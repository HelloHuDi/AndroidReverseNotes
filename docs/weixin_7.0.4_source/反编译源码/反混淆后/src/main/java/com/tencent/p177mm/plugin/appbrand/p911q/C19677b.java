package com.tencent.p177mm.plugin.appbrand.p911q;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.q.b */
public interface C19677b {

    /* renamed from: com.tencent.mm.plugin.appbrand.q.b$a */
    public static class C10705a {
        /* renamed from: n */
        public static String m18377n(String[] strArr) {
            AppMethodBeat.m2504i(57065);
            String str = "";
            String str2 = " PRIMARY KEY ( ";
            for (String str3 : strArr) {
                str2 = str2 + ", " + str3;
            }
            String str4 = str + "," + (str2.replaceFirst(",", "") + " )");
            AppMethodBeat.m2505o(57065);
            return str4;
        }
    }

    String[] getKeys();
}
