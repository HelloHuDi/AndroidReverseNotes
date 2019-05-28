package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class Float32Array extends TypedArray {
    public Float32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Float32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(75048);
        AppMethodBeat.o(75048);
    }

    public float get(int i) {
        AppMethodBeat.i(75049);
        float f = this.buffer.asFloatBuffer().get(i);
        AppMethodBeat.o(75049);
        return f;
    }

    public int length() {
        AppMethodBeat.i(75050);
        int limit = this.buffer.asFloatBuffer().limit();
        AppMethodBeat.o(75050);
        return limit;
    }

    public void put(int i, float f) {
        AppMethodBeat.i(75051);
        this.buffer.asFloatBuffer().put(i, f);
        AppMethodBeat.o(75051);
    }

    public int getType() {
        return 16;
    }
}
