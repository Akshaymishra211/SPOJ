import sys
import math
import bisect
from sys import stdin,stdout
from math import floor,sqrt,log
from collections import defaultdict as dd
from bisect import bisect_left as bl,bisect_right as br
mod=1000000007
sys.setrecursionlimit(10**6)
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def mod_inverse(a, n):
    N = n
    xx = 0
    yy = 1
    y = 0
    x = 1
    while(n > 0):
        q = a // n
        t = n
        n = a % n
        a = t
        t = xx
        xx = x - q * xx
        x = t
        t = yy
        yy = y - q * yy
        y = t
    x %= N
    x += N
    x %= N
    return x
def SieveOfEratosthenes(n): 
    prime = [True for i in range(n + 1)] 
    p = 2
    while (p * p <= n):  
        if (prime[p] == True):  
            for i in range(p * 2, n + 1, p): 
                prime[i] = False
        p += 1
    prime[0]= False
    prime[1]= False
    # return all prime numbers below n in O(n*log(log(n))
    return prime

def func(string,size,dp):
    t1,t2,t3=0,0,0
    if size==1 or size==0:
        return dp[size]
    if dp[size]!=-1:
        return dp[size]
    if string[size-1]!='0':
        t1=func(string,size-1,dp)
    if size>=2:
        if string[size-2]=='1':
            t2=func(string,size-2,dp)
        elif string[size-2]=='2' and int(string[size-1])<7:
            t3=func(string,size-2,dp)
    dp[size]=t1+t2+t3
    return dp[size]

def solve():
    dp=[-1]*(5005)
    dp[0]=1
    dp[1]=1
    num=input()
    if int(num)==0:
        exit()
    print(func(num,len(num),dp))    

if __name__ == "__main__":
    '''if ("in.txt" and "out.txt"):
        sys.stdin=open("in.txt",'r')
        sys.stdout=open("out.txt",'w')
    testcase=int(sys.stdin.readline())
    for _ in range(testcase):'''
    while True:
        solve()
