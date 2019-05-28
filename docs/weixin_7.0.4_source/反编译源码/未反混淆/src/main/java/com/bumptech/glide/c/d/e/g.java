package com.bumptech.glide.c.d.e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.m;
import com.bumptech.glide.i;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class g {
    private m<Bitmap> aCk;
    final com.bumptech.glide.b.a aGb;
    private boolean aGc;
    private boolean aGd;
    private i<Bitmap> aGe;
    a aGf;
    boolean aGg;
    a aGh;
    Bitmap aGi;
    a aGj;
    final j awX;
    private final e awf;
    final List<b> callbacks;
    private final Handler handler;
    boolean isRunning;

    static class a extends com.bumptech.glide.f.a.c<Bitmap> {
        private final long aGk;
        Bitmap aGl;
        private final Handler handler;
        final int index;

        public final /* synthetic */ void aa(Object obj) {
            AppMethodBeat.i(92342);
            this.aGl = (Bitmap) obj;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.aGk);
            AppMethodBeat.o(92342);
        }

        a(Handler handler, int i, long j) {
            this.handler = handler;
            this.index = i;
            this.aGk = j;
        }
    }

    public interface b {
        void nC();
    }

    class c implements Callback {
        c() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(92343);
            if (message.what == 1) {
                g.this.a((a) message.obj);
                AppMethodBeat.o(92343);
                return true;
            }
            if (message.what == 2) {
                g.this.awX.c((a) message.obj);
            }
            AppMethodBeat.o(92343);
            return false;
        }
    }

    g(com.bumptech.glide.c cVar, com.bumptech.glide.b.a aVar, int i, int i2, m<Bitmap> mVar, Bitmap bitmap) {
        this(cVar.awf, com.bumptech.glide.c.af(cVar.awi.getBaseContext()), aVar, com.bumptech.glide.c.af(cVar.awi.getBaseContext()).lI().a(com.bumptech.glide.f.e.a(com.bumptech.glide.c.b.i.aBj).nP().nQ().aU(i, i2)), (m) mVar, bitmap);
        AppMethodBeat.i(92344);
        AppMethodBeat.o(92344);
    }

    private g(e eVar, j jVar, com.bumptech.glide.b.a aVar, i<Bitmap> iVar, m<Bitmap> mVar, Bitmap bitmap) {
        AppMethodBeat.i(92345);
        this.callbacks = new ArrayList();
        this.awX = jVar;
        Handler handler = new Handler(Looper.getMainLooper(), new c());
        this.awf = eVar;
        this.handler = handler;
        this.aGe = iVar;
        this.aGb = aVar;
        a(mVar, bitmap);
        AppMethodBeat.o(92345);
    }

    /* Access modifiers changed, original: final */
    public final void a(b bVar) {
        AppMethodBeat.i(92347);
        IllegalStateException illegalStateException;
        if (this.aGg) {
            illegalStateException = new IllegalStateException("Cannot subscribe to a cleared frame loader");
            AppMethodBeat.o(92347);
            throw illegalStateException;
        } else if (this.callbacks.contains(bVar)) {
            illegalStateException = new IllegalStateException("Cannot subscribe twice in a row");
            AppMethodBeat.o(92347);
            throw illegalStateException;
        } else {
            boolean isEmpty = this.callbacks.isEmpty();
            this.callbacks.add(bVar);
            if (isEmpty) {
                start();
            }
            AppMethodBeat.o(92347);
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(b bVar) {
        AppMethodBeat.i(92348);
        this.callbacks.remove(bVar);
        if (this.callbacks.isEmpty()) {
            this.isRunning = false;
        }
        AppMethodBeat.o(92348);
    }

    /* Access modifiers changed, original: final */
    public final int getFrameCount() {
        AppMethodBeat.i(92349);
        int frameCount = this.aGb.getFrameCount();
        AppMethodBeat.o(92349);
        return frameCount;
    }

    private void start() {
        AppMethodBeat.i(92350);
        if (this.isRunning) {
            AppMethodBeat.o(92350);
            return;
        }
        this.isRunning = true;
        this.aGg = false;
        nE();
        AppMethodBeat.o(92350);
    }

    /* Access modifiers changed, original: final */
    public final Bitmap nD() {
        if (this.aGf != null) {
            return this.aGf.aGl;
        }
        return this.aGi;
    }

    private void nE() {
        AppMethodBeat.i(92351);
        if (!this.isRunning || this.aGc) {
            AppMethodBeat.o(92351);
            return;
        }
        if (this.aGd) {
            com.bumptech.glide.h.i.b(this.aGj == null, "Pending target must be null when starting from the first frame");
            this.aGb.lV();
            this.aGd = false;
        }
        if (this.aGj != null) {
            a aVar = this.aGj;
            this.aGj = null;
            a(aVar);
            AppMethodBeat.o(92351);
            return;
        }
        this.aGc = true;
        long lT = ((long) this.aGb.lT()) + SystemClock.uptimeMillis();
        this.aGb.advance();
        this.aGh = new a(this.handler, this.aGb.lU(), lT);
        this.aGe.a(com.bumptech.glide.f.e.e(nG())).Q(this.aGb).b(this.aGh);
        AppMethodBeat.o(92351);
    }

    /* Access modifiers changed, original: final */
    public final void nF() {
        AppMethodBeat.i(92352);
        if (this.aGi != null) {
            this.awf.g(this.aGi);
            this.aGi = null;
        }
        AppMethodBeat.o(92352);
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar) {
        AppMethodBeat.i(92353);
        this.aGc = false;
        if (this.aGg) {
            this.handler.obtainMessage(2, aVar).sendToTarget();
            AppMethodBeat.o(92353);
        } else if (this.isRunning) {
            if (aVar.aGl != null) {
                nF();
                a aVar2 = this.aGf;
                this.aGf = aVar;
                for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                    ((b) this.callbacks.get(size)).nC();
                }
                if (aVar2 != null) {
                    this.handler.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            nE();
            AppMethodBeat.o(92353);
        } else {
            this.aGj = aVar;
            AppMethodBeat.o(92353);
        }
    }

    private static h nG() {
        AppMethodBeat.i(92354);
        com.bumptech.glide.g.b bVar = new com.bumptech.glide.g.b(Double.valueOf(Math.random()));
        AppMethodBeat.o(92354);
        return bVar;
    }

    /* Access modifiers changed, original: final */
    public final void a(m<Bitmap> mVar, Bitmap bitmap) {
        AppMethodBeat.i(92346);
        this.aCk = (m) com.bumptech.glide.h.i.d(mVar, "Argument must not be null");
        this.aGi = (Bitmap) com.bumptech.glide.h.i.d(bitmap, "Argument must not be null");
        this.aGe = this.aGe.a(new com.bumptech.glide.f.e().a((m) mVar));
        AppMethodBeat.o(92346);
    }
}
