package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.sdk.platformtools.ab;

public final class aj extends m implements k {
    public boolean eTf;
    private final b ehh;
    private f ehi;
    public String kdS;
    public com.tencent.mm.bt.b keu;

    public aj(String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, com.tencent.mm.bt.b bVar) {
        AppMethodBeat.i(87922);
        a aVar = new a();
        aVar.fsJ = new aen();
        aVar.fsK = new aeo();
        aVar.uri = "/cgi-bin/micromsg-bin/getavailablecard";
        this.ehh = aVar.acD();
        aen aen = (aen) this.ehh.fsG.fsP;
        aen.app_id = str;
        aen.kmq = i;
        aen.kmr = str2;
        aen.kms = str3;
        aen.time_stamp = i2;
        aen.kmt = str4;
        aen.kbU = str5;
        aen.kmu = str6;
        aen.keu = bVar;
        if ("INVOICE".equalsIgnoreCase(str6)) {
            aen.wmp = 1;
            AppMethodBeat.o(87922);
            return;
        }
        aen.wmp = 0;
        AppMethodBeat.o(87922);
    }

    public final int getType() {
        return 664;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87923);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87923);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87924);
        ab.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aeo aeo = (aeo) this.ehh.fsH.fsP;
            this.kdS = aeo.kdS;
            this.keu = aeo.keu;
            this.eTf = aeo.wmq != 0;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87924);
    }
}
