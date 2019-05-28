package com.tencent.p177mm.p209c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.c.h */
public final class C25999h {
    /* renamed from: b */
    public static int m41491b(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(125706);
        if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.m2505o(125706);
            return -1;
        }
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            File file2 = new File(str3);
            File file3 = new File(str2);
            if (file.exists() && file3.exists()) {
                int i;
                C32429a cL = C32429a.m53086cL(str);
                if (cL == null || cL.cdb == null) {
                    i = 0;
                } else {
                    i = cL.cdb.cde + 8;
                    System.out.println("MicroMsg.MergePatchApk:extLen = ".concat(String.valueOf(i)));
                }
                if (C37625d.m63546a(randomAccessFile, file2, file3, i) != 1) {
                    System.out.println("MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
                    randomAccessFile.close();
                    AppMethodBeat.m2505o(125706);
                    return -1;
                }
                randomAccessFile.close();
                if (str4.equalsIgnoreCase(C25998g.m41489cz(str3))) {
                    C37624b c37624b = new C37624b();
                    c37624b.apkMd5 = str4;
                    new C32429a(c37624b).mo53071x(file2);
                    AppMethodBeat.m2505o(125706);
                    return 0;
                }
                AppMethodBeat.m2505o(125706);
                return -2;
            }
            System.err.println("MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=" + file.exists() + ", newFile.exists()=" + file2.exists() + ", patch.exists()=" + file3.exists());
            randomAccessFile.close();
            AppMethodBeat.m2505o(125706);
            return -1;
        } catch (Exception e) {
            System.out.println("MicroMsg.MergePatchApk:Exception in merge()");
            AppMethodBeat.m2505o(125706);
            return -1;
        }
    }
}
