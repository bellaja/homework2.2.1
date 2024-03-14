package ru.netology

fun main() {
    transferAmountCalculator(75_000, "Mastercard")
    transferAmountCalculator(75_001, "Mastercard")
    transferAmountCalculator(160_000, "Mastercard")
    transferAmountCalculator(3000, "Visa")
    transferAmountCalculator(5000, "Visa")
    transferAmountCalculator(160_000, "Visa")
    transferAmountCalculator(150_000, "Мир")
    transferAmountCalculator(160_000, "Мир")
}

fun transferAmountCalculator(
    amount: Int,
    cardType: String = "Visa",
    previousTransfer: Int = 0
) {
    val totalTransfer = amount + previousTransfer
    var comission = 0
    val minComission = 35
    when (cardType) {

        "Mastercard" -> if (totalTransfer <= 150_000 /*||totalTransfer <= 600_000*/) {
            comission = (amount * 0.6 / 100 + 20).toInt()
            if (amount > 75_000) {
                println("Сумма перевода равна ${amount + comission} рублей.")
            } else {
                println("Сумма перевода равна $amount рублей.")
            }
        } else {
            println("Операция заблокирована, превышен лимит перевода!")
        }

        "Visa" -> if (totalTransfer <= 150_000 /*|| totalTransfer <= 600_000*/) {
            comission = (amount * 0.75 / 100).toInt()
            if (comission <= minComission) {
                println("Сумма перевода равна ${amount + minComission} рублей.")
            } else {
                println("Сумма перевода равна ${amount + comission} рублей.")
            }
        } else {
            println("Операция заблокирована, превышен лимит перевода!")
        }

        "Мир" -> if (totalTransfer <= 150_000 /*|| totalTransfer <= 600_000*/) {
            println("Сумма перевода равна $amount рублей.")
        } else {
            println("Операция заблокирована, превышен лимит перевода!")
        }
    }
}