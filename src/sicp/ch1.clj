(ns sicp.ch1)

(defn square [x] (* x x))

(defn sum-of-squares [x y]
  (+ (square x) (square y)))

(defn f [a]
  (sum-of-squares (+ a 1) (* a 2)))

(defn abs [x]
  (cond 
    (> x 0) x
    (= x 0) 0
    (< x 0) (- x)))

(defn abs2 [x]
  (cond
    (< x 0) (- x)
    :else x))

(defn abs3 [x]
  (if (< x 0)
    (- x)
    x))


; 1.1
10
12
8
3
6
; a def
; another def
19
false
4
16
6
8

; 1.2
(/ (+ 5 (- 2 (- 3 (+ 6 (/ 4 3)))))
   (* 3 (- 6 2) (- 2 7)))

; 1.3
(fn [x y z]
  (cond
    (and (>= x z) (>= y z))
         (+ (* x x) (* y y))
    (and (>= x z) (>= z y))
         (+ (* x x) (* z z))
    (and (>= y x) (>= z x))
         (+ (* y y) (* z z))))

; 1.4
; if b is greater than 0, add a and b, else subtract b from a

; 1.5
; if using applicative-order, the procedure would return false
; if using normal-order, the procedure would be caught in an infinite loop of trying to evaluate p

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn average [x y]
  (/ (+ x y) 2))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

(sqrt 9)
(sqrt (+ 100 37))
(sqrt (+ (sqrt 2) (sqrt 3)))
(square (sqrt 1000))

; 1.6
; it will evaluate the predicate and two clauses in order to pass them into the new-if procedure

; 1.7
; with very small numbers, the result will always turn out to be around 0.03, because the x value is so low it will be below 0.001
; with very large numbers, rounding results in us seeing same answer for different numbers

; 1.8
(defn cubert [x]
  (cubert-iter 1.0 x))

(defn cubert-iter [guess x]
  (if (good-enough? guess x)
    guess
    (cubert-iter (cube-improve guess x)
                 x)))

(defn cube-improve [guess x]
  (/ (+ (/ x (square guess)) (* guess 2))
     3))
