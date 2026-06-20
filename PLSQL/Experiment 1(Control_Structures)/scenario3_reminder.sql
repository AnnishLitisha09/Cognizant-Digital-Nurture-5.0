SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT c.Name, l.EndDate
        FROM Customers c
        JOIN Loans l
            ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: ' || rec.Name ||
            ' loan due on ' ||
            TO_CHAR(rec.EndDate, 'YYYY-MM-DD')
        );
    END LOOP;
END;
/