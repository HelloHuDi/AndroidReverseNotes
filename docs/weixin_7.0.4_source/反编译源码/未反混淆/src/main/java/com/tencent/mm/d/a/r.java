package com.tencent.mm.d.a;

import android.os.SystemClock;
import android.support.v4.widget.j;
import android.util.SparseArray;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.utils.V8ObjectUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;
import java.util.concurrent.TimeUnit;

final class r extends n {
    int cin = 0;
    final SparseArray<b> cio = new SparseArray();
    volatile al cip = null;
    private final boolean ciq = false;

    class c extends b implements Runnable {
        final V8Array ciA;
        final long ciy;
        final boolean ciz;

        c(l lVar, int i, V8Function v8Function, V8Array v8Array, boolean z, long j) {
            super(lVar, i, v8Function);
            this.ciy = j;
            this.ciz = z;
            this.ciA = v8Array;
        }

        /* Access modifiers changed, original: 0000 */
        public void schedule() {
            AppMethodBeat.i(113879);
            this.ciw.chO.f(this, this.ciy);
            AppMethodBeat.o(113879);
        }

        public void run() {
            AppMethodBeat.i(113880);
            if (isValid()) {
                a(this.ciA);
                if (!isValid()) {
                    AppMethodBeat.o(113880);
                    return;
                } else if (this.ciz) {
                    schedule();
                    AppMethodBeat.o(113880);
                    return;
                } else {
                    cleanup();
                    AppMethodBeat.o(113880);
                    return;
                }
            }
            AppMethodBeat.o(113880);
        }

        /* Access modifiers changed, original: final */
        public final void cleanup() {
            AppMethodBeat.i(113881);
            super.cleanup();
            this.ciA.release();
            AppMethodBeat.o(113881);
        }
    }

    abstract class b {
        l ciw;
        V8Function cix;
        int id;

        public abstract void schedule();

        b(l lVar, int i, V8Function v8Function) {
            this.ciw = lVar;
            this.cix = v8Function;
            this.id = i;
        }

        /* Access modifiers changed, original: final */
        public final void a(V8Array v8Array) {
            if (!this.cix.isReleased() && !this.ciw.CB().isReleased()) {
                this.cix.call(this.ciw.CB().getGlobalObject(), v8Array);
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void cancel() {
            cleanup();
        }

        /* Access modifiers changed, original: final */
        public final boolean isValid() {
            return (this.cix.isReleased() || this.ciw.CB().isReleased()) ? false : true;
        }

        /* Access modifiers changed, original: 0000 */
        public void cleanup() {
            r.this.cio.remove(this.id);
            this.cix.release();
        }
    }

    class a extends c implements Runnable {
        private final ap che;
        private long cis;
        private long cit;

        a(final l lVar, int i, V8Function v8Function, V8Array v8Array, boolean z, long j) {
            super(lVar, i, v8Function, v8Array, z, j);
            AppMethodBeat.i(113875);
            this.che = new ap(r.this.cip.oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a(r.this) {
                public final boolean BI() {
                    AppMethodBeat.i(113874);
                    a.this.cit = SystemClock.elapsedRealtimeNanos();
                    lVar.chO.k(a.this);
                    AppMethodBeat.o(113874);
                    return false;
                }
            }, false);
            AppMethodBeat.o(113875);
        }

        /* Access modifiers changed, original: final */
        public final void schedule() {
            AppMethodBeat.i(113876);
            this.che.ae(this.ciy, this.ciy);
            AppMethodBeat.o(113876);
        }

        public final void run() {
            AppMethodBeat.i(113877);
            if (isValid()) {
                a(this.ciA);
                if (!isValid()) {
                    AppMethodBeat.o(113877);
                    return;
                } else if (this.ciz) {
                    long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                    if (0 == this.cis) {
                        this.cis = elapsedRealtimeNanos - this.cit;
                    } else {
                        this.cis = ((elapsedRealtimeNanos + this.cis) - this.cit) / 2;
                    }
                    elapsedRealtimeNanos = this.ciy - TimeUnit.NANOSECONDS.toMillis(this.cis);
                    if (elapsedRealtimeNanos <= 0) {
                        elapsedRealtimeNanos = this.ciy;
                    }
                    this.che.ae(elapsedRealtimeNanos, elapsedRealtimeNanos);
                    AppMethodBeat.o(113877);
                    return;
                } else {
                    cleanup();
                    AppMethodBeat.o(113877);
                    return;
                }
            }
            AppMethodBeat.o(113877);
        }

        /* Access modifiers changed, original: final */
        public final void cancel() {
            AppMethodBeat.i(113878);
            this.che.stopTimer();
            super.cancel();
            AppMethodBeat.o(113878);
        }
    }

    r() {
        AppMethodBeat.i(113882);
        AppMethodBeat.o(113882);
    }

    static int dt(String str) {
        int i = j.INVALID_ID;
        AppMethodBeat.i(113883);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.decode(str).intValue();
                    AppMethodBeat.o(113883);
                    return i;
                }
            } catch (NumberFormatException e) {
                ab.printErrStackTrace("MicroMsg.J2V8.V8DirectApiTimer", e, "", new Object[0]);
                AppMethodBeat.o(113883);
            }
        }
        AppMethodBeat.o(113883);
        return i;
    }

    public final void cleanup() {
        AppMethodBeat.i(113885);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cio.size()) {
                break;
            }
            ((b) this.cio.valueAt(i2)).cancel();
            i = i2 + 1;
        }
        this.cio.clear();
        al alVar = this.cip;
        if (alVar != null) {
            alVar.oAl.quit();
            this.cip = null;
        }
        AppMethodBeat.o(113885);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(final l lVar, V8Object v8Object) {
        AppMethodBeat.i(113884);
        if (!(lVar.chO instanceof b)) {
            this.cip = new al("MicroMsg.J2V8.V8DirectApiTimer");
        }
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113870);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 7) {
                    ab.w("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters invalid length:%d type[0]:%d", Integer.valueOf(v8Array.length()), Integer.valueOf(v8Array.getType(0)));
                    AppMethodBeat.o(113870);
                    return null;
                }
                int i;
                V8Array toV8Array;
                c cVar;
                V8Function v8Function = (V8Function) v8Array.getObject(0);
                if (v8Array.length() <= 1) {
                    i = 0;
                } else if (v8Array.getType(1) == 1) {
                    i = v8Array.getInteger(1);
                } else if (v8Array.getType(1) == 2) {
                    i = (int) v8Array.getDouble(1);
                } else if (v8Array.getType(1) == 4) {
                    i = r.dt(v8Array.getString(1));
                    if (i == j.INVALID_ID) {
                        AppMethodBeat.o(113870);
                        return null;
                    }
                } else {
                    ab.w("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters[1] type:%d", Integer.valueOf(v8Array.getType(1)));
                    AppMethodBeat.o(113870);
                    return null;
                }
                if (v8Array.length() > 2) {
                    List toList = V8ObjectUtils.toList(v8Array);
                    toV8Array = V8ObjectUtils.toV8Array(lVar.CB(), toList.subList(2, toList.size() - 1));
                } else {
                    toV8Array = lVar.CB().newV8Array();
                }
                r rVar = r.this;
                l lVar = lVar;
                rVar.cin++;
                if (lVar.chO instanceof b) {
                    cVar = new c(lVar, rVar.cin, v8Function, toV8Array, false, (long) i);
                } else {
                    cVar = new a(lVar, rVar.cin, v8Function, toV8Array, false, (long) i);
                }
                cVar.schedule();
                rVar.cio.put(rVar.cin, cVar);
                Object valueOf = Integer.valueOf(rVar.cin);
                AppMethodBeat.o(113870);
                return valueOf;
            }
        }, "setTimeout");
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113871);
                if (v8Array.length() < 2 || v8Array.getType(0) != 7) {
                    ab.w("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters invalid length:%d type[0]:%d", Integer.valueOf(v8Array.length()), Integer.valueOf(v8Array.getType(0)));
                    AppMethodBeat.o(113871);
                    return null;
                }
                int integer;
                V8Array toV8Array;
                c cVar;
                V8Function v8Function = (V8Function) v8Array.getObject(0);
                if (v8Array.getType(1) == 1) {
                    integer = v8Array.getInteger(1);
                } else if (v8Array.getType(1) == 2) {
                    integer = (int) v8Array.getDouble(1);
                } else if (v8Array.getType(1) == 4) {
                    integer = r.dt(v8Array.getString(1));
                    if (integer == j.INVALID_ID) {
                        AppMethodBeat.o(113871);
                        return null;
                    }
                } else {
                    ab.w("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters[1] type:%d", Integer.valueOf(v8Array.getType(1)));
                    AppMethodBeat.o(113871);
                    return null;
                }
                if (v8Array.length() > 2) {
                    List toList = V8ObjectUtils.toList(v8Array);
                    toV8Array = V8ObjectUtils.toV8Array(lVar.CB(), toList.subList(2, toList.size() - 1));
                } else {
                    toV8Array = lVar.CB().newV8Array();
                }
                r rVar = r.this;
                l lVar = lVar;
                rVar.cin++;
                if (lVar.chO instanceof b) {
                    cVar = new c(lVar, rVar.cin, v8Function, toV8Array, true, (long) integer);
                } else {
                    cVar = new a(lVar, rVar.cin, v8Function, toV8Array, true, (long) integer);
                }
                cVar.schedule();
                rVar.cio.put(rVar.cin, cVar);
                Object valueOf = Integer.valueOf(rVar.cin);
                AppMethodBeat.o(113871);
                return valueOf;
            }
        }, "setInterval");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113872);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                    AppMethodBeat.o(113872);
                    return;
                }
                r.a(r.this, v8Array.getInteger(0));
                AppMethodBeat.o(113872);
            }
        }, "clearTimeout");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113873);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                    AppMethodBeat.o(113873);
                    return;
                }
                r.a(r.this, v8Array.getInteger(0));
                AppMethodBeat.o(113873);
            }
        }, "clearInterval");
        AppMethodBeat.o(113884);
    }
}
