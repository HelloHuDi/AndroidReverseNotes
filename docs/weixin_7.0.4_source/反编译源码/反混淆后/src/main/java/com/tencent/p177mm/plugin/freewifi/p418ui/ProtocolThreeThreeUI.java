package com.tencent.p177mm.plugin.freewifi.p418ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.freewifi.C11970l;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C39111g;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p1549a.C45949a;
import com.tencent.p177mm.plugin.freewifi.p1549a.C45949a.C39099a;
import com.tencent.p177mm.plugin.freewifi.p416d.C44738f;
import com.tencent.p177mm.plugin.freewifi.p417g.C3137c;
import com.tencent.p177mm.protocal.protobuf.C23391gj;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.net.HttpURLConnection;

@Deprecated
/* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI */
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
    private C7564ap mAw = new C7564ap(new C208161(), false);
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
    private C4931a myc;
    private C44275p mzU;
    protected int mzZ;
    protected String sign;
    protected String signature;
    protected String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI$5 */
    class C208115 implements C4931a {
        private int mAd = -999999999;

        C208115() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(21151);
            ProtocolThreeThreeUI.this.cxs = ProtocolThreeThreeUI.this.bzz();
            if (this.mAd != ProtocolThreeThreeUI.this.cxs) {
                this.mAd = ProtocolThreeThreeUI.this.cxs;
                ProtocolThreeThreeUI.this.mo36097vT(ProtocolThreeThreeUI.this.cxs);
            }
            AppMethodBeat.m2505o(21151);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI$7 */
    class C208147 implements C39099a {
        C208147() {
        }

        /* renamed from: g */
        public final void mo7408g(HttpURLConnection httpURLConnection) {
            AppMethodBeat.m2504i(21155);
            int responseCode = httpURLConnection.getResponseCode();
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(responseCode));
            if (responseCode == 200) {
                ProtocolThreeThreeUI.m32042c(ProtocolThreeThreeUI.this);
                AppMethodBeat.m2505o(21155);
            } else if (responseCode == 302) {
                ProtocolThreeThreeUI.m32040a(ProtocolThreeThreeUI.this, httpURLConnection.getHeaderField("Location"));
                AppMethodBeat.m2505o(21155);
            } else {
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())));
                C45957d.m85352a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                AppMethodBeat.m2505o(21155);
            }
        }

        /* renamed from: j */
        public final void mo7409j(Exception exception) {
            AppMethodBeat.m2504i(21156);
            C4990ab.m7413e("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), exception.getMessage());
            AppMethodBeat.m2505o(21156);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI$8 */
    class C208158 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI$8$1 */
        class C120081 implements C1202f {
            C120081() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(21157);
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    C23391gj bzj = ((C44738f) c1207m).bzj();
                    if (bzj != null) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                        ProtocolThreeThreeUI.this.mwH = bzj.jCH;
                        ProtocolThreeThreeUI.this.cBb = bzj.jBB;
                        ProtocolThreeThreeUI.this.mzZ = bzj.vID;
                        ProtocolThreeThreeUI.this.mAa = bzj.vIE;
                        ProtocolThreeThreeUI.this.signature = bzj.guQ;
                        ProtocolThreeThreeUI.this.mAb = bzj.vIF;
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPageFor33] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), ProtocolThreeThreeUI.this.appId, ProtocolThreeThreeUI.this.mwH, ProtocolThreeThreeUI.this.cBb, Integer.valueOf(ProtocolThreeThreeUI.this.mzZ), ProtocolThreeThreeUI.this.mAa, ProtocolThreeThreeUI.this.signature, ProtocolThreeThreeUI.this.mAb);
                    }
                    C45957d.m85352a(ProtocolThreeThreeUI.this.ssid, 2, ProtocolThreeThreeUI.this.getIntent());
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(2));
                    AppMethodBeat.m2505o(21157);
                } else if (i2 == -30032) {
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_error_ui_error_msg", ProtocolThreeThreeUI.this.getString(C25738R.string.bzv));
                    intent.setClass(ProtocolThreeThreeUI.this, FreeWifiErrorUI.class);
                    ProtocolThreeThreeUI.this.finish();
                    ProtocolThreeThreeUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(21157);
                } else {
                    C45957d.m85352a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=NetSceneGetBackPageFor33 returns unkown errcode. errCode=%d", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i2));
                    AppMethodBeat.m2505o(21157);
                }
            }
        }

        C208158() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21158);
            String byK = C45957d.byK();
            String byO = C45957d.byO();
            int byL = C45957d.byL();
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), "", byK, byO, Integer.valueOf(byL));
            new C44738f(ProtocolThreeThreeUI.this.ssid, ProtocolThreeThreeUI.this.bssid, ProtocolThreeThreeUI.this.appId, ProtocolThreeThreeUI.this.mwU, ProtocolThreeThreeUI.this.mwV, ProtocolThreeThreeUI.this.mwW, ProtocolThreeThreeUI.this.cvO, ProtocolThreeThreeUI.this.sign).mo68619c(new C120081());
            AppMethodBeat.m2505o(21158);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI$1 */
    class C208161 implements C5015a {
        C208161() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(21148);
            if (!C5046bo.isNullOrNil(ProtocolThreeThreeUI.this.ssid)) {
                ProtocolThreeThreeUI.this.cxs = ProtocolThreeThreeUI.this.bzz();
                if (ProtocolThreeThreeUI.this.cxs != 2) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), C45957d.m85354vR(ProtocolThreeThreeUI.this.cxs));
                    C45957d.m85352a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                }
            }
            AppMethodBeat.m2505o(21148);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI$2 */
    class C208172 implements OnMenuItemClickListener {
        C208172() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21149);
            ProtocolThreeThreeUI.m32041b(ProtocolThreeThreeUI.this);
            AppMethodBeat.m2505o(21149);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI$3 */
    class C208183 implements OnClickListener {
        C208183() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21150);
            C11970l.m19875w(C45957d.byN(), ProtocolThreeThreeUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeThreeUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), C45957d.m85354vR(ProtocolThreeThreeUI.this.bzz()));
            if (ProtocolThreeThreeUI.this.bzz() == 2) {
                ProtocolThreeThreeUI.this.finish();
                AppMethodBeat.m2505o(21150);
                return;
            }
            C45957d.m85352a(ProtocolThreeThreeUI.this.ssid, 1, ProtocolThreeThreeUI.this.getIntent());
            ProtocolThreeThreeUI.this.connect();
            AppMethodBeat.m2505o(21150);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI$4 */
    class C208194 implements OnClickListener {
        C208194() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI$9 */
    class C208209 implements OnCancelListener {
        C208209() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(21159);
            C45957d.m85352a(ProtocolThreeThreeUI.this.ssid, 4, ProtocolThreeThreeUI.this.getIntent());
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(4));
            AppMethodBeat.m2505o(21159);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ProtocolThreeThreeUI() {
        AppMethodBeat.m2504i(21160);
        AppMethodBeat.m2505o(21160);
    }

    /* renamed from: b */
    static /* synthetic */ void m32041b(ProtocolThreeThreeUI protocolThreeThreeUI) {
        AppMethodBeat.m2504i(21169);
        protocolThreeThreeUI.goBack();
        AppMethodBeat.m2505o(21169);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21161);
        super.onCreate(bundle);
        this.mwY = getIntent().getStringExtra("free_wifi_schema_uri");
        this.mwX = Uri.parse(this.mwY);
        this.appId = this.mwX.getQueryParameter("appId");
        this.mwU = this.mwX.getQueryParameter("shopId");
        this.mwV = this.mwX.getQueryParameter("authUrl");
        this.mwW = this.mwX.getQueryParameter("extend");
        this.cvO = this.mwX.getQueryParameter(Param.TIMESTAMP);
        this.sign = this.mwX.getQueryParameter("sign");
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), this.mwY);
        initView();
        if (C5046bo.isNullOrNil(this.ssid)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
        } else {
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
            ML.field_url = "";
            ML.field_mid = "";
            ML.field_wifiType = 33;
            ML.field_connectState = 1;
            if (i != 0) {
                C11976j.byW().mo10101b((C4925c) ML);
            } else {
                C11976j.byW().mo10103c(ML, new String[0]);
            }
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", this.ssid, "", Integer.valueOf(this.cvd));
            this.myc = new C208115();
            C11976j.byW().mo10116c(this.myc);
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), ML.field_ssidmd5, ML.field_ssid, ML.field_url, ML.field_mid, Integer.valueOf(ML.field_wifiType), Integer.valueOf(ML.field_connectState));
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
            C45957d.m85352a(this.ssid, 4, getIntent());
        }
        C11970l.m19874v(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        AppMethodBeat.m2505o(21161);
    }

    public final void initView() {
        AppMethodBeat.m2504i(21162);
        this.ssid = C34189m.m56059Mx("MicroMsg.FreeWifi.Protocol33UI");
        this.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol33UI");
        this.cvd = getIntent().getIntExtra("free_wifi_source", 1);
        this.cdf = getIntent().getIntExtra("free_wifi_channel_id", 0);
        setBackBtn(new C208172());
        findViewById(2131824137).setVisibility(0);
        this.myQ = (ImageView) findViewById(2131824129);
        this.myR = (TextView) findViewById(2131824130);
        this.myS = (TextView) findViewById(2131824131);
        this.myB = (TextView) findViewById(2131824132);
        this.myT = (Button) findViewById(2131824135);
        this.myT.setOnClickListener(new C208183());
        this.myU = (Button) findViewById(2131824136);
        this.myU.setOnClickListener(new C208194());
        if (C5046bo.isNullOrNil(this.ssid)) {
            this.myS.setText(getString(C25738R.string.c0r));
            this.myT.setVisibility(4);
        }
        setMMTitle(getString(C25738R.string.c0t));
        AppMethodBeat.m2505o(21162);
    }

    /* Access modifiers changed, original: protected|final */
    public final void connect() {
        AppMethodBeat.m2504i(21163);
        if (C34189m.isEmpty(this.ssid)) {
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
            C45957d.m85352a(this.ssid, 3, getIntent());
            AppMethodBeat.m2505o(21163);
        } else if (C34189m.isEmpty(this.mwV)) {
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
            C45957d.m85352a(this.ssid, 3, getIntent());
            AppMethodBeat.m2505o(21163);
        } else {
            this.cxs = bzz();
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), C45957d.m85354vR(this.cxs));
            if (this.cxs != 2) {
                this.mAw.mo16770ae(30000, 30000);
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), Integer.valueOf(60));
                C34189m.isEmpty(this.mwV);
                StringBuilder stringBuilder = new StringBuilder(this.mwV);
                if (this.mwV.indexOf("?") == -1) {
                    stringBuilder.append("?extend=").append(this.mwW);
                } else {
                    stringBuilder.append("&extend=").append(this.mwW);
                }
                final String stringBuilder2 = stringBuilder.toString();
                C11976j.byZ().byI().post(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI$6$1 */
                    class C208131 implements C39099a {
                        C208131() {
                        }

                        /* renamed from: g */
                        public final void mo7408g(HttpURLConnection httpURLConnection) {
                            AppMethodBeat.m2504i(21152);
                            int responseCode = httpURLConnection.getResponseCode();
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(responseCode));
                            if (responseCode == 200) {
                                ProtocolThreeThreeUI.m32042c(ProtocolThreeThreeUI.this);
                                AppMethodBeat.m2505o(21152);
                            } else if (responseCode == 302) {
                                ProtocolThreeThreeUI.m32040a(ProtocolThreeThreeUI.this, httpURLConnection.getHeaderField("Location"));
                                AppMethodBeat.m2505o(21152);
                            } else {
                                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())));
                                C45957d.m85352a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                                AppMethodBeat.m2505o(21152);
                            }
                        }

                        /* renamed from: j */
                        public final void mo7409j(Exception exception) {
                            AppMethodBeat.m2504i(21153);
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), exception.getMessage());
                            C45957d.m85352a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                            AppMethodBeat.m2505o(21153);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(21154);
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", C34189m.m56063V(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeThreeUI.this.getIntent())), stringBuilder2);
                        C45949a.byw();
                        C45949a.m85337a(stringBuilder2, new C208131());
                        AppMethodBeat.m2505o(21154);
                    }
                });
                AppMethodBeat.m2505o(21163);
                return;
            }
            C45957d.m85352a(this.ssid, 2, getIntent());
            AppMethodBeat.m2505o(21163);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: vT */
    public final void mo36097vT(int i) {
        AppMethodBeat.m2504i(21164);
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), Integer.valueOf(i));
        switch (i) {
            case 1:
                this.myB.setVisibility(4);
                this.myT.setText(C25738R.string.ato);
                this.mzU = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.ato), true, new C208209());
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                AppMethodBeat.m2505o(21164);
                return;
            case 2:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
                this.myT.setText(C25738R.string.atl);
                this.myT.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.appId);
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
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                break;
            case 3:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
                this.myB.setVisibility(0);
                this.myT.setText(C25738R.string.c0p);
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                AppMethodBeat.m2505o(21164);
                return;
            case 4:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
                this.myB.setVisibility(4);
                this.myT.setText(C25738R.string.atr);
                if (this.cvd == 3) {
                    this.myS.setText(getString(C25738R.string.czp, new Object[]{this.ssid}));
                } else {
                    this.myS.setText(getString(C25738R.string.atp, new Object[]{this.ssid}));
                }
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                AppMethodBeat.m2505o(21164);
                return;
        }
        AppMethodBeat.m2505o(21164);
    }

    public final int getLayoutId() {
        return 2130969591;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(21165);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(21165);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(21165);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(21166);
        C11970l.m19876x(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        C39111g.gkE.mo38923h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.m2505o(21166);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.m2504i(21167);
        if (C5046bo.isNullOrNil(this.ssid)) {
            C4990ab.m7410d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
            AppMethodBeat.m2505o(21167);
            return 0;
        }
        C3137c ML = C11976j.byW().mo17045ML(this.ssid);
        if (ML == null || !ML.field_ssid.equalsIgnoreCase(this.ssid)) {
            AppMethodBeat.m2505o(21167);
            return 0;
        }
        int i = ML.field_connectState;
        AppMethodBeat.m2505o(21167);
        return i;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(21168);
        super.onDestroy();
        if (this.myc != null) {
            C11976j.byW().mo10117d(this.myc);
        }
        this.mAw.stopTimer();
        C11976j.byZ().release();
        AppMethodBeat.m2505o(21168);
    }

    /* renamed from: c */
    static /* synthetic */ void m32042c(ProtocolThreeThreeUI protocolThreeThreeUI) {
        AppMethodBeat.m2504i(21170);
        C11976j.byZ().byI().post(new C208158());
        AppMethodBeat.m2505o(21170);
    }
}
