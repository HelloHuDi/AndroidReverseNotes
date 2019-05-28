package com.tencent.p177mm.vending.p636b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p639e.C5684a;
import com.tencent.p177mm.vending.p642h.C5703d;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.vending.b.b */
public final class C7358b<_Callback> implements C5684a {
    /* renamed from: c */
    private int f2001c = -1;
    /* renamed from: d */
    public _Callback f2002d;
    /* renamed from: e */
    private int f2003e;
    private C5677a zXC;
    public C5703d zXD;

    public C7358b(_Callback _callback, C5677a c5677a) {
        AppMethodBeat.m2504i(126108);
        Assert.assertNotNull("Callback should not be null!", _callback);
        this.f2003e = _callback.hashCode();
        this.f2002d = _callback;
        this.zXC = c5677a;
        AppMethodBeat.m2505o(126108);
    }

    public final int hashCode() {
        return this.f2003e;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(126109);
        if (obj == null || obj.hashCode() != this.f2003e) {
            AppMethodBeat.m2505o(126109);
            return false;
        }
        AppMethodBeat.m2505o(126109);
        return true;
    }

    public final void dead() {
        AppMethodBeat.m2504i(126110);
        Assert.assertNotNull(this.zXC);
        this.zXC.mo11557b(this);
        AppMethodBeat.m2505o(126110);
    }
}
