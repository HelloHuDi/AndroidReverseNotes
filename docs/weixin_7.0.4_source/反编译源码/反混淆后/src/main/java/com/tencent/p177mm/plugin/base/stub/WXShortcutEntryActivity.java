package com.tencent.p177mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p1622w.C43754b;
import com.tencent.p177mm.plugin.p1622w.C43755c;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity.C4737a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5068w;

/* renamed from: com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity */
public class WXShortcutEntryActivity extends AutoLoginActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18225);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(18225);
    }

    /* renamed from: O */
    public final boolean mo6736O(Intent intent) {
        return true;
    }

    /* renamed from: a */
    public final void mo6737a(C4737a c4737a, Intent intent) {
        AppMethodBeat.m2504i(18226);
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.WXShortcutEntryActivity", "intent is null");
            finish();
            AppMethodBeat.m2505o(18226);
            return;
        }
        C43755c c43755c = C43755c.qwS;
        int a = C5068w.m7682a(intent, "type", 0);
        AppCompatActivity appCompatActivity = this.mController.ylL;
        if (intent != null) {
            C43754b c43754b = (C43754b) c43755c.qwT.get(a);
            if (c43754b != null) {
                c43754b.mo26753l(appCompatActivity, intent);
            }
        }
        finish();
        AppMethodBeat.m2505o(18226);
    }
}
