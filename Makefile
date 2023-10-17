all: doc Vlille.jar

doc:
		# génération de la documentation
		javadoc -sourcepath src -d doc -subpackages main/java/ProjetSara/Main

cls:
		# compilation des classes
		javac -cp res -sourcepath src -d classes src/main/java/ProjetSara/Main/*.java

test: cls
		# tests
		javac -d classes -classpath ./lib/junit-platform-console-standalone-1.9.0.jar ./src/main/java/ProjetSara/Main/*.java  ./src/main/java/ProjetSara/Main/gfx/*.java ./src/main/java/ProjetSara/Main/input/*.java  ./src/main/java/ProjetSara/Main/menu/*.java ./src/main/java/ProjetSara/Main/ui/*.java ./src/main/java/ProjetSara/Main/levels/*.java ./test/java/testSara/Main/ui/*.java ./test/java/testSara/Main/mocks/*.java  ./test/java/testSara/Main/menu/*.java ./test/java/testSara/Main/gfx/*.java ./test/java/testSara/Main/levels/*.java ./test/java/testSara/Main/input/*.java
		java -jar ./lib/junit-platform-console-standalone-1.9.0.jar -cp classes --scan-classpath --disable-banner

Vlille.jar: cls
	# construction du jar
	jar cvfm appli.jar manifest-tpX -C classes 
	
jeu:
	# execution du jar
	java -jar Vlille.jar


clean:
	# nettoyage des fichiers
	rm -r doc classes *.jar
