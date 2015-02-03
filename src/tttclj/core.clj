(ns tttclj.core
  (:require [tttclj.board :refer [new-board]]
            [tttclj.game :refer [play-game]]
            [tttclj.player.human :as human]
            [tttclj.player.ai :as ai]
            [tttclj.printer :refer [print-winner]]
            [tttclj.prompt :refer [prompt set-players]]
            [tttclj.app :refer [app]]))

(defn -main [& args]
  (app (set-players) #(= (prompt "Play again? (y/n)" ["y" "n"]) "y"))
)
