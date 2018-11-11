package pe.com.srmasset.srmappwsapi.presentation.internal;

import pe.com.srmasset.srmappwsapi.application.dto.RequestEvaluationDTO;
import pe.com.srmasset.srmappwsapi.application.enumeration.TypeOfEvaluationEnum;
import pe.com.srmasset.srmappwsapi.application.exceptions.InvalidParametersException;
import pe.com.srmasset.srmappwsapi.application.utils.Constants;
import pe.com.srmasset.srmappwsapi.domain.Evaluation;

import java.math.BigDecimal;

/**
 * Class responsible for converting the DTO to Model
 *
 * @author Zeler Benji villarreal Marcelo
 * @since 10/11/2018
 * @version 1.0.0
 */
public class EvaluationAssembler {

    public static Evaluation model(RequestEvaluationDTO requestEvaluationDTO) throws InvalidParametersException{
        if(requestEvaluationDTO.getClientName().compareTo(Constants.EMPTY) == Constants.INT_0){
            throw new InvalidParametersException(Constants.MESSAGE_PROPERTY_CLIENT_NAME_IS_EMPTY);
        }

        if(requestEvaluationDTO.getLimCredit().compareTo(new BigDecimal(Constants.INT_0)) == Constants.INT_0 ||
           requestEvaluationDTO.getLimCredit().compareTo(new BigDecimal(Constants.INT_0)) == Constants.INT_NEGATIVE_1
        ){
            throw new InvalidParametersException(Constants.MESSAGE_PROPERTY_LIMT_CREDIT_LESS_OR_ZERO);
        }
        if(requestEvaluationDTO.getTypeOfEvaluation().compareTo(TypeOfEvaluationEnum.TYPE_A.getValue()) != Constants.INT_0 &&
            requestEvaluationDTO.getTypeOfEvaluation().compareTo(TypeOfEvaluationEnum.TYPE_B.getValue()) != Constants.INT_0 &&
            requestEvaluationDTO.getTypeOfEvaluation().compareTo(TypeOfEvaluationEnum.TYPE_C.getValue()) != Constants.INT_0){
            throw new InvalidParametersException(Constants.MESSAGE_PROPERTY_TYPE_OF_EVALUATION_INVALID);
        }

        return new Evaluation(null, requestEvaluationDTO.getClientName(), requestEvaluationDTO.getLimCredit(),BigDecimal.ZERO, requestEvaluationDTO.getTypeOfEvaluation());
    }
}
