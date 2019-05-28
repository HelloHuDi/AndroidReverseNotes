package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class c<T extends b> extends com.tencent.mm.sdk.b.c<T> implements f {
    private static HashMap<b, c<? extends b>> fBy = new HashMap();
    private static HashMap<m, b> vaL = new HashMap();
    private int vaK = 0;

    public abstract int Jy();

    public abstract b a(int i, m mVar, T t);

    public abstract m b(T t);

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        if (Jy() == mVar.getType()) {
            b bVar = (b) vaL.remove(mVar);
            if (bVar != null) {
                kp kpVar = new kp();
                kpVar.cGw.cGx = a(i2, mVar, bVar);
                kpVar.cGw.errType = i;
                kpVar.cGw.errCode = i2;
                kpVar.cGw.aIm = str;
                a.xxA.m(kpVar);
            }
        }
    }

    public static void k(b bVar) {
        m mVar;
        for (Entry entry : vaL.entrySet()) {
            if (entry.getValue() == bVar) {
                mVar = (m) entry.getKey();
                break;
            }
        }
        mVar = null;
        if (mVar != null) {
            g.Rg().c(mVar);
            vaL.remove(mVar);
        }
    }

    public final void dgW() {
        if (this.vaK == 0) {
            g.Rg().a(Jy(), (f) this);
        }
        this.vaK++;
    }

    public final void bIW() {
        if (this.vaK != 0) {
            this.vaK--;
            if (this.vaK == 0) {
                g.Rg().b(Jy(), (f) this);
            }
        }
    }

    public final void l(T t) {
        m b = b(t);
        g.Rg().a(b, 0);
        vaL.put(b, t);
    }
}
