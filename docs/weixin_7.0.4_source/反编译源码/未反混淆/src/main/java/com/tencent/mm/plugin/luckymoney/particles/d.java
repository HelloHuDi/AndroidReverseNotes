package com.tencent.mm.plugin.luckymoney.particles;

public final class d {
    public final int oao;
    public final int oap;
    public final int oaq;
    public final int oar;

    public d(int i, int i2) {
        this(i, i2, i, i2);
    }

    private d(int i, int i2, int i3, int i4) {
        this.oao = i;
        this.oap = i2;
        this.oaq = i3;
        this.oar = i4;
    }

    /* Access modifiers changed, original: protected|final */
    public final float aI(float f) {
        return ((float) this.oao) + (((float) (this.oaq - this.oao)) * f);
    }

    /* Access modifiers changed, original: protected|final */
    public final float aJ(float f) {
        return ((float) this.oap) + (((float) (this.oar - this.oap)) * f);
    }
}
