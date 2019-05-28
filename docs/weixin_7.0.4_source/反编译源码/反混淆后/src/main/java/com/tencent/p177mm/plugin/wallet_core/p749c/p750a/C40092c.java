package com.tencent.p177mm.plugin.wallet_core.p749c.p750a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.p177mm.protocal.protobuf.biw;
import com.tencent.p177mm.protocal.protobuf.bja;
import com.tencent.p177mm.protocal.protobuf.bjh;
import com.tencent.p177mm.protocal.protobuf.bji;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.a.c */
public final class C40092c extends C36378u {
    private C7472b ehh;
    private C1202f ehi;
    public int tuI = 0;
    public Orders tux;

    public C40092c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.m2504i(46566);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bjh();
        c1196a.fsK = new bji();
        c1196a.uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
        c1196a.fsI = 1565;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bjh bjh = (bjh) this.ehh.fsG.fsP;
        bjh.fKh = str;
        bjh.vYP = str4;
        bjh.vYO = str2;
        bjh.vYQ = str5;
        bjh.vYR = str6;
        bjh.vLo = str3;
        bjh.vXP = str7;
        AppMethodBeat.m2505o(46566);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(46567);
        C4990ab.m7417i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        bji bji = (bji) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i == 0) {
            i2 = bji.luT;
            str = bji.luU;
        }
        C4990ab.m7417i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", Integer.valueOf(bji.wMH));
        this.tuI = bji.wMH;
        this.tux = new Orders();
        this.tux.tuo = 1;
        if (bji == null || bji.wME == null) {
            C4990ab.m7412e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
        } else {
            Iterator it;
            this.tux.pTN = (double) bji.wME.wMK;
            Commodity commodity = new Commodity();
            commodity.cAa = bji.wME.pQe;
            commodity.desc = bji.wME.fFZ;
            commodity.kCJ = ((double) bji.wME.wMK) / 100.0d;
            commodity.pce = String.valueOf(bji.wME.wMM);
            commodity.pcf = bji.wME.wMN;
            commodity.pcj = bji.wME.wMJ;
            commodity.pch = bji.wME.wMI;
            commodity.pcl = bji.wME.pcl;
            commodity.pca = bji.wME.wML;
            commodity.tAR = ((double) bji.wME.wMO) / 100.0d;
            if (bji.wMF != null) {
                commodity.pcm = bji.wMF.vTT;
                Promotions promotions = new Promotions();
                promotions.name = bji.wMF.wMp;
                promotions.pcm = bji.wMF.vTT;
                commodity.tAS = bji.wMF.vTT;
                promotions.pia = bji.wMF.kbV;
                commodity.tAh = bji.wMF.wMn;
                promotions.type = Orders.tAP;
                if (!C5046bo.isNullOrNil(promotions.name)) {
                    commodity.tBa.add(promotions);
                    commodity.tBb = true;
                }
                this.tux.tAh = bji.wMF.wMn;
            } else {
                C4990ab.m7416i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
                this.tux.tAh = 0;
            }
            if (bji.wME.wMP != null && bji.wME.wMP.size() > 0) {
                commodity.tAU = new ArrayList();
                it = bji.wME.wMP.iterator();
                while (it.hasNext()) {
                    bja bja = (bja) it.next();
                    DiscountInfo discountInfo = new DiscountInfo();
                    discountInfo.pOz = bja.wMq;
                    commodity.tAU.add(discountInfo);
                }
            }
            if (bji.wMG != null && bji.wMG.size() > 0) {
                commodity.tBa = new ArrayList();
                it = bji.wMG.iterator();
                while (it.hasNext()) {
                    biw biw = (biw) it.next();
                    Promotions promotions2 = new Promotions();
                    promotions2.type = Orders.tAQ;
                    promotions2.url = biw.url;
                    promotions2.name = biw.cEh;
                    promotions2.pia = biw.cIY;
                    promotions2.tzS = biw.tID;
                    promotions2.tBn = C5046bo.getInt(biw.type, 0);
                    promotions2.title = biw.title;
                    promotions2.ttW = biw.tBx;
                    promotions2.uZM = (int) biw.tBy;
                    promotions2.uZO = biw.tzT;
                    promotions2.uZN = (int) biw.tBz;
                    promotions2.tzP = biw.tBA;
                    promotions2.tzQ = biw.tBB;
                    promotions2.uZP = biw.wMk;
                    promotions2.uZQ = biw.wMl;
                    promotions2.tzR = biw.tBC;
                    promotions2.uZR = biw.wMm;
                    commodity.tBa.add(promotions2);
                }
            }
            this.tux.tAq = new ArrayList();
            this.tux.tAq.add(commodity);
            this.tux.tAj = bji.wME.wMN;
            C4990ab.m7417i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", Integer.valueOf(this.tux.tAq.size()), this.tux);
        }
        if (C5046bo.isNullOrNil(str)) {
            str = C4996ah.getContext().getString(C25738R.string.fdx);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(46567);
    }

    public final int getType() {
        return 1565;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46568);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46568);
        return a;
    }
}
