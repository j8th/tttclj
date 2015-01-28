(ns tttclj.game
  (:require [tttclj.rules :refer :all]))

(defn play-game [board player-x player-o]
  (if (or (xwins? board) (owins? board) (draw? board))
    board))
