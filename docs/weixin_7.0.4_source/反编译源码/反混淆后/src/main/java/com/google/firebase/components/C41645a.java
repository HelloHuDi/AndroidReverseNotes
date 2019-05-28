package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
/* renamed from: com.google.firebase.components.a */
public final class C41645a<T> {
    final Set<Class<? super T>> buT;
    final Set<C25581f> buU;
    final C41647d<T> buV;
    private final int zzad;

    @KeepForSdk
    /* renamed from: com.google.firebase.components.a$a */
    public static class C8742a<T> {
        private final Set<Class<? super T>> buT;
        private final Set<C25581f> buU;
        private C41647d<T> buV;
        public int zzad;

        private C8742a(Class<T> cls, Class<? super T>... clsArr) {
            int i = 0;
            AppMethodBeat.m2504i(10601);
            this.buT = new HashSet();
            this.buU = new HashSet();
            this.zzad = 0;
            C32092r.zza(cls, "Null interface");
            this.buT.add(cls);
            int length = clsArr.length;
            while (i < length) {
                C32092r.zza(clsArr[i], "Null interface");
                i++;
            }
            Collections.addAll(this.buT, clsArr);
            AppMethodBeat.m2505o(10601);
        }

        /* synthetic */ C8742a(Class cls, Class[] clsArr, byte b) {
            this(cls, clsArr);
        }

        @KeepForSdk
        /* renamed from: a */
        public final C8742a<T> mo19758a(C41647d<T> c41647d) {
            AppMethodBeat.m2504i(10603);
            this.buV = (C41647d) C32092r.zza(c41647d, "Null factory");
            AppMethodBeat.m2505o(10603);
            return this;
        }

        @KeepForSdk
        /* renamed from: uA */
        public final C41645a<T> mo19760uA() {
            AppMethodBeat.m2504i(10604);
            C32092r.m52219c(this.buV != null, "Missing required property: factory.");
            C41645a c41645a = new C41645a(new HashSet(this.buT), new HashSet(this.buU), this.zzad, this.buV, (byte) 0);
            AppMethodBeat.m2505o(10604);
            return c41645a;
        }

        @KeepForSdk
        /* renamed from: a */
        public final C8742a<T> mo19759a(C25581f c25581f) {
            AppMethodBeat.m2504i(10602);
            C32092r.zza(c25581f, "Null dependency");
            String str = "Components are not allowed to depend on interfaces they themselves provide.";
            if ((!this.buT.contains(c25581f.buW) ? 1 : null) == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
                AppMethodBeat.m2505o(10602);
                throw illegalArgumentException;
            }
            this.buU.add(c25581f);
            AppMethodBeat.m2505o(10602);
            return this;
        }
    }

    private C41645a(Set<Class<? super T>> set, Set<C25581f> set2, int i, C41647d<T> c41647d) {
        AppMethodBeat.m2504i(10605);
        this.buT = Collections.unmodifiableSet(set);
        this.buU = Collections.unmodifiableSet(set2);
        this.zzad = i;
        this.buV = c41647d;
        AppMethodBeat.m2505o(10605);
    }

    /* synthetic */ C41645a(Set set, Set set2, int i, C41647d c41647d, byte b) {
        this(set, set2, i, c41647d);
    }

    @KeepForSdk
    /* renamed from: a */
    public static <T> C41645a<T> m73014a(Class<T> cls, T t) {
        AppMethodBeat.m2504i(10608);
        C41645a uA = C41645a.m73015y(cls).mo19758a(new C44651j(t)).mo19760uA();
        AppMethodBeat.m2505o(10608);
        return uA;
    }

    @KeepForSdk
    /* renamed from: y */
    public static <T> C8742a<T> m73015y(Class<T> cls) {
        AppMethodBeat.m2504i(10607);
        C8742a c8742a = new C8742a(cls, new Class[0], (byte) 0);
        AppMethodBeat.m2505o(10607);
        return c8742a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(10606);
        String str = "Component<" + Arrays.toString(this.buT.toArray()) + ">{" + this.zzad + ", deps=" + Arrays.toString(this.buU.toArray()) + "}";
        AppMethodBeat.m2505o(10606);
        return str;
    }

    /* renamed from: uy */
    public final boolean mo67048uy() {
        return this.zzad == 1;
    }

    /* renamed from: uz */
    public final boolean mo67049uz() {
        return this.zzad == 2;
    }
}
