package com.tencent.p177mm.vending.p641g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p640f.C5687a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5692d.C5691b;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7370b;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.p177mm.vending.p644j.C7625d;
import com.tencent.p177mm.vending.p644j.C7641e;
import com.tencent.p177mm.vending.p644j.C7643f;
import com.tencent.p177mm.vending.p644j.C7649h;
import java.util.Stack;

/* renamed from: com.tencent.mm.vending.g.f */
public final class C5698f {
    private static final C7360a zYm = new C7360a();

    static {
        AppMethodBeat.m2504i(126032);
        AppMethodBeat.m2505o(126032);
    }

    public static final C7361c<Void> dMn() {
        AppMethodBeat.m2504i(126018);
        C7361c C = new C7582e().mo16867C(new Object[0]);
        AppMethodBeat.m2505o(126018);
        return C;
    }

    /* renamed from: cU */
    public static final <Var1> C7361c<Var1> m8559cU(Var1 var1) {
        AppMethodBeat.m2504i(126019);
        C7361c C = new C7582e().mo16867C(var1);
        AppMethodBeat.m2505o(126019);
        return C;
    }

    /* renamed from: D */
    public static final <Var1, Var2> C7361c<C7583c<Var1, Var2>> m8551D(Var1 var1, Var2 var2) {
        AppMethodBeat.m2504i(126020);
        C7361c C = new C7582e().mo16867C(var1, var2);
        AppMethodBeat.m2505o(126020);
        return C;
    }

    /* renamed from: h */
    public static final <Var1, Var2, Var3> C7361c<C7625d<Var1, Var2, Var3>> m8561h(Var1 var1, Var2 var2, Var3 var3) {
        AppMethodBeat.m2504i(126021);
        C7361c C = new C7582e().mo16867C(var1, var2, var3);
        AppMethodBeat.m2505o(126021);
        return C;
    }

    /* renamed from: b */
    public static final <Var1, Var2, Var3, Var4> C7361c<C7641e<Var1, Var2, Var3, Var4>> m8558b(Var1 var1, Var2 var2, Var3 var3, Var4 var4) {
        AppMethodBeat.m2504i(126022);
        C7361c C = new C7582e().mo16867C(var1, var2, var3, var4);
        AppMethodBeat.m2505o(126022);
        return C;
    }

    /* renamed from: a */
    public static final <Var1, Var2, Var3, Var4, Var5> C7361c<C7643f<Var1, Var2, Var3, Var4, Var5>> m8553a(Var1 var1, Var2 var2, Var3 var3, Var4 var4, Var5 var5) {
        AppMethodBeat.m2504i(126023);
        C7361c C = new C7582e().mo16867C(var1, var2, var3, var4, var5);
        AppMethodBeat.m2505o(126023);
        return C;
    }

    /* renamed from: a */
    public static final <Var1, Var2, Var3, Var4, Var5, Var6, Var7> C7361c<C7649h<Var1, Var2, Var3, Var4, Var5, Var6, Var7>> m8554a(Var1 var1, Var2 var2, Var3 var3, Var4 var4, Var5 var5, Var6 var6, Var7 var7) {
        AppMethodBeat.m2504i(126024);
        C7361c C = new C7582e().mo16867C(var1, var2, var3, var4, var5, var6, var7);
        AppMethodBeat.m2505o(126024);
        return C;
    }

    /* renamed from: cV */
    public static <$1> C7370b<$1> m8560cV($1 $1) {
        AppMethodBeat.m2504i(126025);
        C7370b cW = C5710a.m8576cW($1);
        AppMethodBeat.m2505o(126025);
        return cW;
    }

    /* renamed from: E */
    public static <$1, $2> C7583c<$1, $2> m8552E($1 $1, $2 $2) {
        AppMethodBeat.m2504i(126026);
        C7583c F = C5710a.m8574F($1, $2);
        AppMethodBeat.m2505o(126026);
        return F;
    }

    public static final C5688b dMj() {
        AppMethodBeat.m2504i(126027);
        C5701g dMp = C5701g.dMp();
        Stack stack = (Stack) dMp.f1348b.get();
        C7361c c7361c = stack == null ? null : stack.size() == 0 ? null : (C7361c) ((Stack) dMp.f1348b.get()).peek();
        C5688b dMj;
        if (c7361c != null) {
            dMj = c7361c.dMj();
            AppMethodBeat.m2505o(126027);
            return dMj;
        }
        dMj = zYm;
        AppMethodBeat.m2505o(126027);
        return dMj;
    }

    public static final C5688b dMo() {
        AppMethodBeat.m2504i(126028);
        C5688b dMj = C5698f.dMj();
        if (dMj != null) {
            dMj.dMi();
        } else {
            C5687a.m8543w("Vending.QuickAccess", "dummy mario", new Object[0]);
        }
        AppMethodBeat.m2505o(126028);
        return dMj;
    }

    /* renamed from: a */
    public static final void m8556a(C5688b c5688b, Object... objArr) {
        AppMethodBeat.m2504i(126029);
        if (c5688b == null) {
            C5687a.m8543w("Vending.QuickAccess", "dummy mario", new Object[0]);
            AppMethodBeat.m2505o(126029);
        } else if (objArr.length > 0) {
            c5688b.mo11581B(objArr);
            AppMethodBeat.m2505o(126029);
        } else {
            c5688b.resume();
            AppMethodBeat.m2505o(126029);
        }
    }

    /* renamed from: a */
    public static final void m8555a(C5688b c5688b) {
        AppMethodBeat.m2504i(126030);
        if (c5688b == null) {
            C5687a.m8543w("Vending.QuickAccess", "dummy mario", new Object[0]);
            AppMethodBeat.m2505o(126030);
            return;
        }
        c5688b.mo11582cR(null);
        AppMethodBeat.m2505o(126030);
    }

    /* renamed from: a */
    public static final <_Var> void m8557a(C5692d<_Var> c5692d) {
        AppMethodBeat.m2504i(126031);
        final C5688b dMo = C5698f.dMo();
        c5692d.mo11587a(new C5691b<_Var>() {
            /* renamed from: az */
            public final void mo5270az(_Var _var) {
                AppMethodBeat.m2504i(126017);
                C5698f.m8556a(dMo, _var);
                AppMethodBeat.m2505o(126017);
            }
        }).mo11586a(new C5690a() {
            /* renamed from: bi */
            public final void mo9345bi(Object obj) {
                AppMethodBeat.m2504i(126033);
                dMo.mo11582cR(obj);
                AppMethodBeat.m2505o(126033);
            }
        });
        AppMethodBeat.m2505o(126031);
    }
}
