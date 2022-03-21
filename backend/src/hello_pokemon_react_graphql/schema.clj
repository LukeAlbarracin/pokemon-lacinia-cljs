(ns hello-pokemon-react-graphql.schema
  "Contains custom resolvers and a function to provide the full schema."
  (:require
    [clojure.java.io :as io]
    [com.walmartlabs.lacinia.util :as util]
    [com.walmartlabs.lacinia.resolve :refer [resolve-as]]
    [com.stuartsierra.component :as component]
    [hello-pokemon-react-graphql.db :as db]
    [clojure.edn :as edn]
    [com.walmartlabs.lacinia.schema :as schema]))

(defn pokemon-by-id
  [db]
  (fn [_ args _]
    (db/find-pokemon-by-id db (:id args))))

(defn move-by-id
  [db]
  (fn [_ args _]
    (db/find-move-by-id db (:id args))))


(defn resolver-map
  [component]
  (let [db (:db component)]
    {:query/pokemon-by-id (pokemon-by-id db)
     :query/move-by-id (move-by-id db)}))

(defn load-schema
  [component]
  (-> (io/resource "pokemon-schema.edn")
      slurp
      edn/read-string
      (util/attach-resolvers (resolver-map component))
      schema/compile))

(defrecord SchemaProvider [schema]

  component/Lifecycle

  (start [this]
    (assoc this :schema (load-schema this)))

  (stop [this]
    (assoc this :schema nil)))

(defn new-schema-provider
  []
  {:schema-provider (-> {}
                        map->SchemaProvider
                        (component/using [:db]))})
