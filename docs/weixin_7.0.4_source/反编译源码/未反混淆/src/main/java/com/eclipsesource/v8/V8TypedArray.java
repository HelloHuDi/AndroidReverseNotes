package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class V8TypedArray extends V8Array {

    static class V8ArrayData {
        private V8ArrayBuffer buffer;
        private int offset;
        private int size;
        private int type;

        public V8ArrayData(V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
            this.buffer = v8ArrayBuffer;
            this.offset = i;
            this.size = i2;
            this.type = i3;
        }
    }

    public V8TypedArray(V8 v8, V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
        super(v8, new V8ArrayData(v8ArrayBuffer, i2, i3, i));
        AppMethodBeat.i(75579);
        AppMethodBeat.o(75579);
    }

    private V8TypedArray(V8 v8) {
        super(v8);
    }

    public V8ArrayBuffer getBuffer() {
        AppMethodBeat.i(75580);
        V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) get("buffer");
        AppMethodBeat.o(75580);
        return v8ArrayBuffer;
    }

    public ByteBuffer getByteBuffer() {
        AppMethodBeat.i(75581);
        V8ArrayBuffer buffer = getBuffer();
        try {
            ByteBuffer backingStore = buffer.getBackingStore();
            return backingStore;
        } finally {
            buffer.release();
            AppMethodBeat.o(75581);
        }
    }

    /* Access modifiers changed, original: protected */
    public void initialize(long j, Object obj) {
        AppMethodBeat.i(75582);
        this.v8.checkThread();
        if (obj == null) {
            super.initialize(j, obj);
            AppMethodBeat.o(75582);
            return;
        }
        V8ArrayData v8ArrayData = (V8ArrayData) obj;
        checkArrayProperties(v8ArrayData);
        long createTypedArray = createTypedArray(j, v8ArrayData);
        this.released = false;
        addObjectReference(createTypedArray);
        AppMethodBeat.o(75582);
    }

    private long createTypedArray(long j, V8ArrayData v8ArrayData) {
        AppMethodBeat.i(75583);
        long initNewV8Int32Array;
        switch (v8ArrayData.type) {
            case 1:
                initNewV8Int32Array = this.v8.initNewV8Int32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(75583);
                return initNewV8Int32Array;
            case 2:
                initNewV8Int32Array = this.v8.initNewV8Float64Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(75583);
                return initNewV8Int32Array;
            case 9:
                initNewV8Int32Array = this.v8.initNewV8Int8Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(75583);
                return initNewV8Int32Array;
            case 11:
                initNewV8Int32Array = this.v8.initNewV8UInt8Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(75583);
                return initNewV8Int32Array;
            case 12:
                initNewV8Int32Array = this.v8.initNewV8UInt8ClampedArray(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(75583);
                return initNewV8Int32Array;
            case 13:
                initNewV8Int32Array = this.v8.initNewV8Int16Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(75583);
                return initNewV8Int32Array;
            case 14:
                initNewV8Int32Array = this.v8.initNewV8UInt16Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(75583);
                return initNewV8Int32Array;
            case 15:
                initNewV8Int32Array = this.v8.initNewV8UInt32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(75583);
                return initNewV8Int32Array;
            case 16:
                initNewV8Int32Array = this.v8.initNewV8Float32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                AppMethodBeat.o(75583);
                return initNewV8Int32Array;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(v8ArrayData.type));
                AppMethodBeat.o(75583);
                throw illegalArgumentException;
        }
    }

    public static int getStructureSize(int i) {
        AppMethodBeat.i(75584);
        switch (i) {
            case 1:
            case 15:
            case 16:
                AppMethodBeat.o(75584);
                return 4;
            case 2:
                AppMethodBeat.o(75584);
                return 8;
            case 9:
            case 11:
            case 12:
                AppMethodBeat.o(75584);
                return 1;
            case 13:
            case 14:
                AppMethodBeat.o(75584);
                return 2;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(i));
                AppMethodBeat.o(75584);
                throw illegalArgumentException;
        }
    }

    private void checkArrayProperties(V8ArrayData v8ArrayData) {
        AppMethodBeat.i(75585);
        checkOffset(v8ArrayData);
        checkSize(v8ArrayData);
        AppMethodBeat.o(75585);
    }

    private void checkSize(V8ArrayData v8ArrayData) {
        AppMethodBeat.i(75586);
        IllegalStateException illegalStateException;
        if (v8ArrayData.size < 0) {
            illegalStateException = new IllegalStateException("RangeError: Invalid typed array length");
            AppMethodBeat.o(75586);
            throw illegalStateException;
        } else if ((v8ArrayData.size * getStructureSize(v8ArrayData.type)) + v8ArrayData.offset > v8ArrayData.buffer.getBackingStore().limit()) {
            illegalStateException = new IllegalStateException("RangeError: Invalid typed array length");
            AppMethodBeat.o(75586);
            throw illegalStateException;
        } else {
            AppMethodBeat.o(75586);
        }
    }

    private void checkOffset(V8ArrayData v8ArrayData) {
        AppMethodBeat.i(75587);
        if (v8ArrayData.offset % getStructureSize(v8ArrayData.type) != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("RangeError: Start offset of Int32Array must be a multiple of " + getStructureSize(v8ArrayData.type));
            AppMethodBeat.o(75587);
            throw illegalStateException;
        }
        AppMethodBeat.o(75587);
    }

    /* Access modifiers changed, original: protected */
    public V8Value createTwin() {
        AppMethodBeat.i(75588);
        V8TypedArray v8TypedArray = new V8TypedArray(this.v8);
        AppMethodBeat.o(75588);
        return v8TypedArray;
    }
}
