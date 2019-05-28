package com.tencent.p177mm.plugin.topstory.p541ui.webview;

import android.annotation.TargetApi;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C13944f;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C35292i;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C43690a;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.plugin.topstory.p541ui.C7612a;
import com.tencent.p177mm.plugin.topstory.p541ui.home.C39969a;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C46405w;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.bsj;
import com.tencent.p177mm.protocal.protobuf.chn;
import com.tencent.p177mm.protocal.protobuf.cht;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e */
public final class C43702e {
    chn cPu;
    private C13995c sHF;
    TopStoryWebView sHG;
    private boolean sHH = true;
    public C39969a sHt;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$7 */
    public class C224227 implements Runnable {
        final /* synthetic */ String sHN;

        public C224227(String str) {
            this.sHN = str;
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.m2504i(2181);
            C13993a.m22130a(C43702e.this, "onWebRecommendCommCgiResult", this.sHN);
            AppMethodBeat.m2505o(2181);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$10 */
    public class C3531410 implements Runnable {
        final /* synthetic */ String sHO;

        public C3531410(String str) {
            this.sHO = str;
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.m2504i(2184);
            C13993a.m22130a(C43702e.this, "onWebRecommendPostComments", this.sHO);
            AppMethodBeat.m2505o(2184);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$12 */
    public class C3531512 implements Runnable {
        final /* synthetic */ String sHK;

        public C3531512(String str) {
            this.sHK = str;
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.m2504i(2186);
            C13993a.m22130a(C43702e.this, "onWebRecommendInfoUpdate", this.sHK);
            AppMethodBeat.m2505o(2186);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$11 */
    public class C3999811 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(2185);
            C13993a.m22130a(C43702e.this, "onNetWorkChange", "");
            AppMethodBeat.m2505o(2185);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$3 */
    class C400003 implements Runnable {
        C400003() {
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.m2504i(2177);
            C13993a.m22130a(C43702e.this, "onNavBarShadowManuallyHidden", "");
            AppMethodBeat.m2505o(2177);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$9 */
    public class C437019 implements Runnable {
        final /* synthetic */ String sHO;

        public C437019(String str) {
            this.sHO = str;
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.m2504i(2183);
            C13993a.m22130a(C43702e.this, "onWebRecommendSetComments", this.sHO);
            AppMethodBeat.m2505o(2183);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$2 */
    public class C437032 implements Runnable {
        final /* synthetic */ String sHK;

        public C437032(String str) {
            this.sHK = str;
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.m2504i(2176);
            C13993a.m22130a(C43702e.this, "onWebRecommendNotifyReddotExtMsg", this.sHK);
            AppMethodBeat.m2505o(2176);
        }
    }

    public C43702e(TopStoryWebView topStoryWebView, chn chn, C13995c c13995c) {
        this.sHG = topStoryWebView;
        this.cPu = chn;
        this.sHF = c13995c;
    }

    @JavascriptInterface
    public final String getSearchData(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(2187);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getSearchData %s", str);
        if (this.sHt != null) {
            this.sHt.cFy();
        }
        C4210c.m6561c(this.cPu, "getSearchData", System.currentTimeMillis());
        try {
            JSONObject jSONObject = new JSONObject(str);
            chn chn = new chn();
            chn.xgj = this.cPu.xgj;
            chn.ctj = jSONObject.optString(SearchIntents.EXTRA_QUERY, "");
            chn.offset = jSONObject.optInt("offset", 0);
            chn.scene = jSONObject.optInt("scene", 21);
            chn.cvF = jSONObject.optString("sessionId", "");
            chn.cIy = jSONObject.optString("subSessionId", "");
            chn.hlm = jSONObject.optString("searchId", "");
            chn.nQB = jSONObject.optString("requestId", "");
            chn.cdf = jSONObject.optInt("tagId", 0);
            chn.tZP = jSONObject.optString("navigationId", "");
            chn.xgn = C46400aa.bVP();
            boolean optBoolean = jSONObject.optBoolean("directRequest", false);
            String optString = jSONObject.optString("extReqParams", "");
            if (!C5046bo.isNullOrNil(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    C23447tn c23447tn = new C23447tn();
                    c23447tn.key = jSONObject2.optString("key", "");
                    c23447tn.waD = (long) jSONObject2.optInt("uintValue", 0);
                    c23447tn.waE = jSONObject2.optString("textValue", "");
                    chn.tZG.add(c23447tn);
                }
            }
            if (chn.cdf == 100) {
                C13995c c13995c = this.sHF;
                if (c13995c.sHv != null) {
                    if (c13995c.sHv.sHE.cvF.equals(chn.cvF) && System.currentTimeMillis() - c13995c.sHv.jKz <= 60000) {
                        str2 = c13995c.sHv.sHD;
                    }
                    c13995c.sHv = null;
                    if (C5046bo.isNullOrNil(str2)) {
                        C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebData", "load data from cache fail");
                    } else {
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebData", "load data from cache success %d", Integer.valueOf(str2.length()));
                    }
                }
                if (C5046bo.isNullOrNil(str2)) {
                    this.sHF.mo26227a(chn, true, false, this.sHt == null ? 0 : this.sHt.cFC());
                } else {
                    abD(str2);
                }
            } else {
                this.sHF.mo26227a(chn, true, optBoolean, this.sHt == null ? 0 : this.sHt.cFC());
            }
            str2 = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2187);
            return str2;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "getSearchData", new Object[0]);
            str2 = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2187);
            return str2;
        }
    }

    @JavascriptInterface
    public final String reportSearchStatistics(String str) {
        AppMethodBeat.m2504i(2188);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "reportSearchStatistics %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            int optInt = jSONObject2.optInt("logId", 0);
            if (optInt != 14904) {
                C7053e.pXa.mo8374X(optInt, jSONObject2.optString("logString", ""));
            }
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2188);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "reportSearchStatistics", new Object[0]);
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2188);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String reportSearchRealTimeStatistics(String str) {
        AppMethodBeat.m2504i(2189);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "reportSearchRealTimeStatistics %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            bsj bsj = new bsj();
            bsj.wUu = jSONObject2.optString("logString", "");
            C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2189);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "reportSearchRealTimeStatistics", new Object[0]);
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2189);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String stage(String str) {
        AppMethodBeat.m2504i(2190);
        String str2;
        try {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "stage %s", str);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.keys() != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    str2 = (String) keys.next();
                    C4210c.m6561c(this.cPu, str2, jSONObject.optLong(str2));
                }
            }
            str2 = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2190);
            return str2;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "stage", new Object[0]);
            str2 = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2190);
            return str2;
        }
    }

    @JavascriptInterface
    public final String startSearchItemDetailPage(String str) {
        AppMethodBeat.m2504i(2191);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String optString = jSONObject2.optString("jumpUrl", "");
            String optString2 = jSONObject2.optString("publishId", "");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", optString);
            intent.putExtra("KPublisherId", optString2);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", optString, optString2);
            int optInt = jSONObject2.optInt("openScene", Downloads.MIN_WAIT_FOR_NETWORK);
            int optInt2 = jSONObject2.optInt("subScene", -1);
            int optInt3 = jSONObject2.optInt("itemType", -1);
            intent.putExtra(C5506m.ygo, optInt3);
            if (C4990ab.getLogLevel() > 0 && optInt3 == -1) {
                optInt3 = 0;
            }
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openScene:%s, subScene:%s, itemType:%s", Integer.valueOf(optInt), Integer.valueOf(optInt2), Integer.valueOf(optInt3));
            if (((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(7) && ((C20023b) C1720g.m3528K(C20023b.class)).mo6750a(this.sHt.bKU(), optString, optInt3, optInt, optInt2, intent)) {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to TmplWebview");
            } else {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to WebViewUI");
                C25985d.m41467b(this.sHt.bKU(), "webview", ".ui.tools.WebViewUI", intent);
            }
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2191);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "reportSearchRealTimeReport", new Object[0]);
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2191);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String log(String str) {
        AppMethodBeat.m2504i(2192);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "log: %s", str);
        String jSONObject = C43702e.cHp().toString();
        AppMethodBeat.m2505o(2192);
        return jSONObject;
    }

    @JavascriptInterface
    public final String getNetworkType(String str) {
        AppMethodBeat.m2504i(2193);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getNetworkType %s", str);
        String jSONObject;
        try {
            JSONObject cHp = C43702e.cHp();
            String cFq = C39964g.cFq();
            cHp.put("subtype", cFq);
            if (cFq.equals("wifi")) {
                cHp.put("err_msg", "network_type:wifi");
            } else if (cFq.equals("fail")) {
                cHp.put("err_msg", "network_type:fail");
            } else {
                cHp.put("err_msg", "network_type:wwan");
            }
            jSONObject = cHp.toString();
            AppMethodBeat.m2505o(2193);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2193);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String openProfileWithOpenId(String str) {
        AppMethodBeat.m2504i(2194);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openProfileWithOpenId %s", str);
        String string;
        try {
            string = new JSONObject(str).getString("openId");
            if (!C5046bo.isNullOrNil(string)) {
                C4210c.abC(string);
            }
            string = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2194);
            return string;
        } catch (Exception e) {
            string = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2194);
            return string;
        }
    }

    @JavascriptInterface
    public final String updateReddotTimeStamps(String str) {
        AppMethodBeat.m2504i(2195);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "updateReddotTimeStamps %s", str);
        String jSONObject;
        try {
            ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().mo56038lC(new JSONObject(str).optLong("reddotTimeStamps", 0));
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2195);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "updateReddotTimeStamps", new Object[0]);
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2195);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String doGoToRecVideoList(String str) {
        AppMethodBeat.m2504i(2196);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doGoToRecVideoList %s", str);
        String jSONObject;
        try {
            chv am = C39964g.m68432am(new JSONObject(str));
            if (this.sHt != null) {
                C46400aa.m87323a(this.sHt.bKU(), am);
            }
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2196);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "doGoToRecVideoList", new Object[0]);
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2196);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String webViewUIReady(String str) {
        AppMethodBeat.m2504i(2197);
        String jSONObject;
        try {
            if (this.sHH) {
                this.sHH = false;
                if (this.sHt != null) {
                    this.sHt.cFz();
                }
                C4210c.m6561c(this.cPu, "webViewUIReady", System.currentTimeMillis());
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "traceResult:\n%s", C4210c.m6555a(this.cPu));
            }
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2197);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2197);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String renderFinish(String str) {
        AppMethodBeat.m2504i(2198);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "renderFinish %s", str);
        try {
            this.sHt.cFB();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "renderFinish error", new Object[0]);
        }
        String jSONObject = C43702e.cHp().toString();
        AppMethodBeat.m2505o(2198);
        return jSONObject;
    }

    public final void abD(String str) {
        AppMethodBeat.m2504i(2199);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("json", str);
            jSONObject.put("newQuery", this.sHH);
            jSONObject.put("isCache", false);
            C5004al.m7441d(new Runnable() {
                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.m2504i(2175);
                    C13993a.m22130a(C43702e.this, "onSearchDataReady", jSONObject.toString());
                    C4210c.m6561c(C43702e.this.cPu, "dataReady", System.currentTimeMillis());
                    AppMethodBeat.m2505o(2175);
                }
            });
            AppMethodBeat.m2505o(2199);
        } catch (Exception e) {
            AppMethodBeat.m2505o(2199);
        }
    }

    /* renamed from: c */
    public final void mo69351c(String str, String str2, int i, int i2, int i3, String str3) {
        AppMethodBeat.m2504i(2200);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("beginMsgId", str);
            jSONObject.put("endMsgId", str2);
            jSONObject.put("beginSeq", i);
            jSONObject.put("endSeq", i2);
            jSONObject.put("reddotNum", i3);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, str3);
            C5004al.m7441d(new Runnable() {
                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.m2504i(2179);
                    C13993a.m22130a(C43702e.this, "notifyNumReddotChange", jSONObject.toString());
                    AppMethodBeat.m2505o(2179);
                }
            });
            AppMethodBeat.m2505o(2200);
        } catch (JSONException e) {
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyNumReddotChange " + e.getMessage());
            AppMethodBeat.m2505o(2200);
        }
    }

    /* renamed from: aw */
    public final void mo69350aw(String str, long j) {
        AppMethodBeat.m2504i(2201);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgId", str);
            jSONObject.put("latestTimeStamp", j);
            C5004al.m7441d(new Runnable() {
                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.m2504i(2180);
                    C13993a.m22130a(C43702e.this, "notifyReddot", jSONObject.toString());
                    AppMethodBeat.m2505o(2180);
                }
            });
            AppMethodBeat.m2505o(2201);
        } catch (JSONException e) {
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyReddot " + e.getMessage());
            AppMethodBeat.m2505o(2201);
        }
    }

    public final void abM(final String str) {
        AppMethodBeat.m2504i(2202);
        C5004al.m7441d(new Runnable() {
            @TargetApi(7)
            public final void run() {
                AppMethodBeat.m2504i(2182);
                C13993a.m22130a(C43702e.this, "onWebCommendEnterFromFindPage", str);
                AppMethodBeat.m2505o(2182);
            }
        });
        AppMethodBeat.m2505o(2202);
    }

    /* renamed from: aj */
    public final void mo69349aj(String str, int i, int i2) {
        AppMethodBeat.m2504i(2203);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected: %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(i2));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tabInfo", str);
            jSONObject.put("contentReddot", i);
            jSONObject.put("numberReddot", i2);
        } catch (JSONException e) {
            C4990ab.m7420w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected json exception: " + e.getMessage());
        }
        C13993a.m22130a(this, "onTabSelected", jSONObject.toString());
        AppMethodBeat.m2505o(2203);
    }

    public final void cHo() {
        AppMethodBeat.m2504i(2204);
        C5004al.m7441d(new C400003());
        AppMethodBeat.m2505o(2204);
    }

    @JavascriptInterface
    public final String fetchNumReddot(String str) {
        AppMethodBeat.m2504i(2205);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchNumReddot %s", str);
        String jSONObject;
        try {
            int cEU = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEU();
            cht cEW = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEW();
            cht cEX = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEX();
            mo69351c(cEX.cJb, cEW.cJb, cEX.fQi, cEW.fQi, cEU, cEW.extInfo);
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2205);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2205);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String fetchReddot(String str) {
        AppMethodBeat.m2504i(2206);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchReddot %s", str);
        String jSONObject;
        try {
            cht cEP = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEP();
            if (cEP != null) {
                mo69350aw(cEP.cJb, cEP.xgz);
            }
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2206);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2206);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String queryWebCommCgi(String str) {
        AppMethodBeat.m2504i(2207);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl queryWebCommCgi %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            C1720g.m3540Rg().mo14541a(new C43690a(jSONObject2.optString("requestId", ""), jSONObject2.optString("commReq", "")), 0);
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2207);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2207);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String updateNumReddot(String str) {
        AppMethodBeat.m2504i(2208);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl updateNumReddot %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().mo56037i(jSONObject2.getLong("latestTimeStamp"), jSONObject2.getInt("seq"), false);
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2208);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "lxl updateNumReddot", new Object[0]);
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2208);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String setComments(String str) {
        AppMethodBeat.m2504i(2209);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl setComments %s", str);
        String jSONObject;
        try {
            C1720g.m3540Rg().mo14541a(new C35292i(new JSONObject(str)), 0);
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2209);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2209);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String postComments(String str) {
        AppMethodBeat.m2504i(2210);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl postComments %s", str);
        String jSONObject;
        try {
            C1720g.m3540Rg().mo14541a(new C13944f(new JSONObject(str)), 0);
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2210);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2210);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String showNavBarShadow(String str) {
        AppMethodBeat.m2504i(2211);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl showNavBarShadow %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.getString("color");
            int i = (int) (jSONObject2.getDouble("alpha") * 255.0d);
            this.sHt.mo63185fQ(Integer.parseInt(string.substring(1, string.length()), 16), i);
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2211);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2211);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String hideNavBarShadow(String str) {
        AppMethodBeat.m2504i(2212);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl hideNavBarShadow %s", str);
        String jSONObject;
        try {
            this.sHt.cFA();
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2212);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2212);
            return jSONObject;
        }
    }

    public final void abN(String str) {
        AppMethodBeat.m2504i(2213);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", str);
            jSONObject.put("sessionId", this.cPu.cvF);
            jSONObject.put("subSessionId", this.cPu.cIy);
            jSONObject.put("scene", this.cPu.scene);
            C5004al.m7441d(new Runnable() {
                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.m2504i(2178);
                    C43702e.this.sHG.evaluateJavascript(String.format("javascript:window.activity_state_change && activity_state_change(%s)", new Object[]{jSONObject.toString()}), null);
                    AppMethodBeat.m2505o(2178);
                }
            });
            AppMethodBeat.m2505o(2213);
        } catch (Exception e) {
            AppMethodBeat.m2505o(2213);
        }
    }

    private static JSONObject cHp() {
        AppMethodBeat.m2504i(2214);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", 0);
        } catch (JSONException e) {
        }
        AppMethodBeat.m2505o(2214);
        return jSONObject;
    }

    private static JSONObject cHq() {
        AppMethodBeat.m2504i(2215);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", -1);
        } catch (JSONException e) {
        }
        AppMethodBeat.m2505o(2215);
        return jSONObject;
    }

    @JavascriptInterface
    public final String openSearchWebView(String str) {
        AppMethodBeat.m2504i(2216);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openSearchWebView %s", str);
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("actionType");
            String optString = jSONObject.optString("extParams", "");
            String optString2 = jSONObject.optString("publishId", "");
            switch (optInt) {
                case 2:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", jSONObject.optString("jumpUrl", ""));
                    intent.putExtra("KPublisherId", optString2);
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", str2, optString2);
                    C25985d.m41467b(this.sHt.bKU(), "webview", ".ui.tools.WebViewUI", intent);
                    break;
                case 3:
                    optString2 = jSONObject.optString(SearchIntents.EXTRA_QUERY, "");
                    int optInt2 = jSONObject.optInt("scene", 0);
                    String optString3 = jSONObject.optString("sessionId", "");
                    String HP = C46400aa.m87299HP(optInt2);
                    int optInt3 = jSONObject.optInt("tagId", 0);
                    String optString4 = jSONObject.optString("nativeConfig", "");
                    str2 = null;
                    if (!TextUtils.isEmpty(optString4)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(optString4);
                            if (jSONObject2.has("title")) {
                                str2 = jSONObject2.optString("title");
                            }
                        } catch (JSONException e) {
                            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "", new Object[0]);
                        }
                    }
                    optString4 = String.valueOf(System.currentTimeMillis());
                    HashMap hashMap = new HashMap();
                    hashMap.put("scene", String.valueOf(optInt2));
                    hashMap.put(SearchIntents.EXTRA_QUERY, optString2);
                    hashMap.put("sessionId", optString3);
                    hashMap.put("extParams", optString);
                    hashMap.put("subSessionId", HP);
                    hashMap.put("requestId", optString4);
                    hashMap.put("pRequestId", optString4);
                    hashMap.put("seq", optString4);
                    chn chn = new chn();
                    chn.xgj = C4210c.cFx();
                    chn.scene = optInt2;
                    chn.hlm = "";
                    chn.ctj = optString2;
                    chn.cvF = optString3;
                    chn.cIy = optString3;
                    chn.xgl = 2;
                    chn.url = C39964g.m68435o(hashMap);
                    chn.xgm = str2;
                    chn.cdf = optInt3;
                    chn.nQB = optString4;
                    chn.xgn = C46400aa.bVP();
                    C23447tn c23447tn = new C23447tn();
                    c23447tn.key = "rec_category";
                    c23447tn.waD = (long) optInt3;
                    c23447tn.waE = String.valueOf(optInt3);
                    chn.tZG.add(c23447tn);
                    C4210c.m6556a(C4996ah.getContext(), chn, optString4);
                    break;
                case 6:
                    this.sHt.mo63186fR(jSONObject.optInt("scene", 53), jSONObject.optInt("subScene", 5));
                    break;
            }
            str2 = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2216);
            return str2;
        } catch (Exception e2) {
            str2 = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2216);
            return str2;
        }
    }

    @JavascriptInterface
    public final void doNegFeedback(String str) {
        AppMethodBeat.m2504i(2217);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doNegFeedback %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("filterDocid") && jSONObject.has("category")) {
                String string = jSONObject.getString("filterDocid");
                ((C7612a) C1720g.m3530M(C7612a.class)).getWebViewMgr().mo9149bq(jSONObject.getInt("category"), string);
                AppMethodBeat.m2505o(2217);
                return;
            }
            AppMethodBeat.m2505o(2217);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "doNegFeedback", new Object[0]);
            AppMethodBeat.m2505o(2217);
        }
    }

    @JavascriptInterface
    public final String openWeAppPage(String str) {
        AppMethodBeat.m2504i(2218);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWeAppPage %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_UP;
            ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(C4996ah.getContext(), jSONObject2.getString("userName"), jSONObject2.getString("appid"), 0, 0, jSONObject2.getString("path"), appBrandStatObject);
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(2218);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "openWeAppPage", new Object[0]);
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(2218);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String openWowColikeSetting(String str) {
        AppMethodBeat.m2504i(138033);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWowColikeSetting %s", str);
        String jSONObject;
        try {
            C4210c.m6562eZ(C4996ah.getContext());
            jSONObject = C43702e.cHp().toString();
            AppMethodBeat.m2505o(138033);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "openWowColikeSetting", new Object[0]);
            jSONObject = C43702e.cHq().toString();
            AppMethodBeat.m2505o(138033);
            return jSONObject;
        }
    }
}
