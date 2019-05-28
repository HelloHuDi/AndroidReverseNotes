package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.plugin.setting.model.C39647d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI */
public class SettingsAliasUI extends MMActivity implements C1202f {
    private String dFl;
    private ProgressDialog ehJ = null;
    private ImageView ejo;
    private TextView ejp;
    private TextView gGA;
    private EditText qmS;
    private C39647d qmT;
    private boolean qmU = false;
    private TextView qmV;
    private C1202f qmb = null;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI$1 */
    class C132101 implements TextWatcher {
        C132101() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(127184);
            SettingsAliasUI settingsAliasUI = SettingsAliasUI.this;
            C46192a c46192a = new C46192a();
            if (charSequence.length() < 6 || charSequence.length() > 20) {
                c46192a.aIm = settingsAliasUI.getString(C25738R.string.f0k);
                c46192a.cxj = false;
            } else if (C5046bo.m7590z(charSequence.charAt(0))) {
                int length = charSequence.length() - 1;
                while (length > 0) {
                    char charAt = charSequence.charAt(length);
                    if (C5046bo.m7590z(charAt) || charAt == '-' || charAt == '_' || C5046bo.m7498A(charAt)) {
                        length--;
                    } else if (Character.isSpace(charAt)) {
                        c46192a.aIm = settingsAliasUI.getString(C25738R.string.f0h);
                        c46192a.cxj = false;
                    } else if (C5046bo.m7587y(charAt)) {
                        c46192a.aIm = settingsAliasUI.getString(C25738R.string.f0f);
                        c46192a.cxj = false;
                    } else {
                        c46192a.aIm = settingsAliasUI.getString(C25738R.string.f0k);
                        c46192a.cxj = false;
                    }
                }
                c46192a.aIm = settingsAliasUI.getString(C25738R.string.d1a);
                c46192a.cxj = true;
            } else {
                c46192a.aIm = settingsAliasUI.getString(C25738R.string.f0i);
                c46192a.cxj = false;
            }
            if (c46192a.cxj) {
                SettingsAliasUI.this.enableOptionMenu(true);
                SettingsAliasUI.this.qmV.setTextColor(SettingsAliasUI.this.getResources().getColorStateList(C25738R.color.f12092s0));
            } else {
                SettingsAliasUI.this.enableOptionMenu(false);
                SettingsAliasUI.this.qmV.setTextColor(SettingsAliasUI.this.getResources().getColorStateList(C25738R.color.f12304ze));
            }
            SettingsAliasUI.this.qmV.setText(c46192a.aIm);
            SettingsAliasUI.this.gGA.setText(SettingsAliasUI.this.getString(C25738R.string.f8813fr, new Object[]{charSequence}));
            AppMethodBeat.m2505o(127184);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI$2 */
    class C132112 implements OnMenuItemClickListener {
        C132112() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127185);
            SettingsAliasUI.this.aqX();
            SettingsAliasUI.this.finish();
            AppMethodBeat.m2505o(127185);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI$4 */
    class C132124 implements OnCancelListener {
        C132124() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(127188);
            if (SettingsAliasUI.this.qmT != null) {
                C1720g.m3540Rg().mo14547c(SettingsAliasUI.this.qmT);
            }
            AppMethodBeat.m2505o(127188);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI$5 */
    class C132135 implements C1202f {
        C132135() {
        }

        public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
            AppMethodBeat.m2504i(127190);
            C4990ab.m7410d("MicroMsg.SettingsAliasUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + c1207m.getType());
            C1720g.m3540Rg().mo14546b(255, SettingsAliasUI.this.qmb);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(127189);
                    if (SettingsAliasUI.this.ehJ != null) {
                        SettingsAliasUI.this.ehJ.dismiss();
                        SettingsAliasUI.this.ehJ = null;
                    }
                    SettingsAliasUI.this.qmb = null;
                    if (c1207m.getType() == 255) {
                        boolean z = (i2 == -3 && i == 4) ? false : true;
                        Intent intent = new Intent(SettingsAliasUI.this, SettingsAliasResultUI.class);
                        intent.putExtra("has_pwd", z);
                        SettingsAliasUI.this.startActivity(intent);
                        SettingsAliasUI.this.finish();
                    }
                    AppMethodBeat.m2505o(127189);
                }
            });
            AppMethodBeat.m2505o(127190);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI$3 */
    class C132153 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI$3$1 */
        class C132161 implements OnClickListener {
            C132161() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(127186);
                SettingsAliasUI.m21222e(SettingsAliasUI.this);
                AppMethodBeat.m2505o(127186);
            }
        }

        C132153() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127187);
            SettingsAliasUI.this.dFl = SettingsAliasUI.this.qmS.getText().toString().trim();
            if (C1853r.m3846Yz().equalsIgnoreCase(SettingsAliasUI.this.dFl)) {
                SettingsAliasUI.this.aqX();
                SettingsAliasUI.this.finish();
                AppMethodBeat.m2505o(127187);
            } else {
                C30379h.m48440a(SettingsAliasUI.this.mController.ylL, SettingsAliasUI.this.getString(C25738R.string.d19, new Object[]{SettingsAliasUI.this.dFl}), SettingsAliasUI.this.getString(C25738R.string.atj), new C132161(), null);
                AppMethodBeat.m2505o(127187);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127191);
        super.onCreate(bundle);
        this.qmU = getIntent().getBooleanExtra("KFromSetAliasTips", false);
        initView();
        C1720g.m3540Rg().mo14539a((int) ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, (C1202f) this);
        AppMethodBeat.m2505o(127191);
    }

    public final int getLayoutId() {
        return 2130970630;
    }

    public void onPause() {
        AppMethodBeat.m2504i(127192);
        super.onPause();
        AppMethodBeat.m2505o(127192);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127193);
        if (this.qmT != null) {
            C1720g.m3540Rg().mo14547c(this.qmT);
        }
        C1720g.m3540Rg().mo14546b((int) ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(127193);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127194);
        setMMTitle((int) C25738R.string.d18);
        this.ejo = (ImageView) findViewById(2131821183);
        this.ejp = (TextView) findViewById(2131823149);
        this.gGA = (TextView) findViewById(2131826877);
        this.qmV = (TextView) findViewById(2131827381);
        this.qmS = (EditText) findViewById(2131827380);
        String Yz = C1853r.m3846Yz();
        if (!C7616ad.aoA(Yz)) {
            this.qmS.setText(C1853r.m3846Yz());
            this.gGA.setText(getString(C25738R.string.f8813fr, new Object[]{Yz}));
        }
        this.qmS.setSelection(this.qmS.getText().length());
        this.qmS.setFocusable(true);
        this.qmS.setFocusableInTouchMode(true);
        this.qmS.addTextChangedListener(new C132101());
        this.ejp.setText(C44089j.m79293b((Context) this, C5046bo.nullAsNil(C1853r.m3820YB()), this.ejp.getTextSize()));
        C40460b.m69434b(this.ejo, Yz);
        setBackBtn(new C132112());
        mo17379a(0, getString(C25738R.string.f9218tc), (OnMenuItemClickListener) new C132153(), C5535b.GREEN);
        enableOptionMenu(false);
        AppMethodBeat.m2505o(127194);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 1;
        AppMethodBeat.m2504i(127195);
        if (i == 0 && i2 == 0) {
            if (this.qmU) {
                C7060h.pYm.mo8374X(10358, "1");
            }
            aqX();
            C1720g.m3536RP().mo5239Ry().set(42, this.dFl);
            C6300p Rg = C1720g.m3540Rg();
            C1202f c132135 = new C132135();
            this.qmb = c132135;
            Rg.mo14539a(255, c132135);
            C1720g.m3540Rg().mo14541a(new C9706r(1), 0);
            AppMethodBeat.m2505o(127195);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!C24824b.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
            switch (i) {
                case 4:
                    if (i2 == -7 || i2 == -10) {
                        C30379h.m48467g(this.mController.ylL, C25738R.string.djv, C25738R.string.d1b);
                        break;
                    }
                default:
                    i3 = 0;
                    break;
            }
        }
        if (i3 != 0) {
            AppMethodBeat.m2505o(127195);
        } else {
            AppMethodBeat.m2505o(127195);
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m21222e(SettingsAliasUI settingsAliasUI) {
        AppMethodBeat.m2504i(127196);
        if (settingsAliasUI.dFl.equals(C1853r.m3846Yz())) {
            C30379h.m48467g(settingsAliasUI.mController.ylL, C25738R.string.d1_, C25738R.string.d18);
            AppMethodBeat.m2505o(127196);
        } else if (C5046bo.amX(settingsAliasUI.dFl)) {
            Context context = settingsAliasUI.mController.ylL;
            settingsAliasUI.getString(C25738R.string.d18);
            settingsAliasUI.ehJ = C30379h.m48458b(context, settingsAliasUI.getString(C25738R.string.d17), true, new C132124());
            if (settingsAliasUI.qmT != null) {
                C1720g.m3540Rg().mo14547c(settingsAliasUI.qmT);
            }
            settingsAliasUI.qmT = new C39647d(settingsAliasUI.dFl);
            C1720g.m3540Rg().mo14541a(settingsAliasUI.qmT, 0);
            AppMethodBeat.m2505o(127196);
        } else {
            C30379h.m48467g(settingsAliasUI.mController.ylL, C25738R.string.f0k, C25738R.string.djx);
            AppMethodBeat.m2505o(127196);
        }
    }
}
