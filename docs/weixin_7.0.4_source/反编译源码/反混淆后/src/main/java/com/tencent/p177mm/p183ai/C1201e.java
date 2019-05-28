package com.tencent.p177mm.p183ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.ai.e */
public interface C1201e {

    /* renamed from: com.tencent.mm.ai.e$a */
    public static class C1197a {
        public C7254cm eAB;
        public boolean fsU = false;
        public boolean fsV = false;
        public boolean fsW = false;
        public long fsX = 0;
        public Object fsY;

        public C1197a(C7254cm c7254cm, boolean z, boolean z2, boolean z3) {
            this.eAB = c7254cm;
            this.fsU = z;
            this.fsV = z2;
            this.fsW = z3;
        }

        public C1197a(C7254cm c7254cm, boolean z, long j) {
            this.eAB = c7254cm;
            this.fsU = true;
            this.fsV = false;
            this.fsW = z;
            this.fsX = j;
        }

        public C1197a(C7254cm c7254cm, Object obj) {
            this.eAB = c7254cm;
            this.fsY = obj;
        }

        public final String toString() {
            AppMethodBeat.m2504i(59945);
            String format = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.fsU), Boolean.valueOf(this.fsV), Boolean.valueOf(this.fsW), Long.valueOf(this.fsX)});
            AppMethodBeat.m2505o(59945);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.ai.e$b */
    public static class C1198b {
        public C7620bi csG;
        public boolean fsZ;

        public C1198b(C7620bi c7620bi, boolean z) {
            this.csG = c7620bi;
            this.fsZ = z;
        }
    }

    /* renamed from: com.tencent.mm.ai.e$c */
    public static class C1199c {
        public C7620bi cKd;
        public C7254cm eAB;
        public Object fsY;

        public C1199c(C7620bi c7620bi) {
            this.cKd = c7620bi;
        }

        public C1199c(C7254cm c7254cm, Object obj) {
            this.eAB = c7254cm;
            this.fsY = obj;
        }
    }

    /* renamed from: com.tencent.mm.ai.e$d */
    public static class C1200d {
        private static ConcurrentHashMap<Object, C1201e> fsR = new ConcurrentHashMap();

        static {
            AppMethodBeat.m2504i(59949);
            AppMethodBeat.m2505o(59949);
        }

        /* renamed from: a */
        public static void m2636a(Object obj, C1201e c1201e) {
            AppMethodBeat.m2504i(59946);
            C4990ab.m7417i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", obj, c1201e);
            fsR.put(obj, c1201e);
            AppMethodBeat.m2505o(59946);
        }

        /* renamed from: b */
        public static void m2637b(Object obj, C1201e c1201e) {
            AppMethodBeat.m2504i(59947);
            C4990ab.m7417i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", obj, c1201e);
            fsR.remove(obj);
            AppMethodBeat.m2505o(59947);
        }

        /* renamed from: bg */
        public static C1201e m2638bg(Object obj) {
            AppMethodBeat.m2504i(59948);
            C1201e c1201e = (C1201e) fsR.get(obj);
            AppMethodBeat.m2505o(59948);
            return c1201e;
        }
    }

    /* renamed from: a */
    void mo4452a(C1199c c1199c);

    /* renamed from: b */
    C1198b mo4453b(C1197a c1197a);
}
