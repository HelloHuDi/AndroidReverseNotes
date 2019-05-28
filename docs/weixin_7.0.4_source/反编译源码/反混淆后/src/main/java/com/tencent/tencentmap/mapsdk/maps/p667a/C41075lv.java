package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lv */
public class C41075lv<T> {
    /* renamed from: b */
    private static final C46806mj f16548b = C24418ml.m38014a().mo40748c();
    /* renamed from: c */
    private static final C41075lv<Object> f16549c = C41075lv.m71472a(new C410761());
    /* renamed from: a */
    final C36534a<T> f16550a;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lv$a */
    public interface C36534a<T> extends C31080me<C5908ly<? super T>> {
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lv$1 */
    static class C410761 implements C36534a<Object> {
        C410761() {
        }

        /* renamed from: a */
        public final void mo65173a(C5908ly<? super Object> c5908ly) {
            AppMethodBeat.m2504i(100482);
            c5908ly.mo57772a();
            AppMethodBeat.m2505o(100482);
        }
    }

    protected C41075lv(C36534a<T> c36534a) {
        this.f16550a = c36534a;
    }

    static {
        AppMethodBeat.m2504i(100490);
        AppMethodBeat.m2505o(100490);
    }

    /* renamed from: a */
    public static final <T> C41075lv<T> m71472a(C36534a<T> c36534a) {
        AppMethodBeat.m2504i(100486);
        C41075lv c41075lv = new C41075lv(f16548b.mo75540a((C36534a) c36534a));
        AppMethodBeat.m2505o(100486);
        return c41075lv;
    }

    /* renamed from: a */
    public static final <T> C41075lv<T> m71471a() {
        return f16549c;
    }

    /* renamed from: a */
    public final void mo65171a(C31080me<? super T> c31080me) {
        AppMethodBeat.m2504i(100487);
        mo65172b(c31080me);
        AppMethodBeat.m2505o(100487);
    }

    /* renamed from: b */
    public final C24417lz mo65172b(final C31080me<? super T> c31080me) {
        AppMethodBeat.m2504i(100488);
        if (c31080me == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("onNext can not be null");
            AppMethodBeat.m2505o(100488);
            throw illegalArgumentException;
        }
        C24417lz a = mo65170a(new C5908ly<T>() {
            /* renamed from: a */
            public final void mo57772a() {
            }

            /* renamed from: a */
            public final void mo57774a(Throwable th) {
                AppMethodBeat.m2504i(100484);
                C16306md c16306md = new C16306md(th);
                AppMethodBeat.m2505o(100484);
                throw c16306md;
            }

            /* renamed from: a */
            public final void mo57773a(T t) {
                AppMethodBeat.m2504i(100485);
                c31080me.mo29560a(t);
                AppMethodBeat.m2505o(100485);
            }
        });
        AppMethodBeat.m2505o(100488);
        return a;
    }

    /* renamed from: a */
    public final C24417lz mo65170a(C5908ly<? super T> c5908ly) {
        AppMethodBeat.m2504i(100489);
        if (c5908ly == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("observer can not be null");
            AppMethodBeat.m2505o(100489);
            throw illegalArgumentException;
        } else if (this.f16550a == null) {
            IllegalStateException illegalStateException = new IllegalStateException("onSubscribe function can not be null.");
            AppMethodBeat.m2505o(100489);
            throw illegalStateException;
        } else {
            C24417lz c5908ly2;
            c5908ly2.mo12545d();
            if (!(c5908ly2 instanceof C44538mh)) {
                c5908ly2 = new C44538mh(c5908ly2);
            }
            C24417lz a;
            try {
                f16548b.mo75541a(this, this.f16550a).mo29560a(c5908ly2);
                a = f16548b.mo75542a(c5908ly2);
                AppMethodBeat.m2505o(100489);
                return a;
            } catch (Throwable th) {
                C41077mb.m71478a(th);
                try {
                    c5908ly2.mo57774a(f16548b.mo75543a(th));
                    a = C24419mm.m38018a();
                    AppMethodBeat.m2505o(100489);
                    return a;
                } catch (C16306md e) {
                    AppMethodBeat.m2505o(100489);
                    throw e;
                } catch (Throwable th2) {
                    f16548b.mo75543a(new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2));
                    AppMethodBeat.m2505o(100489);
                }
            }
        }
    }
}
