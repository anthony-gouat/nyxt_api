INSERT INTO utilisateur(nom_util,prenom_util,email_util,date_naissance_util,mot_de_passe_util) 
VALUES 
('util1','joe','joe.d@gmail.com','2000-09-24','joe1'),
('util2','jack','jack.d@gmail.com','2000-09-24','jack2'),
('util3','william','william.d@gmail.com','2000-09-24','william3'),
('util4','avrell','avrell.d@gmail.com','2000-09-24','avrell4');

INSERT INTO produit(nom_produit,description_produit,type_produit,score,prix)
VALUES 
('p1','c est le p1','type1',15,112),
('p2','c est le p2','type2',10,12),
('p3','c est le p3','type3',1,155.12),
('p4','c est le p4','type1',5,15),
('p5','c est le p5','type2',15,15.1),
('p6','c est le p6','type3',12,55.2),
('p7','c est le p7','type2',18,55),
('p8','c est le p8','type1',3,34.99);

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