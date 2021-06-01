package pl.lelenet;

import pl.lelenet.UI.Option;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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
        List<Path> folders = FileManager.getDirContents(FileManager.stringToPath(Main.AUTO_MODS_FOLDER));
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
            FileManager.deleteContents(Main.MODS_FOLDER);
            FileManager.copyContents(Main.AUTO_MODS_FOLDER + this.folderName, Main.MODS_FOLDER);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean versionAlreadyThere() {
        var currentInfoFile = new VersionInfoFile(Main.MODS_FOLDER);
        try {
            if (currentInfoFile.getVersion().equals(this)) return true;
        }
        catch (FileNotFoundException ignored) { }
        return false;
    }

    public void run() {
        if (!versionAlreadyThere())
        {
            prepareFiles();
        }
        LauncherProfileSelector.selectProfile(lastVersionId);

        Main.launchLauncher();
    }

    @Override
    public String toString() {
        return friendlyName + "\t\t\t\t" + gameVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Version version = (Version) o;
        return Objects.equals(folderName, version.folderName) && Objects.equals(friendlyName, version.friendlyName)
         && Objects.equals(gameVersion, version.gameVersion) && Objects.equals(lastVersionId, version.lastVersionId);
    }
}
