(ns tttclj.prompt
  (:require [tttclj.player.human :as human]
            [tttclj.player.ai :as ai]))

(defn prompt [message choices]
  (println message)
  (let [choice (read-line)]
    (if (contains? (into #{} choices) choice)
      choice
      (prompt message choices))))

(defn set-players []
  (let [choice (prompt "Will you be X or O?" ["X" "O"])]
    (if (= choice "X")
      [human/move ai/move]
      [ai/move human/move])))

(defn play-again? []
  (= (prompt "Play again? (y/n)" ["y" "n"]) "y"))
