package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WaitNotify {
    private static final String TAG = "WaitNotify";
    private volatile boolean isWaiting = false;
    private final MonitorObject myMonitorObject = new MonitorObject();
    private volatile boolean wasSignalled = false;

    public interface WaitListener {
        boolean keepWaiting();
    }

    public WaitNotify() {
        AppMethodBeat.i(128382);
        AppMethodBeat.o(128382);
    }

    public boolean isWaiting() {
        return this.isWaiting;
    }

    public void doWait() {
        AppMethodBeat.i(128383);
        doWait(Long.MAX_VALUE, 0, new WaitListener() {
            public boolean keepWaiting() {
                return true;
            }
        });
        AppMethodBeat.o(128383);
    }

    public void doWait(long j, int i, WaitListener waitListener) {
        int i2 = 0;
        AppMethodBeat.i(128384);
        Logger.d(TAG, "doWait " + Thread.currentThread().getName());
        synchronized (this.myMonitorObject) {
            try {
                this.wasSignalled = false;
                while (true) {
                    int i3 = i2;
                    if (this.wasSignalled) {
                        break;
                    }
                    Logger.d(TAG, "doWait internal " + Thread.currentThread().getName());
                    this.isWaiting = true;
                    if (i3 < i) {
                        this.myMonitorObject.wait(j, 0);
                        if (!waitListener.keepWaiting()) {
                            doNotify();
                            break;
                        }
                    }
                    this.myMonitorObject.wait();
                    Logger.d(TAG, "doWait wake " + Thread.currentThread().getName());
                    i2 = i3 + 1;
                }
                this.isWaiting = false;
            } catch (InterruptedException e) {
                Logger.e(TAG, e.toString());
            } catch (Throwable th) {
                AppMethodBeat.o(128384);
            }
        }
        AppMethodBeat.o(128384);
    }

    public void doNotify() {
        AppMethodBeat.i(128385);
        Logger.d(TAG, "doNotify " + Thread.currentThread().getName());
        synchronized (this.myMonitorObject) {
            try {
                this.wasSignalled = true;
                Logger.d(TAG, "doNotify internal " + Thread.currentThread().getName());
                this.myMonitorObject.notifyAll();
                Logger.d(TAG, "doNotify over " + Thread.currentThread().getName());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(128385);
            }
        }
    }
}
