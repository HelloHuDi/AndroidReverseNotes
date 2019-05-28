package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* renamed from: com.tencent.smtt.utils.y */
public class C5822y {
    /* renamed from: a */
    private static File f1434a = null;

    /* renamed from: a */
    public static long m8882a() {
        AppMethodBeat.m2504i(65344);
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        AppMethodBeat.m2505o(65344);
        return availableBlocks;
    }

    @TargetApi(9)
    /* renamed from: a */
    public static boolean m8883a(Context context) {
        AppMethodBeat.m2504i(65345);
        if (context == null) {
            AppMethodBeat.m2505o(65345);
            return false;
        } else if (f1434a == null) {
            try {
                if (context.getApplicationInfo().processName.contains("com.tencent.mm")) {
                    File dir = context.getDir("tbs", 0);
                    if (dir == null || !dir.isDirectory()) {
                        AppMethodBeat.m2505o(65345);
                        return false;
                    }
                    File file = new File(dir, "share");
                    if (file.isDirectory() || file.mkdir()) {
                        f1434a = file;
                        file.setExecutable(true, false);
                        AppMethodBeat.m2505o(65345);
                        return true;
                    }
                    AppMethodBeat.m2505o(65345);
                    return false;
                }
                AppMethodBeat.m2505o(65345);
                return false;
            } catch (Exception e) {
                AppMethodBeat.m2505o(65345);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(65345);
            return true;
        }
    }
}
