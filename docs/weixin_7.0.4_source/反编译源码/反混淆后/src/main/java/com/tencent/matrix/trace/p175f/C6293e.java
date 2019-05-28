package com.tencent.matrix.trace.p175f;

import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.p174e.C1154c;

/* renamed from: com.tencent.matrix.trace.f.e */
public abstract class C6293e extends C1154c {
    private volatile boolean bYT = false;
    volatile boolean caA;

    /* Access modifiers changed, original: protected */
    /* renamed from: zC */
    public void mo14533zC() {
        C1070c.m2368i("Matrix.Tracer", "[onAlive] %s", getClass().getName());
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: zD */
    public void mo14534zD() {
        C1070c.m2368i("Matrix.Tracer", "[onDead] %s", getClass().getName());
    }

    /* renamed from: zE */
    public final synchronized void mo14535zE() {
        if (!this.bYT) {
            this.bYT = true;
            mo14533zC();
        }
    }

    /* renamed from: zF */
    public final synchronized void mo14536zF() {
        if (this.bYT) {
            this.bYT = false;
            mo14534zD();
        }
    }

    public void onForeground(boolean z) {
        this.caA = z;
    }
}
