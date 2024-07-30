CREATE TABLE Brand (
                       brand_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       brand_name VARCHAR(255) NOT NULL
);

CREATE TABLE Category (
                          category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          category_name VARCHAR(255) NOT NULL
);

CREATE TABLE Product (
                         product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         brand_id BIGINT NOT NULL,
                         category_id BIGINT NOT NULL,
                         product_price INT NOT NULL,
                         FOREIGN KEY (brand_id) REFERENCES Brand(brand_id),
                         FOREIGN KEY (category_id) REFERENCES Category(category_id)
);
