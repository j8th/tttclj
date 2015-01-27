(ns tttclj.player.human-spec
  (:require [speclj.core :refer :all]
            [tttclj.player.human :refer :all]
            [tttclj.board :refer :all]))

(describe "(move)"
  (around [it]
    (with-out-str (it)))

  (it "returns an integer that fits on the board"
    (should (< 0 (with-in-str "3" (move new-board)) (- board-size 1))))

  (it "prompts the player for a move"
    (should-contain "Please enter your move: " (with-out-str (with-in-str "4" (move new-board)))))

  (it "returns the move the player entered"
    (should= 6 (with-in-str "6" (move new-board))))

  (it "prints the board"
    (should-contain (str " 0 | 1 | 2 \n"
                         "-----------\n"
                         " 3 | 4 | 5 \n"
                         "-----------\n"
                         " 6 | 7 | 8 \n") (with-out-str (with-in-str "1" (move new-board)))))
)
