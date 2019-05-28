package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    private static boolean fNO = false;
    private long fNP = 0;
    private String fNQ;
    private long fNR = 0;
    private long mNativePtr = 0;

    public a(long j) {
        AppMethodBeat.i(93147);
        this.fNQ = String.valueOf(j);
        init();
        AppMethodBeat.o(93147);
    }

    public a(String str) {
        AppMethodBeat.i(93148);
        this.fNQ = str;
        init();
        AppMethodBeat.o(93148);
    }

    private void init() {
        AppMethodBeat.i(93149);
        ab.i("MicroMsg.EncEngine", "init  key  enckey " + this.fNQ + "  hashcode " + hashCode());
        this.mNativePtr = MMIMAGEENCJNI.open(this.fNQ);
        try {
            ab.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
            AppMethodBeat.o(93149);
        } catch (Exception e) {
            ab.e("MicroMsg.EncEngine", "exception " + e.getMessage());
            AppMethodBeat.o(93149);
        }
    }

    public final void reset() {
        AppMethodBeat.i(93150);
        ab.i("MicroMsg.EncEngine", "reset " + bo.dpG());
        free();
        if (this.fNR == 0) {
            init();
            this.fNP = 0;
            AppMethodBeat.o(93150);
            return;
        }
        init();
        MMIMAGEENCJNI.seek(this.mNativePtr, this.fNR, 1);
        this.fNP = this.fNR;
        AppMethodBeat.o(93150);
    }

    public final long aiO() {
        this.fNR = this.fNP;
        return this.fNR;
    }

    public final int z(byte[] bArr, int i) {
        AppMethodBeat.i(93151);
        if (this.mNativePtr == 0) {
            ab.i("MicroMsg.EncEngine", "transFor " + bo.dpG().toString());
        }
        if (fNO) {
            ab.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + bArr.length);
        }
        if (fNO && this.fNP < 64) {
            ab.d("MicroMsg.EncEngine", "dump before _offset " + this.fNP + "  length:" + i + " " + bo.ca(bArr) + " hashcode " + hashCode());
        }
        MMIMAGEENCJNI.transFor(this.mNativePtr, bArr, this.fNP, (long) i);
        if (fNO && this.fNP < 64) {
            ab.d("MicroMsg.EncEngine", "dump after _offset " + this.fNP + "  length:" + i + " " + bo.ca(bArr) + " hashcode " + hashCode());
        }
        this.fNP += (long) i;
        AppMethodBeat.o(93151);
        return i;
    }

    public final void seek(long j) {
        AppMethodBeat.i(93152);
        this.fNP = j;
        MMIMAGEENCJNI.seek(this.mNativePtr, j, 1);
        AppMethodBeat.o(93152);
    }

    public final void free() {
        AppMethodBeat.i(93153);
        ab.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
        MMIMAGEENCJNI.free(this.mNativePtr);
        this.mNativePtr = 0;
        AppMethodBeat.o(93153);
    }
}
