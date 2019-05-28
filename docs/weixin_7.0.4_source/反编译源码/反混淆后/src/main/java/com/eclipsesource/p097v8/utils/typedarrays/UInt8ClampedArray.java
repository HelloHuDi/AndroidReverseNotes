package com.eclipsesource.p097v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.eclipsesource.v8.utils.typedarrays.UInt8ClampedArray */
public class UInt8ClampedArray extends TypedArray {
    public UInt8ClampedArray(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt8ClampedArray(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.m2504i(75080);
        AppMethodBeat.m2505o(75080);
    }

    public short get(int i) {
        AppMethodBeat.m2504i(75081);
        short s = (short) (this.buffer.get(i) & 255);
        AppMethodBeat.m2505o(75081);
        return s;
    }

    public int length() {
        AppMethodBeat.m2504i(75082);
        int limit = this.buffer.limit();
        AppMethodBeat.m2505o(75082);
        return limit;
    }

    public void put(int i, short s) {
        AppMethodBeat.m2504i(75083);
        if (s > (short) 255) {
            this.buffer.put(i, (byte) -1);
            AppMethodBeat.m2505o(75083);
        } else if (s < (short) 0) {
            this.buffer.put(i, (byte) 0);
            AppMethodBeat.m2505o(75083);
        } else {
            this.buffer.put(i, (byte) s);
            AppMethodBeat.m2505o(75083);
        }
    }

    public int getType() {
        return 12;
    }
}
