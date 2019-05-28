package com.tencent.p177mm.plugin.p369d.p370a.p371a;

import com.tencent.p177mm.plugin.exdevice.p1611j.C42991a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.d.a.a.j */
public abstract class C38825j {
    protected byte jFt = (byte) 0;
    protected byte[] jFu = null;
    protected int mLength = -1;

    /* renamed from: as */
    public abstract boolean mo61708as(byte[] bArr);

    /* renamed from: a */
    public final boolean mo61707a(C42991a c42991a) {
        if (c42991a.getSize() == 0) {
            C4990ab.m7420w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
            return false;
        }
        byte[] bArr = new byte[1];
        c42991a.mo68525Q(bArr, 1);
        byte b = bArr[0];
        if (b + 1 > c42991a.getSize()) {
            C4990ab.m7421w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", Integer.valueOf(b), Integer.valueOf(c42991a.getSize()));
            return false;
        } else if (b <= (byte) 1) {
            C4990ab.m7421w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", Integer.valueOf(b));
            return false;
        } else {
            this.mLength = b;
            c42991a.mo68525Q(bArr, 1);
            this.jFt = bArr[0];
            this.jFu = new byte[(this.mLength - 1)];
            c42991a.mo68525Q(this.jFu, this.jFu.length);
            return mo61708as(this.jFu);
        }
    }
}
