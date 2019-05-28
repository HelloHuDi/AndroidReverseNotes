package com.tencent.mm.plugin.webview.stub;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.c;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.webview.model.at;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.f.e;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.d.b;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONException;
import org.json.JSONObject;

@a(7)
@b
public class WebViewStubProxyUI extends MMActivity {
    private OnDismissListener cMR = new OnDismissListener() {
        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(7095);
            if (!WebViewStubProxyUI.this.isFinishing()) {
                WebViewStubProxyUI.this.finish();
            }
            AppMethodBeat.o(7095);
        }
    };
    private ap che = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(7096);
            if (WebViewStubProxyUI.this.getWindow() != null && WebViewStubProxyUI.this.getWindow().getDecorView() != null && WebViewStubProxyUI.this.getWindow().getDecorView().getWindowToken() != null) {
                WebViewStubProxyUI.e(WebViewStubProxyUI.this);
                WebViewStubProxyUI.this.uqi = true;
                AppMethodBeat.o(7096);
                return false;
            } else if (WebViewStubProxyUI.this.mqx < 10) {
                WebViewStubProxyUI.d(WebViewStubProxyUI.this);
                AppMethodBeat.o(7096);
                return true;
            } else {
                ab.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
                WebViewStubProxyUI.this.finish();
                AppMethodBeat.o(7096);
                return false;
            }
        }
    }, true);
    private int mqx = 0;
    private e umI = null;
    public boolean uqh = false;
    private boolean uqi = false;
    private int uqj;
    private final e uqk = new e() {
        public final IBinder asBinder() {
            return null;
        }

        public final boolean IZ(int i) {
            AppMethodBeat.i(7074);
            WebViewStubProxyUI.this.umI.IZ(i);
            AppMethodBeat.o(7074);
            return false;
        }

        public final boolean c(int i, Bundle bundle) {
            AppMethodBeat.i(7075);
            WebViewStubProxyUI.this.umI.c(i, bundle);
            AppMethodBeat.o(7075);
            return false;
        }

        public final boolean a(c cVar) {
            AppMethodBeat.i(7076);
            WebViewStubProxyUI.this.umI.a(cVar);
            AppMethodBeat.o(7076);
            return false;
        }

        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            AppMethodBeat.i(7077);
            ab.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
            WebViewStubProxyUI.this.uqh = WebViewStubProxyUI.afc(str2);
            final String str3 = str;
            final String str4 = str2;
            final Bundle bundle2 = bundle;
            final boolean z2 = z;
            WebViewStubProxyUI.this.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(7073);
                    h.JR(WebViewStubProxyUI.this.uqj).a(null, null, null);
                    WebViewStubProxyUI.this.finish();
                    try {
                        WebViewStubProxyUI.this.umI.a(str3, str4, bundle2, z2);
                        AppMethodBeat.o(7073);
                    } catch (Exception e) {
                        ab.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + e.getMessage());
                        AppMethodBeat.o(7073);
                    }
                }
            });
            AppMethodBeat.o(7077);
            return false;
        }

        public final String cYY() {
            AppMethodBeat.i(7078);
            String cYY = WebViewStubProxyUI.this.umI.cYY();
            AppMethodBeat.o(7078);
            return cYY;
        }

        public final String getCurrentUrl() {
            AppMethodBeat.i(7079);
            String currentUrl = WebViewStubProxyUI.this.umI.getCurrentUrl();
            AppMethodBeat.o(7079);
            return currentUrl;
        }

        public final String cYZ() {
            AppMethodBeat.i(7080);
            String cYZ = WebViewStubProxyUI.this.umI.cYZ();
            AppMethodBeat.o(7080);
            return cYZ;
        }

        public final int cZa() {
            AppMethodBeat.i(7081);
            int cZa = WebViewStubProxyUI.this.umI.cZa();
            AppMethodBeat.o(7081);
            return cZa;
        }

        public final void nJ(boolean z) {
            AppMethodBeat.i(7082);
            WebViewStubProxyUI.this.umI.nJ(z);
            AppMethodBeat.o(7082);
        }

        public final void nK(boolean z) {
            AppMethodBeat.i(7083);
            WebViewStubProxyUI.this.umI.nK(z);
            AppMethodBeat.o(7083);
        }

        public final void q(int i, Bundle bundle) {
            AppMethodBeat.i(7084);
            WebViewStubProxyUI.this.umI.q(i, bundle);
            AppMethodBeat.o(7084);
        }

        public final void cZb() {
            AppMethodBeat.i(7085);
            WebViewStubProxyUI.this.umI.cZb();
            AppMethodBeat.o(7085);
        }

        public final void W(Bundle bundle) {
            AppMethodBeat.i(7086);
            WebViewStubProxyUI.this.umI.W(bundle);
            AppMethodBeat.o(7086);
        }

        public final void afd(String str) {
            AppMethodBeat.i(7087);
            WebViewStubProxyUI.this.umI.afd(str);
            AppMethodBeat.o(7087);
        }

        public final void cZc() {
            AppMethodBeat.i(7088);
            if (WebViewStubProxyUI.this.umI == null) {
                AppMethodBeat.o(7088);
                return;
            }
            WebViewStubProxyUI.this.umI.cZc();
            AppMethodBeat.o(7088);
        }

        public final void e(String str, String str2, int i, int i2) {
        }

        public final void hd(String str, String str2) {
            AppMethodBeat.i(7089);
            WebViewStubProxyUI.this.umI.hd(str, str2);
            AppMethodBeat.o(7089);
        }

        public final Bundle g(int i, Bundle bundle) {
            AppMethodBeat.i(7090);
            Bundle g = WebViewStubProxyUI.this.umI.g(i, bundle);
            AppMethodBeat.o(7090);
            return g;
        }

        public final void X(Bundle bundle) {
            AppMethodBeat.i(7091);
            WebViewStubProxyUI.this.umI.X(bundle);
            AppMethodBeat.o(7091);
        }

        public final void nL(boolean z) {
            AppMethodBeat.i(7092);
            WebViewStubProxyUI.this.umI.nL(z);
            AppMethodBeat.o(7092);
        }

        public final void he(String str, String str2) {
            AppMethodBeat.i(7093);
            WebViewStubProxyUI.this.umI.he(str, str2);
            AppMethodBeat.o(7093);
        }

        public final Bundle dj(String str, String str2) {
            AppMethodBeat.i(7094);
            Bundle dj = WebViewStubProxyUI.this.umI.dj(str, str2);
            AppMethodBeat.o(7094);
            return dj;
        }
    };
    private ap uql = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(7097);
            if (!WebViewStubProxyUI.this.isFinishing()) {
                WebViewStubProxyUI.this.finish();
            }
            AppMethodBeat.o(7097);
            return false;
        }
    }, true);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebViewStubProxyUI() {
        AppMethodBeat.i(7098);
        AppMethodBeat.o(7098);
    }

    static /* synthetic */ int d(WebViewStubProxyUI webViewStubProxyUI) {
        int i = webViewStubProxyUI.mqx + 1;
        webViewStubProxyUI.mqx = i;
        return i;
    }

    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7099);
        super.onCreate(bundle);
        if (d.iW(21)) {
            getWindow().setStatusBarColor(0);
        }
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = (WebViewStubCallbackWrapper) getIntent().getParcelableExtra("webview_stub_callbacker_key");
        if (webViewStubCallbackWrapper != null) {
            this.umI = webViewStubCallbackWrapper.uuT;
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        this.uqj = intent.getIntExtra("webview_binder_id", 0);
        ab.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d", Integer.valueOf(intExtra), Integer.valueOf(this.uqj));
        if ("startMonitoringBeacons".equals(intent.getStringExtra("proxyui_function_key"))) {
            this.uqh = true;
        }
        String stringExtra;
        switch (intExtra) {
            case 1:
                if (!this.uqi) {
                    this.che.ae(100, 100);
                }
                if (this.uqh) {
                    this.uql.ae(5000, 5000);
                    AppMethodBeat.o(7099);
                    return;
                }
                break;
            case 2:
                final com.tencent.mm.sdk.b.b tyVar = new ty();
                tyVar.callback = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7068);
                        if (tyVar.cQd.cQe) {
                            if (WebViewStubProxyUI.this.umI != null) {
                                try {
                                    WebViewStubProxyUI.this.umI.c(1001, null);
                                } catch (RemoteException e) {
                                    ab.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + e.getMessage());
                                }
                            }
                            WebViewStubProxyUI.this.finish();
                            e.a aVar = e.vdx;
                            if (aVar != null) {
                                aVar.bd(WebViewStubProxyUI.this);
                            }
                            AppMethodBeat.o(7068);
                            return;
                        }
                        WebViewStubProxyUI.this.finish();
                        AppMethodBeat.o(7068);
                    }
                };
                tyVar.cQc.context = this;
                tyVar.cQc.type = intent.getIntExtra("update_type_key", 0);
                if (tyVar.cQc.type <= 0) {
                    ab.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + tyVar.cQc.type);
                    finish();
                    AppMethodBeat.o(7099);
                    return;
                }
                com.tencent.mm.sdk.b.a.xxA.a(tyVar, Looper.myLooper());
                AppMethodBeat.o(7099);
                return;
            case 3:
                Dialog a;
                bq RA = ((j) g.K(j.class)).XU().RA("@t.qq.com");
                if (!r.Ze()) {
                    a = com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.axq, (int) R.string.tz, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(7069);
                            com.tencent.mm.plugin.webview.a.a.gkE.g(new Intent(), WebViewStubProxyUI.this);
                            AppMethodBeat.o(7069);
                        }
                    }, null);
                } else if (RA == null || bo.isNullOrNil(RA.name)) {
                    a = com.tencent.mm.ui.base.h.g(this, R.string.ec6, R.string.tz);
                } else {
                    g.Rg().a(new v(getIntent().getIntExtra("type", 0), bo.nullAsNil(getIntent().getStringExtra("shortUrl"))), 0);
                    try {
                        this.umI.IZ(0);
                        a = null;
                    } catch (Exception e) {
                        ab.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + e.getMessage());
                        a = null;
                    }
                }
                if (a == null) {
                    finish();
                    AppMethodBeat.o(7099);
                    return;
                }
                a.setOnDismissListener(this.cMR);
                AppMethodBeat.o(7099);
                return;
            case 4:
                this.che.ae(100, 100);
                AppMethodBeat.o(7099);
                return;
            case 5:
                ((q) g.K(q.class)).a(this, intent.getStringExtra("proxyui_handle_event_url"), this.cMR);
                AppMethodBeat.o(7099);
                return;
            case 6:
                intExtra = getIntent().getIntExtra("proxyui_expired_errtype", 0);
                int intExtra2 = getIntent().getIntExtra("proxyui_expired_errcode", 0);
                if (intExtra == 0 && intExtra2 == 0) {
                    ab.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
                    AppMethodBeat.o(7099);
                    return;
                }
                c cVar = new c();
                cVar.crO.crP = this;
                cVar.crO.errType = intExtra;
                cVar.crO.errCode = intExtra2;
                com.tencent.mm.sdk.b.a.xxA.m(cVar);
                AppMethodBeat.o(7099);
                return;
            case 8:
                stringExtra = getIntent().getStringExtra("proxyui_phone");
                if (bo.isNullOrNil(stringExtra)) {
                    ab.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
                    finish();
                    AppMethodBeat.o(7099);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fromScene", 3);
                qr qrVar = new qr();
                qrVar.cMP.context = this;
                qrVar.cMP.cMQ = stringExtra;
                qrVar.cMP.cMR = this.cMR;
                qrVar.cMP.cMS = bundle2;
                com.tencent.mm.sdk.b.a.xxA.m(qrVar);
                AppMethodBeat.o(7099);
                return;
            case 9:
                Intent intent2 = (Intent) getIntent().getExtras().getParcelable("proxyui_next_intent_key");
                intent2.setFlags(603979776);
                Intent intent3 = new Intent();
                intent3.setClass(this, SimpleLoginUI.class);
                MMWizardActivity.b(this, intent3, intent2);
                finish();
                AppMethodBeat.o(7099);
                return;
            case 10:
                stringExtra = getIntent().getStringExtra("KAppId");
                String stringExtra2 = getIntent().getStringExtra("shortcut_user_name");
                if (!(bo.isNullOrNil(stringExtra) || bo.isNullOrNil(stringExtra2))) {
                    getString(R.string.tz);
                    final p b = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(7070);
                            ab.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                            WebViewStubProxyUI.this.finish();
                            AppMethodBeat.o(7070);
                        }
                    });
                    b.show();
                    at.a(ah.getContext(), stringExtra2, stringExtra, new at.a() {
                        public final void hJ(boolean z) {
                            AppMethodBeat.i(7072);
                            if (b != null) {
                                b.dismiss();
                            }
                            Bundle bundle;
                            if (z) {
                                if (WebViewStubProxyUI.this.umI != null) {
                                    bundle = new Bundle();
                                    bundle.putBoolean("add_shortcut_status", true);
                                    try {
                                        WebViewStubProxyUI.this.umI.g(54, bundle);
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e.getMessage());
                                    }
                                }
                                com.tencent.mm.ui.base.h.a(WebViewStubProxyUI.this, (int) R.string.g1s, (int) R.string.tz, false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(7071);
                                        WebViewStubProxyUI.this.finish();
                                        AppMethodBeat.o(7071);
                                    }
                                });
                                AppMethodBeat.o(7072);
                                return;
                            }
                            Toast.makeText(WebViewStubProxyUI.this.mController.ylL, WebViewStubProxyUI.this.mController.ylL.getString(R.string.g1r), 0).show();
                            if (WebViewStubProxyUI.this.umI != null) {
                                bundle = new Bundle();
                                bundle.putBoolean("add_shortcut_status", false);
                                try {
                                    WebViewStubProxyUI.this.umI.g(54, bundle);
                                } catch (Exception e2) {
                                    ab.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e2.getMessage());
                                }
                            }
                            WebViewStubProxyUI.this.finish();
                            AppMethodBeat.o(7072);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(7099);
    }

    public final int getForceOrientation() {
        AppMethodBeat.i(7100);
        int intExtra = getIntent().getIntExtra("screen_orientation", -1);
        AppMethodBeat.o(7100);
        return intExtra;
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onDestroy() {
        AppMethodBeat.i(7101);
        super.onDestroy();
        if (!this.uqh) {
            this.umI = null;
        }
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(this.uqj);
        if (JR.ehJ != null) {
            JR.ehJ.dismiss();
            JR.ehJ = null;
        }
        ab.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
        AppMethodBeat.o(7101);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(7102);
        switch (i) {
            case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*72*/:
            case 113:
            case 115:
            case 116:
            case com.tencent.view.d.MIC_ALPHA_ADJUST_REAL /*117*/:
            case 118:
            case com.tencent.view.d.MIC_AVROUND_BLUR /*119*/:
            case 120:
                if (iArr[0] != 0) {
                    h.JR(this.uqj).c(i, 0, null);
                    break;
                }
                h.JR(this.uqj).c(i, -1, null);
                AppMethodBeat.o(7102);
                return;
        }
        AppMethodBeat.o(7102);
    }

    static /* synthetic */ boolean afc(String str) {
        AppMethodBeat.i(7103);
        if (str != null) {
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split.length > 0 && split[0].equals("startMonitoringBeacons")) {
                AppMethodBeat.o(7103);
                return true;
            }
        }
        AppMethodBeat.o(7103);
        return false;
    }

    static /* synthetic */ void e(WebViewStubProxyUI webViewStubProxyUI) {
        AppMethodBeat.i(7104);
        Intent intent = webViewStubProxyUI.getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        ab.i("MicroMsg.WebViewStubProxyUI", "onCreate, dealAfterWindowTokenInited = ".concat(String.valueOf(intExtra)));
        JsapiPermissionWrapper jsapiPermissionWrapper;
        switch (intExtra) {
            case 1:
                i iVar = new i();
                iVar.type = intent.getStringExtra("proxyui_type_key");
                iVar.uIJ = intent.getStringExtra("proxyui_function_key");
                iVar.uIG = intent.getStringExtra("proxyui_callback_key");
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    ab.e("MicroMsg.WebViewStubProxyUI", "getExtras from intent, returned NULL");
                    extras = Bundle.EMPTY;
                }
                iVar.puc = i.aq(extras.getBundle("compatParams"));
                try {
                    iVar.uIH = new JSONObject(extras.getString("rawParams"));
                } catch (JSONException e) {
                    ab.e("MicroMsg.WebViewStubProxyUI", "get rawParams, e = %s", e);
                }
                jsapiPermissionWrapper = (JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key");
                if (jsapiPermissionWrapper == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(webViewStubProxyUI.uqj);
                JR.oc(false);
                JR.a((Context) webViewStubProxyUI, webViewStubProxyUI.uqk, webViewStubProxyUI.umI);
                if (!JR.a(iVar, jsapiPermissionWrapper)) {
                    try {
                        webViewStubProxyUI.uqk.a(null, null, null, true);
                        AppMethodBeat.o(7104);
                        return;
                    } catch (Exception e2) {
                        ab.w("MicroMsg.WebViewStubProxyUI", "onHandleEnd, ex = " + e2.getMessage());
                        AppMethodBeat.o(7104);
                        return;
                    }
                }
                break;
            case 4:
                if (((JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key")) == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                h.JR(webViewStubProxyUI.uqj).a((Context) webViewStubProxyUI, webViewStubProxyUI.uqk);
                if (!h.JR(webViewStubProxyUI.uqj).agy(intent.getStringExtra("proxyui_username_key"))) {
                    ab.w("MicroMsg.WebViewStubProxyUI", "doProfile fail, finish");
                    webViewStubProxyUI.finish();
                    AppMethodBeat.o(7104);
                    return;
                }
                break;
            default:
                ab.e("MicroMsg.WebViewStubProxyUI", "dealAfterWindowTokenInited unknown actionCode = ".concat(String.valueOf(intExtra)));
                webViewStubProxyUI.finish();
                break;
        }
        AppMethodBeat.o(7104);
    }
}
