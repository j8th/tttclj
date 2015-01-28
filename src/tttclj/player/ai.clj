(ns tttclj.player.ai
  (:require [tttclj.board :refer [board-size]]))

(defn move [board]
  (rand-int board-size))
