package com.tencent.mm.audio.b;

public abstract class f {
    protected int cpB = -123456789;
    protected a cpT;
    protected int cqp = 0;
    protected boolean mIsPause = false;

    public interface a {
        void d(int i, byte[] bArr);
    }

    public abstract boolean EL();

    public abstract void bs(boolean z);

    public abstract void stopRecord();

    public final void a(a aVar) {
        this.cpT = aVar;
    }

    public final void gH(int i) {
        this.cpB = i;
    }

    public final int EO() {
        return this.cqp;
    }
}
