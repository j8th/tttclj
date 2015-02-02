(ns tttclj.fixtures.test-boards
  (:require [tttclj.player.token :refer [token-x token-o]]
            [tttclj.board :refer [empty-spot new-board]]))

(def board-x-corners-o-mid [token-x    empty-spot empty-spot
                            empty-spot token-o    empty-spot
                            empty-spot empty-spot token-x])

(def board-x-0-o-4  [token-x    empty-spot empty-spot
                     empty-spot token-o    empty-spot
                     empty-spot empty-spot empty-spot])

(def board-x-43-o-0 [token-o    empty-spot empty-spot
                     token-x    token-x    empty-spot
                     empty-spot empty-spot empty-spot])

(def board-x-wins [token-x    empty-spot empty-spot
                   token-x    token-o    empty-spot
                   token-x    token-o    empty-spot])

(def board-o-wins [token-o    empty-spot empty-spot
                   token-o    token-x    token-x
                   token-o    empty-spot token-x])

(def draw-board [token-x    token-o    token-x
                 token-x    token-o    token-o
                 token-o    token-x    token-x])

(defn test-board [xspots ospots]
  (reduce #(assoc %1 %2 token-o) (reduce #(assoc %1 %2 token-x) new-board xspots) ospots))
