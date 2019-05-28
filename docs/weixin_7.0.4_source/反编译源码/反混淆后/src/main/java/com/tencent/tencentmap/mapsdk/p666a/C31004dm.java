package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dm */
public class C31004dm {
    /* renamed from: A */
    private static String f13983A = "color_texture_flat_style.png";
    /* renamed from: B */
    private boolean f13984B;
    /* renamed from: C */
    private C31005a f13985C;
    /* renamed from: D */
    private C24341cx f13986D;
    /* renamed from: E */
    private int f13987E;
    /* renamed from: F */
    private int f13988F;
    /* renamed from: a */
    private final List<C24343db> f13989a;
    /* renamed from: b */
    private float f13990b;
    /* renamed from: c */
    private float f13991c;
    /* renamed from: d */
    private int f13992d;
    /* renamed from: e */
    private int f13993e;
    /* renamed from: f */
    private boolean f13994f;
    /* renamed from: g */
    private boolean f13995g;
    /* renamed from: h */
    private boolean f13996h;
    /* renamed from: i */
    private boolean f13997i;
    /* renamed from: j */
    private float f13998j;
    /* renamed from: k */
    private boolean f13999k;
    /* renamed from: l */
    private C36465ck f14000l;
    /* renamed from: m */
    private List<Integer> f14001m;
    /* renamed from: n */
    private int[] f14002n;
    /* renamed from: o */
    private int[] f14003o;
    /* renamed from: p */
    private int[] f14004p;
    /* renamed from: q */
    private int f14005q;
    /* renamed from: r */
    private int f14006r;
    @Deprecated
    /* renamed from: s */
    private String f14007s;
    /* renamed from: t */
    private C41018cm f14008t;
    /* renamed from: u */
    private boolean f14009u;
    /* renamed from: v */
    private int f14010v;
    /* renamed from: w */
    private boolean f14011w;
    /* renamed from: x */
    private List<C24343db> f14012x;
    /* renamed from: y */
    private boolean f14013y;
    /* renamed from: z */
    private C41018cm f14014z;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.dm$a */
    public enum C31005a {
        LINE_COLOR_NONE,
        LINE_COLOR_TEXTURE,
        LINE_COLOR_ARGB;

        static {
            AppMethodBeat.m2505o(101082);
        }
    }

    /* renamed from: a */
    public int mo50235a() {
        return this.f14010v;
    }

    /* renamed from: b */
    public List<C24343db> mo50250b() {
        return this.f14012x;
    }

    public C31004dm() {
        AppMethodBeat.m2504i(101083);
        this.f13997i = false;
        this.f14002n = null;
        this.f14003o = new int[]{-16711936};
        this.f14004p = null;
        this.f14005q = -7829368;
        this.f14006r = 0;
        this.f14007s = f13983A;
        this.f14008t = C5839cn.m8917a(f13983A);
        this.f14009u = false;
        this.f14010v = 0;
        this.f14011w = true;
        this.f14013y = false;
        this.f14014z = null;
        this.f13985C = C31005a.LINE_COLOR_NONE;
        this.f13987E = C24347di.f4621a;
        this.f13988F = 100;
        this.f13990b = -1.0f;
        this.f13992d = C36520ic.f15406k;
        this.f13994f = true;
        this.f13995g = false;
        this.f13989a = new ArrayList();
        this.f13998j = 1.0f;
        this.f13999k = false;
        this.f14010v = 0;
        this.f13993e = 0;
        this.f14012x = new ArrayList();
        AppMethodBeat.m2505o(101083);
    }

    @Deprecated
    /* renamed from: a */
    public void mo50244a(List<C24343db> list) {
        AppMethodBeat.m2504i(101084);
        mo50248b((List) list);
        AppMethodBeat.m2505o(101084);
    }

    /* renamed from: b */
    public C31004dm mo50248b(List<C24343db> list) {
        AppMethodBeat.m2504i(101085);
        if (list != null) {
            this.f13989a.clear();
            this.f13989a.addAll(list);
        }
        AppMethodBeat.m2505o(101085);
        return this;
    }

    /* renamed from: a */
    public C31004dm mo50240a(C24343db c24343db, C24343db... c24343dbArr) {
        AppMethodBeat.m2504i(101086);
        this.f13989a.add(c24343db);
        if (c24343dbArr != null) {
            mo50243a(c24343dbArr);
        }
        AppMethodBeat.m2505o(101086);
        return this;
    }

    /* renamed from: a */
    public C31004dm mo50243a(C24343db[] c24343dbArr) {
        AppMethodBeat.m2504i(101087);
        if (c24343dbArr != null) {
            this.f13989a.addAll(Arrays.asList(c24343dbArr));
        }
        AppMethodBeat.m2505o(101087);
        return this;
    }

    /* renamed from: a */
    public C31004dm mo50241a(Iterable<C24343db> iterable) {
        AppMethodBeat.m2504i(101088);
        if (iterable != null) {
            for (C24343db a : iterable) {
                mo50240a(a, new C24343db[0]);
            }
        }
        AppMethodBeat.m2505o(101088);
        return this;
    }

    /* renamed from: a */
    public C31004dm mo50236a(float f) {
        if (f < 0.0f) {
            this.f13990b = 9.0f;
        } else {
            this.f13990b = f;
        }
        return this;
    }

    /* renamed from: b */
    public C31004dm mo50245b(float f) {
        if (f < 0.0f) {
            this.f13991c = 1.0f;
        } else {
            this.f13991c = f;
        }
        return this;
    }

    /* renamed from: c */
    public C31005a mo50251c() {
        return this.f13985C;
    }

    /* renamed from: a */
    public C31004dm mo50237a(int i) {
        this.f13992d = i;
        return this;
    }

    /* renamed from: b */
    public C31004dm mo50246b(int i) {
        this.f14003o = new int[]{i};
        return this;
    }

    /* renamed from: c */
    public C31004dm mo50252c(int i) {
        this.f14005q = i;
        return this;
    }

    /* renamed from: d */
    public int mo50254d() {
        return this.f14005q;
    }

    /* renamed from: d */
    public C31004dm mo50255d(int i) {
        AppMethodBeat.m2504i(101089);
        this.f13993e = Math.max(0, i);
        AppMethodBeat.m2505o(101089);
        return this;
    }

    /* renamed from: a */
    public C31004dm mo50239a(C24341cx c24341cx) {
        if (c24341cx != null) {
            this.f13986D = c24341cx;
            this.f13997i = true;
        }
        return this;
    }

    /* renamed from: a */
    public C31004dm mo50242a(boolean z) {
        this.f13994f = z;
        return this;
    }

    /* renamed from: b */
    public C31004dm mo50249b(boolean z) {
        this.f13996h = z;
        return this;
    }

    /* renamed from: e */
    public List<C24343db> mo50257e() {
        return this.f13989a;
    }

    /* renamed from: f */
    public float mo50258f() {
        return this.f13990b;
    }

    /* renamed from: g */
    public int mo50260g() {
        return this.f13992d;
    }

    /* renamed from: h */
    public int[][] mo50262h() {
        if (this.f14002n == null || this.f14004p == null || this.f14002n.length != this.f14004p.length) {
            return null;
        }
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{2, this.f14002n.length});
        iArr[0] = this.f14002n;
        iArr[1] = this.f14004p;
        return iArr;
    }

    /* renamed from: i */
    public int mo50263i() {
        return this.f13993e;
    }

    /* renamed from: j */
    public C24341cx mo50264j() {
        return this.f13986D;
    }

    /* renamed from: k */
    public boolean mo50265k() {
        return this.f13994f;
    }

    /* renamed from: l */
    public boolean mo50266l() {
        return this.f13996h;
    }

    /* renamed from: m */
    public boolean mo50267m() {
        return this.f13997i;
    }

    /* renamed from: n */
    public float mo50268n() {
        return this.f13998j;
    }

    /* renamed from: o */
    public boolean mo50269o() {
        return this.f13999k;
    }

    /* renamed from: p */
    public C36465ck mo50270p() {
        return this.f14000l;
    }

    /* renamed from: q */
    public int mo50271q() {
        return this.f14006r;
    }

    /* renamed from: e */
    public C31004dm mo50256e(int i) {
        this.f14006r = i;
        return this;
    }

    /* renamed from: a */
    public C31004dm mo50238a(C41018cm c41018cm) {
        this.f14008t = c41018cm;
        this.f13985C = C31005a.LINE_COLOR_TEXTURE;
        return this;
    }

    /* renamed from: r */
    public C41018cm mo50272r() {
        return this.f14008t;
    }

    /* renamed from: s */
    public boolean mo50273s() {
        return this.f14011w;
    }

    /* renamed from: f */
    public C31004dm mo50259f(int i) {
        if (i >= C24347di.f4621a && i <= C24347di.f4623c) {
            this.f13987E = i;
        }
        return this;
    }

    /* renamed from: t */
    public int mo50274t() {
        return this.f13987E;
    }

    /* renamed from: b */
    public C31004dm mo50247b(C41018cm c41018cm) {
        this.f14014z = c41018cm;
        return this;
    }

    /* renamed from: g */
    public C31004dm mo50261g(int i) {
        this.f13988F = i;
        return this;
    }

    /* renamed from: u */
    public C41018cm mo50275u() {
        return this.f14014z;
    }

    /* renamed from: v */
    public int mo50276v() {
        return this.f13988F;
    }

    /* renamed from: w */
    public boolean mo50277w() {
        return this.f13984B;
    }

    /* renamed from: x */
    public List<Integer> mo50278x() {
        return this.f14001m;
    }

    /* renamed from: c */
    public C31004dm mo50253c(List<Integer> list) {
        this.f14001m = list;
        return this;
    }

    /* renamed from: y */
    public float mo50279y() {
        return this.f13991c;
    }

    /* renamed from: z */
    public int[] mo50280z() {
        return this.f14003o;
    }
}
