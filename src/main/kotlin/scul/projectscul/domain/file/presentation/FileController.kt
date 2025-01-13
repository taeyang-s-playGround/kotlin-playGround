package scul.projectscul.domain.file.presentation

import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import scul.projectscul.infra.CreateImageUrlService
import scul.projectscul.domain.file.presentation.response.ImageUrlResponse

@RequestMapping("/files")
@RestController
class FileController(
    private val createImageUrlService: CreateImageUrlService
) {

    @PostMapping("/upload")
    fun uploadFile(@RequestPart(value = "image", required = false) multipartFiles : List<MultipartFile>): ImageUrlResponse {
        return createImageUrlService.execute(multipartFiles)
    }
}
