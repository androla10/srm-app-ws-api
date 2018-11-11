package pe.com.srmasset.srmappwsapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>DTO ResponseEvaluationDTO</h1>
 * <p>
 *   Object of data transfer as response of the service.
 * </p>
 * @author Zeler Benji Villarreal Marcelo
 * @since 10/11/2018
 * @version 1.0.0
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEvaluationDTO {
    private Integer statusCode;
    private String message;
}
