package com.tencent.p177mm.p224d.p225a;

import android.os.SystemClock;
import android.support.p057v4.widget.C8415j;
import android.util.SparseArray;
import com.eclipsesource.p097v8.JavaCallback;
import com.eclipsesource.p097v8.JavaVoidCallback;
import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8Function;
import com.eclipsesource.p097v8.V8Object;
import com.eclipsesource.p097v8.utils.V8ObjectUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.d.a.r */
final class C37669r extends C9265n {
    int cin = 0;
    final SparseArray<C37668b> cio = new SparseArray();
    volatile C5004al cip = null;
    private final boolean ciq = false;

    /* renamed from: com.tencent.mm.d.a.r$c */
    class C32494c extends C37668b implements Runnable {
        final V8Array ciA;
        final long ciy;
        final boolean ciz;

        C32494c(C32488l c32488l, int i, V8Function v8Function, V8Array v8Array, boolean z, long j) {
            super(c32488l, i, v8Function);
            this.ciy = j;
            this.ciz = z;
            this.ciA = v8Array;
        }

        /* Access modifiers changed, original: 0000 */
        public void schedule() {
            AppMethodBeat.m2504i(113879);
            this.ciw.chO.mo73184f(this, this.ciy);
            AppMethodBeat.m2505o(113879);
        }

        public void run() {
            AppMethodBeat.m2504i(113880);
            if (isValid()) {
                mo60495a(this.ciA);
                if (!isValid()) {
                    AppMethodBeat.m2505o(113880);
                    return;
                } else if (this.ciz) {
                    schedule();
                    AppMethodBeat.m2505o(113880);
                    return;
                } else {
                    cleanup();
                    AppMethodBeat.m2505o(113880);
                    return;
                }
            }
            AppMethodBeat.m2505o(113880);
        }

        /* Access modifiers changed, original: final */
        public final void cleanup() {
            AppMethodBeat.m2504i(113881);
            super.cleanup();
            this.ciA.release();
            AppMethodBeat.m2505o(113881);
        }
    }

    /* renamed from: com.tencent.mm.d.a.r$4 */
    class C376674 implements JavaVoidCallback {
        C376674() {
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(113873);
            if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                AppMethodBeat.m2505o(113873);
                return;
            }
            C37669r.m63702a(C37669r.this, v8Array.getInteger(0));
            AppMethodBeat.m2505o(113873);
        }
    }

    /* renamed from: com.tencent.mm.d.a.r$b */
    abstract class C37668b {
        C32488l ciw;
        V8Function cix;
        /* renamed from: id */
        int f16118id;

        public abstract void schedule();

        C37668b(C32488l c32488l, int i, V8Function v8Function) {
            this.ciw = c32488l;
            this.cix = v8Function;
            this.f16118id = i;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo60495a(V8Array v8Array) {
            if (!this.cix.isReleased() && !this.ciw.mo53119CB().isReleased()) {
                this.cix.call(this.ciw.mo53119CB().getGlobalObject(), v8Array);
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void cancel() {
            cleanup();
        }

        /* Access modifiers changed, original: final */
        public final boolean isValid() {
            return (this.cix.isReleased() || this.ciw.mo53119CB().isReleased()) ? false : true;
        }

        /* Access modifiers changed, original: 0000 */
        public void cleanup() {
            C37669r.this.cio.remove(this.f16118id);
            this.cix.release();
        }
    }

    /* renamed from: com.tencent.mm.d.a.r$a */
    class C37670a extends C32494c implements Runnable {
        private final C7564ap che;
        private long cis;
        private long cit;

        C37670a(final C32488l c32488l, int i, V8Function v8Function, V8Array v8Array, boolean z, long j) {
            super(c32488l, i, v8Function, v8Array, z, j);
            AppMethodBeat.m2504i(113875);
            this.che = new C7564ap(C37669r.this.cip.oAl.getLooper(), new C5015a(C37669r.this) {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(113874);
                    C37670a.this.cit = SystemClock.elapsedRealtimeNanos();
                    c32488l.chO.mo73187k(C37670a.this);
                    AppMethodBeat.m2505o(113874);
                    return false;
                }
            }, false);
            AppMethodBeat.m2505o(113875);
        }

        /* Access modifiers changed, original: final */
        public final void schedule() {
            AppMethodBeat.m2504i(113876);
            this.che.mo16770ae(this.ciy, this.ciy);
            AppMethodBeat.m2505o(113876);
        }

        public final void run() {
            AppMethodBeat.m2504i(113877);
            if (isValid()) {
                mo60495a(this.ciA);
                if (!isValid()) {
                    AppMethodBeat.m2505o(113877);
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
                    this.che.mo16770ae(elapsedRealtimeNanos, elapsedRealtimeNanos);
                    AppMethodBeat.m2505o(113877);
                    return;
                } else {
                    cleanup();
                    AppMethodBeat.m2505o(113877);
                    return;
                }
            }
            AppMethodBeat.m2505o(113877);
        }

        /* Access modifiers changed, original: final */
        public final void cancel() {
            AppMethodBeat.m2504i(113878);
            this.che.stopTimer();
            super.cancel();
            AppMethodBeat.m2505o(113878);
        }
    }

    /* renamed from: com.tencent.mm.d.a.r$3 */
    class C376713 implements JavaVoidCallback {
        C376713() {
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(113872);
            if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                AppMethodBeat.m2505o(113872);
                return;
            }
            C37669r.m63702a(C37669r.this, v8Array.getInteger(0));
            AppMethodBeat.m2505o(113872);
        }
    }

    C37669r() {
        AppMethodBeat.m2504i(113882);
        AppMethodBeat.m2505o(113882);
    }

    /* renamed from: dt */
    static int m63703dt(String str) {
        int i = C8415j.INVALID_ID;
        AppMethodBeat.m2504i(113883);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.decode(str).intValue();
                    AppMethodBeat.m2505o(113883);
                    return i;
                }
            } catch (NumberFormatException e) {
                C4990ab.printErrStackTrace("MicroMsg.J2V8.V8DirectApiTimer", e, "", new Object[0]);
                AppMethodBeat.m2505o(113883);
            }
        }
        AppMethodBeat.m2505o(113883);
        return i;
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(113885);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cio.size()) {
                break;
            }
            ((C37668b) this.cio.valueAt(i2)).cancel();
            i = i2 + 1;
        }
        this.cio.clear();
        C5004al c5004al = this.cip;
        if (c5004al != null) {
            c5004al.oAl.quit();
            this.cip = null;
        }
        AppMethodBeat.m2505o(113885);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo4940a(final C32488l c32488l, V8Object v8Object) {
        AppMethodBeat.m2504i(113884);
        if (!(c32488l.chO instanceof C37664b)) {
            this.cip = new C5004al("MicroMsg.J2V8.V8DirectApiTimer");
        }
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.m2504i(113870);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 7) {
                    C4990ab.m7421w("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters invalid length:%d type[0]:%d", Integer.valueOf(v8Array.length()), Integer.valueOf(v8Array.getType(0)));
                    AppMethodBeat.m2505o(113870);
                    return null;
                }
                int i;
                V8Array toV8Array;
                C32494c c32494c;
                V8Function v8Function = (V8Function) v8Array.getObject(0);
                if (v8Array.length() <= 1) {
                    i = 0;
                } else if (v8Array.getType(1) == 1) {
                    i = v8Array.getInteger(1);
                } else if (v8Array.getType(1) == 2) {
                    i = (int) v8Array.getDouble(1);
                } else if (v8Array.getType(1) == 4) {
                    i = C37669r.m63703dt(v8Array.getString(1));
                    if (i == C8415j.INVALID_ID) {
                        AppMethodBeat.m2505o(113870);
                        return null;
                    }
                } else {
                    C4990ab.m7421w("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters[1] type:%d", Integer.valueOf(v8Array.getType(1)));
                    AppMethodBeat.m2505o(113870);
                    return null;
                }
                if (v8Array.length() > 2) {
                    List toList = V8ObjectUtils.toList(v8Array);
                    toV8Array = V8ObjectUtils.toV8Array(c32488l.mo53119CB(), toList.subList(2, toList.size() - 1));
                } else {
                    toV8Array = c32488l.mo53119CB().newV8Array();
                }
                C37669r c37669r = C37669r.this;
                C32488l c32488l = c32488l;
                c37669r.cin++;
                if (c32488l.chO instanceof C37664b) {
                    c32494c = new C32494c(c32488l, c37669r.cin, v8Function, toV8Array, false, (long) i);
                } else {
                    c32494c = new C37670a(c32488l, c37669r.cin, v8Function, toV8Array, false, (long) i);
                }
                c32494c.schedule();
                c37669r.cio.put(c37669r.cin, c32494c);
                Object valueOf = Integer.valueOf(c37669r.cin);
                AppMethodBeat.m2505o(113870);
                return valueOf;
            }
        }, "setTimeout");
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.m2504i(113871);
                if (v8Array.length() < 2 || v8Array.getType(0) != 7) {
                    C4990ab.m7421w("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters invalid length:%d type[0]:%d", Integer.valueOf(v8Array.length()), Integer.valueOf(v8Array.getType(0)));
                    AppMethodBeat.m2505o(113871);
                    return null;
                }
                int integer;
                V8Array toV8Array;
                C32494c c32494c;
                V8Function v8Function = (V8Function) v8Array.getObject(0);
                if (v8Array.getType(1) == 1) {
                    integer = v8Array.getInteger(1);
                } else if (v8Array.getType(1) == 2) {
                    integer = (int) v8Array.getDouble(1);
                } else if (v8Array.getType(1) == 4) {
                    integer = C37669r.m63703dt(v8Array.getString(1));
                    if (integer == C8415j.INVALID_ID) {
                        AppMethodBeat.m2505o(113871);
                        return null;
                    }
                } else {
                    C4990ab.m7421w("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters[1] type:%d", Integer.valueOf(v8Array.getType(1)));
                    AppMethodBeat.m2505o(113871);
                    return null;
                }
                if (v8Array.length() > 2) {
                    List toList = V8ObjectUtils.toList(v8Array);
                    toV8Array = V8ObjectUtils.toV8Array(c32488l.mo53119CB(), toList.subList(2, toList.size() - 1));
                } else {
                    toV8Array = c32488l.mo53119CB().newV8Array();
                }
                C37669r c37669r = C37669r.this;
                C32488l c32488l = c32488l;
                c37669r.cin++;
                if (c32488l.chO instanceof C37664b) {
                    c32494c = new C32494c(c32488l, c37669r.cin, v8Function, toV8Array, true, (long) integer);
                } else {
                    c32494c = new C37670a(c32488l, c37669r.cin, v8Function, toV8Array, true, (long) integer);
                }
                c32494c.schedule();
                c37669r.cio.put(c37669r.cin, c32494c);
                Object valueOf = Integer.valueOf(c37669r.cin);
                AppMethodBeat.m2505o(113871);
                return valueOf;
            }
        }, "setInterval");
        v8Object.registerJavaMethod(new C376713(), "clearTimeout");
        v8Object.registerJavaMethod(new C376674(), "clearInterval");
        AppMethodBeat.m2505o(113884);
    }
}
