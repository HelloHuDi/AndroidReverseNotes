package com.tencent.p177mm.plugin.webview.fts;

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
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p198aw.C25848g;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p835bd.C17977a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.record.C34797b;
import com.tencent.p177mm.plugin.sns.p1024b.C29034m;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C35570af;
import com.tencent.p177mm.plugin.websearch.api.C35573ai;
import com.tencent.p177mm.plugin.websearch.api.C40195v;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C46405w;
import com.tencent.p177mm.plugin.websearch.p1064c.p1065a.C35577c;
import com.tencent.p177mm.plugin.websearch.p1064c.p1065a.C35577c.C35578a;
import com.tencent.p177mm.plugin.websearch.p1064c.p1065a.C40197b;
import com.tencent.p177mm.plugin.websearch.p1064c.p1065a.C40198d;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C23018g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29944h;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.azv;
import com.tencent.p177mm.protocal.protobuf.azw;
import com.tencent.p177mm.protocal.protobuf.bdi;
import com.tencent.p177mm.protocal.protobuf.bdj;
import com.tencent.p177mm.protocal.protobuf.bsj;
import com.tencent.p177mm.protocal.protobuf.chn;
import com.tencent.p177mm.protocal.protobuf.cst;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.view.C31128d;
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

/* renamed from: com.tencent.mm.plugin.webview.fts.b */
public final class C43869b implements C1202f {
    public C4884c hAA = new C355853();
    private long ijU;
    public C28106a mEx;
    public C28114l plf = new C402154();
    public Set<Integer> ufg;
    public C28114l ufh = new C45361();
    private HashMap<String, C29766b> ufi;
    public C43877e ufj;
    public C40195v ufk;
    private Map<Integer, C43870g> ufl = new HashMap();
    public C29767e ufm = new C29767e();
    public List<C9058e> ufn;
    private C35577c ufo;
    C40198d ufp;

    /* renamed from: com.tencent.mm.plugin.webview.fts.b$1 */
    class C45361 implements C28114l {
        C45361() {
        }

        /* renamed from: b */
        public final void mo8215b(final C28109j c28109j) {
            AppMethodBeat.m2504i(5673);
            final C14454f c14454f = (C14454f) c28109j.mAJ;
            C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", Integer.valueOf(c28109j.bFZ), Integer.valueOf(c14454f.ufG));
            if (c28109j.bFZ == 0) {
                final ArrayList arrayList = new ArrayList();
                for (C45966l c45966l : c28109j.mEy) {
                    arrayList.add(c45966l.content);
                }
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(5672);
                        if (c14454f.ufG != 0) {
                            C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener callback， id %d", Integer.valueOf(c14454f.ufG));
                            C23018g JR = C29944h.m47401JR(c14454f.ufG);
                            try {
                                C4990ab.m7417i("MicroMsg.MsgHandler", "onGetSearchHistory %s", arrayList.toString());
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
                                        JR.umI.mo26784c(ErrorCode.NEEDDOWNLOAD_4, bundle);
                                        AppMethodBeat.m2505o(5672);
                                        return;
                                    }
                                    C4990ab.m7416i("MicroMsg.MsgHandler", "callbacker is null");
                                    AppMethodBeat.m2505o(5672);
                                    return;
                                } catch (RemoteException e) {
                                    C4990ab.m7420w("MicroMsg.MsgHandler", "onGetSearchHistory exception" + e.getMessage());
                                    AppMethodBeat.m2505o(5672);
                                    return;
                                }
                            } catch (JSONException e2) {
                                C4990ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.m2505o(5672);
                    }
                });
            }
            AppMethodBeat.m2505o(5673);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.b$c */
    class C14452c {
        public int cIC;
        public String hlm;
        public String nickname;
        public String pln;
        public C7285uy pmz;
        public int position;
        public String query;
        public int scene;
        public String signature;
        public int ufB;
        public boolean ufC;
        public String ufD;
        public int ufE;
        public String username;

        private C14452c() {
        }

        /* synthetic */ C14452c(C43869b c43869b, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.b$d */
    class C14453d {
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

        private C14453d() {
        }

        /* synthetic */ C14453d(C43869b c43869b, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.b$f */
    public class C14454f extends C20846i {
        public int ufG;

        private C14454f() {
        }

        public /* synthetic */ C14454f(C43869b c43869b, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.b$b */
    class C29766b {
        String cBF;
        boolean fOb;
        private String hPI;
        String lcA;
        int scene;
        int type;
        long ufA;
        long ufz;

        private C29766b() {
            this.fOb = false;
            this.hPI = null;
        }

        /* synthetic */ C29766b(C43869b c43869b, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final boolean isAvailable() {
            AppMethodBeat.m2504i(5682);
            if (this.fOb) {
                AppMethodBeat.m2505o(5682);
                return false;
            } else if (C5046bo.isNullOrNil(this.cBF) || (System.currentTimeMillis() / 1000) - this.ufA > this.ufz) {
                AppMethodBeat.m2505o(5682);
                return false;
            } else {
                AppMethodBeat.m2505o(5682);
                return true;
            }
        }

        /* Access modifiers changed, original: final */
        public final String cWm() {
            AppMethodBeat.m2504i(5683);
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
            AppMethodBeat.m2505o(5683);
            return str;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: gr */
        public final void mo48021gr(int i, int i2) {
            AppMethodBeat.m2504i(5684);
            azv azv = new azv();
            String XZ = C34797b.m57159XZ();
            String s = C43869b.m78674s(i, i2, false);
            if (!s.equals(C43869b.m78674s(i, i2, true))) {
                this.fOb = true;
            }
            File file = new File(XZ, s);
            byte[] e = C1173e.m2569e(file.getAbsolutePath(), 0, (int) file.length());
            if (e != null) {
                try {
                    azv.parseFrom(e);
                    this.scene = azv.scene;
                    this.cBF = azv.vOy;
                    this.ufz = azv.wDD;
                    this.ufA = azv.wDE;
                    this.lcA = azv.vQg;
                    this.type = azv.jCt;
                    C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "load bizCacheFile %s %d", file.getAbsolutePath(), Integer.valueOf(e.length));
                    AppMethodBeat.m2505o(5684);
                    return;
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.m2505o(5684);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.b$e */
    public class C29767e {
        public boolean ctn;
        public boolean egk = true;
        public int mFl;
        public String query;
        public boolean sAY;
        public int scene;

        /* renamed from: m */
        public final void mo48023m(int i, String str, int i2) {
            this.query = str;
            this.scene = i;
            this.ctn = false;
            this.mFl = i2;
            this.sAY = false;
            this.egk = false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.b$3 */
    class C355853 extends C4884c<C37752ke> {
        C355853() {
            AppMethodBeat.m2504i(5675);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(5675);
        }

        /* renamed from: a */
        private boolean m58415a(C37752ke c37752ke) {
            AppMethodBeat.m2504i(5676);
            C9058e c9058e = c37752ke.cFH.cFB;
            if (c9058e != null && C37494a.m63282d(c9058e)) {
                switch (c37752ke.cFH.action) {
                    case 0:
                    case 1:
                        for (Integer intValue : C43869b.this.ufg) {
                            C29944h.m47401JR(intValue.intValue()).mo38649dN(c9058e.fJU, 1);
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        for (Integer intValue2 : C43869b.this.ufg) {
                            C29944h.m47401JR(intValue2.intValue()).mo38649dN(c9058e.fJU, 0);
                        }
                        break;
                }
            }
            AppMethodBeat.m2505o(5676);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.b$4 */
    class C402154 implements C28114l {
        C402154() {
        }

        /* renamed from: b */
        public final void mo8215b(final C28109j c28109j) {
            AppMethodBeat.m2504i(5679);
            if (c28109j.bFZ == 0) {
                final ArrayList arrayList = new ArrayList();
                for (C45966l c45966l : c28109j.mEy) {
                    arrayList.add(c45966l.content);
                }
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(5678);
                        if (!(C43869b.this.mEx == null || C43869b.this.mEx.mDs == null)) {
                            C23018g JR = C29944h.m47401JR(((Integer) C43869b.this.mEx.mDs).intValue());
                            String str = c28109j.mAJ.query;
                            C4990ab.m7417i("MicroMsg.MsgHandler", "onSearchHistoryCallback: %s", arrayList.toString());
                            Bundle bundle = new Bundle();
                            bundle.putString(SearchIntents.EXTRA_QUERY, str);
                            bundle.putStringArrayList("result", r2);
                            try {
                                if (JR.umI != null) {
                                    JR.umI.mo26784c(126, bundle);
                                }
                                AppMethodBeat.m2505o(5678);
                                return;
                            } catch (RemoteException e) {
                                C4990ab.m7420w("MicroMsg.MsgHandler", "onSearchHistoryCallback exception" + e.getMessage());
                            }
                        }
                        AppMethodBeat.m2505o(5678);
                    }
                });
            }
            AppMethodBeat.m2505o(5679);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.b$a */
    public class C40216a implements Runnable {
        public String data;
        public boolean ufy;

        private C40216a() {
        }

        public /* synthetic */ C40216a(C43869b c43869b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(5681);
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.data);
                for (int i = 0; i < jSONArray.length(); i++) {
                    TimeLineObject tC = ((C29034m) C1720g.m3528K(C29034m.class)).mo47122tC(jSONArray.getString(i));
                    C1720g.m3537RQ();
                    C9058e a = C25848g.m41159a(C1720g.m3536RP().eJM, tC, 9);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                if (!this.ufy || C43869b.this.ufn == null) {
                    C43869b.this.ufn = arrayList;
                    AppMethodBeat.m2505o(5681);
                    return;
                }
                C43869b.this.ufn.addAll(arrayList);
                AppMethodBeat.m2505o(5681);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
                AppMethodBeat.m2505o(5681);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.b$g */
    static class C43870g {
        public String cBF;
        public long interval;
        public int scene;
        public long ufA;
        public int ufH;

        public C43870g() {
            this.scene = 0;
            this.cBF = "";
            this.interval = 0;
            this.ufA = 0;
            this.ufH = 0;
        }

        public C43870g(cst cst, int i) {
            AppMethodBeat.m2504i(5685);
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
            AppMethodBeat.m2505o(5685);
        }

        public static C43870g cWn() {
            C43870g c43870g;
            AppMethodBeat.m2504i(5686);
            File file = new File(C34797b.m57159XZ(), C43870g.m78683Iv(201));
            byte[] e = C1173e.m2569e(file.getAbsolutePath(), 0, (int) file.length());
            try {
                azw azw = new azw();
                azw.parseFrom(e);
                c43870g = new C43870g();
                try {
                    c43870g.scene = azw.Scene;
                    c43870g.cBF = azw.vOy;
                    c43870g.interval = azw.wDF;
                    c43870g.ufA = azw.wDE;
                    c43870g.ufH = azw.wDG;
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                c43870g = null;
            }
            AppMethodBeat.m2505o(5686);
            return c43870g;
        }

        /* renamed from: Iv */
        static String m78683Iv(int i) {
            AppMethodBeat.m2504i(5687);
            String str = "SearchGuide_" + i + "-" + C4988aa.m7403gw(C4996ah.getContext());
            AppMethodBeat.m2505o(5687);
            return str;
        }

        public final boolean isExpired() {
            AppMethodBeat.m2504i(5688);
            if (this.ufA + this.interval <= System.currentTimeMillis() / 1000) {
                AppMethodBeat.m2505o(5688);
                return true;
            }
            AppMethodBeat.m2505o(5688);
            return false;
        }
    }

    public C43869b() {
        AppMethodBeat.m2504i(5689);
        C4990ab.m7416i("MicroMsg.FTS.FTSWebViewLogic", "create FTSWebViewLogic");
        this.ufi = new HashMap();
        this.ufg = Collections.synchronizedSet(new HashSet());
        C4879a.xxA.mo10052c(this.hAA);
        AppMethodBeat.m2505o(5689);
    }

    /* renamed from: p */
    public static Bundle m78673p(int i, Bundle bundle) {
        AppMethodBeat.m2504i(5690);
        Bundle bundle2 = new Bundle();
        switch (i) {
            case 2:
                try {
                    String string = bundle.getString("key");
                    bundle2.putString("result", C29736ac.adL(string).toString());
                    if ("educationTab".equals(string)) {
                        JSONObject adL = C29736ac.adL("discoverSearchGuide");
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
                Map d = C46400aa.m87334d(bundle.getInt("scene"), bundle.getBoolean("isHomePage"), bundle.getInt("type"));
                bundle2.putString("type", (String) d.get("type"));
                bundle2.putString("isMostSearchBiz", (String) d.get("isMostSearchBiz"));
                bundle2.putString("isLocalSug", (String) d.get("isLocalSug"));
                bundle2.putString("isSug", (String) d.get("isSug"));
                bundle2.putString("scene", (String) d.get("scene"));
                break;
            case 6:
                try {
                    bundle2.putString("result", C29736ac.adM(bundle.getString("key")));
                    break;
                } catch (Exception e2) {
                    break;
                }
            case 7:
                bundle2.putString("data", C29833g.cYC().cWl());
                break;
        }
        AppMethodBeat.m2505o(5690);
        return bundle2;
    }

    /* renamed from: av */
    public final boolean mo69559av(Map<String, Object> map) {
        AppMethodBeat.m2504i(5691);
        String t;
        int d;
        switch (C46400aa.m87332d((Map) map, NativeProtocol.WEB_DIALOG_ACTION, 0)) {
            case 1:
                if (C35570af.uax == null) {
                    C35570af.cVk();
                }
                C35570af.uax.jBw.clear();
                SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("fts_history_search_sp", 0);
                try {
                    sharedPreferences.edit().putString(C35570af.cVl(), Base64.encodeToString(C35570af.uax.toByteArray(), 0)).apply();
                    C4990ab.m7417i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", t);
                    break;
                } catch (IOException e) {
                    break;
                }
            case 2:
                int d2 = C46400aa.m87332d((Map) map, "type", 0);
                d = C46400aa.m87332d((Map) map, "scene", 0);
                if (System.currentTimeMillis() - this.ijU > 1000) {
                    this.ijU = System.currentTimeMillis();
                    if (!C46400aa.m87304HU(0)) {
                        C4990ab.m7412e("MicroMsg.FTS.FTSWebViewLogic", "fts h5 template not avail");
                        break;
                    }
                    C14423an.m22657x(d2, d, C29736ac.adM("searchID"));
                    Intent cVd = C46400aa.cVd();
                    cVd.putExtra("ftsneedkeyboard", true);
                    cVd.putExtra("ftsbizscene", d);
                    cVd.putExtra("ftsType", d2);
                    cVd.putExtra("rawUrl", C46400aa.m87298E(C46400aa.m87334d(d, true, d2)));
                    cVd.putExtra("key_load_js_without_delay", true);
                    C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd);
                    break;
                }
                break;
            case 3:
                C23018g JR = C29944h.m47401JR(C46400aa.m87332d((Map) map, "webview_instance_id", -1));
                d = C46400aa.m87332d((Map) map, "scene", 0);
                t = C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY);
                if (d == 20 && !C5046bo.isNullOrNil(t)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fts_key_new_query", t);
                    try {
                        if (JR.umI != null) {
                            JR.umI.mo26784c(C19395n.CTRL_INDEX, bundle);
                            break;
                        }
                    } catch (Exception e2) {
                        C4990ab.m7420w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + e2.getMessage());
                        break;
                    }
                }
                C4990ab.m7421w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", Integer.valueOf(d), t);
                break;
                break;
        }
        AppMethodBeat.m2505o(5691);
        return false;
    }

    public final String cWl() {
        AppMethodBeat.m2504i(5692);
        String s = C43869b.m78674s(20, 0, true);
        if (this.ufi.get(s) == null) {
            C29766b c29766b = new C29766b(this, (byte) 0);
            c29766b.mo48021gr(20, 0);
            this.ufi.put(s, c29766b);
        }
        C29766b c29766b2 = (C29766b) this.ufi.get(s);
        s = c29766b2.isAvailable() ? c29766b2.cBF : "";
        if (C5046bo.isNullOrNil(s)) {
            s = "";
            AppMethodBeat.m2505o(5692);
            return s;
        }
        AppMethodBeat.m2505o(5692);
        return s;
    }

    /* renamed from: aw */
    public final boolean mo69560aw(Map<String, Object> map) {
        AppMethodBeat.m2504i(5693);
        C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData: %s", map);
        int d = C46400aa.m87332d((Map) map, "scene", 0);
        int d2 = C46400aa.m87332d((Map) map, "type", 0);
        int d3 = C46400aa.m87332d((Map) map, "requestType", 0);
        int g = C5046bo.m7550g(map.get("webview_instance_id"), -1);
        String str = (String) map.get("requestId");
        boolean u = C46400aa.m87343u(map, "ignoreCache");
        String s;
        if (d3 == 0) {
            C29766b c29766b;
            s = C43869b.m78674s(d, d2, true);
            if (this.ufi.get(s) == null) {
                c29766b = new C29766b(this, (byte) 0);
                c29766b.mo48021gr(d, d2);
                this.ufi.put(s, c29766b);
            }
            c29766b = (C29766b) this.ufi.get(s);
            if (!(C5046bo.isNullOrNil(c29766b.cBF) || u)) {
                C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d, cache %s", Integer.valueOf(g), c29766b.cBF);
                if (!(c29766b.scene == 20 && c29766b.type == 0 && (c29766b.fOb || !c29766b.isAvailable()))) {
                    C29944h.m47401JR(g).mo38648d(d3, c29766b.cBF, 1, str);
                }
            }
            if (!c29766b.isAvailable() || u) {
                C1720g.m3540Rg().mo14539a(1048, (C1202f) this);
                C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", Integer.valueOf(g));
                this.ufk = new C40195v(d, d2, C46400aa.m87305HV(0), g, C4988aa.m7403gw(C4996ah.getContext()), C29736ac.adL("discoverSearchEntry").optLong("guideParam"), str);
                C1720g.m3540Rg().mo14541a(this.ufk, 0);
            } else {
                C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "hit the cache: %d %d %d %d, data %s", Integer.valueOf(c29766b.scene), Long.valueOf(c29766b.ufz), Long.valueOf(c29766b.ufA), Integer.valueOf(c29766b.type), c29766b.cBF);
                if (c29766b.scene == 20 && c29766b.type == 0) {
                    C14423an.m22642a(c29766b.scene, 0, c29766b.lcA, c29766b.type, 2, c29766b.cWm(), 1);
                } else {
                    C14423an.m22642a(c29766b.scene, 0, c29766b.lcA, c29766b.type, 1, "", 0);
                }
                AppMethodBeat.m2505o(5693);
                return false;
            }
        }
        bdj cVo = C35573ai.cVo();
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (d = cVo.jBw.size() - 1; d >= 0; d--) {
                JSONObject jSONObject3 = new JSONObject();
                bdi bdi = (bdi) cVo.jBw.get(d);
                if (C1855t.m3912mY(bdi.vHl)) {
                    C16527d qX = C17903f.m28104qX(bdi.vHl);
                    if (qX != null) {
                        jSONObject3.put("avatarUrl", qX.field_brandIconURL);
                        jSONObject3.put("userName", qX.field_username);
                        jSONObject3.put("nickName", C1854s.m3866mJ(qX.field_username));
                        jSONArray2.put(jSONObject3);
                    }
                }
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put("type", 5);
            jSONObject2.put("title", "");
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
            C4990ab.m7411d("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData returnString=%s", jSONObject.toString());
            C29944h.m47401JR(g).mo38648d(1, s, 1, str);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "gen mostSearchBizContactList error", new Object[0]);
        }
        AppMethodBeat.m2505o(5693);
        return false;
    }

    /* renamed from: ax */
    public final boolean mo69561ax(Map<String, Object> map) {
        C43870g cWn;
        int i = 1;
        AppMethodBeat.m2504i(5694);
        int g = C5046bo.m7550g(map.get("webview_instance_id"), -1);
        if (this.ufl.get(Integer.valueOf(201)) == null) {
            cWn = C43870g.cWn();
            if (cWn != null) {
                this.ufl.put(Integer.valueOf(201), cWn);
            }
        }
        cWn = (C43870g) this.ufl.get(Integer.valueOf(201));
        if (cWn != null) {
            C29944h.m47401JR(g).mo38660m(cWn.cBF, 1, cWn.isExpired() ? 1 : 0, cWn.ufH);
            i = cWn.isExpired();
        }
        if (i != 0) {
            C1720g.m3540Rg().mo14539a(1866, (C1202f) this);
            C1207m c40218c = new C40218c(map, 0);
            if (map != null) {
                c40218c.cIv = C46400aa.m87332d((Map) map, "webview_instance_id", -1);
            }
            C1720g.m3540Rg().mo14541a(c40218c, 0);
        }
        AppMethodBeat.m2505o(5694);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x00b9 A:{SYNTHETIC, Splitter:B:9:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0446  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo69556a(Map<String, Object> map, C23018g c23018g) {
        String str;
        int i;
        String str2;
        String str3;
        Object obj;
        AppMethodBeat.m2504i(5695);
        C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "openSearchWebView %s", map.toString());
        int ank = C5046bo.ank((String) map.get("actionType"));
        int d = C46400aa.m87332d((Map) map, "type", 0);
        String str4 = (String) map.get("extParams");
        String str5 = (String) map.get("jumpTo");
        String str6 = (String) map.get("navBarColor");
        String t = C46400aa.m87342t(map, "publishId");
        boolean equals = "true".equals((String) map.get("hideSearchBar"));
        int ank2 = C5046bo.ank((String) map.get("isHomePage"));
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
                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
            }
            i = 0;
            if (!C5046bo.isNullOrNil(str6)) {
                try {
                    i = Color.parseColor(str6);
                } catch (IllegalArgumentException e2) {
                    C4990ab.m7412e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e2.getMessage());
                    AppMethodBeat.m2505o(5695);
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
                            C43869b.m78665a(m78670az(map), false);
                            break;
                        case 8:
                            C46400aa.m87342t(map, "snsid");
                            str5 = C46400aa.m87342t(map, "objectXmlDesc");
                            str6 = C46400aa.m87342t(map, "userName");
                            boolean u = C46400aa.m87343u(map, "fromMusicItem");
                            C29833g.cYC();
                            C43869b.m78675z(str5, str6, u);
                            break;
                        case 32:
                            C43869b.m78666a(m78668aA(map));
                            break;
                        default:
                            str5 = C46400aa.m87342t(map, "jumpUrl");
                            C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", str5);
                            dcJ = c23018g.dcJ();
                            if (!C5046bo.isNullOrNil(str5)) {
                                C29833g.cYC();
                                C43869b.m78667a(str5, dcJ, i, str2, t, 0);
                                break;
                            }
                            break;
                    }
                case 2:
                    str5 = C46400aa.m87342t(map, "jumpUrl");
                    C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", str5);
                    dcJ = c23018g.dcJ();
                    if (!C5046bo.isNullOrNil(str5)) {
                        C29833g.cYC();
                        C43869b.m78667a(str5, dcJ, i, str2, t, 0);
                        break;
                    }
                    break;
                case 3:
                case 7:
                    str6 = C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY);
                    int d2 = C46400aa.m87332d((Map) map, "scene", 0);
                    String t2 = C46400aa.m87342t(map, "searchId");
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
                    if (!C27278r.aNU()) {
                        cA = C17977a.m28292cA(d2, d);
                        cA.put(SearchIntents.EXTRA_QUERY, str6);
                        cA.put("searchId", t2);
                        intent.putExtra("rawUrl", C17977a.m28291b(d2, cA));
                        if (d2 == 20 || d2 == 22 || d2 == 33) {
                            str5 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                        } else {
                            str5 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                        }
                        C25985d.m41467b(C4996ah.getContext(), "webview", str5, intent);
                        break;
                    }
                    Object obj2 = C46400aa.m87332d((Map) map, "isWeAppMore", 0) == 1 ? 1 : null;
                    int d3 = C46400aa.m87332d((Map) map, "tabPageType", 0);
                    if (obj2 == null) {
                        cA = C46400aa.m87318a(d2, false, d, str4);
                        cA.put(SearchIntents.EXTRA_QUERY, str6);
                        cA.put("searchId", t2);
                        cA.put("isHomePage", String.valueOf(ank2));
                        cA.put("isSug", valueOf);
                        if (!TextUtils.isEmpty(obj)) {
                            cA.put("sessionId", obj);
                            intent.putExtra("sessionId", obj);
                        }
                        String HP = C46400aa.m87299HP(d2);
                        cA.put("subSessionId", HP);
                        intent.putExtra("subSessionId", HP);
                        intent.putExtra("rawUrl", C17977a.m28291b(d2, cA));
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
                                C25985d.m41467b(C4996ah.getContext(), "webview", str5, intent);
                                break;
                            }
                        }
                        intent.putExtra("ftscaneditable", false);
                        C46400aa.m87324a(C4996ah.getContext(), str6, intent, str, str4, t2, (String) obj, HP);
                        AppMethodBeat.m2505o(5695);
                        return false;
                    }
                    cA = C27278r.m43308a(d2, false, d, str4);
                    cA.put(SearchIntents.EXTRA_QUERY, str6);
                    cA.put("searchId", t2);
                    cA.put("subType", String.valueOf(C46400aa.m87332d((Map) map, "subType", 0)));
                    cA.put("isWeAppMore", String.valueOf(C46400aa.m87332d((Map) map, "isWeAppMore", 0)));
                    str6 = C45445b.abv();
                    cA.put("sessionId", str6);
                    cA.put("sessionId", str6);
                    cA.put("subSessionId", str6);
                    intent.putExtra("key_session_id", str6);
                    intent.putExtra("rawUrl", C27278r.m43306E(cA));
                    intent.putExtra("ftsbizscene", d2);
                    intent.putExtra("customize_status_bar_color", i);
                    intent.putExtra("status_bar_style", str2);
                    intent.putExtra("sessionId", str6);
                    C25985d.m41467b(C4996ah.getContext(), "appbrand", ".ui.AppBrandSearchUI", intent);
                    break;
                    break;
                case 5:
                    str5 = C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY);
                    int d4 = C46400aa.m87332d((Map) map, "topStoryScene", 0);
                    i = C46400aa.m87332d((Map) map, "tagId", 0);
                    str2 = C46400aa.m87342t(map, "navigationId");
                    if (C5046bo.isNullOrNil(obj)) {
                        obj = C46400aa.m87299HP(d4);
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
                    chn.xgj = C4210c.cFx();
                    chn.scene = d4;
                    chn.hlm = "";
                    chn.ctj = str5;
                    chn.cvF = obj;
                    chn.cIy = obj;
                    chn.xgl = 2;
                    chn.url = C39964g.m68435o(hashMap);
                    chn.xgm = str;
                    chn.cdf = i;
                    chn.nQB = t;
                    chn.tZP = str2;
                    chn.xgn = C46400aa.bVP();
                    C23447tn c23447tn = new C23447tn();
                    c23447tn.key = "rec_category";
                    c23447tn.waD = (long) i;
                    c23447tn.waE = String.valueOf(i);
                    chn.tZG.add(c23447tn);
                    C4210c.m6556a(C4996ah.getContext(), chn, t);
                    break;
            }
            AppMethodBeat.m2505o(5695);
            return false;
        }
        str = null;
        i = 0;
        if (C5046bo.isNullOrNil(str6)) {
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
        AppMethodBeat.m2505o(5695);
        return false;
    }

    /* renamed from: a */
    public final boolean mo69557a(Map<String, Object> map, C23018g c23018g, String str) {
        AppMethodBeat.m2504i(5696);
        this.ufm.sAY = true;
        boolean u = C46400aa.m87343u(map, "isTeachPage");
        boolean u2 = C46400aa.m87343u(map, "isMoreButton");
        Object obj = C46400aa.m87332d((Map) map, "isFeedBack", 0) == 1 ? 1 : null;
        Object obj2 = C46400aa.m87332d((Map) map, "isWeAppMore", 0) == 1 ? 1 : null;
        String t = C46400aa.m87342t(map, "sessionId");
        String str2 = (String) map.get("navBarColor");
        String t2 = C46400aa.m87342t(map, "searchPlaceHolder");
        int i = 0;
        if (!C5046bo.isNullOrNil(str2)) {
            try {
                i = Color.parseColor(str2);
            } catch (IllegalArgumentException e) {
                C4990ab.m7412e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e.getMessage());
                AppMethodBeat.m2505o(5696);
                return true;
            }
        }
        String str3 = (String) map.get("statusBarStyle");
        String t3;
        Bundle bundle;
        if (obj == null) {
            int d = C46400aa.m87332d((Map) map, "type", 0);
            int d2 = C46400aa.m87332d((Map) map, "opType", 0);
            if (d2 <= 0) {
                if (!u2) {
                    str2 = (String) map.get("url");
                    C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", Integer.valueOf(d), str2);
                    switch (d) {
                        case 1:
                            C43869b.m78665a(m78670az(map), false);
                            break;
                        case 8:
                            C46400aa.m87342t(map, "snsid");
                            str2 = C46400aa.m87342t(map, "objectXmlDesc");
                            t3 = C46400aa.m87342t(map, "userName");
                            boolean u3 = C46400aa.m87343u(map, "fromMusicItem");
                            C29833g.cYC();
                            C43869b.m78675z(str2, t3, u3);
                            break;
                        case 32:
                            C43869b.m78666a(m78668aA(map));
                            break;
                        default:
                            str2 = C46400aa.m87342t(map, "jumpUrl");
                            C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", str2, C46400aa.m87342t(map, "publishId"), Integer.valueOf(C46400aa.m87332d((Map) map, "payScene", 0)));
                            Bundle bundle2 = null;
                            if (c23018g != null) {
                                bundle2 = c23018g.dcJ();
                            }
                            if (!C5046bo.isNullOrNil(str2)) {
                                C29833g.cYC();
                                C43869b.m78667a(str2, bundle2, i, str3, r4, r5);
                                break;
                            }
                            break;
                    }
                }
                str2 = C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY);
                i = C46400aa.m87332d((Map) map, "scene", 0);
                str3 = C46400aa.m87342t(map, "searchId");
                Intent intent = new Intent();
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("key_load_js_without_delay", true);
                intent.putExtra("ftsQuery", str2);
                intent.putExtra("ftsType", d);
                intent.putExtra("sessionId", t);
                Map cA;
                if (!C27278r.aNU()) {
                    cA = C17977a.m28292cA(i, d);
                    try {
                        cA.put(SearchIntents.EXTRA_QUERY, C18178q.encode(str2, "UTF-8"));
                    } catch (Exception e2) {
                        cA.put(SearchIntents.EXTRA_QUERY, str2);
                    }
                    cA.put("searchId", str3);
                    cA.put("sessionId", t);
                    str2 = C46400aa.m87299HP(C5046bo.ank((String) cA.get("scene")));
                    cA.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("key_session_id", t);
                    intent.putExtra("rawUrl", C17977a.m28291b(i, cA));
                    if (i == 20 || i == 22 || i == 24 || i == 33) {
                        str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    C25985d.m41467b(C4996ah.getContext(), "webview", str2, intent);
                } else if (obj2 != null) {
                    cA = C27278r.m43308a(i, false, d, str);
                    try {
                        cA.put(SearchIntents.EXTRA_QUERY, C18178q.encode(str2, "UTF-8"));
                    } catch (Exception e3) {
                        cA.put(SearchIntents.EXTRA_QUERY, str2);
                    }
                    cA.put("searchId", str3);
                    cA.put("subType", String.valueOf(C46400aa.m87332d((Map) map, "subType", 0)));
                    cA.put("isWeAppMore", String.valueOf(C46400aa.m87332d((Map) map, "isWeAppMore", 0)));
                    cA.put("sessionId", t);
                    str3 = C45445b.abv();
                    cA.put("sessionId", str3);
                    str2 = C46400aa.m87299HP(C5046bo.ank((String) cA.get("scene")));
                    cA.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("key_session_id", str3);
                    intent.putExtra("rawUrl", C27278r.m43306E(cA));
                    intent.putExtra("ftsbizscene", i);
                    intent.putExtra("key_search_place_holder", t2);
                    C25985d.m41467b(C4996ah.getContext(), "appbrand", ".ui.AppBrandSearchUI", intent);
                } else {
                    cA = C46400aa.m87318a(i, false, d, str);
                    try {
                        cA.put(SearchIntents.EXTRA_QUERY, C18178q.encode(str2, "UTF-8"));
                    } catch (Exception e4) {
                        cA.put(SearchIntents.EXTRA_QUERY, str2);
                    }
                    cA.put("searchId", str3);
                    cA.put("sessionId", t);
                    str2 = C46400aa.m87299HP(C5046bo.ank((String) cA.get("scene")));
                    cA.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("rawUrl", C17977a.m28291b(i, cA));
                    intent.putExtra("key_session_id", t);
                    intent.putExtra("searchId", str3);
                    if (i == 20 || i == 22 || i == 24 || i == 33) {
                        str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    C25985d.m41467b(C4996ah.getContext(), "webview", str2, intent);
                }
            } else {
                switch (d2) {
                    case 2:
                        C43869b.m78665a(m78670az(map), u);
                        break;
                    case 3:
                        C14452c az = m78670az(map);
                        if (!C1855t.m3912mY(az.username)) {
                            C43869b.m78665a(az, u);
                            break;
                        }
                        C35573ai.adO(az.username);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Chat_User", az.username);
                        intent2.putExtra("finish_direct", true);
                        intent2.putExtra("key_temp_session_show_type", 0);
                        intent2.putExtra("preChatTYPE", 9);
                        C25985d.m41473f(C4996ah.getContext(), ".ui.chatting.ChattingUI", intent2);
                        break;
                    case 4:
                        t3 = C46400aa.m87342t(map, "jumpUrl");
                        bundle = null;
                        if (c23018g != null) {
                            bundle = c23018g.dcJ();
                        }
                        C29833g.cYC();
                        C43869b.m78672o(t3, bundle);
                        break;
                }
            }
        }
        t3 = C46400aa.m87342t(map, "jumpUrl");
        bundle = null;
        if (c23018g != null) {
            bundle = c23018g.dcJ();
        }
        C29833g.cYC();
        C43869b.m78672o(t3, bundle);
        AppMethodBeat.m2505o(5696);
        return false;
    }

    /* renamed from: ay */
    public final boolean mo69562ay(Map<String, Object> map) {
        AppMethodBeat.m2504i(5697);
        C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchRealTimeReport: %s", map.toString());
        bsj bsj = new bsj();
        bsj.wUu = C46400aa.m87342t(map, "logString");
        C1720g.m3540Rg().mo14539a(1134, (C1202f) this);
        C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
        AppMethodBeat.m2505o(5697);
        return false;
    }

    /* renamed from: o */
    private static void m78672o(String str, Bundle bundle) {
        AppMethodBeat.m2504i(5698);
        C43869b.m78667a(str, bundle, 0, "", "", 0);
        AppMethodBeat.m2505o(5698);
    }

    /* renamed from: a */
    private static void m78667a(String str, Bundle bundle, int i, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(5699);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("convertActivityFromTranslucent", false);
        intent.putExtra("customize_status_bar_color", i);
        intent.putExtra("status_bar_style", str2);
        if (!C5046bo.isNullOrNil(str3)) {
            intent.putExtra("prePublishId", str3);
            intent.putExtra("KPublisherId", str3);
        } else if (!(bundle == null || C5046bo.isNullOrNil(str))) {
            String str4 = bundle.getString("publishIdPrefix", "gs") + "_" + C1178g.m2591x(str.getBytes());
            intent.putExtra("prePublishId", str4);
            intent.putExtra("KPublisherId", str4);
        }
        if (i2 > 0) {
            intent.putExtra("pay_channel", i2);
        }
        intent.putExtra("preChatTYPE", 10);
        C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(5699);
    }

    /* renamed from: z */
    private static void m78675z(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(5700);
        TimeLineObject tC = ((C29034m) C1720g.m3528K(C29034m.class)).mo47122tC(str);
        Intent intent = new Intent();
        intent.putExtra("INTENT_TALKER", str2);
        intent.putExtra("INTENT_SNSID", new BigInteger(tC.f15074Id).longValue());
        intent.putExtra("SNS_FROM_MUSIC_ITEM", z);
        try {
            intent.putExtra("INTENT_SNS_TIMELINEOBJECT", tC.toByteArray());
        } catch (IOException e) {
        }
        C25985d.m41467b(C4996ah.getContext(), "sns", ".ui.SnsCommentDetailUI", intent);
        AppMethodBeat.m2505o(5700);
    }

    /* renamed from: a */
    private static void m78666a(C14453d c14453d) {
        AppMethodBeat.m2504i(5701);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", c14453d.username);
        intent.putExtra("Contact_Nick", c14453d.nickname);
        intent.putExtra("Contact_Alias", c14453d.dFl);
        intent.putExtra("Contact_Sex", c14453d.dtS);
        intent.putExtra("Contact_Scene", c14453d.scene);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(c14453d.country, c14453d.duc, c14453d.dud));
        intent.putExtra("Contact_Signature", c14453d.signature);
        intent.putExtra("Contact_KSnsIFlag", c14453d.ufF);
        intent.putExtra("Contact_full_Mobile_MD5", c14453d.query);
        C25985d.m41467b(C4996ah.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.m2505o(5701);
    }

    /* renamed from: a */
    private static void m78665a(C14452c c14452c, boolean z) {
        int i;
        AppMethodBeat.m2504i(5702);
        if (c14452c.ufE != 0) {
            i = c14452c.ufE;
        } else if (c14452c.cIC == 2) {
            i = 89;
        } else if (z) {
            i = 85;
        } else if (c14452c.scene != 3 && c14452c.scene != 16) {
            i = 39;
        } else if (c14452c.ufC) {
            i = 88;
        } else {
            i = 87;
        }
        C35573ai.adO(c14452c.username);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", c14452c.username);
        intent.putExtra("Contact_Nick", c14452c.nickname);
        intent.putExtra("Contact_BrandIconURL", c14452c.pln);
        intent.putExtra("Contact_Signature", c14452c.signature);
        intent.putExtra("Contact_VUser_Info_Flag", c14452c.ufB);
        intent.putExtra("Contact_Scene", i);
        if (c14452c.pmz != null) {
            try {
                intent.putExtra("Contact_customInfo", c14452c.pmz.toByteArray());
            } catch (IOException e) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("Contact_Ext_Args_Search_Id", c14452c.hlm);
        bundle.putString("Contact_Ext_Args_Query_String", c14452c.query);
        bundle.putInt("Contact_Scene", i);
        bundle.putInt("Contact_Ext_Args_Index", c14452c.position);
        bundle.putString("Contact_Ext_Extra_Params", c14452c.ufD);
        intent.putExtra("preChatTYPE", 10);
        intent.putExtra("Contact_Ext_Args", bundle);
        C25985d.m41467b(C4996ah.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.m2505o(5702);
    }

    /* renamed from: c */
    public static int m78671c(Map<String, Object> map, Map<String, Object> map2) {
        AppMethodBeat.m2504i(5703);
        try {
            JSONArray jSONArray = new JSONArray(C46400aa.m87342t(map, "data"));
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
                String mJ = C1854s.m3866mJ(string3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", string2);
                jSONObject2.put("userName", string3);
                jSONObject2.put("displayName", mJ);
                jSONArray2.put(jSONObject2);
            }
            map2.put("ret", Integer.valueOf(0));
            map2.put("data", jSONArray2.toString());
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(5703);
        return 0;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(5704);
        String s;
        int i3;
        String XZ;
        if (c1207m instanceof C40195v) {
            C1720g.m3540Rg().mo14546b(1048, (C1202f) this);
            if (i == 0 && i2 == 0) {
                C40195v c40195v = (C40195v) c1207m;
                C29766b c29766b = new C29766b(this, (byte) 0);
                c29766b.scene = c40195v.scene;
                c29766b.ufz = (long) c40195v.tZT.wDL;
                c29766b.cBF = c40195v.tZT.vOy;
                c29766b.ufA = System.currentTimeMillis() / 1000;
                c29766b.lcA = c40195v.tZT.wDM;
                c29766b.type = c40195v.businessType;
                s = C43869b.m78674s(c29766b.scene, c29766b.type, true);
                C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", c29766b.cBF);
                if (!C5046bo.isNullOrNil(c29766b.cBF)) {
                    C29944h.m47401JR(c40195v.cIv).mo38648d(0, c29766b.cBF, 0, c40195v.nQB);
                    C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "onTeachSearchDataReady, %s", c29766b.cBF);
                }
                this.ufi.put(s, c29766b);
                File file;
                if (c29766b.ufz == 0) {
                    i3 = c29766b.scene;
                    int i4 = c29766b.type;
                    C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "delete biz cache %d %d", Integer.valueOf(i3), Integer.valueOf(i4));
                    XZ = C34797b.m57159XZ();
                    file = new File(XZ, C43869b.m78674s(i3, i4, true));
                    if (file.exists()) {
                        file.delete();
                    }
                    file = new File(XZ, C43869b.m78674s(i3, i4, false));
                    if (file.exists()) {
                        file.delete();
                    }
                } else {
                    azv azv = new azv();
                    azv.scene = c29766b.scene;
                    azv.vOy = c29766b.cBF;
                    azv.wDD = c29766b.ufz;
                    azv.wDE = c29766b.ufA;
                    azv.vQg = c29766b.lcA;
                    azv.jCt = c29766b.type;
                    byte[] bArr = null;
                    try {
                        bArr = azv.toByteArray();
                    } catch (IOException e) {
                    }
                    if (bArr != null) {
                        file = new File(C34797b.m57159XZ(), C43869b.m78674s(c29766b.scene, c29766b.type, true));
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        C1173e.m2559b(file.getAbsolutePath(), bArr, bArr.length);
                        C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile %s %d", file.getAbsolutePath(), Integer.valueOf(bArr.length));
                    } else {
                        C4990ab.m7416i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile fail");
                    }
                }
                if (c29766b.scene == 20 && c29766b.type == 0) {
                    C14423an.m22642a(c29766b.scene, 1, c29766b.lcA, c29766b.type, 2, c29766b.cWm(), 1);
                    AppMethodBeat.m2505o(5704);
                    return;
                }
                C14423an.m22642a(c29766b.scene, 1, c29766b.lcA, c29766b.type, 1, "", 0);
                AppMethodBeat.m2505o(5704);
                return;
            }
            C4990ab.m7413e("MicroMsg.FTS.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(5704);
        } else if (c1207m instanceof C46405w) {
            C1720g.m3540Rg().mo14546b(1134, (C1202f) this);
            AppMethodBeat.m2505o(5704);
        } else if (c1207m instanceof C43877e) {
            C1720g.m3540Rg().mo14546b(1161, (C1202f) this);
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
                            if (!C5046bo.isNullOrNil(optString)) {
                                arrayList.add(optString);
                            }
                        }
                    }
                    s = XZ;
                } catch (Exception e2) {
                    s = "";
                }
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(5674);
                        C23018g JR = C29944h.m47401JR(C43869b.this.ufj.fpL.cIv);
                        String str = C43869b.this.ufj.fpL.ctj;
                        String str2 = s;
                        C4990ab.m7417i("MicroMsg.MsgHandler", "onSearchSuggestCallback: %s", arrayList.toString());
                        Bundle bundle = new Bundle();
                        bundle.putString(SearchIntents.EXTRA_QUERY, str);
                        bundle.putString("suggestionId", str2);
                        bundle.putStringArrayList("result", r3);
                        try {
                            if (JR.umI != null) {
                                JR.umI.mo26784c(C31128d.MIC_SketchMark, bundle);
                            }
                            AppMethodBeat.m2505o(5674);
                        } catch (RemoteException e) {
                            C4990ab.m7420w("MicroMsg.MsgHandler", "onSearchSuggestCallback exception" + e.getMessage());
                            AppMethodBeat.m2505o(5674);
                        }
                    }
                });
                AppMethodBeat.m2505o(5704);
                return;
            }
            AppMethodBeat.m2505o(5704);
        } else {
            if (c1207m instanceof C40218c) {
                C1720g.m3540Rg().mo14546b(1866, (C1202f) this);
                if (i == 0 && i2 == 0) {
                    C40218c c40218c = (C40218c) c1207m;
                    if (c40218c.cIv != -1) {
                        C29944h.m47401JR(c40218c.cIv).mo38660m(((cst) c40218c.ehh.fsH.fsP).cBF, 0, 0, 0);
                    }
                    if (c40218c.ufI != null) {
                        this.ufl.put(Integer.valueOf(c40218c.ufI.scene), c40218c.ufI);
                    }
                } else {
                    AppMethodBeat.m2505o(5704);
                    return;
                }
            }
            AppMethodBeat.m2505o(5704);
        }
    }

    /* renamed from: az */
    private C14452c m78670az(Map<String, Object> map) {
        AppMethodBeat.m2504i(5705);
        C14452c c14452c = new C14452c(this, (byte) 0);
        c14452c.username = C46400aa.m87342t(map, "userName");
        c14452c.nickname = C46400aa.m87342t(map, "nickName");
        c14452c.pln = C46400aa.m87342t(map, "headHDImgUrl");
        c14452c.ufB = C46400aa.m87332d((Map) map, "verifyFlag", 0);
        c14452c.signature = C46400aa.m87342t(map, "signature");
        c14452c.scene = C46400aa.m87332d((Map) map, "scene", 0);
        c14452c.cIC = C46400aa.m87332d((Map) map, "sceneActionType", 1);
        c14452c.pmz = new C7285uy();
        c14452c.pmz.gvb = C46400aa.m87332d((Map) map, "brandFlag", 0);
        c14452c.pmz.gve = C46400aa.m87342t(map, "iconUrl");
        c14452c.pmz.gvd = C46400aa.m87342t(map, "brandInfo");
        c14452c.pmz.gvc = C46400aa.m87342t(map, "externalInfo");
        c14452c.hlm = C46400aa.m87342t(map, "searchId");
        c14452c.query = C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY);
        c14452c.position = C46400aa.m87332d((Map) map, "position", 0);
        c14452c.ufC = C46400aa.m87343u(map, "isCurrentDetailPage");
        c14452c.ufD = C46400aa.m87342t(map, "extraParams");
        c14452c.ufE = C46400aa.m87332d((Map) map, "friendScene", 0);
        AppMethodBeat.m2505o(5705);
        return c14452c;
    }

    /* renamed from: aA */
    private C14453d m78668aA(Map<String, Object> map) {
        int i = 3;
        AppMethodBeat.m2504i(5706);
        C14453d c14453d = new C14453d(this, (byte) 0);
        c14453d.username = C46400aa.m87342t(map, "userName");
        c14453d.nickname = C46400aa.m87342t(map, "nickName");
        c14453d.dFl = C46400aa.m87342t(map, "alias");
        c14453d.signature = C46400aa.m87342t(map, "signature");
        c14453d.dtS = C46400aa.m87332d((Map) map, "sex", 0);
        c14453d.country = C46400aa.m87342t(map, UserDataStore.COUNTRY);
        c14453d.dud = C46400aa.m87342t(map, "city");
        c14453d.duc = C46400aa.m87342t(map, "province");
        c14453d.ufF = C46400aa.m87332d((Map) map, "snsFlag", 0);
        String t = C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY);
        if (C5046bo.isNullOrNil(t)) {
            c14453d.scene = 3;
        } else {
            if (Character.isDigit(t.charAt(0))) {
                i = 15;
            }
            c14453d.scene = i;
            if (c14453d.scene == 15) {
                if ("mobile".equals(C46400aa.m87342t(map, "matchType"))) {
                    c14453d.query = t;
                } else {
                    c14453d.scene = 1;
                }
            }
        }
        AppMethodBeat.m2505o(5706);
        return c14453d;
    }

    /* renamed from: s */
    static String m78674s(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(5707);
        String str = "FTS_BizCacheObj" + i + "-" + i2;
        String str2 = str + "-" + C4988aa.m7403gw(C4996ah.getContext());
        if (z) {
            AppMethodBeat.m2505o(5707);
            return str2;
        } else if (new File(C34797b.m57159XZ(), str2).exists()) {
            AppMethodBeat.m2505o(5707);
            return str2;
        } else {
            AppMethodBeat.m2505o(5707);
            return str;
        }
    }

    /* renamed from: aB */
    public static boolean m78669aB(Map<String, Object> map) {
        AppMethodBeat.m2504i(5708);
        C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "setSearchInputWord %s", map);
        String t = C46400aa.m87342t(map, "word");
        boolean u = C46400aa.m87343u(map, "isInputChange");
        String t2 = C46400aa.m87342t(map, "custom");
        String t3 = C46400aa.m87342t(map, "tagList");
        C23018g JR = C29944h.m47401JR(C5046bo.m7550g(map.get("webview_instance_id"), -1));
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_new_query", t);
        bundle.putString("fts_key_custom_query", t2);
        bundle.putBoolean("fts_key_need_keyboard", u);
        bundle.putString("fts_key_tag_list", t3);
        try {
            if (JR.umI != null) {
                JR.umI.mo26784c(122, bundle);
            }
        } catch (RemoteException e) {
            C4990ab.m7420w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + e.getMessage());
        }
        AppMethodBeat.m2505o(5708);
        return false;
    }

    /* renamed from: aC */
    public final boolean mo69558aC(Map<String, Object> map) {
        AppMethodBeat.m2504i(5709);
        String str = (String) map.get(SearchIntents.EXTRA_QUERY);
        String str2 = (String) map.get("sortedContacts");
        final int ank = C5046bo.ank((String) map.get("offset"));
        final int ank2 = C5046bo.ank((String) map.get("count"));
        final int g = C5046bo.m7550g(map.get("webview_instance_id"), -1);
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
            C4990ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
        if (this.ufo == null) {
            this.ufo = new C40197b();
        }
        C40198d c40198d = new C40198d(str, arrayList);
        if (this.ufp == null || !this.ufp.equals(c40198d)) {
            this.ufp = c40198d;
            this.ufo.mo56307a(c40198d, new C35578a() {
                public final void cVJ() {
                    AppMethodBeat.m2504i(5680);
                    C43869b.m78664a(C43869b.this.ufp, ank, ank2, g);
                    AppMethodBeat.m2505o(5680);
                }
            });
        } else if (this.ufp.ctn) {
            C43869b.m78664a(this.ufp, ank, ank2, g);
        }
        AppMethodBeat.m2505o(5709);
        return false;
    }

    /* renamed from: a */
    static void m78664a(C40198d c40198d, int i, int i2, int i3) {
        AppMethodBeat.m2504i(5710);
        C29944h.m47401JR(i3).mo38621aP(c40198d.mo63538gq(i, i2));
        AppMethodBeat.m2505o(5710);
    }
}
