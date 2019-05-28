package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c {
    private Handler a;
    private Looper b;
    private boolean c = true;
    private Thread d;

    public c(String str) {
        AppMethodBeat.i(66041);
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.b = handlerThread.getLooper();
        this.a = new Handler(this.b);
        this.d = handlerThread;
        AppMethodBeat.o(66041);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(66042);
        if (this.c) {
            this.a.getLooper().quit();
        }
        super.finalize();
        AppMethodBeat.o(66042);
    }

    public void a(final Runnable runnable) {
        AppMethodBeat.i(66043);
        final boolean[] zArr = new boolean[1];
        if (Thread.currentThread().equals(this.d)) {
            runnable.run();
            AppMethodBeat.o(66043);
            return;
        }
        synchronized (this.a) {
            try {
                zArr[0] = false;
                this.a.post(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(66022);
                        runnable.run();
                        zArr[0] = true;
                        synchronized (c.this.a) {
                            try {
                                c.this.a.notifyAll();
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(66022);
                            }
                        }
                    }
                });
                while (!zArr[0]) {
                    try {
                        this.a.wait();
                    } catch (Exception e) {
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66043);
            }
        }
    }

    public void b(Runnable runnable) {
        AppMethodBeat.i(66044);
        this.a.post(runnable);
        AppMethodBeat.o(66044);
    }
}
