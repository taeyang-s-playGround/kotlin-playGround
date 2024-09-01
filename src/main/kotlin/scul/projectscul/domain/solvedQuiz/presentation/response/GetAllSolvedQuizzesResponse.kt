package scul.projectscul.domain.solvedQuiz.presentation.response

import java.time.LocalDateTime

data class GetAllSolvedQuizzesResponse(
        val quizzes: List<QuizDto>
) {
        data class QuizDto(
                val id: Long,
                val quiz: String,
                val answer: String,
                val reason: String,
        )
}