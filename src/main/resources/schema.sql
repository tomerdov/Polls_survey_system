CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY  AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(255),
    age INT,
    address VARCHAR(255),
    join_date DATE  DEFAULT CURRENT_DATE,
    registered BOOLEAN NOT NULL DEFAULT FALSE
    );

CREATE TABLE IF NOT EXISTS polls (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(500) NOT NULL,
    answer1 VARCHAR(255) NOT NULL,
    answer2 VARCHAR(255) NOT NULL,
    answer3 VARCHAR(255) NOT NULL,
    answer4 VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS poll_answers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    poll_id BIGINT NOT NULL,
    selected_option INT NOT NULL,

    FOREIGN KEY (user_id)
     REFERENCES users(id)
     ON DELETE CASCADE,

    FOREIGN KEY (poll_id)
     REFERENCES polls(id)
     ON DELETE CASCADE,

    UNIQUE(user_id, poll_id),

    CHECK (selected_option BETWEEN 1 AND 4)
    );

