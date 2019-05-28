package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;

@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.mmsight.model.a.g */
public final class C24797g extends C21294h {
    private int eTa = -1;

    public C24797g(int i, int i2) {
        super(i, i2);
    }

    /* renamed from: q */
    public final int mo20926q(int i, String str) {
        AppMethodBeat.m2504i(76571);
        this.eTa = i;
        int q = super.mo20926q(i, str);
        AppMethodBeat.m2505o(76571);
        return q;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: g */
    public final void mo20925g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(76572);
        if (!(this.eTa < 0 || byteBuffer == null || bufferInfo == null || this.ovY)) {
            SightVideoJNI.writeAACDataLock(this.eTa, byteBuffer, bufferInfo.size);
        }
        AppMethodBeat.m2505o(76572);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: WF */
    public final boolean mo20924WF() {
        return true;
    }
}
