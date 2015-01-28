(ns tttclj.player.ai
  (:require [tttclj.board :refer [board-size open-spots]]))

(defn move [board]
  (rand-nth (into [] (open-spots board))))
