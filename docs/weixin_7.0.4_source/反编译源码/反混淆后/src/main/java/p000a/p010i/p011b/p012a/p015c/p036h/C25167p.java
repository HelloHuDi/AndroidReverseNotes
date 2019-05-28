package p000a.p010i.p011b.p012a.p015c.p036h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

/* renamed from: a.i.b.a.c.h.p */
public enum C25167p {
    ;

    /* renamed from: a.i.b.a.c.h.p$a */
    static final class C25168a extends C25167p {
        C25168a(String str) {
            super(str, 1);
        }

        public final String escape(String str) {
            AppMethodBeat.m2504i(121912);
            C25052j.m39376p(str, "string");
            String i = C6163u.m9838i(C6163u.m9838i(str, "<", "&lt;", false), ">", "&gt;", false);
            AppMethodBeat.m2505o(121912);
            return i;
        }
    }

    /* renamed from: a.i.b.a.c.h.p$b */
    static final class C25169b extends C25167p {
        C25169b(String str) {
            super(str, 0);
        }

        public final String escape(String str) {
            AppMethodBeat.m2504i(121913);
            C25052j.m39376p(str, "string");
            AppMethodBeat.m2505o(121913);
            return str;
        }
    }

    public abstract String escape(String str);
}
