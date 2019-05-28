package com.tencent.mm.loader.j;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;

public class b {
    public static final String eSi;
    public static final String eSj = (eSi + "MicroMsg/");
    public static final String eSk = (eSi + "files/public/");
    public static String eSl = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String eSm = "/tencent/MicroMsg/";
    public static String eSn = (eSl + eSm);
    public static String eSo = (eSn + "crash/");

    static {
        Context context = ah.getContext();
        if (context == null) {
            throw new RuntimeException("MMApplicationContext not initialized.");
        }
        eSi = context.getFilesDir().getParentFile().getAbsolutePath() + "/";
        try {
            File file = new File(eSj);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Error e) {
        }
    }
}
