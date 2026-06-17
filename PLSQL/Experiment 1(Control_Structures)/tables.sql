CREATE TABLE customers (
   customer_id NUMBER,
   age NUMBER,
   balance NUMBER,
   interest_rate NUMBER,
   IsVIP VARCHAR2(10)
);

CREATE TABLE loans (
   customer_id NUMBER,
   loan_due_date DATE
);