package com.tencent.mm.vending.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback> implements a {
    private int c = -1;
    public _Callback d;
    private int e;
    private a zXC;
    public d zXD;

    public b(_Callback _callback, a aVar) {
        AppMethodBeat.i(126108);
        Assert.assertNotNull("Callback should not be null!", _callback);
        this.e = _callback.hashCode();
        this.d = _callback;
        this.zXC = aVar;
        AppMethodBeat.o(126108);
    }

    public final int hashCode() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(126109);
        if (obj == null || obj.hashCode() != this.e) {
            AppMethodBeat.o(126109);
            return false;
        }
        AppMethodBeat.o(126109);
        return true;
    }

    public final void dead() {
        AppMethodBeat.i(126110);
        Assert.assertNotNull(this.zXC);
        this.zXC.b(this);
        AppMethodBeat.o(126110);
    }
}
