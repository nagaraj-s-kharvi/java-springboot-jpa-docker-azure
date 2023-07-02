Check health of the app
http://localhost:8080/actuator/health
Swagger
http://localhost:8080/swagger-ui/index.html

Database
DROP TABLE users;

CREATE TABLE users (
  user_id SERIAL PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  dob DATE NOT NULL,
  created_by BIGINT NOT NULL,
  created_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_by BIGINT NOT NULL,
  updated_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO public.users
(user_id, username, "password", email, dob, created_by, created_ts, updated_by, updated_ts)
VALUES(1, 'kharvinagaraj1', '123', 'kharvinagaraj1@gmail.com', '1996-06-03', 1, '2023-06-25 15:36:38.201', 1, '2023-06-25 15:36:38.201');

SELECT * FROM users;