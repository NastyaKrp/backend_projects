import random

def swap_min_max(lst):
    if len(lst) < 2:
        return lst

    min_index = lst.index(min(lst))
    max_index = lst.index(max(lst))

    lst[min_index], lst[max_index] = lst[max_index], lst[min_index]
    return lst

def main():
    try:
        n = int(input("Введите размер списка: "))
        if n <= 0:
            print("Размер списка должен быть положительным числом.")
            return
        # Создаем случайный список чисел
        random_list = [random.randint(1, 100) for _ in range(n)]
        print("Исходный список:", random_list)
        # Меняем местами первый минимальный и первый максимальный элементы
        modified_list = swap_min_max(random_list)
        print("Список после замены минимального и максимального элементов:", modified_list)
    except ValueError:
        print("Ошибка: введено некорректное число.")

if __name__ == "__main__":
    main()
