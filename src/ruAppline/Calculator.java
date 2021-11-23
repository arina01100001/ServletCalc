package ruAppline;

import java.io.Serializable;

public class Calculator implements Serializable {
    private double x;
    private double y;
    private String procedure;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public Calculator(double x, double y, String procedure) {
        this.x = x;
        this.y = y;
        this.procedure = procedure;
    }

    public Serializable calc() {
        if (procedure == "-") {
            return x - y;
        } else if (procedure == "+") {
            return x + y;
        } else if (procedure == "*") {
            return x * y;
        } else if (procedure == "/") {
            return x / y;
        } else {
            String string = "Ne podderjivaemaya operaciya";
            return string;
        }
    }
}
