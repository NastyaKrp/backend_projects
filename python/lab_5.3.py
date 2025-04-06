import numpy as np
from numpy.linalg import norm, LinAlgError

def solve_linear_system(C, b=None):
    # Проверка на вырожденность матрицы C
    try:
        np.linalg.inv(C)
    except LinAlgError:
        raise ValueError("Матрица C является вырожденной и не имеет обратной.")

    if b is None:
        # Генерация случайного вектора b с равномерным распределением на [-1, -3]
        b = np.random.uniform(-1, -3, C.shape[0])

    # Решение системы уравнений
    x = np.linalg.solve(C, b)

    # Вычисление евклидовой нормы
    euclidean_norm = norm(x)

    return x, euclidean_norm


C_matrix = np.array([[2, 1], [1, -1]])
b_vector = np.array([1, -2])

solution, euclidean_norm = solve_linear_system(C_matrix, b_vector)
print("Решение:", solution)
print("Евклидова норма:", euclidean_norm)
