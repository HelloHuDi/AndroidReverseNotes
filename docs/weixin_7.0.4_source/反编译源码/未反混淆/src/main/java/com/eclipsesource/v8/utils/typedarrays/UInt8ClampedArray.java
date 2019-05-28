package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt8ClampedArray extends TypedArray {
    public UInt8ClampedArray(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt8ClampedArray(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(75080);
        AppMethodBeat.o(75080);
    }

    public short get(int i) {
        AppMethodBeat.i(75081);
        short s = (short) (this.buffer.get(i) & 255);
        AppMethodBeat.o(75081);
        return s;
    }

    public int length() {
        AppMethodBeat.i(75082);
        int limit = this.buffer.limit();
        AppMethodBeat.o(75082);
        return limit;
    }

    public void put(int i, short s) {
        AppMethodBeat.i(75083);
        if (s > (short) 255) {
            this.buffer.put(i, (byte) -1);
            AppMethodBeat.o(75083);
        } else if (s < (short) 0) {
            this.buffer.put(i, (byte) 0);
            AppMethodBeat.o(75083);
        } else {
            this.buffer.put(i, (byte) s);
            AppMethodBeat.o(75083);
        }
    }

    public int getType() {
        return 12;
    }
}
