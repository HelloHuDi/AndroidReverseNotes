package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C36963d;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p037i.C31747j;
import p000a.p010i.p011b.p012a.p015c.p037i.C37038h;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C31759m;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.a.a.a */
public final class C31644a {
    /* renamed from: a */
    public static <D extends C25085b> Collection<D> m51182a(Collection<D> collection, Collection<D> collection2, C46865e c46865e, C31759m c31759m) {
        AppMethodBeat.m2504i(119747);
        Collection a = C31644a.m51183a(collection, collection2, c46865e, c31759m, false);
        AppMethodBeat.m2505o(119747);
        return a;
    }

    /* renamed from: b */
    public static <D extends C25085b> Collection<D> m51185b(Collection<D> collection, Collection<D> collection2, C46865e c46865e, C31759m c31759m) {
        AppMethodBeat.m2504i(119748);
        Collection a = C31644a.m51183a(collection, collection2, c46865e, c31759m, true);
        AppMethodBeat.m2505o(119748);
        return a;
    }

    /* renamed from: a */
    private static <D extends C25085b> Collection<D> m51183a(Collection<D> collection, Collection<D> collection2, C46865e c46865e, final C31759m c31759m, final boolean z) {
        AppMethodBeat.m2504i(119749);
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        C31747j.m51406a((Collection) collection, (Collection) collection2, c46865e, new C37038h() {

            /* renamed from: a.i.b.a.c.d.a.a.a$1$1 */
            class C171731 implements C17126b<C25085b, C37091y> {
                C171731() {
                }

                /* renamed from: am */
                public final /* synthetic */ Object mo50am(Object obj) {
                    AppMethodBeat.m2504i(119744);
                    c31759m.mo51747d((C25085b) obj);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(119744);
                    return c37091y;
                }
            }

            /* renamed from: g */
            public final void mo232g(C25085b c25085b) {
                AppMethodBeat.m2504i(119745);
                C31747j.m51402a(c25085b, new C171731());
                linkedHashSet.add(c25085b);
                AppMethodBeat.m2505o(119745);
            }

            /* renamed from: a */
            public final void mo231a(C25085b c25085b, C25085b c25085b2) {
            }

            /* renamed from: a */
            public final void mo31270a(C25085b c25085b, Collection<? extends C25085b> collection) {
                AppMethodBeat.m2504i(119746);
                if (!z || c25085b.dYZ() == C8063a.FAKE_OVERRIDE) {
                    super.mo31270a(c25085b, collection);
                    AppMethodBeat.m2505o(119746);
                    return;
                }
                AppMethodBeat.m2505o(119746);
            }
        });
        AppMethodBeat.m2505o(119749);
        return linkedHashSet;
    }

    /* renamed from: b */
    public static C41399au m51184b(C37022f c37022f, C46865e c46865e) {
        AppMethodBeat.m2504i(119750);
        Collection dYb = c46865e.dYb();
        if (dYb.size() != 1) {
            AppMethodBeat.m2505o(119750);
            return null;
        }
        for (C41399au c41399au : ((C36963d) dYb.iterator().next()).dYV()) {
            if (c41399au.dZg().equals(c37022f)) {
                AppMethodBeat.m2505o(119750);
                return c41399au;
            }
        }
        AppMethodBeat.m2505o(119750);
        return null;
    }
}
