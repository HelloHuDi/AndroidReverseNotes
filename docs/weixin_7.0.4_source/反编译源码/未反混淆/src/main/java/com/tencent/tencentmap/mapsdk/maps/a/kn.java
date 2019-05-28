package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class kn<T, S extends kt> {
    private static final mf<kt, Boolean> d = new mf<kt, Boolean>() {
        public final Boolean a(kt ktVar) {
            return Boolean.TRUE;
        }
    };
    private final kj<T, S> a;
    private final kf b;
    private int c;

    public static class a {
        private Integer a;
        private Integer b;
        private kq c;
        private ko d;
        private boolean e;

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private a() {
            AppMethodBeat.i(100250);
            this.a = null;
            this.b = null;
            this.c = new kr();
            this.d = new kp();
            this.e = false;
            AppMethodBeat.o(100250);
        }

        public a a(int i) {
            AppMethodBeat.i(100251);
            this.b = Integer.valueOf(i);
            AppMethodBeat.o(100251);
            return this;
        }

        public a b(int i) {
            AppMethodBeat.i(100252);
            this.a = Integer.valueOf(i);
            AppMethodBeat.o(100252);
            return this;
        }

        public <T, S extends kt> kn<T, S> a() {
            AppMethodBeat.i(100253);
            if (this.a == null) {
                this.a = Integer.valueOf(4);
            }
            if (this.b == null) {
                this.b = Integer.valueOf((int) Math.round(((double) this.a.intValue()) * 0.4d));
            }
            kn knVar = new kn(new kf(this.b.intValue(), this.a.intValue(), this.d, this.c), null);
            AppMethodBeat.o(100253);
            return knVar;
        }
    }

    /* synthetic */ kn(kf kfVar, AnonymousClass1 anonymousClass1) {
        this(kfVar);
    }

    private kn(kj<T, S> kjVar, int i, kf kfVar) {
        this.a = kjVar;
        this.c = i;
        this.b = kfVar;
    }

    private kn(kf kfVar) {
        this(null, 0, kfVar);
    }

    public static a a(int i) {
        AppMethodBeat.i(100254);
        a a = new a().a(i);
        AppMethodBeat.o(100254);
        return a;
    }

    public final kn<T, S> a(kg<? extends T, ? extends S> kgVar) {
        AppMethodBeat.i(100255);
        if (this.a != null) {
            kj kjVar;
            List a = this.a.a(kgVar);
            if (a.size() == 1) {
                kjVar = (kj) a.get(0);
            } else {
                kjVar = new kl(a, this.b);
            }
            kn<T, S> knVar = new kn(kjVar, this.c + 1, this.b);
            AppMethodBeat.o(100255);
            return knVar;
        }
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new kg[]{kgVar});
        kn<T, S> knVar2 = new kn(new ki(arrayList, this.b), this.c + 1, this.b);
        AppMethodBeat.o(100255);
        return knVar2;
    }

    public final kn<T, S> a(T t, S s) {
        AppMethodBeat.i(100256);
        kn a = a(kg.a(t, s));
        AppMethodBeat.o(100256);
        return a;
    }

    /* Access modifiers changed, original: final */
    public final lv<kg<T, S>> a(mf<? super kt, Boolean> mfVar) {
        AppMethodBeat.i(100257);
        if (this.a != null) {
            lv a = lv.a(new km(this.a, mfVar));
            AppMethodBeat.o(100257);
            return a;
        }
        lv<kg<T, S>> a2 = lv.a();
        AppMethodBeat.o(100257);
        return a2;
    }

    public static mf<kt, Boolean> a(final ky kyVar) {
        AppMethodBeat.i(100258);
        AnonymousClass1 anonymousClass1 = new mf<kt, Boolean>() {
            public final Boolean a(kt ktVar) {
                AppMethodBeat.i(100247);
                Boolean valueOf = Boolean.valueOf(ktVar.a(kyVar));
                AppMethodBeat.o(100247);
                return valueOf;
            }
        };
        AppMethodBeat.o(100258);
        return anonymousClass1;
    }

    static {
        AppMethodBeat.i(100260);
        AppMethodBeat.o(100260);
    }

    public final lv<kg<T, S>> b(ky kyVar) {
        AppMethodBeat.i(100259);
        lv a = a(a(kyVar));
        AppMethodBeat.o(100259);
        return a;
    }
}
