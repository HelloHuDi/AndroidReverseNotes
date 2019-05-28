package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public final class a<T> {
    final Set<Class<? super T>> buT;
    final Set<f> buU;
    final d<T> buV;
    private final int zzad;

    @KeepForSdk
    public static class a<T> {
        private final Set<Class<? super T>> buT;
        private final Set<f> buU;
        private d<T> buV;
        public int zzad;

        private a(Class<T> cls, Class<? super T>... clsArr) {
            int i = 0;
            AppMethodBeat.i(10601);
            this.buT = new HashSet();
            this.buU = new HashSet();
            this.zzad = 0;
            r.zza(cls, "Null interface");
            this.buT.add(cls);
            int length = clsArr.length;
            while (i < length) {
                r.zza(clsArr[i], "Null interface");
                i++;
            }
            Collections.addAll(this.buT, clsArr);
            AppMethodBeat.o(10601);
        }

        /* synthetic */ a(Class cls, Class[] clsArr, byte b) {
            this(cls, clsArr);
        }

        @KeepForSdk
        public final a<T> a(d<T> dVar) {
            AppMethodBeat.i(10603);
            this.buV = (d) r.zza(dVar, "Null factory");
            AppMethodBeat.o(10603);
            return this;
        }

        @KeepForSdk
        public final a<T> uA() {
            AppMethodBeat.i(10604);
            r.c(this.buV != null, "Missing required property: factory.");
            a aVar = new a(new HashSet(this.buT), new HashSet(this.buU), this.zzad, this.buV, (byte) 0);
            AppMethodBeat.o(10604);
            return aVar;
        }

        @KeepForSdk
        public final a<T> a(f fVar) {
            AppMethodBeat.i(10602);
            r.zza(fVar, "Null dependency");
            String str = "Components are not allowed to depend on interfaces they themselves provide.";
            if ((!this.buT.contains(fVar.buW) ? 1 : null) == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
                AppMethodBeat.o(10602);
                throw illegalArgumentException;
            }
            this.buU.add(fVar);
            AppMethodBeat.o(10602);
            return this;
        }
    }

    private a(Set<Class<? super T>> set, Set<f> set2, int i, d<T> dVar) {
        AppMethodBeat.i(10605);
        this.buT = Collections.unmodifiableSet(set);
        this.buU = Collections.unmodifiableSet(set2);
        this.zzad = i;
        this.buV = dVar;
        AppMethodBeat.o(10605);
    }

    /* synthetic */ a(Set set, Set set2, int i, d dVar, byte b) {
        this(set, set2, i, dVar);
    }

    @KeepForSdk
    public static <T> a<T> a(Class<T> cls, T t) {
        AppMethodBeat.i(10608);
        a uA = y(cls).a(new j(t)).uA();
        AppMethodBeat.o(10608);
        return uA;
    }

    @KeepForSdk
    public static <T> a<T> y(Class<T> cls) {
        AppMethodBeat.i(10607);
        a aVar = new a(cls, new Class[0], (byte) 0);
        AppMethodBeat.o(10607);
        return aVar;
    }

    public final String toString() {
        AppMethodBeat.i(10606);
        String str = "Component<" + Arrays.toString(this.buT.toArray()) + ">{" + this.zzad + ", deps=" + Arrays.toString(this.buU.toArray()) + "}";
        AppMethodBeat.o(10606);
        return str;
    }

    public final boolean uy() {
        return this.zzad == 1;
    }

    public final boolean uz() {
        return this.zzad == 2;
    }
}
