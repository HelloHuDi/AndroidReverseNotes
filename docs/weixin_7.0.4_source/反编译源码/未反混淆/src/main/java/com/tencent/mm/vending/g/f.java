package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.e;
import com.tencent.mm.vending.j.h;
import java.util.Stack;

public final class f {
    private static final a zYm = new a();

    static {
        AppMethodBeat.i(126032);
        AppMethodBeat.o(126032);
    }

    public static final c<Void> dMn() {
        AppMethodBeat.i(126018);
        c C = new e().C(new Object[0]);
        AppMethodBeat.o(126018);
        return C;
    }

    public static final <Var1> c<Var1> cU(Var1 var1) {
        AppMethodBeat.i(126019);
        c C = new e().C(var1);
        AppMethodBeat.o(126019);
        return C;
    }

    public static final <Var1, Var2> c<c<Var1, Var2>> D(Var1 var1, Var2 var2) {
        AppMethodBeat.i(126020);
        c C = new e().C(var1, var2);
        AppMethodBeat.o(126020);
        return C;
    }

    public static final <Var1, Var2, Var3> c<d<Var1, Var2, Var3>> h(Var1 var1, Var2 var2, Var3 var3) {
        AppMethodBeat.i(126021);
        c C = new e().C(var1, var2, var3);
        AppMethodBeat.o(126021);
        return C;
    }

    public static final <Var1, Var2, Var3, Var4> c<e<Var1, Var2, Var3, Var4>> b(Var1 var1, Var2 var2, Var3 var3, Var4 var4) {
        AppMethodBeat.i(126022);
        c C = new e().C(var1, var2, var3, var4);
        AppMethodBeat.o(126022);
        return C;
    }

    public static final <Var1, Var2, Var3, Var4, Var5> c<com.tencent.mm.vending.j.f<Var1, Var2, Var3, Var4, Var5>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4, Var5 var5) {
        AppMethodBeat.i(126023);
        c C = new e().C(var1, var2, var3, var4, var5);
        AppMethodBeat.o(126023);
        return C;
    }

    public static final <Var1, Var2, Var3, Var4, Var5, Var6, Var7> c<h<Var1, Var2, Var3, Var4, Var5, Var6, Var7>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4, Var5 var5, Var6 var6, Var7 var7) {
        AppMethodBeat.i(126024);
        c C = new e().C(var1, var2, var3, var4, var5, var6, var7);
        AppMethodBeat.o(126024);
        return C;
    }

    public static <$1> b<$1> cV($1 $1) {
        AppMethodBeat.i(126025);
        b cW = a.cW($1);
        AppMethodBeat.o(126025);
        return cW;
    }

    public static <$1, $2> c<$1, $2> E($1 $1, $2 $2) {
        AppMethodBeat.i(126026);
        c F = a.F($1, $2);
        AppMethodBeat.o(126026);
        return F;
    }

    public static final b dMj() {
        AppMethodBeat.i(126027);
        g dMp = g.dMp();
        Stack stack = (Stack) dMp.b.get();
        c cVar = stack == null ? null : stack.size() == 0 ? null : (c) ((Stack) dMp.b.get()).peek();
        b dMj;
        if (cVar != null) {
            dMj = cVar.dMj();
            AppMethodBeat.o(126027);
            return dMj;
        }
        dMj = zYm;
        AppMethodBeat.o(126027);
        return dMj;
    }

    public static final b dMo() {
        AppMethodBeat.i(126028);
        b dMj = dMj();
        if (dMj != null) {
            dMj.dMi();
        } else {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        }
        AppMethodBeat.o(126028);
        return dMj;
    }

    public static final void a(b bVar, Object... objArr) {
        AppMethodBeat.i(126029);
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
            AppMethodBeat.o(126029);
        } else if (objArr.length > 0) {
            bVar.B(objArr);
            AppMethodBeat.o(126029);
        } else {
            bVar.resume();
            AppMethodBeat.o(126029);
        }
    }

    public static final void a(b bVar) {
        AppMethodBeat.i(126030);
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
            AppMethodBeat.o(126030);
            return;
        }
        bVar.cR(null);
        AppMethodBeat.o(126030);
    }

    public static final <_Var> void a(d<_Var> dVar) {
        AppMethodBeat.i(126031);
        final b dMo = dMo();
        dVar.a(new d.b<_Var>() {
            public final void az(_Var _var) {
                AppMethodBeat.i(126017);
                f.a(dMo, _var);
                AppMethodBeat.o(126017);
            }
        }).a(new d.a() {
            public final void bi(Object obj) {
                AppMethodBeat.i(126033);
                dMo.cR(obj);
                AppMethodBeat.o(126033);
            }
        });
        AppMethodBeat.o(126031);
    }
}
