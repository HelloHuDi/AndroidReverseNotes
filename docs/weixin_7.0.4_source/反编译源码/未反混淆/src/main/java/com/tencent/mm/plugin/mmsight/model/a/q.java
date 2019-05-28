package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class q extends r {
    protected int eTa = -1;

    public q(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i, i2, i3, i4, i5, i6, i7, z);
    }

    public final int ew(int i, int i2) {
        AppMethodBeat.i(76667);
        this.eTa = i;
        int ew = super.ew(i, i2);
        AppMethodBeat.o(76667);
        return ew;
    }

    /* Access modifiers changed, original: protected|final */
    public final void g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(76668);
        if (this.eTa >= 0 && byteBuffer != null && bufferInfo != null && bufferInfo.size == byteBuffer.limit() - byteBuffer.position()) {
            long yz = bo.yz();
            SightVideoJNI.writeH264DataLock(this.eTa, byteBuffer, bufferInfo.size);
            ab.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeH264Data used %sms, size: %s %s", Long.valueOf(bo.az(yz)), Integer.valueOf(bufferInfo.size), Integer.valueOf(byteBuffer.capacity()));
        }
        AppMethodBeat.o(76668);
    }

    public final void clear() {
        AppMethodBeat.i(76669);
        super.clear();
        SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
        AppMethodBeat.o(76669);
    }
}
