package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelsimple.BindWordingContent;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1179au.C17950b.C17951a;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i.C6726a;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i.C6727b;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileUI */
public class BindMobileUI extends MMWizardActivity {
    private String cFl;
    private String countryCode = null;
    private String fHE = null;
    private EditText grE;
    private LinearLayout grF;
    private TextView grH;
    private TextView grI;
    private String grJ = null;
    private BindWordingContent grY;
    private int grZ;
    private C6725i gro;
    private TextView gsf;
    private Button gsg;
    private TextView gsh;
    private TextView gsi;
    private CheckBox gsj;
    private CheckBox gsk;
    private LinearLayout gsl;
    private ImageView gsm;
    private boolean gsn;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileUI$4 */
    class C188024 implements OnMenuItemClickListener {
        C188024() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13512);
            BindMobileUI.m42395e(BindMobileUI.this);
            AppMethodBeat.m2505o(13512);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileUI$6 */
    class C188036 implements OnClickListener {
        C188036() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13514);
            Intent intent = new Intent();
            intent.putExtra("country_name", BindMobileUI.this.fHE);
            intent.putExtra("couttry_code", BindMobileUI.this.countryCode);
            C24679a.gkE.mo38903b(intent, BindMobileUI.this);
            AppMethodBeat.m2505o(13514);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileUI$5 */
    class C265525 implements OnClickListener {
        C265525() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13513);
            Intent intent = new Intent();
            intent.putExtra("country_name", BindMobileUI.this.fHE);
            intent.putExtra("couttry_code", BindMobileUI.this.countryCode);
            C24679a.gkE.mo38903b(intent, BindMobileUI.this);
            AppMethodBeat.m2505o(13513);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileUI$2 */
    class C265552 implements OnClickListener {
        C265552() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13510);
            if (BindMobileUI.this.grE.getText().toString() == null || BindMobileUI.this.grE.getText().toString().length() == 0) {
                Toast.makeText(BindMobileUI.this, BindMobileUI.this.getString(C25738R.string.a6j), 0).show();
                AppMethodBeat.m2505o(13510);
                return;
            }
            BindMobileUI.this.cFl = BindMobileUI.this.grI.getText().toString().trim() + C5046bo.m7509PA(BindMobileUI.this.grE.getText().toString());
            C4990ab.m7416i("MicroMsg.BindMContactUI", "do next, send sms to self");
            BindMobileUI.m42392c(BindMobileUI.this, BindMobileUI.this.cFl);
            AppMethodBeat.m2505o(13510);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileUI$3 */
    class C265563 implements OnClickListener {
        C265563() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13511);
            BindMobileUI.m42393d(BindMobileUI.this);
            AppMethodBeat.m2505o(13511);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: k */
    static /* synthetic */ void m42401k(BindMobileUI bindMobileUI) {
        AppMethodBeat.m2504i(13526);
        bindMobileUI.exit(-1);
        AppMethodBeat.m2505o(13526);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13516);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.a76);
        this.fHE = C5046bo.m7532bc(getIntent().getStringExtra("country_name"), "");
        this.countryCode = C5046bo.m7532bc(getIntent().getStringExtra("couttry_code"), "");
        this.grJ = C5046bo.m7532bc(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.grY = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.grZ = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.gsn = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
        initView();
        AppMethodBeat.m2505o(13516);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13517);
        super.onDestroy();
        if (this.gro != null) {
            this.gro.recycle();
        }
        AppMethodBeat.m2505o(13517);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13518);
        if (i == 4) {
            mo27541Ni(1);
            AppMethodBeat.m2505o(13518);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13518);
        return onKeyDown;
    }

    public final void initView() {
        AppMethodBeat.m2504i(13519);
        this.grE = (EditText) findViewById(2131821729);
        this.grF = (LinearLayout) findViewById(2131821726);
        this.grH = (TextView) findViewById(2131821728);
        this.grI = (TextView) findViewById(2131821727);
        this.gsf = (TextView) findViewById(2131821725);
        this.gsg = (Button) findViewById(2131821730);
        this.gsh = (TextView) findViewById(2131821736);
        this.gsf.setText(getString(C25738R.string.a72));
        this.gsi = (TextView) findViewById(2131821734);
        this.gsl = (LinearLayout) findViewById(2131821731);
        this.gsk = (CheckBox) findViewById(2131821733);
        this.gsj = (CheckBox) findViewById(2131821732);
        this.gsm = (ImageView) findViewById(2131821724);
        if (this.grY != null) {
            if (this.grY.title != null && this.grY.title.length() > 0) {
                this.gsf.setText(this.grY.title);
            }
            if (this.grY.content != null && this.grY.content.length() > 0) {
                this.gsi.setText(this.grY.content);
            }
            switch (this.grY.bWu.intValue()) {
                case 0:
                    this.gsm.setImageResource(C25738R.drawable.ab8);
                    break;
                case 1:
                    this.gsm.setImageResource(C25738R.drawable.aba);
                    break;
                case 2:
                    this.gsm.setImageResource(C25738R.drawable.ab9);
                    break;
            }
        }
        switch (this.grZ) {
            case 0:
                this.gsl.setVisibility(0);
                this.gsk.setVisibility(0);
                this.gsi.setVisibility(8);
                break;
            case 1:
                this.gsl.setVisibility(8);
                this.gsk.setVisibility(8);
                this.gsi.setVisibility(0);
                break;
        }
        apc();
        if (!(this.fHE == null || this.fHE.equals(""))) {
            this.grH.setText(this.fHE);
        }
        if (!(this.countryCode == null || this.countryCode.equals(""))) {
            this.grI.setText("+" + this.countryCode);
        }
        if (!(this.grJ == null || this.grJ.equals(""))) {
            this.grE.setText(this.grJ);
        }
        this.gsg.setOnClickListener(new C265552());
        this.gsh.setOnClickListener(new C265563());
        if (this.gsn) {
            setMMTitle((int) C25738R.string.a67);
            this.gsm.setVisibility(8);
            this.gsf.setText(C25738R.string.a6r);
            this.gsl.setVisibility(8);
            this.gsk.setVisibility(8);
            this.gsk.setChecked(false);
            this.gsj.setVisibility(0);
            this.gsj.setChecked(false);
            this.gsi.setVisibility(8);
            this.gsi.setText(getString(C25738R.string.a69));
            this.gsh.setVisibility(8);
            this.gsg.setText(C25738R.string.a67);
            setBackBtn(new C188024());
        }
        this.grF.setOnClickListener(new C265525());
        this.grF.setOnClickListener(new C188036());
        AppMethodBeat.m2505o(13519);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(13520);
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
        AppMethodBeat.m2505o(13520);
    }

    private void apc() {
        AppMethodBeat.m2504i(13521);
        if (C5046bo.isNullOrNil(this.fHE) && C5046bo.isNullOrNil(this.countryCode)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            C4990ab.m7410d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(simCountryIso)));
            if (C5046bo.isNullOrNil(simCountryIso)) {
                C4990ab.m7412e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
                AppMethodBeat.m2505o(13521);
                return;
            }
            C17951a k = C17950b.m28210k(this, simCountryIso, getString(C25738R.string.b3_));
            if (k == null) {
                C4990ab.m7412e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
                AppMethodBeat.m2505o(13521);
                return;
            }
            this.fHE = k.fHE;
            this.countryCode = k.fHD;
            AppMethodBeat.m2505o(13521);
            return;
        }
        AppMethodBeat.m2505o(13521);
    }

    public final int getLayoutId() {
        return 2130968835;
    }

    /* renamed from: a */
    static /* synthetic */ void m42388a(BindMobileUI bindMobileUI, final String str) {
        AppMethodBeat.m2504i(13522);
        if (bindMobileUI.gro == null) {
            bindMobileUI.gro = new C6725i(C6727b.BINDMOBILE, bindMobileUI, new C6726a() {
                /* renamed from: e */
                public final void mo14957e(int i, Bundle bundle) {
                    boolean z = true;
                    AppMethodBeat.m2504i(13515);
                    if (i != 2) {
                        if (i == 1) {
                            BindMobileUI.m42394d(BindMobileUI.this, str);
                        }
                        AppMethodBeat.m2505o(13515);
                    } else if (BindMobileUI.this.gsn) {
                        BindMobileUI bindMobileUI = BindMobileUI.this;
                        boolean z2 = !BindMobileUI.this.gsj.isChecked();
                        if (BindMobileUI.this.gsk.isChecked()) {
                            z = false;
                        }
                        BindMobileStatusUI.m83832c(bindMobileUI, z2, z);
                        BindMobileUI.m42401k(BindMobileUI.this);
                        AppMethodBeat.m2505o(13515);
                    } else {
                        Intent intent = new Intent(BindMobileUI.this, BindMobileStatusUI.class);
                        intent.putExtra("kstyle_bind_wording", BindMobileUI.this.grY);
                        intent.putExtra("kstyle_bind_recommend_show", BindMobileUI.this.grZ);
                        intent.putExtra("Kfind_friend_by_mobile_flag", BindMobileUI.this.gsj.isChecked());
                        intent.putExtra("Krecom_friends_by_mobile_flag", BindMobileUI.this.gsk.isChecked());
                        MMWizardActivity.m23791J(BindMobileUI.this, intent);
                        AppMethodBeat.m2505o(13515);
                    }
                }
            });
        }
        bindMobileUI.gro.mo14956wn(str);
        if (bindMobileUI.gsn) {
            bindMobileUI.gro.gys = false;
        }
        AppMethodBeat.m2505o(13522);
    }

    /* renamed from: c */
    static /* synthetic */ void m42392c(BindMobileUI bindMobileUI, final String str) {
        AppMethodBeat.m2504i(13523);
        String string = bindMobileUI.mController.ylL.getString(C25738R.string.a7w);
        C30379h.m48440a(bindMobileUI.mController.ylL, String.format("%s\n%s", new Object[]{bindMobileUI.mController.ylL.getString(C25738R.string.a7x), str}), string, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(13509);
                BindMobileUI.m42388a(BindMobileUI.this, str);
                AppMethodBeat.m2505o(13509);
            }
        }, null);
        AppMethodBeat.m2505o(13523);
    }

    /* renamed from: d */
    static /* synthetic */ void m42393d(BindMobileUI bindMobileUI) {
        AppMethodBeat.m2504i(13524);
        bindMobileUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13524);
    }

    /* renamed from: e */
    static /* synthetic */ void m42395e(BindMobileUI bindMobileUI) {
        AppMethodBeat.m2504i(13525);
        bindMobileUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13525);
    }

    /* renamed from: d */
    static /* synthetic */ void m42394d(BindMobileUI bindMobileUI, String str) {
        AppMethodBeat.m2504i(13527);
        Intent intent = new Intent(bindMobileUI, BindMobileVerifyUI.class);
        intent.putExtra("bindmcontact_mobile", str);
        intent.putExtra("kstyle_bind_wording", bindMobileUI.grY);
        intent.putExtra("kstyle_bind_recommend_show", bindMobileUI.grZ);
        intent.putExtra("Kfind_friend_by_mobile_flag", bindMobileUI.gsj.isChecked());
        intent.putExtra("Krecom_friends_by_mobile_flag", bindMobileUI.gsk.isChecked());
        if (bindMobileUI.gsn) {
            intent.putExtra("bind_scene", 6);
        }
        MMWizardActivity.m23791J(bindMobileUI, intent);
        AppMethodBeat.m2505o(13527);
    }
}
