(ns tttclj.app
  (:require [tttclj.game :refer [play-game]]
            [tttclj.board :refer [new-board]]
            [tttclj.printer :refer [print-winner]]))

(defn app [player-x player-o play-again-fn]
  (print-winner (play-game new-board player-x player-o))
  (if (play-again-fn)
    (+ 1 (app player-x player-o play-again-fn))
    1))
