#lang planet neil/sicp
 
; 2.5
(define (cons a b)
  (* (expt 2 a)
     (expt 3 b)))

(define (num-divs n d)
  (define (iter x result)
    (if (= 0 (remainder x d))
        (iter (/ x d) (+ 1 result))
        result))
  (iter n 0))

(define (car x)
  (num-divs x 2))

(define (cdr x)
  (num-divs x 3))

