-- Brand Table INSERT
INSERT INTO Brand (brand_id, brand_name) VALUES (1, 'A');
INSERT INTO Brand (brand_id, brand_name) VALUES (2, 'B');
INSERT INTO Brand (brand_id, brand_name) VALUES (3, 'C');
INSERT INTO Brand (brand_id, brand_name) VALUES (4, 'D');
INSERT INTO Brand (brand_id, brand_name) VALUES (5, 'E');
INSERT INTO Brand (brand_id, brand_name) VALUES (6, 'F');
INSERT INTO Brand (brand_id, brand_name) VALUES (7, 'G');
INSERT INTO Brand (brand_id, brand_name) VALUES (8, 'H');
INSERT INTO Brand (brand_id, brand_name) VALUES (9, 'I');

-- Category Table INSERT
INSERT INTO Category (category_id, category_name) VALUES (1, '상의');
INSERT INTO Category (category_id, category_name) VALUES (2, '아우터');
INSERT INTO Category (category_id, category_name) VALUES (3, '바지');
INSERT INTO Category (category_id, category_name) VALUES (4, '스니커즈');
INSERT INTO Category (category_id, category_name) VALUES (5, '가방');
INSERT INTO Category (category_id, category_name) VALUES (6, '모자');
INSERT INTO Category (category_id, category_name) VALUES (7, '양말');
INSERT INTO Category (category_id, category_name) VALUES (8, '액세서리');

-- Product Table INSERT
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (1, 1, 1, 11200); -- A, 상의
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (2, 1, 2, 5500);  -- A, 아우터
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (3, 1, 3, 4200);  -- A, 바지
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (4, 1, 4, 9000);  -- A, 스니커즈
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (5, 1, 5, 2000);  -- A, 가방
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (6, 1, 6, 1700);  -- A, 모자
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (7, 1, 7, 1800);  -- A, 양말
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (8, 1, 8, 2300);  -- A, 액세서리

INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (9, 2, 1, 10500); -- B, 상의
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (10, 2, 2, 5900); -- B, 아우터
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (11, 2, 3, 3800); -- B, 바지
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (12, 2, 4, 9100); -- B, 스니커즈
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (13, 2, 5, 2100); -- B, 가방
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (14, 2, 6, 2000); -- B, 모자
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (15, 2, 7, 2000); -- B, 양말
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (16, 2, 8, 2200); -- B, 액세서리

INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (17, 3, 1, 10000); -- C, 상의
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (18, 3, 2, 6200);  -- C, 아우터
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (19, 3, 3, 3300);  -- C, 바지
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (20, 3, 4, 9200);  -- C, 스니커즈
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (21, 3, 5, 2200);  -- C, 가방
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (22, 3, 6, 1900);  -- C, 모자
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (23, 3, 7, 2200);  -- C, 양말
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (24, 3, 8, 2100);  -- C, 액세서리

INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (25, 4, 1, 10100); -- D, 상의
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (26, 4, 2, 5100);  -- D, 아우터
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (27, 4, 3, 3000);  -- D, 바지
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (28, 4, 4, 9500);  -- D, 스니커즈
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (29, 4, 5, 2500);  -- D, 가방
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (30, 4, 6, 1500);  -- D, 모자
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (31, 4, 7, 2400);  -- D, 양말
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (32, 4, 8, 2000);  -- D, 액세서리

INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (33, 5, 1, 10700); -- E, 상의
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (34, 5, 2, 5000);  -- E, 아우터
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (35, 5, 3, 3800);  -- E, 바지
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (36, 5, 4, 9900);  -- E, 스니커즈
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (37, 5, 5, 2300);  -- E, 가방
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (38, 5, 6, 1800);  -- E, 모자
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (39, 5, 7, 2100);  -- E, 양말
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (40, 5, 8, 2100);  -- E, 액세서리

INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (41, 6, 1, 11200); -- F, 상의
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (42, 6, 2, 7200);  -- F, 아우터
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (43, 6, 3, 4000);  -- F, 바지
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (44, 6, 4, 9300);  -- F, 스니커즈
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (45, 6, 5, 2100);  -- F, 가방
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (46, 6, 6, 1600);  -- F, 모자
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (47, 6, 7, 2300);  -- F, 양말
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (48, 6, 8, 1900);  -- F, 액세서리

INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (49, 7, 1, 10500); -- G, 상의
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (50, 7, 2, 5800);  -- G, 아우터
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (51, 7, 3, 3900);  -- G, 바지
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (52, 7, 4, 9000);  -- G, 스니커즈
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (53, 7, 5, 2200);  -- G, 가방
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (54, 7, 6, 1700);  -- G, 모자
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (55, 7, 7, 2100);  -- G, 양말
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (56, 7, 8, 2000);  -- G, 액세서리

INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (57, 8, 1, 10800); -- H, 상의
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (58, 8, 2, 6300);  -- H, 아우터
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (59, 8, 3, 3100);  -- H, 바지
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (60, 8, 4, 9700);  -- H, 스니커즈
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (61, 8, 5, 2100);  -- H, 가방
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (62, 8, 6, 1600);  -- H, 모자
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (63, 8, 7, 2000);  -- H, 양말
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (64, 8, 8, 2000);  -- H, 액세서리

INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (65, 9, 1, 11400); -- I, 상의
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (66, 9, 2, 6700);  -- I, 아우터
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (67, 9, 3, 3200);  -- I, 바지
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (68, 9, 4, 9500);  -- I, 스니커즈
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (69, 9, 5, 2400);  -- I, 가방
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (70, 9, 6, 1700);  -- I, 모자
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (71, 9, 7, 1700);  -- I, 양말
INSERT INTO product (product_id, brand_id, category_id, product_price) VALUES (72, 9, 8, 2400);  -- I, 액세서리

