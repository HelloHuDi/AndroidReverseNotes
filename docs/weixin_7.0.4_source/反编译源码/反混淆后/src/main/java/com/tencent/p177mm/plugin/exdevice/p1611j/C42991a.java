package com.tencent.p177mm.plugin.exdevice.p1611j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.j.a */
public final class C42991a {
    private final int lFA = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    private ByteBuffer lFB;
    private ByteBuffer lFC;

    public C42991a(int i) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(20237);
        C4990ab.m7410d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = ".concat(String.valueOf(i)));
        Assert.assertTrue(i >= 0);
        this.lFC = ByteBuffer.allocate(i);
        this.lFB = this.lFC.asReadOnlyBuffer();
        if (this.lFC != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.lFB == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        AppMethodBeat.m2505o(20237);
    }

    private int getCapacity() {
        AppMethodBeat.m2504i(20238);
        C4990ab.m7410d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.lFC.capacity());
        int capacity = this.lFC.capacity();
        AppMethodBeat.m2505o(20238);
        return capacity;
    }

    public final int getSize() {
        AppMethodBeat.m2504i(20239);
        C4990ab.m7410d("MicroMsg.exdevice.AutoBuffer", "size = " + this.lFC.position());
        int position = this.lFC.position();
        AppMethodBeat.m2505o(20239);
        return position;
    }

    public final short readShort() {
        AppMethodBeat.m2504i(20240);
        if (getSize() <= 1) {
            IOException iOException = new IOException("There is only one byte in array");
            AppMethodBeat.m2505o(20240);
            throw iOException;
        }
        short s = this.lFB.getShort();
        C4990ab.m7410d("MicroMsg.exdevice.AutoBuffer", "getShort = ".concat(String.valueOf(s)));
        AppMethodBeat.m2505o(20240);
        return s;
    }

    /* renamed from: Q */
    public final void mo68525Q(byte[] bArr, int i) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(20241);
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr.length >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (bArr.length >= i + 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.lFB.remaining() < i) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        C4990ab.m7410d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0 byteCount = ".concat(String.valueOf(i)));
        this.lFB.get(bArr, 0, i);
        AppMethodBeat.m2505o(20241);
    }

    /* renamed from: R */
    public final void mo68526R(byte[] bArr, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(20242);
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        C4990ab.m7410d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0 byteCount = ".concat(String.valueOf(i)));
        if (i > this.lFC.remaining()) {
            C4990ab.m7410d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
            ByteBuffer allocate = ByteBuffer.allocate((getCapacity() + i) + WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            int position = this.lFB.position();
            allocate.put(this.lFC.array());
            allocate.put(bArr, 0, i);
            this.lFC = allocate;
            this.lFB = allocate.asReadOnlyBuffer();
            this.lFB.position(position);
            AppMethodBeat.m2505o(20242);
            return;
        }
        this.lFC.put(bArr, 0, i);
        AppMethodBeat.m2505o(20242);
    }
}
