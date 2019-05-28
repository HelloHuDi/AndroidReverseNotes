package com.tencent.p177mm.audio.p1457c;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C18171e;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.audio.c.a */
public final class C32313a {
    /* renamed from: a */
    public static AudioTrack m52809a(boolean z, int i, int i2, int i3) {
        AudioTrack c18171e;
        int i4 = 3;
        AppMethodBeat.m2504i(55761);
        int i5 = z ? 3 : 0;
        if (C1427q.etd.epG) {
            C1427q.etd.dump();
            if (z && C1427q.etd.eqj >= 0) {
                i5 = C1427q.etd.eqj;
            } else if (!z && C1427q.etd.eqk >= 0) {
                i5 = C1427q.etd.eqk;
            }
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, 2);
        C4990ab.m7417i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", Boolean.valueOf(z), Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(minBufferSize), Integer.valueOf(i3));
        AudioTrack c18171e2 = new C18171e(i5, i, i2, i3 * minBufferSize);
        if (c18171e2.getState() == 0) {
            c18171e2.release();
            C4990ab.m7416i("AudioDeviceFactory", "reconstruct AudioTrack");
            if (i5 != 0) {
                i4 = 0;
            }
            c18171e = new C18171e(i4, i, i2, i3 * minBufferSize);
        } else {
            c18171e = c18171e2;
        }
        C4990ab.m7416i("AudioDeviceFactory", "AudioTrack state: " + c18171e.getState());
        AppMethodBeat.m2505o(55761);
        return c18171e;
    }
}
