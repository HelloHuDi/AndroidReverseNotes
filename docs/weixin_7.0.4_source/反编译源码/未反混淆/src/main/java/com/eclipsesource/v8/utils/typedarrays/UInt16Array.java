package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class UInt16Array extends TypedArray {
    public UInt16Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public UInt16Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.i(75068);
        AppMethodBeat.o(75068);
    }

    public int get(int i) {
        AppMethodBeat.i(75069);
        int i2 = CdnLogic.kBizGeneric & this.buffer.asShortBuffer().get(i);
        AppMethodBeat.o(75069);
        return i2;
    }

    public int length() {
        AppMethodBeat.i(75070);
        int limit = this.buffer.asShortBuffer().limit();
        AppMethodBeat.o(75070);
        return limit;
    }

    public void put(int i, int i2) {
        AppMethodBeat.i(75071);
        this.buffer.asShortBuffer().put(i, (short) (CdnLogic.kBizGeneric & i2));
        AppMethodBeat.o(75071);
    }

    public int getType() {
        return 14;
    }
}
