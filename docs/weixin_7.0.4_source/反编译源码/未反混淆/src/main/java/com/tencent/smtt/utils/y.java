package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class y {
    private static File a = null;

    public static long a() {
        AppMethodBeat.i(65344);
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        AppMethodBeat.o(65344);
        return availableBlocks;
    }

    @TargetApi(9)
    public static boolean a(Context context) {
        AppMethodBeat.i(65345);
        if (context == null) {
            AppMethodBeat.o(65345);
            return false;
        } else if (a == null) {
            try {
                if (context.getApplicationInfo().processName.contains("com.tencent.mm")) {
                    File dir = context.getDir("tbs", 0);
                    if (dir == null || !dir.isDirectory()) {
                        AppMethodBeat.o(65345);
                        return false;
                    }
                    File file = new File(dir, "share");
                    if (file.isDirectory() || file.mkdir()) {
                        a = file;
                        file.setExecutable(true, false);
                        AppMethodBeat.o(65345);
                        return true;
                    }
                    AppMethodBeat.o(65345);
                    return false;
                }
                AppMethodBeat.o(65345);
                return false;
            } catch (Exception e) {
                AppMethodBeat.o(65345);
                return false;
            }
        } else {
            AppMethodBeat.o(65345);
            return true;
        }
    }
}
