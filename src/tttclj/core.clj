(ns tttclj.core
  (:require [tttclj.app :refer [app]]
            [tttclj.prompt :refer [set-players play-again?]]))

(defn -main [& args]
  (app (set-players) play-again?)
)
