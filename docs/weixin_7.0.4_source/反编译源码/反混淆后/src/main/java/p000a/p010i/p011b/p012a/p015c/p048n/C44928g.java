package p000a.p010i.p011b.p012a.p015c.p048n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.n.g */
public enum C44928g {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");
    
    public static final C44927a BNn = null;
    final String description;

    /* renamed from: a.i.b.a.c.n.g$a */
    public static final class C44927a {
        private C44927a() {
        }

        public /* synthetic */ C44927a(byte b) {
            this();
        }
    }

    private C44928g(String str) {
        C25052j.m39376p(str, "description");
        AppMethodBeat.m2504i(122945);
        this.description = str;
        AppMethodBeat.m2505o(122945);
    }

    static {
        BNn = new C44927a();
        AppMethodBeat.m2505o(122944);
    }

    public final boolean eky() {
        return ((C44928g) this) == WARN;
    }

    public final boolean ekz() {
        return ((C44928g) this) == IGNORE;
    }
}
