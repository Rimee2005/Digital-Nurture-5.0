CREATE OR REPLACE PROCEDURE SafeTransferFunds(
p_from_acc NUMBER,
p_to_acc NUMBER,
p_amount NUMBER
)
IS
v_bal NUMBER;
BEGIN

```
-- Check balance of source account
SELECT Balance
INTO v_bal
FROM Accounts
WHERE AccountID = p_from_acc;

-- Check if enough balance is available
IF v_bal < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001,'Insufficient Funds');
END IF;

-- Deduct amount from sender account
UPDATE Accounts
SET Balance = Balance - p_amount
WHERE AccountID = p_from_acc;

-- Add amount to receiver account
UPDATE Accounts
SET Balance = Balance + p_amount
WHERE AccountID = p_to_acc;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Transfer Successful');
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

CREATE OR REPLACE PROCEDURE UpdateSalary(
p_empid NUMBER,
p_percent NUMBER
)
IS
v_count NUMBER;
BEGIN

```
-- Check employee exists or not
SELECT COUNT(*)
INTO v_count
FROM Employees
WHERE EmployeeID = p_empid;

IF v_count = 0 THEN
    RAISE_APPLICATION_ERROR(-20002,'Employee Not Found');
END IF;

-- Increase salary by given percentage
UPDATE Employees
SET Salary = Salary + (Salary * p_percent / 100)
WHERE EmployeeID = p_empid;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Salary Updated');
```

EXCEPTION

```
WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error : ' || SQLERRM);
```

END;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer(
p_id NUMBER,
p_name VARCHAR2,
p_dob DATE,
p_balance NUMBER
)
IS
BEGIN

```
-- Insert new customer record
INSERT INTO Customers(
    CustomerID,
    Name,
    DOB,
    Balance,
    LastModified
)
VALUES(
    p_id,
    p_name,
    p_dob,
    p_balance,
    SYSDATE
);

COMMIT;

DBMS_OUTPUT.PUT_LINE('Customer Added Successfully');
```

EXCEPTION

```
-- Duplicate customer id
WHEN DUP_VAL_ON_INDEX THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Customer ID Already Exists');

WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error : ' || SQLERRM);
```

END;
/

-- Test procedure 1
BEGIN
SafeTransferFunds(1,2,100);
END;
/

-- Test procedure 2
BEGIN
UpdateSalary(1,10);
END;
/

-- Test procedure 3
BEGIN
AddNewCustomer(
3,
'Rahul Kumar',
TO_DATE('2000-01-10','YYYY-MM-DD'),
5000
);
END;
/
