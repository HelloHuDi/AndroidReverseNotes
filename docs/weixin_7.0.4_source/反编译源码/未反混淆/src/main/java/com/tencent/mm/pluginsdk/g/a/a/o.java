package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.q.b;

public final class o extends n {

    static class a extends k {
        final com.tencent.mm.protocal.q.a veS = new com.tencent.mm.protocal.q.a();
        final b veT = new b();

        public a() {
            AppMethodBeat.i(79559);
            AppMethodBeat.o(79559);
        }

        public final d ZR() {
            return this.veS;
        }

        public final int getType() {
            return f.vxx ? 784 : 722;
        }

        public final String getUri() {
            return f.vxx ? "/cgi-bin/micromsg-bin/secencryptcheckresupdate" : "/cgi-bin/micromsg-bin/encryptcheckresupdate";
        }

        public final e ZS() {
            return this.veT;
        }

        public final int acC() {
            return 1;
        }
    }

    public static void aVi() {
        AppMethodBeat.i(79560);
        g.RO().eJo.a(new o(), 0);
        AppMethodBeat.o(79560);
    }

    /* Access modifiers changed, original: protected|final */
    public final String getTag() {
        return "MicroMsg.NetSceneEncryptCheckResUpdate";
    }

    /* Access modifiers changed, original: protected|final */
    public final rr i(q qVar) {
        return ((a) qVar).veT.vyB;
    }

    public final int getType() {
        return f.vxx ? 784 : 722;
    }

    /* Access modifiers changed, original: protected|final */
    public final q diq() {
        AppMethodBeat.i(79561);
        a aVar = new a();
        com.tencent.mm.protocal.q.a aVar2 = aVar.veS;
        aVar2.hB(0);
        aVar2.vyy.wek.wei.vYX.addAll(this.veO);
        AppMethodBeat.o(79561);
        return aVar;
    }
}
