CREATE TABLE IF NOT EXISTS Animal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    species VARCHAR(255),
    age INT,
    image VARCHAR(255),
    adopted BOOLEAN
);

INSERT INTO Animal (name, species, age, image, adopted)
VALUES ('Bella', 'Chien', 3, 'https://th.bing.com/th/id/R.f1c01a05edc3d7133b9c6f81d071f432?rik=nx2bDQBEteLU8Q&riu=http%3a%2f%2fzezete2.z.e.pic.centerblog.net%2fo%2f3b10503e.jpg&ehk=dNRHCqhXCDzUFfCoVyHBQQXqM1tjsfsXnRLGIaTVEQ0%3d&risl=&pid=ImgRaw&r=0', false);

INSERT INTO Animal (name, species, age, image, adopted)
VALUES ('Milo', 'Chat', 2, 'https://th.bing.com/th/id/R.e56c0874793cbd09a2c5a477df105c36?rik=TEq0HoNSkNMClA&riu=http%3a%2f%2farcus.a.r.pic.centerblog.net%2fo%2f3514b761.jpg&ehk=PREEK%2b2XEzrFQS%2fXVabM2oCwciEWJCbnB%2fI%2fXmaN5KI%3d&risl=&pid=ImgRaw&r=0', false);
