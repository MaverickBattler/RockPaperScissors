
var scoreUser = 0
var scoreComputer = 0

val options = arrayOf("rock", "paper", "scissors")

// Get the computer choice
fun getComputerChoice() : String = options[(Math.random() * options.size).toInt()]

// Get the user choice and check input for correctness
fun getUserChoice() : String {
    while (true) {
        val userChoice = readLine() // User inputs their choice
        if (userChoice != null) {
            for (option in options) {
                // Check if user input is one of the choices or the keyword "quit"
                if (userChoice.equals(option, true)  || userChoice.equals("quit", true))
                    return userChoice
            }
        }
        println("Please, enter one of the following: \"rock\", \"paper\", \"scissors\", or \"quit\"")
    }
}

// Decide the winner by the Rock-Paper-Scissors game rules
fun calculateGameResult(computerChoice: String, userChoice: String) {
    var gameResult = "Winner to be determined"
    println("Computer throws ${computerChoice.uppercase()}")
    println("You throw ${userChoice.uppercase()}")
    when (computerChoice) {
        "rock" -> when {
            userChoice.equals("rock", true) ->  gameResult = "Tie"
            userChoice.equals("paper", true) -> gameResult =  "User"
            userChoice.equals("scissors", true) -> gameResult = "Computer"
        }
        "paper" -> when {
            userChoice.equals("rock", true) -> gameResult = "Computer"
            userChoice.equals("paper", true) -> gameResult = "Tie"
            userChoice.equals("scissors", true) -> gameResult = "User"
        }
        "scissors" -> when {
            userChoice.equals("rock", true) -> gameResult = "User"
            userChoice.equals("paper", true) -> gameResult = "Computer"
            userChoice.equals("scissors", true) -> gameResult = "Tie"
        }
    }
    when (gameResult) {
        "Computer" -> {
            scoreComputer++
            println("Computer wins! Score:")
            println("Computer: $scoreComputer, You: $scoreUser")
        }
        "User" -> {
            scoreUser++
            println("You win! Score:")
            println("Computer: $scoreComputer, You: $scoreUser")
        }
        "Tie" -> {
            println("It's a tie! Score:")
            println("Computer: $scoreComputer, You: $scoreUser")
        }
        else -> println("Something went wrong, please try again!")
    }
}

fun main() {
    var gameContinues = true // Indicator whether the game continues
    while (gameContinues) {
        println("Make your choice: enter \"rock\", \"paper\" or \"scissors\"")
        println("To exit enter \"quit\"")
        val userChoice = getUserChoice() // User enters its choice
        if (!userChoice.equals("quit", true)) {
            val computerChoice = getComputerChoice() // Computer makes its choice
            // Calculate game results and print them
            calculateGameResult(computerChoice, userChoice)
            println("------------------------------------") // Ask user for his choice again
            println("Make your choice: enter \"rock\", \"paper\" or \"scissors\"")
        } else // If user decides to quit, finish the game
            gameContinues = false
    }
}