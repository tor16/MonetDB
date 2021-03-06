CREATE FUNCTION f1(i int) RETURNS TABLE (j int) BEGIN RETURN TABLE(SELECT i); END;
CREATE FUNCTION f2(i int) RETURNS TABLE (j int) BEGIN RETURN TABLE(SELECT i UNION SELECT 2 * i); END;
CREATE FUNCTION f3(i bigint) RETURNS TABLE (j int) BEGIN RETURN TABLE(SELECT i UNION SELECT 2 * i); END;
CREATE FUNCTION f4(i int) RETURNS TABLE (j int) BEGIN RETURN TABLE(SELECT i UNION SELECT i); END;

SELECT * FROM f1(1);
SELECT * FROM f2(3);
SELECT * FROM f3(5);
SELECT * FROM f4(7);

DROP FUNCTION f1;
DROP FUNCTION f2;
DROP FUNCTION f3;
DROP FUNCTION f4;
