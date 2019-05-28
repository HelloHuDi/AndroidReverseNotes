package com.tencent.p177mm.p209c;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.c.l */
public final class C45276l implements Cloneable {
    public int value;

    public C45276l(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private C45276l(byte[] bArr, byte b) {
        AppMethodBeat.m2504i(125698);
        this.value = (bArr[1] << 8) & 65280;
        this.value += bArr[0] & 255;
        AppMethodBeat.m2505o(125698);
    }

    public C45276l(int i) {
        this.value = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof C45276l) && this.value == ((C45276l) obj).value) {
            return true;
        }
        return false;
    }

    public final byte[] getBytes() {
        return new byte[]{(byte) (this.value & 255), (byte) ((this.value & 65280) >> 8)};
    }

    public final int hashCode() {
        return this.value;
    }
}
