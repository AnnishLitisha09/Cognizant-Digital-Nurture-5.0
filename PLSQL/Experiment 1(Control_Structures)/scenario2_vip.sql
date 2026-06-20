BEGIN
    FOR rec IN (
        SELECT CustomerID, Balance FROM Customers
    ) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET Name = Name || ' (VIP)'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP updated');
END;
/