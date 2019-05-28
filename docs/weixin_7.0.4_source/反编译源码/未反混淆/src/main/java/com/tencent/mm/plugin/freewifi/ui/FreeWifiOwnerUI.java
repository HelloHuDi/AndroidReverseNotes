package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.j;

public class FreeWifiOwnerUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21059);
        super.onCreate(bundle);
        AppMethodBeat.o(21059);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.i(21060);
        super.onResume();
        String stringExtra = getIntent().getStringExtra("wifi_owner_name");
        int intExtra = getIntent().getIntExtra("wifi_owner_type", 0);
        j.userName = stringExtra;
        j.type = intExtra;
        finish();
        AppMethodBeat.o(21060);
    }
}
