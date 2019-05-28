package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.LinearLayoutManager;
import android.webkit.URLUtil;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.u;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wxmm.v2helper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n {
    f fur = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            boolean z = true;
            AppMethodBeat.i(1760);
            ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), mVar);
            if (mVar.equals(n.this.sFa)) {
                g.Rg().b(1943, n.this.fur);
                n.this.sFa = null;
                j jVar = (j) mVar;
                if (i == 0 && i2 == 0) {
                    a aVar = new a(n.this, (byte) 0);
                    aVar.lWq = jVar.cFt().vOy;
                    if (jVar.sBa.offset != 0) {
                        z = false;
                    }
                    aVar.mTL = z;
                    d.post(aVar, "TopStory.DecodeRecommendResultTask");
                } else {
                    ab.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", jVar.cFt().vOy);
                    com.tencent.mm.plugin.websearch.api.a.a.kT(2);
                    n.this.sDo.abH(str);
                    n.this.sEY = false;
                    AppMethodBeat.o(1760);
                    return;
                }
            }
            AppMethodBeat.o(1760);
        }
    };
    public b sDo;
    public boolean sEY;
    public int sEZ;
    j sFa;
    private int sFb;
    private int sFc;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.n$1 */
    public class AnonymousClass1 implements f {
        final /* synthetic */ j sFd;

        public AnonymousClass1(j jVar) {
            this.sFd = jVar;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(1757);
            if (mVar == this.sFd) {
                g.Rg().b(1943, (f) this);
                final j jVar = (j) mVar;
                if (i == 0 && i2 == 0) {
                    d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(1756);
                            try {
                                JSONArray optJSONArray = new JSONObject(jVar.cFt().vOy).optJSONArray("data");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=json data error");
                                    AppMethodBeat.o(1756);
                                    return;
                                }
                                final List b = n.b(n.this.sDo.cGb(), optJSONArray);
                                al.d(new Runnable() {
                                    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x00c3=Splitter:B:29:0x00c3, B:36:0x0103=Splitter:B:36:0x0103} */
                                    /* JADX WARNING: Missing block: B:14:0x0055, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=item exist");
     */
                                    /* JADX WARNING: Missing block: B:18:?, code skipped:
            r2 = ((com.tencent.mm.protocal.protobuf.chw) r0.get(0)).voe;
            r5 = r10.sFi.sFg.sFe.sDo.cFY();
            r6 = r10.sFi.sFg.sFe.sDo.cGa().getHeadersCount();
            r1 = ((android.support.v7.widget.LinearLayoutManager) r10.sFi.sFg.sFe.sDo.getLayoutManager()).iS() - r6;
            r7 = r4.size() - 1;
     */
                                    /* JADX WARNING: Missing block: B:19:0x00a7, code skipped:
            if (r5 != r7) goto L_0x00b7;
     */
                                    /* JADX WARNING: Missing block: B:20:0x00a9, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=last pos");
     */
                                    /* JADX WARNING: Missing block: B:22:0x00b3, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(1755);
     */
                                    /* JADX WARNING: Missing block: B:23:0x00b7, code skipped:
            if (r2 <= r5) goto L_0x00bd;
     */
                                    /* JADX WARNING: Missing block: B:25:0x00bb, code skipped:
            if (r2 <= (r7 + 1)) goto L_0x0113;
     */
                                    /* JADX WARNING: Missing block: B:26:0x00bd, code skipped:
            r1 = r1 + 1;
     */
                                    /* JADX WARNING: Missing block: B:27:0x00bf, code skipped:
            if (r1 > 0) goto L_0x00c3;
     */
                                    /* JADX WARNING: Missing block: B:28:0x00c1, code skipped:
            r1 = r5 + 1;
     */
                                    /* JADX WARNING: Missing block: B:31:0x00c7, code skipped:
            if (r1 <= r4.size()) goto L_0x00cd;
     */
                                    /* JADX WARNING: Missing block: B:32:0x00c9, code skipped:
            r1 = r4.size();
     */
                                    /* JADX WARNING: Missing block: B:33:0x00cd, code skipped:
            r4.add(r1, r0);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "insert success pos:%s, vid[%s], title:%s", java.lang.Integer.valueOf(r1), r0.xgS, r0.title);
            r10.sFi.sFg.sFe.sDo.cGa().ch(r1 + r6);
     */
                                    /* JADX WARNING: Missing block: B:35:0x00fe, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(1755);
     */
                                    /* JADX WARNING: Missing block: B:40:0x0113, code skipped:
            r1 = r2;
     */
                                    /* JADX WARNING: Missing block: B:43:?, code skipped:
            return;
     */
                                    /* JADX WARNING: Missing block: B:44:?, code skipped:
            return;
     */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final void run() {
                                        int i = 0;
                                        AppMethodBeat.i(1755);
                                        synchronized (n.this) {
                                            try {
                                                List cGQ = n.this.cGQ();
                                                if (!bo.ek(b) && !bo.ek(cGQ) && (n.this.sDo.getLayoutManager() instanceof LinearLayoutManager)) {
                                                    chw chw = (chw) b.get(0);
                                                    while (true) {
                                                        int i2 = i;
                                                        if (i2 >= cGQ.size()) {
                                                            break;
                                                        } else if (((chw) cGQ.get(i2)).xgS.equals(chw.xgS)) {
                                                            break;
                                                        } else {
                                                            i = i2 + 1;
                                                        }
                                                    }
                                                } else {
                                                    ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=result list or curlist is null");
                                                }
                                            } finally {
                                                AppMethodBeat.o(1755);
                                            }
                                        }
                                    }
                                });
                                AppMethodBeat.o(1756);
                            } catch (Exception e) {
                                ab.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=" + e.getMessage());
                                AppMethodBeat.o(1756);
                            }
                        }
                    }, "TopStory.requestRelVideo");
                } else {
                    ab.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo failed!, errType:%s, errCode:%s, response json: %s", Integer.valueOf(i), Integer.valueOf(i2), jVar.cFt().vOy);
                    AppMethodBeat.o(1757);
                    return;
                }
            }
            AppMethodBeat.o(1757);
        }
    }

    class a implements Runnable {
        private String lWq;
        private boolean mTL;

        private a() {
        }

        /* synthetic */ a(n nVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(1761);
            try {
                n.a(n.this, new JSONObject(this.lWq), this.mTL);
            } catch (Exception e) {
            } finally {
                n.this.sEY = false;
                AppMethodBeat.o(1761);
            }
        }
    }

    static /* synthetic */ List b(boolean z, JSONArray jSONArray) {
        AppMethodBeat.i(1775);
        List a = a(z, jSONArray);
        AppMethodBeat.o(1775);
        return a;
    }

    static /* synthetic */ void b(chw chw, String str, String str2) {
        AppMethodBeat.i(1776);
        a(chw, str, str2);
        AppMethodBeat.o(1776);
    }

    public n() {
        AppMethodBeat.i(1762);
        AppMethodBeat.o(1762);
    }

    public final List<chw> cGQ() {
        AppMethodBeat.i(1763);
        LinkedList linkedList = this.sDo.cFT().xgK;
        AppMethodBeat.o(1763);
        return linkedList;
    }

    public final int cGR() {
        AppMethodBeat.i(1764);
        int size = cGQ().size();
        AppMethodBeat.o(1764);
        return size;
    }

    public final void d(chw chw) {
        AppMethodBeat.i(1765);
        synchronized (this) {
            try {
                cGQ().add(chw);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(1765);
            }
        }
    }

    public final void FK(int i) {
        AppMethodBeat.i(1766);
        synchronized (this) {
            if (i >= 0) {
                try {
                    if (i < cGQ().size()) {
                        cGQ().remove(i);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(1766);
                    }
                }
            }
        }
        AppMethodBeat.o(1766);
    }

    public final chw FL(int i) {
        chw chw;
        AppMethodBeat.i(1767);
        synchronized (this) {
            if (i >= 0) {
                try {
                    if (i < cGQ().size()) {
                        chw = (chw) cGQ().get(i);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(1767);
                }
            }
            chw = null;
            AppMethodBeat.o(1767);
        }
        return chw;
    }

    public final boolean FM(int i) {
        AppMethodBeat.i(1768);
        if (this.sEY) {
            ab.w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
            AppMethodBeat.o(1768);
            return false;
        }
        tn tnVar;
        boolean z;
        tn tnVar2;
        String stringBuffer;
        ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", Integer.valueOf(i));
        this.sEY = true;
        chv a = com.tencent.mm.plugin.topstory.a.g.a(this.sDo.cFT());
        a.offset = i;
        if (!bo.isNullOrNil(this.sDo.cFT().xgC)) {
            tnVar = new tn();
            tnVar.key = "relevant_vid";
            tnVar.waE = this.sDo.cFT().xgC;
            a.tZG.add(tnVar);
        }
        if (!bo.isNullOrNil(this.sDo.cFT().xgD)) {
            tnVar = new tn();
            tnVar.key = "relevant_expand";
            tnVar.waE = this.sDo.cFT().xgD;
            a.tZG.add(tnVar);
        }
        if (!bo.isNullOrNil(this.sDo.cFT().xgE)) {
            tnVar = new tn();
            tnVar.key = "relevant_pre_searchid";
            tnVar.waE = this.sDo.cFT().xgE;
            a.tZG.add(tnVar);
        }
        if (!bo.isNullOrNil(this.sDo.cFT().xgF)) {
            tnVar = new tn();
            tnVar.key = "relevant_shared_openid";
            tnVar.waE = this.sDo.cFT().xgF;
            a.tZG.add(tnVar);
        }
        if (this.sDo.cFT().xgI != null) {
            tnVar = new tn();
            tnVar.key = "rec_category";
            tnVar.waD = this.sDo.cFT().xgI.wYN;
            a.tZG.add(tnVar);
        } else {
            tnVar = new tn();
            tnVar.key = "rec_category";
            tnVar.waD = this.sDo.cFT().xgG;
            a.tZG.add(tnVar);
        }
        Iterator it = a.tZG.iterator();
        while (it.hasNext()) {
            if ("show_tag_list".equals(((tn) it.next()).key)) {
                z = false;
                break;
            }
        }
        z = true;
        if (this.sDo.cFT().xgI != null && z) {
            tnVar = new tn();
            tnVar.key = "show_tag_list";
            tnVar.waE = this.sDo.cFT().xgI.id;
            a.tZG.add(tnVar);
        }
        tnVar = new tn();
        tnVar.key = "fetch_seed_videoinfo";
        if (this.sDo.cFT().xgI == null || bo.isNullOrNil(this.sDo.cFT().xgI.id)) {
            tnVar.waD = 1;
        } else {
            tnVar.waD = 0;
        }
        a.tZG.add(tnVar);
        if (cGR() == 1) {
            chw FL = FL(0);
            tnVar2 = new tn();
            tnVar2.key = "first_video_tag_list";
            tnVar2.waE = com.tencent.mm.plugin.topstory.a.g.dN(FL.wiH).toString();
            a.tZG.add(tnVar2);
        }
        o cFR = this.sDo.cFR();
        if (cFR.sFn.size() > 0) {
            ArrayList<b> arrayList = new ArrayList();
            arrayList.addAll(cFR.sFn.values());
            StringBuffer stringBuffer2 = new StringBuffer("");
            for (b bVar : arrayList) {
                stringBuffer2.append(bVar.sAY ? 1 : 0);
                stringBuffer2.append("_");
                stringBuffer2.append(bVar.sAX.xgS);
                stringBuffer2.append(";");
            }
            stringBuffer = stringBuffer2.toString();
        } else {
            stringBuffer = null;
        }
        if (!bo.isNullOrNil(stringBuffer)) {
            tnVar2 = new tn();
            tnVar2.key = "client_exposed_info";
            tnVar2.waE = stringBuffer;
            a.tZG.add(tnVar2);
        }
        tnVar = new tn();
        tnVar.key = "is_prefetch";
        tnVar.waD = (long) this.sEZ;
        a.tZG.add(tnVar);
        this.sFa = new j(a);
        g.Rg().a(this.sFa, 0);
        g.Rg().a(1943, this.fur);
        com.tencent.mm.plugin.websearch.api.a.a.kT(0);
        AppMethodBeat.o(1768);
        return true;
    }

    /* JADX WARNING: Missing block: B:19:0x0041, code skipped:
            r0 = new com.tencent.mm.plugin.topstory.a.c.e(r6, r2);
            com.tencent.mm.kernel.g.Rg().a(r0, 0);
            com.tencent.mm.kernel.g.Rg().a(r0.getType(), new com.tencent.mm.plugin.topstory.ui.video.n.AnonymousClass2(r5));
            com.tencent.matrix.trace.core.AppMethodBeat.o(1769);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(chv chv, int i) {
        AppMethodBeat.i(1769);
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                List cGQ = cGQ();
                if (bo.ek(cGQ) || i >= cGQ.size()) {
                } else {
                    int i2;
                    if (i > 0) {
                        i2 = i - 1;
                    } else {
                        i2 = i;
                    }
                    int i3 = i2;
                    while (i3 < cGQ.size() && i3 < i + 10) {
                        arrayList.add(((chw) cGQ.get(i3)).xgS);
                        i3++;
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(1769);
            }
        }
    }

    public final void aEX() {
        AppMethodBeat.i(1770);
        g.Rg().b(1943, this.fur);
        AppMethodBeat.o(1770);
    }

    private static List<chw> a(boolean z, JSONArray jSONArray) {
        AppMethodBeat.i(1771);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < jSONArray.length()) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                long optLong = jSONObject.optLong("resultType");
                long optLong2 = jSONObject.optLong("type");
                String optString = jSONObject.optString("expand");
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    long yz = bo.yz();
                    i = 0;
                    while (true) {
                        int i3 = i;
                        if (i3 >= optJSONArray.length()) {
                            break;
                        }
                        JSONObject optJSONObject;
                        jSONObject = (JSONObject) optJSONArray.get(i3);
                        String optString2 = jSONObject.optString("videoApi");
                        String optString3 = jSONObject.optString("videoId");
                        String optString4 = jSONObject.optString("videoPlatform");
                        String optString5 = jSONObject.optString("docID");
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("show_tag_list");
                        JSONArray jSONArray2 = null;
                        if (!jSONObject.optBoolean("not_show_feedback", false)) {
                            optJSONObject = jSONObject.optJSONObject("feedbackObj");
                            if (optJSONObject != null) {
                                jSONArray2 = optJSONObject.optJSONArray("feedbackData");
                            }
                        }
                        int optInt = jSONObject.optInt("mediaDuration", 0);
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("videoInfo");
                        optJSONObject = null;
                        if (optJSONObject2 != null) {
                            optJSONObject = optJSONObject2.optJSONObject("videoCdnInfo");
                        }
                        if (!bo.isNullOrNil(optString3)) {
                            Object obj;
                            int i4;
                            chw chw = new chw();
                            chw.xgS = optString3;
                            int i5 = 0;
                            if (optJSONObject != null) {
                                i5 = optJSONObject.optInt("cdnScene", 0);
                            }
                            if (i5 == 1 || i5 == 2) {
                                if (a(i5, chw, optJSONObject)) {
                                    obj = 1;
                                }
                            } else if (!bo.isNullOrNil(optString2)) {
                                a(chw, optString2, optString4);
                                if (bo.ek(chw.xhb)) {
                                    com.tencent.mm.plugin.websearch.api.a.a.kT(29);
                                    ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi retry");
                                    a(chw, optString2, optString4);
                                }
                                obj = null;
                            }
                            chy dM = com.tencent.mm.plugin.topstory.a.g.dM(chw.xhb);
                            if (dM != null) {
                                chw.videoUrl = dM.url;
                                chw.xhg = dM.xhg;
                            }
                            if (bo.isNullOrNil(chw.videoUrl)) {
                                com.tencent.mm.plugin.websearch.api.a.a.kT(11);
                            }
                            chw.xgR = optInt;
                            chw.title = jSONObject.optString("title");
                            chw.lvA = jSONObject.optString("shareTitle");
                            chw.qVw = jSONObject.optString("shareDesc");
                            chw.uaf = jSONObject.optString("shareImgUrl");
                            chw.uag = jSONObject.optString("shareString");
                            chw.uah = jSONObject.optString("shareStringUrl");
                            chw.source = jSONObject.optString("source");
                            chw.phw = jSONObject.optString("sourceUrl");
                            chw.lvz = jSONObject.optString("shareUrl");
                            chw.xgT = jSONObject.optLong("relevant_category", -1);
                            chw.xgU = jSONObject.optString("shareOpenId");
                            chw.xgV = jSONObject.optString("expand");
                            chw.uai = jSONObject.optString("strPlayCount");
                            chw.uaj = jSONObject.optString("titleUrl");
                            chw.xgW = jSONObject.optInt("itemType");
                            chw.xgY = jSONObject.optString("bizIcon");
                            chw.xhe = jSONObject.optLong("shareChannelId", chw.xgT);
                            chw.timestamp = yz;
                            chw.cui = false;
                            chw.ubA = optString5;
                            chw.xgZ = optLong;
                            chw.ctk = optLong2;
                            chw.xgX = optString;
                            chw.xhd = jSONObject.optInt("switchFlag", 0);
                            boolean z2 = jSONObject.optJSONObject("colikeInfo") != null && jSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb");
                            chw.xhh = z2;
                            chw.xhi = jSONObject.optJSONObject("colikeInfo") != null ? jSONObject.optJSONObject("colikeInfo").optString("byPass", "") : "";
                            chw.voe = jSONObject.optInt("insertPos", 0);
                            if (optJSONArray2 != null) {
                                for (i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    bzs bzs = new bzs();
                                    bzs.id = optJSONArray2.getJSONObject(i4).optString("id");
                                    bzs.cEh = optJSONArray2.getJSONObject(i4).optString("wording");
                                    bzs.wYN = optJSONArray2.getJSONObject(i4).optLong("category");
                                    bzs.actionType = optJSONArray2.getJSONObject(i4).optInt("actionType");
                                    bzs.url = optJSONArray2.getJSONObject(i4).optString("url");
                                    bzs.title = optJSONArray2.getJSONObject(i4).optString("title");
                                    bzs.jcF = optJSONArray2.getJSONObject(i4).optString("subTitle");
                                    bzs.cIY = optJSONArray2.getJSONObject(i4).optString("icon");
                                    chw.wiH.add(bzs);
                                }
                            }
                            if (jSONArray2 != null) {
                                for (i4 = 0; i4 < jSONArray2.length(); i4++) {
                                    abz abz = new abz();
                                    abz.id = jSONArray2.optJSONObject(i4).optString("id", "");
                                    abz.cEh = jSONArray2.optJSONObject(i4).optString("wording", "");
                                    abz.wjP = jSONArray2.optJSONObject(i4).optBoolean("isUseToConfirm", false);
                                    chw.xhc.add(abz);
                                }
                            }
                            if (z) {
                                chw.fgJ = v2helper.VOIP_ENC_HEIGHT_LV1;
                                chw.fgI = 640;
                                if (bo.isNullOrNil(chw.xgQ)) {
                                    chw.xgQ = jSONObject.optString("thumbUrl");
                                }
                            } else {
                                if (bo.isNullOrNil(chw.xgQ)) {
                                    chw.xgQ = "http://shp.qpic.cn/qqvideo_ori/0/" + chw.xgS + String.format("_%s_%s/0", new Object[]{Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX), Integer.valueOf(com.tencent.view.d.MIC_PTU_TRANS_XINXIAN)});
                                }
                                chw.fgJ = com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX;
                                chw.fgI = com.tencent.view.d.MIC_PTU_TRANS_XINXIAN;
                            }
                            if (obj != null) {
                                ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, cdnScene:%s, vid:%s, title:%s, size:%s", Integer.valueOf(i5), chw.xgS, chw.title, Long.valueOf(chw.xha));
                            }
                            if (bo.isNullOrNil(chw.videoUrl)) {
                                ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Can not add video %s", chw.xgS);
                            } else {
                                ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", chw.xgS, chw.videoUrl, Long.valueOf(chw.xha));
                                arrayList.add(chw);
                            }
                        }
                        i = i3 + 1;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(1771);
                return arrayList;
            }
        }
    }

    private static boolean a(int i, chw chw, JSONObject jSONObject) {
        JSONObject optJSONObject;
        AppMethodBeat.i(1772);
        if (i == 1) {
            try {
                optJSONObject = jSONObject.optJSONObject("mpInfo");
            } catch (Exception e) {
                ab.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + e.getMessage());
                AppMethodBeat.o(1772);
                return false;
            }
        }
        optJSONObject = jSONObject.optJSONObject("ctnInfo");
        if (optJSONObject == null || optJSONObject.optJSONArray("urlInfo") == null) {
            AppMethodBeat.o(1772);
            return false;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("urlInfo");
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i2);
            if (jSONObject2.has("url") && jSONObject2.has(FFmpegMetadataRetriever.METADATA_KEY_FILESIZE)) {
                chw.xha = (long) jSONObject2.optInt(FFmpegMetadataRetriever.METADATA_KEY_FILESIZE, 0);
                chy chy = new chy();
                chy.url = jSONObject2.optString("url");
                chy.xhg = 0;
                chw.xhb.add(chy);
            }
        }
        chw.xgQ = optJSONObject.optString("coverUrl");
        if (chw.xha <= 0 || bo.ek(chw.xhb)) {
            AppMethodBeat.o(1772);
            return false;
        }
        AppMethodBeat.o(1772);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x00de A:{SYNTHETIC, EDGE_INSN: B:111:0x00de->B:51:0x00de ?: BREAK  , EDGE_INSN: B:111:0x00de->B:51:0x00de ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070 A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f6 A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0129 A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070 A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x00de A:{SYNTHETIC, EDGE_INSN: B:111:0x00de->B:51:0x00de ?: BREAK  , EDGE_INSN: B:111:0x00de->B:51:0x00de ?: BREAK  , EDGE_INSN: B:111:0x00de->B:51:0x00de ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f6 A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0129 A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x00de A:{SYNTHETIC, EDGE_INSN: B:111:0x00de->B:51:0x00de ?: BREAK  , EDGE_INSN: B:111:0x00de->B:51:0x00de ?: BREAK  , EDGE_INSN: B:111:0x00de->B:51:0x00de ?: BREAK  , EDGE_INSN: B:111:0x00de->B:51:0x00de ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070 A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f6 A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0129 A:{Catch:{ Throwable -> 0x0074, all -> 0x0236 }} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0260  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(chw chw, String str, String str2) {
        AppMethodBeat.i(1773);
        u uVar = null;
        v vVar = null;
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            int i;
            int i2;
            InputStream inputStream;
            BufferedReader bufferedReader;
            String readLine;
            JSONObject jSONObject;
            JSONObject optJSONObject;
            if (com.tencent.mm.plugin.topstory.a.g.cFp()) {
                i = 2;
            } else {
                i = -1;
            }
            int Me = Me();
            int iSPCode = at.getISPCode(ah.getContext());
            if (iSPCode != 0) {
                i2 = iSPCode / 100;
                iSPCode %= 100;
                if (i2 == 460) {
                    if (iSPCode == 0 || iSPCode == 2 || iSPCode == 7) {
                        i2 = 3;
                        ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", str);
                        if (URLUtil.isHttpsUrl(str)) {
                            uVar = com.tencent.mm.network.b.a(str, null);
                            uVar.setUseCaches(true);
                            uVar.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                            uVar.setReadTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                            inputStream = uVar.getInputStream();
                        } else {
                            vVar = com.tencent.mm.network.b.vb(str);
                            vVar.anb();
                            vVar.amZ();
                            vVar.ana();
                            inputStream = vVar.gdG.getInputStream();
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                break;
                            }
                            stringBuilder.append(readLine);
                        }
                        jSONObject = new JSONObject(stringBuilder.toString().substring(13));
                        optJSONObject = jSONObject.optJSONObject("fl");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("fi");
                            if (optJSONArray != null) {
                                for (iSPCode = 0; iSPCode < optJSONArray.length(); iSPCode++) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(iSPCode);
                                    if (jSONObject2.optInt("sl", 0) == 1) {
                                        chw.xha = jSONObject2.optLong("fs");
                                        break;
                                    }
                                }
                            }
                        }
                        optJSONObject = jSONObject.optJSONObject("vl");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("vi");
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                optJSONObject = optJSONArray2.getJSONObject(0);
                                if (optJSONObject != null) {
                                    String optString = optJSONObject.optString(UserDataStore.FIRST_NAME);
                                    String optString2 = optJSONObject.optString("fvkey");
                                    optJSONObject = optJSONObject.optJSONObject("ul");
                                    if (optJSONObject != null) {
                                        JSONArray optJSONArray3 = optJSONObject.optJSONArray("ui");
                                        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                                optJSONObject = optJSONArray3.getJSONObject(i3);
                                                if (optJSONObject != null) {
                                                    String optString3 = optJSONObject.optString("url");
                                                    int optInt = optJSONObject.optInt("vt", 0);
                                                    if (!(bo.isNullOrNil(optString3) || bo.isNullOrNil(optString2) || bo.isNullOrNil(optString))) {
                                                        readLine = optString3 + optString + "?vkey=" + optString2;
                                                        if (!bo.isNullOrNil(str2)) {
                                                            readLine = readLine + "&platform=" + str2;
                                                        }
                                                        optString3 = "&";
                                                        if (!bo.isNullOrNil(readLine)) {
                                                            readLine = readLine + optString3 + "Unicomtype=" + i + "&newnettype=" + Me + "&Netoperator=" + i2;
                                                            ab.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "joinUrlWithNetInfo: ".concat(String.valueOf(readLine)));
                                                        }
                                                        chy chy = new chy();
                                                        chy.url = readLine;
                                                        chy.xhg = optInt;
                                                        chw.xhb.add(chy);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (uVar != null) {
                            uVar.connection.disconnect();
                        }
                        if (vVar != null) {
                            vVar.gdG.disconnect();
                        }
                        if (inputStream != null) {
                            e.p(inputStream);
                            AppMethodBeat.o(1773);
                            return;
                        }
                        AppMethodBeat.o(1773);
                    } else if (iSPCode == 1 || iSPCode == 6 || iSPCode == 9) {
                        i2 = 2;
                        ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", str);
                        if (URLUtil.isHttpsUrl(str)) {
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            readLine = bufferedReader.readLine();
                            if (readLine != null) {
                            }
                        }
                        jSONObject = new JSONObject(stringBuilder.toString().substring(13));
                        optJSONObject = jSONObject.optJSONObject("fl");
                        if (optJSONObject != null) {
                        }
                        optJSONObject = jSONObject.optJSONObject("vl");
                        if (optJSONObject != null) {
                        }
                        if (uVar != null) {
                        }
                        if (vVar != null) {
                        }
                        if (inputStream != null) {
                        }
                        AppMethodBeat.o(1773);
                    } else if (iSPCode == 3 || iSPCode == 5 || iSPCode == 11) {
                        i2 = 1;
                        ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", str);
                        if (URLUtil.isHttpsUrl(str)) {
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            readLine = bufferedReader.readLine();
                            if (readLine != null) {
                            }
                        }
                        jSONObject = new JSONObject(stringBuilder.toString().substring(13));
                        optJSONObject = jSONObject.optJSONObject("fl");
                        if (optJSONObject != null) {
                        }
                        optJSONObject = jSONObject.optJSONObject("vl");
                        if (optJSONObject != null) {
                        }
                        if (uVar != null) {
                        }
                        if (vVar != null) {
                        }
                        if (inputStream != null) {
                        }
                        AppMethodBeat.o(1773);
                    }
                }
            }
            i2 = 0;
            ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", str);
            if (URLUtil.isHttpsUrl(str)) {
            }
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                }
            }
            jSONObject = new JSONObject(stringBuilder.toString().substring(13));
            optJSONObject = jSONObject.optJSONObject("fl");
            if (optJSONObject != null) {
            }
            optJSONObject = jSONObject.optJSONObject("vl");
            if (optJSONObject != null) {
            }
            if (uVar != null) {
            }
            if (vVar != null) {
            }
            if (inputStream != null) {
            }
        } catch (Throwable th) {
            if (null != null) {
                null.connection.disconnect();
            }
            if (null != null) {
                null.gdG.disconnect();
            }
            if (null != null) {
                e.p(null);
            }
            AppMethodBeat.o(1773);
        }
        AppMethodBeat.o(1773);
    }

    public static int Me() {
        AppMethodBeat.i(1774);
        switch (at.getNetType(ah.getContext())) {
            case -1:
                AppMethodBeat.o(1774);
                return 0;
            case 0:
                AppMethodBeat.o(1774);
                return 1;
            default:
                if (at.is2G(ah.getContext())) {
                    AppMethodBeat.o(1774);
                    return 2;
                } else if (at.is3G(ah.getContext())) {
                    AppMethodBeat.o(1774);
                    return 3;
                } else if (at.is4G(ah.getContext())) {
                    AppMethodBeat.o(1774);
                    return 4;
                } else {
                    AppMethodBeat.o(1774);
                    return 0;
                }
        }
    }
}
