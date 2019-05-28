package com.tencent.p177mm.p612ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.base.C5271a;

@C5271a(7)
/* renamed from: com.tencent.mm.ui.transmit.TaskRedirectUI */
public class TaskRedirectUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(35279);
        super.onCreate(bundle);
        Intent intent = new Intent(this, LauncherUI.class);
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
        AppMethodBeat.m2505o(35279);
    }
}
