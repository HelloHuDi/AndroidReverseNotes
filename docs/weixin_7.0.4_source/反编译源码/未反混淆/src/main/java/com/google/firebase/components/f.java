package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class f {
    final Class<?> buW;
    final int buX = 1;
    private final int buY = 0;

    private f(Class<?> cls) {
        AppMethodBeat.i(10610);
        this.buW = (Class) r.zza(cls, "Null dependency interface.");
        AppMethodBeat.o(10610);
    }

    @KeepForSdk
    public static f A(Class<?> cls) {
        AppMethodBeat.i(10611);
        f fVar = new f(cls);
        AppMethodBeat.o(10611);
        return fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.buW == fVar.buW && this.buX == fVar.buX && this.buY == fVar.buY;
    }

    public final int hashCode() {
        AppMethodBeat.i(10612);
        int hashCode = ((((this.buW.hashCode() ^ 1000003) * 1000003) ^ this.buX) * 1000003) ^ this.buY;
        AppMethodBeat.o(10612);
        return hashCode;
    }

    public final String toString() {
        boolean z = true;
        AppMethodBeat.i(10613);
        StringBuilder append = new StringBuilder("Dependency{interface=").append(this.buW).append(", required=").append(this.buX == 1).append(", direct=");
        if (this.buY != 0) {
            z = false;
        }
        String stringBuilder = append.append(z).append("}").toString();
        AppMethodBeat.o(10613);
        return stringBuilder;
    }

    public final boolean uB() {
        return this.buY == 0;
    }
}
