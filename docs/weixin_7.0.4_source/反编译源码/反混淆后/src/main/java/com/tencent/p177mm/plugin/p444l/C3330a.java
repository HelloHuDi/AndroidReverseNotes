package com.tencent.p177mm.plugin.p444l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.l.a */
public final class C3330a {
    private static List<C3331a> nRx;
    private static String nRy;

    /* renamed from: com.tencent.mm.plugin.l.a$a */
    public static class C3331a {
        public String igi;
        public SKBuiltinBuffer_t nRA;
        public int nRz;
    }

    /* renamed from: o */
    public static synchronized void m5634o(String str, List<C3331a> list) {
        synchronized (C3330a.class) {
            nRy = str;
            nRx = list;
        }
    }

    /* renamed from: Qe */
    public static synchronized List<C3331a> m5633Qe(String str) {
        List<C3331a> list;
        synchronized (C3330a.class) {
            AppMethodBeat.m2504i(70225);
            if (str == null || !str.equals(nRy)) {
                list = null;
                AppMethodBeat.m2505o(70225);
            } else {
                list = nRx;
                AppMethodBeat.m2505o(70225);
            }
        }
        return list;
    }
}
