def totalSum(mat, n) :
    # Your code goes here
    l=[]
    for i in range(n):
        l.append(mat[i][0])
        l.append(mat[i][n-1])
        l.append(mat[0][i])
        l.append(mat[n-1][i])
    for i in range(n):
        l.append(mat[i][i])
        l.append(mat[i][n-i-1])
    res=sum(set(l))
    print(set(l))
t=int(input())
mat=[]
for i in range(t):
    n=int(input())
    for i in range(n):
        mat.append(list(map(int,input().split())))
    totalSum(mat,n)
