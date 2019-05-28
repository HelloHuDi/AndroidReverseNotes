package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.model.t;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.c.a.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.cgg;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.d;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g implements f {
    static final long ufL = ((long) (d.dwu() + 500));
    public com.tencent.mm.plugin.fts.a.a.a mEx;
    private l plf = new l() {
        public final void b(j jVar) {
            AppMethodBeat.i(5742);
            switch (jVar.bFZ) {
                case -3:
                case -2:
                case -1:
                    h.JR(((Integer) g.this.mEx.mDs).intValue()).agq("");
                    break;
                case 0:
                    if (jVar.mEy == null || jVar.mEy.size() == 0) {
                        ab.i("MicroMsg.FTS.WebSearchLogic", "local contact search size 0");
                        h.JR(((Integer) g.this.mEx.mDs).intValue()).agq("");
                        AppMethodBeat.o(5742);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray2 = new JSONArray();
                        for (com.tencent.mm.plugin.fts.a.a.l lVar : jVar.mEy) {
                            if (lVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                                jSONArray2.put(g.a(lVar, jVar.mDz));
                            }
                        }
                        jSONObject2.put("items", jSONArray2);
                        jSONObject2.put("title", ah.getContext().getString(R.string.c2_));
                        jSONObject2.put("count", jSONArray2.length());
                        jSONObject2.put("type", 3);
                        jSONArray.put(jSONObject2);
                        jSONObject.put("data", jSONArray);
                        jSONObject.put("ret", 0);
                        h.JR(((Integer) g.this.mEx.mDs).intValue()).agq(jSONObject.toString());
                        AppMethodBeat.o(5742);
                        return;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "onSearchDone", new Object[0]);
                        AppMethodBeat.o(5742);
                        return;
                    }
            }
            AppMethodBeat.o(5742);
        }
    };
    private al rdm = new al("WebSearchLogic_worker");
    public cvf tZK;
    private Set<String> ufM;
    volatile boolean ufO;
    volatile boolean ufP;
    volatile CountDownLatch ufQ;
    private volatile s ufR;
    volatile boolean ufT;
    public c ufU = new c<ns>() {
        {
            AppMethodBeat.i(5736);
            this.xxI = ns.class.getName().hashCode();
            AppMethodBeat.o(5736);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(5737);
            g.this.cWp();
            AppMethodBeat.o(5737);
            return false;
        }
    };
    public int ugc = 0;
    public cvf ugd;
    public Map<String, Integer> uge = new HashMap();
    long ugf;
    public c ugg = new c<mr>() {
        {
            AppMethodBeat.i(5738);
            this.xxI = mr.class.getName().hashCode();
            AppMethodBeat.o(5738);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(5739);
            mr mrVar = (mr) bVar;
            g gVar = g.this;
            String str = mrVar.cIx.cIz;
            String str2 = mrVar.cIx.cvF;
            String str3 = mrVar.cIx.cIy;
            String str4 = mrVar.cIx.query;
            int i = mrVar.cIx.scene;
            String str5 = mrVar.cIx.cIA;
            String str6 = mrVar.cIx.cIB;
            int i2 = mrVar.cIx.cIC;
            if (!TextUtils.isEmpty(str4)) {
                if (!gVar.ufT) {
                    ab.w("MicroMsg.FTS.WebSearchLogic", "do no support pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", Integer.valueOf(aa.HV(0)), str, str2, str3);
                } else if (System.currentTimeMillis() - gVar.ugf <= g.ufL) {
                    ab.w("MicroMsg.FTS.WebSearchLogic", "pre get data fail for time interval limit");
                } else {
                    ab.w("MicroMsg.FTS.WebSearchLogic", "pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", Integer.valueOf(aa.HV(0)), str, str2, str3);
                    gVar.ufO = true;
                    if (gVar.ufQ != null) {
                        gVar.ufQ.countDown();
                    }
                    gVar.ufQ = new CountDownLatch(1);
                    gVar.ufP = false;
                    gVar.a(str, str2, str3, str4, i, str5, str6, i2);
                    gVar.ugf = System.currentTimeMillis();
                }
            }
            AppMethodBeat.o(5739);
            return false;
        }
    };
    private com.tencent.mm.plugin.websearch.c.a.c ugh = new com.tencent.mm.plugin.websearch.c.a.b();
    public a ugi = new a(this, (byte) 0);
    public b ugj = new b(this, (byte) 0);

    public class b {
        public com.tencent.mm.plugin.websearch.api.b ugp;

        private b() {
        }

        /* synthetic */ b(g gVar, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.g$3 */
    public class AnonymousClass3 implements com.tencent.mm.ai.w.a {
        final /* synthetic */ String hlQ;
        final /* synthetic */ int ugl;
        final /* synthetic */ String ugm;

        public AnonymousClass3(int i, String str, String str2) {
            this.ugl = i;
            this.hlQ = str;
            this.ugm = str2;
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
            AppMethodBeat.i(5740);
            if (mVar.getType() != 2608) {
                AppMethodBeat.o(5740);
            } else if (i == 0 && i2 == 0) {
                if (bVar != null) {
                    bvq bvq = (bvq) bVar.fsH.fsP;
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(this.ugl);
                    String str2 = this.hlQ;
                    String str3 = this.ugm;
                    String str4 = bvq.vOy;
                    Bundle bundle = new Bundle();
                    bundle.putString("searchId", str2);
                    bundle.putString("poiId", str3);
                    bundle.putString("json", str4);
                    try {
                        if (JR.umI != null) {
                            JR.umI.c(145, bundle);
                        }
                    } catch (RemoteException e) {
                        ab.w("MicroMsg.MsgHandler", "onGetPoiReady exception" + e.getMessage());
                    }
                }
                AppMethodBeat.o(5740);
            } else {
                ab.e("MicroMsg.FTS.WebSearchLogic", "getPoiInfo onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
                AppMethodBeat.o(5740);
            }
            return 0;
        }
    }

    public class a implements Comparable {
        private ThreadPoolExecutor cmi;
        public com.tencent.mm.plugin.websearch.api.a ufZ;
        public a ugn;

        public class a implements Runnable {
            s fpL;
            public volatile boolean jxQ;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }

            public final void run() {
                AppMethodBeat.i(5743);
                if (Thread.interrupted()) {
                    AppMethodBeat.o(5743);
                } else if (bo.isNullOrNil(this.fpL.ctj)) {
                    ab.i("MicroMsg.FTS.WebSearchLogic", "error query %d %d %d %d %s %d", Integer.valueOf(this.fpL.businessType), Integer.valueOf(this.fpL.scene), Integer.valueOf(this.fpL.tZw), Integer.valueOf(this.fpL.cIC), this.fpL.lcA, Integer.valueOf(this.fpL.offset));
                    AppMethodBeat.o(5743);
                } else {
                    switch (this.fpL.scene) {
                        case 3:
                        case 16:
                        case 20:
                            ((n) com.tencent.mm.kernel.g.M(n.class)).addSOSHistory(this.fpL.ctj);
                            break;
                    }
                    ab.i("MicroMsg.FTS.WebSearchLogic", "start New NetScene %s ,  %d", this.fpL.ctj, Integer.valueOf(this.fpL.cIv));
                    if (a.this.ufZ != null) {
                        com.tencent.mm.kernel.g.Rg().c(a.this.ufZ);
                    }
                    e eVar = null;
                    if ((this.fpL.tZx == null || this.fpL.tZx.isEmpty()) && g.al(this.fpL.ctj, this.fpL.scene, this.fpL.businessType)) {
                        eVar = (e) g.this.ugh.adR(this.fpL.ctj);
                        long currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                        ab.i("MicroMsg.FTS.WebSearchLogic", "match contact cost %d ms", Long.valueOf(currentTimeMillis));
                        com.tencent.mm.plugin.report.service.h.pYm.e(14717, this.fpL.ctj, Integer.valueOf(t.Zo()), Integer.valueOf(eVar.mFf.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.fpL.scene));
                    }
                    if (this.jxQ) {
                        ab.i("MicroMsg.FTS.WebSearchLogic", "was cancelled");
                        AppMethodBeat.o(5743);
                        return;
                    }
                    com.tencent.mm.plugin.webview.modeltools.g.cYC().ufm.m(this.fpL.scene, this.fpL.ctj, this.fpL.businessType);
                    a.this.ufZ = a.c(this.fpL);
                    if (eVar != null) {
                        LinkedList linkedList = new LinkedList();
                        for (com.tencent.mm.plugin.websearch.c.a.e.a aVar : new ArrayList(eVar.mFf)) {
                            cmg cmg = new cmg();
                            cmg.jBB = aVar.userName;
                            cmg.xkl = aVar.ucj;
                            cmg.jCH = aVar.bCu;
                            cmg.wbw = aVar.hHV;
                            cmg.guS = aVar.dFl;
                            cmg.vEA = aVar.desc;
                            linkedList.add(cmg);
                        }
                        a.this.ufZ.ax(linkedList);
                    }
                    com.tencent.mm.kernel.g.Rg().a(a.this.ufZ.getType(), g.this);
                    com.tencent.mm.kernel.g.Rg().a(a.this.ufZ, 0);
                    ab.i("MicroMsg.FTS.WebSearchLogic", "doScene(type : %s)", Integer.valueOf(a.this.ufZ.getType()));
                    AppMethodBeat.o(5743);
                }
            }
        }

        private a() {
            AppMethodBeat.i(5744);
            this.cmi = new ThreadPoolExecutor(0, 10, 120, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
            AppMethodBeat.o(5744);
        }

        /* synthetic */ a(g gVar, byte b) {
            this();
        }

        public final void b(s sVar) {
            AppMethodBeat.i(5745);
            if (this.ugn != null) {
                this.ugn.jxQ = true;
            }
            this.ugn = new a(this, (byte) 0);
            this.ugn.fpL = sVar;
            g.this.ufR = sVar;
            this.cmi.execute(this.ugn);
            AppMethodBeat.o(5745);
        }

        public final int compareTo(Object obj) {
            return 0;
        }

        static /* synthetic */ com.tencent.mm.plugin.websearch.api.a c(s sVar) {
            com.tencent.mm.plugin.websearch.api.a qVar;
            AppMethodBeat.i(5746);
            if (g.Iz(sVar.scene) && !r.aNU()) {
                qVar = new q(sVar);
            } else if (g.IA(sVar.scene)) {
                qVar = new com.tencent.mm.plugin.websearch.api.t(sVar);
            } else {
                qVar = new d(sVar);
            }
            qVar.HN(sVar.cIv);
            AppMethodBeat.o(5746);
            return qVar;
        }
    }

    static /* synthetic */ boolean Iz(int i) {
        AppMethodBeat.i(138972);
        boolean Iy = Iy(i);
        AppMethodBeat.o(138972);
        return Iy;
    }

    static {
        AppMethodBeat.i(5762);
        AppMethodBeat.o(5762);
    }

    public g() {
        AppMethodBeat.i(5747);
        ab.d("MicroMsg.FTS.WebSearchLogic", "create WebSearchLogic");
        this.ufU.dnU();
        this.ugg.dnU();
        this.ufM = new HashSet();
        this.ufM.add(DownloadInfo.NETTYPE);
        this.ufM.add("currentPage");
        this.ufM.add("requestId");
        this.ufM.add("parentSearchID");
        cWp();
        AppMethodBeat.o(5747);
    }

    private static boolean Iy(int i) {
        return i == 201;
    }

    public final boolean aD(Map<String, Object> map) {
        int i = 1;
        AppMethodBeat.i(5748);
        ab.i("MicroMsg.FTS.WebSearchLogic", "getSearchData: %s", map.toString());
        h.JR(bo.g(map.get("webview_instance_id"), -1)).c(aa.d((Map) map, "type", 0), aa.t(map, SearchIntents.EXTRA_QUERY), (Map) map);
        if (this.ufO) {
            this.ufO = false;
            int g = bo.g(map.get("webview_instance_id"), -1);
            if (this.ufR != null) {
                this.ufR.cIv = g;
            }
            if (k(aE(map))) {
                if (this.ufQ != null) {
                    this.ufQ.countDown();
                }
                if (this.ufR != null) {
                    ab.i("MicroMsg.FTS.WebSearchLogic", "do not send this call, wait for pre get, webivewId %d, %s", Integer.valueOf(this.ufR.cIv), this.ufR);
                }
            } else {
                ab.e("MicroMsg.FTS.WebSearchLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
                this.ufP = true;
                if (this.ufQ != null) {
                    this.ufQ.countDown();
                }
                i = 0;
            }
        } else {
            if (this.ufQ != null) {
                this.ufQ.countDown();
            }
            i = 0;
        }
        if (i != 0) {
            ab.i("MicroMsg.FTS.WebSearchLogic", "waiting for pre getdata back");
            AppMethodBeat.o(5748);
        } else {
            this.ugi.b(aF(map));
            AppMethodBeat.o(5748);
        }
        return false;
    }

    private boolean k(Set<String> set) {
        AppMethodBeat.i(5749);
        if (set == null || this.ufM.containsAll(set)) {
            AppMethodBeat.o(5749);
            return true;
        }
        AppMethodBeat.o(5749);
        return false;
    }

    private static Set<String> aE(Map<String, Object> map) {
        Set<String> emptySet;
        Throwable e;
        AppMethodBeat.i(5750);
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
                    ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
                    AppMethodBeat.o(5750);
                    return emptySet;
                }
            } catch (Exception e3) {
                e = e3;
                emptySet = null;
                ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
                AppMethodBeat.o(5750);
                return emptySet;
            }
        }
        AppMethodBeat.o(5750);
        return emptySet;
    }

    public final boolean a(String str, String str2, String str3, String str4, int i, String str5, String str6, int i2) {
        AppMethodBeat.i(5751);
        ab.i("MicroMsg.FTS.WebSearchLogic", "preGetSearchData");
        HashMap hashMap = new HashMap();
        hashMap.put("displayPattern", "2");
        hashMap.put(SearchIntents.EXTRA_QUERY, str4);
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("type", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("isHomePage", "1");
        hashMap.put("sugId", str6);
        hashMap.put("sceneActionType", Integer.valueOf(i2));
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", DownloadInfo.NETTYPE);
            jSONObject.put("textValue", aa.bVP());
            jSONArray.put(jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("key", "currentPage");
            jSONObject.put("textValue", 1);
            jSONArray.put(jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("key", "requestId");
            jSONObject.put("textValue", str);
            jSONArray.put(jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("key", "parentSearchID");
            jSONObject.put("textValue", str5);
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
        }
        hashMap.put("extReqParams", jSONArray.toString());
        hashMap.put("sessionId", str2);
        hashMap.put("subSessionId", str3);
        hashMap.put("requestId", str);
        s aF = aF(hashMap);
        aF.tZO = true;
        if (ay(aF.tZG)) {
            this.ugi.b(aF);
            AppMethodBeat.o(5751);
            return false;
        }
        IllegalStateException illegalStateException = new IllegalStateException("pre get data must use same commKvSets with hardcode set");
        AppMethodBeat.o(5751);
        throw illegalStateException;
    }

    public static void bB(int i, String str) {
        AppMethodBeat.i(5752);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", Integer.valueOf(i));
        hashMap.put("statSessionId", str);
        com.tencent.mm.kernel.g.Rg().a(new c(hashMap, 1), 0);
        AppMethodBeat.o(5752);
    }

    private boolean ay(LinkedList<tn> linkedList) {
        AppMethodBeat.i(5753);
        HashSet hashSet = new HashSet();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            hashSet.add(((tn) it.next()).key);
        }
        boolean equals = this.ufM.equals(hashSet);
        AppMethodBeat.o(5753);
        return equals;
    }

    private s aF(Map<String, Object> map) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        CharSequence charSequence;
        AppMethodBeat.i(5754);
        int d = aa.d((Map) map, "scene", 0);
        s sVar = new s();
        sVar.ctj = aa.t(map, SearchIntents.EXTRA_QUERY);
        sVar.offset = aa.d((Map) map, "offset", 0);
        sVar.businessType = aa.d((Map) map, "type", 0);
        sVar.scene = d;
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
                for (d = 0; d < jSONArray.length(); d++) {
                    jSONObject = jSONArray.getJSONObject(d);
                    tn tnVar = new tn();
                    tnVar.key = jSONObject.optString("key", "");
                    tnVar.waD = (long) jSONObject.optInt("uintValue", 0);
                    tnVar.waE = jSONObject.optString("textValue", "");
                    sVar.tZG.add(tnVar);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "commKvJSONArray", new Object[0]);
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
                ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        t = aa.t(map, "prefixQuery");
        if (!bo.isNullOrNil(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (d = 0; d < jSONArray.length(); d++) {
                    sVar.tZB.add(jSONArray.getString(d));
                }
            } catch (Exception e22) {
                ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e22, "prefixQueryJSONArray", new Object[0]);
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
                ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        t = aa.t(map, "numConditions");
        if (!bo.isNullOrNil(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (d = 0; d < jSONArray.length(); d++) {
                    jSONObject = jSONArray.optJSONObject(d);
                    bem bem = new bem();
                    bem.wIB = jSONObject.optLong("from");
                    bem.wIC = jSONObject.optLong("to");
                    bem.wIA = jSONObject.optInt("field");
                    sVar.tZH.add(bem);
                }
            } catch (Exception e2222) {
                ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        sVar.cIv = bo.g(map.get("webview_instance_id"), -1);
        sVar.aOt = com.tencent.mm.sdk.platformtools.aa.gw(ah.getContext());
        sVar.mDw = aa.d((Map) map, "subType", 0);
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
                Object obj = com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
                if (obj != null && (obj instanceof String)) {
                    sVar.tZJ.xrS = (String) obj;
                }
            }
        }
        if (this.ugc == 1) {
            sVar.tZK = this.tZK;
        } else {
            sVar.tZK = null;
        }
        t = sVar.ctj;
        com.tencent.mm.plugin.webview.fts.b.a.a.cWt();
        com.tencent.mm.plugin.webview.fts.b.a.a.a aeb = com.tencent.mm.plugin.webview.fts.b.a.a.aeb(t);
        if (aeb == null) {
            charSequence = "";
        } else {
            ab.i("MicroMsg.FTS.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", aeb.ugB, aeb.csB, aeb.ugz, aeb.ugA);
            this.tZK = new cvf();
            this.tZK.xrj = 1;
            this.tZK.xrk = new li();
            this.tZK.xrk.csB = aeb.csB;
            this.tZK.xrk.vOO = bo.ank(aeb.ugz);
            this.tZK.xrk.kLN = aeb.ugA;
            charSequence = aeb.ugB;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            sVar.ctj = charSequence;
            sVar.tZK = this.tZK;
        }
        if (sVar.scene == 33 && this.ugd != null) {
            if (sVar.tZK == null) {
                sVar.tZK = new cvf();
            }
            if (sVar.tZK.xrk == null) {
                sVar.tZK.xrk = new li();
            }
            if (this.ugd.xrk != null) {
                sVar.tZK.xrk.vOV = this.ugd.xrk.vOV;
                ab.i("MicroMsg.FTS.WebSearchLogic", "websearch from url [%s]", this.ugd.xrk.vOV);
            }
            this.ugd = null;
        }
        if (sVar.businessType == 262144 && this.ugd != null && this.ugd.xrk.vOS == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt("isRefresh", 1);
            bundle.putString("widgetId", aa.t(map, "widgetId"));
            sVar.tZN = bundle;
            sVar.tZK = this.ugd;
            this.ugd = null;
        }
        AppMethodBeat.o(5754);
        return sVar;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(5755);
        String str2 = "MicroMsg.FTS.WebSearchLogic";
        String str3 = "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(mVar != null ? mVar.getType() : 0);
        ab.v(str2, str3, objArr);
        if (mVar instanceof com.tencent.mm.plugin.websearch.api.a) {
            com.tencent.mm.kernel.g.Rg().b(mVar.getType(), (f) this);
            com.tencent.mm.plugin.websearch.api.a aVar = (com.tencent.mm.plugin.websearch.api.a) mVar;
            if (i == 0 && i2 == 0) {
                str3 = aVar.abH();
                int abI = aVar.abI();
                ab.i("MicroMsg.FTS.WebSearchLogic", "callback %s", aVar.bAk());
                a(aVar.cUO(), str3, aVar.cUP(), aVar.cUR(), aVar.cUQ());
                if (abI > 0) {
                    ab.i("MicroMsg.FTS.WebSearchLogic", "updateCode %d, need update", Integer.valueOf(abI));
                    com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
                    com.tencent.mm.pluginsdk.g.a.a.b.Ky(27);
                }
                AppMethodBeat.o(5755);
                return;
            }
            ab.i("MicroMsg.FTS.WebSearchLogic", "net scene fail %s", aVar.bAk());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", -1);
            } catch (JSONException e) {
            }
            a(aVar.cUO(), jSONObject.toString(), aVar.cUP(), aVar.cUR(), null);
            AppMethodBeat.o(5755);
            return;
        }
        if (mVar instanceof com.tencent.mm.plugin.websearch.api.b) {
            com.tencent.mm.kernel.g.Rg().b(mVar.getType(), (f) this);
            com.tencent.mm.plugin.websearch.api.b bVar = (com.tencent.mm.plugin.websearch.api.b) mVar;
            if (i == 0 && i2 == 0) {
                h.JR(bVar.cUO()).agq(bVar.abH());
            } else {
                ab.i("MicroMsg.FTS.WebSearchLogic", "net scene fail %s", bVar.getQuery());
                h.JR(bVar.cUO()).agq("{}");
                AppMethodBeat.o(5755);
                return;
            }
        }
        AppMethodBeat.o(5755);
    }

    private void a(int i, String str, boolean z, String str2, Bundle bundle) {
        AppMethodBeat.i(5756);
        final int i2 = i;
        final String str3 = str2;
        final String str4 = str;
        final boolean z2 = z;
        final Bundle bundle2 = bundle;
        this.rdm.aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5741);
                if (g.this.ufQ != null) {
                    ab.i("MicroMsg.FTS.WebSearchLogic", "waiting for countdown, %d", Long.valueOf(g.this.ufQ.getCount()));
                    try {
                        g.this.ufQ.await();
                    } catch (InterruptedException e) {
                        ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
                    }
                } else {
                    ab.i("MicroMsg.FTS.WebSearchLogic", "count down latch null");
                }
                int i = i2;
                if (g.this.ufR != null) {
                    i = g.this.ufR.cIv;
                    if (g.this.ufR.tZO && g.this.ufP) {
                        ab.w("MicroMsg.FTS.WebSearchLogic", "ingore pre get data");
                        AppMethodBeat.o(5741);
                        return;
                    }
                }
                ab.i("MicroMsg.FTS.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", Integer.valueOf(i), str3, g.this.ufR);
                h.JR(i).a(str4, z2, str3, bundle2);
                AppMethodBeat.o(5741);
            }
        });
        AppMethodBeat.o(5756);
    }

    public final boolean aG(Map<String, Object> map) {
        AppMethodBeat.i(5757);
        ab.i("MicroMsg.FTS.WebSearchLogic", "getSuggestionData %s", map);
        s sVar = new s();
        sVar.ctj = aa.t(map, SearchIntents.EXTRA_QUERY);
        try {
            sVar.ctj = URLDecoder.decode(sVar.ctj, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        sVar.businessType = aa.d((Map) map, "type", 0);
        sVar.scene = aa.d((Map) map, "scene", 0);
        sVar.tZw = aa.u(map, "isHomePage") ? 1 : 0;
        sVar.cIv = bo.g(map.get("webview_instance_id"), -1);
        sVar.tZB.add(aa.t(map, "prefixQuery"));
        int d = aa.d((Map) map, "requestType", 0);
        sVar.mDw = aa.d((Map) map, "subtype", 0);
        ab.i("MicroMsg.FTS.WebSearchLogic", "getSearchData, webviewID = %d", Integer.valueOf(sVar.cIv));
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
                Object obj = com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
                if (obj != null && (obj instanceof String)) {
                    sVar.tZJ.xrS = (String) obj;
                }
            }
        }
        switch (d) {
            case 0:
                b bVar = this.ugj;
                if (bVar.ugp != null) {
                    com.tencent.mm.kernel.g.Rg().b(bVar.ugp.getType(), g.this);
                    com.tencent.mm.kernel.g.Rg().c(bVar.ugp);
                    bVar.ugp = null;
                }
                if (bVar.ugp == null) {
                    com.tencent.mm.plugin.websearch.api.b eVar;
                    if (r.aNU()) {
                        eVar = new e(sVar);
                    } else if (Iy(sVar.scene)) {
                        eVar = new com.tencent.mm.modelappbrand.r(sVar.ctj, sVar.scene, sVar.cIv);
                    } else {
                        eVar = new e(sVar);
                    }
                    bVar.ugp = eVar;
                    com.tencent.mm.kernel.g.Rg().a(bVar.ugp.getType(), g.this);
                    com.tencent.mm.kernel.g.Rg().a(bVar.ugp, 0);
                    break;
                }
                break;
            case 1:
                String str = sVar.ctj;
                int i = sVar.businessType;
                int i2 = sVar.cIv;
                if (!bo.isNullOrNil(str)) {
                    int[] iArr;
                    if (this.mEx != null) {
                        ((n) com.tencent.mm.kernel.g.M(n.class)).cancelSearchTask(this.mEx);
                        this.mEx = null;
                    }
                    switch (i) {
                        case 8:
                            iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
                            break;
                        default:
                            iArr = null;
                            break;
                    }
                    if (iArr != null) {
                        i iVar = new i();
                        iVar.hbo = 16;
                        iVar.query = str;
                        iVar.mEr = iArr;
                        iVar.mEt = 5;
                        iVar.mEv = com.tencent.mm.plugin.fts.a.c.b.mEV;
                        iVar.mEu = new HashSet();
                        iVar.mEw = this.plf;
                        this.mEx = ((n) com.tencent.mm.kernel.g.M(n.class)).search(2, iVar);
                        this.mEx.mDs = Integer.valueOf(i2);
                        break;
                    }
                }
                break;
            case 2:
                h.JR(sVar.cIv).agq(af.cVm());
                break;
        }
        AppMethodBeat.o(5757);
        return false;
    }

    /* JADX WARNING: Missing block: B:3:0x002b, code skipped:
            if (r8 == 0) goto L_0x01cd;
     */
    /* JADX WARNING: Missing block: B:4:0x002d, code skipped:
            r0 = com.tencent.mm.plugin.fts.a.a.d.a(r5, r14, r3, r6);
            r0.mDD = com.tencent.mm.plugin.fts.a.a.d.a.CustomTag;
            r0.mDI = "<em class=\"highlight\">";
            r0.mDJ = "</em>";
            r1 = com.tencent.mm.plugin.fts.a.f.a(r0).mDR.toString();
     */
    /* JADX WARNING: Missing block: B:5:0x004a, code skipped:
            if (r7 == 0) goto L_0x01ca;
     */
    /* JADX WARNING: Missing block: B:6:0x004c, code skipped:
            r0 = com.tencent.mm.plugin.fts.a.a.d.a(r4, r14, r3, r6);
            r0.mDD = com.tencent.mm.plugin.fts.a.a.d.a.CustomTag;
            r0.mDI = "<em class=\"highlight\">";
            r0.mDJ = "</em>";
            r0 = r10 + com.tencent.mm.plugin.fts.a.f.a(r0).mDR.toString();
     */
    /* JADX WARNING: Missing block: B:7:0x0079, code skipped:
            r2 = new org.json.JSONObject();
     */
    /* JADX WARNING: Missing block: B:9:?, code skipped:
            r2.put("nickName", com.tencent.mm.plugin.fts.a.d.LC(r13.mDx));
            r2.put("userName", r13.mDx);
     */
    /* JADX WARNING: Missing block: B:10:0x0092, code skipped:
            if (r8 == 0) goto L_0x009a;
     */
    /* JADX WARNING: Missing block: B:11:0x0094, code skipped:
            r2.put("nickNameHighlight", r1);
     */
    /* JADX WARNING: Missing block: B:12:0x009a, code skipped:
            if (r7 == 0) goto L_0x00a2;
     */
    /* JADX WARNING: Missing block: B:13:0x009c, code skipped:
            r2.put("extraHighlight", r0);
     */
    /* JADX WARNING: Missing block: B:17:0x00a7, code skipped:
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:18:0x00a8, code skipped:
            r6 = r0;
            r7 = 0;
            r8 = 1;
            r4 = null;
            r10 = null;
     */
    /* JADX WARNING: Missing block: B:20:0x00b0, code skipped:
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:21:0x00b1, code skipped:
            r4 = r4.field_nickname;
            r6 = r0;
            r7 = 1;
            r8 = 0;
            r10 = com.tencent.mm.sdk.platformtools.ah.getContext().getString(com.tencent.mm.R.string.e05);
     */
    /* JADX WARNING: Missing block: B:52:0x01ca, code skipped:
            r0 = r4;
     */
    /* JADX WARNING: Missing block: B:53:0x01cd, code skipped:
            r1 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final JSONObject a(com.tencent.mm.plugin.fts.a.a.l lVar, com.tencent.mm.plugin.fts.a.a.g gVar) {
        AppMethodBeat.i(5758);
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(lVar.mDx);
        CharSequence LC = com.tencent.mm.plugin.fts.a.d.LC(lVar.mDx);
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        int i2;
        Object obj;
        String string;
        String str;
        switch (lVar.mDw) {
            case 1:
                z = false;
                z2 = false;
                break;
            case 2:
                z = false;
                break;
            case 3:
                z = true;
                break;
            case 4:
                z3 = false;
                z2 = false;
                i = 1;
                i2 = 0;
                obj = aoO.dul;
                string = ah.getContext().getString(R.string.e00);
                break;
            case 5:
                z = false;
                z2 = false;
                break;
            case 6:
                z = false;
                break;
            case 7:
                z = true;
                break;
            case 11:
                List<String> MX = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSMainDB().MX(aoO.field_contactLabelIds);
                StringBuffer stringBuffer = new StringBuffer();
                for (CharSequence charSequence : gVar.mEa) {
                    for (String str2 : MX) {
                        if (com.tencent.mm.plugin.fts.a.d.Nb(str2).contains(charSequence)) {
                            stringBuffer.append(str2);
                            stringBuffer.append(",");
                        }
                    }
                }
                stringBuffer.trimToSize();
                if (stringBuffer.length() == 0) {
                    str2 = "";
                } else {
                    str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
                }
                z3 = false;
                z2 = false;
                i = 1;
                i2 = 0;
                obj = str2;
                string = ah.getContext().getString(R.string.e08);
                break;
            case 15:
                str2 = aoO.Hq();
                if (bo.isNullOrNil(str2)) {
                    str2 = aoO.field_username;
                }
                z3 = false;
                z2 = false;
                i = 1;
                i2 = 0;
                obj = str2;
                string = ah.getContext().getString(R.string.e09);
                break;
            case 16:
                String str3 = lVar.content;
                if (!bo.isNullOrNil(str3)) {
                    for (String str22 : str3.split("​")) {
                        if (str22.startsWith(gVar.mDY)) {
                            z3 = false;
                            z2 = false;
                            i = 1;
                            i2 = 0;
                            obj = str22;
                            string = ah.getContext().getString(R.string.e04);
                            break;
                        }
                    }
                }
                str22 = str3;
                z3 = false;
                z2 = false;
                i = 1;
                i2 = 0;
                obj = str22;
                string = ah.getContext().getString(R.string.e04);
            case 17:
                z3 = false;
                z2 = false;
                i = 1;
                i2 = 0;
                obj = lVar.content;
                string = ah.getContext().getString(R.string.dzz);
                break;
            case 18:
                z3 = false;
                z2 = false;
                i = 1;
                i2 = 0;
                obj = lVar.content;
                string = ah.getContext().getString(R.string.e06);
                break;
            default:
                z3 = false;
                z2 = false;
                i = 0;
                i2 = 0;
                CharSequence obj2 = null;
                string = null;
                break;
        }
        AppMethodBeat.o(5758);
        return r2;
    }

    public final void cWp() {
        AppMethodBeat.i(5759);
        String If = aa.If(0);
        ab.i("MicroMsg.FTS.WebSearchLogic", "config commKV %s", If);
        if (TextUtils.isEmpty(If)) {
            this.ufT = true;
            AppMethodBeat.o(5759);
            return;
        }
        this.ufT = k(new HashSet(Arrays.asList(If.split(","))));
        AppMethodBeat.o(5759);
    }

    static /* synthetic */ boolean IA(int i) {
        return i == 21;
    }

    static /* synthetic */ boolean al(String str, int i, int i2) {
        AppMethodBeat.i(5761);
        if (!TextUtils.isEmpty(str) && aa.cVg()) {
            int cVh = aa.cVh();
            if ((cVh <= 0 || str.length() <= cVh) && (i != 3 || i2 == 8)) {
                if ((i == 3 || i == 20) && i2 == 8) {
                    AppMethodBeat.o(5761);
                    return true;
                } else if ((i == 14 || i == 22) && i2 == 8) {
                    AppMethodBeat.o(5761);
                    return true;
                } else if (i == 16) {
                    AppMethodBeat.o(5761);
                    return true;
                }
            }
        }
        AppMethodBeat.o(5761);
        return false;
    }
}
