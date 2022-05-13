# nyxt_api
## API

Cette API à pour but de fournir des données à l'application [NYXT](https://github.com/maximemeyer/NYXT)


## Installation

### Prérequis
- Java 17
- BDD MySQL où MariaDB
- Maven

### BDD
Lancer le script base.sql puis donnees_de_test.sql

### Environnement
Dans application.properties, mettre les informations pour se connecter à la BDD

### Maven
En ligne de commande : mvn install -f pom.xml
Cette commande va créer le jar : nyxt_api-0.0.1-SNAPSHOT.war dans le dossier target

###Java
En ligne de commande pour démarrer le projet : java -jar nyxt_api-0.0.1-SNAPSHOT.war
