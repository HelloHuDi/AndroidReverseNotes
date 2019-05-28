package com.tencent.p127d.p130d.p808a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p135f.C45085h;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;

/* renamed from: com.tencent.d.d.a.e */
public final class C17726e {
    public static boolean dQm() {
        AppMethodBeat.m2504i(114509);
        try {
            String str = System.getenv("PATH");
            if (TextUtils.isEmpty(str)) {
                for (String file : str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                    File file2 = new File(file, "su");
                    if (file2.exists()) {
                        new StringBuilder("SuFile found : ").append(file2.toString());
                        C45085h.dQG();
                        AppMethodBeat.m2505o(114509);
                        return true;
                    }
                }
            } else if (new File("/system/bin/su").exists()) {
                C45085h.dQG();
                AppMethodBeat.m2505o(114509);
                return true;
            } else if (new File("/system/xbin/su").exists()) {
                C45085h.dQG();
                AppMethodBeat.m2505o(114509);
                return true;
            }
        } catch (Throwable th) {
            C45085h.m82713w(th);
        }
        C45085h.dQG();
        AppMethodBeat.m2505o(114509);
        return false;
    }
}
