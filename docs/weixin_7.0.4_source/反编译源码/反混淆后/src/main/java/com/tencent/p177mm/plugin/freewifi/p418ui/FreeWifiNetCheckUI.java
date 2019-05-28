package com.tencent.p177mm.plugin.freewifi.p418ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C34191h.C20801b;
import com.tencent.p177mm.plugin.freewifi.model.C34191h.C28083a;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p416d.C20782h;
import com.tencent.p177mm.plugin.freewifi.p416d.C44739k;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.C7257dh;
import com.tencent.p177mm.protocal.protobuf.acq;
import com.tencent.p177mm.protocal.protobuf.buc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI */
public class FreeWifiNetCheckUI extends MMActivity {
    private int cIb;
    private C7564ap che;
    private Intent intent;
    private String key;
    private boolean myf = true;
    private final int mzA = 1;
    private final int mzB = 2;
    private int[] mzD = new int[]{C25738R.drawable.aef, C25738R.drawable.aeg, C25738R.drawable.aeh, C25738R.drawable.aei, C25738R.drawable.aej};
    C7306ak mzE = new C280961();
    private C20828b mzL;
    ImageView mzx;
    private int scene;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI$3 */
    class C119933 implements C5015a {
        C119933() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(21036);
            FreeWifiNetCheckUI.this.mzE.sendEmptyMessage(1);
            AppMethodBeat.m2505o(21036);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI$2 */
    class C280942 implements OnMenuItemClickListener {
        C280942() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21035);
            FreeWifiNetCheckUI.this.finish();
            AppMethodBeat.m2505o(21035);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI$4 */
    class C280954 implements OnClickListener {
        C280954() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(21037);
            C26443d.m42103bX(FreeWifiNetCheckUI.this);
            AppMethodBeat.m2505o(21037);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI$1 */
    class C280961 extends C7306ak {
        /* renamed from: i */
        int f13693i = 0;

        C280961() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(21034);
            if (message.what == 1) {
                if (this.f13693i >= FreeWifiNetCheckUI.this.mzD.length) {
                    this.f13693i = 0;
                }
                FreeWifiNetCheckUI.this.mzx.setImageResource(FreeWifiNetCheckUI.this.mzD[this.f13693i]);
                this.f13693i++;
            } else if (message.what == 2) {
                FreeWifiNetCheckUI.this.mzx.setImageResource(FreeWifiNetCheckUI.this.mzD[FreeWifiNetCheckUI.this.mzD.length - 1]);
            }
            super.handleMessage(message);
            AppMethodBeat.m2505o(21034);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI$7 */
    class C280997 implements OnClickListener {
        C280997() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(21041);
            FreeWifiNetCheckUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            FreeWifiNetCheckUI.this.finish();
            AppMethodBeat.m2505o(21041);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI$8 */
    class C281008 implements OnClickListener {
        C281008() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(21042);
            FreeWifiNetCheckUI.this.finish();
            AppMethodBeat.m2505o(21042);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FreeWifiNetCheckUI() {
        AppMethodBeat.m2504i(21043);
        AppMethodBeat.m2505o(21043);
    }

    /* renamed from: e */
    static /* synthetic */ void m44662e(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        AppMethodBeat.m2504i(21053);
        freeWifiNetCheckUI.bzS();
        AppMethodBeat.m2505o(21053);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21045);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.c0t);
        setBackBtn(new C280942());
        this.intent = getIntent();
        C34189m.m56062U(this.intent);
        this.key = getIntent().getStringExtra("free_wifi_ap_key");
        this.scene = getIntent().getIntExtra("free_wifi_source", 1);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)), this.key, C45957d.byO());
        this.mzx = (ImageView) findViewById(2131824129);
        this.che = new C7564ap(new C119933(), true);
        this.che.mo16770ae(200, 200);
        AppMethodBeat.m2505o(21045);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        boolean z;
        String str;
        AppMethodBeat.m2504i(21046);
        super.onResume();
        if (this.myf) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)));
            if (!C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)) {
                z = false;
                if (z) {
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "check permission not passed!");
                    AppMethodBeat.m2505o(21046);
                    return;
                }
                switch (this.scene) {
                    case 1:
                        getIntent().putExtra("free_wifi_channel_id", 2);
                        this.cIb = 2;
                        if (!C5046bo.isNullOrNil(this.key)) {
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
                                C34189m.m56072d(getIntent(), queryParameter2);
                                C11967a byo = C11966k.byo();
                                byo.muc = queryParameter;
                                byo.mud = str;
                                byo.kBq = queryParameter2;
                                byo.muf = C11968b.GetPcFrontPage.muQ;
                                byo.mug = C11968b.GetPcFrontPage.name;
                                byo.byq().byp();
                                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), queryParameter, str, queryParameter2);
                                new C20782h(str, Integer.valueOf(queryParameter).intValue(), queryParameter2).mo68619c(new C1202f() {
                                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                        AppMethodBeat.m2504i(21038);
                                        if (i == 0 && i2 == 0) {
                                            acq bzh = ((C20782h) c1207m).bzh();
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
                                        } else if (!C34189m.m56075eh(i, i2) || C34189m.isEmpty(str)) {
                                            FreeWifiNetCheckUI.m44657a(FreeWifiNetCheckUI.this, FreeWifiNetCheckUI.this.getString(C25738R.string.bzw), FreeWifiNetCheckUI.this.getString(C25738R.string.bzx));
                                        } else {
                                            FreeWifiNetCheckUI.m44657a(FreeWifiNetCheckUI.this, str + "(" + C34189m.m56068a(C34189m.m56065X(FreeWifiNetCheckUI.this.intent), C11968b.GetPcFrontPageReturn, i2) + ")", "");
                                        }
                                        C11967a byo = C11966k.byo();
                                        byo.muc = queryParameter;
                                        byo.mud = str;
                                        byo.kBq = queryParameter2;
                                        byo.muf = C11968b.GetPcFrontPageReturn.muQ;
                                        byo.mug = C11968b.GetPcFrontPageReturn.name;
                                        byo.result = i2;
                                        byo.byq().byp();
                                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", C34189m.m56063V(FreeWifiNetCheckUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(FreeWifiNetCheckUI.this.getIntent())), Integer.valueOf(i2));
                                        AppMethodBeat.m2505o(21038);
                                    }
                                });
                                break;
                            }
                            "_test".equals(str);
                            bzS();
                            break;
                        }
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
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
                        if (!str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || !C5046bo.isNullOrNil(this.key)) {
                            if (!str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                if (!str.equals("1")) {
                                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
                                    finish();
                                    break;
                                }
                                str = getIntent().getStringExtra("free_wifi_jsapi_param_username");
                                if (!C45957d.isWifiEnabled()) {
                                    C45957d.byJ();
                                }
                                C20801b.mwc.mo54766a(new C28083a() {

                                    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI$6$1 */
                                    class C280981 implements C1202f {
                                        C280981() {
                                        }

                                        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                            AppMethodBeat.m2504i(21039);
                                            String bzq = ((C44739k) c1207m).bzq();
                                            if (C5046bo.isNullOrNil(bzq)) {
                                                FreeWifiNetCheckUI.this.finish();
                                                FreeWifiNetCheckUI.m44660c(FreeWifiNetCheckUI.this);
                                                AppMethodBeat.m2505o(21039);
                                                return;
                                            }
                                            FreeWifiNetCheckUI.this.key = bzq;
                                            FreeWifiNetCheckUI.this.getIntent().putExtra("free_wifi_ap_key", bzq);
                                            FreeWifiNetCheckUI.this.cIb = 9;
                                            FreeWifiNetCheckUI.m44662e(FreeWifiNetCheckUI.this);
                                            AppMethodBeat.m2505o(21039);
                                        }
                                    }

                                    /* renamed from: bU */
                                    public final void mo23813bU(List<ScanResult> list) {
                                        AppMethodBeat.m2504i(21040);
                                        if (list == null || list.size() == 0) {
                                            FreeWifiNetCheckUI.this.finish();
                                            FreeWifiNetCheckUI.m44660c(FreeWifiNetCheckUI.this);
                                            AppMethodBeat.m2505o(21040);
                                            return;
                                        }
                                        buc buc = new buc();
                                        buc.wVV = new LinkedList();
                                        for (ScanResult scanResult : list) {
                                            if (scanResult != null) {
                                                C7257dh c7257dh = new C7257dh();
                                                c7257dh.mac = scanResult.BSSID;
                                                c7257dh.vFl = scanResult.level;
                                                c7257dh.ssid = scanResult.SSID;
                                                buc.wVV.add(c7257dh);
                                            }
                                        }
                                        C11967a byo = C11966k.byo();
                                        byo.kBq = C34189m.m56063V(FreeWifiNetCheckUI.this.intent);
                                        byo.muf = C11968b.ScanNearFieldWifiAndReport.muQ;
                                        byo.mug = C11968b.ScanNearFieldWifiAndReport.name;
                                        byo.cIb = 9;
                                        byo.byq().byp();
                                        new C44739k(str, buc, 9, C34189m.m56063V(FreeWifiNetCheckUI.this.getIntent())).mo68619c(new C280981());
                                        AppMethodBeat.m2505o(21040);
                                    }
                                });
                                break;
                            }
                            bzS();
                            break;
                        }
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
                        finish();
                        break;
                        break;
                    case 5:
                        this.cIb = getIntent().getIntExtra("free_wifi_channel_id", 1);
                        if (!C5046bo.isNullOrNil(this.key)) {
                            bzS();
                            break;
                        }
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                        finish();
                        break;
                    case 6:
                        getIntent().putExtra("free_wifi_channel_id", 10);
                        this.cIb = 10;
                        if (!C5046bo.isNullOrNil(this.key)) {
                            bzS();
                            break;
                        }
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                        finish();
                        break;
                    default:
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
                        finish();
                        break;
                }
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(this.intent)), Integer.valueOf(this.cIb));
                AppMethodBeat.m2505o(21046);
            }
        }
        if (!C35805b.m58714o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            z = false;
        } else if (C26443d.agA()) {
            z = true;
        } else {
            C30379h.m48445a((Context) this, getString(C25738R.string.c9z), getString(C25738R.string.f9238tz), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C280954(), null);
            z = false;
        }
        if (z) {
        }
        finish();
        if (!"pc".equalsIgnoreCase(str)) {
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(this.intent)), Integer.valueOf(this.cIb));
        AppMethodBeat.m2505o(21046);
    }

    private void bzS() {
        AppMethodBeat.m2504i(21047);
        if (C5046bo.isNullOrNil(this.key)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            finish();
            AppMethodBeat.m2505o(21047);
            return;
        }
        this.mzL = new C20828b(this, this.key, this.cIb);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(this.intent)), this.key, Integer.valueOf(this.cIb));
        this.mzL.connect();
        AppMethodBeat.m2505o(21047);
    }

    public final int getLayoutId() {
        return 2130969594;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(21048);
        super.onDestroy();
        if (this.mzL != null) {
            this.mzL = null;
        }
        this.che.stopTimer();
        AppMethodBeat.m2505o(21048);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(21049);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
            AppMethodBeat.m2505o(21049);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(21049);
        return onKeyDown;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(21050);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(21050);
            return;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 77:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.myf = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C280997(), new C281008());
                    break;
                }
        }
        AppMethodBeat.m2505o(21050);
    }

    public void finish() {
        AppMethodBeat.m2504i(21044);
        if (this.che != null) {
            this.che.stopTimer();
        }
        this.mzE.sendEmptyMessage(2);
        super.finish();
        AppMethodBeat.m2505o(21044);
    }

    /* renamed from: a */
    static /* synthetic */ void m44657a(FreeWifiNetCheckUI freeWifiNetCheckUI, String str, String str2) {
        AppMethodBeat.m2504i(21051);
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiNetCheckUI, FreeWifiErrorUI.class);
        freeWifiNetCheckUI.finish();
        freeWifiNetCheckUI.startActivity(intent);
        AppMethodBeat.m2505o(21051);
    }

    /* renamed from: c */
    static /* synthetic */ void m44660c(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        AppMethodBeat.m2504i(21052);
        Intent intent = new Intent();
        intent.setClass(freeWifiNetCheckUI, FreeWifiNoWifiUI.class);
        freeWifiNetCheckUI.startActivity(intent);
        AppMethodBeat.m2505o(21052);
    }
}
