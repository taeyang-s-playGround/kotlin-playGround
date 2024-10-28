package scul.projectscul.domain.quiz.presentation

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import scul.projectscul.domain.quiz.presentation.request.SolveQuizRequest
import scul.projectscul.domain.quiz.presentation.response.GetQuizResponse
import scul.projectscul.domain.quiz.service.GetQuizService
import scul.projectscul.domain.quiz.service.SolveQuizService
import javax.validation.Valid
import javax.validation.constraints.Positive

@RequestMapping("/scul/quizzes")
@RestController
@Validated
class QuizController(
    private val getQuizService: GetQuizService,
    private val solveQuizService: SolveQuizService,
) {

    @GetMapping("/{id}")
    fun getQuiz(
        @Valid
        @Positive(message = "1이상이여야합니다.")
        @PathVariable
        id: Long,
    ): GetQuizResponse = getQuizService.execute(id)

    @PostMapping("solve/{id}")
    fun solveQuiz(
        @Valid
        @Positive(message = "1이상이여야합니다.")
        @PathVariable
        id: Long,
        @Valid
        @RequestBody
        req: SolveQuizRequest
    ): Boolean = solveQuizService.execute(req, id)
}
