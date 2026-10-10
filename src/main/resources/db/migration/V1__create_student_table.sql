CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    job_title VARCHAR(255) NOT NULL,
    salary DECIMAL(10, 0) DEFAULT NULL,
    full_time TINYINT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY idemployee_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO employee (
    id, first_name, last_name, birth_date,
    email, phone, job_title, salary, full_time
) VALUES
    (1, 'Jozef', 'Novák', '1992-04-15', 'jozef.novak@ukf.sk', '+421901234567', 'Software Engineer', 2000, 1),
    (2, 'Mária', 'Kováčová', '1988-11-20', 'maria.kovacova@ukf.sk', '+421902345678', 'Data Analyst', 1800, 1),
    (3, 'Peter', 'Horváth', '1995-07-05', 'peter.horvath@ukf.sk', '+421903456789', 'System Administrator', 1600, 0),
    (4, 'Anna', 'Miklová', '1990-09-25', 'anna.miklova@ukf.sk', '+421904567890', 'UX Designer', NULL, 1),
    (5, 'Milan', 'Rybár', '1985-03-14', 'milan.rybar@ukf.sk', '+421905678901', 'DevOps Engineer', 2200, 1),
    (6, 'Eva', 'Králiková', '1998-02-28', 'eva.kralikova@ukf.sk', '+421906789012', 'Front-End Developer', 1900, 1),
    (7, 'Martin', 'Slovák', '1983-12-09', 'martin.slovak@ukf.sk', '+421907890123', 'Back-End Developer', 2100, 0),
    (8, 'Jana', 'Poláková', '1991-06-17', 'jana.polakova@ukf.sk', '+421908901234', 'Project Manager', NULL, 1),
    (9, 'Tomáš', 'Bielik', '1987-08-30', 'tomas.bielik@ukf.sk', '+421909012345', 'QA Tester', 1700, 1),
    (10, 'Zuzana', 'Petríková', '1996-05-22', 'zuzana.petrikova@ukf.sk', '+421910123456', 'Product Owner', 2300, 1);