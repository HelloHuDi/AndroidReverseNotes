package com.tencent.p177mm.p224d.p225a;

import com.eclipsesource.p097v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.d.a.m */
final class C9260m {
    final MultiContextV8 chm;
    final C45301c cid;
    Timer cie;
    final Runnable cif = new C92623();

    /* renamed from: com.tencent.mm.d.a.m$2 */
    class C92612 implements Runnable {
        C92612() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113853);
            if (C9260m.this.cie != null) {
                C9260m.this.cie.cancel();
            }
            AppMethodBeat.m2505o(113853);
        }
    }

    /* renamed from: com.tencent.mm.d.a.m$3 */
    class C92623 implements Runnable {
        C92623() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113854);
            C9260m.this.chm.debuggerMessageLoop();
            AppMethodBeat.m2505o(113854);
        }
    }

    /* renamed from: com.tencent.mm.d.a.m$1 */
    class C92631 implements Runnable {
        final /* synthetic */ String chV;

        C92631(String str) {
            this.chV = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(113852);
            if (C9260m.this.chm == null) {
                IllegalStateException illegalStateException = new IllegalStateException("V8DebuggerHelper v8 null");
                AppMethodBeat.m2505o(113852);
                throw illegalStateException;
            }
            C9260m.this.chm.waitForDebugger(this.chV);
            C9260m c9260m = C9260m.this;
            if (c9260m.cie == null) {
                c9260m.cie = new Timer();
                c9260m.cie.schedule(new C92644(), FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            }
            AppMethodBeat.m2505o(113852);
        }
    }

    /* renamed from: com.tencent.mm.d.a.m$4 */
    class C92644 extends TimerTask {
        C92644() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113855);
            C9260m.this.cid.mo73187k(C9260m.this.cif);
            AppMethodBeat.m2505o(113855);
        }
    }

    public C9260m(MultiContextV8 multiContextV8, C45301c c45301c) {
        AppMethodBeat.m2504i(113856);
        this.chm = multiContextV8;
        this.cid = c45301c;
        AppMethodBeat.m2505o(113856);
    }
}
