package com.google.p114b.p115c.p116a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.google.b.c.a.m */
final class C8731m extends C25572c {
    C8731m() {
    }

    /* renamed from: vu */
    public final int mo3686vu() {
        return 2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int mo3683a(char c, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(57171);
        if (c == ' ') {
            stringBuilder.append(3);
            AppMethodBeat.m2505o(57171);
            return 1;
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
            AppMethodBeat.m2505o(57171);
            return 1;
        } else if (c >= 'a' && c <= 'z') {
            stringBuilder.append((char) ((c - 97) + 14));
            AppMethodBeat.m2505o(57171);
            return 1;
        } else if (c >= 0 && c <= 31) {
            stringBuilder.append(0);
            stringBuilder.append(c);
            AppMethodBeat.m2505o(57171);
            return 2;
        } else if (c >= '!' && c <= IOUtils.DIR_SEPARATOR_UNIX) {
            stringBuilder.append(1);
            stringBuilder.append((char) (c - 33));
            AppMethodBeat.m2505o(57171);
            return 2;
        } else if (c >= ':' && c <= '@') {
            stringBuilder.append(1);
            stringBuilder.append((char) ((c - 58) + 15));
            AppMethodBeat.m2505o(57171);
            return 2;
        } else if (c >= '[' && c <= '_') {
            stringBuilder.append(1);
            stringBuilder.append((char) ((c - 91) + 22));
            AppMethodBeat.m2505o(57171);
            return 2;
        } else if (c == '`') {
            stringBuilder.append(2);
            stringBuilder.append((char) (c - 96));
            AppMethodBeat.m2505o(57171);
            return 2;
        } else if (c >= 'A' && c <= 'Z') {
            stringBuilder.append(2);
            stringBuilder.append((char) ((c - 65) + 1));
            AppMethodBeat.m2505o(57171);
            return 2;
        } else if (c >= '{' && c <= 127) {
            stringBuilder.append(2);
            stringBuilder.append((char) ((c - 123) + 27));
            AppMethodBeat.m2505o(57171);
            return 2;
        } else if (c >= 128) {
            stringBuilder.append("\u0001\u001e");
            int a = mo3683a((char) (c - 128), stringBuilder) + 2;
            AppMethodBeat.m2505o(57171);
            return a;
        } else {
            C32081j.m52196h(c);
            AppMethodBeat.m2505o(57171);
            return -1;
        }
    }
}
