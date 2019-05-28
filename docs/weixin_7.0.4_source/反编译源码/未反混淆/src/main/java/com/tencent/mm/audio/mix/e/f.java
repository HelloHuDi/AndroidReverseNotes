package com.tencent.mm.audio.mix.e;

import com.tencent.mm.audio.mix.a.b;
import com.tencent.mm.audio.mix.a.d;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public abstract class f implements h {
    protected int MAX_VALUE = 32767;
    protected int MIN_VALUE = -32768;
    protected short[][] cmZ = ((short[][]) Array.newInstance(Short.TYPE, new int[]{1, 1}));
    protected int cna = 1;
    protected int cnb = 1;
    protected short[] cnc = new short[1];
    protected int cnd = 1;
    protected b cne;

    public abstract byte[] D(int i, int i2, int i3);

    public final boolean a(b bVar, List<d> list) {
        if (list == null || list.size() == 0) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.BaseAudioMixAlgorithm", "process list is invalid");
            return false;
        }
        int i;
        byte[] bArr;
        byte[][] bArr2 = new byte[list.size()][];
        for (i = 0; i < list.size(); i++) {
            bArr2[i] = ((d) list.get(i)).ckv;
        }
        this.cne = bVar;
        if (bArr2.length == 0) {
            bArr = null;
        } else {
            Object obj = bArr2[0];
            if (obj == null || obj.length == 0) {
                bArr = null;
            } else if (bArr2.length == 1) {
                bArr = Ed();
                if (bArr == null || bArr.length != obj.length) {
                    bArr = new byte[obj.length];
                }
                System.arraycopy(obj, 0, bArr, 0, obj.length);
            } else {
                int i2;
                for (i2 = 0; i2 < bArr2.length; i2++) {
                    if (bArr2[i2].length != obj.length) {
                        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.BaseAudioMixAlgorithm", "column of the road of audio + " + i2 + " is different.");
                        bArr = null;
                        break;
                    }
                }
                int length = bArr2.length;
                int length2 = obj.length / 2;
                if (!(length == this.cna && length2 == this.cnb)) {
                    this.cmZ = (short[][]) Array.newInstance(Short.TYPE, new int[]{length, length2});
                    this.cna = length;
                    this.cnb = length2;
                }
                for (i = 0; i < length; i++) {
                    Arrays.fill(this.cmZ[i], 0, length2 - 1, (short) 0);
                    for (i2 = 0; i2 < length2; i2++) {
                        this.cmZ[i][i2] = (short) ((bArr2[i][i2 * 2] & 255) | ((bArr2[i][(i2 * 2) + 1] & 255) << 8));
                    }
                }
                if (this.cnd != length2) {
                    this.cnd = length2;
                    this.cnc = new short[length2];
                }
                Arrays.fill(this.cnc, 0, length2 - 1, (short) 0);
                bArr = D(length, length2, obj.length);
            }
        }
        if (bArr == null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.BaseAudioMixAlgorithm", "mixed data is invalid");
            return false;
        }
        bVar.ckv = bArr;
        bVar.channels = ((d) list.get(0)).channels;
        bVar.sampleRate = ((d) list.get(0)).sampleRate;
        return true;
    }

    private byte[] Ed() {
        if (this.cne != null) {
            return this.cne.ckv;
        }
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final short gz(int i) {
        if (i > this.MAX_VALUE) {
            return (short) this.MAX_VALUE;
        }
        if (i < this.MIN_VALUE) {
            return (short) this.MIN_VALUE;
        }
        return (short) i;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] bM(int i, int i2) {
        byte[] Ed = Ed();
        if (Ed == null || Ed.length != i) {
            Ed = new byte[i];
        }
        for (int i3 = 0; i3 < i2; i3++) {
            Ed[i3 * 2] = (byte) (this.cnc[i3] & 255);
            Ed[(i3 * 2) + 1] = (byte) ((this.cnc[i3] & 65280) >> 8);
        }
        return Ed;
    }
}
