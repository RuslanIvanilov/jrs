package ru.s7.stuff;

public class FileReport {

    private String description;
    private String extencion;

    public FileReport(String description, String extencion){
        this.description = description;
        this.extencion = extencion;
    }

    public String getDescription(){ return description; }
    public String getExtencion(){  return extencion; }

}
