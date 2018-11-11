package pe.com.srmasset.srmappwsapi.application.enumeration;

public enum TypeOfEvaluationEnum {
    TYPE_A("TYPE_A"),
    TYPE_B("TYPE_B"),
    TYPE_C("TYPE_C");

    private String value;

    TypeOfEvaluationEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
