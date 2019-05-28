package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;

public interface d extends e {

    public static class a {
        private static ConcurrentHashMap<Object, d> fsR = new ConcurrentHashMap();

        static {
            AppMethodBeat.i(59944);
            AppMethodBeat.o(59944);
        }

        public static void a(d dVar) {
            AppMethodBeat.i(59941);
            ab.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", Integer.valueOf(12399999), Integer.valueOf(0));
            fsR.put(Integer.valueOf(0), dVar);
            com.tencent.mm.ai.e.d.a(Integer.valueOf(12399999), dVar);
            AppMethodBeat.o(59941);
        }

        public static void b(d dVar) {
            AppMethodBeat.i(59942);
            ab.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", Integer.valueOf(12399999), Integer.valueOf(0));
            fsR.remove(Integer.valueOf(0));
            com.tencent.mm.ai.e.d.b(Integer.valueOf(12399999), dVar);
            AppMethodBeat.o(59942);
        }

        public static d bf(Object obj) {
            AppMethodBeat.i(59943);
            d dVar = (d) fsR.get(obj);
            AppMethodBeat.o(59943);
            return dVar;
        }
    }

    public static class b {
        public mk fsS;
        public String fsT;
    }
}
