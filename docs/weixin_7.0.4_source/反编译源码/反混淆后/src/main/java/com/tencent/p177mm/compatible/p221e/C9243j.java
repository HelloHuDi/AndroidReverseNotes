package com.tencent.p177mm.compatible.p221e;

import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.compatible.e.j */
final class C9243j implements C32469a {
    C9243j() {
    }

    /* renamed from: b */
    public static C32470a m16776b(Looper looper) {
        AppMethodBeat.m2504i(92932);
        C32470a c32470a = new C32470a();
        try {
            c32470a.erH = C41939u.m74076c(looper);
            c32470a.rotate = 0;
            if (c32470a.erH == null) {
                AppMethodBeat.m2505o(92932);
                return null;
            }
            if (Build.DISPLAY.startsWith("Flyme")) {
                c32470a.rotate = 90;
                c32470a.erH.setDisplayOrientation(90);
            } else {
                int i;
                if (Build.MODEL.equals("M9")) {
                    String str = Build.DISPLAY;
                    if (str.substring(0, 0).equals("1")) {
                        i = -1;
                    } else {
                        String[] split = str.split("-");
                        if (split == null || split.length < 2) {
                            i = -1;
                        } else {
                            i = C5046bo.getInt(split[1], 0);
                        }
                    }
                } else {
                    i = -1;
                }
                if (i >= 7093) {
                    c32470a.rotate = 90;
                    c32470a.erH.setDisplayOrientation(180);
                }
            }
            AppMethodBeat.m2505o(92932);
            return c32470a;
        } catch (Exception e) {
            AppMethodBeat.m2505o(92932);
            return null;
        }
    }
}
