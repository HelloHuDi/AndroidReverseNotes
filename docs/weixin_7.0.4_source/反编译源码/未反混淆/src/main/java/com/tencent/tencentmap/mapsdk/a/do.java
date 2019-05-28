package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class do {
    public final db a;
    public final db b;
    public final db c;
    public final db d;
    public final dc e;

    public do(db dbVar, db dbVar2, db dbVar3, db dbVar4, dc dcVar) {
        this.a = dbVar;
        this.b = dbVar2;
        this.c = dbVar3;
        this.d = dbVar4;
        this.e = dcVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101090);
        if (this == obj) {
            AppMethodBeat.o(101090);
            return true;
        } else if (obj instanceof do) {
            do doVar = (do) obj;
            if (this.a.equals(doVar.a) && this.b.equals(doVar.b) && this.c.equals(doVar.c) && this.d.equals(doVar.d) && this.e.equals(doVar.e)) {
                AppMethodBeat.o(101090);
                return true;
            }
            AppMethodBeat.o(101090);
            return false;
        } else {
            AppMethodBeat.o(101090);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(101091);
        String str = "nearLeft" + this.a + "nearRight" + this.b + "farLeft" + this.c + "farRight" + this.d + "latLngBounds" + this.e;
        AppMethodBeat.o(101091);
        return str;
    }
}
