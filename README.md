# [L3S5 COO] — Projet de conception orientée objet

# Binôme:
- Sara Lyna Ouyahia
- Angel Hely

# Présentation du projet :

Ce projet consiste à concevoir une simulation d'un système de location de vélos en libre-service similaire aux services Vélib ou V'Lille. Les principaux éléments de ce système comprennent des stations de location avec une capacité variable de 10 à 20 emplacements, des vélos classiques et électriques avec divers équipements, et un centre de contrôle chargé de superviser la flotte de vélos et les stations. La simulation doit gérer le dépôt et le retrait de vélos dans les stations, ainsi que la redistribution des vélos lorsque certaines stations restent vides ou pleines pendant trop longtemps.


---------


## How To
# Ceci est un projet maven

- Documentation:
` maven doc `


- Compilation:
` maven `

- Tests :
` maven test `
ou 
` maven verify `

 
- jar:



## UML

[Diagramme UML (Lucid)](https://lucid.app/lucidchart/9dc501e0-0b7b-4537-9b5b-f93b645f211e/edit?viewport_loc=-117%2C-103%2C1365%2C609%2CCNEwwmiSjA0G&invitationId=inv_d51f50c2-f5b2-428b-91ec-7436d3d0eb45)

## Journal de bord

### Semaine 1 :
Mercredi 20 Septembre :
- début de la modélisation des vélos, des stations, du centre de contrôle, des modeles, des Reparateurs et des accessoires des vélos.
- Donc création des classes : Bike.java, Station.java , FeatureDeco.java , ControlCenter.java et Repairer.java

### Semaine 2 :
Lundi 25 Septembre :
- Mise en place des Tests : StationTest.java et BikeTest.java

### Semaine 3 :
Mardi 03 Octobre :
- Mise en place des autres classes sur l'UML : Repairer, State, PannierRack, Folding, Basket, FeatureDeco (histoire de mettre le pattern Decorator)
ElectricBike.
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
- Création d'un package TwoWheeledVehicle qui represente tous les vehicules qui ont deux roues: velos, trotinettes...
- Implémentation des tests + ControlCenterTest
- Création du makefile

Mardi 18 Octobre :
- création de méthode initCapacityMax() et InitBikeInStation() + test Station 
- Mise en place de la Classe RepairerElectric 

Samedi 21 Octobre :
- Implémentation du reste des méthodes de twoWheeledVehicle et de Bike et ElectricBike pour gérer le coté electrique du vélo en prenant en compte sa capacité de batterie , son rechargement/déchargement..
- Implémentation de la classe station pour gérer les différents états du vehicule, si oui ou non on peut le louer..
- Implématation de l'enum State , en mettant en place deux nouveaux etats : endommagé et volé
- Implémentation du decorateur FeatureDeco pour factoriser le plus possible les vehicules
- Mise en place des tests : ElectricBikeTest, ElectricRepairerTest, FeatureTest, RepairerTest, twoWheeledTest.

- Méthode use() pour Bike 
- Changement d'approche concernant la gestion des Repairer par ControlCenter
- Méthode pour récupérer un seul véhicule dans la station
- Plus d'initialisation des véhicules dans Station
- Regroupement des méthodes pour modifier l'état d'un véhicule 
- Test pour Station et ControlCenter

Dimanche 22 Octobre :
- Implémentation des méthodes de Bike
- Test de ElectricBikeTest
- Implémentation d'autres méthodes dans différentes classes 
- Début de l'implémentation du Main

### Semaine 6 :

Lundi 23 Octobre :
- Mise en place de méthodes pour collecter les véhicules et redistribuer les véhicules
- Test pour ControlCenter, Bike et Repairer

### Semaine 7 :
Mardi 31 Octobre :
- création d'une classe Vlille scénarisé
- ajout d'une classe Input
- changement dans les affichages de certaines classes
- ajout de test pour Station



Jeudi 02 Novembre :
- Documentation des différentes méthodes de classe
- Modification de l'UML pour etre en concordance avec les classes du projets
- importation du diagramme UML sous format pdf.
- Mise en place de la gestion du nombre d'usage limite pour un véhicule.
- Test pour Bike

### Semaine 8 : 
Mercredi 08 Novembre :
- ajout d'une méthode askRepaire pour Bike qui retourne un repairer correspondant au bon vélo.
- modification de la gestion de Repairers dans les stations ainsi que de l'envoie de ces derniers pour qu'ils puissent effectuer leurs actions.

Dimanche 12 Novembre : 
- modification des tests de Bike et Station.
- changement de la façon dont les véhicules sont stockés dans les stations.
- création d'une liste de véhicules hors-services dans les stations pour différencier les véhicules disponibles et les véhicules hors-services.
- modification : avant que le centre de control envoie un réparateur, celui-ci demande au véhicule bar le bias de la station qu'elle réparateur il souhaite, si et seulement si il n'y a pas de réparteur qui correspond au souhait du véhicule 

### Semaine 9 :

Lundi 13 Novembre : 
- ajout et modification de tests dans BikeTest

Mardi 14 Novembre :
- création d'une liste de vehicules (inventaire) disponibles et une autre liste de vehicles pris (pas disponible, sur la route) dans la classe
ControlCenter.java
- Mise en place d'un package worker pour répertorier tous les travailleurs potentiels qui pourraient apporter quelque chose à un vehicule.

Mercredi 15 Novembre :
- mise en place d'une classe Worker abstraite et de l'héritage entre Repairer et Worker + modification de certaines méthodes pour
correspondre à la mise en place 
- Tests Station 
- Création d'une classe Planning pour gérer la plannification des repairers.


### Semaine 10 :
- Mise en place des sous classes de Planning, histoire de gérer les tests
- Une classe PlanningSystem et FakePlanning
- La classe State pour l'instant n'a plus aucune utilité, on laisse quand meme histoire de dire qu'on a commencé avec.

## Semaine 11 : 

Mercredi 29 Novembre :
- tests ControlCenter
- Ajout d'exception  
- suppression de Plannig

Dimanche 03 Décembre :
- Création d'une classe Time, pour créer un temps avec jours et heure 
- Création d'une classe Pair, pour créer un tuple avec deux valeurs
- Création d'une classe Planning et FakePlanning pour plannifier les tâche d'un Worker
- modification de la classe Worker 
- Test Pair
- début Test Planning

## Semaine 12 :
Lundi 04 Décembre :
- continuation des test de Planning

Mardi  Décembre :
- Suppression de la classe Statejava car elle ne sert plus à rien
- Test de ElectricRepairerTest fini
- Création d'une classe Mock pour gérer les stations et les workers
- Fin des tests unitaires
- Fin du codage de la classe Planning et Fakeplanning
- Mise à jour du diagramme UML et finition




## Explication du fonctionnement du projet et des classes :
la classe Planning sert à faire la plannification des taches pour les workers, dés qu'une nouvelle tache est ajoutée dans une station qui n'était pas prévue dans la routine du worker, ça l'envoie directement à Planning qui la plannifie pour le lendemain à 14H.
compte à FakePlanning elle sert surtout à faire les tests unitaires, c'est une classe qu'on a créé dans le but de gérer le temps pour les workers afin d'attribuer les taches aux  réparateurs et plannifier leur emploi du temps, elle sert de faux temps pour faciliter les tests unitaires.

La classe MockWorker sert d'alternative à la classe Worker (comme c'est une classe abstraite les tests dessus ne sont pas possibles) alors MockWorker est là afin de faciliter la création de stations pour les tests unitaires.

et concernant la classe MockStation elle est juste là pour faciliter l'écriture des tests (éviter de réécrire à chaque fois les @BeforeEach ...)

Comme le Main n'a pas été demandé pour ce projet, on a testé nos classes et méthodes grace à Maven en lançant maven test
ou directement sur Eclipse en lançant Maven test ou bien Maven Verify.


Tous les tests sont passés avec succès, aucun warning, aucune erreur

-Fin du projet
