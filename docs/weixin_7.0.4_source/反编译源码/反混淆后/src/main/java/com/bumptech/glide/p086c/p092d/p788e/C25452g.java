package com.bumptech.glide.p086c.p092d.p788e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.C8555c;
import com.bumptech.glide.C8562i;
import com.bumptech.glide.C8565j;
import com.bumptech.glide.p085b.C25400a;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C31970m;
import com.bumptech.glide.p086c.p088b.C31938i;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.bumptech.glide.p095h.C8561i;
import com.bumptech.glide.p1157g.C17555b;
import com.bumptech.glide.p791f.C41570e;
import com.bumptech.glide.p791f.p1156a.C25456c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.c.d.e.g */
final class C25452g {
    private C31970m<Bitmap> aCk;
    final C25400a aGb;
    private boolean aGc;
    private boolean aGd;
    private C8562i<Bitmap> aGe;
    C8551a aGf;
    boolean aGg;
    C8551a aGh;
    Bitmap aGi;
    C8551a aGj;
    final C8565j awX;
    private final C31925e awf;
    final List<C8552b> callbacks;
    private final Handler handler;
    boolean isRunning;

    /* renamed from: com.bumptech.glide.c.d.e.g$a */
    static class C8551a extends C25456c<Bitmap> {
        private final long aGk;
        Bitmap aGl;
        private final Handler handler;
        final int index;

        /* renamed from: aa */
        public final /* synthetic */ void mo18652aa(Object obj) {
            AppMethodBeat.m2504i(92342);
            this.aGl = (Bitmap) obj;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.aGk);
            AppMethodBeat.m2505o(92342);
        }

        C8551a(Handler handler, int i, long j) {
            this.handler = handler;
            this.index = i;
            this.aGk = j;
        }
    }

    /* renamed from: com.bumptech.glide.c.d.e.g$b */
    public interface C8552b {
        /* renamed from: nC */
        void mo18653nC();
    }

    /* renamed from: com.bumptech.glide.c.d.e.g$c */
    class C25451c implements Callback {
        C25451c() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(92343);
            if (message.what == 1) {
                C25452g.this.mo42487a((C8551a) message.obj);
                AppMethodBeat.m2505o(92343);
                return true;
            }
            if (message.what == 2) {
                C25452g.this.awX.mo18674c((C8551a) message.obj);
            }
            AppMethodBeat.m2505o(92343);
            return false;
        }
    }

    C25452g(C8555c c8555c, C25400a c25400a, int i, int i2, C31970m<Bitmap> c31970m, Bitmap bitmap) {
        this(c8555c.awf, C8555c.m15205af(c8555c.awi.getBaseContext()), c25400a, C8555c.m15205af(c8555c.awi.getBaseContext()).mo18677lI().mo18670a(C41570e.m72766a(C31938i.aBj).mo66590nP().mo66591nQ().mo66584aU(i, i2)), (C31970m) c31970m, bitmap);
        AppMethodBeat.m2504i(92344);
        AppMethodBeat.m2505o(92344);
    }

    private C25452g(C31925e c31925e, C8565j c8565j, C25400a c25400a, C8562i<Bitmap> c8562i, C31970m<Bitmap> c31970m, Bitmap bitmap) {
        AppMethodBeat.m2504i(92345);
        this.callbacks = new ArrayList();
        this.awX = c8565j;
        Handler handler = new Handler(Looper.getMainLooper(), new C25451c());
        this.awf = c31925e;
        this.handler = handler;
        this.aGe = c8562i;
        this.aGb = c25400a;
        mo42489a(c31970m, bitmap);
        AppMethodBeat.m2505o(92345);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42488a(C8552b c8552b) {
        AppMethodBeat.m2504i(92347);
        IllegalStateException illegalStateException;
        if (this.aGg) {
            illegalStateException = new IllegalStateException("Cannot subscribe to a cleared frame loader");
            AppMethodBeat.m2505o(92347);
            throw illegalStateException;
        } else if (this.callbacks.contains(c8552b)) {
            illegalStateException = new IllegalStateException("Cannot subscribe twice in a row");
            AppMethodBeat.m2505o(92347);
            throw illegalStateException;
        } else {
            boolean isEmpty = this.callbacks.isEmpty();
            this.callbacks.add(c8552b);
            if (isEmpty) {
                start();
            }
            AppMethodBeat.m2505o(92347);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo42490b(C8552b c8552b) {
        AppMethodBeat.m2504i(92348);
        this.callbacks.remove(c8552b);
        if (this.callbacks.isEmpty()) {
            this.isRunning = false;
        }
        AppMethodBeat.m2505o(92348);
    }

    /* Access modifiers changed, original: final */
    public final int getFrameCount() {
        AppMethodBeat.m2504i(92349);
        int frameCount = this.aGb.getFrameCount();
        AppMethodBeat.m2505o(92349);
        return frameCount;
    }

    private void start() {
        AppMethodBeat.m2504i(92350);
        if (this.isRunning) {
            AppMethodBeat.m2505o(92350);
            return;
        }
        this.isRunning = true;
        this.aGg = false;
        m40217nE();
        AppMethodBeat.m2505o(92350);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: nD */
    public final Bitmap mo42492nD() {
        if (this.aGf != null) {
            return this.aGf.aGl;
        }
        return this.aGi;
    }

    /* renamed from: nE */
    private void m40217nE() {
        AppMethodBeat.m2504i(92351);
        if (!this.isRunning || this.aGc) {
            AppMethodBeat.m2505o(92351);
            return;
        }
        if (this.aGd) {
            C8561i.m15215b(this.aGj == null, "Pending target must be null when starting from the first frame");
            this.aGb.mo42437lV();
            this.aGd = false;
        }
        if (this.aGj != null) {
            C8551a c8551a = this.aGj;
            this.aGj = null;
            mo42487a(c8551a);
            AppMethodBeat.m2505o(92351);
            return;
        }
        this.aGc = true;
        long lT = ((long) this.aGb.mo42435lT()) + SystemClock.uptimeMillis();
        this.aGb.advance();
        this.aGh = new C8551a(this.handler, this.aGb.mo42436lU(), lT);
        this.aGe.mo18670a(C41570e.m72769e(C25452g.m40218nG())).mo18669Q(this.aGb).mo18671b(this.aGh);
        AppMethodBeat.m2505o(92351);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: nF */
    public final void mo42493nF() {
        AppMethodBeat.m2504i(92352);
        if (this.aGi != null) {
            this.awf.mo2199g(this.aGi);
            this.aGi = null;
        }
        AppMethodBeat.m2505o(92352);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42487a(C8551a c8551a) {
        AppMethodBeat.m2504i(92353);
        this.aGc = false;
        if (this.aGg) {
            this.handler.obtainMessage(2, c8551a).sendToTarget();
            AppMethodBeat.m2505o(92353);
        } else if (this.isRunning) {
            if (c8551a.aGl != null) {
                mo42493nF();
                C8551a c8551a2 = this.aGf;
                this.aGf = c8551a;
                for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                    ((C8552b) this.callbacks.get(size)).mo18653nC();
                }
                if (c8551a2 != null) {
                    this.handler.obtainMessage(2, c8551a2).sendToTarget();
                }
            }
            m40217nE();
            AppMethodBeat.m2505o(92353);
        } else {
            this.aGj = c8551a;
            AppMethodBeat.m2505o(92353);
        }
    }

    /* renamed from: nG */
    private static C0779h m40218nG() {
        AppMethodBeat.m2504i(92354);
        C17555b c17555b = new C17555b(Double.valueOf(Math.random()));
        AppMethodBeat.m2505o(92354);
        return c17555b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42489a(C31970m<Bitmap> c31970m, Bitmap bitmap) {
        AppMethodBeat.m2504i(92346);
        this.aCk = (C31970m) C8561i.m15217d(c31970m, "Argument must not be null");
        this.aGi = (Bitmap) C8561i.m15217d(bitmap, "Argument must not be null");
        this.aGe = this.aGe.mo18670a(new C41570e().mo66583a((C31970m) c31970m));
        AppMethodBeat.m2505o(92346);
    }
}
