package com.google.android.exoplayer2.p099a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p111i.C32064k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.a.h */
public final class C45019h {
    private static final int[] aRn = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] aRo = new int[]{-1, TXRecordCommon.AUDIO_SAMPLERATE_8000, TXRecordCommon.AUDIO_SAMPLERATE_16000, TXRecordCommon.AUDIO_SAMPLERATE_32000, -1, -1, 11025, 22050, TXRecordCommon.AUDIO_SAMPLERATE_44100, -1, -1, 12000, 24000, TXRecordCommon.AUDIO_SAMPLERATE_48000, -1, -1};
    private static final int[] aRp = new int[]{64, 112, 128, C33250az.CTRL_INDEX, 224, 256, 384, FileUtils.S_IRWXU, 512, 640, 768, 896, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 1152, ActUtil.HEIGHT, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* renamed from: a */
    public static Format m82474a(byte[] bArr, String str, String str2) {
        AppMethodBeat.m2504i(94694);
        C32064k c32064k = new C32064k(bArr);
        c32064k.mo52355ee(60);
        int i = aRn[c32064k.mo52354ed(6)];
        int i2 = aRo[c32064k.mo52354ed(4)];
        int ed = c32064k.mo52354ed(5);
        ed = ed >= aRp.length ? -1 : (aRp[ed] * 1000) / 2;
        c32064k.mo52355ee(10);
        Format a = Format.m15271a(str, "audio/vnd.dts", ed, -1, i + (c32064k.mo52354ed(2) > 0 ? 1 : 0), i2, null, null, str2);
        AppMethodBeat.m2505o(94694);
        return a;
    }

    /* renamed from: k */
    public static int m82476k(byte[] bArr) {
        return ((((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2)) + 1) * 32;
    }

    /* renamed from: h */
    public static int m82475h(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(94695);
        int position = byteBuffer.position();
        position = ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
        AppMethodBeat.m2505o(94695);
        return position;
    }

    /* renamed from: l */
    public static int m82477l(byte[] bArr) {
        return ((((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) | ((bArr[7] & 240) >> 4)) + 1;
    }
}
