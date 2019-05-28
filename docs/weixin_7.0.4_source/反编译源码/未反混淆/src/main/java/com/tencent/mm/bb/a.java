package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends m implements k {
    private final b ehh;
    private f ehi;
    public String fMC;
    public String fMD;
    public byte[] fME;

    public a() {
        this(r.Yz(), bo.h((Integer) g.RP().Ry().get(66561, null)), 0);
        AppMethodBeat.i(78520);
        AppMethodBeat.o(78520);
    }

    public a(String str, int i) {
        this(str, i, 0);
    }

    public a(String str, int i, int i2) {
        AppMethodBeat.i(78521);
        this.ehi = null;
        this.fMC = null;
        this.fMD = null;
        this.fME = null;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new ana();
        aVar.fsK = new anb();
        aVar.uri = "/cgi-bin/micromsg-bin/getqrcode";
        aVar.fsI = 168;
        aVar.fsL = 67;
        aVar.fsM = 1000000067;
        this.ehh = aVar.acD();
        ana ana = (ana) this.ehh.fsG.fsP;
        ana.wcB = aa.vy(str);
        ana.wrF = i;
        ana.OpCode = i2;
        ab.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(78521);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78522);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78522);
        return a;
    }

    public final int getType() {
        return 168;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78523);
        ab.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + i2 + " errCode" + i3);
        if (i2 == 0 && i3 == 0) {
            anb anb = (anb) this.ehh.fsH.fsP;
            String a = aa.a(((ana) this.ehh.fsG.fsP).wcB);
            this.fME = aa.a(anb.wrG, new byte[0]);
            this.fMC = anb.wrH;
            ab.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", this.fMC, anb.wrI, anb.wrJ);
            if (r.Yz().equals(a)) {
                Object obj = anb.wrI;
                a = (String) g.RP().Ry().get(66563, (Object) "");
                if (!(obj == null || a.equals(obj))) {
                    g.RP().Ry().set(66563, obj);
                    this.fMD = anb.wrJ;
                }
                g.RP().Ry().set(66561, Integer.valueOf(anb.wrF));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78523);
    }
}
