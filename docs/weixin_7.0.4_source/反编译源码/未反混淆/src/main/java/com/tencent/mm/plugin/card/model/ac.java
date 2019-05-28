package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.k.w;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class ac extends m implements k {
    private final b ehh;
    private f ehi;
    public LinkedList<String> kaF;
    public int kaH;
    public int kaI;
    public int kaJ;

    public ac(String str) {
        AppMethodBeat.i(87901);
        a aVar = new a();
        aVar.fsJ = new agr();
        aVar.fsK = new ags();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardserial";
        aVar.fsI = w.CTRL_INDEX;
        this.ehh = aVar.acD();
        ((agr) this.ehh.fsG.fsP).cMC = str;
        AppMethodBeat.o(87901);
    }

    public final int getType() {
        return w.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87902);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87902);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87903);
        ab.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ags ags = (ags) this.ehh.fsH.fsP;
            this.kaF = ags.kaF;
            this.kaH = ags.kaH;
            this.kaI = ags.kaI;
            this.kaJ = ags.kaJ;
        }
        ab.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", Integer.valueOf(this.kaH), Integer.valueOf(this.kaI), Integer.valueOf(this.kaJ));
        if (this.kaF != null) {
            ab.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.kaF.size());
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87903);
    }
}
