package com.google.p114b.p115c.p116a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.c.a.n */
final class C0896n extends C25572c {
    C0896n() {
    }

    /* renamed from: vu */
    public final int mo3686vu() {
        return 3;
    }

    /* renamed from: a */
    public final void mo3684a(C45064h c45064h) {
        AppMethodBeat.m2504i(57222);
        StringBuilder stringBuilder = new StringBuilder();
        while (c45064h.mo72834vy()) {
            char vx = c45064h.mo72833vx();
            c45064h.pos++;
            mo3683a(vx, stringBuilder);
            if (stringBuilder.length() % 3 == 0) {
                C25572c.m40546a(c45064h, stringBuilder);
                int b = C32081j.m52192b(c45064h.bzH, c45064h.pos, 3);
                if (b != 3) {
                    c45064h.bzM = b;
                    break;
                }
            }
        }
        mo3685b(c45064h, stringBuilder);
        AppMethodBeat.m2505o(57222);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int mo3683a(char c, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(57223);
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
            C32081j.m52196h(c);
        } else {
            stringBuilder.append((char) ((c - 65) + 14));
        }
        AppMethodBeat.m2505o(57223);
        return 1;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo3685b(C45064h c45064h, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(57224);
        c45064h.mo72832vB();
        int length = c45064h.bzN.bzW - c45064h.bzL.length();
        c45064h.pos -= stringBuilder.length();
        if (c45064h.mo72831vA() > 1 || length > 1 || c45064h.mo72831vA() != length) {
            c45064h.mo72829d(254);
        }
        if (c45064h.bzM < 0) {
            c45064h.bzM = 0;
        }
        AppMethodBeat.m2505o(57224);
    }
}
