package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.concurrent.ConcurrentHashMap;

public interface e {

    public static class a {
        public cm eAB;
        public boolean fsU = false;
        public boolean fsV = false;
        public boolean fsW = false;
        public long fsX = 0;
        public Object fsY;

        public a(cm cmVar, boolean z, boolean z2, boolean z3) {
            this.eAB = cmVar;
            this.fsU = z;
            this.fsV = z2;
            this.fsW = z3;
        }

        public a(cm cmVar, boolean z, long j) {
            this.eAB = cmVar;
            this.fsU = true;
            this.fsV = false;
            this.fsW = z;
            this.fsX = j;
        }

        public a(cm cmVar, Object obj) {
            this.eAB = cmVar;
            this.fsY = obj;
        }

        public final String toString() {
            AppMethodBeat.i(59945);
            String format = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.fsU), Boolean.valueOf(this.fsV), Boolean.valueOf(this.fsW), Long.valueOf(this.fsX)});
            AppMethodBeat.o(59945);
            return format;
        }
    }

    public static class b {
        public bi csG;
        public boolean fsZ;

        public b(bi biVar, boolean z) {
            this.csG = biVar;
            this.fsZ = z;
        }
    }

    public static class c {
        public bi cKd;
        public cm eAB;
        public Object fsY;

        public c(bi biVar) {
            this.cKd = biVar;
        }

        public c(cm cmVar, Object obj) {
            this.eAB = cmVar;
            this.fsY = obj;
        }
    }

    public static class d {
        private static ConcurrentHashMap<Object, e> fsR = new ConcurrentHashMap();

        static {
            AppMethodBeat.i(59949);
            AppMethodBeat.o(59949);
        }

        public static void a(Object obj, e eVar) {
            AppMethodBeat.i(59946);
            ab.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", obj, eVar);
            fsR.put(obj, eVar);
            AppMethodBeat.o(59946);
        }

        public static void b(Object obj, e eVar) {
            AppMethodBeat.i(59947);
            ab.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", obj, eVar);
            fsR.remove(obj);
            AppMethodBeat.o(59947);
        }

        public static e bg(Object obj) {
            AppMethodBeat.i(59948);
            e eVar = (e) fsR.get(obj);
            AppMethodBeat.o(59948);
            return eVar;
        }
    }

    void a(c cVar);

    b b(a aVar);
}
