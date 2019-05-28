package com.google.android.exoplayer2.p099a;

import android.support.p057v4.widget.C8415j;
import com.google.android.exoplayer2.p099a.C8640d.C8641a;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.google.android.exoplayer2.a.j */
final class C25511j implements C8640d {
    private int aOn = -1;
    private ByteBuffer aQL = aPG;
    private int aRj = -1;
    private boolean aRm;
    private ByteBuffer buffer = aPG;
    private int encoding = 0;

    /* renamed from: r */
    public final boolean mo19136r(int i, int i2, int i3) {
        AppMethodBeat.m2504i(94719);
        if (i3 != 3 && i3 != 2 && i3 != C8415j.INVALID_ID && i3 != ErrorDialogData.SUPPRESSED) {
            C8641a c8641a = new C8641a(i, i2, i3);
            AppMethodBeat.m2505o(94719);
            throw c8641a;
        } else if (this.aRj == i && this.aOn == i2 && this.encoding == i3) {
            AppMethodBeat.m2505o(94719);
            return false;
        } else {
            this.aRj = i;
            this.aOn = i2;
            this.encoding = i3;
            if (i3 == 2) {
                this.buffer = aPG;
            }
            AppMethodBeat.m2505o(94719);
            return true;
        }
    }

    public final boolean isActive() {
        return (this.encoding == 0 || this.encoding == 2) ? false : true;
    }

    /* renamed from: qk */
    public final int mo19133qk() {
        return this.aOn;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public final void mo19130g(ByteBuffer byteBuffer) {
        IllegalStateException illegalStateException;
        AppMethodBeat.m2504i(94720);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        switch (this.encoding) {
            case C8415j.INVALID_ID /*-2147483648*/:
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
                AppMethodBeat.m2505o(94720);
                throw illegalStateException;
        }
        if (this.buffer.capacity() < i) {
            this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        switch (this.encoding) {
            case C8415j.INVALID_ID /*-2147483648*/:
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
                AppMethodBeat.m2505o(94720);
                throw illegalStateException;
        }
        byteBuffer.position(byteBuffer.limit());
        this.buffer.flip();
        this.aQL = this.buffer;
        AppMethodBeat.m2505o(94720);
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
        AppMethodBeat.m2504i(94721);
        flush();
        this.buffer = aPG;
        this.aRj = -1;
        this.aOn = -1;
        this.encoding = 0;
        AppMethodBeat.m2505o(94721);
    }
}
