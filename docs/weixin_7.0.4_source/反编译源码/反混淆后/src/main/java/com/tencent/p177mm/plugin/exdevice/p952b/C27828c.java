package com.tencent.p177mm.plugin.exdevice.p952b;

import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.exdevice.p1255e.C27831e;

/* renamed from: com.tencent.mm.plugin.exdevice.b.c */
public abstract class C27828c {
    public long jJa = -1;
    public short lqB = (short) 30003;
    public C27831e lqC = null;
    protected C1331a lqD = null;

    public abstract short bor();

    public abstract short bos();

    public abstract byte[] bot();

    /* Access modifiers changed, original: protected|final */
    /* renamed from: as */
    public final C27831e mo45698as(int i, String str) {
        this.lqC = new C27831e();
        this.lqC.luT = i;
        this.lqC.luU = str;
        return this.lqC;
    }
}
