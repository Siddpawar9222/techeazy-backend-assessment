INSERT INTO role_table  (role_id, role_name) VALUES
    (1,0) ,
    (2,1) ;

INSERT INTO user_table  (user_username, user_password) VALUES
('siddhesh@gmail.com','$2a$10$m3so4CKtcH1EyBCQjjIuAukB6PRCZkJV4hm4.aczg0M1ZwxmdOYIG');

INSERT INTO user_roles (user_id, role_id) VALUES
(1,1) ,
(1,2);
