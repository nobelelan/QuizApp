package com.example.quizapp

object Constants{

    const val USER_NAME: String = "userName"
    const val TOTAL_QUESTIONS: String = "totalQuestion"
    const val CORRECT_ANSWERS: String = "correctAnswers"

    fun getQuestions(): ArrayList<Question>{
        val questionList= ArrayList<Question>()

        val que1 = Question(
            id = 1,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_argentina,
            optionOne = "Pakistan",
            optionTwo = "Argentina",
            optionThree = "Brasil",
            optionFour = "Australia",
            correctAnswer = 2
        )
        questionList.add(que1)

        val que2 = Question(
            id = 2,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_australia,
            optionOne = "Germany",
            optionTwo = "England",
            optionThree = "Australia",
            optionFour = "Romania",
            correctAnswer = 3
        )
        questionList.add(que2)

        val que3 = Question(
            id = 3,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_belgium,
            optionOne = "Kuwait",
            optionTwo = "England",
            optionThree = "Belgium",
            optionFour = "Poland",
            correctAnswer = 3
        )
        questionList.add(que3)

        val que4 = Question(
            id = 4,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_brazil,
            optionOne = "Brazil",
            optionTwo = "Austria",
            optionThree = "Netherland",
            optionFour = "India",
            correctAnswer = 1
        )
        questionList.add(que4)

        val que5 = Question(
            id = 5,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_denmark,
            optionOne = "Pakistan",
            optionTwo = "Japan",
            optionThree = "Austria",
            optionFour = "Denmark",
            correctAnswer = 4
        )
        questionList.add(que5)

        val que6 = Question(
            id = 6,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_fiji,
            optionOne = "Hulululu",
            optionTwo = "Fiji",
            optionThree = "China",
            optionFour = "Bangladesh",
            correctAnswer = 2
        )
        questionList.add(que6)

        val que7 = Question(
            id = 7,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_germany,
            optionOne = "Germany",
            optionTwo = "Srilanka",
            optionThree = "India",
            optionFour = "United States",
            correctAnswer = 1
        )
        questionList.add(que7)

        val que8 = Question(
            id = 8,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_india,
            optionOne = "Bangladesh",
            optionTwo = "Pakistan",
            optionThree = "India",
            optionFour = "Australia",
            correctAnswer = 3
        )
        questionList.add(que8)

        val que9 = Question(
            id = 9,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_kuwait,
            optionOne = "Bangladesh",
            optionTwo = "Australia",
            optionThree = "Pakistan",
            optionFour = "Kuwait",
            correctAnswer = 4
        )
        questionList.add(que9)

        val que10 = Question(
            id = 10,
            question = "What country does this flag belong to?",
            image = R.drawable.ic_flag_of_new_zealand,
            optionOne = "Austria",
            optionTwo = "England",
            optionThree = "Peru",
            optionFour = "New Zealand",
            correctAnswer = 4
        )
        questionList.add(que10)

        return  questionList
    }
}