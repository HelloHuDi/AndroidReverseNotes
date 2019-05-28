package com.tencent.mm.plugin.appbrand.t.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.d.d.a;
import com.tencent.mm.plugin.appbrand.t.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e implements c {
    protected static byte[] iTy = new byte[0];
    protected a iTA;
    private ByteBuffer iTB;
    protected boolean iTC;
    protected boolean iTz;

    public e(a aVar) {
        AppMethodBeat.i(73262);
        this.iTA = aVar;
        this.iTB = ByteBuffer.wrap(iTy);
        AppMethodBeat.o(73262);
    }

    public e(d dVar) {
        AppMethodBeat.i(73263);
        this.iTz = dVar.aOr();
        this.iTA = dVar.aOt();
        this.iTB = dVar.aOq();
        this.iTC = dVar.aOs();
        AppMethodBeat.o(73263);
    }

    public final boolean aOr() {
        return this.iTz;
    }

    public final a aOt() {
        return this.iTA;
    }

    public final boolean aOs() {
        return this.iTC;
    }

    public ByteBuffer aOq() {
        return this.iTB;
    }

    public final void eM(boolean z) {
        this.iTz = z;
    }

    public final void a(a aVar) {
        this.iTA = aVar;
    }

    public void A(ByteBuffer byteBuffer) {
        this.iTB = byteBuffer;
    }

    public final void eN(boolean z) {
        this.iTC = z;
    }

    public final void e(d dVar) {
        AppMethodBeat.i(73264);
        ByteBuffer aOq = dVar.aOq();
        if (this.iTB == null) {
            this.iTB = ByteBuffer.allocate(aOq.remaining());
            aOq.mark();
            this.iTB.put(aOq);
            aOq.reset();
        } else {
            aOq.mark();
            this.iTB.position(this.iTB.limit());
            this.iTB.limit(this.iTB.capacity());
            if (aOq.remaining() > this.iTB.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(aOq.remaining() + this.iTB.capacity());
                this.iTB.flip();
                allocate.put(this.iTB);
                allocate.put(aOq);
                this.iTB = allocate;
            } else {
                this.iTB.put(aOq);
            }
            this.iTB.rewind();
            aOq.reset();
        }
        this.iTz = dVar.aOr();
        AppMethodBeat.o(73264);
    }

    public String toString() {
        AppMethodBeat.i(73265);
        String str = "Framedata{ optcode:" + this.iTA + ", fin:" + this.iTz + ", payloadlength:[pos:" + this.iTB.position() + ", len:" + this.iTB.remaining() + "], payload:" + Arrays.toString(b.Es(new String(this.iTB.array()))) + "}";
        AppMethodBeat.o(73265);
        return str;
    }
}
