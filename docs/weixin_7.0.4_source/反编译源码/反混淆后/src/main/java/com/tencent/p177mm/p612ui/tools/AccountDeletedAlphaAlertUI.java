package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p230g.p231a.C26270x;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.sdk.p600b.C4879a;

@C5271a(3)
/* renamed from: com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI */
public class AccountDeletedAlphaAlertUI extends MMActivity {
    private static AccountDeletedAlphaAlertUI zzW = null;

    /* renamed from: com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI$1 */
    class C159141 implements OnClickListener {
        C159141() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34739);
            AccountDeletedAlphaAlertUI.m24225a(AccountDeletedAlphaAlertUI.this);
            AppMethodBeat.m2505o(34739);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI$2 */
    class C159152 implements OnClickListener {
        C159152() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34740);
            AccountDeletedAlphaAlertUI.m24225a(AccountDeletedAlphaAlertUI.this);
            AppMethodBeat.m2505o(34740);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public static AccountDeletedAlphaAlertUI dJp() {
        return zzW;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34741);
        super.onCreate(bundle);
        zzW = this;
        C4879a.xxA.mo10055m(new C26270x());
        C9638aw.hold();
        C42124a jY = C42124a.m74268jY(getIntent().getStringExtra("errmsg"));
        if (jY != null) {
            jY.mo67668a(this, new C159141(), null);
            AppMethodBeat.m2505o(34741);
            return;
        }
        C30379h.m48448a((Context) this, getString(C25738R.string.cvv), null, false, new C159152());
        AppMethodBeat.m2505o(34741);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34742);
        if (equals(zzW)) {
            zzW = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(34742);
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: a */
    static /* synthetic */ void m24225a(AccountDeletedAlphaAlertUI accountDeletedAlphaAlertUI) {
        AppMethodBeat.m2504i(34743);
        accountDeletedAlphaAlertUI.finish();
        C26529w.m42357cn(accountDeletedAlphaAlertUI);
        Intent intent = new Intent(accountDeletedAlphaAlertUI.mController.ylL, LauncherUI.class);
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        accountDeletedAlphaAlertUI.mController.ylL.startActivity(intent);
        AppMethodBeat.m2505o(34743);
    }
}
