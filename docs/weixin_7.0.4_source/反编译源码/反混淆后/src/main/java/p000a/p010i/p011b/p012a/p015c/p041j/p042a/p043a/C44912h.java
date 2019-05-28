package p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import p000a.p001a.C25035t;
import p000a.p001a.C44628q;
import p000a.p001a.C44629x;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p018b.p775b.C17160b;
import p000a.p010i.p011b.p012a.p015c.p021c.C17171a;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C0039c;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C36655am;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C36999ag;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C6143s;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31698a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C37007i;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C37007i.C37008a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C41420h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0136d;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C31758k;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C8225i;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.j.a.a.h */
public final class C44912h extends C41183g {
    private final C36953ab BIw;
    private final C8174b BcW = this.BIw.dZF();

    /* renamed from: a */
    public final /* synthetic */ Collection mo220a(C0136d c0136d, C17126b c17126b) {
        AppMethodBeat.m2504i(122405);
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        Collection b = mo65814b(c0136d, c17126b, C0039c.WHEN_GET_ALL_DESCRIPTORS);
        Collection arrayList = new ArrayList();
        for (C17160b d : this.BHj.Brl.BGV) {
            C44628q.m81054a(arrayList, (Iterable) d.mo31260d(this.BcW));
        }
        arrayList = C25035t.m39331b(b, (Iterable) (List) arrayList);
        AppMethodBeat.m2505o(122405);
        return arrayList;
    }

    public C44912h(C36953ab c36953ab, C6143s c6143s, C31702c c31702c, C31698a c31698a, C44640e c44640e, C8225i c8225i, C31214a<? extends Collection<C37022f>> c31214a) {
        C25052j.m39376p(c36953ab, "packageDescriptor");
        C25052j.m39376p(c6143s, "proto");
        C25052j.m39376p(c31702c, "nameResolver");
        C25052j.m39376p(c31698a, "metadataVersion");
        C25052j.m39376p(c8225i, "components");
        C25052j.m39376p(c31214a, "classNames");
        C36999ag c36999ag = c6143s.BtC;
        C25052j.m39375o(c36999ag, "proto.typeTable");
        C41420h c41420h = new C41420h(c36999ag);
        C37008a c37008a = C37007i.Bxj;
        C36655am c36655am = c6143s.BtE;
        C25052j.m39375o(c36655am, "proto.versionRequirementTable");
        C31758k a = c8225i.mo18022a(c36953ab, c31702c, c41420h, C37008a.m61878g(c36655am), c31698a, c44640e);
        List list = c6143s.Btw;
        C25052j.m39375o(list, "proto.functionList");
        Collection collection = list;
        List list2 = c6143s.Btx;
        C25052j.m39375o(list2, "proto.propertyList");
        Collection collection2 = list2;
        List list3 = c6143s.Bty;
        C25052j.m39375o(list3, "proto.typeAliasList");
        super(a, collection, collection2, list3, c31214a);
        AppMethodBeat.m2504i(122411);
        this.BIw = c36953ab;
        AppMethodBeat.m2505o(122411);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: D */
    public final boolean mo65813D(C37022f c37022f) {
        AppMethodBeat.m2504i(122406);
        C25052j.m39376p(c37022f, "name");
        if (!super.mo65813D(c37022f)) {
            Object obj;
            Iterable<C17160b> iterable = this.BHj.Brl.BGV;
            if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                for (C17160b a : iterable) {
                    if (a.mo31259a(this.BcW, c37022f)) {
                        obj = 1;
                        break;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                AppMethodBeat.m2505o(122406);
                return false;
            }
        }
        AppMethodBeat.m2505o(122406);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: A */
    public final C8173a mo42053A(C37022f c37022f) {
        AppMethodBeat.m2504i(122407);
        C25052j.m39376p(c37022f, "name");
        C8173a c8173a = new C8173a(this.BcW, c37022f);
        AppMethodBeat.m2505o(122407);
        return c8173a;
    }

    /* renamed from: c */
    public final C0036h mo222c(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122408);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        mo41969d(c37022f, c8085a);
        C0036h c = super.mo222c(c37022f, c8085a);
        AppMethodBeat.m2505o(122408);
        return c;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final void mo42056c(Collection<C31642l> collection, C17126b<? super C37022f, Boolean> c17126b) {
        AppMethodBeat.m2504i(122410);
        C25052j.m39376p(collection, "result");
        C25052j.m39376p(c17126b, "nameFilter");
        AppMethodBeat.m2505o(122410);
    }

    /* renamed from: d */
    public final void mo41969d(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122409);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        C17171a.m26542a(this.BHj.Brl.Bnc, c8085a, this.BIw, c37022f);
        AppMethodBeat.m2505o(122409);
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<C37022f> ejY() {
        return C44629x.AUR;
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<C37022f> ejZ() {
        return C44629x.AUR;
    }
}
