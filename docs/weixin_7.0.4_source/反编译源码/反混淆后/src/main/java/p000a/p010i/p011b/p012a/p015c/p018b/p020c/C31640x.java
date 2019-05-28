package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44877n;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.c.x */
public abstract class C31640x extends C17168k implements C36953ab {
    public final C8174b BfP;

    public final C8174b dZF() {
        return this.BfP;
    }

    public C31640x(C25093y c25093y, C8174b c8174b) {
        C25052j.m39376p(c25093y, "module");
        C25052j.m39376p(c8174b, "fqName");
        C31642l c31642l = c25093y;
        C0027a c0027a = C0026g.BfJ;
        super(c31642l, C0027a.eai(), c8174b.ByQ.ehL(), C41398am.BeR);
        this.BfP = c8174b;
    }

    /* renamed from: a */
    public final <R, D> R mo245a(C44877n<R, D> c44877n, D d) {
        C25052j.m39376p(c44877n, "visitor");
        return c44877n.mo13668a((C36953ab) this, (Object) d);
    }

    /* renamed from: dZE */
    public final C25093y dXW() {
        C31642l dXW = super.dXW();
        if (dXW != null) {
            return (C25093y) dXW;
        }
        throw new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }

    public C41398am dYo() {
        C41398am c41398am = C41398am.BeR;
        C25052j.m39375o(c41398am, "SourceElement.NO_SOURCE");
        return c41398am;
    }

    public String toString() {
        return "package " + this.BfP;
    }
}
