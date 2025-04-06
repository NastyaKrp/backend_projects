import random

def positive_even_elements(lst):
    return [x for i, x in enumerate(lst) if i % 2 == 0 and x > 0]

def main():
    try:
        n = int(input("Введите размер списка: "))
        if n <= 0:
            print("Размер списка должен быть положительным числом.")
            return
        # Создаем случайный список чисел
        random_list = [random.randint(-100, 100) for _ in range(n)]
        print("Исходный список:", random_list)
        # Получаем новый список из положительных элементов исходного списка, стоящих на четных местах
        positive_even_list = positive_even_elements(random_list)
        if positive_even_list:
            print("Новый список из положительных элементов, стоящих на четных местах:", positive_even_list)
        else:
            print("В исходном списке нет положительных элементов, стоящих на четных местах.")
    except ValueError:
        print("Ошибка: введено некорректное число.")

if __name__ == "__main__":
    main()
