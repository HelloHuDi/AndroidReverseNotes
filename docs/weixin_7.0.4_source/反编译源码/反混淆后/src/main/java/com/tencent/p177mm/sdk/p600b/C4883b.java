package com.tencent.p177mm.sdk.p600b;

/* renamed from: com.tencent.mm.sdk.b.b */
public abstract class C4883b {
    public Runnable callback = null;
    protected boolean xxG;
    private int xxH = 0;

    /* Access modifiers changed, original: final */
    public final int dnS() {
        if (this.xxH == 0) {
            this.xxH = getClass().getName().hashCode();
        }
        return this.xxH;
    }

    public final boolean dnT() {
        return this.xxG;
    }
}
