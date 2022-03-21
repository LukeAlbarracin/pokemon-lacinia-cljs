#!/usr/bin/env bash

docker exec -ti --user postgres pokemon-db-1 psql -Upokemon_role pokemondb
