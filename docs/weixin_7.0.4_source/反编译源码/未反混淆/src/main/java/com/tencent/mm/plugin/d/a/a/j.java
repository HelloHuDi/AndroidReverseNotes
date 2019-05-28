package com.tencent.mm.plugin.d.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class j {
    protected byte jFt = (byte) 0;
    protected byte[] jFu = null;
    protected int mLength = -1;

    public abstract boolean as(byte[] bArr);

    public final boolean a(a aVar) {
        if (aVar.getSize() == 0) {
            ab.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
            return false;
        }
        byte[] bArr = new byte[1];
        aVar.Q(bArr, 1);
        byte b = bArr[0];
        if (b + 1 > aVar.getSize()) {
            ab.w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", Integer.valueOf(b), Integer.valueOf(aVar.getSize()));
            return false;
        } else if (b <= (byte) 1) {
            ab.w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", Integer.valueOf(b));
            return false;
        } else {
            this.mLength = b;
            aVar.Q(bArr, 1);
            this.jFt = bArr[0];
            this.jFu = new byte[(this.mLength - 1)];
            aVar.Q(this.jFu, this.jFu.length);
            return as(this.jFu);
        }
    }
}
