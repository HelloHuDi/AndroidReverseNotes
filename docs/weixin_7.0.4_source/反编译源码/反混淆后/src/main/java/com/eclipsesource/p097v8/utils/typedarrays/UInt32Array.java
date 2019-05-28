package com.eclipsesource.p097v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.eclipsesource.v8.utils.typedarrays.UInt32Array */
public class UInt32Array extends TypedArray {
    public UInt32Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt32Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.m2504i(75072);
        AppMethodBeat.m2505o(75072);
    }

    public long get(int i) {
        AppMethodBeat.m2504i(75073);
        long j = (long) (this.buffer.asIntBuffer().get(i) & -1);
        AppMethodBeat.m2505o(75073);
        return j;
    }

    public int length() {
        AppMethodBeat.m2504i(75074);
        int limit = this.buffer.asIntBuffer().limit();
        AppMethodBeat.m2505o(75074);
        return limit;
    }

    public void put(int i, long j) {
        AppMethodBeat.m2504i(75075);
        this.buffer.asIntBuffer().put(i, (int) (-1 & j));
        AppMethodBeat.m2505o(75075);
    }

    public int getType() {
        return 15;
    }
}
