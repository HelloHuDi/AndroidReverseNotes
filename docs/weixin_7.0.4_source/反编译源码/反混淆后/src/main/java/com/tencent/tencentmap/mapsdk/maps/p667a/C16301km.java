package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41075lv.C36534a;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.km */
final class C16301km<T, S extends C36529kt> implements C36534a<C16298kg<T, S>> {
    /* renamed from: a */
    private final C46800kj<T, S> f3469a;
    /* renamed from: b */
    private final C31081mf<? super C36529kt, Boolean> f3470b;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.km$a */
    static class C16302a<T, S extends C36529kt> implements C36536lx {
        /* renamed from: a */
        private final C5908ly<? super C16298kg<T, S>> f3471a;
        /* renamed from: b */
        private final C46800kj<T, S> f3472b;
        /* renamed from: c */
        private final C31081mf<? super C36529kt, Boolean> f3473c;
        /* renamed from: d */
        private volatile C44532kz<C36526kk<T, S>> f3474d;
        /* renamed from: e */
        private final AtomicLong f3475e = new AtomicLong(0);

        C16302a(C46800kj<T, S> c46800kj, C31081mf<? super C36529kt, Boolean> c31081mf, C5908ly<? super C16298kg<T, S>> c5908ly) {
            AppMethodBeat.m2504i(100241);
            this.f3472b = c46800kj;
            this.f3473c = c31081mf;
            this.f3471a = c5908ly;
            this.f3474d = C44532kz.m80826a(new C36526kk(c46800kj, 0));
            AppMethodBeat.m2505o(100241);
        }

        /* renamed from: a */
        public void mo29561a(long j) {
            AppMethodBeat.m2504i(100242);
            if (j != 0) {
                try {
                    if (this.f3475e.get() != Long.MAX_VALUE) {
                        if (j == Long.MAX_VALUE) {
                            m25115a();
                            AppMethodBeat.m2505o(100242);
                            return;
                        }
                        m25116b(j);
                        AppMethodBeat.m2505o(100242);
                        return;
                    }
                } catch (RuntimeException e) {
                    this.f3471a.mo57774a((Throwable) e);
                    AppMethodBeat.m2505o(100242);
                    return;
                }
            }
            AppMethodBeat.m2505o(100242);
        }

        /* renamed from: a */
        private void m25115a() {
            AppMethodBeat.m2504i(100243);
            this.f3475e.set(Long.MAX_VALUE);
            this.f3472b.mo65162a(this.f3473c, this.f3471a);
            if (!this.f3471a.mo12544c()) {
                this.f3471a.mo57772a();
            }
            AppMethodBeat.m2505o(100243);
        }

        /* renamed from: b */
        private void m25116b(long j) {
            AppMethodBeat.m2504i(100244);
            if (this.f3475e.getAndAdd(j) == 0) {
                while (true) {
                    long j2 = this.f3475e.get();
                    this.f3474d = C44531kd.m80824a(this.f3473c, this.f3471a, this.f3474d, j2);
                    if (this.f3474d.mo70915b()) {
                        if (this.f3471a.mo12544c()) {
                            AppMethodBeat.m2505o(100244);
                            return;
                        }
                        this.f3471a.mo57772a();
                    } else if (this.f3475e.addAndGet(-j2) == 0) {
                        AppMethodBeat.m2505o(100244);
                        return;
                    }
                }
            } else {
                AppMethodBeat.m2505o(100244);
            }
        }
    }

    C16301km(C46800kj<T, S> c46800kj, C31081mf<? super C36529kt, Boolean> c31081mf) {
        this.f3469a = c46800kj;
        this.f3470b = c31081mf;
    }

    /* renamed from: a */
    public final void mo29559a(C5908ly<? super C16298kg<T, S>> c5908ly) {
        AppMethodBeat.m2504i(100245);
        c5908ly.mo12542a(new C16302a(this.f3469a, this.f3470b, c5908ly));
        AppMethodBeat.m2505o(100245);
    }
}
