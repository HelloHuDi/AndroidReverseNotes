package com.tencent.p177mm.p217ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p636b.C5677a;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p642h.C5703d;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ci.a */
public class C6454a<_Callback> extends C5677a<_Callback> {

    /* renamed from: com.tencent.mm.ci.a$a */
    public interface C1387a<_Callback> {
        /* renamed from: ax */
        void mo4769ax(_Callback _callback);
    }

    public C6454a() {
        super(new C6456e());
        AppMethodBeat.m2504i(123360);
        AppMethodBeat.m2505o(123360);
    }

    public C6454a(C5703d c5703d) {
        super(c5703d);
    }

    /* renamed from: a */
    public final void mo14669a(final C1387a<_Callback> c1387a) {
        AppMethodBeat.m2504i(123361);
        Iterator it = dMf().iterator();
        while (it.hasNext()) {
            final C7358b c7358b = (C7358b) it.next();
            if (c7358b != null) {
                if (c7358b.zXD != null) {
                    this.zXB.mo11600c(c7358b.zXD);
                    this.zXB.mo11599a(new C5681a<Void, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.m2504i(123359);
                            Void voidR = (Void) obj;
                            c1387a.mo4769ax(c7358b.f2002d);
                            AppMethodBeat.m2505o(123359);
                            return voidR;
                        }
                    }, C5681a.zXH, true);
                } else {
                    c1387a.mo4769ax(c7358b.f2002d);
                }
            }
        }
        AppMethodBeat.m2505o(123361);
    }

    /* renamed from: aD */
    public C7358b<_Callback> mo14670aD(_Callback _callback) {
        AppMethodBeat.m2504i(123362);
        C7358b a = super.mo11556a(new C7358b(_callback, this));
        AppMethodBeat.m2505o(123362);
        return a;
    }

    public final void remove(_Callback _callback) {
        AppMethodBeat.m2504i(123363);
        super.mo11557b(new C7358b(_callback, this));
        AppMethodBeat.m2505o(123363);
    }
}
