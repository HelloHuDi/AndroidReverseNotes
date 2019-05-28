package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.LoginVoiceUI */
public class LoginVoiceUI extends LoginHistoryUI {

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginVoiceUI$1 */
    class C380661 implements OnClickListener {
        C380661() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125073);
            C7060h.pYm.mo8381e(11557, Integer.valueOf(2));
            Intent intent = new Intent();
            intent.putExtra("Kusername", LoginVoiceUI.this.gCb);
            intent.putExtra("kscene_type", 1);
            C25985d.m41468b(LoginVoiceUI.this.mController.ylL, "voiceprint", ".ui.VoiceLoginUI", intent, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.m2505o(125073);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125075);
        super.onCreate(bundle);
        if (this.gCl) {
            AppMethodBeat.m2505o(125075);
            return;
        }
        this.gwX = 1;
        this.gCe.setVisibility(0);
        this.gBM.setVisibility(0);
        LayoutParams layoutParams = (LayoutParams) this.gBL.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.leftMargin = 0;
        this.gBL.setLayoutParams(layoutParams);
        findViewById(2131825304).setEnabled(false);
        ((TextView) findViewById(2131825305)).setTextColor(getResources().getColorStateList(C25738R.color.a8m));
        ((TextView) findViewById(2131825305)).setBackgroundResource(getResources().getColor(C25738R.color.a3p));
        this.gBM.setOnClickListener(new C380661());
        AppMethodBeat.m2505o(125075);
    }

    public final boolean aqY() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        int i = -1;
        AppMethodBeat.m2504i(125076);
        super.aqU();
        aqV();
        final C1207m c6686q = new C6686q(this.gCb, this.gCk, "", 0);
        c6686q.mo14934tr(this.gCk);
        String str = "MicroMsg.LoginVoiceUI";
        String str2 = "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.gCk == null ? -1 : this.gCk.length());
        objArr[1] = C5046bo.anv(this.gCk);
        if (this.gBT.guf != null) {
            i = this.gBT.guf.length();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = C5046bo.anv(this.gBT.guf);
        C4990ab.m7411d(str, str2, objArr);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.cou), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(125074);
                C1720g.m3540Rg().mo14547c(c6686q);
                LoginVoiceUI.this.aqW();
                AppMethodBeat.m2505o(125074);
            }
        });
        C1720g.m3540Rg().mo14541a(c6686q, 0);
        AppMethodBeat.m2505o(125076);
    }
}
