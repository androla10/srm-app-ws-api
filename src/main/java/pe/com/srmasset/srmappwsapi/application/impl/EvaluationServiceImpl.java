package pe.com.srmasset.srmappwsapi.application.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pe.com.srmasset.srmappwsapi.application.EvaluationService;
import pe.com.srmasset.srmappwsapi.application.dto.ResponseEvaluationDTO;
import pe.com.srmasset.srmappwsapi.application.enumeration.TypeOfEvaluationEnum;
import pe.com.srmasset.srmappwsapi.application.utils.Constants;
import pe.com.srmasset.srmappwsapi.domain.Evaluation;
import pe.com.srmasset.srmappwsapi.infrastructure.persistence.EvaluationRepository;

import javax.persistence.PersistenceException;
import java.math.BigDecimal;

/**
 * <h1>EvaluationServiceImpl Class</h1>
 * <p>
 *     Class responsible for implementing the methods specified in the EvaluationService interface
 * </p>
 *
 * @author Zeler Benji Villarreal Marcelo
 * @since 10/11/2018
 * @version 1.0.0
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final Logger LOGGER = LoggerFactory.getLogger(EvaluationServiceImpl.class);

    private final EvaluationRepository evaluationRepository;

    public EvaluationServiceImpl(EvaluationRepository evaluationRepository){
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public ResponseEvaluationDTO calculateEvaluation(Evaluation evaluation) {
        try{
            LOGGER.debug("Insert to database...");

            BigDecimal porcInterest = BigDecimal.ZERO;

            if(evaluation.getTypeOfEvaluation().compareTo(TypeOfEvaluationEnum.TYPE_B.getValue()) == Constants.INT_0){
                porcInterest = new BigDecimal(Constants.INT_10);
            }
            else if(evaluation.getTypeOfEvaluation().compareTo(TypeOfEvaluationEnum.TYPE_C.getValue()) == Constants.INT_0){
                porcInterest = new BigDecimal(Constants.INT_20);
            }

            evaluation.setPorcInterest(porcInterest);
            evaluationRepository.addEvaluation(evaluation);
            ResponseEvaluationDTO responseEvaluationDTO = new ResponseEvaluationDTO();
            responseEvaluationDTO.setStatusCode(Constants.INT_200);
            responseEvaluationDTO.setMessage(Constants.SUCCESS);
            return responseEvaluationDTO;
        }catch (PersistenceException e){
            LOGGER.error("An error occurred when inserting the database :: error message {}", e.getMessage());
            return null;
        }
    }
}
