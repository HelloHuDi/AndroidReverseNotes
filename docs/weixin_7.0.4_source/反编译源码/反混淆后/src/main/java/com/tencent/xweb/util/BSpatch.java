package com.tencent.xweb.util;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import org.xwalk.core.Log;

public class BSpatch {
    public native int nativeDoPatch(String str, String str2, String str3);

    /* renamed from: aH */
    public static int m25217aH(String str, String str2, String str3) {
        AppMethodBeat.m2504i(3999);
        Log.m81049i("BSpatch", "doPatch oldFile:" + str + ",patchFile:" + str2 + ",newFile:" + str3);
        long currentTimeMillis = System.currentTimeMillis();
        C24532f.dVh();
        Object obj = null;
        if (str.equals(str3)) {
            str3 = str + ".temp";
            obj = 1;
        }
        int nativeDoPatch = new BSpatch().nativeDoPatch(str, str2, str3);
        if (nativeDoPatch < 0) {
            Log.m81049i("BSpatch", "doPatch failed");
            C24532f.dVi();
        } else {
            Log.m81049i("BSpatch", "doPatch successful");
            if (obj != null) {
                if (C41131b.copyFile(str3, str)) {
                    C41131b.deleteFile(str3);
                } else {
                    Log.m81046e("BSpatch", "doPatch same path, copy failed");
                    AppMethodBeat.m2505o(3999);
                    return -1;
                }
            }
            C24532f.m38188nP(System.currentTimeMillis() - currentTimeMillis);
        }
        AppMethodBeat.m2505o(3999);
        return nativeDoPatch;
    }

    static {
        AppMethodBeat.m2504i(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED);
        C1449k.m3079a("bspatch_utils", BSpatch.class.getClassLoader());
        AppMethodBeat.m2505o(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED);
    }
}
