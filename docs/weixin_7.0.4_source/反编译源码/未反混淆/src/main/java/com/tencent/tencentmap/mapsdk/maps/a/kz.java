package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class kz<T> implements Iterable<T> {
    private static kz<?> c = new kz();
    private final T a;
    private final kz<T> b;

    static class a<U> implements Iterator<U> {
        private kz<U> a;

        public a(kz<U> kzVar) {
            this.a = kzVar;
        }

        public boolean hasNext() {
            AppMethodBeat.i(100290);
            if (this.a.b()) {
                AppMethodBeat.o(100290);
                return false;
            }
            AppMethodBeat.o(100290);
            return true;
        }

        public U next() {
            AppMethodBeat.i(100291);
            Object c = this.a.c();
            this.a = this.a.d();
            AppMethodBeat.o(100291);
            return c;
        }

        public void remove() {
            AppMethodBeat.i(100292);
            RuntimeException runtimeException = new RuntimeException("not supported");
            AppMethodBeat.o(100292);
            throw runtimeException;
        }
    }

    static {
        AppMethodBeat.i(100296);
        AppMethodBeat.o(100296);
    }

    public kz(T t, kz<T> kzVar) {
        this.a = t;
        this.b = kzVar;
    }

    public static <T> kz<T> a(T t) {
        AppMethodBeat.i(100293);
        kz kzVar = new kz(t, a());
        AppMethodBeat.o(100293);
        return kzVar;
    }

    public kz() {
        this(null, null);
    }

    public static <S> kz<S> a() {
        return c;
    }

    public final boolean b() {
        return this.a == null;
    }

    public final T c() {
        return this.a;
    }

    public final kz<T> d() {
        return this.b;
    }

    public final kz<T> b(T t) {
        AppMethodBeat.i(100294);
        kz kzVar = new kz(t, this);
        AppMethodBeat.o(100294);
        return kzVar;
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.i(100295);
        a aVar = new a(this);
        AppMethodBeat.o(100295);
        return aVar;
    }
}
