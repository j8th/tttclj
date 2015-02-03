(ns tttclj.app
  (:require [tttclj.game :refer [play-game]]
            [tttclj.board :refer [new-board]]
            [tttclj.printer :refer [print-winner]]))

(defn app [players play-again-fn]
  (print-winner (play-game new-board (first players) (second players)))
  (if (play-again-fn)
    (+ 1 (app players play-again-fn))
    1))
