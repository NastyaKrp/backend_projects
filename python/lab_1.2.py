def calculate_day_to_reach_target(x, y):
    day = 1
    distance = x
    while distance < y:
        distance += distance * 0.1  # увеличиваем пробег на 10% от предыдущего значения
        day += 1
    return day

def main():
    x_str = input("Введите пробег спортсмена в первый день, км: ")
    y_str = input("Введите желаемый пробег, км: ")
    try:
        x = float(x_str)
        y = float(y_str)
        if x <= 0 or y <= 0:
            print("Пробег и желаемый пробег должны быть положительными числами.")
            return
        day_to_reach_target = calculate_day_to_reach_target(x, y)
        print("Спортсмен достигнет пробега не менее", y, "километров на", day_to_reach_target, "день.")
    except ValueError:
        print("Ошибка: введено некорректное число.")

if __name__ == "__main__":
    main()
