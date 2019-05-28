package com.tencent.d.d.a;

import android.text.TextUtils;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;

public final class e {
    public static boolean dQm() {
        AppMethodBeat.i(114509);
        try {
            String str = System.getenv("PATH");
            if (TextUtils.isEmpty(str)) {
                for (String file : str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                    File file2 = new File(file, "su");
                    if (file2.exists()) {
                        new StringBuilder("SuFile found : ").append(file2.toString());
                        h.dQG();
                        AppMethodBeat.o(114509);
                        return true;
                    }
                }
            } else if (new File("/system/bin/su").exists()) {
                h.dQG();
                AppMethodBeat.o(114509);
                return true;
            } else if (new File("/system/xbin/su").exists()) {
                h.dQG();
                AppMethodBeat.o(114509);
                return true;
            }
        } catch (Throwable th) {
            h.w(th);
        }
        h.dQG();
        AppMethodBeat.o(114509);
        return false;
    }
}
