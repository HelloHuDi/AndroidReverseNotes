package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
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

    public abstract E a(I i, O o, boolean z);

    public abstract I qR();

    public abstract O qS();

    public final /* synthetic */ void ad(Object obj) {
        e eVar = (e) obj;
        synchronized (this.lock) {
            a.checkArgument(eVar == this.aSt);
            this.aSn.addLast(eVar);
            qO();
            this.aSt = null;
        }
    }

    public final /* synthetic */ Object qI() {
        return qM();
    }

    public final /* synthetic */ Object qJ() {
        return qN();
    }

    protected g(I[] iArr, O[] oArr) {
        int i = 0;
        this.aSp = iArr;
        this.aSr = 2;
        for (int i2 = 0; i2 < this.aSr; i2++) {
            this.aSp[i2] = qR();
        }
        this.aSq = oArr;
        this.aSs = 2;
        while (i < this.aSs) {
            this.aSq[i] = qS();
            i++;
        }
        this.aSm = new Thread() {
            public final void run() {
                AppMethodBeat.i(94745);
                do {
                    try {
                    } catch (InterruptedException e) {
                        IllegalStateException illegalStateException = new IllegalStateException(e);
                        AppMethodBeat.o(94745);
                        throw illegalStateException;
                    }
                } while (g.this.qP());
                AppMethodBeat.o(94745);
            }
        };
        this.aSm.start();
    }

    private I qM() {
        e eVar;
        synchronized (this.lock) {
            a.checkState(this.aSt == null);
            if (this.aSr == 0) {
                eVar = null;
            } else {
                e[] eVarArr = this.aSp;
                int i = this.aSr - 1;
                this.aSr = i;
                eVar = eVarArr[i];
            }
            this.aSt = eVar;
            eVar = this.aSt;
        }
        return eVar;
    }

    private O qN() {
        O o;
        synchronized (this.lock) {
            if (this.aSo.isEmpty()) {
                o = null;
            } else {
                f o2 = (f) this.aSo.removeFirst();
            }
        }
        return o2;
    }

    /* Access modifiers changed, original: protected */
    public void a(O o) {
        synchronized (this.lock) {
            b(o);
            qO();
        }
    }

    public final void flush() {
        synchronized (this.lock) {
            this.aSu = true;
            this.aSg = 0;
            if (this.aSt != null) {
                a(this.aSt);
                this.aSt = null;
            }
            while (!this.aSn.isEmpty()) {
                a((e) this.aSn.removeFirst());
            }
            while (!this.aSo.isEmpty()) {
                b((f) this.aSo.removeFirst());
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

    private void qO() {
        if (qQ()) {
            this.lock.notify();
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:19:0x003a, code skipped:
            if (r0.qG() == false) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:20:0x003c, code skipped:
            r3.dB(4);
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
            b(r3);
     */
    /* JADX WARNING: Missing block: B:27:0x004a, code skipped:
            a(r0);
     */
    /* JADX WARNING: Missing block: B:28:0x004d, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:31:0x0054, code skipped:
            if (r0.qF() == false) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:32:0x0056, code skipped:
            r3.dB(android.support.v4.widget.j.INVALID_ID);
     */
    /* JADX WARNING: Missing block: B:33:0x005b, code skipped:
            r6.exception = a(r0, r3, r4);
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
            if (r3.qF() == false) goto L_0x0081;
     */
    /* JADX WARNING: Missing block: B:46:0x0074, code skipped:
            r6.aSg++;
            b(r3);
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
    public final boolean qP() {
        synchronized (this.lock) {
            while (!this.released && !qQ()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            e eVar = (e) this.aSn.removeFirst();
            f[] fVarArr = this.aSq;
            int i = this.aSs - 1;
            this.aSs = i;
            f fVar = fVarArr[i];
            boolean z = this.aSu;
            this.aSu = false;
        }
    }

    private boolean qQ() {
        return !this.aSn.isEmpty() && this.aSs > 0;
    }

    private void a(I i) {
        i.clear();
        e[] eVarArr = this.aSp;
        int i2 = this.aSr;
        this.aSr = i2 + 1;
        eVarArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        f[] fVarArr = this.aSq;
        int i = this.aSs;
        this.aSs = i + 1;
        fVarArr[i] = o;
    }
}
