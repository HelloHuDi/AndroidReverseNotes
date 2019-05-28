package com.tencent.mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i extends Activity {
    public String xHe;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    i() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(114878);
        super.onCreate(bundle);
        h.g("WxSplash.SplashHackActivity", "onCreate", new Object[0]);
        setVisible(false);
        Intent intent = new Intent(this, h.drg());
        intent.putExtra("hashcode", hashCode());
        startActivityForResult(intent, 100);
        AppMethodBeat.o(114878);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(114879);
        h.g("WxSplash.SplashHackActivity", "onNewIntent.", new Object[0]);
        if (h.xGG != null && h.xGG.n(intent)) {
            finish();
        }
        AppMethodBeat.o(114879);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.i(114880);
        super.onResume();
        h.g("WxSplash.SplashHackActivity", "onResume", new Object[0]);
        AppMethodBeat.o(114880);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.i(114881);
        h.g("WxSplash.SplashHackActivity", "onPause", new Object[0]);
        super.onPause();
        AppMethodBeat.o(114881);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        AppMethodBeat.i(114882);
        h.g("WxSplash.SplashHackActivity", "onDestroy", new Object[0]);
        h.xGC.remove(this);
        setVisible(true);
        h.xGC.remove(this);
        super.onDestroy();
        AppMethodBeat.o(114882);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(114883);
        if (i != 100) {
            finish();
            h.g("WxSplash.SplashHackActivity", "unknown request code.", new Object[0]);
        } else if (i2 != -100) {
            onBackPressed();
            AppMethodBeat.o(114883);
            return;
        }
        AppMethodBeat.o(114883);
    }
}
