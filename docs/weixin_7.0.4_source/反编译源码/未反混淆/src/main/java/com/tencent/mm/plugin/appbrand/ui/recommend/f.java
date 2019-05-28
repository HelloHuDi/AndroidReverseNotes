package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.a.f.AnonymousClass1;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f {
    private long iQa = 0;
    private long iQb = 0;
    private long iQc = 0;
    private boolean iQd = false;
    private HashMap<String, zd> iQe = new HashMap();
    private LinkedList<sp> iQf = new LinkedList();
    private HashMap<String, sp> iQg = new HashMap();

    public f() {
        AppMethodBeat.i(133566);
        AppMethodBeat.o(133566);
    }

    public final void aNG() {
        AppMethodBeat.i(133567);
        aNH();
        AppMethodBeat.o(133567);
    }

    private void aNH() {
        AppMethodBeat.i(133568);
        this.iQb = bo.anT();
        this.iQa = this.iQb;
        this.iQd = false;
        this.iQe.clear();
        this.iQf.clear();
        this.iQg.clear();
        this.iQc = 0;
        AppMethodBeat.o(133568);
    }

    public final void aNI() {
        AppMethodBeat.i(138700);
        this.iQb = bo.anT();
        AppMethodBeat.o(138700);
    }

    public final void aNJ() {
        AppMethodBeat.i(138701);
        this.iQc = (bo.anT() - this.iQb) + this.iQc;
        this.iQb = bo.anT();
        AppMethodBeat.o(138701);
    }

    public final void eK(boolean z) {
        this.iQd = z;
    }

    private LinkedList<zd> aNK() {
        AppMethodBeat.i(133569);
        LinkedList linkedList = new LinkedList();
        for (String str : this.iQe.keySet()) {
            linkedList.add(this.iQe.get(str));
        }
        ab.d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", Integer.valueOf(this.iQe.size()));
        AppMethodBeat.o(133569);
        return linkedList;
    }

    public final void gu(long j) {
        int i;
        long j2 = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
        AppMethodBeat.i(133570);
        if (this.iQf.size() == 0) {
            int i2;
            if (this.iQe.size() > 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                ab.e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
                AppMethodBeat.o(133570);
                return;
            }
        }
        ab.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
        long anT = bo.anT() - this.iQb;
        if (anT < TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            j2 = this.iQc + anT;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.iQf);
        LinkedList aNK = aNK();
        if (this.iQd) {
            i = 1;
        } else {
            i = 0;
        }
        ab.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", Long.valueOf(j), Integer.valueOf(this.iQf.size()), Integer.valueOf(aNK.size()), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(this.iQa));
        a(this.iQf, aNK);
        int i3 = (int) j2;
        int i4 = (int) this.iQa;
        ab.d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
        e.aNS().aa(new AnonymousClass1(j, aNK, linkedList, i, i3, i4));
        aNH();
        AppMethodBeat.o(133570);
    }

    private static void a(LinkedList<sp> linkedList, LinkedList<zd> linkedList2) {
        Iterator it;
        StringBuilder stringBuilder;
        AppMethodBeat.i(133571);
        if (linkedList.size() > 0) {
            it = linkedList.iterator();
            while (it.hasNext()) {
                sp spVar = (sp) it.next();
                stringBuilder = new StringBuilder();
                stringBuilder.append("{");
                stringBuilder.append("username:").append(spVar.username).append(",");
                stringBuilder.append("recommend_id:").append(spVar.izZ).append(",");
                stringBuilder.append("item_count:").append(spVar.wad).append(",");
                stringBuilder.append("footnote_count:").append(spVar.wae).append(",");
                stringBuilder.append("strategy_info:").append(spVar.iAa).append(",");
                stringBuilder.append("appid:").append(spVar.csB).append(",");
                stringBuilder.append("page_path:").append(spVar.iAb).append(",");
                stringBuilder.append("page_param:").append(spVar.iAc).append(",");
                stringBuilder.append("card_type:").append(spVar.iAd).append(",");
                stringBuilder.append("pass_str:").append(spVar.iAe).append(",");
                stringBuilder.append("},");
                ab.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", stringBuilder.toString());
            }
        }
        if (linkedList2.size() > 0) {
            it = linkedList2.iterator();
            while (it.hasNext()) {
                zd zdVar = (zd) it.next();
                stringBuilder = new StringBuilder();
                stringBuilder.append("{");
                stringBuilder.append("username:").append(zdVar.username).append(",");
                stringBuilder.append("recommend_id:").append(zdVar.izZ).append(",");
                stringBuilder.append("count:").append(zdVar.count).append(",");
                stringBuilder.append("strategy_info:").append(zdVar.iAa).append(",");
                stringBuilder.append("expose_millisecond:").append(zdVar.wez).append(",");
                stringBuilder.append("appid:").append(zdVar.csB).append(",");
                stringBuilder.append("page_path:").append(zdVar.iAb).append(",");
                stringBuilder.append("page_param:").append(zdVar.iAc).append(",");
                stringBuilder.append("card_type:").append(zdVar.iAd).append(",");
                stringBuilder.append("pass_str:").append(zdVar.iAe).append(",");
                stringBuilder.append("},");
                ab.d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", stringBuilder.toString());
            }
        }
        AppMethodBeat.o(133571);
    }

    public final void a(int i, bqd bqd) {
        AppMethodBeat.i(133572);
        if (bqd == null) {
            AppMethodBeat.o(133572);
            return;
        }
        ab.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportContentClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommend_id:%s", Integer.valueOf(i), bqd.wSq, bqd.wSw, Integer.valueOf(bqd.iAd), bqd.izZ);
        sp spVar;
        if (this.iQg.containsKey(bqd.izZ)) {
            spVar = (sp) this.iQg.get(bqd.izZ);
            spVar.wad++;
            AppMethodBeat.o(133572);
            return;
        }
        spVar = c(i, bqd);
        spVar.wad = 1;
        spVar.wae = 0;
        this.iQg.put(bqd.izZ, spVar);
        this.iQf.add(spVar);
        AppMethodBeat.o(133572);
    }

    public final void b(int i, bqd bqd) {
        AppMethodBeat.i(133573);
        if (bqd == null) {
            AppMethodBeat.o(133573);
            return;
        }
        ab.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportFooterClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommendId:%s", Integer.valueOf(i), bqd.wSq, bqd.wSw, Integer.valueOf(bqd.iAd), bqd.izZ);
        sp spVar;
        if (this.iQg.containsKey(bqd.izZ)) {
            spVar = (sp) this.iQg.get(bqd.izZ);
            spVar.wae++;
            AppMethodBeat.o(133573);
            return;
        }
        spVar = c(i, bqd);
        spVar.wad = 0;
        spVar.wae = 1;
        this.iQg.put(bqd.izZ, spVar);
        this.iQf.add(spVar);
        AppMethodBeat.o(133573);
    }

    private static sp c(int i, bqd bqd) {
        AppMethodBeat.i(133574);
        sp spVar = new sp();
        spVar.username = bqd.wSq;
        spVar.izZ = bqd.izZ;
        spVar.iAa = bqd.iAa;
        spVar.iAb = bqd.iAb;
        spVar.iAc = bqd.iAc;
        spVar.iAd = bqd.iAd;
        spVar.iAe = bqd.iAe;
        spVar.position = i + 1;
        WxaAttributes d = com.tencent.mm.plugin.appbrand.app.f.auO().d(bqd.wSq, new String[0]);
        if (d != null) {
            spVar.csB = d.field_appId;
        }
        AppMethodBeat.o(133574);
        return spVar;
    }

    public final void y(String str, long j) {
        AppMethodBeat.i(133576);
        if (this.iQe.containsKey(str)) {
            zd zdVar = (zd) this.iQe.get(str);
            zdVar.wez = (int) (((long) zdVar.wez) + j);
            this.iQe.put(str, zdVar);
        }
        AppMethodBeat.o(133576);
    }

    public final void d(int i, bqd bqd) {
        AppMethodBeat.i(133575);
        zd zdVar;
        if (this.iQe.containsKey(bqd.izZ)) {
            zdVar = (zd) this.iQe.get(bqd.izZ);
            zdVar.count++;
            this.iQe.put(bqd.izZ, zdVar);
            AppMethodBeat.o(133575);
            return;
        }
        zdVar = new zd();
        zdVar.username = bqd.wSq;
        zdVar.count = 1;
        zdVar.izZ = bqd.izZ;
        zdVar.iAa = bqd.iAa;
        zdVar.wez = 0;
        zdVar.iAb = bqd.iAb;
        zdVar.iAc = bqd.iAc;
        zdVar.iAd = bqd.iAd;
        zdVar.iAe = bqd.iAe;
        zdVar.position = i + 1;
        WxaAttributes d = com.tencent.mm.plugin.appbrand.app.f.auO().d(bqd.wSq, new String[0]);
        if (d != null) {
            zdVar.csB = d.field_appId;
        }
        this.iQe.put(bqd.izZ, zdVar);
        AppMethodBeat.o(133575);
    }
}
