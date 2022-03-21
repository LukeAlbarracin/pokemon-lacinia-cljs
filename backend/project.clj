(defproject hello-pokemon-react-graphql "0.1.0-SNAPSHOT"
  :description "hello-pokemon-react-graphql"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  ; NA. Use tutorial Clojure version
  ;:dependencies [[org.clojure/clojure "1.10.0"]]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.stuartsierra/component "0.3.2"]
                 [com.walmartlabs/lacinia "0.30.0"]
                 [com.walmartlabs/lacinia-pedestal "0.10.0"]
                 [org.clojure/java.jdbc "0.7.8"]
                 [org.postgresql/postgresql "42.2.5.jre7"]
                 [com.mchange/c3p0 "0.9.5.2"]
                 [org.flatland/ordered "1.5.7"]
                 [io.aviso/logging "0.3.1"]])
  ; NA. NOTE: remove this !!!  
  ; :repl-options {:init-ns hello-pokemon-react-graphql.core})
