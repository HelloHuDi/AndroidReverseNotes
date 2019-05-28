package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agl;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.sdk.platformtools.ab;

public final class aa extends m implements k {
    private final b ehh;
    private f ehi;
    public String kdS;

    public aa(String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, cdc cdc) {
        AppMethodBeat.i(87895);
        a aVar = new a();
        aVar.fsJ = new agl();
        aVar.fsK = new agm();
        aVar.uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
        this.ehh = aVar.acD();
        agl agl = (agl) this.ehh.fsG.fsP;
        agl.cMC = str;
        agl.cME = i;
        agl.kde = str2;
        agl.cMD = str3;
        agl.vBv = str4;
        agl.vBu = str5;
        agl.vBw = i2;
        agl.wni = str6;
        agl.vBy = cdc;
        AppMethodBeat.o(87895);
    }

    public final int getType() {
        return 645;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87896);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87896);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87897);
        ab.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            this.kdS = ((agm) this.ehh.fsH.fsP).kdS;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87897);
    }
}
