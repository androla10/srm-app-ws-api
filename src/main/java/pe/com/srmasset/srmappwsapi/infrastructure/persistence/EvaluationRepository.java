package pe.com.srmasset.srmappwsapi.infrastructure.persistence;

import pe.com.srmasset.srmappwsapi.domain.Evaluation;

/**
 * <h1>Interface EvaluationRepository</h1>
 * <p>
 *  Interface responsible for declaring the methods for data access.
 * </p>
 * @author Zeler Benji Villarreal Marcelo
 * @since 10/11/2018
 * @version 1.0.0
 */
public interface EvaluationRepository{
    /**
     * Method responsible for recording an evaluation.
     * @param evaluation
     *
     */
    void addEvaluation(Evaluation evaluation);
}
