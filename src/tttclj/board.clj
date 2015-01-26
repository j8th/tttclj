(ns tttclj.board)

(def empty-spot ".")
(def empty-board [empty-spot empty-spot empty-spot
                  empty-spot empty-spot empty-spot
                  empty-spot empty-spot empty-spot])

(defn drop-piece [board spot token]
  (assoc board spot token))

(defn new-board []
  empty-board)
