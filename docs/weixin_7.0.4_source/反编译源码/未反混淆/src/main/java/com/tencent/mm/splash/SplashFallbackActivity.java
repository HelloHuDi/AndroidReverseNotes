package com.tencent.mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.io.File;

public class SplashFallbackActivity extends Activity {
    private Handler mHandler;
    private Runnable xHb = new Runnable() {
        private long xHc = -1;

        public final void run() {
            AppMethodBeat.i(114873);
            if (this.xHc == -1) {
                this.xHc = System.currentTimeMillis();
            }
            if (SplashFallbackActivity.drn()) {
                h.g("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone true", new Object[0]);
                SplashFallbackActivity.this.finish();
                SplashFallbackActivity.this.overridePendingTransition(R.anim.dp, R.anim.dn);
                AppMethodBeat.o(114873);
            } else if (System.currentTimeMillis() - this.xHc >= 80000) {
                h.g("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone timeout", new Object[0]);
                SplashFallbackActivity.this.finish();
                SplashFallbackActivity.this.overridePendingTransition(R.anim.dp, R.anim.dn);
                AppMethodBeat.o(114873);
            } else {
                SplashFallbackActivity.this.mHandler.postDelayed(SplashFallbackActivity.this.xHb, 100);
                AppMethodBeat.o(114873);
            }
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SplashFallbackActivity() {
        AppMethodBeat.i(114874);
        AppMethodBeat.o(114874);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(114875);
        super.onCreate(bundle);
        h.g("MicroMsg.FallbackSplash", "onCreate", new Object[0]);
        HandlerThread handlerThread = new HandlerThread("splash-activity");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mHandler.postDelayed(this.xHb, 100);
        AppMethodBeat.o(114875);
    }

    public void onBackPressed() {
        AppMethodBeat.i(114876);
        h.g("MicroMsg.FallbackSplash", "block onBackPressed", new Object[0]);
        AppMethodBeat.o(114876);
    }

    static /* synthetic */ boolean drn() {
        AppMethodBeat.i(114877);
        String dqR = a.dqR();
        if (!new File(dqR).exists()) {
            h.g("MicroMsg.FigLeaf", "dex opt dir not exists.", new Object[0]);
        } else if (new File(dqR + "/main-process-blocking").exists()) {
            AppMethodBeat.o(114877);
            return false;
        }
        AppMethodBeat.o(114877);
        return true;
    }
}
