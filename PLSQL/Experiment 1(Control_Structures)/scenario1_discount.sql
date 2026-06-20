BEGIN
    FOR rec IN (
        SELECT c.CustomerID, 
               FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS age,
               l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
    ) LOOP
        IF rec.age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Discount applied');
END;
/