package com.eclipsesource.p097v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.eclipsesource.v8.utils.typedarrays.Int8Array */
public class Int8Array extends TypedArray {
    public Int8Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Int8Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.m2504i(75064);
        AppMethodBeat.m2505o(75064);
    }

    public byte get(int i) {
        AppMethodBeat.m2504i(75065);
        byte b = this.buffer.get(i);
        AppMethodBeat.m2505o(75065);
        return b;
    }

    public int length() {
        AppMethodBeat.m2504i(75066);
        int limit = this.buffer.limit();
        AppMethodBeat.m2505o(75066);
        return limit;
    }

    public void put(int i, byte b) {
        AppMethodBeat.m2504i(75067);
        this.buffer.put(i, b);
        AppMethodBeat.m2505o(75067);
    }

    public int getType() {
        return 9;
    }
}
