-- Scenario 2: Set VIP for customers with balance > 10000

SET SERVEROUTPUT ON;

BEGIN
   FOR rec IN (SELECT customer_id, balance FROM customers) LOOP
      IF rec.balance > 10000 THEN
         UPDATE customers
         SET IsVIP = 'TRUE'
         WHERE customer_id = rec.customer_id;
         DBMS_OUTPUT.PUT_LINE('VIP set for Customer ID: ' || rec.customer_id);
      END IF;
   END LOOP;
   COMMIT;
END;
/