package com.google.android.exoplayer2.i;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.d;

public final class c {
    private static final byte[] bqY = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    private static final int[] bqZ = new int[]{96000, 88200, 64000, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000, 24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};
    private static final int[] bra = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> q(byte[] bArr) {
        AppMethodBeat.i(95864);
        k kVar = new k(bArr);
        int c = c(kVar);
        int d = d(kVar);
        int ed = kVar.ed(4);
        if (c == 5 || c == 29) {
            d = d(kVar);
            if (c(kVar) == 22) {
                ed = kVar.ed(4);
            }
        }
        int i = bra[ed];
        a.checkArgument(i != -1);
        Pair create = Pair.create(Integer.valueOf(d), Integer.valueOf(i));
        AppMethodBeat.o(95864);
        return create;
    }

    public static byte[] t(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & d.MIC_PTU_ZIPAI_THURSDAY) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] j(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95865);
        byte[] bArr2 = new byte[(bqY.length + i2)];
        System.arraycopy(bqY, 0, bArr2, 0, bqY.length);
        System.arraycopy(bArr, i, bArr2, bqY.length, i2);
        AppMethodBeat.o(95865);
        return bArr2;
    }

    private static int c(k kVar) {
        AppMethodBeat.i(95866);
        int ed = kVar.ed(5);
        if (ed == 31) {
            ed = kVar.ed(6) + 32;
        }
        AppMethodBeat.o(95866);
        return ed;
    }

    private static int d(k kVar) {
        int ed;
        AppMethodBeat.i(95867);
        int ed2 = kVar.ed(4);
        if (ed2 == 15) {
            ed = kVar.ed(24);
        } else {
            a.checkArgument(ed2 < 13);
            ed = bqZ[ed2];
        }
        AppMethodBeat.o(95867);
        return ed;
    }
}
