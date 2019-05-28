package com.google.p114b.p115c.p116a;

import com.google.p114b.C45062b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

/* renamed from: com.google.b.c.a.h */
final class C45064h {
    final String bzH;
    C0895l bzI;
    C45062b bzJ;
    C45062b bzK;
    final StringBuilder bzL;
    int bzM;
    C0894k bzN;
    int bzO;
    int pos;

    C45064h(String str) {
        AppMethodBeat.m2504i(57207);
        byte[] bytes = str.getBytes(Charset.forName("ISO-8859-1"));
        StringBuilder stringBuilder = new StringBuilder(bytes.length);
        int i = 0;
        int length = bytes.length;
        while (i < length) {
            char c = (char) (bytes[i] & 255);
            if (c != '?' || str.charAt(i) == '?') {
                stringBuilder.append(c);
                i++;
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
                AppMethodBeat.m2505o(57207);
                throw illegalArgumentException;
            }
        }
        this.bzH = stringBuilder.toString();
        this.bzI = C0895l.FORCE_NONE;
        this.bzL = new StringBuilder(str.length());
        this.bzM = -1;
        AppMethodBeat.m2505o(57207);
    }

    /* renamed from: vx */
    public final char mo72833vx() {
        AppMethodBeat.m2504i(57208);
        char charAt = this.bzH.charAt(this.pos);
        AppMethodBeat.m2505o(57208);
        return charAt;
    }

    /* renamed from: bi */
    public final void mo72828bi(String str) {
        AppMethodBeat.m2504i(57209);
        this.bzL.append(str);
        AppMethodBeat.m2505o(57209);
    }

    /* renamed from: d */
    public final void mo72829d(char c) {
        AppMethodBeat.m2504i(57210);
        this.bzL.append(c);
        AppMethodBeat.m2505o(57210);
    }

    /* renamed from: vy */
    public final boolean mo72834vy() {
        AppMethodBeat.m2504i(57211);
        if (this.pos < m82680vz()) {
            AppMethodBeat.m2505o(57211);
            return true;
        }
        AppMethodBeat.m2505o(57211);
        return false;
    }

    /* renamed from: vz */
    private int m82680vz() {
        AppMethodBeat.m2504i(57212);
        int length = this.bzH.length() - this.bzO;
        AppMethodBeat.m2505o(57212);
        return length;
    }

    /* renamed from: vA */
    public final int mo72831vA() {
        AppMethodBeat.m2504i(57213);
        int vz = m82680vz() - this.pos;
        AppMethodBeat.m2505o(57213);
        return vz;
    }

    /* renamed from: fF */
    public final void mo72830fF(int i) {
        AppMethodBeat.m2504i(57215);
        if (this.bzN == null || i > this.bzN.bzW) {
            this.bzN = C0894k.m2021a(i, this.bzI, this.bzJ, this.bzK);
        }
        AppMethodBeat.m2505o(57215);
    }

    /* renamed from: vB */
    public final void mo72832vB() {
        AppMethodBeat.m2504i(57214);
        mo72830fF(this.bzL.length());
        AppMethodBeat.m2505o(57214);
    }
}
