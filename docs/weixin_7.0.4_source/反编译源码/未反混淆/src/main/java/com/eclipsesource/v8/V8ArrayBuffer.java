package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class V8ArrayBuffer extends V8Value {
    private ByteBuffer byteBuffer;

    public V8ArrayBuffer(V8 v8, int i) {
        super(v8);
        AppMethodBeat.i(75441);
        initialize(v8.getV8RuntimePtr(), Integer.valueOf(i));
        this.byteBuffer = v8.createV8ArrayBufferBackingStore(v8.getV8RuntimePtr(), this.objectHandle, i);
        this.byteBuffer.order(ByteOrder.nativeOrder());
        AppMethodBeat.o(75441);
    }

    public V8ArrayBuffer(V8 v8, ByteBuffer byteBuffer) {
        super(v8);
        AppMethodBeat.i(75442);
        if (byteBuffer.isDirect()) {
            initialize(v8.getV8RuntimePtr(), byteBuffer);
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.nativeOrder());
            AppMethodBeat.o(75442);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
        AppMethodBeat.o(75442);
        throw illegalArgumentException;
    }

    /* Access modifiers changed, original: protected */
    public void initialize(long j, Object obj) {
        AppMethodBeat.i(75443);
        this.v8.checkThread();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), byteBuffer, byteBuffer.limit());
        } else {
            this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), ((Integer) obj).intValue());
        }
        this.released = false;
        addObjectReference(this.objectHandle);
        AppMethodBeat.o(75443);
    }

    /* Access modifiers changed, original: protected */
    public V8Value createTwin() {
        AppMethodBeat.i(75444);
        V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(this.v8, this.byteBuffer);
        AppMethodBeat.o(75444);
        return v8ArrayBuffer;
    }

    public V8ArrayBuffer twin() {
        AppMethodBeat.i(75445);
        V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) super.twin();
        AppMethodBeat.o(75445);
        return v8ArrayBuffer;
    }

    public ByteBuffer getBackingStore() {
        AppMethodBeat.i(75446);
        this.v8.checkReleased();
        this.v8.checkThread();
        ByteBuffer byteBuffer = this.byteBuffer;
        AppMethodBeat.o(75446);
        return byteBuffer;
    }
}
