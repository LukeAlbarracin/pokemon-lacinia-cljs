(ns hello-pokemon-react-graphql.db
  (:require
    [com.stuartsierra.component :as component]
    [io.pedestal.log :as log]
    [clojure.java.jdbc :as jdbc]
    [clojure.string :as str])
  (:import (com.mchange.v2.c3p0 ComboPooledDataSource)))

(defn ^:private pooled-data-source
  [host dbname user password port]
  {:datasource
   (doto (ComboPooledDataSource.)
     (.setDriverClass "org.postgresql.Driver")
     (.setJdbcUrl (str "jdbc:postgresql://" host ":" port "/" dbname))
     (.setUser user)
     (.setPassword password))})

(defrecord HelloPokemonReactGraphqlDb [ds]

  component/Lifecycle

  (start [this]
    (assoc this
           :ds (pooled-data-source "localhost" "pokemondb" "pokemon_role" "lacinia" 25432)))

  (stop [this]
    (-> ds :datasource .close)
    (assoc this :ds nil)))

(defn new-db
  []
  {:db (map->HelloPokemonReactGraphqlDb {})})


(defn ^:private query
  [component statement]
  (let [[sql & params] statement]
    (log/debug :sql (str/replace sql #"\s+" " ")
               :params params))
  (jdbc/query (:ds component) statement))

(defn ^:private execute!
  [component statement]
  (let [[sql & params] statement]
    (log/debug :sql (str/replace sql #"\s+" " ")
               :params params))
  (jdbc/execute! (:ds component) statement))

(defn find-pokemon-by-id
  [component pokemon-id]
  (first
    (query component
           ["select id, name, usage
             from pokemon where id = ?" pokemon-id])))

(defn find-move-by-id
  [component move-id]
  (first
   (query component 
          ["select id, name
            from move where id = ?" move-id])))
