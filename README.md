# Eshop
## Requirements
 - Java 17
 - PostgreSQL
 - Docker (optional)

## How to run
### Run using Docker
1. Run `mvn package` to create jar file
2. Generate docker image: `docker build -t <image-name> .`
3. Pull postgresql image from dockerhub and create `eshop` db
4. Run both containers: `docker compose up`
5. To shutdown both containers: `docker compose down`

### Run locally
1. Create db with name `eshop` in postgres
2. Set environments variables DB_HOST, DB_USERNAME and DB_PASSWORD according to your db settings

## Features

### Liquibase
For DB migration Liquibase is used. Migration is defined in `/resources/migration/` folder.

### Etag
To reduce the network traffic Etag is used.