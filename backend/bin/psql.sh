#!/usr/bin/env bash

docker exec -ti --user postgres pokemon_db_1 psql -Upokemon_role pokemondb
