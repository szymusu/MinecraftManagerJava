package pl.lelenet;

import pl.lelenet.UI.Option;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Version implements Option {

    private static final List<Version> versions = new ArrayList<>();
    private static final String minecraftFolder = "/home/_m/.minecraft/";
    private static final String modsFolder = minecraftFolder + "mods/";
    private static final String autoModsFolder = minecraftFolder + "auto_mods/";

    private String folderName;
    private String friendlyName;
    private String gameVersion;

    public Version(String folderName, String friendlyName, String gameVersion) {
        this.folderName = folderName;
        this.friendlyName = friendlyName;
        this.gameVersion = gameVersion;
    }

    private static void add(Version version) {
        versions.add(version);
    }

    public static List<Option> getVersionOptions() throws IOException {
        List<Option> options = new ArrayList<>();
        List<Path> folders = FileManager.getDirContents(FileManager.stringToPath(autoModsFolder));
        for (Path folder : folders) {
            try {
                var infoFile = new VersionInfoFile(folder.toString());
                options.add(infoFile.getVersion());
            }
            catch (FileNotFoundException ignored) { }
        }
        return options;
    }
    public static Version getVersion(int index) {
        return versions.get(index);
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    private void prepareFiles() {
        try {
            FileManager.deleteContents(modsFolder);
            FileManager.copyContents(autoModsFolder + this.folderName, modsFolder);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        prepareFiles();

        try {
            Runtime.getRuntime().exec("minecraft-launcher");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return friendlyName + "\t\t\t" + gameVersion;
    }
}
