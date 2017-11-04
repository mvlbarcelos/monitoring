#!/bin/bash

#Create users
http -v POST http://127.0.0.1:8081/users/ \
    username=marcus email=marcus@test.com name=Marcus

http -v POST http://127.0.0.1:8081/users/ \
    username=jonh email=jonh@test.com name=Jonh

http -v POST http://127.0.0.1:8081/users/ \
    username=paul email=paul@test.com name=Paul


#Create subscriptions
http -v POST http://127.0.0.1:8082/payments/  \
    username=marcus type=PREMIUM status=ACTIVE

http -v POST http://127.0.0.1:8082/payments/  \
    username=jonh type=PREMIUM status=ACTIVE

http -v POST http://127.0.0.1:8082/payments/  \
    username=paul type=STANDARD status=ACTIVE

#Create Movies

http -v POST http://127.0.0.1:8080/movies/  \
    title="Training Day" typeSubscription=PREMIUM

http -v POST http://127.0.0.1:8080/movies/  \
    title="The Godfather" typeSubscription=PREMIUM

http -v POST http://127.0.0.1:8080/movies/  \
    title="E.T. the Extra-Terrestrial" typeSubscription=PREMIUM

http -v POST http://127.0.0.1:8080/movies/  \
    title="Saving Private Ryan" typeSubscription=STANDARD 

http -v POST http://127.0.0.1:8080/movies/  \
    title="Braveheart" typeSubscription=STANDARD
 

