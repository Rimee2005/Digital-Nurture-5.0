DECLARE

```
CURSOR GenerateMonthlyStatements IS
    SELECT c.Name,
           t.TransactionID,
           t.Amount,
           t.TransactionType,
           t.TransactionDate
    FROM Customers c
    JOIN Accounts a
    ON c.CustomerID = a.CustomerID
    JOIN Transactions t
    ON a.AccountID = t.AccountID
    WHERE EXTRACT(MONTH FROM t.TransactionDate) =
          EXTRACT(MONTH FROM SYSDATE)
    AND EXTRACT(YEAR FROM t.TransactionDate) =
        EXTRACT(YEAR FROM SYSDATE);

v_name Customers.Name%TYPE;
v_tid Transactions.TransactionID%TYPE;
v_amt Transactions.Amount%TYPE;
v_type Transactions.TransactionType%TYPE;
v_date Transactions.TransactionDate%TYPE;
```

BEGIN

```
OPEN GenerateMonthlyStatements;

LOOP

    FETCH GenerateMonthlyStatements
    INTO v_name,v_tid,v_amt,v_type,v_date;

    EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE(
        v_name || ' | ' ||
        v_tid || ' | ' ||
        v_type || ' | ' ||
        v_amt
    );

END LOOP;

CLOSE GenerateMonthlyStatements;
```

END;
/

DECLARE

```
CURSOR ApplyAnnualFee IS
    SELECT AccountID
    FROM Accounts;
```

BEGIN

```
FOR acc IN ApplyAnnualFee
LOOP

    -- Deduct annual maintenance fee
    UPDATE Accounts
    SET Balance = Balance - 100
    WHERE AccountID = acc.AccountID;

END LOOP;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Annual Fee Applied');
```

END;
/

DECLARE

```
CURSOR UpdateLoanInterestRates IS
    SELECT LoanID,InterestRate
    FROM Loans;
```

BEGIN

```
FOR loan IN UpdateLoanInterestRates
LOOP

    -- Increase rate by 0.5%
    UPDATE Loans
    SET InterestRate = loan.InterestRate + 0.5
    WHERE LoanID = loan.LoanID;

END LOOP;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Loan Interest Rates Updated');
```

END;
/
