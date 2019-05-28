package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C46752b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.t */
public final class C36541t {
    /* renamed from: c */
    private static C36541t f15452c = null;
    /* renamed from: a */
    protected C44540v f15453a = null;
    /* renamed from: b */
    protected Context f15454b = null;
    /* renamed from: d */
    private boolean f15455d = false;
    /* renamed from: e */
    private int f15456e = 0;
    /* renamed from: f */
    private C46770bd f15457f = null;
    /* renamed from: g */
    private Runnable f15458g = null;
    /* renamed from: h */
    private List<C24421s> f15459h = new ArrayList(5);
    /* renamed from: i */
    private SparseArray<C41033be> f15460i = new SparseArray(5);
    /* renamed from: j */
    private List<C44542w> f15461j = new ArrayList(5);
    /* renamed from: k */
    private SparseArray<C44543x> f15462k = new SparseArray(2);
    /* renamed from: l */
    private boolean f15463l = false;
    /* renamed from: m */
    private Runnable f15464m = new C365401();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.t$1 */
    class C365401 implements Runnable {
        C365401() {
        }

        public final void run() {
            AppMethodBeat.m2504i(100542);
            if (!(C36541t.this.f15454b == null || C36541t.this.f15453a == null)) {
                C36541t.this.f15453a.mo70934a(C36541t.this.f15454b);
            }
            AppMethodBeat.m2505o(100542);
        }
    }

    /* renamed from: a */
    public static synchronized C36541t m60530a(Context context) {
        C36541t c36541t;
        synchronized (C36541t.class) {
            AppMethodBeat.m2504i(100545);
            if (f15452c == null && context != null) {
                f15452c = new C36541t(context);
            }
            c36541t = f15452c;
            AppMethodBeat.m2505o(100545);
        }
        return c36541t;
    }

    /* renamed from: a */
    public final synchronized boolean mo57786a() {
        return this.f15463l;
    }

    /* renamed from: b */
    public final synchronized void mo57787b() {
        this.f15463l = true;
    }

    /* renamed from: c */
    public static synchronized C41033be m60531c() {
        C41033be k;
        synchronized (C36541t.class) {
            AppMethodBeat.m2504i(100546);
            if (f15452c != null) {
                k = f15452c.m60532k();
                AppMethodBeat.m2505o(100546);
            } else {
                k = null;
                AppMethodBeat.m2505o(100546);
            }
        }
        return k;
    }

    private C36541t(Context context) {
        AppMethodBeat.m2504i(100547);
        this.f15454b = context;
        this.f15453a = C44540v.m80860a();
        C46752b.m88622a().mo12298a(this.f15464m);
        this.f15457f = new C46770bd(context);
        this.f15458g = new C16310u(context);
        C46752b.m88622a().mo12298a(this.f15458g);
        AppMethodBeat.m2505o(100547);
    }

    /* renamed from: d */
    public final synchronized Runnable mo57788d() {
        return this.f15458g;
    }

    /* renamed from: e */
    public final synchronized C44540v mo57789e() {
        return this.f15453a;
    }

    /* renamed from: k */
    private synchronized C41033be m60532k() {
        C41033be c41033be;
        AppMethodBeat.m2504i(100548);
        if (this.f15460i == null || this.f15460i.size() <= 0) {
            c41033be = null;
            AppMethodBeat.m2505o(100548);
        } else {
            c41033be = (C41033be) this.f15460i.get(0);
            AppMethodBeat.m2505o(100548);
        }
        return c41033be;
    }

    /* renamed from: a */
    public final synchronized void mo57780a(int i, C41033be c41033be) {
        AppMethodBeat.m2504i(100549);
        if (this.f15460i != null) {
            if (c41033be == null) {
                this.f15460i.remove(i);
                AppMethodBeat.m2505o(100549);
            } else {
                this.f15460i.put(i, c41033be);
                c41033be.mo65115a(mo57790f());
            }
        }
        AppMethodBeat.m2505o(100549);
    }

    /* renamed from: f */
    public final synchronized C46770bd mo57790f() {
        return this.f15457f;
    }

    /* renamed from: g */
    public final synchronized boolean mo57791g() {
        return this.f15455d;
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    /* renamed from: h */
    public final synchronized void mo57792h() {
        AppMethodBeat.m2504i(100550);
        this.f15455d = true;
        C16205ag.m24689f("isFirst }%b", Boolean.TRUE);
        AppMethodBeat.m2505o(100550);
    }

    /* renamed from: i */
    public final synchronized C24421s[] mo57793i() {
        C24421s[] c24421sArr;
        AppMethodBeat.m2504i(100551);
        if (this.f15459h == null || this.f15459h.size() <= 0) {
            c24421sArr = null;
            AppMethodBeat.m2505o(100551);
        } else {
            c24421sArr = (C24421s[]) this.f15459h.toArray(new C24421s[0]);
            AppMethodBeat.m2505o(100551);
        }
        return c24421sArr;
    }

    /* renamed from: l */
    private synchronized C44542w[] m60533l() {
        C44542w[] c44542wArr;
        AppMethodBeat.m2504i(100552);
        if (this.f15461j == null || this.f15461j.size() <= 0) {
            c44542wArr = null;
            AppMethodBeat.m2505o(100552);
        } else {
            c44542wArr = (C44542w[]) this.f15461j.toArray(new C44542w[0]);
            AppMethodBeat.m2505o(100552);
        }
        return c44542wArr;
    }

    /* renamed from: j */
    public final synchronized int mo57794j() {
        return this.f15456e;
    }

    /* renamed from: a */
    public final synchronized void mo57779a(int i) {
        AppMethodBeat.m2504i(100553);
        this.f15456e = i;
        C16205ag.m24689f("step:%d", Integer.valueOf(i));
        AppMethodBeat.m2505o(100553);
    }

    /* renamed from: a */
    public final synchronized void mo57782a(final C24421s c24421s) {
        AppMethodBeat.m2504i(100554);
        if (c24421s == null) {
            AppMethodBeat.m2505o(100554);
        } else {
            if (this.f15459h == null) {
                this.f15459h = new ArrayList();
            }
            if (!this.f15459h.contains(c24421s)) {
                this.f15459h.add(c24421s);
                final int j = mo57794j();
                if (mo57791g()) {
                    C16205ag.m24688e("add listener should notify app first run! %s", c24421s.toString());
                    C46752b.m88622a().mo12298a(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(100543);
                            c24421s.mo40751c();
                            AppMethodBeat.m2505o(100543);
                        }
                    });
                }
                if (j >= 2) {
                    C16205ag.m24688e("add listener should notify app start query! %s", c24421s.toString());
                    C46752b.m88622a().mo12298a(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(100544);
                            c24421s.mo40749a();
                            if (j >= 3) {
                                C16205ag.m24688e("query finished should notify", new Object[0]);
                                c24421s.mo40750b();
                            }
                            AppMethodBeat.m2505o(100544);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(100554);
        }
    }

    /* renamed from: a */
    public final synchronized void mo57784a(C44542w c44542w) {
        AppMethodBeat.m2504i(100555);
        if (!(c44542w == null || this.f15461j == null || this.f15461j.contains(c44542w))) {
            this.f15461j.add(c44542w);
        }
        AppMethodBeat.m2505o(100555);
    }

    /* renamed from: a */
    public final synchronized void mo57785a(C44543x c44543x) {
        AppMethodBeat.m2504i(100556);
        if (!(c44543x == null || this.f15462k == null)) {
            this.f15462k.put(1, c44543x);
        }
        AppMethodBeat.m2505o(100556);
    }

    /* renamed from: m */
    private synchronized SparseArray<C44543x> m60534m() {
        return this.f15462k;
    }

    /* renamed from: a */
    public final void mo57783a(C44540v c44540v) {
        AppMethodBeat.m2504i(100557);
        C44542w[] l = m60533l();
        if (l != null) {
            for (C44542w a : l) {
                try {
                    a.mo41921a(c44540v);
                } catch (Throwable th) {
                    C16205ag.m24684a(th);
                    C16205ag.m24687d("com strategy changed error %s", th.toString());
                }
            }
        }
        AppMethodBeat.m2505o(100557);
    }

    /* renamed from: a */
    public final void mo57781a(int i, Map<String, String> map) {
        AppMethodBeat.m2504i(100558);
        SparseArray m = m60534m();
        if (m != null) {
            C44543x c44543x = (C44543x) m.get(i);
            if (c44543x != null) {
                c44543x.mo41922a(map);
            }
        }
        AppMethodBeat.m2505o(100558);
    }
}
