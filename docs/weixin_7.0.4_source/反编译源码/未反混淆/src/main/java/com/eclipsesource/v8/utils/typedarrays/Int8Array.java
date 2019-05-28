package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Int8Array extends TypedArray {
    public Int8Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Int8Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(75064);
        AppMethodBeat.o(75064);
    }

    public byte get(int i) {
        AppMethodBeat.i(75065);
        byte b = this.buffer.get(i);
        AppMethodBeat.o(75065);
        return b;
    }

    public int length() {
        AppMethodBeat.i(75066);
        int limit = this.buffer.limit();
        AppMethodBeat.o(75066);
        return limit;
    }

    public void put(int i, byte b) {
        AppMethodBeat.i(75067);
        this.buffer.put(i, b);
        AppMethodBeat.o(75067);
    }

    public int getType() {
        return 9;
    }
}
