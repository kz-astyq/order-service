package kz.astyq.orderservice.core.exception.dto;

import kz.astyq.orderservice.core.util.ErrorCode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private ErrorCode code;
    private String message;
    private String status;
}
