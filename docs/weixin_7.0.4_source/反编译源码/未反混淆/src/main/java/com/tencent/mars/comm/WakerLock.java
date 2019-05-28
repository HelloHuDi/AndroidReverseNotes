package com.tencent.mars.comm;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.jni.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class WakerLock {
    private static final String TAG = "MicroMsg.WakerLock";
    private static long lastChecktime = 0;
    private static Boolean shouldLock = null;
    private IAutoUnlockCallback autoUnlockCallback;
    private Context context;
    private String mCreatePosStackLine;
    private ak mHandler;
    private Runnable mReleaser;
    private WakeLock wakeLock;

    public interface IAutoUnlockCallback {
        void autoUnlockCallback();
    }

    private String getCallerStack() {
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (!stackTraceElement.getClassName().contains(WakerLock.class.getName())) {
                return stackTraceElement.toString();
            }
        }
        return "<native>";
    }

    public String getCreatePosStackLine() {
        return this.mCreatePosStackLine;
    }

    public WakerLock(Context context, String str, IAutoUnlockCallback iAutoUnlockCallback) {
        this(context, str);
        this.autoUnlockCallback = iAutoUnlockCallback;
    }

    public WakerLock(Context context, String str) {
        this.mCreatePosStackLine = null;
        this.wakeLock = null;
        this.mHandler = null;
        this.autoUnlockCallback = null;
        this.mReleaser = new Runnable() {
            public void run() {
                if (WakerLock.this.wakeLock.isHeld()) {
                    ab.w(WakerLock.TAG, "unlock by fucking handler! [%d,%d] @[%s]", Integer.valueOf(WakerLock.this.hashCode()), Integer.valueOf(WakerLock.this.wakeLock.hashCode()), WakerLock.this.mCreatePosStackLine);
                    WakerLock.this.unLock();
                    if (WakerLock.this.autoUnlockCallback != null) {
                        WakerLock.this.autoUnlockCallback.autoUnlockCallback();
                    }
                }
            }
        };
        this.mCreatePosStackLine = getCallerStack();
        this.wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, str);
        this.wakeLock.setReferenceCounted(false);
        this.mHandler = new ak(context.getMainLooper());
        this.context = context;
        ab.i(TAG, "init [%d,%d] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        ab.i(TAG, "finalize unlock [%d,%d] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine);
        unLock();
        super.finalize();
    }

    public void lock(long j) {
        lock(j, getCallerStack());
    }

    public void lock() {
        lock(getCallerStack());
    }

    public void lock(String str) {
        lock(-1, str);
    }

    public void lock(long j, String str) {
        try {
            if (this.wakeLock.isHeld()) {
                unLock();
            }
            a.a(this, str);
            ab.i(TAG, "lock [%d,%d] traceMsg:[%s] @[%s] limit time:%d", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), str, getCreatePosStackLine(), Long.valueOf(j));
            this.wakeLock.acquire();
            if (j == -1) {
                this.mHandler.removeCallbacks(this.mReleaser);
            } else {
                this.mHandler.postDelayed(this.mReleaser, j);
            }
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", "");
        }
    }

    public void unLock() {
        if (this.wakeLock.isHeld()) {
            this.mHandler.removeCallbacks(this.mReleaser);
            a.c(this);
            ab.i(TAG, "unlock [%d,%d] caller:[%s] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), getCallerStack(), getCreatePosStackLine());
            try {
                this.wakeLock.release();
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", "");
            }
        }
    }

    public boolean isLocking() {
        try {
            ab.i(TAG, "check is held [%d,%d] :%b caller:[%s] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), Boolean.valueOf(this.wakeLock.isHeld()), getCallerStack(), getCreatePosStackLine());
            return this.wakeLock.isHeld();
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", "");
            return false;
        }
    }

    public int innerWakeLockHashCode() {
        return this.wakeLock.hashCode();
    }
}
