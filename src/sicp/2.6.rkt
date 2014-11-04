#lang racket
 
(define zero (lambda (f) (lambda (x) x)))

(define (add-1 n)
  (lambda (f) (lambda (x) (f ((n f) x)))))

(define one
  (lambda (f) (lambda (x) (f x) x)))

(define two
  (lambda (f) (lambda (x) (f x) (f x) x)))

(define (hi x)
  (print x)
  x)

(define (add n1 n2)
  (lambda (f) (lambda (x) 
                ((n1 f) x) 
                ((n2 f) x))))

;((zero hi) "hi")
;((two hi) "sup")
;(((add-1 zero) hi) "sup")
;(((add-1 (add-1 (add-1 zero))) hi) "sup")
(((add two two) hi) "hi")