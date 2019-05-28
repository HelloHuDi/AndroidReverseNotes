package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

@Deprecated
public class ProtocolThreeTwoUI extends MMActivity {
    protected String cBb;
    protected int cdf;
    protected String csB;
    private String cuH;
    private String cvO;
    protected int cvd;
    private int cxs = 1;
    private final c fGS;
    private Intent intent;
    protected String jUg;
    protected String mAa;
    protected String mAb;
    private ap mAw = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(21172);
            if (!bo.isNullOrNil(ProtocolThreeTwoUI.this.ssid)) {
                ProtocolThreeTwoUI.this.cxs = ProtocolThreeTwoUI.this.bzz();
                if (ProtocolThreeTwoUI.this.cxs != 2) {
                    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), d.vR(ProtocolThreeTwoUI.this.cxs));
                    d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                    ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 33, "AUTH_302_TIMES_EXCESS");
                }
            }
            AppMethodBeat.o(21172);
            return false;
        }
    }, false);
    protected String mwH;
    private com.tencent.mm.plugin.freewifi.a mwL;
    private int mwR = 0;
    protected String mxW;
    private String mxc;
    private TextView myB;
    private ImageView myQ;
    private TextView myR;
    private TextView myS;
    private Button myT;
    private Button myU;
    protected String myX;
    protected String myY;
    protected String myZ;
    private k.a myc;
    private p mzU;
    protected int mzZ;
    protected String mza;
    private String openId;
    private String sign;
    protected String signature;
    protected String ssid;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ProtocolThreeTwoUI() {
        AppMethodBeat.i(21195);
        c.a aVar = new c.a();
        aVar.ePF = true;
        aVar.ePG = true;
        aVar.ePT = R.drawable.aee;
        aVar.eQf = true;
        aVar.eQg = 0.0f;
        this.fGS = aVar.ahG();
        AppMethodBeat.o(21195);
    }

    static /* synthetic */ void a(ProtocolThreeTwoUI protocolThreeTwoUI, int i, String str) {
        AppMethodBeat.i(21205);
        protocolThreeTwoUI.aH(i, str);
        AppMethodBeat.o(21205);
    }

    static /* synthetic */ void b(ProtocolThreeTwoUI protocolThreeTwoUI) {
        AppMethodBeat.i(21206);
        protocolThreeTwoUI.goBack();
        AppMethodBeat.o(21206);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21196);
        super.onCreate(bundle);
        this.intent = getIntent();
        this.cuH = getIntent().getStringExtra("free_wifi_ap_key");
        this.openId = getIntent().getStringExtra("free_wifi_openid");
        this.mxc = getIntent().getStringExtra("free_wifi_tid");
        this.cvO = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
        this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), this.cuH);
        initView();
        if (bo.isNullOrNil(this.ssid)) {
            ab.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
        } else {
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
            ML.field_wifiType = 32;
            ML.field_connectState = 1;
            if (i != 0) {
                j.byW().b((com.tencent.mm.sdk.e.c) ML);
            } else {
                j.byW().c(ML, new String[0]);
            }
            ab.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mxW, Integer.valueOf(this.cvd));
            this.myc = new k.a() {
                private int mAd = -999999999;

                public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
                    AppMethodBeat.i(21179);
                    ProtocolThreeTwoUI.this.cxs = ProtocolThreeTwoUI.this.bzz();
                    if (this.mAd != ProtocolThreeTwoUI.this.cxs) {
                        this.mAd = ProtocolThreeTwoUI.this.cxs;
                        ProtocolThreeTwoUI.this.vT(ProtocolThreeTwoUI.this.cxs);
                    }
                    AppMethodBeat.o(21179);
                }
            };
            j.byW().c(this.myc);
            ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), ML.field_ssidmd5, ML.field_ssid, ML.field_url, ML.field_mid, Integer.valueOf(ML.field_wifiType), Integer.valueOf(ML.field_connectState));
            ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
            d.a(this.ssid, 4, getIntent());
        }
        l.v(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        AppMethodBeat.o(21196);
    }

    public final void initView() {
        AppMethodBeat.i(21197);
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
        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), this.ssid, this.mxW, this.jUg, Integer.valueOf(this.cvd), Integer.valueOf(this.cdf), this.csB, this.myX, this.myY, this.mza);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21176);
                ProtocolThreeTwoUI.b(ProtocolThreeTwoUI.this);
                AppMethodBeat.o(21176);
                return true;
            }
        });
        findViewById(R.id.bw4).setVisibility(0);
        this.myQ = (ImageView) findViewById(R.id.bvw);
        this.myR = (TextView) findViewById(R.id.bvx);
        this.myS = (TextView) findViewById(R.id.bvy);
        this.myB = (TextView) findViewById(R.id.bvz);
        this.myT = (Button) findViewById(R.id.bw2);
        this.myT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21177);
                l.w(d.byN(), ProtocolThreeTwoUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeTwoUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), d.vR(ProtocolThreeTwoUI.this.bzz()));
                if (ProtocolThreeTwoUI.this.bzz() == 2) {
                    ProtocolThreeTwoUI.this.finish();
                    AppMethodBeat.o(21177);
                    return;
                }
                d.a(ProtocolThreeTwoUI.this.ssid, 1, ProtocolThreeTwoUI.this.getIntent());
                ProtocolThreeTwoUI.this.connect();
                AppMethodBeat.o(21177);
            }
        });
        this.myU = (Button) findViewById(R.id.bw3);
        this.myU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21178);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", ProtocolThreeTwoUI.this.mza);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bp.d.b(ProtocolThreeTwoUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(21178);
            }
        });
        if (bo.isNullOrNil(this.ssid)) {
            this.myS.setText(getString(R.string.c0r));
            this.myT.setVisibility(4);
        }
        setMMTitle(getString(R.string.c0t));
        AppMethodBeat.o(21197);
    }

    /* Access modifiers changed, original: protected|final */
    public final void connect() {
        AppMethodBeat.i(21198);
        this.cxs = bzz();
        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), d.vR(this.cxs));
        if (this.cxs != 2) {
            this.mAw.ae(45000, 45000);
            ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), Integer.valueOf(60));
            this.mwL = new com.tencent.mm.plugin.freewifi.a(this.ssid, this);
            j.byZ().byI().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21180);
                    ProtocolThreeTwoUI.c(ProtocolThreeTwoUI.this);
                    AppMethodBeat.o(21180);
                }
            });
            AppMethodBeat.o(21198);
            return;
        }
        d.a(this.ssid, 2, getIntent());
        AppMethodBeat.o(21198);
    }

    /* Access modifiers changed, original: protected|final */
    public final void vT(int i) {
        AppMethodBeat.i(21199);
        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), Integer.valueOf(i));
        switch (i) {
            case 1:
                this.myB.setVisibility(4);
                this.myT.setText(R.string.ato);
                this.mzU = h.b(this.mController.ylL, getString(R.string.ato), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(21175);
                        d.a(ProtocolThreeTwoUI.this.ssid, 4, ProtocolThreeTwoUI.this.getIntent());
                        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(4));
                        AppMethodBeat.o(21175);
                    }
                });
                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                AppMethodBeat.o(21199);
                return;
            case 2:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
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
                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                break;
            case 3:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
                this.myB.setVisibility(0);
                this.myT.setText(R.string.c0p);
                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                AppMethodBeat.o(21199);
                return;
            case 4:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
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
                    if (!bo.isNullOrNil(this.mwH)) {
                        this.myR.setText(this.mwH);
                    }
                    if (!bo.isNullOrNil(this.myX)) {
                        o.ahp().a(this.myX, this.myQ, this.fGS);
                    }
                }
                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                AppMethodBeat.o(21199);
                return;
        }
        AppMethodBeat.o(21199);
    }

    public final int getLayoutId() {
        return R.layout.a0m;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(21200);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(21200);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(21200);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(21201);
        l.x(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.gkE.h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.o(21201);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.i(21202);
        if (bo.isNullOrNil(this.ssid)) {
            ab.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
            AppMethodBeat.o(21202);
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c ML = j.byW().ML(this.ssid);
        if (ML == null || !ML.field_ssid.equalsIgnoreCase(this.ssid)) {
            AppMethodBeat.o(21202);
            return 0;
        }
        int i = ML.field_connectState;
        AppMethodBeat.o(21202);
        return i;
    }

    private void aH(int i, String str) {
        AppMethodBeat.i(21203);
        com.tencent.mm.plugin.freewifi.k.a byo = com.tencent.mm.plugin.freewifi.k.byo();
        byo.ssid = this.ssid;
        byo.bssid = m.My("MicroMsg.FreeWifi.Protocol32UI");
        byo.cuI = m.Mz("MicroMsg.FreeWifi.Protocol32UI");
        byo.cuH = this.cuH;
        byo.mud = this.csB;
        byo.kBq = m.V(this.intent);
        byo.mue = m.X(this.intent);
        byo.muf = b.ThreeTwoAuth.muQ;
        byo.mug = b.ThreeTwoAuth.name;
        byo.result = i;
        byo.ehr = str;
        byo.cIb = m.Y(this.intent);
        byo.muh = this.cBb;
        byo.byq().byp();
        AppMethodBeat.o(21203);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(21204);
        super.onDestroy();
        if (this.myc != null) {
            j.byW().d(this.myc);
        }
        this.mAw.stopTimer();
        j.byZ().release();
        AppMethodBeat.o(21204);
    }

    static /* synthetic */ void c(ProtocolThreeTwoUI protocolThreeTwoUI) {
        AppMethodBeat.i(21207);
        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", m.V(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.W(protocolThreeTwoUI.getIntent())), protocolThreeTwoUI.ssid);
        protocolThreeTwoUI.mwL.a(new com.tencent.mm.plugin.freewifi.a.a() {
            public final void onSuccess() {
                AppMethodBeat.i(21188);
                com.tencent.mm.plugin.freewifi.k.a byo = com.tencent.mm.plugin.freewifi.k.byo();
                byo.ssid = ProtocolThreeTwoUI.this.ssid;
                byo.bssid = m.My("MicroMsg.FreeWifi.Protocol32UI");
                byo.cuI = m.Mz("MicroMsg.FreeWifi.Protocol32UI");
                byo.cuH = ProtocolThreeTwoUI.this.cuH;
                byo.mud = ProtocolThreeTwoUI.this.csB;
                byo.kBq = m.V(ProtocolThreeTwoUI.this.intent);
                byo.mue = m.X(ProtocolThreeTwoUI.this.intent);
                byo.muf = b.AddNetwork.muQ;
                byo.mug = b.AddNetwork.name;
                byo.result = 0;
                byo.cIb = m.Y(ProtocolThreeTwoUI.this.intent);
                byo.muh = ProtocolThreeTwoUI.this.cBb;
                byo.byq().byp();
                final String byl = com.tencent.mm.plugin.freewifi.h.b.mtY.byl();
                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.ssid, byl);
                AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.freewifi.a.a.a() {
                    int mxe = 0;
                    private final int mxf = 3;
                    private int mxg = 0;
                    private com.tencent.mm.plugin.freewifi.a.a.a mxh = new com.tencent.mm.plugin.freewifi.a.a.a() {
                        public final void g(HttpURLConnection httpURLConnection) {
                            AppMethodBeat.i(21181);
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())));
                                d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                                ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                                AppMethodBeat.o(21181);
                            } else if (responseCode == 302) {
                                AnonymousClass1.a(AnonymousClass1.this, httpURLConnection.getHeaderField("Location"));
                                AppMethodBeat.o(21181);
                            } else {
                                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())));
                                d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                                ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 32, "INVALID_HTTP_RESP_CODE");
                                AppMethodBeat.o(21181);
                            }
                        }

                        public final void j(Exception exception) {
                            AppMethodBeat.i(21182);
                            ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), exception.getMessage());
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 101, m.g(exception));
                            AppMethodBeat.o(21182);
                        }
                    };

                    static /* synthetic */ void a(AnonymousClass1 anonymousClass1, String str) {
                        AppMethodBeat.i(21187);
                        anonymousClass1.MI(str);
                        AppMethodBeat.o(21187);
                    }

                    public final void g(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.i(21184);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())));
                            ProtocolThreeTwoUI.f(ProtocolThreeTwoUI.this);
                            AppMethodBeat.o(21184);
                        } else if (responseCode == 302) {
                            MI(httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.o(21184);
                        } else {
                            ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())));
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.o(21184);
                        }
                    }

                    public final void j(Exception exception) {
                        AppMethodBeat.i(21185);
                        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), exception.getMessage());
                        if (exception instanceof UnknownHostException) {
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 102, m.g(exception));
                            int i = this.mxe + 1;
                            this.mxe = i;
                            if (i <= 3) {
                                try {
                                    Thread.sleep(3000);
                                    com.tencent.mm.plugin.freewifi.a.a.byw();
                                    com.tencent.mm.plugin.freewifi.a.a.a(byl, this);
                                    AppMethodBeat.o(21185);
                                    return;
                                } catch (InterruptedException e) {
                                    AppMethodBeat.o(21185);
                                    return;
                                }
                            }
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 101, m.g(exception));
                            AppMethodBeat.o(21185);
                            return;
                        }
                        d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                        ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 101, m.g(exception));
                        AppMethodBeat.o(21185);
                    }

                    private void MI(String str) {
                        AppMethodBeat.i(21186);
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("authUrl");
                        String Mw = m.Mw(parse.getQueryParameter("extend"));
                        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), str, queryParameter, Mw);
                        if (m.isEmpty(queryParameter)) {
                            this.mxg++;
                            if (this.mxg < 3) {
                                com.tencent.mm.plugin.freewifi.a.a.byw();
                                com.tencent.mm.plugin.freewifi.a.a.a(str, this.mxh);
                                AppMethodBeat.o(21186);
                                return;
                            }
                            ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())));
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 36, "BLACK_302_TIMES_EXCESS");
                            AppMethodBeat.o(21186);
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder(queryParameter);
                        if (queryParameter.indexOf("?") != -1) {
                            stringBuilder.append("&extend=").append(Mw);
                        } else {
                            stringBuilder.append("?extend=").append(Mw);
                        }
                        stringBuilder.append("&openId=").append(m.Mw(ProtocolThreeTwoUI.this.openId)).append("&tid=").append(m.Mw(ProtocolThreeTwoUI.this.mxc)).append("&timestamp=").append(ProtocolThreeTwoUI.this.cvO).append("&sign=").append(ProtocolThreeTwoUI.this.sign);
                        ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, stringBuilder.toString());
                        AppMethodBeat.o(21186);
                    }
                };
                com.tencent.mm.plugin.freewifi.a.a.byw();
                com.tencent.mm.plugin.freewifi.a.a.a(byl, anonymousClass1);
                AppMethodBeat.o(21188);
            }

            public final void onFail(int i) {
                AppMethodBeat.i(21189);
                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.ssid, Integer.valueOf(i));
                d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                com.tencent.mm.plugin.freewifi.k.a byo = com.tencent.mm.plugin.freewifi.k.byo();
                byo.ssid = ProtocolThreeTwoUI.this.ssid;
                byo.bssid = m.My("MicroMsg.FreeWifi.Protocol32UI");
                byo.cuI = m.Mz("MicroMsg.FreeWifi.Protocol32UI");
                byo.cuH = ProtocolThreeTwoUI.this.cuH;
                byo.mud = ProtocolThreeTwoUI.this.csB;
                byo.kBq = m.V(ProtocolThreeTwoUI.this.intent);
                byo.mue = m.X(ProtocolThreeTwoUI.this.intent);
                byo.muf = b.AddNetwork.muQ;
                byo.mug = b.AddNetwork.name;
                byo.result = i;
                byo.cIb = m.Y(ProtocolThreeTwoUI.this.intent);
                byo.muh = ProtocolThreeTwoUI.this.cBb;
                byo.byq().byp();
                AppMethodBeat.o(21189);
            }
        });
        AppMethodBeat.o(21207);
    }

    static /* synthetic */ void f(ProtocolThreeTwoUI protocolThreeTwoUI) {
        AppMethodBeat.i(21208);
        protocolThreeTwoUI.aH(0, "");
        j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21174);
                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.jUg, d.byK(), d.byO(), Integer.valueOf(d.byL()));
                new com.tencent.mm.plugin.freewifi.d.a(ProtocolThreeTwoUI.this.jUg, r2, r3, r4, ProtocolThreeTwoUI.this.cdf, m.V(ProtocolThreeTwoUI.this.getIntent())).c(new f() {
                    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                        AppMethodBeat.i(21173);
                        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            if (mVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                                gj bzj = ((com.tencent.mm.plugin.freewifi.d.a) mVar).bzj();
                                if (bzj != null) {
                                    ab.i("MicroMsg.FreeWifi.Protocol32UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                                    ProtocolThreeTwoUI.this.csB = bzj.vEn;
                                    ProtocolThreeTwoUI.this.mwH = bzj.jCH;
                                    ProtocolThreeTwoUI.this.cBb = bzj.jBB;
                                    ProtocolThreeTwoUI.this.mzZ = bzj.vID;
                                    ProtocolThreeTwoUI.this.mAa = bzj.vIE;
                                    ProtocolThreeTwoUI.this.signature = bzj.guQ;
                                    ProtocolThreeTwoUI.this.mAb = bzj.vIF;
                                    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.csB, ProtocolThreeTwoUI.this.mwH, ProtocolThreeTwoUI.this.cBb, Integer.valueOf(ProtocolThreeTwoUI.this.mzZ), ProtocolThreeTwoUI.this.mAa, ProtocolThreeTwoUI.this.signature, ProtocolThreeTwoUI.this.mAb);
                                }
                                d.a(ProtocolThreeTwoUI.this.ssid, 2, ProtocolThreeTwoUI.this.getIntent());
                                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(2));
                            } else {
                                AppMethodBeat.o(21173);
                                return;
                            }
                        }
                        AppMethodBeat.o(21173);
                    }
                });
                AppMethodBeat.o(21174);
            }
        });
        AppMethodBeat.o(21208);
    }

    static /* synthetic */ void b(ProtocolThreeTwoUI protocolThreeTwoUI, String str) {
        AppMethodBeat.i(21210);
        protocolThreeTwoUI.mwR++;
        if (protocolThreeTwoUI.mwR > 3) {
            ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.V(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.W(protocolThreeTwoUI.getIntent())));
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.aH(33, "AUTH_302_TIMES_EXCESS");
            AppMethodBeat.o(21210);
            return;
        }
        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.V(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.W(protocolThreeTwoUI.getIntent())), str);
        if (m.isEmpty(str)) {
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.aH(34, "EMPTY_AUTH_LOCATION");
            AppMethodBeat.o(21210);
            return;
        }
        AnonymousClass11 anonymousClass11 = new com.tencent.mm.plugin.freewifi.a.a.a() {
            public final void g(HttpURLConnection httpURLConnection) {
                AppMethodBeat.i(21193);
                int responseCode = httpURLConnection.getResponseCode();
                ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    ProtocolThreeTwoUI.f(ProtocolThreeTwoUI.this);
                    AppMethodBeat.o(21193);
                } else if (responseCode == 302) {
                    ProtocolThreeTwoUI.b(ProtocolThreeTwoUI.this, httpURLConnection.getHeaderField("Location"));
                    AppMethodBeat.o(21193);
                } else {
                    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())));
                    d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                    ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 32, "INVALID_HTTP_RESP_CODE");
                    AppMethodBeat.o(21193);
                }
            }

            public final void j(Exception exception) {
                AppMethodBeat.i(21194);
                ab.e("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", m.V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeTwoUI.this.getIntent())), exception.getMessage());
                ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 101, m.g(exception));
                AppMethodBeat.o(21194);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(FirebaseAnalytics.b.METHOD))) {
            com.tencent.mm.plugin.freewifi.a.a.byw();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass11);
            AppMethodBeat.o(21210);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.byw();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass11);
        AppMethodBeat.o(21210);
    }
}
