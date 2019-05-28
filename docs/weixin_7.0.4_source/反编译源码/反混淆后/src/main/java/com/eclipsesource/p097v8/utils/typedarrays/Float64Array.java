package com.eclipsesource.p097v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.eclipsesource.v8.utils.typedarrays.Float64Array */
public class Float64Array extends TypedArray {
    public Float64Array(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public Float64Array(ArrayBuffer arrayBuffer) {
        this(arrayBuffer.getByteBuffer());
        AppMethodBeat.m2504i(75052);
        AppMethodBeat.m2505o(75052);
    }

    public double get(int i) {
        AppMethodBeat.m2504i(75053);
        double d = this.buffer.asDoubleBuffer().get(i);
        AppMethodBeat.m2505o(75053);
        return d;
    }

    public int length() {
        AppMethodBeat.m2504i(75054);
        int limit = this.buffer.asDoubleBuffer().limit();
        AppMethodBeat.m2505o(75054);
        return limit;
    }

    public void put(int i, double d) {
        AppMethodBeat.m2504i(75055);
        this.buffer.asDoubleBuffer().put(i, d);
        AppMethodBeat.m2505o(75055);
    }

    public int getType() {
        return 2;
    }
}
