package common.dto.patterns.interpreter;

public class Context {
    public String getLowerCase(String s){
        return s.toLowerCase();
    }
    public String getUpperCase(String s){
        return s.toUpperCase();
    }
}
