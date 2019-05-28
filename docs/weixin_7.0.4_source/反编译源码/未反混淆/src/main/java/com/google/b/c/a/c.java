package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

class c implements g {
    c() {
    }

    public int vu() {
        return 1;
    }

    public void a(h hVar) {
        AppMethodBeat.i(57289);
        StringBuilder stringBuilder = new StringBuilder();
        while (hVar.vy()) {
            char vx = hVar.vx();
            hVar.pos++;
            int a = a(vx, stringBuilder);
            int length = ((stringBuilder.length() / 3) << 1) + hVar.bzL.length();
            hVar.fF(length);
            length = hVar.bzN.bzW - length;
            if (!hVar.vy()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder.length() % 3 == 2 && (length < 2 || length > 2)) {
                    a = a(hVar, stringBuilder, stringBuilder2, a);
                }
                while (stringBuilder.length() % 3 == 1 && ((a <= 3 && length != 1) || a > 3)) {
                    a = a(hVar, stringBuilder, stringBuilder2, a);
                }
            } else if (stringBuilder.length() % 3 == 0) {
                a = j.b(hVar.bzH, hVar.pos, vu());
                if (a != vu()) {
                    hVar.bzM = a;
                    break;
                }
            }
        }
        b(hVar, stringBuilder);
        AppMethodBeat.o(57289);
    }

    private int a(h hVar, StringBuilder stringBuilder, StringBuilder stringBuilder2, int i) {
        AppMethodBeat.i(57290);
        int length = stringBuilder.length();
        stringBuilder.delete(length - i, length);
        hVar.pos--;
        length = a(hVar.vx(), stringBuilder2);
        hVar.bzN = null;
        AppMethodBeat.o(57290);
        return length;
    }

    /* Access modifiers changed, original: 0000 */
    public void b(h hVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(57292);
        int length = stringBuilder.length() % 3;
        int length2 = ((stringBuilder.length() / 3) << 1) + hVar.bzL.length();
        hVar.fF(length2);
        length2 = hVar.bzN.bzW - length2;
        if (length == 2) {
            stringBuilder.append(0);
            while (stringBuilder.length() >= 3) {
                a(hVar, stringBuilder);
            }
            if (hVar.vy()) {
                hVar.d(254);
            }
        } else if (length2 == 1 && length == 1) {
            while (stringBuilder.length() >= 3) {
                a(hVar, stringBuilder);
            }
            if (hVar.vy()) {
                hVar.d(254);
            }
            hVar.pos--;
        } else if (length == 0) {
            while (stringBuilder.length() >= 3) {
                a(hVar, stringBuilder);
            }
            if (length2 > 0 || hVar.vy()) {
                hVar.d(254);
            }
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected case. Please report!");
            AppMethodBeat.o(57292);
            throw illegalStateException;
        }
        hVar.bzM = 0;
        AppMethodBeat.o(57292);
    }

    /* Access modifiers changed, original: 0000 */
    public int a(char c, StringBuilder stringBuilder) {
        AppMethodBeat.i(57293);
        if (c == ' ') {
            stringBuilder.append(3);
            AppMethodBeat.o(57293);
            return 1;
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
            AppMethodBeat.o(57293);
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            stringBuilder.append((char) ((c - 65) + 14));
            AppMethodBeat.o(57293);
            return 1;
        } else if (c >= 0 && c <= 31) {
            stringBuilder.append(0);
            stringBuilder.append(c);
            AppMethodBeat.o(57293);
            return 2;
        } else if (c >= '!' && c <= IOUtils.DIR_SEPARATOR_UNIX) {
            stringBuilder.append(1);
            stringBuilder.append((char) (c - 33));
            AppMethodBeat.o(57293);
            return 2;
        } else if (c >= ':' && c <= '@') {
            stringBuilder.append(1);
            stringBuilder.append((char) ((c - 58) + 15));
            AppMethodBeat.o(57293);
            return 2;
        } else if (c >= '[' && c <= '_') {
            stringBuilder.append(1);
            stringBuilder.append((char) ((c - 91) + 22));
            AppMethodBeat.o(57293);
            return 2;
        } else if (c >= '`' && c <= 127) {
            stringBuilder.append(2);
            stringBuilder.append((char) (c - 96));
            AppMethodBeat.o(57293);
            return 2;
        } else if (c >= 128) {
            stringBuilder.append("\u0001\u001e");
            int a = a((char) (c - 128), stringBuilder) + 2;
            AppMethodBeat.o(57293);
            return a;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal character: ".concat(String.valueOf(c)));
            AppMethodBeat.o(57293);
            throw illegalArgumentException;
        }
    }

    static void a(h hVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(57291);
        char charAt = (char) (((((stringBuilder.charAt(0) * 1600) + (stringBuilder.charAt(1) * 40)) + stringBuilder.charAt(2)) + 1) % 256);
        hVar.bi(new String(new char[]{(char) (r0 / 256), charAt}));
        stringBuilder.delete(0, 3);
        AppMethodBeat.o(57291);
    }
}
