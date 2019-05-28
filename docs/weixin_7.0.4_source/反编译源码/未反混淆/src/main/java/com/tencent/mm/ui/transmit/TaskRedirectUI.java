package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.a;

@a(7)
public class TaskRedirectUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35279);
        super.onCreate(bundle);
        Intent intent = new Intent(this, LauncherUI.class);
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
        AppMethodBeat.o(35279);
    }
}
