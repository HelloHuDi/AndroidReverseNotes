package com.google.p114b.p120f.p122b;

import com.google.p114b.p120f.p121a.C0902c;
import com.google.p114b.p120f.p121a.C32089a;
import com.google.p114b.p120f.p121a.C8737b;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.f.b.f */
public final class C45066f {
    C8737b bBQ;
    C32089a bBR;
    C0902c bBS;
    int bBT = -1;
    public C8738b bBU;

    public final String toString() {
        AppMethodBeat.m2504i(57296);
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
        AppMethodBeat.m2505o(57296);
        return stringBuilder2;
    }
}
