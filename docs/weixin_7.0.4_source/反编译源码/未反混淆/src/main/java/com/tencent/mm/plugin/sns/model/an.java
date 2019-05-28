package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class an {
    private static final Map<String, String> qMG = new HashMap();

    static {
        AppMethodBeat.i(36599);
        AppMethodBeat.o(36599);
    }

    public static String fZ(String str, String str2) {
        AppMethodBeat.i(36597);
        String str3;
        if (str2 == null) {
            str3 = "";
            AppMethodBeat.o(36597);
            return str3;
        }
        boolean equals = Looper.getMainLooper().equals(Looper.myLooper());
        if (equals && qMG.containsKey(str + str2)) {
            str3 = (String) qMG.get(str + str2);
            if (!bo.isNullOrNil(str3)) {
                AppMethodBeat.o(36597);
                return str3;
            }
        }
        str3 = g.x(str2.getBytes());
        StringBuffer stringBuffer = new StringBuffer(str);
        if (str3.length() > 0) {
            stringBuffer.append(str3.charAt(0));
            stringBuffer.append("/");
        }
        if (str3.length() >= 2) {
            stringBuffer.append(str3.charAt(1));
            stringBuffer.append("/");
        }
        if (equals) {
            qMG.put(str + str2, stringBuffer.toString());
        }
        str3 = stringBuffer.toString();
        AppMethodBeat.o(36597);
        return str3;
    }

    public static synchronized void release() {
        synchronized (an.class) {
            AppMethodBeat.i(36598);
            qMG.clear();
            AppMethodBeat.o(36598);
        }
    }
}
