(ns tttclj.prompt)

(defn prompt [message choices]
 (println message)
 (let [choice (read-line)]
   (if (contains? choices choice)
     choice
     (prompt message choices))))
