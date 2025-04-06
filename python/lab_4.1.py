import numpy as np

def task_1(n):
    A = np.zeros((n, n), dtype=int)
    np.fill_diagonal(A, np.arange(-7, n - 7, 1))
    np.fill_diagonal(A[ :-1 , 1:], 4)
    A[3, : ] = -4

    E = np.eye(n, dtype=int)
    O = np.zeros((n, n), dtype=int)
    EXP = np.exp(A)

    R1 = np.concatenate((A, E), axis=1)
    R2 = np.concatenate((O, EXP), axis=1)
    R = np.concatenate((R1, R2), axis=0)

    return R


n = int(input("Введите размер матрицы "))
matrix = task_1(n)
np.savetxt("matrix.txt", matrix, fmt="%10.6f")







