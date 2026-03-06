CREATE TABLE IF NOT EXISTS post (
    id       SERIAL PRIMARY KEY,
    title    VARCHAR(120) NOT NULL,
    content  TEXT NOT NULL,
    image    VARCHAR(200)  -- filename or URL (optional)
    );

CREATE UNIQUE INDEX IF NOT EXISTS idx_post_title_unique ON post(title);

create table IF NOT EXISTS user
(
    user_id  serial  primary key,
    username varchar(50) not null,
    password varchar(50) not null
);
CREATE UNIQUE INDEX IF NOT EXISTS idx_user_name ON user(username);