(ns tttclj.core
  (:require [tttclj.board :refer [drop-piece new-board]]))

(defn -main [& args]
  (print "I will be a TicTacToe game.\n")
  (print (str "Empty-spot is: " tttclj.board/empty-spot)))
