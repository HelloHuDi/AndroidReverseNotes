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
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.g.c;
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
public class ProtocolThreeThreeUI extends MMActivity {
    protected String appId;
    protected String bssid;
    protected String cBb;
    protected int cdf;
    protected String cvO;
    protected int cvd;
    private int cxs = 1;
    protected String mAa;
    protected String mAb;
    private ap mAw = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(21148);
            if (!bo.isNullOrNil(ProtocolThreeThreeUI.this.ssid)) {
                ProtocolThreeThreeUI.this.cxs = ProtocolThreeThreeUI.this.bzz();
                if (ProtocolThreeThreeUI.this.cxs != 2) {
                    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), d.vR(ProtocolThreeThreeUI.this.cxs));
                    d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                }
            }
            AppMethodBeat.o(21148);
            return false;
        }
    }, false);
    protected String mwH;
    private int mwR = 0;
    protected String mwU;
    protected String mwV;
    protected String mwW;
    private Uri mwX;
    private String mwY;
    private TextView myB;
    private ImageView myQ;
    private TextView myR;
    private TextView myS;
    private Button myT;
    private Button myU;
    private k.a myc;
    private p mzU;
    protected int mzZ;
    protected String sign;
    protected String signature;
    protected String ssid;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ProtocolThreeThreeUI() {
        AppMethodBeat.i(21160);
        AppMethodBeat.o(21160);
    }

    static /* synthetic */ void b(ProtocolThreeThreeUI protocolThreeThreeUI) {
        AppMethodBeat.i(21169);
        protocolThreeThreeUI.goBack();
        AppMethodBeat.o(21169);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21161);
        super.onCreate(bundle);
        this.mwY = getIntent().getStringExtra("free_wifi_schema_uri");
        this.mwX = Uri.parse(this.mwY);
        this.appId = this.mwX.getQueryParameter("appId");
        this.mwU = this.mwX.getQueryParameter("shopId");
        this.mwV = this.mwX.getQueryParameter("authUrl");
        this.mwW = this.mwX.getQueryParameter("extend");
        this.cvO = this.mwX.getQueryParameter(Param.TIMESTAMP);
        this.sign = this.mwX.getQueryParameter("sign");
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), this.mwY);
        initView();
        if (bo.isNullOrNil(this.ssid)) {
            ab.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
        } else {
            int i;
            c ML = j.byW().ML(this.ssid);
            if (ML == null) {
                ML = new c();
                ML.field_ssidmd5 = ag.ck(this.ssid);
                ML.field_ssid = this.ssid;
                i = 1;
            } else {
                i = 0;
            }
            ML.field_url = "";
            ML.field_mid = "";
            ML.field_wifiType = 33;
            ML.field_connectState = 1;
            if (i != 0) {
                j.byW().b((com.tencent.mm.sdk.e.c) ML);
            } else {
                j.byW().c(ML, new String[0]);
            }
            ab.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", this.ssid, "", Integer.valueOf(this.cvd));
            this.myc = new k.a() {
                private int mAd = -999999999;

                public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
                    AppMethodBeat.i(21151);
                    ProtocolThreeThreeUI.this.cxs = ProtocolThreeThreeUI.this.bzz();
                    if (this.mAd != ProtocolThreeThreeUI.this.cxs) {
                        this.mAd = ProtocolThreeThreeUI.this.cxs;
                        ProtocolThreeThreeUI.this.vT(ProtocolThreeThreeUI.this.cxs);
                    }
                    AppMethodBeat.o(21151);
                }
            };
            j.byW().c(this.myc);
            ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), ML.field_ssidmd5, ML.field_ssid, ML.field_url, ML.field_mid, Integer.valueOf(ML.field_wifiType), Integer.valueOf(ML.field_connectState));
            ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
            d.a(this.ssid, 4, getIntent());
        }
        l.v(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        AppMethodBeat.o(21161);
    }

    public final void initView() {
        AppMethodBeat.i(21162);
        this.ssid = m.Mx("MicroMsg.FreeWifi.Protocol33UI");
        this.bssid = m.My("MicroMsg.FreeWifi.Protocol33UI");
        this.cvd = getIntent().getIntExtra("free_wifi_source", 1);
        this.cdf = getIntent().getIntExtra("free_wifi_channel_id", 0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21149);
                ProtocolThreeThreeUI.b(ProtocolThreeThreeUI.this);
                AppMethodBeat.o(21149);
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
                AppMethodBeat.i(21150);
                l.w(d.byN(), ProtocolThreeThreeUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeThreeUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), d.vR(ProtocolThreeThreeUI.this.bzz()));
                if (ProtocolThreeThreeUI.this.bzz() == 2) {
                    ProtocolThreeThreeUI.this.finish();
                    AppMethodBeat.o(21150);
                    return;
                }
                d.a(ProtocolThreeThreeUI.this.ssid, 1, ProtocolThreeThreeUI.this.getIntent());
                ProtocolThreeThreeUI.this.connect();
                AppMethodBeat.o(21150);
            }
        });
        this.myU = (Button) findViewById(R.id.bw3);
        this.myU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        if (bo.isNullOrNil(this.ssid)) {
            this.myS.setText(getString(R.string.c0r));
            this.myT.setVisibility(4);
        }
        setMMTitle(getString(R.string.c0t));
        AppMethodBeat.o(21162);
    }

    /* Access modifiers changed, original: protected|final */
    public final void connect() {
        AppMethodBeat.i(21163);
        if (m.isEmpty(this.ssid)) {
            ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
            d.a(this.ssid, 3, getIntent());
            AppMethodBeat.o(21163);
        } else if (m.isEmpty(this.mwV)) {
            ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
            d.a(this.ssid, 3, getIntent());
            AppMethodBeat.o(21163);
        } else {
            this.cxs = bzz();
            ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), d.vR(this.cxs));
            if (this.cxs != 2) {
                this.mAw.ae(30000, 30000);
                ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), Integer.valueOf(60));
                m.isEmpty(this.mwV);
                StringBuilder stringBuilder = new StringBuilder(this.mwV);
                if (this.mwV.indexOf("?") == -1) {
                    stringBuilder.append("?extend=").append(this.mwW);
                } else {
                    stringBuilder.append("&extend=").append(this.mwW);
                }
                final String stringBuilder2 = stringBuilder.toString();
                j.byZ().byI().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(21154);
                        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), stringBuilder2);
                        com.tencent.mm.plugin.freewifi.a.a.byw();
                        com.tencent.mm.plugin.freewifi.a.a.a(stringBuilder2, new com.tencent.mm.plugin.freewifi.a.a.a() {
                            public final void g(HttpURLConnection httpURLConnection) {
                                AppMethodBeat.i(21152);
                                int responseCode = httpURLConnection.getResponseCode();
                                ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(responseCode));
                                if (responseCode == 200) {
                                    ProtocolThreeThreeUI.c(ProtocolThreeThreeUI.this);
                                    AppMethodBeat.o(21152);
                                } else if (responseCode == 302) {
                                    ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, httpURLConnection.getHeaderField("Location"));
                                    AppMethodBeat.o(21152);
                                } else {
                                    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())));
                                    d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                                    AppMethodBeat.o(21152);
                                }
                            }

                            public final void j(Exception exception) {
                                AppMethodBeat.i(21153);
                                ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), exception.getMessage());
                                d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                                AppMethodBeat.o(21153);
                            }
                        });
                        AppMethodBeat.o(21154);
                    }
                });
                AppMethodBeat.o(21163);
                return;
            }
            d.a(this.ssid, 2, getIntent());
            AppMethodBeat.o(21163);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void vT(int i) {
        AppMethodBeat.i(21164);
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), Integer.valueOf(i));
        switch (i) {
            case 1:
                this.myB.setVisibility(4);
                this.myT.setText(R.string.ato);
                this.mzU = h.b(this.mController.ylL, getString(R.string.ato), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(21159);
                        d.a(ProtocolThreeThreeUI.this.ssid, 4, ProtocolThreeThreeUI.this.getIntent());
                        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(4));
                        AppMethodBeat.o(21159);
                    }
                });
                ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                AppMethodBeat.o(21164);
                return;
            case 2:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
                this.myT.setText(R.string.atl);
                this.myT.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.appId);
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
                ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                break;
            case 3:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
                this.myB.setVisibility(0);
                this.myT.setText(R.string.c0p);
                ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                AppMethodBeat.o(21164);
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
                } else {
                    this.myS.setText(getString(R.string.atp, new Object[]{this.ssid}));
                }
                ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                AppMethodBeat.o(21164);
                return;
        }
        AppMethodBeat.o(21164);
    }

    public final int getLayoutId() {
        return R.layout.a0m;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(21165);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(21165);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(21165);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(21166);
        l.x(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.gkE.h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.o(21166);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.i(21167);
        if (bo.isNullOrNil(this.ssid)) {
            ab.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
            AppMethodBeat.o(21167);
            return 0;
        }
        c ML = j.byW().ML(this.ssid);
        if (ML == null || !ML.field_ssid.equalsIgnoreCase(this.ssid)) {
            AppMethodBeat.o(21167);
            return 0;
        }
        int i = ML.field_connectState;
        AppMethodBeat.o(21167);
        return i;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(21168);
        super.onDestroy();
        if (this.myc != null) {
            j.byW().d(this.myc);
        }
        this.mAw.stopTimer();
        j.byZ().release();
        AppMethodBeat.o(21168);
    }

    static /* synthetic */ void c(ProtocolThreeThreeUI protocolThreeThreeUI) {
        AppMethodBeat.i(21170);
        j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21158);
                String byK = d.byK();
                String byO = d.byO();
                int byL = d.byL();
                ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), "", byK, byO, Integer.valueOf(byL));
                new f(ProtocolThreeThreeUI.this.ssid, ProtocolThreeThreeUI.this.bssid, ProtocolThreeThreeUI.this.appId, ProtocolThreeThreeUI.this.mwU, ProtocolThreeThreeUI.this.mwV, ProtocolThreeThreeUI.this.mwW, ProtocolThreeThreeUI.this.cvO, ProtocolThreeThreeUI.this.sign).c(new com.tencent.mm.ai.f() {
                    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                        AppMethodBeat.i(21157);
                        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            gj bzj = ((f) mVar).bzj();
                            if (bzj != null) {
                                ab.i("MicroMsg.FreeWifi.Protocol33UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                                ProtocolThreeThreeUI.this.mwH = bzj.jCH;
                                ProtocolThreeThreeUI.this.cBb = bzj.jBB;
                                ProtocolThreeThreeUI.this.mzZ = bzj.vID;
                                ProtocolThreeThreeUI.this.mAa = bzj.vIE;
                                ProtocolThreeThreeUI.this.signature = bzj.guQ;
                                ProtocolThreeThreeUI.this.mAb = bzj.vIF;
                                ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPageFor33] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), ProtocolThreeThreeUI.this.appId, ProtocolThreeThreeUI.this.mwH, ProtocolThreeThreeUI.this.cBb, Integer.valueOf(ProtocolThreeThreeUI.this.mzZ), ProtocolThreeThreeUI.this.mAa, ProtocolThreeThreeUI.this.signature, ProtocolThreeThreeUI.this.mAb);
                            }
                            d.a(ProtocolThreeThreeUI.this.ssid, 2, ProtocolThreeThreeUI.this.getIntent());
                            ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(2));
                            AppMethodBeat.o(21157);
                        } else if (i2 == -30032) {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_error_ui_error_msg", ProtocolThreeThreeUI.this.getString(R.string.bzv));
                            intent.setClass(ProtocolThreeThreeUI.this, FreeWifiErrorUI.class);
                            ProtocolThreeThreeUI.this.finish();
                            ProtocolThreeThreeUI.this.startActivity(intent);
                            AppMethodBeat.o(21157);
                        } else {
                            d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                            ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=NetSceneGetBackPageFor33 returns unkown errcode. errCode=%d", m.V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i2));
                            AppMethodBeat.o(21157);
                        }
                    }
                });
                AppMethodBeat.o(21158);
            }
        });
        AppMethodBeat.o(21170);
    }
}
