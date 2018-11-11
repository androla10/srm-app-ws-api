package pe.com.srmasset.srmappwsapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <h1>DTO RequestEvaluationDTO</h1>
 * <p>
 *   Class responsible for mapping the data model of the requests.
 * </p>
 * @author Zeler Benji Villarreal Marcelo
 * @since 10/11/2018
 * @version 1.0.0
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestEvaluationDTO {
    private String clientName;
    private BigDecimal limCredit;
    private String typeOfEvaluation;
}
