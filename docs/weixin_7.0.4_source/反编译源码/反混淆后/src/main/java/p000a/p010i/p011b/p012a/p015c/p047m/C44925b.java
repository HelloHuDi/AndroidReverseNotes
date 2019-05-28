package p000a.p010i.p011b.p012a.p015c.p047m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;

/* renamed from: a.i.b.a.c.m.b */
public interface C44925b {

    /* renamed from: a.i.b.a.c.m.b$a */
    public static final class C25240a {
        /* renamed from: a */
        public static String m39808a(C44925b c44925b, C8083t c8083t) {
            AppMethodBeat.m2504i(122848);
            C25052j.m39376p(c8083t, "functionDescriptor");
            if (c44925b.mo253h(c8083t)) {
                AppMethodBeat.m2505o(122848);
                return null;
            }
            String description = c44925b.getDescription();
            AppMethodBeat.m2505o(122848);
            return description;
        }
    }

    String getDescription();

    /* renamed from: h */
    boolean mo253h(C8083t c8083t);

    /* renamed from: i */
    String mo18042i(C8083t c8083t);
}
