buildJava:
	./buildScript.sh
docker:
	docker build ./ -t java
	docker run -p 8081:8081 java --detach
run: buildJava docker