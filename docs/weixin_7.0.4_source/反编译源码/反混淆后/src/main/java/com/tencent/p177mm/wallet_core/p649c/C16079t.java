package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cnb;
import com.tencent.p177mm.protocal.protobuf.cnc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.wallet_core.c.t */
public final class C16079t extends C36378u {
    private final C7472b ehh;
    private C1202f ehi;
    public int errCode;
    public String kWB;
    public String kWz = null;
    public int tRC = 0;

    public C16079t(String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(49080);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cnb();
        c1196a.fsK = new cnc();
        c1196a.uri = "/cgi-bin/micromsg-bin/verifypurchase";
        c1196a.fsI = 414;
        c1196a.fsL = 215;
        c1196a.fsM = 1000000215;
        this.ehh = c1196a.acD();
        cnb cnb = (cnb) this.ehh.fsG.fsP;
        this.kWz = str;
        cnb.ProductID = str;
        cnb.xkz = i;
        cnb.wOu = i3;
        cnb.pdc = i2;
        if (!C5046bo.isNullOrNil(str6)) {
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
        cnb.xkA = (int) C5046bo.anT();
        C4990ab.m7416i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.kWz + ",verifyType:" + i + ",palyType:" + i2 + ",payload:" + str2 + ",purchaseData:" + str3 + ",dataSignature:" + str4);
        AppMethodBeat.m2505o(49080);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(49081);
        C4990ab.m7412e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + i + "   errCode:" + i2);
        this.errCode = 0;
        if (i == 0 && i2 == 0) {
            cnc cnc = (cnc) ((C7472b) c1929q).fsH.fsP;
            if (cnc.BaseResponse != null) {
                this.tRC = cnc.xkD;
                C4990ab.m7410d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + cnc.SeriesID);
                C4990ab.m7410d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + cnc.xkC);
                this.kWB = cnc.SeriesID;
            }
            this.ehi.onSceneEnd(i, i2, str, this);
            AppMethodBeat.m2505o(49081);
            return;
        }
        this.errCode = -1;
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(49081);
    }

    public final int getType() {
        return 414;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(49082);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(49082);
        return a;
    }
}
