package scul.projectscul.domain.solvedQuiz.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scul.projectscul.domain.solvedQuiz.domain.repository.SolvedQuizRepository
import scul.projectscul.domain.solvedQuiz.presentation.response.GetAllSolvedQuizzesResponse

@Service
@Transactional(readOnly = true)
class GetAllSolvedQuizzesService(
    private val userQuizSolveRepository: SolvedQuizRepository
) {

    fun execute() = GetAllSolvedQuizzesResponse(
        quizzes = userQuizSolveRepository.findAll().map { userQuizSolve ->

            GetAllSolvedQuizzesResponse.QuizDto(
                id = userQuizSolve.quiz.id,
                quiz = userQuizSolve.quiz.quiz,
                answer = userQuizSolve.quiz.answer,
                reason = userQuizSolve.quiz.reason
            )
        }
    )
}
