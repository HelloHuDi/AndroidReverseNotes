package com.tencent.magicbrush.p149c;

import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.C17841a;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.magicbrush.p821d.C37415c;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.magicbrush.c.a */
public final class C1002a implements FrameCallback {
    private volatile MBRuntime bSg;
    private boolean bUt;
    private volatile boolean bUu;
    C17841a bUv;
    C1003a bUw;
    Choreographer bsZ;

    /* renamed from: com.tencent.magicbrush.c.a$a */
    class C1003a implements FrameCallback, Runnable {
        private C1003a() {
        }

        /* synthetic */ C1003a(C1002a c1002a, byte b) {
            this();
        }

        public final void doFrame(long j) {
            AppMethodBeat.m2504i(115990);
            C1002a.this.bUv.mo33017f(this);
            AppMethodBeat.m2505o(115990);
        }

        public final void run() {
            AppMethodBeat.m2504i(115991);
            C1002a.this.bsZ.postFrameCallback(C1002a.this.bUw);
            C1002a.this.doFrame(System.nanoTime());
            AppMethodBeat.m2505o(115991);
        }
    }

    /* renamed from: com.tencent.magicbrush.c.a$1 */
    class C10041 implements Runnable {
        C10041() {
        }

        public final void run() {
            AppMethodBeat.m2504i(115988);
            synchronized (C1002a.this) {
                try {
                    C1002a.this.bsZ = Choreographer.getInstance();
                    C1002a.this.bUu = true;
                    if (C1002a.this.bUt) {
                        C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in MainThread...[start in resume mode]", new Object[0]);
                        C1002a.this.bsZ.postFrameCallback(C1002a.this.bUw);
                    }
                    C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in MainThread...[done]", new Object[0]);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(115988);
                }
            }
        }
    }

    /* renamed from: com.tencent.magicbrush.c.a$2 */
    class C10052 implements Runnable {
        C10052() {
        }

        public final void run() {
            AppMethodBeat.m2504i(115989);
            if (Looper.myLooper() == null) {
                C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in JsThread...[Looper missing]", new Object[0]);
                C1002a.m2273e(C1002a.this);
                AppMethodBeat.m2505o(115989);
                return;
            }
            synchronized (C1002a.this) {
                try {
                    C1002a.this.bsZ = Choreographer.getInstance();
                    if (C1002a.this.bUt) {
                        C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in JsThread...[start in resume mode]", new Object[0]);
                        C1002a.this.bsZ.postFrameCallback(C1002a.this);
                    }
                    C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in JsThread...[done]", new Object[0]);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(115989);
                }
            }
        }
    }

    public C1002a(MBRuntime mBRuntime, C17841a c17841a) {
        this(mBRuntime, c17841a, (byte) 0);
    }

    private C1002a(MBRuntime mBRuntime, C17841a c17841a, byte b) {
        AppMethodBeat.m2504i(115992);
        this.bUt = false;
        this.bUu = false;
        this.bUw = new C1003a(this, (byte) 0);
        this.bSg = mBRuntime;
        this.bUv = c17841a;
        C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in JsThread...", new Object[0]);
        c17841a.mo33017f(new C10052());
        AppMethodBeat.m2505o(115992);
    }

    public final synchronized void resume() {
        AppMethodBeat.m2504i(115993);
        C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "Resuming AnimationFrameHandler", new Object[0]);
        this.bUt = true;
        if (this.bsZ != null) {
            if (this.bUu) {
                this.bsZ.removeFrameCallback(this.bUw);
                this.bsZ.postFrameCallback(this.bUw);
                AppMethodBeat.m2505o(115993);
            } else {
                this.bsZ.removeFrameCallback(this);
                this.bsZ.postFrameCallback(this);
            }
        }
        AppMethodBeat.m2505o(115993);
    }

    public final synchronized void pause() {
        AppMethodBeat.m2504i(115994);
        C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "Pausing AnimationFrameHandler", new Object[0]);
        this.bUt = false;
        if (this.bsZ != null) {
            if (this.bUu) {
                this.bsZ.removeFrameCallback(this.bUw);
                AppMethodBeat.m2505o(115994);
            } else {
                this.bsZ.removeFrameCallback(this);
            }
        }
        AppMethodBeat.m2505o(115994);
    }

    public final synchronized void destroy() {
        AppMethodBeat.m2504i(115995);
        C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "Destroying AnimationFrameHandler", new Object[0]);
        pause();
        this.bsZ = null;
        C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "Destroy AnimationFrameHandler, done.", new Object[0]);
        AppMethodBeat.m2505o(115995);
    }

    public final void doFrame(long j) {
        AppMethodBeat.m2504i(115996);
        if (this.bUt && this.bsZ != null) {
            if (!this.bUu) {
                this.bsZ.postFrameCallback(this);
            }
            this.bSg.notifyAnimationFrame(((double) j) / 1000000.0d);
        }
        AppMethodBeat.m2505o(115996);
    }

    /* renamed from: e */
    static /* synthetic */ void m2273e(C1002a c1002a) {
        AppMethodBeat.m2504i(115997);
        C17837c.m27916i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in MainThread...", new Object[0]);
        C37415c.runOnUiThread(new C10041());
        AppMethodBeat.m2505o(115997);
    }
}
