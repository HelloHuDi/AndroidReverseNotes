package com.google.p114b.p115c.p116a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.google.b.c.a.c */
class C25572c implements C37295g {
    C25572c() {
    }

    /* renamed from: vu */
    public int mo3686vu() {
        return 1;
    }

    /* renamed from: a */
    public void mo3684a(C45064h c45064h) {
        AppMethodBeat.m2504i(57289);
        StringBuilder stringBuilder = new StringBuilder();
        while (c45064h.mo72834vy()) {
            char vx = c45064h.mo72833vx();
            c45064h.pos++;
            int a = mo3683a(vx, stringBuilder);
            int length = ((stringBuilder.length() / 3) << 1) + c45064h.bzL.length();
            c45064h.mo72830fF(length);
            length = c45064h.bzN.bzW - length;
            if (!c45064h.mo72834vy()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder.length() % 3 == 2 && (length < 2 || length > 2)) {
                    a = m40545a(c45064h, stringBuilder, stringBuilder2, a);
                }
                while (stringBuilder.length() % 3 == 1 && ((a <= 3 && length != 1) || a > 3)) {
                    a = m40545a(c45064h, stringBuilder, stringBuilder2, a);
                }
            } else if (stringBuilder.length() % 3 == 0) {
                a = C32081j.m52192b(c45064h.bzH, c45064h.pos, mo3686vu());
                if (a != mo3686vu()) {
                    c45064h.bzM = a;
                    break;
                }
            }
        }
        mo3685b(c45064h, stringBuilder);
        AppMethodBeat.m2505o(57289);
    }

    /* renamed from: a */
    private int m40545a(C45064h c45064h, StringBuilder stringBuilder, StringBuilder stringBuilder2, int i) {
        AppMethodBeat.m2504i(57290);
        int length = stringBuilder.length();
        stringBuilder.delete(length - i, length);
        c45064h.pos--;
        length = mo3683a(c45064h.mo72833vx(), stringBuilder2);
        c45064h.bzN = null;
        AppMethodBeat.m2505o(57290);
        return length;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo3685b(C45064h c45064h, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(57292);
        int length = stringBuilder.length() % 3;
        int length2 = ((stringBuilder.length() / 3) << 1) + c45064h.bzL.length();
        c45064h.mo72830fF(length2);
        length2 = c45064h.bzN.bzW - length2;
        if (length == 2) {
            stringBuilder.append(0);
            while (stringBuilder.length() >= 3) {
                C25572c.m40546a(c45064h, stringBuilder);
            }
            if (c45064h.mo72834vy()) {
                c45064h.mo72829d(254);
            }
        } else if (length2 == 1 && length == 1) {
            while (stringBuilder.length() >= 3) {
                C25572c.m40546a(c45064h, stringBuilder);
            }
            if (c45064h.mo72834vy()) {
                c45064h.mo72829d(254);
            }
            c45064h.pos--;
        } else if (length == 0) {
            while (stringBuilder.length() >= 3) {
                C25572c.m40546a(c45064h, stringBuilder);
            }
            if (length2 > 0 || c45064h.mo72834vy()) {
                c45064h.mo72829d(254);
            }
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected case. Please report!");
            AppMethodBeat.m2505o(57292);
            throw illegalStateException;
        }
        c45064h.bzM = 0;
        AppMethodBeat.m2505o(57292);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public int mo3683a(char c, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(57293);
        if (c == ' ') {
            stringBuilder.append(3);
            AppMethodBeat.m2505o(57293);
            return 1;
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
            AppMethodBeat.m2505o(57293);
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            stringBuilder.append((char) ((c - 65) + 14));
            AppMethodBeat.m2505o(57293);
            return 1;
        } else if (c >= 0 && c <= 31) {
            stringBuilder.append(0);
            stringBuilder.append(c);
            AppMethodBeat.m2505o(57293);
            return 2;
        } else if (c >= '!' && c <= IOUtils.DIR_SEPARATOR_UNIX) {
            stringBuilder.append(1);
            stringBuilder.append((char) (c - 33));
            AppMethodBeat.m2505o(57293);
            return 2;
        } else if (c >= ':' && c <= '@') {
            stringBuilder.append(1);
            stringBuilder.append((char) ((c - 58) + 15));
            AppMethodBeat.m2505o(57293);
            return 2;
        } else if (c >= '[' && c <= '_') {
            stringBuilder.append(1);
            stringBuilder.append((char) ((c - 91) + 22));
            AppMethodBeat.m2505o(57293);
            return 2;
        } else if (c >= '`' && c <= 127) {
            stringBuilder.append(2);
            stringBuilder.append((char) (c - 96));
            AppMethodBeat.m2505o(57293);
            return 2;
        } else if (c >= 128) {
            stringBuilder.append("\u0001\u001e");
            int a = mo3683a((char) (c - 128), stringBuilder) + 2;
            AppMethodBeat.m2505o(57293);
            return a;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal character: ".concat(String.valueOf(c)));
            AppMethodBeat.m2505o(57293);
            throw illegalArgumentException;
        }
    }

    /* renamed from: a */
    static void m40546a(C45064h c45064h, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(57291);
        char charAt = (char) (((((stringBuilder.charAt(0) * 1600) + (stringBuilder.charAt(1) * 40)) + stringBuilder.charAt(2)) + 1) % 256);
        c45064h.mo72828bi(new String(new char[]{(char) (r0 / 256), charAt}));
        stringBuilder.delete(0, 3);
        AppMethodBeat.m2505o(57291);
    }
}
