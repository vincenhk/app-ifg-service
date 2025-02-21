/*
    DML NEEDED FOR app-ifg-service
*/

-- Insert dummy data into mst_users
INSERT INTO mst_users (email, first_name, last_name, phone)
VALUES
    ('john.doe@example.com', 'John', 'Doe', '+6281234567890'),
    ('jane.smith@example.com', 'Jane', 'Smith', '+6289876543210');

-- Insert dummy data into mst_balance
INSERT INTO mst_balance (  balance_amount, last_updated, user_id, currency)
VALUES
    ( 1000000.50, NOW(), 1, 'IDR'),
    (25000000.75, NOW(), 2, 'USD');