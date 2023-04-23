package by.vsu.bank.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@AllArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private Long resourceId;

    public String getMessage() {
        return resourceName == null || resourceId == null ? null :
                "Resource %s not found with id %d".formatted(resourceName, resourceId);
    }

}
