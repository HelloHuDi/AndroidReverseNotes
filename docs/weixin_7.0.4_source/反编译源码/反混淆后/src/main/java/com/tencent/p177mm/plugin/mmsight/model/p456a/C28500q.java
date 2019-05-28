package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;

@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.mmsight.model.a.q */
public final class C28500q extends C39378r {
    protected int eTa = -1;

    public C28500q(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i, i2, i3, i4, i5, i6, i7, z);
    }

    /* renamed from: ew */
    public final int mo46466ew(int i, int i2) {
        AppMethodBeat.m2504i(76667);
        this.eTa = i;
        int ew = super.mo46466ew(i, i2);
        AppMethodBeat.m2505o(76667);
        return ew;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: g */
    public final void mo46467g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(76668);
        if (this.eTa >= 0 && byteBuffer != null && bufferInfo != null && bufferInfo.size == byteBuffer.limit() - byteBuffer.position()) {
            long yz = C5046bo.m7588yz();
            SightVideoJNI.writeH264DataLock(this.eTa, byteBuffer, bufferInfo.size);
            C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeH264Data used %sms, size: %s %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(bufferInfo.size), Integer.valueOf(byteBuffer.capacity()));
        }
        AppMethodBeat.m2505o(76668);
    }

    public final void clear() {
        AppMethodBeat.m2504i(76669);
        super.clear();
        SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
        AppMethodBeat.m2505o(76669);
    }
}
