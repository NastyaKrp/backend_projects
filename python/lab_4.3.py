import numpy as np
def sum_of_squares(path):
    matrix = np.loadtxt(path, delimiter='\t')
    result = np.sum(np.square(matrix[0, np.abs(matrix[0]) < 5]))
    print(result)


file_path = 'matr.txt'
sum_of_squares(file_path)