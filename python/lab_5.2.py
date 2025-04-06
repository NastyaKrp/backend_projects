import numpy as np
import matplotlib.pyplot as plt
from numpy.polynomial import Polynomial
from scipy.integrate import quad

def f(x):
    return x**7

# Определение скалярного произведения
# Определение функции scalar_product(f, g),
# которая вычисляет скалярное произведение двух функций f и g
# на отрезке [0, 1] с использованием численного интегрирования.

def scalar_product(f, g):
    integrand = lambda x: f(x) * g(x)
    result, _ = quad(integrand, 0, 1)
    return result

# Построение матрицы системы уравнений
# Построение матрицы matrix, элементы которой вычисляются как скалярные произведения базисных полиномов степени i и j.
# Polynomial.basis(deg=j) - создается базисный полином степени j.
matrix = np.array([[scalar_product(Polynomial.basis(deg=i), Polynomial.basis(deg=j)) for j in range(6)] for i in range(6)])

# Построение вектора правой части системы уравнений
rhs = np.array([scalar_product(f, Polynomial.basis(deg=i)) for i in range(6)])

# Решение системы линейных уравнений для нахождения коэффициентов
coefficients = np.linalg.solve(matrix, rhs)

# Построение полинома наилучшего среднеквадратичного приближения
approximation = Polynomial(coefficients)

# Вывод коэффициентов разложения
print("Коэффициенты разложения:", coefficients)

# Построение графика функции x^7 и приближения
x_vals = np.linspace(0, 1, 100)
y_vals_exact = f(x_vals)
y_vals_approx = approximation(x_vals)

plt.plot(x_vals, y_vals_exact, label='x^7')
plt.plot(x_vals, y_vals_approx, label='Приближение', linestyle='dashed')
plt.legend()
plt.title('Наилучшее среднеквадратичное приближение')
plt.xlabel('x')
plt.ylabel('y')
plt.show()
