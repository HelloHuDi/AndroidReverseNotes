package com.tencent.mm.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class s extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    s() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(137942);
        super.onCreate(bundle);
        ab.i("WxSplash.SuicideHackActivity", "onCreate");
        finish();
        AppMethodBeat.o(137942);
    }
}
