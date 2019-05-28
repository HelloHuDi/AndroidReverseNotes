package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class t extends u {
    private final b ehh;
    private f ehi;
    public int errCode;
    public String kWB;
    public String kWz = null;
    public int tRC = 0;

    public t(String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(49080);
        a aVar = new a();
        aVar.fsJ = new cnb();
        aVar.fsK = new cnc();
        aVar.uri = "/cgi-bin/micromsg-bin/verifypurchase";
        aVar.fsI = 414;
        aVar.fsL = 215;
        aVar.fsM = 1000000215;
        this.ehh = aVar.acD();
        cnb cnb = (cnb) this.ehh.fsG.fsP;
        this.kWz = str;
        cnb.ProductID = str;
        cnb.xkz = i;
        cnb.wOu = i3;
        cnb.pdc = i2;
        if (!bo.isNullOrNil(str6)) {
            cnb.wOs = str6;
            cnb.wOt = str5;
        }
        cnb.wOv = str2;
        cnb.xkB = str4;
        if (str3 != null) {
            cnb.xky = new SKBuiltinBuffer_t().setBuffer(str3.getBytes());
        } else {
            cnb.xky = new SKBuiltinBuffer_t();
        }
        cnb.xkA = (int) bo.anT();
        ab.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.kWz + ",verifyType:" + i + ",palyType:" + i2 + ",payload:" + str2 + ",purchaseData:" + str3 + ",dataSignature:" + str4);
        AppMethodBeat.o(49080);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(49081);
        ab.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + i + "   errCode:" + i2);
        this.errCode = 0;
        if (i == 0 && i2 == 0) {
            cnc cnc = (cnc) ((b) qVar).fsH.fsP;
            if (cnc.BaseResponse != null) {
                this.tRC = cnc.xkD;
                ab.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + cnc.SeriesID);
                ab.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + cnc.xkC);
                this.kWB = cnc.SeriesID;
            }
            this.ehi.onSceneEnd(i, i2, str, this);
            AppMethodBeat.o(49081);
            return;
        }
        this.errCode = -1;
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(49081);
    }

    public final int getType() {
        return 414;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(49082);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(49082);
        return a;
    }
}
