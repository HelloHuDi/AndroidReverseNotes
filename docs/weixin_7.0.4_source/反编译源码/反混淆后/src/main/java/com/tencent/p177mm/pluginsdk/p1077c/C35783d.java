package com.tencent.p177mm.pluginsdk.p1077c;

import com.tencent.p177mm.p230g.p231a.C42015jp;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;

/* renamed from: com.tencent.mm.pluginsdk.c.d */
public abstract class C35783d implements C4931a {
    public int vaK = 0;

    /* renamed from: NJ */
    public abstract C4883b mo36283NJ(String str);

    public abstract C7296k bCU();

    public final void axy() {
        if (this.vaK == 0) {
            C7296k bCU = bCU();
            if (bCU != null) {
                bCU.mo10116c(this);
            }
        }
        this.vaK++;
    }

    public final void unregister() {
        if (this.vaK != 0) {
            this.vaK--;
            if (this.vaK == 0) {
                C7296k bCU = bCU();
                if (bCU != null) {
                    bCU.mo10117d(this);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        C42015jp c42015jp = new C42015jp();
        c42015jp.cEP.cEQ = mo36283NJ(str);
        C4879a.xxA.mo10055m(c42015jp);
    }
}
