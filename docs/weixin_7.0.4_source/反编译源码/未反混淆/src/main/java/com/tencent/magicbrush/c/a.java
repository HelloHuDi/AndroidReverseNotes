package com.tencent.magicbrush.c;

import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements FrameCallback {
    private volatile MBRuntime bSg;
    private boolean bUt;
    private volatile boolean bUu;
    com.tencent.magicbrush.handler.a bUv;
    a bUw;
    Choreographer bsZ;

    class a implements FrameCallback, Runnable {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void doFrame(long j) {
            AppMethodBeat.i(115990);
            a.this.bUv.f(this);
            AppMethodBeat.o(115990);
        }

        public final void run() {
            AppMethodBeat.i(115991);
            a.this.bsZ.postFrameCallback(a.this.bUw);
            a.this.doFrame(System.nanoTime());
            AppMethodBeat.o(115991);
        }
    }

    public a(MBRuntime mBRuntime, com.tencent.magicbrush.handler.a aVar) {
        this(mBRuntime, aVar, (byte) 0);
    }

    private a(MBRuntime mBRuntime, com.tencent.magicbrush.handler.a aVar, byte b) {
        AppMethodBeat.i(115992);
        this.bUt = false;
        this.bUu = false;
        this.bUw = new a(this, (byte) 0);
        this.bSg = mBRuntime;
        this.bUv = aVar;
        c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in JsThread...", new Object[0]);
        aVar.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115989);
                if (Looper.myLooper() == null) {
                    c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in JsThread...[Looper missing]", new Object[0]);
                    a.e(a.this);
                    AppMethodBeat.o(115989);
                    return;
                }
                synchronized (a.this) {
                    try {
                        a.this.bsZ = Choreographer.getInstance();
                        if (a.this.bUt) {
                            c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in JsThread...[start in resume mode]", new Object[0]);
                            a.this.bsZ.postFrameCallback(a.this);
                        }
                        c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in JsThread...[done]", new Object[0]);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(115989);
                    }
                }
            }
        });
        AppMethodBeat.o(115992);
    }

    public final synchronized void resume() {
        AppMethodBeat.i(115993);
        c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "Resuming AnimationFrameHandler", new Object[0]);
        this.bUt = true;
        if (this.bsZ != null) {
            if (this.bUu) {
                this.bsZ.removeFrameCallback(this.bUw);
                this.bsZ.postFrameCallback(this.bUw);
                AppMethodBeat.o(115993);
            } else {
                this.bsZ.removeFrameCallback(this);
                this.bsZ.postFrameCallback(this);
            }
        }
        AppMethodBeat.o(115993);
    }

    public final synchronized void pause() {
        AppMethodBeat.i(115994);
        c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "Pausing AnimationFrameHandler", new Object[0]);
        this.bUt = false;
        if (this.bsZ != null) {
            if (this.bUu) {
                this.bsZ.removeFrameCallback(this.bUw);
                AppMethodBeat.o(115994);
            } else {
                this.bsZ.removeFrameCallback(this);
            }
        }
        AppMethodBeat.o(115994);
    }

    public final synchronized void destroy() {
        AppMethodBeat.i(115995);
        c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "Destroying AnimationFrameHandler", new Object[0]);
        pause();
        this.bsZ = null;
        c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "Destroy AnimationFrameHandler, done.", new Object[0]);
        AppMethodBeat.o(115995);
    }

    public final void doFrame(long j) {
        AppMethodBeat.i(115996);
        if (this.bUt && this.bsZ != null) {
            if (!this.bUu) {
                this.bsZ.postFrameCallback(this);
            }
            this.bSg.notifyAnimationFrame(((double) j) / 1000000.0d);
        }
        AppMethodBeat.o(115996);
    }

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(115997);
        c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in MainThread...", new Object[0]);
        com.tencent.magicbrush.d.c.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115988);
                synchronized (a.this) {
                    try {
                        a.this.bsZ = Choreographer.getInstance();
                        a.this.bUu = true;
                        if (a.this.bUt) {
                            c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in MainThread...[start in resume mode]", new Object[0]);
                            a.this.bsZ.postFrameCallback(a.this.bUw);
                        }
                        c.i("MicroMsg.MagicBrush.AnimationFrameHandler", "MBRuntime trying to use Choreographer in MainThread...[done]", new Object[0]);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(115988);
                    }
                }
            }
        });
        AppMethodBeat.o(115997);
    }
}
