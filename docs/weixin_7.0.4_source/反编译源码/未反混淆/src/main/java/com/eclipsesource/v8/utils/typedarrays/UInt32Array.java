package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt32Array extends TypedArray {
    public UInt32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(75072);
        AppMethodBeat.o(75072);
    }

    public long get(int i) {
        AppMethodBeat.i(75073);
        long j = (long) (this.buffer.asIntBuffer().get(i) & -1);
        AppMethodBeat.o(75073);
        return j;
    }

    public int length() {
        AppMethodBeat.i(75074);
        int limit = this.buffer.asIntBuffer().limit();
        AppMethodBeat.o(75074);
        return limit;
    }

    public void put(int i, long j) {
        AppMethodBeat.i(75075);
        this.buffer.asIntBuffer().put(i, (int) (-1 & j));
        AppMethodBeat.o(75075);
    }

    public int getType() {
        return 15;
    }
}
