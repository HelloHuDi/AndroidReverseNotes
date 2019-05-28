package com.eclipsesource.v8.utils.typedarrays;

import com.eclipsesource.v8.V8TypedArray;
import java.nio.ByteBuffer;

public abstract class TypedArray {
    protected ByteBuffer buffer;

    public abstract int getType();

    public abstract int length();

    protected TypedArray(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
        } else if (byteBuffer.limit() % V8TypedArray.getStructureSize(getType()) != 0) {
            throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
        } else {
            this.buffer = byteBuffer;
        }
    }

    public ByteBuffer getByteBuffer() {
        return this.buffer;
    }
}
