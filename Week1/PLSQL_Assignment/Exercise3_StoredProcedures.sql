CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN

```
-- Add 1% interest to all savings accounts
UPDATE Accounts
SET Balance = Balance + (Balance * 0.01)
WHERE AccountType = 'Savings';

COMMIT;

DBMS_OUTPUT.PUT_LINE('Monthly Interest Applied');
///

EXCEPTION
WHEN OTHERS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('Error : ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
p_department VARCHAR2,
p_bonus NUMBER
)
IS
BEGIN

```
-- Update salary of employees in given department
UPDATE Employees
SET Salary = Salary + (Salary * p_bonus / 100)
WHERE Department = p_department;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Bonus Updated');
```

EXCEPTION
WHEN OTHERS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('Error : ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds(
p_from_acc NUMBER,
p_to_acc NUMBER,
p_amount NUMBER
)
IS
v_bal NUMBER;
BEGIN

```
-- Get balance of source account
SELECT Balance
INTO v_bal
FROM Accounts
WHERE AccountID = p_from_acc;

-- Check sufficient balance
IF v_bal < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001,'Insufficient Balance');
END IF;

-- Deduct amount from source account
UPDATE Accounts
SET Balance = Balance - p_amount
WHERE AccountID = p_from_acc;

-- Add amount to destination account
UPDATE Accounts
SET Balance = Balance + p_amount
WHERE AccountID = p_to_acc;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Fund Transfer Successful');
```

EXCEPTION

```
WHEN NO_DATA_FOUND THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Account Not Found');

WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error : ' || SQLERRM);
```

END;
/

-- Test Procedure 1
BEGIN
ProcessMonthlyInterest;
END;
/

-- Test Procedure 2
BEGIN
UpdateEmployeeBonus('IT',10);
END;
/

-- Test Procedure 3
BEGIN
TransferFunds(1,2,200);
END;
/
