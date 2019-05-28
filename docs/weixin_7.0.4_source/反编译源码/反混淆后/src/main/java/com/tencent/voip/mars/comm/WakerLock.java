package com.tencent.voip.mars.comm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WakerLock {
    private static final String TAG = "MicroMsg.WakerLock";
    private Handler mHandler = null;
    private Runnable mReleaser = new C59921();
    private WakeLock wakeLock = null;

    /* renamed from: com.tencent.voip.mars.comm.WakerLock$1 */
    class C59921 implements Runnable {
        C59921() {
        }

        public void run() {
            AppMethodBeat.m2504i(92745);
            WakerLock.this.unLock();
            AppMethodBeat.m2505o(92745);
        }
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public WakerLock(Context context) {
        AppMethodBeat.m2504i(92751);
        this.wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, TAG);
        this.wakeLock.setReferenceCounted(false);
        this.mHandler = new Handler(context.getMainLooper());
        AppMethodBeat.m2505o(92751);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(92752);
        unLock();
        AppMethodBeat.m2505o(92752);
    }

    public void lock(long j) {
        AppMethodBeat.m2504i(92753);
        try {
            lock();
            this.mHandler.postDelayed(this.mReleaser, j);
            AppMethodBeat.m2505o(92753);
        } catch (Exception e) {
            AppMethodBeat.m2505o(92753);
        }
    }

    public void lock() {
        AppMethodBeat.m2504i(92754);
        try {
            this.mHandler.removeCallbacks(this.mReleaser);
            this.wakeLock.acquire();
            AppMethodBeat.m2505o(92754);
        } catch (Exception e) {
            AppMethodBeat.m2505o(92754);
        }
    }

    public void unLock() {
        AppMethodBeat.m2504i(92755);
        try {
            this.mHandler.removeCallbacks(this.mReleaser);
            if (this.wakeLock.isHeld()) {
                this.wakeLock.release();
            }
            AppMethodBeat.m2505o(92755);
        } catch (Exception e) {
            AppMethodBeat.m2505o(92755);
        }
    }

    public boolean isLocking() {
        AppMethodBeat.m2504i(92756);
        try {
            boolean isHeld = this.wakeLock.isHeld();
            AppMethodBeat.m2505o(92756);
            return isHeld;
        } catch (Exception e) {
            AppMethodBeat.m2505o(92756);
            return false;
        }
    }
}
