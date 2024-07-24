CREATE TABLE Brand (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL
);

CREATE TABLE Category (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE Product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         brand_id BIGINT NOT NULL,
                         category_id BIGINT NOT NULL,
                         price INT NOT NULL,
                         FOREIGN KEY (brand_id) REFERENCES Brand(id),
                         FOREIGN KEY (category_id) REFERENCES Category(id)
);
