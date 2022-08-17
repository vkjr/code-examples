(ns vkjr.logger
  (:require [clojure.pprint :as pprint]))

(defn timestamp []
  #?(:clj
     (.format (java.text.SimpleDateFormat. "d/M/yyyy, HH:mm:ss") (new java.util.Date))
     :cljs
     (let [now (new js/Date)]
       (.toLocaleString now "en-US" #js{:hour12 false}))))

(defn log [arg]
  (pprint/cl-format true
                    "Time: ~S | Lang: ~S | Object: ~S\n"
                    (timestamp)
                    #?@(:clj ["Clojure"]
                        :cljs ["ClojureScript"])
                    arg))

(comment

  (read-string {:read-cond :allow} "(#?@(:clj [\"Clojure\"]
                        :cljs [\"ClojureScript\"]))"))