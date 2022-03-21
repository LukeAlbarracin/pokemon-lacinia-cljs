SCHEMA_FILE=pokemon.json

help:
	@echo make init
	@echo make install
	@echo make clean
	@echo make run-ui
	@echo make run-api		
	@echo make run

init:
	yarn add -g json-graphql-server

install:
	yarn install

clean:
	rm -fr ./node_modules	

run-ui:
	yarn start

run-api:
	json-graphql-server $(SCHEMA_FILE) --p 5000	

run: run-api
