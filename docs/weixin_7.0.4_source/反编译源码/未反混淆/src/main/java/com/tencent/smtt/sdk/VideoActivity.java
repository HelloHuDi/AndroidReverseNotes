package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoActivity extends Activity {
    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(64678);
        super.onActivityResult(i, i2, intent);
        be.a(this).a(i, i2, intent);
        AppMethodBeat.o(64678);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64673);
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            be.a(super.getApplicationContext()).a(null, bundleExtra, null);
        }
        AppMethodBeat.o(64673);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(64677);
        super.onDestroy();
        be.a(this).a(this, 4);
        AppMethodBeat.o(64677);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.i(64676);
        super.onPause();
        be.a(this).a(this, 3);
        AppMethodBeat.o(64676);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.i(64674);
        super.onResume();
        be.a(this).a(this, 2);
        AppMethodBeat.o(64674);
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        AppMethodBeat.i(64675);
        super.onStop();
        be.a(this).a(this, 1);
        AppMethodBeat.o(64675);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
