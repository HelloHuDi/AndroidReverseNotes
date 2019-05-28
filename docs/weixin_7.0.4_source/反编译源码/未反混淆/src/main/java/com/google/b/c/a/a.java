package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a implements g {
    a() {
    }

    public final void a(h hVar) {
        int i;
        AppMethodBeat.i(57206);
        String str = hVar.bzH;
        int i2 = hVar.pos;
        int length = str.length();
        if (i2 < length) {
            char charAt = str.charAt(i2);
            i = 0;
            while (j.isDigit(charAt) && i2 < length) {
                i++;
                i2++;
                if (i2 < length) {
                    charAt = str.charAt(i2);
                }
            }
        } else {
            i = 0;
        }
        char charAt2;
        if (i >= 2) {
            charAt2 = hVar.bzH.charAt(hVar.pos);
            char charAt3 = hVar.bzH.charAt(hVar.pos + 1);
            if (j.isDigit(charAt2) && j.isDigit(charAt3)) {
                hVar.d((char) ((((charAt2 - 48) * 10) + (charAt3 - 48)) + 130));
                hVar.pos += 2;
                AppMethodBeat.o(57206);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("not digits: " + charAt2 + charAt3);
            AppMethodBeat.o(57206);
            throw illegalArgumentException;
        }
        charAt2 = hVar.vx();
        i = j.b(hVar.bzH, hVar.pos, 0);
        if (i != 0) {
            switch (i) {
                case 1:
                    hVar.d(230);
                    hVar.bzM = 1;
                    AppMethodBeat.o(57206);
                    return;
                case 2:
                    hVar.d(239);
                    hVar.bzM = 2;
                    AppMethodBeat.o(57206);
                    return;
                case 3:
                    hVar.d(238);
                    hVar.bzM = 3;
                    AppMethodBeat.o(57206);
                    return;
                case 4:
                    hVar.d(240);
                    hVar.bzM = 4;
                    AppMethodBeat.o(57206);
                    return;
                case 5:
                    hVar.d(231);
                    hVar.bzM = 5;
                    AppMethodBeat.o(57206);
                    return;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Illegal mode: ".concat(String.valueOf(i)));
                    AppMethodBeat.o(57206);
                    throw illegalStateException;
            }
        } else if (j.e(charAt2)) {
            hVar.d(235);
            hVar.d((char) ((charAt2 - 128) + 1));
            hVar.pos++;
            AppMethodBeat.o(57206);
        } else {
            hVar.d((char) (charAt2 + 1));
            hVar.pos++;
            AppMethodBeat.o(57206);
        }
    }
}
