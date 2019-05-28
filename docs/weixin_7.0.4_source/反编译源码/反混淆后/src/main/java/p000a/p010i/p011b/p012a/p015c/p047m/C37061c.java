package p000a.p010i.p011b.p012a.p015c.p047m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.m.c */
public abstract class C37061c {
    public final boolean cxT;

    /* renamed from: a.i.b.a.c.m.c$c */
    public static final class C37062c extends C37061c {
        public static final C37062c BLu = new C37062c();

        static {
            AppMethodBeat.m2504i(122851);
            AppMethodBeat.m2505o(122851);
        }

        private C37062c() {
            super(true, (byte) 0);
        }
    }

    /* renamed from: a.i.b.a.c.m.c$a */
    public static final class C37063a extends C37061c {
        public static final C37063a BLt = new C37063a();

        static {
            AppMethodBeat.m2504i(122849);
            AppMethodBeat.m2505o(122849);
        }

        private C37063a() {
            super(false, (byte) 0);
        }
    }

    /* renamed from: a.i.b.a.c.m.c$b */
    public static final class C37064b extends C37061c {
        private final String error;

        public C37064b(String str) {
            C25052j.m39376p(str, "error");
            super(false, (byte) 0);
            AppMethodBeat.m2504i(122850);
            this.error = str;
            AppMethodBeat.m2505o(122850);
        }
    }

    private C37061c(boolean z) {
        this.cxT = z;
    }

    public /* synthetic */ C37061c(boolean z, byte b) {
        this(z);
    }
}
