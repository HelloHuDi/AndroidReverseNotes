package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class lv<T> {
    private static final mj b = ml.a().c();
    private static final lv<Object> c = a(new a<Object>() {
        public final void a(ly<? super Object> lyVar) {
            AppMethodBeat.i(100482);
            lyVar.a();
            AppMethodBeat.o(100482);
        }
    });
    final a<T> a;

    public interface a<T> extends me<ly<? super T>> {
    }

    protected lv(a<T> aVar) {
        this.a = aVar;
    }

    static {
        AppMethodBeat.i(100490);
        AppMethodBeat.o(100490);
    }

    public static final <T> lv<T> a(a<T> aVar) {
        AppMethodBeat.i(100486);
        lv lvVar = new lv(b.a((a) aVar));
        AppMethodBeat.o(100486);
        return lvVar;
    }

    public static final <T> lv<T> a() {
        return c;
    }

    public final void a(me<? super T> meVar) {
        AppMethodBeat.i(100487);
        b(meVar);
        AppMethodBeat.o(100487);
    }

    public final lz b(final me<? super T> meVar) {
        AppMethodBeat.i(100488);
        if (meVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("onNext can not be null");
            AppMethodBeat.o(100488);
            throw illegalArgumentException;
        }
        lz a = a(new ly<T>() {
            public final void a() {
            }

            public final void a(Throwable th) {
                AppMethodBeat.i(100484);
                md mdVar = new md(th);
                AppMethodBeat.o(100484);
                throw mdVar;
            }

            public final void a(T t) {
                AppMethodBeat.i(100485);
                meVar.a(t);
                AppMethodBeat.o(100485);
            }
        });
        AppMethodBeat.o(100488);
        return a;
    }

    public final lz a(ly<? super T> lyVar) {
        AppMethodBeat.i(100489);
        if (lyVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("observer can not be null");
            AppMethodBeat.o(100489);
            throw illegalArgumentException;
        } else if (this.a == null) {
            IllegalStateException illegalStateException = new IllegalStateException("onSubscribe function can not be null.");
            AppMethodBeat.o(100489);
            throw illegalStateException;
        } else {
            lz lyVar2;
            lyVar2.d();
            if (!(lyVar2 instanceof mh)) {
                lyVar2 = new mh(lyVar2);
            }
            lz a;
            try {
                b.a(this, this.a).a(lyVar2);
                a = b.a(lyVar2);
                AppMethodBeat.o(100489);
                return a;
            } catch (Throwable th) {
                mb.a(th);
                try {
                    lyVar2.a(b.a(th));
                    a = mm.a();
                    AppMethodBeat.o(100489);
                    return a;
                } catch (md e) {
                    AppMethodBeat.o(100489);
                    throw e;
                } catch (Throwable th2) {
                    b.a(new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2));
                    AppMethodBeat.o(100489);
                }
            }
        }
    }
}
