package com.bumptech.glide.p086c.p088b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.p088b.C44988o.C44987a;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.c.b.a */
final class C44983a {
    final Handler awA = new Handler(Looper.getMainLooper(), new C07471());
    private final boolean awy;
    final Map<C0779h, C44981b> azI = new HashMap();
    C44987a azJ;
    ReferenceQueue<C44988o<?>> azK;
    private Thread azL;
    volatile boolean azM;
    volatile C37163a azN;

    /* renamed from: com.bumptech.glide.c.b.a$1 */
    class C07471 implements Callback {
        C07471() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(91745);
            if (message.what == 1) {
                C44983a.this.mo72263a((C44981b) message.obj);
                AppMethodBeat.m2505o(91745);
                return true;
            }
            AppMethodBeat.m2505o(91745);
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.a$2 */
    class C254062 implements Runnable {
        C254062() {
        }

        public final void run() {
            AppMethodBeat.m2504i(91746);
            Process.setThreadPriority(10);
            C44983a c44983a = C44983a.this;
            while (!c44983a.azM) {
                try {
                    c44983a.awA.obtainMessage(1, (C44981b) c44983a.azK.remove()).sendToTarget();
                    C37163a c37163a = c44983a.azN;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            AppMethodBeat.m2505o(91746);
        }
    }

    /* renamed from: com.bumptech.glide.c.b.a$a */
    interface C37163a {
    }

    /* renamed from: com.bumptech.glide.c.b.a$b */
    static final class C44981b extends WeakReference<C44988o<?>> {
        final C0779h azP;
        final boolean azQ;
        C17526u<?> azR;

        C44981b(C0779h c0779h, C44988o<?> c44988o, ReferenceQueue<? super C44988o<?>> referenceQueue, boolean z) {
            super(c44988o, referenceQueue);
            AppMethodBeat.m2504i(91747);
            this.azP = (C0779h) C8561i.m15217d(c0779h, "Argument must not be null");
            C17526u c17526u = (c44988o.azQ && z) ? (C17526u) C8561i.m15217d(c44988o.azR, "Argument must not be null") : null;
            this.azR = c17526u;
            this.azQ = c44988o.azQ;
            AppMethodBeat.m2505o(91747);
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            AppMethodBeat.m2504i(91748);
            this.azR = null;
            clear();
            AppMethodBeat.m2505o(91748);
        }
    }

    C44983a(boolean z) {
        AppMethodBeat.m2504i(91749);
        this.awy = z;
        AppMethodBeat.m2505o(91749);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo72264a(C0779h c0779h, C44988o<?> c44988o) {
        AppMethodBeat.m2504i(91750);
        if (this.azK == null) {
            this.azK = new ReferenceQueue();
            this.azL = new Thread(new C254062(), "glide-active-resources");
            this.azL.start();
        }
        C44981b c44981b = (C44981b) this.azI.put(c0779h, new C44981b(c0779h, c44988o, this.azK, this.awy));
        if (c44981b != null) {
            c44981b.reset();
        }
        AppMethodBeat.m2505o(91750);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo72263a(C44981b c44981b) {
        AppMethodBeat.m2504i(91751);
        C45002j.m82426om();
        this.azI.remove(c44981b.azP);
        if (!c44981b.azQ || c44981b.azR == null) {
            AppMethodBeat.m2505o(91751);
            return;
        }
        C44988o c44988o = new C44988o(c44981b.azR, true, false);
        c44988o.mo72280a(c44981b.azP, this.azJ);
        this.azJ.mo52055b(c44981b.azP, c44988o);
        AppMethodBeat.m2505o(91751);
    }
}
