package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kz */
public final class C44532kz<T> implements Iterable<T> {
    /* renamed from: c */
    private static C44532kz<?> f17477c = new C44532kz();
    /* renamed from: a */
    private final T f17478a;
    /* renamed from: b */
    private final C44532kz<T> f17479b;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kz$a */
    static class C16305a<U> implements Iterator<U> {
        /* renamed from: a */
        private C44532kz<U> f3484a;

        public C16305a(C44532kz<U> c44532kz) {
            this.f3484a = c44532kz;
        }

        public boolean hasNext() {
            AppMethodBeat.m2504i(100290);
            if (this.f3484a.mo70915b()) {
                AppMethodBeat.m2505o(100290);
                return false;
            }
            AppMethodBeat.m2505o(100290);
            return true;
        }

        public U next() {
            AppMethodBeat.m2504i(100291);
            Object c = this.f3484a.mo70916c();
            this.f3484a = this.f3484a.mo70917d();
            AppMethodBeat.m2505o(100291);
            return c;
        }

        public void remove() {
            AppMethodBeat.m2504i(100292);
            RuntimeException runtimeException = new RuntimeException("not supported");
            AppMethodBeat.m2505o(100292);
            throw runtimeException;
        }
    }

    static {
        AppMethodBeat.m2504i(100296);
        AppMethodBeat.m2505o(100296);
    }

    public C44532kz(T t, C44532kz<T> c44532kz) {
        this.f17478a = t;
        this.f17479b = c44532kz;
    }

    /* renamed from: a */
    public static <T> C44532kz<T> m80826a(T t) {
        AppMethodBeat.m2504i(100293);
        C44532kz c44532kz = new C44532kz(t, C44532kz.m80825a());
        AppMethodBeat.m2505o(100293);
        return c44532kz;
    }

    public C44532kz() {
        this(null, null);
    }

    /* renamed from: a */
    public static <S> C44532kz<S> m80825a() {
        return f17477c;
    }

    /* renamed from: b */
    public final boolean mo70915b() {
        return this.f17478a == null;
    }

    /* renamed from: c */
    public final T mo70916c() {
        return this.f17478a;
    }

    /* renamed from: d */
    public final C44532kz<T> mo70917d() {
        return this.f17479b;
    }

    /* renamed from: b */
    public final C44532kz<T> mo70914b(T t) {
        AppMethodBeat.m2504i(100294);
        C44532kz c44532kz = new C44532kz(t, this);
        AppMethodBeat.m2505o(100294);
        return c44532kz;
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.m2504i(100295);
        C16305a c16305a = new C16305a(this);
        AppMethodBeat.m2505o(100295);
        return c16305a;
    }
}
