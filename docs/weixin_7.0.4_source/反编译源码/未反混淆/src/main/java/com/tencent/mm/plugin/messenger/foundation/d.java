package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.az.a;
import com.tencent.mm.az.n;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.x;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.HashMap;

public final class d implements c, j {
    aj oqb;
    bw oqc;
    bj oqd;
    al oqe;
    n oqf;
    a oqg;
    br oqh;
    ao oqi;
    ay oqj;
    aw oqk;
    bg oql;
    bu oqm;
    cb oqn;
    x oqo;
    bc oqp;

    public final g bOl() {
        AppMethodBeat.i(1028);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        a aVar = this.oqg;
        AppMethodBeat.o(1028);
        return aVar;
    }

    public final b bOm() {
        AppMethodBeat.i(1029);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        x xVar = this.oqo;
        AppMethodBeat.o(1029);
        return xVar;
    }

    public final void onAccountInitialized(e.c cVar) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(1030);
        if (this.oqb != null) {
            aj ajVar = this.oqb;
            ajVar.xXl.clear();
            ajVar.xXm.clear();
        }
        if (this.oqf != null) {
            f fVar = this.oqf;
            fVar.fBy = new HashMap();
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.b(681, fVar);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.b(806, fVar);
        }
        AppMethodBeat.o(1030);
    }

    public final /* bridge */ /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.n ahV() {
        return this.oqp;
    }

    public final /* synthetic */ l bOn() {
        AppMethodBeat.i(1031);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        bu buVar = this.oqm;
        AppMethodBeat.o(1031);
        return buVar;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.f bOo() {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_SHAKA_ADD_13);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        bg bgVar = this.oql;
        AppMethodBeat.o(FilterEnum4Shaka.MIC_SHAKA_ADD_13);
        return bgVar;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.d bOp() {
        AppMethodBeat.i(1033);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        aw awVar = this.oqk;
        AppMethodBeat.o(1033);
        return awVar;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.e bOq() {
        AppMethodBeat.i(1034);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        ay ayVar = this.oqj;
        AppMethodBeat.o(1034);
        return ayVar;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.c Yo() {
        AppMethodBeat.i(1035);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        ao aoVar = this.oqi;
        AppMethodBeat.o(1035);
        return aoVar;
    }

    public final /* synthetic */ k XU() {
        AppMethodBeat.i(1036);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        br brVar = this.oqh;
        AppMethodBeat.o(1036);
        return brVar;
    }

    public final /* synthetic */ be XR() {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_SHAKA_ADD2_2);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        al alVar = this.oqe;
        AppMethodBeat.o(FilterEnum4Shaka.MIC_SHAKA_ADD2_2);
        return alVar;
    }

    public final /* synthetic */ h bOr() {
        AppMethodBeat.i(1038);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        bj bjVar = this.oqd;
        AppMethodBeat.o(1038);
        return bjVar;
    }

    public final /* synthetic */ m XN() {
        AppMethodBeat.i(1039);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        bw bwVar = this.oqc;
        AppMethodBeat.o(1039);
        return bwVar;
    }

    public final /* synthetic */ bd XM() {
        AppMethodBeat.i(1040);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        aj ajVar = this.oqb;
        AppMethodBeat.o(1040);
        return ajVar;
    }

    public final /* synthetic */ i XL() {
        AppMethodBeat.i(1041);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN().QU();
        n nVar = this.oqf;
        AppMethodBeat.o(1041);
        return nVar;
    }
}
