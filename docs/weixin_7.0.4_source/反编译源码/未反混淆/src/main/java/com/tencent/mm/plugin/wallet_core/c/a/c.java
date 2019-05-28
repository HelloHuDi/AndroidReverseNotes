package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;
import java.util.ArrayList;
import java.util.Iterator;

public final class c extends u {
    private b ehh;
    private f ehi;
    public int tuI = 0;
    public Orders tux;

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(46566);
        a aVar = new a();
        aVar.fsJ = new bjh();
        aVar.fsK = new bji();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
        aVar.fsI = 1565;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bjh bjh = (bjh) this.ehh.fsG.fsP;
        bjh.fKh = str;
        bjh.vYP = str4;
        bjh.vYO = str2;
        bjh.vYQ = str5;
        bjh.vYR = str6;
        bjh.vLo = str3;
        bjh.vXP = str7;
        AppMethodBeat.o(46566);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(46567);
        ab.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        bji bji = (bji) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i == 0) {
            i2 = bji.luT;
            str = bji.luU;
        }
        ab.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", Integer.valueOf(bji.wMH));
        this.tuI = bji.wMH;
        this.tux = new Orders();
        this.tux.tuo = 1;
        if (bji == null || bji.wME == null) {
            ab.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
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
                if (!bo.isNullOrNil(promotions.name)) {
                    commodity.tBa.add(promotions);
                    commodity.tBb = true;
                }
                this.tux.tAh = bji.wMF.wMn;
            } else {
                ab.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
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
                    promotions2.tBn = bo.getInt(biw.type, 0);
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
            ab.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", Integer.valueOf(this.tux.tAq.size()), this.tux);
        }
        if (bo.isNullOrNil(str)) {
            str = ah.getContext().getString(R.string.fdx);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(46567);
    }

    public final int getType() {
        return 1565;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46568);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46568);
        return a;
    }
}
