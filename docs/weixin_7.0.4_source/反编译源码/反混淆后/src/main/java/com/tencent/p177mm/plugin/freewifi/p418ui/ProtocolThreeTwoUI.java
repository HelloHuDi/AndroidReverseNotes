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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
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
import com.tencent.p177mm.plugin.freewifi.C28067a;
import com.tencent.p177mm.plugin.freewifi.C28067a.C20777a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C39111g;
import com.tencent.p177mm.plugin.freewifi.C45955h.C39112b;
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
import java.net.UnknownHostException;

@Deprecated
/* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI */
public class ProtocolThreeTwoUI extends MMActivity {
    protected String cBb;
    protected int cdf;
    protected String csB;
    private String cuH;
    private String cvO;
    protected int cvd;
    private int cxs = 1;
    private final C25814c fGS;
    private Intent intent;
    protected String jUg;
    protected String mAa;
    protected String mAb;
    private C7564ap mAw = new C7564ap(new C120101(), false);
    protected String mwH;
    private C28067a mwL;
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
    private C4931a myc;
    private C44275p mzU;
    protected int mzZ;
    protected String mza;
    private String openId;
    private String sign;
    protected String signature;
    protected String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$1 */
    class C120101 implements C5015a {
        C120101() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(21172);
            if (!C5046bo.isNullOrNil(ProtocolThreeTwoUI.this.ssid)) {
                ProtocolThreeTwoUI.this.cxs = ProtocolThreeTwoUI.this.bzz();
                if (ProtocolThreeTwoUI.this.cxs != 2) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), C45957d.m85354vR(ProtocolThreeTwoUI.this.cxs));
                    C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                    ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 33, "AUTH_302_TIMES_EXCESS");
                }
            }
            AppMethodBeat.m2505o(21172);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$2 */
    class C120112 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$2$1 */
        class C120121 implements C1202f {
            C120121() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(21173);
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    if (c1207m instanceof C28075a) {
                        C23391gj bzj = ((C28075a) c1207m).bzj();
                        if (bzj != null) {
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                            ProtocolThreeTwoUI.this.csB = bzj.vEn;
                            ProtocolThreeTwoUI.this.mwH = bzj.jCH;
                            ProtocolThreeTwoUI.this.cBb = bzj.jBB;
                            ProtocolThreeTwoUI.this.mzZ = bzj.vID;
                            ProtocolThreeTwoUI.this.mAa = bzj.vIE;
                            ProtocolThreeTwoUI.this.signature = bzj.guQ;
                            ProtocolThreeTwoUI.this.mAb = bzj.vIF;
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.csB, ProtocolThreeTwoUI.this.mwH, ProtocolThreeTwoUI.this.cBb, Integer.valueOf(ProtocolThreeTwoUI.this.mzZ), ProtocolThreeTwoUI.this.mAa, ProtocolThreeTwoUI.this.signature, ProtocolThreeTwoUI.this.mAb);
                        }
                        C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 2, ProtocolThreeTwoUI.this.getIntent());
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(2));
                    } else {
                        AppMethodBeat.m2505o(21173);
                        return;
                    }
                }
                AppMethodBeat.m2505o(21173);
            }
        }

        C120112() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21174);
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.jUg, C45957d.byK(), C45957d.byO(), Integer.valueOf(C45957d.byL()));
            new C28075a(ProtocolThreeTwoUI.this.jUg, r2, r3, r4, ProtocolThreeTwoUI.this.cdf, C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent())).mo68619c(new C120121());
            AppMethodBeat.m2505o(21174);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$8 */
    class C120138 implements Runnable {
        C120138() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21180);
            ProtocolThreeTwoUI.m19928c(ProtocolThreeTwoUI.this);
            AppMethodBeat.m2505o(21180);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$9 */
    class C120149 implements C20777a {
        C120149() {
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(21188);
            C11967a byo = C11966k.byo();
            byo.ssid = ProtocolThreeTwoUI.this.ssid;
            byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol32UI");
            byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol32UI");
            byo.cuH = ProtocolThreeTwoUI.this.cuH;
            byo.mud = ProtocolThreeTwoUI.this.csB;
            byo.kBq = C34189m.m56063V(ProtocolThreeTwoUI.this.intent);
            byo.mue = C34189m.m56065X(ProtocolThreeTwoUI.this.intent);
            byo.muf = C11968b.AddNetwork.muQ;
            byo.mug = C11968b.AddNetwork.name;
            byo.result = 0;
            byo.cIb = C34189m.m56066Y(ProtocolThreeTwoUI.this.intent);
            byo.muh = ProtocolThreeTwoUI.this.cBb;
            byo.byq().byp();
            final String byl = C39112b.mtY.byl();
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.ssid, byl);
            C120151 c120151 = new C39099a() {
                int mxe = 0;
                private final int mxf = 3;
                private int mxg = 0;
                private C39099a mxh = new C120161();

                /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$9$1$1 */
                class C120161 implements C39099a {
                    C120161() {
                    }

                    /* renamed from: g */
                    public final void mo7408g(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.m2504i(21181);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())));
                            C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                            AppMethodBeat.m2505o(21181);
                        } else if (responseCode == 302) {
                            C120151.m19938a(C120151.this, httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.m2505o(21181);
                        } else {
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())));
                            C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.m2505o(21181);
                        }
                    }

                    /* renamed from: j */
                    public final void mo7409j(Exception exception) {
                        AppMethodBeat.m2504i(21182);
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), exception.getMessage());
                        C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                        ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 101, C34189m.m56077g(exception));
                        AppMethodBeat.m2505o(21182);
                    }
                }

                /* renamed from: a */
                static /* synthetic */ void m19938a(C120151 c120151, String str) {
                    AppMethodBeat.m2504i(21187);
                    c120151.m19937MI(str);
                    AppMethodBeat.m2505o(21187);
                }

                /* renamed from: g */
                public final void mo7408g(HttpURLConnection httpURLConnection) {
                    AppMethodBeat.m2504i(21184);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())));
                        ProtocolThreeTwoUI.m19931f(ProtocolThreeTwoUI.this);
                        AppMethodBeat.m2505o(21184);
                    } else if (responseCode == 302) {
                        m19937MI(httpURLConnection.getHeaderField("Location"));
                        AppMethodBeat.m2505o(21184);
                    } else {
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())));
                        C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                        ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 32, "INVALID_HTTP_RESP_CODE");
                        AppMethodBeat.m2505o(21184);
                    }
                }

                /* renamed from: j */
                public final void mo7409j(Exception exception) {
                    AppMethodBeat.m2504i(21185);
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), exception.getMessage());
                    if (exception instanceof UnknownHostException) {
                        ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 102, C34189m.m56077g(exception));
                        int i = this.mxe + 1;
                        this.mxe = i;
                        if (i <= 3) {
                            try {
                                Thread.sleep(3000);
                                C45949a.byw();
                                C45949a.m85337a(byl, this);
                                AppMethodBeat.m2505o(21185);
                                return;
                            } catch (InterruptedException e) {
                                AppMethodBeat.m2505o(21185);
                                return;
                            }
                        }
                        C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                        ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 101, C34189m.m56077g(exception));
                        AppMethodBeat.m2505o(21185);
                        return;
                    }
                    C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                    ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 101, C34189m.m56077g(exception));
                    AppMethodBeat.m2505o(21185);
                }

                /* renamed from: MI */
                private void m19937MI(String str) {
                    AppMethodBeat.m2504i(21186);
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("authUrl");
                    String Mw = C34189m.m56058Mw(parse.getQueryParameter("extend"));
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), str, queryParameter, Mw);
                    if (C34189m.isEmpty(queryParameter)) {
                        this.mxg++;
                        if (this.mxg < 3) {
                            C45949a.byw();
                            C45949a.m85337a(str, this.mxh);
                            AppMethodBeat.m2505o(21186);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())));
                        C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                        ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 36, "BLACK_302_TIMES_EXCESS");
                        AppMethodBeat.m2505o(21186);
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder(queryParameter);
                    if (queryParameter.indexOf("?") != -1) {
                        stringBuilder.append("&extend=").append(Mw);
                    } else {
                        stringBuilder.append("?extend=").append(Mw);
                    }
                    stringBuilder.append("&openId=").append(C34189m.m56058Mw(ProtocolThreeTwoUI.this.openId)).append("&tid=").append(C34189m.m56058Mw(ProtocolThreeTwoUI.this.mxc)).append("&timestamp=").append(ProtocolThreeTwoUI.this.cvO).append("&sign=").append(ProtocolThreeTwoUI.this.sign);
                    ProtocolThreeTwoUI.m19924a(ProtocolThreeTwoUI.this, stringBuilder.toString());
                    AppMethodBeat.m2505o(21186);
                }
            };
            C45949a.byw();
            C45949a.m85337a(byl, c120151);
            AppMethodBeat.m2505o(21188);
        }

        public final void onFail(int i) {
            AppMethodBeat.m2504i(21189);
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.ssid, Integer.valueOf(i));
            C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
            C11967a byo = C11966k.byo();
            byo.ssid = ProtocolThreeTwoUI.this.ssid;
            byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol32UI");
            byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol32UI");
            byo.cuH = ProtocolThreeTwoUI.this.cuH;
            byo.mud = ProtocolThreeTwoUI.this.csB;
            byo.kBq = C34189m.m56063V(ProtocolThreeTwoUI.this.intent);
            byo.mue = C34189m.m56065X(ProtocolThreeTwoUI.this.intent);
            byo.muf = C11968b.AddNetwork.muQ;
            byo.mug = C11968b.AddNetwork.name;
            byo.result = i;
            byo.cIb = C34189m.m56066Y(ProtocolThreeTwoUI.this.intent);
            byo.muh = ProtocolThreeTwoUI.this.cBb;
            byo.byq().byp();
            AppMethodBeat.m2505o(21189);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$3 */
    class C120173 implements OnCancelListener {
        C120173() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(21175);
            C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 4, ProtocolThreeTwoUI.this.getIntent());
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(4));
            AppMethodBeat.m2505o(21175);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$11 */
    class C1201911 implements C39099a {
        C1201911() {
        }

        /* renamed from: g */
        public final void mo7408g(HttpURLConnection httpURLConnection) {
            AppMethodBeat.m2504i(21193);
            int responseCode = httpURLConnection.getResponseCode();
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(responseCode));
            if (responseCode == 200) {
                ProtocolThreeTwoUI.m19931f(ProtocolThreeTwoUI.this);
                AppMethodBeat.m2505o(21193);
            } else if (responseCode == 302) {
                ProtocolThreeTwoUI.m19927b(ProtocolThreeTwoUI.this, httpURLConnection.getHeaderField("Location"));
                AppMethodBeat.m2505o(21193);
            } else {
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())));
                C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 32, "INVALID_HTTP_RESP_CODE");
                AppMethodBeat.m2505o(21193);
            }
        }

        /* renamed from: j */
        public final void mo7409j(Exception exception) {
            AppMethodBeat.m2504i(21194);
            C4990ab.m7413e("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), exception.getMessage());
            ProtocolThreeTwoUI.m19923a(ProtocolThreeTwoUI.this, 101, C34189m.m56077g(exception));
            AppMethodBeat.m2505o(21194);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$4 */
    class C120204 implements OnMenuItemClickListener {
        C120204() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21176);
            ProtocolThreeTwoUI.m19926b(ProtocolThreeTwoUI.this);
            AppMethodBeat.m2505o(21176);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$5 */
    class C120215 implements OnClickListener {
        C120215() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21177);
            C11970l.m19875w(C45957d.byN(), ProtocolThreeTwoUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeTwoUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", C34189m.m56063V(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(ProtocolThreeTwoUI.this.getIntent())), C45957d.m85354vR(ProtocolThreeTwoUI.this.bzz()));
            if (ProtocolThreeTwoUI.this.bzz() == 2) {
                ProtocolThreeTwoUI.this.finish();
                AppMethodBeat.m2505o(21177);
                return;
            }
            C45957d.m85352a(ProtocolThreeTwoUI.this.ssid, 1, ProtocolThreeTwoUI.this.getIntent());
            ProtocolThreeTwoUI.this.connect();
            AppMethodBeat.m2505o(21177);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$6 */
    class C120226 implements OnClickListener {
        C120226() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21178);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", ProtocolThreeTwoUI.this.mza);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(ProtocolThreeTwoUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(21178);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI$7 */
    class C120237 implements C4931a {
        private int mAd = -999999999;

        C120237() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(21179);
            ProtocolThreeTwoUI.this.cxs = ProtocolThreeTwoUI.this.bzz();
            if (this.mAd != ProtocolThreeTwoUI.this.cxs) {
                this.mAd = ProtocolThreeTwoUI.this.cxs;
                ProtocolThreeTwoUI.this.mo23837vT(ProtocolThreeTwoUI.this.cxs);
            }
            AppMethodBeat.m2505o(21179);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ProtocolThreeTwoUI() {
        AppMethodBeat.m2504i(21195);
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePG = true;
        c17927a.ePT = C25738R.drawable.aee;
        c17927a.eQf = true;
        c17927a.eQg = 0.0f;
        this.fGS = c17927a.ahG();
        AppMethodBeat.m2505o(21195);
    }

    /* renamed from: a */
    static /* synthetic */ void m19923a(ProtocolThreeTwoUI protocolThreeTwoUI, int i, String str) {
        AppMethodBeat.m2504i(21205);
        protocolThreeTwoUI.m19925aH(i, str);
        AppMethodBeat.m2505o(21205);
    }

    /* renamed from: b */
    static /* synthetic */ void m19926b(ProtocolThreeTwoUI protocolThreeTwoUI) {
        AppMethodBeat.m2504i(21206);
        protocolThreeTwoUI.goBack();
        AppMethodBeat.m2505o(21206);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21196);
        super.onCreate(bundle);
        this.intent = getIntent();
        this.cuH = getIntent().getStringExtra("free_wifi_ap_key");
        this.openId = getIntent().getStringExtra("free_wifi_openid");
        this.mxc = getIntent().getStringExtra("free_wifi_tid");
        this.cvO = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
        this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), this.cuH);
        initView();
        if (C5046bo.isNullOrNil(this.ssid)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
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
            ML.field_wifiType = 32;
            ML.field_connectState = 1;
            if (i != 0) {
                C11976j.byW().mo10101b((C4925c) ML);
            } else {
                C11976j.byW().mo10103c(ML, new String[0]);
            }
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mxW, Integer.valueOf(this.cvd));
            this.myc = new C120237();
            C11976j.byW().mo10116c(this.myc);
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), ML.field_ssidmd5, ML.field_ssid, ML.field_url, ML.field_mid, Integer.valueOf(ML.field_wifiType), Integer.valueOf(ML.field_connectState));
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
            C45957d.m85352a(this.ssid, 4, getIntent());
        }
        C11970l.m19874v(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        AppMethodBeat.m2505o(21196);
    }

    public final void initView() {
        AppMethodBeat.m2504i(21197);
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
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), this.ssid, this.mxW, this.jUg, Integer.valueOf(this.cvd), Integer.valueOf(this.cdf), this.csB, this.myX, this.myY, this.mza);
        setBackBtn(new C120204());
        findViewById(2131824137).setVisibility(0);
        this.myQ = (ImageView) findViewById(2131824129);
        this.myR = (TextView) findViewById(2131824130);
        this.myS = (TextView) findViewById(2131824131);
        this.myB = (TextView) findViewById(2131824132);
        this.myT = (Button) findViewById(2131824135);
        this.myT.setOnClickListener(new C120215());
        this.myU = (Button) findViewById(2131824136);
        this.myU.setOnClickListener(new C120226());
        if (C5046bo.isNullOrNil(this.ssid)) {
            this.myS.setText(getString(C25738R.string.c0r));
            this.myT.setVisibility(4);
        }
        setMMTitle(getString(C25738R.string.c0t));
        AppMethodBeat.m2505o(21197);
    }

    /* Access modifiers changed, original: protected|final */
    public final void connect() {
        AppMethodBeat.m2504i(21198);
        this.cxs = bzz();
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), C45957d.m85354vR(this.cxs));
        if (this.cxs != 2) {
            this.mAw.mo16770ae(45000, 45000);
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), Integer.valueOf(60));
            this.mwL = new C28067a(this.ssid, this);
            C11976j.byZ().byI().post(new C120138());
            AppMethodBeat.m2505o(21198);
            return;
        }
        C45957d.m85352a(this.ssid, 2, getIntent());
        AppMethodBeat.m2505o(21198);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: vT */
    public final void mo23837vT(int i) {
        AppMethodBeat.m2504i(21199);
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), Integer.valueOf(i));
        switch (i) {
            case 1:
                this.myB.setVisibility(4);
                this.myT.setText(C25738R.string.ato);
                this.mzU = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.ato), true, new C120173());
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                AppMethodBeat.m2505o(21199);
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
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                break;
            case 3:
                if (this.mzU != null) {
                    this.mzU.dismiss();
                }
                this.mAw.stopTimer();
                this.myB.setVisibility(0);
                this.myT.setText(C25738R.string.c0p);
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                AppMethodBeat.m2505o(21199);
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
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                AppMethodBeat.m2505o(21199);
                return;
        }
        AppMethodBeat.m2505o(21199);
    }

    public final int getLayoutId() {
        return 2130969591;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(21200);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(21200);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(21200);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(21201);
        C11970l.m19876x(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        C39111g.gkE.mo38923h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.m2505o(21201);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.m2504i(21202);
        if (C5046bo.isNullOrNil(this.ssid)) {
            C4990ab.m7410d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
            AppMethodBeat.m2505o(21202);
            return 0;
        }
        C3137c ML = C11976j.byW().mo17045ML(this.ssid);
        if (ML == null || !ML.field_ssid.equalsIgnoreCase(this.ssid)) {
            AppMethodBeat.m2505o(21202);
            return 0;
        }
        int i = ML.field_connectState;
        AppMethodBeat.m2505o(21202);
        return i;
    }

    /* renamed from: aH */
    private void m19925aH(int i, String str) {
        AppMethodBeat.m2504i(21203);
        C11967a byo = C11966k.byo();
        byo.ssid = this.ssid;
        byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol32UI");
        byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol32UI");
        byo.cuH = this.cuH;
        byo.mud = this.csB;
        byo.kBq = C34189m.m56063V(this.intent);
        byo.mue = C34189m.m56065X(this.intent);
        byo.muf = C11968b.ThreeTwoAuth.muQ;
        byo.mug = C11968b.ThreeTwoAuth.name;
        byo.result = i;
        byo.ehr = str;
        byo.cIb = C34189m.m56066Y(this.intent);
        byo.muh = this.cBb;
        byo.byq().byp();
        AppMethodBeat.m2505o(21203);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(21204);
        super.onDestroy();
        if (this.myc != null) {
            C11976j.byW().mo10117d(this.myc);
        }
        this.mAw.stopTimer();
        C11976j.byZ().release();
        AppMethodBeat.m2505o(21204);
    }

    /* renamed from: c */
    static /* synthetic */ void m19928c(ProtocolThreeTwoUI protocolThreeTwoUI) {
        AppMethodBeat.m2504i(21207);
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", C34189m.m56063V(protocolThreeTwoUI.getIntent()), Integer.valueOf(C34189m.m56064W(protocolThreeTwoUI.getIntent())), protocolThreeTwoUI.ssid);
        protocolThreeTwoUI.mwL.mo45989a(new C120149());
        AppMethodBeat.m2505o(21207);
    }

    /* renamed from: f */
    static /* synthetic */ void m19931f(ProtocolThreeTwoUI protocolThreeTwoUI) {
        AppMethodBeat.m2504i(21208);
        protocolThreeTwoUI.m19925aH(0, "");
        C11976j.byZ().byI().post(new C120112());
        AppMethodBeat.m2505o(21208);
    }

    /* renamed from: b */
    static /* synthetic */ void m19927b(ProtocolThreeTwoUI protocolThreeTwoUI, String str) {
        AppMethodBeat.m2504i(21210);
        protocolThreeTwoUI.mwR++;
        if (protocolThreeTwoUI.mwR > 3) {
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", C34189m.m56063V(protocolThreeTwoUI.getIntent()), Integer.valueOf(C34189m.m56064W(protocolThreeTwoUI.getIntent())));
            C45957d.m85352a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.m19925aH(33, "AUTH_302_TIMES_EXCESS");
            AppMethodBeat.m2505o(21210);
            return;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", C34189m.m56063V(protocolThreeTwoUI.getIntent()), Integer.valueOf(C34189m.m56064W(protocolThreeTwoUI.getIntent())), str);
        if (C34189m.isEmpty(str)) {
            C45957d.m85352a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.m19925aH(34, "EMPTY_AUTH_LOCATION");
            AppMethodBeat.m2505o(21210);
            return;
        }
        C1201911 c1201911 = new C1201911();
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(C8741b.METHOD))) {
            C45949a.byw();
            C45949a.m85338a(str, parse.getEncodedQuery(), c1201911);
            AppMethodBeat.m2505o(21210);
            return;
        }
        C45949a.byw();
        C45949a.m85337a(str, c1201911);
        AppMethodBeat.m2505o(21210);
    }
}
