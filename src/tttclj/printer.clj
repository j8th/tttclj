(ns tttclj.printer
  (:require [tttclj.board :refer [empty-spot]]))

(let [replace-empty-spots-with-index-number (fn [board] 
        (map-indexed (fn [index, spot] (if (= spot empty-spot) index spot)) board))]

  (defn print-board [board]
    (let [spots (replace-empty-spots-with-index-number board)]
      (println (apply format (str " %s | %s | %s \n"
                                "-----------\n"
                                " %s | %s | %s \n"
                                "-----------\n"
                                " %s | %s | %s \n") spots))))

)
