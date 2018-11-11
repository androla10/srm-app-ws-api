package pe.com.srmasset.srmappwsapi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.com.srmasset.srmappwsapi.application.EvaluationService;
import pe.com.srmasset.srmappwsapi.application.dto.RequestEvaluationDTO;
import pe.com.srmasset.srmappwsapi.application.dto.ResponseEvaluationDTO;
import pe.com.srmasset.srmappwsapi.application.enumeration.TypeOfEvaluationEnum;
import pe.com.srmasset.srmappwsapi.application.exceptions.InvalidParametersException;
import pe.com.srmasset.srmappwsapi.presentation.internal.EvaluationAssembler;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SrmAppWsApiApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SrmAppWsApiApplicationTests.class);

    private RequestEvaluationDTO requestEvaluationDTO;

    @Before
    public void before(){
        requestEvaluationDTO = new RequestEvaluationDTO();
        requestEvaluationDTO.setClientName("Zeler Benji");
        requestEvaluationDTO.setLimCredit(new BigDecimal(1500));
        requestEvaluationDTO.setTypeOfEvaluation(TypeOfEvaluationEnum.TYPE_B.getValue());
    }

    @Autowired
    private EvaluationService evaluationService;

    @Test
    public void addEvaluation() {
        try{
            ResponseEvaluationDTO responseEvaluationDTO = evaluationService.calculateEvaluation(EvaluationAssembler.model(requestEvaluationDTO));
            Assert.assertNotNull(responseEvaluationDTO);
        }catch (InvalidParametersException e){
            LOGGER.error(e.getMessage());
            Assert.assertTrue(false);
        }
    }

}
