package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.buz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.view.d;

public final class b extends m implements k {
    private f eIc;
    private final com.tencent.mm.ai.b ehh;
    private long kVE = 0;
    private byte[] kWI = null;
    private String kWK;
    private int kWt;
    int ueW = -1;
    boolean ueX = true;

    public b(int i, String str, byte[] bArr, int i2, long j) {
        AppMethodBeat.i(5658);
        a aVar = new a();
        aVar.fsJ = new buy();
        aVar.fsK = new buz();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
        aVar.fsI = d.MIC_PTU_FENGJING;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.kWt = i;
        this.kWK = str;
        this.kWI = bArr;
        this.ueW = i2;
        this.kVE = j;
        AppMethodBeat.o(5658);
    }

    public final int getType() {
        return d.MIC_PTU_FENGJING;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(5659);
        this.eIc = fVar;
        buy buy = (buy) this.ehh.fsG.fsP;
        if (bo.cb(this.kWI)) {
            buy.wok = new SKBuiltinBuffer_t();
            this.ueX = true;
        } else {
            buy.wok = aa.ad(this.kWI);
            this.ueX = false;
            buy.won = this.kVE;
        }
        ab.d("MicroMsg.emoji.NetSceneSearchEmotion", buy.wok == null ? "Buf is NULL" : buy.wok.toString());
        buy.ReqType = this.kWt;
        buy.wol = this.kWK;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(5659);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(5660);
        ab.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(5660);
    }

    public final buz cWk() {
        if (this.ehh == null) {
            return null;
        }
        return (buz) this.ehh.fsH.fsP;
    }
}
