package model;



import lombok.Data;

@Data
public class LogData {

    public LogData(){

    }

    private String application;
    private String logDetails;
    private String dateTime;
}
