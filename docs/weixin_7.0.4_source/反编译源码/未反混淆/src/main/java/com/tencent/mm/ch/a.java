package com.tencent.mm.ch;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class a {
    public static String asQ(String str) {
        AppMethodBeat.i(116368);
        String str2 = e.evi + String.format("%s%d.%s", new Object[]{"wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), str});
        AppMethodBeat.o(116368);
        return str2;
    }

    public static int bu(float f) {
        AppMethodBeat.i(116369);
        int i = (int) ((ah.getContext().getResources().getDisplayMetrics().density * f) + 0.5f);
        AppMethodBeat.o(116369);
        return i;
    }

    public static int a(Options options, int i, int i2) {
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
        AppMethodBeat.i(116370);
        ab.i("MicroMsg.MMPhotoEditUtil", "[deleteDirAllFile] dir:%s", str);
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isFile() && !bo.isNullOrNil(file2.getName()) && file2.getName().startsWith("wx_photo_edit_")) {
                        file2.delete();
                    }
                    i++;
                }
            }
        }
        AppMethodBeat.o(116370);
    }
}
