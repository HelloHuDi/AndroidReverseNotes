package com.tencent.p177mm.p224d.p225a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.eclipsesource.p097v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C9254d.C9255a;

/* renamed from: com.tencent.mm.d.a.h */
public final class C32481h implements C9254d {
    private final C32482a chA;
    private C9255a chz = null;
    private final Looper mLooper;

    /* renamed from: com.tencent.mm.d.a.h$a */
    class C32482a extends Handler {
        C32482a(Looper looper) {
            super(looper);
        }

        public final void dispatchMessage(Message message) {
            AppMethodBeat.m2504i(113804);
            try {
                super.dispatchMessage(message);
                AppMethodBeat.m2505o(113804);
            } catch (V8ScriptException e) {
                C32481h.this.mo53115c(e);
                AppMethodBeat.m2505o(113804);
            }
        }
    }

    C32481h(Looper looper) {
        AppMethodBeat.m2504i(113805);
        this.mLooper = looper;
        this.chA = new C32482a(looper);
        AppMethodBeat.m2505o(113805);
    }

    public final void loop() {
        AppMethodBeat.m2504i(113806);
        Looper.loop();
        AppMethodBeat.m2505o(113806);
    }

    /* renamed from: Cs */
    public final boolean mo20666Cs() {
        AppMethodBeat.m2504i(113807);
        if (this.mLooper.getThread().getId() == Thread.currentThread().getId()) {
            AppMethodBeat.m2505o(113807);
            return true;
        }
        AppMethodBeat.m2505o(113807);
        return false;
    }

    /* renamed from: m */
    public final void mo20670m(Runnable runnable) {
        AppMethodBeat.m2504i(113808);
        if (runnable == null) {
            AppMethodBeat.m2505o(113808);
        } else if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
            try {
                runnable.run();
                AppMethodBeat.m2505o(113808);
            } catch (V8ScriptException e) {
                mo53115c(e);
                AppMethodBeat.m2505o(113808);
            }
        } else {
            this.chA.post(runnable);
            AppMethodBeat.m2505o(113808);
        }
    }

    /* renamed from: g */
    public final void mo20668g(Runnable runnable, long j) {
        AppMethodBeat.m2504i(113809);
        this.chA.postDelayed(runnable, j);
        AppMethodBeat.m2505o(113809);
    }

    public final void pause() {
    }

    public final void resume() {
    }

    public final void quit() {
        AppMethodBeat.m2504i(113810);
        this.mLooper.quitSafely();
        AppMethodBeat.m2505o(113810);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo53115c(V8ScriptException v8ScriptException) {
        AppMethodBeat.m2504i(113811);
        if (this.chz != null) {
            this.chz.mo20674b(v8ScriptException);
        }
        AppMethodBeat.m2505o(113811);
    }

    /* renamed from: a */
    public final void mo20667a(C9255a c9255a) {
        this.chz = c9255a;
    }
}
