(ns tttclj.core
  (:require [tttclj.board :refer [new-board]]
            [tttclj.game :refer [play-game]]
            [tttclj.player.human :as human]
            [tttclj.printer :refer [print-winner]]))

(defn -main [& args]
  (print-winner (play-game new-board human/move human/move))
)
