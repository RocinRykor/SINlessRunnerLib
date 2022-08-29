package studio.rrprojects.srl;

import studio.rrprojects.srl.matrix.MatrixController;
import studio.rrprojects.srl.matrix.utilities.CyberDeckUtility;
import studio.rrprojects.util_library.DebugUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MatrixController controller = new MatrixController();


        List<CyberDeckUtility> deckUtils = controller.getMasterListCyberdeckUtilities();

        for (CyberDeckUtility utility : deckUtils) {
            DebugUtils.ProgressNormalMsg(utility.toString());
        }
    }
}
