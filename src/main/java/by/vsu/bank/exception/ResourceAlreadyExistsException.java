package by.vsu.bank.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ResourceAlreadyExistsException extends RuntimeException {

    private String resourceName;
    private Long resourceId;

    public String getMessage() {
        return resourceName == null || resourceId == null ?  null :
         "Resource '%s' already exists with id '%d'".formatted(resourceName, resourceId);
    }
}
