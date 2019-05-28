package com.tencent.p177mm.plugin.nfc.p1002a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.nfc.p1004c.C12717a;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.nfc.a.c */
public final class C12714c implements Serializable {
    public byte[] oTb;

    public C12714c(byte[] bArr) {
        AppMethodBeat.m2504i(23021);
        if (bArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("apdu is null");
            AppMethodBeat.m2505o(23021);
            throw illegalArgumentException;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        C12714c.m20729bd(bArr2);
        this.oTb = bArr2;
        AppMethodBeat.m2505o(23021);
    }

    /* renamed from: bd */
    private static void m20729bd(byte[] bArr) {
        AppMethodBeat.m2504i(23022);
        if (bArr.length < 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("apdu must be at least 2 bytes long");
            AppMethodBeat.m2505o(23022);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(23022);
    }

    public final short bVw() {
        return (short) (this.oTb[this.oTb.length - 2] & 255);
    }

    public final short bVx() {
        return (short) (this.oTb[this.oTb.length - 1] & 255);
    }

    public final String toString() {
        AppMethodBeat.m2504i(23024);
        String byteArrayToHexString = C12717a.byteArrayToHexString(this.oTb);
        AppMethodBeat.m2505o(23024);
        return byteArrayToHexString;
    }

    /* renamed from: a */
    public final void mo24713a(C12714c c12714c) {
        AppMethodBeat.m2504i(23025);
        int length = this.oTb.length;
        this.oTb = Arrays.copyOf(this.oTb, (this.oTb.length + c12714c.oTb.length) - 2);
        int i = length - 2;
        byte[] bArr = (byte[]) c12714c.oTb.clone();
        int length2 = bArr.length;
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i + 1;
            this.oTb[i] = bArr[i2];
            i2++;
            i = i3;
        }
        AppMethodBeat.m2505o(23025);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(23026);
        if (this == obj) {
            AppMethodBeat.m2505o(23026);
            return true;
        } else if (obj instanceof C12714c) {
            boolean equals = Arrays.equals(this.oTb, ((C12714c) obj).oTb);
            AppMethodBeat.m2505o(23026);
            return equals;
        } else {
            AppMethodBeat.m2505o(23026);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(23027);
        int hashCode = Arrays.hashCode(this.oTb);
        AppMethodBeat.m2505o(23027);
        return hashCode;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.m2504i(23028);
        this.oTb = (byte[]) objectInputStream.readUnshared();
        C12714c.m20729bd(this.oTb);
        AppMethodBeat.m2505o(23028);
    }

    public final boolean bVy() {
        AppMethodBeat.m2504i(23023);
        if (((short) ((bVw() << 8) | bVx())) == (short) -28672) {
            AppMethodBeat.m2505o(23023);
            return true;
        }
        AppMethodBeat.m2505o(23023);
        return false;
    }
}
