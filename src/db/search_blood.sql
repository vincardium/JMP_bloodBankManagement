CREATE TABLE `search`.`new_table` (
  `id` INT NOT NULL,
  `city` VARCHAR(15) NOT NULL,
  `blood_type` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO blood (id, city, blood_type)
VALUES
    ('1', 'Bandra', 'A+'),
    ('2', 'Bandra', 'B+'),
    ('3', 'Borivali', 'A-'),
    ('4', 'Chembur', 'B-'),
    ('5', 'Ghatkopar', 'O+'),
    ('6', 'Kurla', 'O-'),
    ('7', 'Kurla', 'AB+'),
    ('8', 'Kurla', 'AB+'),
    ('9', 'Kurla', 'A+'),
    ('10', 'Kurla', 'B+'),
    ('11', 'Panvel', 'AB-'),
    ('12', 'Shahad', 'AB+'),
    ('13', 'Shahad', 'A-'),
    ('14', 'Sion', 'O-'),
    ('15', 'Thane', 'B+'),
    ('16', 'Thane', 'AB-'),
    ('17', 'Vashi', 'A+');
DELETE FROM blood;
SELECT * FROM blood;