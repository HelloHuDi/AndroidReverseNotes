package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a {
    private final int lFA = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    private ByteBuffer lFB;
    private ByteBuffer lFC;

    public a(int i) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(20237);
        ab.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = ".concat(String.valueOf(i)));
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
        AppMethodBeat.o(20237);
    }

    private int getCapacity() {
        AppMethodBeat.i(20238);
        ab.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.lFC.capacity());
        int capacity = this.lFC.capacity();
        AppMethodBeat.o(20238);
        return capacity;
    }

    public final int getSize() {
        AppMethodBeat.i(20239);
        ab.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.lFC.position());
        int position = this.lFC.position();
        AppMethodBeat.o(20239);
        return position;
    }

    public final short readShort() {
        AppMethodBeat.i(20240);
        if (getSize() <= 1) {
            IOException iOException = new IOException("There is only one byte in array");
            AppMethodBeat.o(20240);
            throw iOException;
        }
        short s = this.lFB.getShort();
        ab.d("MicroMsg.exdevice.AutoBuffer", "getShort = ".concat(String.valueOf(s)));
        AppMethodBeat.o(20240);
        return s;
    }

    public final void Q(byte[] bArr, int i) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(20241);
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
        ab.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0 byteCount = ".concat(String.valueOf(i)));
        this.lFB.get(bArr, 0, i);
        AppMethodBeat.o(20241);
    }

    public final void R(byte[] bArr, int i) {
        boolean z = true;
        AppMethodBeat.i(20242);
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        ab.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0 byteCount = ".concat(String.valueOf(i)));
        if (i > this.lFC.remaining()) {
            ab.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
            ByteBuffer allocate = ByteBuffer.allocate((getCapacity() + i) + WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            int position = this.lFB.position();
            allocate.put(this.lFC.array());
            allocate.put(bArr, 0, i);
            this.lFC = allocate;
            this.lFB = allocate.asReadOnlyBuffer();
            this.lFB.position(position);
            AppMethodBeat.o(20242);
            return;
        }
        this.lFC.put(bArr, 0, i);
        AppMethodBeat.o(20242);
    }
}
