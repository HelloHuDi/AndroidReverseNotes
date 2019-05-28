package com.tencent.mm.plugin.appbrand.jsapi.t;

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
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.jsapi.t.c.c;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.NFCEventTransfer;
import com.tencent.mm.plugin.webview.modeltools.d;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public class e implements OnCreateContextMenuListener, com.tencent.mm.plugin.appbrand.jsapi.t.c.b {
    private j icA;
    private String icB;
    int icC;
    int icD;
    h icE;
    com.tencent.xweb.WebView.b icF;
    com.tencent.xweb.WebView.b icG;
    private final d icH = new d();
    final c icI;
    private com.tencent.mm.plugin.webview.ui.tools.jsapi.d icJ;
    private m icK = new m() {
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00e6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final Bundle g(int i, Bundle bundle) {
            AppMethodBeat.i(17026);
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_webview_container_env", "miniProgram");
            switch (i) {
                case 101:
                    bundle.setClassLoader(e.class.getClassLoader());
                    com.tencent.mm.bp.d.b(e.g(e.this), bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")));
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX /*139*/:
                    try {
                        e.this.icI.D(new JSONObject(bundle.getString("info")));
                        break;
                    } catch (Exception e) {
                        break;
                    }
                case 140:
                    bundle2.putInt("key_webview_preverify_info_scene", 1);
                    bundle2.putString("key_webview_preverify_info_source_appid", e.this.icI.getAppId());
                    break;
                case 145:
                    bundle2.putStringArray("key_webview_apbrand_jsapi_report_args", e.this.icI.getJsApiReportArgs());
                    break;
                case WearableStatusCodes.DUPLICATE_LISTENER /*4001*/:
                case WearableStatusCodes.UNKNOWN_LISTENER /*4002*/:
                case WearableStatusCodes.DATA_ITEM_TOO_LARGE /*4003*/:
                case WearableStatusCodes.INVALID_TARGET_NODE /*4004*/:
                case WearableStatusCodes.ASSET_UNAVAILABLE /*4005*/:
                case WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED /*4008*/:
                    com.tencent.mm.g.a.j jVar = new com.tencent.mm.g.a.j();
                    jVar.csb.context = e.g(e.this);
                    jVar.csb.actionCode = i;
                    if (WearableStatusCodes.DATA_ITEM_TOO_LARGE == i) {
                        jVar.csb.csd = bundle.getString("apdu");
                    } else if (WearableStatusCodes.INVALID_TARGET_NODE == i) {
                        String string = bundle.getString("apdus");
                        boolean z = bundle.getBoolean("breakIfFail", true);
                        boolean z2 = bundle.getBoolean("breakIfTrue", false);
                        jVar.csb.csd = string;
                        jVar.csb.cse = z;
                        jVar.csb.csf = z2;
                    }
                    ab.i("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult actionCode: %d", Integer.valueOf(jVar.csb.actionCode));
                    try {
                        NFCEventTransfer nFCEventTransfer = (NFCEventTransfer) XIPCInvoker.a("com.tencent.mm:tools", new NFCEventTransfer(jVar), com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.a.class);
                        if (nFCEventTransfer == null || nFCEventTransfer.csg == null) {
                            NFCIPCHelper.cYy();
                            if (jVar.csc.csg != null) {
                                bundle2.putAll(jVar.csc.csg);
                                break;
                            }
                        }
                        jVar.csc.csg = nFCEventTransfer.csg;
                        if (jVar.csc.csg != null) {
                        }
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.NFCIPCHelper", e2, "alvinluo nfcInvokeAsResult exception", new Object[0]);
                        NFCIPCHelper.cYy();
                    }
                    break;
            }
            AppMethodBeat.o(17026);
            return bundle2;
        }

        public final void e(String str, final String str2, int i, int i2) {
            AppMethodBeat.i(17027);
            ab.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: ".concat(String.valueOf(str2)));
            if (e.this.icE == null || str == null || !str.equals(e.this.icE.upr)) {
                AppMethodBeat.o(17027);
            } else if (i != 22) {
                AppMethodBeat.o(17027);
            } else {
                if (e.this.icE != null) {
                    e.this.icE.cYK();
                }
                e.this.icC = i;
                e.this.icD = i2;
                if (str2 == null || e.this.icA == null) {
                    AppMethodBeat.o(17027);
                    return;
                }
                e.this.icI.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(17025);
                        e.this.icB = str2;
                        e.this.icA.b(e.this.icv, new OnCreateContextMenuListener() {
                            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                AppMethodBeat.i(17024);
                                if (e.this.icF != null) {
                                    ab.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show webkit menu");
                                    e.a(e.this, contextMenu, e.this.icF);
                                    e.this.icF = null;
                                    AppMethodBeat.o(17024);
                                    return;
                                }
                                if (e.this.icG != null) {
                                    ab.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show IX5 menu");
                                    e.b(e.this, contextMenu, e.this.icG);
                                    e.this.icG = null;
                                }
                                AppMethodBeat.o(17024);
                            }
                        }, null);
                        e.this.icA.cuu();
                        AppMethodBeat.o(17025);
                    }
                });
                AppMethodBeat.o(17027);
            }
        }
    };
    private h.c icL = new h.c() {
        public final void BY(String str) {
            AppMethodBeat.i(17035);
            try {
                if (e.this.icy != null) {
                    e.this.icy.a(str, new int[]{3}, 0, 0);
                    AppMethodBeat.o(17035);
                    return;
                }
                ab.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
                AppMethodBeat.o(17035);
            } catch (RemoteException e) {
                ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
                AppMethodBeat.o(17035);
            }
        }
    };
    private String icl;
    MMWebViewWithJsApi icv;
    private b icw;
    private a icx;
    private com.tencent.mm.plugin.webview.stub.d icy;
    private k icz;

    class b extends com.tencent.mm.plugin.webview.ui.tools.widget.k {
        b(MMWebView mMWebView) {
            super(mMWebView);
        }

        public final m aGt() {
            AppMethodBeat.i(17042);
            m a = e.this.icK;
            AppMethodBeat.o(17042);
            return a;
        }

        public final void a(com.tencent.mm.plugin.webview.stub.d dVar, k kVar) {
            AppMethodBeat.i(17043);
            e.this.icy = dVar;
            e.this.icz = kVar;
            try {
                Bundle bundle = new Bundle();
                bundle.putString("key_webview_container_env", "miniProgram");
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("jsapiargs", bundle);
                dVar.a(20, bundle2, this.fow.hashCode());
                AppMethodBeat.o(17043);
            } catch (RemoteException e) {
                ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + e.getMessage());
                AppMethodBeat.o(17043);
            }
        }

        public final boolean oZ(String str) {
            AppMethodBeat.i(17044);
            Intent intent;
            if (str.startsWith("file:///android_asset")) {
                ab.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found %s", str);
                AppMethodBeat.o(17044);
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse(str));
                this.fow.getContext().startActivity(intent);
                AppMethodBeat.o(17044);
                return true;
            } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse(str));
                this.fow.getContext().startActivity(intent);
                AppMethodBeat.o(17044);
                return true;
            } else {
                int i;
                if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str) || bo.nullAsNil(str).startsWith("weixin")) {
                    i = true;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found unacceptable %s", str);
                    AppMethodBeat.o(17044);
                    return true;
                }
                AppMethodBeat.o(17044);
                return false;
            }
        }

        public final void a(com.tencent.xweb.WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(17045);
            e.this.icl = str;
            e.this.icI.BW(str);
            AppMethodBeat.o(17045);
        }

        public final void e(com.tencent.xweb.WebView webView, String str) {
            AppMethodBeat.i(17046);
            e.this.icl = str;
            e.this.icI.bF(str);
            AppMethodBeat.o(17046);
        }

        public final int aGu() {
            AppMethodBeat.i(17047);
            if (e.this.icI.aGr()) {
                AppMethodBeat.o(17047);
                return 55;
            }
            AppMethodBeat.o(17047);
            return 49;
        }

        public final int aGv() {
            AppMethodBeat.i(17048);
            if (e.this.icI.aGr()) {
                AppMethodBeat.o(17048);
                return 55;
            }
            AppMethodBeat.o(17048);
            return 49;
        }

        public final String BZ(String str) {
            AppMethodBeat.i(17049);
            String c;
            if (e.this.icl == null || !e.this.icl.equals(str)) {
                c = e.this.icl;
                AppMethodBeat.o(17049);
                return c;
            }
            c = "";
            AppMethodBeat.o(17049);
            return c;
        }

        public final void g(Bundle bundle, String str) {
            AppMethodBeat.i(17050);
            super.g(bundle, str);
            bundle.putString("geta8key_data_appid", e.this.icI.getAppId());
            AppMethodBeat.o(17050);
        }

        public final void a(com.tencent.xweb.WebView webView, int i, String str, String str2) {
            AppMethodBeat.i(17051);
            e.this.icI.m(str2, i, str);
            AppMethodBeat.o(17051);
        }

        public final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
            AppMethodBeat.i(17052);
            super.a(dVar);
            if (!(dVar == null || e.this.icI == null)) {
                dVar.uqT = e.this.icI.getAppId();
            }
            e.this.icJ = dVar;
            AppMethodBeat.o(17052);
        }
    }

    class a extends i {
        a(MMWebViewWithJsApi mMWebViewWithJsApi) {
            super(mMWebViewWithJsApi);
        }

        public final void d(com.tencent.xweb.WebView webView, String str) {
            AppMethodBeat.i(17037);
            super.d(webView, str);
            e.this.icI.BV(str);
            AppMethodBeat.o(17037);
        }

        public final void onClose() {
            AppMethodBeat.i(17038);
            e.this.icI.aGp();
            AppMethodBeat.o(17038);
        }

        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            AppMethodBeat.i(17039);
            a(valueCallback, null, str, str2);
            AppMethodBeat.o(17039);
        }

        public final boolean a(com.tencent.xweb.WebView webView, ValueCallback<Uri[]> valueCallback, com.tencent.xweb.l.a aVar) {
            AppMethodBeat.i(17040);
            if (aVar.getMode() != 0) {
                AppMethodBeat.o(17040);
                return false;
            } else if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                ab.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                AppMethodBeat.o(17040);
                return true;
            } else {
                String str = aVar.getAcceptTypes()[0];
                String str2 = "*";
                if (aVar.isCaptureEnabled()) {
                    if ("image/*".equalsIgnoreCase(str)) {
                        str2 = "camera";
                    } else if ("video/*".equalsIgnoreCase(str)) {
                        str2 = "camcorder";
                    }
                }
                a(null, valueCallback, str, str2);
                AppMethodBeat.o(17040);
                return true;
            }
        }

        private void a(ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
            AppMethodBeat.i(17041);
            if (e.this.icv.getContext() instanceof MMActivity) {
                final MMActivity mMActivity = (MMActivity) e.this.icv.getContext();
                mMActivity.ifE = new com.tencent.mm.ui.MMActivity.a() {
                    public final void c(int i, int i2, Intent intent) {
                        AppMethodBeat.i(17036);
                        e.this.icH.b(mMActivity, i, i2, intent);
                        AppMethodBeat.o(17036);
                    }
                };
                e.this.icH.a(mMActivity, e.this.icz, valueCallback, valueCallback2, str, str2);
                AppMethodBeat.o(17041);
                return;
            }
            AppMethodBeat.o(17041);
        }
    }

    static /* synthetic */ void a(e eVar, ContextMenu contextMenu, com.tencent.xweb.WebView.b bVar) {
        AppMethodBeat.i(17063);
        eVar.b(contextMenu, bVar);
        AppMethodBeat.o(17063);
    }

    static /* synthetic */ void b(e eVar, ContextMenu contextMenu, com.tencent.xweb.WebView.b bVar) {
        AppMethodBeat.i(17064);
        eVar.a(contextMenu, bVar);
        AppMethodBeat.o(17064);
    }

    public e(c cVar) {
        AppMethodBeat.i(17053);
        this.icI = cVar;
        this.icv = (MMWebViewWithJsApi) cVar.getWebView();
        this.icw = new b(this.icv);
        this.icx = new a(this.icv);
        this.icv.setWebViewClient(this.icw);
        this.icv.setWebChromeClient(this.icx);
        this.icv.setCleanOnDetached(true);
        this.icA = new j(this.icv.getContext());
        this.icA.a(this.icv, this, null);
        this.icA.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(17028);
                if (!(e.this.icE == null || e.this.icy == null)) {
                    try {
                        e.this.icy.afo(e.this.icE.upr);
                        e.this.icE.cYK();
                        AppMethodBeat.o(17028);
                        return;
                    } catch (Exception e) {
                        ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cancel capture failed");
                    }
                }
                AppMethodBeat.o(17028);
            }
        });
        AppMethodBeat.o(17053);
    }

    public final void cleanup() {
        AppMethodBeat.i(17054);
        this.icw.cleanup();
        this.icv.destroy();
        AppMethodBeat.o(17054);
    }

    public final void k(boolean z, int i) {
        AppMethodBeat.i(17055);
        ab.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "notifyKeyboardStateChanged, shown[%b], height[%d]", Boolean.valueOf(z), Integer.valueOf(i));
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.icJ;
        if (dVar != null) {
            if (!z) {
                i = 0;
            }
            dVar.JM(i);
        }
        AppMethodBeat.o(17055);
    }

    public final void wU() {
        AppMethodBeat.i(17056);
        if (this.icw.uDd != null) {
            this.icw.uDd.nN(true);
        }
        AppMethodBeat.o(17056);
    }

    public final void wW() {
        AppMethodBeat.i(17057);
        if (this.icw.uDd != null) {
            this.icw.uDd.nN(false);
        }
        AppMethodBeat.o(17057);
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        boolean isSDCardAvailable;
        AppMethodBeat.i(17058);
        try {
            isSDCardAvailable = this.icy.isSDCardAvailable();
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            AppMethodBeat.o(17058);
            return true;
        } else if (this.icz == null) {
            AppMethodBeat.o(17058);
            return true;
        } else {
            contextMenu.setHeaderTitle(R.string.g2h);
            try {
                isSDCardAvailable = this.icy.cZd();
            } catch (Exception e2) {
                ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", e2.getMessage());
                isSDCardAvailable = false;
            }
            ab.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(this.icz.cZT().dmn()), Boolean.valueOf(this.icz.cZT().dmo()));
            if (isSDCardAvailable && r3) {
                contextMenu.add(0, 0, 0, this.icv.getContext().getString(R.string.dhh)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(17030);
                        try {
                            u.a(e.g(e.this), str, com.tencent.xweb.b.dTR().getCookie(str), e.this.icy.isSDCardAvailable(), new com.tencent.mm.pluginsdk.ui.tools.u.a() {
                                public final void BX(String str) {
                                    AppMethodBeat.i(17029);
                                    if (bo.isNullOrNil(str)) {
                                        ab.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
                                        AppMethodBeat.o(17029);
                                        return;
                                    }
                                    e.c(e.this, str);
                                    AppMethodBeat.o(17029);
                                }
                            });
                        } catch (Exception e) {
                            ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
                        }
                        AppMethodBeat.o(17030);
                        return true;
                    }
                });
            }
            contextMenu.add(0, 0, 0, this.icv.getContext().getString(R.string.dwz)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    boolean isSDCardAvailable;
                    AppMethodBeat.i(17031);
                    try {
                        isSDCardAvailable = e.this.icy.isSDCardAvailable();
                    } catch (Exception e) {
                        ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
                        isSDCardAvailable = false;
                    }
                    try {
                        u.a(e.g(e.this), str, com.tencent.xweb.b.dTR().getCookie(str), isSDCardAvailable);
                    } catch (Exception e2) {
                        ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", e2.getMessage());
                    }
                    AppMethodBeat.o(17031);
                    return true;
                }
            });
            if (isSDCardAvailable && r4) {
                contextMenu.add(0, 0, 0, this.icv.getContext().getString(R.string.dcq)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(17033);
                        try {
                            boolean isSDCardAvailable = e.this.icy.isSDCardAvailable();
                            String replaceAll = str.replaceAll("tp=webp", "");
                            u.a(e.g(e.this), replaceAll, com.tencent.xweb.b.dTR().getCookie(replaceAll), isSDCardAvailable, new com.tencent.mm.pluginsdk.ui.tools.u.a() {
                                public final void BX(String str) {
                                    AppMethodBeat.i(17032);
                                    e.d(e.this, str);
                                    AppMethodBeat.o(17032);
                                }
                            });
                        } catch (Exception e) {
                            ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
                        }
                        AppMethodBeat.o(17033);
                        return true;
                    }
                });
            }
            if (this.icB == null) {
                AppMethodBeat.o(17058);
                return false;
            } else if (com.tencent.mm.plugin.scanner.a.ba(this.icC, this.icB)) {
                final String str2 = this.icB;
                contextMenu.add(0, 0, 0, this.icv.getContext().getString(R.string.diz)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(17034);
                        e eVar = e.this;
                        String str = str2;
                        String c = e.this.icl;
                        String str2 = str;
                        int i = e.this.icC;
                        int i2 = e.this.icD;
                        if (str != null) {
                            Intent intent = new Intent();
                            intent.setClass(eVar.icv.getContext(), WebviewScanImageActivity.class);
                            intent.putExtra("key_string_for_scan", str);
                            intent.putExtra("key_string_for_url", c);
                            intent.putExtra("key_string_for_image_url", str2);
                            intent.putExtra("key_codetype_for_scan", i);
                            intent.putExtra("key_codeversion_for_scan", i2);
                            if (!(eVar.icI == null || bo.isNullOrNil(eVar.icI.getAppId()))) {
                                intent.putExtra("key_string_for_wxapp_id", eVar.icI.getAppId());
                            }
                            eVar.icv.getContext().startActivity(intent);
                        }
                        AppMethodBeat.o(17034);
                        return false;
                    }
                });
                this.icB = null;
                AppMethodBeat.o(17058);
                return true;
            } else {
                this.icB = null;
                AppMethodBeat.o(17058);
                return true;
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(17061);
        com.tencent.xweb.WebView.b hitTestResult;
        if (view instanceof android.webkit.WebView) {
            hitTestResult = this.icv.getHitTestResult();
            if (hitTestResult == null) {
                AppMethodBeat.o(17061);
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                b(contextMenu, hitTestResult);
            }
            AppMethodBeat.o(17061);
            return;
        }
        if (view instanceof MMWebView) {
            hitTestResult = ((MMWebView) view).getHitTestResult();
            if (hitTestResult == null) {
                AppMethodBeat.o(17061);
                return;
            } else if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                a(contextMenu, hitTestResult);
            }
        }
        AppMethodBeat.o(17061);
    }

    private void a(ContextMenu contextMenu, com.tencent.xweb.WebView.b bVar) {
        AppMethodBeat.i(17059);
        if (!a(contextMenu, bVar.mExtra) && this.icz.cZT().dml()) {
            this.icG = bVar;
            this.icE = new h();
            this.icE.a(this.icv, this.icL);
        }
        AppMethodBeat.o(17059);
    }

    private void b(ContextMenu contextMenu, com.tencent.xweb.WebView.b bVar) {
        AppMethodBeat.i(17060);
        if (!a(contextMenu, bVar.mExtra) && this.icz.cZT().dml()) {
            this.icF = bVar;
            this.icE = new h();
            this.icE.a(this.icv, this.icL);
        }
        AppMethodBeat.o(17060);
    }

    static /* synthetic */ Context g(e eVar) {
        AppMethodBeat.i(17062);
        Context context = eVar.icv.getContext();
        AppMethodBeat.o(17062);
        return context;
    }

    static /* synthetic */ void c(e eVar, String str) {
        AppMethodBeat.i(17065);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
            intent.putExtra("Retr_Msg_Type", 4);
        }
        com.tencent.mm.bp.d.f(eVar.icv.getContext(), ".ui.transmit.MsgRetransmitUI", intent);
        AppMethodBeat.o(17065);
    }

    static /* synthetic */ void d(e eVar, String str) {
        AppMethodBeat.i(17066);
        try {
            if (eVar.icy.afm(str) == 0) {
                Toast.makeText(eVar.icv.getContext(), eVar.icv.getContext().getString(R.string.bpv), 0).show();
            }
            AppMethodBeat.o(17066);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "favoriteUrl fail, ex = " + e.getMessage());
            AppMethodBeat.o(17066);
        }
    }
}
