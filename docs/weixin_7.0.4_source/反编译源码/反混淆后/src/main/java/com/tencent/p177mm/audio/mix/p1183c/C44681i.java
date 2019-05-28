package com.tencent.p177mm.audio.mix.p1183c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.jni.SilkResampleJni;
import com.tencent.p177mm.audio.mix.p197h.C45174b;

/* renamed from: com.tencent.mm.audio.mix.c.i */
public final class C44681i implements C41775h {
    private int clA = 0;
    private int clz = 0;
    private String fileName;

    /* renamed from: g */
    public final boolean mo67529g(String str, int i, int i2) {
        AppMethodBeat.m2504i(137033);
        this.clz = i;
        this.clA = i2;
        this.fileName = str;
        C45174b.m83210i("MicroMsg.Mix.SilkResampleAlgorithm", "initResample, fileName:%s, sSample:%d, dSample:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (SilkResampleJni.initResample(str, i, i2) == -1) {
            C45174b.m83208e("MicroMsg.Mix.SilkResampleAlgorithm", "initResample result is -1, fileName:%s", str);
            AppMethodBeat.m2505o(137033);
            return false;
        }
        AppMethodBeat.m2505o(137033);
        return true;
    }

    /* renamed from: F */
    public final byte[] mo67528F(byte[] bArr) {
        int i = 0;
        AppMethodBeat.m2504i(137034);
        short[] sArr = new short[(bArr.length / 2)];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            sArr[i2] = (short) ((bArr[i2 * 2] & 255) | ((bArr[(i2 * 2) + 1] & 255) << 8));
        }
        short[] sArr2 = new short[((sArr.length * this.clA) / this.clz)];
        if (SilkResampleJni.resamplePcm(this.fileName, this.clz, this.clA, sArr, sArr.length, sArr2) == -1) {
            C45174b.m83208e("MicroMsg.Mix.SilkResampleAlgorithm", "resamplePcm result is -1, fileName:%s", this.fileName);
            AppMethodBeat.m2505o(137034);
            return null;
        }
        byte[] bArr2 = new byte[(sArr2.length << 1)];
        while (i < sArr2.length) {
            bArr2[i * 2] = (byte) (sArr2[i] & 255);
            bArr2[(i * 2) + 1] = (byte) ((sArr2[i] & 65280) >> 8);
            i++;
        }
        AppMethodBeat.m2505o(137034);
        return bArr2;
    }

    public final boolean release() {
        AppMethodBeat.m2504i(137035);
        if (SilkResampleJni.clearResample(this.fileName) == -1) {
            C45174b.m83207e("MicroMsg.Mix.SilkResampleAlgorithm", "clearResample result is -1");
            AppMethodBeat.m2505o(137035);
            return false;
        }
        C45174b.m83209i("MicroMsg.Mix.SilkResampleAlgorithm", "release");
        AppMethodBeat.m2505o(137035);
        return true;
    }
}
