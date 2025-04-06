import numpy as np

# Определение матрицы A
A = np.array([
    [-7.0, 4.0, 0.0, 0.0, 0.0, 0.0, 0.0],
    [0.0, -6.0, 4.0, 0.0, 0.0, 0.0, 0.0],
    [0.0, 0.0, -5.0, 4.0, 0.0, 0.0, 0.0],
    [-4.0, -4.0, -4.0, -4.0, -4.0, -4.0, -4.0],
    [0.0, 0.0, 0.0, 0.0, -3.0, 4.0, 0.0],
    [0.0, 0.0, 0.0, 0.0, 0.0, -2.0, 4.0],
    [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -1.0]
])

# Нахождение собственных значений и собственных векторов
eigenvalues, eigenvectors = np.linalg.eig(A)

# Индекс наименьшего по модулю собственного значения
min_index = np.argmin(np.abs(eigenvalues))

# Выбор наименьшего по модулю собственного значения и соответствующего вектора
lambda_min = eigenvalues[min_index]
x_min = eigenvectors[:, min_index]

# Проверка условия Ax = λ * x
check_condition = np.allclose(A.dot(x_min), lambda_min * x_min)


print("Собственные значения:", eigenvalues)
print("Собственные векторы:")
print(eigenvectors)
print(f"Наименьшее по модулю собственное значение: λ = {lambda_min}")
print(f"Соответствующий вектор: x = {x_min}")
print("Проверка условия Ax = λ * x:", check_condition)
