package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Int32Array extends TypedArray {
    public Int32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Int32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(75060);
        AppMethodBeat.o(75060);
    }

    public int get(int i) {
        AppMethodBeat.i(75061);
        int i2 = this.buffer.asIntBuffer().get(i);
        AppMethodBeat.o(75061);
        return i2;
    }

    public int length() {
        AppMethodBeat.i(75062);
        int limit = this.buffer.asIntBuffer().limit();
        AppMethodBeat.o(75062);
        return limit;
    }

    public void put(int i, int i2) {
        AppMethodBeat.i(75063);
        this.buffer.asIntBuffer().put(i, i2);
        AppMethodBeat.o(75063);
    }

    public int getType() {
        return 1;
    }
}
