all: doc Vlille.jar

doc:
		# génération de la documentation
		maven


test: cls
		# tests
		maven test


clean:
		# nettoyage des fichiers
		maven clean
	
	


	
	