package com.tencent.p177mm.plugin.account.security.p274ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.C35927jp;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI */
public class SecurityAccountIntroUI extends MMWizardActivity implements C1202f {
    private String cFl;
    private ProgressDialog ehJ = null;
    private String gsF;
    private String gzO;
    private String gzP;
    private boolean gzQ = false;
    private Button gzR;
    private String jumpUrl;

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI$1 */
    class C20091 implements OnClickListener {
        C20091() {
        }

        public final void onClick(View view) {
            C1207m c38037x;
            AppMethodBeat.m2504i(69904);
            if (SecurityAccountIntroUI.this.gzQ) {
                c38037x = new C38037x(SecurityAccountIntroUI.this.cFl, 10, "", 0, "");
            } else {
                c38037x = new C32815a(SecurityAccountIntroUI.this.cFl, 10, "", "", SecurityAccountIntroUI.this.gzO);
            }
            C1720g.m3540Rg().mo14541a(c38037x, 0);
            SecurityAccountIntroUI securityAccountIntroUI = SecurityAccountIntroUI.this;
            Context context = SecurityAccountIntroUI.this;
            SecurityAccountIntroUI.this.getString(C25738R.string.f9238tz);
            securityAccountIntroUI.ehJ = C30379h.m48458b(context, SecurityAccountIntroUI.this.getString(C25738R.string.dwo), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(69903);
                    C1720g.m3540Rg().mo14547c(c38037x);
                    AppMethodBeat.m2505o(69903);
                }
            });
            AppMethodBeat.m2505o(69904);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI$2 */
    class C20112 implements OnClickListener {
        C20112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(69905);
            String g = C4988aa.m7402g(SecurityAccountIntroUI.this.getSharedPreferences(C4996ah.doA(), 0));
            Intent intent = new Intent();
            if (C5046bo.isNullOrNil(SecurityAccountIntroUI.this.jumpUrl)) {
                intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{g}));
            } else {
                intent.putExtra("rawUrl", SecurityAccountIntroUI.this.jumpUrl);
            }
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("title", SecurityAccountIntroUI.this.getString(C25738R.string.dwj));
            intent.putExtra("show_bottom", false);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
            C24679a.gkE.mo38924i(intent, SecurityAccountIntroUI.this);
            AppMethodBeat.m2505o(69905);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI$3 */
    class C20123 implements OnMenuItemClickListener {
        C20123() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(69906);
            SecurityAccountIntroUI.m29470e(SecurityAccountIntroUI.this);
            AppMethodBeat.m2505o(69906);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: e */
    static /* synthetic */ void m29470e(SecurityAccountIntroUI securityAccountIntroUI) {
        AppMethodBeat.m2504i(69914);
        securityAccountIntroUI.aoZ();
        AppMethodBeat.m2505o(69914);
    }

    public final int getLayoutId() {
        return 2130970576;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(69907);
        super.onCreate(bundle);
        this.gzO = getIntent().getStringExtra("auth_ticket");
        this.cFl = getIntent().getStringExtra("binded_mobile");
        this.gzQ = getIntent().getBooleanExtra("re_open_verify", false);
        String stringExtra = getIntent().getStringExtra("close_safe_device_style");
        C4990ab.m7417i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", C5046bo.anv(this.gzO), stringExtra);
        if (!C5046bo.isNullOrNil(stringExtra)) {
            Map z = C5049br.m7595z(stringExtra, "wording");
            if (z != null) {
                this.gzP = (String) z.get(".wording.title");
                this.jumpUrl = (String) z.get(".wording.url");
                C4990ab.m7417i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", this.gzP, this.jumpUrl);
            }
        }
        this.gsF = C42756a.m75794FP();
        initView();
        AppMethodBeat.m2505o(69907);
    }

    public void onResume() {
        AppMethodBeat.m2504i(69908);
        super.onResume();
        C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        C1720g.m3540Rg().mo14539a(132, (C1202f) this);
        if (!this.gzQ) {
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L600_100,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("L600_100")).append(",1").toString());
            C42756a.m75798wz("L600_100");
        }
        AppMethodBeat.m2505o(69908);
    }

    public void onPause() {
        AppMethodBeat.m2504i(69909);
        super.onPause();
        C1720g.m3540Rg().mo14546b(145, (C1202f) this);
        C1720g.m3540Rg().mo14546b(132, (C1202f) this);
        if (!this.gzQ) {
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L600_100,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("L600_100")).append(",2").toString());
        }
        AppMethodBeat.m2505o(69909);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(69910);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.m2505o(69910);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(69910);
        return onKeyDown;
    }

    public final void initView() {
        AppMethodBeat.m2504i(69911);
        setMMTitle((int) C25738R.string.dws);
        findViewById(2131827289).setOnClickListener(new C20091());
        if (!this.gzQ) {
            this.gzR = (Button) findViewById(2131827290);
            if (!C5046bo.isNullOrNil(this.gzP)) {
                this.gzR.setText(this.gzP);
            }
            this.gzR.setVisibility(0);
            this.gzR.setOnClickListener(new C20112());
        }
        setBackBtn(new C20123());
        AppMethodBeat.m2505o(69911);
    }

    private void aoZ() {
        AppMethodBeat.m2504i(69912);
        C42756a.m75796wA(this.gsF);
        cancel();
        mo27541Ni(1);
        AppMethodBeat.m2505o(69912);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(69913);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0) {
            String str2;
            if (this.gzQ) {
                str2 = ((C35927jp) ((C38037x) c1207m).ehh.fsH.fsP).vHS;
            } else {
                str2 = ((C32815a) c1207m).agh();
            }
            C4990ab.m7410d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.gzO + "duanyi test authTicket_check = " + str2);
            Intent intent = new Intent(this, SecurityAccountVerifyUI.class);
            intent.putExtra("auth_ticket", str2);
            intent.putExtra("binded_mobile", this.cFl);
            intent.putExtra("re_open_verify", this.gzQ);
            intent.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
            MMWizardActivity.m23791J(this, intent);
            if (getIntent().getIntExtra("from_source", 1) == 3) {
                finish();
            }
            AppMethodBeat.m2505o(69913);
            return;
        }
        int i3;
        switch (i2) {
            case -74:
                C30379h.m48431a((Context) this, (int) C25738R.string.a6g, (int) C25738R.string.f9238tz, null);
                i3 = 1;
                break;
            case -57:
            case -1:
                Toast.makeText(this, C25738R.string.f9111ps, 0).show();
                i3 = 1;
                break;
            case -41:
                Toast.makeText(this, C25738R.string.a6j, 0).show();
                i3 = 1;
                break;
            case -34:
                Toast.makeText(this, C25738R.string.a6k, 0).show();
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 != 0 || C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
            AppMethodBeat.m2505o(69913);
            return;
        }
        Toast.makeText(this, getString(C25738R.string.dwm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.m2505o(69913);
    }
}
