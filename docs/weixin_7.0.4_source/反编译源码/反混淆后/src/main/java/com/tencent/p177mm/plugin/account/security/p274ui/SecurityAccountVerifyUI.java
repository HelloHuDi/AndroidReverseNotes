package com.tencent.p177mm.plugin.account.security.p274ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C38037x;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.security.p880a.C38042f;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI */
public class SecurityAccountVerifyUI extends MMWizardActivity implements C1202f {
    private String cCU;
    private String cCW;
    private String cFl;
    private C7564ap che;
    private ProgressDialog ehJ = null;
    private String gsF;
    private String gzO;
    private Button gzR;
    private EditText gzV;
    private TextView gzW;
    private TextView gzX;
    private Button gzY;
    private boolean gzZ = false;

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI$1 */
    class C20131 implements TextWatcher {
        C20131() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(69915);
            boolean z = (editable == null || C5046bo.isNullOrNil(editable.toString())) ? false : true;
            SecurityAccountVerifyUI.this.enableOptionMenu(z);
            AppMethodBeat.m2505o(69915);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI$2 */
    class C67342 implements C5015a {
        C67342() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(69916);
            int intValue = ((Integer) SecurityAccountVerifyUI.this.gzX.getTag()).intValue();
            if (intValue <= 1) {
                SecurityAccountVerifyUI.this.gzY.setVisibility(0);
                SecurityAccountVerifyUI.this.gzX.setVisibility(8);
                AppMethodBeat.m2505o(69916);
                return false;
            }
            SecurityAccountVerifyUI.this.gzX.setTag(Integer.valueOf(intValue - 1));
            SecurityAccountVerifyUI.this.gzX.setText(SecurityAccountVerifyUI.this.getString(C25738R.string.dwl, new Object[]{Integer.valueOf(intValue)}));
            if (SecurityAccountVerifyUI.this.gzX.getVisibility() != 0) {
                SecurityAccountVerifyUI.this.gzX.setVisibility(0);
            }
            AppMethodBeat.m2505o(69916);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI$3 */
    class C188633 implements OnClickListener {
        C188633() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(69918);
            C4990ab.m7418v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
            SecurityAccountVerifyUI.this.gzY.setVisibility(8);
            SecurityAccountVerifyUI.this.gzX.setTag(Integer.valueOf(60));
            SecurityAccountVerifyUI.this.che.stopTimer();
            SecurityAccountVerifyUI.this.che.mo16770ae(1000, 1000);
            final C1207m c32815a = new C32815a(SecurityAccountVerifyUI.this.cFl, 10, "", "", SecurityAccountVerifyUI.this.gzO);
            C1720g.m3540Rg().mo14541a(c32815a, 0);
            SecurityAccountVerifyUI securityAccountVerifyUI = SecurityAccountVerifyUI.this;
            Context context = SecurityAccountVerifyUI.this.mController.ylL;
            SecurityAccountVerifyUI.this.getString(C25738R.string.f9238tz);
            securityAccountVerifyUI.ehJ = C30379h.m48458b(context, SecurityAccountVerifyUI.this.getString(C25738R.string.dwo), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(69917);
                    C1720g.m3540Rg().mo14547c(c32815a);
                    AppMethodBeat.m2505o(69917);
                }
            });
            AppMethodBeat.m2505o(69918);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI$5 */
    class C329845 implements OnMenuItemClickListener {
        C329845() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(69920);
            SecurityAccountVerifyUI.m74796f(SecurityAccountVerifyUI.this);
            AppMethodBeat.m2505o(69920);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI$6 */
    class C329856 implements OnMenuItemClickListener {
        C329856() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(69922);
            String trim = SecurityAccountVerifyUI.this.gzV.getText().toString().trim();
            if (C5046bo.isNullOrNil(trim)) {
                C30379h.m48467g(SecurityAccountVerifyUI.this, C25738R.string.a7z, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(69922);
            } else {
                C1207m c38037x;
                SecurityAccountVerifyUI.this.aqX();
                SecurityAccountVerifyUI.this.cCU = C38042f.m64373cz(SecurityAccountVerifyUI.this);
                SecurityAccountVerifyUI.this.cCW = C38042f.aqE();
                if (SecurityAccountVerifyUI.this.gzZ) {
                    c38037x = new C38037x(SecurityAccountVerifyUI.this.cFl, 11, trim, "", SecurityAccountVerifyUI.this.cCU, SecurityAccountVerifyUI.this.cCW);
                } else {
                    c38037x = new C32815a(SecurityAccountVerifyUI.this.cFl, trim, "", SecurityAccountVerifyUI.this.gzO, SecurityAccountVerifyUI.this.cCU, SecurityAccountVerifyUI.this.cCW);
                }
                C1720g.m3540Rg().mo14541a(c38037x, 0);
                SecurityAccountVerifyUI securityAccountVerifyUI = SecurityAccountVerifyUI.this;
                Context context = SecurityAccountVerifyUI.this;
                SecurityAccountVerifyUI.this.getString(C25738R.string.f9238tz);
                securityAccountVerifyUI.ehJ = C30379h.m48458b(context, SecurityAccountVerifyUI.this.getString(C25738R.string.a7n), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(69921);
                        C1720g.m3540Rg().mo14547c(c38037x);
                        AppMethodBeat.m2505o(69921);
                    }
                });
                AppMethodBeat.m2505o(69922);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI$4 */
    class C422914 implements OnClickListener {
        C422914() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(69919);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L600_300,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("L600_300")).append(",1").toString());
            String g = C4988aa.m7402g(SecurityAccountVerifyUI.this.getSharedPreferences(C4996ah.doA(), 0));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{g}));
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("title", SecurityAccountVerifyUI.this.getString(C25738R.string.dwj));
            intent.putExtra("show_bottom", false);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
            C24679a.gkE.mo38924i(intent, SecurityAccountVerifyUI.this);
            AppMethodBeat.m2505o(69919);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: f */
    static /* synthetic */ void m74796f(SecurityAccountVerifyUI securityAccountVerifyUI) {
        AppMethodBeat.m2504i(69932);
        securityAccountVerifyUI.aoZ();
        AppMethodBeat.m2505o(69932);
    }

    public final int getLayoutId() {
        return 2130970578;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(69923);
        super.onCreate(bundle);
        this.gsF = C42756a.m75794FP();
        initView();
        AppMethodBeat.m2505o(69923);
    }

    public void onResume() {
        AppMethodBeat.m2504i(69924);
        C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        C1720g.m3540Rg().mo14539a(132, (C1202f) this);
        super.onResume();
        if (!this.gzZ) {
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L600_200,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("L600_200")).append(",1").toString());
            C42756a.m75798wz("L600_200");
        }
        AppMethodBeat.m2505o(69924);
    }

    public void onPause() {
        AppMethodBeat.m2504i(69925);
        C1720g.m3540Rg().mo14546b(145, (C1202f) this);
        C1720g.m3540Rg().mo14546b(132, (C1202f) this);
        super.onPause();
        if (!this.gzZ) {
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L600_200,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("L600_200")).append(",2").toString());
        }
        AppMethodBeat.m2505o(69925);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(69926);
        super.onDestroy();
        this.che.stopTimer();
        AppMethodBeat.m2505o(69926);
    }

    public final void initView() {
        AppMethodBeat.m2504i(69927);
        this.cFl = getIntent().getStringExtra("binded_mobile");
        this.gzO = getIntent().getStringExtra("auth_ticket");
        this.gzZ = getIntent().getBooleanExtra("re_open_verify", false);
        this.gzV = (EditText) findViewById(2131821771);
        this.gzW = (TextView) findViewById(2131827293);
        this.gzX = (TextView) findViewById(2131827294);
        this.gzY = (Button) findViewById(2131827295);
        this.gzV.addTextChangedListener(new C20131());
        this.gzW.setText(C5046bo.ans(this.cFl));
        this.gzX.setTag(Integer.valueOf(60));
        this.che = new C7564ap(new C67342(), true);
        this.gzY.setOnClickListener(new C188633());
        if (!this.gzZ) {
            this.gzR = (Button) findViewById(2131827290);
            this.gzR.setVisibility(0);
            this.gzR.setOnClickListener(new C422914());
        }
        setBackBtn(new C329845());
        addTextOptionMenu(0, getString(C25738R.string.f9182s1), new C329856());
        enableOptionMenu(false);
        setMMTitle((int) C25738R.string.dwd);
        this.che.mo16770ae(1000, 1000);
        AppMethodBeat.m2505o(69927);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(69928);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.m2505o(69928);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(69928);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.m2504i(69929);
        cancel();
        mo27541Ni(1);
        AppMethodBeat.m2505o(69929);
    }

    /* renamed from: j */
    private boolean m74801j(int i, int i2, String str) {
        boolean z = true;
        AppMethodBeat.m2504i(69931);
        if (C24679a.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.m2505o(69931);
        } else {
            switch (i2) {
                case -74:
                    C30379h.m48431a(this.mController.ylL, (int) C25738R.string.a6g, (int) C25738R.string.f9238tz, null);
                    break;
                case -57:
                case -1:
                    Toast.makeText(this.mController.ylL, C25738R.string.f9111ps, 0).show();
                    break;
                case -41:
                    Toast.makeText(this.mController.ylL, C25738R.string.a6j, 0).show();
                    break;
                case -34:
                    Toast.makeText(this, C25738R.string.a6k, 0).show();
                    break;
                case -33:
                    C30379h.m48431a(this.mController.ylL, (int) C25738R.string.a7s, (int) C25738R.string.a7y, null);
                    break;
                case -32:
                    C30379h.m48431a(this.mController.ylL, (int) C25738R.string.a7t, (int) C25738R.string.a7y, null);
                    break;
                default:
                    z = false;
                    break;
            }
            AppMethodBeat.m2505o(69931);
        }
        return z;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(69930);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        Intent intent;
        switch (c1207m.getType()) {
            case 132:
                if (i != 0 || i2 != 0) {
                    if (!m74801j(i, i2, str)) {
                        Toast.makeText(this, getString(C25738R.string.dwq, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        break;
                    }
                    AppMethodBeat.m2505o(69930);
                    return;
                }
                C38042f.m64374n(true, true);
                intent = new Intent(this, MySafeDeviceListUI.class);
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
                AppMethodBeat.m2505o(69930);
                return;
                break;
            case 145:
                C32815a c32815a = (C32815a) c1207m;
                if (c32815a.mo53366Ah() == 10) {
                    if (i == 0 && i2 == 0) {
                        C4990ab.m7416i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
                        AppMethodBeat.m2505o(69930);
                        return;
                    }
                    C4990ab.m7421w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (m74801j(i, i2, str)) {
                        AppMethodBeat.m2505o(69930);
                        return;
                    }
                    Toast.makeText(this.mController.ylL, getString(C25738R.string.dwm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.m2505o(69930);
                    return;
                } else if (c32815a.mo53366Ah() != 11) {
                    C4990ab.m7421w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", Integer.valueOf(c32815a.mo53366Ah()), Integer.valueOf(i), Integer.valueOf(i2));
                    AppMethodBeat.m2505o(69930);
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.gzO = c32815a.agh();
                    C4990ab.m7410d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.gzO);
                    int intExtra = getIntent().getIntExtra("from_source", 1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("from_source", intExtra);
                    intent2.putExtra("binded_mobile", this.cFl);
                    switch (intExtra) {
                        case 1:
                        case 2:
                        case 5:
                        case 6:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.gzO);
                            C24679a.gkE.mo38892a((Context) this, intent2, null);
                            finish();
                            AppMethodBeat.m2505o(69930);
                            return;
                        case 3:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.gzO);
                            Object stringExtra = getIntent().getStringExtra("WizardTransactionId");
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            intent = (Intent) ynD.get(stringExtra);
                            ynD.clear();
                            if (intent != null) {
                                C24679a.gkE.mo38892a((Context) this, intent2, intent);
                            } else {
                                C24679a.gkE.mo38892a((Context) this, intent2, null);
                            }
                            finish();
                            AppMethodBeat.m2505o(69930);
                            return;
                        default:
                            mo27541Ni(1);
                            AppMethodBeat.m2505o(69930);
                            return;
                    }
                } else {
                    C4990ab.m7421w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (m74801j(i, i2, str)) {
                        AppMethodBeat.m2505o(69930);
                        return;
                    }
                    Toast.makeText(this.mController.ylL, getString(C25738R.string.dwq, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.m2505o(69930);
                    return;
                }
        }
        AppMethodBeat.m2505o(69930);
    }
}
