package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class ArrayBuffer {
    private ByteBuffer byteBuffer;

    public ArrayBuffer(int i) {
        AppMethodBeat.i(75040);
        this.byteBuffer = ByteBuffer.allocateDirect(i);
        AppMethodBeat.o(75040);
    }

    public ArrayBuffer(byte[] bArr) {
        AppMethodBeat.i(75041);
        this.byteBuffer = ByteBuffer.allocateDirect(bArr.length);
        this.byteBuffer.put(bArr, 0, bArr.length);
        AppMethodBeat.o(75041);
    }

    public ArrayBuffer(ByteBuffer byteBuffer) {
        AppMethodBeat.i(75042);
        this.byteBuffer = validateByteBuffer(byteBuffer);
        AppMethodBeat.o(75042);
    }

    private ByteBuffer validateByteBuffer(ByteBuffer byteBuffer) {
        AppMethodBeat.i(75043);
        if (byteBuffer.isDirect()) {
            AppMethodBeat.o(75043);
            return byteBuffer;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
        AppMethodBeat.o(75043);
        throw illegalArgumentException;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public byte getByte(int i) {
        AppMethodBeat.i(75044);
        byte b = this.byteBuffer.get(i);
        AppMethodBeat.o(75044);
        return b;
    }

    public short getUnsignedByte(int i) {
        AppMethodBeat.i(75045);
        short s = (short) (this.byteBuffer.get(i) & 255);
        AppMethodBeat.o(75045);
        return s;
    }

    public void put(int i, byte b) {
        AppMethodBeat.i(75046);
        this.byteBuffer.put(i, b);
        AppMethodBeat.o(75046);
    }

    public int limit() {
        AppMethodBeat.i(75047);
        int limit = this.byteBuffer.limit();
        AppMethodBeat.o(75047);
        return limit;
    }

    public String toString() {
        return "[object ArrayBuffer]";
    }
}
