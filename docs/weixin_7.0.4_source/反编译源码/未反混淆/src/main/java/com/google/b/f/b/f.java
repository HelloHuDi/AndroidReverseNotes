package com.google.b.f.b;

import com.google.b.f.a.a;
import com.google.b.f.a.b;
import com.google.b.f.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    b bBQ;
    a bBR;
    c bBS;
    int bBT = -1;
    public b bBU;

    public final String toString() {
        AppMethodBeat.i(57296);
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.bBQ);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.bBR);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.bBS);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.bBT);
        if (this.bBU == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.bBU);
        }
        stringBuilder.append(">>\n");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(57296);
        return stringBuilder2;
    }
}
