package com.tencent.p177mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelappbrand.C32813q;
import com.tencent.p177mm.modelappbrand.C32814r;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p230g.p231a.C18347ns;
import com.tencent.p177mm.p230g.p231a.C37762mr;
import com.tencent.p177mm.p230g.p231a.C42006ig;
import com.tencent.p177mm.p612ui.C5493d;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p975c.C39132b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C14425b;
import com.tencent.p177mm.plugin.websearch.api.C22760s;
import com.tencent.p177mm.plugin.websearch.api.C35570af;
import com.tencent.p177mm.plugin.websearch.api.C40194t;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C7197a;
import com.tencent.p177mm.plugin.websearch.p1064c.p1065a.C35577c;
import com.tencent.p177mm.plugin.websearch.p1064c.p1065a.C35579e;
import com.tencent.p177mm.plugin.websearch.p1064c.p1065a.C35579e.C29746a;
import com.tencent.p177mm.plugin.websearch.p1064c.p1065a.C40197b;
import com.tencent.p177mm.plugin.webview.fts.p578b.p579a.C4539a;
import com.tencent.p177mm.plugin.webview.fts.p578b.p579a.p1329a.C22789a;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C23018g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29944h;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.C35933li;
import com.tencent.p177mm.protocal.protobuf.bem;
import com.tencent.p177mm.protocal.protobuf.bvq;
import com.tencent.p177mm.protocal.protobuf.cgg;
import com.tencent.p177mm.protocal.protobuf.cmg;
import com.tencent.p177mm.protocal.protobuf.cvf;
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
import com.tencent.p177mm.storage.C7616ad;
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

/* renamed from: com.tencent.mm.plugin.webview.fts.g */
public final class C22797g implements C1202f {
    static final long ufL = ((long) (C5493d.dwu() + 500));
    public C28106a mEx;
    private C28114l plf = new C228025();
    private C5004al rdm = new C5004al("WebSearchLogic_worker");
    public cvf tZK;
    private Set<String> ufM;
    volatile boolean ufO;
    volatile boolean ufP;
    volatile CountDownLatch ufQ;
    private volatile C22760s ufR;
    volatile boolean ufT;
    public C4884c ufU = new C227961();
    public int ugc = 0;
    public cvf ugd;
    public Map<String, Integer> uge = new HashMap();
    long ugf;
    public C4884c ugg = new C228002();
    private C35577c ugh = new C40197b();
    public C22803a ugi = new C22803a(this, (byte) 0);
    public C22798b ugj = new C22798b(this, (byte) 0);

    /* renamed from: com.tencent.mm.plugin.webview.fts.g$1 */
    class C227961 extends C4884c<C18347ns> {
        C227961() {
            AppMethodBeat.m2504i(5736);
            this.xxI = C18347ns.class.getName().hashCode();
            AppMethodBeat.m2505o(5736);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(5737);
            C22797g.this.cWp();
            AppMethodBeat.m2505o(5737);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.g$b */
    public class C22798b {
        public C14425b ugp;

        private C22798b() {
        }

        /* synthetic */ C22798b(C22797g c22797g, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.g$3 */
    public class C227993 implements C1224a {
        final /* synthetic */ String hlQ;
        final /* synthetic */ int ugl;
        final /* synthetic */ String ugm;

        public C227993(int i, String str, String str2) {
            this.ugl = i;
            this.hlQ = str;
            this.ugm = str2;
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(5740);
            if (c1207m.getType() != 2608) {
                AppMethodBeat.m2505o(5740);
            } else if (i == 0 && i2 == 0) {
                if (c7472b != null) {
                    bvq bvq = (bvq) c7472b.fsH.fsP;
                    C23018g JR = C29944h.m47401JR(this.ugl);
                    String str2 = this.hlQ;
                    String str3 = this.ugm;
                    String str4 = bvq.vOy;
                    Bundle bundle = new Bundle();
                    bundle.putString("searchId", str2);
                    bundle.putString("poiId", str3);
                    bundle.putString("json", str4);
                    try {
                        if (JR.umI != null) {
                            JR.umI.mo26784c(145, bundle);
                        }
                    } catch (RemoteException e) {
                        C4990ab.m7420w("MicroMsg.MsgHandler", "onGetPoiReady exception" + e.getMessage());
                    }
                }
                AppMethodBeat.m2505o(5740);
            } else {
                C4990ab.m7412e("MicroMsg.FTS.WebSearchLogic", "getPoiInfo onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
                AppMethodBeat.m2505o(5740);
            }
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.g$2 */
    class C228002 extends C4884c<C37762mr> {
        C228002() {
            AppMethodBeat.m2504i(5738);
            this.xxI = C37762mr.class.getName().hashCode();
            AppMethodBeat.m2505o(5738);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(5739);
            C37762mr c37762mr = (C37762mr) c4883b;
            C22797g c22797g = C22797g.this;
            String str = c37762mr.cIx.cIz;
            String str2 = c37762mr.cIx.cvF;
            String str3 = c37762mr.cIx.cIy;
            String str4 = c37762mr.cIx.query;
            int i = c37762mr.cIx.scene;
            String str5 = c37762mr.cIx.cIA;
            String str6 = c37762mr.cIx.cIB;
            int i2 = c37762mr.cIx.cIC;
            if (!TextUtils.isEmpty(str4)) {
                if (!c22797g.ufT) {
                    C4990ab.m7421w("MicroMsg.FTS.WebSearchLogic", "do no support pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", Integer.valueOf(C46400aa.m87305HV(0)), str, str2, str3);
                } else if (System.currentTimeMillis() - c22797g.ugf <= C22797g.ufL) {
                    C4990ab.m7420w("MicroMsg.FTS.WebSearchLogic", "pre get data fail for time interval limit");
                } else {
                    C4990ab.m7421w("MicroMsg.FTS.WebSearchLogic", "pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", Integer.valueOf(C46400aa.m87305HV(0)), str, str2, str3);
                    c22797g.ufO = true;
                    if (c22797g.ufQ != null) {
                        c22797g.ufQ.countDown();
                    }
                    c22797g.ufQ = new CountDownLatch(1);
                    c22797g.ufP = false;
                    c22797g.mo38395a(str, str2, str3, str4, i, str5, str6, i2);
                    c22797g.ugf = System.currentTimeMillis();
                }
            }
            AppMethodBeat.m2505o(5739);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.g$5 */
    class C228025 implements C28114l {
        C228025() {
        }

        /* renamed from: b */
        public final void mo8215b(C28109j c28109j) {
            AppMethodBeat.m2504i(5742);
            switch (c28109j.bFZ) {
                case -3:
                case -2:
                case -1:
                    C29944h.m47401JR(((Integer) C22797g.this.mEx.mDs).intValue()).agq("");
                    break;
                case 0:
                    if (c28109j.mEy == null || c28109j.mEy.size() == 0) {
                        C4990ab.m7416i("MicroMsg.FTS.WebSearchLogic", "local contact search size 0");
                        C29944h.m47401JR(((Integer) C22797g.this.mEx.mDs).intValue()).agq("");
                        AppMethodBeat.m2505o(5742);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray2 = new JSONArray();
                        for (C45966l c45966l : c28109j.mEy) {
                            if (c45966l.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                                jSONArray2.put(C22797g.m34597a(c45966l, c28109j.mDz));
                            }
                        }
                        jSONObject2.put("items", jSONArray2);
                        jSONObject2.put("title", C4996ah.getContext().getString(C25738R.string.c2_));
                        jSONObject2.put("count", jSONArray2.length());
                        jSONObject2.put("type", 3);
                        jSONArray.put(jSONObject2);
                        jSONObject.put("data", jSONArray);
                        jSONObject.put("ret", 0);
                        C29944h.m47401JR(((Integer) C22797g.this.mEx.mDs).intValue()).agq(jSONObject.toString());
                        AppMethodBeat.m2505o(5742);
                        return;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "onSearchDone", new Object[0]);
                        AppMethodBeat.m2505o(5742);
                        return;
                    }
            }
            AppMethodBeat.m2505o(5742);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.g$a */
    public class C22803a implements Comparable {
        private ThreadPoolExecutor cmi;
        public C7197a ufZ;
        public C22804a ugn;

        /* renamed from: com.tencent.mm.plugin.webview.fts.g$a$a */
        public class C22804a implements Runnable {
            C22760s fpL;
            public volatile boolean jxQ;

            private C22804a() {
            }

            /* synthetic */ C22804a(C22803a c22803a, byte b) {
                this();
            }

            public final void run() {
                AppMethodBeat.m2504i(5743);
                if (Thread.interrupted()) {
                    AppMethodBeat.m2505o(5743);
                } else if (C5046bo.isNullOrNil(this.fpL.ctj)) {
                    C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "error query %d %d %d %d %s %d", Integer.valueOf(this.fpL.businessType), Integer.valueOf(this.fpL.scene), Integer.valueOf(this.fpL.tZw), Integer.valueOf(this.fpL.cIC), this.fpL.lcA, Integer.valueOf(this.fpL.offset));
                    AppMethodBeat.m2505o(5743);
                } else {
                    switch (this.fpL.scene) {
                        case 3:
                        case 16:
                        case 20:
                            ((C12029n) C1720g.m3530M(C12029n.class)).addSOSHistory(this.fpL.ctj);
                            break;
                    }
                    C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "start New NetScene %s ,  %d", this.fpL.ctj, Integer.valueOf(this.fpL.cIv));
                    if (C22803a.this.ufZ != null) {
                        C1720g.m3540Rg().mo14547c(C22803a.this.ufZ);
                    }
                    C35579e c35579e = null;
                    if ((this.fpL.tZx == null || this.fpL.tZx.isEmpty()) && C22797g.m34601al(this.fpL.ctj, this.fpL.scene, this.fpL.businessType)) {
                        c35579e = (C35579e) C22797g.this.ugh.adR(this.fpL.ctj);
                        long currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                        C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "match contact cost %d ms", Long.valueOf(currentTimeMillis));
                        C7060h.pYm.mo8381e(14717, this.fpL.ctj, Integer.valueOf(C1855t.m3878Zo()), Integer.valueOf(c35579e.mFf.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.fpL.scene));
                    }
                    if (this.jxQ) {
                        C4990ab.m7416i("MicroMsg.FTS.WebSearchLogic", "was cancelled");
                        AppMethodBeat.m2505o(5743);
                        return;
                    }
                    C29833g.cYC().ufm.mo48023m(this.fpL.scene, this.fpL.ctj, this.fpL.businessType);
                    C22803a.this.ufZ = C22803a.m34617c(this.fpL);
                    if (c35579e != null) {
                        LinkedList linkedList = new LinkedList();
                        for (C29746a c29746a : new ArrayList(c35579e.mFf)) {
                            cmg cmg = new cmg();
                            cmg.jBB = c29746a.userName;
                            cmg.xkl = c29746a.ucj;
                            cmg.jCH = c29746a.bCu;
                            cmg.wbw = c29746a.hHV;
                            cmg.guS = c29746a.dFl;
                            cmg.vEA = c29746a.desc;
                            linkedList.add(cmg);
                        }
                        C22803a.this.ufZ.mo15504ax(linkedList);
                    }
                    C1720g.m3540Rg().mo14539a(C22803a.this.ufZ.getType(), C22797g.this);
                    C1720g.m3540Rg().mo14541a(C22803a.this.ufZ, 0);
                    C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "doScene(type : %s)", Integer.valueOf(C22803a.this.ufZ.getType()));
                    AppMethodBeat.m2505o(5743);
                }
            }
        }

        private C22803a() {
            AppMethodBeat.m2504i(5744);
            this.cmi = new ThreadPoolExecutor(0, 10, 120, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
            AppMethodBeat.m2505o(5744);
        }

        /* synthetic */ C22803a(C22797g c22797g, byte b) {
            this();
        }

        /* renamed from: b */
        public final void mo38400b(C22760s c22760s) {
            AppMethodBeat.m2504i(5745);
            if (this.ugn != null) {
                this.ugn.jxQ = true;
            }
            this.ugn = new C22804a(this, (byte) 0);
            this.ugn.fpL = c22760s;
            C22797g.this.ufR = c22760s;
            this.cmi.execute(this.ugn);
            AppMethodBeat.m2505o(5745);
        }

        public final int compareTo(Object obj) {
            return 0;
        }

        /* renamed from: c */
        static /* synthetic */ C7197a m34617c(C22760s c22760s) {
            C7197a c32813q;
            AppMethodBeat.m2504i(5746);
            if (C22797g.m34594Iz(c22760s.scene) && !C27278r.aNU()) {
                c32813q = new C32813q(c22760s);
            } else if (C22797g.m34592IA(c22760s.scene)) {
                c32813q = new C40194t(c22760s);
            } else {
                c32813q = new C46412d(c22760s);
            }
            c32813q.mo15501HN(c22760s.cIv);
            AppMethodBeat.m2505o(5746);
            return c32813q;
        }
    }

    /* renamed from: Iz */
    static /* synthetic */ boolean m34594Iz(int i) {
        AppMethodBeat.m2504i(138972);
        boolean Iy = C22797g.m34593Iy(i);
        AppMethodBeat.m2505o(138972);
        return Iy;
    }

    static {
        AppMethodBeat.m2504i(5762);
        AppMethodBeat.m2505o(5762);
    }

    public C22797g() {
        AppMethodBeat.m2504i(5747);
        C4990ab.m7410d("MicroMsg.FTS.WebSearchLogic", "create WebSearchLogic");
        this.ufU.dnU();
        this.ugg.dnU();
        this.ufM = new HashSet();
        this.ufM.add(DownloadInfo.NETTYPE);
        this.ufM.add("currentPage");
        this.ufM.add("requestId");
        this.ufM.add("parentSearchID");
        cWp();
        AppMethodBeat.m2505o(5747);
    }

    /* renamed from: Iy */
    private static boolean m34593Iy(int i) {
        return i == 201;
    }

    /* renamed from: aD */
    public final boolean mo38396aD(Map<String, Object> map) {
        int i = 1;
        AppMethodBeat.m2504i(5748);
        C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "getSearchData: %s", map.toString());
        C29944h.m47401JR(C5046bo.m7550g(map.get("webview_instance_id"), -1)).mo38646c(C46400aa.m87332d((Map) map, "type", 0), C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY), (Map) map);
        if (this.ufO) {
            this.ufO = false;
            int g = C5046bo.m7550g(map.get("webview_instance_id"), -1);
            if (this.ufR != null) {
                this.ufR.cIv = g;
            }
            if (m34608k(C22797g.m34599aE(map))) {
                if (this.ufQ != null) {
                    this.ufQ.countDown();
                }
                if (this.ufR != null) {
                    C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "do not send this call, wait for pre get, webivewId %d, %s", Integer.valueOf(this.ufR.cIv), this.ufR);
                }
            } else {
                C4990ab.m7412e("MicroMsg.FTS.WebSearchLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
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
            C4990ab.m7416i("MicroMsg.FTS.WebSearchLogic", "waiting for pre getdata back");
            AppMethodBeat.m2505o(5748);
        } else {
            this.ugi.mo38400b(m34600aF(map));
            AppMethodBeat.m2505o(5748);
        }
        return false;
    }

    /* renamed from: k */
    private boolean m34608k(Set<String> set) {
        AppMethodBeat.m2504i(5749);
        if (set == null || this.ufM.containsAll(set)) {
            AppMethodBeat.m2505o(5749);
            return true;
        }
        AppMethodBeat.m2505o(5749);
        return false;
    }

    /* renamed from: aE */
    private static Set<String> m34599aE(Map<String, Object> map) {
        Set<String> emptySet;
        Throwable e;
        AppMethodBeat.m2504i(5750);
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
                    C4990ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
                    AppMethodBeat.m2505o(5750);
                    return emptySet;
                }
            } catch (Exception e3) {
                e = e3;
                emptySet = null;
                C4990ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
                AppMethodBeat.m2505o(5750);
                return emptySet;
            }
        }
        AppMethodBeat.m2505o(5750);
        return emptySet;
    }

    /* renamed from: a */
    public final boolean mo38395a(String str, String str2, String str3, String str4, int i, String str5, String str6, int i2) {
        AppMethodBeat.m2504i(5751);
        C4990ab.m7416i("MicroMsg.FTS.WebSearchLogic", "preGetSearchData");
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
            jSONObject.put("textValue", C46400aa.bVP());
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
            C4990ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
        }
        hashMap.put("extReqParams", jSONArray.toString());
        hashMap.put("sessionId", str2);
        hashMap.put("subSessionId", str3);
        hashMap.put("requestId", str);
        C22760s aF = m34600aF(hashMap);
        aF.tZO = true;
        if (m34602ay(aF.tZG)) {
            this.ugi.mo38400b(aF);
            AppMethodBeat.m2505o(5751);
            return false;
        }
        IllegalStateException illegalStateException = new IllegalStateException("pre get data must use same commKvSets with hardcode set");
        AppMethodBeat.m2505o(5751);
        throw illegalStateException;
    }

    /* renamed from: bB */
    public static void m34604bB(int i, String str) {
        AppMethodBeat.m2504i(5752);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", Integer.valueOf(i));
        hashMap.put("statSessionId", str);
        C1720g.m3540Rg().mo14541a(new C40218c(hashMap, 1), 0);
        AppMethodBeat.m2505o(5752);
    }

    /* renamed from: ay */
    private boolean m34602ay(LinkedList<C23447tn> linkedList) {
        AppMethodBeat.m2504i(5753);
        HashSet hashSet = new HashSet();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            hashSet.add(((C23447tn) it.next()).key);
        }
        boolean equals = this.ufM.equals(hashSet);
        AppMethodBeat.m2505o(5753);
        return equals;
    }

    /* renamed from: aF */
    private C22760s m34600aF(Map<String, Object> map) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        CharSequence charSequence;
        AppMethodBeat.m2504i(5754);
        int d = C46400aa.m87332d((Map) map, "scene", 0);
        C22760s c22760s = new C22760s();
        c22760s.ctj = C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY);
        c22760s.offset = C46400aa.m87332d((Map) map, "offset", 0);
        c22760s.businessType = C46400aa.m87332d((Map) map, "type", 0);
        c22760s.scene = d;
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
                for (d = 0; d < jSONArray.length(); d++) {
                    jSONObject = jSONArray.getJSONObject(d);
                    C23447tn c23447tn = new C23447tn();
                    c23447tn.key = jSONObject.optString("key", "");
                    c23447tn.waD = (long) jSONObject.optInt("uintValue", 0);
                    c23447tn.waE = jSONObject.optString("textValue", "");
                    c22760s.tZG.add(c23447tn);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "commKvJSONArray", new Object[0]);
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
                C4990ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        t = C46400aa.m87342t(map, "prefixQuery");
        if (!C5046bo.isNullOrNil(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (d = 0; d < jSONArray.length(); d++) {
                    c22760s.tZB.add(jSONArray.getString(d));
                }
            } catch (Exception e22) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e22, "prefixQueryJSONArray", new Object[0]);
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
                C4990ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        t = C46400aa.m87342t(map, "numConditions");
        if (!C5046bo.isNullOrNil(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (d = 0; d < jSONArray.length(); d++) {
                    jSONObject = jSONArray.optJSONObject(d);
                    bem bem = new bem();
                    bem.wIB = jSONObject.optLong("from");
                    bem.wIC = jSONObject.optLong("to");
                    bem.wIA = jSONObject.optInt("field");
                    c22760s.tZH.add(bem);
                }
            } catch (Exception e2222) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        c22760s.cIv = C5046bo.m7550g(map.get("webview_instance_id"), -1);
        c22760s.aOt = C4988aa.m7403gw(C4996ah.getContext());
        c22760s.mDw = C46400aa.m87332d((Map) map, "subType", 0);
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
        if (this.ugc == 1) {
            c22760s.tZK = this.tZK;
        } else {
            c22760s.tZK = null;
        }
        t = c22760s.ctj;
        C4539a.cWt();
        C22789a aeb = C4539a.aeb(t);
        if (aeb == null) {
            charSequence = "";
        } else {
            C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", aeb.ugB, aeb.csB, aeb.ugz, aeb.ugA);
            this.tZK = new cvf();
            this.tZK.xrj = 1;
            this.tZK.xrk = new C35933li();
            this.tZK.xrk.csB = aeb.csB;
            this.tZK.xrk.vOO = C5046bo.ank(aeb.ugz);
            this.tZK.xrk.kLN = aeb.ugA;
            charSequence = aeb.ugB;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            c22760s.ctj = charSequence;
            c22760s.tZK = this.tZK;
        }
        if (c22760s.scene == 33 && this.ugd != null) {
            if (c22760s.tZK == null) {
                c22760s.tZK = new cvf();
            }
            if (c22760s.tZK.xrk == null) {
                c22760s.tZK.xrk = new C35933li();
            }
            if (this.ugd.xrk != null) {
                c22760s.tZK.xrk.vOV = this.ugd.xrk.vOV;
                C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "websearch from url [%s]", this.ugd.xrk.vOV);
            }
            this.ugd = null;
        }
        if (c22760s.businessType == 262144 && this.ugd != null && this.ugd.xrk.vOS == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt("isRefresh", 1);
            bundle.putString("widgetId", C46400aa.m87342t(map, "widgetId"));
            c22760s.tZN = bundle;
            c22760s.tZK = this.ugd;
            this.ugd = null;
        }
        AppMethodBeat.m2505o(5754);
        return c22760s;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(5755);
        String str2 = "MicroMsg.FTS.WebSearchLogic";
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
                str3 = c7197a.abH();
                int abI = c7197a.abI();
                C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "callback %s", c7197a.bAk());
                m34598a(c7197a.cUO(), str3, c7197a.cUP(), c7197a.cUR(), c7197a.cUQ());
                if (abI > 0) {
                    C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "updateCode %d, need update", Integer.valueOf(abI));
                    C14845c.veg;
                    C14839b.m23095Ky(27);
                }
                AppMethodBeat.m2505o(5755);
                return;
            }
            C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "net scene fail %s", c7197a.bAk());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", -1);
            } catch (JSONException e) {
            }
            m34598a(c7197a.cUO(), jSONObject.toString(), c7197a.cUP(), c7197a.cUR(), null);
            AppMethodBeat.m2505o(5755);
            return;
        }
        if (c1207m instanceof C14425b) {
            C1720g.m3540Rg().mo14546b(c1207m.getType(), (C1202f) this);
            C14425b c14425b = (C14425b) c1207m;
            if (i == 0 && i2 == 0) {
                C29944h.m47401JR(c14425b.cUO()).agq(c14425b.abH());
            } else {
                C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "net scene fail %s", c14425b.getQuery());
                C29944h.m47401JR(c14425b.cUO()).agq("{}");
                AppMethodBeat.m2505o(5755);
                return;
            }
        }
        AppMethodBeat.m2505o(5755);
    }

    /* renamed from: a */
    private void m34598a(int i, String str, boolean z, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(5756);
        final int i2 = i;
        final String str3 = str2;
        final String str4 = str;
        final boolean z2 = z;
        final Bundle bundle2 = bundle;
        this.rdm.mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(5741);
                if (C22797g.this.ufQ != null) {
                    C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "waiting for countdown, %d", Long.valueOf(C22797g.this.ufQ.getCount()));
                    try {
                        C22797g.this.ufQ.await();
                    } catch (InterruptedException e) {
                        C4990ab.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.FTS.WebSearchLogic", "count down latch null");
                }
                int i = i2;
                if (C22797g.this.ufR != null) {
                    i = C22797g.this.ufR.cIv;
                    if (C22797g.this.ufR.tZO && C22797g.this.ufP) {
                        C4990ab.m7420w("MicroMsg.FTS.WebSearchLogic", "ingore pre get data");
                        AppMethodBeat.m2505o(5741);
                        return;
                    }
                }
                C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", Integer.valueOf(i), str3, C22797g.this.ufR);
                C29944h.m47401JR(i).mo38619a(str4, z2, str3, bundle2);
                AppMethodBeat.m2505o(5741);
            }
        });
        AppMethodBeat.m2505o(5756);
    }

    /* renamed from: aG */
    public final boolean mo38397aG(Map<String, Object> map) {
        AppMethodBeat.m2504i(5757);
        C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "getSuggestionData %s", map);
        C22760s c22760s = new C22760s();
        c22760s.ctj = C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY);
        try {
            c22760s.ctj = URLDecoder.decode(c22760s.ctj, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        c22760s.businessType = C46400aa.m87332d((Map) map, "type", 0);
        c22760s.scene = C46400aa.m87332d((Map) map, "scene", 0);
        c22760s.tZw = C46400aa.m87343u(map, "isHomePage") ? 1 : 0;
        c22760s.cIv = C5046bo.m7550g(map.get("webview_instance_id"), -1);
        c22760s.tZB.add(C46400aa.m87342t(map, "prefixQuery"));
        int d = C46400aa.m87332d((Map) map, "requestType", 0);
        c22760s.mDw = C46400aa.m87332d((Map) map, "subtype", 0);
        C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "getSearchData, webviewID = %d", Integer.valueOf(c22760s.cIv));
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
                Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
                if (obj != null && (obj instanceof String)) {
                    c22760s.tZJ.xrS = (String) obj;
                }
            }
        }
        switch (d) {
            case 0:
                C22798b c22798b = this.ugj;
                if (c22798b.ugp != null) {
                    C1720g.m3540Rg().mo14546b(c22798b.ugp.getType(), C22797g.this);
                    C1720g.m3540Rg().mo14547c(c22798b.ugp);
                    c22798b.ugp = null;
                }
                if (c22798b.ugp == null) {
                    C14425b c43877e;
                    if (C27278r.aNU()) {
                        c43877e = new C43877e(c22760s);
                    } else if (C22797g.m34593Iy(c22760s.scene)) {
                        c43877e = new C32814r(c22760s.ctj, c22760s.scene, c22760s.cIv);
                    } else {
                        c43877e = new C43877e(c22760s);
                    }
                    c22798b.ugp = c43877e;
                    C1720g.m3540Rg().mo14539a(c22798b.ugp.getType(), C22797g.this);
                    C1720g.m3540Rg().mo14541a(c22798b.ugp, 0);
                    break;
                }
                break;
            case 1:
                String str = c22760s.ctj;
                int i = c22760s.businessType;
                int i2 = c22760s.cIv;
                if (!C5046bo.isNullOrNil(str)) {
                    int[] iArr;
                    if (this.mEx != null) {
                        ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(this.mEx);
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
                        C20846i c20846i = new C20846i();
                        c20846i.hbo = 16;
                        c20846i.query = str;
                        c20846i.mEr = iArr;
                        c20846i.mEt = 5;
                        c20846i.mEv = C39132b.mEV;
                        c20846i.mEu = new HashSet();
                        c20846i.mEw = this.plf;
                        this.mEx = ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
                        this.mEx.mDs = Integer.valueOf(i2);
                        break;
                    }
                }
                break;
            case 2:
                C29944h.m47401JR(c22760s.cIv).agq(C35570af.cVm());
                break;
        }
        AppMethodBeat.m2505o(5757);
        return false;
    }

    /* JADX WARNING: Missing block: B:3:0x002b, code skipped:
            if (r8 == 0) goto L_0x01cd;
     */
    /* JADX WARNING: Missing block: B:4:0x002d, code skipped:
            r0 = com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66568a(r5, r14, r3, r6);
            r0.mDD = com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.C28108a.CustomTag;
            r0.mDI = "<em class=\"highlight\">";
            r0.mDJ = "</em>";
            r1 = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(r0).mDR.toString();
     */
    /* JADX WARNING: Missing block: B:5:0x004a, code skipped:
            if (r7 == 0) goto L_0x01ca;
     */
    /* JADX WARNING: Missing block: B:6:0x004c, code skipped:
            r0 = com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66568a(r4, r14, r3, r6);
            r0.mDD = com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.C28108a.CustomTag;
            r0.mDI = "<em class=\"highlight\">";
            r0.mDJ = "</em>";
            r0 = r10 + com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(r0).mDR.toString();
     */
    /* JADX WARNING: Missing block: B:7:0x0079, code skipped:
            r2 = new org.json.JSONObject();
     */
    /* JADX WARNING: Missing block: B:9:?, code skipped:
            r2.put("nickName", com.tencent.p177mm.plugin.fts.p419a.C3161d.m5401LC(r13.mDx));
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
            r10 = com.tencent.p177mm.sdk.platformtools.C4996ah.getContext().getString(com.tencent.p177mm.C25738R.string.e05);
     */
    /* JADX WARNING: Missing block: B:52:0x01ca, code skipped:
            r0 = r4;
     */
    /* JADX WARNING: Missing block: B:53:0x01cd, code skipped:
            r1 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final JSONObject m34597a(C45966l c45966l, C20840g c20840g) {
        AppMethodBeat.m2504i(5758);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c45966l.mDx);
        CharSequence LC = C3161d.m5401LC(c45966l.mDx);
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        int i2;
        Object obj;
        String string;
        String str;
        switch (c45966l.mDw) {
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
                string = C4996ah.getContext().getString(C25738R.string.e00);
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
                List<String> MX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSMainDB().mo46036MX(aoO.field_contactLabelIds);
                StringBuffer stringBuffer = new StringBuffer();
                for (CharSequence charSequence : c20840g.mEa) {
                    for (String str2 : MX) {
                        if (C3161d.m5404Nb(str2).contains(charSequence)) {
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
                string = C4996ah.getContext().getString(C25738R.string.e08);
                break;
            case 15:
                str2 = aoO.mo14673Hq();
                if (C5046bo.isNullOrNil(str2)) {
                    str2 = aoO.field_username;
                }
                z3 = false;
                z2 = false;
                i = 1;
                i2 = 0;
                obj = str2;
                string = C4996ah.getContext().getString(C25738R.string.e09);
                break;
            case 16:
                String str3 = c45966l.content;
                if (!C5046bo.isNullOrNil(str3)) {
                    for (String str22 : str3.split("​")) {
                        if (str22.startsWith(c20840g.mDY)) {
                            z3 = false;
                            z2 = false;
                            i = 1;
                            i2 = 0;
                            obj = str22;
                            string = C4996ah.getContext().getString(C25738R.string.e04);
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
                string = C4996ah.getContext().getString(C25738R.string.e04);
            case 17:
                z3 = false;
                z2 = false;
                i = 1;
                i2 = 0;
                obj = c45966l.content;
                string = C4996ah.getContext().getString(C25738R.string.dzz);
                break;
            case 18:
                z3 = false;
                z2 = false;
                i = 1;
                i2 = 0;
                obj = c45966l.content;
                string = C4996ah.getContext().getString(C25738R.string.e06);
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
        AppMethodBeat.m2505o(5758);
        return r2;
    }

    public final void cWp() {
        AppMethodBeat.m2504i(5759);
        String If = C46400aa.m87315If(0);
        C4990ab.m7417i("MicroMsg.FTS.WebSearchLogic", "config commKV %s", If);
        if (TextUtils.isEmpty(If)) {
            this.ufT = true;
            AppMethodBeat.m2505o(5759);
            return;
        }
        this.ufT = m34608k(new HashSet(Arrays.asList(If.split(","))));
        AppMethodBeat.m2505o(5759);
    }

    /* renamed from: IA */
    static /* synthetic */ boolean m34592IA(int i) {
        return i == 21;
    }

    /* renamed from: al */
    static /* synthetic */ boolean m34601al(String str, int i, int i2) {
        AppMethodBeat.m2504i(5761);
        if (!TextUtils.isEmpty(str) && C46400aa.cVg()) {
            int cVh = C46400aa.cVh();
            if ((cVh <= 0 || str.length() <= cVh) && (i != 3 || i2 == 8)) {
                if ((i == 3 || i == 20) && i2 == 8) {
                    AppMethodBeat.m2505o(5761);
                    return true;
                } else if ((i == 14 || i == 22) && i2 == 8) {
                    AppMethodBeat.m2505o(5761);
                    return true;
                } else if (i == 16) {
                    AppMethodBeat.m2505o(5761);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(5761);
        return false;
    }
}
