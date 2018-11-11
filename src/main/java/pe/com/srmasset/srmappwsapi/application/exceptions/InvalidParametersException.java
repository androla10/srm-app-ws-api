package pe.com.srmasset.srmappwsapi.application.exceptions;

/**
 * <h1>InvalidParametersException Class</h1>
 * <p>
 *  Custom exception for parameter validations.
 * </p>
 *
 * @author Zeler Benji Villarreal Marcelo
 * @since 10/11/2018
 * @version 1.0.0
 */
public class InvalidParametersException extends Exception{
    public InvalidParametersException(String message){
        super(message);
    }
}
