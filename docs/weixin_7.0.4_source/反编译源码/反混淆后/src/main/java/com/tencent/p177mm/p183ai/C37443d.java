package com.tencent.p177mm.p183ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.protocal.protobuf.C40545mk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.ai.d */
public interface C37443d extends C1201e {

    /* renamed from: com.tencent.mm.ai.d$a */
    public static class C17888a {
        private static ConcurrentHashMap<Object, C37443d> fsR = new ConcurrentHashMap();

        static {
            AppMethodBeat.m2504i(59944);
            AppMethodBeat.m2505o(59944);
        }

        /* renamed from: a */
        public static void m28060a(C37443d c37443d) {
            AppMethodBeat.m2504i(59941);
            C4990ab.m7417i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", Integer.valueOf(12399999), Integer.valueOf(0));
            fsR.put(Integer.valueOf(0), c37443d);
            C1200d.m2636a(Integer.valueOf(12399999), c37443d);
            AppMethodBeat.m2505o(59941);
        }

        /* renamed from: b */
        public static void m28061b(C37443d c37443d) {
            AppMethodBeat.m2504i(59942);
            C4990ab.m7417i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", Integer.valueOf(12399999), Integer.valueOf(0));
            fsR.remove(Integer.valueOf(0));
            C1200d.m2637b(Integer.valueOf(12399999), c37443d);
            AppMethodBeat.m2505o(59942);
        }

        /* renamed from: bf */
        public static C37443d m28062bf(Object obj) {
            AppMethodBeat.m2504i(59943);
            C37443d c37443d = (C37443d) fsR.get(obj);
            AppMethodBeat.m2505o(59943);
            return c37443d;
        }
    }

    /* renamed from: com.tencent.mm.ai.d$b */
    public static class C37444b {
        public C40545mk fsS;
        public String fsT;
    }
}
