package com.tencent.p177mm.plugin.webview.model;

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
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.webview.modelcache.C14525q;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C22947f;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C46438d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.GameWebViewUI;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.plugin.wepkg.C30003c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.xweb.C31147o;
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
import org.apache.commons.p1431a.C31203c;

/* renamed from: com.tencent.mm.plugin.webview.model.an */
public final class C22883an {
    private Context mContext;
    private int umA = -1;
    public ArrayList<String> umB;
    public ArrayList<String> umC;
    public List<Integer> umD;
    public final Map<String, Boolean> umE;
    public final Set<String> umF;
    private String umG = null;

    public C22883an(Context context) {
        AppMethodBeat.m2504i(6739);
        this.mContext = context;
        this.umD = new ArrayList();
        this.umE = new HashMap();
        this.umF = new HashSet();
        this.umB = new ArrayList();
        this.umC = new ArrayList();
        AppMethodBeat.m2505o(6739);
    }

    /* renamed from: a */
    public final C31147o mo38480a(String str, boolean z, C46434d c46434d) {
        AppMethodBeat.m2504i(6740);
        C31147o cXO;
        String dC;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
            AppMethodBeat.m2505o(6740);
            return null;
        } else if (str.startsWith("weixin://bridge.js")) {
            cXO = cXO();
            AppMethodBeat.m2505o(6740);
            return cXO;
        } else if (str.startsWith("weixin://game.js")) {
            if (this.mContext == null || !(this.mContext instanceof GameWebViewUI)) {
                AppMethodBeat.m2505o(6740);
                return null;
            }
            boolean z2;
            C30003c c30003c = ((GameWebViewUI) this.mContext).uDe;
            if (c30003c != null) {
                z2 = c30003c.uVv;
            } else {
                z2 = false;
            }
            WebResourceResponse nX = C46438d.m87588nX(z2);
            if (nX == null) {
                AppMethodBeat.m2505o(6740);
                return null;
            } else if (VERSION.SDK_INT >= 21) {
                cXO = new C31147o(nX.getMimeType(), nX.getEncoding(), nX.getStatusCode(), nX.getReasonPhrase(), nX.getResponseHeaders(), nX.getData());
                AppMethodBeat.m2505o(6740);
                return cXO;
            } else {
                cXO = new C31147o(nX.getMimeType(), nX.getEncoding(), nX.getData());
                AppMethodBeat.m2505o(6740);
                return cXO;
            }
        } else if (str.startsWith("weixin://resourceid/")) {
            C4990ab.m7416i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
            try {
                InputStream inputStream;
                dC = c46434d.mo15571dC(str, 1);
                if (C5046bo.isNullOrNil(dC)) {
                    C4990ab.m7412e("MicroMsg.WebviewJSSDKUtil", "local is is null or nil");
                    inputStream = null;
                } else {
                    inputStream = C43914ap.aeE(dC);
                }
                cXO = new C31147o("image/*", ProtocolPackage.ServerEncoding, inputStream);
                AppMethodBeat.m2505o(6740);
                return cXO;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", e.getMessage());
                AppMethodBeat.m2505o(6740);
                return null;
            }
        } else {
            String toLowerCase;
            if (z) {
                Object obj;
                if (!C5046bo.isNullOrNil(str) && C14525q.m22728Ed(str)) {
                    toLowerCase = str.toLowerCase();
                    if (toLowerCase.contains("localhost") || toLowerCase.contains("127.0.0.1") || toLowerCase.contains("::1") || toLowerCase.contains(C30152u.bOO())) {
                        if (this.umD != null && this.umD.size() > 0) {
                            for (Integer intValue : this.umD) {
                                int intValue2 = intValue.intValue();
                                if (!toLowerCase.contains("localhost:".concat(String.valueOf(intValue2)))) {
                                    if (toLowerCase.contains("127.0.0.1:".concat(String.valueOf(intValue2)))) {
                                    }
                                }
                                C4990ab.m7417i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", toLowerCase, Integer.valueOf(intValue2));
                            }
                        }
                        C4990ab.m7413e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", toLowerCase);
                        obj = 1;
                    }
                    obj = null;
                    break;
                }
                obj = null;
                if (obj != null) {
                    C4990ab.m7415f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", str);
                    cXO = new C31147o("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                    AppMethodBeat.m2505o(6740);
                    return cXO;
                }
            }
            if (m34734b(str, c46434d)) {
                C4990ab.m7413e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", str);
                cXO = new C31147o("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                AppMethodBeat.m2505o(6740);
                return cXO;
            }
            try {
                if (C22947f.isEnabled()) {
                    dC = C22947f.cZD();
                    Uri parse = Uri.parse(str);
                    String host = parse.getHost();
                    if (!(dC == null || host == null || !dC.equals(C4995ag.m7428ck(host + C6998b.oTO.mo8093TQ("\u0003&+21"))))) {
                        SharedPreferences sharedPreferences;
                        long j;
                        long currentTimeMillis;
                        Set queryParameterNames = parse.getQueryParameterNames();
                        if (queryParameterNames != null && queryParameterNames.contains(ApplicationInfo.class.getSimpleName().substring(2, 3))) {
                            C4990ab.m7420w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, something wicked this way comes.");
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7420w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
                            } else {
                                sharedPreferences = C4996ah.getContext().getSharedPreferences("qar_cycle_rec", 0);
                                toLowerCase = "qaj_tick_" + C4995ag.m7428ck(str);
                                j = sharedPreferences.getLong(toLowerCase, 0);
                                currentTimeMillis = System.currentTimeMillis();
                                if (currentTimeMillis - j > TimeUnit.HOURS.toMillis(24)) {
                                    sharedPreferences.edit().putLong(toLowerCase, currentTimeMillis).commit();
                                    C7053e.pXa.mo8376a(16195, str.replace(",", "%2C"), false, true);
                                    C7053e.pXa.mo8378a(943, 0, 1, false);
                                }
                            }
                        }
                        if (C22947f.bXm()) {
                            C4990ab.m7420w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, block is enabled.");
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7420w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
                            } else {
                                try {
                                    sharedPreferences = C4996ah.getContext().getSharedPreferences("qar_cycle_rec", 0);
                                    toLowerCase = "qab_tick_" + C4995ag.m7428ck(str);
                                    j = sharedPreferences.getLong(toLowerCase, 0);
                                    currentTimeMillis = System.currentTimeMillis();
                                    if (currentTimeMillis - j > TimeUnit.HOURS.toMillis(24)) {
                                        sharedPreferences.edit().putLong(toLowerCase, currentTimeMillis).commit();
                                        C7053e.pXa.mo8378a(943, 1, 1, false);
                                    }
                                } catch (Throwable th) {
                                    C4990ab.printErrStackTrace("MicroMsg.WebViewReporter", th, "", new Object[0]);
                                }
                            }
                            cXO = new C31147o("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
                            AppMethodBeat.m2505o(6740);
                            return cXO;
                        }
                    }
                }
            } catch (Throwable th2) {
            }
            AppMethodBeat.m2505o(6740);
            return null;
        }
    }

    /* renamed from: b */
    private boolean m34734b(String str, C46434d c46434d) {
        Iterator it;
        AppMethodBeat.m2504i(6741);
        if (this.umA == -1) {
            try {
                Bundle g = c46434d.mo15575g(31, null);
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
                    C4990ab.m7416i("MicroMsg.WebViewResourceInterrupter", stringBuilder.toString());
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", e.getMessage());
                this.umA = 0;
            }
        }
        if (this.umA == 0) {
            AppMethodBeat.m2505o(6741);
            return false;
        }
        String host = Uri.parse(str).getHost();
        C4990ab.m7411d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", host, this.umE.get(host));
        if (C5046bo.isNullOrNil(host)) {
            AppMethodBeat.m2505o(6741);
            return false;
        } else if (this.umE.containsKey(host)) {
            boolean booleanValue = ((Boolean) this.umE.get(host)).booleanValue();
            AppMethodBeat.m2505o(6741);
            return booleanValue;
        } else {
            String str2;
            if (this.umB != null && this.umB.size() > 0) {
                it = this.umB.iterator();
                while (it.hasNext()) {
                    str2 = (String) it.next();
                    if (!C5046bo.isNullOrNil(str2) && host.contains(str2)) {
                        this.umE.put(host, Boolean.FALSE);
                        C4990ab.m7416i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
                        AppMethodBeat.m2505o(6741);
                        return false;
                    }
                }
            }
            if (this.umC != null && this.umC.size() > 0) {
                it = this.umC.iterator();
                while (it.hasNext()) {
                    str2 = (String) it.next();
                    if (!C5046bo.isNullOrNil(str2) && host.contains(str2)) {
                        if (this.umA == 1) {
                            this.umE.put(host, Boolean.TRUE);
                            C4990ab.m7413e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", str2, str);
                            AppMethodBeat.m2505o(6741);
                            return true;
                        } else if (this.umA == 2) {
                            C4990ab.m7417i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", str2, str);
                            this.umF.add(host);
                            this.umE.put(host, Boolean.FALSE);
                            AppMethodBeat.m2505o(6741);
                            return false;
                        }
                    }
                }
            }
            this.umE.put(host, Boolean.FALSE);
            AppMethodBeat.m2505o(6741);
            return false;
        }
    }

    public final void aey(String str) {
        AppMethodBeat.m2504i(6742);
        this.umG = str;
        C4990ab.m7417i("MicroMsg.WebViewResourceInterrupter", "setDgtVerifyRandomStr, ranDomStr: %s, hashCode: %d", this.umG, Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(6742);
    }

    private C31147o cXO() {
        AppMethodBeat.m2504i(6743);
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_webview_can_pre_inject_jsbridge, 1) == 0) {
            C4990ab.m7417i("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, canPreInjectJsBridge: %d", Integer.valueOf(((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_webview_can_pre_inject_jsbridge, 1)));
            AppMethodBeat.m2505o(6743);
            return null;
        }
        if (this.mContext != null && (this.mContext instanceof WebViewUI)) {
            ((WebViewUI) this.mContext).uvG = false;
        }
        try {
            InputStream open;
            if (TextUtils.isEmpty(this.umG)) {
                open = C4996ah.getContext().getAssets().open("jsapi/wxjs.js");
            } else {
                open = new ByteArrayInputStream(new String(C31203c.toByteArray(C4996ah.getContext().getAssets().open("jsapi/wxjs.js"))).replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.umG).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true").getBytes("UTF-8"));
                C4990ab.m7417i("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, ranDomStr: %s, hashCode: %d", this.umG, Integer.valueOf(hashCode()));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
            hashMap.put("Pragma", "no-cache");
            hashMap.put("Expires", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            C31147o c31147o = new C31147o("application/javascript", ProtocolPackage.ServerEncoding, 200, "OK", hashMap, open);
            AppMethodBeat.m2505o(6743);
            return c31147o;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, failed, ", e);
            AppMethodBeat.m2505o(6743);
            return null;
        }
    }
}
