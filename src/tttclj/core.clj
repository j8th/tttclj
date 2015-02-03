(ns tttclj.core
  (:require [tttclj.app :refer [app]]
            [tttclj.prompt :refer [prompt set-players]]))

(defn -main [& args]
  (app (set-players) #(= (prompt "Play again? (y/n)" ["y" "n"]) "y"))
)
