package com.tencent.p177mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18347ns;
import com.tencent.p177mm.p230g.p231a.C42006ig;
import com.tencent.p177mm.p612ui.C5493d;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.websearch.api.C22760s;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C7197a;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29944h;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.bem;
import com.tencent.p177mm.protocal.protobuf.cgg;
import com.tencent.p177mm.protocal.protobuf.cmg;
import com.tencent.p177mm.protocal.protobuf.cxo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.fts.f */
public final class C22793f implements C1202f {
    private static final long ufL = ((long) (C5493d.dwu() + 500));
    private static C22793f ufS = new C22793f();
    private C5004al rdm = new C5004al("RecommendLogic_worker");
    private Set<String> ufM;
    public C22795a ufN = new C22795a(this, (byte) 0);
    private volatile boolean ufO;
    private volatile boolean ufP;
    private volatile CountDownLatch ufQ;
    private volatile C22760s ufR;
    private volatile boolean ufT;
    public C4884c ufU = new C144551();

    /* renamed from: com.tencent.mm.plugin.webview.fts.f$1 */
    class C144551 extends C4884c<C18347ns> {
        C144551() {
            AppMethodBeat.m2504i(5721);
            this.xxI = C18347ns.class.getName().hashCode();
            AppMethodBeat.m2505o(5721);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(5722);
            C22793f.this.cWp();
            AppMethodBeat.m2505o(5722);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.f$a */
    public class C22795a implements Comparable {
        public C7197a ufZ;
        public C14456a uga;

        /* renamed from: com.tencent.mm.plugin.webview.fts.f$a$a */
        public class C14456a implements Runnable {
            C22760s fpL;
            public volatile boolean jxQ;

            private C14456a() {
            }

            /* synthetic */ C14456a(C22795a c22795a, byte b) {
                this();
            }

            public final void run() {
                AppMethodBeat.m2504i(5724);
                if (Thread.interrupted()) {
                    AppMethodBeat.m2505o(5724);
                } else if (C5046bo.isNullOrNil(this.fpL.ctj)) {
                    C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", Integer.valueOf(this.fpL.businessType), Integer.valueOf(this.fpL.scene), Integer.valueOf(this.fpL.tZw), Integer.valueOf(this.fpL.cIC), this.fpL.lcA, Integer.valueOf(this.fpL.offset));
                    AppMethodBeat.m2505o(5724);
                } else {
                    C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", this.fpL.ctj, Integer.valueOf(this.fpL.cIv));
                    if (C22795a.this.ufZ != null) {
                        C1720g.m3540Rg().mo14547c(C22795a.this.ufZ);
                    }
                    if (this.jxQ) {
                        C4990ab.m7416i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
                        AppMethodBeat.m2505o(5724);
                        return;
                    }
                    C29833g.cYC().ufm.mo48023m(this.fpL.scene, this.fpL.ctj, this.fpL.businessType);
                    C22795a.this.ufZ = C22795a.m34588a(this.fpL);
                    C1720g.m3540Rg().mo14539a(C22795a.this.ufZ.getType(), C22793f.this);
                    C1720g.m3540Rg().mo14541a(C22795a.this.ufZ, 0);
                    C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", Integer.valueOf(C22795a.this.ufZ.getType()));
                    AppMethodBeat.m2505o(5724);
                }
            }
        }

        private C22795a() {
        }

        /* synthetic */ C22795a(C22793f c22793f, byte b) {
            this();
        }

        public final int compareTo(Object obj) {
            return 0;
        }
    }

    static {
        AppMethodBeat.m2504i(5735);
        AppMethodBeat.m2505o(5735);
    }

    public C22793f() {
        AppMethodBeat.m2504i(5726);
        C4990ab.m7410d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
        C4990ab.m7410d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
        this.ufU.dnU();
        this.ufM = new HashSet();
        this.ufM.add(DownloadInfo.NETTYPE);
        this.ufM.add("time_zone_min");
        this.ufM.add("currentPage");
        this.ufM.add("is_prefetch");
        this.ufM.add(TencentLocation.EXTRA_DIRECTION);
        this.ufM.add("seq");
        this.ufM.add("client_exposed_info");
        this.ufM.add("requestId");
        this.ufM.add("recType");
        this.ufM.add("redPointMsgId");
        cWp();
        AppMethodBeat.m2505o(5726);
    }

    public static C22793f cWo() {
        return ufS;
    }

    /* renamed from: k */
    private boolean m34586k(Set<String> set) {
        AppMethodBeat.m2504i(5727);
        if (set == null || this.ufM.containsAll(set)) {
            AppMethodBeat.m2505o(5727);
            return true;
        }
        AppMethodBeat.m2505o(5727);
        return false;
    }

    /* renamed from: aD */
    public final boolean mo38391aD(Map<String, Object> map) {
        int g;
        AppMethodBeat.m2504i(5728);
        C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", map.toString());
        C29944h.m47401JR(C5046bo.m7550g(map.get("webview_instance_id"), -1)).mo38646c(C46400aa.m87332d((Map) map, "type", 0), C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY), (Map) map);
        if (this.ufO) {
            this.ufO = false;
            g = C5046bo.m7550g(map.get("webview_instance_id"), -1);
            if (this.ufR != null) {
                this.ufR.cIv = g;
            }
            if (m34586k(C22793f.m34582aE(map))) {
                if (this.ufQ != null) {
                    this.ufQ.countDown();
                }
                if (this.ufR != null) {
                    C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", Integer.valueOf(this.ufR.cIv), this.ufR);
                }
                g = 1;
            } else {
                C4990ab.m7412e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
                this.ufP = true;
                if (this.ufQ != null) {
                    this.ufQ.countDown();
                }
                g = 0;
            }
        } else {
            if (this.ufQ != null) {
                this.ufQ.countDown();
            }
            g = 0;
        }
        if (g != 0) {
            AppMethodBeat.m2505o(5728);
        } else {
            C22760s aF = C22793f.m34583aF(map);
            C22795a c22795a = this.ufN;
            if (c22795a.uga != null) {
                c22795a.uga.jxQ = true;
            }
            c22795a.uga = new C14456a(c22795a, (byte) 0);
            c22795a.uga.fpL = aF;
            C22793f.this.ufR = aF;
            c22795a.uga.run();
            AppMethodBeat.m2505o(5728);
        }
        return false;
    }

    /* renamed from: aE */
    private static Set<String> m34582aE(Map<String, Object> map) {
        Set<String> emptySet;
        Throwable e;
        AppMethodBeat.m2504i(5729);
        String t = C46400aa.m87342t(map, "extReqParams");
        if (C5046bo.isNullOrNil(t)) {
            emptySet = Collections.emptySet();
        } else {
            try {
                emptySet = new HashSet();
                try {
                    JSONArray jSONArray = new JSONArray(t);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        C23447tn c23447tn = new C23447tn();
                        emptySet.add(jSONObject.optString("key", ""));
                    }
                } catch (Exception e2) {
                    e = e2;
                    C4990ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "", new Object[0]);
                    AppMethodBeat.m2505o(5729);
                    return emptySet;
                }
            } catch (Exception e3) {
                e = e3;
                emptySet = null;
                C4990ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "", new Object[0]);
                AppMethodBeat.m2505o(5729);
                return emptySet;
            }
        }
        AppMethodBeat.m2505o(5729);
        return emptySet;
    }

    /* renamed from: aF */
    private static C22760s m34583aF(Map<String, Object> map) {
        JSONArray jSONArray;
        int i;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        AppMethodBeat.m2504i(5730);
        C22760s c22760s = new C22760s();
        c22760s.ctj = C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY);
        c22760s.offset = C46400aa.m87332d((Map) map, "offset", 0);
        c22760s.businessType = C46400aa.m87332d((Map) map, "type", 0);
        c22760s.scene = C46400aa.m87332d((Map) map, "scene", 0);
        c22760s.tZy = C46400aa.m87342t(map, "sugId");
        c22760s.tZA = C46400aa.m87332d((Map) map, "sugType", 0);
        c22760s.tZz = C46400aa.m87342t(map, "prefixSug");
        c22760s.tZL = C46400aa.m87342t(map, "poiInfo");
        c22760s.tZw = C46400aa.m87343u(map, "isHomePage") ? 1 : 0;
        c22760s.lcA = C46400aa.m87342t(map, "searchId");
        if (map.containsKey("sessionId")) {
            c22760s.cvF = C46400aa.m87342t(map, "sessionId");
        }
        c22760s.cIC = C46400aa.m87332d((Map) map, "sceneActionType", 1);
        c22760s.tZC = C46400aa.m87332d((Map) map, "displayPattern", 2);
        c22760s.tZD = C46400aa.m87332d((Map) map, "sugPosition", 0);
        c22760s.tZE = C46400aa.m87342t(map, "sugBuffer");
        c22760s.nQB = C46400aa.m87342t(map, "requestId");
        c22760s.cvF = C46400aa.m87342t(map, "sessionId");
        c22760s.cIy = C46400aa.m87342t(map, "subSessionId");
        c22760s.tZM = C46400aa.m87342t(map, "tagId");
        String t = C46400aa.m87342t(map, "extReqParams");
        if (!C5046bo.isNullOrNil(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.getJSONObject(i);
                    C23447tn c23447tn = new C23447tn();
                    c23447tn.key = jSONObject.optString("key", "");
                    c23447tn.waD = (long) jSONObject.optInt("uintValue", 0);
                    c23447tn.waE = jSONObject.optString("textValue", "");
                    c22760s.tZG.add(c23447tn);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "commKvJSONArray", new Object[0]);
            }
        }
        t = C46400aa.m87342t(map, "matchUser");
        if (!C5046bo.isNullOrNil(t)) {
            try {
                jSONObject2 = new JSONObject(t);
                cmg cmg = new cmg();
                cmg.jBB = jSONObject2.optString("userName");
                cmg.xkl = jSONObject2.optString("matchWord");
                if (!TextUtils.isEmpty(cmg.jBB)) {
                    c22760s.tZx.add(cmg);
                }
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        t = C46400aa.m87342t(map, "prefixQuery");
        if (!C5046bo.isNullOrNil(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (i = 0; i < jSONArray.length(); i++) {
                    c22760s.tZB.add(jSONArray.getString(i));
                }
            } catch (Exception e22) {
                C4990ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e22, "prefixQueryJSONArray", new Object[0]);
            }
        }
        t = C46400aa.m87342t(map, "tagInfo");
        if (!C5046bo.isNullOrNil(t)) {
            try {
                jSONObject2 = new JSONObject(t);
                c22760s.tZF = new cgg();
                c22760s.tZF.xfp = jSONObject2.optString("tagText");
                c22760s.tZF.xfo = jSONObject2.optInt("tagType");
                c22760s.tZF.xfq = jSONObject2.optString("tagExtValue");
            } catch (Exception e222) {
                C4990ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        t = C46400aa.m87342t(map, "numConditions");
        if (!C5046bo.isNullOrNil(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.optJSONObject(i);
                    bem bem = new bem();
                    bem.wIB = jSONObject.optLong("from");
                    bem.wIC = jSONObject.optLong("to");
                    bem.wIA = jSONObject.optInt("field");
                    c22760s.tZH.add(bem);
                }
            } catch (Exception e2222) {
                C4990ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        c22760s.cIv = C5046bo.m7550g(map.get("webview_instance_id"), -1);
        c22760s.aOt = C4988aa.m7403gw(C4996ah.getContext());
        c22760s.mDw = C46400aa.m87332d((Map) map, "subType", 0);
        c22760s.cdf = C46400aa.m87332d((Map) map, DownloadInfoColumns.CHANNELID, 0);
        c22760s.tZP = C46400aa.m87342t(map, "navigationId");
        if (C27278r.aNU()) {
            c22760s.tZI = C46400aa.m87332d((Map) map, "isWeAppMore", 0);
            if (c22760s.tZI == 1) {
                c22760s.tZJ = new cxo();
                C42006ig c42006ig = new C42006ig();
                C4879a.xxA.mo10055m(c42006ig);
                c22760s.tZJ.xsP = c42006ig.cDp.cDq;
                c22760s.tZJ.xsR = C45445b.fpE;
                c22760s.tZJ.xsQ = C46400aa.m87332d((Map) map, "subType", 0);
                c22760s.tZJ.session_id = C45445b.fpD;
                c22760s.tZJ.xsS = c22760s.tZD;
                Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
                if (obj != null && (obj instanceof String)) {
                    c22760s.tZJ.xrS = (String) obj;
                }
            }
        }
        AppMethodBeat.m2505o(5730);
        return c22760s;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(5731);
        String str2 = "MicroMsg.TopStory.RecommendLogic";
        String str3 = "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(c1207m != null ? c1207m.getType() : 0);
        C4990ab.m7419v(str2, str3, objArr);
        if (c1207m instanceof C7197a) {
            C1720g.m3540Rg().mo14546b(c1207m.getType(), (C1202f) this);
            C7197a c7197a = (C7197a) c1207m;
            if (i == 0 && i2 == 0) {
                String abH = c7197a.abH();
                int abI = c7197a.abI();
                C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "callback %s", c7197a.bAk());
                m34581a(c7197a.cUO(), abH, c7197a.cUP(), c7197a.cUR());
                if (abI > 0) {
                    C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", Integer.valueOf(abI));
                    C14845c.veg;
                    C14839b.m23095Ky(27);
                }
            } else {
                C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", c7197a.bAk());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ret", -1);
                } catch (JSONException e) {
                }
                m34581a(c7197a.cUO(), jSONObject.toString(), c7197a.cUP(), c7197a.cUR());
                AppMethodBeat.m2505o(5731);
                return;
            }
        }
        AppMethodBeat.m2505o(5731);
    }

    /* renamed from: a */
    private void m34581a(int i, String str, boolean z, String str2) {
        AppMethodBeat.m2504i(5732);
        final int i2 = i;
        final String str3 = str2;
        final String str4 = str;
        final boolean z2 = z;
        this.rdm.mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(5723);
                if (C22793f.this.ufQ != null) {
                    C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", Long.valueOf(C22793f.this.ufQ.getCount()));
                    try {
                        C22793f.this.ufQ.await();
                    } catch (InterruptedException e) {
                        C4990ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "", new Object[0]);
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
                }
                int i = i2;
                if (C22793f.this.ufR != null) {
                    i = C22793f.this.ufR.cIv;
                    if (C22793f.this.ufR.tZO && C22793f.this.ufP) {
                        C4990ab.m7420w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
                        AppMethodBeat.m2505o(5723);
                        return;
                    }
                }
                C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", Integer.valueOf(i), str3, C22793f.this.ufR);
                C29944h.m47401JR(i).mo38619a(str4, z2, str3, null);
                AppMethodBeat.m2505o(5723);
            }
        });
        AppMethodBeat.m2505o(5732);
    }

    public static void start() {
        AppMethodBeat.m2504i(5733);
        try {
            Looper.prepare();
            AppMethodBeat.m2505o(5733);
        } catch (Exception e) {
            AppMethodBeat.m2505o(5733);
        }
    }

    public final void cWp() {
        AppMethodBeat.m2504i(5734);
        String If = C46400aa.m87315If(1);
        C4990ab.m7417i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", If);
        if (TextUtils.isEmpty(If)) {
            this.ufT = true;
            AppMethodBeat.m2505o(5734);
            return;
        }
        this.ufT = m34586k(new HashSet(Arrays.asList(If.split(","))));
        AppMethodBeat.m2505o(5734);
    }

    /* renamed from: Iw */
    static /* synthetic */ boolean m34578Iw(int i) {
        return i == 201;
    }

    /* renamed from: Ix */
    static /* synthetic */ boolean m34579Ix(int i) {
        return i == 21;
    }
}
