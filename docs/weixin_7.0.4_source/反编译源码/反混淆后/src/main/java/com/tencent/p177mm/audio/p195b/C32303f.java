package com.tencent.p177mm.audio.p195b;

/* renamed from: com.tencent.mm.audio.b.f */
public abstract class C32303f {
    protected int cpB = -123456789;
    protected C25831a cpT;
    protected int cqp = 0;
    protected boolean mIsPause = false;

    /* renamed from: com.tencent.mm.audio.b.f$a */
    public interface C25831a {
        /* renamed from: d */
        void mo4589d(int i, byte[] bArr);
    }

    /* renamed from: EL */
    public abstract boolean mo20481EL();

    /* renamed from: bs */
    public abstract void mo20482bs(boolean z);

    public abstract void stopRecord();

    /* renamed from: a */
    public final void mo53012a(C25831a c25831a) {
        this.cpT = c25831a;
    }

    /* renamed from: gH */
    public final void mo53013gH(int i) {
        this.cpB = i;
    }

    /* renamed from: EO */
    public final int mo53011EO() {
        return this.cqp;
    }
}
