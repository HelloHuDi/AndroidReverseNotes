package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class kg<T, S extends kt> implements kv {
    private final T a;
    private final S b;

    public kg(T t, S s) {
        AppMethodBeat.i(100219);
        if (s == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(100219);
            throw illegalArgumentException;
        }
        this.a = t;
        this.b = s;
        AppMethodBeat.o(100219);
    }

    public static <T, S extends kt> kg<T, S> a(T t, S s) {
        AppMethodBeat.i(100220);
        kg kgVar = new kg(t, s);
        AppMethodBeat.o(100220);
        return kgVar;
    }

    public final T a() {
        return this.a;
    }

    public final S b() {
        return this.b;
    }

    public final String toString() {
        AppMethodBeat.i(100221);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Entry [value=");
        stringBuilder.append(this.a);
        stringBuilder.append(", geometry=");
        stringBuilder.append(this.b);
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(100221);
        return stringBuilder2;
    }

    public final int hashCode() {
        AppMethodBeat.i(100222);
        int hashCode = Arrays.hashCode(new Object[]{this.a, this.b});
        AppMethodBeat.o(100222);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100223);
        if (obj == null) {
            AppMethodBeat.o(100223);
            return false;
        } else if (obj instanceof kg) {
            boolean z;
            kg kgVar = (kg) obj;
            if (this.a == kgVar.a || (this.a != null && this.a.equals(kgVar.a))) {
                z = true;
            } else {
                z = false;
            }
            boolean z2;
            if (this.b == kgVar.b || (this.b != null && this.b.equals(kgVar.b))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && z2) {
                AppMethodBeat.o(100223);
                return true;
            }
            AppMethodBeat.o(100223);
            return false;
        } else {
            AppMethodBeat.o(100223);
            return false;
        }
    }
}
