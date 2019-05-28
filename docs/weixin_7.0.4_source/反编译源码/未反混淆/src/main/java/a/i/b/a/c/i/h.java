package a.i.b.a.c.i;

import a.f.b.j;
import a.i.b.a.c.b.b;

public abstract class h extends i {
    public abstract void a(b bVar, b bVar2);

    public final void b(b bVar, b bVar2) {
        j.p(bVar, "fromSuper");
        j.p(bVar2, "fromCurrent");
        a(bVar, bVar2);
    }

    public final void c(b bVar, b bVar2) {
        j.p(bVar, "first");
        j.p(bVar2, "second");
        a(bVar, bVar2);
    }
}
