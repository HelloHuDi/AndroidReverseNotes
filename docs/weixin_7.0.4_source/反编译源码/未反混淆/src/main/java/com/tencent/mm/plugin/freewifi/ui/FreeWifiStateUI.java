package com.tencent.mm.plugin.freewifi.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@Deprecated
public abstract class FreeWifiStateUI extends MMActivity implements a, b {
    protected String cBb;
    protected int cdf;
    protected String csB;
    protected String cuH;
    protected int cvd;
    private int cxs = 1;
    private final c fGS;
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
    private ap mya = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(21071);
            if (!bo.isNullOrNil(FreeWifiStateUI.this.ssid)) {
                FreeWifiStateUI.this.cxs = FreeWifiStateUI.this.bzz();
                ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", FreeWifiStateUI.this.ssid, Integer.valueOf(FreeWifiStateUI.this.cxs));
                FreeWifiStateUI.this.myb.stopTimer();
                k.a byo = k.byo();
                byo.ssid = FreeWifiStateUI.this.ssid;
                byo.cuH = FreeWifiStateUI.this.cuH;
                byo.kBq = m.V(FreeWifiStateUI.this.getIntent());
                byo.mue = m.X(FreeWifiStateUI.this.getIntent());
                byo.muf = k.b.AddNetwork.muQ;
                byo.mug = k.b.AddNetwork.name;
                byo.result = -16;
                byo.cIb = m.Y(FreeWifiStateUI.this.getIntent());
                byo.mud = FreeWifiStateUI.this.csB;
                byo.muh = FreeWifiStateUI.this.cBb;
                byo.byq().byp();
                if (FreeWifiStateUI.this.cxs != 2) {
                    FreeWifiStateUI.this.bzD();
                    FreeWifiStateUI.this.bzB();
                    d.a(FreeWifiStateUI.this.ssid, 3, FreeWifiStateUI.this.getIntent());
                }
            }
            AppMethodBeat.o(21071);
            return false;
        }
    }, false);
    private ap myb = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(21072);
            if (d.MD(FreeWifiStateUI.this.ssid)) {
                FreeWifiStateUI.this.a(State.CONNECTED);
                FreeWifiStateUI.this.myb.stopTimer();
                AppMethodBeat.o(21072);
                return false;
            }
            AppMethodBeat.o(21072);
            return true;
        }
    }, true);
    private com.tencent.mm.sdk.e.k.a myc;
    private p mzU = null;
    protected int mzZ;
    protected String mza;
    protected String signature;
    protected String ssid;

    public abstract void a(State state);

    public abstract void aqU();

    public abstract void bzy();

    public abstract int bzz();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FreeWifiStateUI() {
        c.a aVar = new c.a();
        aVar.ePF = true;
        aVar.ePG = true;
        aVar.ePT = R.drawable.aee;
        aVar.eQf = true;
        aVar.eQg = 0.0f;
        this.fGS = aVar.ahG();
        this.myc = new com.tencent.mm.sdk.e.k.a() {
            private int mAd = -999999999;

            public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
                AppMethodBeat.i(21073);
                FreeWifiStateUI.this.cxs = FreeWifiStateUI.this.bzz();
                if (this.mAd != FreeWifiStateUI.this.cxs) {
                    this.mAd = FreeWifiStateUI.this.cxs;
                    FreeWifiStateUI.this.uQ(FreeWifiStateUI.this.cxs);
                }
                AppMethodBeat.o(21073);
            }
        };
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
                if (bo.isNullOrNil(this.ssid)) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
                    break;
                }
                int i;
                com.tencent.mm.plugin.freewifi.g.c ML = j.byW().ML(this.ssid);
                if (ML == null) {
                    ML = new com.tencent.mm.plugin.freewifi.g.c();
                    ML.field_ssidmd5 = ag.ck(this.ssid);
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
                    j.byW().b((com.tencent.mm.sdk.e.c) ML);
                } else {
                    j.byW().c(ML, new String[0]);
                }
            case 2:
                com.tencent.mm.plugin.freewifi.g.c bzx = j.byW().bzx();
                if (bzx != null) {
                    this.ssid = bzx.field_ssid;
                    this.mxW = bzx.field_mid;
                    this.jUg = bzx.field_url;
                    ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", this.ssid, this.mxW, this.jUg);
                } else {
                    ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "there is no connect sucessfull wifi info");
                }
                if (!bo.isNullOrNil(this.ssid)) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
                    break;
                }
                ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mxW, Integer.valueOf(this.cvd));
                break;
        }
        if (!bo.isNullOrNil(this.ssid)) {
        }
        initView();
        j.byW().c(this.myc);
        l.v(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21074);
                FreeWifiStateUI.this.goBack();
                AppMethodBeat.o(21074);
                return true;
            }
        });
        if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
            findViewById(R.id.bw4).setVisibility(0);
        }
        this.myQ = (ImageView) findViewById(R.id.bvw);
        this.myR = (TextView) findViewById(R.id.bvx);
        this.myS = (TextView) findViewById(R.id.bvy);
        this.myB = (TextView) findViewById(R.id.bvz);
        this.myT = (Button) findViewById(R.id.bw2);
        this.myT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21075);
                l.w(d.byN(), FreeWifiStateUI.this.getIntent().getStringExtra("free_wifi_ap_key"), FreeWifiStateUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                if (FreeWifiStateUI.this.bzz() == 2) {
                    FreeWifiStateUI.this.finish();
                    AppMethodBeat.o(21075);
                    return;
                }
                d.a(FreeWifiStateUI.this.ssid, 1, FreeWifiStateUI.this.getIntent());
                FreeWifiStateUI.this.mxY = false;
                FreeWifiStateUI.this.bzF();
                AppMethodBeat.o(21075);
            }
        });
        this.myU = (Button) findViewById(R.id.bw3);
        this.myU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21076);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", FreeWifiStateUI.this.mza);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bp.d.b(FreeWifiStateUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(21076);
            }
        });
        if (bo.isNullOrNil(this.ssid)) {
            this.myS.setText(getString(R.string.c0r));
            this.myT.setVisibility(4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzB() {
        if (this.mxX != null) {
            ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
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
            ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
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
        if (d.isWifiEnabled()) {
            this.cxs = bzz();
            ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.cxs));
            if (this.cxs != 2) {
                if (m.X(getIntent()) == 4) {
                    this.mya.ae(30000, 30000);
                } else {
                    this.mya.ae(60000, 60000);
                }
                this.myb.ae(1000, 1000);
                if (d.MD(this.ssid)) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.mxY));
                    if (this.mxY) {
                        ab.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
                        return;
                    }
                    this.mya.ae(60000, 60000);
                    this.myb.ae(1000, 1000);
                    aqU();
                    this.mxY = true;
                    return;
                }
                j.byZ().byI().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(21078);
                        ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", FreeWifiStateUI.this.ssid);
                        FreeWifiStateUI.this.bzy();
                        AppMethodBeat.o(21078);
                    }
                });
                return;
            }
            d.a(this.ssid, this.cxs, getIntent());
            return;
        }
        this.mya.ae(60000, 60000);
        this.myb.ae(1000, 1000);
        ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
        j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21077);
                FreeWifiStateUI.d(FreeWifiStateUI.this);
                AppMethodBeat.o(21077);
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final void uQ(int i) {
        ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case -2014:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mya.stopTimer();
                this.myb.stopTimer();
                this.myB.setVisibility(0);
                this.myT.setText(R.string.c0p);
                return;
            case -1:
                return;
            case 1:
                this.myB.setVisibility(4);
                this.myT.setText(R.string.ato);
                this.mzU = h.b(this.mController.ylL, getString(R.string.ato), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(21079);
                        d.a(FreeWifiStateUI.this.ssid, 4, FreeWifiStateUI.this.getIntent());
                        AppMethodBeat.o(21079);
                    }
                });
                return;
            case 2:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mya.stopTimer();
                this.myb.stopTimer();
                this.myT.setText(R.string.atl);
                this.myT.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.csB);
                intent.putExtra("free_wifi_app_nickname", this.mwH);
                intent.putExtra("free_wifi_app_username", this.cBb);
                intent.putExtra("free_wifi_signature", this.signature);
                intent.putExtra("free_wifi_finish_actioncode", this.mzZ);
                intent.putExtra("free_wifi_finish_url", this.mAa);
                if (bo.isNullOrNil(this.mAb)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    intent.putExtra("free_wifi_qinghuai_url", this.mAb);
                    intent.setClass(this, FreeWifiSuccWebViewUI.class);
                }
                finish();
                startActivity(intent);
                d.IF();
                return;
            case 3:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mya.stopTimer();
                this.myb.stopTimer();
                this.myB.setVisibility(0);
                this.myT.setText(R.string.c0p);
                return;
            case 4:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mya.stopTimer();
                this.myb.stopTimer();
                this.mxY = false;
                this.myB.setVisibility(4);
                this.myT.setText(R.string.atr);
                if (!(m.Y(getIntent()) != 10 || m.isEmpty(q.eth.etR) || m.isEmpty(q.bB(this.mController.ylL)))) {
                    this.myT.setText(String.format(getString(R.string.bzn), new Object[]{q.bB(this.mController.ylL)}));
                }
                if (this.cvd == 3) {
                    this.myS.setText(getString(R.string.czp, new Object[]{this.ssid}));
                } else if (bo.isNullOrNil(this.myZ)) {
                    this.myS.setText(getString(R.string.atn));
                } else {
                    this.myS.setText(this.myZ);
                }
                if (!bo.isNullOrNil(this.csB)) {
                    if (!bo.isNullOrNil(this.myY)) {
                        this.myR.setText(this.myY);
                    }
                    if (!bo.isNullOrNil(this.myX)) {
                        o.ahp().a(this.myX, this.myQ, this.fGS);
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
                this.myT.setText(R.string.atr);
                if (this.cvd == 3) {
                    this.myS.setText(getString(R.string.czp, new Object[]{this.ssid}));
                } else if (bo.isNullOrNil(this.myZ)) {
                    this.myS.setText(getString(R.string.atn));
                } else {
                    this.myS.setText(this.myZ);
                }
                if (!bo.isNullOrNil(this.csB)) {
                    if (!bo.isNullOrNil(this.myY)) {
                        this.myR.setText(this.myY);
                    }
                    if (!bo.isNullOrNil(this.myX)) {
                        o.ahp().a(this.myX, this.myQ, this.fGS);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public final int getLayoutId() {
        return R.layout.a0m;
    }

    public void onDestroy() {
        super.onDestroy();
        j.byW().d(this.myc);
        bzB();
        bzD();
        if (this.mxX != null) {
            unregisterReceiver(this.mxX);
        }
        this.mya.stopTimer();
        this.myb.stopTimer();
        j.byZ().release();
    }

    public final void vS(int i) {
        ab.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", Integer.valueOf(i));
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
        l.x(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.gkE.h(new Intent(), (Context) this);
        finish();
    }

    static /* synthetic */ void d(FreeWifiStateUI freeWifiStateUI) {
        if (freeWifiStateUI.mxX == null) {
            freeWifiStateUI.bzE();
        }
        freeWifiStateUI.mxX.mvX = freeWifiStateUI;
        d.byJ();
    }
}
