(ns tttclj.player.ai-spec
  (:require [speclj.core :refer :all]
            [tttclj.player.ai :refer :all]
            [tttclj.board :refer :all]
            [tttclj.fixtures.test-boards :refer :all]
            [tttclj.game :refer [play-game]]
            [tttclj.rules :refer [draw?]]))

(describe "(move)"
  (it "returns an integer that fits on the board"
    (should (< -1 (move new-board) board-size)))

  (it "takes a winning move"
    (should= 5 (move (test-board '(0 3 4) '(1 6 7)))))

  (it "chooses a blocking move"
    (should= 5 (move (test-board '(3 4) '(0)))))

  (it "plays this game to a draw"
    (should (draw? (play-game (test-board '(8) '()) move move))))

  (it "plays this game to a draw"
    (should (draw? (play-game (test-board '(6) '()) move move))))

  (it "plays this game to a draw"
    (should (draw? (play-game (test-board '(3) '()) move move))))
)
