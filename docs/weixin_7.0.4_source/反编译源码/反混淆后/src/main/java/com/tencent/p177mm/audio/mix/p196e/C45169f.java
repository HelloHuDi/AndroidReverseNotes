package com.tencent.p177mm.audio.mix.p196e;

import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C25836b;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.tencent.mm.audio.mix.e.f */
public abstract class C45169f implements C25841h {
    protected int MAX_VALUE = 32767;
    protected int MIN_VALUE = -32768;
    protected short[][] cmZ = ((short[][]) Array.newInstance(Short.TYPE, new int[]{1, 1}));
    protected int cna = 1;
    protected int cnb = 1;
    protected short[] cnc = new short[1];
    protected int cnd = 1;
    protected C25836b cne;

    /* renamed from: D */
    public abstract byte[] mo4603D(int i, int i2, int i3);

    /* renamed from: a */
    public final boolean mo43831a(C25836b c25836b, List<C45164d> list) {
        if (list == null || list.size() == 0) {
            C45174b.m83207e("MicroMsg.Mix.BaseAudioMixAlgorithm", "process list is invalid");
            return false;
        }
        int i;
        byte[] bArr;
        byte[][] bArr2 = new byte[list.size()][];
        for (i = 0; i < list.size(); i++) {
            bArr2[i] = ((C45164d) list.get(i)).ckv;
        }
        this.cne = c25836b;
        if (bArr2.length == 0) {
            bArr = null;
        } else {
            Object obj = bArr2[0];
            if (obj == null || obj.length == 0) {
                bArr = null;
            } else if (bArr2.length == 1) {
                bArr = m83177Ed();
                if (bArr == null || bArr.length != obj.length) {
                    bArr = new byte[obj.length];
                }
                System.arraycopy(obj, 0, bArr, 0, obj.length);
            } else {
                int i2;
                for (i2 = 0; i2 < bArr2.length; i2++) {
                    if (bArr2[i2].length != obj.length) {
                        C45174b.m83207e("MicroMsg.Mix.BaseAudioMixAlgorithm", "column of the road of audio + " + i2 + " is different.");
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
                bArr = mo4603D(length, length2, obj.length);
            }
        }
        if (bArr == null) {
            C45174b.m83207e("MicroMsg.Mix.BaseAudioMixAlgorithm", "mixed data is invalid");
            return false;
        }
        c25836b.ckv = bArr;
        c25836b.channels = ((C45164d) list.get(0)).channels;
        c25836b.sampleRate = ((C45164d) list.get(0)).sampleRate;
        return true;
    }

    /* renamed from: Ed */
    private byte[] m83177Ed() {
        if (this.cne != null) {
            return this.cne.ckv;
        }
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: gz */
    public final short mo73138gz(int i) {
        if (i > this.MAX_VALUE) {
            return (short) this.MAX_VALUE;
        }
        if (i < this.MIN_VALUE) {
            return (short) this.MIN_VALUE;
        }
        return (short) i;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bM */
    public final byte[] mo73137bM(int i, int i2) {
        byte[] Ed = m83177Ed();
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
