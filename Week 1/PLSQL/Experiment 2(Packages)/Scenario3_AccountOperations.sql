CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_accid NUMBER, p_custid NUMBER, p_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_accid NUMBER);
    FUNCTION GetTotalBalance(p_custid NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(p_accid NUMBER, p_custid NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts VALUES (p_accid, p_custid, p_type, p_balance, SYSDATE);
    END;

    PROCEDURE CloseAccount(p_accid NUMBER) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_accid;
    END;

    FUNCTION GetTotalBalance(p_custid NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total
        FROM Accounts
        WHERE CustomerID = p_custid;

        RETURN NVL(v_total, 0);
    END;

END AccountOperations;
/