package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g implements d {
    private int aOn = -1;
    private ByteBuffer aQL = aPG;
    private int aRj = -1;
    int[] aRk;
    private int[] aRl;
    private boolean aRm;
    private boolean active;
    private ByteBuffer buffer = aPG;

    public final boolean r(int i, int i2, int i3) {
        AppMethodBeat.i(94691);
        boolean z = !Arrays.equals(this.aRk, this.aRl);
        this.aRl = this.aRk;
        a aVar;
        if (this.aRl == null) {
            this.active = false;
            AppMethodBeat.o(94691);
            return z;
        } else if (i3 != 2) {
            aVar = new a(i, i2, i3);
            AppMethodBeat.o(94691);
            throw aVar;
        } else if (!z && this.aRj == i && this.aOn == i2) {
            AppMethodBeat.o(94691);
            return false;
        } else {
            this.aRj = i;
            this.aOn = i2;
            if (i2 != this.aRl.length) {
                z = true;
            } else {
                z = false;
            }
            this.active = z;
            int i4 = 0;
            while (i4 < this.aRl.length) {
                int i5 = this.aRl[i4];
                if (i5 >= i2) {
                    aVar = new a(i, i2, i3);
                    AppMethodBeat.o(94691);
                    throw aVar;
                }
                this.active = (i5 != i4 ? 1 : 0) | this.active;
                i4++;
            }
            AppMethodBeat.o(94691);
            return true;
        }
    }

    public final boolean isActive() {
        return this.active;
    }

    public final int qk() {
        return this.aRl == null ? this.aOn : this.aRl.length;
    }

    public final void g(ByteBuffer byteBuffer) {
        AppMethodBeat.i(94692);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.aOn * 2)) * this.aRl.length) * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        while (position < limit) {
            for (int i : this.aRl) {
                this.buffer.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.aOn * 2;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.aQL = this.buffer;
        AppMethodBeat.o(94692);
    }

    public final void ql() {
        this.aRm = true;
    }

    public final ByteBuffer qm() {
        ByteBuffer byteBuffer = this.aQL;
        this.aQL = aPG;
        return byteBuffer;
    }

    public final boolean qf() {
        return this.aRm && this.aQL == aPG;
    }

    public final void flush() {
        this.aQL = aPG;
        this.aRm = false;
    }

    public final void reset() {
        AppMethodBeat.i(94693);
        flush();
        this.buffer = aPG;
        this.aOn = -1;
        this.aRj = -1;
        this.aRl = null;
        this.active = false;
        AppMethodBeat.o(94693);
    }
}
