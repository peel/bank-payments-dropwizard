#!/bin/bash

curl -i -X POST -H "Content-Type:application/json" -d '{  "debit" : "John Doe",  "credit" : "Jane Doe", "amount": "123"}' http://localhost:8003/payments
