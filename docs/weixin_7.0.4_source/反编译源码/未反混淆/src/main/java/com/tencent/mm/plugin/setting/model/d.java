package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adm;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class d extends m implements k {
    private b ehh;
    private f ehi;

    public d(String str) {
        AppMethodBeat.i(126844);
        a aVar = new a();
        aVar.fsJ = new adm();
        aVar.fsK = new adn();
        aVar.uri = "/cgi-bin/micromsg-bin/generalset";
        aVar.fsI = ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
        this.ehh = aVar.acD();
        adm adm = (adm) this.ehh.fsG.fsP;
        adm.SetType = 1;
        adm.wlj = str;
        AppMethodBeat.o(126844);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(126845);
        ab.d("MicroMsg.NetSceneGeneralSet", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(126845);
        return a;
    }

    public final int getType() {
        return ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(126846);
        ab.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(126846);
    }
}
