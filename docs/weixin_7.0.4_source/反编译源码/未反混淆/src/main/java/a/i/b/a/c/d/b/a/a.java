package a.i.b.a.c.d.b.a;

import a.a.ag;
import a.f.b.j;
import a.h.h;
import a.i.b.a.c.e.b.a.d;
import a.i.b.a.c.e.b.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a {
    public final a Bsc;
    public final g Bsd;
    private final d Bse;
    public final String[] Bsf;
    public final String[] Bsg;
    private final String Bsh;
    private final int Bsi;
    private final String packageName;
    public final String[] strings;

    public enum a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        private static final Map<Integer, a> Bsq = null;
        public static final a Bsr = null;
        private final int id;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        private a(int i) {
            this.id = i;
        }

        static {
            Bsr = new a();
            a[] values = values();
            Map linkedHashMap = new LinkedHashMap(h.im(ag.SI(values.length), 16));
            int length = values.length;
            int i;
            while (i < length) {
                a aVar = values[i];
                linkedHashMap.put(Integer.valueOf(aVar.id), aVar);
                i++;
            }
            Bsq = linkedHashMap;
            AppMethodBeat.o(120337);
        }

        public static final a SO(int i) {
            AppMethodBeat.i(120340);
            a aVar = (a) Bsq.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = UNKNOWN;
            }
            AppMethodBeat.o(120340);
            return aVar;
        }
    }

    public a(a aVar, g gVar, d dVar, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        j.p(aVar, "kind");
        j.p(gVar, "metadataVersion");
        j.p(dVar, "bytecodeVersion");
        AppMethodBeat.i(120342);
        this.Bsc = aVar;
        this.Bsd = gVar;
        this.Bse = dVar;
        this.Bsf = strArr;
        this.Bsg = strArr2;
        this.strings = strArr3;
        this.Bsh = str;
        this.Bsi = i;
        this.packageName = str2;
        AppMethodBeat.o(120342);
    }

    public final String ecv() {
        return (this.Bsc == a.MULTIFILE_CLASS_PART ? 1 : null) != null ? this.Bsh : null;
    }

    public final boolean ecw() {
        return (this.Bsi & 2) != 0;
    }

    public final String toString() {
        AppMethodBeat.i(120341);
        String str = this.Bsc + " version=" + this.Bsd;
        AppMethodBeat.o(120341);
        return str;
    }
}
