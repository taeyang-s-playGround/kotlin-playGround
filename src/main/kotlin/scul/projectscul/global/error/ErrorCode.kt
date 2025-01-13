package com.example.kotlinpractice.global.error

import com.example.kotlinpractice.global.error.exception.ErrorProperty


enum class ErrorCode (
    private val status: Int,
    private val message: String
) : ErrorProperty {
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    INVALID_TOKEN(401,"Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),

    EMAIL_CODE_MISS_MATCH(400, "Email Code Miss Match"),
    EMAIL_NOT_FOUND(404, "Email Not Found"),
    EMAIL_ALREADY_EXISTS(409, "Email Already Exists"),

    PASSWORD_MIS_MATCH(400, "Password Miss Match"),
    USER_NOT_FOUND(404, "User Not Found"),
    USER_ALREADY_EXISTS(409, "User Already Exists"),

    INVALID_IMAGE_FORMAT(400, "Invalid Image Format"),

    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found");

    override fun message(): String = message
    override fun status(): Int = status
}