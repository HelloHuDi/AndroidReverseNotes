package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class g extends h {
    private int eTa = -1;

    public g(int i, int i2) {
        super(i, i2);
    }

    public final int q(int i, String str) {
        AppMethodBeat.i(76571);
        this.eTa = i;
        int q = super.q(i, str);
        AppMethodBeat.o(76571);
        return q;
    }

    /* Access modifiers changed, original: protected|final */
    public final void g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(76572);
        if (!(this.eTa < 0 || byteBuffer == null || bufferInfo == null || this.ovY)) {
            SightVideoJNI.writeAACDataLock(this.eTa, byteBuffer, bufferInfo.size);
        }
        AppMethodBeat.o(76572);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean WF() {
        return true;
    }
}
