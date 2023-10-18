# [L3S5 COO] — Projet de conception orientée objet

# Binôme:
- Sara Lyna Ouyahia
- Angel Hely

# Présentation du projet :

Ce projet consiste à concevoir une simulation d'un système de location de vélos en libre-service similaire aux services Vélib ou V'Lille. Les principaux éléments de ce système comprennent des stations de location avec une capacité variable de 10 à 20 emplacements, des vélos classiques et électriques avec divers équipements, et un centre de contrôle chargé de superviser la flotte de vélos et les stations. La simulation doit gérer le dépôt et le retrait de vélos dans les stations, ainsi que la redistribution des vélos lorsque certaines stations restent vides ou pleines pendant trop longtemps.


---------


## How To

--Documentation:
javadoc -sourcepath src -d doc -subpackages main/java/ProjetSara/Main


--Compilation:
javac -sourcepath src -d classes src/main/java/ProjetSara/Main/*.java

--Compiltion Tests : 
javac -classpath junit-console.jar:classes src/test/java/testSara/*.java
 
 
--Exécution:
java -classpath classes ProjetSara.Main


--Exécution des tests :
 java -jar junit-console.jar -classpath test/testSara:classes -scan-classpath

--jar:
--Création:
jar cvfm appli.jar manifest-tpX -C classes
--Exécution:
java -jar Vlille.jar

## UML

[Diagramme UML (Lucid)](https://lucid.app/lucidchart/9dc501e0-0b7b-4537-9b5b-f93b645f211e/edit?viewport_loc=-117%2C-103%2C1365%2C609%2CCNEwwmiSjA0G&invitationId=inv_d51f50c2-f5b2-428b-91ec-7436d3d0eb45)

## Journal de bord

### Semaine 1 :
Mercredi 20 Septembre :
- début de la modélisation des vélos, des stations, du centre de contrôle, des modeles, des utilisateurs , Reparateur et des accessoires des vélos.
- Donc création des classes : Bike.java, Station.java , Feature.java , User.java , ControlCenter.java et Reparateur.java

### Semaine 2 :
Lundi 25 Septembre :
- Mise en place des Tests : StationTest.java et BikeTest.java

### Semaine 3 :
Mardi 03 Octobre :
- Mise en place des autres classes sur l'UML : Repairer, State, PannierRack, Folding, Basket, FeatureDeco (histoire de mettre le pattern Decorator)
ClassicBike, ElectricBike.
- Mise en place des Getteurs et Setteurs des différentes classes du projet.
- Réflexion sur la façon d'implementer les méthodes, et la conception des différentes 
classes tout en essayent d'utiliser le plus possibles les décorateurs et patterns vus 
en cours.

### Semaine 4 :
Lundi 09 Octobre :
- Codage de quelques méthodes des différentes classes,
- Mise en place des décorateurs et des différents patterns.

### Semaine 5 :
Lundi 16 Octobre :
- Suite du codage,
- Création d'un package TwoWheeledVehicle qui represente tous les trucs qui ont deux roues: velos, trotinettes...
- Implémentation des tests.
- Création du makefile

Mardi 18 Octobre :
- création de méthode initCapacityMax() et InitBikeInStation() + test Station 
- Mise en place des Classes Available, Unavailable et OutOfService pour le pattern state

### Semaine 6 :







