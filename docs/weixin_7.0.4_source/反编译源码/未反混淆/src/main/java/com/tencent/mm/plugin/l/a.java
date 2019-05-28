package com.tencent.mm.plugin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import java.util.List;

public final class a {
    private static List<a> nRx;
    private static String nRy;

    public static class a {
        public String igi;
        public SKBuiltinBuffer_t nRA;
        public int nRz;
    }

    public static synchronized void o(String str, List<a> list) {
        synchronized (a.class) {
            nRy = str;
            nRx = list;
        }
    }

    public static synchronized List<a> Qe(String str) {
        List<a> list;
        synchronized (a.class) {
            AppMethodBeat.i(70225);
            if (str == null || !str.equals(nRy)) {
                list = null;
                AppMethodBeat.o(70225);
            } else {
                list = nRx;
                AppMethodBeat.o(70225);
            }
        }
        return list;
    }
}
