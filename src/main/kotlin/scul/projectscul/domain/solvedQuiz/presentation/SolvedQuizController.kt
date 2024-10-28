package scul.projectscul.domain.solvedQuiz.presentation

import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import scul.projectscul.domain.solvedQuiz.presentation.response.GetAllSolvedQuizzesResponse
import scul.projectscul.domain.solvedQuiz.presentation.response.GetLastSolvedQuizResponse
import scul.projectscul.domain.solvedQuiz.service.GetAllSolvedQuizzesService
import scul.projectscul.domain.solvedQuiz.service.GetLastQuizListService
import java.util.*

@RequestMapping("/scul/quizzes")
@RestController
class SolvedQuizController(
    private val getLastQuizListService: GetLastQuizListService,
    private val getAllSolvedQuizzesService: GetAllSolvedQuizzesService
) {
    @GetMapping("/solved/{user-id}")
    fun getLastQuizList(
        @PathVariable("user-id") @NotNull userId: UUID
    ): GetLastSolvedQuizResponse {
        return getLastQuizListService.execute(userId)
    }

    @GetMapping("/list")
    fun getAllSolvedQuizzes(): GetAllSolvedQuizzesResponse {
        return getAllSolvedQuizzesService.execute()
    }
}
