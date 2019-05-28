package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMAutoSwitchEditTextView;
import com.tencent.p177mm.p612ui.base.MMAutoSwitchEditTextView.C5243a;
import com.tencent.p177mm.p612ui.base.MMAutoSwitchEditTextView.C5244b;
import com.tencent.p177mm.plugin.account.friend.p272a.C1985r.C1986a;
import com.tencent.p177mm.plugin.account.friend.p272a.C1985r.C1987b;
import com.tencent.p177mm.plugin.account.friend.p272a.C9881z;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C42475m;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.EmailVerifyUI */
public class EmailVerifyUI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private TextView gAF;
    private TextView gAG;
    private MMAutoSwitchEditTextView gAH;
    private Button gAI;
    private Button gAJ;
    private String gAK;
    private String gAL;
    private String gAM;
    private String gAN;
    private boolean gAO = false;
    private String gsF;

    /* renamed from: com.tencent.mm.plugin.account.ui.EmailVerifyUI$2 */
    class C99142 implements C5244b {
        C99142() {
        }

        public final void aqK() {
            AppMethodBeat.m2504i(124758);
            EmailVerifyUI.this.enableOptionMenu(false);
            AppMethodBeat.m2505o(124758);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.EmailVerifyUI$1 */
    class C99161 implements C5243a {
        C99161() {
        }

        /* renamed from: wr */
        public final void mo10754wr(String str) {
            AppMethodBeat.m2504i(124757);
            EmailVerifyUI.this.enableOptionMenu(true);
            EmailVerifyUI.m17556a(EmailVerifyUI.this, str);
            AppMethodBeat.m2505o(124757);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.EmailVerifyUI$3 */
    class C99173 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.ui.EmailVerifyUI$3$1 */
        class C99121 implements DialogInterface.OnClickListener {
            C99121() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(124760);
                final C1207m c9881z = new C9881z(EmailVerifyUI.this.gAK, EmailVerifyUI.this.gAM);
                C1720g.m3540Rg().mo14541a(c9881z, 0);
                EmailVerifyUI emailVerifyUI = EmailVerifyUI.this;
                Context context = EmailVerifyUI.this;
                EmailVerifyUI.this.getString(C25738R.string.f9238tz);
                emailVerifyUI.ehJ = C30379h.m48458b(context, EmailVerifyUI.this.getString(C25738R.string.dkk), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(124759);
                        C1720g.m3540Rg().mo14547c(c9881z);
                        AppMethodBeat.m2505o(124759);
                    }
                });
                AppMethodBeat.m2505o(124760);
            }
        }

        C99173() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124761);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R500_250,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R500_250")).append(",3").toString());
            C30379h.m48428a(EmailVerifyUI.this, (int) C25738R.string.dkc, (int) C25738R.string.dk3, (int) C25738R.string.f9187s6, (int) C25738R.string.f9076or, new C99121(), null);
            AppMethodBeat.m2505o(124761);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.EmailVerifyUI$4 */
    class C99184 implements OnClickListener {
        C99184() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124762);
            C5046bo.m7506M(EmailVerifyUI.this, EmailVerifyUI.this.gAL);
            AppMethodBeat.m2505o(124762);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.EmailVerifyUI$5 */
    class C99195 implements OnMenuItemClickListener {
        C99195() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124763);
            EmailVerifyUI.m17560d(EmailVerifyUI.this);
            AppMethodBeat.m2505o(124763);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.EmailVerifyUI$6 */
    class C99206 implements OnMenuItemClickListener {
        C99206() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124764);
            EmailVerifyUI.this.gAN = EmailVerifyUI.this.gAH.getText();
            if (C5046bo.isNullOrNil(EmailVerifyUI.this.gAN) || EmailVerifyUI.this.gAN.length() != 12) {
                EmailVerifyUI.this.enableOptionMenu(false);
            } else {
                EmailVerifyUI.m17556a(EmailVerifyUI.this, EmailVerifyUI.this.gAN);
            }
            AppMethodBeat.m2505o(124764);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: d */
    static /* synthetic */ void m17560d(EmailVerifyUI emailVerifyUI) {
        AppMethodBeat.m2504i(124774);
        emailVerifyUI.goBack();
        AppMethodBeat.m2505o(124774);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124766);
        super.onCreate(bundle);
        initView();
        this.gsF = C42756a.m75794FP();
        AppMethodBeat.m2505o(124766);
    }

    public void onResume() {
        AppMethodBeat.m2504i(124767);
        super.onResume();
        C1720g.m3540Rg().mo14539a((int) C42475m.CTRL_INDEX, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R500_200,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R500_200")).append(",1").toString());
        C42756a.m75798wz("R500_200");
        AppMethodBeat.m2505o(124767);
    }

    public void onPause() {
        AppMethodBeat.m2504i(124768);
        super.onPause();
        C1720g.m3540Rg().mo14546b((int) C42475m.CTRL_INDEX, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R500_200,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R500_200")).append(",2").toString());
        AppMethodBeat.m2505o(124768);
    }

    public final int getLayoutId() {
        return 2130970985;
    }

    public final void initView() {
        AppMethodBeat.m2504i(124769);
        setMMTitle((int) C25738R.string.dkl);
        this.gAF = (TextView) findViewById(2131828394);
        this.gAF.setText(Html.fromHtml(getString(C25738R.string.dk5)));
        this.gAG = (TextView) findViewById(2131828395);
        this.gAK = getIntent().getStringExtra("email_address");
        if (C5046bo.isNullOrNil(this.gAK)) {
            C4990ab.m7420w("MicroMsg.EmailVerifyUI", "email add is null or nill");
        } else {
            this.gAG.setText(this.gAK);
        }
        this.gAM = getIntent().getStringExtra("password");
        this.gAL = getIntent().getStringExtra("email_login_page");
        C4990ab.m7417i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", this.gAK, this.gAL);
        this.gAH = (MMAutoSwitchEditTextView) findViewById(2131828396);
        this.gAH.setOnInputFinished(new C99161());
        this.gAH.setOnTextChanged(new C99142());
        this.gAJ = (Button) findViewById(2131828398);
        this.gAJ.setOnClickListener(new C99173());
        this.gAI = (Button) findViewById(2131828397);
        if (C5046bo.isNullOrNil(this.gAL) || C5046bo.isNullOrNil(this.gAK)) {
            this.gAI.setVisibility(8);
        } else {
            this.gAI.setVisibility(0);
            this.gAI.setOnClickListener(new C99184());
        }
        setBackBtn(new C99195());
        addTextOptionMenu(0, getString(C25738R.string.f9182s1), new C99206());
        enableOptionMenu(false);
        AppMethodBeat.m2505o(124769);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(124770);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(124770);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(124770);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(124771);
        C42756a.m75796wA(this.gsF);
        finish();
        AppMethodBeat.m2505o(124771);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124772);
        C4990ab.m7416i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        this.gAO = false;
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (c1207m.getType() != C42475m.CTRL_INDEX) {
            C4990ab.m7413e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", Integer.valueOf(c1207m.getType()));
            AppMethodBeat.m2505o(124772);
            return;
        }
        int i3 = ((C1986a) ((C9881z) c1207m).ftU.acF()).gvF.vIJ;
        StringBuilder stringBuilder;
        if (i != 0 || i2 != 0) {
            int i4;
            if (!C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
                switch (i2) {
                    case -34:
                        Toast.makeText(this, C25738R.string.dk1, 0).show();
                        i4 = 1;
                        break;
                    case -33:
                        C30379h.m48431a((Context) this, (int) C25738R.string.dk2, (int) C25738R.string.dk3, null);
                        i4 = 1;
                        break;
                    case -32:
                        C30379h.m48431a((Context) this, (int) C25738R.string.dk4, (int) C25738R.string.dk3, null);
                        stringBuilder = new StringBuilder();
                        C1720g.m3534RN();
                        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R500_260,");
                        C1720g.m3534RN();
                        C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R500_260")).append(",3").toString());
                        i4 = 1;
                        break;
                    default:
                        boolean i42 = false;
                        break;
                }
            }
            i42 = 1;
            if (i42 != 0) {
                AppMethodBeat.m2505o(124772);
            } else if (i3 == 2) {
                Toast.makeText(this, getString(C25738R.string.dkm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                AppMethodBeat.m2505o(124772);
            } else {
                if (i3 == 1) {
                    Toast.makeText(this, getString(C25738R.string.dkd, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
                AppMethodBeat.m2505o(124772);
            }
        } else if (i3 == 2) {
            C42756a.m75796wA("R200_900_email");
            Intent intent = new Intent(this, RegSetInfoUI.class);
            intent.putExtra("regsetinfo_ticket", ((C1987b) ((C9881z) c1207m).ftU.mo5618ZS()).gvG.wdB);
            intent.putExtra("regsetinfo_user", this.gAK);
            intent.putExtra("regsetinfo_ismobile", 3);
            intent.putExtra("regsetinfo_NextStyle", ((C9881z) c1207m).ajx());
            intent.putExtra("regsetinfo_pwd", this.gAM);
            intent.putExtra("regsetinfo_bind_email", this.gAK);
            startActivity(intent);
            AppMethodBeat.m2505o(124772);
        } else if (i3 == 1) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R22_resend_email_code_alert,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R22_resend_email_code_alert")).append(",3").toString());
            C30379h.m48465bQ(this, getString(C25738R.string.dke));
            AppMethodBeat.m2505o(124772);
        } else {
            C4990ab.m7412e("MicroMsg.EmailVerifyUI", "err opcode");
            AppMethodBeat.m2505o(124772);
        }
    }
}
