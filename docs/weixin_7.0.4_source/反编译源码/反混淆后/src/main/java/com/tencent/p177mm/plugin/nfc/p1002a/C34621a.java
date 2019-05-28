package com.tencent.p177mm.plugin.nfc.p1002a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.nfc.p1004c.C12717a;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.nfc.a.a */
public final class C34621a implements Serializable {
    private byte[] oTb;
    private transient int oTc;
    private transient int oTd;
    private transient int oTe;

    public C34621a(byte[] bArr) {
        AppMethodBeat.m2504i(23013);
        this.oTb = (byte[]) bArr.clone();
        parse();
        AppMethodBeat.m2505o(23013);
    }

    public C34621a(String str) {
        AppMethodBeat.m2504i(23014);
        this.oTb = C12717a.hexStringToByteArray(str);
        parse();
        AppMethodBeat.m2505o(23014);
    }

    private void parse() {
        int i = 256;
        AppMethodBeat.m2504i(23015);
        IllegalArgumentException illegalArgumentException;
        if (this.oTb.length < 4) {
            illegalArgumentException = new IllegalArgumentException("apdu must be at least 4 bytes long");
            AppMethodBeat.m2505o(23015);
            throw illegalArgumentException;
        } else if (this.oTb.length == 4) {
            AppMethodBeat.m2505o(23015);
        } else {
            int i2 = this.oTb[4] & 255;
            if (this.oTb.length == 5) {
                if (i2 != 0) {
                    i = i2;
                }
                this.oTd = i;
                AppMethodBeat.m2505o(23015);
            } else if (i2 != 0) {
                if (this.oTb.length == i2 + 5) {
                    this.oTc = i2;
                    this.oTe = 5;
                    AppMethodBeat.m2505o(23015);
                } else if (this.oTb.length == i2 + 6) {
                    this.oTc = i2;
                    this.oTe = 5;
                    i2 = this.oTb[this.oTb.length - 1] & 255;
                    if (i2 != 0) {
                        i = i2;
                    }
                    this.oTd = i;
                    AppMethodBeat.m2505o(23015);
                } else {
                    illegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.oTb.length + ", b1=" + i2);
                    AppMethodBeat.m2505o(23015);
                    throw illegalArgumentException;
                }
            } else if (this.oTb.length < 7) {
                illegalArgumentException = new IllegalArgumentException("Invalid APDU: length=" + this.oTb.length + ", b1=" + i2);
                AppMethodBeat.m2505o(23015);
                throw illegalArgumentException;
            } else {
                i = ((this.oTb[5] & 255) << 8) | (this.oTb[6] & 255);
                IllegalArgumentException illegalArgumentException2;
                if (this.oTb.length == 7) {
                    if (i == 0) {
                        i = 65536;
                    }
                    this.oTd = i;
                    AppMethodBeat.m2505o(23015);
                } else if (i == 0) {
                    illegalArgumentException2 = new IllegalArgumentException("Invalid APDU: length=" + this.oTb.length + ", b1=" + i2 + ", b2||b3=" + i);
                    AppMethodBeat.m2505o(23015);
                    throw illegalArgumentException2;
                } else if (this.oTb.length == i + 7) {
                    this.oTc = i;
                    this.oTe = 7;
                    AppMethodBeat.m2505o(23015);
                } else if (this.oTb.length == i + 9) {
                    this.oTc = i;
                    this.oTe = 7;
                    i = this.oTb.length - 2;
                    i = (this.oTb[i + 1] & 255) | ((this.oTb[i] & 255) << 8);
                    if (i == 0) {
                        i = 65536;
                    }
                    this.oTd = i;
                    AppMethodBeat.m2505o(23015);
                } else {
                    illegalArgumentException2 = new IllegalArgumentException("Invalid APDU: length=" + this.oTb.length + ", b1=" + i2 + ", b2||b3=" + i);
                    AppMethodBeat.m2505o(23015);
                    throw illegalArgumentException2;
                }
            }
        }
    }

    /* renamed from: Ag */
    public final void mo55205Ag(int i) {
        this.oTd = i;
        this.oTb[this.oTb.length - 1] = (byte) i;
    }

    public final byte[] getBytes() {
        AppMethodBeat.m2504i(23016);
        byte[] bArr = (byte[]) this.oTb.clone();
        AppMethodBeat.m2505o(23016);
        return bArr;
    }

    public final String toString() {
        AppMethodBeat.m2504i(23017);
        String byteArrayToHexString = C12717a.byteArrayToHexString(this.oTb);
        AppMethodBeat.m2505o(23017);
        return byteArrayToHexString;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(23018);
        if (this == obj) {
            AppMethodBeat.m2505o(23018);
            return true;
        } else if (obj instanceof C34621a) {
            boolean equals = Arrays.equals(this.oTb, ((C34621a) obj).oTb);
            AppMethodBeat.m2505o(23018);
            return equals;
        } else {
            AppMethodBeat.m2505o(23018);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(23019);
        int hashCode = Arrays.hashCode(this.oTb);
        AppMethodBeat.m2505o(23019);
        return hashCode;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.m2504i(23020);
        this.oTb = (byte[]) objectInputStream.readUnshared();
        parse();
        AppMethodBeat.m2505o(23020);
    }
}
