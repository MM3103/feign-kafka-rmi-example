package common.dto.patterns.interpreter;

public class UpperExpression implements Expression {
    private String s;
    public UpperExpression(String s) {
        this.s = s;
    }
    public String interpret(Context context) {
        return context.getUpperCase(s);
    }
}
