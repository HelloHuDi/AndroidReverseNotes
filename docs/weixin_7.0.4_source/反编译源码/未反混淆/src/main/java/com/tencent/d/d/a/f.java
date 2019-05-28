package com.tencent.d.d.a;

import com.tencent.d.d.b.a;
import com.tencent.d.d.b.c;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.IOException;

public final class f {
    private static boolean af(File file) {
        AppMethodBeat.i(114510);
        try {
            if ((c.atS(file.getAbsolutePath()) & 2048) > 0) {
                AppMethodBeat.o(114510);
                return true;
            }
            AppMethodBeat.o(114510);
            return false;
        } catch (Exception e) {
            h.w(e);
            AppMethodBeat.o(114510);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean dQn() {
        AppMethodBeat.i(114511);
        if (com.tencent.d.d.b.f.dQp()) {
            h.dQG();
            AppMethodBeat.o(114511);
            return false;
        }
        try {
            boolean z;
            String str = new String(a.atR("/proc/mounts"));
            "SetuidBitChecker mounts : ".concat(String.valueOf(str));
            h.dQH();
            String[] split = str.split(IOUtils.LINE_SEPARATOR_UNIX);
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str2 = split[i];
                if (str2.contains(" /system ")) {
                    if (str2.contains(",nosuid")) {
                        h.dQG();
                        z = true;
                        if (z) {
                            AppMethodBeat.o(114511);
                            return false;
                        } else if (c.isAvailable()) {
                            File file;
                            File[] listFiles = new File("/system/bin").listFiles();
                            if (listFiles != null) {
                                length = listFiles.length;
                                i = 0;
                                while (i < length) {
                                    file = listFiles[i];
                                    if ("run-as".equals(file.getName()) || !af(file)) {
                                        i++;
                                    } else {
                                        new StringBuilder("SetuidBitChecker s-bit found : ").append(file.getAbsolutePath());
                                        h.dQG();
                                        AppMethodBeat.o(114511);
                                        return true;
                                    }
                                }
                            }
                            listFiles = new File("/system/xbin").listFiles();
                            if (listFiles != null) {
                                for (File file2 : listFiles) {
                                    if (af(file2)) {
                                        new StringBuilder("SetuidBitChecker s-bit found : ").append(file2.getAbsolutePath());
                                        h.dQG();
                                        AppMethodBeat.o(114511);
                                        return true;
                                    }
                                }
                            }
                            h.dQG();
                            AppMethodBeat.o(114511);
                            return false;
                        } else {
                            h.dQG();
                            AppMethodBeat.o(114511);
                            return false;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                } else {
                    i++;
                }
            }
            z = false;
            if (z) {
            }
        } catch (IOException e) {
            h.w(e);
            AppMethodBeat.o(114511);
            return false;
        }
    }
}
