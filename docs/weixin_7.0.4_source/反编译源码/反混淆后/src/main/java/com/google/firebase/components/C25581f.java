package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
/* renamed from: com.google.firebase.components.f */
public final class C25581f {
    final Class<?> buW;
    final int buX = 1;
    private final int buY = 0;

    private C25581f(Class<?> cls) {
        AppMethodBeat.m2504i(10610);
        this.buW = (Class) C32092r.zza(cls, "Null dependency interface.");
        AppMethodBeat.m2505o(10610);
    }

    @KeepForSdk
    /* renamed from: A */
    public static C25581f m40563A(Class<?> cls) {
        AppMethodBeat.m2504i(10611);
        C25581f c25581f = new C25581f(cls);
        AppMethodBeat.m2505o(10611);
        return c25581f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C25581f)) {
            return false;
        }
        C25581f c25581f = (C25581f) obj;
        return this.buW == c25581f.buW && this.buX == c25581f.buX && this.buY == c25581f.buY;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(10612);
        int hashCode = ((((this.buW.hashCode() ^ 1000003) * 1000003) ^ this.buX) * 1000003) ^ this.buY;
        AppMethodBeat.m2505o(10612);
        return hashCode;
    }

    public final String toString() {
        boolean z = true;
        AppMethodBeat.m2504i(10613);
        StringBuilder append = new StringBuilder("Dependency{interface=").append(this.buW).append(", required=").append(this.buX == 1).append(", direct=");
        if (this.buY != 0) {
            z = false;
        }
        String stringBuilder = append.append(z).append("}").toString();
        AppMethodBeat.m2505o(10613);
        return stringBuilder;
    }

    /* renamed from: uB */
    public final boolean mo43233uB() {
        return this.buY == 0;
    }
}
