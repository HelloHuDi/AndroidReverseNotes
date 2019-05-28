package com.tencent.p177mm.plugin.account.p275ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p230g.p232b.p233a.C42085ba;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.p629f.p630a.C15885b;
import com.tencent.p177mm.p612ui.p629f.p630a.C15887d;
import com.tencent.p177mm.p612ui.p629f.p630a.C15887d.C15886b;
import com.tencent.p177mm.p612ui.p629f.p630a.C15887d.C15888a;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c.C30705a;
import com.tencent.p177mm.p612ui.p629f.p630a.C30706e;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import java.util.ArrayList;
import org.json.JSONObject;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.account.ui.WelcomeActivity */
public class WelcomeActivity extends MMFragmentActivity {
    private static final String[] gAu = new String[]{"public_profile"};
    private C15887d gAT;
    private C30704c gBj;
    private C42085ba gBm = new C42085ba();
    private WelcomeSelectView gIt;

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeActivity$1 */
    class C20311 implements OnClickListener {
        C20311() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125633);
            Intent intent = new Intent();
            intent.putExtra("not_auth_setting", true);
            intent.putExtra("from_login_history", true);
            C24679a.gkE.mo38930o(intent, WelcomeActivity.this);
            AppMethodBeat.m2505o(125633);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeActivity$2 */
    class C20322 implements C15886b {
        C20322() {
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(125634);
            C4990ab.m7416i("MicroMsg.WelcomeActivity", "facebook-android login success!");
            WelcomeActivity.m54003f(WelcomeActivity.this);
            AppMethodBeat.m2505o(125634);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(125635);
            C4990ab.m7416i("MicroMsg.WelcomeActivity", "facebook-android login cancel!");
            AppMethodBeat.m2505o(125635);
        }

        public final void onError(String str) {
            AppMethodBeat.m2504i(125636);
            C4990ab.m7417i("MicroMsg.WelcomeActivity", "facebook-android login error! %s", str);
            C30379h.m48461b(WelcomeActivity.this, WelcomeActivity.this.getString(C25738R.string.bm2), "", true);
            AppMethodBeat.m2505o(125636);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeActivity$3 */
    class C20333 implements C30705a {
        C20333() {
        }

        /* renamed from: p */
        public final void mo5794p(Bundle bundle) {
            AppMethodBeat.m2504i(125637);
            C4990ab.m7416i("MicroMsg.WelcomeActivity", "facebook login success");
            WelcomeActivity.m54003f(WelcomeActivity.this);
            AppMethodBeat.m2505o(125637);
        }

        /* renamed from: a */
        public final void mo5792a(C30706e c30706e) {
            AppMethodBeat.m2504i(125638);
            C4990ab.m7417i("MicroMsg.WelcomeActivity", "facebook-android login error! %s", c30706e.getMessage());
            C30379h.m48461b(WelcomeActivity.this, WelcomeActivity.this.getString(C25738R.string.bm2), "", true);
            AppMethodBeat.m2505o(125638);
        }

        /* renamed from: a */
        public final void mo5791a(C15885b c15885b) {
            AppMethodBeat.m2504i(125639);
            C4990ab.m7417i("MicroMsg.WelcomeActivity", "facebook-android login error! %s", c15885b.getMessage());
            C30379h.m48461b(WelcomeActivity.this, WelcomeActivity.this.getString(C25738R.string.bm2), "", true);
            AppMethodBeat.m2505o(125639);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(125640);
            C4990ab.m7416i("MicroMsg.WelcomeActivity", "facebook login cancel");
            AppMethodBeat.m2505o(125640);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeActivity$9 */
    class C189579 implements OnClickListener {
        C189579() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125645);
            if (C7243d.vxr) {
                WelcomeActivity.m54000c(WelcomeActivity.this);
                AppMethodBeat.m2505o(125645);
                return;
            }
            WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class));
            AppMethodBeat.m2505o(125645);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeActivity$4 */
    class C330304 implements OnClickListener {
        C330304() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125641);
            Intent intent = new Intent(WelcomeActivity.this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            WelcomeActivity.this.startActivity(intent);
            AppMethodBeat.m2505o(125641);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeActivity$6 */
    class C330316 implements C5279d {
        C330316() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(125643);
            switch (menuItem.getItemId()) {
                case 1001:
                    WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class));
                    AppMethodBeat.m2505o(125643);
                    return;
                case 1002:
                    WelcomeActivity.this.gBm.daR = 1;
                    WelcomeActivity.this.gBm.cVS = 2;
                    WelcomeActivity.this.gBm.ajK();
                    WelcomeActivity.m53999b(WelcomeActivity.this);
                    break;
            }
            AppMethodBeat.m2505o(125643);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeActivity$10 */
    class C3303210 implements C15888a {
        C3303210() {
        }

        /* renamed from: g */
        public final void mo28128g(JSONObject jSONObject) {
            AppMethodBeat.m2504i(125646);
            C4990ab.m7416i("MicroMsg.WelcomeActivity", "facebook-android get name and picture completed!");
            if (jSONObject != null) {
                try {
                    Intent intent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
                    String str = null;
                    if (!(WelcomeActivity.this.gAT.zxJ == null || WelcomeActivity.this.gAT.zxJ.getToken() == null)) {
                        str = WelcomeActivity.this.gAT.zxJ.getToken().toString();
                    }
                    intent.putExtra("third_app_token", str);
                    intent.putExtra("reg_3d_app_type", 1);
                    intent.putExtra("register_title", WelcomeActivity.this.getString(C25738R.string.b34));
                    if (jSONObject.has("name")) {
                        intent.putExtra("register_nick_name", jSONObject.getString("name"));
                        C4990ab.m7417i("MicroMsg.WelcomeActivity", "name %s", jSONObject.getString("name"));
                    }
                    if (jSONObject.has("picture")) {
                        C4990ab.m7417i("MicroMsg.WelcomeActivity", "picture %s", jSONObject.get("picture"));
                        intent.putExtra("register_avatar", ((JSONObject) jSONObject.get("picture")).getJSONObject("data").getString("url"));
                    }
                    WelcomeActivity.this.startActivity(intent);
                    WelcomeActivity.this.gBm.daR = 1;
                    WelcomeActivity.this.gBm.cVS = 3;
                    WelcomeActivity.this.gBm.ajK();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WelcomeActivity", e, "parse json error!", new Object[0]);
                    C30379h.m48461b(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
                    AppMethodBeat.m2505o(125646);
                    return;
                }
            }
            AppMethodBeat.m2505o(125646);
        }

        public final void onError(String str) {
            AppMethodBeat.m2504i(125647);
            C4990ab.m7417i("MicroMsg.WelcomeActivity", "facebook-android get name and picture error! %s", str);
            C30379h.m48461b(WelcomeActivity.this, WelcomeActivity.this.getString(C25738R.string.bm2), "", true);
            AppMethodBeat.m2505o(125647);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeActivity$7 */
    class C330347 implements C15994a {
        C330347() {
        }

        public final void onDismiss() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeActivity$11 */
    class C3303511 implements C5002a {
        JSONObject gBq = null;

        C3303511() {
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(125648);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "name,picture.type(large)");
            try {
                C4990ab.m7417i("MicroMsg.WelcomeActivity", "result json %s", WelcomeActivity.this.gBj.mo49077q("me", bundle));
                this.gBq = new JSONObject(r0);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WelcomeActivity", e, "get name and picture error!", new Object[0]);
                C30379h.m48461b(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
            }
            AppMethodBeat.m2505o(125648);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(125649);
            if (this.gBq != null) {
                try {
                    Intent intent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
                    intent.putExtra("third_app_token", WelcomeActivity.this.gBj.gqE.toString());
                    intent.putExtra("reg_3d_app_type", 1);
                    intent.putExtra("register_title", WelcomeActivity.this.getString(C25738R.string.b34));
                    intent.putExtra("register_nick_name", this.gBq.getString("name"));
                    intent.putExtra("register_avatar", ((JSONObject) this.gBq.get("picture")).getJSONObject("data").getString("url"));
                    WelcomeActivity.this.startActivity(intent);
                    WelcomeActivity.this.gBm.daR = 1;
                    WelcomeActivity.this.gBm.cVS = 3;
                    WelcomeActivity.this.gBm.ajK();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WelcomeActivity", e, "parse json error!", new Object[0]);
                    C30379h.m48461b(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
                }
            }
            AppMethodBeat.m2505o(125649);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WelcomeActivity() {
        AppMethodBeat.m2504i(125650);
        AppMethodBeat.m2505o(125650);
    }

    /* renamed from: f */
    static /* synthetic */ void m54003f(WelcomeActivity welcomeActivity) {
        AppMethodBeat.m2504i(125659);
        welcomeActivity.arM();
        AppMethodBeat.m2505o(125659);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125651);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.gIt = new WelcomeSelectView(this);
        setContentView((View) this.gIt);
        this.gIt.arN();
        this.gIt.gIx.setOnClickListener(new C20311());
        this.gIt.gIv.setOnClickListener(new C330304());
        final ArrayList arrayList = new ArrayList();
        C44274m c44274m = new C44274m(this, 1001, 0);
        c44274m.setTitle((int) C25738R.string.dkp);
        arrayList.add(c44274m);
        c44274m = new C44274m(this, 1002, 0);
        if (C17950b.ahL()) {
            c44274m.setTitle((int) C25738R.string.dkn);
            arrayList.add(c44274m);
        }
        if (arrayList.size() > 1) {
            final C36356d c36356d = new C36356d(this, 1, false);
            c36356d.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(125642);
                    if (c44273l.dzR()) {
                        for (C44274m i : arrayList) {
                            c44273l.mo70073i(i);
                        }
                    }
                    AppMethodBeat.m2505o(125642);
                }
            };
            c36356d.rBm = new C330316();
            c36356d.zQf = new C330347();
            this.gIt.gIw.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(125644);
                    if (C7243d.vxr) {
                        WelcomeActivity.m54000c(WelcomeActivity.this);
                        AppMethodBeat.m2505o(125644);
                        return;
                    }
                    c36356d.cpD();
                    if (arrayList.contains(c44274m)) {
                        WelcomeActivity.this.gBm.daR = 1;
                        WelcomeActivity.this.gBm.cVS = 1;
                        WelcomeActivity.this.gBm.ajK();
                    }
                    AppMethodBeat.m2505o(125644);
                }
            });
            AppMethodBeat.m2505o(125651);
            return;
        }
        this.gIt.gIw.setOnClickListener(new C189579());
        AppMethodBeat.m2505o(125651);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125652);
        super.onResume();
        this.gIt.init();
        AppMethodBeat.m2505o(125652);
    }

    private void arM() {
        AppMethodBeat.m2504i(125653);
        if (C35800q.m58700u(this, "com.facebook.katana")) {
            this.gAT.mo28123a("name,picture.type(large)", new C3303210());
            AppMethodBeat.m2505o(125653);
            return;
        }
        C1720g.m3539RS().mo10300a(new C3303511());
        AppMethodBeat.m2505o(125653);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125654);
        super.onDestroy();
        this.gBm.ajK();
        if (this.gAT != null) {
            this.gAT.logout();
        }
        AppMethodBeat.m2505o(125654);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125655);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent bh = C24679a.gkE.mo38909bh(this);
            bh.addFlags(67108864);
            bh.putExtra("can_finish", true);
            startActivity(bh);
            finish();
            C5274b.m8054hM(this);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125655);
        return onKeyDown;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        AppMethodBeat.m2504i(125656);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.WelcomeActivity";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (this.gAT != null) {
            this.gAT.mo28126h(i, i2, intent);
        }
        AppMethodBeat.m2505o(125656);
    }

    /* renamed from: b */
    static /* synthetic */ void m53999b(WelcomeActivity welcomeActivity) {
        AppMethodBeat.m2504i(125657);
        if (C35800q.m58700u(welcomeActivity, "com.facebook.katana")) {
            if (welcomeActivity.gAT == null) {
                welcomeActivity.gAT = new C15887d(welcomeActivity.getString(C25738R.string.g7d));
                welcomeActivity.gAT.dJd();
            }
            if (welcomeActivity.gAT.dJc()) {
                welcomeActivity.arM();
                AppMethodBeat.m2505o(125657);
                return;
            }
            welcomeActivity.gAT.logout();
            welcomeActivity.gAT.mo28122a(welcomeActivity, new C20322(), gAu);
            AppMethodBeat.m2505o(125657);
            return;
        }
        welcomeActivity.gBj = new C30704c(welcomeActivity.getString(C25738R.string.g7d));
        welcomeActivity.gBj.mo49070a((Activity) welcomeActivity, gAu, new C20333());
        AppMethodBeat.m2505o(125657);
    }

    /* renamed from: c */
    static /* synthetic */ void m54000c(WelcomeActivity welcomeActivity) {
        AppMethodBeat.m2504i(125658);
        String string = welcomeActivity.getString(C25738R.string.b3m, new Object[]{"0x" + Integer.toHexString(C7243d.vxo), C4988aa.dor()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        C24679a.gkE.mo38924i(intent, welcomeActivity);
        AppMethodBeat.m2505o(125658);
    }
}
