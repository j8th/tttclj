(ns tttclj.prompt)

(defn prompt [message choices]

  (println message)
  (let [choice (read-line)]
    (if (contains? (into #{} choices) choice)
      choice
      (prompt message choices))))
