package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k implements Cloneable {
    long value;

    public k(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private k(byte[] bArr, byte b) {
        AppMethodBeat.i(125705);
        this.value = ((long) (bArr[3] << 24)) & 4278190080L;
        this.value += (long) ((bArr[2] << 16) & 16711680);
        this.value += (long) ((bArr[1] << 8) & 65280);
        this.value += (long) (bArr[0] & 255);
        AppMethodBeat.o(125705);
    }

    public k(long j) {
        this.value = j;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof k) && this.value == ((k) obj).value) {
            return true;
        }
        return false;
    }

    public final byte[] getBytes() {
        return new byte[]{(byte) ((int) (this.value & 255)), (byte) ((int) ((this.value & 65280) >> 8)), (byte) ((int) ((this.value & 16711680) >> 16)), (byte) ((int) ((this.value & 4278190080L) >> 24))};
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
