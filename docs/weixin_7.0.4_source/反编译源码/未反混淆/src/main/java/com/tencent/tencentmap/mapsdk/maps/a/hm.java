package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import java.io.File;

public class hm {
    public static boolean a(String str, String str2) {
        AppMethodBeat.i(99555);
        File file = new File(str);
        File file2 = new File(str2);
        if (file2.exists()) {
            a(file2);
        }
        boolean renameTo = file.renameTo(new File(str2));
        AppMethodBeat.o(99555);
        return renameTo;
    }

    public static long a(File file) {
        long j = 0;
        AppMethodBeat.i(99556);
        if (file == null || !file.exists()) {
            AppMethodBeat.o(99556);
        } else {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File a : listFiles) {
                        j += a(a);
                    }
                }
            } else {
                j = file.length();
            }
            File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
            file.renameTo(file2);
            file2.delete();
            AppMethodBeat.o(99556);
        }
        return j;
    }

    public static String a(Context context) {
        AppMethodBeat.i(99557);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(99557);
            return str;
        }
        try {
            str = context.getPackageName();
            if (str == null || str.length() == 0) {
                str = "";
                AppMethodBeat.o(99557);
                return str;
            } else if (str.length() > 255) {
                str = str.substring(0, d.MIC_PTU_ZIPAI_LIGHTRED);
                AppMethodBeat.o(99557);
                return str;
            } else {
                AppMethodBeat.o(99557);
                return str;
            }
        } catch (Exception e) {
            str = "";
            AppMethodBeat.o(99557);
            return str;
        }
    }
}
