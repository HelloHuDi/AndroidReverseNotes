package com.tencent.p177mm.plugin.ext.p964ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI */
public class RedirectToChattingByPhoneStubUI extends Activity implements C1202f {
    private C44275p lRg = null;

    /* renamed from: com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI$1 */
    class C340881 implements Runnable {
        C340881() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20434);
            RedirectToChattingByPhoneStubUI.this.hideVKB();
            AppMethodBeat.m2505o(20434);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20435);
        super.onCreate(bundle);
        getString(C25738R.string.f9260un);
        this.lRg = C30379h.m48458b((Context) this, "", false, null);
        C5004al.m7442n(new C340881(), 500);
        C9638aw.m17182Rg().mo14539a(106, (C1202f) this);
        AppMethodBeat.m2505o(20435);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(20436);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(106, (C1202f) this);
        if (this.lRg != null) {
            this.lRg.dismiss();
            this.lRg = null;
        }
        AppMethodBeat.m2505o(20436);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(20437);
        finish();
        AppMethodBeat.m2505o(20437);
    }

    public final boolean hideVKB() {
        AppMethodBeat.m2504i(20438);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.m2505o(20438);
            return false;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.m2505o(20438);
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.m2505o(20438);
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            C4990ab.m7413e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        C4990ab.m7419v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        AppMethodBeat.m2505o(20438);
        return hideSoftInputFromWindow;
    }
}
