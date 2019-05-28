package com.google.p114b.p115c.p116a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.c.a.a */
final class C45063a implements C37295g {
    C45063a() {
    }

    /* renamed from: a */
    public final void mo3684a(C45064h c45064h) {
        int i;
        AppMethodBeat.m2504i(57206);
        String str = c45064h.bzH;
        int i2 = c45064h.pos;
        int length = str.length();
        if (i2 < length) {
            char charAt = str.charAt(i2);
            i = 0;
            while (C32081j.isDigit(charAt) && i2 < length) {
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
            charAt2 = c45064h.bzH.charAt(c45064h.pos);
            char charAt3 = c45064h.bzH.charAt(c45064h.pos + 1);
            if (C32081j.isDigit(charAt2) && C32081j.isDigit(charAt3)) {
                c45064h.mo72829d((char) ((((charAt2 - 48) * 10) + (charAt3 - 48)) + 130));
                c45064h.pos += 2;
                AppMethodBeat.m2505o(57206);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("not digits: " + charAt2 + charAt3);
            AppMethodBeat.m2505o(57206);
            throw illegalArgumentException;
        }
        charAt2 = c45064h.mo72833vx();
        i = C32081j.m52192b(c45064h.bzH, c45064h.pos, 0);
        if (i != 0) {
            switch (i) {
                case 1:
                    c45064h.mo72829d(230);
                    c45064h.bzM = 1;
                    AppMethodBeat.m2505o(57206);
                    return;
                case 2:
                    c45064h.mo72829d(239);
                    c45064h.bzM = 2;
                    AppMethodBeat.m2505o(57206);
                    return;
                case 3:
                    c45064h.mo72829d(238);
                    c45064h.bzM = 3;
                    AppMethodBeat.m2505o(57206);
                    return;
                case 4:
                    c45064h.mo72829d(240);
                    c45064h.bzM = 4;
                    AppMethodBeat.m2505o(57206);
                    return;
                case 5:
                    c45064h.mo72829d(231);
                    c45064h.bzM = 5;
                    AppMethodBeat.m2505o(57206);
                    return;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Illegal mode: ".concat(String.valueOf(i)));
                    AppMethodBeat.m2505o(57206);
                    throw illegalStateException;
            }
        } else if (C32081j.m52193e(charAt2)) {
            c45064h.mo72829d(235);
            c45064h.mo72829d((char) ((charAt2 - 128) + 1));
            c45064h.pos++;
            AppMethodBeat.m2505o(57206);
        } else {
            c45064h.mo72829d((char) (charAt2 + 1));
            c45064h.pos++;
            AppMethodBeat.m2505o(57206);
        }
    }
}
