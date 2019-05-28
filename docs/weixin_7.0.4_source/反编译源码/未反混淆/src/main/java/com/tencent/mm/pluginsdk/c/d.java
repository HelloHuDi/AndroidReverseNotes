package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.jp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

public abstract class d implements a {
    public int vaK = 0;

    public abstract b NJ(String str);

    public abstract k bCU();

    public final void axy() {
        if (this.vaK == 0) {
            k bCU = bCU();
            if (bCU != null) {
                bCU.c(this);
            }
        }
        this.vaK++;
    }

    public final void unregister() {
        if (this.vaK != 0) {
            this.vaK--;
            if (this.vaK == 0) {
                k bCU = bCU();
                if (bCU != null) {
                    bCU.d(this);
                }
            }
        }
    }

    public final void a(String str, m mVar) {
        jp jpVar = new jp();
        jpVar.cEP.cEQ = NJ(str);
        com.tencent.mm.sdk.b.a.xxA.m(jpVar);
    }
}
