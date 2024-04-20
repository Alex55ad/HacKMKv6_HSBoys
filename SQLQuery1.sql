-- Table for employees
CREATE TABLE Employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    role VARCHAR(50)
);

-- Insert random employee data
INSERT INTO Employees (employee_id, name, email, role)
VALUES
    ('11', 'John Smith', 'john@example.com', 'Manager'),
    ('12', 'Jane Doe', 'jane@example.com', 'Software Engineer'),
    ('13', 'Michael Johnson', 'michael@example.com', 'Accountant'),
    ('14', 'Emily Brown', 'emily@example.com', 'Marketing Specialist');

-- Table for user accounts
CREATE TABLE UserAccounts (
    user_id INT PRIMARY KEY,
    username VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    account_type VARCHAR(50) -- normal or company
);

-- Insert random user account data
INSERT INTO UserAccounts (user_id, username, email, password, account_type)
VALUES
    ('212', 'john_doe', 'john@example.com', 'password1', 'normal'),
    ('213', 'jane_smith', 'jane@example.com', 'password2', 'company'),
    ('214', 'mike_johnson', 'mike@example.com', 'password3', 'normal'),
    ('215', 'emily_brown', 'emily@example.com', 'password4', 'company');

-- Table for orders
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    user_id INT,
    order_date DATE,
    total_amount DECIMAL(10, 2),
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES UserAccounts(user_id)
);

-- Insert random order data-----------------------------------------------------------------------------
INSERT INTO Orders (order_id, user_id, order_date, total_amount, status)
VALUES
    ( 1,1,'2024-04-20', 1000, 'Pending'),
    (2,2, '2024-04-21', 2000, 'Shipped'),
    (3,3,'2024-04-22', 2000, 'Delivered'),
    (4,4,'2024-04-23',2000, 'Pending');

-- Table for products
CREATE TABLE Productss (
    product_id INT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    price DECIMAL(10, 2)
);

-- Insert random product data
INSERT INTO Productss (product_id, name, price, description)
VALUES
    (1, 'Ibuprofen 200 mg tablet', 12, 'Anti-inflammatory medication'),
    (2, 'Naproxen 500 mg tablet', 14, 'Anti-inflammatory medication'),
    (3, 'Amoxicillin 500 mg capsule', 80, 'Antibiotic medication'),
    (4, 'Azithromycin 250 mg tablet', 19, 'Antibiotic medication');

-- Table for vehicles
CREATE TABLE Vehicles (
    vehicle_id INT PRIMARY KEY,
    type VARCHAR(100),
    registration_number VARCHAR(50)
);

-- Insert random vehicle data
INSERT INTO Vehicles (vehicle_id, type, registration_number)
VALUES
    (1, 'Sedan', 'ABC123'),
    (2, 'SUV', 'DEF456'),
    (3, 'Truck', 'GHI789'),
    (4, 'Van', 'JKL012');

-- Table for delivery
CREATE TABLE Delivery (
    delivery_id INT PRIMARY KEY,
    order_id INT,
    delivery_date DATE,
    status VARCHAR(50),
    vehicle_id INT,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (vehicle_id) REFERENCES Vehicles(vehicle_id)
);

-- Insert random delivery data
INSERT INTO Delivery (delivery_id, order_id, delivery_date, status, vehicle_id)
VALUES
    (1, 1, '2024-04-21', 'Delivered', 1),
    (2, 2, '2024-04-22', 'Pending', 2),
    (3, 3, '2024-04-23', 'In Transit', 3),
    (4, 4, '2024-04-24', 'Delivered', 4);

-- Table for user reviews
CREATE TABLE ProductReviews (
    review_id INT PRIMARY KEY,
    user_id INT,
    product_id INT,
    rating INT,
    review TEXT,
    review_date DATE, -- Added column for review date
    FOREIGN KEY (user_id) REFERENCES UserAccounts(user_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

-- Insert random user review data
INSERT INTO ProductReviews (review_id, user_id, product_id, rating, review, review_date)
VALUES
    (1, 1, 1, 4, 'Effective pain relief, highly recommended.', '2024-04-20'),
    (2, 2, 2, 5, 'Great for inflammation, worked wonders for me.', '2024-04-21'),
    (3, 3, 3, 3, 'Standard antibiotic, nothing special.', '2024-04-22');

-- Table for registered businesses
CREATE TABLE BusinessRegister (
    business_id INT PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(100),
    phone_number VARCHAR(20)
);

-- Insert random business data
INSERT INTO BusinessRegister (business_id, name, address, phone_number)
VALUES
    (1, 'ABC Corp', '123 Main St', '555-1234'),
    (2, 'XYZ Inc', '456 Elm St', '555-5678'),
    (3, '123 Enterprises', '789 Oak St', '555-9012'),
    (4, '456 Ltd', '101 Pine St', '555-3456');

-- Table for product views
CREATE TABLE ProductViews (
    view_id INT PRIMARY KEY,
    user_id INT,
    product_id INT,
    view_date DATE, -- Changed to DATE type
    FOREIGN KEY (user_id) REFERENCES UserAccounts(user_id),
    FOREIGN KEY (product_id) REFERENCES Productss(product_id)
);

-- Insert random product view register data
INSERT INTO ProductViews (view_id, user_id, product_id, view_date)
VALUES
    (1, 1, 1, '2024-04-20'),
    (2, 2, 2, '2024-04-21'),
    (3, 3, 3, '2024-04-22'),
    (4, 4, 4, '2024-04-23');

-- Display the data from the Delivery table
SELECT * FROM Delivery;

-- Display the data from the Employees table
SELECT * FROM Employees;

-- Display the data from the Orders table
SELECT * FROM Orders;

-- Display the data from the Products table
SELECT * FROM Productss;

-- Display the data from the ProductViews table
SELECT * FROM ProductViews;

-- Display the data from the RegisteredBusinesses table
SELECT * FROM BusinessRegister;

-- Display the data from the UserAccounts table
SELECT * FROM UserAccounts;

-- Display the data from the UserReviews table
SELECT * FROM ProductReviews;

-- Display the data from the Vehicles table
SELECT * FROM Vehicles;
-- Table for order reviews
CREATE TABLE OrderReviews (
    review_id INT PRIMARY KEY,
    order_id INT,
    user_id INT,
    rating INT,
    review TEXT,
    review_date DATE,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (user_id) REFERENCES UserAccounts(user_id)
);
INSERT INTO OrderReviews (review_id, order_id, user_id, rating, review, review_date)
VALUES
    (1, 1, 1, 5, 'Excellent service and fast delivery!', '2024-04-20'),
    (2, 2, 2, 4, 'Good experience overall, but delivery was slightly delayed.', '2024-04-21'),
    (3, 3, 3, 3, 'Average service, product quality could be better.', '2024-04-22');




SELECT * FROM OrderReviews;


