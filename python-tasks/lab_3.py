from math import acos


def f1():
    print("First task:")
    s = str(input("Enter string\n"))
    res = s.lower()
    print(res)



def f2():
    print("Second task:")
    c = int(input("Enter num\n"))
    num = ('ноль', 'один', 'два', 'три', 'четыре', 'пять', 'шесть', 'семь', 'восемь', 'девять')
    pi = str(acos(-1))[2:]

    print(f"{num[3]}.", end='')
    for i in pi[:c]:
        print(num[int(i)], end='|')




def f3():
    print("Third task:")
    txt = input("Enter txt: ")
    words = txt.split()

    min_word = min(words, key=len)
    max_word = max(words, key=len)

    words.remove(min_word)
    words.remove(max_word)

    new_txt = ' '.join(words)
    print("New text:", new_txt)


f3()