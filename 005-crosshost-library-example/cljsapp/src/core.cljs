(ns core
  (:require [vkjr.logger :as logger]))

(defn -main [& _]
  (logger/log "Hi there!")
  (logger/log {:a 1 :b 2})
  (logger/log [1 2 3 4])
  (logger/log (new js/Date)))
