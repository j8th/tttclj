(ns tttclj.printer-spec
  (:require [speclj.core :refer :all]
            [tttclj.printer :refer :all]
            [tttclj.board :refer [new-board]]
            [tttclj.fixtures.test-boards :refer :all]))

(describe "(print-board)"
  (it "prints an empty board"
    (should= (str " 0 | 1 | 2 \n"
                  "-----------\n"
                  " 3 | 4 | 5 \n"
                  "-----------\n"
                  " 6 | 7 | 8 \n\n") (with-out-str (print-board new-board))))

  (it "prints a non-empty board"
    (should= (str " X | 1 | 2 \n"
                  "-----------\n"
                  " 3 | O | 5 \n"
                  "-----------\n"
                  " 6 | 7 | X \n\n") (with-out-str (print-board board-x-corners-o-mid))))

  (it "prints a non-empty board"
    (should= (str " X | 1 | X \n"
                  "-----------\n"
                  " 3 | X | O \n"
                  "-----------\n"
                  " 6 | 7 | O \n\n") (with-out-str (print-board (test-board '(0 2 4) '(5 8))))))

)

(describe "(print-winner)"
  (it "prints the winner of the board"
    (should= "Player X Wins!\n" (with-out-str (print-winner board-x-wins)))
    (should= "Player O Wins!\n" (with-out-str (print-winner board-o-wins)))
    (should= "Draw Game.\n" (with-out-str (print-winner draw-board)))
  ))
