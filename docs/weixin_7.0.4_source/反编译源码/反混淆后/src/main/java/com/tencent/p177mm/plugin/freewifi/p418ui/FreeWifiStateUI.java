package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C11970l;
import com.tencent.p177mm.plugin.freewifi.C34189m;
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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

@Deprecated
/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI */
public abstract class FreeWifiStateUI extends MMActivity implements C20796a, C20797b {
    protected String cBb;
    protected int cdf;
    protected String csB;
    protected String cuH;
    protected int cvd;
    private int cxs = 1;
    private final C25814c fGS;
    protected String jUg;
    protected String mAa;
    protected String mAb;
    protected String mwH;
    protected String mxW;
    protected FreeWifiNetworkReceiver mxX;
    protected boolean mxY = false;
    private TextView myB;
    private ImageView myQ;
    private TextView myR;
    private TextView myS;
    private Button myT;
    private Button myU;
    protected String myX;
    protected String myY;
    protected String myZ;
    private C7564ap mya = new C7564ap(new C77731(), false);
    private C7564ap myb = new C7564ap(new C77712(), true);
    private C4931a myc;
    private C44275p mzU = null;
    protected int mzZ;
    protected String mza;
    protected String signature;
    protected String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI$3 */
    class C77693 implements C4931a {
        private int mAd = -999999999;

        C77693() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(21073);
            FreeWifiStateUI.this.cxs = FreeWifiStateUI.this.bzz();
            if (this.mAd != FreeWifiStateUI.this.cxs) {
                this.mAd = FreeWifiStateUI.this.cxs;
                FreeWifiStateUI.this.mo17595uQ(FreeWifiStateUI.this.cxs);
            }
            AppMethodBeat.m2505o(21073);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI$5 */
    class C77705 implements OnClickListener {
        C77705() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21075);
            C11970l.m19875w(C45957d.byN(), FreeWifiStateUI.this.getIntent().getStringExtra("free_wifi_ap_key"), FreeWifiStateUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
            if (FreeWifiStateUI.this.bzz() == 2) {
                FreeWifiStateUI.this.finish();
                AppMethodBeat.m2505o(21075);
                return;
            }
            C45957d.m85352a(FreeWifiStateUI.this.ssid, 1, FreeWifiStateUI.this.getIntent());
            FreeWifiStateUI.this.mxY = false;
            FreeWifiStateUI.this.bzF();
            AppMethodBeat.m2505o(21075);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI$2 */
    class C77712 implements C5015a {
        C77712() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(21072);
            if (C45957d.m85348MD(FreeWifiStateUI.this.ssid)) {
                FreeWifiStateUI.this.mo17587a(State.CONNECTED);
                FreeWifiStateUI.this.myb.stopTimer();
                AppMethodBeat.m2505o(21072);
                return false;
            }
            AppMethodBeat.m2505o(21072);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI$4 */
    class C77724 implements OnMenuItemClickListener {
        C77724() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21074);
            FreeWifiStateUI.this.goBack();
            AppMethodBeat.m2505o(21074);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI$1 */
    class C77731 implements C5015a {
        C77731() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(21071);
            if (!C5046bo.isNullOrNil(FreeWifiStateUI.this.ssid)) {
                FreeWifiStateUI.this.cxs = FreeWifiStateUI.this.bzz();
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", FreeWifiStateUI.this.ssid, Integer.valueOf(FreeWifiStateUI.this.cxs));
                FreeWifiStateUI.this.myb.stopTimer();
                C11967a byo = C11966k.byo();
                byo.ssid = FreeWifiStateUI.this.ssid;
                byo.cuH = FreeWifiStateUI.this.cuH;
                byo.kBq = C34189m.m56063V(FreeWifiStateUI.this.getIntent());
                byo.mue = C34189m.m56065X(FreeWifiStateUI.this.getIntent());
                byo.muf = C11968b.AddNetwork.muQ;
                byo.mug = C11968b.AddNetwork.name;
                byo.result = -16;
                byo.cIb = C34189m.m56066Y(FreeWifiStateUI.this.getIntent());
                byo.mud = FreeWifiStateUI.this.csB;
                byo.muh = FreeWifiStateUI.this.cBb;
                byo.byq().byp();
                if (FreeWifiStateUI.this.cxs != 2) {
                    FreeWifiStateUI.this.bzD();
                    FreeWifiStateUI.this.bzB();
                    C45957d.m85352a(FreeWifiStateUI.this.ssid, 3, FreeWifiStateUI.this.getIntent());
                }
            }
            AppMethodBeat.m2505o(21071);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI$7 */
    class C77747 implements Runnable {
        C77747() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21077);
            FreeWifiStateUI.m13809d(FreeWifiStateUI.this);
            AppMethodBeat.m2505o(21077);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI$8 */
    class C77758 implements Runnable {
        C77758() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21078);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", FreeWifiStateUI.this.ssid);
            FreeWifiStateUI.this.bzy();
            AppMethodBeat.m2505o(21078);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI$9 */
    class C77769 implements OnCancelListener {
        C77769() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(21079);
            C45957d.m85352a(FreeWifiStateUI.this.ssid, 4, FreeWifiStateUI.this.getIntent());
            AppMethodBeat.m2505o(21079);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI$6 */
    class C77776 implements OnClickListener {
        C77776() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21076);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", FreeWifiStateUI.this.mza);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(FreeWifiStateUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(21076);
        }
    }

    /* renamed from: a */
    public abstract void mo17587a(State state);

    public abstract void aqU();

    public abstract void bzy();

    public abstract int bzz();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FreeWifiStateUI() {
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePG = true;
        c17927a.ePT = C25738R.drawable.aee;
        c17927a.eQf = true;
        c17927a.eQg = 0.0f;
        this.fGS = c17927a.ahG();
        this.myc = new C77693();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cuH = getIntent().getStringExtra("free_wifi_ap_key");
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.mxW = getIntent().getStringExtra("free_wifi_mid");
        this.jUg = getIntent().getStringExtra("free_wifi_url");
        this.cvd = getIntent().getIntExtra("free_wifi_source", 1);
        this.cdf = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.csB = getIntent().getStringExtra("free_wifi_appid");
        this.myX = getIntent().getStringExtra("free_wifi_head_img_url");
        this.myY = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.myZ = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.mza = getIntent().getStringExtra("free_wifi_privacy_url");
        this.mwH = getIntent().getStringExtra("free_wifi_app_nickname");
        switch (this.cvd) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
                if (C5046bo.isNullOrNil(this.ssid)) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
                    break;
                }
                int i;
                C3137c ML = C11976j.byW().mo17045ML(this.ssid);
                if (ML == null) {
                    ML = new C3137c();
                    ML.field_ssidmd5 = C4995ag.m7428ck(this.ssid);
                    ML.field_ssid = this.ssid;
                    i = 1;
                } else {
                    i = 0;
                }
                ML.field_url = this.jUg;
                ML.field_mid = this.mxW;
                ML.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
                ML.field_connectState = 1;
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
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", this.ssid, this.mxW, this.jUg);
                } else {
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiStateUI", "there is no connect sucessfull wifi info");
                }
                if (!C5046bo.isNullOrNil(this.ssid)) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
                    break;
                }
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mxW, Integer.valueOf(this.cvd));
                break;
        }
        if (!C5046bo.isNullOrNil(this.ssid)) {
        }
        initView();
        C11976j.byW().mo10116c(this.myc);
        C11970l.m19874v(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void initView() {
        setBackBtn(new C77724());
        if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
            findViewById(2131824137).setVisibility(0);
        }
        this.myQ = (ImageView) findViewById(2131824129);
        this.myR = (TextView) findViewById(2131824130);
        this.myS = (TextView) findViewById(2131824131);
        this.myB = (TextView) findViewById(2131824132);
        this.myT = (Button) findViewById(2131824135);
        this.myT.setOnClickListener(new C77705());
        this.myU = (Button) findViewById(2131824136);
        this.myU.setOnClickListener(new C77776());
        if (C5046bo.isNullOrNil(this.ssid)) {
            this.myS.setText(getString(C25738R.string.c0r));
            this.myT.setVisibility(4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzB() {
        if (this.mxX != null) {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
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
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
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
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.cxs));
            if (this.cxs != 2) {
                if (C34189m.m56065X(getIntent()) == 4) {
                    this.mya.mo16770ae(30000, 30000);
                } else {
                    this.mya.mo16770ae(60000, 60000);
                }
                this.myb.mo16770ae(1000, 1000);
                if (C45957d.m85348MD(this.ssid)) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.mxY));
                    if (this.mxY) {
                        C4990ab.m7410d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
                        return;
                    }
                    this.mya.mo16770ae(60000, 60000);
                    this.myb.mo16770ae(1000, 1000);
                    aqU();
                    this.mxY = true;
                    return;
                }
                C11976j.byZ().byI().post(new C77758());
                return;
            }
            C45957d.m85352a(this.ssid, this.cxs, getIntent());
            return;
        }
        this.mya.mo16770ae(60000, 60000);
        this.myb.mo16770ae(1000, 1000);
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
        C11976j.byZ().byI().post(new C77747());
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: uQ */
    public final void mo17595uQ(int i) {
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case -2014:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mya.stopTimer();
                this.myb.stopTimer();
                this.myB.setVisibility(0);
                this.myT.setText(C25738R.string.c0p);
                return;
            case -1:
                return;
            case 1:
                this.myB.setVisibility(4);
                this.myT.setText(C25738R.string.ato);
                this.mzU = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.ato), true, new C77769());
                return;
            case 2:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mya.stopTimer();
                this.myb.stopTimer();
                this.myT.setText(C25738R.string.atl);
                this.myT.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.csB);
                intent.putExtra("free_wifi_app_nickname", this.mwH);
                intent.putExtra("free_wifi_app_username", this.cBb);
                intent.putExtra("free_wifi_signature", this.signature);
                intent.putExtra("free_wifi_finish_actioncode", this.mzZ);
                intent.putExtra("free_wifi_finish_url", this.mAa);
                if (C5046bo.isNullOrNil(this.mAb)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    intent.putExtra("free_wifi_qinghuai_url", this.mAb);
                    intent.setClass(this, FreeWifiSuccWebViewUI.class);
                }
                finish();
                startActivity(intent);
                C39125d.m66564IF();
                return;
            case 3:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mya.stopTimer();
                this.myb.stopTimer();
                this.myB.setVisibility(0);
                this.myT.setText(C25738R.string.c0p);
                return;
            case 4:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mya.stopTimer();
                this.myb.stopTimer();
                this.mxY = false;
                this.myB.setVisibility(4);
                this.myT.setText(C25738R.string.atr);
                if (!(C34189m.m56066Y(getIntent()) != 10 || C34189m.isEmpty(C1427q.eth.etR) || C34189m.isEmpty(C1427q.m3045bB(this.mController.ylL)))) {
                    this.myT.setText(String.format(getString(C25738R.string.bzn), new Object[]{C1427q.m3045bB(this.mController.ylL)}));
                }
                if (this.cvd == 3) {
                    this.myS.setText(getString(C25738R.string.czp, new Object[]{this.ssid}));
                } else if (C5046bo.isNullOrNil(this.myZ)) {
                    this.myS.setText(getString(C25738R.string.atn));
                } else {
                    this.myS.setText(this.myZ);
                }
                if (!C5046bo.isNullOrNil(this.csB)) {
                    if (!C5046bo.isNullOrNil(this.myY)) {
                        this.myR.setText(this.myY);
                    }
                    if (!C5046bo.isNullOrNil(this.myX)) {
                        C32291o.ahp().mo43766a(this.myX, this.myQ, this.fGS);
                        return;
                    }
                    return;
                }
                return;
            default:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.myB.setVisibility(4);
                this.myT.setText(C25738R.string.atr);
                if (this.cvd == 3) {
                    this.myS.setText(getString(C25738R.string.czp, new Object[]{this.ssid}));
                } else if (C5046bo.isNullOrNil(this.myZ)) {
                    this.myS.setText(getString(C25738R.string.atn));
                } else {
                    this.myS.setText(this.myZ);
                }
                if (!C5046bo.isNullOrNil(this.csB)) {
                    if (!C5046bo.isNullOrNil(this.myY)) {
                        this.myR.setText(this.myY);
                    }
                    if (!C5046bo.isNullOrNil(this.myX)) {
                        C32291o.ahp().mo43766a(this.myX, this.myQ, this.fGS);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public final int getLayoutId() {
        return 2130969591;
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
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", Integer.valueOf(i));
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
        C11970l.m19876x(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        C39111g.gkE.mo38923h(new Intent(), (Context) this);
        finish();
    }

    /* renamed from: d */
    static /* synthetic */ void m13809d(FreeWifiStateUI freeWifiStateUI) {
        if (freeWifiStateUI.mxX == null) {
            freeWifiStateUI.bzE();
        }
        freeWifiStateUI.mxX.mvX = freeWifiStateUI;
        C45957d.byJ();
    }
}
