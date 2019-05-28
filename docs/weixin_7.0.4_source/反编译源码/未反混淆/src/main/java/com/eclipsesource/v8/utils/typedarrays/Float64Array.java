package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Float64Array extends TypedArray {
    public Float64Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Float64Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(75052);
        AppMethodBeat.o(75052);
    }

    public double get(int i) {
        AppMethodBeat.i(75053);
        double d = this.buffer.asDoubleBuffer().get(i);
        AppMethodBeat.o(75053);
        return d;
    }

    public int length() {
        AppMethodBeat.i(75054);
        int limit = this.buffer.asDoubleBuffer().limit();
        AppMethodBeat.o(75054);
        return limit;
    }

    public void put(int i, double d) {
        AppMethodBeat.i(75055);
        this.buffer.asDoubleBuffer().put(i, d);
        AppMethodBeat.o(75055);
    }

    public int getType() {
        return 2;
    }
}
