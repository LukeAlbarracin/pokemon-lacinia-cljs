help:
	@echo make shell
	@echo ""
	@echo make docker_up
	@echo make db_setup
	@echo make db_shell
	@echo make docker_down
	@echo ""
	@echo make tests

# NA. NOTE: will default to clojure profile in dev-resources/user.clj
shell:
	lein repl

docker_up:
	. ./bin/docker-up.sh

db_setup:
	. ./bin/setup-db.sh

db_shell:
	. ./bin/psql.sh

docker_down:
	. ./bin/docker-down.sh

# NA.
# NOTE. make test conflicts with Clojure default test/ directory structure
tests:
	lein test

