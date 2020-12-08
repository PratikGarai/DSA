class Node:
    def __init__(self, data):
        self.data = data
        self.neighbours = []

class Graph:
    def __init__(self, size):
        self.nodes = [ Node(i) for i in range(size) ]

    def add(self, a,b,c):
        self.nodes[a].neighbours.append([self.nodes[b],c])
        self.nodes[b].neighbours.append([self.nodes[a],c])

    def digkstra(self, source, dest):
        pass

def main():
    
    print("Enter the vertices : ")
    n = int(input())
    print("Enter the number of edges : ")
    e = int(input())

    g = Graph(n)
    print("Enter the edges and weights : ")
    for i in range(e):
        a,b,c, = map(int, input().split())
        g.add(a,b,c)
    
    print("\nEnter the source : ")
    s = int(input())
    print("Enter the destination : ")
    d = int(input())
    g.digkstra(s,d)
