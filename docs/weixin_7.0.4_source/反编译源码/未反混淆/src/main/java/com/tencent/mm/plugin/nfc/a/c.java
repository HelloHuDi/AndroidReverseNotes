package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.c.a;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class c implements Serializable {
    public byte[] oTb;

    public c(byte[] bArr) {
        AppMethodBeat.i(23021);
        if (bArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("apdu is null");
            AppMethodBeat.o(23021);
            throw illegalArgumentException;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        bd(bArr2);
        this.oTb = bArr2;
        AppMethodBeat.o(23021);
    }

    private static void bd(byte[] bArr) {
        AppMethodBeat.i(23022);
        if (bArr.length < 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("apdu must be at least 2 bytes long");
            AppMethodBeat.o(23022);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(23022);
    }

    public final short bVw() {
        return (short) (this.oTb[this.oTb.length - 2] & 255);
    }

    public final short bVx() {
        return (short) (this.oTb[this.oTb.length - 1] & 255);
    }

    public final String toString() {
        AppMethodBeat.i(23024);
        String byteArrayToHexString = a.byteArrayToHexString(this.oTb);
        AppMethodBeat.o(23024);
        return byteArrayToHexString;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(23025);
        int length = this.oTb.length;
        this.oTb = Arrays.copyOf(this.oTb, (this.oTb.length + cVar.oTb.length) - 2);
        int i = length - 2;
        byte[] bArr = (byte[]) cVar.oTb.clone();
        int length2 = bArr.length;
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i + 1;
            this.oTb[i] = bArr[i2];
            i2++;
            i = i3;
        }
        AppMethodBeat.o(23025);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(23026);
        if (this == obj) {
            AppMethodBeat.o(23026);
            return true;
        } else if (obj instanceof c) {
            boolean equals = Arrays.equals(this.oTb, ((c) obj).oTb);
            AppMethodBeat.o(23026);
            return equals;
        } else {
            AppMethodBeat.o(23026);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(23027);
        int hashCode = Arrays.hashCode(this.oTb);
        AppMethodBeat.o(23027);
        return hashCode;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.i(23028);
        this.oTb = (byte[]) objectInputStream.readUnshared();
        bd(this.oTb);
        AppMethodBeat.o(23028);
    }

    public final boolean bVy() {
        AppMethodBeat.i(23023);
        if (((short) ((bVw() << 8) | bVx())) == (short) -28672) {
            AppMethodBeat.o(23023);
            return true;
        }
        AppMethodBeat.o(23023);
        return false;
    }
}
