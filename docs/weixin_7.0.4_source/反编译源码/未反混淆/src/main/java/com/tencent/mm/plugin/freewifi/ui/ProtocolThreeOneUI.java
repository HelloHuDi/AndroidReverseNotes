package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
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
import com.tencent.mm.ai.f;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.e.q;
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

@Deprecated
public class ProtocolThreeOneUI extends MMActivity {
    protected String cBb;
    protected int cdf;
    private boolean chh = false;
    protected String csB;
    private String cuH;
    protected int cvd;
    private String cxb;
    private int cxs = 1;
    private final c fGS;
    private Intent intent;
    protected String jUg;
    protected String mAa;
    protected String mAb;
    private ap mAw = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(21121);
            if (!bo.isNullOrNil(ProtocolThreeOneUI.this.ssid)) {
                ProtocolThreeOneUI.this.cxs = ProtocolThreeOneUI.this.bzz();
                if (ProtocolThreeOneUI.this.cxs != 2) {
                    ProtocolThreeOneUI.this.chh = true;
                    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())), d.vR(ProtocolThreeOneUI.this.cxs));
                    d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                    ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 31, "AUTH_TIMEOUT");
                }
            }
            AppMethodBeat.o(21121);
            return false;
        }
    }, false);
    protected String mwH;
    private String mwQ;
    private int mwR = 0;
    protected String mxW;
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
    protected String signature;
    protected String ssid;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ProtocolThreeOneUI() {
        AppMethodBeat.i(21134);
        c.a aVar = new c.a();
        aVar.ePF = true;
        aVar.ePG = true;
        aVar.ePT = R.drawable.aee;
        aVar.eQf = true;
        aVar.eQg = 0.0f;
        this.fGS = aVar.ahG();
        AppMethodBeat.o(21134);
    }

    static /* synthetic */ void a(ProtocolThreeOneUI protocolThreeOneUI, int i, String str) {
        AppMethodBeat.i(21144);
        protocolThreeOneUI.aH(i, str);
        AppMethodBeat.o(21144);
    }

    static /* synthetic */ void c(ProtocolThreeOneUI protocolThreeOneUI) {
        AppMethodBeat.i(21145);
        protocolThreeOneUI.goBack();
        AppMethodBeat.o(21145);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21135);
        super.onCreate(bundle);
        this.intent = getIntent();
        this.cuH = getIntent().getStringExtra("free_wifi_ap_key");
        this.cxb = getIntent().getStringExtra("free_wifi_schema_ticket");
        this.mwQ = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), this.cuH, this.cxb);
        initView();
        if (bo.isNullOrNil(this.ssid)) {
            ab.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
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
            ML.field_wifiType = 3;
            ML.field_connectState = 1;
            if (i != 0) {
                j.byW().b((com.tencent.mm.sdk.e.c) ML);
            } else {
                j.byW().c(ML, new String[0]);
            }
            ab.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mxW, Integer.valueOf(this.cvd));
            this.myc = new k.a() {
                private int mAd = -999999999;

                public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
                    AppMethodBeat.i(21125);
                    ProtocolThreeOneUI.this.cxs = ProtocolThreeOneUI.this.bzz();
                    if (this.mAd != ProtocolThreeOneUI.this.cxs) {
                        this.mAd = ProtocolThreeOneUI.this.cxs;
                        ProtocolThreeOneUI.this.vT(ProtocolThreeOneUI.this.cxs);
                    }
                    AppMethodBeat.o(21125);
                }
            };
            j.byW().c(this.myc);
            ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), ML.field_ssidmd5, ML.field_ssid, ML.field_url, ML.field_mid, Integer.valueOf(ML.field_wifiType), Integer.valueOf(ML.field_connectState));
            ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
            d.a(this.ssid, 4, getIntent());
        }
        l.v(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        AppMethodBeat.o(21135);
    }

    public final void initView() {
        AppMethodBeat.i(21136);
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
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), this.ssid, this.mxW, this.jUg, Integer.valueOf(this.cvd), Integer.valueOf(this.cdf), this.csB, this.myX, this.myY, this.mza);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21122);
                ProtocolThreeOneUI.c(ProtocolThreeOneUI.this);
                AppMethodBeat.o(21122);
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
                AppMethodBeat.i(21123);
                l.w(d.byN(), ProtocolThreeOneUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeOneUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())), d.vR(ProtocolThreeOneUI.this.bzz()));
                if (ProtocolThreeOneUI.this.bzz() == 2) {
                    ProtocolThreeOneUI.this.finish();
                    AppMethodBeat.o(21123);
                    return;
                }
                d.a(ProtocolThreeOneUI.this.ssid, 1, ProtocolThreeOneUI.this.getIntent());
                ProtocolThreeOneUI.this.connect();
                AppMethodBeat.o(21123);
            }
        });
        this.myU = (Button) findViewById(R.id.bw3);
        this.myU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21124);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", ProtocolThreeOneUI.this.mza);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bp.d.b(ProtocolThreeOneUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(21124);
            }
        });
        if (bo.isNullOrNil(this.ssid)) {
            this.myS.setText(getString(R.string.c0r));
            this.myT.setVisibility(4);
        }
        setMMTitle(getString(R.string.c0t));
        AppMethodBeat.o(21136);
    }

    /* Access modifiers changed, original: protected|final */
    public final void connect() {
        AppMethodBeat.i(21137);
        this.cxs = bzz();
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), d.vR(this.cxs));
        if (this.cxs != 2) {
            this.mAw.ae(15000, 15000);
            ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), Integer.valueOf(60));
            final String str = this.mwQ;
            j.byZ().byI().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21128);
                    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())), str);
                    com.tencent.mm.plugin.freewifi.a.a.byw();
                    com.tencent.mm.plugin.freewifi.a.a.a(str, new com.tencent.mm.plugin.freewifi.a.a.a() {
                        public final void g(HttpURLConnection httpURLConnection) {
                            AppMethodBeat.i(21126);
                            int responseCode = httpURLConnection.getResponseCode();
                            ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(responseCode));
                            if (ProtocolThreeOneUI.this.chh) {
                                AppMethodBeat.o(21126);
                            } else if (responseCode == 200) {
                                ProtocolThreeOneUI.e(ProtocolThreeOneUI.this);
                                AppMethodBeat.o(21126);
                            } else if (responseCode == 302) {
                                ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, httpURLConnection.getHeaderField("Location"));
                                AppMethodBeat.o(21126);
                            } else {
                                ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())));
                                d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                                ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 32, "INVALID_HTTP_RESP_CODE");
                                AppMethodBeat.o(21126);
                            }
                        }

                        public final void j(Exception exception) {
                            AppMethodBeat.i(21127);
                            ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())), exception.getMessage());
                            d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                            ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 101, m.g(exception));
                            AppMethodBeat.o(21127);
                        }
                    });
                    AppMethodBeat.o(21128);
                }
            });
            AppMethodBeat.o(21137);
            return;
        }
        d.a(this.ssid, 2, getIntent());
        AppMethodBeat.o(21137);
    }

    /* Access modifiers changed, original: protected|final */
    public final void vT(int i) {
        AppMethodBeat.i(21138);
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), Integer.valueOf(i));
        switch (i) {
            case 1:
                this.myB.setVisibility(4);
                this.myT.setText(R.string.ato);
                this.mzU = h.b(this.mController.ylL, getString(R.string.ato), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(21133);
                        d.a(ProtocolThreeOneUI.this.ssid, 4, ProtocolThreeOneUI.this.getIntent());
                        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(4));
                        AppMethodBeat.o(21133);
                    }
                });
                ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                AppMethodBeat.o(21138);
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
                ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                break;
            case 3:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
                this.myB.setVisibility(0);
                this.myT.setText(R.string.c0p);
                ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                AppMethodBeat.o(21138);
                return;
            case 4:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
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
                    if (!bo.isNullOrNil(this.mwH)) {
                        this.myR.setText(this.mwH);
                    }
                    if (!bo.isNullOrNil(this.myX)) {
                        o.ahp().a(this.myX, this.myQ, this.fGS);
                    }
                }
                ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                AppMethodBeat.o(21138);
                return;
        }
        AppMethodBeat.o(21138);
    }

    public final int getLayoutId() {
        return R.layout.a0m;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(21139);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(21139);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(21139);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(21140);
        l.x(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.gkE.h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.o(21140);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.i(21141);
        if (bo.isNullOrNil(this.ssid)) {
            ab.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
            AppMethodBeat.o(21141);
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c ML = j.byW().ML(this.ssid);
        if (ML == null || !ML.field_ssid.equalsIgnoreCase(this.ssid)) {
            AppMethodBeat.o(21141);
            return 0;
        }
        int i = ML.field_connectState;
        AppMethodBeat.o(21141);
        return i;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void aH(int i, String str) {
        AppMethodBeat.i(21142);
        com.tencent.mm.plugin.freewifi.k.a byo = com.tencent.mm.plugin.freewifi.k.byo();
        byo.ssid = this.ssid;
        byo.bssid = m.My("MicroMsg.FreeWifi.Protocol31UI");
        byo.cuI = m.Mz("MicroMsg.FreeWifi.Protocol31UI");
        byo.cuH = this.cuH;
        byo.mud = this.csB;
        byo.kBq = m.V(this.intent);
        byo.mue = m.X(this.intent);
        byo.muf = b.ThreeOneAuth.muQ;
        byo.mug = b.ThreeOneAuth.name;
        byo.result = i;
        byo.ehr = str;
        byo.cIb = m.Y(this.intent);
        byo.muh = this.cBb;
        byo.byq().byp();
        AppMethodBeat.o(21142);
    }

    public void onDestroy() {
        AppMethodBeat.i(21143);
        super.onDestroy();
        if (this.myc != null) {
            j.byW().d(this.myc);
        }
        this.mAw.stopTimer();
        j.byZ().release();
        AppMethodBeat.o(21143);
    }

    static /* synthetic */ void e(ProtocolThreeOneUI protocolThreeOneUI) {
        AppMethodBeat.i(21146);
        protocolThreeOneUI.aH(0, "");
        j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21132);
                ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())), ProtocolThreeOneUI.this.jUg, d.byK(), d.byO(), Integer.valueOf(d.byL()));
                new com.tencent.mm.plugin.freewifi.d.a(ProtocolThreeOneUI.this.jUg, r2, r3, r4, ProtocolThreeOneUI.this.cdf, m.V(ProtocolThreeOneUI.this.getIntent())).c(new f() {
                    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                        AppMethodBeat.i(21131);
                        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            if (mVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                                gj bzj = ((com.tencent.mm.plugin.freewifi.d.a) mVar).bzj();
                                if (bzj != null) {
                                    ab.i("MicroMsg.FreeWifi.Protocol31UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                                    ProtocolThreeOneUI.this.csB = bzj.vEn;
                                    ProtocolThreeOneUI.this.mwH = bzj.jCH;
                                    ProtocolThreeOneUI.this.cBb = bzj.jBB;
                                    ProtocolThreeOneUI.this.mzZ = bzj.vID;
                                    ProtocolThreeOneUI.this.mAa = bzj.vIE;
                                    ProtocolThreeOneUI.this.signature = bzj.guQ;
                                    ProtocolThreeOneUI.this.mAb = bzj.vIF;
                                    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())), ProtocolThreeOneUI.this.csB, ProtocolThreeOneUI.this.mwH, ProtocolThreeOneUI.this.cBb, Integer.valueOf(ProtocolThreeOneUI.this.mzZ), ProtocolThreeOneUI.this.mAa, ProtocolThreeOneUI.this.signature, ProtocolThreeOneUI.this.mAb);
                                }
                                d.a(ProtocolThreeOneUI.this.ssid, 2, ProtocolThreeOneUI.this.getIntent());
                                ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", m.V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(2));
                            } else {
                                AppMethodBeat.o(21131);
                                return;
                            }
                        }
                        AppMethodBeat.o(21131);
                    }
                });
                AppMethodBeat.o(21132);
            }
        });
        AppMethodBeat.o(21146);
    }
}
