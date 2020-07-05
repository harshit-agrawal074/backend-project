CREATE TABLE IF NOT EXISTS content (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  uuid VARCHAR(50) NOT NULL,
  created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  category VARCHAR(20),
  genre VARCHAR(20),
  duration float,
  name VARCHAR(100),
  description VARCHAR(255),
  languages VARCHAR(255),
  rating float,
  is_deleted CHAR(1) DEFAULT FALSE,
  casting VARCHAR(255),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE INDEX content_uuid ON content (uuid);
