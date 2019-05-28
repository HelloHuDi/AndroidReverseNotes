package com.eclipsesource.p097v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.eclipsesource.v8.utils.typedarrays.UInt8Array */
public class UInt8Array extends TypedArray {
    public UInt8Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt8Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.m2504i(75076);
        AppMethodBeat.m2505o(75076);
    }

    public short get(int i) {
        AppMethodBeat.m2504i(75077);
        short s = (short) (this.buffer.get(i) & 255);
        AppMethodBeat.m2505o(75077);
        return s;
    }

    public int length() {
        AppMethodBeat.m2504i(75078);
        int limit = this.buffer.limit();
        AppMethodBeat.m2505o(75078);
        return limit;
    }

    public void put(int i, short s) {
        AppMethodBeat.m2504i(75079);
        this.buffer.put(i, (byte) (s & 255));
        AppMethodBeat.m2505o(75079);
    }

    public int getType() {
        return 11;
    }
}
