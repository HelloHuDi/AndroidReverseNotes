package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.support.p069v7.widget.LinearLayoutManager;
import android.webkit.URLUtil;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.network.C1937v;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19486m;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C35293j;
import com.tencent.p177mm.plugin.topstory.p539a.p1414b.C39960b;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.abz;
import com.tencent.p177mm.protocal.protobuf.bzs;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.protocal.protobuf.chy;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
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

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.n */
public final class C13986n {
    C1202f fur = new C139893();
    public C4232b sDo;
    public boolean sEY;
    public int sEZ;
    C35293j sFa;
    private int sFb;
    private int sFc;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.n$1 */
    public class C139871 implements C1202f {
        final /* synthetic */ C35293j sFd;

        public C139871(C35293j c35293j) {
            this.sFd = c35293j;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(1757);
            if (c1207m == this.sFd) {
                C1720g.m3540Rg().mo14546b(1943, (C1202f) this);
                final C35293j c35293j = (C35293j) c1207m;
                if (i == 0 && i2 == 0) {
                    C7305d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(1756);
                            try {
                                JSONArray optJSONArray = new JSONObject(c35293j.cFt().vOy).optJSONArray("data");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=json data error");
                                    AppMethodBeat.m2505o(1756);
                                    return;
                                }
                                final List b = C13986n.m22121b(C13986n.this.sDo.cGb(), optJSONArray);
                                C5004al.m7441d(new Runnable() {
                                    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x00c3=Splitter:B:29:0x00c3, B:36:0x0103=Splitter:B:36:0x0103} */
                                    /* JADX WARNING: Missing block: B:14:0x0055, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=item exist");
     */
                                    /* JADX WARNING: Missing block: B:18:?, code skipped:
            r2 = ((com.tencent.p177mm.protocal.protobuf.chw) r0.get(0)).voe;
            r5 = r10.sFi.sFg.sFe.sDo.cFY();
            r6 = r10.sFi.sFg.sFe.sDo.cGa().getHeadersCount();
            r1 = ((android.support.p069v7.widget.LinearLayoutManager) r10.sFi.sFg.sFe.sDo.getLayoutManager()).mo1782iS() - r6;
            r7 = r4.size() - 1;
     */
                                    /* JADX WARNING: Missing block: B:19:0x00a7, code skipped:
            if (r5 != r7) goto L_0x00b7;
     */
                                    /* JADX WARNING: Missing block: B:20:0x00a9, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=last pos");
     */
                                    /* JADX WARNING: Missing block: B:22:0x00b3, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(1755);
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoDataMgr", "insert success pos:%s, vid[%s], title:%s", java.lang.Integer.valueOf(r1), r0.xgS, r0.title);
            r10.sFi.sFg.sFe.sDo.cGa().mo66317ch(r1 + r6);
     */
                                    /* JADX WARNING: Missing block: B:35:0x00fe, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(1755);
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
                                        AppMethodBeat.m2504i(1755);
                                        synchronized (C13986n.this) {
                                            try {
                                                List cGQ = C13986n.this.cGQ();
                                                if (!C5046bo.m7548ek(b) && !C5046bo.m7548ek(cGQ) && (C13986n.this.sDo.getLayoutManager() instanceof LinearLayoutManager)) {
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
                                                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=result list or curlist is null");
                                                }
                                            } finally {
                                                AppMethodBeat.m2505o(1755);
                                            }
                                        }
                                    }
                                });
                                AppMethodBeat.m2505o(1756);
                            } catch (Exception e) {
                                C4990ab.m7412e("MicroMsg.TopStory.TopStoryVideoDataMgr", "Fail insert. code=" + e.getMessage());
                                AppMethodBeat.m2505o(1756);
                            }
                        }
                    }, "TopStory.requestRelVideo");
                } else {
                    C4990ab.m7413e("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo failed!, errType:%s, errCode:%s, response json: %s", Integer.valueOf(i), Integer.valueOf(i2), c35293j.cFt().vOy);
                    AppMethodBeat.m2505o(1757);
                    return;
                }
            }
            AppMethodBeat.m2505o(1757);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.n$3 */
    class C139893 implements C1202f {
        C139893() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            boolean z = true;
            AppMethodBeat.m2504i(1760);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), c1207m);
            if (c1207m.equals(C13986n.this.sFa)) {
                C1720g.m3540Rg().mo14546b(1943, C13986n.this.fur);
                C13986n.this.sFa = null;
                C35293j c35293j = (C35293j) c1207m;
                if (i == 0 && i2 == 0) {
                    C13990a c13990a = new C13990a(C13986n.this, (byte) 0);
                    c13990a.lWq = c35293j.cFt().vOy;
                    if (c35293j.sBa.offset != 0) {
                        z = false;
                    }
                    c13990a.mTL = z;
                    C7305d.post(c13990a, "TopStory.DecodeRecommendResultTask");
                } else {
                    C4990ab.m7413e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", c35293j.cFt().vOy);
                    C14419a.m22633kT(2);
                    C13986n.this.sDo.abH(str);
                    C13986n.this.sEY = false;
                    AppMethodBeat.m2505o(1760);
                    return;
                }
            }
            AppMethodBeat.m2505o(1760);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.n$a */
    class C13990a implements Runnable {
        private String lWq;
        private boolean mTL;

        private C13990a() {
        }

        /* synthetic */ C13990a(C13986n c13986n, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(1761);
            try {
                C13986n.m22118a(C13986n.this, new JSONObject(this.lWq), this.mTL);
            } catch (Exception e) {
            } finally {
                C13986n.this.sEY = false;
                AppMethodBeat.m2505o(1761);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ List m22121b(boolean z, JSONArray jSONArray) {
        AppMethodBeat.m2504i(1775);
        List a = C13986n.m22117a(z, jSONArray);
        AppMethodBeat.m2505o(1775);
        return a;
    }

    /* renamed from: b */
    static /* synthetic */ void m22122b(chw chw, String str, String str2) {
        AppMethodBeat.m2504i(1776);
        C13986n.m22119a(chw, str, str2);
        AppMethodBeat.m2505o(1776);
    }

    public C13986n() {
        AppMethodBeat.m2504i(1762);
        AppMethodBeat.m2505o(1762);
    }

    public final List<chw> cGQ() {
        AppMethodBeat.m2504i(1763);
        LinkedList linkedList = this.sDo.cFT().xgK;
        AppMethodBeat.m2505o(1763);
        return linkedList;
    }

    public final int cGR() {
        AppMethodBeat.m2504i(1764);
        int size = cGQ().size();
        AppMethodBeat.m2505o(1764);
        return size;
    }

    /* renamed from: d */
    public final void mo26224d(chw chw) {
        AppMethodBeat.m2504i(1765);
        synchronized (this) {
            try {
                cGQ().add(chw);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(1765);
            }
        }
    }

    /* renamed from: FK */
    public final void mo26217FK(int i) {
        AppMethodBeat.m2504i(1766);
        synchronized (this) {
            if (i >= 0) {
                try {
                    if (i < cGQ().size()) {
                        cGQ().remove(i);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(1766);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(1766);
    }

    /* renamed from: FL */
    public final chw mo26218FL(int i) {
        chw chw;
        AppMethodBeat.m2504i(1767);
        synchronized (this) {
            if (i >= 0) {
                try {
                    if (i < cGQ().size()) {
                        chw = (chw) cGQ().get(i);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(1767);
                }
            }
            chw = null;
            AppMethodBeat.m2505o(1767);
        }
        return chw;
    }

    /* renamed from: FM */
    public final boolean mo26219FM(int i) {
        AppMethodBeat.m2504i(1768);
        if (this.sEY) {
            C4990ab.m7420w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
            AppMethodBeat.m2505o(1768);
            return false;
        }
        C23447tn c23447tn;
        boolean z;
        C23447tn c23447tn2;
        String stringBuffer;
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", Integer.valueOf(i));
        this.sEY = true;
        chv a = C39964g.m68428a(this.sDo.cFT());
        a.offset = i;
        if (!C5046bo.isNullOrNil(this.sDo.cFT().xgC)) {
            c23447tn = new C23447tn();
            c23447tn.key = "relevant_vid";
            c23447tn.waE = this.sDo.cFT().xgC;
            a.tZG.add(c23447tn);
        }
        if (!C5046bo.isNullOrNil(this.sDo.cFT().xgD)) {
            c23447tn = new C23447tn();
            c23447tn.key = "relevant_expand";
            c23447tn.waE = this.sDo.cFT().xgD;
            a.tZG.add(c23447tn);
        }
        if (!C5046bo.isNullOrNil(this.sDo.cFT().xgE)) {
            c23447tn = new C23447tn();
            c23447tn.key = "relevant_pre_searchid";
            c23447tn.waE = this.sDo.cFT().xgE;
            a.tZG.add(c23447tn);
        }
        if (!C5046bo.isNullOrNil(this.sDo.cFT().xgF)) {
            c23447tn = new C23447tn();
            c23447tn.key = "relevant_shared_openid";
            c23447tn.waE = this.sDo.cFT().xgF;
            a.tZG.add(c23447tn);
        }
        if (this.sDo.cFT().xgI != null) {
            c23447tn = new C23447tn();
            c23447tn.key = "rec_category";
            c23447tn.waD = this.sDo.cFT().xgI.wYN;
            a.tZG.add(c23447tn);
        } else {
            c23447tn = new C23447tn();
            c23447tn.key = "rec_category";
            c23447tn.waD = this.sDo.cFT().xgG;
            a.tZG.add(c23447tn);
        }
        Iterator it = a.tZG.iterator();
        while (it.hasNext()) {
            if ("show_tag_list".equals(((C23447tn) it.next()).key)) {
                z = false;
                break;
            }
        }
        z = true;
        if (this.sDo.cFT().xgI != null && z) {
            c23447tn = new C23447tn();
            c23447tn.key = "show_tag_list";
            c23447tn.waE = this.sDo.cFT().xgI.f4415id;
            a.tZG.add(c23447tn);
        }
        c23447tn = new C23447tn();
        c23447tn.key = "fetch_seed_videoinfo";
        if (this.sDo.cFT().xgI == null || C5046bo.isNullOrNil(this.sDo.cFT().xgI.f4415id)) {
            c23447tn.waD = 1;
        } else {
            c23447tn.waD = 0;
        }
        a.tZG.add(c23447tn);
        if (cGR() == 1) {
            chw FL = mo26218FL(0);
            c23447tn2 = new C23447tn();
            c23447tn2.key = "first_video_tag_list";
            c23447tn2.waE = C39964g.m68434dN(FL.wiH).toString();
            a.tZG.add(c23447tn2);
        }
        C46311o cFR = this.sDo.cFR();
        if (cFR.sFn.size() > 0) {
            ArrayList<C39960b> arrayList = new ArrayList();
            arrayList.addAll(cFR.sFn.values());
            StringBuffer stringBuffer2 = new StringBuffer("");
            for (C39960b c39960b : arrayList) {
                stringBuffer2.append(c39960b.sAY ? 1 : 0);
                stringBuffer2.append("_");
                stringBuffer2.append(c39960b.sAX.xgS);
                stringBuffer2.append(";");
            }
            stringBuffer = stringBuffer2.toString();
        } else {
            stringBuffer = null;
        }
        if (!C5046bo.isNullOrNil(stringBuffer)) {
            c23447tn2 = new C23447tn();
            c23447tn2.key = "client_exposed_info";
            c23447tn2.waE = stringBuffer;
            a.tZG.add(c23447tn2);
        }
        c23447tn = new C23447tn();
        c23447tn.key = "is_prefetch";
        c23447tn.waD = (long) this.sEZ;
        a.tZG.add(c23447tn);
        this.sFa = new C35293j(a);
        C1720g.m3540Rg().mo14541a(this.sFa, 0);
        C1720g.m3540Rg().mo14539a(1943, this.fur);
        C14419a.m22633kT(0);
        AppMethodBeat.m2505o(1768);
        return true;
    }

    /* JADX WARNING: Missing block: B:19:0x0041, code skipped:
            r0 = new com.tencent.p177mm.plugin.topstory.p539a.p1042c.C29429e(r6, r2);
            com.tencent.p177mm.kernel.C1720g.m3540Rg().mo14541a(r0, 0);
            com.tencent.p177mm.kernel.C1720g.m3540Rg().mo14539a(r0.getType(), new com.tencent.p177mm.plugin.topstory.p541ui.video.C13986n.C139882(r5));
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(1769);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo26220a(chv chv, int i) {
        AppMethodBeat.m2504i(1769);
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                List cGQ = cGQ();
                if (C5046bo.m7548ek(cGQ) || i >= cGQ.size()) {
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
                AppMethodBeat.m2505o(1769);
            }
        }
    }

    public final void aEX() {
        AppMethodBeat.m2504i(1770);
        C1720g.m3540Rg().mo14546b(1943, this.fur);
        AppMethodBeat.m2505o(1770);
    }

    /* renamed from: a */
    private static List<chw> m22117a(boolean z, JSONArray jSONArray) {
        AppMethodBeat.m2504i(1771);
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
                    long yz = C5046bo.m7588yz();
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
                        if (!C5046bo.isNullOrNil(optString3)) {
                            Object obj;
                            int i4;
                            chw chw = new chw();
                            chw.xgS = optString3;
                            int i5 = 0;
                            if (optJSONObject != null) {
                                i5 = optJSONObject.optInt("cdnScene", 0);
                            }
                            if (i5 == 1 || i5 == 2) {
                                if (C13986n.m22120a(i5, chw, optJSONObject)) {
                                    obj = 1;
                                }
                            } else if (!C5046bo.isNullOrNil(optString2)) {
                                C13986n.m22119a(chw, optString2, optString4);
                                if (C5046bo.m7548ek(chw.xhb)) {
                                    C14419a.m22633kT(29);
                                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi retry");
                                    C13986n.m22119a(chw, optString2, optString4);
                                }
                                obj = null;
                            }
                            chy dM = C39964g.m68433dM(chw.xhb);
                            if (dM != null) {
                                chw.videoUrl = dM.url;
                                chw.xhg = dM.xhg;
                            }
                            if (C5046bo.isNullOrNil(chw.videoUrl)) {
                                C14419a.m22633kT(11);
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
                                    bzs.f4415id = optJSONArray2.getJSONObject(i4).optString("id");
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
                                    abz.f16202id = jSONArray2.optJSONObject(i4).optString("id", "");
                                    abz.cEh = jSONArray2.optJSONObject(i4).optString("wording", "");
                                    abz.wjP = jSONArray2.optJSONObject(i4).optBoolean("isUseToConfirm", false);
                                    chw.xhc.add(abz);
                                }
                            }
                            if (z) {
                                chw.fgJ = v2helper.VOIP_ENC_HEIGHT_LV1;
                                chw.fgI = 640;
                                if (C5046bo.isNullOrNil(chw.xgQ)) {
                                    chw.xgQ = jSONObject.optString("thumbUrl");
                                }
                            } else {
                                if (C5046bo.isNullOrNil(chw.xgQ)) {
                                    chw.xgQ = "http://shp.qpic.cn/qqvideo_ori/0/" + chw.xgS + String.format("_%s_%s/0", new Object[]{Integer.valueOf(C19486m.CTRL_INDEX), Integer.valueOf(C31128d.MIC_PTU_TRANS_XINXIAN)});
                                }
                                chw.fgJ = C19486m.CTRL_INDEX;
                                chw.fgI = C31128d.MIC_PTU_TRANS_XINXIAN;
                            }
                            if (obj != null) {
                                C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, cdnScene:%s, vid:%s, title:%s, size:%s", Integer.valueOf(i5), chw.xgS, chw.title, Long.valueOf(chw.xha));
                            }
                            if (C5046bo.isNullOrNil(chw.videoUrl)) {
                                C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Can not add video %s", chw.xgS);
                            } else {
                                C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", chw.xgS, chw.videoUrl, Long.valueOf(chw.xha));
                                arrayList.add(chw);
                            }
                        }
                        i = i3 + 1;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(1771);
                return arrayList;
            }
        }
    }

    /* renamed from: a */
    private static boolean m22120a(int i, chw chw, JSONObject jSONObject) {
        JSONObject optJSONObject;
        AppMethodBeat.m2504i(1772);
        if (i == 1) {
            try {
                optJSONObject = jSONObject.optJSONObject("mpInfo");
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + e.getMessage());
                AppMethodBeat.m2505o(1772);
                return false;
            }
        }
        optJSONObject = jSONObject.optJSONObject("ctnInfo");
        if (optJSONObject == null || optJSONObject.optJSONArray("urlInfo") == null) {
            AppMethodBeat.m2505o(1772);
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
        if (chw.xha <= 0 || C5046bo.m7548ek(chw.xhb)) {
            AppMethodBeat.m2505o(1772);
            return false;
        }
        AppMethodBeat.m2505o(1772);
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
    /* renamed from: a */
    private static void m22119a(chw chw, String str, String str2) {
        AppMethodBeat.m2504i(1773);
        C1936u c1936u = null;
        C1937v c1937v = null;
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            int i;
            int i2;
            InputStream inputStream;
            BufferedReader bufferedReader;
            String readLine;
            JSONObject jSONObject;
            JSONObject optJSONObject;
            if (C39964g.cFp()) {
                i = 2;
            } else {
                i = -1;
            }
            int Me = C13986n.m22116Me();
            int iSPCode = C5023at.getISPCode(C4996ah.getContext());
            if (iSPCode != 0) {
                i2 = iSPCode / 100;
                iSPCode %= 100;
                if (i2 == 460) {
                    if (iSPCode == 0 || iSPCode == 2 || iSPCode == 7) {
                        i2 = 3;
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", str);
                        if (URLUtil.isHttpsUrl(str)) {
                            c1936u = C1897b.m4020a(str, null);
                            c1936u.setUseCaches(true);
                            c1936u.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                            c1936u.setReadTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                            inputStream = c1936u.getInputStream();
                        } else {
                            c1937v = C1897b.m4023vb(str);
                            c1937v.anb();
                            c1937v.amZ();
                            c1937v.ana();
                            inputStream = c1937v.gdG.getInputStream();
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
                                                    if (!(C5046bo.isNullOrNil(optString3) || C5046bo.isNullOrNil(optString2) || C5046bo.isNullOrNil(optString))) {
                                                        readLine = optString3 + optString + "?vkey=" + optString2;
                                                        if (!C5046bo.isNullOrNil(str2)) {
                                                            readLine = readLine + "&platform=" + str2;
                                                        }
                                                        optString3 = "&";
                                                        if (!C5046bo.isNullOrNil(readLine)) {
                                                            readLine = readLine + optString3 + "Unicomtype=" + i + "&newnettype=" + Me + "&Netoperator=" + i2;
                                                            C4990ab.m7410d("MicroMsg.TopStory.TopStoryVideoDataMgr", "joinUrlWithNetInfo: ".concat(String.valueOf(readLine)));
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
                        if (c1936u != null) {
                            c1936u.connection.disconnect();
                        }
                        if (c1937v != null) {
                            c1937v.gdG.disconnect();
                        }
                        if (inputStream != null) {
                            C1173e.m2573p(inputStream);
                            AppMethodBeat.m2505o(1773);
                            return;
                        }
                        AppMethodBeat.m2505o(1773);
                    } else if (iSPCode == 1 || iSPCode == 6 || iSPCode == 9) {
                        i2 = 2;
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", str);
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
                        if (c1936u != null) {
                        }
                        if (c1937v != null) {
                        }
                        if (inputStream != null) {
                        }
                        AppMethodBeat.m2505o(1773);
                    } else if (iSPCode == 3 || iSPCode == 5 || iSPCode == 11) {
                        i2 = 1;
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", str);
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
                        if (c1936u != null) {
                        }
                        if (c1937v != null) {
                        }
                        if (inputStream != null) {
                        }
                        AppMethodBeat.m2505o(1773);
                    }
                }
            }
            i2 = 0;
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", str);
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
            if (c1936u != null) {
            }
            if (c1937v != null) {
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
                C1173e.m2573p(null);
            }
            AppMethodBeat.m2505o(1773);
        }
        AppMethodBeat.m2505o(1773);
    }

    /* renamed from: Me */
    public static int m22116Me() {
        AppMethodBeat.m2504i(1774);
        switch (C5023at.getNetType(C4996ah.getContext())) {
            case -1:
                AppMethodBeat.m2505o(1774);
                return 0;
            case 0:
                AppMethodBeat.m2505o(1774);
                return 1;
            default:
                if (C5023at.is2G(C4996ah.getContext())) {
                    AppMethodBeat.m2505o(1774);
                    return 2;
                } else if (C5023at.is3G(C4996ah.getContext())) {
                    AppMethodBeat.m2505o(1774);
                    return 3;
                } else if (C5023at.is4G(C4996ah.getContext())) {
                    AppMethodBeat.m2505o(1774);
                    return 4;
                } else {
                    AppMethodBeat.m2505o(1774);
                    return 0;
                }
        }
    }
}
