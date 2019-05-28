package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.sdk.platformtools.ab;

public final class al extends m implements k {
    private final b ehh;
    private f ehi;
    private brv nYU;

    public al(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(42409);
        ab.i("MicroMsg.NetSceneLuckyMoneyReport", "NetSceneLuckyMoneyReport() sendId:%s unique_id:%s reportType:%s sendUsername:%s recvUserName:%s", str, str2, Integer.valueOf(i), str3, str4);
        a aVar = new a();
        bru bru = new bru();
        bru.nSX = str;
        bru.wKQ = str2;
        bru.cKB = i;
        bru.nXl = str3;
        bru.wTV = str4;
        aVar.fsJ = bru;
        aVar.fsK = new brv();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/wxhbreport";
        this.ehh = aVar.acD();
        AppMethodBeat.o(42409);
    }

    public final int getType() {
        return 2715;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(42410);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(42410);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(42411);
        ab.w("MicroMsg.NetSceneLuckyMoneyReport", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.nYU = (brv) ((b) qVar).fsH.fsP;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(42411);
    }
}
