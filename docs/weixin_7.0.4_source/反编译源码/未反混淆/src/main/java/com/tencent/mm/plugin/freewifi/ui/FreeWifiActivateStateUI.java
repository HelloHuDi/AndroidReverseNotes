package com.tencent.mm.plugin.freewifi.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI extends MMActivity implements a, b {
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
    private ap mya = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(20899);
            if (!bo.isNullOrNil(FreeWifiActivateStateUI.this.ssid)) {
                FreeWifiActivateStateUI.this.cxs = FreeWifiActivateStateUI.this.bzz();
                ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", FreeWifiActivateStateUI.this.ssid, Integer.valueOf(FreeWifiActivateStateUI.this.cxs));
                FreeWifiActivateStateUI.this.myb.stopTimer();
                if (FreeWifiActivateStateUI.this.cxs != 2) {
                    FreeWifiActivateStateUI.this.bzD();
                    FreeWifiActivateStateUI.this.bzB();
                    d.a(FreeWifiActivateStateUI.this.ssid, 3, FreeWifiActivateStateUI.this.getIntent());
                }
            }
            AppMethodBeat.o(20899);
            return false;
        }
    }, false);
    private ap myb = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(20900);
            if (d.MD(FreeWifiActivateStateUI.this.ssid)) {
                FreeWifiActivateStateUI.this.a(State.CONNECTED);
                FreeWifiActivateStateUI.this.myb.stopTimer();
                AppMethodBeat.o(20900);
                return false;
            }
            AppMethodBeat.o(20900);
            return true;
        }
    }, true);
    private k.a myc = new k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(20901);
            FreeWifiActivateStateUI.this.cxs = FreeWifiActivateStateUI.this.bzz();
            FreeWifiActivateStateUI.this.uQ(FreeWifiActivateStateUI.this.cxs);
            AppMethodBeat.o(20901);
        }
    };
    protected String ssid;

    public abstract void aqU();

    public abstract void bzy();

    public abstract int bzz();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
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
                if (bo.isNullOrNil(this.ssid)) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
                    break;
                }
                int i;
                c ML = j.byW().ML(this.ssid);
                if (ML == null) {
                    ML = new c();
                    ML.field_ssidmd5 = ag.ck(this.ssid);
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
                    j.byW().b((com.tencent.mm.sdk.e.c) ML);
                } else {
                    j.byW().c(ML, new String[0]);
                }
            case 2:
                c bzx = j.byW().bzx();
                if (bzx != null) {
                    this.ssid = bzx.field_ssid;
                    this.mxW = bzx.field_mid;
                    this.jUg = bzx.field_url;
                    ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", this.ssid, this.mxW, this.jUg);
                } else {
                    ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "there is no connect sucessfull wifi info");
                }
                if (!bo.isNullOrNil(this.ssid)) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
                    break;
                }
                ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mxW, Integer.valueOf(this.cvd));
                break;
        }
        if (!bo.isNullOrNil(this.ssid)) {
        }
        initView();
        j.byW().c(this.myc);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onResume() {
        super.onResume();
        if (!bo.isNullOrNil(this.ssid)) {
            bzF();
        }
    }

    public void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20902);
                FreeWifiActivateStateUI.this.goBack();
                AppMethodBeat.o(20902);
                return true;
            }
        });
        this.mxR = (FreeWifiStateView) findViewById(R.id.bwj);
        this.mxS = (TextView) findViewById(R.id.bwk);
        this.mxT = (TextView) findViewById(R.id.bwl);
        if (this.cvd == 3) {
            this.mxT.setText(getString(R.string.czp, new Object[]{this.ssid}));
        } else {
            this.mxT.setText(getString(R.string.atp, new Object[]{this.ssid}));
        }
        this.mxU = (Button) findViewById(R.id.bwm);
        this.mxU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20903);
                if (FreeWifiActivateStateUI.this.bzz() == 2) {
                    FreeWifiActivateStateUI.this.finish();
                    AppMethodBeat.o(20903);
                    return;
                }
                d.a(FreeWifiActivateStateUI.this.ssid, 1, FreeWifiActivateStateUI.this.getIntent());
                FreeWifiActivateStateUI.this.mxY = false;
                FreeWifiActivateStateUI.this.bzF();
                AppMethodBeat.o(20903);
            }
        });
        this.mxV = (Button) findViewById(R.id.bw_);
        this.mxV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20904);
                String string = FreeWifiActivateStateUI.this.getString(R.string.c07);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bp.d.b(FreeWifiActivateStateUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(20904);
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzB() {
        if (this.mxX != null) {
            ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
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
            ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
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
            ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.cxs));
            if (this.cxs != 2) {
                this.mya.ae(60000, 60000);
                this.myb.ae(1000, 1000);
                if (d.MD(this.ssid)) {
                    bzG();
                    return;
                } else {
                    j.byZ().byI().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(20906);
                            ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", FreeWifiActivateStateUI.this.ssid);
                            FreeWifiActivateStateUI.this.bzy();
                            AppMethodBeat.o(20906);
                        }
                    });
                    return;
                }
            }
            uQ(this.cxs);
            return;
        }
        this.mya.ae(60000, 60000);
        this.myb.ae(1000, 1000);
        ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
        j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20905);
                FreeWifiActivateStateUI.d(FreeWifiActivateStateUI.this);
                AppMethodBeat.o(20905);
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final void uQ(int i) {
        this.mxR.setOnClickListener(null);
        ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case -2014:
                this.mya.stopTimer();
                this.myb.stopTimer();
                this.mxR.setImageResource(R.drawable.aen);
                this.mxR.setState(3);
                this.mxS.setText(R.string.c0b);
                this.mxS.setVisibility(0);
                this.mxT.setText(R.string.c0c);
                this.mxT.setVisibility(0);
                break;
            case 1:
                this.mxR.setImageResource(R.drawable.aeo);
                this.mxR.setState(1);
                this.mxS.setText(R.string.atm);
                break;
            case 2:
                this.mxR.setImageResource(R.drawable.aem);
                this.mxR.setState(2);
                this.mxS.setText(R.string.atl);
                this.mxU.setVisibility(0);
                this.mxU.setText(R.string.bzk);
                this.mya.stopTimer();
                this.myb.stopTimer();
                if (this.cvd == 1 || this.cvd == 5 || this.cvd == 4) {
                    this.mxU.setVisibility(4);
                    final c ML = j.byW().ML(this.ssid);
                    if (!(ML == null || bo.isNullOrNil(ML.field_showUrl) || this.mxZ)) {
                        this.mxZ = true;
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(20907);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", ML.field_showUrl + "&lang=" + aa.g(FreeWifiActivateStateUI.this.getSharedPreferences(ah.doA(), 0)));
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("stastic_scene", 7);
                                com.tencent.mm.bp.d.b(FreeWifiActivateStateUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", intent.getStringExtra("rawUrl"));
                                FreeWifiActivateStateUI.this.finish();
                                AppMethodBeat.o(20907);
                            }
                        }, 1000);
                    }
                }
                d.IF();
                return;
            case 3:
                this.mxR.setImageResource(R.drawable.aeo);
                this.mxR.setState(3);
                this.mxR.lAB = 2;
                this.mxS.setText(R.string.atq);
                this.mxU.setVisibility(0);
                this.mxU.setText(R.string.c0p);
                this.mya.stopTimer();
                this.myb.stopTimer();
                return;
            default:
                this.mxR.setImageResource(R.drawable.aeo);
                this.mxS.setText(R.string.atm);
                if (this.cvd != 3) {
                    this.mxT.setText(getString(R.string.atp, new Object[]{this.ssid}));
                    break;
                }
                this.mxT.setText(getString(R.string.czp, new Object[]{this.ssid}));
                break;
        }
        this.mxU.setVisibility(8);
    }

    private void bzG() {
        ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.mxY));
        if (this.mxY) {
            ab.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
            return;
        }
        this.mya.ae(60000, 60000);
        this.myb.ae(1000, 1000);
        aqU();
        this.mxY = true;
    }

    public final int getLayoutId() {
        return R.layout.a0t;
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
        ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", Integer.valueOf(i));
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
            g.gkE.h(new Intent(), (Context) this);
        }
    }

    static /* synthetic */ void d(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        if (freeWifiActivateStateUI.mxX == null) {
            freeWifiActivateStateUI.bzE();
        }
        freeWifiActivateStateUI.mxX.mvX = freeWifiActivateStateUI;
        d.byJ();
    }
}
