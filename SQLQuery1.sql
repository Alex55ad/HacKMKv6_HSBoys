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
CREATE TABLE UserAccounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    account_type VARCHAR(50)                     -- normal or company
);

-- Insert random user account data
INSERT INTO UserAccounts (username, email, password, account_type)
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
    FOREIGN KEY (user_id) REFERENCES UserAccounts(id)
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
    stock INT DEFAULT 0
);

-- Insert random product data
INSERT INTO Products (name, price, description)
VALUES
    ('Ibuprofen 200 mg tablet', 12, 'Anti-inflammatory medication'),
    ('Naproxen 500 mg tablet', 14, 'Anti-inflammatory medication'),
    ('Amoxicillin 500 mg capsule', 80, 'Antibiotic medication'),
    ('Azithromycin 250 mg tablet', 19, 'Antibiotic medication');

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
CREATE TABLE ProductReviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    product_id INT,
    rating INT,
    review TEXT,
    review_date DATETIME DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES UserAccounts(id),
    FOREIGN KEY (product_id) REFERENCES Products(id)
);

-- Insert random user review data
INSERT INTO ProductReviews (user_id, product_id, rating, review, review_date)
VALUES
    (1, 1, 4, 'Effective pain relief, highly recommended.', '2024-04-20'),
    (2, 2, 5, 'Great for inflammation, worked wonders for me.', '2024-04-21'),
    (3, 3, 3, 'Standard antibiotic, nothing special.', '2024-04-22');

-- Table for registered businesses
CREATE TABLE BusinessRegister (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(100),
    phone_number VARCHAR(20),
    registration_password varchar(20)
);

-- Insert random business data
INSERT INTO BusinessRegister (name, address, phone_number, registration_password)
VALUES
    ('ABC Corp', '123 Main St', '555-1234', 'aBcDeFgH'),
    ('XYZ Inc', '456 Elm St', '555-5678', 'zYxWvUt'),
    ('123 Enterprises', '789 Oak St', '555-9012', '1E2n3P4r'),
    ('456 Ltd', '101 Pine St', '555-3456', '6d5L4tD6');

-- Table for order reviews
CREATE TABLE OrderReviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    user_id INT,
    rating INT,
    review TEXT,
    review_date DATETIME DEFAULT NOW(),
    FOREIGN KEY (order_id) REFERENCES Orders(id),
    FOREIGN KEY (user_id) REFERENCES UserAccounts(id)
);
INSERT INTO OrderReviews (order_id, user_id, rating, review, review_date)
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
