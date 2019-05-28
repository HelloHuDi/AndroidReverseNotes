package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Int16Array extends TypedArray {
    public Int16Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Int16Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(75056);
        AppMethodBeat.o(75056);
    }

    public short get(int i) {
        AppMethodBeat.i(75057);
        short s = this.buffer.asShortBuffer().get(i);
        AppMethodBeat.o(75057);
        return s;
    }

    public int length() {
        AppMethodBeat.i(75058);
        int limit = this.buffer.asShortBuffer().limit();
        AppMethodBeat.o(75058);
        return limit;
    }

    public void put(int i, short s) {
        AppMethodBeat.i(75059);
        this.buffer.asShortBuffer().put(i, s);
        AppMethodBeat.o(75059);
    }

    public int getType() {
        return 13;
    }
}
