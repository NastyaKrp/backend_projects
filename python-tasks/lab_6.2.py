import numpy as np
import matplotlib.pyplot as plt

# Определение параметрических функций для эвольвенты эллипса
def x(t, a, b):
    return ((np.cos(t))**3) * (a**2 - b**2) / a

def y(t, a, b):
    return ((np.sin(t))**3) * (a**2 - b**2) / b

t_values = np.linspace(0, 2 * np.pi, 1000)

plt.plot(x(t_values, 2, 1), y(t_values, 2, 1), label='Эвольвента эллипса', color='blue')


plt.grid(True, linestyle='--', alpha=0.5)


plt.xlabel('x')
plt.ylabel('y')


plt.title('Эвольвента эллипса')

# Отображение графика
plt.legend()
plt.show()
