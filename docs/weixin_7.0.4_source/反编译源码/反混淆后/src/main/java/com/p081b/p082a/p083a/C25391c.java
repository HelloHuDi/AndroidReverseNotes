package com.p081b.p082a.p083a;

import android.os.Handler;
import com.p081b.p082a.p083a.C8482d.C8483a;

/* renamed from: com.b.a.a.c */
abstract class C25391c extends C8482d {
    private boolean bCL;

    /* renamed from: vW */
    public abstract void mo18576vW();

    /* renamed from: vX */
    public abstract void mo18577vX();

    C25391c() {
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo18559a(Handler handler, C8483a c8483a) {
        this.bCL = false;
        super.mo18559a(handler, c8483a);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: aV */
    public final synchronized void mo42418aV(boolean z) {
        if ((this.bCL ^ z) != 0) {
            this.bCL = z;
            if (this.bCL) {
                mo18576vW();
            } else {
                mo18577vX();
            }
        }
    }
}
