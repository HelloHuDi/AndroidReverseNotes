package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.au.b;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

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
    private i gro;
    private TextView gsf;
    private Button gsg;
    private TextView gsh;
    private TextView gsi;
    private CheckBox gsj;
    private CheckBox gsk;
    private LinearLayout gsl;
    private ImageView gsm;
    private boolean gsn;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void k(BindMobileUI bindMobileUI) {
        AppMethodBeat.i(13526);
        bindMobileUI.exit(-1);
        AppMethodBeat.o(13526);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13516);
        super.onCreate(bundle);
        setMMTitle((int) R.string.a76);
        this.fHE = bo.bc(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bo.bc(getIntent().getStringExtra("couttry_code"), "");
        this.grJ = bo.bc(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.grY = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.grZ = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.gsn = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
        initView();
        AppMethodBeat.o(13516);
    }

    public void onDestroy() {
        AppMethodBeat.i(13517);
        super.onDestroy();
        if (this.gro != null) {
            this.gro.recycle();
        }
        AppMethodBeat.o(13517);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13518);
        if (i == 4) {
            Ni(1);
            AppMethodBeat.o(13518);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13518);
        return onKeyDown;
    }

    public final void initView() {
        AppMethodBeat.i(13519);
        this.grE = (EditText) findViewById(R.id.a50);
        this.grF = (LinearLayout) findViewById(R.id.a4x);
        this.grH = (TextView) findViewById(R.id.a4z);
        this.grI = (TextView) findViewById(R.id.a4y);
        this.gsf = (TextView) findViewById(R.id.a4w);
        this.gsg = (Button) findViewById(R.id.a51);
        this.gsh = (TextView) findViewById(R.id.a57);
        this.gsf.setText(getString(R.string.a72));
        this.gsi = (TextView) findViewById(R.id.a55);
        this.gsl = (LinearLayout) findViewById(R.id.a52);
        this.gsk = (CheckBox) findViewById(R.id.a54);
        this.gsj = (CheckBox) findViewById(R.id.a53);
        this.gsm = (ImageView) findViewById(R.id.a4v);
        if (this.grY != null) {
            if (this.grY.title != null && this.grY.title.length() > 0) {
                this.gsf.setText(this.grY.title);
            }
            if (this.grY.content != null && this.grY.content.length() > 0) {
                this.gsi.setText(this.grY.content);
            }
            switch (this.grY.bWu.intValue()) {
                case 0:
                    this.gsm.setImageResource(R.drawable.ab8);
                    break;
                case 1:
                    this.gsm.setImageResource(R.drawable.aba);
                    break;
                case 2:
                    this.gsm.setImageResource(R.drawable.ab9);
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
        this.gsg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13510);
                if (BindMobileUI.this.grE.getText().toString() == null || BindMobileUI.this.grE.getText().toString().length() == 0) {
                    Toast.makeText(BindMobileUI.this, BindMobileUI.this.getString(R.string.a6j), 0).show();
                    AppMethodBeat.o(13510);
                    return;
                }
                BindMobileUI.this.cFl = BindMobileUI.this.grI.getText().toString().trim() + bo.PA(BindMobileUI.this.grE.getText().toString());
                ab.i("MicroMsg.BindMContactUI", "do next, send sms to self");
                BindMobileUI.c(BindMobileUI.this, BindMobileUI.this.cFl);
                AppMethodBeat.o(13510);
            }
        });
        this.gsh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13511);
                BindMobileUI.d(BindMobileUI.this);
                AppMethodBeat.o(13511);
            }
        });
        if (this.gsn) {
            setMMTitle((int) R.string.a67);
            this.gsm.setVisibility(8);
            this.gsf.setText(R.string.a6r);
            this.gsl.setVisibility(8);
            this.gsk.setVisibility(8);
            this.gsk.setChecked(false);
            this.gsj.setVisibility(0);
            this.gsj.setChecked(false);
            this.gsi.setVisibility(8);
            this.gsi.setText(getString(R.string.a69));
            this.gsh.setVisibility(8);
            this.gsg.setText(R.string.a67);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(13512);
                    BindMobileUI.e(BindMobileUI.this);
                    AppMethodBeat.o(13512);
                    return true;
                }
            });
        }
        this.grF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13513);
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMobileUI.this.fHE);
                intent.putExtra("couttry_code", BindMobileUI.this.countryCode);
                a.gkE.b(intent, BindMobileUI.this);
                AppMethodBeat.o(13513);
            }
        });
        this.grF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13514);
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMobileUI.this.fHE);
                intent.putExtra("couttry_code", BindMobileUI.this.countryCode);
                a.gkE.b(intent, BindMobileUI.this);
                AppMethodBeat.o(13514);
            }
        });
        AppMethodBeat.o(13519);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(13520);
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.fHE = bo.bc(intent.getStringExtra("country_name"), "");
                this.countryCode = bo.bc(intent.getStringExtra("couttry_code"), "");
                if (!this.fHE.equals("")) {
                    this.grH.setText(this.fHE);
                }
                if (!this.countryCode.equals("")) {
                    this.grI.setText("+" + this.countryCode);
                    break;
                }
                break;
        }
        AppMethodBeat.o(13520);
    }

    private void apc() {
        AppMethodBeat.i(13521);
        if (bo.isNullOrNil(this.fHE) && bo.isNullOrNil(this.countryCode)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            ab.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(simCountryIso)));
            if (bo.isNullOrNil(simCountryIso)) {
                ab.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
                AppMethodBeat.o(13521);
                return;
            }
            b.a k = b.k(this, simCountryIso, getString(R.string.b3_));
            if (k == null) {
                ab.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
                AppMethodBeat.o(13521);
                return;
            }
            this.fHE = k.fHE;
            this.countryCode = k.fHD;
            AppMethodBeat.o(13521);
            return;
        }
        AppMethodBeat.o(13521);
    }

    public final int getLayoutId() {
        return R.layout.ga;
    }

    static /* synthetic */ void a(BindMobileUI bindMobileUI, final String str) {
        AppMethodBeat.i(13522);
        if (bindMobileUI.gro == null) {
            bindMobileUI.gro = new i(i.b.BINDMOBILE, bindMobileUI, new i.a() {
                public final void e(int i, Bundle bundle) {
                    boolean z = true;
                    AppMethodBeat.i(13515);
                    if (i != 2) {
                        if (i == 1) {
                            BindMobileUI.d(BindMobileUI.this, str);
                        }
                        AppMethodBeat.o(13515);
                    } else if (BindMobileUI.this.gsn) {
                        BindMobileUI bindMobileUI = BindMobileUI.this;
                        boolean z2 = !BindMobileUI.this.gsj.isChecked();
                        if (BindMobileUI.this.gsk.isChecked()) {
                            z = false;
                        }
                        BindMobileStatusUI.c(bindMobileUI, z2, z);
                        BindMobileUI.k(BindMobileUI.this);
                        AppMethodBeat.o(13515);
                    } else {
                        Intent intent = new Intent(BindMobileUI.this, BindMobileStatusUI.class);
                        intent.putExtra("kstyle_bind_wording", BindMobileUI.this.grY);
                        intent.putExtra("kstyle_bind_recommend_show", BindMobileUI.this.grZ);
                        intent.putExtra("Kfind_friend_by_mobile_flag", BindMobileUI.this.gsj.isChecked());
                        intent.putExtra("Krecom_friends_by_mobile_flag", BindMobileUI.this.gsk.isChecked());
                        MMWizardActivity.J(BindMobileUI.this, intent);
                        AppMethodBeat.o(13515);
                    }
                }
            });
        }
        bindMobileUI.gro.wn(str);
        if (bindMobileUI.gsn) {
            bindMobileUI.gro.gys = false;
        }
        AppMethodBeat.o(13522);
    }

    static /* synthetic */ void c(BindMobileUI bindMobileUI, final String str) {
        AppMethodBeat.i(13523);
        String string = bindMobileUI.mController.ylL.getString(R.string.a7w);
        h.a(bindMobileUI.mController.ylL, String.format("%s\n%s", new Object[]{bindMobileUI.mController.ylL.getString(R.string.a7x), str}), string, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(13509);
                BindMobileUI.a(BindMobileUI.this, str);
                AppMethodBeat.o(13509);
            }
        }, null);
        AppMethodBeat.o(13523);
    }

    static /* synthetic */ void d(BindMobileUI bindMobileUI) {
        AppMethodBeat.i(13524);
        bindMobileUI.Ni(1);
        AppMethodBeat.o(13524);
    }

    static /* synthetic */ void e(BindMobileUI bindMobileUI) {
        AppMethodBeat.i(13525);
        bindMobileUI.Ni(1);
        AppMethodBeat.o(13525);
    }

    static /* synthetic */ void d(BindMobileUI bindMobileUI, String str) {
        AppMethodBeat.i(13527);
        Intent intent = new Intent(bindMobileUI, BindMobileVerifyUI.class);
        intent.putExtra("bindmcontact_mobile", str);
        intent.putExtra("kstyle_bind_wording", bindMobileUI.grY);
        intent.putExtra("kstyle_bind_recommend_show", bindMobileUI.grZ);
        intent.putExtra("Kfind_friend_by_mobile_flag", bindMobileUI.gsj.isChecked());
        intent.putExtra("Krecom_friends_by_mobile_flag", bindMobileUI.gsk.isChecked());
        if (bindMobileUI.gsn) {
            intent.putExtra("bind_scene", 6);
        }
        MMWizardActivity.J(bindMobileUI, intent);
        AppMethodBeat.o(13527);
    }
}
