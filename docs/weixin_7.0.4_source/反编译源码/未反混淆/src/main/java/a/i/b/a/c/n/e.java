package a.i.b.a.c.n;

import a.a.ag;
import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class e {
    public static final e BNd = new e(g.WARN, null, ag.emptyMap(), (byte) 0);
    public static final e BNe;
    public static final e BNf;
    public static final a BNg = new a();
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(e.class), "description", "getDescription()[Ljava/lang/String;"))};
    private final f BMY;
    public final g BMZ;
    public final g BNa;
    public final Map<String, g> BNb;
    public final boolean BNc;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static final class b extends a.f.b.k implements a.f.a.a<String[]> {
        final /* synthetic */ e BNh;

        b(e eVar) {
            this.BNh = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(122934);
            List arrayList = new ArrayList();
            arrayList.add(this.BNh.BMZ.description);
            g gVar = this.BNh.BNa;
            if (gVar != null) {
                arrayList.add("under-migration:" + gVar.description);
            }
            for (Entry entry : this.BNh.BNb.entrySet()) {
                arrayList.add("@" + ((String) entry.getKey()) + ':' + ((g) entry.getValue()).description);
            }
            Object[] toArray = arrayList.toArray(new String[0]);
            if (toArray == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(122934);
                throw vVar;
            }
            String[] strArr = (String[]) toArray;
            AppMethodBeat.o(122934);
            return strArr;
        }
    }

    /* JADX WARNING: Missing block: B:13:0x0035, code skipped:
            if ((r5.BNc == r6.BNc) != false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(122939);
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (j.j(this.BMZ, eVar.BMZ) && j.j(this.BNa, eVar.BNa) && j.j(this.BNb, eVar.BNb)) {
                }
            }
            AppMethodBeat.o(122939);
            return false;
        }
        AppMethodBeat.o(122939);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(122938);
        g gVar = this.BMZ;
        int hashCode = (gVar != null ? gVar.hashCode() : 0) * 31;
        gVar = this.BNa;
        int hashCode2 = ((gVar != null ? gVar.hashCode() : 0) + hashCode) * 31;
        Map map = this.BNb;
        if (map != null) {
            i = map.hashCode();
        }
        i = (hashCode2 + i) * 31;
        hashCode2 = this.BNc;
        if (hashCode2 != 0) {
            hashCode2 = 1;
        }
        hashCode2 += i;
        AppMethodBeat.o(122938);
        return hashCode2;
    }

    public final String toString() {
        AppMethodBeat.i(122937);
        String str = "Jsr305State(global=" + this.BMZ + ", migration=" + this.BNa + ", user=" + this.BNb + ", enableCompatqualCheckerFrameworkAnnotations=" + this.BNc + ")";
        AppMethodBeat.o(122937);
        return str;
    }

    private e(g gVar, g gVar2, Map<String, ? extends g> map) {
        j.p(gVar, "global");
        j.p(map, "user");
        AppMethodBeat.i(122936);
        this.BMZ = gVar;
        this.BNa = gVar2;
        this.BNb = map;
        this.BNc = true;
        this.BMY = i.g(new b(this));
        AppMethodBeat.o(122936);
    }

    private /* synthetic */ e(g gVar, g gVar2, Map map, byte b) {
        this(gVar, gVar2, map);
    }

    public final boolean ekx() {
        return ((e) this) == BNe;
    }

    static {
        AppMethodBeat.i(122935);
        g gVar = g.IGNORE;
        BNe = new e(gVar, gVar, ag.emptyMap(), (byte) 0);
        gVar = g.STRICT;
        BNf = new e(gVar, gVar, ag.emptyMap(), (byte) 0);
        AppMethodBeat.o(122935);
    }
}
