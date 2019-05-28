package com.tencent.p177mm.vending.p644j;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.vending.j.a */
public class C5710a {
    /* renamed from: a */
    Object[] f1357a;

    public final <T> T get(int i) {
        if (this.f1357a.length <= i) {
            return null;
        }
        return this.f1357a[i];
    }

    public final int size() {
        if (this.f1357a == null) {
            return 0;
        }
        return this.f1357a.length;
    }

    /* renamed from: cW */
    public static <$1> C7370b<$1> m8576cW($1 $1) {
        AppMethodBeat.m2504i(126102);
        C7370b c7370b = new C7370b();
        c7370b.f1357a = new Object[]{$1};
        c7370b = c7370b;
        AppMethodBeat.m2505o(126102);
        return c7370b;
    }

    /* renamed from: F */
    public static <$1, $2> C7583c<$1, $2> m8574F($1 $1, $2 $2) {
        AppMethodBeat.m2504i(126103);
        C7583c c7583c = new C7583c();
        c7583c.f1357a = new Object[]{$1, $2};
        c7583c = c7583c;
        AppMethodBeat.m2505o(126103);
        return c7583c;
    }

    /* renamed from: i */
    public static <$1, $2, $3> C7625d<$1, $2, $3> m8577i($1 $1, $2 $2, $3 $3) {
        AppMethodBeat.m2504i(126104);
        C7625d c7625d = new C7625d();
        c7625d.f1357a = new Object[]{$1, $2, $3};
        c7625d = c7625d;
        AppMethodBeat.m2505o(126104);
        return c7625d;
    }

    /* renamed from: b */
    public static <$1, $2, $3, $4, $5> C7643f<$1, $2, $3, $4, $5> m8575b($1 $1, $2 $2, $3 $3, $4 $4, $5 $5) {
        AppMethodBeat.m2504i(126105);
        C7643f c7643f = new C7643f();
        c7643f.f1357a = new Object[]{$1, $2, $3, $4, $5};
        c7643f = c7643f;
        AppMethodBeat.m2505o(126105);
        return c7643f;
    }

    public String toString() {
        AppMethodBeat.m2504i(126106);
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Object obj2 : this.f1357a) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(obj2);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(126106);
        return stringBuilder2;
    }
}
