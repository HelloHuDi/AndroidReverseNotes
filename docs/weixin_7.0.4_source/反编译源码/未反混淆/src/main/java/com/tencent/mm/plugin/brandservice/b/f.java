package com.tencent.mm.plugin.brandservice.b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends m implements k {
    private static long jKz = 0;
    private b ehh;
    private com.tencent.mm.ai.f ehi;

    public static boolean aVV() {
        AppMethodBeat.i(13839);
        if (System.currentTimeMillis() - jKz > 3600000) {
            AppMethodBeat.o(13839);
            return true;
        }
        AppMethodBeat.o(13839);
        return false;
    }

    public final int getType() {
        return 456;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(13840);
        jKz = System.currentTimeMillis();
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new asb();
        aVar.fsK = new asc();
        aVar.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
        aVar.fsI = 456;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13840);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13841);
        ab.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            asc asc = (asc) this.ehh.fsH.fsP;
            if (asc.wvP.wHG > 0) {
                ab.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", Integer.valueOf(asc.wvP.wHG));
                try {
                    byte[] toByteArray = asc.wvP.toByteArray();
                    com.tencent.mm.vfs.e.b(g.RP().eJM + "search_biz_recommend", toByteArray, toByteArray.length);
                    Iterator it = asc.wvP.wSD.iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((bqh) it.next()).wSC.iterator();
                        while (it2.hasNext()) {
                            bvn bvn = (bvn) it2.next();
                            h hVar = new h();
                            hVar.username = aa.a(bvn.wcB);
                            hVar.frW = bvn.vXm;
                            hVar.frV = bvn.vXn;
                            hVar.bJt = -1;
                            hVar.dtR = 3;
                            hVar.cB(true);
                            o.act().b(hVar);
                        }
                    }
                } catch (IOException e) {
                    ab.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e, "", new Object[0]);
                }
            } else {
                com.tencent.mm.vfs.e.deleteFile(g.RP().eJM + "search_biz_recommend");
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(13841);
    }

    public static LinkedList<bqh> aVW() {
        AppMethodBeat.i(13842);
        try {
            byte[] e = com.tencent.mm.vfs.e.e(g.RP().eJM + "search_biz_recommend", 0, BaseClientBuilder.API_PRIORITY_OTHER);
            if (e != null) {
                bqi bqi = new bqi();
                bqi.parseFrom(e);
                ab.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", Integer.valueOf(bqi.wHG));
                LinkedList linkedList = bqi.wSD;
                AppMethodBeat.o(13842);
                return linkedList;
            }
        } catch (Exception e2) {
            ab.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e2.getMessage());
            ab.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e2, "", new Object[0]);
        }
        LinkedList<bqh> linkedList2 = new LinkedList();
        AppMethodBeat.o(13842);
        return linkedList2;
    }
}
