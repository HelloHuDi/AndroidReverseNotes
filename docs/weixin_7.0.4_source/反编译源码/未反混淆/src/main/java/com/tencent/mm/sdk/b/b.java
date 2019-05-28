package com.tencent.mm.sdk.b;

public abstract class b {
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
