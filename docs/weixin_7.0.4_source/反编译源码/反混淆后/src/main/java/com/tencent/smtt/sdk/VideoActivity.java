package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoActivity extends Activity {
    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(64678);
        super.onActivityResult(i, i2, intent);
        C46737be.m88593a(this).mo75281a(i, i2, intent);
        AppMethodBeat.m2505o(64678);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(64673);
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            C46737be.m88593a(super.getApplicationContext()).mo75284a(null, bundleExtra, null);
        }
        AppMethodBeat.m2505o(64673);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(64677);
        super.onDestroy();
        C46737be.m88593a(this).mo75282a(this, 4);
        AppMethodBeat.m2505o(64677);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.m2504i(64676);
        super.onPause();
        C46737be.m88593a(this).mo75282a(this, 3);
        AppMethodBeat.m2505o(64676);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.m2504i(64674);
        super.onResume();
        C46737be.m88593a(this).mo75282a(this, 2);
        AppMethodBeat.m2505o(64674);
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        AppMethodBeat.m2504i(64675);
        super.onStop();
        C46737be.m88593a(this).mo75282a(this, 1);
        AppMethodBeat.m2505o(64675);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }
}
