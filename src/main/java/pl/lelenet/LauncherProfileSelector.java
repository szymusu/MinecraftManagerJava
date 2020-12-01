package pl.lelenet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LauncherProfileSelector {

    private static final String lastUsed0 = "      \"lastUsed\" : \"0\",\n";
    private static final String lastUsedLater = "      \"lastUsed\" : \"2020-10-20T20:32:14.199Z\",\n";

    public static void selectProfile(String lastVersionId) {
        File file = new File(Main.MINECRAFT_FOLDER + "launcher_profiles.json");
        try {
            String line;
            int replaceLineIndex = 0;
            List<String> lines = new ArrayList<>();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains("lastUsed")) {
                    line = lastUsed0;
                }
                lines.add(line);
                if (line.contains(lastVersionId)) {
                    replaceLineIndex = lines.size() - 2;
                }
            }
            fr.close();
            br.close();

            if (replaceLineIndex != 0) {
                lines.set(replaceLineIndex, lastUsedLater);
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            for (String s : lines) {
                out.write(s.replace("\n", ""));
                out.newLine();
            }
            out.flush();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
