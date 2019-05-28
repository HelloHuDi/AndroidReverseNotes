package a.i.b.a.c.l;

import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.a.c;
import a.i.b.a.c.b.a.g;
import a.k.r;

public abstract class ad extends az {
    public abstract ad d(g gVar);

    public abstract ad rL(boolean z);

    public ad() {
        super();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (c cVar : dYn()) {
            r.a(stringBuilder, "[", a.i.b.a.c.h.c.BBN.a(cVar, null), "] ");
        }
        stringBuilder.append(ejw());
        if (!ejt().isEmpty()) {
            t.a(ejt(), stringBuilder, ", ", "<", ">", 0, null, null, 112);
        }
        if (eci()) {
            stringBuilder.append("?");
        }
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }
}
