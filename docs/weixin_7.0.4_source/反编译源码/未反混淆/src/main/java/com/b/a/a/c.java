package com.b.a.a;

import android.os.Handler;

abstract class c extends d {
    private boolean bCL;

    public abstract void vW();

    public abstract void vX();

    c() {
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a(Handler handler, a aVar) {
        this.bCL = false;
        super.a(handler, aVar);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void aV(boolean z) {
        if ((this.bCL ^ z) != 0) {
            this.bCL = z;
            if (this.bCL) {
                vW();
            } else {
                vX();
            }
        }
    }
}
