package com.eclipsesource.p097v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.eclipsesource.v8.SharedV8ArrayBuffer */
public class SharedV8ArrayBuffer extends V8ArrayBuffer {
    private SharedV8ArrayBuffer(C45010V8 c45010v8, int i) {
        super(c45010v8, i);
        AppMethodBeat.m2504i(75026);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("not support this way construct");
        AppMethodBeat.m2505o(75026);
        throw illegalArgumentException;
    }

    public SharedV8ArrayBuffer(C45010V8 c45010v8, ByteBuffer byteBuffer) {
        super(c45010v8, byteBuffer);
    }

    public void release() {
    }

    /* Access modifiers changed, original: protected */
    public void initialize(long j, Object obj) {
        AppMethodBeat.m2504i(75027);
        this.f14672v8.checkThread();
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        this.objectHandle = this.f14672v8.initNewSharedV8ArrayBuffer(this.f14672v8.getV8RuntimePtr(), byteBuffer, byteBuffer.limit());
        this.released = false;
        addObjectReference(this.objectHandle);
        AppMethodBeat.m2505o(75027);
    }

    public void manualRelease() {
        AppMethodBeat.m2504i(75028);
        super.release();
        AppMethodBeat.m2505o(75028);
    }
}
