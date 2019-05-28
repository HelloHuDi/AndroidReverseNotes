package com.eclipsesource.p097v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.eclipsesource.v8.V8ArrayBuffer */
public class V8ArrayBuffer extends V8Value {
    private ByteBuffer byteBuffer;

    public V8ArrayBuffer(C45010V8 c45010v8, int i) {
        super(c45010v8);
        AppMethodBeat.m2504i(75441);
        initialize(c45010v8.getV8RuntimePtr(), Integer.valueOf(i));
        this.byteBuffer = c45010v8.createV8ArrayBufferBackingStore(c45010v8.getV8RuntimePtr(), this.objectHandle, i);
        this.byteBuffer.order(ByteOrder.nativeOrder());
        AppMethodBeat.m2505o(75441);
    }

    public V8ArrayBuffer(C45010V8 c45010v8, ByteBuffer byteBuffer) {
        super(c45010v8);
        AppMethodBeat.m2504i(75442);
        if (byteBuffer.isDirect()) {
            initialize(c45010v8.getV8RuntimePtr(), byteBuffer);
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.nativeOrder());
            AppMethodBeat.m2505o(75442);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
        AppMethodBeat.m2505o(75442);
        throw illegalArgumentException;
    }

    /* Access modifiers changed, original: protected */
    public void initialize(long j, Object obj) {
        AppMethodBeat.m2504i(75443);
        this.f14672v8.checkThread();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            this.objectHandle = this.f14672v8.initNewV8ArrayBuffer(this.f14672v8.getV8RuntimePtr(), byteBuffer, byteBuffer.limit());
        } else {
            this.objectHandle = this.f14672v8.initNewV8ArrayBuffer(this.f14672v8.getV8RuntimePtr(), ((Integer) obj).intValue());
        }
        this.released = false;
        addObjectReference(this.objectHandle);
        AppMethodBeat.m2505o(75443);
    }

    /* Access modifiers changed, original: protected */
    public V8Value createTwin() {
        AppMethodBeat.m2504i(75444);
        V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(this.f14672v8, this.byteBuffer);
        AppMethodBeat.m2505o(75444);
        return v8ArrayBuffer;
    }

    public V8ArrayBuffer twin() {
        AppMethodBeat.m2504i(75445);
        V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) super.twin();
        AppMethodBeat.m2505o(75445);
        return v8ArrayBuffer;
    }

    public ByteBuffer getBackingStore() {
        AppMethodBeat.m2504i(75446);
        this.f14672v8.checkReleased();
        this.f14672v8.checkThread();
        ByteBuffer byteBuffer = this.byteBuffer;
        AppMethodBeat.m2505o(75446);
        return byteBuffer;
    }
}
