(ns tttclj.board)

(defn drop-piece [board spot token]
  (assoc board spot token))
