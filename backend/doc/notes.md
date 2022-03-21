# notes

## TODO
- NA, NLA.  Review Brave, Clojure book - IN PROGRESS
- NA. Scaffold frontend/ to call a test graphql endpoint = COMPLETED
- NA, NLA. Lift and move lucinia tutorial for pokemon - COMPLETED
- NA. Isolate concepts for NLA prep.
- NA. Lift and move minimal hybrid-fall2021-kpod assets for web UI

## References
- https://www.braveclojure.com/
- https://graphql.org/
- https://github.com/walmartlabs/lacinia
- https://github.com/walmartlabs/clojure-game-geek
- https://lacinia.readthedocs.io/en/latest/tutorial/
- https://lacinia.readthedocs.io/en/latest/resources.html

## Miscellaneous
- https://blog.logrocket.com/mocking-graphql-api-server-using-json-graphql-server/
- https://github.com/marmelab/json-graphql-server

## Lift, Move notes
- NA. scaffold with lein new "backend" and then lift and move tutorial components
- NA. Change namespace to hello-pokemon-react-graphql globally.
- NA. NOTE: Need underscores for package folder names (e.g., hello_pokemon_react_graphql)
- NA. dev-resources/ need modification for user.clj, test_utils
- NA. Change user, schema, database names throughout (e.g, pokemon, pokemondb)
- NA. Add bin/*.sh scripts and customize for pokemondb
- NA. Add Makefile bin/*.sh targets

## Troubleshooting
- NA. Namespaces!!! Correct global replace
- NA. Tutorial starts with .edn but send with full Postgres.  Know the difference and understand
  - `lein repl`
    - must have proper configuration with dev-resources\user.clj
    - NOTE: if you have default core.clj and core_tests.clj from `lein new` this defaults to core namespace unintentionally! with project.clj
      - :repl-options {:init-ns hello-pokemon-react-graphql.core})

## REPL queries
- NA. run `lein repl`
  - (start)

  - (q "{pokemon_by_id(id:2) {id name}}")

  - (stop)

## Concepts for NA, NLA pairing
- Q: What is different in .edn versu external Postgres?
  - A: 
- Q: How to start, stop and setup Postgres DB
- Q: Differences in REPL testing on .edn versus external DB
- Q: Components and libraries:
  - Lacinia Pedastal
  - Clojure/Postgres drive
  - Clojure/JDBC
- Q: dev-resources/
  - REPL and user namespace
- Q: What is a logger
  - logback-test.xml

## Interview Preparation
- Q: What version of Clojure?
  - A: Clojure 1.9 for tutorial; Clojure 1.10 for current projects
- Q: What is library to pass SQL queries to Postgres?
  - A: org.clojure/java.jdbc
- Q: What is C3P0?
  - A: A database pooling connection library