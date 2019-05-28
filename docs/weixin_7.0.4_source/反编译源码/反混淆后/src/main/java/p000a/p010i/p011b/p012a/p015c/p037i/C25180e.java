package p000a.p010i.p011b.p012a.p015c.p037i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;

/* renamed from: a.i.b.a.c.i.e */
public interface C25180e {

    /* renamed from: a.i.b.a.c.i.e$a */
    public enum C25181a {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH;

        static {
            AppMethodBeat.m2505o(121978);
        }
    }

    /* renamed from: a.i.b.a.c.i.e$b */
    public enum C25182b {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN;

        static {
            AppMethodBeat.m2505o(121981);
        }
    }

    /* renamed from: a */
    C25182b mo42047a(C8045a c8045a, C8045a c8045a2, C46865e c46865e);

    C25181a eaX();
}
