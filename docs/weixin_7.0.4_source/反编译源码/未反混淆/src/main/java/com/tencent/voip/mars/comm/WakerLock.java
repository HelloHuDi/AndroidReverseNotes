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
    private Runnable mReleaser = new Runnable() {
        public void run() {
            AppMethodBeat.i(92745);
            WakerLock.this.unLock();
            AppMethodBeat.o(92745);
        }
    };
    private WakeLock wakeLock = null;

    @SuppressLint({"InvalidWakeLockTag"})
    public WakerLock(Context context) {
        AppMethodBeat.i(92751);
        this.wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, TAG);
        this.wakeLock.setReferenceCounted(false);
        this.mHandler = new Handler(context.getMainLooper());
        AppMethodBeat.o(92751);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(92752);
        unLock();
        AppMethodBeat.o(92752);
    }

    public void lock(long j) {
        AppMethodBeat.i(92753);
        try {
            lock();
            this.mHandler.postDelayed(this.mReleaser, j);
            AppMethodBeat.o(92753);
        } catch (Exception e) {
            AppMethodBeat.o(92753);
        }
    }

    public void lock() {
        AppMethodBeat.i(92754);
        try {
            this.mHandler.removeCallbacks(this.mReleaser);
            this.wakeLock.acquire();
            AppMethodBeat.o(92754);
        } catch (Exception e) {
            AppMethodBeat.o(92754);
        }
    }

    public void unLock() {
        AppMethodBeat.i(92755);
        try {
            this.mHandler.removeCallbacks(this.mReleaser);
            if (this.wakeLock.isHeld()) {
                this.wakeLock.release();
            }
            AppMethodBeat.o(92755);
        } catch (Exception e) {
            AppMethodBeat.o(92755);
        }
    }

    public boolean isLocking() {
        AppMethodBeat.i(92756);
        try {
            boolean isHeld = this.wakeLock.isHeld();
            AppMethodBeat.o(92756);
            return isHeld;
        } catch (Exception e) {
            AppMethodBeat.o(92756);
            return false;
        }
    }
}
