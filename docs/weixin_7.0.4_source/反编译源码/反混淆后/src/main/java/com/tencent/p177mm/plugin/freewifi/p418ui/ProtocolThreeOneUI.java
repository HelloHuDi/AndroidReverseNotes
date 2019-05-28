package com.tencent.p177mm.plugin.freewifi.p418ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
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
import com.tencent.p177mm.plugin.freewifi.p1549a.C45949a;
import com.tencent.p177mm.plugin.freewifi.p1549a.C45949a.C39099a;
import com.tencent.p177mm.plugin.freewifi.p416d.C28075a;
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
/* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI */
public class ProtocolThreeOneUI extends MMActivity {
    protected String cBb;
    protected int cdf;
    private boolean chh = false;
    protected String csB;
    private String cuH;
    protected int cvd;
    private String cxb;
    private int cxs = 1;
    private final C25814c fGS;
    private Intent intent;
    protected String jUg;
    protected String mAa;
    protected String mAb;
    private C7564ap mAw = new C7564ap(new C120021(), false);
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
    private C4931a myc;
    private C44275p mzU;
    protected int mzZ;
    protected String mza;
    protected String signature;
    protected String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI$7 */
    class C119987 implements C39099a {
        C119987() {
        }

        /* renamed from: g */
        public final void mo7408g(HttpURLConnection httpURLConnection) {
            AppMethodBeat.m2504i(21129);
            int responseCode = httpURLConnection.getResponseCode();
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(responseCode));
            if (responseCode == 200) {
                ProtocolThreeOneUI.m19914e(ProtocolThreeOneUI.this);
                AppMethodBeat.m2505o(21129);
            } else if (responseCode == 302) {
                ProtocolThreeOneUI.m19909a(ProtocolThreeOneUI.this, httpURLConnection.getHeaderField("Location"));
                AppMethodBeat.m2505o(21129);
            } else {
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())));
                C45957d.m85352a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                ProtocolThreeOneUI.m19908a(ProtocolThreeOneUI.this, 32, "INVALID_HTTP_RESP_CODE");
                AppMethodBeat.m2505o(21129);
            }
        }

        /* renamed from: j */
        public final void mo7409j(Exception exception) {
            AppMethodBeat.m2504i(21130);
            C4990ab.m7413e("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), exception.getMessage());
            C45957d.m85352a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
            ProtocolThreeOneUI.m19908a(ProtocolThreeOneUI.this, 101, C34189m.m56077g(exception));
            AppMethodBeat.m2505o(21130);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI$5 */
    class C119995 implements C4931a {
        private int mAd = -999999999;

        C119995() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(21125);
            ProtocolThreeOneUI.this.cxs = ProtocolThreeOneUI.this.bzz();
            if (this.mAd != ProtocolThreeOneUI.this.cxs) {
                this.mAd = ProtocolThreeOneUI.this.cxs;
                ProtocolThreeOneUI.this.mo23828vT(ProtocolThreeOneUI.this.cxs);
            }
            AppMethodBeat.m2505o(21125);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI$4 */
    class C120004 implements OnClickListener {
        C120004() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21124);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", ProtocolThreeOneUI.this.mza);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(ProtocolThreeOneUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(21124);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI$1 */
    class C120021 implements C5015a {
        C120021() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(21121);
            if (!C5046bo.isNullOrNil(ProtocolThreeOneUI.this.ssid)) {
                ProtocolThreeOneUI.this.cxs = ProtocolThreeOneUI.this.bzz();
                if (ProtocolThreeOneUI.this.cxs != 2) {
                    ProtocolThreeOneUI.this.chh = true;
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), C45957d.m85354vR(ProtocolThreeOneUI.this.cxs));
                    C45957d.m85352a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                    ProtocolThreeOneUI.m19908a(ProtocolThreeOneUI.this, 31, "AUTH_TIMEOUT");
                }
            }
            AppMethodBeat.m2505o(21121);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI$3 */
    class C120033 implements OnClickListener {
        C120033() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21123);
            C11970l.m19875w(C45957d.byN(), ProtocolThreeOneUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeOneUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), C45957d.m85354vR(ProtocolThreeOneUI.this.bzz()));
            if (ProtocolThreeOneUI.this.bzz() == 2) {
                ProtocolThreeOneUI.this.finish();
                AppMethodBeat.m2505o(21123);
                return;
            }
            C45957d.m85352a(ProtocolThreeOneUI.this.ssid, 1, ProtocolThreeOneUI.this.getIntent());
            ProtocolThreeOneUI.this.connect();
            AppMethodBeat.m2505o(21123);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI$8 */
    class C120048 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI$8$1 */
        class C120051 implements C1202f {
            C120051() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(21131);
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    if (c1207m instanceof C28075a) {
                        C23391gj bzj = ((C28075a) c1207m).bzj();
                        if (bzj != null) {
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                            ProtocolThreeOneUI.this.csB = bzj.vEn;
                            ProtocolThreeOneUI.this.mwH = bzj.jCH;
                            ProtocolThreeOneUI.this.cBb = bzj.jBB;
                            ProtocolThreeOneUI.this.mzZ = bzj.vID;
                            ProtocolThreeOneUI.this.mAa = bzj.vIE;
                            ProtocolThreeOneUI.this.signature = bzj.guQ;
                            ProtocolThreeOneUI.this.mAb = bzj.vIF;
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), ProtocolThreeOneUI.this.csB, ProtocolThreeOneUI.this.mwH, ProtocolThreeOneUI.this.cBb, Integer.valueOf(ProtocolThreeOneUI.this.mzZ), ProtocolThreeOneUI.this.mAa, ProtocolThreeOneUI.this.signature, ProtocolThreeOneUI.this.mAb);
                        }
                        C45957d.m85352a(ProtocolThreeOneUI.this.ssid, 2, ProtocolThreeOneUI.this.getIntent());
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(2));
                    } else {
                        AppMethodBeat.m2505o(21131);
                        return;
                    }
                }
                AppMethodBeat.m2505o(21131);
            }
        }

        C120048() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21132);
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), ProtocolThreeOneUI.this.jUg, C45957d.byK(), C45957d.byO(), Integer.valueOf(C45957d.byL()));
            new C28075a(ProtocolThreeOneUI.this.jUg, r2, r3, r4, ProtocolThreeOneUI.this.cdf, C34189m.m56063V(ProtocolThreeOneUI.this.getIntent())).mo68619c(new C120051());
            AppMethodBeat.m2505o(21132);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI$9 */
    class C120069 implements OnCancelListener {
        C120069() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(21133);
            C45957d.m85352a(ProtocolThreeOneUI.this.ssid, 4, ProtocolThreeOneUI.this.getIntent());
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(4));
            AppMethodBeat.m2505o(21133);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI$2 */
    class C120072 implements OnMenuItemClickListener {
        C120072() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21122);
            ProtocolThreeOneUI.m19912c(ProtocolThreeOneUI.this);
            AppMethodBeat.m2505o(21122);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ProtocolThreeOneUI() {
        AppMethodBeat.m2504i(21134);
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePG = true;
        c17927a.ePT = C25738R.drawable.aee;
        c17927a.eQf = true;
        c17927a.eQg = 0.0f;
        this.fGS = c17927a.ahG();
        AppMethodBeat.m2505o(21134);
    }

    /* renamed from: a */
    static /* synthetic */ void m19908a(ProtocolThreeOneUI protocolThreeOneUI, int i, String str) {
        AppMethodBeat.m2504i(21144);
        protocolThreeOneUI.m19910aH(i, str);
        AppMethodBeat.m2505o(21144);
    }

    /* renamed from: c */
    static /* synthetic */ void m19912c(ProtocolThreeOneUI protocolThreeOneUI) {
        AppMethodBeat.m2504i(21145);
        protocolThreeOneUI.goBack();
        AppMethodBeat.m2505o(21145);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21135);
        super.onCreate(bundle);
        this.intent = getIntent();
        this.cuH = getIntent().getStringExtra("free_wifi_ap_key");
        this.cxb = getIntent().getStringExtra("free_wifi_schema_ticket");
        this.mwQ = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), this.cuH, this.cxb);
        initView();
        if (C5046bo.isNullOrNil(this.ssid)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
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
            ML.field_url = this.jUg;
            ML.field_mid = this.mxW;
            ML.field_wifiType = 3;
            ML.field_connectState = 1;
            if (i != 0) {
                C11976j.byW().mo10101b((C4925c) ML);
            } else {
                C11976j.byW().mo10103c(ML, new String[0]);
            }
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mxW, Integer.valueOf(this.cvd));
            this.myc = new C119995();
            C11976j.byW().mo10116c(this.myc);
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), ML.field_ssidmd5, ML.field_ssid, ML.field_url, ML.field_mid, Integer.valueOf(ML.field_wifiType), Integer.valueOf(ML.field_connectState));
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
            C45957d.m85352a(this.ssid, 4, getIntent());
        }
        C11970l.m19874v(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        AppMethodBeat.m2505o(21135);
    }

    public final void initView() {
        AppMethodBeat.m2504i(21136);
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
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), this.ssid, this.mxW, this.jUg, Integer.valueOf(this.cvd), Integer.valueOf(this.cdf), this.csB, this.myX, this.myY, this.mza);
        setBackBtn(new C120072());
        findViewById(2131824137).setVisibility(0);
        this.myQ = (ImageView) findViewById(2131824129);
        this.myR = (TextView) findViewById(2131824130);
        this.myS = (TextView) findViewById(2131824131);
        this.myB = (TextView) findViewById(2131824132);
        this.myT = (Button) findViewById(2131824135);
        this.myT.setOnClickListener(new C120033());
        this.myU = (Button) findViewById(2131824136);
        this.myU.setOnClickListener(new C120004());
        if (C5046bo.isNullOrNil(this.ssid)) {
            this.myS.setText(getString(C25738R.string.c0r));
            this.myT.setVisibility(4);
        }
        setMMTitle(getString(C25738R.string.c0t));
        AppMethodBeat.m2505o(21136);
    }

    /* Access modifiers changed, original: protected|final */
    public final void connect() {
        AppMethodBeat.m2504i(21137);
        this.cxs = bzz();
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), C45957d.m85354vR(this.cxs));
        if (this.cxs != 2) {
            this.mAw.mo16770ae(15000, 15000);
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), Integer.valueOf(60));
            final String str = this.mwQ;
            C11976j.byZ().byI().post(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI$6$1 */
                class C31521 implements C39099a {
                    C31521() {
                    }

                    /* renamed from: g */
                    public final void mo7408g(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.m2504i(21126);
                        int responseCode = httpURLConnection.getResponseCode();
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(responseCode));
                        if (ProtocolThreeOneUI.this.chh) {
                            AppMethodBeat.m2505o(21126);
                        } else if (responseCode == 200) {
                            ProtocolThreeOneUI.m19914e(ProtocolThreeOneUI.this);
                            AppMethodBeat.m2505o(21126);
                        } else if (responseCode == 302) {
                            ProtocolThreeOneUI.m19909a(ProtocolThreeOneUI.this, httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.m2505o(21126);
                        } else {
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())));
                            C45957d.m85352a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                            ProtocolThreeOneUI.m19908a(ProtocolThreeOneUI.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.m2505o(21126);
                        }
                    }

                    /* renamed from: j */
                    public final void mo7409j(Exception exception) {
                        AppMethodBeat.m2504i(21127);
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), exception.getMessage());
                        C45957d.m85352a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                        ProtocolThreeOneUI.m19908a(ProtocolThreeOneUI.this, 101, C34189m.m56077g(exception));
                        AppMethodBeat.m2505o(21127);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(21128);
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", C34189m.m56063V(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeOneUI.this.getIntent())), str);
                    C45949a.byw();
                    C45949a.m85337a(str, new C31521());
                    AppMethodBeat.m2505o(21128);
                }
            });
            AppMethodBeat.m2505o(21137);
            return;
        }
        C45957d.m85352a(this.ssid, 2, getIntent());
        AppMethodBeat.m2505o(21137);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: vT */
    public final void mo23828vT(int i) {
        AppMethodBeat.m2504i(21138);
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), Integer.valueOf(i));
        switch (i) {
            case 1:
                this.myB.setVisibility(4);
                this.myT.setText(C25738R.string.ato);
                this.mzU = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.ato), true, new C120069());
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                AppMethodBeat.m2505o(21138);
                return;
            case 2:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
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
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                break;
            case 3:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
                this.myB.setVisibility(0);
                this.myT.setText(C25738R.string.c0p);
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                AppMethodBeat.m2505o(21138);
                return;
            case 4:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
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
                    if (!C5046bo.isNullOrNil(this.mwH)) {
                        this.myR.setText(this.mwH);
                    }
                    if (!C5046bo.isNullOrNil(this.myX)) {
                        C32291o.ahp().mo43766a(this.myX, this.myQ, this.fGS);
                    }
                }
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                AppMethodBeat.m2505o(21138);
                return;
        }
        AppMethodBeat.m2505o(21138);
    }

    public final int getLayoutId() {
        return 2130969591;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(21139);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(21139);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(21139);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(21140);
        C11970l.m19876x(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        C39111g.gkE.mo38923h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.m2505o(21140);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.m2504i(21141);
        if (C5046bo.isNullOrNil(this.ssid)) {
            C4990ab.m7410d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
            AppMethodBeat.m2505o(21141);
            return 0;
        }
        C3137c ML = C11976j.byW().mo17045ML(this.ssid);
        if (ML == null || !ML.field_ssid.equalsIgnoreCase(this.ssid)) {
            AppMethodBeat.m2505o(21141);
            return 0;
        }
        int i = ML.field_connectState;
        AppMethodBeat.m2505o(21141);
        return i;
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: aH */
    private void m19910aH(int i, String str) {
        AppMethodBeat.m2504i(21142);
        C11967a byo = C11966k.byo();
        byo.ssid = this.ssid;
        byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol31UI");
        byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol31UI");
        byo.cuH = this.cuH;
        byo.mud = this.csB;
        byo.kBq = C34189m.m56063V(this.intent);
        byo.mue = C34189m.m56065X(this.intent);
        byo.muf = C11968b.ThreeOneAuth.muQ;
        byo.mug = C11968b.ThreeOneAuth.name;
        byo.result = i;
        byo.ehr = str;
        byo.cIb = C34189m.m56066Y(this.intent);
        byo.muh = this.cBb;
        byo.byq().byp();
        AppMethodBeat.m2505o(21142);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(21143);
        super.onDestroy();
        if (this.myc != null) {
            C11976j.byW().mo10117d(this.myc);
        }
        this.mAw.stopTimer();
        C11976j.byZ().release();
        AppMethodBeat.m2505o(21143);
    }

    /* renamed from: e */
    static /* synthetic */ void m19914e(ProtocolThreeOneUI protocolThreeOneUI) {
        AppMethodBeat.m2504i(21146);
        protocolThreeOneUI.m19910aH(0, "");
        C11976j.byZ().byI().post(new C120048());
        AppMethodBeat.m2505o(21146);
    }
}
