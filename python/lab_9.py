class Graph:

    # конструктор класса
    #
    # self.vertices cоздает
    # пустой словарь(`{}`), который
    # будет использоваться
    # для хранения вершин графа.
    # Ключи словаря - это вершины, а
    # значения - множества вершин, с
    # которыми они соединены ребрами.

    # self.edges Создает
    # пустое (множество(`set()`),
    # которое будет использоваться
    # для хранения ребер графа.
    # Ребро представляется
    # кортежем `(vertex1, vertex2)`,
    # где `vertex1` и `vertex2` - это
    # вершины, соединенные
    # ребром.Использование множества
    # для хранения ребер гарантирует, что
    # каждое ребро в графе уникально, и
    # не может быть дублировано.

    def __init__(self):
        self.vertices = {}
        self.edges = set()

    def add_vertex(self, vertex):
        if vertex not in self.vertices:
            self.vertices[vertex] = set()

    def add_edge(self, vertex1, vertex2):
        if vertex1 in self.vertices and vertex2 in self.vertices:
            self.vertices[vertex1].add(vertex2)
            self.vertices[vertex2].add(vertex1)
            self.edges.add((vertex1, vertex2))

    def remove_vertex(self, vertex):
        if vertex in self.vertices:
            adjacent_vertices = self.vertices[vertex].copy()
            for adjacent_vertex in adjacent_vertices:
                self.remove_edge(vertex, adjacent_vertex)
            del self.vertices[vertex]

    def remove_edge(self, vertex1, vertex2):
        if (vertex1, vertex2) in self.edges or (vertex2, vertex1) in self.edges:
            self.vertices[vertex1].remove(vertex2)
            self.vertices[vertex2].remove(vertex1)
            self.edges.discard((vertex1, vertex2))
            self.edges.discard((vertex2, vertex1))

    def contract_edge(self, vertex1, vertex2):
        if (vertex1, vertex2) in self.edges or (vertex2, vertex1) in self.edges:
            self.remove_edge(vertex1, vertex2)
            self.remove_vertex(vertex2)

    # перегружает стандартный метод
    # преобразования объекта в строку в
    # классе.Когда объект этого класса
    # передается в функцию str(), вызывается
    # именно этот метод.В данном случае, метод
    # формирует строку, представляющую
    # информацию о графе, чтобы ее
    # можно было легко прочитать или вывести.

    def __str__(self):
        result = "Vertices: {}\nEdges: {}".format(list(self.vertices.keys()), list(self.edges))
        return result

    def __add__(self, other):
        new_graph = Graph()

        # Добавляем вершины из первого графа
        for vertex in self.vertices:
            new_graph.add_vertex(vertex)

        # Добавляем ребра из первого графа
        for edge in self.edges:
            new_graph.add_edge(edge[0], edge[1])

        # Добавляем вершины из второго графа
        for vertex in other.vertices:
            new_graph.add_vertex(vertex)

        # Добавляем ребра из второго графа
        for edge in other.edges:
            new_graph.add_edge(edge[0], edge[1])

        return new_graph

# Демонстрация работы класса
graph = Graph()
graph.add_vertex("A")
graph.add_vertex("B")
graph.add_vertex("C")
graph.add_edge("A", "B")
graph.add_edge("B", "C")

print("Initial graph:")
print(graph)

graph.remove_edge("A", "B")
print("\nGraph after removing edge (A, B):")
print(graph)

graph.add_edge("A", "C")
print("\nGraph after adding edge (A, C):")
print(graph)

graph.remove_vertex("B")
print("\nGraph after removing vertex B:")
print(graph)

graph.contract_edge("A", "C")
print("\nGraph after contracting edge (A, C):")
print(graph)

# Выводим граф с использованием метода __str__
print("\nInformation about graph with using str:")
print(str(graph))


graph1 = Graph()
graph1.add_vertex("A")
graph1.add_vertex("B")
graph1.add_edge("A", "B")

graph2 = Graph()
graph2.add_vertex("C")
graph2.add_vertex("D")
graph2.add_edge("C", "D")

# Сложение графов
sum_graph = graph1 + graph2

print("Graph 1:")
print(graph1)

print("\nGraph 2:")
print(graph2)

print("\nSum of Graph 1 and Graph 2:")
print(sum_graph)
