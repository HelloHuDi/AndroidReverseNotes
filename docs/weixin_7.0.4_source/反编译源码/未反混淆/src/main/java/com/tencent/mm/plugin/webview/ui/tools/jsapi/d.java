package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.xweb.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements c, b {
    private static final int uFn = (com.tencent.mm.compatible.util.d.fP(19) ? 200 : 20);
    public com.tencent.mm.plugin.webview.stub.d icy;
    public boolean ready = false;
    private final List<String> uFA = new LinkedList();
    volatile String uFB = null;
    volatile int uFC = 0;
    private JSONObject uFD = new JSONObject();
    private JSONArray uFE = new JSONArray();
    private List<String> uFF = new LinkedList();
    private ap uFG = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(8890);
            d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onBeaconsInRange", d.this.uFD, d.this.uFv, d.this.uFw) + ")", null);
            d.this.uFF.clear();
            d.this.uFD = new JSONObject();
            d.this.uFE = new JSONArray();
            AppMethodBeat.o(8890);
            return false;
        }
    }, false);
    public long uFH = 0;
    public MMWebView uFo;
    private final List<String> uFp = new LinkedList();
    private final LinkedList<i> uFq = new LinkedList();
    private ak uFr = null;
    Map<String, Object> uFs;
    public Map<String, Object> uFt;
    private k uFu;
    public boolean uFv = false;
    public String uFw = "";
    private Set<a> uFx;
    public String uFy;
    public String uFz;
    public String uqT;
    public int uqj;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$40 */
    public class AnonymousClass40 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass40(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8903);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8903);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8903);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$41 */
    public class AnonymousClass41 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass41(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8904);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8904);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8904);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$43 */
    public class AnonymousClass43 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass43(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8907);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8907);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8907);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$19 */
    public class AnonymousClass19 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass19(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8882);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8882);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onArticleReadingBtnClicked fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8882);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$22 */
    public class AnonymousClass22 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass22(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8885);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8885);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8885);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$38 */
    public class AnonymousClass38 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass38(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8901);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8901);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8901);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$61 */
    public class AnonymousClass61 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass61(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8925);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8925);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8925);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$6 */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass6(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8869);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8869);
            } catch (Exception e) {
                ab.w("MicroMsg.JsApiHandler", "onWXDeviceBluetoothStateChange, %s", e.getMessage());
                AppMethodBeat.o(8869);
            }
        }
    }

    public interface a {
        void onReady();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$11 */
    public class AnonymousClass11 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass11(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8874);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8874);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8874);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$18 */
    public class AnonymousClass18 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass18(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8881);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8881);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8881);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$57 */
    public class AnonymousClass57 implements Runnable {
        final /* synthetic */ String uFO;

        public AnonymousClass57(String str) {
            this.uFO = str;
        }

        public final void run() {
            AppMethodBeat.i(8921);
            try {
                d.this.uFo.evaluateJavascript(this.uFO, null);
                AppMethodBeat.o(8921);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8921);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass5(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8868);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8868);
            } catch (Exception e) {
                ab.w("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange, %s", e.getMessage());
                AppMethodBeat.o(8868);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$7 */
    public class AnonymousClass7 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass7(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8870);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8870);
            } catch (Exception e) {
                ab.w("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange, %s", e.getMessage());
                AppMethodBeat.o(8870);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$35 */
    public class AnonymousClass35 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass35(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8898);
            try {
                ab.d("MicroMsg.JsApiHandler", "onSearchHistoryReady %s", this.itc);
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8898);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8898);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$45 */
    public class AnonymousClass45 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass45(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8909);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8909);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8909);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$32 */
    public class AnonymousClass32 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass32(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8895);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8895);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8895);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass4(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8867);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8867);
            } catch (Exception e) {
                ab.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", e.getMessage());
                AppMethodBeat.o(8867);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$20 */
    public class AnonymousClass20 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass20(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8883);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8883);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onNfcTouch fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8883);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$63 */
    public class AnonymousClass63 implements Runnable {
        final /* synthetic */ String uFO;

        public AnonymousClass63(String str) {
            this.uFO = str;
        }

        public final void run() {
            AppMethodBeat.i(8927);
            try {
                if (d.this.uFo != null) {
                    d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uFO + ")", null);
                }
                AppMethodBeat.o(8927);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", e);
                AppMethodBeat.o(8927);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$64 */
    public class AnonymousClass64 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass64(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8928);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8928);
            } catch (Exception e) {
                AppMethodBeat.o(8928);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$59 */
    public class AnonymousClass59 implements Runnable {
        final /* synthetic */ String itc;

        public AnonymousClass59(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.i(8923);
            try {
                d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.o(8923);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", e.getMessage());
                AppMethodBeat.o(8923);
            }
        }
    }

    static /* synthetic */ boolean B(String str, Map map) {
        AppMethodBeat.i(9015);
        boolean A = A(str, map);
        AppMethodBeat.o(9015);
        return A;
    }

    static /* synthetic */ boolean hl(String str, String str2) {
        AppMethodBeat.i(9016);
        boolean hk = hk(str, str2);
        AppMethodBeat.o(9016);
        return hk;
    }

    static {
        AppMethodBeat.i(9017);
        AppMethodBeat.o(9017);
    }

    public d(MMWebView mMWebView, k kVar, Map<String, Object> map) {
        AppMethodBeat.i(8934);
        this.uFo = mMWebView;
        this.uFu = kVar;
        this.uFs = map;
        dcg();
        ab.i("MicroMsg.JsApiHandler", "JsApiHandler<init>, webview: %d, this: %d", Integer.valueOf(mMWebView.hashCode()), Integer.valueOf(hashCode()));
        AppMethodBeat.o(8934);
    }

    public d(MMWebView mMWebView, k kVar, Map<String, Object> map, com.tencent.mm.plugin.webview.stub.d dVar, int i) {
        AppMethodBeat.i(8935);
        this.uFo = mMWebView;
        this.uFu = kVar;
        this.icy = dVar;
        this.uFs = map;
        this.uqj = i;
        dcg();
        ab.i("MicroMsg.JsApiHandler", "JsApiHandler<init>, webview: %d, this: %d", Integer.valueOf(mMWebView.hashCode()), Integer.valueOf(hashCode()));
        AppMethodBeat.o(8935);
    }

    private void dcg() {
        AppMethodBeat.i(8936);
        this.uFr = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(8864);
                switch (message.what) {
                    case 1:
                        String str = (String) message.obj;
                        if (!bo.isNullOrNil(str)) {
                            d.this.uFp.add(str);
                        }
                        d.c(d.this);
                        AppMethodBeat.o(8864);
                        return;
                    case 2:
                        ab.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + message.obj);
                        break;
                }
                AppMethodBeat.o(8864);
            }
        };
        AppMethodBeat.o(8936);
    }

    public final void e(com.tencent.mm.plugin.webview.stub.d dVar) {
        this.icy = dVar;
    }

    public final void JJ(int i) {
        this.uqj = i;
    }

    public final void a(k kVar) {
        this.uFu = kVar;
    }

    public final void dch() {
        AppMethodBeat.i(8937);
        this.uFv = true;
        this.uFw = bo.Mb(16);
        ab.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", this.uFw, Integer.valueOf(hashCode()));
        AppMethodBeat.o(8937);
    }

    public final String dci() {
        return this.uFw;
    }

    public final void bJ(String str, boolean z) {
        AppMethodBeat.i(8938);
        try {
            this.icy.i(str, z, this.uqj);
            AppMethodBeat.o(8938);
        } catch (Exception e) {
            ab.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(e)));
            AppMethodBeat.o(8938);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        AppMethodBeat.i(8939);
        if (this.uFr != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            this.uFr.sendMessage(obtain);
        }
        AppMethodBeat.o(8939);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final boolean _isDgtVerifyEnabled() {
        return this.uFv;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String _getDgtVerifyRandomStr() {
        return this.uFw;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _ready(boolean z) {
        this.ready = z;
    }

    public final boolean afS(String str) {
        AppMethodBeat.i(8942);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8942);
            return false;
        }
        boolean t = u.t(str, "weixin://dispatch_message/");
        AppMethodBeat.o(8942);
        return t;
    }

    public final boolean afM(final String str) {
        AppMethodBeat.i(8943);
        this.uFo.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(8875);
                String str = (String) obj;
                ab.i("MicroMsg.JsApiHandler", "handle url %s, re %s", str, str);
                AppMethodBeat.o(8875);
            }
        });
        AppMethodBeat.o(8943);
        return true;
    }

    public final void aK(Map<String, Object> map) {
        AppMethodBeat.i(8944);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onPreloadWebViewInit success, ready");
            String str = "MicroMsg.JsApiHandler";
            String str2 = "onPreloadWebViewInit,params %s";
            Object[] objArr = new Object[1];
            objArr[0] = map == null ? "" : map.toString();
            ab.i(str, str2, objArr);
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onUiInit", map, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8908);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8908);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onPreloadWebViewInit fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8908);
                    }
                }
            });
            AppMethodBeat.o(8944);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onPreloadWebViewInit fail, not ready");
        AppMethodBeat.o(8944);
    }

    public final void nZ(boolean z) {
        AppMethodBeat.i(8945);
        this.ready = z;
        if (z && this.uFx != null) {
            for (a aVar : this.uFx) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
        }
        AppMethodBeat.o(8945);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(8946);
        if (this.uFx == null) {
            this.uFx = new HashSet();
        }
        this.uFx.add(aVar);
        AppMethodBeat.o(8946);
    }

    public final void dcj() {
        AppMethodBeat.i(8947);
        ab.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", Boolean.valueOf(this.ready));
        if (this.uFo != null && this.ready) {
            this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("sys:attach_runOn3rd_apis", dck(), this.uFv, this.uFw) + ")", new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(8919);
                    ab.i("MicroMsg.JsApiHandler", "sys:attach_runOn3rd_apis back %s\t", (String) obj);
                    AppMethodBeat.o(8919);
                }
            });
        }
        AppMethodBeat.o(8947);
    }

    private Map<String, Object> dck() {
        AppMethodBeat.i(8948);
        HashMap hashMap = new HashMap();
        JsapiPermissionWrapper cZS = this.uFu.cZS();
        LinkedList linkedList = new LinkedList();
        if (cZS != null) {
            if (cZS.jB(88)) {
                linkedList.add("menu:share:timeline");
            }
            if (cZS.jB(89)) {
                linkedList.add("menu:share:appmessage");
            }
            if (cZS.jB(94)) {
                linkedList.add("menu:share:qq");
            }
            if (cZS.jB(109)) {
                linkedList.add("menu:share:weiboApp");
            }
            if (cZS.jB(com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX)) {
                linkedList.add("menu:share:QZone");
            }
            if (cZS.jB(219)) {
                linkedList.add("sys:record");
            }
            linkedList.add("onVoiceRecordEnd");
            linkedList.add("onVoicePlayBegin");
            linkedList.add("onVoicePlayEnd");
            linkedList.add("onLocalImageUploadProgress");
            linkedList.add("onImageDownloadProgress");
            linkedList.add("onVoiceUploadProgress");
            linkedList.add("onVoiceDownloadProgress");
            linkedList.add("onVideoUploadProgress");
            linkedList.add("onMediaFileUploadProgress");
            linkedList.add("menu:setfont");
            linkedList.add("menu:haokan");
            linkedList.add("reportOnLeaveForMP");
            linkedList.add("menu:share:weibo");
            linkedList.add("menu:share:email");
            linkedList.add("wxdownload:state_change");
            linkedList.add("wxdownload:progress_change");
            linkedList.add("hdOnDeviceStateChanged");
            linkedList.add("activity:state_change");
            linkedList.add("onWXDeviceBluetoothStateChange");
            linkedList.add("onWXDeviceLanStateChange");
            linkedList.add("onWXDeviceBindStateChange");
            linkedList.add("onReceiveDataFromWXDevice");
            linkedList.add("onScanWXDeviceResult");
            linkedList.add("onWXDeviceStateChange");
            linkedList.add("onNfcTouch");
            linkedList.add("onBeaconMonitoring");
            linkedList.add("onBeaconsInRange");
            linkedList.add("menu:custom");
            linkedList.add("onSearchWAWidgetOpenApp");
            linkedList.add("onSearchDataReady");
            linkedList.add("onGetPoiInfoReturn");
            linkedList.add("onSearchHistoryReady");
            linkedList.add("onSearchWAWidgetOnTapCallback");
            linkedList.add("onSearchImageListReady");
            linkedList.add("onTeachSearchDataReady");
            linkedList.add("onSearchGuideDataReady");
            linkedList.add("onUxOplogDataReady");
            linkedList.add("onSearchInputChange");
            linkedList.add("onSearchInputConfirm");
            linkedList.add("onSearchSuggestionDataReady");
            linkedList.add("onMusicStatusChanged");
            linkedList.add("switchToTabSearch");
            linkedList.add("onVideoPlayerCallback");
            linkedList.add("onSelectContact");
            linkedList.add("onSearchWAWidgetAttrChanged");
            linkedList.add("onSearchWAWidgetReloadData");
            linkedList.add("onSearchWAWidgetReloadDataFinish");
            linkedList.add("onSearchWAWidgetStateChange");
            linkedList.add("onSearchWAWidgetDataPush");
            linkedList.add("onPullDownRefresh");
            linkedList.add("onPageStateChange");
            linkedList.add("onGetKeyboardHeight");
            linkedList.add("onGetSmiley");
            linkedList.add("onAddShortcutStatus");
            linkedList.add("onFocusSearchInput");
            linkedList.add("onGetA8KeyUrl");
            linkedList.add("deleteAccountSuccess");
            linkedList.add("onGetMsgProofItems");
            linkedList.add("WNJSHandlerInsert");
            linkedList.add("WNJSHandlerMultiInsert");
            linkedList.add("WNJSHandlerExportData");
            linkedList.add("WNJSHandlerHeaderAndFooterChange");
            linkedList.add("WNJSHandlerEditableChange");
            linkedList.add("WNJSHandlerEditingChange");
            linkedList.add("WNJSHandlerSaveSelectionRange");
            linkedList.add("WNJSHandlerLoadSelectionRange");
            linkedList.add("onCustomGameMenuClicked");
            linkedList.add("showLoading");
            linkedList.add("getSearchEmotionDataCallBack");
            linkedList.add("onNavigationBarRightButtonClick");
            linkedList.add("onSearchActionSheetClick");
            linkedList.add("onGetMatchContactList");
            linkedList.add("onUiInit");
            linkedList.add("onNetWorkChange");
            linkedList.add("onMiniProgramData");
            linkedList.add("onBackgroundAudioStateChange");
            linkedList.add("onArticleReadingBtnClicked");
            if (!bo.ek(null)) {
                linkedList.addAll(null);
            }
            linkedList.add("onReceivePageData");
            linkedList.add("onPageAuthOK");
            linkedList.add("onScrollViewDidScroll");
        }
        hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
        AppMethodBeat.o(8948);
        return hashMap;
    }

    private void dcl() {
        AppMethodBeat.i(8949);
        do {
        } while (dcm());
        AppMethodBeat.o(8949);
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x042e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean dcm() {
        AppMethodBeat.i(8950);
        if (bo.ek(this.uFq)) {
            ab.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
            AppMethodBeat.o(8950);
            return false;
        }
        boolean Jb;
        try {
            Jb = this.icy.Jb(this.uqj);
        } catch (Exception e) {
            ab.w("MicroMsg.JsApiHandler", "isBusy, ex = " + e.getMessage());
            Jb = false;
        }
        ab.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(Jb)));
        if (Jb) {
            ab.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
            AppMethodBeat.o(8950);
            return false;
        } else if (this.uFq.size() == 0) {
            ab.w("MicroMsg.JsApiHandler", "msgList size is 0.");
            AppMethodBeat.o(8950);
            return false;
        } else {
            i iVar = (i) this.uFq.remove(0);
            if (iVar == null) {
                ab.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
                AppMethodBeat.o(8950);
                return true;
            } else if (iVar.uIJ == null || iVar.puc == null || iVar.type == null || this.uFo == null) {
                ab.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + iVar.uIJ + ", params = " + iVar.puc + ", type = " + iVar.type + ", wv = " + this.uFo);
                AppMethodBeat.o(8950);
                return true;
            } else {
                if (!(this.uFt == null || this.uFt.get("srcUsername") == null || bo.isNullOrNil(this.uFt.get("srcUsername").toString()))) {
                    iVar.puc.put("src_username", this.uFt.get("srcUsername").toString());
                }
                if (!(this.uFt == null || this.uFt.get("srcDisplayname") == null || bo.isNullOrNil(this.uFt.get("srcDisplayname").toString()))) {
                    iVar.puc.put("src_displayname", this.uFt.get("srcDisplayname").toString());
                }
                if (!(this.uFt == null || this.uFt.get("KTemplateId") == null || bo.isNullOrNil(this.uFt.get("KTemplateId").toString()))) {
                    iVar.puc.put("tempalate_id", this.uFt.get("KTemplateId").toString());
                }
                if (this.uFt != null) {
                    iVar.puc.put("message_id", this.uFt.get("message_id"));
                    iVar.puc.put("message_index", this.uFt.get("message_index"));
                    iVar.puc.put("webview_scene", this.uFt.get("scene"));
                    iVar.puc.put("pay_channel", this.uFt.get("pay_channel"));
                    iVar.puc.put("pay_scene", this.uFt.get("pay_scene"));
                    ab.i("MicroMsg.JsApiHandler", "getPackageName %s", this.uFt.get("pay_package"));
                    if (this.uFt.get("pay_package") != null) {
                        iVar.puc.put("pay_packageName", this.uFt.get("pay_package"));
                    }
                    iVar.puc.put("stastic_scene", this.uFt.get("stastic_scene"));
                    iVar.puc.put("open_from_scene", this.uFt.get("from_scence"));
                    Bundle bundle = new Bundle();
                    bundle.putString("__jsapi_fw_ext_info_key_current_url", this.uFo.getUrl());
                    iVar.puc.put("__jsapi_fw_ext_info", bundle);
                }
                if (!(iVar.uIJ.equals("shareWeibo") || iVar.uIJ.equals("openUrlByExtBrowser") || iVar.uIJ.equals("openUrlWithExtraWebview") || iVar.uIJ.equals("openCustomWebview") || iVar.uIJ.equals("openGameWebView") || iVar.uIJ.equals("addToEmoticon") || iVar.uIJ.equals("shareEmoticon") || iVar.uIJ.equals("openGameUrlWithExtraWebView") || iVar.uIJ.equals(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID))) {
                    iVar.puc.put("url", this.uFo.getUrl());
                    ab.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl:" + this.uFo.getUrl());
                }
                if (iVar.uIJ.equalsIgnoreCase("openDesignerEmojiView") || iVar.uIJ.equalsIgnoreCase("openEmotionDetailViewLocal") || iVar.uIJ.equalsIgnoreCase("openDesignerEmojiView") || iVar.uIJ.equalsIgnoreCase("openDesignerEmojiViewLocal") || iVar.uIJ.equalsIgnoreCase("openDesignerEmojiView") || iVar.uIJ.equalsIgnoreCase("openDesignerProfile") || iVar.uIJ.equalsIgnoreCase("openDesignerProfileLocal") || iVar.uIJ.equalsIgnoreCase("getSearchEmotionData")) {
                    iVar.puc.put("searchID", Long.valueOf(dcp()));
                    ab.d("MicroMsg.JsApiHandler", "emoji search id:%d", Long.valueOf(dcp()));
                }
                if (iVar.uIJ.equals(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID)) {
                    iVar.puc.put("key_request_full_url_query", this.uFy);
                    iVar.puc.put("key_request_header", this.uFz);
                }
                try {
                    JsapiPermissionWrapper cZS = this.uFu.cZS();
                    Bundle bundle2 = new Bundle();
                    if (cZS != null) {
                        cZS.toBundle(bundle2);
                    }
                    Bundle aP = i.aP(iVar.puc);
                    if (!bo.isNullOrNil(this.uqT)) {
                        aP.putString("key_wxapp_id", this.uqT);
                    }
                    Bundle bundle3 = new Bundle(2);
                    bundle3.putBundle("compatParams", aP);
                    bundle3.putString("rawParams", iVar.uIH.toString());
                    if (!(this.icy == null || iVar == null)) {
                        GeneralControlWrapper cZT = this.uFu.cZT();
                        if (this.uFo == null || !(this.uFo.getContext() instanceof WebViewUI)) {
                            Jb = true;
                        } else {
                            if (!((WebViewUI) this.uFo.getContext()).uvG || cZT.dmj()) {
                                Jb = true;
                            } else {
                                ab.e("MicroMsg.JsApiHandler", "Can not call js api now, forbidJsApiExcuteNow:%b, canCallJsApiBeforeLoaded:%b", Boolean.valueOf(r0.uvG), Boolean.valueOf(cZT.dmj()));
                                Jb = false;
                            }
                        }
                        if (Jb) {
                            Jb = this.icy.a(iVar.type, iVar.uIJ, iVar.uIG, bundle2, bundle3, this.uqj);
                            j.cYL();
                            ab.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", iVar.uIJ, Boolean.valueOf(Jb));
                            if (Jb) {
                                AppMethodBeat.o(8950);
                                return true;
                            }
                            AppMethodBeat.o(8950);
                            return false;
                        }
                    }
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    ab.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + e2.getMessage());
                }
                Jb = false;
                j.cYL();
                ab.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", iVar.uIJ, Boolean.valueOf(Jb));
                if (Jb) {
                }
            }
        }
    }

    public final void detach() {
        AppMethodBeat.i(8951);
        this.ready = false;
        this.uFq.clear();
        this.uFp.clear();
        this.uFr = null;
        AppMethodBeat.o(8951);
    }

    public final void agl(String str) {
        this.uFy = str;
    }

    public final void agm(String str) {
        this.uFz = str;
    }

    public final void keep_setReturnValue(String str, String str2) {
        AppMethodBeat.i(8952);
        ab.i("MicroMsg.JsApiHandler", "setResultValue, scene = " + str + ", resultValue = " + str2);
        ab.i("MicroMsg.JsApiHandler", "edw setResultValue = threadId = " + Thread.currentThread().getId() + ", threadName = " + Thread.currentThread().getName());
        if (this.uFr != null) {
            Message obtain = Message.obtain();
            obtain.obj = str2;
            if (str.equals("SCENE_FETCHQUEUE")) {
                obtain.what = 1;
            } else if (str.equals("SCENE_HANDLEMSGFROMWX")) {
                obtain.what = 2;
            }
            this.uFr.sendMessage(obtain);
        }
        AppMethodBeat.o(8952);
    }

    public final void JK(int i) {
        AppMethodBeat.i(8953);
        if (this.ready) {
            HashMap hashMap = new HashMap();
            hashMap.put("fontSize", String.valueOf(i));
            this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("menu:setfont", hashMap, this.uFv, this.uFw) + ")", null);
            AppMethodBeat.o(8953);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
        AppMethodBeat.o(8953);
    }

    public final void bG(int i, String str) {
        AppMethodBeat.i(8954);
        if (this.ready) {
            HashMap hashMap = new HashMap();
            hashMap.put("recommend", Integer.valueOf(i));
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_COMMENT, str);
            this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("menu:haokan", hashMap, this.uFv, this.uFw) + ")", null);
            AppMethodBeat.o(8954);
            return;
        }
        AppMethodBeat.o(8954);
    }

    public final void q(HashMap<String, String> hashMap) {
        AppMethodBeat.i(8955);
        if (this.ready) {
            Bundle JL = JL(1);
            if (JL == null || !JL.getBoolean("WebViewShare_reslut", false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("scene", "friend");
                this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("menu:share:appmessage", hashMap2, this.uFv, this.uFw) + ")", null);
                try {
                    this.icy.L("scene", "friend", this.uqj);
                    AppMethodBeat.o(8955);
                    return;
                } catch (Exception e) {
                    ab.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                    AppMethodBeat.o(8955);
                    return;
                }
            }
            h(JL, "sendAppMessage");
            AppMethodBeat.o(8955);
            return;
        }
        ab.w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
        h(aL(hashMap), "sendAppMessage");
        AppMethodBeat.o(8955);
    }

    public final Bundle JL(int i) {
        AppMethodBeat.i(8956);
        try {
            if (this.uFo == null) {
                AppMethodBeat.o(8956);
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("WebViewShare_type", i);
            bundle.putInt("WebViewShare_BinderID", this.uqj);
            bundle.putString("WebViewShare_wv_url", this.uFo.getUrl());
            bundle = this.icy.g(105, bundle);
            bundle.putBoolean("use_update_jsapi_data", true);
            AppMethodBeat.o(8956);
            return bundle;
        } catch (RemoteException e) {
            ab.e("MicroMsg.JsApiHandler", "getShareData err %s", e.getMessage());
            AppMethodBeat.o(8956);
            return null;
        }
    }

    public final Bundle aL(Map<String, String> map) {
        String title;
        AppMethodBeat.i(8957);
        Bundle bundle = new Bundle();
        String url = this.uFo.getUrl();
        if (map != null) {
            String str;
            String str2 = (String) map.get("share_report_pre_msg_url");
            if (bo.isNullOrNil(str2)) {
                str = url;
            } else {
                str = str2;
            }
            str2 = (String) map.get("share_report_pre_msg_title");
            if (bo.isNullOrNil(str2)) {
                title = this.uFo.getTitle();
            } else {
                title = str2;
            }
            str2 = (String) map.get("share_report_pre_msg_desc");
            if (bo.isNullOrNil(str2)) {
                str2 = url;
            }
            bundle.putString("link", str);
            bundle.putString("desc", str2);
            bundle.putString("img_url", bo.nullAsNil((String) map.get("share_report_pre_msg_icon_url")));
        } else {
            title = this.uFo.getTitle();
            bundle.putString("link", url);
            bundle.putString("desc", url);
            bundle.putString("img_url", "");
        }
        if (!bo.isNullOrNil(title)) {
            url = title;
        } else if (bo.isNullOrNil(url)) {
            url = ah.getContext().getString(R.string.fyo);
        } else {
            Uri parse = Uri.parse(url);
            if (parse.getHost() != null) {
                url = parse.getHost();
            }
        }
        bundle.putString("title", url);
        bundle.putBoolean("use_update_jsapi_data", false);
        AppMethodBeat.o(8957);
        return bundle;
    }

    public final void h(final Bundle bundle, final String str) {
        AppMethodBeat.i(8958);
        if (bundle == null) {
            ab.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
            AppMethodBeat.o(8958);
            return;
        }
        if (this.uFr != null) {
            this.uFr.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8932);
                    i iVar = new i();
                    iVar.puc = new HashMap();
                    iVar.puc.put("link", bundle.getString("link"));
                    iVar.puc.put("title", bundle.getString("title"));
                    iVar.puc.put("desc", bundle.getString("desc"));
                    iVar.uIH = new JSONObject();
                    iVar.puc.put("img_url", bundle.getString("img_url"));
                    iVar.puc.put("use_update_jsapi_data", Boolean.valueOf(bundle.getBoolean("use_update_jsapi_data")));
                    iVar.type = "call";
                    iVar.uIG = "";
                    iVar.uIJ = str;
                    d.this.uFq.add(iVar);
                    d.f(d.this);
                    AppMethodBeat.o(8932);
                }
            });
        }
        AppMethodBeat.o(8958);
    }

    public final void i(Bundle bundle, String str) {
        AppMethodBeat.i(8959);
        if (!this.ready || bundle == null) {
            ab.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
            AppMethodBeat.o(8959);
            return;
        }
        long j = bundle.getLong("download_manager_downloadid");
        String string = bundle.getString("download_manager_appid", "");
        int i = bundle.getInt("download_manager_errcode");
        ab.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + j + ", state = " + str + ", errCode = " + i);
        HashMap hashMap = new HashMap();
        hashMap.put("appid", string);
        hashMap.put("download_id", Long.valueOf(j));
        hashMap.put("err_code", Integer.valueOf(i));
        hashMap.put("state", str);
        final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("wxdownload:state_change", hashMap, this.uFv, this.uFw);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8933);
                try {
                    d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.o(8933);
                } catch (Exception e) {
                    ab.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", e.getMessage());
                    AppMethodBeat.o(8933);
                }
            }
        });
        AppMethodBeat.o(8959);
    }

    public final void n(String str, long j, int i) {
        AppMethodBeat.i(8960);
        if (this.ready) {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", str);
            hashMap.put("download_id", Long.valueOf(j));
            hashMap.put("progress", Integer.valueOf(i));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("wxdownload:progress_change", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8865);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8865);
                    } catch (Exception e) {
                        ab.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", e.getMessage());
                        AppMethodBeat.o(8865);
                    }
                }
            });
            AppMethodBeat.o(8960);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
        AppMethodBeat.o(8960);
    }

    public final void dG(String str, int i) {
        AppMethodBeat.i(8961);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", str, Integer.valueOf(i));
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.JsApiHandler", "parameter error!!!");
                AppMethodBeat.o(8961);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("deviceId", str);
            if (i == 2) {
                hashMap.put("state", "connected");
            } else if (i == 1) {
                hashMap.put("state", "connecting");
            } else {
                hashMap.put("state", "disconnected");
            }
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onWXDeviceStateChange", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8866);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8866);
                    } catch (Exception e) {
                        ab.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", e.getMessage());
                        AppMethodBeat.o(8866);
                    }
                }
            });
            AppMethodBeat.o(8961);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
        AppMethodBeat.o(8961);
    }

    public final void agn(String str) {
        AppMethodBeat.i(8962);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = ".concat(String.valueOf(str)));
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("activity:state_change", hashMap, this.uFv, this.uFw);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                try {
                    this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.o(8962);
                    return;
                } catch (Exception e) {
                    ab.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", e.getMessage());
                    AppMethodBeat.o(8962);
                    return;
                }
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8871);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8871);
                    } catch (Exception e) {
                        ab.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", e.getMessage());
                        AppMethodBeat.o(8871);
                    }
                }
            });
            AppMethodBeat.o(8962);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready");
        AppMethodBeat.o(8962);
    }

    public final void aM(Map<String, Object> map) {
        AppMethodBeat.i(8963);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onVoicePlayEnd", map, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8872);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8872);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8872);
                    }
                }
            });
            AppMethodBeat.o(8963);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
        AppMethodBeat.o(8963);
    }

    public final void aN(Map<String, Object> map) {
        AppMethodBeat.i(8964);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onVoiceRecordEnd", map, this.uFv, this.uFw);
            ab.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", b);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8873);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8873);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8873);
                    }
                }
            });
            AppMethodBeat.o(8964);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
        AppMethodBeat.o(8964);
    }

    public final void dH(String str, int i) {
        AppMethodBeat.i(8965);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onImageUploadProgress", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8876);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8876);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8876);
                    }
                }
            });
            AppMethodBeat.o(8965);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
        AppMethodBeat.o(8965);
    }

    public final void dI(String str, int i) {
        AppMethodBeat.i(8966);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", str, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onImageDownloadProgress", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8877);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8877);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8877);
                    }
                }
            });
            AppMethodBeat.o(8966);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
        AppMethodBeat.o(8966);
    }

    public final void dJ(String str, int i) {
        AppMethodBeat.i(8967);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onVoiceUploadProgress", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8878);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8878);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8878);
                    }
                }
            });
            AppMethodBeat.o(8967);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
        AppMethodBeat.o(8967);
    }

    public final void dK(String str, int i) {
        AppMethodBeat.i(8968);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", str, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onVoiceDownloadProgress", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8879);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8879);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8879);
                    }
                }
            });
            AppMethodBeat.o(8968);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
        AppMethodBeat.o(8968);
    }

    public final void dL(String str, int i) {
        AppMethodBeat.i(8969);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onVideoUploadProgress", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8880);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8880);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8880);
                    }
                }
            });
            AppMethodBeat.o(8969);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
        AppMethodBeat.o(8969);
    }

    public final void ago(String str) {
        AppMethodBeat.i(8970);
        try {
            Bundle bundle = new Bundle();
            JsapiPermissionWrapper cZS = this.uFu.cZS();
            if (cZS != null) {
                cZS.toBundle(bundle);
            }
            this.icy.a(str, bundle, this.uqj);
            AppMethodBeat.o(8970);
        } catch (Exception e) {
            ab.w("MicroMsg.JsApiHandler", "doProfile, ex = " + e.getMessage());
            AppMethodBeat.o(8970);
        }
    }

    public final void JM(int i) {
        AppMethodBeat.i(8971);
        HashMap hashMap = new HashMap();
        hashMap.put("height", Integer.valueOf(com.tencent.mm.bz.a.ao(ah.getContext(), i)));
        final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onGetKeyboardHeight", hashMap, this.uFv, this.uFw);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8884);
                try {
                    d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.o(8884);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", e.getMessage());
                    AppMethodBeat.o(8884);
                }
            }
        });
        AppMethodBeat.o(8971);
    }

    public final void oa(boolean z) {
        AppMethodBeat.i(8972);
        HashMap hashMap = new HashMap();
        hashMap.put("success", Boolean.valueOf(z));
        final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onAddShortcutStatus", hashMap, this.uFv, this.uFw);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8887);
                try {
                    d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.o(8887);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", e.getMessage());
                    AppMethodBeat.o(8887);
                }
            }
        });
        AppMethodBeat.o(8972);
    }

    public final void agp(String str) {
        AppMethodBeat.i(8973);
        HashMap hashMap = new HashMap();
        hashMap.put("err_msg", str);
        final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onBeaconMonitoring", hashMap, this.uFv, this.uFw);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8888);
                try {
                    d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.o(8888);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", e.getMessage());
                    AppMethodBeat.o(8888);
                }
            }
        });
        AppMethodBeat.o(8973);
    }

    public final void z(final String str, final Map<String, String> map) {
        AppMethodBeat.i(8974);
        ab.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8974);
            return;
        }
        this.uFB = str;
        if (map == null || map.size() == 0) {
            this.uFC = 0;
        } else {
            this.uFC = 1;
        }
        final String dM = dM(str, this.uFC);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8889);
                try {
                    if (!(map == null || map.size() == 0)) {
                        com.tencent.xweb.c.jx(ah.getContext());
                        b dTR = b.dTR();
                        for (String str : map.keySet()) {
                            dTR.setCookie(bo.anB(str), str + "=" + ((String) map.get(str)));
                        }
                        dTR.setCookie(bo.anB(str), "httponly");
                        com.tencent.xweb.c.dTT();
                        com.tencent.xweb.c.sync();
                        ab.i("MicroMsg.JsApiHandler", "cookies:%s", dTR.getCookie(bo.anB(str)));
                    }
                    d.this.uFo.evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[]{str}), null);
                    d.this.uFo.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                    if (d.this.ready) {
                        d.this.uFo.evaluateJavascript(dM, null);
                        d.this.uFB = null;
                        d.this.uFC = 0;
                    }
                    AppMethodBeat.o(8889);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", e.getMessage());
                    AppMethodBeat.o(8889);
                }
            }
        });
        AppMethodBeat.o(8974);
    }

    /* Access modifiers changed, original: final */
    public final String dM(String str, int i) {
        AppMethodBeat.i(8975);
        HashMap hashMap = new HashMap(2);
        hashMap.put("url", str);
        hashMap.put("set_cookie", Integer.valueOf(i));
        String agr = agr(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onGetA8KeyUrl", hashMap, this.uFv, this.uFw));
        AppMethodBeat.o(8975);
        return agr;
    }

    public final synchronized void a(String str, int i, int i2, double d, double d2, float f) {
        int i3 = 1;
        synchronized (this) {
            AppMethodBeat.i(8976);
            if (this.uFG.doT()) {
                this.uFG.ae(1000, 1000);
            }
            JSONObject jSONObject = new JSONObject();
            if (d <= 0.0d || d >= 0.5d) {
                i3 = 0;
            }
            try {
                if (!this.uFF.contains(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2))) {
                    this.uFF.add(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2));
                    jSONObject.put("uuid", String.valueOf(str));
                    jSONObject.put("major", String.valueOf(i));
                    jSONObject.put("minor", String.valueOf(i2));
                    jSONObject.put("accuracy", String.valueOf(d));
                    jSONObject.put("rssi", String.valueOf(d2));
                    jSONObject.put("heading", String.valueOf(f));
                    jSONObject.put("proximity", String.valueOf(i3));
                    this.uFE.put(jSONObject);
                    this.uFD.put("beacons", this.uFE);
                    this.uFD.put("err_msg", "onBeaconsInRange:ok");
                }
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", e.getMessage());
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onBeaconsInRange", this.uFD, this.uFv, this.uFw);
            AppMethodBeat.o(8976);
        }
        return;
    }

    public final void a(String str, String str2, Map<String, Object> map, boolean z) {
        AppMethodBeat.i(8977);
        if (!bo.isNullOrNil(str)) {
            j(str, str2, map);
        }
        if (z) {
            cZc();
        }
        AppMethodBeat.o(8977);
    }

    public final void cZc() {
        AppMethodBeat.i(8978);
        if (this.uFr != null) {
            this.uFr.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8891);
                    d.f(d.this);
                    AppMethodBeat.o(8891);
                }
            });
        }
        AppMethodBeat.o(8978);
    }

    public final void cZb() {
        AppMethodBeat.i(8979);
        if (this.uFq != null) {
            this.uFq.clear();
        }
        AppMethodBeat.o(8979);
    }

    private void j(String str, String str2, Map<String, Object> map) {
        AppMethodBeat.i(8980);
        if (str2 == null || str2.length() == 0 || str == null) {
            ab.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(str2)));
            AppMethodBeat.o(8980);
        } else if (this.ready) {
            Map hashMap = new HashMap();
            hashMap.put("err_msg", str2);
            if (map != null && map.size() > 0) {
                ab.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + map.size());
                hashMap.putAll(map);
            }
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(str, hashMap, this.uFv, this.uFw);
            ab.i("MicroMsg.JsApiHandler", "doCallback, ret = " + str2 + ", cb = " + a);
            if (!(a == null || this.uFo == null)) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8892);
                        try {
                            d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                            AppMethodBeat.o(8892);
                        } catch (Exception e) {
                            ab.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", e.getMessage());
                            AppMethodBeat.o(8892);
                        }
                    }
                });
            }
            AppMethodBeat.o(8980);
        } else {
            ab.e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
            AppMethodBeat.o(8980);
        }
    }

    public final void aO(Map<String, Object> map) {
        AppMethodBeat.i(8981);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSelectContact", map, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8893);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8893);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8893);
                    }
                }
            });
            AppMethodBeat.o(8981);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
        AppMethodBeat.o(8981);
    }

    public final void gA(int i, int i2) {
        AppMethodBeat.i(8982);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put(FirebaseAnalytics.b.INDEX, Integer.valueOf(i));
            hashMap.put("actionSheetId", Integer.valueOf(i2));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchActionSheetClick", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8894);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8894);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8894);
                    }
                }
            });
            AppMethodBeat.o(8982);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
        AppMethodBeat.o(8982);
    }

    public final void aP(JSONObject jSONObject) {
        AppMethodBeat.i(8983);
        final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onGetMatchContactList", jSONObject, this.uFv, this.uFw);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8897);
                try {
                    d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    AppMethodBeat.o(8897);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiHandler", "onGetMatchContactList fail, ex = %s", e.getMessage());
                    AppMethodBeat.o(8897);
                }
            }
        });
        AppMethodBeat.o(8983);
    }

    public final void h(String str, boolean z, String str2) {
        AppMethodBeat.i(8984);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("json", str);
            hashMap.put("newQuery", Boolean.valueOf(z));
            hashMap.put("requestId", str2);
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchDataReady", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8899);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8899);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8899);
                    }
                }
            });
            AppMethodBeat.o(8984);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
        AppMethodBeat.o(8984);
    }

    public final void ap(Bundle bundle) {
        AppMethodBeat.i(8985);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("json", bundle.getString("json"));
            hashMap.put("searchId", bundle.getString("searchId"));
            hashMap.put("poiId", bundle.getString("poiId"));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onGetPoiInfoReturn", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8900);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8900);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onGetPoiInfoReturn fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8900);
                    }
                }
            });
            AppMethodBeat.o(8985);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
        AppMethodBeat.o(8985);
    }

    public final void a(String str, boolean z, String str2, String str3) {
        AppMethodBeat.i(8986);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("eventId", str);
            hashMap.put("widgetId", str3);
            hashMap.put("hitTest", Boolean.valueOf(z));
            hashMap.put("err_msg", str2);
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchWAWidgetOnTapCallback", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8902);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8902);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8902);
                    }
                }
            });
            AppMethodBeat.o(8986);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
        AppMethodBeat.o(8986);
    }

    public final void hj(String str, String str2) {
        AppMethodBeat.i(8987);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("data", str2);
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchWAWidgetReloadDataFinish", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8906);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", new ValueCallback<String>() {
                            public final /* synthetic */ void onReceiveValue(Object obj) {
                                AppMethodBeat.i(8905);
                                ab.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish back %s", (String) obj);
                                AppMethodBeat.o(8905);
                            }
                        });
                        AppMethodBeat.o(8906);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8906);
                    }
                }
            });
            AppMethodBeat.o(8987);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
        AppMethodBeat.o(8987);
    }

    public final void a(String str, String str2, JSONArray jSONArray, int i) {
        AppMethodBeat.i(8988);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", str, str2, jSONArray.toString());
            HashMap hashMap = new HashMap();
            hashMap.put(SearchIntents.EXTRA_QUERY, str);
            hashMap.put("custom", str2);
            hashMap.put("tagList", jSONArray);
            hashMap.put("isCancelButtonClick", Integer.valueOf(i));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchInputChange", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8910);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8910);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8910);
                    }
                }
            });
            AppMethodBeat.o(8988);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
        AppMethodBeat.o(8988);
    }

    public final void a(String str, String str2, JSONArray jSONArray) {
        AppMethodBeat.i(8989);
        Map hashMap = new HashMap();
        hashMap.put(SearchIntents.EXTRA_QUERY, str);
        hashMap.put("custom", str2);
        hashMap.put("tagList", jSONArray);
        a("onSearchInputChange", hashMap, null);
        AppMethodBeat.o(8989);
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
        AppMethodBeat.i(8990);
        JSONObject jSONObject = new JSONObject();
        try {
            for (Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
        }
        try {
            jSONObject.put("scene", str);
            jSONObject.put("type", str2);
            jSONObject.put("isSug", str3);
            jSONObject.put("isLocalSug", str4);
            jSONObject.put("sessionId", str5);
        } catch (JSONException e2) {
            ab.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
        }
        a("switchToTabSearch", null, jSONObject);
        AppMethodBeat.o(8990);
        return true;
    }

    public final void a(final String str, Map<String, Object> map, JSONObject jSONObject) {
        AppMethodBeat.i(8991);
        if (!this.ready || (map == null && jSONObject == null)) {
            ab.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", str);
            AppMethodBeat.o(8991);
            return;
        }
        String b;
        String str2 = "MicroMsg.JsApiHandler";
        String str3 = "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = map == null ? "" : map.toString();
        objArr[2] = jSONObject == null ? "" : jSONObject.toString();
        ab.i(str2, str3, objArr);
        if (map != null) {
            b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b(str, map, this.uFv, this.uFw);
        } else {
            b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(str, jSONObject, this.uFv, this.uFw);
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8911);
                try {
                    d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.o(8911);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", str, e.getMessage());
                    AppMethodBeat.o(8911);
                }
            }
        });
        AppMethodBeat.o(8991);
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, JSONArray jSONArray, String str8, int i, Map<String, Object> map) {
        AppMethodBeat.i(8992);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "switchToTabSearch success, ready %s %s %s %s %s", str, str2, str3, str4, str5);
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                        } catch (JSONException e) {
                            Throwable th = e;
                            try {
                                jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                            } catch (JSONException e2) {
                                try {
                                    jSONObject.put((String) entry.getKey(), entry.getValue());
                                } catch (JSONException e3) {
                                    ab.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                                }
                            }
                        }
                    }
                }
            }
            try {
                jSONObject.put("type", str);
                jSONObject.put("isMostSearchBiz", str2);
                jSONObject.put("isSug", str3);
                jSONObject.put("isLocalSug", str5);
                jSONObject.put("scene", str4);
                jSONObject.put(SearchIntents.EXTRA_QUERY, str6);
                jSONObject.put("custom", str7);
                jSONObject.put("tagList", jSONArray);
                jSONObject.put("isBackButtonClick", 0);
                jSONObject.put("sugId", str8);
                jSONObject.put("sugClickType", i);
            } catch (JSONException e4) {
                ab.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            }
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("switchToTabSearch", jSONObject, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8912);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                        AppMethodBeat.o(8912);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8912);
                    }
                }
            });
            AppMethodBeat.o(8992);
            return true;
        }
        ab.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, not ready");
        AppMethodBeat.o(8992);
        return false;
    }

    public final void a(String str, String str2, JSONArray jSONArray, int i, Map<String, Object> map) {
        AppMethodBeat.i(8993);
        a(str, str2, jSONArray, i, "", (Map) map);
        AppMethodBeat.o(8993);
    }

    private void a(String str, String str2, JSONArray jSONArray, int i, String str3, Map<String, Object> map) {
        AppMethodBeat.i(8994);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", str, str2, jSONArray.toString());
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                        } catch (JSONException e) {
                            Throwable th = e;
                            try {
                                jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                            } catch (JSONException e2) {
                                try {
                                    jSONObject.put((String) entry.getKey(), entry.getValue());
                                } catch (JSONException e3) {
                                    ab.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                                }
                            }
                        }
                    }
                }
            }
            try {
                jSONObject.put(SearchIntents.EXTRA_QUERY, str);
                jSONObject.put("custom", str2);
                jSONObject.put("tagList", jSONArray);
                jSONObject.put("isBackButtonClick", i);
                jSONObject.put("sugId", str3);
                jSONObject.put("sugClickType", 0);
            } catch (JSONException e4) {
                ab.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            }
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchInputConfirm", jSONObject, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8913);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                        AppMethodBeat.o(8913);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8913);
                    }
                }
            });
            AppMethodBeat.o(8994);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
        AppMethodBeat.o(8994);
    }

    public final void agq(String str) {
        AppMethodBeat.i(8995);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("json", str);
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchSuggestionDataReady", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8914);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8914);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8914);
                    }
                }
            });
            AppMethodBeat.o(8995);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
        AppMethodBeat.o(8995);
    }

    public final void bH(int i, String str) {
        AppMethodBeat.i(8996);
        if (this.ready) {
            HashMap hashMap = new HashMap();
            hashMap.put("ret", Integer.valueOf(i));
            hashMap.put("data", str);
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchImageListReady", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8915);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8915);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8915);
                    }
                }
            });
            AppMethodBeat.o(8996);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
        AppMethodBeat.o(8996);
    }

    public final void n(int i, String str, int i2) {
        AppMethodBeat.i(8997);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("requestType", Integer.valueOf(i));
            hashMap.put("json", str);
            hashMap.put("isCacheData", Integer.valueOf(i2));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onTeachSearchDataReady", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8916);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8916);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8916);
                    }
                }
            });
            AppMethodBeat.o(8997);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
        AppMethodBeat.o(8997);
    }

    public final void m(String str, int i, int i2, int i3) {
        AppMethodBeat.i(8998);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("json", str);
            hashMap.put("isCacheData", Integer.valueOf(i));
            hashMap.put("isExpired", Integer.valueOf(i2));
            hashMap.put("isPreload", Integer.valueOf(i3));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchGuideDataReady", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8917);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8917);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8917);
                    }
                }
            });
            AppMethodBeat.o(8998);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
        AppMethodBeat.o(8998);
    }

    public final void a(int i, long j, String str) {
        AppMethodBeat.i(8999);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onUxOplogDataReady success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("ret", Integer.valueOf(i));
            hashMap.put("reqId", Long.valueOf(j));
            hashMap.put("json", str);
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onUxOplogDataReady", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8918);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8918);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8918);
                    }
                }
            });
            AppMethodBeat.o(8999);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
        AppMethodBeat.o(8999);
    }

    public final void dN(String str, int i) {
        AppMethodBeat.i(9000);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("snsid", str);
            hashMap.put("status", Integer.valueOf(i));
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onMusicStatusChanged", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8920);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8920);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8920);
                    }
                }
            });
            AppMethodBeat.o(9000);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
        AppMethodBeat.o(9000);
    }

    public static String agr(String str) {
        AppMethodBeat.i(9001);
        String format = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[]{bo.nullAsNil(str)});
        AppMethodBeat.o(9001);
        return format;
    }

    public final void nN(boolean z) {
        AppMethodBeat.i(9002);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", Boolean.valueOf(z));
            HashMap hashMap = new HashMap();
            hashMap.put("active", String.valueOf(z));
            final String agr = agr(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onPageStateChange", hashMap, this.uFv, this.uFw));
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8922);
                    try {
                        d.this.uFo.evaluateJavascript(agr, null);
                        AppMethodBeat.o(8922);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8922);
                    }
                }
            });
            AppMethodBeat.o(9002);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
        AppMethodBeat.o(9002);
    }

    public final void ob(boolean z) {
        AppMethodBeat.i(9003);
        ab.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", Boolean.valueOf(this.ready));
        if (!(this.uFo == null || this.icy == null || !this.ready)) {
            if (z) {
                this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("sys:get_html_content", new HashMap(), this.uFv, this.uFw) + ")", null);
                AppMethodBeat.o(9003);
                return;
            }
            List cZq;
            try {
                cZq = this.icy.cZq();
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                cZq = null;
            }
            Uri parse = Uri.parse(this.uFo.getUrl());
            if (parse != null) {
                ab.d("MicroMsg.JsApiHandler", "wv hijack url host" + parse.getHost());
            }
            if (!(cZq == null || parse == null || !cZq.contains(parse.getHost()))) {
                this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("sys:get_html_content", new HashMap(), this.uFv, this.uFw) + ")", null);
            }
        }
        AppMethodBeat.o(9003);
    }

    public final void dcn() {
        AppMethodBeat.i(9004);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("needShow", Boolean.TRUE);
            final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("showLoading", hashMap, this.uFv, this.uFw);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8924);
                    try {
                        d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.o(8924);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", e.getMessage());
                        AppMethodBeat.o(8924);
                    }
                }
            });
            AppMethodBeat.o(9004);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
        AppMethodBeat.o(9004);
    }

    public final void ags(String str) {
        AppMethodBeat.i(9005);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(9005);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DownloadInfo.NETTYPE, str);
        final String b = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onNetWorkChange", hashMap, this.uFv, this.uFw);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8926);
                try {
                    d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.o(8926);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", e.getMessage());
                    AppMethodBeat.o(8926);
                }
            }
        });
        AppMethodBeat.o(9005);
    }

    public final void dco() {
        AppMethodBeat.i(9006);
        if (this.ready) {
            ab.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
            this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onNavigationBarRightButtonClick", new HashMap(), this.uFv, this.uFw) + ")", null);
            AppMethodBeat.o(9006);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
        AppMethodBeat.o(9006);
    }

    public final long dcp() {
        AppMethodBeat.i(9007);
        ab.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", Long.valueOf(this.uFH));
        long j = this.uFH;
        AppMethodBeat.o(9007);
        return j;
    }

    private String agt(String str) {
        AppMethodBeat.i(9008);
        String url = this.uFo.getUrl();
        try {
            ab.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", url, str, e.euU + n.getSHA1(url + str));
            AppMethodBeat.o(9008);
            return r0;
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(url)));
            ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
            AppMethodBeat.o(9008);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ff A:{SYNTHETIC, Splitter:B:39:0x00ff} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0098 A:{SYNTHETIC, Splitter:B:22:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ff A:{SYNTHETIC, Splitter:B:39:0x00ff} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean A(String str, Map<String, Integer> map) {
        Throwable e;
        AppMethodBeat.i(9009);
        if (bo.isNullOrNil(str) || map == null) {
            ab.w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            AppMethodBeat.o(9009);
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                ab.e("MicroMsg.JsApiHandler", "creating file failed, filePath is ".concat(String.valueOf(str)));
                ab.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                AppMethodBeat.o(9009);
                return false;
            }
        }
        OutputStream outputStream = null;
        OutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                for (String str2 : map.keySet()) {
                    bufferedOutputStream.write((((Integer) map.get(str2)).intValue() + " " + str2).getBytes());
                    bufferedOutputStream.write(13);
                    bufferedOutputStream.write(10);
                }
                bufferedOutputStream.flush();
                try {
                    bufferedOutputStream.close();
                } catch (IOException e22) {
                    ab.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                }
                ab.d("MicroMsg.JsApiHandler", "writeToFile ok! ".concat(String.valueOf(str)));
                AppMethodBeat.o(9009);
                return true;
            } catch (Exception e3) {
                e = e3;
                outputStream = bufferedOutputStream;
                try {
                    ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                    ab.w("MicroMsg.JsApiHandler", "write to file error");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e222) {
                            ab.printErrStackTrace("MicroMsg.JsApiHandler", e222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(9009);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    bufferedOutputStream = outputStream;
                    if (bufferedOutputStream != null) {
                    }
                    AppMethodBeat.o(9009);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e4) {
                        ab.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(9009);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
            ab.w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
            }
            AppMethodBeat.o(9009);
            return false;
        } catch (Throwable th3) {
            e = th3;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
            }
            AppMethodBeat.o(9009);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b2 A:{SYNTHETIC, Splitter:B:27:0x00b2} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ca A:{SYNTHETIC, Splitter:B:34:0x00ca} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean hk(String str, String str2) {
        Throwable e;
        AppMethodBeat.i(9010);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            AppMethodBeat.o(9010);
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                ab.e("MicroMsg.JsApiHandler", "creating file failed, filePath is ".concat(String.valueOf(str)));
                ab.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                AppMethodBeat.o(9010);
                return false;
            }
        }
        OutputStream outputStream = null;
        try {
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                outputStream = new FileOutputStream(str);
                outputStream.write(str2.getBytes());
                outputStream.write(13);
                outputStream.write(10);
                outputStream.flush();
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    ab.printErrStackTrace("MicroMsg.JsApiHandler", e3, "", new Object[0]);
                }
                ab.d("MicroMsg.JsApiHandler", "writeToFile ok! ".concat(String.valueOf(str)));
                AppMethodBeat.o(9010);
                return true;
            } catch (Exception e4) {
                e = e4;
                outputStream = bufferedOutputStream;
                try {
                    ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                    ab.w("MicroMsg.JsApiHandler", "write to file error");
                    if (outputStream != null) {
                    }
                    AppMethodBeat.o(9010);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e32) {
                            ab.printErrStackTrace("MicroMsg.JsApiHandler", e32, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(9010);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                outputStream = bufferedOutputStream;
                if (outputStream != null) {
                }
                AppMethodBeat.o(9010);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
            ab.w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e22) {
                    ab.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.o(9010);
            return false;
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(final String str) {
        AppMethodBeat.i(8940);
        if (str != null) {
            this.uFr.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8930);
                    Map M = d.M(str.split(","));
                    String a = d.a(d.this, "hosts");
                    if (!d.B(a, M)) {
                        ab.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
                    } else if (!(d.this.icy == null || d.this.uFo == null)) {
                        try {
                            d.this.icy.J(0, d.this.uFo.getUrl(), a);
                            AppMethodBeat.o(8930);
                            return;
                        } catch (RemoteException e) {
                            ab.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", e.getMessage());
                            AppMethodBeat.o(8930);
                            return;
                        }
                    }
                    AppMethodBeat.o(8930);
                }
            });
        }
        AppMethodBeat.o(8940);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(final String str) {
        AppMethodBeat.i(8941);
        if (str != null) {
            this.uFr.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8931);
                    String a = d.a(d.this, "html");
                    if (!d.hl(a, str)) {
                        ab.e("MicroMsg.JsApiHandler", "failed to write Html file");
                    } else if (!(d.this.icy == null || d.this.uFo == null)) {
                        try {
                            d.this.icy.J(1, d.this.uFo.getUrl(), a);
                            AppMethodBeat.o(8931);
                            return;
                        } catch (RemoteException e) {
                            ab.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", e.getMessage());
                            AppMethodBeat.o(8931);
                            return;
                        }
                    }
                    AppMethodBeat.o(8931);
                }
            });
        }
        AppMethodBeat.o(8941);
    }

    static /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(9011);
        if (dVar.uFp.size() <= 0) {
            ab.i("MicroMsg.JsApiHandler", "dealMsgQueue fail, resultValueList is empty");
            AppMethodBeat.o(9011);
            return;
        }
        ab.i("MicroMsg.JsApiHandler", "dealMsgQueue, pre msgList = " + dVar.uFq.size());
        List i = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.i((String) dVar.uFp.remove(0), dVar.uFv, dVar.uFw);
        if (!bo.ek(i)) {
            dVar.uFq.addAll(i);
            ab.i("MicroMsg.JsApiHandler", "now msg list size : %d", Integer.valueOf(dVar.uFq.size()));
        }
        ab.i("MicroMsg.JsApiHandler", "dealMsgQueue, post msgList = " + dVar.uFq.size());
        dVar.dcl();
        if (dVar.uFr != null) {
            dVar.uFr.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8929);
                    d.c(d.this);
                    AppMethodBeat.o(8929);
                }
            });
        }
        AppMethodBeat.o(9011);
    }

    static /* synthetic */ void f(d dVar) {
        AppMethodBeat.i(9012);
        do {
        } while (dVar.dcm());
        AppMethodBeat.o(9012);
    }

    static /* synthetic */ Map M(String[] strArr) {
        AppMethodBeat.i(9013);
        int length = strArr == null ? 0 : strArr.length;
        if (length == 0) {
            AppMethodBeat.o(9013);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < length; i++) {
            if (hashMap.keySet().contains(strArr[i])) {
                hashMap.put(strArr[i], Integer.valueOf(((Integer) hashMap.get(strArr[i])).intValue() + 1));
            } else {
                hashMap.put(strArr[i], Integer.valueOf(1));
            }
        }
        AppMethodBeat.o(9013);
        return hashMap;
    }
}
