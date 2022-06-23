package studio.rrprojects.srl;

import studio.rrprojects.srl.matrix.MatrixController;
import studio.rrprojects.util_library.DebugUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MatrixController controller = new MatrixController();

        List<String> deckList = controller.getListDeckNameOfficial();
        DebugUtils.ProgressNormalMsg(deckList.toString());

        for (String deckModel : deckList) {
            DebugUtils.VariableMsg(controller.getCyberDeckFromModel(deckModel) + "\n\n");
        }

    }
}
