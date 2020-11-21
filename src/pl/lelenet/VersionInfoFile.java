package pl.lelenet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VersionInfoFile {

    private String friendlyName;
    private String gameVersion;
    private final File file;

    public VersionInfoFile(String folderPath) {
        file = new File(folderPath + "/versionInfo.txt");
    }

    public Version getVersion() throws FileNotFoundException {
        readValues();
        return new Version(file.getParentFile().getName(), friendlyName, gameVersion);
    }

    private void readValues() throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        friendlyName = fileReader.nextLine();
        gameVersion = fileReader.nextLine();
        fileReader.close();
    }
}
