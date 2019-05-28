package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.ttpic.FilterEnum4Shaka;

@a(3)
public class FreeWifiEntryUI extends Activity {
    private boolean myf = true;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20954);
        super.onCreate(bundle);
        AppMethodBeat.o(20954);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:8:0x0043, code skipped:
            if (com.tencent.mm.pluginsdk.permission.b.a(r12, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null) != false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        AppMethodBeat.i(20955);
        super.onResume();
        if (aw.RK()) {
            if (this.myf) {
                ab.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)));
            }
            if (b.o(this, "android.permission.ACCESS_COARSE_LOCATION") && !d.agA()) {
                h.a((Context) this, getString(R.string.c9z), getString(R.string.tz), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(20951);
                        d.bX(FreeWifiEntryUI.this);
                        AppMethodBeat.o(20951);
                    }
                }, null);
            }
            Intent intent = getIntent();
            ab.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "has notified, now scene is : %d", Integer.valueOf(getIntent().getIntExtra("free_wifi_source", 1)));
            switch (getIntent().getIntExtra("free_wifi_source", 1)) {
                case 1:
                    if (1 != i.a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        i.a.mtZ.ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    m.d(intent, intent.getStringExtra("free_wifi_mid"));
                    intent.setClass(this, FreeWifiNetCheckUI.class);
                    startActivity(intent);
                    super.overridePendingTransition(R.anim.df, R.anim.dc);
                    break;
                case 2:
                    c ML = j.byW().ML(com.tencent.mm.plugin.freewifi.model.d.byO());
                    if (ML != null) {
                        ab.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "banner click, freeWifiInfo.field_action:%d, field_showUrl:%s", Integer.valueOf(ML.field_action), ML.field_showUrl);
                        if (ML.field_action != 2 || bo.isNullOrNil(ML.field_showUrl)) {
                            if (ML.field_action == 1 && !bo.isNullOrNil(ML.field_showUrl)) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", Uri.parse(ML.field_showUrl).buildUpon().appendQueryParameter("lang", aa.g(getSharedPreferences(ah.doA(), 0))).build().toString());
                                intent2.putExtra("show_bottom", false);
                                com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                                break;
                            }
                            intent.setClass(this, FreeWifiAuthStateUI.class);
                            startActivity(intent);
                            break;
                        }
                        ((f) g.K(f.class)).b(this, ML.field_showUrl, FilterEnum4Shaka.MIC_WEISHI_BAIHUA, null);
                        break;
                    }
                    ab.e("MicroMsg.FreeWifi.FreeWifiEntryUI", "what the fuck, how could it be???");
                    break;
                case 3:
                    intent.putExtra("free_wifi_auth_type", 2);
                    intent.setClass(this, FreeWifiMIGNoAuthStateUI.class);
                    startActivity(intent);
                    break;
                case 4:
                    if (1 != i.a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        i.a.mtZ.ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    intent.setClass(this, FreeWifiNetCheckUI.class);
                    startActivity(intent);
                    super.overridePendingTransition(R.anim.df, R.anim.dc);
                    break;
                case 5:
                    if (1 != i.a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        i.a.mtZ.ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    String stringExtra = intent.getStringExtra("free_wifi_ap_key");
                    if (!m.isEmpty(stringExtra)) {
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
                                m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                                if (intExtra == 4) {
                                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.V(intent) + "_" + m.X(intent) + "_" + m.Y(intent) + "_" + System.currentTimeMillis());
                                }
                                intent.setClass(this, FreeWifiNetCheckUI.class);
                                startActivity(intent);
                                super.overridePendingTransition(R.anim.df, R.anim.dc);
                                break;
                            }
                            stringExtra = getString(R.string.c05);
                            intent = new Intent();
                            intent.putExtra("free_wifi_error_ui_error_msg", stringExtra);
                            intent.setClass(this, FreeWifiErrorUI.class);
                            startActivity(intent);
                            super.overridePendingTransition(R.anim.df, R.anim.dc);
                            break;
                        }
                        m.U(intent);
                        intent.putExtra("free_wifi_auth_type", 33);
                        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 33);
                        intent.putExtra("free_wifi_ssid", m.Mx("MicroMsg.FreeWifi.FreeWifiEntryUI"));
                        intent.putExtra("free_wifi_url", stringExtra);
                        intent.putExtra("free_wifi_ap_key", stringExtra);
                        intent.putExtra("free_wifi_source", 5);
                        intent.putExtra("free_wifi_channel_id", 1);
                        intent.setClass(this, FreeWifiFrontPageUI.class);
                        startActivity(intent);
                        super.overridePendingTransition(R.anim.df, R.anim.dc);
                        break;
                    }
                    break;
                case 6:
                    if (1 != i.a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        i.a.mtZ.ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    intent.setClass(this, FreeWifiNetCheckUI.class);
                    startActivity(intent);
                    super.overridePendingTransition(R.anim.df, R.anim.dc);
                    break;
            }
        }
        finish();
        finish();
        AppMethodBeat.o(20955);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(20956);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(20956);
            return;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 77:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.myf = false;
                    h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(20952);
                            FreeWifiEntryUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            FreeWifiEntryUI.this.finish();
                            AppMethodBeat.o(20952);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(20953);
                            FreeWifiEntryUI.this.finish();
                            AppMethodBeat.o(20953);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(20956);
    }
}
