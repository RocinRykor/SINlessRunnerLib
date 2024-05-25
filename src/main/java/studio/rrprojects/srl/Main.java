package studio.rrprojects.srl;

import studio.rrprojects.srl.creation.priority.PriorityController;
import studio.rrprojects.srl.generators.MatrixHostGenerator;
import studio.rrprojects.util_library.TextUtils;

public class Main {

    public static void main(String[] args) {
        MatrixHostGenerator matrixHostGenerator = new MatrixHostGenerator();

        for (int i = 0; i < 10; i++) {
            System.out.println(matrixHostGenerator.MatrixAccessProtocolBuilder());
        }
    }
}
