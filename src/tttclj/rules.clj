(ns tttclj.rules
  (:require [tttclj.player.token :refer [token-x token-o]]
            [tttclj.board :refer [empty-spot x-spots o-spots open-spots]]
            [clojure.set :refer [subset?]]))

(let [
     winning-combinations [#{0 1 2}
                           #{3 4 5}
                           #{6 7 8}
                           #{0 3 6}
                           #{1 4 7}
                           #{2 5 8}
                           #{0 4 8}
                           #{6 4 2}]

      contains-winning-combination? (fn [set-of-tokens]
                                      (not (empty? (filter #(subset? % set-of-tokens) winning-combinations))))
      ]

  (defn xwins? [board]
    (if (contains-winning-combination? (x-spots board))
      true 
      false))

  (defn owins? [board]
    (if (contains-winning-combination? (o-spots board))
      true
      false))

  (defn finished? [board]
    (if (and (not (xwins? board)) (not (owins? board)) (not (empty? (open-spots board))))
      false 
      true))

  (defn draw? [board]
    (if (and (not (xwins? board)) (not (owins? board)) (finished? board))
      true
      false))

  (defn xturn? [board]
    (if (and (= (count (x-spots board)) (count (o-spots board))) (not (finished? board)))
      true
      false)
    )

)
