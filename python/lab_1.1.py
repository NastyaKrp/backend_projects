def fibonacci_sequence(n):
    sequence = []
    if n <= 0:
        return sequence
    elif n == 1:
        sequence.append(0)
        return sequence
    elif n == 2:
        sequence.extend([0, 1])
        return sequence
    else:
        sequence.extend([0, 1])
        for i in range(2, n):
            next_number = sequence[-1] + sequence[-2]
            sequence.append(next_number)
        return sequence

def main():
    n_str = input("Введите натуральное число n: ")
    try:
        n = int(n_str)
        if n <= 0:
            print("Число должно быть натуральным.")
            return
        fibonacci = fibonacci_sequence(n)
        print("Последовательность Фибоначчи из", n, "элементов:", fibonacci)
    except ValueError:
        print("Ошибка: введено некорректное число.")

if __name__ == "__main__":
    main()
