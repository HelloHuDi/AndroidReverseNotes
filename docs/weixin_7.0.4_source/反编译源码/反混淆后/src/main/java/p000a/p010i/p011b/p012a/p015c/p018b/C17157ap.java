package p000a.p010i.p011b.p012a.p015c.p018b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;

/* renamed from: a.i.b.a.c.b.ap */
public interface C17157ap {

    /* renamed from: a.i.b.a.c.b.ap$a */
    public static final class C17158a implements C17157ap {
        public static final C17158a BeT = new C17158a();

        static {
            AppMethodBeat.m2504i(119294);
            AppMethodBeat.m2505o(119294);
        }

        private C17158a() {
        }

        /* renamed from: a */
        public final Collection<C46867w> mo31255a(C17313an c17313an, Collection<? extends C46867w> collection, C17126b<? super C17313an, ? extends Iterable<? extends C46867w>> c17126b, C17126b<? super C46867w, C37091y> c17126b2) {
            AppMethodBeat.m2504i(119293);
            C25052j.m39376p(c17313an, "currentTypeConstructor");
            C25052j.m39376p(collection, "superTypes");
            C25052j.m39376p(c17126b, "neighbors");
            C25052j.m39376p(c17126b2, "reportLoop");
            AppMethodBeat.m2505o(119293);
            return collection;
        }
    }

    /* renamed from: a */
    Collection<C46867w> mo31255a(C17313an c17313an, Collection<? extends C46867w> collection, C17126b<? super C17313an, ? extends Iterable<? extends C46867w>> c17126b, C17126b<? super C46867w, C37091y> c17126b2);
}
