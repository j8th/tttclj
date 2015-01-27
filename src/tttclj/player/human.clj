(ns tttclj.player.human
  (:require [tttclj.printer :refer [print-board]]))

(defn move [board]
  (print-board board)
  (print "Please enter your move: ")
  (read-string (read-line)))
