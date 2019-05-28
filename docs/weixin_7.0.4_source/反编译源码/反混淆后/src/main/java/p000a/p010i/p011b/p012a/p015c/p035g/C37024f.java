package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: a.i.b.a.c.g.f */
public final class C37024f {
    private int Bzy = 0;
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int position;

    /* renamed from: a.i.b.a.c.g.f$a */
    public static class C0118a extends IOException {
        C0118a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private C37024f(OutputStream outputStream, byte[] bArr) {
        AppMethodBeat.m2504i(121450);
        this.output = outputStream;
        this.buffer = bArr;
        this.position = 0;
        this.limit = bArr.length;
        AppMethodBeat.m2505o(121450);
    }

    /* renamed from: e */
    public static C37024f m61953e(OutputStream outputStream, int i) {
        AppMethodBeat.m2504i(121451);
        C37024f c37024f = new C37024f(outputStream, new byte[i]);
        AppMethodBeat.m2505o(121451);
        return c37024f;
    }

    /* renamed from: bq */
    public final void mo59052bq(int i, int i2) {
        AppMethodBeat.m2504i(121452);
        mo59053bu(i, 0);
        mo59043Uy(i2);
        AppMethodBeat.m2505o(121452);
    }

    /* renamed from: rP */
    public final void mo59062rP(boolean z) {
        AppMethodBeat.m2504i(121453);
        mo59053bu(3, 0);
        mo59063rQ(z);
        AppMethodBeat.m2505o(121453);
    }

    /* renamed from: a */
    public final void mo59046a(int i, C8185q c8185q) {
        AppMethodBeat.m2504i(121454);
        mo59053bu(i, 2);
        mo59051b(c8185q);
        AppMethodBeat.m2505o(121454);
    }

    /* renamed from: a */
    public final void mo59045a(int i, C31710d c31710d) {
        AppMethodBeat.m2504i(121455);
        mo59053bu(i, 2);
        mo59050b(c31710d);
        AppMethodBeat.m2505o(121455);
    }

    /* renamed from: io */
    public final void mo59059io(int i, int i2) {
        AppMethodBeat.m2504i(121456);
        mo59053bu(i, 0);
        mo59043Uy(i2);
        AppMethodBeat.m2505o(121456);
    }

    /* renamed from: b */
    public final void mo59049b(int i, C8185q c8185q) {
        AppMethodBeat.m2504i(121457);
        mo59053bu(1, 3);
        mo59053bu(2, 0);
        mo59058fw(i);
        mo59046a(3, c8185q);
        mo59053bu(1, 4);
        AppMethodBeat.m2505o(121457);
    }

    /* renamed from: J */
    public final void mo59041J(double d) {
        AppMethodBeat.m2504i(121458);
        mo59061nV(Double.doubleToRawLongBits(d));
        AppMethodBeat.m2505o(121458);
    }

    /* renamed from: bz */
    public final void mo59054bz(float f) {
        AppMethodBeat.m2504i(121459);
        mo59042UA(Float.floatToRawIntBits(f));
        AppMethodBeat.m2505o(121459);
    }

    /* renamed from: Uy */
    public final void mo59043Uy(int i) {
        AppMethodBeat.m2504i(121460);
        if (i >= 0) {
            mo59058fw(i);
            AppMethodBeat.m2505o(121460);
            return;
        }
        mo59047av((long) i);
        AppMethodBeat.m2505o(121460);
    }

    /* renamed from: rQ */
    public final void mo59063rQ(boolean z) {
        int i;
        AppMethodBeat.m2504i(121461);
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        m61951c((byte) i);
        AppMethodBeat.m2505o(121461);
    }

    public final void awd(String str) {
        AppMethodBeat.m2504i(121462);
        byte[] bytes = str.getBytes("UTF-8");
        mo59058fw(bytes.length);
        m61960q(bytes, bytes.length);
        AppMethodBeat.m2505o(121462);
    }

    /* renamed from: b */
    public final void mo59051b(C8185q c8185q) {
        AppMethodBeat.m2504i(121463);
        mo59058fw(c8185q.mo144vq());
        c8185q.mo128a(this);
        AppMethodBeat.m2505o(121463);
    }

    /* renamed from: b */
    public final void mo59050b(C31710d c31710d) {
        AppMethodBeat.m2504i(121464);
        mo59058fw(c31710d.size());
        mo59056d(c31710d);
        AppMethodBeat.m2505o(121464);
    }

    /* renamed from: cy */
    public final void mo59055cy(byte[] bArr) {
        AppMethodBeat.m2504i(121465);
        mo59058fw(bArr.length);
        m61960q(bArr, bArr.length);
        AppMethodBeat.m2505o(121465);
    }

    /* renamed from: Uz */
    public final void mo59044Uz(int i) {
        AppMethodBeat.m2504i(121466);
        mo59058fw(C37024f.m61941UB(i));
        AppMethodBeat.m2505o(121466);
    }

    /* renamed from: nT */
    public final void mo59060nT(long j) {
        AppMethodBeat.m2504i(121467);
        mo59047av(C37024f.m61959nW(j));
        AppMethodBeat.m2505o(121467);
    }

    /* renamed from: bs */
    public static int m61947bs(int i, int i2) {
        AppMethodBeat.m2504i(121468);
        int fv = C37024f.m61955fv(i) + C37024f.m61954ft(i2);
        AppMethodBeat.m2505o(121468);
        return fv;
    }

    /* renamed from: c */
    public static int m61948c(int i, C8185q c8185q) {
        AppMethodBeat.m2504i(121469);
        int fv = C37024f.m61955fv(i) + C37024f.m61950c(c8185q);
        AppMethodBeat.m2505o(121469);
        return fv;
    }

    /* renamed from: b */
    public static int m61945b(int i, C31710d c31710d) {
        AppMethodBeat.m2504i(121470);
        int fv = C37024f.m61955fv(i) + C37024f.m61949c(c31710d);
        AppMethodBeat.m2505o(121470);
        return fv;
    }

    /* renamed from: ip */
    public static int m61957ip(int i, int i2) {
        AppMethodBeat.m2504i(121471);
        int fv = C37024f.m61955fv(i) + C37024f.m61954ft(i2);
        AppMethodBeat.m2505o(121471);
        return fv;
    }

    /* renamed from: nU */
    public static int m61958nU(long j) {
        AppMethodBeat.m2504i(121472);
        int fv = C37024f.m61955fv(2) + C37024f.m61944aw(C37024f.m61959nW(j));
        AppMethodBeat.m2505o(121472);
        return fv;
    }

    /* renamed from: ft */
    public static int m61954ft(int i) {
        AppMethodBeat.m2504i(121473);
        if (i >= 0) {
            int fx = C37024f.m61956fx(i);
            AppMethodBeat.m2505o(121473);
            return fx;
        }
        AppMethodBeat.m2505o(121473);
        return 10;
    }

    /* renamed from: bf */
    public static int m61946bf(String str) {
        AppMethodBeat.m2504i(121474);
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length + C37024f.m61956fx(bytes.length);
            AppMethodBeat.m2505o(121474);
            return length;
        } catch (UnsupportedEncodingException e) {
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported.", e);
            AppMethodBeat.m2505o(121474);
            throw runtimeException;
        }
    }

    /* renamed from: c */
    public static int m61950c(C8185q c8185q) {
        AppMethodBeat.m2504i(121475);
        int vq = c8185q.mo144vq();
        vq += C37024f.m61956fx(vq);
        AppMethodBeat.m2505o(121475);
        return vq;
    }

    /* renamed from: a */
    public static int m61942a(C37025m c37025m) {
        AppMethodBeat.m2504i(121476);
        int vq = c37025m.mo59066vq();
        vq += C37024f.m61956fx(vq);
        AppMethodBeat.m2505o(121476);
        return vq;
    }

    /* renamed from: c */
    public static int m61949c(C31710d c31710d) {
        AppMethodBeat.m2504i(121477);
        int fx = C37024f.m61956fx(c31710d.size()) + c31710d.size();
        AppMethodBeat.m2505o(121477);
        return fx;
    }

    /* renamed from: cz */
    public static int m61952cz(byte[] bArr) {
        AppMethodBeat.m2504i(121478);
        int fx = C37024f.m61956fx(bArr.length) + bArr.length;
        AppMethodBeat.m2505o(121478);
        return fx;
    }

    private void eid() {
        AppMethodBeat.m2504i(121479);
        if (this.output == null) {
            C0118a c0118a = new C0118a();
            AppMethodBeat.m2505o(121479);
            throw c0118a;
        }
        this.output.write(this.buffer, 0, this.position);
        this.position = 0;
        AppMethodBeat.m2505o(121479);
    }

    public final void flush() {
        AppMethodBeat.m2504i(121480);
        if (this.output != null) {
            eid();
        }
        AppMethodBeat.m2505o(121480);
    }

    /* renamed from: c */
    private void m61951c(byte b) {
        AppMethodBeat.m2504i(121481);
        if (this.position == this.limit) {
            eid();
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
        this.Bzy++;
        AppMethodBeat.m2505o(121481);
    }

    /* renamed from: d */
    public final void mo59056d(C31710d c31710d) {
        AppMethodBeat.m2504i(121482);
        m61943a(c31710d, c31710d.size());
        AppMethodBeat.m2505o(121482);
    }

    /* renamed from: q */
    private void m61960q(byte[] bArr, int i) {
        AppMethodBeat.m2504i(121483);
        if (this.limit - this.position >= i) {
            System.arraycopy(bArr, 0, this.buffer, this.position, i);
            this.position += i;
        } else {
            int i2 = this.limit - this.position;
            System.arraycopy(bArr, 0, this.buffer, this.position, i2);
            int i3 = i2 + 0;
            i -= i2;
            this.position = this.limit;
            this.Bzy = i2 + this.Bzy;
            eid();
            if (i <= this.limit) {
                System.arraycopy(bArr, i3, this.buffer, 0, i);
                this.position = i;
            } else {
                this.output.write(bArr, i3, i);
            }
        }
        this.Bzy += i;
        AppMethodBeat.m2505o(121483);
    }

    /* renamed from: a */
    private void m61943a(C31710d c31710d, int i) {
        AppMethodBeat.m2504i(121484);
        if (this.limit - this.position >= i) {
            c31710d.mo51675f(this.buffer, 0, this.position, i);
            this.position += i;
        } else {
            int i2 = this.limit - this.position;
            c31710d.mo51675f(this.buffer, 0, this.position, i2);
            int i3 = i2 + 0;
            i -= i2;
            this.position = this.limit;
            this.Bzy = i2 + this.Bzy;
            eid();
            if (i <= this.limit) {
                c31710d.mo51675f(this.buffer, i3, 0, i);
                this.position = i;
            } else {
                c31710d.mo51673a(this.output, i3, i);
            }
        }
        this.Bzy += i;
        AppMethodBeat.m2505o(121484);
    }

    /* renamed from: bu */
    public final void mo59053bu(int i, int i2) {
        AppMethodBeat.m2504i(121485);
        mo59058fw(C17273z.m26753bv(i, i2));
        AppMethodBeat.m2505o(121485);
    }

    /* renamed from: fv */
    public static int m61955fv(int i) {
        AppMethodBeat.m2504i(121486);
        int fx = C37024f.m61956fx(C17273z.m26753bv(i, 0));
        AppMethodBeat.m2505o(121486);
        return fx;
    }

    /* renamed from: fw */
    public final void mo59058fw(int i) {
        AppMethodBeat.m2504i(121487);
        while ((i & -128) != 0) {
            m61951c((byte) ((i & C31128d.MIC_SketchMark) | 128));
            i >>>= 7;
        }
        m61951c((byte) i);
        AppMethodBeat.m2505o(121487);
    }

    /* renamed from: fx */
    public static int m61956fx(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    /* renamed from: av */
    public final void mo59047av(long j) {
        AppMethodBeat.m2504i(121488);
        while ((-128 & j) != 0) {
            m61951c((byte) ((((int) j) & C31128d.MIC_SketchMark) | 128));
            j >>>= 7;
        }
        m61951c((byte) ((int) j));
        AppMethodBeat.m2505o(121488);
    }

    /* renamed from: aw */
    public static int m61944aw(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    /* renamed from: UA */
    public final void mo59042UA(int i) {
        AppMethodBeat.m2504i(121489);
        m61951c((byte) (i & 255));
        m61951c((byte) ((i >> 8) & 255));
        m61951c((byte) ((i >> 16) & 255));
        m61951c((byte) ((i >> 24) & 255));
        AppMethodBeat.m2505o(121489);
    }

    /* renamed from: nV */
    public final void mo59061nV(long j) {
        AppMethodBeat.m2504i(121490);
        m61951c((byte) (((int) j) & 255));
        m61951c((byte) (((int) (j >> 8)) & 255));
        m61951c((byte) (((int) (j >> 16)) & 255));
        m61951c((byte) (((int) (j >> 24)) & 255));
        m61951c((byte) (((int) (j >> 32)) & 255));
        m61951c((byte) (((int) (j >> 40)) & 255));
        m61951c((byte) (((int) (j >> 48)) & 255));
        m61951c((byte) (((int) (j >> 56)) & 255));
        AppMethodBeat.m2505o(121490);
    }

    /* renamed from: UB */
    public static int m61941UB(int i) {
        return (i << 1) ^ (i >> 31);
    }

    /* renamed from: nW */
    public static long m61959nW(long j) {
        return (j << 1) ^ (j >> 63);
    }
}
