package com.tencent.p177mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelsfs.a */
public final class C32819a {
    private static boolean fNO = false;
    private long fNP = 0;
    private String fNQ;
    private long fNR = 0;
    private long mNativePtr = 0;

    public C32819a(long j) {
        AppMethodBeat.m2504i(93147);
        this.fNQ = String.valueOf(j);
        init();
        AppMethodBeat.m2505o(93147);
    }

    public C32819a(String str) {
        AppMethodBeat.m2504i(93148);
        this.fNQ = str;
        init();
        AppMethodBeat.m2505o(93148);
    }

    private void init() {
        AppMethodBeat.m2504i(93149);
        C4990ab.m7416i("MicroMsg.EncEngine", "init  key  enckey " + this.fNQ + "  hashcode " + hashCode());
        this.mNativePtr = MMIMAGEENCJNI.open(this.fNQ);
        try {
            C4990ab.m7416i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
            AppMethodBeat.m2505o(93149);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.EncEngine", "exception " + e.getMessage());
            AppMethodBeat.m2505o(93149);
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(93150);
        C4990ab.m7416i("MicroMsg.EncEngine", "reset " + C5046bo.dpG());
        free();
        if (this.fNR == 0) {
            init();
            this.fNP = 0;
            AppMethodBeat.m2505o(93150);
            return;
        }
        init();
        MMIMAGEENCJNI.seek(this.mNativePtr, this.fNR, 1);
        this.fNP = this.fNR;
        AppMethodBeat.m2505o(93150);
    }

    public final long aiO() {
        this.fNR = this.fNP;
        return this.fNR;
    }

    /* renamed from: z */
    public final int mo53392z(byte[] bArr, int i) {
        AppMethodBeat.m2504i(93151);
        if (this.mNativePtr == 0) {
            C4990ab.m7416i("MicroMsg.EncEngine", "transFor " + C5046bo.dpG().toString());
        }
        if (fNO) {
            C4990ab.m7416i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + bArr.length);
        }
        if (fNO && this.fNP < 64) {
            C4990ab.m7410d("MicroMsg.EncEngine", "dump before _offset " + this.fNP + "  length:" + i + " " + C5046bo.m7539ca(bArr) + " hashcode " + hashCode());
        }
        MMIMAGEENCJNI.transFor(this.mNativePtr, bArr, this.fNP, (long) i);
        if (fNO && this.fNP < 64) {
            C4990ab.m7410d("MicroMsg.EncEngine", "dump after _offset " + this.fNP + "  length:" + i + " " + C5046bo.m7539ca(bArr) + " hashcode " + hashCode());
        }
        this.fNP += (long) i;
        AppMethodBeat.m2505o(93151);
        return i;
    }

    public final void seek(long j) {
        AppMethodBeat.m2504i(93152);
        this.fNP = j;
        MMIMAGEENCJNI.seek(this.mNativePtr, j, 1);
        AppMethodBeat.m2505o(93152);
    }

    public final void free() {
        AppMethodBeat.m2504i(93153);
        C4990ab.m7416i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
        MMIMAGEENCJNI.free(this.mNativePtr);
        this.mNativePtr = 0;
        AppMethodBeat.m2505o(93153);
    }
}
