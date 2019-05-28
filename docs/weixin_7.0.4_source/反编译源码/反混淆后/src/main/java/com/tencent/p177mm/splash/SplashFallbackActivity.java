package com.tencent.p177mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.io.File;

/* renamed from: com.tencent.mm.splash.SplashFallbackActivity */
public class SplashFallbackActivity extends Activity {
    private Handler mHandler;
    private Runnable xHb = new C50991();

    /* renamed from: com.tencent.mm.splash.SplashFallbackActivity$1 */
    class C50991 implements Runnable {
        private long xHc = -1;

        C50991() {
        }

        public final void run() {
            AppMethodBeat.m2504i(114873);
            if (this.xHc == -1) {
                this.xHc = System.currentTimeMillis();
            }
            if (SplashFallbackActivity.drn()) {
                C5115h.m7780g("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone true", new Object[0]);
                SplashFallbackActivity.this.finish();
                SplashFallbackActivity.this.overridePendingTransition(C25738R.anim.f8411dp, C25738R.anim.f8409dn);
                AppMethodBeat.m2505o(114873);
            } else if (System.currentTimeMillis() - this.xHc >= 80000) {
                C5115h.m7780g("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone timeout", new Object[0]);
                SplashFallbackActivity.this.finish();
                SplashFallbackActivity.this.overridePendingTransition(C25738R.anim.f8411dp, C25738R.anim.f8409dn);
                AppMethodBeat.m2505o(114873);
            } else {
                SplashFallbackActivity.this.mHandler.postDelayed(SplashFallbackActivity.this.xHb, 100);
                AppMethodBeat.m2505o(114873);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SplashFallbackActivity() {
        AppMethodBeat.m2504i(114874);
        AppMethodBeat.m2505o(114874);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(114875);
        super.onCreate(bundle);
        C5115h.m7780g("MicroMsg.FallbackSplash", "onCreate", new Object[0]);
        HandlerThread handlerThread = new HandlerThread("splash-activity");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mHandler.postDelayed(this.xHb, 100);
        AppMethodBeat.m2505o(114875);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(114876);
        C5115h.m7780g("MicroMsg.FallbackSplash", "block onBackPressed", new Object[0]);
        AppMethodBeat.m2505o(114876);
    }

    static /* synthetic */ boolean drn() {
        AppMethodBeat.m2504i(114877);
        String dqR = C5102a.dqR();
        if (!new File(dqR).exists()) {
            C5115h.m7780g("MicroMsg.FigLeaf", "dex opt dir not exists.", new Object[0]);
        } else if (new File(dqR + "/main-process-blocking").exists()) {
            AppMethodBeat.m2505o(114877);
            return false;
        }
        AppMethodBeat.m2505o(114877);
        return true;
    }
}
