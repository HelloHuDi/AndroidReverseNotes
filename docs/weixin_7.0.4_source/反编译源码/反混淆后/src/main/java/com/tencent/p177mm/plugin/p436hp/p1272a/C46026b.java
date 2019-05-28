package com.tencent.p177mm.plugin.p436hp.p1272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p209c.C32429a;
import com.tencent.p177mm.p209c.C37624b;
import com.tencent.p177mm.p209c.C37625d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.plugin.hp.a.b */
public final class C46026b {
    /* renamed from: b */
    public static int m85592b(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(90546);
        if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.m2505o(90546);
            return -1;
        }
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            File file2 = new File(str3);
            C1173e.m2565cx(str3);
            File file3 = new File(str2);
            if (file.exists() && file3.exists()) {
                int i = 0;
                C32429a cL = C32429a.m53086cL(str);
                if (!(cL == null || cL.cdb == null)) {
                    i = cL.cdb.cde + 8;
                    C4990ab.m7417i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:extLen = %d", Integer.valueOf(i));
                }
                if (C37625d.m63546a(randomAccessFile, file2, file3, i) != 1) {
                    C4990ab.m7416i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
                    randomAccessFile.close();
                    AppMethodBeat.m2505o(90546);
                    return -1;
                }
                randomAccessFile.close();
                if (str4.equalsIgnoreCase(C1178g.m2587cz(str3))) {
                    C37624b c37624b = new C37624b();
                    c37624b.apkMd5 = str4;
                    new C32429a(c37624b).mo53071x(file2);
                    AppMethodBeat.m2505o(90546);
                    return 0;
                }
                C4990ab.m7417i("MicroMsg.Tinker.MergeBsDiffApk", "newApkMd5:%s file md5:%s", str4, C1178g.m2587cz(str3));
                AppMethodBeat.m2505o(90546);
                return -2;
            }
            C4990ab.m7413e("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=%s , newFile.exists()=%s , patch.exists()=%s ", Boolean.valueOf(file.exists()), Boolean.valueOf(file2.exists()), Boolean.valueOf(file3.exists()));
            randomAccessFile.close();
            AppMethodBeat.m2505o(90546);
            return -1;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Tinker.MergeBsDiffApk", e, "merge apk failed.", new Object[0]);
            AppMethodBeat.m2505o(90546);
            return -1;
        }
    }
}
