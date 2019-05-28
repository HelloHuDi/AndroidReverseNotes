package com.eclipsesource.p097v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.eclipsesource.v8.utils.typedarrays.Int16Array */
public class Int16Array extends TypedArray {
    public Int16Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Int16Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.m2504i(75056);
        AppMethodBeat.m2505o(75056);
    }

    public short get(int i) {
        AppMethodBeat.m2504i(75057);
        short s = this.buffer.asShortBuffer().get(i);
        AppMethodBeat.m2505o(75057);
        return s;
    }

    public int length() {
        AppMethodBeat.m2504i(75058);
        int limit = this.buffer.asShortBuffer().limit();
        AppMethodBeat.m2505o(75058);
        return limit;
    }

    public void put(int i, short s) {
        AppMethodBeat.m2504i(75059);
        this.buffer.asShortBuffer().put(i, s);
        AppMethodBeat.m2505o(75059);
    }

    public int getType() {
        return 13;
    }
}
