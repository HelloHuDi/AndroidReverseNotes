package com.google.android.exoplayer2.p099a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p111i.C32064k;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45604f.C10436a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.C31128d;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.a.a */
public final class C32018a {
    private static final int[] aPs = new int[]{1, 2, 3, 6};
    private static final int[] aPt = new int[]{TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000};
    private static final int[] aPu = new int[]{24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000};
    private static final int[] aPv = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] aPw = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, C33250az.CTRL_INDEX, 224, 256, 320, 384, FileUtils.S_IRWXU, 512, 576, 640};
    private static final int[] aPx = new int[]{69, 87, 104, 121, C33333a.CTRL_INDEX, ErrorCode.NEEDDOWNLOAD_FALSE_4, 208, 243, C31128d.MIC_PTU_TRANS_XINGYE, C10436a.CTRL_INDEX, 417, 487, JsApiGetLabInfo.CTRL_INDEX, 696, 835, 975, FaceManager.FACE_ACQUIRED_RIGHT, 1253, 1393};

    /* renamed from: com.google.android.exoplayer2.a.a$a */
    public static final class C8638a {
        public final int aOn;
        public final int aPy;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;

        /* synthetic */ C8638a(String str, int i, int i2, int i3, int i4, byte b) {
            this(str, i, i2, i3, i4);
        }

        private C8638a(String str, int i, int i2, int i3, int i4) {
            this.mimeType = str;
            this.aOn = i;
            this.sampleRate = i2;
            this.aPy = i3;
            this.sampleCount = i4;
        }
    }

    /* renamed from: a */
    public static Format m51989a(C32065l c32065l, String str, String str2, DrmInitData drmInitData) {
        AppMethodBeat.m2504i(94638);
        int i = aPt[(c32065l.readUnsignedByte() & C33250az.CTRL_INDEX) >> 6];
        int readUnsignedByte = c32065l.readUnsignedByte();
        int i2 = aPv[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        Format a = Format.m15271a(str, "audio/ac3", -1, -1, i2, i, null, drmInitData, str2);
        AppMethodBeat.m2505o(94638);
        return a;
    }

    /* renamed from: b */
    public static Format m51991b(C32065l c32065l, String str, String str2, DrmInitData drmInitData) {
        AppMethodBeat.m2504i(94639);
        c32065l.mo52369eM(2);
        int i = aPt[(c32065l.readUnsignedByte() & C33250az.CTRL_INDEX) >> 6];
        int readUnsignedByte = c32065l.readUnsignedByte();
        int i2 = aPv[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        Format a = Format.m15271a(str, "audio/eac3", -1, -1, i2, i, null, drmInitData, str2);
        AppMethodBeat.m2505o(94639);
        return a;
    }

    /* renamed from: j */
    public static int m51994j(byte[] bArr) {
        AppMethodBeat.m2504i(94641);
        if (bArr.length < 5) {
            AppMethodBeat.m2505o(94641);
            return -1;
        }
        int bc = C32018a.m51992bc((bArr[4] & C33250az.CTRL_INDEX) >> 6, bArr[4] & 63);
        AppMethodBeat.m2505o(94641);
        return bc;
    }

    /* renamed from: qj */
    public static int m51995qj() {
        return 1536;
    }

    /* renamed from: f */
    public static int m51993f(ByteBuffer byteBuffer) {
        int i;
        AppMethodBeat.m2504i(94642);
        if (((byteBuffer.get(byteBuffer.position() + 4) & C33250az.CTRL_INDEX) >> 6) == 3) {
            i = 6;
        } else {
            i = aPs[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        i *= 256;
        AppMethodBeat.m2505o(94642);
        return i;
    }

    /* renamed from: bc */
    private static int m51992bc(int i, int i2) {
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

    /* renamed from: a */
    public static C8638a m51990a(C32064k c32064k) {
        int i;
        int ed;
        int i2;
        String str;
        int i3 = 1;
        AppMethodBeat.m2504i(94640);
        int i4 = c32064k.baG + (c32064k.baF * 8);
        c32064k.mo52355ee(40);
        if (c32064k.mo52354ed(5) == 16) {
            i = 1;
        } else {
            byte i5 = (byte) 0;
        }
        c32064k.setPosition(i4);
        String str2;
        if (i5 != 0) {
            str2 = "audio/eac3";
            c32064k.mo52355ee(21);
            ed = (c32064k.mo52354ed(11) + 1) * 2;
            i4 = c32064k.mo52354ed(2);
            if (i4 == 3) {
                i4 = aPu[c32064k.mo52354ed(2)];
                i5 = 6;
            } else {
                i5 = aPs[c32064k.mo52354ed(2)];
                i4 = aPt[i4];
            }
            i2 = i5 * 256;
            i5 = c32064k.mo52354ed(3);
            str = str2;
        } else {
            str2 = "audio/ac3";
            c32064k.mo52355ee(32);
            i4 = c32064k.mo52354ed(2);
            ed = C32018a.m51992bc(i4, c32064k.mo52354ed(6));
            c32064k.mo52355ee(8);
            i5 = c32064k.mo52354ed(3);
            if (!((i5 & 1) == 0 || i5 == 1)) {
                c32064k.mo52355ee(2);
            }
            if ((i5 & 4) != 0) {
                c32064k.mo52355ee(2);
            }
            if (i5 == 2) {
                c32064k.mo52355ee(2);
            }
            i4 = aPt[i4];
            i2 = 1536;
            str = str2;
        }
        boolean rl = c32064k.mo52358rl();
        i5 = aPv[i5];
        if (!rl) {
            i3 = 0;
        }
        C8638a c8638a = new C8638a(str, i3 + i5, i4, ed, i2, (byte) 0);
        AppMethodBeat.m2505o(94640);
        return c8638a;
    }
}
