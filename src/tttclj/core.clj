(ns tttclj.core
  (:require [tttclj.board :refer [new-board]]
            [tttclj.game :refer [play-game]]
            [tttclj.player.human :as human]
            [tttclj.player.ai :as ai]
            [tttclj.printer :refer [print-winner]]
            [tttclj.prompt :refer [prompt]]
            [tttclj.app :refer [app]]))

(defn -main [& args]
  (app human/move ai/move #(= (prompt "Play again? (y/n)" ["y" "n"]) "y"))
)
