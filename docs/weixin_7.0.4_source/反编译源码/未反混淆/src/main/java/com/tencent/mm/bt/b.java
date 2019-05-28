package com.tencent.mm.bt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public final class b {
    public byte[] wR;

    private b() {
    }

    public b(byte[] bArr) {
        this(bArr, 0, bArr.length);
        AppMethodBeat.i(51823);
        AppMethodBeat.o(51823);
    }

    public b(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(51824);
        this.wR = new byte[i2];
        System.arraycopy(bArr, i, this.wR, 0, i2);
        AppMethodBeat.o(51824);
    }

    public static b y(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(51825);
        b bVar = new b(bArr, i, i2);
        AppMethodBeat.o(51825);
        return bVar;
    }

    public static b bI(byte[] bArr) {
        AppMethodBeat.i(51826);
        if (bArr == null) {
            bArr = new byte[0];
        }
        b bVar = new b(bArr);
        AppMethodBeat.o(51826);
        return bVar;
    }

    public static b akB(String str) {
        AppMethodBeat.i(51827);
        try {
            b bVar = new b();
            bVar.wR = str.getBytes("UTF-8");
            AppMethodBeat.o(51827);
            return bVar;
        } catch (UnsupportedEncodingException e) {
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?", e);
            AppMethodBeat.o(51827);
            throw runtimeException;
        }
    }

    public final b Lv(int i) {
        AppMethodBeat.i(51828);
        byte[] bArr = new byte[i];
        if (this.wR.length >= i) {
            System.arraycopy(this.wR, 0, bArr, 0, i - 1);
            this.wR = bArr;
        } else {
            System.arraycopy(this.wR, 0, bArr, 0, this.wR.length);
            this.wR = bArr;
        }
        AppMethodBeat.o(51828);
        return this;
    }

    public final void bJ(byte[] bArr) {
        AppMethodBeat.i(51829);
        System.arraycopy(this.wR, 0, bArr, 4, this.wR.length);
        AppMethodBeat.o(51829);
    }

    public final void f(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(51830);
        System.arraycopy(this.wR, i, bArr, i2, i3);
        AppMethodBeat.o(51830);
    }

    public final byte[] toByteArray() {
        AppMethodBeat.i(51831);
        int length = this.wR.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.wR, 0, bArr, 0, length);
        AppMethodBeat.o(51831);
        return bArr;
    }

    public final byte[] getBytes() {
        return this.wR;
    }

    public final String dlY() {
        int i = 0;
        AppMethodBeat.i(51832);
        while (i < this.wR.length) {
            try {
                if (this.wR[i] == (byte) 0) {
                    break;
                }
                i++;
            } catch (UnsupportedEncodingException e) {
                RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?");
                AppMethodBeat.o(51832);
                throw runtimeException;
            }
        }
        String str = new String(this.wR, 0, i, "UTF-8");
        AppMethodBeat.o(51832);
        return str;
    }
}
