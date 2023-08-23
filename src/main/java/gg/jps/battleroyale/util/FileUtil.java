package gg.jps.battleroyale.util;

import gg.jps.battleroyale.BattleRoyale;

import java.io.File;

public final class FileUtil {

    public static File getFolderFromPath(String folderName) {
        return new File(BattleRoyale.getInstance().getDataFolder() + File.separator + folderName);
    }

}
