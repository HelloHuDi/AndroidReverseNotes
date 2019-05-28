package a.i.b.a.c.l;

import a.i.b.a.c.b.a.g;

public abstract class j extends i {
    private final ad BpK;

    public j(ad adVar) {
        a.f.b.j.p(adVar, "delegate");
        this.BpK = adVar;
    }

    public final /* synthetic */ az b(g gVar) {
        return i(gVar);
    }

    public final /* synthetic */ ad d(g gVar) {
        return i(gVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final ad eby() {
        return this.BpK;
    }

    private j i(g gVar) {
        a.f.b.j.p(gVar, "newAnnotations");
        if (gVar != dYn()) {
            return new d(this, gVar);
        }
        return this;
    }

    /* renamed from: rL */
    public final ad rK(boolean z) {
        if (z == eci()) {
            return this;
        }
        return this.BpK.rL(z).d(dYn());
    }
}
