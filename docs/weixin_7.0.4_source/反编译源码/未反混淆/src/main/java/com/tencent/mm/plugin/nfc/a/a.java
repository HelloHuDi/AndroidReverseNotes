package com.tencent.mm.plugin.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class a implements Serializable {
    private byte[] oTb;
    private transient int oTc;
    private transient int oTd;
    private transient int oTe;

    public a(byte[] bArr) {
        AppMethodBeat.i(23013);
        this.oTb = (byte[]) bArr.clone();
        parse();
        AppMethodBeat.o(23013);
    }

    public a(String str) {
        AppMethodBeat.i(23014);
        this.oTb = com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str);
        parse();
        AppMethodBeat.o(23014);
    }

    private void parse() {
        int i = 256;
        AppMethodBeat.i(23015);
        IllegalArgumentException illegalArgumentException;
        if (this.oTb.length < 4) {
            illegalArgumentException = new IllegalArgumentException("apdu must be at least 4 bytes long");
            AppMethodBeat.o(23015);
            throw illegalArgumentException;
        } else if (this.oTb.length == 4) {
            AppMethodBeat.o(23015);
        } else {
            int i2 = this.oTb[4] & 255;
            if (this.oTb.length == 5) {
                if (i2 != 0) {
                    i = i2;
                }
                this.oTd = i;
                AppMethodBeat.o(23015);
            } else if (i2 != 0) {
                if (this.oTb.length == i2 + 5) {
                    this.oTc = i2;
                    this.oTe = 5;
                    AppMethodBeat.o(23015);
                } else if (this.oTb.length == i2 + 6) {
                    this.oTc = i2;
                    this.oTe = 5;
                    i2 = this.oTb[this.oTb.length - 1] & 255;
                    if (i2 != 0) {
                        i = i2;
                    }
                    this.oTd = i;
                    AppMethodBeat.o(23015);
                } else {
                    illegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.oTb.length + ", b1=" + i2);
                    AppMethodBeat.o(23015);
                    throw illegalArgumentException;
                }
            } else if (this.oTb.length < 7) {
                illegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.oTb.length + ", b1=" + i2);
                AppMethodBeat.o(23015);
                throw illegalArgumentException;
            } else {
                i = ((this.oTb[5] & 255) << 8) | (this.oTb[6] & 255);
                IllegalArgumentException illegalArgumentException2;
                if (this.oTb.length == 7) {
                    if (i == 0) {
                        i = 65536;
                    }
                    this.oTd = i;
                    AppMethodBeat.o(23015);
                } else if (i == 0) {
                    illegalArgumentException2 = new IllegalArgumentException("Invalid APDU: length=" + this.oTb.length + ", b1=" + i2 + ", b2||b3=" + i);
                    AppMethodBeat.o(23015);
                    throw illegalArgumentException2;
                } else if (this.oTb.length == i + 7) {
                    this.oTc = i;
                    this.oTe = 7;
                    AppMethodBeat.o(23015);
                } else if (this.oTb.length == i + 9) {
                    this.oTc = i;
                    this.oTe = 7;
                    i = this.oTb.length - 2;
                    i = (this.oTb[i + 1] & 255) | ((this.oTb[i] & 255) << 8);
                    if (i == 0) {
                        i = 65536;
                    }
                    this.oTd = i;
                    AppMethodBeat.o(23015);
                } else {
                    illegalArgumentException2 = new IllegalArgumentException("Invalid APDU: length=" + this.oTb.length + ", b1=" + i2 + ", b2||b3=" + i);
                    AppMethodBeat.o(23015);
                    throw illegalArgumentException2;
                }
            }
        }
    }

    public final void Ag(int i) {
        this.oTd = i;
        this.oTb[this.oTb.length - 1] = (byte) i;
    }

    public final byte[] getBytes() {
        AppMethodBeat.i(23016);
        byte[] bArr = (byte[]) this.oTb.clone();
        AppMethodBeat.o(23016);
        return bArr;
    }

    public final String toString() {
        AppMethodBeat.i(23017);
        String byteArrayToHexString = com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(this.oTb);
        AppMethodBeat.o(23017);
        return byteArrayToHexString;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(23018);
        if (this == obj) {
            AppMethodBeat.o(23018);
            return true;
        } else if (obj instanceof a) {
            boolean equals = Arrays.equals(this.oTb, ((a) obj).oTb);
            AppMethodBeat.o(23018);
            return equals;
        } else {
            AppMethodBeat.o(23018);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(23019);
        int hashCode = Arrays.hashCode(this.oTb);
        AppMethodBeat.o(23019);
        return hashCode;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.i(23020);
        this.oTb = (byte[]) objectInputStream.readUnshared();
        parse();
        AppMethodBeat.o(23020);
    }
}
