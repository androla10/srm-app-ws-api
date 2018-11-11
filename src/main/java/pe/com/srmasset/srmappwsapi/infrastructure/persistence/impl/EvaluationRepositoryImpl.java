package pe.com.srmasset.srmappwsapi.infrastructure.persistence.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.com.srmasset.srmappwsapi.domain.Evaluation;
import pe.com.srmasset.srmappwsapi.infrastructure.persistence.EvaluationRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * <h2>EvaluationRepository Implements</h2>
 * <p>
 *   Class responsible for implementing the methods given by the EvaluationRepository interface.
 * </p>
 * @author Zeler Benji Villarreal Marcelo
 * @since 10/11/2018
 * @version 1.0.0
 */
@Transactional
@Repository
public class EvaluationRepositoryImpl implements EvaluationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEvaluation(Evaluation evaluation) {
        entityManager.persist(evaluation);
    }
}
