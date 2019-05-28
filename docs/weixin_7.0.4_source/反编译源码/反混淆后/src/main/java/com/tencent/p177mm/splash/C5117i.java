package com.tencent.p177mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.splash.i */
final class C5117i extends Activity {
    public String xHe;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    C5117i() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(114878);
        super.onCreate(bundle);
        C5115h.m7780g("WxSplash.SplashHackActivity", "onCreate", new Object[0]);
        setVisible(false);
        Intent intent = new Intent(this, C5115h.drg());
        intent.putExtra("hashcode", hashCode());
        startActivityForResult(intent, 100);
        AppMethodBeat.m2505o(114878);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(114879);
        C5115h.m7780g("WxSplash.SplashHackActivity", "onNewIntent.", new Object[0]);
        if (C5115h.xGG != null && C5115h.xGG.mo10482n(intent)) {
            finish();
        }
        AppMethodBeat.m2505o(114879);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.m2504i(114880);
        super.onResume();
        C5115h.m7780g("WxSplash.SplashHackActivity", "onResume", new Object[0]);
        AppMethodBeat.m2505o(114880);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.m2504i(114881);
        C5115h.m7780g("WxSplash.SplashHackActivity", "onPause", new Object[0]);
        super.onPause();
        AppMethodBeat.m2505o(114881);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        AppMethodBeat.m2504i(114882);
        C5115h.m7780g("WxSplash.SplashHackActivity", "onDestroy", new Object[0]);
        C5115h.xGC.remove(this);
        setVisible(true);
        C5115h.xGC.remove(this);
        super.onDestroy();
        AppMethodBeat.m2505o(114882);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(114883);
        if (i != 100) {
            finish();
            C5115h.m7780g("WxSplash.SplashHackActivity", "unknown request code.", new Object[0]);
        } else if (i2 != -100) {
            onBackPressed();
            AppMethodBeat.m2505o(114883);
            return;
        }
        AppMethodBeat.m2505o(114883);
    }
}
