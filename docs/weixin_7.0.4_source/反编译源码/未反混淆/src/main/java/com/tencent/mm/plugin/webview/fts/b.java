package com.tencent.mm.plugin.webview.fts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements com.tencent.mm.ai.f {
    public com.tencent.mm.sdk.b.c hAA = new com.tencent.mm.sdk.b.c<ke>() {
        {
            AppMethodBeat.i(5675);
            this.xxI = ke.class.getName().hashCode();
            AppMethodBeat.o(5675);
        }

        private boolean a(ke keVar) {
            AppMethodBeat.i(5676);
            com.tencent.mm.aw.e eVar = keVar.cFH.cFB;
            if (eVar != null && com.tencent.mm.aw.a.d(eVar)) {
                switch (keVar.cFH.action) {
                    case 0:
                    case 1:
                        for (Integer intValue : b.this.ufg) {
                            h.JR(intValue.intValue()).dN(eVar.fJU, 1);
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        for (Integer intValue2 : b.this.ufg) {
                            h.JR(intValue2.intValue()).dN(eVar.fJU, 0);
                        }
                        break;
                }
            }
            AppMethodBeat.o(5676);
            return false;
        }
    };
    private long ijU;
    public com.tencent.mm.plugin.fts.a.a.a mEx;
    public l plf = new l() {
        public final void b(final j jVar) {
            AppMethodBeat.i(5679);
            if (jVar.bFZ == 0) {
                final ArrayList arrayList = new ArrayList();
                for (com.tencent.mm.plugin.fts.a.a.l lVar : jVar.mEy) {
                    arrayList.add(lVar.content);
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(5678);
                        if (!(b.this.mEx == null || b.this.mEx.mDs == null)) {
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(((Integer) b.this.mEx.mDs).intValue());
                            String str = jVar.mAJ.query;
                            ab.i("MicroMsg.MsgHandler", "onSearchHistoryCallback: %s", arrayList.toString());
                            Bundle bundle = new Bundle();
                            bundle.putString(SearchIntents.EXTRA_QUERY, str);
                            bundle.putStringArrayList("result", r2);
                            try {
                                if (JR.umI != null) {
                                    JR.umI.c(126, bundle);
                                }
                                AppMethodBeat.o(5678);
                                return;
                            } catch (RemoteException e) {
                                ab.w("MicroMsg.MsgHandler", "onSearchHistoryCallback exception" + e.getMessage());
                            }
                        }
                        AppMethodBeat.o(5678);
                    }
                });
            }
            AppMethodBeat.o(5679);
        }
    };
    public Set<Integer> ufg;
    public l ufh = new l() {
        public final void b(final j jVar) {
            AppMethodBeat.i(5673);
            final f fVar = (f) jVar.mAJ;
            ab.i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", Integer.valueOf(jVar.bFZ), Integer.valueOf(fVar.ufG));
            if (jVar.bFZ == 0) {
                final ArrayList arrayList = new ArrayList();
                for (com.tencent.mm.plugin.fts.a.a.l lVar : jVar.mEy) {
                    arrayList.add(lVar.content);
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(5672);
                        if (fVar.ufG != 0) {
                            ab.i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener callback， id %d", Integer.valueOf(fVar.ufG));
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(fVar.ufG);
                            try {
                                ab.i("MicroMsg.MsgHandler", "onGetSearchHistory %s", arrayList.toString());
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("ret", 0);
                                JSONArray jSONArray = new JSONArray();
                                JSONArray jSONArray2 = new JSONArray();
                                Iterator it = r0.iterator();
                                while (it.hasNext()) {
                                    String str = (String) it.next();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("word", str);
                                    jSONObject2.put("id", System.currentTimeMillis());
                                    jSONObject2.put("timeStamp", System.currentTimeMillis());
                                    jSONArray2.put(jSONObject2);
                                }
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("items", jSONArray2);
                                jSONArray.put(jSONObject3);
                                jSONObject.put("data", jSONArray);
                                Bundle bundle = new Bundle();
                                bundle.putString("data", jSONObject.toString());
                                try {
                                    if (JR.umI != null) {
                                        JR.umI.c(ErrorCode.NEEDDOWNLOAD_4, bundle);
                                        AppMethodBeat.o(5672);
                                        return;
                                    }
                                    ab.i("MicroMsg.MsgHandler", "callbacker is null");
                                    AppMethodBeat.o(5672);
                                    return;
                                } catch (RemoteException e) {
                                    ab.w("MicroMsg.MsgHandler", "onGetSearchHistory exception" + e.getMessage());
                                    AppMethodBeat.o(5672);
                                    return;
                                }
                            } catch (JSONException e2) {
                                ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.o(5672);
                    }
                });
            }
            AppMethodBeat.o(5673);
        }
    };
    private HashMap<String, b> ufi;
    public e ufj;
    public v ufk;
    private Map<Integer, g> ufl = new HashMap();
    public e ufm = new e();
    public List<com.tencent.mm.aw.e> ufn;
    private com.tencent.mm.plugin.websearch.c.a.c ufo;
    com.tencent.mm.plugin.websearch.c.a.d ufp;

    class c {
        public int cIC;
        public String hlm;
        public String nickname;
        public String pln;
        public uy pmz;
        public int position;
        public String query;
        public int scene;
        public String signature;
        public int ufB;
        public boolean ufC;
        public String ufD;
        public int ufE;
        public String username;

        private c() {
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }
    }

    class d {
        public String country;
        public String dFl;
        public int dtS;
        public String duc;
        public String dud;
        public String nickname;
        public String query;
        public int scene;
        public String signature;
        public int ufF;
        public String username;

        private d() {
        }

        /* synthetic */ d(b bVar, byte b) {
            this();
        }
    }

    public class f extends i {
        public int ufG;

        private f() {
        }

        public /* synthetic */ f(b bVar, byte b) {
            this();
        }
    }

    class b {
        String cBF;
        boolean fOb;
        private String hPI;
        String lcA;
        int scene;
        int type;
        long ufA;
        long ufz;

        private b() {
            this.fOb = false;
            this.hPI = null;
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final boolean isAvailable() {
            AppMethodBeat.i(5682);
            if (this.fOb) {
                AppMethodBeat.o(5682);
                return false;
            } else if (bo.isNullOrNil(this.cBF) || (System.currentTimeMillis() / 1000) - this.ufA > this.ufz) {
                AppMethodBeat.o(5682);
                return false;
            } else {
                AppMethodBeat.o(5682);
                return true;
            }
        }

        /* Access modifiers changed, original: final */
        public final String cWm() {
            AppMethodBeat.i(5683);
            if (this.hPI == null) {
                this.hPI = "";
                try {
                    JSONArray optJSONArray = new JSONObject(this.cBF).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(Uri.encode(optJSONArray.optJSONObject(i).optString("hotword")));
                    }
                    this.hPI = TextUtils.join("|", arrayList);
                } catch (Exception e) {
                }
            }
            String str = this.hPI;
            AppMethodBeat.o(5683);
            return str;
        }

        /* Access modifiers changed, original: final */
        public final void gr(int i, int i2) {
            AppMethodBeat.i(5684);
            azv azv = new azv();
            String XZ = com.tencent.mm.plugin.record.b.XZ();
            String s = b.s(i, i2, false);
            if (!s.equals(b.s(i, i2, true))) {
                this.fOb = true;
            }
            File file = new File(XZ, s);
            byte[] e = com.tencent.mm.a.e.e(file.getAbsolutePath(), 0, (int) file.length());
            if (e != null) {
                try {
                    azv.parseFrom(e);
                    this.scene = azv.scene;
                    this.cBF = azv.vOy;
                    this.ufz = azv.wDD;
                    this.ufA = azv.wDE;
                    this.lcA = azv.vQg;
                    this.type = azv.jCt;
                    ab.i("MicroMsg.FTS.FTSWebViewLogic", "load bizCacheFile %s %d", file.getAbsolutePath(), Integer.valueOf(e.length));
                    AppMethodBeat.o(5684);
                    return;
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(5684);
        }
    }

    public class e {
        public boolean ctn;
        public boolean egk = true;
        public int mFl;
        public String query;
        public boolean sAY;
        public int scene;

        public final void m(int i, String str, int i2) {
            this.query = str;
            this.scene = i;
            this.ctn = false;
            this.mFl = i2;
            this.sAY = false;
            this.egk = false;
        }
    }

    public class a implements Runnable {
        public String data;
        public boolean ufy;

        private a() {
        }

        public /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(5681);
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.data);
                for (int i = 0; i < jSONArray.length(); i++) {
                    TimeLineObject tC = ((m) com.tencent.mm.kernel.g.K(m.class)).tC(jSONArray.getString(i));
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.aw.e a = com.tencent.mm.aw.g.a(com.tencent.mm.kernel.g.RP().eJM, tC, 9);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                if (!this.ufy || b.this.ufn == null) {
                    b.this.ufn = arrayList;
                    AppMethodBeat.o(5681);
                    return;
                }
                b.this.ufn.addAll(arrayList);
                AppMethodBeat.o(5681);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
                AppMethodBeat.o(5681);
            }
        }
    }

    static class g {
        public String cBF;
        public long interval;
        public int scene;
        public long ufA;
        public int ufH;

        public g() {
            this.scene = 0;
            this.cBF = "";
            this.interval = 0;
            this.ufA = 0;
            this.ufH = 0;
        }

        public g(cst cst, int i) {
            AppMethodBeat.i(5685);
            this.scene = 0;
            this.cBF = "";
            this.interval = 0;
            this.ufA = 0;
            this.ufH = 0;
            this.scene = 201;
            this.cBF = cst.cBF;
            this.interval = (long) cst.eCL;
            this.ufA = System.currentTimeMillis() / 1000;
            this.ufH = i;
            AppMethodBeat.o(5685);
        }

        public static g cWn() {
            g gVar;
            AppMethodBeat.i(5686);
            File file = new File(com.tencent.mm.plugin.record.b.XZ(), Iv(201));
            byte[] e = com.tencent.mm.a.e.e(file.getAbsolutePath(), 0, (int) file.length());
            try {
                azw azw = new azw();
                azw.parseFrom(e);
                gVar = new g();
                try {
                    gVar.scene = azw.Scene;
                    gVar.cBF = azw.vOy;
                    gVar.interval = azw.wDF;
                    gVar.ufA = azw.wDE;
                    gVar.ufH = azw.wDG;
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                gVar = null;
            }
            AppMethodBeat.o(5686);
            return gVar;
        }

        static String Iv(int i) {
            AppMethodBeat.i(5687);
            String str = "SearchGuide_" + i + "-" + aa.gw(ah.getContext());
            AppMethodBeat.o(5687);
            return str;
        }

        public final boolean isExpired() {
            AppMethodBeat.i(5688);
            if (this.ufA + this.interval <= System.currentTimeMillis() / 1000) {
                AppMethodBeat.o(5688);
                return true;
            }
            AppMethodBeat.o(5688);
            return false;
        }
    }

    public b() {
        AppMethodBeat.i(5689);
        ab.i("MicroMsg.FTS.FTSWebViewLogic", "create FTSWebViewLogic");
        this.ufi = new HashMap();
        this.ufg = Collections.synchronizedSet(new HashSet());
        com.tencent.mm.sdk.b.a.xxA.c(this.hAA);
        AppMethodBeat.o(5689);
    }

    public static Bundle p(int i, Bundle bundle) {
        AppMethodBeat.i(5690);
        Bundle bundle2 = new Bundle();
        switch (i) {
            case 2:
                try {
                    String string = bundle.getString("key");
                    bundle2.putString("result", ac.adL(string).toString());
                    if ("educationTab".equals(string)) {
                        JSONObject adL = ac.adL("discoverSearchGuide");
                        if (adL.optJSONArray("items").length() > 0) {
                            bundle2.putString("result_1", adL.toString());
                            break;
                        }
                    }
                } catch (Exception e) {
                    break;
                }
                break;
            case 4:
                Map d = com.tencent.mm.plugin.websearch.api.aa.d(bundle.getInt("scene"), bundle.getBoolean("isHomePage"), bundle.getInt("type"));
                bundle2.putString("type", (String) d.get("type"));
                bundle2.putString("isMostSearchBiz", (String) d.get("isMostSearchBiz"));
                bundle2.putString("isLocalSug", (String) d.get("isLocalSug"));
                bundle2.putString("isSug", (String) d.get("isSug"));
                bundle2.putString("scene", (String) d.get("scene"));
                break;
            case 6:
                try {
                    bundle2.putString("result", ac.adM(bundle.getString("key")));
                    break;
                } catch (Exception e2) {
                    break;
                }
            case 7:
                bundle2.putString("data", com.tencent.mm.plugin.webview.modeltools.g.cYC().cWl());
                break;
        }
        AppMethodBeat.o(5690);
        return bundle2;
    }

    public final boolean av(Map<String, Object> map) {
        AppMethodBeat.i(5691);
        String t;
        int d;
        switch (com.tencent.mm.plugin.websearch.api.aa.d((Map) map, NativeProtocol.WEB_DIALOG_ACTION, 0)) {
            case 1:
                if (af.uax == null) {
                    af.cVk();
                }
                af.uax.jBw.clear();
                SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("fts_history_search_sp", 0);
                try {
                    sharedPreferences.edit().putString(af.cVl(), Base64.encodeToString(af.uax.toByteArray(), 0)).apply();
                    ab.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", t);
                    break;
                } catch (IOException e) {
                    break;
                }
            case 2:
                int d2 = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "type", 0);
                d = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "scene", 0);
                if (System.currentTimeMillis() - this.ijU > 1000) {
                    this.ijU = System.currentTimeMillis();
                    if (!com.tencent.mm.plugin.websearch.api.aa.HU(0)) {
                        ab.e("MicroMsg.FTS.FTSWebViewLogic", "fts h5 template not avail");
                        break;
                    }
                    an.x(d2, d, ac.adM("searchID"));
                    Intent cVd = com.tencent.mm.plugin.websearch.api.aa.cVd();
                    cVd.putExtra("ftsneedkeyboard", true);
                    cVd.putExtra("ftsbizscene", d);
                    cVd.putExtra("ftsType", d2);
                    cVd.putExtra("rawUrl", com.tencent.mm.plugin.websearch.api.aa.E(com.tencent.mm.plugin.websearch.api.aa.d(d, true, d2)));
                    cVd.putExtra("key_load_js_without_delay", true);
                    com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd);
                    break;
                }
                break;
            case 3:
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "webview_instance_id", -1));
                d = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "scene", 0);
                t = com.tencent.mm.plugin.websearch.api.aa.t(map, SearchIntents.EXTRA_QUERY);
                if (d == 20 && !bo.isNullOrNil(t)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fts_key_new_query", t);
                    try {
                        if (JR.umI != null) {
                            JR.umI.c(n.CTRL_INDEX, bundle);
                            break;
                        }
                    } catch (Exception e2) {
                        ab.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + e2.getMessage());
                        break;
                    }
                }
                ab.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", Integer.valueOf(d), t);
                break;
                break;
        }
        AppMethodBeat.o(5691);
        return false;
    }

    public final String cWl() {
        AppMethodBeat.i(5692);
        String s = s(20, 0, true);
        if (this.ufi.get(s) == null) {
            b bVar = new b(this, (byte) 0);
            bVar.gr(20, 0);
            this.ufi.put(s, bVar);
        }
        b bVar2 = (b) this.ufi.get(s);
        s = bVar2.isAvailable() ? bVar2.cBF : "";
        if (bo.isNullOrNil(s)) {
            s = "";
            AppMethodBeat.o(5692);
            return s;
        }
        AppMethodBeat.o(5692);
        return s;
    }

    public final boolean aw(Map<String, Object> map) {
        AppMethodBeat.i(5693);
        ab.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData: %s", map);
        int d = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "scene", 0);
        int d2 = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "type", 0);
        int d3 = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "requestType", 0);
        int g = bo.g(map.get("webview_instance_id"), -1);
        String str = (String) map.get("requestId");
        boolean u = com.tencent.mm.plugin.websearch.api.aa.u(map, "ignoreCache");
        String s;
        if (d3 == 0) {
            b bVar;
            s = s(d, d2, true);
            if (this.ufi.get(s) == null) {
                bVar = new b(this, (byte) 0);
                bVar.gr(d, d2);
                this.ufi.put(s, bVar);
            }
            bVar = (b) this.ufi.get(s);
            if (!(bo.isNullOrNil(bVar.cBF) || u)) {
                ab.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d, cache %s", Integer.valueOf(g), bVar.cBF);
                if (!(bVar.scene == 20 && bVar.type == 0 && (bVar.fOb || !bVar.isAvailable()))) {
                    h.JR(g).d(d3, bVar.cBF, 1, str);
                }
            }
            if (!bVar.isAvailable() || u) {
                com.tencent.mm.kernel.g.Rg().a(1048, (com.tencent.mm.ai.f) this);
                ab.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", Integer.valueOf(g));
                this.ufk = new v(d, d2, com.tencent.mm.plugin.websearch.api.aa.HV(0), g, aa.gw(ah.getContext()), ac.adL("discoverSearchEntry").optLong("guideParam"), str);
                com.tencent.mm.kernel.g.Rg().a(this.ufk, 0);
            } else {
                ab.i("MicroMsg.FTS.FTSWebViewLogic", "hit the cache: %d %d %d %d, data %s", Integer.valueOf(bVar.scene), Long.valueOf(bVar.ufz), Long.valueOf(bVar.ufA), Integer.valueOf(bVar.type), bVar.cBF);
                if (bVar.scene == 20 && bVar.type == 0) {
                    an.a(bVar.scene, 0, bVar.lcA, bVar.type, 2, bVar.cWm(), 1);
                } else {
                    an.a(bVar.scene, 0, bVar.lcA, bVar.type, 1, "", 0);
                }
                AppMethodBeat.o(5693);
                return false;
            }
        }
        bdj cVo = ai.cVo();
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (d = cVo.jBw.size() - 1; d >= 0; d--) {
                JSONObject jSONObject3 = new JSONObject();
                bdi bdi = (bdi) cVo.jBw.get(d);
                if (t.mY(bdi.vHl)) {
                    com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(bdi.vHl);
                    if (qX != null) {
                        jSONObject3.put("avatarUrl", qX.field_brandIconURL);
                        jSONObject3.put("userName", qX.field_username);
                        jSONObject3.put("nickName", s.mJ(qX.field_username));
                        jSONArray2.put(jSONObject3);
                    }
                }
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put("type", 5);
            jSONObject2.put("title", "");
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
            ab.d("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData returnString=%s", jSONObject.toString());
            h.JR(g).d(1, s, 1, str);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "gen mostSearchBizContactList error", new Object[0]);
        }
        AppMethodBeat.o(5693);
        return false;
    }

    public final boolean ax(Map<String, Object> map) {
        g cWn;
        int i = 1;
        AppMethodBeat.i(5694);
        int g = bo.g(map.get("webview_instance_id"), -1);
        if (this.ufl.get(Integer.valueOf(201)) == null) {
            cWn = g.cWn();
            if (cWn != null) {
                this.ufl.put(Integer.valueOf(201), cWn);
            }
        }
        cWn = (g) this.ufl.get(Integer.valueOf(201));
        if (cWn != null) {
            h.JR(g).m(cWn.cBF, 1, cWn.isExpired() ? 1 : 0, cWn.ufH);
            i = cWn.isExpired();
        }
        if (i != 0) {
            com.tencent.mm.kernel.g.Rg().a(1866, (com.tencent.mm.ai.f) this);
            com.tencent.mm.ai.m cVar = new c(map, 0);
            if (map != null) {
                cVar.cIv = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "webview_instance_id", -1);
            }
            com.tencent.mm.kernel.g.Rg().a(cVar, 0);
        }
        AppMethodBeat.o(5694);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x00b9 A:{SYNTHETIC, Splitter:B:9:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0446  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Map<String, Object> map, com.tencent.mm.plugin.webview.ui.tools.jsapi.g gVar) {
        String str;
        int i;
        String str2;
        String str3;
        Object obj;
        AppMethodBeat.i(5695);
        ab.i("MicroMsg.FTS.FTSWebViewLogic", "openSearchWebView %s", map.toString());
        int ank = bo.ank((String) map.get("actionType"));
        int d = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "type", 0);
        String str4 = (String) map.get("extParams");
        String str5 = (String) map.get("jumpTo");
        String str6 = (String) map.get("navBarColor");
        String t = com.tencent.mm.plugin.websearch.api.aa.t(map, "publishId");
        boolean equals = "true".equals((String) map.get("hideSearchBar"));
        int ank2 = bo.ank((String) map.get("isHomePage"));
        String valueOf = String.valueOf(map.get("isSug"));
        String str7 = (String) map.get("nativeConfig");
        if (!TextUtils.isEmpty(str7)) {
            try {
                JSONObject jSONObject = new JSONObject(str7);
                if (jSONObject.has("title")) {
                    str7 = jSONObject.optString("title");
                } else {
                    str7 = null;
                }
                str = str7;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
            }
            i = 0;
            if (!bo.isNullOrNil(str6)) {
                try {
                    i = Color.parseColor(str6);
                } catch (IllegalArgumentException e2) {
                    ab.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e2.getMessage());
                    AppMethodBeat.o(5695);
                    return true;
                }
            }
            str2 = (String) map.get("statusBarStyle");
            str3 = (String) map.get("tagId");
            obj = (String) map.get("sessionId");
            Bundle dcJ;
            switch (ank) {
                case 1:
                    switch (d) {
                        case 1:
                            a(az(map), false);
                            break;
                        case 8:
                            com.tencent.mm.plugin.websearch.api.aa.t(map, "snsid");
                            str5 = com.tencent.mm.plugin.websearch.api.aa.t(map, "objectXmlDesc");
                            str6 = com.tencent.mm.plugin.websearch.api.aa.t(map, "userName");
                            boolean u = com.tencent.mm.plugin.websearch.api.aa.u(map, "fromMusicItem");
                            com.tencent.mm.plugin.webview.modeltools.g.cYC();
                            z(str5, str6, u);
                            break;
                        case 32:
                            a(aA(map));
                            break;
                        default:
                            str5 = com.tencent.mm.plugin.websearch.api.aa.t(map, "jumpUrl");
                            ab.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", str5);
                            dcJ = gVar.dcJ();
                            if (!bo.isNullOrNil(str5)) {
                                com.tencent.mm.plugin.webview.modeltools.g.cYC();
                                a(str5, dcJ, i, str2, t, 0);
                                break;
                            }
                            break;
                    }
                case 2:
                    str5 = com.tencent.mm.plugin.websearch.api.aa.t(map, "jumpUrl");
                    ab.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", str5);
                    dcJ = gVar.dcJ();
                    if (!bo.isNullOrNil(str5)) {
                        com.tencent.mm.plugin.webview.modeltools.g.cYC();
                        a(str5, dcJ, i, str2, t, 0);
                        break;
                    }
                    break;
                case 3:
                case 7:
                    str6 = com.tencent.mm.plugin.websearch.api.aa.t(map, SearchIntents.EXTRA_QUERY);
                    int d2 = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "scene", 0);
                    String t2 = com.tencent.mm.plugin.websearch.api.aa.t(map, "searchId");
                    Intent intent = new Intent();
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("key_load_js_without_delay", true);
                    intent.putExtra("ftsQuery", str6);
                    intent.putExtra("ftsType", d);
                    intent.putExtra("customize_status_bar_color", i);
                    intent.putExtra("status_bar_style", str2);
                    intent.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str5));
                    intent.putExtra("KPublisherId", t);
                    intent.putExtra("ftsbizscene", d2);
                    if (str != null) {
                        intent.putExtra("title", str);
                    }
                    Map cA;
                    if (!r.aNU()) {
                        cA = com.tencent.mm.bd.a.cA(d2, d);
                        cA.put(SearchIntents.EXTRA_QUERY, str6);
                        cA.put("searchId", t2);
                        intent.putExtra("rawUrl", com.tencent.mm.bd.a.b(d2, cA));
                        if (d2 == 20 || d2 == 22 || d2 == 33) {
                            str5 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                        } else {
                            str5 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                        }
                        com.tencent.mm.bp.d.b(ah.getContext(), "webview", str5, intent);
                        break;
                    }
                    Object obj2 = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "isWeAppMore", 0) == 1 ? 1 : null;
                    int d3 = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "tabPageType", 0);
                    if (obj2 == null) {
                        cA = com.tencent.mm.plugin.websearch.api.aa.a(d2, false, d, str4);
                        cA.put(SearchIntents.EXTRA_QUERY, str6);
                        cA.put("searchId", t2);
                        cA.put("isHomePage", String.valueOf(ank2));
                        cA.put("isSug", valueOf);
                        if (!TextUtils.isEmpty(obj)) {
                            cA.put("sessionId", obj);
                            intent.putExtra("sessionId", obj);
                        }
                        String HP = com.tencent.mm.plugin.websearch.api.aa.HP(d2);
                        cA.put("subSessionId", HP);
                        intent.putExtra("subSessionId", HP);
                        intent.putExtra("rawUrl", com.tencent.mm.bd.a.b(d2, cA));
                        intent.putExtra("ftsQuery", str6);
                        intent.putExtra("customize_status_bar_color", i);
                        intent.putExtra("status_bar_style", str2);
                        intent.putExtra("tabId", str3);
                        intent.putExtra("key_load_js_without_delay", true);
                        if (ank == 7) {
                            intent.putExtra("ftsneedkeyboard", true);
                        }
                        if (d3 != 1) {
                            if (d2 == 20 || d2 == 22 || d2 == 33 || d2 == 3 || d2 == 36) {
                                intent.putExtra("ftsInitToSearch", true);
                                intent.putExtra("hideSearchInput", equals);
                                str5 = ".ui.tools.fts.FTSSOSHomeWebViewUI";
                            } else {
                                str5 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                            }
                            if (!TextUtils.isEmpty(str5)) {
                                com.tencent.mm.bp.d.b(ah.getContext(), "webview", str5, intent);
                                break;
                            }
                        }
                        intent.putExtra("ftscaneditable", false);
                        com.tencent.mm.plugin.websearch.api.aa.a(ah.getContext(), str6, intent, str, str4, t2, (String) obj, HP);
                        AppMethodBeat.o(5695);
                        return false;
                    }
                    cA = r.a(d2, false, d, str4);
                    cA.put(SearchIntents.EXTRA_QUERY, str6);
                    cA.put("searchId", t2);
                    cA.put("subType", String.valueOf(com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "subType", 0)));
                    cA.put("isWeAppMore", String.valueOf(com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "isWeAppMore", 0)));
                    str6 = com.tencent.mm.modelappbrand.b.abv();
                    cA.put("sessionId", str6);
                    cA.put("sessionId", str6);
                    cA.put("subSessionId", str6);
                    intent.putExtra("key_session_id", str6);
                    intent.putExtra("rawUrl", r.E(cA));
                    intent.putExtra("ftsbizscene", d2);
                    intent.putExtra("customize_status_bar_color", i);
                    intent.putExtra("status_bar_style", str2);
                    intent.putExtra("sessionId", str6);
                    com.tencent.mm.bp.d.b(ah.getContext(), "appbrand", ".ui.AppBrandSearchUI", intent);
                    break;
                    break;
                case 5:
                    str5 = com.tencent.mm.plugin.websearch.api.aa.t(map, SearchIntents.EXTRA_QUERY);
                    int d4 = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "topStoryScene", 0);
                    i = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "tagId", 0);
                    str2 = com.tencent.mm.plugin.websearch.api.aa.t(map, "navigationId");
                    if (bo.isNullOrNil(obj)) {
                        obj = com.tencent.mm.plugin.websearch.api.aa.HP(d4);
                    }
                    t = String.valueOf(System.currentTimeMillis());
                    HashMap hashMap = new HashMap();
                    hashMap.put("scene", "21");
                    hashMap.put(SearchIntents.EXTRA_QUERY, str5);
                    hashMap.put("extParams", str4);
                    hashMap.put("sessionId", obj);
                    hashMap.put("subSessionId", obj);
                    hashMap.put("requestId", t);
                    hashMap.put("pRequestId", t);
                    hashMap.put("seq", t);
                    hashMap.put("navigationId", str2);
                    hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i));
                    chn chn = new chn();
                    chn.xgj = com.tencent.mm.plugin.topstory.ui.c.cFx();
                    chn.scene = d4;
                    chn.hlm = "";
                    chn.ctj = str5;
                    chn.cvF = obj;
                    chn.cIy = obj;
                    chn.xgl = 2;
                    chn.url = com.tencent.mm.plugin.topstory.a.g.o(hashMap);
                    chn.xgm = str;
                    chn.cdf = i;
                    chn.nQB = t;
                    chn.tZP = str2;
                    chn.xgn = com.tencent.mm.plugin.websearch.api.aa.bVP();
                    tn tnVar = new tn();
                    tnVar.key = "rec_category";
                    tnVar.waD = (long) i;
                    tnVar.waE = String.valueOf(i);
                    chn.tZG.add(tnVar);
                    com.tencent.mm.plugin.topstory.ui.c.a(ah.getContext(), chn, t);
                    break;
            }
            AppMethodBeat.o(5695);
            return false;
        }
        str = null;
        i = 0;
        if (bo.isNullOrNil(str6)) {
        }
        str2 = (String) map.get("statusBarStyle");
        str3 = (String) map.get("tagId");
        obj = (String) map.get("sessionId");
        switch (ank) {
            case 1:
                break;
            case 2:
                break;
            case 3:
            case 7:
                break;
            case 5:
                break;
        }
        AppMethodBeat.o(5695);
        return false;
    }

    public final boolean a(Map<String, Object> map, com.tencent.mm.plugin.webview.ui.tools.jsapi.g gVar, String str) {
        AppMethodBeat.i(5696);
        this.ufm.sAY = true;
        boolean u = com.tencent.mm.plugin.websearch.api.aa.u(map, "isTeachPage");
        boolean u2 = com.tencent.mm.plugin.websearch.api.aa.u(map, "isMoreButton");
        Object obj = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "isFeedBack", 0) == 1 ? 1 : null;
        Object obj2 = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "isWeAppMore", 0) == 1 ? 1 : null;
        String t = com.tencent.mm.plugin.websearch.api.aa.t(map, "sessionId");
        String str2 = (String) map.get("navBarColor");
        String t2 = com.tencent.mm.plugin.websearch.api.aa.t(map, "searchPlaceHolder");
        int i = 0;
        if (!bo.isNullOrNil(str2)) {
            try {
                i = Color.parseColor(str2);
            } catch (IllegalArgumentException e) {
                ab.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e.getMessage());
                AppMethodBeat.o(5696);
                return true;
            }
        }
        String str3 = (String) map.get("statusBarStyle");
        String t3;
        Bundle bundle;
        if (obj == null) {
            int d = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "type", 0);
            int d2 = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "opType", 0);
            if (d2 <= 0) {
                if (!u2) {
                    str2 = (String) map.get("url");
                    ab.i("MicroMsg.FTS.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", Integer.valueOf(d), str2);
                    switch (d) {
                        case 1:
                            a(az(map), false);
                            break;
                        case 8:
                            com.tencent.mm.plugin.websearch.api.aa.t(map, "snsid");
                            str2 = com.tencent.mm.plugin.websearch.api.aa.t(map, "objectXmlDesc");
                            t3 = com.tencent.mm.plugin.websearch.api.aa.t(map, "userName");
                            boolean u3 = com.tencent.mm.plugin.websearch.api.aa.u(map, "fromMusicItem");
                            com.tencent.mm.plugin.webview.modeltools.g.cYC();
                            z(str2, t3, u3);
                            break;
                        case 32:
                            a(aA(map));
                            break;
                        default:
                            str2 = com.tencent.mm.plugin.websearch.api.aa.t(map, "jumpUrl");
                            ab.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", str2, com.tencent.mm.plugin.websearch.api.aa.t(map, "publishId"), Integer.valueOf(com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "payScene", 0)));
                            Bundle bundle2 = null;
                            if (gVar != null) {
                                bundle2 = gVar.dcJ();
                            }
                            if (!bo.isNullOrNil(str2)) {
                                com.tencent.mm.plugin.webview.modeltools.g.cYC();
                                a(str2, bundle2, i, str3, r4, r5);
                                break;
                            }
                            break;
                    }
                }
                str2 = com.tencent.mm.plugin.websearch.api.aa.t(map, SearchIntents.EXTRA_QUERY);
                i = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "scene", 0);
                str3 = com.tencent.mm.plugin.websearch.api.aa.t(map, "searchId");
                Intent intent = new Intent();
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("key_load_js_without_delay", true);
                intent.putExtra("ftsQuery", str2);
                intent.putExtra("ftsType", d);
                intent.putExtra("sessionId", t);
                Map cA;
                if (!r.aNU()) {
                    cA = com.tencent.mm.bd.a.cA(i, d);
                    try {
                        cA.put(SearchIntents.EXTRA_QUERY, q.encode(str2, "UTF-8"));
                    } catch (Exception e2) {
                        cA.put(SearchIntents.EXTRA_QUERY, str2);
                    }
                    cA.put("searchId", str3);
                    cA.put("sessionId", t);
                    str2 = com.tencent.mm.plugin.websearch.api.aa.HP(bo.ank((String) cA.get("scene")));
                    cA.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("key_session_id", t);
                    intent.putExtra("rawUrl", com.tencent.mm.bd.a.b(i, cA));
                    if (i == 20 || i == 22 || i == 24 || i == 33) {
                        str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bp.d.b(ah.getContext(), "webview", str2, intent);
                } else if (obj2 != null) {
                    cA = r.a(i, false, d, str);
                    try {
                        cA.put(SearchIntents.EXTRA_QUERY, q.encode(str2, "UTF-8"));
                    } catch (Exception e3) {
                        cA.put(SearchIntents.EXTRA_QUERY, str2);
                    }
                    cA.put("searchId", str3);
                    cA.put("subType", String.valueOf(com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "subType", 0)));
                    cA.put("isWeAppMore", String.valueOf(com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "isWeAppMore", 0)));
                    cA.put("sessionId", t);
                    str3 = com.tencent.mm.modelappbrand.b.abv();
                    cA.put("sessionId", str3);
                    str2 = com.tencent.mm.plugin.websearch.api.aa.HP(bo.ank((String) cA.get("scene")));
                    cA.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("key_session_id", str3);
                    intent.putExtra("rawUrl", r.E(cA));
                    intent.putExtra("ftsbizscene", i);
                    intent.putExtra("key_search_place_holder", t2);
                    com.tencent.mm.bp.d.b(ah.getContext(), "appbrand", ".ui.AppBrandSearchUI", intent);
                } else {
                    cA = com.tencent.mm.plugin.websearch.api.aa.a(i, false, d, str);
                    try {
                        cA.put(SearchIntents.EXTRA_QUERY, q.encode(str2, "UTF-8"));
                    } catch (Exception e4) {
                        cA.put(SearchIntents.EXTRA_QUERY, str2);
                    }
                    cA.put("searchId", str3);
                    cA.put("sessionId", t);
                    str2 = com.tencent.mm.plugin.websearch.api.aa.HP(bo.ank((String) cA.get("scene")));
                    cA.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("rawUrl", com.tencent.mm.bd.a.b(i, cA));
                    intent.putExtra("key_session_id", t);
                    intent.putExtra("searchId", str3);
                    if (i == 20 || i == 22 || i == 24 || i == 33) {
                        str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bp.d.b(ah.getContext(), "webview", str2, intent);
                }
            } else {
                switch (d2) {
                    case 2:
                        a(az(map), u);
                        break;
                    case 3:
                        c az = az(map);
                        if (!t.mY(az.username)) {
                            a(az, u);
                            break;
                        }
                        ai.adO(az.username);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Chat_User", az.username);
                        intent2.putExtra("finish_direct", true);
                        intent2.putExtra("key_temp_session_show_type", 0);
                        intent2.putExtra("preChatTYPE", 9);
                        com.tencent.mm.bp.d.f(ah.getContext(), ".ui.chatting.ChattingUI", intent2);
                        break;
                    case 4:
                        t3 = com.tencent.mm.plugin.websearch.api.aa.t(map, "jumpUrl");
                        bundle = null;
                        if (gVar != null) {
                            bundle = gVar.dcJ();
                        }
                        com.tencent.mm.plugin.webview.modeltools.g.cYC();
                        o(t3, bundle);
                        break;
                }
            }
        }
        t3 = com.tencent.mm.plugin.websearch.api.aa.t(map, "jumpUrl");
        bundle = null;
        if (gVar != null) {
            bundle = gVar.dcJ();
        }
        com.tencent.mm.plugin.webview.modeltools.g.cYC();
        o(t3, bundle);
        AppMethodBeat.o(5696);
        return false;
    }

    public final boolean ay(Map<String, Object> map) {
        AppMethodBeat.i(5697);
        ab.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchRealTimeReport: %s", map.toString());
        bsj bsj = new bsj();
        bsj.wUu = com.tencent.mm.plugin.websearch.api.aa.t(map, "logString");
        com.tencent.mm.kernel.g.Rg().a(1134, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().a(new w(bsj), 0);
        AppMethodBeat.o(5697);
        return false;
    }

    private static void o(String str, Bundle bundle) {
        AppMethodBeat.i(5698);
        a(str, bundle, 0, "", "", 0);
        AppMethodBeat.o(5698);
    }

    private static void a(String str, Bundle bundle, int i, String str2, String str3, int i2) {
        AppMethodBeat.i(5699);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("convertActivityFromTranslucent", false);
        intent.putExtra("customize_status_bar_color", i);
        intent.putExtra("status_bar_style", str2);
        if (!bo.isNullOrNil(str3)) {
            intent.putExtra("prePublishId", str3);
            intent.putExtra("KPublisherId", str3);
        } else if (!(bundle == null || bo.isNullOrNil(str))) {
            String str4 = bundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.a.g.x(str.getBytes());
            intent.putExtra("prePublishId", str4);
            intent.putExtra("KPublisherId", str4);
        }
        if (i2 > 0) {
            intent.putExtra("pay_channel", i2);
        }
        intent.putExtra("preChatTYPE", 10);
        com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(5699);
    }

    private static void z(String str, String str2, boolean z) {
        AppMethodBeat.i(5700);
        TimeLineObject tC = ((m) com.tencent.mm.kernel.g.K(m.class)).tC(str);
        Intent intent = new Intent();
        intent.putExtra("INTENT_TALKER", str2);
        intent.putExtra("INTENT_SNSID", new BigInteger(tC.Id).longValue());
        intent.putExtra("SNS_FROM_MUSIC_ITEM", z);
        try {
            intent.putExtra("INTENT_SNS_TIMELINEOBJECT", tC.toByteArray());
        } catch (IOException e) {
        }
        com.tencent.mm.bp.d.b(ah.getContext(), "sns", ".ui.SnsCommentDetailUI", intent);
        AppMethodBeat.o(5700);
    }

    private static void a(d dVar) {
        AppMethodBeat.i(5701);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", dVar.username);
        intent.putExtra("Contact_Nick", dVar.nickname);
        intent.putExtra("Contact_Alias", dVar.dFl);
        intent.putExtra("Contact_Sex", dVar.dtS);
        intent.putExtra("Contact_Scene", dVar.scene);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(dVar.country, dVar.duc, dVar.dud));
        intent.putExtra("Contact_Signature", dVar.signature);
        intent.putExtra("Contact_KSnsIFlag", dVar.ufF);
        intent.putExtra("Contact_full_Mobile_MD5", dVar.query);
        com.tencent.mm.bp.d.b(ah.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(5701);
    }

    private static void a(c cVar, boolean z) {
        int i;
        AppMethodBeat.i(5702);
        if (cVar.ufE != 0) {
            i = cVar.ufE;
        } else if (cVar.cIC == 2) {
            i = 89;
        } else if (z) {
            i = 85;
        } else if (cVar.scene != 3 && cVar.scene != 16) {
            i = 39;
        } else if (cVar.ufC) {
            i = 88;
        } else {
            i = 87;
        }
        ai.adO(cVar.username);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", cVar.username);
        intent.putExtra("Contact_Nick", cVar.nickname);
        intent.putExtra("Contact_BrandIconURL", cVar.pln);
        intent.putExtra("Contact_Signature", cVar.signature);
        intent.putExtra("Contact_VUser_Info_Flag", cVar.ufB);
        intent.putExtra("Contact_Scene", i);
        if (cVar.pmz != null) {
            try {
                intent.putExtra("Contact_customInfo", cVar.pmz.toByteArray());
            } catch (IOException e) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("Contact_Ext_Args_Search_Id", cVar.hlm);
        bundle.putString("Contact_Ext_Args_Query_String", cVar.query);
        bundle.putInt("Contact_Scene", i);
        bundle.putInt("Contact_Ext_Args_Index", cVar.position);
        bundle.putString("Contact_Ext_Extra_Params", cVar.ufD);
        intent.putExtra("preChatTYPE", 10);
        intent.putExtra("Contact_Ext_Args", bundle);
        com.tencent.mm.bp.d.b(ah.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(5702);
    }

    public static int c(Map<String, Object> map, Map<String, Object> map2) {
        AppMethodBeat.i(5703);
        try {
            JSONArray jSONArray = new JSONArray(com.tencent.mm.plugin.websearch.api.aa.t(map, "data"));
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object string;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("id")) {
                    string = jSONObject.getString("id");
                } else {
                    String string2 = "";
                }
                String string3 = jSONObject.has("userName") ? jSONObject.getString("userName") : "";
                String mJ = s.mJ(string3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", string2);
                jSONObject2.put("userName", string3);
                jSONObject2.put("displayName", mJ);
                jSONArray2.put(jSONObject2);
            }
            map2.put("ret", Integer.valueOf(0));
            map2.put("data", jSONArray2.toString());
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
        AppMethodBeat.o(5703);
        return 0;
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(5704);
        String s;
        int i3;
        String XZ;
        if (mVar instanceof v) {
            com.tencent.mm.kernel.g.Rg().b(1048, (com.tencent.mm.ai.f) this);
            if (i == 0 && i2 == 0) {
                v vVar = (v) mVar;
                b bVar = new b(this, (byte) 0);
                bVar.scene = vVar.scene;
                bVar.ufz = (long) vVar.tZT.wDL;
                bVar.cBF = vVar.tZT.vOy;
                bVar.ufA = System.currentTimeMillis() / 1000;
                bVar.lcA = vVar.tZT.wDM;
                bVar.type = vVar.businessType;
                s = s(bVar.scene, bVar.type, true);
                ab.i("MicroMsg.FTS.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", bVar.cBF);
                if (!bo.isNullOrNil(bVar.cBF)) {
                    h.JR(vVar.cIv).d(0, bVar.cBF, 0, vVar.nQB);
                    ab.i("MicroMsg.FTS.FTSWebViewLogic", "onTeachSearchDataReady, %s", bVar.cBF);
                }
                this.ufi.put(s, bVar);
                File file;
                if (bVar.ufz == 0) {
                    i3 = bVar.scene;
                    int i4 = bVar.type;
                    ab.i("MicroMsg.FTS.FTSWebViewLogic", "delete biz cache %d %d", Integer.valueOf(i3), Integer.valueOf(i4));
                    XZ = com.tencent.mm.plugin.record.b.XZ();
                    file = new File(XZ, s(i3, i4, true));
                    if (file.exists()) {
                        file.delete();
                    }
                    file = new File(XZ, s(i3, i4, false));
                    if (file.exists()) {
                        file.delete();
                    }
                } else {
                    azv azv = new azv();
                    azv.scene = bVar.scene;
                    azv.vOy = bVar.cBF;
                    azv.wDD = bVar.ufz;
                    azv.wDE = bVar.ufA;
                    azv.vQg = bVar.lcA;
                    azv.jCt = bVar.type;
                    byte[] bArr = null;
                    try {
                        bArr = azv.toByteArray();
                    } catch (IOException e) {
                    }
                    if (bArr != null) {
                        file = new File(com.tencent.mm.plugin.record.b.XZ(), s(bVar.scene, bVar.type, true));
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        com.tencent.mm.a.e.b(file.getAbsolutePath(), bArr, bArr.length);
                        ab.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile %s %d", file.getAbsolutePath(), Integer.valueOf(bArr.length));
                    } else {
                        ab.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile fail");
                    }
                }
                if (bVar.scene == 20 && bVar.type == 0) {
                    an.a(bVar.scene, 1, bVar.lcA, bVar.type, 2, bVar.cWm(), 1);
                    AppMethodBeat.o(5704);
                    return;
                }
                an.a(bVar.scene, 1, bVar.lcA, bVar.type, 1, "", 0);
                AppMethodBeat.o(5704);
                return;
            }
            ab.e("MicroMsg.FTS.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(5704);
        } else if (mVar instanceof w) {
            com.tencent.mm.kernel.g.Rg().b(1134, (com.tencent.mm.ai.f) this);
            AppMethodBeat.o(5704);
        } else if (mVar instanceof e) {
            com.tencent.mm.kernel.g.Rg().b(1161, (com.tencent.mm.ai.f) this);
            if (i == 0 && i2 == 0) {
                s = this.ufj.abH();
                final ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(s);
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    XZ = jSONObject.optString("suggestionID", "");
                    jSONObject = null;
                    int i5 = 0;
                    while (i5 < optJSONArray.length()) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                        if (optJSONObject.optInt("type") != 1) {
                            optJSONObject = jSONObject;
                        }
                        i5++;
                        jSONObject = optJSONObject;
                    }
                    if (jSONObject != null) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("items");
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            String optString = optJSONArray2.optJSONObject(i3).optString("word");
                            if (!bo.isNullOrNil(optString)) {
                                arrayList.add(optString);
                            }
                        }
                    }
                    s = XZ;
                } catch (Exception e2) {
                    s = "";
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(5674);
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(b.this.ufj.fpL.cIv);
                        String str = b.this.ufj.fpL.ctj;
                        String str2 = s;
                        ab.i("MicroMsg.MsgHandler", "onSearchSuggestCallback: %s", arrayList.toString());
                        Bundle bundle = new Bundle();
                        bundle.putString(SearchIntents.EXTRA_QUERY, str);
                        bundle.putString("suggestionId", str2);
                        bundle.putStringArrayList("result", r3);
                        try {
                            if (JR.umI != null) {
                                JR.umI.c(com.tencent.view.d.MIC_SketchMark, bundle);
                            }
                            AppMethodBeat.o(5674);
                        } catch (RemoteException e) {
                            ab.w("MicroMsg.MsgHandler", "onSearchSuggestCallback exception" + e.getMessage());
                            AppMethodBeat.o(5674);
                        }
                    }
                });
                AppMethodBeat.o(5704);
                return;
            }
            AppMethodBeat.o(5704);
        } else {
            if (mVar instanceof c) {
                com.tencent.mm.kernel.g.Rg().b(1866, (com.tencent.mm.ai.f) this);
                if (i == 0 && i2 == 0) {
                    c cVar = (c) mVar;
                    if (cVar.cIv != -1) {
                        h.JR(cVar.cIv).m(((cst) cVar.ehh.fsH.fsP).cBF, 0, 0, 0);
                    }
                    if (cVar.ufI != null) {
                        this.ufl.put(Integer.valueOf(cVar.ufI.scene), cVar.ufI);
                    }
                } else {
                    AppMethodBeat.o(5704);
                    return;
                }
            }
            AppMethodBeat.o(5704);
        }
    }

    private c az(Map<String, Object> map) {
        AppMethodBeat.i(5705);
        c cVar = new c(this, (byte) 0);
        cVar.username = com.tencent.mm.plugin.websearch.api.aa.t(map, "userName");
        cVar.nickname = com.tencent.mm.plugin.websearch.api.aa.t(map, "nickName");
        cVar.pln = com.tencent.mm.plugin.websearch.api.aa.t(map, "headHDImgUrl");
        cVar.ufB = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "verifyFlag", 0);
        cVar.signature = com.tencent.mm.plugin.websearch.api.aa.t(map, "signature");
        cVar.scene = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "scene", 0);
        cVar.cIC = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "sceneActionType", 1);
        cVar.pmz = new uy();
        cVar.pmz.gvb = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "brandFlag", 0);
        cVar.pmz.gve = com.tencent.mm.plugin.websearch.api.aa.t(map, "iconUrl");
        cVar.pmz.gvd = com.tencent.mm.plugin.websearch.api.aa.t(map, "brandInfo");
        cVar.pmz.gvc = com.tencent.mm.plugin.websearch.api.aa.t(map, "externalInfo");
        cVar.hlm = com.tencent.mm.plugin.websearch.api.aa.t(map, "searchId");
        cVar.query = com.tencent.mm.plugin.websearch.api.aa.t(map, SearchIntents.EXTRA_QUERY);
        cVar.position = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "position", 0);
        cVar.ufC = com.tencent.mm.plugin.websearch.api.aa.u(map, "isCurrentDetailPage");
        cVar.ufD = com.tencent.mm.plugin.websearch.api.aa.t(map, "extraParams");
        cVar.ufE = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "friendScene", 0);
        AppMethodBeat.o(5705);
        return cVar;
    }

    private d aA(Map<String, Object> map) {
        int i = 3;
        AppMethodBeat.i(5706);
        d dVar = new d(this, (byte) 0);
        dVar.username = com.tencent.mm.plugin.websearch.api.aa.t(map, "userName");
        dVar.nickname = com.tencent.mm.plugin.websearch.api.aa.t(map, "nickName");
        dVar.dFl = com.tencent.mm.plugin.websearch.api.aa.t(map, "alias");
        dVar.signature = com.tencent.mm.plugin.websearch.api.aa.t(map, "signature");
        dVar.dtS = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "sex", 0);
        dVar.country = com.tencent.mm.plugin.websearch.api.aa.t(map, UserDataStore.COUNTRY);
        dVar.dud = com.tencent.mm.plugin.websearch.api.aa.t(map, "city");
        dVar.duc = com.tencent.mm.plugin.websearch.api.aa.t(map, "province");
        dVar.ufF = com.tencent.mm.plugin.websearch.api.aa.d((Map) map, "snsFlag", 0);
        String t = com.tencent.mm.plugin.websearch.api.aa.t(map, SearchIntents.EXTRA_QUERY);
        if (bo.isNullOrNil(t)) {
            dVar.scene = 3;
        } else {
            if (Character.isDigit(t.charAt(0))) {
                i = 15;
            }
            dVar.scene = i;
            if (dVar.scene == 15) {
                if ("mobile".equals(com.tencent.mm.plugin.websearch.api.aa.t(map, "matchType"))) {
                    dVar.query = t;
                } else {
                    dVar.scene = 1;
                }
            }
        }
        AppMethodBeat.o(5706);
        return dVar;
    }

    static String s(int i, int i2, boolean z) {
        AppMethodBeat.i(5707);
        String str = "FTS_BizCacheObj" + i + "-" + i2;
        String str2 = str + "-" + aa.gw(ah.getContext());
        if (z) {
            AppMethodBeat.o(5707);
            return str2;
        } else if (new File(com.tencent.mm.plugin.record.b.XZ(), str2).exists()) {
            AppMethodBeat.o(5707);
            return str2;
        } else {
            AppMethodBeat.o(5707);
            return str;
        }
    }

    public static boolean aB(Map<String, Object> map) {
        AppMethodBeat.i(5708);
        ab.i("MicroMsg.FTS.FTSWebViewLogic", "setSearchInputWord %s", map);
        String t = com.tencent.mm.plugin.websearch.api.aa.t(map, "word");
        boolean u = com.tencent.mm.plugin.websearch.api.aa.u(map, "isInputChange");
        String t2 = com.tencent.mm.plugin.websearch.api.aa.t(map, "custom");
        String t3 = com.tencent.mm.plugin.websearch.api.aa.t(map, "tagList");
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(bo.g(map.get("webview_instance_id"), -1));
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_new_query", t);
        bundle.putString("fts_key_custom_query", t2);
        bundle.putBoolean("fts_key_need_keyboard", u);
        bundle.putString("fts_key_tag_list", t3);
        try {
            if (JR.umI != null) {
                JR.umI.c(122, bundle);
            }
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + e.getMessage());
        }
        AppMethodBeat.o(5708);
        return false;
    }

    public final boolean aC(Map<String, Object> map) {
        AppMethodBeat.i(5709);
        String str = (String) map.get(SearchIntents.EXTRA_QUERY);
        String str2 = (String) map.get("sortedContacts");
        final int ank = bo.ank((String) map.get("offset"));
        final int ank2 = bo.ank((String) map.get("count"));
        final int g = bo.g(map.get("webview_instance_id"), -1);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
        if (this.ufo == null) {
            this.ufo = new com.tencent.mm.plugin.websearch.c.a.b();
        }
        com.tencent.mm.plugin.websearch.c.a.d dVar = new com.tencent.mm.plugin.websearch.c.a.d(str, arrayList);
        if (this.ufp == null || !this.ufp.equals(dVar)) {
            this.ufp = dVar;
            this.ufo.a(dVar, new com.tencent.mm.plugin.websearch.c.a.c.a() {
                public final void cVJ() {
                    AppMethodBeat.i(5680);
                    b.a(b.this.ufp, ank, ank2, g);
                    AppMethodBeat.o(5680);
                }
            });
        } else if (this.ufp.ctn) {
            a(this.ufp, ank, ank2, g);
        }
        AppMethodBeat.o(5709);
        return false;
    }

    static void a(com.tencent.mm.plugin.websearch.c.a.d dVar, int i, int i2, int i3) {
        AppMethodBeat.i(5710);
        h.JR(i3).aP(dVar.gq(i, i2));
        AppMethodBeat.o(5710);
    }
}
