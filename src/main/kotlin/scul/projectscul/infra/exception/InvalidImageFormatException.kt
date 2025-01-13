package scul.projectscul.infra.exception

import com.example.kotlinpractice.global.error.ErrorCode
import com.example.kotlinpractice.global.error.exception.BusinessException

object InvalidImageFormatException : BusinessException(
    ErrorCode.INVALID_IMAGE_FORMAT
)