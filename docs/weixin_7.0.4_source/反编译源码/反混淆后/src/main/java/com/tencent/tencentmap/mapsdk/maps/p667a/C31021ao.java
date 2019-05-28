package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C46752b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ao */
public final class C31021ao implements C24355au {
    /* renamed from: a */
    private Context f14049a;
    /* renamed from: b */
    private boolean f14050b = false;
    /* renamed from: c */
    private Object f14051c = new Object();
    /* renamed from: d */
    private Object f14052d = new Object();
    /* renamed from: e */
    private Object f14053e = new Object();
    /* renamed from: f */
    private List<C24356av> f14054f;
    /* renamed from: g */
    private long f14055g = 60000;
    /* renamed from: h */
    private Runnable f14056h = new C243531();
    /* renamed from: i */
    private Runnable f14057i = new C310202();
    /* renamed from: j */
    private Runnable f14058j = new C310223();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ao$1 */
    class C243531 implements Runnable {
        C243531() {
        }

        public final void run() {
            AppMethodBeat.m2504i(98484);
            C31021ao.this.mo50345a();
            AppMethodBeat.m2505o(98484);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ao$2 */
    class C310202 implements Runnable {
        C310202() {
        }

        public final void run() {
            AppMethodBeat.m2504i(98485);
            C31021ao.m49828a(C31021ao.this);
            AppMethodBeat.m2505o(98485);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ao$3 */
    class C310223 implements Runnable {
        C310223() {
        }

        public final void run() {
            AppMethodBeat.m2504i(98486);
            C16205ag.m24689f(" db events to up", new Object[0]);
            try {
                C25011ax.m39273a(false);
                AppMethodBeat.m2505o(98486);
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                AppMethodBeat.m2505o(98486);
            }
        }
    }

    public C31021ao(Context context) {
        AppMethodBeat.m2504i(98487);
        this.f14049a = context;
        this.f14054f = new ArrayList(25);
        AppMethodBeat.m2505o(98487);
    }

    /* renamed from: b */
    private synchronized List<C24356av> m49829b() {
        List<C24356av> list;
        AppMethodBeat.m2504i(98488);
        if (this.f14054f == null || this.f14054f.size() <= 0 || !m49831d()) {
            list = null;
            AppMethodBeat.m2505o(98488);
        } else {
            list = new ArrayList();
            list.addAll(this.f14054f);
            this.f14054f.clear();
            C16205ag.m24685b(" get MN:" + list.size(), new Object[0]);
            AppMethodBeat.m2505o(98488);
        }
        return list;
    }

    /* renamed from: a */
    public final boolean mo40526a(C24356av c24356av) {
        AppMethodBeat.m2504i(98489);
        synchronized (this.f14051c) {
            try {
                String str = " BF eN:%s   isRT:%b ";
                Object[] objArr = new Object[2];
                objArr[0] = c24356av == null ? BuildConfig.COMMAND : c24356av.mo40536d();
                objArr[1] = Boolean.FALSE;
                C16205ag.m24689f(str, objArr);
                if (this.f14049a == null || c24356av == null || !this.f14050b) {
                    C16205ag.m24687d(" err BF 1R", new Object[0]);
                } else if (m49831d()) {
                    C46769as g = C25011ax.m39275d().mo41926g();
                    int c = g.mo75349c();
                    this.f14055g = (long) (g.mo75350d() * 1000);
                    int size = this.f14054f.size();
                    if (size >= c) {
                        C16205ag.m24689f(" BF mN!", new Object[0]);
                        C46752b.m88622a().mo12298a(this.f14056h);
                        C46752b.m88622a().mo12297a(102, this.f14056h, this.f14055g, this.f14055g);
                    }
                    this.f14054f.add(c24356av);
                    if (this.f14054f.size() >= c) {
                        C16205ag.m24686c(" err BF 3R! list size:".concat(String.valueOf(size)), new Object[0]);
                    }
                    C16205ag.m24683a("CommonprocessUA:true!", new Object[0]);
                    AppMethodBeat.m2505o(98489);
                    return true;
                } else {
                    C16205ag.m24687d(" CommonProcess processUA return false, isEnable is false !", new Object[0]);
                    AppMethodBeat.m2505o(98489);
                    return false;
                }
            } finally {
                AppMethodBeat.m2505o(98489);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:27:0x009b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(98490);
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo50345a() {
        boolean z = false;
        AppMethodBeat.m2504i(98490);
        synchronized (this.f14052d) {
            try {
                if (m49831d()) {
                    List b = m49829b();
                    if (b == null || b.size() <= 0) {
                        C46769as g = C25011ax.m39275d().mo41926g();
                        if (g != null) {
                            z = g.mo75353g();
                        }
                        if (z) {
                            this.f14058j.run();
                            C16205ag.m24688e(" common polling up", new Object[0]);
                        }
                    } else {
                        Long[] a = C24349e.m37590a(this.f14049a, b);
                        C46771bf a2 = C46771bf.m88722a(this.f14049a);
                        if (a != null) {
                            long e = (long) C25011ax.m39275d().mo41926g().mo75351e();
                            if (C24349e.m37620l(this.f14049a)) {
                                C16205ag.m24688e(" onwifi, so half mSZ ".concat(String.valueOf(e)), new Object[0]);
                                e /= 2;
                            }
                            int j = C24349e.m37618j(this.f14049a);
                            C16205ag.m24685b("countCommomRecordNum: ".concat(String.valueOf(j)), new Object[0]);
                            if (((long) j) >= e) {
                                z = true;
                            }
                            if (z && a2.mo75358a() && a2.mo75359b()) {
                                this.f14058j.run();
                                C16205ag.m24688e(" common max up", new Object[0]);
                            }
                        }
                    }
                } else {
                    C16205ag.m24686c(" err su 1R", new Object[0]);
                }
            } finally {
                AppMethodBeat.m2505o(98490);
            }
        }
    }

    /* JADX WARNING: Missing block: B:14:0x002f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(98491);
     */
    /* JADX WARNING: Missing block: B:18:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private void m49830c() {
        AppMethodBeat.m2504i(98491);
        synchronized (this.f14053e) {
            try {
                if (m49831d()) {
                    List b = m49829b();
                    if (b != null && b.size() > 0) {
                        C24349e.m37590a(this.f14049a, b);
                    }
                } else {
                    C16205ag.m24686c(" err su 1R", new Object[0]);
                }
            } finally {
                AppMethodBeat.m2505o(98491);
            }
        }
    }

    /* renamed from: d */
    private synchronized boolean m49831d() {
        return this.f14050b;
    }

    /* renamed from: a */
    public final synchronized void mo40525a(boolean z) {
        AppMethodBeat.m2504i(98492);
        if (this.f14050b != z) {
            if (z) {
                this.f14050b = z;
                this.f14055g = (long) (C25011ax.m39275d().mo41926g().mo75350d() * 1000);
                C46752b.m88622a().mo12297a(102, this.f14056h, this.f14055g, this.f14055g);
                AppMethodBeat.m2505o(98492);
            } else {
                C46752b.m88622a().mo12296a(102);
                C46752b.m88622a().mo12296a(112);
                mo50346b(true);
                this.f14050b = z;
            }
        }
        AppMethodBeat.m2505o(98492);
    }

    /* renamed from: b */
    public final synchronized void mo50346b(boolean z) {
        AppMethodBeat.m2504i(98493);
        C16205ag.m24688e("common process flush memory objects to db.", new Object[0]);
        if (z) {
            m49830c();
            AppMethodBeat.m2505o(98493);
        } else {
            C46752b.m88622a().mo12298a(this.f14057i);
            AppMethodBeat.m2505o(98493);
        }
    }
}
