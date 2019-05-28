package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Timer;
import java.util.TimerTask;

final class m {
    final MultiContextV8 chm;
    final c cid;
    Timer cie;
    final Runnable cif = new Runnable() {
        public final void run() {
            AppMethodBeat.i(113854);
            m.this.chm.debuggerMessageLoop();
            AppMethodBeat.o(113854);
        }
    };

    /* renamed from: com.tencent.mm.d.a.m$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String chV;

        AnonymousClass1(String str) {
            this.chV = str;
        }

        public final void run() {
            AppMethodBeat.i(113852);
            if (m.this.chm == null) {
                IllegalStateException illegalStateException = new IllegalStateException("V8DebuggerHelper v8 null");
                AppMethodBeat.o(113852);
                throw illegalStateException;
            }
            m.this.chm.waitForDebugger(this.chV);
            m mVar = m.this;
            if (mVar.cie == null) {
                mVar.cie = new Timer();
                mVar.cie.schedule(new TimerTask() {
                    public final void run() {
                        AppMethodBeat.i(113855);
                        m.this.cid.k(m.this.cif);
                        AppMethodBeat.o(113855);
                    }
                }, FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            }
            AppMethodBeat.o(113852);
        }
    }

    public m(MultiContextV8 multiContextV8, c cVar) {
        AppMethodBeat.i(113856);
        this.chm = multiContextV8;
        this.cid = cVar;
        AppMethodBeat.o(113856);
    }
}
