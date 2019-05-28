package com.bumptech.glide.h.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static final d<Object> aIi = new d<Object>() {
        public final void reset(Object obj) {
        }
    };

    static final class b<T> implements android.support.v4.f.k.a<T> {
        private final android.support.v4.f.k.a<T> aAr;
        private final a<T> aIj;
        private final d<T> aIk;

        b(android.support.v4.f.k.a<T> aVar, a<T> aVar2, d<T> dVar) {
            this.aAr = aVar;
            this.aIj = aVar2;
            this.aIk = dVar;
        }

        public final T aA() {
            AppMethodBeat.i(92618);
            T aA = this.aAr.aA();
            if (aA == null) {
                aA = this.aIj.mG();
                if (Log.isLoggable("FactoryPools", 2)) {
                    new StringBuilder("Created new ").append(aA.getClass());
                }
            }
            if (aA instanceof c) {
                ((c) aA).my().ay(false);
            }
            AppMethodBeat.o(92618);
            return aA;
        }

        public final boolean release(T t) {
            AppMethodBeat.i(92619);
            if (t instanceof c) {
                ((c) t).my().ay(true);
            }
            this.aIk.reset(t);
            boolean release = this.aAr.release(t);
            AppMethodBeat.o(92619);
            return release;
        }
    }

    public interface d<T> {
        void reset(T t);
    }

    public interface c {
        b my();
    }

    public interface a<T> {
        T mG();
    }

    static {
        AppMethodBeat.i(92625);
        AppMethodBeat.o(92625);
    }

    public static <T extends c> android.support.v4.f.k.a<T> a(a<T> aVar) {
        AppMethodBeat.i(92620);
        android.support.v4.f.k.a a = a(new android.support.v4.f.k.b(150), (a) aVar);
        AppMethodBeat.o(92620);
        return a;
    }

    public static <T extends c> android.support.v4.f.k.a<T> a(int i, a<T> aVar) {
        AppMethodBeat.i(92621);
        android.support.v4.f.k.a a = a(new android.support.v4.f.k.c(i), (a) aVar);
        AppMethodBeat.o(92621);
        return a;
    }

    private static <T> android.support.v4.f.k.a<T> a(android.support.v4.f.k.a<T> aVar, a<T> aVar2, d<T> dVar) {
        AppMethodBeat.i(92624);
        b bVar = new b(aVar, aVar2, dVar);
        AppMethodBeat.o(92624);
        return bVar;
    }

    public static <T> android.support.v4.f.k.a<List<T>> op() {
        AppMethodBeat.i(92622);
        android.support.v4.f.k.a a = a(new android.support.v4.f.k.c(20), new a<List<T>>() {
            public final /* synthetic */ Object mG() {
                AppMethodBeat.i(92616);
                ArrayList arrayList = new ArrayList();
                AppMethodBeat.o(92616);
                return arrayList;
            }
        }, new d<List<T>>() {
            public final /* synthetic */ void reset(Object obj) {
                AppMethodBeat.i(92617);
                ((List) obj).clear();
                AppMethodBeat.o(92617);
            }
        });
        AppMethodBeat.o(92622);
        return a;
    }

    private static <T extends c> android.support.v4.f.k.a<T> a(android.support.v4.f.k.a<T> aVar, a<T> aVar2) {
        AppMethodBeat.i(92623);
        android.support.v4.f.k.a a = a(aVar, aVar2, aIi);
        AppMethodBeat.o(92623);
        return a;
    }
}
