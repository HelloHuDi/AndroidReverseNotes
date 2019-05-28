package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.topstory.ui.home.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.m;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    chn cPu;
    private c sHF;
    TopStoryWebView sHG;
    private boolean sHH = true;
    public a sHt;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$7 */
    public class AnonymousClass7 implements Runnable {
        final /* synthetic */ String sHN;

        public AnonymousClass7(String str) {
            this.sHN = str;
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.i(2181);
            a.a(e.this, "onWebRecommendCommCgiResult", this.sHN);
            AppMethodBeat.o(2181);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$10 */
    public class AnonymousClass10 implements Runnable {
        final /* synthetic */ String sHO;

        public AnonymousClass10(String str) {
            this.sHO = str;
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.i(2184);
            a.a(e.this, "onWebRecommendPostComments", this.sHO);
            AppMethodBeat.o(2184);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$12 */
    public class AnonymousClass12 implements Runnable {
        final /* synthetic */ String sHK;

        public AnonymousClass12(String str) {
            this.sHK = str;
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.i(2186);
            a.a(e.this, "onWebRecommendInfoUpdate", this.sHK);
            AppMethodBeat.o(2186);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$9 */
    public class AnonymousClass9 implements Runnable {
        final /* synthetic */ String sHO;

        public AnonymousClass9(String str) {
            this.sHO = str;
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.i(2183);
            a.a(e.this, "onWebRecommendSetComments", this.sHO);
            AppMethodBeat.o(2183);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.webview.e$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ String sHK;

        public AnonymousClass2(String str) {
            this.sHK = str;
        }

        @TargetApi(7)
        public final void run() {
            AppMethodBeat.i(2176);
            a.a(e.this, "onWebRecommendNotifyReddotExtMsg", this.sHK);
            AppMethodBeat.o(2176);
        }
    }

    public e(TopStoryWebView topStoryWebView, chn chn, c cVar) {
        this.sHG = topStoryWebView;
        this.cPu = chn;
        this.sHF = cVar;
    }

    @JavascriptInterface
    public final String getSearchData(String str) {
        String str2 = null;
        AppMethodBeat.i(2187);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getSearchData %s", str);
        if (this.sHt != null) {
            this.sHt.cFy();
        }
        c.c(this.cPu, "getSearchData", System.currentTimeMillis());
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
            chn.xgn = aa.bVP();
            boolean optBoolean = jSONObject.optBoolean("directRequest", false);
            String optString = jSONObject.optString("extReqParams", "");
            if (!bo.isNullOrNil(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    tn tnVar = new tn();
                    tnVar.key = jSONObject2.optString("key", "");
                    tnVar.waD = (long) jSONObject2.optInt("uintValue", 0);
                    tnVar.waE = jSONObject2.optString("textValue", "");
                    chn.tZG.add(tnVar);
                }
            }
            if (chn.cdf == 100) {
                c cVar = this.sHF;
                if (cVar.sHv != null) {
                    if (cVar.sHv.sHE.cvF.equals(chn.cvF) && System.currentTimeMillis() - cVar.sHv.jKz <= 60000) {
                        str2 = cVar.sHv.sHD;
                    }
                    cVar.sHv = null;
                    if (bo.isNullOrNil(str2)) {
                        ab.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache fail");
                    } else {
                        ab.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache success %d", Integer.valueOf(str2.length()));
                    }
                }
                if (bo.isNullOrNil(str2)) {
                    this.sHF.a(chn, true, false, this.sHt == null ? 0 : this.sHt.cFC());
                } else {
                    abD(str2);
                }
            } else {
                this.sHF.a(chn, true, optBoolean, this.sHt == null ? 0 : this.sHt.cFC());
            }
            str2 = cHp().toString();
            AppMethodBeat.o(2187);
            return str2;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "getSearchData", new Object[0]);
            str2 = cHq().toString();
            AppMethodBeat.o(2187);
            return str2;
        }
    }

    @JavascriptInterface
    public final String reportSearchStatistics(String str) {
        AppMethodBeat.i(2188);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "reportSearchStatistics %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            int optInt = jSONObject2.optInt("logId", 0);
            if (optInt != 14904) {
                com.tencent.mm.plugin.report.e.pXa.X(optInt, jSONObject2.optString("logString", ""));
            }
            jSONObject = cHp().toString();
            AppMethodBeat.o(2188);
            return jSONObject;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "reportSearchStatistics", new Object[0]);
            jSONObject = cHq().toString();
            AppMethodBeat.o(2188);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String reportSearchRealTimeStatistics(String str) {
        AppMethodBeat.i(2189);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "reportSearchRealTimeStatistics %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            bsj bsj = new bsj();
            bsj.wUu = jSONObject2.optString("logString", "");
            g.Rg().a(new w(bsj), 0);
            jSONObject = cHp().toString();
            AppMethodBeat.o(2189);
            return jSONObject;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "reportSearchRealTimeStatistics", new Object[0]);
            jSONObject = cHq().toString();
            AppMethodBeat.o(2189);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String stage(String str) {
        AppMethodBeat.i(2190);
        String str2;
        try {
            ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "stage %s", str);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.keys() != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    str2 = (String) keys.next();
                    c.c(this.cPu, str2, jSONObject.optLong(str2));
                }
            }
            str2 = cHp().toString();
            AppMethodBeat.o(2190);
            return str2;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "stage", new Object[0]);
            str2 = cHq().toString();
            AppMethodBeat.o(2190);
            return str2;
        }
    }

    @JavascriptInterface
    public final String startSearchItemDetailPage(String str) {
        AppMethodBeat.i(2191);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String optString = jSONObject2.optString("jumpUrl", "");
            String optString2 = jSONObject2.optString("publishId", "");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", optString);
            intent.putExtra("KPublisherId", optString2);
            ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", optString, optString2);
            int optInt = jSONObject2.optInt("openScene", Downloads.MIN_WAIT_FOR_NETWORK);
            int optInt2 = jSONObject2.optInt("subScene", -1);
            int optInt3 = jSONObject2.optInt("itemType", -1);
            intent.putExtra(m.ygo, optInt3);
            if (ab.getLogLevel() > 0 && optInt3 == -1) {
                optInt3 = 0;
            }
            ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openScene:%s, subScene:%s, itemType:%s", Integer.valueOf(optInt), Integer.valueOf(optInt2), Integer.valueOf(optInt3));
            if (((b) g.K(b.class)).rW(7) && ((b) g.K(b.class)).a(this.sHt.bKU(), optString, optInt3, optInt, optInt2, intent)) {
                ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to TmplWebview");
            } else {
                ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to WebViewUI");
                d.b(this.sHt.bKU(), "webview", ".ui.tools.WebViewUI", intent);
            }
            jSONObject = cHp().toString();
            AppMethodBeat.o(2191);
            return jSONObject;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "reportSearchRealTimeReport", new Object[0]);
            jSONObject = cHq().toString();
            AppMethodBeat.o(2191);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String log(String str) {
        AppMethodBeat.i(2192);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "log: %s", str);
        String jSONObject = cHp().toString();
        AppMethodBeat.o(2192);
        return jSONObject;
    }

    @JavascriptInterface
    public final String getNetworkType(String str) {
        AppMethodBeat.i(2193);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getNetworkType %s", str);
        String jSONObject;
        try {
            JSONObject cHp = cHp();
            String cFq = com.tencent.mm.plugin.topstory.a.g.cFq();
            cHp.put("subtype", cFq);
            if (cFq.equals("wifi")) {
                cHp.put("err_msg", "network_type:wifi");
            } else if (cFq.equals("fail")) {
                cHp.put("err_msg", "network_type:fail");
            } else {
                cHp.put("err_msg", "network_type:wwan");
            }
            jSONObject = cHp.toString();
            AppMethodBeat.o(2193);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = cHq().toString();
            AppMethodBeat.o(2193);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String openProfileWithOpenId(String str) {
        AppMethodBeat.i(2194);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openProfileWithOpenId %s", str);
        String string;
        try {
            string = new JSONObject(str).getString("openId");
            if (!bo.isNullOrNil(string)) {
                c.abC(string);
            }
            string = cHp().toString();
            AppMethodBeat.o(2194);
            return string;
        } catch (Exception e) {
            string = cHq().toString();
            AppMethodBeat.o(2194);
            return string;
        }
    }

    @JavascriptInterface
    public final String updateReddotTimeStamps(String str) {
        AppMethodBeat.i(2195);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "updateReddotTimeStamps %s", str);
        String jSONObject;
        try {
            ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().lC(new JSONObject(str).optLong("reddotTimeStamps", 0));
            jSONObject = cHp().toString();
            AppMethodBeat.o(2195);
            return jSONObject;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "updateReddotTimeStamps", new Object[0]);
            jSONObject = cHq().toString();
            AppMethodBeat.o(2195);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String doGoToRecVideoList(String str) {
        AppMethodBeat.i(2196);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doGoToRecVideoList %s", str);
        String jSONObject;
        try {
            chv am = com.tencent.mm.plugin.topstory.a.g.am(new JSONObject(str));
            if (this.sHt != null) {
                aa.a(this.sHt.bKU(), am);
            }
            jSONObject = cHp().toString();
            AppMethodBeat.o(2196);
            return jSONObject;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "doGoToRecVideoList", new Object[0]);
            jSONObject = cHq().toString();
            AppMethodBeat.o(2196);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String webViewUIReady(String str) {
        AppMethodBeat.i(2197);
        String jSONObject;
        try {
            if (this.sHH) {
                this.sHH = false;
                if (this.sHt != null) {
                    this.sHt.cFz();
                }
                c.c(this.cPu, "webViewUIReady", System.currentTimeMillis());
                ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "traceResult:\n%s", c.a(this.cPu));
            }
            jSONObject = cHp().toString();
            AppMethodBeat.o(2197);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = cHq().toString();
            AppMethodBeat.o(2197);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String renderFinish(String str) {
        AppMethodBeat.i(2198);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "renderFinish %s", str);
        try {
            this.sHt.cFB();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "renderFinish error", new Object[0]);
        }
        String jSONObject = cHp().toString();
        AppMethodBeat.o(2198);
        return jSONObject;
    }

    public final void abD(String str) {
        AppMethodBeat.i(2199);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("json", str);
            jSONObject.put("newQuery", this.sHH);
            jSONObject.put("isCache", false);
            al.d(new Runnable() {
                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.i(2175);
                    a.a(e.this, "onSearchDataReady", jSONObject.toString());
                    c.c(e.this.cPu, "dataReady", System.currentTimeMillis());
                    AppMethodBeat.o(2175);
                }
            });
            AppMethodBeat.o(2199);
        } catch (Exception e) {
            AppMethodBeat.o(2199);
        }
    }

    public final void c(String str, String str2, int i, int i2, int i3, String str3) {
        AppMethodBeat.i(2200);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("beginMsgId", str);
            jSONObject.put("endMsgId", str2);
            jSONObject.put("beginSeq", i);
            jSONObject.put("endSeq", i2);
            jSONObject.put("reddotNum", i3);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, str3);
            al.d(new Runnable() {
                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.i(2179);
                    a.a(e.this, "notifyNumReddotChange", jSONObject.toString());
                    AppMethodBeat.o(2179);
                }
            });
            AppMethodBeat.o(2200);
        } catch (JSONException e) {
            ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyNumReddotChange " + e.getMessage());
            AppMethodBeat.o(2200);
        }
    }

    public final void aw(String str, long j) {
        AppMethodBeat.i(2201);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgId", str);
            jSONObject.put("latestTimeStamp", j);
            al.d(new Runnable() {
                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.i(2180);
                    a.a(e.this, "notifyReddot", jSONObject.toString());
                    AppMethodBeat.o(2180);
                }
            });
            AppMethodBeat.o(2201);
        } catch (JSONException e) {
            ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyReddot " + e.getMessage());
            AppMethodBeat.o(2201);
        }
    }

    public final void abM(final String str) {
        AppMethodBeat.i(2202);
        al.d(new Runnable() {
            @TargetApi(7)
            public final void run() {
                AppMethodBeat.i(2182);
                a.a(e.this, "onWebCommendEnterFromFindPage", str);
                AppMethodBeat.o(2182);
            }
        });
        AppMethodBeat.o(2202);
    }

    public final void aj(String str, int i, int i2) {
        AppMethodBeat.i(2203);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected: %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(i2));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tabInfo", str);
            jSONObject.put("contentReddot", i);
            jSONObject.put("numberReddot", i2);
        } catch (JSONException e) {
            ab.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected json exception: " + e.getMessage());
        }
        a.a(this, "onTabSelected", jSONObject.toString());
        AppMethodBeat.o(2203);
    }

    public final void cHo() {
        AppMethodBeat.i(2204);
        al.d(new Runnable() {
            @TargetApi(7)
            public final void run() {
                AppMethodBeat.i(2177);
                a.a(e.this, "onNavBarShadowManuallyHidden", "");
                AppMethodBeat.o(2177);
            }
        });
        AppMethodBeat.o(2204);
    }

    @JavascriptInterface
    public final String fetchNumReddot(String str) {
        AppMethodBeat.i(2205);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchNumReddot %s", str);
        String jSONObject;
        try {
            int cEU = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEU();
            cht cEW = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEW();
            cht cEX = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEX();
            c(cEX.cJb, cEW.cJb, cEX.fQi, cEW.fQi, cEU, cEW.extInfo);
            jSONObject = cHp().toString();
            AppMethodBeat.o(2205);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = cHq().toString();
            AppMethodBeat.o(2205);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String fetchReddot(String str) {
        AppMethodBeat.i(2206);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchReddot %s", str);
        String jSONObject;
        try {
            cht cEP = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEP();
            if (cEP != null) {
                aw(cEP.cJb, cEP.xgz);
            }
            jSONObject = cHp().toString();
            AppMethodBeat.o(2206);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = cHq().toString();
            AppMethodBeat.o(2206);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String queryWebCommCgi(String str) {
        AppMethodBeat.i(2207);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl queryWebCommCgi %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            g.Rg().a(new com.tencent.mm.plugin.topstory.a.c.a(jSONObject2.optString("requestId", ""), jSONObject2.optString("commReq", "")), 0);
            jSONObject = cHp().toString();
            AppMethodBeat.o(2207);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = cHq().toString();
            AppMethodBeat.o(2207);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String updateNumReddot(String str) {
        AppMethodBeat.i(2208);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl updateNumReddot %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().i(jSONObject2.getLong("latestTimeStamp"), jSONObject2.getInt("seq"), false);
            jSONObject = cHp().toString();
            AppMethodBeat.o(2208);
            return jSONObject;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "lxl updateNumReddot", new Object[0]);
            jSONObject = cHq().toString();
            AppMethodBeat.o(2208);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String setComments(String str) {
        AppMethodBeat.i(2209);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl setComments %s", str);
        String jSONObject;
        try {
            g.Rg().a(new i(new JSONObject(str)), 0);
            jSONObject = cHp().toString();
            AppMethodBeat.o(2209);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = cHq().toString();
            AppMethodBeat.o(2209);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String postComments(String str) {
        AppMethodBeat.i(2210);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl postComments %s", str);
        String jSONObject;
        try {
            g.Rg().a(new f(new JSONObject(str)), 0);
            jSONObject = cHp().toString();
            AppMethodBeat.o(2210);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = cHq().toString();
            AppMethodBeat.o(2210);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String showNavBarShadow(String str) {
        AppMethodBeat.i(2211);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl showNavBarShadow %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.getString("color");
            int i = (int) (jSONObject2.getDouble("alpha") * 255.0d);
            this.sHt.fQ(Integer.parseInt(string.substring(1, string.length()), 16), i);
            jSONObject = cHp().toString();
            AppMethodBeat.o(2211);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = cHq().toString();
            AppMethodBeat.o(2211);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String hideNavBarShadow(String str) {
        AppMethodBeat.i(2212);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl hideNavBarShadow %s", str);
        String jSONObject;
        try {
            this.sHt.cFA();
            jSONObject = cHp().toString();
            AppMethodBeat.o(2212);
            return jSONObject;
        } catch (Exception e) {
            jSONObject = cHq().toString();
            AppMethodBeat.o(2212);
            return jSONObject;
        }
    }

    public final void abN(String str) {
        AppMethodBeat.i(2213);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", str);
            jSONObject.put("sessionId", this.cPu.cvF);
            jSONObject.put("subSessionId", this.cPu.cIy);
            jSONObject.put("scene", this.cPu.scene);
            al.d(new Runnable() {
                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.i(2178);
                    e.this.sHG.evaluateJavascript(String.format("javascript:window.activity_state_change && activity_state_change(%s)", new Object[]{jSONObject.toString()}), null);
                    AppMethodBeat.o(2178);
                }
            });
            AppMethodBeat.o(2213);
        } catch (Exception e) {
            AppMethodBeat.o(2213);
        }
    }

    private static JSONObject cHp() {
        AppMethodBeat.i(2214);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", 0);
        } catch (JSONException e) {
        }
        AppMethodBeat.o(2214);
        return jSONObject;
    }

    private static JSONObject cHq() {
        AppMethodBeat.i(2215);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", -1);
        } catch (JSONException e) {
        }
        AppMethodBeat.o(2215);
        return jSONObject;
    }

    @JavascriptInterface
    public final String openSearchWebView(String str) {
        AppMethodBeat.i(2216);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openSearchWebView %s", str);
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
                    ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", str2, optString2);
                    d.b(this.sHt.bKU(), "webview", ".ui.tools.WebViewUI", intent);
                    break;
                case 3:
                    optString2 = jSONObject.optString(SearchIntents.EXTRA_QUERY, "");
                    int optInt2 = jSONObject.optInt("scene", 0);
                    String optString3 = jSONObject.optString("sessionId", "");
                    String HP = aa.HP(optInt2);
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
                            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "", new Object[0]);
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
                    chn.xgj = c.cFx();
                    chn.scene = optInt2;
                    chn.hlm = "";
                    chn.ctj = optString2;
                    chn.cvF = optString3;
                    chn.cIy = optString3;
                    chn.xgl = 2;
                    chn.url = com.tencent.mm.plugin.topstory.a.g.o(hashMap);
                    chn.xgm = str2;
                    chn.cdf = optInt3;
                    chn.nQB = optString4;
                    chn.xgn = aa.bVP();
                    tn tnVar = new tn();
                    tnVar.key = "rec_category";
                    tnVar.waD = (long) optInt3;
                    tnVar.waE = String.valueOf(optInt3);
                    chn.tZG.add(tnVar);
                    c.a(ah.getContext(), chn, optString4);
                    break;
                case 6:
                    this.sHt.fR(jSONObject.optInt("scene", 53), jSONObject.optInt("subScene", 5));
                    break;
            }
            str2 = cHp().toString();
            AppMethodBeat.o(2216);
            return str2;
        } catch (Exception e2) {
            str2 = cHq().toString();
            AppMethodBeat.o(2216);
            return str2;
        }
    }

    @JavascriptInterface
    public final void doNegFeedback(String str) {
        AppMethodBeat.i(2217);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doNegFeedback %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("filterDocid") && jSONObject.has("category")) {
                String string = jSONObject.getString("filterDocid");
                ((com.tencent.mm.plugin.topstory.ui.a) g.M(com.tencent.mm.plugin.topstory.ui.a.class)).getWebViewMgr().bq(jSONObject.getInt("category"), string);
                AppMethodBeat.o(2217);
                return;
            }
            AppMethodBeat.o(2217);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "doNegFeedback", new Object[0]);
            AppMethodBeat.o(2217);
        }
    }

    @JavascriptInterface
    public final String openWeAppPage(String str) {
        AppMethodBeat.i(2218);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWeAppPage %s", str);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_UP;
            ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(ah.getContext(), jSONObject2.getString("userName"), jSONObject2.getString("appid"), 0, 0, jSONObject2.getString("path"), appBrandStatObject);
            jSONObject = cHp().toString();
            AppMethodBeat.o(2218);
            return jSONObject;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "openWeAppPage", new Object[0]);
            jSONObject = cHq().toString();
            AppMethodBeat.o(2218);
            return jSONObject;
        }
    }

    @JavascriptInterface
    public final String openWowColikeSetting(String str) {
        AppMethodBeat.i(138033);
        ab.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWowColikeSetting %s", str);
        String jSONObject;
        try {
            c.eZ(ah.getContext());
            jSONObject = cHp().toString();
            AppMethodBeat.o(138033);
            return jSONObject;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e, "openWowColikeSetting", new Object[0]);
            jSONObject = cHq().toString();
            AppMethodBeat.o(138033);
            return jSONObject;
        }
    }
}
