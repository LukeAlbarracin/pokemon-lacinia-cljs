(ns hello-pokemon-react-graphql.system-tests
  (:require
    [clojure.test :refer [deftest is use-fixtures]]
    [hello-pokemon-react-graphql.system :as system]
    [hello-pokemon-react-graphql.test-utils :refer [simplify]]
    [com.stuartsierra.component :as component]
    [com.walmartlabs.lacinia :as lacinia]))

(defn ^:private test-system
  "Creates a new system suitable for testing, and ensures that
  the HTTP port won't conflict with a default running system."
  []
  (-> (system/new-system)
      (assoc-in [:server :port] 8989)))

(def ^:dynamic ^:private *system*)

(use-fixtures :once
  (fn [test-fn]
    (binding [*system* (component/start-system (test-system))]
      (try
        (test-fn)
        (finally
          (component/stop-system *system*))))))

(defn ^:private q
  "Extracts the compiled schema and executes a query."
  [query variables]
  (-> *system*
      (get-in [:schema-provider :schema])
      (lacinia/execute query variables nil)
      simplify))
(comment
  (deftest can-read-board-game
    (is (= {:data {:game_by_id {:max_players 2
                                :min_players 2
                                :name "Zertz"
                                :play_time nil
                                :summary "Two player abstract with forced moves and shrinking board"}}}
          (q "{ game_by_id(id: 1234) { name summary min_players max_players play_time }}"
              nil))))
)
