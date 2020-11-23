package pl.lelenet;

import pl.lelenet.UI.Option;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Version implements Option {

    private final String folderName;
    private final String friendlyName;
    private final String gameVersion;
    private final String lastVersionId;

    public Version(String folderName, String friendlyName, String gameVersion, String lastVersionId) {
        this.folderName = folderName;
        this.friendlyName = friendlyName;
        this.gameVersion = gameVersion;
        this.lastVersionId = lastVersionId;
    }

    public static List<Option> getVersionOptions() throws IOException {
        List<Option> options = new ArrayList<>();
        List<Path> folders = FileManager.getDirContents(FileManager.stringToPath(Main.autoModsFolder));
        for (Path folder : folders) {
            try {
                var infoFile = new VersionInfoFile(folder.toString());
                options.add(infoFile.getVersion());
            }
            catch (FileNotFoundException | NoSuchElementException ignored) { }
        }
        return options;
    }

    private void prepareFiles() {
        try {
            FileManager.deleteContents(Main.modsFolder);
            FileManager.copyContents(Main.autoModsFolder + this.folderName, Main.modsFolder);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        prepareFiles();
        LauncherProfileSelector.selectProfile(lastVersionId);

        try {
            Runtime.getRuntime().exec("minecraft-launcher");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return friendlyName + "\t\t\t\t" + gameVersion;
    }
}
