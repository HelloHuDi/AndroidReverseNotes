package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;

final class km<T, S extends kt> implements com.tencent.tencentmap.mapsdk.maps.a.lv.a<kg<T, S>> {
    private final kj<T, S> a;
    private final mf<? super kt, Boolean> b;

    static class a<T, S extends kt> implements lx {
        private final ly<? super kg<T, S>> a;
        private final kj<T, S> b;
        private final mf<? super kt, Boolean> c;
        private volatile kz<kk<T, S>> d;
        private final AtomicLong e = new AtomicLong(0);

        a(kj<T, S> kjVar, mf<? super kt, Boolean> mfVar, ly<? super kg<T, S>> lyVar) {
            AppMethodBeat.i(100241);
            this.b = kjVar;
            this.c = mfVar;
            this.a = lyVar;
            this.d = kz.a(new kk(kjVar, 0));
            AppMethodBeat.o(100241);
        }

        public void a(long j) {
            AppMethodBeat.i(100242);
            if (j != 0) {
                try {
                    if (this.e.get() != Long.MAX_VALUE) {
                        if (j == Long.MAX_VALUE) {
                            a();
                            AppMethodBeat.o(100242);
                            return;
                        }
                        b(j);
                        AppMethodBeat.o(100242);
                        return;
                    }
                } catch (RuntimeException e) {
                    this.a.a((Throwable) e);
                    AppMethodBeat.o(100242);
                    return;
                }
            }
            AppMethodBeat.o(100242);
        }

        private void a() {
            AppMethodBeat.i(100243);
            this.e.set(Long.MAX_VALUE);
            this.b.a(this.c, this.a);
            if (!this.a.c()) {
                this.a.a();
            }
            AppMethodBeat.o(100243);
        }

        private void b(long j) {
            AppMethodBeat.i(100244);
            if (this.e.getAndAdd(j) == 0) {
                while (true) {
                    long j2 = this.e.get();
                    this.d = kd.a(this.c, this.a, this.d, j2);
                    if (this.d.b()) {
                        if (this.a.c()) {
                            AppMethodBeat.o(100244);
                            return;
                        }
                        this.a.a();
                    } else if (this.e.addAndGet(-j2) == 0) {
                        AppMethodBeat.o(100244);
                        return;
                    }
                }
            } else {
                AppMethodBeat.o(100244);
            }
        }
    }

    km(kj<T, S> kjVar, mf<? super kt, Boolean> mfVar) {
        this.a = kjVar;
        this.b = mfVar;
    }

    public final void a(ly<? super kg<T, S>> lyVar) {
        AppMethodBeat.i(100245);
        lyVar.a(new a(this.a, this.b, lyVar));
        AppMethodBeat.o(100245);
    }
}
