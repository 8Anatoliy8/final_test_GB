USE my_first;
CREATE TABLE Pets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(20) NOT NULL,
    birth_date DATE NOT NULL,
    commands VARCHAR(255)
);

CREATE TABLE PackAnimals (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(20) NOT NULL,
    birth_date DATE NOT NULL,
    commands VARCHAR(255)
);

-- Данные для Pets
INSERT INTO Pets (name, type, birth_date, commands)
VALUES 
    ('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
    ('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
    ('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
    ('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
    ('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
    ('Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
    ('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
    ('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');

-- Данные для PackAnimals
INSERT INTO PackAnimals (name, type, birth_date, commands)
VALUES 
    ('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
    ('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
    ('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
    ('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
    ('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
    ('Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
    ('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
    ('Sahara', 'Camel', '2015-08-14', 'Walk, Run');
  
SET SQL_SAFE_UPDATES = 0;

DELETE FROM PackAnimals WHERE type = 'Camel';
SET SQL_SAFE_UPDATES = 1;

CREATE TABLE HorsesAndDonkeys AS
SELECT * FROM PackAnimals WHERE type IN ('Horse', 'Donkey');

CREATE TABLE AnimalsAged1To3 AS
SELECT 
    id,
    name,
    type,
    birth_date,
    commands,
    TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_in_months
FROM 
    Pets
WHERE 
    TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3

UNION

SELECT 
    id,
    name,
    type,
    birth_date,
    commands,
    TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_in_months
FROM 
    PackAnimals
WHERE 
    TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3;


CREATE TABLE AllAnimals AS
SELECT 'Pets' AS origin, id, name, type, birth_date, commands FROM Pets
UNION ALL
SELECT 'PackAnimals' AS origin, id, name, type, birth_date, commands FROM PackAnimals
UNION ALL
SELECT 'HorsesAndDonkeys' AS origin, id, name, type, birth_date, commands FROM HorsesAndDonkeys
UNION ALL
SELECT 'AnimalsAged1To3' AS origin, id, name, type, birth_date, commands FROM AnimalsAged1To3;



