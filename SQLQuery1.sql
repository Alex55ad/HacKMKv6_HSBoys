drop schema HKMKv6;
create schema HKMKv6;
use HKMKv6;

-- Table for employees
CREATE TABLE Employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    role VARCHAR(50)
);

-- Insert random employee data
INSERT INTO Employees ( name, email, role)
VALUES
    ('John Smith', 'john@example.com', 'Manager'),
    ('Jane Doe', 'jane@example.com', 'Software Engineer'),
    ('Michael Johnson', 'michael@example.com', 'Accountant'),
    ('Emily Brown', 'emily@example.com', 'Marketing Specialist');

-- Table for user accounts
CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    account_type VARCHAR(50)                     -- normal or company
);

-- Insert random user account data
INSERT INTO Users (username, email, password, account_type)
VALUES
    ('john_doe', 'john@example.com', 'password1', 'normal'),
    ('jane_smith', 'jane@example.com', 'password2', 'company'),
    ('mike_johnson', 'mike@example.com', 'password3', 'normal'),
    ('emily_brown', 'emily@example.com', 'password4', 'company');

-- Table for orders
CREATE TABLE Orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    order_date DATETIME DEFAULT NOW(),
    total_amount DECIMAL(10, 2),
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

-- Insert random order data-----------------------------------------------------------------------------
INSERT INTO Orders (user_id, order_date, total_amount, status)
VALUES
    (1,'2024-04-20', 1000, 'Pending'),
    (2, '2024-04-21', 2000, 'Shipped'),
    (3,'2024-04-22', 2000, 'Delivered'),
    (4,'2024-04-23',2000, 'Pending');

-- Table for products
CREATE TABLE Products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    price DECIMAL(10, 2),
    stock INT DEFAULT 0,
    score DECIMAL(10,2) DEFAULT 0.00
);

-- Insert random product data
INSERT INTO Products (name, price, description, stock)
VALUES
    ('Ibuprofen 200 mg tablet', 12, 'Anti-inflammatory medication', 500),
    ('Naproxen 500 mg tablet', 14, 'Anti-inflammatory medication', 350),
    ('Amoxicillin 500 mg capsule', 80, 'Antibiotic medication', 200),
    ('Azithromycin 250 mg tablet', 19, 'Antibiotic medication', 150),
    ('Paracetamol 500 mg tablet', 10.50, 'Analgesic and antipyretic medication', 600),
    ('Omeprazole 20 mg capsule', 25.75, 'Proton-pump inhibitor medication', 400),
    ('Loratadine 10 mg tablet', 17.25, 'Antihistamine medication', 300),
    ('Metformin 500 mg tablet', 9.80, 'Anti-diabetic medication', 550),
    ('Simvastatin 20 mg tablet', 35.20, 'Statins medication', 250),
    ('Losartan 50 mg tablet', 22.60, 'Antihypertensive medication', 400),
    ('Salbutamol inhaler 100 mcg', 28.90, 'Bronchodilator medication', 200),
    ('Fluoxetine 20 mg capsule', 18.40, 'Antidepressant medication', 350),
    ('Diazepam 5 mg tablet', 15.70, 'Anxiolytic medication', 300),
    ('Cetirizine 10 mg tablet', 12.80, 'Antihistamine medication', 450),
    ('Metronidazole 500 mg tablet', 23.60, 'Antibiotic medication', 150),
    ('Atorvastatin 40 mg tablet', 40.50, 'Statins medication', 200),
    ('Furosemide 40 mg tablet', 11.90, 'Diuretic medication', 500),
    ('Lisinopril 10 mg tablet', 19.20, 'Antihypertensive medication', 350),
    ('Warfarin 5 mg tablet', 16.80, 'Anticoagulant medication', 400);

-- Table for vehicles
CREATE TABLE Vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(100),
    last_maintenance DATETIME DEFAULT  NOW(),
    registration_number VARCHAR(50)
);

-- Insert random vehicle data
INSERT INTO Vehicles (type, registration_number)
VALUES
    ('Sedan', 'ABC123'),
    ('SUV', 'DEF456'),
    ('Truck', 'GHI789'),
    ('Van', 'JKL012');

-- Table for delivery
CREATE TABLE Delivery (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    delivery_date DATETIME,
    status VARCHAR(50),
    vehicle_id INT,
    FOREIGN KEY (order_id) REFERENCES Orders(id),
    FOREIGN KEY (vehicle_id) REFERENCES Vehicles(id)
);

-- Insert random delivery data
INSERT INTO Delivery (order_id, delivery_date, status, vehicle_id)
VALUES
    (1, '2024-04-21', 'Delivered', 1),
    (2, '2024-04-22', 'Pending', 2),
    (3, '2024-04-23', 'In Transit', 3),
    (4, '2024-04-24', 'Delivered', 4);

-- Table for user reviews
CREATE TABLE Product_Reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    product_id INT,
    rating INT,
    review TEXT,
    review_date DATETIME DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (product_id) REFERENCES Products(id)
);

-- Insert random user review data
INSERT INTO Product_Reviews (user_id, product_id, rating, review, review_date)
VALUES
    (1, 1, 4, 'Effective pain relief, highly recommended.', '2024-04-20'),
    (2, 2, 5, 'Great for inflammation, worked wonders for me.', '2024-04-21'),
    (3, 3, 3, 'Standard antibiotic, nothing special.', '2024-04-22');

-- Table for registered businesses
CREATE TABLE Business_Register (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(100),
    phone_number VARCHAR(20),
    registration_password varchar(20)
);

-- Insert random business data
INSERT INTO Business_Register (name, address, phone_number, registration_password)
VALUES
    ('ABC Corp', '123 Main St', '555-1234', 'aBcDeFgH'),
    ('XYZ Inc', '456 Elm St', '555-5678', 'zYxWvUt'),
    ('123 Enterprises', '789 Oak St', '555-9012', '1E2n3P4r'),
    ('456 Ltd', '101 Pine St', '555-3456', '6d5L4tD6');

-- Table for order reviews
CREATE TABLE Order_Reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    user_id INT,
    rating INT,
    review TEXT,
    review_date DATETIME DEFAULT NOW(),
    FOREIGN KEY (order_id) REFERENCES Orders(id),
    FOREIGN KEY (user_id) REFERENCES Users(id)
);
INSERT INTO Order_Reviews (order_id, user_id, rating, review, review_date)
VALUES
    (1, 1, 5, 'Excellent service and fast delivery!', '2024-04-20'),
    (2, 2, 4, 'Good experience overall, but delivery was slightly delayed.', '2024-04-21'),
    (3, 3, 3, 'Average service, product quality could be better.', '2024-04-22');

CREATE TABLE `order_product` (
    `id` INT NOT NULL AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    `quantity` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_order_product_order` FOREIGN KEY (order_id) REFERENCES `orders` (id) ON DELETE CASCADE,
    CONSTRAINT `fk_order_product_product` FOREIGN KEY (product_id) REFERENCES `products` (id) ON DELETE CASCADE
);

INSERT INTO order_product (order_id, product_id, quantity)
VALUES
    (1, 1, 2), -- Ibuprofen 200 mg tablet
    (1, 3, 1), -- Amoxicillin 500 mg capsule
    (1, 6, 3), -- Losartan 50 mg tablet
    (1, 9, 1); -- Diazepam 5 mg tablet

-- For order with ID 2
INSERT INTO order_product (order_id, product_id, quantity)
VALUES
    (2, 2, 3), -- Naproxen 500 mg tablet
    (2, 4, 2), -- Azithromycin 250 mg tablet
    (2, 7, 1), -- Salbutamol inhaler 100 mcg
    (2, 10, 2); -- Cetirizine 10 mg tablet

-- For order with ID 3
INSERT INTO order_product (order_id, product_id, quantity)
VALUES
    (3, 5, 4), -- Simvastatin 20 mg tablet
    (3, 8, 2), -- Fluoxetine 20 mg capsule
    (3, 11, 3), -- Metronidazole 500 mg tablet
    (3, 13, 1); -- Furosemide 40 mg tablet

-- For order with ID 4
INSERT INTO order_product (order_id, product_id, quantity)
VALUES
    (4, 1, 1), -- Ibuprofen 200 mg tablet
    (4, 3, 2), -- Amoxicillin 500 mg capsule
    (4, 6, 2), -- Losartan 50 mg tablet
    (4, 12, 1); -- Atorvastatin 40 mg tablet
