package com.tencent.p177mm.plugin.appbrand.p332t.p1232d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d.C33534a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1539f.C42690b;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.appbrand.t.d.e */
public class C41253e implements C38513c {
    protected static byte[] iTy = new byte[0];
    protected C33534a iTA;
    private ByteBuffer iTB;
    protected boolean iTC;
    protected boolean iTz;

    public C41253e(C33534a c33534a) {
        AppMethodBeat.m2504i(73262);
        this.iTA = c33534a;
        this.iTB = ByteBuffer.wrap(iTy);
        AppMethodBeat.m2505o(73262);
    }

    public C41253e(C33533d c33533d) {
        AppMethodBeat.m2504i(73263);
        this.iTz = c33533d.aOr();
        this.iTA = c33533d.aOt();
        this.iTB = c33533d.aOq();
        this.iTC = c33533d.aOs();
        AppMethodBeat.m2505o(73263);
    }

    public final boolean aOr() {
        return this.iTz;
    }

    public final C33534a aOt() {
        return this.iTA;
    }

    public final boolean aOs() {
        return this.iTC;
    }

    public ByteBuffer aOq() {
        return this.iTB;
    }

    /* renamed from: eM */
    public final void mo61235eM(boolean z) {
        this.iTz = z;
    }

    /* renamed from: a */
    public final void mo61234a(C33534a c33534a) {
        this.iTA = c33534a;
    }

    /* renamed from: A */
    public void mo44991A(ByteBuffer byteBuffer) {
        this.iTB = byteBuffer;
    }

    /* renamed from: eN */
    public final void mo61236eN(boolean z) {
        this.iTC = z;
    }

    /* renamed from: e */
    public final void mo54014e(C33533d c33533d) {
        AppMethodBeat.m2504i(73264);
        ByteBuffer aOq = c33533d.aOq();
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
        this.iTz = c33533d.aOr();
        AppMethodBeat.m2505o(73264);
    }

    public String toString() {
        AppMethodBeat.m2504i(73265);
        String str = "Framedata{ optcode:" + this.iTA + ", fin:" + this.iTz + ", payloadlength:[pos:" + this.iTB.position() + ", len:" + this.iTB.remaining() + "], payload:" + Arrays.toString(C42690b.m75608Es(new String(this.iTB.array()))) + "}";
        AppMethodBeat.m2505o(73265);
        return str;
    }
}
