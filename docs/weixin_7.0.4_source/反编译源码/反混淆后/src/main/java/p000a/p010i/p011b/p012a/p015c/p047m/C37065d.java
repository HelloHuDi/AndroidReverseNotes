package p000a.p010i.p011b.p012a.p015c.p047m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p051k.C25274k;

/* renamed from: a.i.b.a.c.m.d */
public final class C37065d {
    public final C25274k BLv;
    public final Collection<C37022f> BLw;
    public final C17126b<C8083t, String> BLx;
    public final C44925b[] BLy;
    public final C37022f BgZ;

    /* renamed from: a.i.b.a.c.m.d$3 */
    static final class C01663 extends C25053k implements C17126b {
        public static final C01663 BLB = new C01663();

        static {
            AppMethodBeat.m2504i(122857);
            AppMethodBeat.m2505o(122857);
        }

        C01663() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122856);
            C25052j.m39376p((C8083t) obj, "receiver$0");
            AppMethodBeat.m2505o(122856);
            return null;
        }
    }

    /* renamed from: a.i.b.a.c.m.d$1 */
    static final class C82461 extends C25053k implements C17126b {
        public static final C82461 BLz = new C82461();

        static {
            AppMethodBeat.m2504i(122853);
            AppMethodBeat.m2505o(122853);
        }

        C82461() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122852);
            C25052j.m39376p((C8083t) obj, "receiver$0");
            AppMethodBeat.m2505o(122852);
            return null;
        }
    }

    /* renamed from: a.i.b.a.c.m.d$2 */
    static final class C82472 extends C25053k implements C17126b {
        public static final C82472 BLA = new C82472();

        static {
            AppMethodBeat.m2504i(122855);
            AppMethodBeat.m2505o(122855);
        }

        C82472() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122854);
            C25052j.m39376p((C8083t) obj, "receiver$0");
            AppMethodBeat.m2505o(122854);
            return null;
        }
    }

    private C37065d(C37022f c37022f, C25274k c25274k, Collection<C37022f> collection, C17126b<? super C8083t, String> c17126b, C44925b... c44925bArr) {
        this.BgZ = c37022f;
        this.BLv = c25274k;
        this.BLw = collection;
        this.BLx = c17126b;
        this.BLy = c44925bArr;
    }

    public C37065d(C37022f c37022f, C44925b[] c44925bArr, C17126b<? super C8083t, String> c17126b) {
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c44925bArr, "checks");
        C25052j.m39376p(c17126b, "additionalChecks");
        this(c37022f, null, null, c17126b, (C44925b[]) Arrays.copyOf(c44925bArr, c44925bArr.length));
        AppMethodBeat.m2504i(122858);
        AppMethodBeat.m2505o(122858);
    }

    private C37065d(C25274k c25274k, C44925b[] c44925bArr, C17126b<? super C8083t, String> c17126b) {
        C25052j.m39376p(c25274k, "regex");
        C25052j.m39376p(c44925bArr, "checks");
        C25052j.m39376p(c17126b, "additionalChecks");
        this(null, c25274k, null, c17126b, (C44925b[]) Arrays.copyOf(c44925bArr, c44925bArr.length));
        AppMethodBeat.m2504i(122860);
        AppMethodBeat.m2505o(122860);
    }

    public C37065d(Collection<C37022f> collection, C44925b[] c44925bArr, C17126b<? super C8083t, String> c17126b) {
        C25052j.m39376p(collection, "nameList");
        C25052j.m39376p(c44925bArr, "checks");
        C25052j.m39376p(c17126b, "additionalChecks");
        this(null, null, collection, c17126b, (C44925b[]) Arrays.copyOf(c44925bArr, c44925bArr.length));
        AppMethodBeat.m2504i(122862);
        AppMethodBeat.m2505o(122862);
    }
}
