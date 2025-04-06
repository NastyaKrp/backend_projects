def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def lcm(a, b):
    return a * b // gcd(a, b)

def main():
    try:
        a = int(input("Введите первое натуральное число: "))
        b = int(input("Введите второе натуральное число: "))
        if a <= 0 or b <= 0:
            print("Числа должны быть натуральными.")
            return
        result = lcm(a, b)
        print("Наименьшее общее кратное чисел", a, "и", b, ":", result)
    except ValueError:
        print("Ошибка: введено некорректное число.")

if __name__ == "__main__":
    main()
