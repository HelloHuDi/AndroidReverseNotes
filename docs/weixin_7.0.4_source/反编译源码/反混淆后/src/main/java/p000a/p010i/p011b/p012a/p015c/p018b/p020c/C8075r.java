package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p018b.C36954ad;
import p000a.p010i.p011b.p012a.p015c.p018b.C44877n;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C17284b;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31745g;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h.C17288b;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.c.r */
public final class C8075r extends C25087j implements C36954ad {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C8075r.class), "fragments", "getFragments()Ljava/util/List;"))};
    final C8174b BfP;
    private final C41441f BiB;
    private final C31746h BiC;
    final C31637v BiD;

    /* renamed from: a.i.b.a.c.b.c.r$b */
    static final class C8076b extends C25053k implements C31214a<C31746h> {
        final /* synthetic */ C8075r BiE;

        C8076b(C8075r c8075r) {
            this.BiE = c8075r;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119465);
            C31746h c31746h;
            if (this.BiE.getFragments().isEmpty()) {
                c31746h = C17288b.BGh;
                AppMethodBeat.m2505o(119465);
                return c31746h;
            }
            Iterable<C36953ab> fragments = this.BiE.getFragments();
            Collection arrayList = new ArrayList(C25034m.m39318d(fragments));
            for (C36953ab dXR : fragments) {
                arrayList.add(dXR.dXR());
            }
            c31746h = new C17284b("package view scope for " + this.BiE.BfP + " in " + this.BiE.BiD.BgZ, C25035t.m39326a((Collection) (List) arrayList, (Object) new C41178ae(this.BiE.BiD, this.BiE.BfP)));
            AppMethodBeat.m2505o(119465);
            return c31746h;
        }
    }

    /* renamed from: a.i.b.a.c.b.c.r$a */
    static final class C8077a extends C25053k implements C31214a<List<? extends C36953ab>> {
        final /* synthetic */ C8075r BiE;

        C8077a(C8075r c8075r) {
            this.BiE = c8075r;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119464);
            List h = this.BiE.BiD.eaE().mo17925h(this.BiE.BfP);
            AppMethodBeat.m2505o(119464);
            return h;
        }
    }

    static {
        AppMethodBeat.m2504i(119466);
        AppMethodBeat.m2505o(119466);
    }

    public final List<C36953ab> getFragments() {
        AppMethodBeat.m2504i(119467);
        List list = (List) C17310h.m26799a(this.BiB, eQB[0]);
        AppMethodBeat.m2505o(119467);
        return list;
    }

    public final C8174b dZF() {
        return this.BfP;
    }

    public C8075r(C31637v c31637v, C8174b c8174b, C25212i c25212i) {
        C25052j.m39376p(c31637v, "module");
        C25052j.m39376p(c8174b, "fqName");
        C25052j.m39376p(c25212i, "storageManager");
        C0027a c0027a = C0026g.BfJ;
        super(C0027a.eai(), c8174b.ByQ.ehL());
        AppMethodBeat.m2504i(119472);
        this.BiD = c31637v;
        this.BfP = c8174b;
        this.BiB = c25212i.mo31373i(new C8077a(this));
        this.BiC = new C31745g(c25212i.mo31373i(new C8076b(this)));
        AppMethodBeat.m2505o(119472);
    }

    public final C31746h dXR() {
        return this.BiC;
    }

    public final boolean equals(Object obj) {
        Object obj2;
        AppMethodBeat.m2504i(119469);
        if (obj instanceof C36954ad) {
            obj2 = obj;
        } else {
            obj2 = null;
        }
        C36954ad c36954ad = (C36954ad) obj2;
        if (c36954ad == null) {
            AppMethodBeat.m2505o(119469);
            return false;
        } else if (C25052j.m39373j(this.BfP, c36954ad.dZF()) && C25052j.m39373j(this.BiD, c36954ad.dZG())) {
            AppMethodBeat.m2505o(119469);
            return true;
        } else {
            AppMethodBeat.m2505o(119469);
            return false;
        }
    }

    /* renamed from: a */
    public final <R, D> R mo245a(C44877n<R, D> c44877n, D d) {
        AppMethodBeat.m2504i(119471);
        C25052j.m39376p(c44877n, "visitor");
        Object a = c44877n.mo13669a((C36954ad) this, (Object) d);
        AppMethodBeat.m2505o(119471);
        return a;
    }

    public final /* synthetic */ C31642l dXW() {
        C36954ad c36954ad;
        AppMethodBeat.m2504i(119468);
        if (this.BfP.ByQ.ByV.isEmpty()) {
            c36954ad = null;
        } else {
            C31637v c31637v = this.BiD;
            C8174b ehG = this.BfP.ehG();
            C25052j.m39375o(ehG, "fqName.parent()");
            c36954ad = c31637v.mo252g(ehG);
        }
        C31642l c31642l = c36954ad;
        AppMethodBeat.m2505o(119468);
        return c31642l;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(119470);
        int hashCode = (this.BiD.hashCode() * 31) + this.BfP.hashCode();
        AppMethodBeat.m2505o(119470);
        return hashCode;
    }

    public final /* bridge */ /* synthetic */ C25093y dZG() {
        return this.BiD;
    }

    public final boolean isEmpty() {
        AppMethodBeat.m2504i(119473);
        boolean isEmpty = getFragments().isEmpty();
        AppMethodBeat.m2505o(119473);
        return isEmpty;
    }
}
