package p000a.p010i.p011b.p012a.p015c.p035g;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: a.i.b.a.c.g.e */
public final class C31713e {
    private final boolean Bzu;
    private boolean Bzv;
    private int Bzw;
    private C31714a Bzx;
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

    /* renamed from: a.i.b.a.c.g.e$a */
    interface C31714a {
    }

    /* renamed from: S */
    public static C31713e m51322S(InputStream inputStream) {
        AppMethodBeat.m2504i(121426);
        C31713e c31713e = new C31713e(inputStream);
        AppMethodBeat.m2505o(121426);
        return c31713e;
    }

    /* renamed from: a */
    static C31713e m51326a(C25162p c25162p) {
        AppMethodBeat.m2504i(121427);
        C31713e c31713e = new C31713e(c25162p);
        try {
            c31713e.mo51690fo(c25162p.size());
            AppMethodBeat.m2505o(121427);
            return c31713e;
        } catch (C41425k e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e);
            AppMethodBeat.m2505o(121427);
            throw illegalArgumentException;
        }
    }

    /* renamed from: vc */
    public final int mo51692vc() {
        AppMethodBeat.m2504i(121428);
        if (eic()) {
            this.bxn = 0;
            AppMethodBeat.m2505o(121428);
            return 0;
        }
        this.bxn = mo51693vd();
        if (C17273z.m26755fz(this.bxn) == 0) {
            C41425k eit = C41425k.eit();
            AppMethodBeat.m2505o(121428);
            throw eit;
        }
        int i = this.bxn;
        AppMethodBeat.m2505o(121428);
        return i;
    }

    /* renamed from: fm */
    public final void mo51689fm(int i) {
        AppMethodBeat.m2504i(121429);
        if (this.bxn != i) {
            C41425k eiu = C41425k.eiu();
            AppMethodBeat.m2505o(121429);
            throw eiu;
        }
        AppMethodBeat.m2505o(121429);
    }

    /* renamed from: a */
    public final boolean mo51684a(int i, C37024f c37024f) {
        AppMethodBeat.m2504i(121430);
        long ve;
        int vc;
        switch (C17273z.m26754fy(i)) {
            case 0:
                ve = mo51694ve();
                c37024f.mo59058fw(i);
                c37024f.mo59047av(ve);
                AppMethodBeat.m2505o(121430);
                return true;
            case 1:
                ve = eib();
                c37024f.mo59058fw(i);
                c37024f.mo59061nV(ve);
                AppMethodBeat.m2505o(121430);
                return true;
            case 2:
                C31710d ehY = ehY();
                c37024f.mo59058fw(i);
                c37024f.mo59050b(ehY);
                AppMethodBeat.m2505o(121430);
                return true;
            case 3:
                c37024f.mo59058fw(i);
                do {
                    vc = mo51692vc();
                    if (vc != 0) {
                    }
                    vc = C17273z.m26753bv(C17273z.m26755fz(i), 4);
                    mo51689fm(vc);
                    c37024f.mo59058fw(vc);
                    AppMethodBeat.m2505o(121430);
                    return true;
                } while (mo51684a(vc, c37024f));
                vc = C17273z.m26753bv(C17273z.m26755fz(i), 4);
                mo51689fm(vc);
                c37024f.mo59058fw(vc);
                AppMethodBeat.m2505o(121430);
                return true;
            case 4:
                AppMethodBeat.m2505o(121430);
                return false;
            case 5:
                vc = eia();
                c37024f.mo59058fw(i);
                c37024f.mo59042UA(vc);
                AppMethodBeat.m2505o(121430);
                return true;
            default:
                C41425k eiv = C41425k.eiv();
                AppMethodBeat.m2505o(121430);
                throw eiv;
        }
    }

    public final boolean ehX() {
        AppMethodBeat.m2504i(121431);
        if (mo51694ve() != 0) {
            AppMethodBeat.m2505o(121431);
            return true;
        }
        AppMethodBeat.m2505o(121431);
        return false;
    }

    /* renamed from: a */
    public final <T extends C8185q> T mo51683a(C25163s<T> c25163s, C31715g c31715g) {
        AppMethodBeat.m2504i(121432);
        int vd = mo51693vd();
        if (this.bxp >= this.bxq) {
            C41425k eiw = C41425k.eiw();
            AppMethodBeat.m2505o(121432);
            throw eiw;
        }
        int fo = mo51690fo(vd);
        this.bxp++;
        C8185q c8185q = (C8185q) c25163s.mo157a(this, c31715g);
        mo51689fm(0);
        this.bxp--;
        mo51691fp(fo);
        AppMethodBeat.m2505o(121432);
        return c8185q;
    }

    public final C31710d ehY() {
        AppMethodBeat.m2504i(121433);
        int vd = mo51693vd();
        C31710d c31709c;
        if (vd <= this.bufferSize - this.bxm && vd > 0) {
            c31709c = (this.Bzu && this.Bzv) ? new C31709c(this.buffer, this.bxm, vd) : C31710d.m51310A(this.buffer, this.bxm, vd);
            this.bxm = vd + this.bxm;
            AppMethodBeat.m2505o(121433);
            return c31709c;
        } else if (vd == 0) {
            c31709c = C31710d.Bzq;
            AppMethodBeat.m2505o(121433);
            return c31709c;
        } else {
            c31709c = new C25162p(mo51682Uw(vd));
            AppMethodBeat.m2505o(121433);
            return c31709c;
        }
    }

    /* JADX WARNING: Missing block: B:28:0x008b, code skipped:
            if (r3[r2] < (byte) 0) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: vd */
    public final int mo51693vd() {
        AppMethodBeat.m2504i(121434);
        int i = this.bxm;
        if (this.bufferSize != i) {
            byte[] bArr = this.buffer;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.bxm = i2;
                AppMethodBeat.m2505o(121434);
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
                AppMethodBeat.m2505o(121434);
                return i;
            }
        }
        i = (int) ehZ();
        AppMethodBeat.m2505o(121434);
        return i;
    }

    /* JADX WARNING: Missing block: B:32:0x00c5, code skipped:
            if (((long) r4[r3]) < 0) goto L_0x00c7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ve */
    public final long mo51694ve() {
        long j;
        AppMethodBeat.m2504i(121435);
        int i = this.bxm;
        if (this.bufferSize != i) {
            byte[] bArr = this.buffer;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.bxm = i2;
                j = (long) b;
                AppMethodBeat.m2505o(121435);
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
                AppMethodBeat.m2505o(121435);
                return j;
            }
        }
        j = ehZ();
        AppMethodBeat.m2505o(121435);
        return j;
    }

    private long ehZ() {
        AppMethodBeat.m2504i(121436);
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte vh = m51330vh();
            j |= ((long) (vh & C31128d.MIC_SketchMark)) << i;
            if ((vh & 128) == 0) {
                AppMethodBeat.m2505o(121436);
                return j;
            }
        }
        C41425k eis = C41425k.eis();
        AppMethodBeat.m2505o(121436);
        throw eis;
    }

    public final int eia() {
        AppMethodBeat.m2504i(121437);
        int i = this.bxm;
        if (this.bufferSize - i < 4) {
            m51323Uu(4);
            i = this.bxm;
        }
        byte[] bArr = this.buffer;
        this.bxm = i + 4;
        i = ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
        AppMethodBeat.m2505o(121437);
        return i;
    }

    public final long eib() {
        AppMethodBeat.m2504i(121438);
        int i = this.bxm;
        if (this.bufferSize - i < 8) {
            m51323Uu(8);
            i = this.bxm;
        }
        byte[] bArr = this.buffer;
        this.bxm = i + 8;
        long j = ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
        AppMethodBeat.m2505o(121438);
        return j;
    }

    /* renamed from: nS */
    public static long m51328nS(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private C31713e(InputStream inputStream) {
        AppMethodBeat.m2504i(121439);
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
        AppMethodBeat.m2505o(121439);
    }

    private C31713e(C25162p c25162p) {
        AppMethodBeat.m2504i(121440);
        this.Bzv = false;
        this.bxo = BaseClientBuilder.API_PRIORITY_OTHER;
        this.bxq = 64;
        this.bxr = 67108864;
        this.Bzx = null;
        this.buffer = c25162p.f5019wR;
        this.bxm = c25162p.ehO();
        this.bufferSize = this.bxm + c25162p.size();
        this.Bzw = -this.bxm;
        this.input = null;
        this.Bzu = true;
        AppMethodBeat.m2505o(121440);
    }

    /* renamed from: fo */
    public final int mo51690fo(int i) {
        AppMethodBeat.m2504i(121441);
        C41425k eir;
        if (i < 0) {
            eir = C41425k.eir();
            AppMethodBeat.m2505o(121441);
            throw eir;
        }
        int i2 = (this.Bzw + this.bxm) + i;
        int i3 = this.bxo;
        if (i2 > i3) {
            eir = C41425k.eiq();
            AppMethodBeat.m2505o(121441);
            throw eir;
        }
        this.bxo = i2;
        m51329vf();
        AppMethodBeat.m2505o(121441);
        return i3;
    }

    /* renamed from: vf */
    private void m51329vf() {
        this.bufferSize += this.bxl;
        int i = this.Bzw + this.bufferSize;
        if (i > this.bxo) {
            this.bxl = i - this.bxo;
            this.bufferSize -= this.bxl;
            return;
        }
        this.bxl = 0;
    }

    /* renamed from: fp */
    public final void mo51691fp(int i) {
        AppMethodBeat.m2504i(121442);
        this.bxo = i;
        m51329vf();
        AppMethodBeat.m2505o(121442);
    }

    /* renamed from: vg */
    public final int mo51695vg() {
        if (this.bxo == BaseClientBuilder.API_PRIORITY_OTHER) {
            return -1;
        }
        return this.bxo - (this.Bzw + this.bxm);
    }

    private boolean eic() {
        AppMethodBeat.m2504i(121443);
        if (this.bxm != this.bufferSize || m51324Uv(1)) {
            AppMethodBeat.m2505o(121443);
            return false;
        }
        AppMethodBeat.m2505o(121443);
        return true;
    }

    /* renamed from: Uu */
    private void m51323Uu(int i) {
        AppMethodBeat.m2504i(121444);
        if (m51324Uv(i)) {
            AppMethodBeat.m2505o(121444);
            return;
        }
        C41425k eiq = C41425k.eiq();
        AppMethodBeat.m2505o(121444);
        throw eiq;
    }

    /* renamed from: Uv */
    private boolean m51324Uv(int i) {
        IllegalStateException illegalStateException;
        AppMethodBeat.m2504i(121445);
        while (this.bxm + i > this.bufferSize) {
            if ((this.Bzw + this.bxm) + i > this.bxo) {
                AppMethodBeat.m2505o(121445);
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
                    AppMethodBeat.m2505o(121445);
                    throw illegalStateException;
                } else if (i2 > 0) {
                    this.bufferSize = i2 + this.bufferSize;
                    if ((this.Bzw + i) - this.bxr > 0) {
                        C41425k eix = C41425k.eix();
                        AppMethodBeat.m2505o(121445);
                        throw eix;
                    }
                    m51329vf();
                    if (this.bufferSize >= i) {
                        AppMethodBeat.m2505o(121445);
                        return true;
                    }
                }
            }
            AppMethodBeat.m2505o(121445);
            return false;
        }
        illegalStateException = new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        AppMethodBeat.m2505o(121445);
        throw illegalStateException;
    }

    /* renamed from: vh */
    private byte m51330vh() {
        AppMethodBeat.m2504i(121446);
        if (this.bxm == this.bufferSize) {
            m51323Uu(1);
        }
        byte[] bArr = this.buffer;
        int i = this.bxm;
        this.bxm = i + 1;
        byte b = bArr[i];
        AppMethodBeat.m2505o(121446);
        return b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Uw */
    public final byte[] mo51682Uw(int i) {
        AppMethodBeat.m2504i(121447);
        byte[] bArr;
        C41425k eir;
        int i2;
        if (i <= 0) {
            if (i == 0) {
                bArr = C8181j.EMPTY_BYTE_ARRAY;
                AppMethodBeat.m2505o(121447);
                return bArr;
            }
            eir = C41425k.eir();
            AppMethodBeat.m2505o(121447);
            throw eir;
        } else if ((this.Bzw + this.bxm) + i > this.bxo) {
            m51327fs((this.bxo - this.Bzw) - this.bxm);
            eir = C41425k.eiq();
            AppMethodBeat.m2505o(121447);
            throw eir;
        } else if (i < 4096) {
            bArr = new byte[i];
            i2 = this.bufferSize - this.bxm;
            System.arraycopy(this.buffer, this.bxm, bArr, 0, i2);
            this.bxm = this.bufferSize;
            int i3 = i - i2;
            if (this.bufferSize - this.bxm < i3) {
                m51323Uu(i3);
            }
            System.arraycopy(this.buffer, 0, bArr, i2, i - i2);
            this.bxm = i - i2;
            AppMethodBeat.m2505o(121447);
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
                        eir = C41425k.eiq();
                        AppMethodBeat.m2505o(121447);
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
                    AppMethodBeat.m2505o(121447);
                    return bArr3;
                }
            }
        }
    }

    /* renamed from: fs */
    private void m51327fs(int i) {
        AppMethodBeat.m2504i(121448);
        if (i > this.bufferSize - this.bxm || i < 0) {
            m51325Ux(i);
            AppMethodBeat.m2505o(121448);
            return;
        }
        this.bxm += i;
        AppMethodBeat.m2505o(121448);
    }

    /* renamed from: Ux */
    private void m51325Ux(int i) {
        AppMethodBeat.m2504i(121449);
        C41425k eir;
        if (i < 0) {
            eir = C41425k.eir();
            AppMethodBeat.m2505o(121449);
            throw eir;
        } else if ((this.Bzw + this.bxm) + i > this.bxo) {
            m51327fs((this.bxo - this.Bzw) - this.bxm);
            eir = C41425k.eiq();
            AppMethodBeat.m2505o(121449);
            throw eir;
        } else {
            int i2 = this.bufferSize - this.bxm;
            this.bxm = this.bufferSize;
            m51323Uu(1);
            while (i - i2 > this.bufferSize) {
                i2 += this.bufferSize;
                this.bxm = this.bufferSize;
                m51323Uu(1);
            }
            this.bxm = i - i2;
            AppMethodBeat.m2505o(121449);
        }
    }
}
