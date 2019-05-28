package com.tencent.p177mm.p1639ch;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.ch.a */
public final class C45281a {
    public static String asQ(String str) {
        AppMethodBeat.m2504i(116368);
        String str2 = C6457e.evi + String.format("%s%d.%s", new Object[]{"wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), str});
        AppMethodBeat.m2505o(116368);
        return str2;
    }

    /* renamed from: bu */
    public static int m83492bu(float f) {
        AppMethodBeat.m2504i(116369);
        int i = (int) ((C4996ah.getContext().getResources().getDisplayMetrics().density * f) + 0.5f);
        AppMethodBeat.m2505o(116369);
        return i;
    }

    /* renamed from: a */
    public static int m83491a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = 1;
        while (options.outWidth / i4 > i) {
            i4++;
        }
        while (i3 / i4 > i2) {
            i4++;
        }
        return i4;
    }

    public static void asR(String str) {
        int i = 0;
        AppMethodBeat.m2504i(116370);
        C4990ab.m7417i("MicroMsg.MMPhotoEditUtil", "[deleteDirAllFile] dir:%s", str);
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isFile() && !C5046bo.isNullOrNil(file2.getName()) && file2.getName().startsWith("wx_photo_edit_")) {
                        file2.delete();
                    }
                    i++;
                }
            }
        }
        AppMethodBeat.m2505o(116370);
    }
}
