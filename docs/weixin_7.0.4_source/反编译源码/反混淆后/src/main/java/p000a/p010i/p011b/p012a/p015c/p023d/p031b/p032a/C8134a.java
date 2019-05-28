package p000a.p010i.p011b.p012a.p015c.p023d.p031b.p032a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import p000a.p001a.C31586ag;
import p000a.p005f.p007b.C25052j;
import p000a.p009h.C0016h;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17257d;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41421g;

/* renamed from: a.i.b.a.c.d.b.a.a */
public final class C8134a {
    public final C8132a Bsc;
    public final C41421g Bsd;
    private final C17257d Bse;
    public final String[] Bsf;
    public final String[] Bsg;
    private final String Bsh;
    private final int Bsi;
    private final String packageName;
    public final String[] strings;

    /* renamed from: a.i.b.a.c.d.b.a.a$a */
    public enum C8132a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        private static final Map<Integer, C8132a> Bsq = null;
        public static final C8133a Bsr = null;
        /* renamed from: id */
        private final int f2138id;

        /* renamed from: a.i.b.a.c.d.b.a.a$a$a */
        public static final class C8133a {
            private C8133a() {
            }

            public /* synthetic */ C8133a(byte b) {
                this();
            }
        }

        private C8132a(int i) {
            this.f2138id = i;
        }

        static {
            Bsr = new C8133a();
            C8132a[] values = C8132a.values();
            Map linkedHashMap = new LinkedHashMap(C0016h.m19im(C31586ag.m51047SI(values.length), 16));
            int length = values.length;
            int i;
            while (i < length) {
                C8132a c8132a = values[i];
                linkedHashMap.put(Integer.valueOf(c8132a.f2138id), c8132a);
                i++;
            }
            Bsq = linkedHashMap;
            AppMethodBeat.m2505o(120337);
        }

        /* renamed from: SO */
        public static final C8132a m14316SO(int i) {
            AppMethodBeat.m2504i(120340);
            C8132a c8132a = (C8132a) Bsq.get(Integer.valueOf(i));
            if (c8132a == null) {
                c8132a = UNKNOWN;
            }
            AppMethodBeat.m2505o(120340);
            return c8132a;
        }
    }

    public C8134a(C8132a c8132a, C41421g c41421g, C17257d c17257d, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        C25052j.m39376p(c8132a, "kind");
        C25052j.m39376p(c41421g, "metadataVersion");
        C25052j.m39376p(c17257d, "bytecodeVersion");
        AppMethodBeat.m2504i(120342);
        this.Bsc = c8132a;
        this.Bsd = c41421g;
        this.Bse = c17257d;
        this.Bsf = strArr;
        this.Bsg = strArr2;
        this.strings = strArr3;
        this.Bsh = str;
        this.Bsi = i;
        this.packageName = str2;
        AppMethodBeat.m2505o(120342);
    }

    public final String ecv() {
        return (this.Bsc == C8132a.MULTIFILE_CLASS_PART ? 1 : null) != null ? this.Bsh : null;
    }

    public final boolean ecw() {
        return (this.Bsi & 2) != 0;
    }

    public final String toString() {
        AppMethodBeat.m2504i(120341);
        String str = this.Bsc + " version=" + this.Bsd;
        AppMethodBeat.m2505o(120341);
        return str;
    }
}
