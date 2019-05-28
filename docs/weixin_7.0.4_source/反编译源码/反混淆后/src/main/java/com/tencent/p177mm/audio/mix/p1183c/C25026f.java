package com.tencent.p177mm.audio.mix.p1183c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C41782a;
import com.tencent.p177mm.audio.mix.p197h.C45174b;

/* renamed from: com.tencent.mm.audio.mix.c.f */
public final class C25026f extends C24655c {
    public C25026f(String str, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = 0;
        AppMethodBeat.m2504i(137032);
        C45174b.m83210i("MicroMsg.Mix.AudioVariableConvertProcess", "AudioVariableConvertProcess src:%s, srcSampleRate:%d, srcChannels:%d, srcBitDepth:%d, desSampleRate:%d, desChannels:%d, desBitDepth:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        this.cle = str;
        this.clf = C41782a.m73753eh(str);
        C41774b.m73738Dq();
        if (i4 <= 0) {
            i7 = 0;
        } else {
            i7 = 1;
        }
        if (i7 != 0) {
            this.ckY = i4;
        }
        if (i5 <= 0) {
            i7 = 0;
        } else {
            i7 = 1;
        }
        if (i7 != 0) {
            this.ckZ = i5;
        }
        if (i4 > 0) {
            i8 = 1;
        }
        if (i8 != 0) {
            this.cla = i6;
        }
        mo33486C(i, i2, i3);
        AppMethodBeat.m2505o(137032);
    }
}
