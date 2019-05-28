package com.tencent.p177mm.loader.p248j;

import android.content.Context;
import android.os.Environment;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.File;

/* renamed from: com.tencent.mm.loader.j.b */
public class C1761b {
    public static final String eSi;
    public static final String eSj = (eSi + "MicroMsg/");
    public static final String eSk = (eSi + "files/public/");
    public static String eSl = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String eSm = "/tencent/MicroMsg/";
    public static String eSn = (eSl + eSm);
    public static String eSo = (eSn + "crash/");

    static {
        Context context = C4996ah.getContext();
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
