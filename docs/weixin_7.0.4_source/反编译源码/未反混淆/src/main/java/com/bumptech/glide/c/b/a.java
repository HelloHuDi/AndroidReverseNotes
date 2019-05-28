package com.bumptech.glide.c.b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.bumptech.glide.c.h;
import com.bumptech.glide.h.i;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class a {
    final Handler awA = new Handler(Looper.getMainLooper(), new Callback() {
        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(91745);
            if (message.what == 1) {
                a.this.a((b) message.obj);
                AppMethodBeat.o(91745);
                return true;
            }
            AppMethodBeat.o(91745);
            return false;
        }
    });
    private final boolean awy;
    final Map<h, b> azI = new HashMap();
    a azJ;
    ReferenceQueue<o<?>> azK;
    private Thread azL;
    volatile boolean azM;
    volatile a azN;

    interface a {
    }

    static final class b extends WeakReference<o<?>> {
        final h azP;
        final boolean azQ;
        u<?> azR;

        b(h hVar, o<?> oVar, ReferenceQueue<? super o<?>> referenceQueue, boolean z) {
            super(oVar, referenceQueue);
            AppMethodBeat.i(91747);
            this.azP = (h) i.d(hVar, "Argument must not be null");
            u uVar = (oVar.azQ && z) ? (u) i.d(oVar.azR, "Argument must not be null") : null;
            this.azR = uVar;
            this.azQ = oVar.azQ;
            AppMethodBeat.o(91747);
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            AppMethodBeat.i(91748);
            this.azR = null;
            clear();
            AppMethodBeat.o(91748);
        }
    }

    a(boolean z) {
        AppMethodBeat.i(91749);
        this.awy = z;
        AppMethodBeat.o(91749);
    }

    /* Access modifiers changed, original: final */
    public final void a(h hVar, o<?> oVar) {
        AppMethodBeat.i(91750);
        if (this.azK == null) {
            this.azK = new ReferenceQueue();
            this.azL = new Thread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(91746);
                    Process.setThreadPriority(10);
                    a aVar = a.this;
                    while (!aVar.azM) {
                        try {
                            aVar.awA.obtainMessage(1, (b) aVar.azK.remove()).sendToTarget();
                            a aVar2 = aVar.azN;
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    AppMethodBeat.o(91746);
                }
            }, "glide-active-resources");
            this.azL.start();
        }
        b bVar = (b) this.azI.put(hVar, new b(hVar, oVar, this.azK, this.awy));
        if (bVar != null) {
            bVar.reset();
        }
        AppMethodBeat.o(91750);
    }

    /* Access modifiers changed, original: final */
    public final void a(b bVar) {
        AppMethodBeat.i(91751);
        j.om();
        this.azI.remove(bVar.azP);
        if (!bVar.azQ || bVar.azR == null) {
            AppMethodBeat.o(91751);
            return;
        }
        o oVar = new o(bVar.azR, true, false);
        oVar.a(bVar.azP, this.azJ);
        this.azJ.b(bVar.azP, oVar);
        AppMethodBeat.o(91751);
    }
}
