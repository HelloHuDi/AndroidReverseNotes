package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l implements d {
    private int aOn = -1;
    private ByteBuffer aQL = aPG;
    private k aRT;
    private ShortBuffer aRU = this.buffer.asShortBuffer();
    long aRV;
    long aRW;
    private int aRj = -1;
    private boolean aRm;
    private ByteBuffer buffer = aPG;
    float pitch = 1.0f;
    float speed = 1.0f;

    public l() {
        AppMethodBeat.i(94728);
        AppMethodBeat.o(94728);
    }

    public final boolean r(int i, int i2, int i3) {
        AppMethodBeat.i(94729);
        if (i3 != 2) {
            a aVar = new a(i, i2, i3);
            AppMethodBeat.o(94729);
            throw aVar;
        } else if (this.aRj == i && this.aOn == i2) {
            AppMethodBeat.o(94729);
            return false;
        } else {
            this.aRj = i;
            this.aOn = i2;
            AppMethodBeat.o(94729);
            return true;
        }
    }

    public final boolean isActive() {
        AppMethodBeat.i(94730);
        if (Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f) {
            AppMethodBeat.o(94730);
            return true;
        }
        AppMethodBeat.o(94730);
        return false;
    }

    public final int qk() {
        return this.aOn;
    }

    public final void g(ByteBuffer byteBuffer) {
        int remaining;
        AppMethodBeat.i(94731);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining2 = byteBuffer.remaining();
            this.aRV += (long) remaining2;
            k kVar = this.aRT;
            remaining = asShortBuffer.remaining() / kVar.aRy;
            int i = (kVar.aRy * remaining) * 2;
            kVar.dA(remaining);
            asShortBuffer.get(kVar.aRE, kVar.aRL * kVar.aRy, i / 2);
            kVar.aRL += remaining;
            kVar.qE();
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
            k kVar2 = this.aRT;
            ShortBuffer shortBuffer = this.aRU;
            remaining = Math.min(shortBuffer.remaining() / kVar2.aRy, kVar2.aRM);
            shortBuffer.put(kVar2.aRG, 0, kVar2.aRy * remaining);
            kVar2.aRM -= remaining;
            System.arraycopy(kVar2.aRG, remaining * kVar2.aRy, kVar2.aRG, 0, kVar2.aRy * kVar2.aRM);
            this.aRW += (long) i2;
            this.buffer.limit(i2);
            this.aQL = this.buffer;
        }
        AppMethodBeat.o(94731);
    }

    public final void ql() {
        AppMethodBeat.i(94732);
        k kVar = this.aRT;
        int i = kVar.aRL;
        int i2 = kVar.aRM + ((int) ((((((float) i) / (kVar.speed / kVar.pitch)) + ((float) kVar.aRN)) / kVar.pitch) + 0.5f));
        kVar.dA((kVar.aRB * 2) + i);
        for (int i3 = 0; i3 < (kVar.aRB * 2) * kVar.aRy; i3++) {
            kVar.aRE[(kVar.aRy * i) + i3] = (short) 0;
        }
        kVar.aRL += kVar.aRB * 2;
        kVar.qE();
        if (kVar.aRM > i2) {
            kVar.aRM = i2;
        }
        kVar.aRL = 0;
        kVar.aRO = 0;
        kVar.aRN = 0;
        this.aRm = true;
        AppMethodBeat.o(94732);
    }

    public final ByteBuffer qm() {
        ByteBuffer byteBuffer = this.aQL;
        this.aQL = aPG;
        return byteBuffer;
    }

    public final boolean qf() {
        return this.aRm && (this.aRT == null || this.aRT.aRM == 0);
    }

    public final void flush() {
        AppMethodBeat.i(94733);
        this.aRT = new k(this.aRj, this.aOn);
        this.aRT.speed = this.speed;
        this.aRT.pitch = this.pitch;
        this.aQL = aPG;
        this.aRV = 0;
        this.aRW = 0;
        this.aRm = false;
        AppMethodBeat.o(94733);
    }

    public final void reset() {
        AppMethodBeat.i(94734);
        this.aRT = null;
        this.buffer = aPG;
        this.aRU = this.buffer.asShortBuffer();
        this.aQL = aPG;
        this.aOn = -1;
        this.aRj = -1;
        this.aRV = 0;
        this.aRW = 0;
        this.aRm = false;
        AppMethodBeat.o(94734);
    }
}
