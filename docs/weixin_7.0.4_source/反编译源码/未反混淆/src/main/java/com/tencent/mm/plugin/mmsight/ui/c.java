package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {
    boolean cFy;
    private int duration;
    float end;
    long eyR;
    ap fJs = null;
    private float oCe = 0.0f;
    float oCf;
    a oCg;
    private Runnable oCh = new Runnable() {
        public final void run() {
            AppMethodBeat.i(55177);
            c.a(c.this);
            if (!c.this.cFy) {
                ab.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
            } else if (c.this.oCf < c.this.end) {
                c.this.fJs.post(this);
                AppMethodBeat.o(55177);
                return;
            } else {
                c.this.cFy = false;
                ab.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s", Float.valueOf(c.this.oCf), Float.valueOf(c.this.end));
                if (c.this.oCg != null) {
                    c.this.oCg.onAnimationEnd();
                    AppMethodBeat.o(55177);
                    return;
                }
            }
            AppMethodBeat.o(55177);
        }
    };
    private float start;

    public interface a {
        void aO(float f);

        void onAnimationEnd();
    }

    public c(float f, float f2, int i) {
        AppMethodBeat.i(55178);
        this.start = f;
        this.end = f2;
        this.duration = i;
        if (f2 > f) {
            this.oCe = ((f2 - f) / ((float) this.duration)) * 20.0f;
        }
        ab.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Float.valueOf(this.oCe));
        this.cFy = false;
        this.eyR = 0;
        this.fJs = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(55176);
                c.a(c.this);
                if (!c.this.cFy) {
                    ab.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
                    AppMethodBeat.o(55176);
                    return false;
                } else if (c.this.oCf < c.this.end) {
                    AppMethodBeat.o(55176);
                    return true;
                } else {
                    c.this.cFy = false;
                    ab.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", Float.valueOf(c.this.oCf), Float.valueOf(c.this.end), c.this.oCg);
                    if (c.this.oCg != null) {
                        c.this.oCg.onAnimationEnd();
                    }
                    AppMethodBeat.o(55176);
                    return false;
                }
            }
        }, true);
        AppMethodBeat.o(55178);
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(55179);
        cVar.oCf = (((float) bo.az(cVar.eyR)) / ((float) cVar.duration)) * (cVar.end - cVar.start);
        if (cVar.oCg != null) {
            cVar.oCg.aO(cVar.oCf);
        }
        AppMethodBeat.o(55179);
    }
}
