# Train Manager
## Topcoder Skill Builder Competition | Java + Springboot + PostgreSQL

Steve has achieved his childhood dream of becoming a train manager.
- In the easy challenge, Steve will be going through the onboarding process, he will be educating himself about the different trains & services available.
- In the medium challenge, the cancellation of the train's arrival has forced him to search for the train based on some clue then he created and requires him to delete it.
- Finally in the hard challenge, his attention to detail is rewarded by his supervisor to edit the details of a particular train and also allows him to add the details of a new bullet train. 

## Topcoder Skill Builder | Java + Springboot + PostgreSQL Levels
- Easy | Challenge Link: http://www.topcoder.com/challenges/30168991
- Medium | Challenge Link: http://www.topcoder.com/challenges/30168980
- Hard |  Challenge Link: http://www.topcoder.com/challenges/30168986

## Postgre SQL Installation

Train Manager requires [PostgreSql](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) to run.
For installation on Mac OS, please follow [this tutorial](https://www.postgresqltutorial.com/install-postgresql-macos/). Set password to `password` and port to `5432`

Add Postgre Repository :
```sh
sudo apt-get install wget ca-certificates
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
```

Update Package List :
```sh
sudo apt-get update
```

Install Postgre SQL :
```sh
sudo apt-get install postgresql postgresql-contrib
```


## Create A New Database
Train Manager requires a database `train` installed manually. To establish a connection, log into the postgres account with:
```sh
sudo su - postgres
```
Now open a postgress prompt using the command:
```sh
psql
```

Create a new database `train`:
```sh
create database train;
```

## Build
Run a maven build using this command
```sh
mvn clean package spring-boot:repackage
```

To run the application
```sh
java -jar target/grab-0.0.1-SNAPSHOT.jar 
```
