package com.bumptech.glide.p086c.p088b.p786c;

import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* renamed from: com.bumptech.glide.c.b.c.b */
final class C37167b {
    static int availableProcessors() {
        AppMethodBeat.m2504i(92027);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (VERSION.SDK_INT < 17) {
            availableProcessors = Math.max(C37167b.m62285ng(), availableProcessors);
        }
        AppMethodBeat.m2505o(92027);
        return availableProcessors;
    }

    /* renamed from: ng */
    private static int m62285ng() {
        int length;
        AppMethodBeat.m2504i(92028);
        File[] fileArr = null;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File("/sys/devices/system/cpu/");
            final Pattern compile = Pattern.compile("cpu[0-9]+");
            fileArr = file.listFiles(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    AppMethodBeat.m2504i(92026);
                    boolean matches = compile.matcher(str).matches();
                    AppMethodBeat.m2505o(92026);
                    return matches;
                }
            });
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            AppMethodBeat.m2505o(92028);
        }
        if (fileArr != null) {
            length = fileArr.length;
        } else {
            length = 0;
        }
        length = Math.max(1, length);
        AppMethodBeat.m2505o(92028);
        return length;
    }
}
