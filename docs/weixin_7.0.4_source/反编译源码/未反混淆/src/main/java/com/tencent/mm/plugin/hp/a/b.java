package com.tencent.mm.plugin.hp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.c.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.RandomAccessFile;

public final class b {
    public static int b(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(90546);
        if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.o(90546);
            return -1;
        }
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            File file2 = new File(str3);
            e.cx(str3);
            File file3 = new File(str2);
            if (file.exists() && file3.exists()) {
                int i = 0;
                a cL = a.cL(str);
                if (!(cL == null || cL.cdb == null)) {
                    i = cL.cdb.cde + 8;
                    ab.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:extLen = %d", Integer.valueOf(i));
                }
                if (d.a(randomAccessFile, file2, file3, i) != 1) {
                    ab.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
                    randomAccessFile.close();
                    AppMethodBeat.o(90546);
                    return -1;
                }
                randomAccessFile.close();
                if (str4.equalsIgnoreCase(g.cz(str3))) {
                    com.tencent.mm.c.b bVar = new com.tencent.mm.c.b();
                    bVar.apkMd5 = str4;
                    new a(bVar).x(file2);
                    AppMethodBeat.o(90546);
                    return 0;
                }
                ab.i("MicroMsg.Tinker.MergeBsDiffApk", "newApkMd5:%s file md5:%s", str4, g.cz(str3));
                AppMethodBeat.o(90546);
                return -2;
            }
            ab.e("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=%s , newFile.exists()=%s , patch.exists()=%s ", Boolean.valueOf(file.exists()), Boolean.valueOf(file2.exists()), Boolean.valueOf(file3.exists()));
            randomAccessFile.close();
            AppMethodBeat.o(90546);
            return -1;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Tinker.MergeBsDiffApk", e, "merge apk failed.", new Object[0]);
            AppMethodBeat.o(90546);
            return -1;
        }
    }
}
