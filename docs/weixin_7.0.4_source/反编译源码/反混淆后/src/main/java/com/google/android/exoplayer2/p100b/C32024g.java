package com.google.android.exoplayer2.p100b;

import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

/* renamed from: com.google.android.exoplayer2.b.g */
public abstract class C32024g<I extends C32022e, O extends C32023f, E extends Exception> implements C8643c<I, O, E> {
    private int aSg;
    private final Thread aSm;
    private final LinkedList<I> aSn = new LinkedList();
    private final LinkedList<O> aSo = new LinkedList();
    protected final I[] aSp;
    private final O[] aSq;
    protected int aSr;
    private int aSs;
    private I aSt;
    private boolean aSu;
    private E exception;
    private final Object lock = new Object();
    private boolean released;

    /* renamed from: com.google.android.exoplayer2.b.g$1 */
    class C255141 extends Thread {
        C255141() {
        }

        public final void run() {
            AppMethodBeat.m2504i(94745);
            do {
                try {
                } catch (InterruptedException e) {
                    IllegalStateException illegalStateException = new IllegalStateException(e);
                    AppMethodBeat.m2505o(94745);
                    throw illegalStateException;
                }
            } while (C32024g.this.mo52318qP());
            AppMethodBeat.m2505o(94745);
        }
    }

    /* renamed from: a */
    public abstract E mo19186a(I i, O o, boolean z);

    /* renamed from: qR */
    public abstract I mo19189qR();

    /* renamed from: qS */
    public abstract O mo19190qS();

    /* renamed from: ad */
    public final /* synthetic */ void mo19140ad(Object obj) {
        C32022e c32022e = (C32022e) obj;
        synchronized (this.lock) {
            C45039a.checkArgument(c32022e == this.aSt);
            this.aSn.addLast(c32022e);
            m52007qO();
            this.aSt = null;
        }
    }

    /* renamed from: qI */
    public final /* synthetic */ Object mo19142qI() {
        return m52005qM();
    }

    /* renamed from: qJ */
    public final /* synthetic */ Object mo19143qJ() {
        return m52006qN();
    }

    protected C32024g(I[] iArr, O[] oArr) {
        int i = 0;
        this.aSp = iArr;
        this.aSr = 2;
        for (int i2 = 0; i2 < this.aSr; i2++) {
            this.aSp[i2] = mo19189qR();
        }
        this.aSq = oArr;
        this.aSs = 2;
        while (i < this.aSs) {
            this.aSq[i] = mo19190qS();
            i++;
        }
        this.aSm = new C255141();
        this.aSm.start();
    }

    /* renamed from: qM */
    private I m52005qM() {
        C32022e c32022e;
        synchronized (this.lock) {
            C45039a.checkState(this.aSt == null);
            if (this.aSr == 0) {
                c32022e = null;
            } else {
                C32022e[] c32022eArr = this.aSp;
                int i = this.aSr - 1;
                this.aSr = i;
                c32022e = c32022eArr[i];
            }
            this.aSt = c32022e;
            c32022e = this.aSt;
        }
        return c32022e;
    }

    /* renamed from: qN */
    private O m52006qN() {
        O o;
        synchronized (this.lock) {
            if (this.aSo.isEmpty()) {
                o = null;
            } else {
                C32023f o2 = (C32023f) this.aSo.removeFirst();
            }
        }
        return o2;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo19187a(O o) {
        synchronized (this.lock) {
            m52004b(o);
            m52007qO();
        }
    }

    public final void flush() {
        synchronized (this.lock) {
            this.aSu = true;
            this.aSg = 0;
            if (this.aSt != null) {
                m52003a(this.aSt);
                this.aSt = null;
            }
            while (!this.aSn.isEmpty()) {
                m52003a((C32022e) this.aSn.removeFirst());
            }
            while (!this.aSo.isEmpty()) {
                m52004b((C32023f) this.aSo.removeFirst());
            }
        }
    }

    public final void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.aSm.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /* renamed from: qO */
    private void m52007qO() {
        if (m52008qQ()) {
            this.lock.notify();
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:19:0x003a, code skipped:
            if (r0.mo42774qG() == false) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:20:0x003c, code skipped:
            r3.mo42771dB(4);
     */
    /* JADX WARNING: Missing block: B:21:0x0040, code skipped:
            r1 = r6.lock;
     */
    /* JADX WARNING: Missing block: B:22:0x0042, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:25:0x0045, code skipped:
            if (r6.aSu == false) goto L_0x006e;
     */
    /* JADX WARNING: Missing block: B:26:0x0047, code skipped:
            m52004b(r3);
     */
    /* JADX WARNING: Missing block: B:27:0x004a, code skipped:
            m52003a(r0);
     */
    /* JADX WARNING: Missing block: B:28:0x004d, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:31:0x0054, code skipped:
            if (r0.mo42773qF() == false) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:32:0x0056, code skipped:
            r3.mo42771dB(android.support.p057v4.widget.C8415j.INVALID_ID);
     */
    /* JADX WARNING: Missing block: B:33:0x005b, code skipped:
            r6.exception = mo19186a(r0, r3, r4);
     */
    /* JADX WARNING: Missing block: B:34:0x0063, code skipped:
            if (r6.exception == null) goto L_0x0040;
     */
    /* JADX WARNING: Missing block: B:35:0x0065, code skipped:
            r2 = r6.lock;
     */
    /* JADX WARNING: Missing block: B:36:0x0067, code skipped:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            monitor-exit(r2);
     */
    /* JADX WARNING: Missing block: B:45:0x0072, code skipped:
            if (r3.mo42773qF() == false) goto L_0x0081;
     */
    /* JADX WARNING: Missing block: B:46:0x0074, code skipped:
            r6.aSg++;
            m52004b(r3);
     */
    /* JADX WARNING: Missing block: B:51:?, code skipped:
            r3.aSg = r6.aSg;
            r6.aSg = 0;
            r6.aSo.addLast(r3);
     */
    /* JADX WARNING: Missing block: B:53:?, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:54:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: qP */
    public final boolean mo52318qP() {
        synchronized (this.lock) {
            while (!this.released && !m52008qQ()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            C32022e c32022e = (C32022e) this.aSn.removeFirst();
            C32023f[] c32023fArr = this.aSq;
            int i = this.aSs - 1;
            this.aSs = i;
            C32023f c32023f = c32023fArr[i];
            boolean z = this.aSu;
            this.aSu = false;
        }
    }

    /* renamed from: qQ */
    private boolean m52008qQ() {
        return !this.aSn.isEmpty() && this.aSs > 0;
    }

    /* renamed from: a */
    private void m52003a(I i) {
        i.clear();
        C32022e[] c32022eArr = this.aSp;
        int i2 = this.aSr;
        this.aSr = i2 + 1;
        c32022eArr[i2] = i;
    }

    /* renamed from: b */
    private void m52004b(O o) {
        o.clear();
        C32023f[] c32023fArr = this.aSq;
        int i = this.aSs;
        this.aSs = i + 1;
        c32023fArr[i] = o;
    }
}
