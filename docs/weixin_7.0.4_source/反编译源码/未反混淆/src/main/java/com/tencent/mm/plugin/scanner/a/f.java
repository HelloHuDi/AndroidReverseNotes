package com.tencent.mm.plugin.scanner.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f extends m implements k {
    private int ctE;
    private int eCW = 1;
    public b ehh;
    private com.tencent.mm.ai.f ehi;
    private byte[] pZD;
    private String pZE = "en";
    private String pZF = "zh_CN";

    public f(byte[] bArr, String str, String str2, int i) {
        this.pZD = bArr;
        this.eCW = 1;
        this.pZE = str;
        this.pZF = str2;
        this.ctE = i;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(80840);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new ben();
        aVar.fsK = new beo();
        aVar.uri = "/cgi-bin/micromsg-bin/ocrtranslation";
        aVar.fsI = 392;
        aVar.fsL = 199;
        aVar.fsM = 1000000199;
        this.ehh = aVar.acD();
        ben ben = (ben) this.ehh.fsG.fsP;
        ben.vOn = ((int) bo.anU()) & BaseClientBuilder.API_PRIORITY_OTHER;
        ben.vOo = new SKBuiltinBuffer_t().setBuffer(this.pZD);
        ben.vOr = this.eCW;
        ben.wID = this.pZE;
        ben.wIE = this.pZF;
        ben.vOs = this.ctE;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(80840);
        return a;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(80841);
        ben ben = (ben) ((b) qVar).fsG.fsP;
        m.b bVar;
        if (ben.vOn <= 0 || bo.isNullOrNil(ben.wIE) || bo.isNullOrNil(ben.wID) || ben.vOr < 0 || ben.vOo == null || ben.vOo.getILen() <= 0) {
            ab.e("MicroMsg.scanner.NetSceneOCRTranslate", "ERR: Security Check Failed");
            bVar = m.b.EFailed;
            AppMethodBeat.o(80841);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(80841);
        return bVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(80842);
        ab.d("MicroMsg.scanner.NetSceneOCRTranslate", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(80842);
    }

    public final int getType() {
        return 392;
    }
}
