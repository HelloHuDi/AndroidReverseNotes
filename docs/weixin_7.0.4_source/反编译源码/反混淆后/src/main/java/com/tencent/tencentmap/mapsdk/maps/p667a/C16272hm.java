package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.io.File;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hm */
public class C16272hm {
    /* renamed from: a */
    public static boolean m24958a(String str, String str2) {
        AppMethodBeat.m2504i(99555);
        File file = new File(str);
        File file2 = new File(str2);
        if (file2.exists()) {
            C16272hm.m24956a(file2);
        }
        boolean renameTo = file.renameTo(new File(str2));
        AppMethodBeat.m2505o(99555);
        return renameTo;
    }

    /* renamed from: a */
    public static long m24956a(File file) {
        long j = 0;
        AppMethodBeat.m2504i(99556);
        if (file == null || !file.exists()) {
            AppMethodBeat.m2505o(99556);
        } else {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File a : listFiles) {
                        j += C16272hm.m24956a(a);
                    }
                }
            } else {
                j = file.length();
            }
            File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
            file.renameTo(file2);
            file2.delete();
            AppMethodBeat.m2505o(99556);
        }
        return j;
    }

    /* renamed from: a */
    public static String m24957a(Context context) {
        AppMethodBeat.m2504i(99557);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(99557);
            return str;
        }
        try {
            str = context.getPackageName();
            if (str == null || str.length() == 0) {
                str = "";
                AppMethodBeat.m2505o(99557);
                return str;
            } else if (str.length() > 255) {
                str = str.substring(0, C31128d.MIC_PTU_ZIPAI_LIGHTRED);
                AppMethodBeat.m2505o(99557);
                return str;
            } else {
                AppMethodBeat.m2505o(99557);
                return str;
            }
        } catch (Exception e) {
            str = "";
            AppMethodBeat.m2505o(99557);
            return str;
        }
    }
}
