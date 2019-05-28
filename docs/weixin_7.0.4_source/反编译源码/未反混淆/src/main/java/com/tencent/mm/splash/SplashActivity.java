package com.tencent.mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.Iterator;

public class SplashActivity extends Activity {
    private boolean xGZ = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(SplashActivity splashActivity) {
        AppMethodBeat.i(114871);
        splashActivity.drk();
        AppMethodBeat.o(114871);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(114863);
        super.onCreate(bundle);
        h.a(this);
        h.g("WxSplash.SplashActivity", "onCreate", new Object[0]);
        if (!h.dra()) {
            h.g("WxSplash.SplashActivity", "no need splash, finish", new Object[0]);
            drl();
        }
        if (h.xGP != null) {
            h.xGP.n(this);
        }
        AppMethodBeat.o(114863);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.i(114864);
        super.onResume();
        h.g("WxSplash.SplashActivity", "onResume", new Object[0]);
        AppMethodBeat.o(114864);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.i(114865);
        h.g("WxSplash.SplashActivity", "onPause", new Object[0]);
        super.onPause();
        AppMethodBeat.o(114865);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(114866);
        h.b(this);
        h.g("WxSplash.SplashActivity", "onDestroy", new Object[0]);
        super.onDestroy();
        AppMethodBeat.o(114866);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(114867);
        if (h.xGG != null) {
            h.xGG.a(this, i, strArr, iArr);
        }
        AppMethodBeat.o(114867);
    }

    private void drk() {
        AppMethodBeat.i(114868);
        if (h.xGG.b(this, new Runnable() {
            public final void run() {
                AppMethodBeat.i(114860);
                SplashActivity.c(SplashActivity.this);
                AppMethodBeat.o(114860);
            }
        })) {
            drm();
        }
        AppMethodBeat.o(114868);
    }

    public final void drl() {
        AppMethodBeat.i(114869);
        if (h.xGG == null) {
            h.g("WxSplash.SplashActivity", "permissions delegate is null, call splash finish directly.", new Object[0]);
            drm();
        } else if (!h.xGG.a(this, new Runnable() {
            public final void run() {
                AppMethodBeat.i(114861);
                SplashActivity.c(SplashActivity.this);
                AppMethodBeat.o(114861);
            }
        })) {
            drk();
            AppMethodBeat.o(114869);
            return;
        }
        AppMethodBeat.o(114869);
    }

    private void drm() {
        AppMethodBeat.i(114870);
        if (this.xGZ) {
            AppMethodBeat.o(114870);
            return;
        }
        this.xGZ = true;
        if (isFinishing()) {
            onBackPressed();
        } else {
            setResult(-100);
            int intExtra = getIntent().getIntExtra("hashcode", 0);
            Iterator it = h.xGC.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (intExtra == iVar.hashCode()) {
                    h.a(iVar);
                    break;
                }
            }
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(114862);
                    SplashActivity.this.finish();
                    SplashActivity.d(SplashActivity.this);
                    AppMethodBeat.o(114862);
                }
            }, 50);
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                h.xGG = null;
            }
        }, 30000);
        AppMethodBeat.o(114870);
    }

    static /* synthetic */ void d(SplashActivity splashActivity) {
        AppMethodBeat.i(114872);
        splashActivity.overridePendingTransition(R.anim.dp, R.anim.f11do);
        AppMethodBeat.o(114872);
    }
}
