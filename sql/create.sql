CREATE TABLE IF NOT EXISTS post (
                                    id       SERIAL PRIMARY KEY,
                                    title    VARCHAR(120) NOT NULL,
    content  TEXT NOT NULL,
    image    VARCHAR(200)  -- filename or URL (optional)
    );

CREATE UNIQUE INDEX IF NOT EXISTS idx_post_title_unique ON post(title);