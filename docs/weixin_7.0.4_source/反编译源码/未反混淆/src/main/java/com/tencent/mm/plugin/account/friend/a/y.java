package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;

public final class y extends m implements k {
    public static int gvV = 1;
    public static int gvW = 2;
    public static int gvX = 3;
    public static int gvY = 4;
    private b ehh;
    private f ehi;

    public y(int i) {
        AppMethodBeat.i(108432);
        a aVar = new a();
        aVar.fsJ = new rz();
        aVar.fsK = new sa();
        aVar.uri = "/cgi-bin/micromsg-bin/checkunbind";
        aVar.fsI = d.MIC_PTU_ZIPAI_LIGHTRED;
        this.ehh = aVar.acD();
        ((rz) this.ehh.fsG.fsP).vZq = i;
        AppMethodBeat.o(108432);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108433);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108433);
        return a;
    }

    public final String aqd() {
        AppMethodBeat.i(108434);
        try {
            String str = ((sa) this.ehh.fsH.fsP).vZr;
            ab.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() ".concat(String.valueOf(str)));
            AppMethodBeat.o(108434);
            return str;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", e, "", new Object[0]);
            AppMethodBeat.o(108434);
            return null;
        }
    }

    public final int getType() {
        return d.MIC_PTU_ZIPAI_LIGHTRED;
    }

    public final sa aqe() {
        return (sa) this.ehh.fsH.fsP;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108435);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108435);
    }
}
