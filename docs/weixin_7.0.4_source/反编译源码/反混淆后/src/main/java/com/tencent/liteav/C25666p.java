package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.p */
public class C25666p {
    /* renamed from: a */
    public static C45110n m40716a(Context context, int i) {
        AppMethodBeat.m2504i(66364);
        C45110n c45110n = null;
        if (i == 2 || i == 4 || i == 4 || i == 6 || i == 3) {
            TXCLog.m15676e("TXSDKUtil", "create player error not support type : ".concat(String.valueOf(i)));
        } else {
            c45110n = new C41693e(context);
        }
        AppMethodBeat.m2505o(66364);
        return c45110n;
    }

    /* renamed from: a */
    public static String m40717a() {
        return "";
    }
}
