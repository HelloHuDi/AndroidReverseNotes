package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends m implements k {
    private b ehh;
    private f ehi;
    public boolean gIJ;
    public String nickname;
    public String username;

    public e(String str, String str2, int i) {
        AppMethodBeat.i(16734);
        a aVar = new a();
        aVar.fsJ = new bpl();
        aVar.fsK = new bpm();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
        this.ehh = aVar.acD();
        bpl bpl = (bpl) this.ehh.fsG.fsP;
        bpl.timestamp = 0;
        bpl.wRX = str;
        bpl.csB = str2;
        bpl.scene = i;
        AppMethodBeat.o(16734);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.i(16735);
        ab.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bpm bpm = (bpm) ((b) qVar).fsH.fsP;
            this.username = bpm.lCH;
            this.nickname = bpm.wSa;
            if (bpm.wRZ != 1) {
                z = false;
            }
            this.gIJ = z;
            if (bpm.wRK.wRN != null) {
                ab.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + bpm.wRK.wRN.size());
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().s(bpm.wRK.wRN);
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16735);
    }

    public final int getType() {
        return 417;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(16736);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16736);
        return a;
    }
}
