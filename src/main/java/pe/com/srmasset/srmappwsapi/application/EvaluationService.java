package pe.com.srmasset.srmappwsapi.application;

import pe.com.srmasset.srmappwsapi.application.dto.ResponseEvaluationDTO;
import pe.com.srmasset.srmappwsapi.domain.Evaluation;

/**
 * <h1>Evaluation service</h1>
 * <p>
 *  Interface responsible for specifying methods at the evaluation service level.
 * </p>
 * @author Zeler Benji Villarreal Marcelo
 * @since 10/11*2018
 * @version 1.0.0
 */
public interface EvaluationService {
    ResponseEvaluationDTO calculateEvaluation(Evaluation evaluation);
}
