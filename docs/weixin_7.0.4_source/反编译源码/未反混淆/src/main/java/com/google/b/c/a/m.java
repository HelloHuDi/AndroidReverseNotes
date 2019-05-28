package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

final class m extends c {
    m() {
    }

    public final int vu() {
        return 2;
    }

    /* Access modifiers changed, original: final */
    public final int a(char c, StringBuilder stringBuilder) {
        AppMethodBeat.i(57171);
        if (c == ' ') {
            stringBuilder.append(3);
            AppMethodBeat.o(57171);
            return 1;
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
            AppMethodBeat.o(57171);
            return 1;
        } else if (c >= 'a' && c <= 'z') {
            stringBuilder.append((char) ((c - 97) + 14));
            AppMethodBeat.o(57171);
            return 1;
        } else if (c >= 0 && c <= 31) {
            stringBuilder.append(0);
            stringBuilder.append(c);
            AppMethodBeat.o(57171);
            return 2;
        } else if (c >= '!' && c <= IOUtils.DIR_SEPARATOR_UNIX) {
            stringBuilder.append(1);
            stringBuilder.append((char) (c - 33));
            AppMethodBeat.o(57171);
            return 2;
        } else if (c >= ':' && c <= '@') {
            stringBuilder.append(1);
            stringBuilder.append((char) ((c - 58) + 15));
            AppMethodBeat.o(57171);
            return 2;
        } else if (c >= '[' && c <= '_') {
            stringBuilder.append(1);
            stringBuilder.append((char) ((c - 91) + 22));
            AppMethodBeat.o(57171);
            return 2;
        } else if (c == '`') {
            stringBuilder.append(2);
            stringBuilder.append((char) (c - 96));
            AppMethodBeat.o(57171);
            return 2;
        } else if (c >= 'A' && c <= 'Z') {
            stringBuilder.append(2);
            stringBuilder.append((char) ((c - 65) + 1));
            AppMethodBeat.o(57171);
            return 2;
        } else if (c >= '{' && c <= 127) {
            stringBuilder.append(2);
            stringBuilder.append((char) ((c - 123) + 27));
            AppMethodBeat.o(57171);
            return 2;
        } else if (c >= 128) {
            stringBuilder.append("\u0001\u001e");
            int a = a((char) (c - 128), stringBuilder) + 2;
            AppMethodBeat.o(57171);
            return a;
        } else {
            j.h(c);
            AppMethodBeat.o(57171);
            return -1;
        }
    }
}
