package com.tencent.liteav.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    public final String a;
    public final int b;
    public final int c;
    public final long d;

    public e(String str, int i, int i2, long j) {
        AppMethodBeat.i(67651);
        this.a = str;
        this.b = i;
        if (i2 < 600) {
            i2 = 600;
        }
        this.c = i2;
        this.d = j;
        AppMethodBeat.o(67651);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(67652);
        if (this == obj) {
            AppMethodBeat.o(67652);
            return true;
        } else if (obj == null || !(obj instanceof e)) {
            AppMethodBeat.o(67652);
            return false;
        } else {
            e eVar = (e) obj;
            if (this.a.equals(eVar.a) && this.b == eVar.b && this.c == eVar.c && this.d == eVar.d) {
                AppMethodBeat.o(67652);
                return true;
            }
            AppMethodBeat.o(67652);
            return false;
        }
    }

    public final boolean a() {
        return this.b == 5;
    }
}
