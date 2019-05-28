package a.i.b.a.c.b.c;

import a.i.b.a.c.b.am;
import a.i.b.a.c.b.l;
import a.i.b.a.c.i.b.f;
import a.i.b.a.c.k.g;

public abstract class ak extends aj {
    static final /* synthetic */ boolean $assertionsDisabled = (!ak.class.desiredAssertionStatus());
    protected final boolean BjC;
    protected g<f<?>> BjD;

    public ak(l lVar, a.i.b.a.c.b.a.g gVar, a.i.b.a.c.f.f fVar, boolean z, am amVar) {
        super(lVar, gVar, fVar, null, amVar);
        this.BjC = z;
    }

    public final boolean dZZ() {
        return this.BjC;
    }

    public final f<?> eaa() {
        if (this.BjD != null) {
            return (f) this.BjD.invoke();
        }
        return null;
    }

    public final void a(g<f<?>> gVar) {
        if ($assertionsDisabled || !this.BjC) {
            this.BjD = gVar;
            return;
        }
        throw new AssertionError("Constant value for variable initializer should be recorded only for final variables: " + this.BgZ);
    }
}
