package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kg */
public final class C16298kg<T, S extends C36529kt> implements C31074kv {
    /* renamed from: a */
    private final T f3466a;
    /* renamed from: b */
    private final S f3467b;

    public C16298kg(T t, S s) {
        AppMethodBeat.m2504i(100219);
        if (s == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(100219);
            throw illegalArgumentException;
        }
        this.f3466a = t;
        this.f3467b = s;
        AppMethodBeat.m2505o(100219);
    }

    /* renamed from: a */
    public static <T, S extends C36529kt> C16298kg<T, S> m25106a(T t, S s) {
        AppMethodBeat.m2504i(100220);
        C16298kg c16298kg = new C16298kg(t, s);
        AppMethodBeat.m2505o(100220);
        return c16298kg;
    }

    /* renamed from: a */
    public final T mo29552a() {
        return this.f3466a;
    }

    /* renamed from: b */
    public final S mo29553b() {
        return this.f3467b;
    }

    public final String toString() {
        AppMethodBeat.m2504i(100221);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Entry [value=");
        stringBuilder.append(this.f3466a);
        stringBuilder.append(", geometry=");
        stringBuilder.append(this.f3467b);
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(100221);
        return stringBuilder2;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(100222);
        int hashCode = Arrays.hashCode(new Object[]{this.f3466a, this.f3467b});
        AppMethodBeat.m2505o(100222);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(100223);
        if (obj == null) {
            AppMethodBeat.m2505o(100223);
            return false;
        } else if (obj instanceof C16298kg) {
            boolean z;
            C16298kg c16298kg = (C16298kg) obj;
            if (this.f3466a == c16298kg.f3466a || (this.f3466a != null && this.f3466a.equals(c16298kg.f3466a))) {
                z = true;
            } else {
                z = false;
            }
            boolean z2;
            if (this.f3467b == c16298kg.f3467b || (this.f3467b != null && this.f3467b.equals(c16298kg.f3467b))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && z2) {
                AppMethodBeat.m2505o(100223);
                return true;
            }
            AppMethodBeat.m2505o(100223);
            return false;
        } else {
            AppMethodBeat.m2505o(100223);
            return false;
        }
    }
}
