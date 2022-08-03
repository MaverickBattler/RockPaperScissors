
var scoreUser = 0
var scoreComputer = 0

val options = arrayOf("rock", "paper", "scissors")

// Get the computer choice
fun getComputerChoice() : String = options[(Math.random() * options.size).toInt()]

// Get the user choice and check input for correctness
fun getUserChoice() : String {
    while (true) {
        var userChoice = readLine() // User inputs their choice
        if (userChoice != null) {
            // Lowercase the input to ignore the character case when comparing it
            userChoice = userChoice.lowercase()
            for (option in options) {
                // Check if user input is one of the choices or the keyword "quit"
                if (userChoice == option  || userChoice == "quit")
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
        "rock" -> when (userChoice) {
            "rock" ->  gameResult = "Tie"
            "paper" -> gameResult =  "User"
            "scissors" -> gameResult = "Computer"
        }
        "paper" -> when (userChoice) {
            "rock" -> gameResult = "Computer"
            "paper" -> gameResult = "Tie"
            "scissors" -> gameResult = "User"
        }
        "scissors" -> when (userChoice) {
            "rock" -> gameResult = "User"
            "paper" -> gameResult = "Computer"
            "scissors" -> gameResult = "Tie"
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
    println("Make your choice: enter \"rock\", \"paper\" or \"scissors\"")
    println("To exit enter \"quit\"")
    while (gameContinues) {
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