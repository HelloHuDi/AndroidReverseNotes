package com.tencent.p177mm.plugin.luckymoney.particles;

/* renamed from: com.tencent.mm.plugin.luckymoney.particles.d */
public final class C28431d {
    public final int oao;
    public final int oap;
    public final int oaq;
    public final int oar;

    public C28431d(int i, int i2) {
        this(i, i2, i, i2);
    }

    private C28431d(int i, int i2, int i3, int i4) {
        this.oao = i;
        this.oap = i2;
        this.oaq = i3;
        this.oar = i4;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aI */
    public final float mo46416aI(float f) {
        return ((float) this.oao) + (((float) (this.oaq - this.oao)) * f);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aJ */
    public final float mo46417aJ(float f) {
        return ((float) this.oap) + (((float) (this.oar - this.oap)) * f);
    }
}
