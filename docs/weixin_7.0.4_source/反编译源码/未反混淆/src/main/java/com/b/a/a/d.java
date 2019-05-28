package com.b.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;

abstract class d {
    private Context Gn;
    boolean bCM;
    private Collection<WeakReference<m>> bCN;
    private a bCO;
    boolean isRunning;
    private Handler mHandler;

    static class a {
        final long bCP;

        a(long j) {
            AppMethodBeat.i(55573);
            this.bCP = Math.max(j, 0);
            AppMethodBeat.o(55573);
        }
    }

    public abstract void a(Context context, Handler handler, a aVar);

    public abstract void at(Context context);

    public abstract void au(Context context);

    public abstract void vV();

    d() {
    }

    /* Access modifiers changed, original: final */
    public final void c(p pVar) {
        if (this.isRunning && this.bCN != null) {
            for (WeakReference weakReference : this.bCN) {
                m mVar = (m) weakReference.get();
                if (mVar != null) {
                    mVar.a(pVar);
                }
            }
        }
    }

    /* Access modifiers changed, original: final|varargs|declared_synchronized */
    public final synchronized void a(Context context, m... mVarArr) {
        if (context == null) {
            throw new Exception("Module: context cannot be null");
        }
        vY();
        b(context.getApplicationContext(), mVarArr);
        this.bCM = true;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void vY() {
        if (this.bCM) {
            stop();
            vV();
            this.bCM = false;
        }
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a(Handler handler, a aVar) {
        stop();
        this.mHandler = handler;
        this.bCO = aVar;
        a(this.Gn, this.mHandler, this.bCO);
        this.isRunning = true;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void stop() {
        if (this.isRunning) {
            au(this.Gn);
            this.mHandler = null;
            this.bCO = null;
            this.isRunning = false;
        }
    }

    private void b(Context context, m... mVarArr) {
        this.Gn = context;
        if (mVarArr == null) {
            this.bCN = null;
        } else {
            this.bCN = new LinkedList();
            for (Object weakReference : mVarArr) {
                this.bCN.add(new WeakReference(weakReference));
            }
        }
        at(context);
    }
}
