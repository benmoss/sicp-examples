(ns sicp.ch2)

; 2.1
(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))

(defn make-rat [n d]
  (let [g (gcd n d)]
    (list (/ n g) (/ d g))))

(defn better-make-rat [n d]
  (let [g (gcd n d)]
    (list (/ n (Math/abs g)) (Math/abs (/ d g)))))

; 2.2
(defn make-point [x y]
  (list x y))

(defn x-point [p]
  (first p))

(defn y-point [p]
  (second p))

(defn make-segment [start end]
  (list start end))

(defn start-segment [s]
  (first s))

(defn end-segment [s]
  (second s))

(defn midpoint-segment [s]
  (let [start-x (x-point (start-segment s))
        end-x (x-point (end-segment s))
        start-y (y-point (start-segment s))
        end-y (y-point (end-segment s))]
    (make-point (/ (+ start-x end-x) 2)
                (/ (+ start-y end-y) 2))))

; 2.3
