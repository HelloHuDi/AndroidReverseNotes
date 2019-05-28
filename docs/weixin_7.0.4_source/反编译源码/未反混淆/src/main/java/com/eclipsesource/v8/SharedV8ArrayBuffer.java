package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class SharedV8ArrayBuffer extends V8ArrayBuffer {
    private SharedV8ArrayBuffer(V8 v8, int i) {
        super(v8, i);
        AppMethodBeat.i(75026);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("not support this way construct");
        AppMethodBeat.o(75026);
        throw illegalArgumentException;
    }

    public SharedV8ArrayBuffer(V8 v8, ByteBuffer byteBuffer) {
        super(v8, byteBuffer);
    }

    public void release() {
    }

    /* Access modifiers changed, original: protected */
    public void initialize(long j, Object obj) {
        AppMethodBeat.i(75027);
        this.v8.checkThread();
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        this.objectHandle = this.v8.initNewSharedV8ArrayBuffer(this.v8.getV8RuntimePtr(), byteBuffer, byteBuffer.limit());
        this.released = false;
        addObjectReference(this.objectHandle);
        AppMethodBeat.o(75027);
    }

    public void manualRelease() {
        AppMethodBeat.i(75028);
        super.release();
        AppMethodBeat.o(75028);
    }
}
