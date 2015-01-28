(ns tttclj.game-spec
  (:require [speclj.core :refer :all]
            [tttclj.game :refer :all]
            [tttclj.fixtures.test-boards :refer :all]
            [tttclj.player.ai :as ai]
            [tttclj.player.human :as human]))

(describe "(play-game)"
  (it "returns 1 for a game x wins."
    (should= 1 (play-game board-x-wins human/move ai/move)))

  (it "returns 0 for a draw game."
    (should= 0 (play-game draw-board human/move ai/move)))

  (it "returns -1 for a game o wins."
    (should= -1 (play-game board-o-wins human/move ai/move)))
)

