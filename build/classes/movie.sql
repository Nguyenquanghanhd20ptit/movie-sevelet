CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    hoten VARCHAR(255) NOT NULL
);


CREATE TABLE category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    type VARCHAR(255),
    price DOUBLE,
    image VARCHAR(255)
);


INSERT INTO category (id, name, type, price, image) VALUES
    (1, 'SPIDERMAN: NO WAY HOME', 'Marvel', 100000, 'https://taiphim4k.com/wp-content/uploads/2022/11/Ngu%CC%9Bo%CC%9B%CC%80i-Nhe%CC%A3%CC%82n-Kho%CC%82ng-co%CC%80n-nha%CC%80-2021-Spider-Man-No-Way-Home-Taiphim4k-Vietsub.jpeg');