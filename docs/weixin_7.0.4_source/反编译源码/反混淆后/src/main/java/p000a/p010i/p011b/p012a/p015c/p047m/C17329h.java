package p000a.p010i.p011b.p012a.p015c.p047m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p047m.C44925b.C25240a;

/* renamed from: a.i.b.a.c.m.h */
final class C17329h implements C44925b {
    public static final C17329h BLG = new C17329h();
    private static final String description = description;

    static {
        AppMethodBeat.m2504i(122874);
        AppMethodBeat.m2505o(122874);
    }

    private C17329h() {
    }

    /* renamed from: i */
    public final String mo18042i(C8083t c8083t) {
        AppMethodBeat.m2504i(122875);
        C25052j.m39376p(c8083t, "functionDescriptor");
        String a = C25240a.m39808a(this, c8083t);
        AppMethodBeat.m2505o(122875);
        return a;
    }

    public final String getDescription() {
        return description;
    }

    /* renamed from: h */
    public final boolean mo253h(C8083t c8083t) {
        AppMethodBeat.m2504i(122873);
        C25052j.m39376p(c8083t, "functionDescriptor");
        List dYV = c8083t.dYV();
        C25052j.m39375o(dYV, "functionDescriptor.valueParameters");
        Iterable<C41399au> iterable = dYV;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (C41399au c41399au : iterable) {
                Object obj;
                C25052j.m39375o(c41399au, "it");
                if (C41434a.m72280b(c41399au) || c41399au.dZV() != null) {
                    obj = null;
                    continue;
                } else {
                    obj = 1;
                    continue;
                }
                if (obj == null) {
                    AppMethodBeat.m2505o(122873);
                    return false;
                }
            }
        }
        AppMethodBeat.m2505o(122873);
        return true;
    }
}
