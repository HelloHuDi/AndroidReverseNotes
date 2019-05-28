package com.google.android.exoplayer2.p111i;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.C31128d;

/* renamed from: com.google.android.exoplayer2.i.c */
public final class C32062c {
    private static final byte[] bqY = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    private static final int[] bqZ = new int[]{96000, 88200, 64000, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000, 24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};
    private static final int[] bra = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* renamed from: q */
    public static Pair<Integer, Integer> m52121q(byte[] bArr) {
        AppMethodBeat.m2504i(95864);
        C32064k c32064k = new C32064k(bArr);
        int c = C32062c.m52118c(c32064k);
        int d = C32062c.m52119d(c32064k);
        int ed = c32064k.mo52354ed(4);
        if (c == 5 || c == 29) {
            d = C32062c.m52119d(c32064k);
            if (C32062c.m52118c(c32064k) == 22) {
                ed = c32064k.mo52354ed(4);
            }
        }
        int i = bra[ed];
        C45039a.checkArgument(i != -1);
        Pair create = Pair.create(Integer.valueOf(d), Integer.valueOf(i));
        AppMethodBeat.m2505o(95864);
        return create;
    }

    /* renamed from: t */
    public static byte[] m52122t(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & C31128d.MIC_PTU_ZIPAI_THURSDAY) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    /* renamed from: j */
    public static byte[] m52120j(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95865);
        byte[] bArr2 = new byte[(bqY.length + i2)];
        System.arraycopy(bqY, 0, bArr2, 0, bqY.length);
        System.arraycopy(bArr, i, bArr2, bqY.length, i2);
        AppMethodBeat.m2505o(95865);
        return bArr2;
    }

    /* renamed from: c */
    private static int m52118c(C32064k c32064k) {
        AppMethodBeat.m2504i(95866);
        int ed = c32064k.mo52354ed(5);
        if (ed == 31) {
            ed = c32064k.mo52354ed(6) + 32;
        }
        AppMethodBeat.m2505o(95866);
        return ed;
    }

    /* renamed from: d */
    private static int m52119d(C32064k c32064k) {
        int ed;
        AppMethodBeat.m2504i(95867);
        int ed2 = c32064k.mo52354ed(4);
        if (ed2 == 15) {
            ed = c32064k.mo52354ed(24);
        } else {
            C45039a.checkArgument(ed2 < 13);
            ed = bqZ[ed2];
        }
        AppMethodBeat.m2505o(95867);
        return ed;
    }
}
