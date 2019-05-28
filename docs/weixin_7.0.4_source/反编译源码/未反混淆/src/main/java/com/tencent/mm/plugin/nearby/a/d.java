package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aye;
import com.tencent.mm.protocal.protobuf.ayf;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends m implements k {
    private final b ehh;
    private f ehi;
    public String gfa;
    public String oPy;

    public d(float f, float f2, int i, String str, String str2) {
        AppMethodBeat.i(55367);
        a aVar = new a();
        aVar.fsJ = new aye();
        aVar.fsK = new ayf();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        this.ehh = aVar.acD();
        aye aye = (aye) this.ehh.fsG.fsP;
        aye.OpCode = 1;
        aye.vRp = f;
        aye.vRq = f2;
        aye.wfG = i;
        aye.wfH = str;
        aye.wfI = str2;
        aye.wfJ = 0;
        ab.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + f + " lat:" + f2 + " pre:" + i + " gpsSource:0 mac" + str + " cell:" + str2);
        AppMethodBeat.o(55367);
    }

    public d(String str, int i, int i2) {
        AppMethodBeat.i(55368);
        a aVar = new a();
        aVar.fsJ = new aye();
        aVar.fsK = new ayf();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        this.ehh = aVar.acD();
        aye aye = (aye) this.ehh.fsG.fsP;
        aye.vRp = 0.0f;
        aye.vRq = 0.0f;
        aye.wfG = 0;
        aye.wfJ = 0;
        aye.wfH = "";
        aye.wfI = "";
        aye.OpCode = 2;
        aye.fLc = str;
        aye.wCk = i;
        aye.wCj = i2;
        AppMethodBeat.o(55368);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(55369);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(55369);
        return a;
    }

    public final int getType() {
        return 376;
    }

    public final int Ah() {
        return ((aye) this.ehh.fsG.fsP).OpCode;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(55370);
        ab.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " opCode:" + Ah());
        ayf ayf = (ayf) ((b) qVar).fsH.fsP;
        if (i2 != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(55370);
        } else if (Ah() == 1) {
            this.gfa = ayf.fLc;
            this.oPy = ayf.wCl;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(55370);
        } else {
            if (Ah() == 2) {
                b.TA(((aye) ((b) qVar).fsG.fsP).fLc);
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.o(55370);
        }
    }
}
