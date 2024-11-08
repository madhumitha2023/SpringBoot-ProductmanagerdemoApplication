package co.pragra.learning.productmanagerdemo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorDto {
    private final int errorCode;
    private final String errorMessage;
    private final Date timestamp;
}
