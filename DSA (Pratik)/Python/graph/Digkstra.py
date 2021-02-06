class Node:
    def __init__(self, data):
        self.data = data
        self.neighbours = []


class Graph:
    def __init__(self, size):
        self.nodes = [ Node(i) for i in range(size) ]
        self.size = size

    def add(self, a,b,c):
        self.nodes[a].neighbours.append([self.nodes[b],c])
        self.nodes[b].neighbours.append([self.nodes[a],c])

    def digkstra(self, source, dest):
        parents = [-1 for i in range(self.size)]
        processed = [False for i in range(self.size)]
        shortestDist = [100000 for i in range(self.size)]
        n_processed  = 0
        shortestDist[source] = 0

        while(n_processed<self.size):
            index = self.getShortestUnprocessedIndex(shortestDist, processed)
            n_processed += 1
            processed[index] = True
            vertex = self.nodes[index]
            # print("Vertex : ", index)

            for neighbour in vertex.neighbours:
                # print("Processing : ", neighbour[0].data)
                if processed[neighbour[0].data]:
                    continue
                if shortestDist[index]+neighbour[1]<shortestDist[neighbour[0].data]:
                    shortestDist[neighbour[0].data] = shortestDist[index]+neighbour[1]
                    parents[neighbour[0].data] = index
        print("Result : ")
        print("Distance : ", shortestDist[dest])

        path = []
        ind = dest
        while(parents[ind]!=-1):
            path.append(ind)
            ind = parents[ind]
        path.append(source)

        print("Path : ", path[::-1])

    def getShortestUnprocessedIndex(self, dists, proc):
        min_index = 0
        while(proc[min_index]):
            min_index += 1
        for i in range(min_index, self.size):
            if proc[i]:
                continue
            if dists[i]<dists[min_index]:
                min_index = i
        return min_index


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

if __name__=='__main__':
    main()
