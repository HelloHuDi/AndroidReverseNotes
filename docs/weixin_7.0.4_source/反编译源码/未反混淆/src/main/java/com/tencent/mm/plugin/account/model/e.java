package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;

public final class e extends m implements k {
    private f ehi;
    private b gme;
    private blo gyM;

    public e(int i, String str) {
        AppMethodBeat.i(124679);
        a aVar = new a();
        aVar.fsJ = new blo();
        aVar.fsK = new blp();
        aVar.fsI = d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI;
        aVar.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
        this.gme = aVar.acD();
        this.gyM = (blo) this.gme.fsG.fsP;
        this.gyM.wOC = i;
        this.gyM.guW = str;
        AppMethodBeat.o(124679);
    }

    public final int getType() {
        return d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(124680);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(124680);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(124681);
        ab.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(124681);
    }
}
