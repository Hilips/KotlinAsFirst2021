@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1


import kotlin.math.sqrt
import kotlin.math.pow

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {

    var flag: Boolean = true
    var numInNumber: Int = 0
    var number = n
    while (flag) {

        if (number > 9) {
            number /= 10
            numInNumber++
        }
        if (number <= 9) {
            numInNumber++
            flag = false
        }
    }
    return numInNumber

}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    if (n == 1 || n == 2) return 1
    else return fib(n - 1) + fib(n - 2)
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (i in 2..n)
        if (n % i == 0) return i
    return 0
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    for (i in n - 1 downTo 1 step 1)
        if (n % i == 0) return i
    return 0
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var num: Int = 0
    var n: Int = x
    var flag: Boolean = true
    if (x == 1) return 0
    while (flag) {

        if (n % 2 == 0) {
            n = n / 2
            num++
            if (n == 1) flag = false
        } else {
            n = 3 * n + 1
            num++
            if (n == 1) flag = false
        }
    }
    return num

}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var numM: Int = m
    var numN: Int = n
    var k: Int = if (numM > numN) numM else numM
    var flag: Boolean = true
    while (flag) {
        if (numM > numN) {
            if (k % numM == 0 && k % numN == 0) flag = false
            else k++
        } else if (numM < numN) {
            if (k % numM == 0 && k % numN == 0) flag = false
            else k++
        }
    }
    return k
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    fun seach(m: Int, n: Int): Boolean {
        for (i in 2..m)
            if (m % i == 0 && n % i == 0)
                return false
        return true
    }
    if (n > m) return seach(m, n)
    else return seach(n, m)
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    /*  fun Int.pow(x: Int): Int = (2..x).fold(this) { r, _ -> r * this }
    fun rev(n: Int, pos: Int){
        var num: Int = n
        var k: Int = pos
        if(num<10) {

            val ns = num*(10.pow(k))}
        return ns
    }

    var flag: Boolean = true
    var numInNumber: Int = 0
    var number = n

    while(flag)
    {

        if(number>9) {
            number /= 10
            numInNumber++
        }
        if(number<=9) {
            numInNumber ++
            flag = false
        }
    }
    numInNumber
    return 0
*/
    return 0
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean = TODO()

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */


fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {

    fun search(n: Int, pos: Int): Int {
        var tempCounter: Int = 0
        var tempNumber: Int = n * n
        while (true) {
            if (tempCounter == pos)
                return tempNumber % 10
            tempNumber /= 10
            tempCounter++
        }
    }

    var numberInNum: Int = 0
    var counter: Int = 1
    var temp: Int = 0
    var flag: Boolean = true
    var division: Boolean = true
    while (flag) {
        temp = counter
        temp *= temp
        while (division) {
            if (temp >= 1) {
                temp /= 10
                numberInNum++
            } else division = false
        }
        if (numberInNum >= n) {
            return (search(counter, numberInNum - n))
            flag = false
        }
        division = true
        counter++
    }
    return 0
}


/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {

    fun search(n: Int, pos: Int): Int {
        var tempCounter: Int = 0
        var tempNumber: Int = n
        while (true) {
            if (tempCounter == pos)
                return tempNumber % 10
            tempNumber /= 10
            tempCounter++
        }
    }

    var numberInNum: Int = 0
    var counter: Int = 1
    var temp: Int = 0
    var flag: Boolean = true
    var division: Boolean = true
    while (flag) {
        temp = fib(counter)
        while (division) {
            if (temp >= 1) {
                temp /= 10
                numberInNum++
            } else division = false
        }
        if (numberInNum >= n) {
            return (search(fib(counter), numberInNum - n))
            flag = false
        }
        division = true
        counter++
    }


    return 0
}
