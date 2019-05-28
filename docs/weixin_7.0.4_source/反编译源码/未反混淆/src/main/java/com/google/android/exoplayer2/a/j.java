package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d.a;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class j implements d {
    private int aOn = -1;
    private ByteBuffer aQL = aPG;
    private int aRj = -1;
    private boolean aRm;
    private ByteBuffer buffer = aPG;
    private int encoding = 0;

    public final boolean r(int i, int i2, int i3) {
        AppMethodBeat.i(94719);
        if (i3 != 3 && i3 != 2 && i3 != android.support.v4.widget.j.INVALID_ID && i3 != ErrorDialogData.SUPPRESSED) {
            a aVar = new a(i, i2, i3);
            AppMethodBeat.o(94719);
            throw aVar;
        } else if (this.aRj == i && this.aOn == i2 && this.encoding == i3) {
            AppMethodBeat.o(94719);
            return false;
        } else {
            this.aRj = i;
            this.aOn = i2;
            this.encoding = i3;
            if (i3 == 2) {
                this.buffer = aPG;
            }
            AppMethodBeat.o(94719);
            return true;
        }
    }

    public final boolean isActive() {
        return (this.encoding == 0 || this.encoding == 2) ? false : true;
    }

    public final int qk() {
        return this.aOn;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(ByteBuffer byteBuffer) {
        IllegalStateException illegalStateException;
        AppMethodBeat.i(94720);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        switch (this.encoding) {
            case android.support.v4.widget.j.INVALID_ID /*-2147483648*/:
                i = (i / 3) * 2;
                break;
            case 3:
                i *= 2;
                break;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                i /= 2;
                break;
            default:
                illegalStateException = new IllegalStateException();
                AppMethodBeat.o(94720);
                throw illegalStateException;
        }
        if (this.buffer.capacity() < i) {
            this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        switch (this.encoding) {
            case android.support.v4.widget.j.INVALID_ID /*-2147483648*/:
                while (position < limit) {
                    this.buffer.put(byteBuffer.get(position + 1));
                    this.buffer.put(byteBuffer.get(position + 2));
                    position += 3;
                }
                break;
            case 3:
                while (position < limit) {
                    this.buffer.put((byte) 0);
                    this.buffer.put((byte) ((byteBuffer.get(position) & 255) - 128));
                    position++;
                }
                break;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                for (i = position; i < limit; i += 4) {
                    this.buffer.put(byteBuffer.get(i + 2));
                    this.buffer.put(byteBuffer.get(i + 3));
                }
                break;
            default:
                illegalStateException = new IllegalStateException();
                AppMethodBeat.o(94720);
                throw illegalStateException;
        }
        byteBuffer.position(byteBuffer.limit());
        this.buffer.flip();
        this.aQL = this.buffer;
        AppMethodBeat.o(94720);
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
        AppMethodBeat.i(94721);
        flush();
        this.buffer = aPG;
        this.aRj = -1;
        this.aOn = -1;
        this.encoding = 0;
        AppMethodBeat.o(94721);
    }
}
