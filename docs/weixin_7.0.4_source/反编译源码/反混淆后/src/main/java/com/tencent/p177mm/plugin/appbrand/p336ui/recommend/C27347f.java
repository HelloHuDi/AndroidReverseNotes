package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C45519f.C423691;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.protocal.protobuf.C46585sp;
import com.tencent.p177mm.protocal.protobuf.C46603zd;
import com.tencent.p177mm.protocal.protobuf.bqd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.f */
public final class C27347f {
    private long iQa = 0;
    private long iQb = 0;
    private long iQc = 0;
    private boolean iQd = false;
    private HashMap<String, C46603zd> iQe = new HashMap();
    private LinkedList<C46585sp> iQf = new LinkedList();
    private HashMap<String, C46585sp> iQg = new HashMap();

    public C27347f() {
        AppMethodBeat.m2504i(133566);
        AppMethodBeat.m2505o(133566);
    }

    public final void aNG() {
        AppMethodBeat.m2504i(133567);
        aNH();
        AppMethodBeat.m2505o(133567);
    }

    private void aNH() {
        AppMethodBeat.m2504i(133568);
        this.iQb = C5046bo.anT();
        this.iQa = this.iQb;
        this.iQd = false;
        this.iQe.clear();
        this.iQf.clear();
        this.iQg.clear();
        this.iQc = 0;
        AppMethodBeat.m2505o(133568);
    }

    public final void aNI() {
        AppMethodBeat.m2504i(138700);
        this.iQb = C5046bo.anT();
        AppMethodBeat.m2505o(138700);
    }

    public final void aNJ() {
        AppMethodBeat.m2504i(138701);
        this.iQc = (C5046bo.anT() - this.iQb) + this.iQc;
        this.iQb = C5046bo.anT();
        AppMethodBeat.m2505o(138701);
    }

    /* renamed from: eK */
    public final void mo45030eK(boolean z) {
        this.iQd = z;
    }

    private LinkedList<C46603zd> aNK() {
        AppMethodBeat.m2504i(133569);
        LinkedList linkedList = new LinkedList();
        for (String str : this.iQe.keySet()) {
            linkedList.add(this.iQe.get(str));
        }
        C4990ab.m7411d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", Integer.valueOf(this.iQe.size()));
        AppMethodBeat.m2505o(133569);
        return linkedList;
    }

    /* renamed from: gu */
    public final void mo45031gu(long j) {
        int i;
        long j2 = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
        AppMethodBeat.m2504i(133570);
        if (this.iQf.size() == 0) {
            int i2;
            if (this.iQe.size() > 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                C4990ab.m7412e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
                AppMethodBeat.m2505o(133570);
                return;
            }
        }
        C4990ab.m7416i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
        long anT = C5046bo.anT() - this.iQb;
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
        C4990ab.m7417i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", Long.valueOf(j), Integer.valueOf(this.iQf.size()), Integer.valueOf(aNK.size()), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(this.iQa));
        C27347f.m43409a(this.iQf, aNK);
        int i3 = (int) j2;
        int i4 = (int) this.iQa;
        C4990ab.m7410d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
        C42677e.aNS().mo10302aa(new C423691(j, aNK, linkedList, i, i3, i4));
        aNH();
        AppMethodBeat.m2505o(133570);
    }

    /* renamed from: a */
    private static void m43409a(LinkedList<C46585sp> linkedList, LinkedList<C46603zd> linkedList2) {
        Iterator it;
        StringBuilder stringBuilder;
        AppMethodBeat.m2504i(133571);
        if (linkedList.size() > 0) {
            it = linkedList.iterator();
            while (it.hasNext()) {
                C46585sp c46585sp = (C46585sp) it.next();
                stringBuilder = new StringBuilder();
                stringBuilder.append("{");
                stringBuilder.append("username:").append(c46585sp.username).append(",");
                stringBuilder.append("recommend_id:").append(c46585sp.izZ).append(",");
                stringBuilder.append("item_count:").append(c46585sp.wad).append(",");
                stringBuilder.append("footnote_count:").append(c46585sp.wae).append(",");
                stringBuilder.append("strategy_info:").append(c46585sp.iAa).append(",");
                stringBuilder.append("appid:").append(c46585sp.csB).append(",");
                stringBuilder.append("page_path:").append(c46585sp.iAb).append(",");
                stringBuilder.append("page_param:").append(c46585sp.iAc).append(",");
                stringBuilder.append("card_type:").append(c46585sp.iAd).append(",");
                stringBuilder.append("pass_str:").append(c46585sp.iAe).append(",");
                stringBuilder.append("},");
                C4990ab.m7417i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", stringBuilder.toString());
            }
        }
        if (linkedList2.size() > 0) {
            it = linkedList2.iterator();
            while (it.hasNext()) {
                C46603zd c46603zd = (C46603zd) it.next();
                stringBuilder = new StringBuilder();
                stringBuilder.append("{");
                stringBuilder.append("username:").append(c46603zd.username).append(",");
                stringBuilder.append("recommend_id:").append(c46603zd.izZ).append(",");
                stringBuilder.append("count:").append(c46603zd.count).append(",");
                stringBuilder.append("strategy_info:").append(c46603zd.iAa).append(",");
                stringBuilder.append("expose_millisecond:").append(c46603zd.wez).append(",");
                stringBuilder.append("appid:").append(c46603zd.csB).append(",");
                stringBuilder.append("page_path:").append(c46603zd.iAb).append(",");
                stringBuilder.append("page_param:").append(c46603zd.iAc).append(",");
                stringBuilder.append("card_type:").append(c46603zd.iAd).append(",");
                stringBuilder.append("pass_str:").append(c46603zd.iAe).append(",");
                stringBuilder.append("},");
                C4990ab.m7411d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", stringBuilder.toString());
            }
        }
        AppMethodBeat.m2505o(133571);
    }

    /* renamed from: a */
    public final void mo45024a(int i, bqd bqd) {
        AppMethodBeat.m2504i(133572);
        if (bqd == null) {
            AppMethodBeat.m2505o(133572);
            return;
        }
        C4990ab.m7417i("MicroMsg.Recommend.AppBrandRecommendReport", "reportContentClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommend_id:%s", Integer.valueOf(i), bqd.wSq, bqd.wSw, Integer.valueOf(bqd.iAd), bqd.izZ);
        C46585sp c46585sp;
        if (this.iQg.containsKey(bqd.izZ)) {
            c46585sp = (C46585sp) this.iQg.get(bqd.izZ);
            c46585sp.wad++;
            AppMethodBeat.m2505o(133572);
            return;
        }
        c46585sp = C27347f.m43410c(i, bqd);
        c46585sp.wad = 1;
        c46585sp.wae = 0;
        this.iQg.put(bqd.izZ, c46585sp);
        this.iQf.add(c46585sp);
        AppMethodBeat.m2505o(133572);
    }

    /* renamed from: b */
    public final void mo45028b(int i, bqd bqd) {
        AppMethodBeat.m2504i(133573);
        if (bqd == null) {
            AppMethodBeat.m2505o(133573);
            return;
        }
        C4990ab.m7417i("MicroMsg.Recommend.AppBrandRecommendReport", "reportFooterClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommendId:%s", Integer.valueOf(i), bqd.wSq, bqd.wSw, Integer.valueOf(bqd.iAd), bqd.izZ);
        C46585sp c46585sp;
        if (this.iQg.containsKey(bqd.izZ)) {
            c46585sp = (C46585sp) this.iQg.get(bqd.izZ);
            c46585sp.wae++;
            AppMethodBeat.m2505o(133573);
            return;
        }
        c46585sp = C27347f.m43410c(i, bqd);
        c46585sp.wad = 0;
        c46585sp.wae = 1;
        this.iQg.put(bqd.izZ, c46585sp);
        this.iQf.add(c46585sp);
        AppMethodBeat.m2505o(133573);
    }

    /* renamed from: c */
    private static C46585sp m43410c(int i, bqd bqd) {
        AppMethodBeat.m2504i(133574);
        C46585sp c46585sp = new C46585sp();
        c46585sp.username = bqd.wSq;
        c46585sp.izZ = bqd.izZ;
        c46585sp.iAa = bqd.iAa;
        c46585sp.iAb = bqd.iAb;
        c46585sp.iAc = bqd.iAc;
        c46585sp.iAd = bqd.iAd;
        c46585sp.iAe = bqd.iAe;
        c46585sp.position = i + 1;
        WxaAttributes d = C42340f.auO().mo21572d(bqd.wSq, new String[0]);
        if (d != null) {
            c46585sp.csB = d.field_appId;
        }
        AppMethodBeat.m2505o(133574);
        return c46585sp;
    }

    /* renamed from: y */
    public final void mo45032y(String str, long j) {
        AppMethodBeat.m2504i(133576);
        if (this.iQe.containsKey(str)) {
            C46603zd c46603zd = (C46603zd) this.iQe.get(str);
            c46603zd.wez = (int) (((long) c46603zd.wez) + j);
            this.iQe.put(str, c46603zd);
        }
        AppMethodBeat.m2505o(133576);
    }

    /* renamed from: d */
    public final void mo45029d(int i, bqd bqd) {
        AppMethodBeat.m2504i(133575);
        C46603zd c46603zd;
        if (this.iQe.containsKey(bqd.izZ)) {
            c46603zd = (C46603zd) this.iQe.get(bqd.izZ);
            c46603zd.count++;
            this.iQe.put(bqd.izZ, c46603zd);
            AppMethodBeat.m2505o(133575);
            return;
        }
        c46603zd = new C46603zd();
        c46603zd.username = bqd.wSq;
        c46603zd.count = 1;
        c46603zd.izZ = bqd.izZ;
        c46603zd.iAa = bqd.iAa;
        c46603zd.wez = 0;
        c46603zd.iAb = bqd.iAb;
        c46603zd.iAc = bqd.iAc;
        c46603zd.iAd = bqd.iAd;
        c46603zd.iAe = bqd.iAe;
        c46603zd.position = i + 1;
        WxaAttributes d = C42340f.auO().mo21572d(bqd.wSq, new String[0]);
        if (d != null) {
            c46603zd.csB = d.field_appId;
        }
        this.iQe.put(bqd.izZ, c46603zd);
        AppMethodBeat.m2505o(133575);
    }
}
