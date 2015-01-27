(ns tttclj.board)

(def empty-spot ".")
(def size 9)
(def new-board [empty-spot empty-spot empty-spot
                empty-spot empty-spot empty-spot
                empty-spot empty-spot empty-spot])

(defn drop-piece [board spot token]
  (assoc board spot token))
