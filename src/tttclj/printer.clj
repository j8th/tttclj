(ns tttclj.printer
  (:require [tttclj.board :refer [empty-spot]]
            [tttclj.rules :refer [xwins? owins? draw?]]))

(let [replace-empty-spots-with-index-number (fn [board] 
        (map-indexed (fn [index, spot] (if (= spot empty-spot) index spot)) board))]

  (defn print-board [board]
    (let [spots (replace-empty-spots-with-index-number board)]
      (println (apply format (str " %s | %s | %s \n"
                                "-----------\n"
                                " %s | %s | %s \n"
                                "-----------\n"
                                " %s | %s | %s \n") spots))))

  (defn print-winner [board]
    (print-board board)
    (cond
      (xwins? board) (println "Player X Wins!")
      (owins? board) (println "Player O Wins!")
      (draw? board) (println "Draw Game.")))
)
