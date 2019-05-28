package com.tencent.mm.openim.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;

public final class p implements a {
    public final void oi(String str) {
        AppMethodBeat.i(78935);
        if (t.mP(str)) {
            ((j) g.K(j.class)).XL().c(new f(str, 1));
            AppMethodBeat.o(78935);
            return;
        }
        ((j) g.K(j.class)).XL().c(new o(str, 1));
        AppMethodBeat.o(78935);
    }

    public final void oj(String str) {
        AppMethodBeat.i(78936);
        if (t.mP(str)) {
            ((j) g.K(j.class)).XL().c(new f(str, 2));
            AppMethodBeat.o(78936);
            return;
        }
        ((j) g.K(j.class)).XL().c(new o(str, 2));
        AppMethodBeat.o(78936);
    }

    public final void ok(String str) {
        AppMethodBeat.i(78937);
        ((j) g.K(j.class)).XL().c(new n(str, 1));
        AppMethodBeat.o(78937);
    }

    public final void ol(String str) {
        AppMethodBeat.i(78938);
        ((j) g.K(j.class)).XL().c(new n(str, 2));
        AppMethodBeat.o(78938);
    }

    public final void om(String str) {
        AppMethodBeat.i(78939);
        ((j) g.K(j.class)).XL().c(new m(str, 1));
        AppMethodBeat.o(78939);
    }

    public final void on(String str) {
        AppMethodBeat.i(78940);
        ((j) g.K(j.class)).XL().c(new m(str, 2));
        AppMethodBeat.o(78940);
    }

    public final void ah(String str, String str2) {
        AppMethodBeat.i(78941);
        ((j) g.K(j.class)).XL().c(new k(str, str2));
        AppMethodBeat.o(78941);
    }

    public final void oo(String str) {
        AppMethodBeat.i(78942);
        ((j) g.K(j.class)).XL().c(new h(str, 1));
        AppMethodBeat.o(78942);
    }

    public final void op(String str) {
        AppMethodBeat.i(78943);
        ((j) g.K(j.class)).XL().c(new h(str, 2));
        AppMethodBeat.o(78943);
    }

    public final void ve(String str) {
        AppMethodBeat.i(78944);
        ((j) g.K(j.class)).XL().c(new a(str));
        AppMethodBeat.o(78944);
    }

    public final void vf(String str) {
        AppMethodBeat.i(78945);
        ((j) g.K(j.class)).XL().c(new l(str, 1));
        AppMethodBeat.o(78945);
    }

    public final void vg(String str) {
        AppMethodBeat.i(78946);
        ((j) g.K(j.class)).XL().c(new l(str, 2));
        AppMethodBeat.o(78946);
    }
}
