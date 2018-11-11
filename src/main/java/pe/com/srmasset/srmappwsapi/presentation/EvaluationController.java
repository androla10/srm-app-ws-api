package pe.com.srmasset.srmappwsapi.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.srmasset.srmappwsapi.application.EvaluationService;
import pe.com.srmasset.srmappwsapi.application.dto.RequestEvaluationDTO;
import pe.com.srmasset.srmappwsapi.application.dto.ResponseEvaluationDTO;
import pe.com.srmasset.srmappwsapi.application.exceptions.InvalidParametersException;
import pe.com.srmasset.srmappwsapi.application.utils.Constants;
import pe.com.srmasset.srmappwsapi.application.utils.EndPoint;
import pe.com.srmasset.srmappwsapi.presentation.internal.EvaluationAssembler;

/**
 * <h1>Controller Evaluation</h1>
 * <p>
 * Controller class of http requests for evaluation service.
 * </p>
 *
 * @author Zeler Benji Villarreal Marcelo
 * @since 10/11/2018
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping(value = EndPoint.URL_API)
public class EvaluationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EvaluationController.class);

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService){
        this.evaluationService = evaluationService;
    }

    /**
     * Method Calculate Evaluation
     *
     * @param requestEvaluationDTO
     * @return
     */
    @RequestMapping(value = EndPoint.URL_EVALUATION, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEvaluationDTO calculateEvaluation(@RequestBody RequestEvaluationDTO requestEvaluationDTO){
        try {
            return evaluationService.calculateEvaluation(EvaluationAssembler.model(requestEvaluationDTO));
        }
        catch (InvalidParametersException e){
            LOGGER.error(e.getMessage());
            return new ResponseEvaluationDTO(Constants.ERROR_400, e.getMessage());
        }
    }
}
