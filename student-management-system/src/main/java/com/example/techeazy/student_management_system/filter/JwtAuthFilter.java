package com.example.techeazy.student_management_system.filter;

import com.example.techeazy.student_management_system.model.Response;
import com.example.techeazy.student_management_system.security.UserDetailsServiceImpl;
import com.example.techeazy.student_management_system.service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    private final Logger log = LoggerFactory.getLogger(JwtAuthFilter.class);

    public JwtAuthFilter(JwtService jwtService, UserDetailsServiceImpl userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String authHeader = request.getHeader("Authorization");
            String token = null;
            String username = null;

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
                username = jwtService.extractUsername(token);
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (jwtService.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else {
                    log.error("JWT Validation Failed. Enter Valid JWT Token");
                }
            }

            filterChain.doFilter(request, response);
        } catch (MalformedJwtException ex) {
            ex.printStackTrace();
            log.error("Invalid JWT token: {}", ex.getMessage());
            handleException(response, "Invalid JWT token", HttpServletResponse.SC_BAD_REQUEST);
        } catch (ExpiredJwtException ex) {
            ex.printStackTrace();
            log.error("Expired JWT token: {}", ex.getMessage());
            handleException(response, "Expired JWT token", HttpServletResponse.SC_BAD_REQUEST);
        } catch (UnsupportedJwtException ex) {
            ex.printStackTrace();
            log.error("Unsupported JWT token: {}", ex.getMessage());
            handleException(response, "Unsupported JWT token", HttpServletResponse.SC_BAD_REQUEST);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            log.error("JWT claims string is empty: {}", ex.getMessage());
            handleException(response, "JWT claims string is empty", HttpServletResponse.SC_BAD_REQUEST);
        }catch(UsernameNotFoundException ex) {
            ex.printStackTrace();
            log.error("Username not found: {}", ex.getMessage());
            handleException(response, "Username not found. Please provide valid credentials or JWT token", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch (JwtException ex) {
            ex.printStackTrace();
            log.error("JWT exception: {}", ex.getMessage());
            handleException(response, "JWT error occurred : " + ex.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("An error occurred: {}", ex.getMessage());
            handleException(response, "An internal server error occurred : "+ ex.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }

    private void handleException(HttpServletResponse response, String message, int status) throws IOException {
        Response customResponse = new Response();
        customResponse.setMessage(message);
        customResponse.setResultCode(status);

        response.setStatus(status);
        response.setContentType("application/json");
        response.getWriter().write(convertObjectToJson(customResponse));
    }

    private String convertObjectToJson(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

