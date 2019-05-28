package com.tencent.soter.core.p1351c;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.soter.core.c.e */
public class C46745e {
    private static volatile C46745e Avh = null;
    public String Avi = C44474b.Avf;

    public static C46745e dQW() {
        AppMethodBeat.m2504i(73032);
        C46745e c46745e;
        if (Avh == null) {
            synchronized (C46745e.class) {
                try {
                    if (Avh == null) {
                        Avh = new C46745e();
                    }
                    c46745e = Avh;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(73032);
                }
            }
            return c46745e;
        }
        c46745e = Avh;
        AppMethodBeat.m2505o(73032);
        return c46745e;
    }
}
