package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i.C6726a;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i.C6727b;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactUI */
public class BindMContactUI extends MMWizardActivity {
    private String cFl;
    private String countryCode = null;
    private String fHE = null;
    private int fromScene = 0;
    private boolean gqB = false;
    private EditText grE;
    private LinearLayout grF;
    private TextView grG;
    private TextView grH;
    private TextView grI;
    private String grJ = null;
    private C6725i gro;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactUI$4 */
    class C98534 implements OnMenuItemClickListener {
        C98534() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13464);
            BindMContactUI.m64322g(BindMContactUI.this);
            AppMethodBeat.m2505o(13464);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactUI$5 */
    class C98545 implements OnClickListener {
        C98545() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13465);
            Intent intent = new Intent();
            intent.putExtra("country_name", BindMContactUI.this.fHE);
            intent.putExtra("couttry_code", BindMContactUI.this.countryCode);
            C24679a.gkE.mo38903b(intent, BindMContactUI.this);
            AppMethodBeat.m2505o(13465);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactUI$6 */
    class C265506 implements Runnable {
        C265506() {
        }

        public final void run() {
            AppMethodBeat.m2504i(13466);
            C32921a.m53856b(BindMContactUI.this, BindMContactUI.this.getString(C25738R.string.g7l, new Object[]{C4988aa.dor()}), 30765, true);
            C5274b.m8055hN(BindMContactUI.this);
            AppMethodBeat.m2505o(13466);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactUI$2 */
    class C329372 implements C5002a {
        String ekv;

        C329372() {
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(13460);
            if (C5046bo.isNullOrNil((BindMContactUI.this.grE.getText()).trim())) {
                if (C5046bo.isNullOrNil(this.ekv)) {
                    BindMContactUI.this.grE.setText("");
                } else {
                    BindMContactUI.this.grE.setText(this.ekv);
                    BindMContactUI.this.grE.setSelection(this.ekv.length());
                }
            }
            AppMethodBeat.m2505o(13460);
            return true;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(13461);
            this.ekv = ((C7599a) C1720g.m3530M(C7599a.class)).getPhoneNum(BindMContactUI.this, BindMContactUI.this.countryCode);
            AppMethodBeat.m2505o(13461);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(13462);
            String str = super.toString() + "|initView";
            AppMethodBeat.m2505o(13462);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactUI$3 */
    class C329383 implements OnMenuItemClickListener {
        C329383() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            int i = 0;
            AppMethodBeat.m2504i(13463);
            BindMContactUI.this.cFl = BindMContactUI.this.grI.getText().toString().trim() + C5046bo.m7509PA(BindMContactUI.this.grE.getText().toString());
            if (!C46482a.aij(BindMContactUI.this.cFl) || C5046bo.m7509PA(BindMContactUI.this.grE.getText().toString()).length() <= 0) {
                C30379h.m48467g(BindMContactUI.this, C25738R.string.a70, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(13463);
            } else {
                C4990ab.m7417i("MicroMsg.BindMContactUI", "nextStep %d", Integer.valueOf(BindMContactUI.m64321f(BindMContactUI.this)));
                String m;
                boolean booleanValue;
                BindMContactUI bindMContactUI;
                Object[] objArr;
                switch (BindMContactUI.m64321f(BindMContactUI.this)) {
                    case 0:
                        C30379h.m48461b(BindMContactUI.this, BindMContactUI.this.getString(C25738R.string.a7c), "", true);
                        break;
                    case 1:
                        C4990ab.m7416i("MicroMsg.BindMContactUI", "do next, send sms to self");
                        BindMContactUI.m64317b(BindMContactUI.this, BindMContactUI.this.cFl);
                        break;
                    case 2:
                        int i2;
                        m = C17950b.m28212m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(C25738R.string.b3_));
                        booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                        bindMContactUI = BindMContactUI.this;
                        objArr = new Object[5];
                        objArr[0] = C4988aa.dor();
                        objArr[1] = m;
                        objArr[2] = "setting";
                        objArr[3] = Integer.valueOf(1);
                        if (booleanValue) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        objArr[4] = Integer.valueOf(i2);
                        C32921a.m53856b(BindMContactUI.this, bindMContactUI.getString(C25738R.string.g7o, objArr), 30767, true);
                        break;
                    case 3:
                        m = C17950b.m28212m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(C25738R.string.b3_));
                        booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                        bindMContactUI = BindMContactUI.this;
                        objArr = new Object[5];
                        objArr[0] = C4988aa.dor();
                        objArr[1] = m;
                        objArr[2] = "login";
                        objArr[3] = Integer.valueOf(1);
                        if (booleanValue) {
                            i = 1;
                        }
                        objArr[4] = Integer.valueOf(i);
                        C32921a.m53856b(BindMContactUI.this, bindMContactUI.getString(C25738R.string.g7o, objArr), 30766, true);
                        break;
                    case 4:
                        m = C17950b.m28212m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(C25738R.string.b3_));
                        booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                        bindMContactUI = BindMContactUI.this;
                        objArr = new Object[5];
                        objArr[0] = C4988aa.dor();
                        objArr[1] = m;
                        objArr[2] = "bindMobileA";
                        objArr[3] = Integer.valueOf(1);
                        if (booleanValue) {
                            i = 1;
                        }
                        objArr[4] = Integer.valueOf(i);
                        C32921a.m53856b(BindMContactUI.this, bindMContactUI.getString(C25738R.string.g7o, objArr), 30767, true);
                        break;
                    case 5:
                        m = C17950b.m28212m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(C25738R.string.b3_));
                        booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                        bindMContactUI = BindMContactUI.this;
                        objArr = new Object[5];
                        objArr[0] = C4988aa.dor();
                        objArr[1] = m;
                        objArr[2] = "bindMobileB";
                        objArr[3] = Integer.valueOf(1);
                        if (booleanValue) {
                            i = 1;
                        }
                        objArr[4] = Integer.valueOf(i);
                        C32921a.m53856b(BindMContactUI.this, bindMContactUI.getString(C25738R.string.g7o, objArr), 30767, true);
                        break;
                    case 6:
                        m = C17950b.m28212m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(C25738R.string.b3_));
                        booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                        bindMContactUI = BindMContactUI.this;
                        objArr = new Object[5];
                        objArr[0] = C4988aa.dor();
                        objArr[1] = m;
                        objArr[2] = "bindMobileC";
                        objArr[3] = Integer.valueOf(1);
                        if (booleanValue) {
                            i = 1;
                        }
                        objArr[4] = Integer.valueOf(i);
                        C32921a.m53856b(BindMContactUI.this, bindMContactUI.getString(C25738R.string.g7o, objArr), 30767, true);
                        break;
                    case 7:
                        m = C17950b.m28212m(BindMContactUI.this, BindMContactUI.this.countryCode, BindMContactUI.this.getString(C25738R.string.b3_));
                        booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                        bindMContactUI = BindMContactUI.this;
                        objArr = new Object[5];
                        objArr[0] = C4988aa.dor();
                        objArr[1] = m;
                        objArr[2] = "bindMobileD";
                        objArr[3] = Integer.valueOf(1);
                        if (booleanValue) {
                            i = 1;
                        }
                        objArr[4] = Integer.valueOf(i);
                        C32921a.m53856b(BindMContactUI.this, bindMContactUI.getString(C25738R.string.g7o, objArr), 30767, true);
                        break;
                }
                AppMethodBeat.m2505o(13463);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactUI$1 */
    class C380201 implements DialogInterface.OnClickListener {
        C380201() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13459);
            BindMContactUI.m64315a(BindMContactUI.this);
            AppMethodBeat.m2505o(13459);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m64317b(BindMContactUI bindMContactUI, String str) {
        AppMethodBeat.m2504i(13477);
        bindMContactUI.m64326vL(str);
        AppMethodBeat.m2505o(13477);
    }

    /* renamed from: g */
    static /* synthetic */ void m64322g(BindMContactUI bindMContactUI) {
        AppMethodBeat.m2504i(13478);
        bindMContactUI.apb();
        AppMethodBeat.m2505o(13478);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13468);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.a79);
        this.fHE = C5046bo.m7532bc(getIntent().getStringExtra("country_name"), "");
        this.countryCode = C5046bo.m7532bc(getIntent().getStringExtra("couttry_code"), "");
        this.grJ = C5046bo.m7532bc(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        initView();
        AppMethodBeat.m2505o(13468);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13469);
        super.onDestroy();
        if (this.gro != null) {
            this.gro.recycle();
        }
        AppMethodBeat.m2505o(13469);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13470);
        if (i == 4) {
            apb();
            AppMethodBeat.m2505o(13470);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13470);
        return onKeyDown;
    }

    private void apb() {
        AppMethodBeat.m2504i(13471);
        if (this.fromScene == 0 || this.fromScene == 3) {
            int i;
            int i2;
            if (this.fromScene == 3) {
                i = C25738R.string.a6o;
            } else {
                i = C25738R.string.a6n;
            }
            if (this.fromScene == 3) {
                i2 = C25738R.string.a6q;
            } else {
                i2 = C25738R.string.a6p;
            }
            C30379h.m48432a((Context) this, i, i2, new C380201(), null);
            AppMethodBeat.m2505o(13471);
            return;
        }
        ynD.clear();
        mo27541Ni(1);
        AppMethodBeat.m2505o(13471);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13472);
        this.gqB = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        C4990ab.m7417i("MicroMsg.BindMContactUI", "bindScene:%d", Integer.valueOf(this.fromScene));
        this.grE = (EditText) findViewById(2131821729);
        this.grF = (LinearLayout) findViewById(2131821726);
        this.grH = (TextView) findViewById(2131821728);
        this.grI = (TextView) findViewById(2131821727);
        this.grG = (TextView) findViewById(2131821762);
        if (this.fromScene == 3) {
            String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
            if (!C5046bo.isNullOrNil(str)) {
                String Ps;
                if (str.startsWith("+")) {
                    Ps = C5025av.m7481Ps(str);
                    if (!C5046bo.isNullOrNil(Ps)) {
                        str = str.substring(Ps.length() + 1);
                    }
                } else {
                    Ps = "86";
                }
                C5025av c5025av = new C5025av();
                str = C5025av.formatNumber(Ps, str);
                this.grG.setText(getString(C25738R.string.a6c, new Object[]{str}));
            }
        }
        if (!C5046bo.isNullOrNil(this.fHE)) {
            this.grH.setText(this.fHE);
        }
        if (C5046bo.isNullOrNil(this.countryCode)) {
            this.countryCode = getString(C25738R.string.b3a);
            if (this.countryCode.startsWith("+")) {
                this.countryCode = this.countryCode.substring(1);
            }
        }
        this.grI.setText("+" + this.countryCode);
        if (this.grJ == null || this.grJ.equals("")) {
            C1720g.m3539RS().mo10300a(new C329372());
        } else {
            this.grE.setText(this.grJ);
            this.grE.setSelection(this.grJ.length());
        }
        addTextOptionMenu(0, getString(C25738R.string.f9182s1), new C329383());
        this.grE.requestFocus();
        setBackBtn(new C98534());
        this.grF.setOnClickListener(new C98545());
        AppMethodBeat.m2505o(13472);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(13473);
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.fHE = C5046bo.m7532bc(intent.getStringExtra("country_name"), "");
                this.countryCode = C5046bo.m7532bc(intent.getStringExtra("couttry_code"), "");
                if (!this.fHE.equals("")) {
                    this.grH.setText(this.fHE);
                }
                if (!this.countryCode.equals("")) {
                    this.grI.setText("+" + this.countryCode);
                    break;
                }
                break;
        }
        Bundle bundleExtra;
        switch (i) {
            case 30765:
                if (intent != null) {
                    bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("birthdayComfirmOK")) {
                        m64326vL(this.cFl);
                        break;
                    }
                }
                break;
            case 30766:
                if (intent != null) {
                    bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("agree_privacy")) {
                        C5004al.m7442n(new C265506(), 100);
                    }
                    AppMethodBeat.m2505o(13473);
                    return;
                }
                break;
            case 30767:
                if (intent != null) {
                    bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("agree_privacy")) {
                        m64326vL(this.cFl);
                    }
                    AppMethodBeat.m2505o(13473);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(13473);
    }

    /* renamed from: vL */
    private void m64326vL(final String str) {
        AppMethodBeat.m2504i(13474);
        if (this.gro == null) {
            C6727b c6727b = C6727b.BINDMOBILE;
            if (this.fromScene == 3) {
                c6727b = C6727b.CHANGEMOBILE;
            }
            this.gro = new C6725i(c6727b, this, new C6726a() {
                /* renamed from: e */
                public final void mo14957e(int i, Bundle bundle) {
                    AppMethodBeat.m2504i(13467);
                    if (i == 1) {
                        C4990ab.m7416i("MicroMsg.BindMContactUI", "next to BindMContactVerifyUI for bind mobile");
                        Intent intent = new Intent(BindMContactUI.this, BindMContactVerifyUI.class);
                        intent.putExtra("bindmcontact_mobile", str);
                        intent.putExtra("KEnterFromBanner", BindMContactUI.this.gqB);
                        intent.putExtra("bind_scene", BindMContactUI.this.fromScene);
                        MMWizardActivity.m23791J(BindMContactUI.this, intent);
                    }
                    AppMethodBeat.m2505o(13467);
                }
            });
        }
        this.gro.mo14956wn(str);
        AppMethodBeat.m2505o(13474);
    }

    public final int getLayoutId() {
        return 2130968841;
    }

    /* renamed from: a */
    static /* synthetic */ void m64315a(BindMContactUI bindMContactUI) {
        AppMethodBeat.m2504i(13475);
        bindMContactUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13475);
    }

    /* renamed from: f */
    static /* synthetic */ int m64321f(BindMContactUI bindMContactUI) {
        String str;
        AppMethodBeat.m2504i(13476);
        String bc = C5046bo.m7532bc((String) C1720g.m3536RP().mo5239Ry().get(274436, null), "CN");
        boolean equalsIgnoreCase = "CN".equalsIgnoreCase(bc);
        boolean sO = C17950b.m28216sO(bc);
        C4990ab.m7417i("MicroMsg.BindMContactUI", "regCountry %s, gdpr %s", bc, Boolean.valueOf(sO));
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        String str3 = "";
        if (C5046bo.isNullOrNil(str2)) {
            str = str2;
        } else {
            str = C5025av.m7481Ps(str2);
            str3 = C17950b.m28212m(bindMContactUI, str, bindMContactUI.getString(C25738R.string.b3_));
        }
        if (C5046bo.isNullOrNil(str3)) {
            str3 = bc;
        }
        boolean equalsIgnoreCase2 = "CN".equalsIgnoreCase(str3);
        boolean sO2 = C17950b.m28216sO(str3);
        C4990ab.m7417i("MicroMsg.BindMContactUI", "curBindMobile %s, curBindIso %s, gdpr %s", str, str3, Boolean.valueOf(sO2));
        boolean equals = bindMContactUI.countryCode.equals("86");
        boolean sP = C17950b.m28217sP(bindMContactUI.countryCode);
        C4990ab.m7417i("MicroMsg.BindMContactUI", "countryCode %s, gdpr %s", bindMContactUI.countryCode, Boolean.valueOf(sP));
        if (equals) {
            if (C7243d.vxp) {
                if (equalsIgnoreCase) {
                    if (!equalsIgnoreCase2) {
                        if (sO2) {
                            AppMethodBeat.m2505o(13476);
                            return 5;
                        }
                        AppMethodBeat.m2505o(13476);
                        return 4;
                    }
                } else if (sO) {
                    AppMethodBeat.m2505o(13476);
                    return 6;
                } else if (sO2) {
                    AppMethodBeat.m2505o(13476);
                    return 6;
                } else {
                    AppMethodBeat.m2505o(13476);
                    return 7;
                }
            }
        } else if (equalsIgnoreCase) {
            if (sP) {
                AppMethodBeat.m2505o(13476);
                return 0;
            }
            AppMethodBeat.m2505o(13476);
            return 2;
        } else if (!sO && sP) {
            AppMethodBeat.m2505o(13476);
            return 3;
        }
        AppMethodBeat.m2505o(13476);
        return 1;
    }
}
