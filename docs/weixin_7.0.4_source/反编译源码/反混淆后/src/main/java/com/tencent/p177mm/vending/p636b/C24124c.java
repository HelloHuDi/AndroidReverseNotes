package com.tencent.p177mm.vending.p636b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p642h.C5703d;
import com.tencent.p177mm.vending.p644j.C5710a;
import java.util.Iterator;

/* renamed from: com.tencent.mm.vending.b.c */
public abstract class C24124c<_Callback> extends C5677a<_Callback> {
    /* renamed from: a */
    public abstract void mo28393a(_Callback _callback, C5710a c5710a);

    public C24124c(C5703d c5703d) {
        super(c5703d);
    }

    public final synchronized void aDt() {
        m37094b(null);
    }

    /* renamed from: a */
    public final synchronized void mo39927a(C5710a c5710a) {
        m37094b(c5710a);
    }

    /* renamed from: b */
    private void m37094b(final C5710a c5710a) {
        Iterator it = dMg().iterator();
        while (it.hasNext()) {
            final C7358b c7358b = (C7358b) it.next();
            if (c7358b != null) {
                if (c7358b.zXD != null) {
                    this.zXB.mo11600c(c7358b.zXD);
                } else {
                    this.zXB.mo11600c(C5703d.dMq());
                }
                this.zXB.mo11599a(new C5681a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.m2504i(126107);
                        Void voidR = (Void) obj;
                        C24124c.this.mo28393a(c7358b.f2002d, c5710a);
                        AppMethodBeat.m2505o(126107);
                        return voidR;
                    }
                }, C5681a.zXH, true);
            }
        }
    }

    /* renamed from: aD */
    public final C7358b<_Callback> mo39928aD(_Callback _callback) {
        return mo11556a(new C7358b(_callback, this));
    }

    public final void remove(_Callback _callback) {
        mo11557b(new C7358b(_callback, this));
    }
}
