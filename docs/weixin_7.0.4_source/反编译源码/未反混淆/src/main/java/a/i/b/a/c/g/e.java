package a.i.b.a.c.g;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public final class e {
    private final boolean Bzu;
    private boolean Bzv;
    private int Bzw;
    private a Bzx;
    final byte[] buffer;
    int bufferSize;
    private int bxl;
    int bxm;
    private int bxn;
    private int bxo;
    int bxp;
    int bxq;
    private int bxr;
    private final InputStream input;

    interface a {
    }

    public static e S(InputStream inputStream) {
        AppMethodBeat.i(121426);
        e eVar = new e(inputStream);
        AppMethodBeat.o(121426);
        return eVar;
    }

    static e a(p pVar) {
        AppMethodBeat.i(121427);
        e eVar = new e(pVar);
        try {
            eVar.fo(pVar.size());
            AppMethodBeat.o(121427);
            return eVar;
        } catch (k e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e);
            AppMethodBeat.o(121427);
            throw illegalArgumentException;
        }
    }

    public final int vc() {
        AppMethodBeat.i(121428);
        if (eic()) {
            this.bxn = 0;
            AppMethodBeat.o(121428);
            return 0;
        }
        this.bxn = vd();
        if (z.fz(this.bxn) == 0) {
            k eit = k.eit();
            AppMethodBeat.o(121428);
            throw eit;
        }
        int i = this.bxn;
        AppMethodBeat.o(121428);
        return i;
    }

    public final void fm(int i) {
        AppMethodBeat.i(121429);
        if (this.bxn != i) {
            k eiu = k.eiu();
            AppMethodBeat.o(121429);
            throw eiu;
        }
        AppMethodBeat.o(121429);
    }

    public final boolean a(int i, f fVar) {
        AppMethodBeat.i(121430);
        long ve;
        int vc;
        switch (z.fy(i)) {
            case 0:
                ve = ve();
                fVar.fw(i);
                fVar.av(ve);
                AppMethodBeat.o(121430);
                return true;
            case 1:
                ve = eib();
                fVar.fw(i);
                fVar.nV(ve);
                AppMethodBeat.o(121430);
                return true;
            case 2:
                d ehY = ehY();
                fVar.fw(i);
                fVar.b(ehY);
                AppMethodBeat.o(121430);
                return true;
            case 3:
                fVar.fw(i);
                do {
                    vc = vc();
                    if (vc != 0) {
                    }
                    vc = z.bv(z.fz(i), 4);
                    fm(vc);
                    fVar.fw(vc);
                    AppMethodBeat.o(121430);
                    return true;
                } while (a(vc, fVar));
                vc = z.bv(z.fz(i), 4);
                fm(vc);
                fVar.fw(vc);
                AppMethodBeat.o(121430);
                return true;
            case 4:
                AppMethodBeat.o(121430);
                return false;
            case 5:
                vc = eia();
                fVar.fw(i);
                fVar.UA(vc);
                AppMethodBeat.o(121430);
                return true;
            default:
                k eiv = k.eiv();
                AppMethodBeat.o(121430);
                throw eiv;
        }
    }

    public final boolean ehX() {
        AppMethodBeat.i(121431);
        if (ve() != 0) {
            AppMethodBeat.o(121431);
            return true;
        }
        AppMethodBeat.o(121431);
        return false;
    }

    public final <T extends q> T a(s<T> sVar, g gVar) {
        AppMethodBeat.i(121432);
        int vd = vd();
        if (this.bxp >= this.bxq) {
            k eiw = k.eiw();
            AppMethodBeat.o(121432);
            throw eiw;
        }
        int fo = fo(vd);
        this.bxp++;
        q qVar = (q) sVar.a(this, gVar);
        fm(0);
        this.bxp--;
        fp(fo);
        AppMethodBeat.o(121432);
        return qVar;
    }

    public final d ehY() {
        AppMethodBeat.i(121433);
        int vd = vd();
        d cVar;
        if (vd <= this.bufferSize - this.bxm && vd > 0) {
            cVar = (this.Bzu && this.Bzv) ? new c(this.buffer, this.bxm, vd) : d.A(this.buffer, this.bxm, vd);
            this.bxm = vd + this.bxm;
            AppMethodBeat.o(121433);
            return cVar;
        } else if (vd == 0) {
            cVar = d.Bzq;
            AppMethodBeat.o(121433);
            return cVar;
        } else {
            cVar = new p(Uw(vd));
            AppMethodBeat.o(121433);
            return cVar;
        }
    }

    /* JADX WARNING: Missing block: B:28:0x008b, code skipped:
            if (r3[r2] < (byte) 0) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int vd() {
        AppMethodBeat.i(121434);
        int i = this.bxm;
        if (this.bufferSize != i) {
            byte[] bArr = this.buffer;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.bxm = i2;
                AppMethodBeat.o(121434);
                return b;
            } else if (this.bufferSize - i2 >= 9) {
                int i3 = i2 + 1;
                i = b ^ (bArr[i2] << 7);
                if (((long) i) < 0) {
                    i = (int) (((long) i) ^ -128);
                } else {
                    i2 = i3 + 1;
                    i ^= bArr[i3] << 14;
                    if (((long) i) >= 0) {
                        i = (int) (((long) i) ^ 16256);
                        i3 = i2;
                    } else {
                        i3 = i2 + 1;
                        i ^= bArr[i2] << 21;
                        if (((long) i) < 0) {
                            i = (int) (((long) i) ^ -2080896);
                        } else {
                            i2 = i3 + 1;
                            byte b2 = bArr[i3];
                            i = (int) (((long) (i ^ (b2 << 28))) ^ 266354560);
                            if (b2 < (byte) 0) {
                                i3 = i2 + 1;
                                if (bArr[i2] < (byte) 0) {
                                    i2 = i3 + 1;
                                    if (bArr[i3] < (byte) 0) {
                                        i3 = i2 + 1;
                                        if (bArr[i2] < (byte) 0) {
                                            i2 = i3 + 1;
                                            if (bArr[i3] < (byte) 0) {
                                                i3 = i2 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                            i3 = i2;
                        }
                    }
                }
                this.bxm = i3;
                AppMethodBeat.o(121434);
                return i;
            }
        }
        i = (int) ehZ();
        AppMethodBeat.o(121434);
        return i;
    }

    /* JADX WARNING: Missing block: B:32:0x00c5, code skipped:
            if (((long) r4[r3]) < 0) goto L_0x00c7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long ve() {
        long j;
        AppMethodBeat.i(121435);
        int i = this.bxm;
        if (this.bufferSize != i) {
            byte[] bArr = this.buffer;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.bxm = i2;
                j = (long) b;
                AppMethodBeat.o(121435);
                return j;
            } else if (this.bufferSize - i2 >= 9) {
                int i3 = i2 + 1;
                j = (long) (b ^ (bArr[i2] << 7));
                if (j < 0) {
                    j ^= -128;
                } else {
                    int i4 = i3 + 1;
                    j ^= (long) (bArr[i3] << 14);
                    if (j >= 0) {
                        j ^= 16256;
                        i3 = i4;
                    } else {
                        i3 = i4 + 1;
                        j ^= (long) (bArr[i4] << 21);
                        if (j < 0) {
                            j ^= -2080896;
                        } else {
                            i4 = i3 + 1;
                            j ^= ((long) bArr[i3]) << 28;
                            if (j >= 0) {
                                j ^= 266354560;
                                i3 = i4;
                            } else {
                                i3 = i4 + 1;
                                j ^= ((long) bArr[i4]) << 35;
                                if (j < 0) {
                                    j ^= -34093383808L;
                                } else {
                                    i4 = i3 + 1;
                                    j ^= ((long) bArr[i3]) << 42;
                                    if (j >= 0) {
                                        j ^= 4363953127296L;
                                        i3 = i4;
                                    } else {
                                        i3 = i4 + 1;
                                        j ^= ((long) bArr[i4]) << 49;
                                        if (j < 0) {
                                            j ^= -558586000294016L;
                                        } else {
                                            i4 = i3 + 1;
                                            j = (j ^ (((long) bArr[i3]) << 56)) ^ 71499008037633920L;
                                            if (j < 0) {
                                                i3 = i4 + 1;
                                            } else {
                                                i3 = i4;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.bxm = i3;
                AppMethodBeat.o(121435);
                return j;
            }
        }
        j = ehZ();
        AppMethodBeat.o(121435);
        return j;
    }

    private long ehZ() {
        AppMethodBeat.i(121436);
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte vh = vh();
            j |= ((long) (vh & d.MIC_SketchMark)) << i;
            if ((vh & 128) == 0) {
                AppMethodBeat.o(121436);
                return j;
            }
        }
        k eis = k.eis();
        AppMethodBeat.o(121436);
        throw eis;
    }

    public final int eia() {
        AppMethodBeat.i(121437);
        int i = this.bxm;
        if (this.bufferSize - i < 4) {
            Uu(4);
            i = this.bxm;
        }
        byte[] bArr = this.buffer;
        this.bxm = i + 4;
        i = ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
        AppMethodBeat.o(121437);
        return i;
    }

    public final long eib() {
        AppMethodBeat.i(121438);
        int i = this.bxm;
        if (this.bufferSize - i < 8) {
            Uu(8);
            i = this.bxm;
        }
        byte[] bArr = this.buffer;
        this.bxm = i + 8;
        long j = ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
        AppMethodBeat.o(121438);
        return j;
    }

    public static long nS(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private e(InputStream inputStream) {
        AppMethodBeat.i(121439);
        this.Bzv = false;
        this.bxo = BaseClientBuilder.API_PRIORITY_OTHER;
        this.bxq = 64;
        this.bxr = 67108864;
        this.Bzx = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bxm = 0;
        this.Bzw = 0;
        this.input = inputStream;
        this.Bzu = false;
        AppMethodBeat.o(121439);
    }

    private e(p pVar) {
        AppMethodBeat.i(121440);
        this.Bzv = false;
        this.bxo = BaseClientBuilder.API_PRIORITY_OTHER;
        this.bxq = 64;
        this.bxr = 67108864;
        this.Bzx = null;
        this.buffer = pVar.wR;
        this.bxm = pVar.ehO();
        this.bufferSize = this.bxm + pVar.size();
        this.Bzw = -this.bxm;
        this.input = null;
        this.Bzu = true;
        AppMethodBeat.o(121440);
    }

    public final int fo(int i) {
        AppMethodBeat.i(121441);
        k eir;
        if (i < 0) {
            eir = k.eir();
            AppMethodBeat.o(121441);
            throw eir;
        }
        int i2 = (this.Bzw + this.bxm) + i;
        int i3 = this.bxo;
        if (i2 > i3) {
            eir = k.eiq();
            AppMethodBeat.o(121441);
            throw eir;
        }
        this.bxo = i2;
        vf();
        AppMethodBeat.o(121441);
        return i3;
    }

    private void vf() {
        this.bufferSize += this.bxl;
        int i = this.Bzw + this.bufferSize;
        if (i > this.bxo) {
            this.bxl = i - this.bxo;
            this.bufferSize -= this.bxl;
            return;
        }
        this.bxl = 0;
    }

    public final void fp(int i) {
        AppMethodBeat.i(121442);
        this.bxo = i;
        vf();
        AppMethodBeat.o(121442);
    }

    public final int vg() {
        if (this.bxo == BaseClientBuilder.API_PRIORITY_OTHER) {
            return -1;
        }
        return this.bxo - (this.Bzw + this.bxm);
    }

    private boolean eic() {
        AppMethodBeat.i(121443);
        if (this.bxm != this.bufferSize || Uv(1)) {
            AppMethodBeat.o(121443);
            return false;
        }
        AppMethodBeat.o(121443);
        return true;
    }

    private void Uu(int i) {
        AppMethodBeat.i(121444);
        if (Uv(i)) {
            AppMethodBeat.o(121444);
            return;
        }
        k eiq = k.eiq();
        AppMethodBeat.o(121444);
        throw eiq;
    }

    private boolean Uv(int i) {
        IllegalStateException illegalStateException;
        AppMethodBeat.i(121445);
        while (this.bxm + i > this.bufferSize) {
            if ((this.Bzw + this.bxm) + i > this.bxo) {
                AppMethodBeat.o(121445);
                return false;
            }
            if (this.input != null) {
                int i2 = this.bxm;
                if (i2 > 0) {
                    if (this.bufferSize > i2) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i2, bArr, 0, this.bufferSize - i2);
                    }
                    this.Bzw += i2;
                    this.bufferSize -= i2;
                    this.bxm = 0;
                }
                i2 = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
                if (i2 == 0 || i2 < -1 || i2 > this.buffer.length) {
                    illegalStateException = new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + i2 + "\nThe InputStream implementation is buggy.");
                    AppMethodBeat.o(121445);
                    throw illegalStateException;
                } else if (i2 > 0) {
                    this.bufferSize = i2 + this.bufferSize;
                    if ((this.Bzw + i) - this.bxr > 0) {
                        k eix = k.eix();
                        AppMethodBeat.o(121445);
                        throw eix;
                    }
                    vf();
                    if (this.bufferSize >= i) {
                        AppMethodBeat.o(121445);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(121445);
            return false;
        }
        illegalStateException = new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        AppMethodBeat.o(121445);
        throw illegalStateException;
    }

    private byte vh() {
        AppMethodBeat.i(121446);
        if (this.bxm == this.bufferSize) {
            Uu(1);
        }
        byte[] bArr = this.buffer;
        int i = this.bxm;
        this.bxm = i + 1;
        byte b = bArr[i];
        AppMethodBeat.o(121446);
        return b;
    }

    /* Access modifiers changed, original: final */
    public final byte[] Uw(int i) {
        AppMethodBeat.i(121447);
        byte[] bArr;
        k eir;
        int i2;
        if (i <= 0) {
            if (i == 0) {
                bArr = j.EMPTY_BYTE_ARRAY;
                AppMethodBeat.o(121447);
                return bArr;
            }
            eir = k.eir();
            AppMethodBeat.o(121447);
            throw eir;
        } else if ((this.Bzw + this.bxm) + i > this.bxo) {
            fs((this.bxo - this.Bzw) - this.bxm);
            eir = k.eiq();
            AppMethodBeat.o(121447);
            throw eir;
        } else if (i < 4096) {
            bArr = new byte[i];
            i2 = this.bufferSize - this.bxm;
            System.arraycopy(this.buffer, this.bxm, bArr, 0, i2);
            this.bxm = this.bufferSize;
            int i3 = i - i2;
            if (this.bufferSize - this.bxm < i3) {
                Uu(i3);
            }
            System.arraycopy(this.buffer, 0, bArr, i2, i - i2);
            this.bxm = i - i2;
            AppMethodBeat.o(121447);
            return bArr;
        } else {
            int i4 = this.bxm;
            int i5 = this.bufferSize;
            this.Bzw += this.bufferSize;
            this.bxm = 0;
            this.bufferSize = 0;
            int i6 = i - (i5 - i4);
            ArrayList arrayList = new ArrayList();
            int i7 = i6;
            while (i7 > 0) {
                byte[] bArr2 = new byte[Math.min(i7, 4096)];
                i6 = 0;
                while (i6 < bArr2.length) {
                    i2 = this.input == null ? -1 : this.input.read(bArr2, i6, bArr2.length - i6);
                    if (i2 == -1) {
                        eir = k.eiq();
                        AppMethodBeat.o(121447);
                        throw eir;
                    }
                    this.Bzw += i2;
                    i6 += i2;
                }
                i6 = i7 - bArr2.length;
                arrayList.add(bArr2);
                i7 = i6;
            }
            byte[] bArr3 = new byte[i];
            i6 = i5 - i4;
            System.arraycopy(this.buffer, i4, bArr3, 0, i6);
            Iterator it = arrayList.iterator();
            while (true) {
                i2 = i6;
                if (it.hasNext()) {
                    bArr = (byte[]) it.next();
                    System.arraycopy(bArr, 0, bArr3, i2, bArr.length);
                    i6 = bArr.length + i2;
                } else {
                    AppMethodBeat.o(121447);
                    return bArr3;
                }
            }
        }
    }

    private void fs(int i) {
        AppMethodBeat.i(121448);
        if (i > this.bufferSize - this.bxm || i < 0) {
            Ux(i);
            AppMethodBeat.o(121448);
            return;
        }
        this.bxm += i;
        AppMethodBeat.o(121448);
    }

    private void Ux(int i) {
        AppMethodBeat.i(121449);
        k eir;
        if (i < 0) {
            eir = k.eir();
            AppMethodBeat.o(121449);
            throw eir;
        } else if ((this.Bzw + this.bxm) + i > this.bxo) {
            fs((this.bxo - this.Bzw) - this.bxm);
            eir = k.eiq();
            AppMethodBeat.o(121449);
            throw eir;
        } else {
            int i2 = this.bufferSize - this.bxm;
            this.bxm = this.bufferSize;
            Uu(1);
            while (i - i2 > this.bufferSize) {
                i2 += this.bufferSize;
                this.bxm = this.bufferSize;
                Uu(1);
            }
            this.bxm = i - i2;
            AppMethodBeat.o(121449);
        }
    }
}
