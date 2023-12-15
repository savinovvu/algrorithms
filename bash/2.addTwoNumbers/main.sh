#!/bin/bash

# Функция для преобразования числа в обратный порядок
reverse_number() {
    num=$1
    rev=0
    while [ $num -gt 0 ]
    do
        # Получить последнюю цифру числа
        last_digit=$((num % 10))

        # Добавить последнюю цифру к обратному числу
        rev=$((rev * 10 + last_digit))

        # Удалить последнюю цифру из числа
        num=$((num / 10))
    done
    echo $rev
}

# Функция для сложения двух чисел
add_numbers() {
    num1=$(reverse_number $1)
    num2=$(reverse_number $2)
    sum=$((num1 + num2))
    echo $(reverse_number $sum)
}

# Пример использования
add_numbers 243 564
