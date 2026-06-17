-- Scenario 3: Loan reminders within next 30 days

SET SERVEROUTPUT ON;

BEGIN
   FOR rec IN (
      SELECT customer_id, loan_due_date
      FROM loans
      WHERE loan_due_date BETWEEN SYSDATE AND SYSDATE + 30
   ) LOOP

      DBMS_OUTPUT.PUT_LINE(
         'Reminder: Customer ID ' || rec.customer_id || ' has a loan due on ' || rec.loan_due_date
      );

   END LOOP;

END;
/