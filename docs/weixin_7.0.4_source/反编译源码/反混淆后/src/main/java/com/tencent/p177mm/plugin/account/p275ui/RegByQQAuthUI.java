package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.modelsimple.C26472s;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.RegByQQAuthUI */
public class RegByQQAuthUI extends MMActivity implements C1202f {
    private String account;
    private String cIR;
    private String cxb;
    private ProgressDialog ehJ = null;
    private EditText gHh = null;
    private int gHi;
    private String guf;

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByQQAuthUI$2 */
    class C77122 implements OnMenuItemClickListener {
        C77122() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125500);
            RegByQQAuthUI.this.aqX();
            RegByQQAuthUI.this.finish();
            AppMethodBeat.m2505o(125500);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByQQAuthUI$1 */
    class C77131 implements OnMenuItemClickListener {
        C77131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125499);
            RegByQQAuthUI.this.cIR = RegByQQAuthUI.this.gHh.getText().toString().trim();
            if (RegByQQAuthUI.this.cIR.equals("")) {
                C30379h.m48467g(RegByQQAuthUI.this, C25738R.string.f0j, C25738R.string.f9109pq);
                AppMethodBeat.m2505o(125499);
            } else {
                final C1207m c26472s = new C26472s("", RegByQQAuthUI.this.guf, RegByQQAuthUI.this.cIR, RegByQQAuthUI.this.gHi, "", "", RegByQQAuthUI.this.cxb, 2);
                C1720g.m3540Rg().mo14541a(c26472s, 0);
                RegByQQAuthUI regByQQAuthUI = RegByQQAuthUI.this;
                Context context = RegByQQAuthUI.this;
                RegByQQAuthUI.this.getString(C25738R.string.f9238tz);
                regByQQAuthUI.ehJ = C30379h.m48458b(context, RegByQQAuthUI.this.getString(C25738R.string.dmm), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(125498);
                        C1720g.m3540Rg().mo14547c(c26472s);
                        AppMethodBeat.m2505o(125498);
                    }
                });
                AppMethodBeat.m2505o(125499);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970500;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125501);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(125501);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125502);
        super.onDestroy();
        AppMethodBeat.m2505o(125502);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125503);
        super.onResume();
        C1720g.m3540Rg().mo14539a(126, (C1202f) this);
        AppMethodBeat.m2505o(125503);
    }

    public void onPause() {
        AppMethodBeat.m2504i(125504);
        super.onPause();
        C1720g.m3540Rg().mo14546b(126, (C1202f) this);
        AppMethodBeat.m2505o(125504);
    }

    public final void initView() {
        AppMethodBeat.m2504i(125505);
        this.gHi = getIntent().getIntExtra("RegByQQ_BindUin", 0);
        this.guf = getIntent().getStringExtra("RegByQQ_RawPsw");
        this.account = getIntent().getStringExtra("RegByQQ_Account");
        this.cxb = getIntent().getStringExtra("RegByQQ_Ticket");
        this.cIR = getIntent().getStringExtra("RegByQQ_Nick");
        C4990ab.m7418v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.gHi + "  pass:" + this.guf + "  ticket:" + this.cxb);
        this.gHh = (EditText) findViewById(2131826954);
        if (!(this.cIR == null || this.cIR.equals(""))) {
            this.gHh.setText(this.cIR);
        }
        setMMTitle((int) C25738R.string.dmf);
        addTextOptionMenu(0, getString(C25738R.string.f9182s1), new C77131());
        setBackBtn(new C77122());
        AppMethodBeat.m2505o(125505);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125506);
        C4990ab.m7416i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!C5046bo.m7544cv(this)) {
            AppMethodBeat.m2505o(125506);
        } else if (i == 0 && i2 == 0) {
            switch (c1207m.getType()) {
                case 126:
                    C1668a.unhold();
                    C6665av.fly.mo14897ak("login_user_name", this.account);
                    Intent intent = new Intent(this, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 1);
                    intent.putExtra("skip", true);
                    Intent bh = C24679a.gkE.mo38909bh(this);
                    bh.addFlags(67108864);
                    bh.putExtra("LauncherUI.enter_from_reg", true);
                    MMWizardActivity.m23792b(this, intent, bh);
                    break;
            }
            AppMethodBeat.m2505o(125506);
        } else {
            int i3;
            if (c1207m.getType() == 126) {
                C42124a jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this, null, null);
                    AppMethodBeat.m2505o(125506);
                    return;
                }
            }
            if (C24679a.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
                i3 = 1;
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -75:
                            C30379h.m48467g(this.mController.ylL, C25738R.string.f8810fn, C25738R.string.f9238tz);
                            i3 = 1;
                            break;
                        case -72:
                            C30379h.m48467g(this.mController.ylL, C25738R.string.dmb, C25738R.string.f9238tz);
                            i3 = 1;
                            break;
                        case -12:
                            C30379h.m48467g(this, C25738R.string.dme, C25738R.string.dmd);
                            i3 = 1;
                            break;
                        case -11:
                            C30379h.m48467g(this, C25738R.string.dmc, C25738R.string.dmd);
                            i3 = 1;
                            break;
                        case -4:
                            C30379h.m48467g(this, C25738R.string.f9107po, C25738R.string.dmd);
                            i3 = 1;
                            break;
                        case -1:
                            if (C1720g.m3540Rg().acS() == 5) {
                                C30379h.m48467g(this, C25738R.string.d5n, C25738R.string.d5m);
                                i3 = 1;
                                break;
                            }
                        case -3:
                            C30379h.m48467g(this, C25738R.string.f9108pp, C25738R.string.dmd);
                            i3 = 1;
                            break;
                    }
                }
                i3 = 0;
            }
            if (i3 != 0) {
                AppMethodBeat.m2505o(125506);
                return;
            }
            Toast.makeText(this, getString(C25738R.string.byf, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(125506);
        }
    }
}
