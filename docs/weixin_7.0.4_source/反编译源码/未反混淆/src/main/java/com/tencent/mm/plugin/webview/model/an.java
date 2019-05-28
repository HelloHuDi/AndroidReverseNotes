package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.webview.modelcache.q;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.xweb.o;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class an {
    private Context mContext;
    private int umA = -1;
    public ArrayList<String> umB;
    public ArrayList<String> umC;
    public List<Integer> umD;
    public final Map<String, Boolean> umE;
    public final Set<String> umF;
    private String umG = null;

    public an(Context context) {
        AppMethodBeat.i(6739);
        this.mContext = context;
        this.umD = new ArrayList();
        this.umE = new HashMap();
        this.umF = new HashSet();
        this.umB = new ArrayList();
        this.umC = new ArrayList();
        AppMethodBeat.o(6739);
    }

    public final o a(String str, boolean z, d dVar) {
        AppMethodBeat.i(6740);
        o cXO;
        String dC;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
            AppMethodBeat.o(6740);
            return null;
        } else if (str.startsWith("weixin://bridge.js")) {
            cXO = cXO();
            AppMethodBeat.o(6740);
            return cXO;
        } else if (str.startsWith("weixin://game.js")) {
            if (this.mContext == null || !(this.mContext instanceof GameWebViewUI)) {
                AppMethodBeat.o(6740);
                return null;
            }
            boolean z2;
            c cVar = ((GameWebViewUI) this.mContext).uDe;
            if (cVar != null) {
                z2 = cVar.uVv;
            } else {
                z2 = false;
            }
            WebResourceResponse nX = com.tencent.mm.plugin.webview.ui.tools.game.d.nX(z2);
            if (nX == null) {
                AppMethodBeat.o(6740);
                return null;
            } else if (VERSION.SDK_INT >= 21) {
                cXO = new o(nX.getMimeType(), nX.getEncoding(), nX.getStatusCode(), nX.getReasonPhrase(), nX.getResponseHeaders(), nX.getData());
                AppMethodBeat.o(6740);
                return cXO;
            } else {
                cXO = new o(nX.getMimeType(), nX.getEncoding(), nX.getData());
                AppMethodBeat.o(6740);
                return cXO;
            }
        } else if (str.startsWith("weixin://resourceid/")) {
            ab.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
            try {
                InputStream inputStream;
                dC = dVar.dC(str, 1);
                if (bo.isNullOrNil(dC)) {
                    ab.e("MicroMsg.WebviewJSSDKUtil", "local is is null or nil");
                    inputStream = null;
                } else {
                    inputStream = ap.aeE(dC);
                }
                cXO = new o("image/*", ProtocolPackage.ServerEncoding, inputStream);
                AppMethodBeat.o(6740);
                return cXO;
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", e.getMessage());
                AppMethodBeat.o(6740);
                return null;
            }
        } else {
            String toLowerCase;
            if (z) {
                Object obj;
                if (!bo.isNullOrNil(str) && q.Ed(str)) {
                    toLowerCase = str.toLowerCase();
                    if (toLowerCase.contains("localhost") || toLowerCase.contains("127.0.0.1") || toLowerCase.contains("::1") || toLowerCase.contains(u.bOO())) {
                        if (this.umD != null && this.umD.size() > 0) {
                            for (Integer intValue : this.umD) {
                                int intValue2 = intValue.intValue();
                                if (!toLowerCase.contains("localhost:".concat(String.valueOf(intValue2)))) {
                                    if (toLowerCase.contains("127.0.0.1:".concat(String.valueOf(intValue2)))) {
                                    }
                                }
                                ab.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", toLowerCase, Integer.valueOf(intValue2));
                            }
                        }
                        ab.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", toLowerCase);
                        obj = 1;
                    }
                    obj = null;
                    break;
                }
                obj = null;
                if (obj != null) {
                    ab.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", str);
                    cXO = new o("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                    AppMethodBeat.o(6740);
                    return cXO;
                }
            }
            if (b(str, dVar)) {
                ab.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", str);
                cXO = new o("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                AppMethodBeat.o(6740);
                return cXO;
            }
            try {
                if (f.isEnabled()) {
                    dC = f.cZD();
                    Uri parse = Uri.parse(str);
                    String host = parse.getHost();
                    if (!(dC == null || host == null || !dC.equals(ag.ck(host + b.oTO.TQ("\u0003&+21"))))) {
                        SharedPreferences sharedPreferences;
                        long j;
                        long currentTimeMillis;
                        Set queryParameterNames = parse.getQueryParameterNames();
                        if (queryParameterNames != null && queryParameterNames.contains(ApplicationInfo.class.getSimpleName().substring(2, 3))) {
                            ab.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, something wicked this way comes.");
                            if (bo.isNullOrNil(str)) {
                                ab.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
                            } else {
                                sharedPreferences = ah.getContext().getSharedPreferences("qar_cycle_rec", 0);
                                toLowerCase = "qaj_tick_" + ag.ck(str);
                                j = sharedPreferences.getLong(toLowerCase, 0);
                                currentTimeMillis = System.currentTimeMillis();
                                if (currentTimeMillis - j > TimeUnit.HOURS.toMillis(24)) {
                                    sharedPreferences.edit().putLong(toLowerCase, currentTimeMillis).commit();
                                    e.pXa.a(16195, str.replace(",", "%2C"), false, true);
                                    e.pXa.a(943, 0, 1, false);
                                }
                            }
                        }
                        if (f.bXm()) {
                            ab.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, block is enabled.");
                            if (bo.isNullOrNil(str)) {
                                ab.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
                            } else {
                                try {
                                    sharedPreferences = ah.getContext().getSharedPreferences("qar_cycle_rec", 0);
                                    toLowerCase = "qab_tick_" + ag.ck(str);
                                    j = sharedPreferences.getLong(toLowerCase, 0);
                                    currentTimeMillis = System.currentTimeMillis();
                                    if (currentTimeMillis - j > TimeUnit.HOURS.toMillis(24)) {
                                        sharedPreferences.edit().putLong(toLowerCase, currentTimeMillis).commit();
                                        e.pXa.a(943, 1, 1, false);
                                    }
                                } catch (Throwable th) {
                                    ab.printErrStackTrace("MicroMsg.WebViewReporter", th, "", new Object[0]);
                                }
                            }
                            cXO = new o("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
                            AppMethodBeat.o(6740);
                            return cXO;
                        }
                    }
                }
            } catch (Throwable th2) {
            }
            AppMethodBeat.o(6740);
            return null;
        }
    }

    private boolean b(String str, d dVar) {
        Iterator it;
        AppMethodBeat.i(6741);
        if (this.umA == -1) {
            try {
                Bundle g = dVar.g(31, null);
                if (g != null) {
                    this.umA = g.getInt("webview_ad_intercept_control_flag");
                    this.umB = g.getStringArrayList("webview_ad_intercept_whitelist_domins");
                    this.umC = g.getStringArrayList("webview_ad_intercept_blacklist_domins");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("white domain list :\n");
                    it = this.umB.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    stringBuilder.append("black list domain list : \n");
                    it = this.umC.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    ab.i("MicroMsg.WebViewResourceInterrupter", stringBuilder.toString());
                }
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", e.getMessage());
                this.umA = 0;
            }
        }
        if (this.umA == 0) {
            AppMethodBeat.o(6741);
            return false;
        }
        String host = Uri.parse(str).getHost();
        ab.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", host, this.umE.get(host));
        if (bo.isNullOrNil(host)) {
            AppMethodBeat.o(6741);
            return false;
        } else if (this.umE.containsKey(host)) {
            boolean booleanValue = ((Boolean) this.umE.get(host)).booleanValue();
            AppMethodBeat.o(6741);
            return booleanValue;
        } else {
            String str2;
            if (this.umB != null && this.umB.size() > 0) {
                it = this.umB.iterator();
                while (it.hasNext()) {
                    str2 = (String) it.next();
                    if (!bo.isNullOrNil(str2) && host.contains(str2)) {
                        this.umE.put(host, Boolean.FALSE);
                        ab.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
                        AppMethodBeat.o(6741);
                        return false;
                    }
                }
            }
            if (this.umC != null && this.umC.size() > 0) {
                it = this.umC.iterator();
                while (it.hasNext()) {
                    str2 = (String) it.next();
                    if (!bo.isNullOrNil(str2) && host.contains(str2)) {
                        if (this.umA == 1) {
                            this.umE.put(host, Boolean.TRUE);
                            ab.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", str2, str);
                            AppMethodBeat.o(6741);
                            return true;
                        } else if (this.umA == 2) {
                            ab.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", str2, str);
                            this.umF.add(host);
                            this.umE.put(host, Boolean.FALSE);
                            AppMethodBeat.o(6741);
                            return false;
                        }
                    }
                }
            }
            this.umE.put(host, Boolean.FALSE);
            AppMethodBeat.o(6741);
            return false;
        }
    }

    public final void aey(String str) {
        AppMethodBeat.i(6742);
        this.umG = str;
        ab.i("MicroMsg.WebViewResourceInterrupter", "setDgtVerifyRandomStr, ranDomStr: %s, hashCode: %d", this.umG, Integer.valueOf(hashCode()));
        AppMethodBeat.o(6742);
    }

    private o cXO() {
        AppMethodBeat.i(6743);
        if (((a) g.K(a.class)).a(a.a.clicfg_webview_can_pre_inject_jsbridge, 1) == 0) {
            ab.i("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, canPreInjectJsBridge: %d", Integer.valueOf(((a) g.K(a.class)).a(a.a.clicfg_webview_can_pre_inject_jsbridge, 1)));
            AppMethodBeat.o(6743);
            return null;
        }
        if (this.mContext != null && (this.mContext instanceof WebViewUI)) {
            ((WebViewUI) this.mContext).uvG = false;
        }
        try {
            InputStream open;
            if (TextUtils.isEmpty(this.umG)) {
                open = ah.getContext().getAssets().open("jsapi/wxjs.js");
            } else {
                open = new ByteArrayInputStream(new String(org.apache.commons.a.c.toByteArray(ah.getContext().getAssets().open("jsapi/wxjs.js"))).replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.umG).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true").getBytes("UTF-8"));
                ab.i("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, ranDomStr: %s, hashCode: %d", this.umG, Integer.valueOf(hashCode()));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
            hashMap.put("Pragma", "no-cache");
            hashMap.put("Expires", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            o oVar = new o("application/javascript", ProtocolPackage.ServerEncoding, 200, "OK", hashMap, open);
            AppMethodBeat.o(6743);
            return oVar;
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, failed, ", e);
            AppMethodBeat.o(6743);
            return null;
        }
    }
}
