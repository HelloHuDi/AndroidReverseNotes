package com.tencent.mm.d.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h implements d {
    private final a chA;
    private com.tencent.mm.d.a.d.a chz = null;
    private final Looper mLooper;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public final void dispatchMessage(Message message) {
            AppMethodBeat.i(113804);
            try {
                super.dispatchMessage(message);
                AppMethodBeat.o(113804);
            } catch (V8ScriptException e) {
                h.this.c(e);
                AppMethodBeat.o(113804);
            }
        }
    }

    h(Looper looper) {
        AppMethodBeat.i(113805);
        this.mLooper = looper;
        this.chA = new a(looper);
        AppMethodBeat.o(113805);
    }

    public final void loop() {
        AppMethodBeat.i(113806);
        Looper.loop();
        AppMethodBeat.o(113806);
    }

    public final boolean Cs() {
        AppMethodBeat.i(113807);
        if (this.mLooper.getThread().getId() == Thread.currentThread().getId()) {
            AppMethodBeat.o(113807);
            return true;
        }
        AppMethodBeat.o(113807);
        return false;
    }

    public final void m(Runnable runnable) {
        AppMethodBeat.i(113808);
        if (runnable == null) {
            AppMethodBeat.o(113808);
        } else if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
            try {
                runnable.run();
                AppMethodBeat.o(113808);
            } catch (V8ScriptException e) {
                c(e);
                AppMethodBeat.o(113808);
            }
        } else {
            this.chA.post(runnable);
            AppMethodBeat.o(113808);
        }
    }

    public final void g(Runnable runnable, long j) {
        AppMethodBeat.i(113809);
        this.chA.postDelayed(runnable, j);
        AppMethodBeat.o(113809);
    }

    public final void pause() {
    }

    public final void resume() {
    }

    public final void quit() {
        AppMethodBeat.i(113810);
        this.mLooper.quitSafely();
        AppMethodBeat.o(113810);
    }

    /* Access modifiers changed, original: final */
    public final void c(V8ScriptException v8ScriptException) {
        AppMethodBeat.i(113811);
        if (this.chz != null) {
            this.chz.b(v8ScriptException);
        }
        AppMethodBeat.o(113811);
    }

    public final void a(com.tencent.mm.d.a.d.a aVar) {
        this.chz = aVar;
    }
}
