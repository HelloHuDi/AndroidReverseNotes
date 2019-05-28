package com.tencent.p177mm.plugin.appbrand.jsapi.p316t;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.p230g.p231a.C42013j;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C42583c.C42581b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C42583c.C42582c;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.plugin.webview.modeltools.C14543h;
import com.tencent.p177mm.plugin.webview.modeltools.C14543h.C14545c;
import com.tencent.p177mm.plugin.webview.modeltools.C43923d;
import com.tencent.p177mm.plugin.webview.modeltools.NFCIPCHelper;
import com.tencent.p177mm.plugin.webview.modeltools.NFCIPCHelper.C14535a;
import com.tencent.p177mm.plugin.webview.modeltools.NFCIPCHelper.NFCEventTransfer;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C14672i;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C43989k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C46936m;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u.C23348a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.C6031l.C6032a;
import com.tencent.xweb.WebView.C41116b;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.e */
public class C27092e implements OnCreateContextMenuListener, C42581b {
    private C46696j icA;
    private String icB;
    int icC;
    int icD;
    C14543h icE;
    C41116b icF;
    C41116b icG;
    private final C43923d icH = new C43923d();
    final C42582c icI;
    private C44786d icJ;
    private C46936m icK = new C23431();
    private C14545c icL = new C270907();
    private String icl;
    MMWebViewWithJsApi icv;
    private C27091b icw;
    private C27099a icx;
    private C46434d icy;
    private C40344k icz;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.e$1 */
    class C23431 extends C46936m {
        C23431() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x00e6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: g */
        public final Bundle mo6226g(int i, Bundle bundle) {
            AppMethodBeat.m2504i(17026);
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_webview_container_env", "miniProgram");
            switch (i) {
                case 101:
                    bundle.setClassLoader(C27092e.class.getClassLoader());
                    C25985d.m41467b(C27092e.m43074g(C27092e.this), bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")));
                    break;
                case C33333a.CTRL_INDEX /*139*/:
                    try {
                        C27092e.this.icI.mo68015D(new JSONObject(bundle.getString("info")));
                        break;
                    } catch (Exception e) {
                        break;
                    }
                case 140:
                    bundle2.putInt("key_webview_preverify_info_scene", 1);
                    bundle2.putString("key_webview_preverify_info_source_appid", C27092e.this.icI.getAppId());
                    break;
                case 145:
                    bundle2.putStringArray("key_webview_apbrand_jsapi_report_args", C27092e.this.icI.getJsApiReportArgs());
                    break;
                case WearableStatusCodes.DUPLICATE_LISTENER /*4001*/:
                case WearableStatusCodes.UNKNOWN_LISTENER /*4002*/:
                case WearableStatusCodes.DATA_ITEM_TOO_LARGE /*4003*/:
                case WearableStatusCodes.INVALID_TARGET_NODE /*4004*/:
                case WearableStatusCodes.ASSET_UNAVAILABLE /*4005*/:
                case WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED /*4008*/:
                    C42013j c42013j = new C42013j();
                    c42013j.csb.context = C27092e.m43074g(C27092e.this);
                    c42013j.csb.actionCode = i;
                    if (WearableStatusCodes.DATA_ITEM_TOO_LARGE == i) {
                        c42013j.csb.csd = bundle.getString("apdu");
                    } else if (WearableStatusCodes.INVALID_TARGET_NODE == i) {
                        String string = bundle.getString("apdus");
                        boolean z = bundle.getBoolean("breakIfFail", true);
                        boolean z2 = bundle.getBoolean("breakIfTrue", false);
                        c42013j.csb.csd = string;
                        c42013j.csb.cse = z;
                        c42013j.csb.csf = z2;
                    }
                    C4990ab.m7417i("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult actionCode: %d", Integer.valueOf(c42013j.csb.actionCode));
                    try {
                        NFCEventTransfer nFCEventTransfer = (NFCEventTransfer) XIPCInvoker.m83628a("com.tencent.mm:tools", new NFCEventTransfer(c42013j), C14535a.class);
                        if (nFCEventTransfer == null || nFCEventTransfer.csg == null) {
                            NFCIPCHelper.cYy();
                            if (c42013j.csc.csg != null) {
                                bundle2.putAll(c42013j.csc.csg);
                                break;
                            }
                        }
                        c42013j.csc.csg = nFCEventTransfer.csg;
                        if (c42013j.csc.csg != null) {
                        }
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.NFCIPCHelper", e2, "alvinluo nfcInvokeAsResult exception", new Object[0]);
                        NFCIPCHelper.cYy();
                    }
                    break;
            }
            AppMethodBeat.m2505o(17026);
            return bundle2;
        }

        /* renamed from: e */
        public final void mo6225e(String str, final String str2, int i, int i2) {
            AppMethodBeat.m2504i(17027);
            C4990ab.m7410d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: ".concat(String.valueOf(str2)));
            if (C27092e.this.icE == null || str == null || !str.equals(C27092e.this.icE.upr)) {
                AppMethodBeat.m2505o(17027);
            } else if (i != 22) {
                AppMethodBeat.m2505o(17027);
            } else {
                if (C27092e.this.icE != null) {
                    C27092e.this.icE.cYK();
                }
                C27092e.this.icC = i;
                C27092e.this.icD = i2;
                if (str2 == null || C27092e.this.icA == null) {
                    AppMethodBeat.m2505o(17027);
                    return;
                }
                C27092e.this.icI.runOnUiThread(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.e$1$1$1 */
                    class C23451 implements OnCreateContextMenuListener {
                        C23451() {
                        }

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.m2504i(17024);
                            if (C27092e.this.icF != null) {
                                C4990ab.m7410d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show webkit menu");
                                C27092e.m43062a(C27092e.this, contextMenu, C27092e.this.icF);
                                C27092e.this.icF = null;
                                AppMethodBeat.m2505o(17024);
                                return;
                            }
                            if (C27092e.this.icG != null) {
                                C4990ab.m7410d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show IX5 menu");
                                C27092e.m43067b(C27092e.this, contextMenu, C27092e.this.icG);
                                C27092e.this.icG = null;
                            }
                            AppMethodBeat.m2505o(17024);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(17025);
                        C27092e.this.icB = str2;
                        C27092e.this.icA.mo75009b(C27092e.this.icv, new C23451(), null);
                        C27092e.this.icA.cuu();
                        AppMethodBeat.m2505o(17025);
                    }
                });
                AppMethodBeat.m2505o(17027);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.e$2 */
    class C23462 implements OnCancelListener {
        C23462() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(17028);
            if (!(C27092e.this.icE == null || C27092e.this.icy == null)) {
                try {
                    C27092e.this.icy.afo(C27092e.this.icE.upr);
                    C27092e.this.icE.cYK();
                    AppMethodBeat.m2505o(17028);
                    return;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cancel capture failed");
                }
            }
            AppMethodBeat.m2505o(17028);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.e$7 */
    class C270907 implements C14545c {
        C270907() {
        }

        /* renamed from: BY */
        public final void mo26772BY(String str) {
            AppMethodBeat.m2504i(17035);
            try {
                if (C27092e.this.icy != null) {
                    C27092e.this.icy.mo15531a(str, new int[]{3}, 0, 0);
                    AppMethodBeat.m2505o(17035);
                    return;
                }
                C4990ab.m7416i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
                AppMethodBeat.m2505o(17035);
            } catch (RemoteException e) {
                C4990ab.m7412e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
                AppMethodBeat.m2505o(17035);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.e$b */
    class C27091b extends C43989k {
        C27091b(MMWebView mMWebView) {
            super(mMWebView);
        }

        public final C46936m aGt() {
            AppMethodBeat.m2504i(17042);
            C46936m a = C27092e.this.icK;
            AppMethodBeat.m2505o(17042);
            return a;
        }

        /* renamed from: a */
        public final void mo38561a(C46434d c46434d, C40344k c40344k) {
            AppMethodBeat.m2504i(17043);
            C27092e.this.icy = c46434d;
            C27092e.this.icz = c40344k;
            try {
                Bundle bundle = new Bundle();
                bundle.putString("key_webview_container_env", "miniProgram");
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("jsapiargs", bundle);
                c46434d.mo15526a(20, bundle2, this.fow.hashCode());
                AppMethodBeat.m2505o(17043);
            } catch (RemoteException e) {
                C4990ab.m7412e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + e.getMessage());
                AppMethodBeat.m2505o(17043);
            }
        }

        /* renamed from: oZ */
        public final boolean mo44753oZ(String str) {
            AppMethodBeat.m2504i(17044);
            Intent intent;
            if (str.startsWith("file:///android_asset")) {
                C4990ab.m7421w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found %s", str);
                AppMethodBeat.m2505o(17044);
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse(str));
                this.fow.getContext().startActivity(intent);
                AppMethodBeat.m2505o(17044);
                return true;
            } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse(str));
                this.fow.getContext().startActivity(intent);
                AppMethodBeat.m2505o(17044);
                return true;
            } else {
                int i;
                if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str) || C5046bo.nullAsNil(str).startsWith("weixin")) {
                    i = true;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    C4990ab.m7413e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found unacceptable %s", str);
                    AppMethodBeat.m2505o(17044);
                    return true;
                }
                AppMethodBeat.m2505o(17044);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo38564a(com.tencent.xweb.WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(17045);
            C27092e.this.icl = str;
            C27092e.this.icI.mo68014BW(str);
            AppMethodBeat.m2505o(17045);
        }

        /* renamed from: e */
        public final void mo38573e(com.tencent.xweb.WebView webView, String str) {
            AppMethodBeat.m2504i(17046);
            C27092e.this.icl = str;
            C27092e.this.icI.mo68018bF(str);
            AppMethodBeat.m2505o(17046);
        }

        public final int aGu() {
            AppMethodBeat.m2504i(17047);
            if (C27092e.this.icI.aGr()) {
                AppMethodBeat.m2505o(17047);
                return 55;
            }
            AppMethodBeat.m2505o(17047);
            return 49;
        }

        public final int aGv() {
            AppMethodBeat.m2504i(17048);
            if (C27092e.this.icI.aGr()) {
                AppMethodBeat.m2505o(17048);
                return 55;
            }
            AppMethodBeat.m2505o(17048);
            return 49;
        }

        /* renamed from: BZ */
        public final String mo44749BZ(String str) {
            AppMethodBeat.m2504i(17049);
            String c;
            if (C27092e.this.icl == null || !C27092e.this.icl.equals(str)) {
                c = C27092e.this.icl;
                AppMethodBeat.m2505o(17049);
                return c;
            }
            c = "";
            AppMethodBeat.m2505o(17049);
            return c;
        }

        /* renamed from: g */
        public final void mo44752g(Bundle bundle, String str) {
            AppMethodBeat.m2504i(17050);
            super.mo44752g(bundle, str);
            bundle.putString("geta8key_data_appid", C27092e.this.icI.getAppId());
            AppMethodBeat.m2505o(17050);
        }

        /* renamed from: a */
        public final void mo7559a(com.tencent.xweb.WebView webView, int i, String str, String str2) {
            AppMethodBeat.m2504i(17051);
            C27092e.this.icI.mo68022m(str2, i, str);
            AppMethodBeat.m2505o(17051);
        }

        /* renamed from: a */
        public final void mo38562a(C44786d c44786d) {
            AppMethodBeat.m2504i(17052);
            super.mo38562a(c44786d);
            if (!(c44786d == null || C27092e.this.icI == null)) {
                c44786d.uqT = C27092e.this.icI.getAppId();
            }
            C27092e.this.icJ = c44786d;
            AppMethodBeat.m2505o(17052);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.e$a */
    class C27099a extends C14672i {
        C27099a(MMWebViewWithJsApi mMWebViewWithJsApi) {
            super(mMWebViewWithJsApi);
        }

        /* renamed from: d */
        public final void mo7557d(com.tencent.xweb.WebView webView, String str) {
            AppMethodBeat.m2504i(17037);
            super.mo7557d(webView, str);
            C27092e.this.icI.mo68013BV(str);
            AppMethodBeat.m2505o(17037);
        }

        public final void onClose() {
            AppMethodBeat.m2504i(17038);
            C27092e.this.icI.aGp();
            AppMethodBeat.m2505o(17038);
        }

        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            AppMethodBeat.m2504i(17039);
            m43082a(valueCallback, null, str, str2);
            AppMethodBeat.m2505o(17039);
        }

        /* renamed from: a */
        public final boolean mo13206a(com.tencent.xweb.WebView webView, ValueCallback<Uri[]> valueCallback, C6032a c6032a) {
            AppMethodBeat.m2504i(17040);
            if (c6032a.getMode() != 0) {
                AppMethodBeat.m2505o(17040);
                return false;
            } else if (c6032a.getAcceptTypes() == null || c6032a.getAcceptTypes().length <= 0) {
                C4990ab.m7416i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                AppMethodBeat.m2505o(17040);
                return true;
            } else {
                String str = c6032a.getAcceptTypes()[0];
                String str2 = "*";
                if (c6032a.isCaptureEnabled()) {
                    if ("image/*".equalsIgnoreCase(str)) {
                        str2 = "camera";
                    } else if ("video/*".equalsIgnoreCase(str)) {
                        str2 = "camcorder";
                    }
                }
                m43082a(null, valueCallback, str, str2);
                AppMethodBeat.m2505o(17040);
                return true;
            }
        }

        /* renamed from: a */
        private void m43082a(ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
            AppMethodBeat.m2504i(17041);
            if (C27092e.this.icv.getContext() instanceof MMActivity) {
                final MMActivity mMActivity = (MMActivity) C27092e.this.icv.getContext();
                mMActivity.ifE = new C5186a() {
                    /* renamed from: c */
                    public final void mo6069c(int i, int i2, Intent intent) {
                        AppMethodBeat.m2504i(17036);
                        C27092e.this.icH.mo69606b(mMActivity, i, i2, intent);
                        AppMethodBeat.m2505o(17036);
                    }
                };
                C27092e.this.icH.mo69604a(mMActivity, C27092e.this.icz, valueCallback, valueCallback2, str, str2);
                AppMethodBeat.m2505o(17041);
                return;
            }
            AppMethodBeat.m2505o(17041);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m43062a(C27092e c27092e, ContextMenu contextMenu, C41116b c41116b) {
        AppMethodBeat.m2504i(17063);
        c27092e.m43066b(contextMenu, c41116b);
        AppMethodBeat.m2505o(17063);
    }

    /* renamed from: b */
    static /* synthetic */ void m43067b(C27092e c27092e, ContextMenu contextMenu, C41116b c41116b) {
        AppMethodBeat.m2504i(17064);
        c27092e.m43061a(contextMenu, c41116b);
        AppMethodBeat.m2505o(17064);
    }

    public C27092e(C42582c c42582c) {
        AppMethodBeat.m2504i(17053);
        this.icI = c42582c;
        this.icv = (MMWebViewWithJsApi) c42582c.getWebView();
        this.icw = new C27091b(this.icv);
        this.icx = new C27099a(this.icv);
        this.icv.setWebViewClient(this.icw);
        this.icv.setWebChromeClient(this.icx);
        this.icv.setCleanOnDetached(true);
        this.icA = new C46696j(this.icv.getContext());
        this.icA.mo75005a(this.icv, this, null);
        this.icA.mo75012e(new C23462());
        AppMethodBeat.m2505o(17053);
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(17054);
        this.icw.cleanup();
        this.icv.destroy();
        AppMethodBeat.m2505o(17054);
    }

    /* renamed from: k */
    public final void mo44755k(boolean z, int i) {
        AppMethodBeat.m2504i(17055);
        C4990ab.m7417i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "notifyKeyboardStateChanged, shown[%b], height[%d]", Boolean.valueOf(z), Integer.valueOf(i));
        C44786d c44786d = this.icJ;
        if (c44786d != null) {
            if (!z) {
                i = 0;
            }
            c44786d.mo71879JM(i);
        }
        AppMethodBeat.m2505o(17055);
    }

    /* renamed from: wU */
    public final void mo44757wU() {
        AppMethodBeat.m2504i(17056);
        if (this.icw.uDd != null) {
            this.icw.uDd.mo71938nN(true);
        }
        AppMethodBeat.m2505o(17056);
    }

    /* renamed from: wW */
    public final void mo44758wW() {
        AppMethodBeat.m2504i(17057);
        if (this.icw.uDd != null) {
            this.icw.uDd.mo71938nN(false);
        }
        AppMethodBeat.m2505o(17057);
    }

    /* renamed from: a */
    private boolean m43063a(ContextMenu contextMenu, final String str) {
        boolean isSDCardAvailable;
        AppMethodBeat.m2504i(17058);
        try {
            isSDCardAvailable = this.icy.isSDCardAvailable();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            AppMethodBeat.m2505o(17058);
            return true;
        } else if (this.icz == null) {
            AppMethodBeat.m2505o(17058);
            return true;
        } else {
            contextMenu.setHeaderTitle(C25738R.string.g2h);
            try {
                isSDCardAvailable = this.icy.cZd();
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", e2.getMessage());
                isSDCardAvailable = false;
            }
            C4990ab.m7417i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(this.icz.cZT().dmn()), Boolean.valueOf(this.icz.cZT().dmo()));
            if (isSDCardAvailable && r3) {
                contextMenu.add(0, 0, 0, this.icv.getContext().getString(C25738R.string.dhh)).setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.e$3$1 */
                    class C270941 implements C23348a {
                        C270941() {
                        }

                        /* renamed from: BX */
                        public final void mo26720BX(String str) {
                            AppMethodBeat.m2504i(17029);
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7420w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
                                AppMethodBeat.m2505o(17029);
                                return;
                            }
                            C27092e.m43069c(C27092e.this, str);
                            AppMethodBeat.m2505o(17029);
                        }
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.m2504i(17030);
                        try {
                            C30152u.m47741a(C27092e.m43074g(C27092e.this), str, C44576b.dTR().getCookie(str), C27092e.this.icy.isSDCardAvailable(), new C270941());
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
                        }
                        AppMethodBeat.m2505o(17030);
                        return true;
                    }
                });
            }
            contextMenu.add(0, 0, 0, this.icv.getContext().getString(C25738R.string.dwz)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    boolean isSDCardAvailable;
                    AppMethodBeat.m2504i(17031);
                    try {
                        isSDCardAvailable = C27092e.this.icy.isSDCardAvailable();
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
                        isSDCardAvailable = false;
                    }
                    try {
                        C30152u.m47740a(C27092e.m43074g(C27092e.this), str, C44576b.dTR().getCookie(str), isSDCardAvailable);
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", e2.getMessage());
                    }
                    AppMethodBeat.m2505o(17031);
                    return true;
                }
            });
            if (isSDCardAvailable && r4) {
                contextMenu.add(0, 0, 0, this.icv.getContext().getString(C25738R.string.dcq)).setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.e$5$1 */
                    class C270981 implements C23348a {
                        C270981() {
                        }

                        /* renamed from: BX */
                        public final void mo26720BX(String str) {
                            AppMethodBeat.m2504i(17032);
                            C27092e.m43071d(C27092e.this, str);
                            AppMethodBeat.m2505o(17032);
                        }
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.m2504i(17033);
                        try {
                            boolean isSDCardAvailable = C27092e.this.icy.isSDCardAvailable();
                            String replaceAll = str.replaceAll("tp=webp", "");
                            C30152u.m47741a(C27092e.m43074g(C27092e.this), replaceAll, C44576b.dTR().getCookie(replaceAll), isSDCardAvailable, new C270981());
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
                        }
                        AppMethodBeat.m2505o(17033);
                        return true;
                    }
                });
            }
            if (this.icB == null) {
                AppMethodBeat.m2505o(17058);
                return false;
            } else if (C13119a.m21150ba(this.icC, this.icB)) {
                final String str2 = this.icB;
                contextMenu.add(0, 0, 0, this.icv.getContext().getString(C25738R.string.diz)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.m2504i(17034);
                        C27092e c27092e = C27092e.this;
                        String str = str2;
                        String c = C27092e.this.icl;
                        String str2 = str;
                        int i = C27092e.this.icC;
                        int i2 = C27092e.this.icD;
                        if (str != null) {
                            Intent intent = new Intent();
                            intent.setClass(c27092e.icv.getContext(), WebviewScanImageActivity.class);
                            intent.putExtra("key_string_for_scan", str);
                            intent.putExtra("key_string_for_url", c);
                            intent.putExtra("key_string_for_image_url", str2);
                            intent.putExtra("key_codetype_for_scan", i);
                            intent.putExtra("key_codeversion_for_scan", i2);
                            if (!(c27092e.icI == null || C5046bo.isNullOrNil(c27092e.icI.getAppId()))) {
                                intent.putExtra("key_string_for_wxapp_id", c27092e.icI.getAppId());
                            }
                            c27092e.icv.getContext().startActivity(intent);
                        }
                        AppMethodBeat.m2505o(17034);
                        return false;
                    }
                });
                this.icB = null;
                AppMethodBeat.m2505o(17058);
                return true;
            } else {
                this.icB = null;
                AppMethodBeat.m2505o(17058);
                return true;
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(17061);
        C41116b hitTestResult;
        if (view instanceof android.webkit.WebView) {
            hitTestResult = this.icv.getHitTestResult();
            if (hitTestResult == null) {
                AppMethodBeat.m2505o(17061);
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                m43066b(contextMenu, hitTestResult);
            }
            AppMethodBeat.m2505o(17061);
            return;
        }
        if (view instanceof MMWebView) {
            hitTestResult = ((MMWebView) view).getHitTestResult();
            if (hitTestResult == null) {
                AppMethodBeat.m2505o(17061);
                return;
            } else if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                m43061a(contextMenu, hitTestResult);
            }
        }
        AppMethodBeat.m2505o(17061);
    }

    /* renamed from: a */
    private void m43061a(ContextMenu contextMenu, C41116b c41116b) {
        AppMethodBeat.m2504i(17059);
        if (!m43063a(contextMenu, c41116b.mExtra) && this.icz.cZT().dml()) {
            this.icG = c41116b;
            this.icE = new C14543h();
            this.icE.mo26769a(this.icv, this.icL);
        }
        AppMethodBeat.m2505o(17059);
    }

    /* renamed from: b */
    private void m43066b(ContextMenu contextMenu, C41116b c41116b) {
        AppMethodBeat.m2504i(17060);
        if (!m43063a(contextMenu, c41116b.mExtra) && this.icz.cZT().dml()) {
            this.icF = c41116b;
            this.icE = new C14543h();
            this.icE.mo26769a(this.icv, this.icL);
        }
        AppMethodBeat.m2505o(17060);
    }

    /* renamed from: g */
    static /* synthetic */ Context m43074g(C27092e c27092e) {
        AppMethodBeat.m2504i(17062);
        Context context = c27092e.icv.getContext();
        AppMethodBeat.m2505o(17062);
        return context;
    }

    /* renamed from: c */
    static /* synthetic */ void m43069c(C27092e c27092e, String str) {
        AppMethodBeat.m2504i(17065);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
            intent.putExtra("Retr_Msg_Type", 4);
        }
        C25985d.m41473f(c27092e.icv.getContext(), ".ui.transmit.MsgRetransmitUI", intent);
        AppMethodBeat.m2505o(17065);
    }

    /* renamed from: d */
    static /* synthetic */ void m43071d(C27092e c27092e, String str) {
        AppMethodBeat.m2504i(17066);
        try {
            if (c27092e.icy.afm(str) == 0) {
                Toast.makeText(c27092e.icv.getContext(), c27092e.icv.getContext().getString(C25738R.string.bpv), 0).show();
            }
            AppMethodBeat.m2505o(17066);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "favoriteUrl fail, ex = " + e.getMessage());
            AppMethodBeat.m2505o(17066);
        }
    }
}
