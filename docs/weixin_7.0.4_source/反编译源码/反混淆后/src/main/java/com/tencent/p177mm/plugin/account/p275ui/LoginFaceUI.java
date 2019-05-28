package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.LoginFaceUI */
public class LoginFaceUI extends LoginHistoryUI {

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginFaceUI$1 */
    class C99251 implements OnClickListener {
        C99251() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124909);
            C7060h.pYm.mo8381e(11557, Integer.valueOf(2));
            Intent intent = new Intent();
            intent.putExtra("k_user_name", LoginFaceUI.this.gCb);
            intent.putExtra("k_purpose", 2);
            intent.putExtra("k_need_signature", true);
            C25985d.m41468b(LoginFaceUI.this.mController.ylL, "facedetect", ".ui.FaceDetectUI", intent, 1025);
            AppMethodBeat.m2505o(124909);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124911);
        super.onCreate(bundle);
        if (this.gCl) {
            AppMethodBeat.m2505o(124911);
            return;
        }
        this.gwX = 4;
        this.gCg.setVisibility(0);
        this.gBN.setVisibility(0);
        findViewById(2131825309).setEnabled(false);
        ((TextView) findViewById(2131825310)).setTextColor(getResources().getColorStateList(C25738R.color.a8m));
        ((TextView) findViewById(2131825310)).setBackgroundResource(getResources().getColor(C25738R.color.a3p));
        this.gBN.setOnClickListener(new C99251());
        AppMethodBeat.m2505o(124911);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        int i = -1;
        AppMethodBeat.m2504i(124912);
        super.aqU();
        aqV();
        final C1207m c6686q = new C6686q(this.gCb, this.gCk, "", 0);
        String str = "MicroMsg.LoginFaceUI";
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
                AppMethodBeat.m2504i(124910);
                C1720g.m3540Rg().mo14547c(c6686q);
                LoginFaceUI.this.aqW();
                AppMethodBeat.m2505o(124910);
            }
        });
        C1720g.m3540Rg().mo14541a(c6686q, 0);
        AppMethodBeat.m2505o(124912);
    }
}
