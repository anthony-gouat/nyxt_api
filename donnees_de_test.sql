INSERT INTO utilisateur(nom_util,prenom_util,email_util,date_naissance_util,mot_de_passe_util) 
VALUES 
('util1','joe','joe.d@gmail.com','2000-09-24','joe1'),
('util2','jack','jack.d@gmail.com','2000-09-24','jack2'),
('util3','william','william.d@gmail.com','2000-09-24','william3'),
('util4','avrell','avrell.d@gmail.com','2000-09-24','avrell4');

INSERT INTO produit(nom_produit,description_produit,type_produit,score,prix)
VALUES 
('Msi Z-690','Support des processeurs Intel Core de 12ème génération sur socket LGA 1700. Support de la mémoire DDR4, jusqu''à 5000 MHz','Carte mère',15,112),
('Intel i-7 12700k','Processeur intel de 12 ème géneration','Processeur',10,12),
('MSI RTX 3080','Carte graphique Nvidia','Carte graphique',1,155.12),
('Gigabyte B450','Socket AM4 pour les processeurs AMD. RAM => DDR4','Carte mère',5,15),
('AMD R5 5600x','Prcesseur AMD => socket AM4','Processeur',15,15.1),
('Radeon RX 7800x','Carte graphique AMD','Carte graphique',12,55.2),
('Intel i-9 12900k','Processeur intel de 12 ème géneration','Processeur',18,55),
('Msi B550','Cette carte mère est conçue pour vous permettre de monter un ordinateur de grande capacité au jeu. Elle accueille les composants récemment sortis.
Compatible avec les processeurs AMD Ryzen','Carte mère',3,34.99);

INSERT INTO favoris(id_produit,id_util)
VALUES
(1,1),
(2,2),
(3,3),
(4,1);

INSERT INTO commentaires(id_produit,id_utilisateur,texte,note)
VALUES
(1,3,'bon produit',2),
(2,1,'bof',18),
(3,3,'repond aux besoins',15),
(4,4,'compliqué',12);