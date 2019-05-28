package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.protocal.protobuf.bev;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;

public final class j extends m implements k {
    private b ehh;
    public f ehi;
    private final int fhF = -1216949095;

    public j() {
        AppMethodBeat.i(36236);
        a aVar = new a();
        aVar.fsJ = new beu();
        aVar.fsK = new bev();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
        this.ehh = aVar.acD();
        beu beu = (beu) this.ehh.fsG.fsP;
        g.RQ();
        g.RN();
        beu.wIP = com.tencent.mm.kernel.a.QF();
        beu.wIQ = -1216949095;
        ab.i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", Integer.valueOf(beu.wIP), Integer.valueOf(beu.wIQ));
        AppMethodBeat.o(36236);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(36237);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36237);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36238);
        ab.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", Integer.valueOf(this.fhF), Integer.valueOf(((bev) ((b) qVar).fsH.fsP).status));
            if (this.fhF == -1216949095) {
                g.RQ();
                g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_UPLOAD_WEISHI_BOOLEAN_SYNC, Boolean.valueOf(r0.status == 1));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36238);
    }

    public final int getType() {
        return 2842;
    }
}
