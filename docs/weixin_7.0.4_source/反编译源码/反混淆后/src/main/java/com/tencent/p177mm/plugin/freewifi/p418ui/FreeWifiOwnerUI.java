package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C3138j;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiOwnerUI */
public class FreeWifiOwnerUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21059);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(21059);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.m2504i(21060);
        super.onResume();
        String stringExtra = getIntent().getStringExtra("wifi_owner_name");
        int intExtra = getIntent().getIntExtra("wifi_owner_type", 0);
        C3138j.userName = stringExtra;
        C3138j.type = intExtra;
        finish();
        AppMethodBeat.m2505o(21060);
    }
}
