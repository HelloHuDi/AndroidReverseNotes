package com.tencent.p127d.p130d.p808a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p130d.p131b.C0920c;
import com.tencent.p127d.p130d.p131b.C37317a;
import com.tencent.p127d.p130d.p131b.C45082f;
import com.tencent.p127d.p135f.C45085h;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.d.d.a.f */
public final class C25598f {
    /* renamed from: af */
    private static boolean m40617af(File file) {
        AppMethodBeat.m2504i(114510);
        try {
            if ((C0920c.atS(file.getAbsolutePath()) & 2048) > 0) {
                AppMethodBeat.m2505o(114510);
                return true;
            }
            AppMethodBeat.m2505o(114510);
            return false;
        } catch (Exception e) {
            C45085h.m82713w(e);
            AppMethodBeat.m2505o(114510);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean dQn() {
        AppMethodBeat.m2504i(114511);
        if (C45082f.dQp()) {
            C45085h.dQG();
            AppMethodBeat.m2505o(114511);
            return false;
        }
        try {
            boolean z;
            String str = new String(C37317a.atR("/proc/mounts"));
            "SetuidBitChecker mounts : ".concat(String.valueOf(str));
            C45085h.dQH();
            String[] split = str.split(IOUtils.LINE_SEPARATOR_UNIX);
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str2 = split[i];
                if (str2.contains(" /system ")) {
                    if (str2.contains(",nosuid")) {
                        C45085h.dQG();
                        z = true;
                        if (z) {
                            AppMethodBeat.m2505o(114511);
                            return false;
                        } else if (C0920c.isAvailable()) {
                            File file;
                            File[] listFiles = new File("/system/bin").listFiles();
                            if (listFiles != null) {
                                length = listFiles.length;
                                i = 0;
                                while (i < length) {
                                    file = listFiles[i];
                                    if ("run-as".equals(file.getName()) || !C25598f.m40617af(file)) {
                                        i++;
                                    } else {
                                        new StringBuilder("SetuidBitChecker s-bit found : ").append(file.getAbsolutePath());
                                        C45085h.dQG();
                                        AppMethodBeat.m2505o(114511);
                                        return true;
                                    }
                                }
                            }
                            listFiles = new File("/system/xbin").listFiles();
                            if (listFiles != null) {
                                for (File file2 : listFiles) {
                                    if (C25598f.m40617af(file2)) {
                                        new StringBuilder("SetuidBitChecker s-bit found : ").append(file2.getAbsolutePath());
                                        C45085h.dQG();
                                        AppMethodBeat.m2505o(114511);
                                        return true;
                                    }
                                }
                            }
                            C45085h.dQG();
                            AppMethodBeat.m2505o(114511);
                            return false;
                        } else {
                            C45085h.dQG();
                            AppMethodBeat.m2505o(114511);
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
            C45085h.m82713w(e);
            AppMethodBeat.m2505o(114511);
            return false;
        }
    }
}
