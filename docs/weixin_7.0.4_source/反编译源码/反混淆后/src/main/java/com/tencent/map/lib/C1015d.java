package com.tencent.map.lib;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tencent.map.lib.d */
public class C1015d {
    /* renamed from: a */
    public static boolean f1210a = false;

    /* renamed from: a */
    public static void m2288a(String str) {
        if (!f1210a || str == null) {
        }
    }

    /* renamed from: a */
    public static void m2289a(String str, Throwable th) {
    }

    /* renamed from: b */
    public static void m2290b(String str) {
    }

    /* renamed from: c */
    public static void m2291c(String str) {
        AppMethodBeat.m2504i(97859);
        if (f1210a) {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), "xiaozhi.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(C1015d.m2287a() + " " + str + IOUtils.LINE_SEPARATOR_UNIX);
                fileWriter.flush();
                fileWriter.close();
                AppMethodBeat.m2505o(97859);
                return;
            } catch (Exception e) {
                AppMethodBeat.m2505o(97859);
                return;
            }
        }
        AppMethodBeat.m2505o(97859);
    }

    /* renamed from: a */
    private static String m2287a() {
        AppMethodBeat.m2504i(97860);
        String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
        AppMethodBeat.m2505o(97860);
        return format;
    }
}
