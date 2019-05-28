package com.google.android.exoplayer2.p099a;

import com.google.android.exoplayer2.p099a.C8640d.C8641a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* renamed from: com.google.android.exoplayer2.a.l */
public final class C25512l implements C8640d {
    private int aOn = -1;
    private ByteBuffer aQL = aPG;
    private C8642k aRT;
    private ShortBuffer aRU = this.buffer.asShortBuffer();
    long aRV;
    long aRW;
    private int aRj = -1;
    private boolean aRm;
    private ByteBuffer buffer = aPG;
    float pitch = 1.0f;
    float speed = 1.0f;

    public C25512l() {
        AppMethodBeat.m2504i(94728);
        AppMethodBeat.m2505o(94728);
    }

    /* renamed from: r */
    public final boolean mo19136r(int i, int i2, int i3) {
        AppMethodBeat.m2504i(94729);
        if (i3 != 2) {
            C8641a c8641a = new C8641a(i, i2, i3);
            AppMethodBeat.m2505o(94729);
            throw c8641a;
        } else if (this.aRj == i && this.aOn == i2) {
            AppMethodBeat.m2505o(94729);
            return false;
        } else {
            this.aRj = i;
            this.aOn = i2;
            AppMethodBeat.m2505o(94729);
            return true;
        }
    }

    public final boolean isActive() {
        AppMethodBeat.m2504i(94730);
        if (Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f) {
            AppMethodBeat.m2505o(94730);
            return true;
        }
        AppMethodBeat.m2505o(94730);
        return false;
    }

    /* renamed from: qk */
    public final int mo19133qk() {
        return this.aOn;
    }

    /* renamed from: g */
    public final void mo19130g(ByteBuffer byteBuffer) {
        int remaining;
        AppMethodBeat.m2504i(94731);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining2 = byteBuffer.remaining();
            this.aRV += (long) remaining2;
            C8642k c8642k = this.aRT;
            remaining = asShortBuffer.remaining() / c8642k.aRy;
            int i = (c8642k.aRy * remaining) * 2;
            c8642k.mo19138dA(remaining);
            asShortBuffer.get(c8642k.aRE, c8642k.aRL * c8642k.aRy, i / 2);
            c8642k.aRL += remaining;
            c8642k.mo19139qE();
            byteBuffer.position(byteBuffer.position() + remaining2);
        }
        int i2 = (this.aRT.aRM * this.aOn) * 2;
        if (i2 > 0) {
            if (this.buffer.capacity() < i2) {
                this.buffer = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
                this.aRU = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.aRU.clear();
            }
            C8642k c8642k2 = this.aRT;
            ShortBuffer shortBuffer = this.aRU;
            remaining = Math.min(shortBuffer.remaining() / c8642k2.aRy, c8642k2.aRM);
            shortBuffer.put(c8642k2.aRG, 0, c8642k2.aRy * remaining);
            c8642k2.aRM -= remaining;
            System.arraycopy(c8642k2.aRG, remaining * c8642k2.aRy, c8642k2.aRG, 0, c8642k2.aRy * c8642k2.aRM);
            this.aRW += (long) i2;
            this.buffer.limit(i2);
            this.aQL = this.buffer;
        }
        AppMethodBeat.m2505o(94731);
    }

    /* renamed from: ql */
    public final void mo19134ql() {
        AppMethodBeat.m2504i(94732);
        C8642k c8642k = this.aRT;
        int i = c8642k.aRL;
        int i2 = c8642k.aRM + ((int) ((((((float) i) / (c8642k.speed / c8642k.pitch)) + ((float) c8642k.aRN)) / c8642k.pitch) + 0.5f));
        c8642k.mo19138dA((c8642k.aRB * 2) + i);
        for (int i3 = 0; i3 < (c8642k.aRB * 2) * c8642k.aRy; i3++) {
            c8642k.aRE[(c8642k.aRy * i) + i3] = (short) 0;
        }
        c8642k.aRL += c8642k.aRB * 2;
        c8642k.mo19139qE();
        if (c8642k.aRM > i2) {
            c8642k.aRM = i2;
        }
        c8642k.aRL = 0;
        c8642k.aRO = 0;
        c8642k.aRN = 0;
        this.aRm = true;
        AppMethodBeat.m2505o(94732);
    }

    /* renamed from: qm */
    public final ByteBuffer mo19135qm() {
        ByteBuffer byteBuffer = this.aQL;
        this.aQL = aPG;
        return byteBuffer;
    }

    /* renamed from: qf */
    public final boolean mo19132qf() {
        return this.aRm && (this.aRT == null || this.aRT.aRM == 0);
    }

    public final void flush() {
        AppMethodBeat.m2504i(94733);
        this.aRT = new C8642k(this.aRj, this.aOn);
        this.aRT.speed = this.speed;
        this.aRT.pitch = this.pitch;
        this.aQL = aPG;
        this.aRV = 0;
        this.aRW = 0;
        this.aRm = false;
        AppMethodBeat.m2505o(94733);
    }

    public final void reset() {
        AppMethodBeat.m2504i(94734);
        this.aRT = null;
        this.buffer = aPG;
        this.aRU = this.buffer.asShortBuffer();
        this.aQL = aPG;
        this.aOn = -1;
        this.aRj = -1;
        this.aRV = 0;
        this.aRW = 0;
        this.aRm = false;
        AppMethodBeat.m2505o(94734);
    }
}
