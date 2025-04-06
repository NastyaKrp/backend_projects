import numpy as np
import matplotlib.pyplot as plt

def y(t):
    return np.sqrt(1 - np.exp(t)) + np.sqrt(np.sqrt(1 - t**2))

def z(t):
    return (t * np.log(np.abs(t))) / (1 + t**4)

def w(t):
    return z(t) - y(t)

t_values = np.linspace(-2, 2, 400)

plt.plot(t_values, y(t_values), label='y(t)', color='blue', linestyle='-', marker='o')
plt.plot(t_values, z(t_values), label='z(t)', color='green', linestyle='--', marker='s')
plt.plot(t_values, w(t_values), label='w(t)', color='red', linestyle='-.', marker='^')


plt.legend()


plt.xlabel('t')
plt.ylabel('Function values')


plt.title('Graphs of y(t), z(t), and w(t)')

plt.grid(True)
plt.show()
