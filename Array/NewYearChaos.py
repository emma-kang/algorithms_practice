# 2019-12-11
# HackerRank NewYearChaos 
# https://www.hackerrank.com/challenges/new-year-chaos/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumBribes function below.
def minimumBribes(q):
    move = 0 # initialize result 
    
    q = [p-1 for p in q]
    
    # original position is 0,1,2,3,4, (eg. 5 people) == index
    for i, v in enumerate(q): 
        if (v-i) > 2:
            return print("Too chaotic")
        
        for j in range(max(v-1,0),i):
            if q[j] > v:
                move += 1
    
    print(move)
        

if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        n = int(input())

        q = list(map(int, input().rstrip().split()))

        minimumBribes(q)
