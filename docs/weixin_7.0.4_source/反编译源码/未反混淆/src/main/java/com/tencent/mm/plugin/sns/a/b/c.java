package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class c extends m implements k {
    private b ehh;
    public f ehi;

    public c(long j, String str, int i, int i2, int i3, String str2, int i4, String str3, int i5, com.tencent.mm.bt.b bVar, com.tencent.mm.bt.b bVar2) {
        AppMethodBeat.i(94483);
        a aVar = new a();
        aVar.fsJ = new bh();
        aVar.fsK = new bi();
        int jS = n.qFD.jS(j);
        if (jS != 2) {
            aVar.uri = "/cgi-bin/mmoc-bin/ad/click";
            aVar.fsI = 1232;
        } else {
            aVar.uri = "/cgi-bin/mmux-bin/adclick";
            aVar.fsI = 1817;
        }
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.NetSceneAdClick", "source %d, uri %s", Integer.valueOf(jS), this.ehh.uri);
        ab.i("MicroMsg.NetSceneAdClick", "snsId:" + j + " viewId:" + str + " clickPos:" + i + " clickAction:" + i2 + " sceneType:" + i3 + " descXml:" + str2 + " adtype:" + i4 + " snsStatStr:" + str3 + " flipStatus:" + i5 + " remind_source_info.length:" + String.valueOf(bVar != null ? bVar.wR.length : 0) + " remind_self_info.length:" + String.valueOf(bVar2 != null ? bVar2.wR.length : 0));
        bh bhVar = (bh) this.ehh.fsG.fsP;
        bhVar.vDs = i;
        bhVar.qEg = str;
        bhVar.scene = i3;
        bhVar.vDt = str2;
        bhVar.bssid = at.gF(ah.getContext());
        bhVar.ssid = at.gE(ah.getContext());
        bhVar.vDu = System.currentTimeMillis();
        bhVar.vDw = i4;
        bhVar.vDx = i2;
        bhVar.cvd = jS;
        bhVar.vDy = str3;
        bhVar.vDz = i5;
        if (bVar2 != null) {
            bhVar.vDB = bVar2;
        }
        if (bVar != null) {
            bhVar.vDA = bVar;
        }
        AppMethodBeat.o(94483);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(94484);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(94484);
        return a;
    }

    public final int getType() {
        return 1232;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(94485);
        ab.d("MicroMsg.NetSceneAdClick", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(94485);
    }
}
