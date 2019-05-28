package com.tencent.matrix.resource.p164c.p165a;

import java.util.Arrays;

/* renamed from: com.tencent.matrix.resource.c.a.b */
public final class C1101b {
    public final byte[] bXC;

    public C1101b(byte[] bArr) {
        int length = bArr.length;
        this.bXC = new byte[length];
        System.arraycopy(bArr, 0, this.bXC, 0, length);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1101b) {
            return Arrays.equals(this.bXC, ((C1101b) obj).bXC);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.bXC);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        for (byte b : this.bXC) {
            stringBuilder.append(Integer.toHexString(b & 255));
        }
        return stringBuilder.toString();
    }
}
