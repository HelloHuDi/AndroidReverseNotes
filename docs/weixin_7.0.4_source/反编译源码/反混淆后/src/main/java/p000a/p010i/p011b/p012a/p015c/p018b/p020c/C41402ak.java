package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C41432f;
import p000a.p010i.p011b.p012a.p015c.p044k.C41442g;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.ak */
public abstract class C41402ak extends C44874aj {
    static final /* synthetic */ boolean $assertionsDisabled = (!C41402ak.class.desiredAssertionStatus());
    protected final boolean BjC;
    protected C41442g<C41432f<?>> BjD;

    public C41402ak(C31642l c31642l, C0026g c0026g, C37022f c37022f, boolean z, C41398am c41398am) {
        super(c31642l, c0026g, c37022f, null, c41398am);
        this.BjC = z;
    }

    public final boolean dZZ() {
        return this.BjC;
    }

    public final C41432f<?> eaa() {
        if (this.BjD != null) {
            return (C41432f) this.BjD.invoke();
        }
        return null;
    }

    /* renamed from: a */
    public final void mo66053a(C41442g<C41432f<?>> c41442g) {
        if ($assertionsDisabled || !this.BjC) {
            this.BjD = c41442g;
            return;
        }
        throw new AssertionError("Constant value for variable initializer should be recorded only for final variables: " + this.BgZ);
    }
}
