package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.RandomAccessFile;

public final class h {
    public static int b(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(125706);
        if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.o(125706);
            return -1;
        }
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            File file2 = new File(str3);
            File file3 = new File(str2);
            if (file.exists() && file3.exists()) {
                int i;
                a cL = a.cL(str);
                if (cL == null || cL.cdb == null) {
                    i = 0;
                } else {
                    i = cL.cdb.cde + 8;
                    System.out.println("MicroMsg.MergePatchApk:extLen = ".concat(String.valueOf(i)));
                }
                if (d.a(randomAccessFile, file2, file3, i) != 1) {
                    System.out.println("MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
                    randomAccessFile.close();
                    AppMethodBeat.o(125706);
                    return -1;
                }
                randomAccessFile.close();
                if (str4.equalsIgnoreCase(g.cz(str3))) {
                    b bVar = new b();
                    bVar.apkMd5 = str4;
                    new a(bVar).x(file2);
                    AppMethodBeat.o(125706);
                    return 0;
                }
                AppMethodBeat.o(125706);
                return -2;
            }
            System.err.println("MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=" + file.exists() + ", newFile.exists()=" + file2.exists() + ", patch.exists()=" + file3.exists());
            randomAccessFile.close();
            AppMethodBeat.o(125706);
            return -1;
        } catch (Exception e) {
            System.out.println("MicroMsg.MergePatchApk:Exception in merge()");
            AppMethodBeat.o(125706);
            return -1;
        }
    }
}
