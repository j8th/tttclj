(ns tttclj.game-spec
  (:require [speclj.core :refer :all]
            [tttclj.game :refer :all]
            [tttclj.fixtures.test-boards :refer :all]
            [tttclj.fixtures.mock-player :refer :all]
            [tttclj.player.ai :as ai]
            [tttclj.player.human :as human]
            [tttclj.rules :refer [finished?]]
            [tttclj.board :refer [new-board x-spots o-spots]]))

(describe "(play-game)"
  (it "returns the board for a game x wins."
    (should= board-x-wins (play-game board-x-wins human/move ai/move)))

  (it "returns the board for a draw game."
    (should= draw-board (play-game draw-board human/move ai/move)))

  (it "returns the board for a game o wins."
    (should= board-o-wins (play-game board-o-wins human/move ai/move)))

  (it "returns a finished board"
    (should (finished? (play-game new-board ai/move ai/move))))

  (it "alternates between players"
    (should (let [board   (play-game new-board ai/move ai/move)
                  num-xs  (count (x-spots board))
                  num-os  (count (o-spots board))]
              (<= 0 (- num-xs num-os) 1 ))))

  (it "takes moves from the players"
    (should= draw-board (play-game
                          new-board
                          (mock-player '(0 2 7 3 8))
                          (mock-player '(4 1 5 6))))
    (should= board-x-wins (play-game
                            new-board
                            (mock-player '(0 3 6))
                            (mock-player '(4 7)))))
)

