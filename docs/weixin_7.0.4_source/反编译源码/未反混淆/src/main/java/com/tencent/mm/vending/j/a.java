package com.tencent.mm.vending.j;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    Object[] a;

    public final <T> T get(int i) {
        if (this.a.length <= i) {
            return null;
        }
        return this.a[i];
    }

    public final int size() {
        if (this.a == null) {
            return 0;
        }
        return this.a.length;
    }

    public static <$1> b<$1> cW($1 $1) {
        AppMethodBeat.i(126102);
        b bVar = new b();
        bVar.a = new Object[]{$1};
        bVar = bVar;
        AppMethodBeat.o(126102);
        return bVar;
    }

    public static <$1, $2> c<$1, $2> F($1 $1, $2 $2) {
        AppMethodBeat.i(126103);
        c cVar = new c();
        cVar.a = new Object[]{$1, $2};
        cVar = cVar;
        AppMethodBeat.o(126103);
        return cVar;
    }

    public static <$1, $2, $3> d<$1, $2, $3> i($1 $1, $2 $2, $3 $3) {
        AppMethodBeat.i(126104);
        d dVar = new d();
        dVar.a = new Object[]{$1, $2, $3};
        dVar = dVar;
        AppMethodBeat.o(126104);
        return dVar;
    }

    public static <$1, $2, $3, $4, $5> f<$1, $2, $3, $4, $5> b($1 $1, $2 $2, $3 $3, $4 $4, $5 $5) {
        AppMethodBeat.i(126105);
        f fVar = new f();
        fVar.a = new Object[]{$1, $2, $3, $4, $5};
        fVar = fVar;
        AppMethodBeat.o(126105);
        return fVar;
    }

    public String toString() {
        AppMethodBeat.i(126106);
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Object obj2 : this.a) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(obj2);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(126106);
        return stringBuilder2;
    }
}
