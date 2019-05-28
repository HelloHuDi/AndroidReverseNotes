package com.google.p114b.p115c.p116a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.c.a.f */
final class C32080f implements C37295g {
    C32080f() {
    }

    /* renamed from: a */
    public final void mo3684a(C45064h c45064h) {
        int i = 1;
        AppMethodBeat.m2504i(57294);
        StringBuilder stringBuilder = new StringBuilder();
        while (c45064h.mo72834vy()) {
            char vx = c45064h.mo72833vx();
            if (vx >= ' ' && vx <= '?') {
                stringBuilder.append(vx);
            } else if (vx < '@' || vx > '^') {
                C32081j.m52196h(vx);
            } else {
                stringBuilder.append((char) (vx - 64));
            }
            c45064h.pos++;
            if (stringBuilder.length() >= 4) {
                c45064h.mo72828bi(C32080f.m52188q(stringBuilder));
                stringBuilder.delete(0, 4);
                if (C32081j.m52192b(c45064h.bzH, c45064h.pos, 4) != 4) {
                    c45064h.bzM = 0;
                    break;
                }
            }
        }
        stringBuilder.append(31);
        try {
            int length = stringBuilder.length();
            if (length != 0) {
                if (length == 1) {
                    c45064h.mo72832vB();
                    int length2 = c45064h.bzN.bzW - c45064h.bzL.length();
                    if (c45064h.mo72831vA() == 0 && length2 <= 2) {
                        c45064h.bzM = 0;
                        AppMethodBeat.m2505o(57294);
                        return;
                    }
                }
                if (length > 4) {
                    IllegalStateException illegalStateException = new IllegalStateException("Count must not exceed 4");
                    AppMethodBeat.m2505o(57294);
                    throw illegalStateException;
                }
                length--;
                String q = C32080f.m52188q(stringBuilder);
                if ((!c45064h.mo72834vy() ? 1 : 0) == 0 || length > 2) {
                    i = 0;
                }
                if (length <= 2) {
                    c45064h.mo72830fF(c45064h.bzL.length() + length);
                    if (c45064h.bzN.bzW - c45064h.bzL.length() >= 3) {
                        c45064h.mo72830fF(c45064h.bzL.length() + q.length());
                        i = 0;
                    }
                }
                if (i != 0) {
                    c45064h.bzN = null;
                    c45064h.pos -= length;
                } else {
                    c45064h.mo72828bi(q);
                }
                c45064h.bzM = 0;
                AppMethodBeat.m2505o(57294);
            }
        } finally {
            c45064h.bzM = 0;
            AppMethodBeat.m2505o(57294);
        }
    }

    /* renamed from: q */
    private static String m52188q(CharSequence charSequence) {
        int i = 0;
        AppMethodBeat.m2504i(57295);
        int length = charSequence.length() + 0;
        if (length == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("StringBuilder must not be empty");
            AppMethodBeat.m2505o(57295);
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
        AppMethodBeat.m2505o(57295);
        return stringBuilder2;
    }
}
