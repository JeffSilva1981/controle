INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('Renan', '1598875-1551', 'http://image.perfil.clienterenan', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');
INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('Mariana', '1198765-4321', 'http://image.perfil.clientemariana', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');
INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('Carlos', '1199123-4567', 'http://image.perfil.clientecarlos', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');
INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('Fernanda', '2198877-1122', 'http://image.perfil.clientefernanda', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');
INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('João', '2199000-3344', 'http://image.perfil.clientejoao', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');
INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('Patrícia', '3199888-5566', 'http://image.perfil.clientepatricia', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');
INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('André', '4199777-7788', 'http://image.perfil.clienteandre', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');
INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('Beatriz', '5199666-8899', 'http://image.perfil.clientebeatriz', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');
INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('Rafael', '6199555-6677', 'http://image.perfil.clienterafael', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');
INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('Juliana', '7199444-2233', 'http://image.perfil.clientejuliana', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');
INSERT INTO tb_customers (name, cell_phone, image, password) VALUES ('Renan', '1598875-1531', 'Http://image.perfil.clienterenan', '$2a$10$bbMvN97ZieEq8.DclJMTh.Ykhp0QjszYL1JIG5MLrnes5yDZe0dyW');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_customers_role (customer_id, role_id) VALUES (1, 2);
INSERT INTO tb_customers_role (customer_id, role_id) VALUES (2, 1);
INSERT INTO tb_customers_role (customer_id, role_id) VALUES (2, 2);


INSERT INTO tb_orders (order_date, status, total_value, proof_of_payment, customer_id) VALUES ('2025-09-16 14:30:00', 'PAID', 250.75, 'http://image.proof/payment123.png', 1);
INSERT INTO tb_orders (order_date, status, total_value, proof_of_payment, customer_id) VALUES ('2025-09-17 10:15:00', 'WAITING_PAYMENT', 150.50, 'http://image.proof/payment124.png', 2);
INSERT INTO tb_orders (order_date, status, total_value, proof_of_payment, customer_id) VALUES ('2025-09-18 11:45:00', 'PAID', 300.00, 'http://image.proof/payment125.png', 3);
INSERT INTO tb_orders (order_date, status, total_value, proof_of_payment, customer_id) VALUES ('2025-09-19 09:30:00', 'CANCELED', 75.25, 'http://image.proof/payment126.png', 4);
INSERT INTO tb_orders (order_date, status, total_value, proof_of_payment, customer_id) VALUES ('2025-09-20 14:00:00', 'PAID', 420.00, 'http://image.proof/payment127.png', 5);
INSERT INTO tb_orders (order_date, status, total_value, proof_of_payment, customer_id) VALUES ('2025-09-21 16:20:00', 'WAITING_PAYMENT', 180.75, 'http://image.proof/payment128.png', 6);
INSERT INTO tb_orders (order_date, status, total_value, proof_of_payment, customer_id) VALUES ('2025-09-22 13:10:00', 'PAID', 500.00, 'http://image.proof/payment129.png', 7);
INSERT INTO tb_orders (order_date, status, total_value, proof_of_payment, customer_id) VALUES ('2025-09-23 15:50:00', 'CANCELED', 220.40, 'http://image.proof/payment130.png', 8);
INSERT INTO tb_orders (order_date, status, total_value, proof_of_payment, customer_id) VALUES ('2025-09-24 12:35:00', 'PAID', 350.60, 'http://image.proof/payment131.png', 9);
INSERT INTO tb_orders (order_date, status, total_value, proof_of_payment, customer_id) VALUES ('2025-09-25 10:05:00', 'WAITING_PAYMENT', 275.80, 'http://image.proof/payment132.png', 10);


INSERT INTO tb_products (name, price, stock, description, image, limit_per_customer) VALUES ('Notebook Gamer', 3500.00, 15, 'Notebook com RTX 3060 e 16GB RAM', 'http://image.products/notebook.png', 1);
INSERT INTO tb_products (name, price, stock, description, image, limit_per_customer) VALUES ('Smartphone Galaxy', 2200.50, 30, 'Samsung Galaxy com 128GB', 'http://image.products/smartphone.png', 2);
INSERT INTO tb_products (name, price, stock, description, image, limit_per_customer) VALUES ('Smartphone Galaxy S22', 2800.00, 30, 'Smartphone Samsung com 128GB e câmera tripla', 'http://image.products/galaxy_s22.png', 2);
INSERT INTO tb_products (name, price, stock, description, image, limit_per_customer) VALUES ('Headset Gamer HyperX', 450.00, 50, 'Headset com som surround 7.1 e microfone removível', 'http://image.products/hyperx.png', 3);
INSERT INTO tb_products (name, price, stock, description, image, limit_per_customer) VALUES ('Teclado Mecânico Redragon', 320.00, 40, 'Teclado mecânico RGB switch blue', 'http://image.products/redragon.png', 2);
INSERT INTO tb_products (name, price, stock, description, image, limit_per_customer) VALUES ('Monitor LG UltraWide 29"', 1200.00, 20, 'Monitor ultrawide Full HD IPS', 'http://image.products/lg_ultrawide.png', 1);
INSERT INTO tb_products (name, price, stock, description, image, limit_per_customer) VALUES ('Mouse Gamer Logitech G502', 380.00, 35, 'Mouse gamer com 11 botões programáveis e RGB', 'http://image.products/logitech_g502.png', 3);
INSERT INTO tb_products (name, price, stock, description, image, limit_per_customer) VALUES ('Cadeira Gamer DXRacer', 1450.00, 10, 'Cadeira ergonômica gamer com ajuste reclinável', 'http://image.products/dxracer.png', 1);
INSERT INTO tb_products (name, price, stock, description, image, limit_per_customer) VALUES ('Placa de Vídeo RTX 4070', 4200.00, 5, 'Placa de vídeo NVIDIA RTX 4070 com 12GB GDDR6X', 'http://image.products/rtx4070.png', 1);
INSERT INTO tb_products (name, price, stock, description, image, limit_per_customer) VALUES ('SSD NVMe 1TB Kingston', 550.00, 25, 'SSD NVMe PCIe 4.0 de 1TB com leitura até 3500MB/s', 'http://image.products/ssd_1tb.png', 4);

INSERT INTO tb_order_items (quantity, unitary_price, product_id, order_id) VALUES (1, 150.75, 2, 1);
INSERT INTO tb_order_items (quantity, unitary_price, product_id, order_id) VALUES (2, 50.00, 1, 1);
INSERT INTO tb_order_items (quantity, unitary_price, product_id, order_id) VALUES (2, 2800.00, 2, 1);
INSERT INTO tb_order_items (quantity, unitary_price, product_id, order_id) VALUES (1, 450.00, 3, 2);
INSERT INTO tb_order_items (quantity, unitary_price, product_id, order_id) VALUES (3, 320.00, 4, 2);
INSERT INTO tb_order_items (quantity, unitary_price, product_id, order_id) VALUES (1, 1200.00, 5, 3);
INSERT INTO tb_order_items (quantity, unitary_price, product_id, order_id) VALUES (2, 380.00, 6, 3);
INSERT INTO tb_order_items (quantity, unitary_price, product_id, order_id) VALUES (1, 1450.00, 7, 4);
INSERT INTO tb_order_items (quantity, unitary_price, product_id, order_id) VALUES (1, 4200.00, 8, 4);
INSERT INTO tb_order_items (quantity, unitary_price, product_id, order_id) VALUES (2, 550.00, 9, 5);
