package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMAutoCompleteTextView;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C32890j;
import com.tencent.p177mm.plugin.account.friend.p272a.C9881z;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C42475m;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI */
public class RegByEmailUI extends MMActivity implements C1202f {
    private static String[] gFE;
    private String dtV;
    private ProgressDialog ehJ = null;
    private EditText gFA;
    private CheckBox gFB;
    private String gFC;
    private Map<String, String> gFD;
    private MMAutoCompleteTextView gFz;
    private String gsF;
    private String guf;

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$4 */
    class C188964 implements OnClickListener {
        C188964() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125304);
            RegByEmailUI.this.finish();
            C42756a.m75796wA("L2_signup");
            Intent intent = new Intent(RegByEmailUI.this, LoginPasswordUI.class);
            intent.putExtra("email_address", RegByEmailUI.this.dtV);
            RegByEmailUI.this.startActivity(intent);
            AppMethodBeat.m2505o(125304);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$5 */
    class C188975 implements View.OnClickListener {
        C188975() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125305);
            C5046bo.m7506M(RegByEmailUI.this, RegByEmailUI.this.getString(C25738R.string.ezj));
            AppMethodBeat.m2505o(125305);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$6 */
    class C188986 implements OnCheckedChangeListener {
        C188986() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(125306);
            RegByEmailUI.m64421b(RegByEmailUI.this);
            AppMethodBeat.m2505o(125306);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$7 */
    class C188997 implements OnMenuItemClickListener {
        C188997() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125307);
            RegByEmailUI.m64422c(RegByEmailUI.this);
            AppMethodBeat.m2505o(125307);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$8 */
    class C189008 implements TextWatcher {
        C189008() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125308);
            RegByEmailUI.m64421b(RegByEmailUI.this);
            AppMethodBeat.m2505o(125308);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$11 */
    class C3807111 implements OnKeyListener {
        C3807111() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125311);
            if (66 != i || keyEvent.getAction() != 0) {
                AppMethodBeat.m2505o(125311);
                return false;
            } else if (RegByEmailUI.this.gFB.isChecked()) {
                RegByEmailUI.m64422c(RegByEmailUI.this);
                AppMethodBeat.m2505o(125311);
                return true;
            } else {
                AppMethodBeat.m2505o(125311);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$1 */
    class C380721 implements Runnable {
        C380721() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125301);
            RegByEmailUI.this.gFA.requestFocus();
            AppMethodBeat.m2505o(125301);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$2 */
    class C380732 implements OnClickListener {
        C380732() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125302);
            C42756a.m75796wA(RegByEmailUI.this.gsF);
            RegByEmailUI.this.aqX();
            RegByEmailUI.this.finish();
            AppMethodBeat.m2505o(125302);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$9 */
    class C380759 implements TextWatcher {
        C380759() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125309);
            RegByEmailUI.m64421b(RegByEmailUI.this);
            AppMethodBeat.m2505o(125309);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$10 */
    class C3807610 implements OnEditorActionListener {
        C3807610() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125310);
            if (i != 6 && i != 5) {
                AppMethodBeat.m2505o(125310);
                return false;
            } else if (RegByEmailUI.this.gFB.isChecked()) {
                RegByEmailUI.m64422c(RegByEmailUI.this);
                AppMethodBeat.m2505o(125310);
                return true;
            } else {
                AppMethodBeat.m2505o(125310);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByEmailUI$12 */
    class C3807712 implements OnMenuItemClickListener {
        C3807712() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125312);
            RegByEmailUI.m64424e(RegByEmailUI.this);
            AppMethodBeat.m2505o(125312);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: e */
    static /* synthetic */ void m64424e(RegByEmailUI regByEmailUI) {
        AppMethodBeat.m2504i(125322);
        regByEmailUI.goBack();
        AppMethodBeat.m2505o(125322);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125313);
        super.onCreate(bundle);
        String string = getString(C25738R.string.dkf);
        if (C7243d.vxr) {
            string = getString(C25738R.string.f9176ru) + getString(C25738R.string.f8807fk);
        }
        setMMTitle(string);
        C24679a.gkF.mo38846BV();
        this.gFC = C26529w.m42363ct(this);
        C4990ab.m7417i("MicroMsg.RegByEmailUI", "get google account:[%s]", this.gFC);
        this.gFD = C32890j.ghe.mo53458cl(this);
        if (!(this.gFD == null || this.gFD.isEmpty())) {
            gFE = new String[this.gFD.size()];
            this.gFD.keySet().toArray(gFE);
        }
        this.gsF = C42756a.m75794FP();
        initView();
        AppMethodBeat.m2505o(125313);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125314);
        super.onResume();
        C1720g.m3540Rg().mo14539a((int) C42475m.CTRL_INDEX, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R500_100,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R500_100")).append(",1").toString());
        C42756a.m75798wz("R500_100");
        AppMethodBeat.m2505o(125314);
    }

    public void onPause() {
        AppMethodBeat.m2504i(125315);
        super.onPause();
        C1720g.m3540Rg().mo14546b((int) C42475m.CTRL_INDEX, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R500_100,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R500_100")).append(",2").toString());
        AppMethodBeat.m2505o(125315);
    }

    public final int getLayoutId() {
        return 2130970492;
    }

    public final void initView() {
        AppMethodBeat.m2504i(125316);
        this.gFz = (MMAutoCompleteTextView) findViewById(2131826915);
        this.gFA = (EditText) findViewById(2131826916);
        this.gFB = (CheckBox) findViewById(2131826066);
        if (!C5046bo.isNullOrNil(this.gFC)) {
            this.gFA.postDelayed(new C380721(), 500);
            this.gFz.setText(this.gFC);
        }
        if (gFE != null) {
            C33038c c33038c = new C33038c(this, gFE, "@");
            this.gFz.setSpilter("@");
            this.gFz.setDropDownAnchor(2131826914);
            this.gFz.setDropDownVerticalOffset(this.gFz.getPaddingBottom());
            this.gFz.setAdapter(c33038c);
        }
        findViewById(2131826067).setOnClickListener(new C188975());
        this.gFB.setOnCheckedChangeListener(new C188986());
        addTextOptionMenu(0, getString(C25738R.string.f9182s1), new C188997());
        enableOptionMenu(false);
        this.gFz.addTextChangedListener(new C189008());
        this.gFA.addTextChangedListener(new C380759());
        this.gFA.setOnEditorActionListener(new C3807610());
        this.gFA.setOnKeyListener(new C3807111());
        setBackBtn(new C3807712());
        AppMethodBeat.m2505o(125316);
    }

    private void goBack() {
        AppMethodBeat.m2504i(125317);
        C30379h.m48428a((Context) this, (int) C25738R.string.dk0, (int) C25738R.string.dk3, (int) C25738R.string.f9187s6, (int) C25738R.string.f9076or, new C380732(), null);
        AppMethodBeat.m2505o(125317);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125318);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(125318);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125318);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125319);
        C4990ab.m7416i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (c1207m.getType() != C42475m.CTRL_INDEX) {
            C4990ab.m7413e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", Integer.valueOf(c1207m.getType()));
            AppMethodBeat.m2505o(125319);
        } else if (i == 0 && i2 == 0) {
            C42756a.m75796wA("R500_200");
            Intent intent = new Intent(this, EmailVerifyUI.class);
            intent.putExtra("email_address", this.dtV);
            intent.putExtra("password", this.guf);
            if (!(this.gFD == null || this.gFD.isEmpty())) {
                String[] split = this.dtV.split("@");
                if (split != null && split.length == 2) {
                    intent.putExtra("email_login_page", (String) this.gFD.get(split[1]));
                }
            }
            startActivity(intent);
            AppMethodBeat.m2505o(125319);
        } else {
            int i3;
            if (!C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
                switch (i2) {
                    case -111:
                        C30379h.m48467g(this, C25738R.string.dk6, C25738R.string.dk3);
                        i3 = 1;
                        break;
                    case -75:
                        C30379h.m48467g(this, C25738R.string.f8810fn, C25738R.string.djw);
                        i3 = 1;
                        break;
                    case -34:
                        Toast.makeText(this, C25738R.string.dk1, 0).show();
                        i3 = 1;
                        break;
                    case -7:
                        StringBuilder stringBuilder = new StringBuilder();
                        C1720g.m3534RN();
                        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R20_email_duplicate_confirm,");
                        C1720g.m3534RN();
                        C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R20_email_duplicate_confirm")).append(",3").toString());
                        C30379h.m48428a((Context) this, (int) C25738R.string.dkg, (int) C25738R.string.dk3, (int) C25738R.string.dki, (int) C25738R.string.dkh, new C188964(), null);
                        i3 = 1;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
            }
            i3 = 1;
            if (i3 != 0) {
                AppMethodBeat.m2505o(125319);
                return;
            }
            if (!C5046bo.isNullOrNil(str)) {
                Map z = C5049br.m7595z(str, "e");
                if (z != null && z.size() > 0) {
                    String str2 = (String) z.get(".e.Content");
                    if (!C5046bo.isNullOrNil(str2)) {
                        C30379h.m48461b((Context) this, str2, getString(C25738R.string.dk3), true);
                        AppMethodBeat.m2505o(125319);
                        return;
                    }
                }
            }
            Toast.makeText(this, getString(C25738R.string.dkd, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(125319);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m64421b(RegByEmailUI regByEmailUI) {
        AppMethodBeat.m2504i(125320);
        if (C5046bo.isNullOrNil(regByEmailUI.gFz.getText().toString().trim()) || C5046bo.isNullOrNil(regByEmailUI.gFA.getText().toString().trim()) || !regByEmailUI.gFB.isChecked()) {
            regByEmailUI.enableOptionMenu(false);
            AppMethodBeat.m2505o(125320);
            return;
        }
        regByEmailUI.enableOptionMenu(true);
        AppMethodBeat.m2505o(125320);
    }

    /* renamed from: c */
    static /* synthetic */ void m64422c(RegByEmailUI regByEmailUI) {
        AppMethodBeat.m2504i(125321);
        regByEmailUI.dtV = regByEmailUI.gFz.getText().toString().trim();
        regByEmailUI.guf = regByEmailUI.gFA.getText().toString();
        if (C5046bo.isNullOrNil(regByEmailUI.dtV)) {
            C30379h.m48467g(regByEmailUI, C25738R.string.dk7, C25738R.string.dk3);
            AppMethodBeat.m2505o(125321);
        } else if (!C5046bo.amW(regByEmailUI.dtV)) {
            C30379h.m48467g(regByEmailUI, C25738R.string.dk6, C25738R.string.dk3);
            AppMethodBeat.m2505o(125321);
        } else if (C5046bo.isNullOrNil(regByEmailUI.guf)) {
            C30379h.m48467g(regByEmailUI, C25738R.string.dk8, C25738R.string.dk3);
            AppMethodBeat.m2505o(125321);
        } else if (C5046bo.amY(regByEmailUI.guf)) {
            regByEmailUI.aqX();
            final C1207m c9881z = new C9881z(regByEmailUI.dtV, regByEmailUI.guf);
            C1720g.m3540Rg().mo14541a(c9881z, 0);
            regByEmailUI.getString(C25738R.string.f9238tz);
            regByEmailUI.ehJ = C30379h.m48458b((Context) regByEmailUI, regByEmailUI.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125303);
                    C1720g.m3540Rg().mo14547c(c9881z);
                    AppMethodBeat.m2505o(125303);
                }
            });
            AppMethodBeat.m2505o(125321);
        } else {
            C30379h.m48467g(regByEmailUI, C25738R.string.f0t, C25738R.string.dk3);
            AppMethodBeat.m2505o(125321);
        }
    }
}
