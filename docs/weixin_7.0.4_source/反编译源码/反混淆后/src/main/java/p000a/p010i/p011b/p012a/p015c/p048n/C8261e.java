package p000a.p010i.p011b.p012a.p015c.p048n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p000a.C17344i;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p001a.C31586ag;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

/* renamed from: a.i.b.a.c.n.e */
public final class C8261e {
    public static final C8261e BNd = new C8261e(C44928g.WARN, null, C31586ag.emptyMap(), (byte) 0);
    public static final C8261e BNe;
    public static final C8261e BNf;
    public static final C0172a BNg = new C0172a();
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C8261e.class), "description", "getDescription()[Ljava/lang/String;"))};
    private final C44856f BMY;
    public final C44928g BMZ;
    public final C44928g BNa;
    public final Map<String, C44928g> BNb;
    public final boolean BNc;

    /* renamed from: a.i.b.a.c.n.e$a */
    public static final class C0172a {
        private C0172a() {
        }

        public /* synthetic */ C0172a(byte b) {
            this();
        }
    }

    /* renamed from: a.i.b.a.c.n.e$b */
    static final class C8262b extends C25053k implements C31214a<String[]> {
        final /* synthetic */ C8261e BNh;

        C8262b(C8261e c8261e) {
            this.BNh = c8261e;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(122934);
            List arrayList = new ArrayList();
            arrayList.add(this.BNh.BMZ.description);
            C44928g c44928g = this.BNh.BNa;
            if (c44928g != null) {
                arrayList.add("under-migration:" + c44928g.description);
            }
            for (Entry entry : this.BNh.BNb.entrySet()) {
                arrayList.add("@" + ((String) entry.getKey()) + ':' + ((C44928g) entry.getValue()).description);
            }
            Object[] toArray = arrayList.toArray(new String[0]);
            if (toArray == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.m2505o(122934);
                throw c44941v;
            }
            String[] strArr = (String[]) toArray;
            AppMethodBeat.m2505o(122934);
            return strArr;
        }
    }

    /* JADX WARNING: Missing block: B:13:0x0035, code skipped:
            if ((r5.BNc == r6.BNc) != false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(122939);
        if (this != obj) {
            if (obj instanceof C8261e) {
                C8261e c8261e = (C8261e) obj;
                if (C25052j.m39373j(this.BMZ, c8261e.BMZ) && C25052j.m39373j(this.BNa, c8261e.BNa) && C25052j.m39373j(this.BNb, c8261e.BNb)) {
                }
            }
            AppMethodBeat.m2505o(122939);
            return false;
        }
        AppMethodBeat.m2505o(122939);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(122938);
        C44928g c44928g = this.BMZ;
        int hashCode = (c44928g != null ? c44928g.hashCode() : 0) * 31;
        c44928g = this.BNa;
        int hashCode2 = ((c44928g != null ? c44928g.hashCode() : 0) + hashCode) * 31;
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
        AppMethodBeat.m2505o(122938);
        return hashCode2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122937);
        String str = "Jsr305State(global=" + this.BMZ + ", migration=" + this.BNa + ", user=" + this.BNb + ", enableCompatqualCheckerFrameworkAnnotations=" + this.BNc + ")";
        AppMethodBeat.m2505o(122937);
        return str;
    }

    private C8261e(C44928g c44928g, C44928g c44928g2, Map<String, ? extends C44928g> map) {
        C25052j.m39376p(c44928g, "global");
        C25052j.m39376p(map, "user");
        AppMethodBeat.m2504i(122936);
        this.BMZ = c44928g;
        this.BNa = c44928g2;
        this.BNb = map;
        this.BNc = true;
        this.BMY = C17344i.m26854g(new C8262b(this));
        AppMethodBeat.m2505o(122936);
    }

    private /* synthetic */ C8261e(C44928g c44928g, C44928g c44928g2, Map map, byte b) {
        this(c44928g, c44928g2, map);
    }

    public final boolean ekx() {
        return ((C8261e) this) == BNe;
    }

    static {
        AppMethodBeat.m2504i(122935);
        C44928g c44928g = C44928g.IGNORE;
        BNe = new C8261e(c44928g, c44928g, C31586ag.emptyMap(), (byte) 0);
        c44928g = C44928g.STRICT;
        BNf = new C8261e(c44928g, c44928g, C31586ag.emptyMap(), (byte) 0);
        AppMethodBeat.m2505o(122935);
    }
}
