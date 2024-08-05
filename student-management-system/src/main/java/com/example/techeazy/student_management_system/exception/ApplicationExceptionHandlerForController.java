//package com.example.techeazy.student_management_system.exception;
//
//
//import com.example.techeazy.student_management_system.model.Response;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class ApplicationExceptionHandlerForController {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ModelAndView handleInvalidArgument(MethodArgumentNotValidException exception) {
//        ModelAndView modelAndView = new ModelAndView();
//        Map<String, String> errorMap = new HashMap<>();
//        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
//            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
//        });
//
//        Response response = new Response();
//        response.setMessage("Validation failed");
//        response.setResultCode(HttpStatus.BAD_REQUEST.value());
//        response.setData(errorMap);
//
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("errorValidation"); // Specify the view name for validation errors
//        return modelAndView;
//    }
//
//    @ExceptionHandler(BadRequestException.class)
//    public ModelAndView handleBadRequestException(BadRequestException exception) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        Response response = new Response();
//        response.setMessage(exception.getMessage());
//        response.setResultCode(HttpStatus.BAD_REQUEST.value());
//
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("errorBadRequest"); // Specify the view name for bad request errors
//        return modelAndView;
//    }
//
//    @ExceptionHandler(ResourceUnavailableException.class)
//    public ModelAndView handleResourceUnavailableException(ResourceUnavailableException exception) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        Response response = new Response();
//        response.setMessage(exception.getMessage());
//        response.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("errorResourceUnavailable"); // Specify the view name for resource unavailable errors
//        return modelAndView;
//    }
//
//    @ExceptionHandler(UsernameAlreadyExistException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ModelAndView handleUsernameAlreadyExistException(UsernameAlreadyExistException exception) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        Response response = new Response();
//        response.setMessage(exception.getMessage());
//        response.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("errorUsernameAlreadyExist"); // Specify the view name for username already exists errors
//        return modelAndView;
//    }
//
//    @ExceptionHandler(LoginException.class)
//    public ModelAndView handleLoginException(LoginException exception) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        Response response = new Response();
//        response.setMessage(exception.getMessage());
//        response.setResultCode(HttpStatus.UNAUTHORIZED.value());
//
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("errorLogin"); // Specify the view name for login errors
//        return modelAndView;
//    }
//
//    @ExceptionHandler(CaughtException.class)
//    public ModelAndView handleCaughtException(CaughtException exception) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        Response response = new Response();
//        response.setMessage(exception.getMessage());
//        response.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("errorCaught"); // Specify the view name for generic caught exceptions
//        return modelAndView;
//    }
//}
