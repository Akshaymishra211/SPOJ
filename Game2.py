# your code goes here
import sys
import math
import bisect
from sys import stdin,stdout
from math import floor,sqrt,log
from collections import defaultdict as dd
from bisect import bisect_left as bl,bisect_right as br
mod=1000000007
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
def check(s1,s2,n,m,dp):
    if m==0:
        for i in range(n-1,-1,-1):
            if s1[i]!='*' and s1[i]!='?':
                return False
        return True
    elif m!=0 and n==0:
        return False
    elif dp[n][m]!=-1:
        return dp[n][m]
    elif s1[n-1]!='?' and s1[n-1]!='*':
        if s1[n-1]!=s2[m-1]:
            return False
        else:
            dp[n][m]=check(s1,s2,n-1,m-1,dp)
            return dp[n][m]
    else:
        if s1[n-1]=='*':
            t1=check(s1,s2,n,m-1,dp)
            t2=check(s1,s2,n-1,m,dp)
        elif s1[n-1]=='?':
            t1=check(s1,s2,n-1,m-1,dp)
            t2=check(s1,s2,n-1,m,dp)
        dp[n][m]=t1 or t2
        return dp[n][m]
 
 
def solve():
    dp=[[-1 for i in range(1005)] for j in range(1005)]
    L=input()
    S=input()
    n,m=len(L),len(S)
    if check(L,S,n,m,dp):
        print("Yes")
    else:
        print("No")
if __name__ == "__main__":
    testcase=int(sys.stdin.readline())
    for _ in range(testcase):
        solve() 
