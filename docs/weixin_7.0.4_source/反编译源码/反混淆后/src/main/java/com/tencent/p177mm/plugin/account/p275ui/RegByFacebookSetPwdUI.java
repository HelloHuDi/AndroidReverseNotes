package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.account.friend.p272a.C26583ak;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a.C18796a;

/* renamed from: com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI */
public class RegByFacebookSetPwdUI extends SetPwdUI {

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI$1 */
    class C266231 implements OnClickListener {
        C266231() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125323);
            RegByFacebookSetPwdUI.this.finish();
            AppMethodBeat.m2505o(125323);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125325);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.dl3);
        AppMethodBeat.m2505o(125325);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125326);
        super.onDestroy();
        AppMethodBeat.m2505o(125326);
    }

    public final int getLayoutId() {
        return 2130970495;
    }

    public final void initView() {
        AppMethodBeat.m2504i(139153);
        setMMTitle((int) C25738R.string.dl3);
        AppMethodBeat.m2505o(139153);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final ProgressDialog mo53561a(Context context, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(125328);
        C44275p b = C30379h.m48458b(context, getString(C25738R.string.dku), true, onCancelListener);
        AppMethodBeat.m2505o(125328);
        return b;
    }

    /* Access modifiers changed, original: protected|final */
    public final C1207m ark() {
        AppMethodBeat.m2504i(125329);
        C26583ak c26583ak = new C26583ak(this.gHW);
        AppMethodBeat.m2505o(125329);
        return c26583ak;
    }

    /* Access modifiers changed, original: protected|final */
    public final String arl() {
        AppMethodBeat.m2504i(125330);
        String obj = ((EditText) findViewById(2131826922)).getText().toString();
        AppMethodBeat.m2505o(125330);
        return obj;
    }

    /* Access modifiers changed, original: protected|final */
    public final String arm() {
        AppMethodBeat.m2504i(125331);
        String obj = ((EditText) findViewById(2131826923)).getText().toString();
        AppMethodBeat.m2505o(125331);
        return obj;
    }

    /* Access modifiers changed, original: protected|final */
    public final int arn() {
        return 382;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo53562a(C18796a c18796a) {
        AppMethodBeat.m2504i(125332);
        switch (c18796a) {
            case TwoPasswordsNotMatch:
                C30379h.m48467g(this, C25738R.string.dkq, C25738R.string.dks);
                AppMethodBeat.m2505o(125332);
                return;
            case BeyondMaximumLength:
                C30379h.m48467g(this, C25738R.string.dkr, C25738R.string.dks);
                AppMethodBeat.m2505o(125332);
                return;
            case DisallowShortNumericPassword:
                C30379h.m48467g(this, C25738R.string.f0r, C25738R.string.f9109pq);
                AppMethodBeat.m2505o(125332);
                return;
            case NotReachMinimumLength:
                C30379h.m48467g(this, C25738R.string.f0t, C25738R.string.f9109pq);
                break;
        }
        AppMethodBeat.m2505o(125332);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: k */
    public final boolean mo53567k(int i, int i2, String str) {
        AppMethodBeat.m2504i(125333);
        if (i == 0 && i2 == 0) {
            C1720g.m3536RP().mo5239Ry().set(57, Integer.valueOf(0));
            C30379h.m48438a((Context) this, getString(C25738R.string.dl1, new Object[]{(String) C1720g.m3536RP().mo5239Ry().get(5, null)}), getString(C25738R.string.dks), new C266231());
            AppMethodBeat.m2505o(125333);
            return true;
        }
        boolean j = mo67826j(i, i2, str);
        AppMethodBeat.m2505o(125333);
        return j;
    }
}
