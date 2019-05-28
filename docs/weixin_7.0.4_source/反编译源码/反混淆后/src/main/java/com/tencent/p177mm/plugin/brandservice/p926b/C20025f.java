package com.tencent.p177mm.plugin.brandservice.p926b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.asb;
import com.tencent.p177mm.protocal.protobuf.asc;
import com.tencent.p177mm.protocal.protobuf.bqh;
import com.tencent.p177mm.protocal.protobuf.bqi;
import com.tencent.p177mm.protocal.protobuf.bvn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.b.f */
public final class C20025f extends C1207m implements C1918k {
    private static long jKz = 0;
    private C7472b ehh;
    private C1202f ehi;

    public static boolean aVV() {
        AppMethodBeat.m2504i(13839);
        if (System.currentTimeMillis() - jKz > 3600000) {
            AppMethodBeat.m2505o(13839);
            return true;
        }
        AppMethodBeat.m2505o(13839);
        return false;
    }

    public final int getType() {
        return 456;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13840);
        jKz = System.currentTimeMillis();
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new asb();
        c1196a.fsK = new asc();
        c1196a.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
        c1196a.fsI = 456;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13840);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13841);
        C4990ab.m7410d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            asc asc = (asc) this.ehh.fsH.fsP;
            if (asc.wvP.wHG > 0) {
                C4990ab.m7411d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", Integer.valueOf(asc.wvP.wHG));
                try {
                    byte[] toByteArray = asc.wvP.toByteArray();
                    C5730e.m8624b(C1720g.m3536RP().eJM + "search_biz_recommend", toByteArray, toByteArray.length);
                    Iterator it = asc.wvP.wSD.iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((bqh) it.next()).wSC.iterator();
                        while (it2.hasNext()) {
                            bvn bvn = (bvn) it2.next();
                            C17880h c17880h = new C17880h();
                            c17880h.username = C1946aa.m4148a(bvn.wcB);
                            c17880h.frW = bvn.vXm;
                            c17880h.frV = bvn.vXn;
                            c17880h.bJt = -1;
                            c17880h.dtR = 3;
                            c17880h.mo33385cB(true);
                            C17884o.act().mo33391b(c17880h);
                        }
                    }
                } catch (IOException e) {
                    C4990ab.m7410d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e, "", new Object[0]);
                }
            } else {
                C5730e.deleteFile(C1720g.m3536RP().eJM + "search_biz_recommend");
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(13841);
    }

    public static LinkedList<bqh> aVW() {
        AppMethodBeat.m2504i(13842);
        try {
            byte[] e = C5730e.m8632e(C1720g.m3536RP().eJM + "search_biz_recommend", 0, BaseClientBuilder.API_PRIORITY_OTHER);
            if (e != null) {
                bqi bqi = new bqi();
                bqi.parseFrom(e);
                C4990ab.m7411d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", Integer.valueOf(bqi.wHG));
                LinkedList linkedList = bqi.wSD;
                AppMethodBeat.m2505o(13842);
                return linkedList;
            }
        } catch (Exception e2) {
            C4990ab.m7410d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e2.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e2, "", new Object[0]);
        }
        LinkedList<bqh> linkedList2 = new LinkedList();
        AppMethodBeat.m2505o(13842);
        return linkedList2;
    }
}
