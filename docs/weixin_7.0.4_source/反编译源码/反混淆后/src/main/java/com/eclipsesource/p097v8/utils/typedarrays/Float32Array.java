package com.eclipsesource.p097v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.eclipsesource.v8.utils.typedarrays.Float32Array */
public class Float32Array extends TypedArray {
    public Float32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Float32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.m2504i(75048);
        AppMethodBeat.m2505o(75048);
    }

    public float get(int i) {
        AppMethodBeat.m2504i(75049);
        float f = this.buffer.asFloatBuffer().get(i);
        AppMethodBeat.m2505o(75049);
        return f;
    }

    public int length() {
        AppMethodBeat.m2504i(75050);
        int limit = this.buffer.asFloatBuffer().limit();
        AppMethodBeat.m2505o(75050);
        return limit;
    }

    public void put(int i, float f) {
        AppMethodBeat.m2504i(75051);
        this.buffer.asFloatBuffer().put(i, f);
        AppMethodBeat.m2505o(75051);
    }

    public int getType() {
        return 16;
    }
}
