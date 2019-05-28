package com.google.b.c.a;

import com.google.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

final class h {
    final String bzH;
    l bzI;
    b bzJ;
    b bzK;
    final StringBuilder bzL;
    int bzM;
    k bzN;
    int bzO;
    int pos;

    h(String str) {
        AppMethodBeat.i(57207);
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
                AppMethodBeat.o(57207);
                throw illegalArgumentException;
            }
        }
        this.bzH = stringBuilder.toString();
        this.bzI = l.FORCE_NONE;
        this.bzL = new StringBuilder(str.length());
        this.bzM = -1;
        AppMethodBeat.o(57207);
    }

    public final char vx() {
        AppMethodBeat.i(57208);
        char charAt = this.bzH.charAt(this.pos);
        AppMethodBeat.o(57208);
        return charAt;
    }

    public final void bi(String str) {
        AppMethodBeat.i(57209);
        this.bzL.append(str);
        AppMethodBeat.o(57209);
    }

    public final void d(char c) {
        AppMethodBeat.i(57210);
        this.bzL.append(c);
        AppMethodBeat.o(57210);
    }

    public final boolean vy() {
        AppMethodBeat.i(57211);
        if (this.pos < vz()) {
            AppMethodBeat.o(57211);
            return true;
        }
        AppMethodBeat.o(57211);
        return false;
    }

    private int vz() {
        AppMethodBeat.i(57212);
        int length = this.bzH.length() - this.bzO;
        AppMethodBeat.o(57212);
        return length;
    }

    public final int vA() {
        AppMethodBeat.i(57213);
        int vz = vz() - this.pos;
        AppMethodBeat.o(57213);
        return vz;
    }

    public final void fF(int i) {
        AppMethodBeat.i(57215);
        if (this.bzN == null || i > this.bzN.bzW) {
            this.bzN = k.a(i, this.bzI, this.bzJ, this.bzK);
        }
        AppMethodBeat.o(57215);
    }

    public final void vB() {
        AppMethodBeat.i(57214);
        fF(this.bzL.length());
        AppMethodBeat.o(57214);
    }
}
