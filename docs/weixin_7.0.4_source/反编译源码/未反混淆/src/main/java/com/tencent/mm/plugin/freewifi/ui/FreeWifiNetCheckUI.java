package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.d.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class FreeWifiNetCheckUI extends MMActivity {
    private int cIb;
    private ap che;
    private Intent intent;
    private String key;
    private boolean myf = true;
    private final int mzA = 1;
    private final int mzB = 2;
    private int[] mzD = new int[]{R.drawable.aef, R.drawable.aeg, R.drawable.aeh, R.drawable.aei, R.drawable.aej};
    ak mzE = new ak() {
        int i = 0;

        public final void handleMessage(Message message) {
            AppMethodBeat.i(21034);
            if (message.what == 1) {
                if (this.i >= FreeWifiNetCheckUI.this.mzD.length) {
                    this.i = 0;
                }
                FreeWifiNetCheckUI.this.mzx.setImageResource(FreeWifiNetCheckUI.this.mzD[this.i]);
                this.i++;
            } else if (message.what == 2) {
                FreeWifiNetCheckUI.this.mzx.setImageResource(FreeWifiNetCheckUI.this.mzD[FreeWifiNetCheckUI.this.mzD.length - 1]);
            }
            super.handleMessage(message);
            AppMethodBeat.o(21034);
        }
    };
    private b mzL;
    ImageView mzx;
    private int scene;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FreeWifiNetCheckUI() {
        AppMethodBeat.i(21043);
        AppMethodBeat.o(21043);
    }

    static /* synthetic */ void e(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        AppMethodBeat.i(21053);
        freeWifiNetCheckUI.bzS();
        AppMethodBeat.o(21053);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21045);
        super.onCreate(bundle);
        setMMTitle((int) R.string.c0t);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21035);
                FreeWifiNetCheckUI.this.finish();
                AppMethodBeat.o(21035);
                return true;
            }
        });
        this.intent = getIntent();
        m.U(this.intent);
        this.key = getIntent().getStringExtra("free_wifi_ap_key");
        this.scene = getIntent().getIntExtra("free_wifi_source", 1);
        ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", m.V(this.intent), Integer.valueOf(m.W(this.intent)), this.key, d.byO());
        this.mzx = (ImageView) findViewById(R.id.bvw);
        this.che = new ap(new a() {
            public final boolean BI() {
                AppMethodBeat.i(21036);
                FreeWifiNetCheckUI.this.mzE.sendEmptyMessage(1);
                AppMethodBeat.o(21036);
                return true;
            }
        }, true);
        this.che.ae(200, 200);
        AppMethodBeat.o(21045);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        boolean z;
        String str;
        AppMethodBeat.i(21046);
        super.onResume();
        if (this.myf) {
            ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)));
            if (!b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)) {
                z = false;
                if (z) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "check permission not passed!");
                    AppMethodBeat.o(21046);
                    return;
                }
                switch (this.scene) {
                    case 1:
                        getIntent().putExtra("free_wifi_channel_id", 2);
                        this.cIb = 2;
                        if (!bo.isNullOrNil(this.key)) {
                            Uri parse;
                            str = "";
                            try {
                                parse = Uri.parse(this.key);
                                try {
                                    str = parse.getQueryParameter("q");
                                } catch (Exception e) {
                                    break;
                                }
                            } catch (Exception e2) {
                                parse = null;
                                break;
                            }
                            if (!"pc".equalsIgnoreCase(str)) {
                                str = parse.getQueryParameter("appid");
                                final String queryParameter = parse.getQueryParameter("shopid");
                                final String queryParameter2 = parse.getQueryParameter("ticket");
                                m.d(getIntent(), queryParameter2);
                                k.a byo = k.byo();
                                byo.muc = queryParameter;
                                byo.mud = str;
                                byo.kBq = queryParameter2;
                                byo.muf = k.b.GetPcFrontPage.muQ;
                                byo.mug = k.b.GetPcFrontPage.name;
                                byo.byq().byp();
                                ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), queryParameter, str, queryParameter2);
                                new h(str, Integer.valueOf(queryParameter).intValue(), queryParameter2).c(new f() {
                                    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                                        AppMethodBeat.i(21038);
                                        if (i == 0 && i2 == 0) {
                                            acq bzh = ((h) mVar).bzh();
                                            if (bzh != null) {
                                                Intent intent = FreeWifiNetCheckUI.this.getIntent();
                                                intent.putExtra("free_wifi_appid", bzh.vEn);
                                                intent.putExtra("free_wifi_head_img_url", bzh.mZW);
                                                intent.putExtra("free_wifi_welcome_msg", bzh.wkr);
                                                intent.putExtra("free_wifi_welcome_sub_title", bzh.wkt);
                                                intent.putExtra("free_wifi_privacy_url", bzh.wks);
                                                intent.putExtra("free_wifi_app_nickname", bzh.jCH);
                                                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", queryParameter);
                                                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET", queryParameter2);
                                                intent.setClass(FreeWifiNetCheckUI.this, FreeWifiPcUI.class);
                                                FreeWifiNetCheckUI.this.finish();
                                                FreeWifiNetCheckUI.this.startActivity(intent);
                                            }
                                        } else if (!m.eh(i, i2) || m.isEmpty(str)) {
                                            FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this, FreeWifiNetCheckUI.this.getString(R.string.bzw), FreeWifiNetCheckUI.this.getString(R.string.bzx));
                                        } else {
                                            FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this, str + "(" + m.a(m.X(FreeWifiNetCheckUI.this.intent), k.b.GetPcFrontPageReturn, i2) + ")", "");
                                        }
                                        k.a byo = k.byo();
                                        byo.muc = queryParameter;
                                        byo.mud = str;
                                        byo.kBq = queryParameter2;
                                        byo.muf = k.b.GetPcFrontPageReturn.muQ;
                                        byo.mug = k.b.GetPcFrontPageReturn.name;
                                        byo.result = i2;
                                        byo.byq().byp();
                                        ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", m.V(FreeWifiNetCheckUI.this.getIntent()), Integer.valueOf(m.W(FreeWifiNetCheckUI.this.getIntent())), Integer.valueOf(i2));
                                        AppMethodBeat.o(21038);
                                    }
                                });
                                break;
                            }
                            "_test".equals(str);
                            bzS();
                            break;
                        }
                        ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                        finish();
                        break;
                    case 4:
                        str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                        if ("1".equals(str)) {
                            getIntent().putExtra("free_wifi_channel_id", 9);
                            this.cIb = 9;
                        } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
                            getIntent().putExtra("free_wifi_channel_id", 8);
                            this.cIb = 8;
                        } else {
                            getIntent().putExtra("free_wifi_channel_id", 4);
                            this.cIb = 4;
                        }
                        str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                        if (!str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || !bo.isNullOrNil(this.key)) {
                            if (!str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                if (!str.equals("1")) {
                                    ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
                                    finish();
                                    break;
                                }
                                str = getIntent().getStringExtra("free_wifi_jsapi_param_username");
                                if (!d.isWifiEnabled()) {
                                    d.byJ();
                                }
                                com.tencent.mm.plugin.freewifi.model.h.b.mwc.a(new com.tencent.mm.plugin.freewifi.model.h.a() {
                                    public final void bU(List<ScanResult> list) {
                                        AppMethodBeat.i(21040);
                                        if (list == null || list.size() == 0) {
                                            FreeWifiNetCheckUI.this.finish();
                                            FreeWifiNetCheckUI.c(FreeWifiNetCheckUI.this);
                                            AppMethodBeat.o(21040);
                                            return;
                                        }
                                        buc buc = new buc();
                                        buc.wVV = new LinkedList();
                                        for (ScanResult scanResult : list) {
                                            if (scanResult != null) {
                                                dh dhVar = new dh();
                                                dhVar.mac = scanResult.BSSID;
                                                dhVar.vFl = scanResult.level;
                                                dhVar.ssid = scanResult.SSID;
                                                buc.wVV.add(dhVar);
                                            }
                                        }
                                        k.a byo = k.byo();
                                        byo.kBq = m.V(FreeWifiNetCheckUI.this.intent);
                                        byo.muf = k.b.ScanNearFieldWifiAndReport.muQ;
                                        byo.mug = k.b.ScanNearFieldWifiAndReport.name;
                                        byo.cIb = 9;
                                        byo.byq().byp();
                                        new com.tencent.mm.plugin.freewifi.d.k(str, buc, 9, m.V(FreeWifiNetCheckUI.this.getIntent())).c(new f() {
                                            public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                                                AppMethodBeat.i(21039);
                                                String bzq = ((com.tencent.mm.plugin.freewifi.d.k) mVar).bzq();
                                                if (bo.isNullOrNil(bzq)) {
                                                    FreeWifiNetCheckUI.this.finish();
                                                    FreeWifiNetCheckUI.c(FreeWifiNetCheckUI.this);
                                                    AppMethodBeat.o(21039);
                                                    return;
                                                }
                                                FreeWifiNetCheckUI.this.key = bzq;
                                                FreeWifiNetCheckUI.this.getIntent().putExtra("free_wifi_ap_key", bzq);
                                                FreeWifiNetCheckUI.this.cIb = 9;
                                                FreeWifiNetCheckUI.e(FreeWifiNetCheckUI.this);
                                                AppMethodBeat.o(21039);
                                            }
                                        });
                                        AppMethodBeat.o(21040);
                                    }
                                });
                                break;
                            }
                            bzS();
                            break;
                        }
                        ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
                        finish();
                        break;
                        break;
                    case 5:
                        this.cIb = getIntent().getIntExtra("free_wifi_channel_id", 1);
                        if (!bo.isNullOrNil(this.key)) {
                            bzS();
                            break;
                        }
                        ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                        finish();
                        break;
                    case 6:
                        getIntent().putExtra("free_wifi_channel_id", 10);
                        this.cIb = 10;
                        if (!bo.isNullOrNil(this.key)) {
                            bzS();
                            break;
                        }
                        ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                        finish();
                        break;
                    default:
                        ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
                        finish();
                        break;
                }
                ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", m.V(getIntent()), Integer.valueOf(m.W(this.intent)), Integer.valueOf(this.cIb));
                AppMethodBeat.o(21046);
            }
        }
        if (!b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            z = false;
        } else if (com.tencent.mm.modelgeo.d.agA()) {
            z = true;
        } else {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.c9z), getString(R.string.tz), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(21037);
                    com.tencent.mm.modelgeo.d.bX(FreeWifiNetCheckUI.this);
                    AppMethodBeat.o(21037);
                }
            }, null);
            z = false;
        }
        if (z) {
        }
        finish();
        if (!"pc".equalsIgnoreCase(str)) {
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", m.V(getIntent()), Integer.valueOf(m.W(this.intent)), Integer.valueOf(this.cIb));
        AppMethodBeat.o(21046);
    }

    private void bzS() {
        AppMethodBeat.i(21047);
        if (bo.isNullOrNil(this.key)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            finish();
            AppMethodBeat.o(21047);
            return;
        }
        this.mzL = new b(this, this.key, this.cIb);
        ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", m.V(getIntent()), Integer.valueOf(m.W(this.intent)), this.key, Integer.valueOf(this.cIb));
        this.mzL.connect();
        AppMethodBeat.o(21047);
    }

    public final int getLayoutId() {
        return R.layout.a0p;
    }

    public void onDestroy() {
        AppMethodBeat.i(21048);
        super.onDestroy();
        if (this.mzL != null) {
            this.mzL = null;
        }
        this.che.stopTimer();
        AppMethodBeat.o(21048);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(21049);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
            AppMethodBeat.o(21049);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(21049);
        return onKeyDown;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(21050);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(21050);
            return;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 77:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.myf = false;
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(21041);
                            FreeWifiNetCheckUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            FreeWifiNetCheckUI.this.finish();
                            AppMethodBeat.o(21041);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(21042);
                            FreeWifiNetCheckUI.this.finish();
                            AppMethodBeat.o(21042);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(21050);
    }

    public void finish() {
        AppMethodBeat.i(21044);
        if (this.che != null) {
            this.che.stopTimer();
        }
        this.mzE.sendEmptyMessage(2);
        super.finish();
        AppMethodBeat.o(21044);
    }

    static /* synthetic */ void a(FreeWifiNetCheckUI freeWifiNetCheckUI, String str, String str2) {
        AppMethodBeat.i(21051);
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiNetCheckUI, FreeWifiErrorUI.class);
        freeWifiNetCheckUI.finish();
        freeWifiNetCheckUI.startActivity(intent);
        AppMethodBeat.o(21051);
    }

    static /* synthetic */ void c(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        AppMethodBeat.i(21052);
        Intent intent = new Intent();
        intent.setClass(freeWifiNetCheckUI, FreeWifiNoWifiUI.class);
        freeWifiNetCheckUI.startActivity(intent);
        AppMethodBeat.o(21052);
    }
}
