package com.p081b.p082a.p083a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;

/* renamed from: com.b.a.a.d */
abstract class C8482d {
    /* renamed from: Gn */
    private Context f2418Gn;
    boolean bCM;
    private Collection<WeakReference<C0735m>> bCN;
    private C8483a bCO;
    boolean isRunning;
    private Handler mHandler;

    /* renamed from: com.b.a.a.d$a */
    static class C8483a {
        final long bCP;

        C8483a(long j) {
            AppMethodBeat.m2504i(55573);
            this.bCP = Math.max(j, 0);
            AppMethodBeat.m2505o(55573);
        }
    }

    /* renamed from: a */
    public abstract void mo18557a(Context context, Handler handler, C8483a c8483a);

    /* renamed from: at */
    public abstract void mo18560at(Context context);

    /* renamed from: au */
    public abstract void mo18561au(Context context);

    /* renamed from: vV */
    public abstract void mo18564vV();

    C8482d() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo18562c(C31914p c31914p) {
        if (this.isRunning && this.bCN != null) {
            for (WeakReference weakReference : this.bCN) {
                C0735m c0735m = (C0735m) weakReference.get();
                if (c0735m != null) {
                    c0735m.mo2178a(c31914p);
                }
            }
        }
    }

    /* Access modifiers changed, original: final|varargs|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo18558a(Context context, C0735m... c0735mArr) {
        if (context == null) {
            throw new Exception("Module: context cannot be null");
        }
        mo18565vY();
        m15062b(context.getApplicationContext(), c0735mArr);
        this.bCM = true;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: vY */
    public final synchronized void mo18565vY() {
        if (this.bCM) {
            stop();
            mo18564vV();
            this.bCM = false;
        }
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo18559a(Handler handler, C8483a c8483a) {
        stop();
        this.mHandler = handler;
        this.bCO = c8483a;
        mo18557a(this.f2418Gn, this.mHandler, this.bCO);
        this.isRunning = true;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void stop() {
        if (this.isRunning) {
            mo18561au(this.f2418Gn);
            this.mHandler = null;
            this.bCO = null;
            this.isRunning = false;
        }
    }

    /* renamed from: b */
    private void m15062b(Context context, C0735m... c0735mArr) {
        this.f2418Gn = context;
        if (c0735mArr == null) {
            this.bCN = null;
        } else {
            this.bCN = new LinkedList();
            for (Object weakReference : c0735mArr) {
                this.bCN.add(new WeakReference(weakReference));
            }
        }
        mo18560at(context);
    }
}
