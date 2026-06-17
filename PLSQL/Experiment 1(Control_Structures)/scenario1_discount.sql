-- Scenario 1: Apply 1% discount for customers above 60

SET SERVEROUTPUT ON;

BEGIN
   FOR rec IN (SELECT customer_id, age, interest_rate FROM customers) LOOP
      IF rec.age > 60 THEN
         UPDATE customers
         SET interest_rate = interest_rate - 1
         WHERE customer_id = rec.customer_id;
         DBMS_OUTPUT.PUT_LINE('Discount applied to Customer ID: ' || rec.customer_id);
      END IF;
   END LOOP;
   COMMIT;
END;
/