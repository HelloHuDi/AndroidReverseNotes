package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C44877n;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a.C8037a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.p040a.C44908h;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.c */
public abstract class C17166c extends C25087j implements C41396ak {
    private static final C37022f Bhe = C37022f.avZ("<this>");

    public final /* bridge */ /* synthetic */ C8045a dYU() {
        return this;
    }

    public final /* bridge */ /* synthetic */ C31642l dZd() {
        return this;
    }

    public C17166c(C0026g c0026g) {
        super(c0026g, Bhe);
    }

    /* renamed from: a */
    public final <R, D> R mo245a(C44877n<R, D> c44877n, D d) {
        return c44877n.mo13673a((C41396ak) this, (Object) d);
    }

    public final C41396ak dYQ() {
        return null;
    }

    public final C41396ak dYR() {
        return null;
    }

    public final List<C36955ar> dYS() {
        return Collections.emptyList();
    }

    public final C46867w dYT() {
        return dZS();
    }

    public final C46867w dZS() {
        return dZO().dZS();
    }

    public final List<C41399au> dYV() {
        return Collections.emptyList();
    }

    public final boolean dYW() {
        return false;
    }

    public final Collection<? extends C8045a> dYX() {
        return Collections.emptySet();
    }

    public final C25082az dYf() {
        return C8051ay.Bfb;
    }

    public final C41398am dYo() {
        return C41398am.BeR;
    }

    /* renamed from: a */
    public final <V> V mo17833a(C8037a<V> c8037a) {
        return null;
    }

    /* renamed from: e */
    public final C41396ak mo17870f(C25227au c25227au) {
        if (c25227au.Bik.isEmpty()) {
            return this;
        }
        C46867w c;
        if (dXW() instanceof C46865e) {
            c = c25227au.mo42080c(dZS(), C0163ba.OUT_VARIANCE);
        } else {
            c = c25227au.mo42080c(dZS(), C0163ba.INVARIANT);
        }
        if (c == null) {
            return null;
        }
        return c != dZS() ? new C31633ac(dXW(), new C44908h(c), dYn()) : this;
    }
}
