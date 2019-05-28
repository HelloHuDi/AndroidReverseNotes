package com.tencent.p177mm.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.app.s */
final class C45157s extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    C45157s() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(137942);
        super.onCreate(bundle);
        C4990ab.m7416i("WxSplash.SuicideHackActivity", "onCreate");
        finish();
        AppMethodBeat.m2505o(137942);
    }
}
