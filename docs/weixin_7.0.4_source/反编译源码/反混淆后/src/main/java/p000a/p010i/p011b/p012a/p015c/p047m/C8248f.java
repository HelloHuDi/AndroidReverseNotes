package p000a.p010i.p011b.p012a.p015c.p047m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p047m.C44925b.C25240a;

/* renamed from: a.i.b.a.c.m.f */
public abstract class C8248f implements C44925b {
    private final String description;

    /* renamed from: a.i.b.a.c.m.f$b */
    public static final class C8249b extends C8248f {
        public static final C8249b BLE = new C8249b();

        static {
            AppMethodBeat.m2504i(122870);
            AppMethodBeat.m2505o(122870);
        }

        private C8249b() {
            super("must be a member or an extension function", (byte) 0);
        }

        /* renamed from: h */
        public final boolean mo253h(C8083t c8083t) {
            AppMethodBeat.m2504i(122869);
            C25052j.m39376p(c8083t, "functionDescriptor");
            if (c8083t.dYR() == null && c8083t.dYQ() == null) {
                AppMethodBeat.m2505o(122869);
                return false;
            }
            AppMethodBeat.m2505o(122869);
            return true;
        }
    }

    /* renamed from: a.i.b.a.c.m.f$a */
    public static final class C8250a extends C8248f {
        public static final C8250a BLD = new C8250a();

        static {
            AppMethodBeat.m2504i(122868);
            AppMethodBeat.m2505o(122868);
        }

        private C8250a() {
            super("must be a member function", (byte) 0);
        }

        /* renamed from: h */
        public final boolean mo253h(C8083t c8083t) {
            AppMethodBeat.m2504i(122867);
            C25052j.m39376p(c8083t, "functionDescriptor");
            if (c8083t.dYR() != null) {
                AppMethodBeat.m2505o(122867);
                return true;
            }
            AppMethodBeat.m2505o(122867);
            return false;
        }
    }

    private C8248f(String str) {
        this.description = str;
    }

    public /* synthetic */ C8248f(String str, byte b) {
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
