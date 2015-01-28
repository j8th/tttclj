(ns tttclj.game
  (:require [tttclj.rules :refer :all]))

(defn play-game [board player-x player-o]
  (cond
    (xwins? board) 1
    (draw? board) 0
    (owins? board) -1))
