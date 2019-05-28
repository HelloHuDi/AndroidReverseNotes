package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;

public final class a {
    public static int MAX_FRAME_SIZE = 2000;
    private int AqA = 0;
    public int AqB = 0;
    public TRSpeexNative AqC = new TRSpeexNative();
    private byte[] Aqy = null;
    public byte[] Aqz = null;

    public a() {
        AppMethodBeat.i(35432);
        AppMethodBeat.o(35432);
    }

    public final int dPS() {
        AppMethodBeat.i(35433);
        if (this.AqA != 0) {
            AppMethodBeat.o(35433);
            return ZipJNI.UNZ_BADZIPFILE;
        }
        int nativeTRSpeexInit = this.AqC.nativeTRSpeexInit();
        if (nativeTRSpeexInit == -1) {
            AppMethodBeat.o(35433);
            return nativeTRSpeexInit;
        }
        this.AqA = nativeTRSpeexInit;
        this.Aqy = new byte[(MAX_FRAME_SIZE * 10)];
        AppMethodBeat.o(35433);
        return 0;
    }

    public final byte[] Z(byte[] bArr, int i) {
        AppMethodBeat.i(35434);
        b bVar;
        if (this.AqA == 0) {
            bVar = new b(ZipJNI.UNZ_PARAMERROR);
            AppMethodBeat.o(35434);
            throw bVar;
        } else if (bArr == null || bArr.length == 0) {
            bVar = new b(ZipJNI.UNZ_INTERNALERROR);
            AppMethodBeat.o(35434);
            throw bVar;
        } else {
            int nativeTRSpeexEncode = this.AqC.nativeTRSpeexEncode(this.AqA, bArr, 0, i, this.Aqy);
            if (nativeTRSpeexEncode < 0) {
                bVar = new b(nativeTRSpeexEncode);
                AppMethodBeat.o(35434);
                throw bVar;
            } else if (nativeTRSpeexEncode == 0) {
                AppMethodBeat.o(35434);
                return null;
            } else {
                byte[] bArr2 = new byte[nativeTRSpeexEncode];
                System.arraycopy(this.Aqy, 0, bArr2, 0, nativeTRSpeexEncode);
                AppMethodBeat.o(35434);
                return bArr2;
            }
        }
    }

    public final int dPT() {
        AppMethodBeat.i(35435);
        if (this.AqA == 0) {
            AppMethodBeat.o(35435);
            return ZipJNI.UNZ_PARAMERROR;
        }
        this.Aqy = null;
        int nativeTRSpeexRelease = this.AqC.nativeTRSpeexRelease(this.AqA);
        this.AqA = 0;
        AppMethodBeat.o(35435);
        return nativeTRSpeexRelease;
    }
}
