CREATE OR REPLACE FUNCTION CalculateAge(
p_dob DATE
)
RETURN NUMBER
IS
v_age NUMBER;
BEGIN

```
-- Calculate age from date of birth
v_age := FLOOR(MONTHS_BETWEEN(SYSDATE,p_dob)/12);

RETURN v_age;
```

END;
/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
p_loan_amount NUMBER,
p_interest_rate NUMBER,
p_years NUMBER
)
RETURN NUMBER
IS
v_monthly NUMBER;
BEGIN

```
-- Simple monthly installment calculation
v_monthly :=
(p_loan_amount +
(p_loan_amount * p_interest_rate * p_years / 100))
/ (p_years * 12);

RETURN ROUND(v_monthly,2);
```

END;
/

CREATE OR REPLACE FUNCTION HasSufficientBalance(
p_accountid NUMBER,
p_amount NUMBER
)
RETURN NUMBER
IS
v_bal NUMBER;
BEGIN

```
-- Get account balance
SELECT Balance
INTO v_bal
FROM Accounts
WHERE AccountID = p_accountid;

-- Check balance
IF v_bal >= p_amount THEN
    RETURN 1;
ELSE
    RETURN 0;
END IF;
```

EXCEPTION

```
WHEN NO_DATA_FOUND THEN
    RETURN 0;
```

END;
/

-- Test Function 1
SELECT CalculateAge(
TO_DATE('2000-01-10','YYYY-MM-DD')
) AS Age
FROM Dual;
/

-- Test Function 2
SELECT CalculateMonthlyInstallment(
500000,
8,
5
) AS EMI
FROM Dual;
/

-- Test Function 3
SELECT HasSufficientBalance(
1,
500
) AS Result
FROM Dual;
/
