(ns tttclj.player.human
  (:require [tttclj.printer :refer [print-board]]
            [tttclj.board :refer [open-spots]]))

(defn move [board]
  (print-board board)
  (println "Please enter your move: ")
  (let [spot (read-string (read-line))]
    (if (contains? (open-spots board) spot)
      spot
      (move board))))
