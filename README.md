# Estos son los pasos para desplegar el proyecto correctamente en docker
## En una sola carpeta crear las sub carpetas:

-iris_call_ms:Clonar el repositorio iris_call_ms
-iris_call_db: crear una subcarpeta llamada iris_call_db y Crear un archivo Dockefile de la siguiente manera:
	
	FROM mysql:5.7

	ENV MYSQL_ROOT_PASSWORD=abcd
	ENV MYSQL_DATABASE=iris_call_db
	ENV MYSQL_USER=call
	ENV MYSQL_PASSWORD=abcd

	EXPOSE 3307

## Crear el Jar de la app
-mvn clean package -DskipTests

## Copiar imagen mysql
-docker pull mysql:5.7

## Correr el DockerFile de call_ms
-docker build -t iris_call_ms .

## Crear una network para conectar la db con el container
-docker network create user-mysql

## Para la base de datos
## crear la db
-docker build -t iris_call_db .

## Desplegar la base ded datos
-docker run -d -t -i -p 3307:3306 --name iris_call_db --network user-mysql iris_call_db

## Desplegar en phpMyAdmin
-docker run --name phpmyadmin --network user-mysql -d --link iris_call_db:db -p 8081:80 phpmyadmin

## Crear el container del ms y unir la base de datos con el container del ms
-docker run -p 9091:8080 --name iris_call_ms --network user-mysql -d iris_call_ms

## Para saber el id del container de call_ms
-docker ps

## Correar la app
-docker logs -f "conatiner id de iris_call_ms"
