package studio.rrprojects.srl.constants;
import java.io.File;

public class FileConstants {
    //Resource Directories
    public static final String RESOURCE_JSON_DIR = File.separator + "JSON" + File.separator;

    public static final String RESOURCE_MISC = RESOURCE_JSON_DIR + "Misc" + File.separator;
    public static final String PRIORITY_TABLE_JSON = FileConstants.RESOURCE_MISC + "CORE_Priority_Table.json";

    public static final String RESOURCE_MATRIX = RESOURCE_JSON_DIR + "Matrix" + File.separator;
    public static final String CYBERDECK_JSON = RESOURCE_MATRIX + "Cyberdecks.json";
    public static final String CYBERDECK_UTILITIES = RESOURCE_MATRIX + "Cyberdeck_Utilities.json";
}
