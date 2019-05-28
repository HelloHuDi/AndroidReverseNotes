package p000a.p010i.p011b.p012a.p015c.p018b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: a.i.b.a.c.b.w */
public enum C44879w {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    public static final C25092a BeG = null;

    /* renamed from: a.i.b.a.c.b.w$a */
    public static final class C25092a {
        private C25092a() {
        }

        public /* synthetic */ C25092a(byte b) {
            this();
        }

        /* renamed from: an */
        public static C44879w m39435an(boolean z, boolean z2) {
            if (z) {
                return C44879w.ABSTRACT;
            }
            if (z2) {
                return C44879w.OPEN;
            }
            return C44879w.FINAL;
        }
    }

    static {
        BeG = new C25092a();
        AppMethodBeat.m2505o(119276);
    }
}
