package com.tencent.view;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c {
    private static c AIK;
    private a AIL = null;
    String AIM;
    private Handler handler;
    public HandlerThread mGlThread;

    private c() {
        AppMethodBeat.i(86633);
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(86631);
                c.this.AIL = new a();
                a a = c.this.AIL;
                if (a.mEGLConfig != null) {
                    a.mEGL.eglMakeCurrent(a.mEGLDisplay, a.mEGLSurface, a.mEGLSurface, a.mEGLContext);
                }
                c.this.AIM = Thread.currentThread().getName();
                AppMethodBeat.o(86631);
            }
        };
        this.mGlThread = new HandlerThread("GlThread") {
            /* Access modifiers changed, original: protected|final */
            public final void onLooperPrepared() {
                AppMethodBeat.i(86632);
                super.onLooperPrepared();
                AppMethodBeat.o(86632);
            }
        };
        this.mGlThread.start();
        this.handler = new Handler(this.mGlThread.getLooper());
        this.handler.post(anonymousClass1);
        AppMethodBeat.o(86633);
    }

    public static c dSN() {
        c cVar;
        AppMethodBeat.i(86634);
        if (AIK == null) {
            synchronized (c.class) {
                try {
                    if (AIK == null) {
                        synchronized (c.class) {
                            cVar = new c();
                        }
                        AIK = cVar;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(86634);
                }
            }
        }
        cVar = AIK;
        AppMethodBeat.o(86634);
        return cVar;
    }

    public final void queue(Runnable runnable) {
        AppMethodBeat.i(86635);
        this.handler.post(runnable);
        AppMethodBeat.o(86635);
    }
}
