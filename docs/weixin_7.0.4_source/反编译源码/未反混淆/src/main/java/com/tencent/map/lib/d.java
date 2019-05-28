package com.tencent.map.lib;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class d {
    public static boolean a = false;

    public static void a(String str) {
        if (!a || str == null) {
        }
    }

    public static void a(String str, Throwable th) {
    }

    public static void b(String str) {
    }

    public static void c(String str) {
        AppMethodBeat.i(97859);
        if (a) {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), "xiaozhi.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(a() + " " + str + IOUtils.LINE_SEPARATOR_UNIX);
                fileWriter.flush();
                fileWriter.close();
                AppMethodBeat.o(97859);
                return;
            } catch (Exception e) {
                AppMethodBeat.o(97859);
                return;
            }
        }
        AppMethodBeat.o(97859);
    }

    private static String a() {
        AppMethodBeat.i(97860);
        String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
        AppMethodBeat.o(97860);
        return format;
    }
}
