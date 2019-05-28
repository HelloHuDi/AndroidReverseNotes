package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt8Array extends TypedArray {
    public UInt8Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt8Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(75076);
        AppMethodBeat.o(75076);
    }

    public short get(int i) {
        AppMethodBeat.i(75077);
        short s = (short) (this.buffer.get(i) & 255);
        AppMethodBeat.o(75077);
        return s;
    }

    public int length() {
        AppMethodBeat.i(75078);
        int limit = this.buffer.limit();
        AppMethodBeat.o(75078);
        return limit;
    }

    public void put(int i, short s) {
        AppMethodBeat.i(75079);
        this.buffer.put(i, (byte) (s & 255));
        AppMethodBeat.o(75079);
    }

    public int getType() {
        return 11;
    }
}
