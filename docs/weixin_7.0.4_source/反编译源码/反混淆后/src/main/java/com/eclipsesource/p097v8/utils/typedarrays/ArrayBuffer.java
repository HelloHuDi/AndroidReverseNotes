package com.eclipsesource.p097v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.eclipsesource.v8.utils.typedarrays.ArrayBuffer */
public class ArrayBuffer {
    private ByteBuffer byteBuffer;

    public ArrayBuffer(int i) {
        AppMethodBeat.m2504i(75040);
        this.byteBuffer = ByteBuffer.allocateDirect(i);
        AppMethodBeat.m2505o(75040);
    }

    public ArrayBuffer(byte[] bArr) {
        AppMethodBeat.m2504i(75041);
        this.byteBuffer = ByteBuffer.allocateDirect(bArr.length);
        this.byteBuffer.put(bArr, 0, bArr.length);
        AppMethodBeat.m2505o(75041);
    }

    public ArrayBuffer(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(75042);
        this.byteBuffer = validateByteBuffer(byteBuffer);
        AppMethodBeat.m2505o(75042);
    }

    private ByteBuffer validateByteBuffer(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(75043);
        if (byteBuffer.isDirect()) {
            AppMethodBeat.m2505o(75043);
            return byteBuffer;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
        AppMethodBeat.m2505o(75043);
        throw illegalArgumentException;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public byte getByte(int i) {
        AppMethodBeat.m2504i(75044);
        byte b = this.byteBuffer.get(i);
        AppMethodBeat.m2505o(75044);
        return b;
    }

    public short getUnsignedByte(int i) {
        AppMethodBeat.m2504i(75045);
        short s = (short) (this.byteBuffer.get(i) & 255);
        AppMethodBeat.m2505o(75045);
        return s;
    }

    public void put(int i, byte b) {
        AppMethodBeat.m2504i(75046);
        this.byteBuffer.put(i, b);
        AppMethodBeat.m2505o(75046);
    }

    public int limit() {
        AppMethodBeat.m2504i(75047);
        int limit = this.byteBuffer.limit();
        AppMethodBeat.m2505o(75047);
        return limit;
    }

    public String toString() {
        return "[object ArrayBuffer]";
    }
}
