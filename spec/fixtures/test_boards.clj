(ns tttclj.fixtures.test-boards
  (:require [tttclj.player.token :refer [token-x token-o]]))

(def empty-spot ".")

(def empty-board [empty-spot empty-spot empty-spot
                  empty-spot empty-spot empty-spot
                  empty-spot empty-spot empty-spot])

(def board-x-corners-o-mid [token-x    empty-spot empty-spot
                            empty-spot token-o    empty-spot
                            empty-spot empty-spot token-x])

