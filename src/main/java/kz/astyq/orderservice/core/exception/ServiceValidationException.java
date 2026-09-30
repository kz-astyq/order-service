package kz.astyq.orderservice.core.exception;

import kz.astyq.orderservice.core.util.ErrorCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ServiceValidationException extends RuntimeException {
    private final ErrorCode errorCode;
    private Object[] arguments;
    public static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public ServiceValidationException(String message, ErrorCode errorCode, Object... arguments) {
        super(message);
        this.errorCode = errorCode;
        this.arguments = arguments;
    }

    public ServiceValidationException(ErrorCode code, Object... arguments) {
        this.errorCode = code;
        this.arguments = arguments;
    }
}
