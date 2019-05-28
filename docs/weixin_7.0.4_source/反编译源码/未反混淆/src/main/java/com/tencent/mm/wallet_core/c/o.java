package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

public final class o extends m implements k {
    private a AfA;
    private int Afz = 2632;
    private final b ehh;
    private f ehi;

    public o(Map<String, Object> map, String str, String str2, int i, a aVar) {
        AppMethodBeat.i(49069);
        ab.i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + str + " appid: " + str2);
        this.AfA = aVar;
        b.a aVar2 = new b.a();
        aVar2.fsJ = new bvz();
        aVar2.fsK = new bwa();
        aVar2.uri = "/cgi-bin/mmpay-bin/securetunnel";
        aVar2.fsI = this.Afz;
        if (map.containsKey("timeout")) {
            aVar2.azs = ((Integer) map.get("timeout")).intValue();
        }
        this.ehh = aVar2.acD();
        bvz bvz = (bvz) this.ehh.fsG.fsP;
        bvz.wWO = (String) map.get("reqbuf");
        bvz.wap = (String) map.get("cmd");
        bvz.url = str;
        bvz.csB = str2;
        bvz.scene = i;
        bvz.cvd = 0;
        AppMethodBeat.o(49069);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(49070);
        ab.i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (this.AfA != null) {
            ab.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
            if (i2 == 0 && i3 == 0) {
                ab.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback success");
                this.AfA.onSuccess(((bwa) this.ehh.fsH.fsP).wWP);
            } else {
                ab.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
                this.AfA.BD(str);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(49070);
    }

    public final int getType() {
        return this.Afz;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(49071);
        this.ehi = fVar;
        ab.d("MicroMsg.NetSceneJSAPISecureTunnel", "doScene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(49071);
        return a;
    }
}
