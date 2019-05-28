package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C45137n;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.websearch.api.C46401c;
import com.tencent.p177mm.plugin.webview.modeltools.C46431j;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.xweb.C24526c;
import com.tencent.xweb.C44576b;
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

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d */
public final class C44786d implements C46401c, C43967b {
    private static final int uFn = (C1443d.m3067fP(19) ? 200 : 20);
    public C46434d icy;
    public boolean ready = false;
    private final List<String> uFA = new LinkedList();
    volatile String uFB = null;
    volatile int uFC = 0;
    private JSONObject uFD = new JSONObject();
    private JSONArray uFE = new JSONArray();
    private List<String> uFF = new LinkedList();
    private C7564ap uFG = new C7564ap(new C4397427(), false);
    public long uFH = 0;
    public MMWebView uFo;
    private final List<String> uFp = new LinkedList();
    private final LinkedList<C29945i> uFq = new LinkedList();
    private C7306ak uFr = null;
    Map<String, Object> uFs;
    public Map<String, Object> uFt;
    private C40344k uFu;
    public boolean uFv = false;
    public String uFw = "";
    private Set<C23001a> uFx;
    public String uFy;
    public String uFz;
    public String uqT;
    public int uqj;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$40 */
    public class C463040 implements Runnable {
        final /* synthetic */ String itc;

        public C463040(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8903);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8903);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8903);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$41 */
    public class C463141 implements Runnable {
        final /* synthetic */ String itc;

        public C463141(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8904);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8904);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8904);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$43 */
    public class C463443 implements Runnable {
        final /* synthetic */ String itc;

        public C463443(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8907);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8907);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8907);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$19 */
    public class C1462219 implements Runnable {
        final /* synthetic */ String itc;

        public C1462219(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8882);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8882);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onArticleReadingBtnClicked fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8882);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$55 */
    class C1462755 implements ValueCallback<String> {
        C1462755() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(8919);
            C4990ab.m7417i("MicroMsg.JsApiHandler", "sys:attach_runOn3rd_apis back %s\t", (String) obj);
            AppMethodBeat.m2505o(8919);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$22 */
    public class C2299122 implements Runnable {
        final /* synthetic */ String itc;

        public C2299122(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8885);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8885);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8885);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$23 */
    class C2299223 implements ValueCallback<String> {
        C2299223() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(8886);
            C4990ab.m7417i("MicroMsg.JsApiHandler", "sys:init back %s\t", (String) obj);
            AppMethodBeat.m2505o(8886);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$38 */
    public class C2299538 implements Runnable {
        final /* synthetic */ String itc;

        public C2299538(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8901);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8901);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8901);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$61 */
    public class C2299761 implements Runnable {
        final /* synthetic */ String itc;

        public C2299761(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8925);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8925);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8925);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$6 */
    public class C230006 implements Runnable {
        final /* synthetic */ String itc;

        public C230006(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8869);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8869);
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.JsApiHandler", "onWXDeviceBluetoothStateChange, %s", e.getMessage());
                AppMethodBeat.m2505o(8869);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$a */
    public interface C23001a {
        void onReady();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$11 */
    public class C2993611 implements Runnable {
        final /* synthetic */ String itc;

        public C2993611(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8874);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8874);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8874);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$18 */
    public class C2993718 implements Runnable {
        final /* synthetic */ String itc;

        public C2993718(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8881);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8881);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8881);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$57 */
    public class C2994057 implements Runnable {
        final /* synthetic */ String uFO;

        public C2994057(String str) {
            this.uFO = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8921);
            try {
                C44786d.this.uFo.evaluateJavascript(this.uFO, null);
                AppMethodBeat.m2505o(8921);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8921);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$5 */
    public class C299415 implements Runnable {
        final /* synthetic */ String itc;

        public C299415(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8868);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8868);
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange, %s", e.getMessage());
                AppMethodBeat.m2505o(8868);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$7 */
    public class C299437 implements Runnable {
        final /* synthetic */ String itc;

        public C299437(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8870);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8870);
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange, %s", e.getMessage());
                AppMethodBeat.m2505o(8870);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$35 */
    public class C3568835 implements Runnable {
        final /* synthetic */ String itc;

        public C3568835(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8898);
            try {
                C4990ab.m7411d("MicroMsg.JsApiHandler", "onSearchHistoryReady %s", this.itc);
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8898);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8898);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$45 */
    public class C3569045 implements Runnable {
        final /* synthetic */ String itc;

        public C3569045(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8909);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8909);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8909);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$32 */
    public class C4033532 implements Runnable {
        final /* synthetic */ String itc;

        public C4033532(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8895);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8895);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8895);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$4 */
    public class C403384 implements Runnable {
        final /* synthetic */ String itc;

        public C403384(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8867);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8867);
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", e.getMessage());
                AppMethodBeat.m2505o(8867);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$20 */
    public class C4397220 implements Runnable {
        final /* synthetic */ String itc;

        public C4397220(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8883);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8883);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onNfcTouch fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8883);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$27 */
    class C4397427 implements C5015a {
        C4397427() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(8890);
            C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35498a("onBeaconsInRange", C44786d.this.uFD, C44786d.this.uFv, C44786d.this.uFw) + ")", null);
            C44786d.this.uFF.clear();
            C44786d.this.uFD = new JSONObject();
            C44786d.this.uFE = new JSONArray();
            AppMethodBeat.m2505o(8890);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$28 */
    class C4397528 implements Runnable {
        C4397528() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8891);
            C44786d.m81768f(C44786d.this);
            AppMethodBeat.m2505o(8891);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$33 */
    class C4397733 implements ValueCallback<String> {
        C4397733() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(8896);
            C4990ab.m7417i("MicroMsg.JsApiHandler", "sys:bridged back %s\t", (String) obj);
            AppMethodBeat.m2505o(8896);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$63 */
    public class C4398163 implements Runnable {
        final /* synthetic */ String uFO;

        public C4398163(String str) {
            this.uFO = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8927);
            try {
                if (C44786d.this.uFo != null) {
                    C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uFO + ")", null);
                }
                AppMethodBeat.m2505o(8927);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", e);
                AppMethodBeat.m2505o(8927);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$64 */
    public class C4398264 implements Runnable {
        final /* synthetic */ String itc;

        public C4398264(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8928);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8928);
            } catch (Exception e) {
                AppMethodBeat.m2505o(8928);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$65 */
    class C4398365 implements Runnable {
        C4398365() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8929);
            C44786d.m81765c(C44786d.this);
            AppMethodBeat.m2505o(8929);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$59 */
    public class C4479059 implements Runnable {
        final /* synthetic */ String itc;

        public C4479059(String str) {
            this.itc = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8923);
            try {
                C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.itc + ")", null);
                AppMethodBeat.m2505o(8923);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(8923);
            }
        }
    }

    /* renamed from: B */
    static /* synthetic */ boolean m81758B(String str, Map map) {
        AppMethodBeat.m2504i(9015);
        boolean A = C44786d.m81757A(str, map);
        AppMethodBeat.m2505o(9015);
        return A;
    }

    /* renamed from: hl */
    static /* synthetic */ boolean m81772hl(String str, String str2) {
        AppMethodBeat.m2504i(9016);
        boolean hk = C44786d.m81771hk(str, str2);
        AppMethodBeat.m2505o(9016);
        return hk;
    }

    static {
        AppMethodBeat.m2504i(9017);
        AppMethodBeat.m2505o(9017);
    }

    public C44786d(MMWebView mMWebView, C40344k c40344k, Map<String, Object> map) {
        AppMethodBeat.m2504i(8934);
        this.uFo = mMWebView;
        this.uFu = c40344k;
        this.uFs = map;
        dcg();
        C4990ab.m7417i("MicroMsg.JsApiHandler", "JsApiHandler<init>, webview: %d, this: %d", Integer.valueOf(mMWebView.hashCode()), Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(8934);
    }

    public C44786d(MMWebView mMWebView, C40344k c40344k, Map<String, Object> map, C46434d c46434d, int i) {
        AppMethodBeat.m2504i(8935);
        this.uFo = mMWebView;
        this.uFu = c40344k;
        this.icy = c46434d;
        this.uFs = map;
        this.uqj = i;
        dcg();
        C4990ab.m7417i("MicroMsg.JsApiHandler", "JsApiHandler<init>, webview: %d, this: %d", Integer.valueOf(mMWebView.hashCode()), Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(8935);
    }

    private void dcg() {
        AppMethodBeat.m2504i(8936);
        this.uFr = new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(8864);
                switch (message.what) {
                    case 1:
                        String str = (String) message.obj;
                        if (!C5046bo.isNullOrNil(str)) {
                            C44786d.this.uFp.add(str);
                        }
                        C44786d.m81765c(C44786d.this);
                        AppMethodBeat.m2505o(8864);
                        return;
                    case 2:
                        C4990ab.m7418v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + message.obj);
                        break;
                }
                AppMethodBeat.m2505o(8864);
            }
        };
        AppMethodBeat.m2505o(8936);
    }

    /* renamed from: e */
    public final void mo71928e(C46434d c46434d) {
        this.icy = c46434d;
    }

    /* renamed from: JJ */
    public final void mo71876JJ(int i) {
        this.uqj = i;
    }

    /* renamed from: a */
    public final void mo71884a(C40344k c40344k) {
        this.uFu = c40344k;
    }

    public final void dch() {
        AppMethodBeat.m2504i(8937);
        this.uFv = true;
        this.uFw = C5046bo.m7507Mb(16);
        C4990ab.m7417i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", this.uFw, Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(8937);
    }

    public final String dci() {
        return this.uFw;
    }

    /* renamed from: bJ */
    public final void mo71910bJ(String str, boolean z) {
        AppMethodBeat.m2504i(8938);
        try {
            this.icy.mo15580i(str, z, this.uqj);
            AppMethodBeat.m2505o(8938);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(8938);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        AppMethodBeat.m2504i(8939);
        if (this.uFr != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            this.uFr.sendMessage(obtain);
        }
        AppMethodBeat.m2505o(8939);
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
        AppMethodBeat.m2504i(8942);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8942);
            return false;
        }
        boolean t = C30152u.m47751t(str, "weixin://dispatch_message/");
        AppMethodBeat.m2505o(8942);
        return t;
    }

    public final boolean afM(final String str) {
        AppMethodBeat.m2504i(8943);
        this.uFo.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.m2504i(8875);
                String str = (String) obj;
                C4990ab.m7417i("MicroMsg.JsApiHandler", "handle url %s, re %s", str, str);
                AppMethodBeat.m2505o(8875);
            }
        });
        AppMethodBeat.m2505o(8943);
        return true;
    }

    /* renamed from: aK */
    public final void mo71894aK(Map<String, Object> map) {
        AppMethodBeat.m2504i(8944);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onPreloadWebViewInit success, ready");
            String str = "MicroMsg.JsApiHandler";
            String str2 = "onPreloadWebViewInit,params %s";
            Object[] objArr = new Object[1];
            objArr[0] = map == null ? "" : map.toString();
            C4990ab.m7417i(str, str2, objArr);
            final String b = C23124a.m35500b("onUiInit", map, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8908);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8908);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onPreloadWebViewInit fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8908);
                    }
                }
            });
            AppMethodBeat.m2505o(8944);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onPreloadWebViewInit fail, not ready");
        AppMethodBeat.m2505o(8944);
    }

    /* renamed from: nZ */
    public final void mo71939nZ(boolean z) {
        AppMethodBeat.m2504i(8945);
        this.ready = z;
        if (z && this.uFx != null) {
            for (C23001a c23001a : this.uFx) {
                if (c23001a != null) {
                    c23001a.onReady();
                }
            }
        }
        AppMethodBeat.m2505o(8945);
    }

    /* renamed from: a */
    public final void mo71883a(C23001a c23001a) {
        AppMethodBeat.m2504i(8946);
        if (this.uFx == null) {
            this.uFx = new HashSet();
        }
        this.uFx.add(c23001a);
        AppMethodBeat.m2505o(8946);
    }

    public final void dcj() {
        AppMethodBeat.m2504i(8947);
        C4990ab.m7419v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", Boolean.valueOf(this.ready));
        if (this.uFo != null && this.ready) {
            this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("sys:attach_runOn3rd_apis", dck(), this.uFv, this.uFw) + ")", new C1462755());
        }
        AppMethodBeat.m2505o(8947);
    }

    private Map<String, Object> dck() {
        AppMethodBeat.m2504i(8948);
        HashMap hashMap = new HashMap();
        JsapiPermissionWrapper cZS = this.uFu.cZS();
        LinkedList linkedList = new LinkedList();
        if (cZS != null) {
            if (cZS.mo69833jB(88)) {
                linkedList.add("menu:share:timeline");
            }
            if (cZS.mo69833jB(89)) {
                linkedList.add("menu:share:appmessage");
            }
            if (cZS.mo69833jB(94)) {
                linkedList.add("menu:share:qq");
            }
            if (cZS.mo69833jB(109)) {
                linkedList.add("menu:share:weiboApp");
            }
            if (cZS.mo69833jB(C19392d.CTRL_INDEX)) {
                linkedList.add("menu:share:QZone");
            }
            if (cZS.mo69833jB(219)) {
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
            if (!C5046bo.m7548ek(null)) {
                linkedList.addAll(null);
            }
            linkedList.add("onReceivePageData");
            linkedList.add("onPageAuthOK");
            linkedList.add("onScrollViewDidScroll");
        }
        hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
        AppMethodBeat.m2505o(8948);
        return hashMap;
    }

    private void dcl() {
        AppMethodBeat.m2504i(8949);
        do {
        } while (dcm());
        AppMethodBeat.m2505o(8949);
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x042e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean dcm() {
        AppMethodBeat.m2504i(8950);
        if (C5046bo.m7548ek(this.uFq)) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
            AppMethodBeat.m2505o(8950);
            return false;
        }
        boolean Jb;
        try {
            Jb = this.icy.mo15518Jb(this.uqj);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.JsApiHandler", "isBusy, ex = " + e.getMessage());
            Jb = false;
        }
        C4990ab.m7416i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(Jb)));
        if (Jb) {
            C4990ab.m7420w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
            AppMethodBeat.m2505o(8950);
            return false;
        } else if (this.uFq.size() == 0) {
            C4990ab.m7420w("MicroMsg.JsApiHandler", "msgList size is 0.");
            AppMethodBeat.m2505o(8950);
            return false;
        } else {
            C29945i c29945i = (C29945i) this.uFq.remove(0);
            if (c29945i == null) {
                C4990ab.m7412e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
                AppMethodBeat.m2505o(8950);
                return true;
            } else if (c29945i.uIJ == null || c29945i.puc == null || c29945i.type == null || this.uFo == null) {
                C4990ab.m7412e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + c29945i.uIJ + ", params = " + c29945i.puc + ", type = " + c29945i.type + ", wv = " + this.uFo);
                AppMethodBeat.m2505o(8950);
                return true;
            } else {
                if (!(this.uFt == null || this.uFt.get("srcUsername") == null || C5046bo.isNullOrNil(this.uFt.get("srcUsername").toString()))) {
                    c29945i.puc.put("src_username", this.uFt.get("srcUsername").toString());
                }
                if (!(this.uFt == null || this.uFt.get("srcDisplayname") == null || C5046bo.isNullOrNil(this.uFt.get("srcDisplayname").toString()))) {
                    c29945i.puc.put("src_displayname", this.uFt.get("srcDisplayname").toString());
                }
                if (!(this.uFt == null || this.uFt.get("KTemplateId") == null || C5046bo.isNullOrNil(this.uFt.get("KTemplateId").toString()))) {
                    c29945i.puc.put("tempalate_id", this.uFt.get("KTemplateId").toString());
                }
                if (this.uFt != null) {
                    c29945i.puc.put("message_id", this.uFt.get("message_id"));
                    c29945i.puc.put("message_index", this.uFt.get("message_index"));
                    c29945i.puc.put("webview_scene", this.uFt.get("scene"));
                    c29945i.puc.put("pay_channel", this.uFt.get("pay_channel"));
                    c29945i.puc.put("pay_scene", this.uFt.get("pay_scene"));
                    C4990ab.m7417i("MicroMsg.JsApiHandler", "getPackageName %s", this.uFt.get("pay_package"));
                    if (this.uFt.get("pay_package") != null) {
                        c29945i.puc.put("pay_packageName", this.uFt.get("pay_package"));
                    }
                    c29945i.puc.put("stastic_scene", this.uFt.get("stastic_scene"));
                    c29945i.puc.put("open_from_scene", this.uFt.get("from_scence"));
                    Bundle bundle = new Bundle();
                    bundle.putString("__jsapi_fw_ext_info_key_current_url", this.uFo.getUrl());
                    c29945i.puc.put("__jsapi_fw_ext_info", bundle);
                }
                if (!(c29945i.uIJ.equals("shareWeibo") || c29945i.uIJ.equals("openUrlByExtBrowser") || c29945i.uIJ.equals("openUrlWithExtraWebview") || c29945i.uIJ.equals("openCustomWebview") || c29945i.uIJ.equals("openGameWebView") || c29945i.uIJ.equals("addToEmoticon") || c29945i.uIJ.equals("shareEmoticon") || c29945i.uIJ.equals("openGameUrlWithExtraWebView") || c29945i.uIJ.equals(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID))) {
                    c29945i.puc.put("url", this.uFo.getUrl());
                    C4990ab.m7416i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl:" + this.uFo.getUrl());
                }
                if (c29945i.uIJ.equalsIgnoreCase("openDesignerEmojiView") || c29945i.uIJ.equalsIgnoreCase("openEmotionDetailViewLocal") || c29945i.uIJ.equalsIgnoreCase("openDesignerEmojiView") || c29945i.uIJ.equalsIgnoreCase("openDesignerEmojiViewLocal") || c29945i.uIJ.equalsIgnoreCase("openDesignerEmojiView") || c29945i.uIJ.equalsIgnoreCase("openDesignerProfile") || c29945i.uIJ.equalsIgnoreCase("openDesignerProfileLocal") || c29945i.uIJ.equalsIgnoreCase("getSearchEmotionData")) {
                    c29945i.puc.put("searchID", Long.valueOf(dcp()));
                    C4990ab.m7411d("MicroMsg.JsApiHandler", "emoji search id:%d", Long.valueOf(dcp()));
                }
                if (c29945i.uIJ.equals(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID)) {
                    c29945i.puc.put("key_request_full_url_query", this.uFy);
                    c29945i.puc.put("key_request_header", this.uFz);
                }
                try {
                    JsapiPermissionWrapper cZS = this.uFu.cZS();
                    Bundle bundle2 = new Bundle();
                    if (cZS != null) {
                        cZS.toBundle(bundle2);
                    }
                    Bundle aP = C29945i.m47402aP(c29945i.puc);
                    if (!C5046bo.isNullOrNil(this.uqT)) {
                        aP.putString("key_wxapp_id", this.uqT);
                    }
                    Bundle bundle3 = new Bundle(2);
                    bundle3.putBundle("compatParams", aP);
                    bundle3.putString("rawParams", c29945i.uIH.toString());
                    if (!(this.icy == null || c29945i == null)) {
                        GeneralControlWrapper cZT = this.uFu.cZT();
                        if (this.uFo == null || !(this.uFo.getContext() instanceof WebViewUI)) {
                            Jb = true;
                        } else {
                            if (!((WebViewUI) this.uFo.getContext()).uvG || cZT.dmj()) {
                                Jb = true;
                            } else {
                                C4990ab.m7413e("MicroMsg.JsApiHandler", "Can not call js api now, forbidJsApiExcuteNow:%b, canCallJsApiBeforeLoaded:%b", Boolean.valueOf(r0.uvG), Boolean.valueOf(cZT.dmj()));
                                Jb = false;
                            }
                        }
                        if (Jb) {
                            Jb = this.icy.mo15532a(c29945i.type, c29945i.uIJ, c29945i.uIG, bundle2, bundle3, this.uqj);
                            C46431j.cYL();
                            C4990ab.m7417i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", c29945i.uIJ, Boolean.valueOf(Jb));
                            if (Jb) {
                                AppMethodBeat.m2505o(8950);
                                return true;
                            }
                            AppMethodBeat.m2505o(8950);
                            return false;
                        }
                    }
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    C4990ab.m7420w("MicroMsg.JsApiHandler", "handleMsg, ex = " + e2.getMessage());
                }
                Jb = false;
                C46431j.cYL();
                C4990ab.m7417i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", c29945i.uIJ, Boolean.valueOf(Jb));
                if (Jb) {
                }
            }
        }
    }

    public final void detach() {
        AppMethodBeat.m2504i(8951);
        this.ready = false;
        this.uFq.clear();
        this.uFp.clear();
        this.uFr = null;
        AppMethodBeat.m2505o(8951);
    }

    public final void agl(String str) {
        this.uFy = str;
    }

    public final void agm(String str) {
        this.uFz = str;
    }

    public final void keep_setReturnValue(String str, String str2) {
        AppMethodBeat.m2504i(8952);
        C4990ab.m7416i("MicroMsg.JsApiHandler", "setResultValue, scene = " + str + ", resultValue = " + str2);
        C4990ab.m7416i("MicroMsg.JsApiHandler", "edw setResultValue = threadId = " + Thread.currentThread().getId() + ", threadName = " + Thread.currentThread().getName());
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
        AppMethodBeat.m2505o(8952);
    }

    /* renamed from: JK */
    public final void mo71877JK(int i) {
        AppMethodBeat.m2504i(8953);
        if (this.ready) {
            HashMap hashMap = new HashMap();
            hashMap.put("fontSize", String.valueOf(i));
            this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:setfont", hashMap, this.uFv, this.uFw) + ")", null);
            AppMethodBeat.m2505o(8953);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
        AppMethodBeat.m2505o(8953);
    }

    /* renamed from: bG */
    public final void mo71908bG(int i, String str) {
        AppMethodBeat.m2504i(8954);
        if (this.ready) {
            HashMap hashMap = new HashMap();
            hashMap.put("recommend", Integer.valueOf(i));
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_COMMENT, str);
            this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:haokan", hashMap, this.uFv, this.uFw) + ")", null);
            AppMethodBeat.m2505o(8954);
            return;
        }
        AppMethodBeat.m2505o(8954);
    }

    /* renamed from: q */
    public final void mo71942q(HashMap<String, String> hashMap) {
        AppMethodBeat.m2504i(8955);
        if (this.ready) {
            Bundle JL = mo71878JL(1);
            if (JL == null || !JL.getBoolean("WebViewShare_reslut", false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("scene", "friend");
                this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("menu:share:appmessage", hashMap2, this.uFv, this.uFw) + ")", null);
                try {
                    this.icy.mo15522L("scene", "friend", this.uqj);
                    AppMethodBeat.m2505o(8955);
                    return;
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                    AppMethodBeat.m2505o(8955);
                    return;
                }
            }
            mo71930h(JL, "sendAppMessage");
            AppMethodBeat.m2505o(8955);
            return;
        }
        C4990ab.m7420w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
        mo71930h(mo71895aL(hashMap), "sendAppMessage");
        AppMethodBeat.m2505o(8955);
    }

    /* renamed from: JL */
    public final Bundle mo71878JL(int i) {
        AppMethodBeat.m2504i(8956);
        try {
            if (this.uFo == null) {
                AppMethodBeat.m2505o(8956);
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("WebViewShare_type", i);
            bundle.putInt("WebViewShare_BinderID", this.uqj);
            bundle.putString("WebViewShare_wv_url", this.uFo.getUrl());
            bundle = this.icy.mo15575g(105, bundle);
            bundle.putBoolean("use_update_jsapi_data", true);
            AppMethodBeat.m2505o(8956);
            return bundle;
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.JsApiHandler", "getShareData err %s", e.getMessage());
            AppMethodBeat.m2505o(8956);
            return null;
        }
    }

    /* renamed from: aL */
    public final Bundle mo71895aL(Map<String, String> map) {
        String title;
        AppMethodBeat.m2504i(8957);
        Bundle bundle = new Bundle();
        String url = this.uFo.getUrl();
        if (map != null) {
            String str;
            String str2 = (String) map.get("share_report_pre_msg_url");
            if (C5046bo.isNullOrNil(str2)) {
                str = url;
            } else {
                str = str2;
            }
            str2 = (String) map.get("share_report_pre_msg_title");
            if (C5046bo.isNullOrNil(str2)) {
                title = this.uFo.getTitle();
            } else {
                title = str2;
            }
            str2 = (String) map.get("share_report_pre_msg_desc");
            if (C5046bo.isNullOrNil(str2)) {
                str2 = url;
            }
            bundle.putString("link", str);
            bundle.putString("desc", str2);
            bundle.putString("img_url", C5046bo.nullAsNil((String) map.get("share_report_pre_msg_icon_url")));
        } else {
            title = this.uFo.getTitle();
            bundle.putString("link", url);
            bundle.putString("desc", url);
            bundle.putString("img_url", "");
        }
        if (!C5046bo.isNullOrNil(title)) {
            url = title;
        } else if (C5046bo.isNullOrNil(url)) {
            url = C4996ah.getContext().getString(C25738R.string.fyo);
        } else {
            Uri parse = Uri.parse(url);
            if (parse.getHost() != null) {
                url = parse.getHost();
            }
        }
        bundle.putString("title", url);
        bundle.putBoolean("use_update_jsapi_data", false);
        AppMethodBeat.m2505o(8957);
        return bundle;
    }

    /* renamed from: h */
    public final void mo71930h(final Bundle bundle, final String str) {
        AppMethodBeat.m2504i(8958);
        if (bundle == null) {
            C4990ab.m7420w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
            AppMethodBeat.m2505o(8958);
            return;
        }
        if (this.uFr != null) {
            this.uFr.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8932);
                    C29945i c29945i = new C29945i();
                    c29945i.puc = new HashMap();
                    c29945i.puc.put("link", bundle.getString("link"));
                    c29945i.puc.put("title", bundle.getString("title"));
                    c29945i.puc.put("desc", bundle.getString("desc"));
                    c29945i.uIH = new JSONObject();
                    c29945i.puc.put("img_url", bundle.getString("img_url"));
                    c29945i.puc.put("use_update_jsapi_data", Boolean.valueOf(bundle.getBoolean("use_update_jsapi_data")));
                    c29945i.type = "call";
                    c29945i.uIG = "";
                    c29945i.uIJ = str;
                    C44786d.this.uFq.add(c29945i);
                    C44786d.m81768f(C44786d.this);
                    AppMethodBeat.m2505o(8932);
                }
            });
        }
        AppMethodBeat.m2505o(8958);
    }

    /* renamed from: i */
    public final void mo71933i(Bundle bundle, String str) {
        AppMethodBeat.m2504i(8959);
        if (!this.ready || bundle == null) {
            C4990ab.m7412e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
            AppMethodBeat.m2505o(8959);
            return;
        }
        long j = bundle.getLong("download_manager_downloadid");
        String string = bundle.getString("download_manager_appid", "");
        int i = bundle.getInt("download_manager_errcode");
        C4990ab.m7416i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + j + ", state = " + str + ", errCode = " + i);
        HashMap hashMap = new HashMap();
        hashMap.put("appid", string);
        hashMap.put("download_id", Long.valueOf(j));
        hashMap.put("err_code", Integer.valueOf(i));
        hashMap.put("state", str);
        final String b = C23124a.m35500b("wxdownload:state_change", hashMap, this.uFv, this.uFw);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(8933);
                try {
                    C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.m2505o(8933);
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", e.getMessage());
                    AppMethodBeat.m2505o(8933);
                }
            }
        });
        AppMethodBeat.m2505o(8959);
    }

    /* renamed from: n */
    public final void mo71937n(String str, long j, int i) {
        AppMethodBeat.m2504i(8960);
        if (this.ready) {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", str);
            hashMap.put("download_id", Long.valueOf(j));
            hashMap.put("progress", Integer.valueOf(i));
            final String b = C23124a.m35500b("wxdownload:progress_change", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8865);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8865);
                    } catch (Exception e) {
                        C4990ab.m7421w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8865);
                    }
                }
            });
            AppMethodBeat.m2505o(8960);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
        AppMethodBeat.m2505o(8960);
    }

    /* renamed from: dG */
    public final void mo71913dG(String str, int i) {
        AppMethodBeat.m2504i(8961);
        if (this.ready) {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", str, Integer.valueOf(i));
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.JsApiHandler", "parameter error!!!");
                AppMethodBeat.m2505o(8961);
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
            final String b = C23124a.m35500b("onWXDeviceStateChange", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8866);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8866);
                    } catch (Exception e) {
                        C4990ab.m7421w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", e.getMessage());
                        AppMethodBeat.m2505o(8866);
                    }
                }
            });
            AppMethodBeat.m2505o(8961);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
        AppMethodBeat.m2505o(8961);
    }

    public final void agn(String str) {
        AppMethodBeat.m2504i(8962);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = ".concat(String.valueOf(str)));
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            final String b = C23124a.m35500b("activity:state_change", hashMap, this.uFv, this.uFw);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                try {
                    this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.m2505o(8962);
                    return;
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", e.getMessage());
                    AppMethodBeat.m2505o(8962);
                    return;
                }
            }
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8871);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8871);
                    } catch (Exception e) {
                        C4990ab.m7421w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8871);
                    }
                }
            });
            AppMethodBeat.m2505o(8962);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready");
        AppMethodBeat.m2505o(8962);
    }

    /* renamed from: aM */
    public final void mo71896aM(Map<String, Object> map) {
        AppMethodBeat.m2504i(8963);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
            final String b = C23124a.m35500b("onVoicePlayEnd", map, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8872);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8872);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8872);
                    }
                }
            });
            AppMethodBeat.m2505o(8963);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
        AppMethodBeat.m2505o(8963);
    }

    /* renamed from: aN */
    public final void mo71897aN(Map<String, Object> map) {
        AppMethodBeat.m2504i(8964);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
            final String b = C23124a.m35500b("onVoiceRecordEnd", map, this.uFv, this.uFw);
            C4990ab.m7417i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", b);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8873);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8873);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8873);
                    }
                }
            });
            AppMethodBeat.m2505o(8964);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
        AppMethodBeat.m2505o(8964);
    }

    /* renamed from: dH */
    public final void mo71914dH(String str, int i) {
        AppMethodBeat.m2504i(8965);
        if (this.ready) {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String b = C23124a.m35500b("onImageUploadProgress", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8876);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8876);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8876);
                    }
                }
            });
            AppMethodBeat.m2505o(8965);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
        AppMethodBeat.m2505o(8965);
    }

    /* renamed from: dI */
    public final void mo71915dI(String str, int i) {
        AppMethodBeat.m2504i(8966);
        if (this.ready) {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", str, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String b = C23124a.m35500b("onImageDownloadProgress", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8877);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8877);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8877);
                    }
                }
            });
            AppMethodBeat.m2505o(8966);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
        AppMethodBeat.m2505o(8966);
    }

    /* renamed from: dJ */
    public final void mo71916dJ(String str, int i) {
        AppMethodBeat.m2504i(8967);
        if (this.ready) {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String b = C23124a.m35500b("onVoiceUploadProgress", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8878);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8878);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8878);
                    }
                }
            });
            AppMethodBeat.m2505o(8967);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
        AppMethodBeat.m2505o(8967);
    }

    /* renamed from: dK */
    public final void mo71917dK(String str, int i) {
        AppMethodBeat.m2504i(8968);
        if (this.ready) {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", str, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String b = C23124a.m35500b("onVoiceDownloadProgress", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8879);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8879);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8879);
                    }
                }
            });
            AppMethodBeat.m2505o(8968);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
        AppMethodBeat.m2505o(8968);
    }

    /* renamed from: dL */
    public final void mo71918dL(String str, int i) {
        AppMethodBeat.m2504i(8969);
        if (this.ready) {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String b = C23124a.m35500b("onVideoUploadProgress", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8880);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8880);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8880);
                    }
                }
            });
            AppMethodBeat.m2505o(8969);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
        AppMethodBeat.m2505o(8969);
    }

    public final void ago(String str) {
        AppMethodBeat.m2504i(8970);
        try {
            Bundle bundle = new Bundle();
            JsapiPermissionWrapper cZS = this.uFu.cZS();
            if (cZS != null) {
                cZS.toBundle(bundle);
            }
            this.icy.mo15529a(str, bundle, this.uqj);
            AppMethodBeat.m2505o(8970);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.JsApiHandler", "doProfile, ex = " + e.getMessage());
            AppMethodBeat.m2505o(8970);
        }
    }

    /* renamed from: JM */
    public final void mo71879JM(int i) {
        AppMethodBeat.m2504i(8971);
        HashMap hashMap = new HashMap();
        hashMap.put("height", Integer.valueOf(C1338a.m2859ao(C4996ah.getContext(), i)));
        final String b = C23124a.m35500b("onGetKeyboardHeight", hashMap, this.uFv, this.uFw);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(8884);
                try {
                    C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.m2505o(8884);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", e.getMessage());
                    AppMethodBeat.m2505o(8884);
                }
            }
        });
        AppMethodBeat.m2505o(8971);
    }

    /* renamed from: oa */
    public final void mo71940oa(boolean z) {
        AppMethodBeat.m2504i(8972);
        HashMap hashMap = new HashMap();
        hashMap.put("success", Boolean.valueOf(z));
        final String b = C23124a.m35500b("onAddShortcutStatus", hashMap, this.uFv, this.uFw);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(8887);
                try {
                    C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.m2505o(8887);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", e.getMessage());
                    AppMethodBeat.m2505o(8887);
                }
            }
        });
        AppMethodBeat.m2505o(8972);
    }

    public final void agp(String str) {
        AppMethodBeat.m2504i(8973);
        HashMap hashMap = new HashMap();
        hashMap.put("err_msg", str);
        final String b = C23124a.m35500b("onBeaconMonitoring", hashMap, this.uFv, this.uFw);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(8888);
                try {
                    C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.m2505o(8888);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", e.getMessage());
                    AppMethodBeat.m2505o(8888);
                }
            }
        });
        AppMethodBeat.m2505o(8973);
    }

    /* renamed from: z */
    public final void mo71943z(final String str, final Map<String, String> map) {
        AppMethodBeat.m2504i(8974);
        C4990ab.m7411d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8974);
            return;
        }
        this.uFB = str;
        if (map == null || map.size() == 0) {
            this.uFC = 0;
        } else {
            this.uFC = 1;
        }
        final String dM = mo71919dM(str, this.uFC);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(8889);
                try {
                    if (!(map == null || map.size() == 0)) {
                        C24526c.m38159jx(C4996ah.getContext());
                        C44576b dTR = C44576b.dTR();
                        for (String str : map.keySet()) {
                            dTR.setCookie(C5046bo.anB(str), str + "=" + ((String) map.get(str)));
                        }
                        dTR.setCookie(C5046bo.anB(str), "httponly");
                        C24526c.dTT();
                        C24526c.sync();
                        C4990ab.m7417i("MicroMsg.JsApiHandler", "cookies:%s", dTR.getCookie(C5046bo.anB(str)));
                    }
                    C44786d.this.uFo.evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[]{str}), null);
                    C44786d.this.uFo.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                    if (C44786d.this.ready) {
                        C44786d.this.uFo.evaluateJavascript(dM, null);
                        C44786d.this.uFB = null;
                        C44786d.this.uFC = 0;
                    }
                    AppMethodBeat.m2505o(8889);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", e.getMessage());
                    AppMethodBeat.m2505o(8889);
                }
            }
        });
        AppMethodBeat.m2505o(8974);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: dM */
    public final String mo71919dM(String str, int i) {
        AppMethodBeat.m2504i(8975);
        HashMap hashMap = new HashMap(2);
        hashMap.put("url", str);
        hashMap.put("set_cookie", Integer.valueOf(i));
        String agr = C44786d.agr(C23124a.m35500b("onGetA8KeyUrl", hashMap, this.uFv, this.uFw));
        AppMethodBeat.m2505o(8975);
        return agr;
    }

    /* renamed from: a */
    public final synchronized void mo71885a(String str, int i, int i2, double d, double d2, float f) {
        int i3 = 1;
        synchronized (this) {
            AppMethodBeat.m2504i(8976);
            if (this.uFG.doT()) {
                this.uFG.mo16770ae(1000, 1000);
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
                C4990ab.m7413e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", e.getMessage());
            }
            C23124a.m35498a("onBeaconsInRange", this.uFD, this.uFv, this.uFw);
            AppMethodBeat.m2505o(8976);
        }
        return;
    }

    /* renamed from: a */
    public final void mo71886a(String str, String str2, Map<String, Object> map, boolean z) {
        AppMethodBeat.m2504i(8977);
        if (!C5046bo.isNullOrNil(str)) {
            m81775j(str, str2, map);
        }
        if (z) {
            cZc();
        }
        AppMethodBeat.m2505o(8977);
    }

    public final void cZc() {
        AppMethodBeat.m2504i(8978);
        if (this.uFr != null) {
            this.uFr.post(new C4397528());
        }
        AppMethodBeat.m2505o(8978);
    }

    public final void cZb() {
        AppMethodBeat.m2504i(8979);
        if (this.uFq != null) {
            this.uFq.clear();
        }
        AppMethodBeat.m2505o(8979);
    }

    /* renamed from: j */
    private void m81775j(String str, String str2, Map<String, Object> map) {
        AppMethodBeat.m2504i(8980);
        if (str2 == null || str2.length() == 0 || str == null) {
            C4990ab.m7412e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(str2)));
            AppMethodBeat.m2505o(8980);
        } else if (this.ready) {
            Map hashMap = new HashMap();
            hashMap.put("err_msg", str2);
            if (map != null && map.size() > 0) {
                C4990ab.m7416i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + map.size());
                hashMap.putAll(map);
            }
            final String a = C23124a.m35497a(str, hashMap, this.uFv, this.uFw);
            C4990ab.m7416i("MicroMsg.JsApiHandler", "doCallback, ret = " + str2 + ", cb = " + a);
            if (!(a == null || this.uFo == null)) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8892);
                        try {
                            C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                            AppMethodBeat.m2505o(8892);
                        } catch (Exception e) {
                            C4990ab.m7421w("MicroMsg.JsApiHandler", "doCallback, ex = %s", e.getMessage());
                            AppMethodBeat.m2505o(8892);
                        }
                    }
                });
            }
            AppMethodBeat.m2505o(8980);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
            AppMethodBeat.m2505o(8980);
        }
    }

    /* renamed from: aO */
    public final void mo71898aO(Map<String, Object> map) {
        AppMethodBeat.m2504i(8981);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
            final String b = C23124a.m35500b("onSelectContact", map, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8893);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8893);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8893);
                    }
                }
            });
            AppMethodBeat.m2505o(8981);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
        AppMethodBeat.m2505o(8981);
    }

    /* renamed from: gA */
    public final void mo71929gA(int i, int i2) {
        AppMethodBeat.m2504i(8982);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put(C8741b.INDEX, Integer.valueOf(i));
            hashMap.put("actionSheetId", Integer.valueOf(i2));
            final String b = C23124a.m35500b("onSearchActionSheetClick", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8894);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8894);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8894);
                    }
                }
            });
            AppMethodBeat.m2505o(8982);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
        AppMethodBeat.m2505o(8982);
    }

    /* renamed from: aP */
    public final void mo71899aP(JSONObject jSONObject) {
        AppMethodBeat.m2504i(8983);
        final String a = C23124a.m35498a("onGetMatchContactList", jSONObject, this.uFv, this.uFw);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(8897);
                try {
                    C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    AppMethodBeat.m2505o(8897);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiHandler", "onGetMatchContactList fail, ex = %s", e.getMessage());
                    AppMethodBeat.m2505o(8897);
                }
            }
        });
        AppMethodBeat.m2505o(8983);
    }

    /* renamed from: h */
    public final void mo71931h(String str, boolean z, String str2) {
        AppMethodBeat.m2504i(8984);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("json", str);
            hashMap.put("newQuery", Boolean.valueOf(z));
            hashMap.put("requestId", str2);
            final String b = C23124a.m35500b("onSearchDataReady", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8899);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8899);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8899);
                    }
                }
            });
            AppMethodBeat.m2505o(8984);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
        AppMethodBeat.m2505o(8984);
    }

    /* renamed from: ap */
    public final void mo71907ap(Bundle bundle) {
        AppMethodBeat.m2504i(8985);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("json", bundle.getString("json"));
            hashMap.put("searchId", bundle.getString("searchId"));
            hashMap.put("poiId", bundle.getString("poiId"));
            final String b = C23124a.m35500b("onGetPoiInfoReturn", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8900);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8900);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onGetPoiInfoReturn fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8900);
                    }
                }
            });
            AppMethodBeat.m2505o(8985);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
        AppMethodBeat.m2505o(8985);
    }

    /* renamed from: a */
    public final void mo71891a(String str, boolean z, String str2, String str3) {
        AppMethodBeat.m2504i(8986);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("eventId", str);
            hashMap.put("widgetId", str3);
            hashMap.put("hitTest", Boolean.valueOf(z));
            hashMap.put("err_msg", str2);
            final String b = C23124a.m35500b("onSearchWAWidgetOnTapCallback", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8902);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8902);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8902);
                    }
                }
            });
            AppMethodBeat.m2505o(8986);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
        AppMethodBeat.m2505o(8986);
    }

    /* renamed from: hj */
    public final void mo71932hj(String str, String str2) {
        AppMethodBeat.m2504i(8987);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("data", str2);
            final String b = C23124a.m35500b("onSearchWAWidgetReloadDataFinish", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$42$1 */
                class C46331 implements ValueCallback<String> {
                    C46331() {
                    }

                    public final /* synthetic */ void onReceiveValue(Object obj) {
                        AppMethodBeat.m2504i(8905);
                        C4990ab.m7417i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish back %s", (String) obj);
                        AppMethodBeat.m2505o(8905);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(8906);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", new C46331());
                        AppMethodBeat.m2505o(8906);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8906);
                    }
                }
            });
            AppMethodBeat.m2505o(8987);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
        AppMethodBeat.m2505o(8987);
    }

    /* renamed from: a */
    public final void mo71888a(String str, String str2, JSONArray jSONArray, int i) {
        AppMethodBeat.m2504i(8988);
        if (this.ready) {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", str, str2, jSONArray.toString());
            HashMap hashMap = new HashMap();
            hashMap.put(SearchIntents.EXTRA_QUERY, str);
            hashMap.put("custom", str2);
            hashMap.put("tagList", jSONArray);
            hashMap.put("isCancelButtonClick", Integer.valueOf(i));
            final String b = C23124a.m35500b("onSearchInputChange", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8910);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8910);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8910);
                    }
                }
            });
            AppMethodBeat.m2505o(8988);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
        AppMethodBeat.m2505o(8988);
    }

    /* renamed from: a */
    public final void mo71887a(String str, String str2, JSONArray jSONArray) {
        AppMethodBeat.m2504i(8989);
        Map hashMap = new HashMap();
        hashMap.put(SearchIntents.EXTRA_QUERY, str);
        hashMap.put("custom", str2);
        hashMap.put("tagList", jSONArray);
        mo71890a("onSearchInputChange", hashMap, null);
        AppMethodBeat.m2505o(8989);
    }

    /* renamed from: a */
    public final boolean mo71893a(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
        AppMethodBeat.m2504i(8990);
        JSONObject jSONObject = new JSONObject();
        try {
            for (Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
        }
        try {
            jSONObject.put("scene", str);
            jSONObject.put("type", str2);
            jSONObject.put("isSug", str3);
            jSONObject.put("isLocalSug", str4);
            jSONObject.put("sessionId", str5);
        } catch (JSONException e2) {
            C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
        }
        mo71890a("switchToTabSearch", null, jSONObject);
        AppMethodBeat.m2505o(8990);
        return true;
    }

    /* renamed from: a */
    public final void mo71890a(final String str, Map<String, Object> map, JSONObject jSONObject) {
        AppMethodBeat.m2504i(8991);
        if (!this.ready || (map == null && jSONObject == null)) {
            C4990ab.m7413e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", str);
            AppMethodBeat.m2505o(8991);
            return;
        }
        String b;
        String str2 = "MicroMsg.JsApiHandler";
        String str3 = "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = map == null ? "" : map.toString();
        objArr[2] = jSONObject == null ? "" : jSONObject.toString();
        C4990ab.m7417i(str2, str3, objArr);
        if (map != null) {
            b = C23124a.m35500b(str, map, this.uFv, this.uFw);
        } else {
            b = C23124a.m35498a(str, jSONObject, this.uFv, this.uFw);
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(8911);
                try {
                    C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.m2505o(8911);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", str, e.getMessage());
                    AppMethodBeat.m2505o(8911);
                }
            }
        });
        AppMethodBeat.m2505o(8991);
    }

    /* renamed from: a */
    public final boolean mo71892a(String str, String str2, String str3, String str4, String str5, String str6, String str7, JSONArray jSONArray, String str8, int i, Map<String, Object> map) {
        AppMethodBeat.m2504i(8992);
        if (this.ready) {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "switchToTabSearch success, ready %s %s %s %s %s", str, str2, str3, str4, str5);
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
                                    C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
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
                C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            }
            final String a = C23124a.m35498a("switchToTabSearch", jSONObject, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8912);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                        AppMethodBeat.m2505o(8912);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "switchToTabSearch fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8912);
                    }
                }
            });
            AppMethodBeat.m2505o(8992);
            return true;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "switchToTabSearch fail, not ready");
        AppMethodBeat.m2505o(8992);
        return false;
    }

    /* renamed from: a */
    public final void mo71889a(String str, String str2, JSONArray jSONArray, int i, Map<String, Object> map) {
        AppMethodBeat.m2504i(8993);
        m81763a(str, str2, jSONArray, i, "", (Map) map);
        AppMethodBeat.m2505o(8993);
    }

    /* renamed from: a */
    private void m81763a(String str, String str2, JSONArray jSONArray, int i, String str3, Map<String, Object> map) {
        AppMethodBeat.m2504i(8994);
        if (this.ready) {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", str, str2, jSONArray.toString());
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
                                    C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
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
                C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            }
            final String a = C23124a.m35498a("onSearchInputConfirm", jSONObject, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8913);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                        AppMethodBeat.m2505o(8913);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8913);
                    }
                }
            });
            AppMethodBeat.m2505o(8994);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
        AppMethodBeat.m2505o(8994);
    }

    public final void agq(String str) {
        AppMethodBeat.m2504i(8995);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("json", str);
            final String b = C23124a.m35500b("onSearchSuggestionDataReady", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8914);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8914);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8914);
                    }
                }
            });
            AppMethodBeat.m2505o(8995);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
        AppMethodBeat.m2505o(8995);
    }

    /* renamed from: bH */
    public final void mo71909bH(int i, String str) {
        AppMethodBeat.m2504i(8996);
        if (this.ready) {
            HashMap hashMap = new HashMap();
            hashMap.put("ret", Integer.valueOf(i));
            hashMap.put("data", str);
            final String b = C23124a.m35500b("onSearchImageListReady", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8915);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8915);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8915);
                    }
                }
            });
            AppMethodBeat.m2505o(8996);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
        AppMethodBeat.m2505o(8996);
    }

    /* renamed from: n */
    public final void mo71936n(int i, String str, int i2) {
        AppMethodBeat.m2504i(8997);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("requestType", Integer.valueOf(i));
            hashMap.put("json", str);
            hashMap.put("isCacheData", Integer.valueOf(i2));
            final String b = C23124a.m35500b("onTeachSearchDataReady", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8916);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8916);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8916);
                    }
                }
            });
            AppMethodBeat.m2505o(8997);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
        AppMethodBeat.m2505o(8997);
    }

    /* renamed from: m */
    public final void mo71935m(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(8998);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("json", str);
            hashMap.put("isCacheData", Integer.valueOf(i));
            hashMap.put("isExpired", Integer.valueOf(i2));
            hashMap.put("isPreload", Integer.valueOf(i3));
            final String b = C23124a.m35500b("onSearchGuideDataReady", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8917);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8917);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8917);
                    }
                }
            });
            AppMethodBeat.m2505o(8998);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
        AppMethodBeat.m2505o(8998);
    }

    /* renamed from: a */
    public final void mo71882a(int i, long j, String str) {
        AppMethodBeat.m2504i(8999);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onUxOplogDataReady success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("ret", Integer.valueOf(i));
            hashMap.put("reqId", Long.valueOf(j));
            hashMap.put("json", str);
            final String b = C23124a.m35500b("onUxOplogDataReady", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8918);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8918);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8918);
                    }
                }
            });
            AppMethodBeat.m2505o(8999);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
        AppMethodBeat.m2505o(8999);
    }

    /* renamed from: dN */
    public final void mo71920dN(String str, int i) {
        AppMethodBeat.m2504i(9000);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("snsid", str);
            hashMap.put("status", Integer.valueOf(i));
            final String b = C23124a.m35500b("onMusicStatusChanged", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8920);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8920);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8920);
                    }
                }
            });
            AppMethodBeat.m2505o(9000);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
        AppMethodBeat.m2505o(9000);
    }

    public static String agr(String str) {
        AppMethodBeat.m2504i(9001);
        String format = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[]{C5046bo.nullAsNil(str)});
        AppMethodBeat.m2505o(9001);
        return format;
    }

    /* renamed from: nN */
    public final void mo71938nN(boolean z) {
        AppMethodBeat.m2504i(9002);
        if (this.ready) {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", Boolean.valueOf(z));
            HashMap hashMap = new HashMap();
            hashMap.put("active", String.valueOf(z));
            final String agr = C44786d.agr(C23124a.m35500b("onPageStateChange", hashMap, this.uFv, this.uFw));
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8922);
                    try {
                        C44786d.this.uFo.evaluateJavascript(agr, null);
                        AppMethodBeat.m2505o(8922);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8922);
                    }
                }
            });
            AppMethodBeat.m2505o(9002);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
        AppMethodBeat.m2505o(9002);
    }

    /* renamed from: ob */
    public final void mo71941ob(boolean z) {
        AppMethodBeat.m2504i(9003);
        C4990ab.m7417i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", Boolean.valueOf(this.ready));
        if (!(this.uFo == null || this.icy == null || !this.ready)) {
            if (z) {
                this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("sys:get_html_content", new HashMap(), this.uFv, this.uFw) + ")", null);
                AppMethodBeat.m2505o(9003);
                return;
            }
            List cZq;
            try {
                cZq = this.icy.cZq();
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                cZq = null;
            }
            Uri parse = Uri.parse(this.uFo.getUrl());
            if (parse != null) {
                C4990ab.m7410d("MicroMsg.JsApiHandler", "wv hijack url host" + parse.getHost());
            }
            if (!(cZq == null || parse == null || !cZq.contains(parse.getHost()))) {
                this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("sys:get_html_content", new HashMap(), this.uFv, this.uFw) + ")", null);
            }
        }
        AppMethodBeat.m2505o(9003);
    }

    public final void dcn() {
        AppMethodBeat.m2504i(9004);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("needShow", Boolean.TRUE);
            final String b = C23124a.m35500b("showLoading", hashMap, this.uFv, this.uFw);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8924);
                    try {
                        C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                        AppMethodBeat.m2505o(8924);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", e.getMessage());
                        AppMethodBeat.m2505o(8924);
                    }
                }
            });
            AppMethodBeat.m2505o(9004);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
        AppMethodBeat.m2505o(9004);
    }

    public final void ags(String str) {
        AppMethodBeat.m2504i(9005);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(9005);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DownloadInfo.NETTYPE, str);
        final String b = C23124a.m35500b("onNetWorkChange", hashMap, this.uFv, this.uFw);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(8926);
                try {
                    C44786d.this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b + ")", null);
                    AppMethodBeat.m2505o(8926);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", e.getMessage());
                    AppMethodBeat.m2505o(8926);
                }
            }
        });
        AppMethodBeat.m2505o(9005);
    }

    public final void dco() {
        AppMethodBeat.m2504i(9006);
        if (this.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
            this.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("onNavigationBarRightButtonClick", new HashMap(), this.uFv, this.uFw) + ")", null);
            AppMethodBeat.m2505o(9006);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
        AppMethodBeat.m2505o(9006);
    }

    public final long dcp() {
        AppMethodBeat.m2504i(9007);
        C4990ab.m7411d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", Long.valueOf(this.uFH));
        long j = this.uFH;
        AppMethodBeat.m2505o(9007);
        return j;
    }

    private String agt(String str) {
        AppMethodBeat.m2504i(9008);
        String url = this.uFo.getUrl();
        try {
            C4990ab.m7417i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", url, str, C6457e.euU + C45137n.getSHA1(url + str));
            AppMethodBeat.m2505o(9008);
            return r0;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(url)));
            C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
            AppMethodBeat.m2505o(9008);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ff A:{SYNTHETIC, Splitter:B:39:0x00ff} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0098 A:{SYNTHETIC, Splitter:B:22:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ff A:{SYNTHETIC, Splitter:B:39:0x00ff} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: A */
    private static boolean m81757A(String str, Map<String, Integer> map) {
        Throwable e;
        AppMethodBeat.m2504i(9009);
        if (C5046bo.isNullOrNil(str) || map == null) {
            C4990ab.m7420w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            AppMethodBeat.m2505o(9009);
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                C4990ab.m7412e("MicroMsg.JsApiHandler", "creating file failed, filePath is ".concat(String.valueOf(str)));
                C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                AppMethodBeat.m2505o(9009);
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
                    C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                }
                C4990ab.m7410d("MicroMsg.JsApiHandler", "writeToFile ok! ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(9009);
                return true;
            } catch (Exception e3) {
                e = e3;
                outputStream = bufferedOutputStream;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                    C4990ab.m7420w("MicroMsg.JsApiHandler", "write to file error");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e222) {
                            C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(9009);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    bufferedOutputStream = outputStream;
                    if (bufferedOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(9009);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e4) {
                        C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(9009);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
            C4990ab.m7420w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
            }
            AppMethodBeat.m2505o(9009);
            return false;
        } catch (Throwable th3) {
            e = th3;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
            }
            AppMethodBeat.m2505o(9009);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b2 A:{SYNTHETIC, Splitter:B:27:0x00b2} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ca A:{SYNTHETIC, Splitter:B:34:0x00ca} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: hk */
    private static boolean m81771hk(String str, String str2) {
        Throwable e;
        AppMethodBeat.m2504i(9010);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            AppMethodBeat.m2505o(9010);
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                C4990ab.m7412e("MicroMsg.JsApiHandler", "creating file failed, filePath is ".concat(String.valueOf(str)));
                C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                AppMethodBeat.m2505o(9010);
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
                    C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e3, "", new Object[0]);
                }
                C4990ab.m7410d("MicroMsg.JsApiHandler", "writeToFile ok! ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(9010);
                return true;
            } catch (Exception e4) {
                e = e4;
                outputStream = bufferedOutputStream;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                    C4990ab.m7420w("MicroMsg.JsApiHandler", "write to file error");
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(9010);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e32) {
                            C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e32, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(9010);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                outputStream = bufferedOutputStream;
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(9010);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
            C4990ab.m7420w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(9010);
            return false;
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(final String str) {
        AppMethodBeat.m2504i(8940);
        if (str != null) {
            this.uFr.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8930);
                    Map M = C44786d.m81759M(str.split(","));
                    String a = C44786d.m81760a(C44786d.this, "hosts");
                    if (!C44786d.m81758B(a, M)) {
                        C4990ab.m7412e("MicroMsg.JsApiHandler", "failed to write Hosts file");
                    } else if (!(C44786d.this.icy == null || C44786d.this.uFo == null)) {
                        try {
                            C44786d.this.icy.mo15516J(0, C44786d.this.uFo.getUrl(), a);
                            AppMethodBeat.m2505o(8930);
                            return;
                        } catch (RemoteException e) {
                            C4990ab.m7413e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", e.getMessage());
                            AppMethodBeat.m2505o(8930);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(8930);
                }
            });
        }
        AppMethodBeat.m2505o(8940);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(final String str) {
        AppMethodBeat.m2504i(8941);
        if (str != null) {
            this.uFr.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8931);
                    String a = C44786d.m81760a(C44786d.this, "html");
                    if (!C44786d.m81772hl(a, str)) {
                        C4990ab.m7412e("MicroMsg.JsApiHandler", "failed to write Html file");
                    } else if (!(C44786d.this.icy == null || C44786d.this.uFo == null)) {
                        try {
                            C44786d.this.icy.mo15516J(1, C44786d.this.uFo.getUrl(), a);
                            AppMethodBeat.m2505o(8931);
                            return;
                        } catch (RemoteException e) {
                            C4990ab.m7413e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", e.getMessage());
                            AppMethodBeat.m2505o(8931);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(8931);
                }
            });
        }
        AppMethodBeat.m2505o(8941);
    }

    /* renamed from: c */
    static /* synthetic */ void m81765c(C44786d c44786d) {
        AppMethodBeat.m2504i(9011);
        if (c44786d.uFp.size() <= 0) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "dealMsgQueue fail, resultValueList is empty");
            AppMethodBeat.m2505o(9011);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsApiHandler", "dealMsgQueue, pre msgList = " + c44786d.uFq.size());
        List i = C23124a.m35501i((String) c44786d.uFp.remove(0), c44786d.uFv, c44786d.uFw);
        if (!C5046bo.m7548ek(i)) {
            c44786d.uFq.addAll(i);
            C4990ab.m7417i("MicroMsg.JsApiHandler", "now msg list size : %d", Integer.valueOf(c44786d.uFq.size()));
        }
        C4990ab.m7416i("MicroMsg.JsApiHandler", "dealMsgQueue, post msgList = " + c44786d.uFq.size());
        c44786d.dcl();
        if (c44786d.uFr != null) {
            c44786d.uFr.post(new C4398365());
        }
        AppMethodBeat.m2505o(9011);
    }

    /* renamed from: f */
    static /* synthetic */ void m81768f(C44786d c44786d) {
        AppMethodBeat.m2504i(9012);
        do {
        } while (c44786d.dcm());
        AppMethodBeat.m2505o(9012);
    }

    /* renamed from: M */
    static /* synthetic */ Map m81759M(String[] strArr) {
        AppMethodBeat.m2504i(9013);
        int length = strArr == null ? 0 : strArr.length;
        if (length == 0) {
            AppMethodBeat.m2505o(9013);
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
        AppMethodBeat.m2505o(9013);
        return hashMap;
    }
}
