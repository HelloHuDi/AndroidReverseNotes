package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.service.C42687f;
import com.tencent.p177mm.plugin.freewifi.C11963i.C11964a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p417g.C3137c;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI */
public class FreeWifiEntryUI extends Activity {
    private boolean myf = true;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI$3 */
    class C119853 implements OnClickListener {
        C119853() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(20953);
            FreeWifiEntryUI.this.finish();
            AppMethodBeat.m2505o(20953);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI$1 */
    class C391191 implements OnClickListener {
        C391191() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(20951);
            C26443d.m42103bX(FreeWifiEntryUI.this);
            AppMethodBeat.m2505o(20951);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI$2 */
    class C459602 implements OnClickListener {
        C459602() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(20952);
            FreeWifiEntryUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            FreeWifiEntryUI.this.finish();
            AppMethodBeat.m2505o(20952);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20954);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(20954);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:8:0x0043, code skipped:
            if (com.tencent.p177mm.pluginsdk.permission.C35805b.m58707a(r12, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null) != false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        AppMethodBeat.m2504i(20955);
        super.onResume();
        if (C9638aw.m17179RK()) {
            if (this.myf) {
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiEntryUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)));
            }
            if (C35805b.m58714o(this, "android.permission.ACCESS_COARSE_LOCATION") && !C26443d.agA()) {
                C30379h.m48445a((Context) this, getString(C25738R.string.c9z), getString(C25738R.string.f9238tz), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C391191(), null);
            }
            Intent intent = getIntent();
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiEntryUI", "has notified, now scene is : %d", Integer.valueOf(getIntent().getIntExtra("free_wifi_source", 1)));
            switch (getIntent().getIntExtra("free_wifi_source", 1)) {
                case 1:
                    if (1 != C11964a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        C11964a.mtZ.mo23806ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    C34189m.m56072d(intent, intent.getStringExtra("free_wifi_mid"));
                    intent.setClass(this, FreeWifiNetCheckUI.class);
                    startActivity(intent);
                    super.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                    break;
                case 2:
                    C3137c ML = C11976j.byW().mo17045ML(C45957d.byO());
                    if (ML != null) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiEntryUI", "banner click, freeWifiInfo.field_action:%d, field_showUrl:%s", Integer.valueOf(ML.field_action), ML.field_showUrl);
                        if (ML.field_action != 2 || C5046bo.isNullOrNil(ML.field_showUrl)) {
                            if (ML.field_action == 1 && !C5046bo.isNullOrNil(ML.field_showUrl)) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", Uri.parse(ML.field_showUrl).buildUpon().appendQueryParameter("lang", C4988aa.m7402g(getSharedPreferences(C4996ah.doA(), 0))).build().toString());
                                intent2.putExtra("show_bottom", false);
                                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                                break;
                            }
                            intent.setClass(this, FreeWifiAuthStateUI.class);
                            startActivity(intent);
                            break;
                        }
                        ((C42687f) C1720g.m3528K(C42687f.class)).mo68090b(this, ML.field_showUrl, FilterEnum4Shaka.MIC_WEISHI_BAIHUA, null);
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiEntryUI", "what the fuck, how could it be???");
                    break;
                case 3:
                    intent.putExtra("free_wifi_auth_type", 2);
                    intent.setClass(this, FreeWifiMIGNoAuthStateUI.class);
                    startActivity(intent);
                    break;
                case 4:
                    if (1 != C11964a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        C11964a.mtZ.mo23806ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    intent.setClass(this, FreeWifiNetCheckUI.class);
                    startActivity(intent);
                    super.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                    break;
                case 5:
                    if (1 != C11964a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        C11964a.mtZ.mo23806ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    String stringExtra = intent.getStringExtra("free_wifi_ap_key");
                    if (!C34189m.isEmpty(stringExtra)) {
                        getIntent().putExtra("free_wifi_channel_id", 1);
                        if (!"_p33beta".equalsIgnoreCase(stringExtra)) {
                            if (!stringExtra.startsWith("_")) {
                                int i;
                                int intExtra = intent.getIntExtra("free_wifi_threeone_startup_type", 0);
                                if (2 == intExtra) {
                                    i = 11;
                                } else if (3 == intExtra) {
                                    i = 12;
                                } else if (4 == intExtra) {
                                    i = 13;
                                } else {
                                    i = 1;
                                }
                                intent.putExtra("free_wifi_channel_id", i);
                                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                                C34189m.m56072d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                                if (intExtra == 4) {
                                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", C34189m.m56063V(intent) + "_" + C34189m.m56065X(intent) + "_" + C34189m.m56066Y(intent) + "_" + System.currentTimeMillis());
                                }
                                intent.setClass(this, FreeWifiNetCheckUI.class);
                                startActivity(intent);
                                super.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                                break;
                            }
                            stringExtra = getString(C25738R.string.c05);
                            intent = new Intent();
                            intent.putExtra("free_wifi_error_ui_error_msg", stringExtra);
                            intent.setClass(this, FreeWifiErrorUI.class);
                            startActivity(intent);
                            super.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                            break;
                        }
                        C34189m.m56062U(intent);
                        intent.putExtra("free_wifi_auth_type", 33);
                        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 33);
                        intent.putExtra("free_wifi_ssid", C34189m.m56059Mx("MicroMsg.FreeWifi.FreeWifiEntryUI"));
                        intent.putExtra("free_wifi_url", stringExtra);
                        intent.putExtra("free_wifi_ap_key", stringExtra);
                        intent.putExtra("free_wifi_source", 5);
                        intent.putExtra("free_wifi_channel_id", 1);
                        intent.setClass(this, FreeWifiFrontPageUI.class);
                        startActivity(intent);
                        super.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                        break;
                    }
                    break;
                case 6:
                    if (1 != C11964a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        C11964a.mtZ.mo23806ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    intent.setClass(this, FreeWifiNetCheckUI.class);
                    startActivity(intent);
                    super.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                    break;
            }
        }
        finish();
        finish();
        AppMethodBeat.m2505o(20955);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(20956);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiEntryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(20956);
            return;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiEntryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 77:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.myf = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C459602(), new C119853());
                    break;
                }
        }
        AppMethodBeat.m2505o(20956);
    }
}
