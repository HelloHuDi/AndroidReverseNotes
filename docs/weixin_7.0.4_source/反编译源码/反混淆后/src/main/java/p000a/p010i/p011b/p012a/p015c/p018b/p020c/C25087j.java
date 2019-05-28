package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C36950b;
import p000a.p010i.p011b.p012a.p015c.p036h.C31724c;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.j */
public abstract class C25087j extends C36950b implements C31642l {
    protected final C37022f BgZ;

    public C25087j(C0026g c0026g, C37022f c37022f) {
        super(c0026g);
        this.BgZ = c37022f;
    }

    public final C37022f dZg() {
        return this.BgZ;
    }

    public C31642l dZd() {
        return this;
    }

    public String toString() {
        return C25087j.m39416h(this);
    }

    /* renamed from: h */
    public static String m39416h(C31642l c31642l) {
        try {
            return C31724c.BBN.mo13667k(c31642l) + "[" + c31642l.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(c31642l)) + "]";
        } catch (Throwable th) {
            return c31642l.getClass().getSimpleName() + " " + c31642l.dZg();
        }
    }
}
