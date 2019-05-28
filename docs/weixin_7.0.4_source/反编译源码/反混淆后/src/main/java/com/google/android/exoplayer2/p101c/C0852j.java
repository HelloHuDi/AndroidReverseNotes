package com.google.android.exoplayer2.p101c;

import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33381d;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.C31128d;
import com.tencent.wcdb.FileUtils;

/* renamed from: com.google.android.exoplayer2.c.j */
public final class C0852j {
    private static final String[] aST = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] aSU = new int[]{TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_32000};
    private static final int[] aSV = new int[]{32, 64, 96, 128, 160, C33250az.CTRL_INDEX, 224, 256, C31128d.MIC_PTU_YOUJIALI, 320, C33381d.CTRL_INDEX, 384, 416, FileUtils.S_IRWXU};
    private static final int[] aSW = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 144, 160, ErrorCode.NEEDDOWNLOAD_FALSE_6, C33250az.CTRL_INDEX, 224, 256};
    private static final int[] aSX = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, C33250az.CTRL_INDEX, 224, 256, 320, 384};
    private static final int[] aSY = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, C33250az.CTRL_INDEX, 224, 256, 320};
    private static final int[] aSZ = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    public int aPy;
    public int aTa;
    public int bitrate;
    public int channels;
    public String mimeType;
    public int sampleRate;
    public int version;

    /* renamed from: dN */
    public static int m1953dN(int i) {
        if ((i & -2097152) != -2097152) {
            return -1;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return -1;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 == 0 || i4 == 15) {
            return -1;
        }
        int i5 = (i >>> 10) & 3;
        if (i5 == 3) {
            return -1;
        }
        int i6 = aSU[i5];
        if (i2 == 2) {
            i5 = i6 / 2;
        } else if (i2 == 0) {
            i5 = i6 / 4;
        } else {
            i5 = i6;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? aSV[i4 - 1] : aSW[i4 - 1]) * 12000) / i5) + i7) * 4;
        }
        if (i2 == 3) {
            i4 = i3 == 2 ? aSX[i4 - 1] : aSY[i4 - 1];
        } else {
            i4 = aSZ[i4 - 1];
        }
        if (i2 == 3) {
            return ((144000 * i4) / i5) + i7;
        }
        return (((i3 == 1 ? 72000 : 144000) * i4) / i5) + i7;
    }

    /* renamed from: a */
    public static boolean m1952a(int i, C0852j c0852j) {
        if ((i & -2097152) != -2097152) {
            return false;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return false;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return false;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 == 0 || i4 == 15) {
            return false;
        }
        int i5 = (i >>> 10) & 3;
        if (i5 == 3) {
            return false;
        }
        int i6;
        int i7;
        int i8 = aSU[i5];
        if (i2 == 2) {
            i6 = i8 / 2;
        } else if (i2 == 0) {
            i6 = i8 / 4;
        } else {
            i6 = i8;
        }
        int i9 = (i >>> 9) & 1;
        if (i3 == 3) {
            i8 = i2 == 3 ? aSV[i4 - 1] : aSW[i4 - 1];
            i4 = (((i8 * 12000) / i6) + i9) * 4;
            i7 = 384;
            i5 = i8;
        } else {
            int i10;
            if (i2 == 3) {
                i8 = i3 == 2 ? aSX[i4 - 1] : aSY[i4 - 1];
                i4 = 1152;
                i5 = i8;
            } else {
                i5 = aSZ[i4 - 1];
                i8 = i3 == 1 ? 576 : 1152;
                if (i3 == 1) {
                    i10 = 72000;
                    i7 = i8;
                    i4 = ((i10 * i5) / i6) + i9;
                } else {
                    i4 = i8;
                }
            }
            i10 = 144000;
            i7 = i4;
            i4 = ((i10 * i5) / i6) + i9;
        }
        String str = aST[3 - i3];
        if (((i >> 6) & 3) == 3) {
            i8 = 1;
        } else {
            i8 = 2;
        }
        i5 *= 1000;
        c0852j.version = i2;
        c0852j.mimeType = str;
        c0852j.aPy = i4;
        c0852j.sampleRate = i6;
        c0852j.channels = i8;
        c0852j.bitrate = i5;
        c0852j.aTa = i7;
        return true;
    }
}
