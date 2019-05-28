package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;
import java.util.Vector;

public final class q extends m implements k {
    public static List<Long> qIU = new Vector();
    private long cND;
    public b ehh;
    public f ehi;

    static {
        AppMethodBeat.i(36275);
        AppMethodBeat.o(36275);
    }

    public static boolean kf(long j) {
        AppMethodBeat.i(36270);
        if (qIU.contains(Long.valueOf(j))) {
            AppMethodBeat.o(36270);
            return false;
        }
        qIU.add(Long.valueOf(j));
        AppMethodBeat.o(36270);
        return true;
    }

    private static boolean ke(long j) {
        AppMethodBeat.i(36271);
        qIU.remove(Long.valueOf(j));
        AppMethodBeat.o(36271);
        return true;
    }

    public q(long j) {
        AppMethodBeat.i(36272);
        this.cND = j;
        a aVar = new a();
        aVar.fsJ = new cbg();
        aVar.fsK = new cbh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
        this.ehh = aVar.acD();
        ((cbg) this.ehh.fsG.fsP).vQE = j;
        ab.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(j)));
        AppMethodBeat.o(36272);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(36273);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36273);
        return a;
    }

    public final int getType() {
        return 210;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(36274);
        if (i2 == 0 && i3 == 0) {
            cbf cbf = ((cbh) this.ehh.fsH.fsP).xaI;
            if (cbf != null) {
                ab.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + aa.b(cbf.xam));
            }
            aj.d(cbf);
            this.ehi.onSceneEnd(i2, i3, str, this);
            ke(this.cND);
            AppMethodBeat.o(36274);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        ke(this.cND);
        AppMethodBeat.o(36274);
    }
}
