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
java -jar target/trains-0.0.1-SNAPSHOT.jar 
```

## Dummy Data in JSON
Send POST Request to ```localhost:8080/api/trains``` with body (raw JSON) :
```json
[
  {
    "id": 1,
    "name": "Light rail",
    "description": "Light rail, which might be also known as trolley and streetcars, mean trains that function as local transit in an urban-core and can operate on the street-level. Compared to rapid transit, light rail costs less, is more pedestrian friendly, but has less passenger capacity. The major advantage with light rail is that it can operate like rapid transit or like local buses, depending on the available infrastructure",
    "distanceBetweenStop": "a few blocks to 1 or 2 miles",
    "maxSpeed": "55-65 mph",
    "sharingTracks": true,
    "gradeCrossing": false,
    "trainFrequency": "3-30 minutes",
    "amenities": "n/a"
  },
  {
    "id": 2,
    "name": "Rapid transit",
    "description": "Rapid transit, which is also known as metro, subway, and heavy rail, mean trains that generally serve the urban-core, have large passenger capacity, and operate totally separate from road traffic. In order to run separately from road traffic in the city-core, rapid transit trains would run either above or underground.",
    "distanceBetweenStop": "1/2 mile to 2 or 3 miles",
    "maxSpeed": "65-70 mph",
    "sharingTracks": false,
    "gradeCrossing": false,
    "trainFrequency": "3-20 minutes",
    "amenities": "Large space for standees"
  },
  {
    "id": 3,
    "name": "Commuter rail",
    "description": "Commuter trains generally mean trains connecting suburban areas with the central city and primarily serves riders to and from work. Commuter trains typically run on weekdays, during rush hours, and only in the peak directions.",
    "distanceBetweenStop": "1 to 2 miles",
    "maxSpeed": "79 mph",
    "sharingTracks": true,
    "gradeCrossing": true,
    "trainFrequency": "15 minutes to hourly (some operate only during weekday peak hours)",
    "amenities": "Restroom"
  },
  {
    "id": 4,
    "name": "Inter-city rail",
    "description": "Inter-city trains generally mean trains traveling long distances connecting metropolitan areas. Although the distances covered by some of these trains are comparable to airlines, inter-city trains generally operate at highway speed. Long distance inter-city trains may provide amenities not found on most other forms of transportation, including sleeper-cars and cafe/dining cars.",
    "distanceBetweenStop": "2 to 10 miles",
    "maxSpeed": "79 mph",
    "sharingTracks": true,
    "gradeCrossing": true,
    "trainFrequency": "Hourly to once a day, or even three trips a week.",
    "amenities": "Restroom, business class, sleeper (longer distance), cafe car, dining car"
  },
  {
    "id": 5,
    "name": "High speed rail",
    "description": "High speed trains are generally defined as trains that can operate 125mph or faster. High speed trains generally connect large metropolitan areas (with very few stops in between) and are meant to be competitive with airlines in terms of overall travel time.",
    "distanceBetweenStop": "at least 10 miles",
    "maxSpeed": "at least 90 mph",
    "sharingTracks": false,
    "gradeCrossing": false,
    "trainFrequency": "15 minutes to hourly",
    "amenities": "Restroom, business class, cafe car"
  }
]
```

