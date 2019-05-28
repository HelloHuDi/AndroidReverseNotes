package com.tencent.p177mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.model.an */
public final class C3892an {
    private static final Map<String, String> qMG = new HashMap();

    static {
        AppMethodBeat.m2504i(36599);
        AppMethodBeat.m2505o(36599);
    }

    /* renamed from: fZ */
    public static String m6198fZ(String str, String str2) {
        AppMethodBeat.m2504i(36597);
        String str3;
        if (str2 == null) {
            str3 = "";
            AppMethodBeat.m2505o(36597);
            return str3;
        }
        boolean equals = Looper.getMainLooper().equals(Looper.myLooper());
        if (equals && qMG.containsKey(str + str2)) {
            str3 = (String) qMG.get(str + str2);
            if (!C5046bo.isNullOrNil(str3)) {
                AppMethodBeat.m2505o(36597);
                return str3;
            }
        }
        str3 = C1178g.m2591x(str2.getBytes());
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
        AppMethodBeat.m2505o(36597);
        return str3;
    }

    public static synchronized void release() {
        synchronized (C3892an.class) {
            AppMethodBeat.m2504i(36598);
            qMG.clear();
            AppMethodBeat.m2505o(36598);
        }
    }
}
