package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.basic.util.c */
public class C17779c {
    /* renamed from: a */
    private Handler f4142a;
    /* renamed from: b */
    private Looper f4143b;
    /* renamed from: c */
    private boolean f4144c = true;
    /* renamed from: d */
    private Thread f4145d;

    public C17779c(String str) {
        AppMethodBeat.m2504i(66041);
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.f4143b = handlerThread.getLooper();
        this.f4142a = new Handler(this.f4143b);
        this.f4145d = handlerThread;
        AppMethodBeat.m2505o(66041);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(66042);
        if (this.f4144c) {
            this.f4142a.getLooper().quit();
        }
        super.finalize();
        AppMethodBeat.m2505o(66042);
    }

    /* renamed from: a */
    public void mo32893a(final Runnable runnable) {
        AppMethodBeat.m2504i(66043);
        final boolean[] zArr = new boolean[1];
        if (Thread.currentThread().equals(this.f4145d)) {
            runnable.run();
            AppMethodBeat.m2505o(66043);
            return;
        }
        synchronized (this.f4142a) {
            try {
                zArr[0] = false;
                this.f4142a.post(new Runnable() {
                    public void run() {
                        AppMethodBeat.m2504i(66022);
                        runnable.run();
                        zArr[0] = true;
                        synchronized (C17779c.this.f4142a) {
                            try {
                                C17779c.this.f4142a.notifyAll();
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.m2505o(66022);
                            }
                        }
                    }
                });
                while (!zArr[0]) {
                    try {
                        this.f4142a.wait();
                    } catch (Exception e) {
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66043);
            }
        }
    }

    /* renamed from: b */
    public void mo32894b(Runnable runnable) {
        AppMethodBeat.m2504i(66044);
        this.f4142a.post(runnable);
        AppMethodBeat.m2505o(66044);
    }
}
