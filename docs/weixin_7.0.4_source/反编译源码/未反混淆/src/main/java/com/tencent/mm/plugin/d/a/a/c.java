package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class c {
    public String cbq = "";
    String jEJ = null;
    public e jEK = null;
    public double jEL = 0.0d;

    public final int hashCode() {
        AppMethodBeat.i(18326);
        if (this.jEK == null) {
            AppMethodBeat.o(18326);
            return 0;
        }
        int hashCode = Arrays.hashCode(this.jEK.jEO.jFp);
        AppMethodBeat.o(18326);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(18327);
        if (this.jEK == null || obj == null) {
            AppMethodBeat.o(18327);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(18327);
            return true;
        } else {
            boolean equals = Arrays.equals(((c) obj).jEK.jEO.jFp, this.jEK.jEO.jFp);
            AppMethodBeat.o(18327);
            return equals;
        }
    }
}
