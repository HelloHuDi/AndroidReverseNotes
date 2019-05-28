package com.tencent.xweb.util;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import org.xwalk.core.Log;

public class BSpatch {
    public native int nativeDoPatch(String str, String str2, String str3);

    public static int aH(String str, String str2, String str3) {
        AppMethodBeat.i(3999);
        Log.i("BSpatch", "doPatch oldFile:" + str + ",patchFile:" + str2 + ",newFile:" + str3);
        long currentTimeMillis = System.currentTimeMillis();
        f.dVh();
        Object obj = null;
        if (str.equals(str3)) {
            str3 = str + ".temp";
            obj = 1;
        }
        int nativeDoPatch = new BSpatch().nativeDoPatch(str, str2, str3);
        if (nativeDoPatch < 0) {
            Log.i("BSpatch", "doPatch failed");
            f.dVi();
        } else {
            Log.i("BSpatch", "doPatch successful");
            if (obj != null) {
                if (b.copyFile(str3, str)) {
                    b.deleteFile(str3);
                } else {
                    Log.e("BSpatch", "doPatch same path, copy failed");
                    AppMethodBeat.o(3999);
                    return -1;
                }
            }
            f.nP(System.currentTimeMillis() - currentTimeMillis);
        }
        AppMethodBeat.o(3999);
        return nativeDoPatch;
    }

    static {
        AppMethodBeat.i(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED);
        k.a("bspatch_utils", BSpatch.class.getClassLoader());
        AppMethodBeat.o(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED);
    }
}
