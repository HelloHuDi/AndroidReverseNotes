package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.cgg;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.d;
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

public final class f implements com.tencent.mm.ai.f {
    private static final long ufL = ((long) (d.dwu() + 500));
    private static f ufS = new f();
    private al rdm = new al("RecommendLogic_worker");
    private Set<String> ufM;
    public a ufN = new a(this, (byte) 0);
    private volatile boolean ufO;
    private volatile boolean ufP;
    private volatile CountDownLatch ufQ;
    private volatile s ufR;
    private volatile boolean ufT;
    public c ufU = new c<ns>() {
        {
            AppMethodBeat.i(5721);
            this.xxI = ns.class.getName().hashCode();
            AppMethodBeat.o(5721);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(5722);
            f.this.cWp();
            AppMethodBeat.o(5722);
            return false;
        }
    };

    public class a implements Comparable {
        public com.tencent.mm.plugin.websearch.api.a ufZ;
        public a uga;

        public class a implements Runnable {
            s fpL;
            public volatile boolean jxQ;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }

            public final void run() {
                AppMethodBeat.i(5724);
                if (Thread.interrupted()) {
                    AppMethodBeat.o(5724);
                } else if (bo.isNullOrNil(this.fpL.ctj)) {
                    ab.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", Integer.valueOf(this.fpL.businessType), Integer.valueOf(this.fpL.scene), Integer.valueOf(this.fpL.tZw), Integer.valueOf(this.fpL.cIC), this.fpL.lcA, Integer.valueOf(this.fpL.offset));
                    AppMethodBeat.o(5724);
                } else {
                    ab.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", this.fpL.ctj, Integer.valueOf(this.fpL.cIv));
                    if (a.this.ufZ != null) {
                        g.Rg().c(a.this.ufZ);
                    }
                    if (this.jxQ) {
                        ab.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
                        AppMethodBeat.o(5724);
                        return;
                    }
                    com.tencent.mm.plugin.webview.modeltools.g.cYC().ufm.m(this.fpL.scene, this.fpL.ctj, this.fpL.businessType);
                    a.this.ufZ = a.a(this.fpL);
                    g.Rg().a(a.this.ufZ.getType(), f.this);
                    g.Rg().a(a.this.ufZ, 0);
                    ab.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", Integer.valueOf(a.this.ufZ.getType()));
                    AppMethodBeat.o(5724);
                }
            }
        }

        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final int compareTo(Object obj) {
            return 0;
        }
    }

    static {
        AppMethodBeat.i(5735);
        AppMethodBeat.o(5735);
    }

    public f() {
        AppMethodBeat.i(5726);
        ab.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
        ab.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
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
        AppMethodBeat.o(5726);
    }

    public static f cWo() {
        return ufS;
    }

    private boolean k(Set<String> set) {
        AppMethodBeat.i(5727);
        if (set == null || this.ufM.containsAll(set)) {
            AppMethodBeat.o(5727);
            return true;
        }
        AppMethodBeat.o(5727);
        return false;
    }

    public final boolean aD(Map<String, Object> map) {
        int g;
        AppMethodBeat.i(5728);
        ab.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", map.toString());
        h.JR(bo.g(map.get("webview_instance_id"), -1)).c(aa.d((Map) map, "type", 0), aa.t(map, SearchIntents.EXTRA_QUERY), (Map) map);
        if (this.ufO) {
            this.ufO = false;
            g = bo.g(map.get("webview_instance_id"), -1);
            if (this.ufR != null) {
                this.ufR.cIv = g;
            }
            if (k(aE(map))) {
                if (this.ufQ != null) {
                    this.ufQ.countDown();
                }
                if (this.ufR != null) {
                    ab.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", Integer.valueOf(this.ufR.cIv), this.ufR);
                }
                g = 1;
            } else {
                ab.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
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
            AppMethodBeat.o(5728);
        } else {
            s aF = aF(map);
            a aVar = this.ufN;
            if (aVar.uga != null) {
                aVar.uga.jxQ = true;
            }
            aVar.uga = new a(aVar, (byte) 0);
            aVar.uga.fpL = aF;
            f.this.ufR = aF;
            aVar.uga.run();
            AppMethodBeat.o(5728);
        }
        return false;
    }

    private static Set<String> aE(Map<String, Object> map) {
        Set<String> emptySet;
        Throwable e;
        AppMethodBeat.i(5729);
        String t = aa.t(map, "extReqParams");
        if (bo.isNullOrNil(t)) {
            emptySet = Collections.emptySet();
        } else {
            try {
                emptySet = new HashSet();
                try {
                    JSONArray jSONArray = new JSONArray(t);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        tn tnVar = new tn();
                        emptySet.add(jSONObject.optString("key", ""));
                    }
                } catch (Exception e2) {
                    e = e2;
                    ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "", new Object[0]);
                    AppMethodBeat.o(5729);
                    return emptySet;
                }
            } catch (Exception e3) {
                e = e3;
                emptySet = null;
                ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "", new Object[0]);
                AppMethodBeat.o(5729);
                return emptySet;
            }
        }
        AppMethodBeat.o(5729);
        return emptySet;
    }

    private static s aF(Map<String, Object> map) {
        JSONArray jSONArray;
        int i;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        AppMethodBeat.i(5730);
        s sVar = new s();
        sVar.ctj = aa.t(map, SearchIntents.EXTRA_QUERY);
        sVar.offset = aa.d((Map) map, "offset", 0);
        sVar.businessType = aa.d((Map) map, "type", 0);
        sVar.scene = aa.d((Map) map, "scene", 0);
        sVar.tZy = aa.t(map, "sugId");
        sVar.tZA = aa.d((Map) map, "sugType", 0);
        sVar.tZz = aa.t(map, "prefixSug");
        sVar.tZL = aa.t(map, "poiInfo");
        sVar.tZw = aa.u(map, "isHomePage") ? 1 : 0;
        sVar.lcA = aa.t(map, "searchId");
        if (map.containsKey("sessionId")) {
            sVar.cvF = aa.t(map, "sessionId");
        }
        sVar.cIC = aa.d((Map) map, "sceneActionType", 1);
        sVar.tZC = aa.d((Map) map, "displayPattern", 2);
        sVar.tZD = aa.d((Map) map, "sugPosition", 0);
        sVar.tZE = aa.t(map, "sugBuffer");
        sVar.nQB = aa.t(map, "requestId");
        sVar.cvF = aa.t(map, "sessionId");
        sVar.cIy = aa.t(map, "subSessionId");
        sVar.tZM = aa.t(map, "tagId");
        String t = aa.t(map, "extReqParams");
        if (!bo.isNullOrNil(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.getJSONObject(i);
                    tn tnVar = new tn();
                    tnVar.key = jSONObject.optString("key", "");
                    tnVar.waD = (long) jSONObject.optInt("uintValue", 0);
                    tnVar.waE = jSONObject.optString("textValue", "");
                    sVar.tZG.add(tnVar);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "commKvJSONArray", new Object[0]);
            }
        }
        t = aa.t(map, "matchUser");
        if (!bo.isNullOrNil(t)) {
            try {
                jSONObject2 = new JSONObject(t);
                cmg cmg = new cmg();
                cmg.jBB = jSONObject2.optString("userName");
                cmg.xkl = jSONObject2.optString("matchWord");
                if (!TextUtils.isEmpty(cmg.jBB)) {
                    sVar.tZx.add(cmg);
                }
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        t = aa.t(map, "prefixQuery");
        if (!bo.isNullOrNil(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (i = 0; i < jSONArray.length(); i++) {
                    sVar.tZB.add(jSONArray.getString(i));
                }
            } catch (Exception e22) {
                ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e22, "prefixQueryJSONArray", new Object[0]);
            }
        }
        t = aa.t(map, "tagInfo");
        if (!bo.isNullOrNil(t)) {
            try {
                jSONObject2 = new JSONObject(t);
                sVar.tZF = new cgg();
                sVar.tZF.xfp = jSONObject2.optString("tagText");
                sVar.tZF.xfo = jSONObject2.optInt("tagType");
                sVar.tZF.xfq = jSONObject2.optString("tagExtValue");
            } catch (Exception e222) {
                ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        t = aa.t(map, "numConditions");
        if (!bo.isNullOrNil(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.optJSONObject(i);
                    bem bem = new bem();
                    bem.wIB = jSONObject.optLong("from");
                    bem.wIC = jSONObject.optLong("to");
                    bem.wIA = jSONObject.optInt("field");
                    sVar.tZH.add(bem);
                }
            } catch (Exception e2222) {
                ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        sVar.cIv = bo.g(map.get("webview_instance_id"), -1);
        sVar.aOt = com.tencent.mm.sdk.platformtools.aa.gw(ah.getContext());
        sVar.mDw = aa.d((Map) map, "subType", 0);
        sVar.cdf = aa.d((Map) map, DownloadInfoColumns.CHANNELID, 0);
        sVar.tZP = aa.t(map, "navigationId");
        if (r.aNU()) {
            sVar.tZI = aa.d((Map) map, "isWeAppMore", 0);
            if (sVar.tZI == 1) {
                sVar.tZJ = new cxo();
                ig igVar = new ig();
                com.tencent.mm.sdk.b.a.xxA.m(igVar);
                sVar.tZJ.xsP = igVar.cDp.cDq;
                sVar.tZJ.xsR = com.tencent.mm.modelappbrand.b.fpE;
                sVar.tZJ.xsQ = aa.d((Map) map, "subType", 0);
                sVar.tZJ.session_id = com.tencent.mm.modelappbrand.b.fpD;
                sVar.tZJ.xsS = sVar.tZD;
                Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
                if (obj != null && (obj instanceof String)) {
                    sVar.tZJ.xrS = (String) obj;
                }
            }
        }
        AppMethodBeat.o(5730);
        return sVar;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(5731);
        String str2 = "MicroMsg.TopStory.RecommendLogic";
        String str3 = "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(mVar != null ? mVar.getType() : 0);
        ab.v(str2, str3, objArr);
        if (mVar instanceof com.tencent.mm.plugin.websearch.api.a) {
            g.Rg().b(mVar.getType(), (com.tencent.mm.ai.f) this);
            com.tencent.mm.plugin.websearch.api.a aVar = (com.tencent.mm.plugin.websearch.api.a) mVar;
            if (i == 0 && i2 == 0) {
                String abH = aVar.abH();
                int abI = aVar.abI();
                ab.i("MicroMsg.TopStory.RecommendLogic", "callback %s", aVar.bAk());
                a(aVar.cUO(), abH, aVar.cUP(), aVar.cUR());
                if (abI > 0) {
                    ab.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", Integer.valueOf(abI));
                    com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
                    com.tencent.mm.pluginsdk.g.a.a.b.Ky(27);
                }
            } else {
                ab.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", aVar.bAk());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ret", -1);
                } catch (JSONException e) {
                }
                a(aVar.cUO(), jSONObject.toString(), aVar.cUP(), aVar.cUR());
                AppMethodBeat.o(5731);
                return;
            }
        }
        AppMethodBeat.o(5731);
    }

    private void a(int i, String str, boolean z, String str2) {
        AppMethodBeat.i(5732);
        final int i2 = i;
        final String str3 = str2;
        final String str4 = str;
        final boolean z2 = z;
        this.rdm.aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5723);
                if (f.this.ufQ != null) {
                    ab.i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", Long.valueOf(f.this.ufQ.getCount()));
                    try {
                        f.this.ufQ.await();
                    } catch (InterruptedException e) {
                        ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "", new Object[0]);
                    }
                } else {
                    ab.i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
                }
                int i = i2;
                if (f.this.ufR != null) {
                    i = f.this.ufR.cIv;
                    if (f.this.ufR.tZO && f.this.ufP) {
                        ab.w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
                        AppMethodBeat.o(5723);
                        return;
                    }
                }
                ab.i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", Integer.valueOf(i), str3, f.this.ufR);
                h.JR(i).a(str4, z2, str3, null);
                AppMethodBeat.o(5723);
            }
        });
        AppMethodBeat.o(5732);
    }

    public static void start() {
        AppMethodBeat.i(5733);
        try {
            Looper.prepare();
            AppMethodBeat.o(5733);
        } catch (Exception e) {
            AppMethodBeat.o(5733);
        }
    }

    public final void cWp() {
        AppMethodBeat.i(5734);
        String If = aa.If(1);
        ab.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", If);
        if (TextUtils.isEmpty(If)) {
            this.ufT = true;
            AppMethodBeat.o(5734);
            return;
        }
        this.ufT = k(new HashSet(Arrays.asList(If.split(","))));
        AppMethodBeat.o(5734);
    }

    static /* synthetic */ boolean Iw(int i) {
        return i == 201;
    }

    static /* synthetic */ boolean Ix(int i) {
        return i == 21;
    }
}
