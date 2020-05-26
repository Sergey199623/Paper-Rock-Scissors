import java.awt.Choice
import java.util.*

fun main(args: Array<String>) {

    val options = arrayOf("Paper", "Rock", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)

}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>) : String {
    var isValidChoice = false
    var userChoice = ""

    //Выполняем цикл, пока пользователь не введет допустимый вариант
    while (!isValidChoice) {

        //Запросить у пользователя его выбор
        print("Please enter one of the following:")
        for (item in optionsParam) print(" $item")
        println(".")

        //Читаем пользовательский ввод
        val userInput = readLine()

        //Проверяем пользовательсткий ввод
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
        //Если пользователь ввел недопустимый вариант, сообщить пользователю
        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String

    //Определяем результат

    if(userChoice == gameChoice) result = "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper")) result = "You win!"
    else result = "You losw!"

    //Выводим результат

    println("You chose $userChoice. I chose $gameChoice. $result")
}
