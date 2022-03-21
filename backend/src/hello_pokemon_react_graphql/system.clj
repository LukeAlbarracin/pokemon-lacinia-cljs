(ns hello-pokemon-react-graphql.system
  (:require
    [com.stuartsierra.component :as component]
    [hello-pokemon-react-graphql.schema :as schema]
    [hello-pokemon-react-graphql.server :as server]
    [hello-pokemon-react-graphql.db :as db]))

(defn new-system
  []
  (merge (component/system-map)
         (server/new-server)
         (schema/new-schema-provider)
         (db/new-db)))
