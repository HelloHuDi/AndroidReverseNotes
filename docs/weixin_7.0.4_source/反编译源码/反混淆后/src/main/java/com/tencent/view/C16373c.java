package com.tencent.view;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.view.c */
public class C16373c {
    private static C16373c AIK;
    private C44568a AIL = null;
    String AIM;
    private Handler handler;
    public HandlerThread mGlThread;

    /* renamed from: com.tencent.view.c$1 */
    class C59901 implements Runnable {
        C59901() {
        }

        public final void run() {
            AppMethodBeat.m2504i(86631);
            C16373c.this.AIL = new C44568a();
            C44568a a = C16373c.this.AIL;
            if (a.mEGLConfig != null) {
                a.mEGL.eglMakeCurrent(a.mEGLDisplay, a.mEGLSurface, a.mEGLSurface, a.mEGLContext);
            }
            C16373c.this.AIM = Thread.currentThread().getName();
            AppMethodBeat.m2505o(86631);
        }
    }

    private C16373c() {
        AppMethodBeat.m2504i(86633);
        C59901 c59901 = new C59901();
        this.mGlThread = new HandlerThread("GlThread") {
            /* Access modifiers changed, original: protected|final */
            public final void onLooperPrepared() {
                AppMethodBeat.m2504i(86632);
                super.onLooperPrepared();
                AppMethodBeat.m2505o(86632);
            }
        };
        this.mGlThread.start();
        this.handler = new Handler(this.mGlThread.getLooper());
        this.handler.post(c59901);
        AppMethodBeat.m2505o(86633);
    }

    public static C16373c dSN() {
        C16373c c16373c;
        AppMethodBeat.m2504i(86634);
        if (AIK == null) {
            synchronized (C16373c.class) {
                try {
                    if (AIK == null) {
                        synchronized (C16373c.class) {
                            c16373c = new C16373c();
                        }
                        AIK = c16373c;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(86634);
                }
            }
        }
        c16373c = AIK;
        AppMethodBeat.m2505o(86634);
        return c16373c;
    }

    public final void queue(Runnable runnable) {
        AppMethodBeat.m2504i(86635);
        this.handler.post(runnable);
        AppMethodBeat.m2505o(86635);
    }
}
