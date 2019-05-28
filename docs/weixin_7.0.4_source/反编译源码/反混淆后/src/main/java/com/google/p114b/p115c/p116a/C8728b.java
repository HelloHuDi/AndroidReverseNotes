package com.google.p114b.p115c.p116a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.c.a.b */
final class C8728b implements C37295g {
    C8728b() {
    }

    /* renamed from: a */
    public final void mo3684a(C45064h c45064h) {
        int b;
        int i = 0;
        AppMethodBeat.m2504i(57319);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(0);
        while (c45064h.mo72834vy()) {
            stringBuilder.append(c45064h.mo72833vx());
            c45064h.pos++;
            b = C32081j.m52192b(c45064h.bzH, c45064h.pos, 5);
            if (b != 5) {
                c45064h.bzM = b;
                break;
            }
        }
        int length = stringBuilder.length() - 1;
        b = (c45064h.bzL.length() + length) + 1;
        c45064h.mo72830fF(b);
        b = c45064h.bzN.bzW - b > 0 ? 1 : 0;
        if (c45064h.mo72834vy() || b != 0) {
            if (length <= 249) {
                stringBuilder.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                stringBuilder.setCharAt(0, (char) ((length / 250) + 249));
                stringBuilder.insert(1, (char) (length % 250));
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                AppMethodBeat.m2505o(57319);
                throw illegalStateException;
            }
        }
        int length2 = stringBuilder.length();
        while (i < length2) {
            b = stringBuilder.charAt(i) + ((((c45064h.bzL.length() + 1) * 149) % 255) + 1);
            if (b > 255) {
                b -= 256;
            }
            c45064h.mo72829d((char) b);
            i++;
        }
        AppMethodBeat.m2505o(57319);
    }
}
