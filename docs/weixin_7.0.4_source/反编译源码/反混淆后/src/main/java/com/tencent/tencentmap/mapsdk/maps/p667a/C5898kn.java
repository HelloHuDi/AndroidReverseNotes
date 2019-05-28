package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kn */
public final class C5898kn<T, S extends C36529kt> {
    /* renamed from: d */
    private static final C31081mf<C36529kt, Boolean> f1656d = new C58972();
    /* renamed from: a */
    private final C46800kj<T, S> f1657a;
    /* renamed from: b */
    private final C31072kf f1658b;
    /* renamed from: c */
    private int f1659c;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kn$2 */
    static class C58972 implements C31081mf<C36529kt, Boolean> {
        C58972() {
        }

        /* renamed from: a */
        public final Boolean mo12521a(C36529kt c36529kt) {
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kn$a */
    public static class C5900a {
        /* renamed from: a */
        private Integer f1661a;
        /* renamed from: b */
        private Integer f1662b;
        /* renamed from: c */
        private C5902kq f1663c;
        /* renamed from: d */
        private C5901ko f1664d;
        /* renamed from: e */
        private boolean f1665e;

        /* synthetic */ C5900a(C58991 c58991) {
            this();
        }

        private C5900a() {
            AppMethodBeat.m2504i(100250);
            this.f1661a = null;
            this.f1662b = null;
            this.f1663c = new C36527kr();
            this.f1664d = new C7391kp();
            this.f1665e = false;
            AppMethodBeat.m2505o(100250);
        }

        /* renamed from: a */
        public C5900a mo12528a(int i) {
            AppMethodBeat.m2504i(100251);
            this.f1662b = Integer.valueOf(i);
            AppMethodBeat.m2505o(100251);
            return this;
        }

        /* renamed from: b */
        public C5900a mo12530b(int i) {
            AppMethodBeat.m2504i(100252);
            this.f1661a = Integer.valueOf(i);
            AppMethodBeat.m2505o(100252);
            return this;
        }

        /* renamed from: a */
        public <T, S extends C36529kt> C5898kn<T, S> mo12529a() {
            AppMethodBeat.m2504i(100253);
            if (this.f1661a == null) {
                this.f1661a = Integer.valueOf(4);
            }
            if (this.f1662b == null) {
                this.f1662b = Integer.valueOf((int) Math.round(((double) this.f1661a.intValue()) * 0.4d));
            }
            C5898kn c5898kn = new C5898kn(new C31072kf(this.f1662b.intValue(), this.f1661a.intValue(), this.f1664d, this.f1663c), null);
            AppMethodBeat.m2505o(100253);
            return c5898kn;
        }
    }

    /* synthetic */ C5898kn(C31072kf c31072kf, C58991 c58991) {
        this(c31072kf);
    }

    private C5898kn(C46800kj<T, S> c46800kj, int i, C31072kf c31072kf) {
        this.f1657a = c46800kj;
        this.f1659c = i;
        this.f1658b = c31072kf;
    }

    private C5898kn(C31072kf c31072kf) {
        this(null, 0, c31072kf);
    }

    /* renamed from: a */
    public static C5900a m9167a(int i) {
        AppMethodBeat.m2504i(100254);
        C5900a a = new C5900a().mo12528a(i);
        AppMethodBeat.m2505o(100254);
        return a;
    }

    /* renamed from: a */
    public final C5898kn<T, S> mo12523a(C16298kg<? extends T, ? extends S> c16298kg) {
        AppMethodBeat.m2504i(100255);
        if (this.f1657a != null) {
            C46800kj c46800kj;
            List a = this.f1657a.mo65161a(c16298kg);
            if (a.size() == 1) {
                c46800kj = (C46800kj) a.get(0);
            } else {
                c46800kj = new C41071kl(a, this.f1658b);
            }
            C5898kn<T, S> c5898kn = new C5898kn(c46800kj, this.f1659c + 1, this.f1658b);
            AppMethodBeat.m2505o(100255);
            return c5898kn;
        }
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new C16298kg[]{c16298kg});
        C5898kn<T, S> c5898kn2 = new C5898kn(new C41070ki(arrayList, this.f1658b), this.f1659c + 1, this.f1658b);
        AppMethodBeat.m2505o(100255);
        return c5898kn2;
    }

    /* renamed from: a */
    public final C5898kn<T, S> mo12524a(T t, S s) {
        AppMethodBeat.m2504i(100256);
        C5898kn a = mo12523a(C16298kg.m25106a(t, s));
        AppMethodBeat.m2505o(100256);
        return a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C41075lv<C16298kg<T, S>> mo12525a(C31081mf<? super C36529kt, Boolean> c31081mf) {
        AppMethodBeat.m2504i(100257);
        if (this.f1657a != null) {
            C41075lv a = C41075lv.m71472a(new C16301km(this.f1657a, c31081mf));
            AppMethodBeat.m2505o(100257);
            return a;
        }
        C41075lv<C16298kg<T, S>> a2 = C41075lv.m71471a();
        AppMethodBeat.m2505o(100257);
        return a2;
    }

    /* renamed from: a */
    public static C31081mf<C36529kt, Boolean> m9168a(final C16304ky c16304ky) {
        AppMethodBeat.m2504i(100258);
        C58991 c58991 = new C31081mf<C36529kt, Boolean>() {
            /* renamed from: a */
            public final Boolean mo12527a(C36529kt c36529kt) {
                AppMethodBeat.m2504i(100247);
                Boolean valueOf = Boolean.valueOf(c36529kt.mo29566a(c16304ky));
                AppMethodBeat.m2505o(100247);
                return valueOf;
            }
        };
        AppMethodBeat.m2505o(100258);
        return c58991;
    }

    static {
        AppMethodBeat.m2504i(100260);
        AppMethodBeat.m2505o(100260);
    }

    /* renamed from: b */
    public final C41075lv<C16298kg<T, S>> mo12526b(C16304ky c16304ky) {
        AppMethodBeat.m2504i(100259);
        C41075lv a = mo12525a(C5898kn.m9168a(c16304ky));
        AppMethodBeat.m2505o(100259);
        return a;
    }
}
