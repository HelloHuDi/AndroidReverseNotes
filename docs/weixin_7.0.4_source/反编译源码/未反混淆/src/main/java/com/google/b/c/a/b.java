package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b implements g {
    b() {
    }

    public final void a(h hVar) {
        int b;
        int i = 0;
        AppMethodBeat.i(57319);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(0);
        while (hVar.vy()) {
            stringBuilder.append(hVar.vx());
            hVar.pos++;
            b = j.b(hVar.bzH, hVar.pos, 5);
            if (b != 5) {
                hVar.bzM = b;
                break;
            }
        }
        int length = stringBuilder.length() - 1;
        b = (hVar.bzL.length() + length) + 1;
        hVar.fF(b);
        b = hVar.bzN.bzW - b > 0 ? 1 : 0;
        if (hVar.vy() || b != 0) {
            if (length <= 249) {
                stringBuilder.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                stringBuilder.setCharAt(0, (char) ((length / 250) + 249));
                stringBuilder.insert(1, (char) (length % 250));
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                AppMethodBeat.o(57319);
                throw illegalStateException;
            }
        }
        int length2 = stringBuilder.length();
        while (i < length2) {
            b = stringBuilder.charAt(i) + ((((hVar.bzL.length() + 1) * 149) % 255) + 1);
            if (b > 255) {
                b -= 256;
            }
            hVar.d((char) b);
            i++;
        }
        AppMethodBeat.o(57319);
    }
}
