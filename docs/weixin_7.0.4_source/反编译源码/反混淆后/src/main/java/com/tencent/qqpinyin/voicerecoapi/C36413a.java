package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;

/* renamed from: com.tencent.qqpinyin.voicerecoapi.a */
public final class C36413a {
    public static int MAX_FRAME_SIZE = 2000;
    private int AqA = 0;
    public int AqB = 0;
    public TRSpeexNative AqC = new TRSpeexNative();
    private byte[] Aqy = null;
    public byte[] Aqz = null;

    public C36413a() {
        AppMethodBeat.m2504i(35432);
        AppMethodBeat.m2505o(35432);
    }

    public final int dPS() {
        AppMethodBeat.m2504i(35433);
        if (this.AqA != 0) {
            AppMethodBeat.m2505o(35433);
            return ZipJNI.UNZ_BADZIPFILE;
        }
        int nativeTRSpeexInit = this.AqC.nativeTRSpeexInit();
        if (nativeTRSpeexInit == -1) {
            AppMethodBeat.m2505o(35433);
            return nativeTRSpeexInit;
        }
        this.AqA = nativeTRSpeexInit;
        this.Aqy = new byte[(MAX_FRAME_SIZE * 10)];
        AppMethodBeat.m2505o(35433);
        return 0;
    }

    /* renamed from: Z */
    public final byte[] mo57384Z(byte[] bArr, int i) {
        AppMethodBeat.m2504i(35434);
        C16134b c16134b;
        if (this.AqA == 0) {
            c16134b = new C16134b(ZipJNI.UNZ_PARAMERROR);
            AppMethodBeat.m2505o(35434);
            throw c16134b;
        } else if (bArr == null || bArr.length == 0) {
            c16134b = new C16134b(ZipJNI.UNZ_INTERNALERROR);
            AppMethodBeat.m2505o(35434);
            throw c16134b;
        } else {
            int nativeTRSpeexEncode = this.AqC.nativeTRSpeexEncode(this.AqA, bArr, 0, i, this.Aqy);
            if (nativeTRSpeexEncode < 0) {
                c16134b = new C16134b(nativeTRSpeexEncode);
                AppMethodBeat.m2505o(35434);
                throw c16134b;
            } else if (nativeTRSpeexEncode == 0) {
                AppMethodBeat.m2505o(35434);
                return null;
            } else {
                byte[] bArr2 = new byte[nativeTRSpeexEncode];
                System.arraycopy(this.Aqy, 0, bArr2, 0, nativeTRSpeexEncode);
                AppMethodBeat.m2505o(35434);
                return bArr2;
            }
        }
    }

    public final int dPT() {
        AppMethodBeat.m2504i(35435);
        if (this.AqA == 0) {
            AppMethodBeat.m2505o(35435);
            return ZipJNI.UNZ_PARAMERROR;
        }
        this.Aqy = null;
        int nativeTRSpeexRelease = this.AqC.nativeTRSpeexRelease(this.AqA);
        this.AqA = 0;
        AppMethodBeat.m2505o(35435);
        return nativeTRSpeexRelease;
    }
}
