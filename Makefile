all: doc Vlille.jar

doc:
		# génération de la documentation
		javadoc -sourcepath src -d doc -subpackages main/java/projetCOO/Main

cls:
		# compilation des classes
		javac -sourcepath src -d classes src/main/java/projetCOO/Main/*.java

test: cls
		# tests
		javac -classpath junit-console.jar:classes src/test/java/testSara/*.java
		java -jar junit-console.jar -classpath test/testSara:classes -scan-classpath

Vlille.jar: cls
	# construction du jar
	jar cvfm Vlille.jar manifest-tpX -C classes
	
jeu:
	# execution du jar
	java -classpath classes projetCOO
	java -jar Vlille.jar


clean:
	# nettoyage des fichiers
	rm -r doc classes *.jar

	
	