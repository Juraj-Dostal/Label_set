import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        int zVrcholaU = 19;
        int doVrcholaV = 422;
        String name = "pr1.hrn";

        Input input = new Input();
        input.readData(name);

        LabelSet labelSet = new LabelSet(zVrcholaU, input);
        labelSet.najdiNajkratsieCesty();
        labelSet.vypisNajkratsiuCestu(doVrcholaV);
    }
}
