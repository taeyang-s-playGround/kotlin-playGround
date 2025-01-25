package scul.projectscul.global.error.dto

import com.example.kotlinpractice.global.error.GlobalErrorCode
import com.example.kotlinpractice.global.error.dto.CustomFieldError
import com.example.kotlinpractice.global.error.exception.ErrorProperty
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.validation.BindingResult
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ConstraintViolationException

data class ErrorResponse(
    val status: Int,
    val message: String,
    val fieldErrors: List<CustomFieldError>
) {
    companion object {
        fun of(errorCode: ErrorProperty) = ErrorResponse(
            status = errorCode.status(),
            message = errorCode.message(),
            fieldErrors = emptyList()
        )

        fun of(bindingResult: BindingResult): ErrorResponse = of(
            exception = GlobalErrorCode.BAD_REQUEST,
            fieldErrors = CustomFieldError.Companion.of(bindingResult)
        )

        fun of(exception: ConstraintViolationException): ErrorResponse {
            val fieldErrors = exception.constraintViolations.flatMap { violation ->
                val path = violation.propertyPath
                val field = path.last().name
                val message = violation.message
                CustomFieldError.Companion.of(field, "", message)
            }

            return of(
                exception = GlobalErrorCode.BAD_REQUEST,
                fieldErrors = fieldErrors
            )
        }

        fun of(exception: MethodArgumentTypeMismatchException): ErrorResponse {
            val value = exception.value
            val fieldErrors = CustomFieldError.Companion.of(exception.name, value.toString(), exception.errorCode)

            return of(
                exception = GlobalErrorCode.BAD_REQUEST,
                fieldErrors = fieldErrors
            )
        }

        fun of(exception: DataIntegrityViolationException): ErrorResponse = of(
            exception = GlobalErrorCode.BAD_REQUEST,
            fieldErrors = CustomFieldError.Companion.of("", "", exception.message ?: "")
        )

        private fun of(exception: ErrorProperty, fieldErrors: List<CustomFieldError>) = ErrorResponse(
            status = exception.status(),
            message = exception.message(),
            fieldErrors = fieldErrors
        )
    }
}