package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;

public final class i implements h {
    private int clA = 0;
    private int clz = 0;
    private String fileName;

    public final boolean g(String str, int i, int i2) {
        AppMethodBeat.i(137033);
        this.clz = i;
        this.clA = i2;
        this.fileName = str;
        b.i("MicroMsg.Mix.SilkResampleAlgorithm", "initResample, fileName:%s, sSample:%d, dSample:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (SilkResampleJni.initResample(str, i, i2) == -1) {
            b.e("MicroMsg.Mix.SilkResampleAlgorithm", "initResample result is -1, fileName:%s", str);
            AppMethodBeat.o(137033);
            return false;
        }
        AppMethodBeat.o(137033);
        return true;
    }

    public final byte[] F(byte[] bArr) {
        int i = 0;
        AppMethodBeat.i(137034);
        short[] sArr = new short[(bArr.length / 2)];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            sArr[i2] = (short) ((bArr[i2 * 2] & 255) | ((bArr[(i2 * 2) + 1] & 255) << 8));
        }
        short[] sArr2 = new short[((sArr.length * this.clA) / this.clz)];
        if (SilkResampleJni.resamplePcm(this.fileName, this.clz, this.clA, sArr, sArr.length, sArr2) == -1) {
            b.e("MicroMsg.Mix.SilkResampleAlgorithm", "resamplePcm result is -1, fileName:%s", this.fileName);
            AppMethodBeat.o(137034);
            return null;
        }
        byte[] bArr2 = new byte[(sArr2.length << 1)];
        while (i < sArr2.length) {
            bArr2[i * 2] = (byte) (sArr2[i] & 255);
            bArr2[(i * 2) + 1] = (byte) ((sArr2[i] & 65280) >> 8);
            i++;
        }
        AppMethodBeat.o(137034);
        return bArr2;
    }

    public final boolean release() {
        AppMethodBeat.i(137035);
        if (SilkResampleJni.clearResample(this.fileName) == -1) {
            b.e("MicroMsg.Mix.SilkResampleAlgorithm", "clearResample result is -1");
            AppMethodBeat.o(137035);
            return false;
        }
        b.i("MicroMsg.Mix.SilkResampleAlgorithm", "release");
        AppMethodBeat.o(137035);
        return true;
    }
}
