(ns tttclj.game-spec
  (:require [speclj.core :refer :all]
            [tttclj.game :refer :all]
            [tttclj.fixtures.test-boards :refer :all]
            [tttclj.player.ai :as ai]
            [tttclj.player.human :as human]))

(describe "(play-game)"
  (it "returns the board for a game x wins."
    (should= board-x-wins (play-game board-x-wins human/move ai/move)))

  (it "returns the board for a draw game."
    (should= draw-board (play-game draw-board human/move ai/move)))

  (it "returns the board for a game o wins."
    (should= board-o-wins (play-game board-o-wins human/move ai/move)))
)

