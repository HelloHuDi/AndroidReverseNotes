package com.tencent.p177mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.util.Iterator;

/* renamed from: com.tencent.mm.splash.SplashActivity */
public class SplashActivity extends Activity {
    private boolean xGZ = false;

    /* renamed from: com.tencent.mm.splash.SplashActivity$1 */
    class C50951 implements Runnable {
        C50951() {
        }

        public final void run() {
            AppMethodBeat.m2504i(114860);
            SplashActivity.m7731c(SplashActivity.this);
            AppMethodBeat.m2505o(114860);
        }
    }

    /* renamed from: com.tencent.mm.splash.SplashActivity$2 */
    class C50962 implements Runnable {
        C50962() {
        }

        public final void run() {
            AppMethodBeat.m2504i(114861);
            SplashActivity.m7731c(SplashActivity.this);
            AppMethodBeat.m2505o(114861);
        }
    }

    /* renamed from: com.tencent.mm.splash.SplashActivity$3 */
    class C50973 implements Runnable {
        C50973() {
        }

        public final void run() {
            AppMethodBeat.m2504i(114862);
            SplashActivity.this.finish();
            SplashActivity.m7732d(SplashActivity.this);
            AppMethodBeat.m2505o(114862);
        }
    }

    /* renamed from: com.tencent.mm.splash.SplashActivity$4 */
    class C50984 implements Runnable {
        C50984() {
        }

        public final void run() {
            C5115h.xGG = null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    static /* synthetic */ void m7731c(SplashActivity splashActivity) {
        AppMethodBeat.m2504i(114871);
        splashActivity.drk();
        AppMethodBeat.m2505o(114871);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(114863);
        super.onCreate(bundle);
        C5115h.m7765a(this);
        C5115h.m7780g("WxSplash.SplashActivity", "onCreate", new Object[0]);
        if (!C5115h.dra()) {
            C5115h.m7780g("WxSplash.SplashActivity", "no need splash, finish", new Object[0]);
            drl();
        }
        if (C5115h.xGP != null) {
            C5115h.xGP.mo4567n(this);
        }
        AppMethodBeat.m2505o(114863);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.m2504i(114864);
        super.onResume();
        C5115h.m7780g("WxSplash.SplashActivity", "onResume", new Object[0]);
        AppMethodBeat.m2505o(114864);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.m2504i(114865);
        C5115h.m7780g("WxSplash.SplashActivity", "onPause", new Object[0]);
        super.onPause();
        AppMethodBeat.m2505o(114865);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(114866);
        C5115h.m7777b(this);
        C5115h.m7780g("WxSplash.SplashActivity", "onDestroy", new Object[0]);
        super.onDestroy();
        AppMethodBeat.m2505o(114866);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(114867);
        if (C5115h.xGG != null) {
            C5115h.xGG.mo10479a(this, i, strArr, iArr);
        }
        AppMethodBeat.m2505o(114867);
    }

    private void drk() {
        AppMethodBeat.m2504i(114868);
        if (C5115h.xGG.mo10481b(this, new C50951())) {
            drm();
        }
        AppMethodBeat.m2505o(114868);
    }

    public final void drl() {
        AppMethodBeat.m2504i(114869);
        if (C5115h.xGG == null) {
            C5115h.m7780g("WxSplash.SplashActivity", "permissions delegate is null, call splash finish directly.", new Object[0]);
            drm();
        } else if (!C5115h.xGG.mo10480a(this, new C50962())) {
            drk();
            AppMethodBeat.m2505o(114869);
            return;
        }
        AppMethodBeat.m2505o(114869);
    }

    private void drm() {
        AppMethodBeat.m2504i(114870);
        if (this.xGZ) {
            AppMethodBeat.m2505o(114870);
            return;
        }
        this.xGZ = true;
        if (isFinishing()) {
            onBackPressed();
        } else {
            setResult(-100);
            int intExtra = getIntent().getIntExtra("hashcode", 0);
            Iterator it = C5115h.xGC.iterator();
            while (it.hasNext()) {
                C5117i c5117i = (C5117i) it.next();
                if (intExtra == c5117i.hashCode()) {
                    C5115h.m7771a(c5117i);
                    break;
                }
            }
            new Handler().postDelayed(new C50973(), 50);
        }
        new Handler().postDelayed(new C50984(), 30000);
        AppMethodBeat.m2505o(114870);
    }

    /* renamed from: d */
    static /* synthetic */ void m7732d(SplashActivity splashActivity) {
        AppMethodBeat.m2504i(114872);
        splashActivity.overridePendingTransition(C25738R.anim.f8411dp, C25738R.anim.f8410do);
        AppMethodBeat.m2505o(114872);
    }
}
