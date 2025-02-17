# Variables
MONGO_CONTAINER=mongodb
MONGO_PORT=27017
MONGO_USER=admin
MONGO_PASSWORD=secret
MONGO_DB=order_management_db
MONGO_VOLUME=mongo_data

POSTGRES_CONTAINER=postgresql
POSTGRES_PORT=5432
POSTGRES_USER=postgres
POSTGRES_PASSWORD=secret
POSTGRES_DB=order_management_db
POSTGRES_VOLUME=postgres_data
TAG=12-alpine

# Run MongoDB container
run-mongo:
	docker run -d --name $(MONGO_CONTAINER) -p $(MONGO_PORT):27017 \
		-e MONGO_INITDB_ROOT_USERNAME=$(MONGO_USER) \
		-e MONGO_INITDB_ROOT_PASSWORD=$(MONGO_PASSWORD) \
		-v $(MONGO_VOLUME):/data/db mongo

# Run PostgreSQL container
run-postgres:
	docker run -d --name $(POSTGRES_CONTAINER) -p $(POSTGRES_PORT):5432 \
		-e POSTGRES_USER=$(POSTGRES_USER) \
		-e POSTGRES_PASSWORD=$(POSTGRES_PASSWORD) \
		-e POSTGRES_DB=$(POSTGRES_DB) \
		-v $(POSTGRES_VOLUME):/var/lib/postgresql/data postgres:$(TAG)

# Stop and remove MongoDB
clean-mongo:
	docker stop $(MONGO_CONTAINER) && docker rm $(MONGO_CONTAINER)

# Stop and remove PostgreSQL
clean-postgres:
	docker stop $(POSTGRES_CONTAINER) && docker rm $(POSTGRES_CONTAINER)

# Start both MongoDB and PostgreSQL
run-all: run-mongo run-postgres

# Stop and remove both containers
clean-all: clean-mongo clean-postgres

# Show running containers
ps:
	docker ps
