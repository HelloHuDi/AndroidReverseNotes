package com.tencent.p177mm.plugin.account.p275ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p230g.p232b.p233a.C42085ba;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.p629f.p630a.C15885b;
import com.tencent.p177mm.p612ui.p629f.p630a.C15887d;
import com.tencent.p177mm.p612ui.p629f.p630a.C15887d.C15886b;
import com.tencent.p177mm.p612ui.p629f.p630a.C15887d.C15888a;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c.C30705a;
import com.tencent.p177mm.p612ui.p629f.p630a.C30706e;
import com.tencent.p177mm.platformtools.C1948e;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.p275ui.C33037b.C189591;
import com.tencent.p177mm.plugin.account.p275ui.C33037b.C189602;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI */
public class FacebookLoginUI extends MMPreference implements C1202f {
    private static final String[] gAu = new String[]{"public_profile"};
    private String cOG = "";
    private C15887d gAT;
    private String gAW = "";
    private C4884c gAY = new C188711();
    private OnCancelListener gAs;
    private C30704c gBj;
    private C44275p gBk;
    private C6686q gBl;
    private C42085ba gBm = new C42085ba();
    private C33037b gBn;
    boolean gBo = true;
    private String gsF;

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$1 */
    class C188711 extends C4884c<C37745jk> {
        C188711() {
            AppMethodBeat.m2504i(124829);
            this.xxI = C37745jk.class.getName().hashCode();
            AppMethodBeat.m2505o(124829);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(124830);
            C37745jk c37745jk = (C37745jk) c4883b;
            if (c37745jk == null || c37745jk.cEJ == null) {
                AppMethodBeat.m2505o(124830);
                return false;
            }
            C4990ab.m7417i("MicroMsg.FacebookLoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", c37745jk.cEJ.content, c37745jk.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", c37745jk.cEJ.content);
            intent.putExtra("key_disaster_url", c37745jk.cEJ.url);
            intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(124830);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$2 */
    class C188722 implements OnCancelListener {
        C188722() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(124831);
            if (FacebookLoginUI.this.gBl != null) {
                C1720g.m3540Rg().mo14547c(FacebookLoginUI.this.gBl);
            }
            AppMethodBeat.m2505o(124831);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$3 */
    class C188733 implements OnMenuItemClickListener {
        C188733() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124832);
            FacebookLoginUI.m64399i(FacebookLoginUI.this);
            AppMethodBeat.m2505o(124832);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$9 */
    class C266149 implements C1835a {
        C266149() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(124842);
            if (c1902e == null) {
                AppMethodBeat.m2505o(124842);
                return;
            }
            C1898c adg = c1902e.adg();
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            byte[] bArr3 = new byte[0];
            C1720g.m3534RN();
            adg.mo5482a(bArr, bArr2, bArr3, C1668a.m3383QF());
            AppMethodBeat.m2505o(124842);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$11 */
    class C3805111 extends C33037b {
        C3805111() {
        }

        /* renamed from: a */
        public final C1207m mo53591a(C1207m c1207m, String str) {
            AppMethodBeat.m2504i(124844);
            C6686q c6686q = new C6686q("facebook@wechat_auth", FacebookLoginUI.this.gAW, ((C6686q) c1207m).getSecCodeType(), str, ((C6686q) c1207m).ajn(), ((C6686q) c1207m).ajp(), 0, "", true, false);
            AppMethodBeat.m2505o(124844);
            return c6686q;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$4 */
    class C380524 implements C15886b {
        C380524() {
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(124833);
            C4990ab.m7416i("MicroMsg.FacebookLoginUI", "facebook-android login success!");
            FacebookLoginUI.this.gAW = FacebookLoginUI.this.gAT.zxJ.getToken();
            FacebookLoginUI.m64392b(FacebookLoginUI.this);
            AppMethodBeat.m2505o(124833);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(124834);
            C4990ab.m7416i("MicroMsg.FacebookLoginUI", "facebook-android login cancel!");
            AppMethodBeat.m2505o(124834);
        }

        public final void onError(String str) {
            AppMethodBeat.m2504i(124835);
            C4990ab.m7417i("MicroMsg.FacebookLoginUI", "facebook-android login error! %s", str);
            C30379h.m48461b(FacebookLoginUI.this, FacebookLoginUI.this.getString(C25738R.string.bm2), "", true);
            AppMethodBeat.m2505o(124835);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$6 */
    class C380536 implements C5002a {
        JSONObject gBq = null;

        C380536() {
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(124838);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "name,picture.type(large)");
            try {
                C4990ab.m7417i("MicroMsg.FacebookLoginUI", "result json %s", FacebookLoginUI.this.gBj.mo49077q("me", bundle));
                this.gBq = new JSONObject(r0);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "get name and picture error!", new Object[0]);
                C30379h.m48461b(FacebookLoginUI.this, "Retrieve Failed, Error Format!", "", true);
            }
            AppMethodBeat.m2505o(124838);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(124839);
            if (this.gBq != null) {
                try {
                    Intent intent = new Intent(FacebookLoginUI.this, RegByMobileRegAIOUI.class);
                    intent.putExtra("third_app_token", FacebookLoginUI.this.gBj.gqE.toString());
                    intent.putExtra("register_title", FacebookLoginUI.this.getString(C25738R.string.b34));
                    intent.putExtra("register_nick_name", this.gBq.getString("name"));
                    intent.putExtra("register_avatar", ((JSONObject) this.gBq.get("picture")).getJSONObject("data").getString("url"));
                    FacebookLoginUI.this.startActivity(intent);
                    FacebookLoginUI.this.gBm.daR = 1;
                    FacebookLoginUI.this.gBm.cVS = 4;
                    FacebookLoginUI.this.gBm.ajK();
                    FacebookLoginUI.this.finish();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "parse json error!", new Object[0]);
                    C30379h.m48461b(FacebookLoginUI.this, "Retrieve Failed, Error Format!", "", true);
                }
            }
            AppMethodBeat.m2505o(124839);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$8 */
    class C380548 implements OnClickListener {
        C380548() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124841);
            FacebookLoginUI.this.finish();
            AppMethodBeat.m2505o(124841);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$a */
    final class C38055a implements C30705a {
        private C38055a() {
        }

        /* synthetic */ C38055a(FacebookLoginUI facebookLoginUI, byte b) {
            this();
        }

        /* renamed from: p */
        public final void mo5794p(Bundle bundle) {
            AppMethodBeat.m2504i(124845);
            FacebookLoginUI.this.gAW = FacebookLoginUI.this.gBj.gqE;
            FacebookLoginUI.m64392b(FacebookLoginUI.this);
            AppMethodBeat.m2505o(124845);
        }

        /* renamed from: a */
        public final void mo5792a(C30706e c30706e) {
            AppMethodBeat.m2504i(124846);
            C4990ab.m7410d("MicroMsg.FacebookLoginUI", "onFacebookError:" + c30706e.getMessage());
            C30379h.m48461b(FacebookLoginUI.this, c30706e.getMessage(), FacebookLoginUI.this.getString(C25738R.string.bm2), true);
            FacebookLoginUI.aqR();
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("L14")).append(",2").toString());
            C7060h.pYm.mo8378a(582, 7, 1, false);
            AppMethodBeat.m2505o(124846);
        }

        /* renamed from: a */
        public final void mo5791a(C15885b c15885b) {
            AppMethodBeat.m2504i(124847);
            C4990ab.m7410d("MicroMsg.FacebookLoginUI", "onError:" + c15885b.getMessage());
            C30379h.m48461b(FacebookLoginUI.this, c15885b.getMessage(), FacebookLoginUI.this.getString(C25738R.string.bm2), true);
            FacebookLoginUI.aqR();
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("L14")).append(",2").toString());
            C7060h.pYm.mo8378a(582, 8, 1, false);
            AppMethodBeat.m2505o(124847);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(124848);
            C4990ab.m7410d("MicroMsg.FacebookLoginUI", "onCancel");
            FacebookLoginUI.aqR();
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("L14")).append(",2").toString());
            C7060h.pYm.mo8378a(582, 9, 1, false);
            AppMethodBeat.m2505o(124848);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$10 */
    class C3805610 implements Runnable {
        C3805610() {
        }

        public final void run() {
            AppMethodBeat.m2504i(124843);
            Intent bh = C24679a.gkE.mo38909bh(FacebookLoginUI.this);
            bh.addFlags(67108864);
            FacebookLoginUI.this.startActivity(bh);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("L14")).append(",4").toString());
            FacebookLoginUI.this.finish();
            AppMethodBeat.m2505o(124843);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$5 */
    class C380575 implements C15888a {
        C380575() {
        }

        /* renamed from: g */
        public final void mo28128g(JSONObject jSONObject) {
            AppMethodBeat.m2504i(124836);
            C4990ab.m7416i("MicroMsg.FacebookLoginUI", "facebook-android get name and picture completed!");
            if (jSONObject != null) {
                try {
                    Intent intent = new Intent(FacebookLoginUI.this, RegByMobileRegAIOUI.class);
                    String str = null;
                    if (!(FacebookLoginUI.this.gAT.zxJ == null || FacebookLoginUI.this.gAT.zxJ.getToken() == null)) {
                        str = FacebookLoginUI.this.gAT.zxJ.getToken().toString();
                    }
                    intent.putExtra("third_app_token", str);
                    intent.putExtra("register_title", FacebookLoginUI.this.getString(C25738R.string.b34));
                    if (jSONObject.has("name")) {
                        intent.putExtra("register_nick_name", jSONObject.getString("name"));
                        C4990ab.m7417i("MicroMsg.FacebookLoginUI", "name %s", jSONObject.getString("name"));
                    }
                    if (jSONObject.has("picture")) {
                        C4990ab.m7417i("MicroMsg.FacebookLoginUI", "picture %s", jSONObject.get("picture"));
                        intent.putExtra("register_avatar", ((JSONObject) jSONObject.get("picture")).getJSONObject("data").getString("url"));
                    }
                    FacebookLoginUI.this.startActivity(intent);
                    FacebookLoginUI.this.finish();
                    FacebookLoginUI.this.gBm.daR = 1;
                    FacebookLoginUI.this.gBm.cVS = 4;
                    FacebookLoginUI.this.gBm.ajK();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "parse json error!", new Object[0]);
                    C30379h.m48461b(FacebookLoginUI.this, "Retrieve Failed, Error Format!", "", true);
                    AppMethodBeat.m2505o(124836);
                    return;
                }
            }
            AppMethodBeat.m2505o(124836);
        }

        public final void onError(String str) {
            AppMethodBeat.m2504i(124837);
            C4990ab.m7417i("MicroMsg.FacebookLoginUI", "facebook-android get name and picture error! %s", str);
            C30379h.m48461b(FacebookLoginUI.this, FacebookLoginUI.this.getString(C25738R.string.bm2), "", true);
            AppMethodBeat.m2505o(124837);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.FacebookLoginUI$7 */
    class C380587 implements OnClickListener {
        C380587() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124840);
            if (C7243d.vxr) {
                FacebookLoginUI.m64395e(FacebookLoginUI.this);
                AppMethodBeat.m2505o(124840);
                return;
            }
            FacebookLoginUI.m64396f(FacebookLoginUI.this);
            AppMethodBeat.m2505o(124840);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FacebookLoginUI() {
        AppMethodBeat.m2504i(124849);
        AppMethodBeat.m2505o(124849);
    }

    /* renamed from: b */
    static /* synthetic */ void m64392b(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.m2504i(124863);
        facebookLoginUI.aqO();
        AppMethodBeat.m2505o(124863);
    }

    /* renamed from: e */
    static /* synthetic */ void m64395e(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.m2504i(124864);
        facebookLoginUI.aqQ();
        AppMethodBeat.m2505o(124864);
    }

    /* renamed from: i */
    static /* synthetic */ void m64399i(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.m2504i(124866);
        facebookLoginUI.goBack();
        AppMethodBeat.m2505o(124866);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124850);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.co3);
        C24679a.gkF.mo38846BV();
        this.gsF = C42756a.m75794FP();
        initView();
        C1720g.m3540Rg().mo14539a(701, (C1202f) this);
        C1720g.m3540Rg().mo14539a(252, (C1202f) this);
        AppMethodBeat.m2505o(124850);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(124851);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        AppMethodBeat.m2505o(124851);
    }

    public void onResume() {
        AppMethodBeat.m2504i(124852);
        C4879a.xxA.mo10052c(this.gAY);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L100_200_FB,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("L100_200_FB")).append(",1").toString());
        C42756a.m75798wz("L100_200_FB");
        AppMethodBeat.m2505o(124852);
    }

    public void onPause() {
        AppMethodBeat.m2504i(124853);
        super.onPause();
        C4879a.xxA.mo10053d(this.gAY);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L100_200_FB,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("L100_200_FB")).append(",2").toString());
        AppMethodBeat.m2505o(124853);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(124854);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(124854);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(124854);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(124855);
        C42756a.m75796wA(this.gsF);
        finish();
        AppMethodBeat.m2505o(124855);
    }

    private void aqO() {
        AppMethodBeat.m2504i(124856);
        getString(C25738R.string.f9238tz);
        this.gBk = C30379h.m48458b((Context) this, getString(C25738R.string.cou), true, null);
        this.gBk.setOnCancelListener(this.gAs);
        C4990ab.m7417i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", "facebook@wechat_auth", Integer.valueOf(this.gAW.length()), this.gAW.substring(0, 4));
        this.gBl = new C6686q("facebook@wechat_auth", this.gAW, 0, "", "", "", 0, "", true, false);
        C1720g.m3540Rg().mo14541a(this.gBl, 0);
        AppMethodBeat.m2505o(124856);
    }

    private void aqP() {
        AppMethodBeat.m2504i(124857);
        if (C35800q.m58700u(this, "com.facebook.katana")) {
            if (this.gAT == null) {
                this.gAT = new C15887d(getString(C25738R.string.g7d));
                this.gAT.dJd();
            }
            if (this.gAT.dJc()) {
                aqO();
            } else {
                this.gAT.logout();
                this.gAT.mo28122a(this, new C380524(), gAu);
            }
        } else {
            try {
                if (this.gBj != null) {
                    this.gBj.mo49076ie(this);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "", new Object[0]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L14,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("L14")).append(",1").toString());
            this.gBj = new C30704c(getString(C25738R.string.g7d));
            this.gBj.mo49070a((Activity) this, gAu, new C38055a(this, (byte) 0));
        }
        C7060h.pYm.mo8378a(582, 5, 1, false);
        AppMethodBeat.m2505o(124857);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124858);
        C4990ab.m7417i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", Integer.valueOf(c1207m.hashCode()), Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.gBk != null) {
            this.gBk.dismiss();
            this.gBk = null;
        }
        if (!C5046bo.m7544cv(this)) {
            AppMethodBeat.m2505o(124858);
        } else if (c1207m instanceof C6686q) {
            this.cOG = ((C6686q) c1207m).ajm();
            Object obj = null;
            if ((c1207m.getType() == 252 || c1207m.getType() == 701) && i == 4 && (i2 == -16 || i2 == -17)) {
                obj = 1;
                C1720g.m3540Rg().mo14541a(new C6668bk(new C266149()), 0);
            }
            if (obj != null || (i == 0 && i2 == 0)) {
                C1668a.unhold();
                C38033l.apX();
                this.gBm.daR = 1;
                this.gBm.cVS = 12;
                this.gBm.ajK();
                C42257z.m74637vx(C1853r.m3846Yz());
                C26529w.m42356cm(this);
                C42257z.showAddrBookUploadConfirm(this, new C3805610(), false, 2);
                AppMethodBeat.m2505o(124858);
            } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                C42257z.m74635f(this, str, 0);
                AppMethodBeat.m2505o(124858);
            } else if (i2 == -217) {
                C42257z.m74633a(this, C1948e.m4157a((C6686q) c1207m), i2);
                AppMethodBeat.m2505o(124858);
            } else if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.gBn == null) {
                    this.gBn = new C3805111();
                }
                C33037b c33037b = this.gBn;
                byte[] ajo = ((C6686q) c1207m).ajo();
                c33037b.gAi = c1207m;
                if (c33037b.gue == null) {
                    c33037b.gue = C15492a.m23811a(this, 0, ajo, "", "", new C189591(this), null, new C189602(), c33037b);
                    AppMethodBeat.m2505o(124858);
                    return;
                }
                c33037b.gue.mo27573b(0, ajo, "", "");
                AppMethodBeat.m2505o(124858);
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -107:
                            this.gBm.daR = 1;
                            this.gBm.cVS = 11;
                            this.gBm.ajK();
                            C30379h.m48466d(this, getString(C25738R.string.bmm), "", getString(C25738R.string.dmw), getString(C25738R.string.cp8), new C380587(), new C380548());
                            obj = 1;
                            break;
                        case -75:
                            C42257z.m74634cu(this.mController.ylL);
                            obj = 1;
                            break;
                        case -72:
                            C30379h.m48467g(this.mController.ylL, C25738R.string.dmb, C25738R.string.f9238tz);
                            obj = 1;
                            break;
                        case -30:
                            if (C7243d.vxr) {
                                aqQ();
                            }
                            obj = 1;
                            break;
                        case -9:
                            C30379h.m48467g(this, C25738R.string.cof, C25738R.string.cog);
                            obj = 1;
                            break;
                        case -1:
                            if (C1720g.m3540Rg().acS() == 5) {
                                C30379h.m48467g(this, C25738R.string.d5n, C25738R.string.d5m);
                                obj = 1;
                                break;
                            }
                        case -4:
                        case -3:
                            C30379h.m48467g(this, C25738R.string.be9, C25738R.string.cog);
                            obj = 1;
                            break;
                    }
                }
                if (C24679a.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AppMethodBeat.m2505o(124858);
                    return;
                }
                if (c1207m.getType() == 252 || c1207m.getType() == 701) {
                    C42124a jY = C42124a.m74268jY(str);
                    if (jY != null && jY.mo67668a(this, null, null)) {
                        AppMethodBeat.m2505o(124858);
                        return;
                    }
                }
                Toast.makeText(this, getString(C25738R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                AppMethodBeat.m2505o(124858);
            }
        } else {
            AppMethodBeat.m2505o(124858);
        }
    }

    private void aqQ() {
        AppMethodBeat.m2504i(124859);
        String string = getString(C25738R.string.b3m, new Object[]{"0x" + Integer.toHexString(C7243d.vxo), C4988aa.dor()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        C24679a.gkE.mo38924i(intent, this);
        AppMethodBeat.m2505o(124859);
    }

    public final void initView() {
        AppMethodBeat.m2504i(124860);
        this.gBj = new C30704c(getString(C25738R.string.g7d));
        this.gAs = new C188722();
        aqP();
        setBackBtn(new C188733());
        AppMethodBeat.m2505o(124860);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.m2504i(124861);
        String str = "MicroMsg.FacebookLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        C4990ab.m7417i(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(C5046bo.isNullOrNil(stringExtra));
            if (!C5046bo.isNullOrNil(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            C4990ab.m7417i(str2, str3, objArr2);
            if (intExtra == -217) {
                aqP();
                AppMethodBeat.m2505o(124861);
                return;
            }
        }
        if (this.gBj != null) {
            this.gBj.mo49075h(i, i2, intent);
        }
        if (this.gAT != null) {
            this.gAT.mo28126h(i, i2, intent);
        }
        AppMethodBeat.m2505o(124861);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8507ar;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(124862);
        String str = preference.mKey;
        if (str == null) {
            C4990ab.m7412e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
            AppMethodBeat.m2505o(124862);
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            aqP();
            AppMethodBeat.m2505o(124862);
            return true;
        } else {
            AppMethodBeat.m2505o(124862);
            return false;
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m64396f(FacebookLoginUI facebookLoginUI) {
        AppMethodBeat.m2504i(124865);
        if (C35800q.m58700u(facebookLoginUI, "com.facebook.katana")) {
            facebookLoginUI.gAT.mo28123a("name,picture.type(large)", new C380575());
            AppMethodBeat.m2505o(124865);
            return;
        }
        C1720g.m3539RS().mo10300a(new C380536());
        AppMethodBeat.m2505o(124865);
    }

    static /* synthetic */ void aqR() {
        AppMethodBeat.m2504i(124867);
        C1720g.m3536RP().eJH.set(20, Integer.valueOf(C5046bo.m7512a((Integer) C1720g.m3536RP().eJH.get(20), 0) + 1));
        AppMethodBeat.m2505o(124867);
    }
}
