package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.protocal.protobuf.jf;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private b ehh;
    private f ehi;
    public jf tQh;

    public c(String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.i(48055);
        a aVar = new a();
        aVar.fsJ = new je();
        aVar.fsK = new jf();
        aVar.uri = "/cgi-bin/mmpay-bin/bindecard";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        je jeVar = (je) this.ehh.fsG.fsP;
        jeVar.vKZ = str;
        jeVar.vLa = str2;
        jeVar.tCi = str3;
        jeVar.vLb = str4;
        jeVar.cHF = i;
        ab.i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", str, str2, Integer.valueOf(i), str3, str4);
        AppMethodBeat.o(48055);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(48056);
        ab.i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tQh = (jf) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.tQh.kdT), this.tQh.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(48056);
    }

    public final int getType() {
        return 1986;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48057);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48057);
        return a;
    }
}
