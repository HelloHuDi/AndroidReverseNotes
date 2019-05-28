package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.exdevice.e.e;

public abstract class c {
    public long jJa = -1;
    public short lqB = (short) 30003;
    public e lqC = null;
    protected a lqD = null;

    public abstract short bor();

    public abstract short bos();

    public abstract byte[] bot();

    /* Access modifiers changed, original: protected|final */
    public final e as(int i, String str) {
        this.lqC = new e();
        this.lqC.luT = i;
        this.lqC.luU = str;
        return this.lqC;
    }
}
