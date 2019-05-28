package com.tencent.p177mm.plugin.webview.stub;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsimple.C32829v;
import com.tencent.p177mm.p230g.p231a.C37698c;
import com.tencent.p177mm.p230g.p231a.C37787qr;
import com.tencent.p177mm.p230g.p231a.C9483ty;
import com.tencent.p177mm.p612ui.C5493d.C5492b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.account.p275ui.SimpleLoginUI;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C33279c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.webview.model.C35610at;
import com.tencent.p177mm.plugin.webview.model.C35610at.C14514a;
import com.tencent.p177mm.plugin.webview.p1562a.C40211a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewStubCallbackWrapper;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C23018g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29944h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i;
import com.tencent.p177mm.pluginsdk.C46500q;
import com.tencent.p177mm.pluginsdk.p1079f.C40423e;
import com.tencent.p177mm.pluginsdk.p1079f.C40423e.C40422a;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import org.json.JSONException;
import org.json.JSONObject;

@C5271a(7)
@C5492b
/* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI */
public class WebViewStubProxyUI extends MMActivity {
    private OnDismissListener cMR = new C298526();
    private C7564ap che = new C7564ap(new C402787(), true);
    private int mqx = 0;
    private C40281e umI = null;
    public boolean uqh = false;
    private boolean uqi = false;
    private int uqj;
    private final C40281e uqk = new C229105();
    private C7564ap uql = new C7564ap(new C439308(), true);

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI$3 */
    class C229093 implements OnCancelListener {
        C229093() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(7070);
            C4990ab.m7416i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
            WebViewStubProxyUI.this.finish();
            AppMethodBeat.m2505o(7070);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI$5 */
    class C229105 implements C40281e {
        C229105() {
        }

        public final IBinder asBinder() {
            return null;
        }

        /* renamed from: IZ */
        public final boolean mo26778IZ(int i) {
            AppMethodBeat.m2504i(7074);
            WebViewStubProxyUI.this.umI.mo26778IZ(i);
            AppMethodBeat.m2505o(7074);
            return false;
        }

        /* renamed from: c */
        public final boolean mo26784c(int i, Bundle bundle) {
            AppMethodBeat.m2504i(7075);
            WebViewStubProxyUI.this.umI.mo26784c(i, bundle);
            AppMethodBeat.m2505o(7075);
            return false;
        }

        /* renamed from: a */
        public final boolean mo26780a(C22913c c22913c) {
            AppMethodBeat.m2504i(7076);
            WebViewStubProxyUI.this.umI.mo26780a(c22913c);
            AppMethodBeat.m2505o(7076);
            return false;
        }

        /* renamed from: a */
        public final boolean mo26781a(String str, String str2, Bundle bundle, boolean z) {
            AppMethodBeat.m2504i(7077);
            C4990ab.m7416i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
            WebViewStubProxyUI.this.uqh = WebViewStubProxyUI.afc(str2);
            final String str3 = str;
            final String str4 = str2;
            final Bundle bundle2 = bundle;
            final boolean z2 = z;
            WebViewStubProxyUI.this.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(7073);
                    C29944h.m47401JR(WebViewStubProxyUI.this.uqj).mo38615a(null, null, null);
                    WebViewStubProxyUI.this.finish();
                    try {
                        WebViewStubProxyUI.this.umI.mo26781a(str3, str4, bundle2, z2);
                        AppMethodBeat.m2505o(7073);
                    } catch (Exception e) {
                        C4990ab.m7420w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + e.getMessage());
                        AppMethodBeat.m2505o(7073);
                    }
                }
            });
            AppMethodBeat.m2505o(7077);
            return false;
        }

        public final String cYY() {
            AppMethodBeat.m2504i(7078);
            String cYY = WebViewStubProxyUI.this.umI.cYY();
            AppMethodBeat.m2505o(7078);
            return cYY;
        }

        public final String getCurrentUrl() {
            AppMethodBeat.m2504i(7079);
            String currentUrl = WebViewStubProxyUI.this.umI.getCurrentUrl();
            AppMethodBeat.m2505o(7079);
            return currentUrl;
        }

        public final String cYZ() {
            AppMethodBeat.m2504i(7080);
            String cYZ = WebViewStubProxyUI.this.umI.cYZ();
            AppMethodBeat.m2505o(7080);
            return cYZ;
        }

        public final int cZa() {
            AppMethodBeat.m2504i(7081);
            int cZa = WebViewStubProxyUI.this.umI.cZa();
            AppMethodBeat.m2505o(7081);
            return cZa;
        }

        /* renamed from: nJ */
        public final void mo26794nJ(boolean z) {
            AppMethodBeat.m2504i(7082);
            WebViewStubProxyUI.this.umI.mo26794nJ(z);
            AppMethodBeat.m2505o(7082);
        }

        /* renamed from: nK */
        public final void mo26795nK(boolean z) {
            AppMethodBeat.m2504i(7083);
            WebViewStubProxyUI.this.umI.mo26795nK(z);
            AppMethodBeat.m2505o(7083);
        }

        /* renamed from: q */
        public final void mo26797q(int i, Bundle bundle) {
            AppMethodBeat.m2504i(7084);
            WebViewStubProxyUI.this.umI.mo26797q(i, bundle);
            AppMethodBeat.m2505o(7084);
        }

        public final void cZb() {
            AppMethodBeat.m2504i(7085);
            WebViewStubProxyUI.this.umI.cZb();
            AppMethodBeat.m2505o(7085);
        }

        /* renamed from: W */
        public final void mo9706W(Bundle bundle) {
            AppMethodBeat.m2504i(7086);
            WebViewStubProxyUI.this.umI.mo9706W(bundle);
            AppMethodBeat.m2505o(7086);
        }

        public final void afd(String str) {
            AppMethodBeat.m2504i(7087);
            WebViewStubProxyUI.this.umI.afd(str);
            AppMethodBeat.m2505o(7087);
        }

        public final void cZc() {
            AppMethodBeat.m2504i(7088);
            if (WebViewStubProxyUI.this.umI == null) {
                AppMethodBeat.m2505o(7088);
                return;
            }
            WebViewStubProxyUI.this.umI.cZc();
            AppMethodBeat.m2505o(7088);
        }

        /* renamed from: e */
        public final void mo6225e(String str, String str2, int i, int i2) {
        }

        /* renamed from: hd */
        public final void mo26792hd(String str, String str2) {
            AppMethodBeat.m2504i(7089);
            WebViewStubProxyUI.this.umI.mo26792hd(str, str2);
            AppMethodBeat.m2505o(7089);
        }

        /* renamed from: g */
        public final Bundle mo6226g(int i, Bundle bundle) {
            AppMethodBeat.m2504i(7090);
            Bundle g = WebViewStubProxyUI.this.umI.mo6226g(i, bundle);
            AppMethodBeat.m2505o(7090);
            return g;
        }

        /* renamed from: X */
        public final void mo26779X(Bundle bundle) {
            AppMethodBeat.m2504i(7091);
            WebViewStubProxyUI.this.umI.mo26779X(bundle);
            AppMethodBeat.m2505o(7091);
        }

        /* renamed from: nL */
        public final void mo26796nL(boolean z) {
            AppMethodBeat.m2504i(7092);
            WebViewStubProxyUI.this.umI.mo26796nL(z);
            AppMethodBeat.m2505o(7092);
        }

        /* renamed from: he */
        public final void mo26793he(String str, String str2) {
            AppMethodBeat.m2504i(7093);
            WebViewStubProxyUI.this.umI.mo26793he(str, str2);
            AppMethodBeat.m2505o(7093);
        }

        /* renamed from: dj */
        public final Bundle mo26790dj(String str, String str2) {
            AppMethodBeat.m2504i(7094);
            Bundle dj = WebViewStubProxyUI.this.umI.mo26790dj(str, str2);
            AppMethodBeat.m2505o(7094);
            return dj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI$6 */
    class C298526 implements OnDismissListener {
        C298526() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(7095);
            if (!WebViewStubProxyUI.this.isFinishing()) {
                WebViewStubProxyUI.this.finish();
            }
            AppMethodBeat.m2505o(7095);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI$7 */
    class C402787 implements C5015a {
        C402787() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(7096);
            if (WebViewStubProxyUI.this.getWindow() != null && WebViewStubProxyUI.this.getWindow().getDecorView() != null && WebViewStubProxyUI.this.getWindow().getDecorView().getWindowToken() != null) {
                WebViewStubProxyUI.m78803e(WebViewStubProxyUI.this);
                WebViewStubProxyUI.this.uqi = true;
                AppMethodBeat.m2505o(7096);
                return false;
            } else if (WebViewStubProxyUI.this.mqx < 10) {
                WebViewStubProxyUI.m78802d(WebViewStubProxyUI.this);
                AppMethodBeat.m2505o(7096);
                return true;
            } else {
                C4990ab.m7412e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
                WebViewStubProxyUI.this.finish();
                AppMethodBeat.m2505o(7096);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI$2 */
    class C439292 implements OnClickListener {
        C439292() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(7069);
            C40211a.gkE.mo38921g(new Intent(), WebViewStubProxyUI.this);
            AppMethodBeat.m2505o(7069);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI$8 */
    class C439308 implements C5015a {
        C439308() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(7097);
            if (!WebViewStubProxyUI.this.isFinishing()) {
                WebViewStubProxyUI.this.finish();
            }
            AppMethodBeat.m2505o(7097);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WebViewStubProxyUI() {
        AppMethodBeat.m2504i(7098);
        AppMethodBeat.m2505o(7098);
    }

    /* renamed from: d */
    static /* synthetic */ int m78802d(WebViewStubProxyUI webViewStubProxyUI) {
        int i = webViewStubProxyUI.mqx + 1;
        webViewStubProxyUI.mqx = i;
        return i;
    }

    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7099);
        super.onCreate(bundle);
        if (C1443d.m3068iW(21)) {
            getWindow().setStatusBarColor(0);
        }
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = (WebViewStubCallbackWrapper) getIntent().getParcelableExtra("webview_stub_callbacker_key");
        if (webViewStubCallbackWrapper != null) {
            this.umI = webViewStubCallbackWrapper.uuT;
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        this.uqj = intent.getIntExtra("webview_binder_id", 0);
        C4990ab.m7417i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d", Integer.valueOf(intExtra), Integer.valueOf(this.uqj));
        if ("startMonitoringBeacons".equals(intent.getStringExtra("proxyui_function_key"))) {
            this.uqh = true;
        }
        String stringExtra;
        switch (intExtra) {
            case 1:
                if (!this.uqi) {
                    this.che.mo16770ae(100, 100);
                }
                if (this.uqh) {
                    this.uql.mo16770ae(5000, 5000);
                    AppMethodBeat.m2505o(7099);
                    return;
                }
                break;
            case 2:
                final C4883b c9483ty = new C9483ty();
                c9483ty.callback = new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7068);
                        if (c9483ty.cQd.cQe) {
                            if (WebViewStubProxyUI.this.umI != null) {
                                try {
                                    WebViewStubProxyUI.this.umI.mo26784c(1001, null);
                                } catch (RemoteException e) {
                                    C4990ab.m7420w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + e.getMessage());
                                }
                            }
                            WebViewStubProxyUI.this.finish();
                            C40422a c40422a = C40423e.vdx;
                            if (c40422a != null) {
                                c40422a.mo20426bd(WebViewStubProxyUI.this);
                            }
                            AppMethodBeat.m2505o(7068);
                            return;
                        }
                        WebViewStubProxyUI.this.finish();
                        AppMethodBeat.m2505o(7068);
                    }
                };
                c9483ty.cQc.context = this;
                c9483ty.cQc.type = intent.getIntExtra("update_type_key", 0);
                if (c9483ty.cQc.type <= 0) {
                    C4990ab.m7412e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + c9483ty.cQc.type);
                    finish();
                    AppMethodBeat.m2505o(7099);
                    return;
                }
                C4879a.xxA.mo10048a(c9483ty, Looper.myLooper());
                AppMethodBeat.m2505o(7099);
                return;
            case 3:
                Dialog a;
                C5140bq RA = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA("@t.qq.com");
                if (!C1853r.m3851Ze()) {
                    a = C30379h.m48432a((Context) this, (int) C25738R.string.axq, (int) C25738R.string.f9238tz, new C439292(), null);
                } else if (RA == null || C5046bo.isNullOrNil(RA.name)) {
                    a = C30379h.m48467g(this, C25738R.string.ec6, C25738R.string.f9238tz);
                } else {
                    C1720g.m3540Rg().mo14541a(new C32829v(getIntent().getIntExtra("type", 0), C5046bo.nullAsNil(getIntent().getStringExtra("shortUrl"))), 0);
                    try {
                        this.umI.mo26778IZ(0);
                        a = null;
                    } catch (Exception e) {
                        C4990ab.m7420w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + e.getMessage());
                        a = null;
                    }
                }
                if (a == null) {
                    finish();
                    AppMethodBeat.m2505o(7099);
                    return;
                }
                a.setOnDismissListener(this.cMR);
                AppMethodBeat.m2505o(7099);
                return;
            case 4:
                this.che.mo16770ae(100, 100);
                AppMethodBeat.m2505o(7099);
                return;
            case 5:
                ((C46500q) C1720g.m3528K(C46500q.class)).mo4548a(this, intent.getStringExtra("proxyui_handle_event_url"), this.cMR);
                AppMethodBeat.m2505o(7099);
                return;
            case 6:
                intExtra = getIntent().getIntExtra("proxyui_expired_errtype", 0);
                int intExtra2 = getIntent().getIntExtra("proxyui_expired_errcode", 0);
                if (intExtra == 0 && intExtra2 == 0) {
                    C4990ab.m7412e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
                    AppMethodBeat.m2505o(7099);
                    return;
                }
                C37698c c37698c = new C37698c();
                c37698c.crO.crP = this;
                c37698c.crO.errType = intExtra;
                c37698c.crO.errCode = intExtra2;
                C4879a.xxA.mo10055m(c37698c);
                AppMethodBeat.m2505o(7099);
                return;
            case 8:
                stringExtra = getIntent().getStringExtra("proxyui_phone");
                if (C5046bo.isNullOrNil(stringExtra)) {
                    C4990ab.m7412e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
                    finish();
                    AppMethodBeat.m2505o(7099);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fromScene", 3);
                C37787qr c37787qr = new C37787qr();
                c37787qr.cMP.context = this;
                c37787qr.cMP.cMQ = stringExtra;
                c37787qr.cMP.cMR = this.cMR;
                c37787qr.cMP.cMS = bundle2;
                C4879a.xxA.mo10055m(c37787qr);
                AppMethodBeat.m2505o(7099);
                return;
            case 9:
                Intent intent2 = (Intent) getIntent().getExtras().getParcelable("proxyui_next_intent_key");
                intent2.setFlags(603979776);
                Intent intent3 = new Intent();
                intent3.setClass(this, SimpleLoginUI.class);
                MMWizardActivity.m23792b(this, intent3, intent2);
                finish();
                AppMethodBeat.m2505o(7099);
                return;
            case 10:
                stringExtra = getIntent().getStringExtra("KAppId");
                String stringExtra2 = getIntent().getStringExtra("shortcut_user_name");
                if (!(C5046bo.isNullOrNil(stringExtra) || C5046bo.isNullOrNil(stringExtra2))) {
                    getString(C25738R.string.f9238tz);
                    final C44275p b = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C229093());
                    b.show();
                    C35610at.m58448a(C4996ah.getContext(), stringExtra2, stringExtra, new C14514a() {

                        /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI$4$1 */
                        class C145491 implements OnClickListener {
                            C145491() {
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(7071);
                                WebViewStubProxyUI.this.finish();
                                AppMethodBeat.m2505o(7071);
                            }
                        }

                        /* renamed from: hJ */
                        public final void mo26754hJ(boolean z) {
                            AppMethodBeat.m2504i(7072);
                            if (b != null) {
                                b.dismiss();
                            }
                            Bundle bundle;
                            if (z) {
                                if (WebViewStubProxyUI.this.umI != null) {
                                    bundle = new Bundle();
                                    bundle.putBoolean("add_shortcut_status", true);
                                    try {
                                        WebViewStubProxyUI.this.umI.mo6226g(54, bundle);
                                    } catch (Exception e) {
                                        C4990ab.m7412e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e.getMessage());
                                    }
                                }
                                C30379h.m48433a(WebViewStubProxyUI.this, (int) C25738R.string.g1s, (int) C25738R.string.f9238tz, false, new C145491());
                                AppMethodBeat.m2505o(7072);
                                return;
                            }
                            Toast.makeText(WebViewStubProxyUI.this.mController.ylL, WebViewStubProxyUI.this.mController.ylL.getString(C25738R.string.g1r), 0).show();
                            if (WebViewStubProxyUI.this.umI != null) {
                                bundle = new Bundle();
                                bundle.putBoolean("add_shortcut_status", false);
                                try {
                                    WebViewStubProxyUI.this.umI.mo6226g(54, bundle);
                                } catch (Exception e2) {
                                    C4990ab.m7412e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e2.getMessage());
                                }
                            }
                            WebViewStubProxyUI.this.finish();
                            AppMethodBeat.m2505o(7072);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.m2505o(7099);
    }

    public final int getForceOrientation() {
        AppMethodBeat.m2504i(7100);
        int intExtra = getIntent().getIntExtra("screen_orientation", -1);
        AppMethodBeat.m2505o(7100);
        return intExtra;
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(7101);
        super.onDestroy();
        if (!this.uqh) {
            this.umI = null;
        }
        C23018g JR = C29944h.m47401JR(this.uqj);
        if (JR.ehJ != null) {
            JR.ehJ.dismiss();
            JR.ehJ = null;
        }
        C4990ab.m7416i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
        AppMethodBeat.m2505o(7101);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(7102);
        switch (i) {
            case C33279c.CTRL_INDEX /*72*/:
            case 113:
            case 115:
            case 116:
            case C31128d.MIC_ALPHA_ADJUST_REAL /*117*/:
            case 118:
            case C31128d.MIC_AVROUND_BLUR /*119*/:
            case 120:
                if (iArr[0] != 0) {
                    C29944h.m47401JR(this.uqj).mo6069c(i, 0, null);
                    break;
                }
                C29944h.m47401JR(this.uqj).mo6069c(i, -1, null);
                AppMethodBeat.m2505o(7102);
                return;
        }
        AppMethodBeat.m2505o(7102);
    }

    static /* synthetic */ boolean afc(String str) {
        AppMethodBeat.m2504i(7103);
        if (str != null) {
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split.length > 0 && split[0].equals("startMonitoringBeacons")) {
                AppMethodBeat.m2505o(7103);
                return true;
            }
        }
        AppMethodBeat.m2505o(7103);
        return false;
    }

    /* renamed from: e */
    static /* synthetic */ void m78803e(WebViewStubProxyUI webViewStubProxyUI) {
        AppMethodBeat.m2504i(7104);
        Intent intent = webViewStubProxyUI.getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        C4990ab.m7416i("MicroMsg.WebViewStubProxyUI", "onCreate, dealAfterWindowTokenInited = ".concat(String.valueOf(intExtra)));
        JsapiPermissionWrapper jsapiPermissionWrapper;
        switch (intExtra) {
            case 1:
                C29945i c29945i = new C29945i();
                c29945i.type = intent.getStringExtra("proxyui_type_key");
                c29945i.uIJ = intent.getStringExtra("proxyui_function_key");
                c29945i.uIG = intent.getStringExtra("proxyui_callback_key");
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    C4990ab.m7412e("MicroMsg.WebViewStubProxyUI", "getExtras from intent, returned NULL");
                    extras = Bundle.EMPTY;
                }
                c29945i.puc = C29945i.m47403aq(extras.getBundle("compatParams"));
                try {
                    c29945i.uIH = new JSONObject(extras.getString("rawParams"));
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.WebViewStubProxyUI", "get rawParams, e = %s", e);
                }
                jsapiPermissionWrapper = (JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key");
                if (jsapiPermissionWrapper == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                C23018g JR = C29944h.m47401JR(webViewStubProxyUI.uqj);
                JR.mo38661oc(false);
                JR.mo38615a((Context) webViewStubProxyUI, webViewStubProxyUI.uqk, webViewStubProxyUI.umI);
                if (!JR.mo38620a(c29945i, jsapiPermissionWrapper)) {
                    try {
                        webViewStubProxyUI.uqk.mo26781a(null, null, null, true);
                        AppMethodBeat.m2505o(7104);
                        return;
                    } catch (Exception e2) {
                        C4990ab.m7420w("MicroMsg.WebViewStubProxyUI", "onHandleEnd, ex = " + e2.getMessage());
                        AppMethodBeat.m2505o(7104);
                        return;
                    }
                }
                break;
            case 4:
                if (((JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key")) == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                C29944h.m47401JR(webViewStubProxyUI.uqj).mo38614a((Context) webViewStubProxyUI, webViewStubProxyUI.uqk);
                if (!C29944h.m47401JR(webViewStubProxyUI.uqj).agy(intent.getStringExtra("proxyui_username_key"))) {
                    C4990ab.m7420w("MicroMsg.WebViewStubProxyUI", "doProfile fail, finish");
                    webViewStubProxyUI.finish();
                    AppMethodBeat.m2505o(7104);
                    return;
                }
                break;
            default:
                C4990ab.m7412e("MicroMsg.WebViewStubProxyUI", "dealAfterWindowTokenInited unknown actionCode = ".concat(String.valueOf(intExtra)));
                webViewStubProxyUI.finish();
                break;
        }
        AppMethodBeat.m2505o(7104);
    }
}
