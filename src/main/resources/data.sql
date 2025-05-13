CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    enabled BOOLEAN DEFAULT true,
    account_non_expired BOOLEAN DEFAULT true,
    account_non_locked BOOLEAN DEFAULT true,
    credentials_non_expired BOOLEAN DEFAULT true
);

-- Password for both users is "password"
INSERT INTO users (username, email, password)
VALUES ('admin', 'admin@example.com', '$2a$10$RX5I3TWnSeADKZwkXLRqFeBhg3DDxGtpwKRFdF8zUC9P./6RmPDT2');

INSERT INTO users (username, email, password)
VALUES ('user', 'user@example.com', '$2a$10$RX5I3TWnSeADKZwkXLRqFeBhg3DDxGtpwKRFdF8zUC9P./6RmPDT2');

CREATE TABLE IF NOT EXISTS Animal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    species VARCHAR(255),
    age INT,
    image VARCHAR(255),
    adopted BOOLEAN DEFAULT false
);

INSERT INTO Animal (name, species, age, image)
VALUES ('Bella', 'Chien', 3, 'https://th.bing.com/th/id/R.f1c01a05edc3d7133b9c6f81d071f432?rik=nx2bDQBEteLU8Q&riu=http%3a%2f%2fzezete2.z.e.pic.centerblog.net%2fo%2f3b10503e.jpg&ehk=dNRHCqhXCDzUFfCoVyHBQQXqM1tjsfsXnRLGIaTVEQ0%3d&risl=&pid=ImgRaw&r=0');

INSERT INTO Animal (name, species, age, image)
VALUES ('Milo', 'Chat', 2, 'https://th.bing.com/th/id/R.e56c0874793cbd09a2c5a477df105c36?rik=TEq0HoNSkNMClA&riu=http%3a%2f%2farcus.a.r.pic.centerblog.net%2fo%2f3514b761.jpg&ehk=PREEK%2b2XEzrFQS%2fXVabM2oCwciEWJCbnB%2fI%2fXmaN5KI%3d&risl=&pid=ImgRaw&r=0');

INSERT INTO Animal (name, species, age, image)
VALUES ('Toto', 'Tortue', 10, 'https://evasion-online.com/image-photo/tortue/Victoire-la-tortue.jpg');

INSERT INTO Animal (name, species, age, image)
VALUES ('Daffy', 'Canard', 2, 'https://th.bing.com/th/id/OIP.jjrqP8lKCQgFefiMsFgSMQHaFj?rs=1&pid=ImgDetMain');

INSERT INTO Animal (name, species, age, image)
VALUES ('Coco', 'Poule', 3, 'https://i.notretemps.com/1400x787/smart/2013/08/28/poule-jardin.jpg');


INSERT INTO Animal (name, species, age, image)
VALUES ('Luna', 'Lapin', 2, 'https://i.pinimg.com/originals/fc/d9/84/fcd9849e0114ede0c08b3717f9adf1c9.jpg');

INSERT INTO Animal (name, species, age, image)
VALUES ('Tango', 'Perroquet', 4, 'https://yokohamabirdclinic.jp/wp-content/uploads/2021/11/P1240518.jpg');

INSERT INTO Animal (name, species, age, image)
VALUES ('Nala', 'Hamster', 1, 'https://media-be.chewy.com/wp-content/uploads/hamster-language.jpg');
