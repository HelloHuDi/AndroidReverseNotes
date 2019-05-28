package com.tencent.matrix.trace.f;

import com.tencent.matrix.trace.e.c;

public abstract class e extends c {
    private volatile boolean bYT = false;
    volatile boolean caA;

    /* Access modifiers changed, original: protected */
    public void zC() {
        com.tencent.matrix.d.c.i("Matrix.Tracer", "[onAlive] %s", getClass().getName());
    }

    /* Access modifiers changed, original: protected */
    public void zD() {
        com.tencent.matrix.d.c.i("Matrix.Tracer", "[onDead] %s", getClass().getName());
    }

    public final synchronized void zE() {
        if (!this.bYT) {
            this.bYT = true;
            zC();
        }
    }

    public final synchronized void zF() {
        if (this.bYT) {
            this.bYT = false;
            zD();
        }
    }

    public void onForeground(boolean z) {
        this.caA = z;
    }
}
