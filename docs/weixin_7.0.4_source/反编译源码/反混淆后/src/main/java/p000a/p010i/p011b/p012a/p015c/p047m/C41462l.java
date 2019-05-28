package p000a.p010i.p011b.p012a.p015c.p047m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p047m.C44925b.C25240a;

/* renamed from: a.i.b.a.c.m.l */
public abstract class C41462l implements C44925b {
    private final String description;

    /* renamed from: a.i.b.a.c.m.l$a */
    public static final class C0170a extends C41462l {
        /* renamed from: n */
        private final int f0n;

        public C0170a(int i) {
            super("must have at least " + i + " value parameter" + (i > 1 ? "s" : ""), (byte) 0);
            AppMethodBeat.m2504i(122900);
            this.f0n = i;
            AppMethodBeat.m2505o(122900);
        }

        /* renamed from: h */
        public final boolean mo253h(C8083t c8083t) {
            AppMethodBeat.m2504i(122899);
            C25052j.m39376p(c8083t, "functionDescriptor");
            if (c8083t.dYV().size() >= this.f0n) {
                AppMethodBeat.m2505o(122899);
                return true;
            }
            AppMethodBeat.m2505o(122899);
            return false;
        }
    }

    /* renamed from: a.i.b.a.c.m.l$b */
    public static final class C31777b extends C41462l {
        /* renamed from: n */
        private final int f14415n = 2;

        public C31777b() {
            super("must have exactly 2 value parameters", (byte) 0);
        }

        /* renamed from: h */
        public final boolean mo253h(C8083t c8083t) {
            AppMethodBeat.m2504i(122901);
            C25052j.m39376p(c8083t, "functionDescriptor");
            if (c8083t.dYV().size() == this.f14415n) {
                AppMethodBeat.m2505o(122901);
                return true;
            }
            AppMethodBeat.m2505o(122901);
            return false;
        }
    }

    /* renamed from: a.i.b.a.c.m.l$c */
    public static final class C31778c extends C41462l {
        public static final C31778c BMG = new C31778c();

        static {
            AppMethodBeat.m2504i(122903);
            AppMethodBeat.m2505o(122903);
        }

        private C31778c() {
            super("must have no value parameters", (byte) 0);
        }

        /* renamed from: h */
        public final boolean mo253h(C8083t c8083t) {
            AppMethodBeat.m2504i(122902);
            C25052j.m39376p(c8083t, "functionDescriptor");
            boolean isEmpty = c8083t.dYV().isEmpty();
            AppMethodBeat.m2505o(122902);
            return isEmpty;
        }
    }

    /* renamed from: a.i.b.a.c.m.l$d */
    public static final class C31779d extends C41462l {
        public static final C31779d BMH = new C31779d();

        static {
            AppMethodBeat.m2504i(122905);
            AppMethodBeat.m2505o(122905);
        }

        private C31779d() {
            super("must have a single value parameter", (byte) 0);
        }

        /* renamed from: h */
        public final boolean mo253h(C8083t c8083t) {
            AppMethodBeat.m2504i(122904);
            C25052j.m39376p(c8083t, "functionDescriptor");
            if (c8083t.dYV().size() == 1) {
                AppMethodBeat.m2505o(122904);
                return true;
            }
            AppMethodBeat.m2505o(122904);
            return false;
        }
    }

    private C41462l(String str) {
        this.description = str;
    }

    public /* synthetic */ C41462l(String str, byte b) {
        this(str);
    }

    public final String getDescription() {
        return this.description;
    }

    /* renamed from: i */
    public final String mo18042i(C8083t c8083t) {
        C25052j.m39376p(c8083t, "functionDescriptor");
        return C25240a.m39808a(this, c8083t);
    }
}
