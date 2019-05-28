package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

public final class ke {
    public static final Comparator<kw<?>> a = a(kh.a);
    public static final Comparator<kw<?>> b = new Comparator<kw<?>>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(100208);
            int a = a((kw) obj, (kw) obj2);
            AppMethodBeat.o(100208);
            return a;
        }

        public final int a(kw<?> kwVar, kw<?> kwVar2) {
            AppMethodBeat.i(100207);
            int compareTo = Float.valueOf(kwVar.c()).compareTo(Float.valueOf(kwVar2.c()));
            AppMethodBeat.o(100207);
            return compareTo;
        }
    };

    static {
        AppMethodBeat.i(100217);
        AppMethodBeat.o(100217);
    }

    public static <T extends kv> Comparator<kv> a(ky kyVar) {
        AppMethodBeat.i(100213);
        Comparator a = a(kh.a(kyVar));
        AppMethodBeat.o(100213);
        return a;
    }

    public static Comparator<kv> b(final ky kyVar) {
        AppMethodBeat.i(100214);
        AnonymousClass2 anonymousClass2 = new Comparator<kv>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(100210);
                int a = a((kv) obj, (kv) obj2);
                AppMethodBeat.o(100210);
                return a;
            }

            public final int a(kv kvVar, kv kvVar2) {
                AppMethodBeat.i(100209);
                int compareTo = Float.valueOf(kvVar.b().a().b(kyVar).g()).compareTo(Float.valueOf(kvVar2.b().a().b(kyVar).g()));
                AppMethodBeat.o(100209);
                return compareTo;
            }
        };
        AppMethodBeat.o(100214);
        return anonymousClass2;
    }

    public static <R, T extends Comparable<T>> Comparator<R> a(final mf<R, T> mfVar) {
        AppMethodBeat.i(100215);
        AnonymousClass3 anonymousClass3 = new Comparator<R>() {
            public final int compare(R r, R r2) {
                AppMethodBeat.i(100211);
                int compareTo = ((Comparable) mfVar.a(r)).compareTo(mfVar.a(r2));
                AppMethodBeat.o(100211);
                return compareTo;
            }
        };
        AppMethodBeat.o(100215);
        return anonymousClass3;
    }

    public static <T> Comparator<T> a(final Comparator<T>... comparatorArr) {
        AppMethodBeat.i(100216);
        AnonymousClass4 anonymousClass4 = new Comparator<T>() {
            public final int compare(T t, T t2) {
                AppMethodBeat.i(100212);
                for (Comparator compare : comparatorArr) {
                    int compare2 = compare.compare(t, t2);
                    if (compare2 != 0) {
                        AppMethodBeat.o(100212);
                        return compare2;
                    }
                }
                AppMethodBeat.o(100212);
                return 0;
            }
        };
        AppMethodBeat.o(100216);
        return anonymousClass4;
    }
}
