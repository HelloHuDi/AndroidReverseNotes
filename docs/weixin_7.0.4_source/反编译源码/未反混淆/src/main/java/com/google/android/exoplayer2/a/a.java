package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.d;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

public final class a {
    private static final int[] aPs = new int[]{1, 2, 3, 6};
    private static final int[] aPt = new int[]{TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000};
    private static final int[] aPu = new int[]{24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000};
    private static final int[] aPv = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] aPw = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, az.CTRL_INDEX, 224, 256, 320, 384, FileUtils.S_IRWXU, 512, 576, 640};
    private static final int[] aPx = new int[]{69, 87, 104, 121, com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX, ErrorCode.NEEDDOWNLOAD_FALSE_4, 208, 243, d.MIC_PTU_TRANS_XINGYE, com.tencent.mm.plugin.appbrand.jsapi.i.f.a.CTRL_INDEX, 417, 487, JsApiGetLabInfo.CTRL_INDEX, 696, 835, 975, FaceManager.FACE_ACQUIRED_RIGHT, 1253, 1393};

    public static final class a {
        public final int aOn;
        public final int aPy;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;

        /* synthetic */ a(String str, int i, int i2, int i3, int i4, byte b) {
            this(str, i, i2, i3, i4);
        }

        private a(String str, int i, int i2, int i3, int i4) {
            this.mimeType = str;
            this.aOn = i;
            this.sampleRate = i2;
            this.aPy = i3;
            this.sampleCount = i4;
        }
    }

    public static Format a(l lVar, String str, String str2, DrmInitData drmInitData) {
        AppMethodBeat.i(94638);
        int i = aPt[(lVar.readUnsignedByte() & az.CTRL_INDEX) >> 6];
        int readUnsignedByte = lVar.readUnsignedByte();
        int i2 = aPv[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        Format a = Format.a(str, "audio/ac3", -1, -1, i2, i, null, drmInitData, str2);
        AppMethodBeat.o(94638);
        return a;
    }

    public static Format b(l lVar, String str, String str2, DrmInitData drmInitData) {
        AppMethodBeat.i(94639);
        lVar.eM(2);
        int i = aPt[(lVar.readUnsignedByte() & az.CTRL_INDEX) >> 6];
        int readUnsignedByte = lVar.readUnsignedByte();
        int i2 = aPv[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        Format a = Format.a(str, "audio/eac3", -1, -1, i2, i, null, drmInitData, str2);
        AppMethodBeat.o(94639);
        return a;
    }

    public static int j(byte[] bArr) {
        AppMethodBeat.i(94641);
        if (bArr.length < 5) {
            AppMethodBeat.o(94641);
            return -1;
        }
        int bc = bc((bArr[4] & az.CTRL_INDEX) >> 6, bArr[4] & 63);
        AppMethodBeat.o(94641);
        return bc;
    }

    public static int qj() {
        return 1536;
    }

    public static int f(ByteBuffer byteBuffer) {
        int i;
        AppMethodBeat.i(94642);
        if (((byteBuffer.get(byteBuffer.position() + 4) & az.CTRL_INDEX) >> 6) == 3) {
            i = 6;
        } else {
            i = aPs[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        i *= 256;
        AppMethodBeat.o(94642);
        return i;
    }

    private static int bc(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= aPt.length || i2 < 0 || i3 >= aPx.length) {
            return -1;
        }
        int i4 = aPt[i];
        if (i4 == 44100) {
            return (aPx[i3] + (i2 % 2)) * 2;
        }
        i3 = aPw[i3];
        if (i4 == 32000) {
            return i3 * 6;
        }
        return i3 * 4;
    }

    public static a a(k kVar) {
        int i;
        int ed;
        int i2;
        String str;
        int i3 = 1;
        AppMethodBeat.i(94640);
        int i4 = kVar.baG + (kVar.baF * 8);
        kVar.ee(40);
        if (kVar.ed(5) == 16) {
            i = 1;
        } else {
            byte i5 = (byte) 0;
        }
        kVar.setPosition(i4);
        String str2;
        if (i5 != 0) {
            str2 = "audio/eac3";
            kVar.ee(21);
            ed = (kVar.ed(11) + 1) * 2;
            i4 = kVar.ed(2);
            if (i4 == 3) {
                i4 = aPu[kVar.ed(2)];
                i5 = 6;
            } else {
                i5 = aPs[kVar.ed(2)];
                i4 = aPt[i4];
            }
            i2 = i5 * 256;
            i5 = kVar.ed(3);
            str = str2;
        } else {
            str2 = "audio/ac3";
            kVar.ee(32);
            i4 = kVar.ed(2);
            ed = bc(i4, kVar.ed(6));
            kVar.ee(8);
            i5 = kVar.ed(3);
            if (!((i5 & 1) == 0 || i5 == 1)) {
                kVar.ee(2);
            }
            if ((i5 & 4) != 0) {
                kVar.ee(2);
            }
            if (i5 == 2) {
                kVar.ee(2);
            }
            i4 = aPt[i4];
            i2 = 1536;
            str = str2;
        }
        boolean rl = kVar.rl();
        i5 = aPv[i5];
        if (!rl) {
            i3 = 0;
        }
        a aVar = new a(str, i3 + i5, i4, ed, i2, (byte) 0);
        AppMethodBeat.o(94640);
        return aVar;
    }
}
