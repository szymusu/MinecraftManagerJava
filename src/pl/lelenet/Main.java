package pl.lelenet;

public class Main {

    public static void main(String[] args) {
        var v = Version.add(
                new Version("mods_fabric", "Literally just OptiFine", "1.8.9"));
        v.run();
    }
}
