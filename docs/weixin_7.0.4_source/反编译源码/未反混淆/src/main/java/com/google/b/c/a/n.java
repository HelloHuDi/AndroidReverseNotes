package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class n extends c {
    n() {
    }

    public final int vu() {
        return 3;
    }

    public final void a(h hVar) {
        AppMethodBeat.i(57222);
        StringBuilder stringBuilder = new StringBuilder();
        while (hVar.vy()) {
            char vx = hVar.vx();
            hVar.pos++;
            a(vx, stringBuilder);
            if (stringBuilder.length() % 3 == 0) {
                c.a(hVar, stringBuilder);
                int b = j.b(hVar.bzH, hVar.pos, 3);
                if (b != 3) {
                    hVar.bzM = b;
                    break;
                }
            }
        }
        b(hVar, stringBuilder);
        AppMethodBeat.o(57222);
    }

    /* Access modifiers changed, original: final */
    public final int a(char c, StringBuilder stringBuilder) {
        AppMethodBeat.i(57223);
        if (c == 13) {
            stringBuilder.append(0);
        } else if (c == '*') {
            stringBuilder.append(1);
        } else if (c == '>') {
            stringBuilder.append(2);
        } else if (c == ' ') {
            stringBuilder.append(3);
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
        } else if (c < 'A' || c > 'Z') {
            j.h(c);
        } else {
            stringBuilder.append((char) ((c - 65) + 14));
        }
        AppMethodBeat.o(57223);
        return 1;
    }

    /* Access modifiers changed, original: final */
    public final void b(h hVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(57224);
        hVar.vB();
        int length = hVar.bzN.bzW - hVar.bzL.length();
        hVar.pos -= stringBuilder.length();
        if (hVar.vA() > 1 || length > 1 || hVar.vA() != length) {
            hVar.d(254);
        }
        if (hVar.bzM < 0) {
            hVar.bzM = 0;
        }
        AppMethodBeat.o(57224);
    }
}
