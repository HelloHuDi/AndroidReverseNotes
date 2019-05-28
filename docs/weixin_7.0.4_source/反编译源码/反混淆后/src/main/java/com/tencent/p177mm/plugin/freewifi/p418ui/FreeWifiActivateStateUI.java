package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.freewifi.C39111g;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.p177mm.plugin.freewifi.model.FreeWifiNetworkReceiver.C20796a;
import com.tencent.p177mm.plugin.freewifi.model.FreeWifiNetworkReceiver.C20797b;
import com.tencent.p177mm.plugin.freewifi.p417g.C3137c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

@Deprecated
/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI */
public abstract class FreeWifiActivateStateUI extends MMActivity implements C20796a, C20797b {
    protected int cdf;
    protected int cvd;
    private int cxs = 1;
    protected String jUg;
    private FreeWifiStateView mxR;
    private TextView mxS;
    private TextView mxT;
    private Button mxU;
    protected Button mxV;
    protected String mxW;
    protected FreeWifiNetworkReceiver mxX;
    protected boolean mxY = false;
    private boolean mxZ = false;
    private C7564ap mya = new C7564ap(new C77631(), false);
    private C7564ap myb = new C7564ap(new C77642(), true);
    private C4931a myc = new C77673();
    protected String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI$8 */
    class C77598 implements Runnable {
        C77598() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20906);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", FreeWifiActivateStateUI.this.ssid);
            FreeWifiActivateStateUI.this.bzy();
            AppMethodBeat.m2505o(20906);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI$6 */
    class C77606 implements OnClickListener {
        C77606() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20904);
            String string = FreeWifiActivateStateUI.this.getString(C25738R.string.c07);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(FreeWifiActivateStateUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(20904);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI$5 */
    class C77615 implements OnClickListener {
        C77615() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20903);
            if (FreeWifiActivateStateUI.this.bzz() == 2) {
                FreeWifiActivateStateUI.this.finish();
                AppMethodBeat.m2505o(20903);
                return;
            }
            C45957d.m85352a(FreeWifiActivateStateUI.this.ssid, 1, FreeWifiActivateStateUI.this.getIntent());
            FreeWifiActivateStateUI.this.mxY = false;
            FreeWifiActivateStateUI.this.bzF();
            AppMethodBeat.m2505o(20903);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI$7 */
    class C77627 implements Runnable {
        C77627() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20905);
            FreeWifiActivateStateUI.m13799d(FreeWifiActivateStateUI.this);
            AppMethodBeat.m2505o(20905);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI$1 */
    class C77631 implements C5015a {
        C77631() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(20899);
            if (!C5046bo.isNullOrNil(FreeWifiActivateStateUI.this.ssid)) {
                FreeWifiActivateStateUI.this.cxs = FreeWifiActivateStateUI.this.bzz();
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", FreeWifiActivateStateUI.this.ssid, Integer.valueOf(FreeWifiActivateStateUI.this.cxs));
                FreeWifiActivateStateUI.this.myb.stopTimer();
                if (FreeWifiActivateStateUI.this.cxs != 2) {
                    FreeWifiActivateStateUI.this.bzD();
                    FreeWifiActivateStateUI.this.bzB();
                    C45957d.m85352a(FreeWifiActivateStateUI.this.ssid, 3, FreeWifiActivateStateUI.this.getIntent());
                }
            }
            AppMethodBeat.m2505o(20899);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI$2 */
    class C77642 implements C5015a {
        C77642() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(20900);
            if (C45957d.m85348MD(FreeWifiActivateStateUI.this.ssid)) {
                FreeWifiActivateStateUI.this.mo17587a(State.CONNECTED);
                FreeWifiActivateStateUI.this.myb.stopTimer();
                AppMethodBeat.m2505o(20900);
                return false;
            }
            AppMethodBeat.m2505o(20900);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI$4 */
    class C77654 implements OnMenuItemClickListener {
        C77654() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20902);
            FreeWifiActivateStateUI.this.goBack();
            AppMethodBeat.m2505o(20902);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI$3 */
    class C77673 implements C4931a {
        C77673() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(20901);
            FreeWifiActivateStateUI.this.cxs = FreeWifiActivateStateUI.this.bzz();
            FreeWifiActivateStateUI.this.mo17578uQ(FreeWifiActivateStateUI.this.cxs);
            AppMethodBeat.m2505o(20901);
        }
    }

    public abstract void aqU();

    public abstract void bzy();

    public abstract int bzz();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.mxW = getIntent().getStringExtra("free_wifi_mid");
        this.jUg = getIntent().getStringExtra("free_wifi_url");
        this.cvd = getIntent().getIntExtra("free_wifi_source", 1);
        this.cdf = getIntent().getIntExtra("free_wifi_channel_id", 0);
        switch (this.cvd) {
            case 1:
            case 3:
            case 4:
            case 5:
                if (C5046bo.isNullOrNil(this.ssid)) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
                    break;
                }
                int i;
                C3137c ML = C11976j.byW().mo17045ML(this.ssid);
                if (ML == null) {
                    ML = new C3137c();
                    ML.field_ssidmd5 = C4995ag.m7428ck(this.ssid);
                    ML.field_ssid = this.ssid;
                    ML.field_connectState = 1;
                    i = 1;
                } else {
                    i = 0;
                }
                ML.field_url = this.jUg;
                ML.field_mid = this.mxW;
                ML.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
                if (i != 0) {
                    C11976j.byW().mo10101b((C4925c) ML);
                } else {
                    C11976j.byW().mo10103c(ML, new String[0]);
                }
            case 2:
                C3137c bzx = C11976j.byW().bzx();
                if (bzx != null) {
                    this.ssid = bzx.field_ssid;
                    this.mxW = bzx.field_mid;
                    this.jUg = bzx.field_url;
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", this.ssid, this.mxW, this.jUg);
                } else {
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "there is no connect sucessfull wifi info");
                }
                if (!C5046bo.isNullOrNil(this.ssid)) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
                    break;
                }
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mxW, Integer.valueOf(this.cvd));
                break;
        }
        if (!C5046bo.isNullOrNil(this.ssid)) {
        }
        initView();
        C11976j.byW().mo10116c(this.myc);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onResume() {
        super.onResume();
        if (!C5046bo.isNullOrNil(this.ssid)) {
            bzF();
        }
    }

    public void initView() {
        setBackBtn(new C77654());
        this.mxR = (FreeWifiStateView) findViewById(2131824153);
        this.mxS = (TextView) findViewById(2131824154);
        this.mxT = (TextView) findViewById(2131824155);
        if (this.cvd == 3) {
            this.mxT.setText(getString(C25738R.string.czp, new Object[]{this.ssid}));
        } else {
            this.mxT.setText(getString(C25738R.string.atp, new Object[]{this.ssid}));
        }
        this.mxU = (Button) findViewById(2131824156);
        this.mxU.setOnClickListener(new C77615());
        this.mxV = (Button) findViewById(2131824143);
        this.mxV.setOnClickListener(new C77606());
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzB() {
        if (this.mxX != null) {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
            this.mxX.mvX = null;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzC() {
        if (this.mxX == null) {
            bzE();
        }
        this.mxX.mvY = this;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzD() {
        if (this.mxX != null) {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
            this.mxX.mvY = null;
        }
    }

    private void bzE() {
        this.mxX = new FreeWifiNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.mxX, intentFilter);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzF() {
        if (C45957d.isWifiEnabled()) {
            this.cxs = bzz();
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.cxs));
            if (this.cxs != 2) {
                this.mya.mo16770ae(60000, 60000);
                this.myb.mo16770ae(1000, 1000);
                if (C45957d.m85348MD(this.ssid)) {
                    bzG();
                    return;
                } else {
                    C11976j.byZ().byI().post(new C77598());
                    return;
                }
            }
            mo17578uQ(this.cxs);
            return;
        }
        this.mya.mo16770ae(60000, 60000);
        this.myb.mo16770ae(1000, 1000);
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
        C11976j.byZ().byI().post(new C77627());
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: uQ */
    public final void mo17578uQ(int i) {
        this.mxR.setOnClickListener(null);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case -2014:
                this.mya.stopTimer();
                this.myb.stopTimer();
                this.mxR.setImageResource(C25738R.drawable.aen);
                this.mxR.setState(3);
                this.mxS.setText(C25738R.string.c0b);
                this.mxS.setVisibility(0);
                this.mxT.setText(C25738R.string.c0c);
                this.mxT.setVisibility(0);
                break;
            case 1:
                this.mxR.setImageResource(C25738R.drawable.aeo);
                this.mxR.setState(1);
                this.mxS.setText(C25738R.string.atm);
                break;
            case 2:
                this.mxR.setImageResource(C25738R.drawable.aem);
                this.mxR.setState(2);
                this.mxS.setText(C25738R.string.atl);
                this.mxU.setVisibility(0);
                this.mxU.setText(C25738R.string.bzk);
                this.mya.stopTimer();
                this.myb.stopTimer();
                if (this.cvd == 1 || this.cvd == 5 || this.cvd == 4) {
                    this.mxU.setVisibility(4);
                    final C3137c ML = C11976j.byW().mo17045ML(this.ssid);
                    if (!(ML == null || C5046bo.isNullOrNil(ML.field_showUrl) || this.mxZ)) {
                        this.mxZ = true;
                        C5004al.m7442n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(20907);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", ML.field_showUrl + "&lang=" + C4988aa.m7402g(FreeWifiActivateStateUI.this.getSharedPreferences(C4996ah.doA(), 0)));
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("stastic_scene", 7);
                                C25985d.m41467b(FreeWifiActivateStateUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", intent.getStringExtra("rawUrl"));
                                FreeWifiActivateStateUI.this.finish();
                                AppMethodBeat.m2505o(20907);
                            }
                        }, 1000);
                    }
                }
                C39125d.m66564IF();
                return;
            case 3:
                this.mxR.setImageResource(C25738R.drawable.aeo);
                this.mxR.setState(3);
                this.mxR.lAB = 2;
                this.mxS.setText(C25738R.string.atq);
                this.mxU.setVisibility(0);
                this.mxU.setText(C25738R.string.c0p);
                this.mya.stopTimer();
                this.myb.stopTimer();
                return;
            default:
                this.mxR.setImageResource(C25738R.drawable.aeo);
                this.mxS.setText(C25738R.string.atm);
                if (this.cvd != 3) {
                    this.mxT.setText(getString(C25738R.string.atp, new Object[]{this.ssid}));
                    break;
                }
                this.mxT.setText(getString(C25738R.string.czp, new Object[]{this.ssid}));
                break;
        }
        this.mxU.setVisibility(8);
    }

    private void bzG() {
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.mxY));
        if (this.mxY) {
            C4990ab.m7410d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
            return;
        }
        this.mya.mo16770ae(60000, 60000);
        this.myb.mo16770ae(1000, 1000);
        aqU();
        this.mxY = true;
    }

    public final int getLayoutId() {
        return 2130969598;
    }

    public void onDestroy() {
        super.onDestroy();
        C11976j.byW().mo10117d(this.myc);
        bzB();
        bzD();
        if (this.mxX != null) {
            unregisterReceiver(this.mxX);
        }
        this.mya.stopTimer();
        this.myb.stopTimer();
        C11976j.byZ().release();
    }

    /* renamed from: vS */
    public final void mo17579vS(int i) {
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", Integer.valueOf(i));
        switch (i) {
            case 3:
                bzB();
                bzF();
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        finish();
        if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false)) {
            C39111g.gkE.mo38923h(new Intent(), (Context) this);
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m13799d(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        if (freeWifiActivateStateUI.mxX == null) {
            freeWifiActivateStateUI.bzE();
        }
        freeWifiActivateStateUI.mxX.mvX = freeWifiActivateStateUI;
        C45957d.byJ();
    }
}
