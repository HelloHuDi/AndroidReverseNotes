package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f implements g {
    f() {
    }

    public final void a(h hVar) {
        int i = 1;
        AppMethodBeat.i(57294);
        StringBuilder stringBuilder = new StringBuilder();
        while (hVar.vy()) {
            char vx = hVar.vx();
            if (vx >= ' ' && vx <= '?') {
                stringBuilder.append(vx);
            } else if (vx < '@' || vx > '^') {
                j.h(vx);
            } else {
                stringBuilder.append((char) (vx - 64));
            }
            hVar.pos++;
            if (stringBuilder.length() >= 4) {
                hVar.bi(q(stringBuilder));
                stringBuilder.delete(0, 4);
                if (j.b(hVar.bzH, hVar.pos, 4) != 4) {
                    hVar.bzM = 0;
                    break;
                }
            }
        }
        stringBuilder.append(31);
        try {
            int length = stringBuilder.length();
            if (length != 0) {
                if (length == 1) {
                    hVar.vB();
                    int length2 = hVar.bzN.bzW - hVar.bzL.length();
                    if (hVar.vA() == 0 && length2 <= 2) {
                        hVar.bzM = 0;
                        AppMethodBeat.o(57294);
                        return;
                    }
                }
                if (length > 4) {
                    IllegalStateException illegalStateException = new IllegalStateException("Count must not exceed 4");
                    AppMethodBeat.o(57294);
                    throw illegalStateException;
                }
                length--;
                String q = q(stringBuilder);
                if ((!hVar.vy() ? 1 : 0) == 0 || length > 2) {
                    i = 0;
                }
                if (length <= 2) {
                    hVar.fF(hVar.bzL.length() + length);
                    if (hVar.bzN.bzW - hVar.bzL.length() >= 3) {
                        hVar.fF(hVar.bzL.length() + q.length());
                        i = 0;
                    }
                }
                if (i != 0) {
                    hVar.bzN = null;
                    hVar.pos -= length;
                } else {
                    hVar.bi(q);
                }
                hVar.bzM = 0;
                AppMethodBeat.o(57294);
            }
        } finally {
            hVar.bzM = 0;
            AppMethodBeat.o(57294);
        }
    }

    private static String q(CharSequence charSequence) {
        int i = 0;
        AppMethodBeat.i(57295);
        int length = charSequence.length() + 0;
        if (length == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("StringBuilder must not be empty");
            AppMethodBeat.o(57295);
            throw illegalStateException;
        }
        int charAt;
        char charAt2 = charSequence.charAt(0);
        int charAt3 = length >= 2 ? charSequence.charAt(1) : 0;
        if (length >= 3) {
            charAt = charSequence.charAt(2);
        } else {
            charAt = 0;
        }
        if (length >= 4) {
            i = charSequence.charAt(3);
        }
        i += (charAt << 6) + ((charAt3 << 12) + (charAt2 << 18));
        char c = (char) ((i >> 16) & 255);
        char c2 = (char) ((i >> 8) & 255);
        char c3 = (char) (i & 255);
        StringBuilder stringBuilder = new StringBuilder(3);
        stringBuilder.append(c);
        if (length >= 2) {
            stringBuilder.append(c2);
        }
        if (length >= 3) {
            stringBuilder.append(c3);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(57295);
        return stringBuilder2;
    }
}
