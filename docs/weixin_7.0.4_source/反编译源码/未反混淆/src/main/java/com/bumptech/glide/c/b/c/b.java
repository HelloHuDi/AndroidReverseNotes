package com.bumptech.glide.c.b.c;

import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

final class b {
    static int availableProcessors() {
        AppMethodBeat.i(92027);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (VERSION.SDK_INT < 17) {
            availableProcessors = Math.max(ng(), availableProcessors);
        }
        AppMethodBeat.o(92027);
        return availableProcessors;
    }

    private static int ng() {
        int length;
        AppMethodBeat.i(92028);
        File[] fileArr = null;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File("/sys/devices/system/cpu/");
            final Pattern compile = Pattern.compile("cpu[0-9]+");
            fileArr = file.listFiles(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    AppMethodBeat.i(92026);
                    boolean matches = compile.matcher(str).matches();
                    AppMethodBeat.o(92026);
                    return matches;
                }
            });
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            AppMethodBeat.o(92028);
        }
        if (fileArr != null) {
            length = fileArr.length;
        } else {
            length = 0;
        }
        length = Math.max(1, length);
        AppMethodBeat.o(92028);
        return length;
    }
}
