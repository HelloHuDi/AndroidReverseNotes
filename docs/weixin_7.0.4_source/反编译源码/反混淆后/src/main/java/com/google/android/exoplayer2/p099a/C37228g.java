package com.google.android.exoplayer2.p099a;

import com.google.android.exoplayer2.p099a.C8640d.C8641a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.a.g */
final class C37228g implements C8640d {
    private int aOn = -1;
    private ByteBuffer aQL = aPG;
    private int aRj = -1;
    int[] aRk;
    private int[] aRl;
    private boolean aRm;
    private boolean active;
    private ByteBuffer buffer = aPG;

    /* renamed from: r */
    public final boolean mo19136r(int i, int i2, int i3) {
        AppMethodBeat.m2504i(94691);
        boolean z = !Arrays.equals(this.aRk, this.aRl);
        this.aRl = this.aRk;
        C8641a c8641a;
        if (this.aRl == null) {
            this.active = false;
            AppMethodBeat.m2505o(94691);
            return z;
        } else if (i3 != 2) {
            c8641a = new C8641a(i, i2, i3);
            AppMethodBeat.m2505o(94691);
            throw c8641a;
        } else if (!z && this.aRj == i && this.aOn == i2) {
            AppMethodBeat.m2505o(94691);
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
                    c8641a = new C8641a(i, i2, i3);
                    AppMethodBeat.m2505o(94691);
                    throw c8641a;
                }
                this.active = (i5 != i4 ? 1 : 0) | this.active;
                i4++;
            }
            AppMethodBeat.m2505o(94691);
            return true;
        }
    }

    public final boolean isActive() {
        return this.active;
    }

    /* renamed from: qk */
    public final int mo19133qk() {
        return this.aRl == null ? this.aOn : this.aRl.length;
    }

    /* renamed from: g */
    public final void mo19130g(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(94692);
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
        AppMethodBeat.m2505o(94692);
    }

    /* renamed from: ql */
    public final void mo19134ql() {
        this.aRm = true;
    }

    /* renamed from: qm */
    public final ByteBuffer mo19135qm() {
        ByteBuffer byteBuffer = this.aQL;
        this.aQL = aPG;
        return byteBuffer;
    }

    /* renamed from: qf */
    public final boolean mo19132qf() {
        return this.aRm && this.aQL == aPG;
    }

    public final void flush() {
        this.aQL = aPG;
        this.aRm = false;
    }

    public final void reset() {
        AppMethodBeat.m2504i(94693);
        flush();
        this.buffer = aPG;
        this.aOn = -1;
        this.aRj = -1;
        this.aRl = null;
        this.active = false;
        AppMethodBeat.m2505o(94693);
    }
}
