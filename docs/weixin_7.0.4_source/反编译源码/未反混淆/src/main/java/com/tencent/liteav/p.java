package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p {
    public static n a(Context context, int i) {
        AppMethodBeat.i(66364);
        n nVar = null;
        if (i == 2 || i == 4 || i == 4 || i == 6 || i == 3) {
            TXCLog.e("TXSDKUtil", "create player error not support type : ".concat(String.valueOf(i)));
        } else {
            nVar = new e(context);
        }
        AppMethodBeat.o(66364);
        return nVar;
    }

    public static String a() {
        return "";
    }
}
