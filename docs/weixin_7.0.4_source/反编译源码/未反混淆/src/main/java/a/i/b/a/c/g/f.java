package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class f {
    private int Bzy = 0;
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int position;

    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private f(OutputStream outputStream, byte[] bArr) {
        AppMethodBeat.i(121450);
        this.output = outputStream;
        this.buffer = bArr;
        this.position = 0;
        this.limit = bArr.length;
        AppMethodBeat.o(121450);
    }

    public static f e(OutputStream outputStream, int i) {
        AppMethodBeat.i(121451);
        f fVar = new f(outputStream, new byte[i]);
        AppMethodBeat.o(121451);
        return fVar;
    }

    public final void bq(int i, int i2) {
        AppMethodBeat.i(121452);
        bu(i, 0);
        Uy(i2);
        AppMethodBeat.o(121452);
    }

    public final void rP(boolean z) {
        AppMethodBeat.i(121453);
        bu(3, 0);
        rQ(z);
        AppMethodBeat.o(121453);
    }

    public final void a(int i, q qVar) {
        AppMethodBeat.i(121454);
        bu(i, 2);
        b(qVar);
        AppMethodBeat.o(121454);
    }

    public final void a(int i, d dVar) {
        AppMethodBeat.i(121455);
        bu(i, 2);
        b(dVar);
        AppMethodBeat.o(121455);
    }

    public final void io(int i, int i2) {
        AppMethodBeat.i(121456);
        bu(i, 0);
        Uy(i2);
        AppMethodBeat.o(121456);
    }

    public final void b(int i, q qVar) {
        AppMethodBeat.i(121457);
        bu(1, 3);
        bu(2, 0);
        fw(i);
        a(3, qVar);
        bu(1, 4);
        AppMethodBeat.o(121457);
    }

    public final void J(double d) {
        AppMethodBeat.i(121458);
        nV(Double.doubleToRawLongBits(d));
        AppMethodBeat.o(121458);
    }

    public final void bz(float f) {
        AppMethodBeat.i(121459);
        UA(Float.floatToRawIntBits(f));
        AppMethodBeat.o(121459);
    }

    public final void Uy(int i) {
        AppMethodBeat.i(121460);
        if (i >= 0) {
            fw(i);
            AppMethodBeat.o(121460);
            return;
        }
        av((long) i);
        AppMethodBeat.o(121460);
    }

    public final void rQ(boolean z) {
        int i;
        AppMethodBeat.i(121461);
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        c((byte) i);
        AppMethodBeat.o(121461);
    }

    public final void awd(String str) {
        AppMethodBeat.i(121462);
        byte[] bytes = str.getBytes("UTF-8");
        fw(bytes.length);
        q(bytes, bytes.length);
        AppMethodBeat.o(121462);
    }

    public final void b(q qVar) {
        AppMethodBeat.i(121463);
        fw(qVar.vq());
        qVar.a(this);
        AppMethodBeat.o(121463);
    }

    public final void b(d dVar) {
        AppMethodBeat.i(121464);
        fw(dVar.size());
        d(dVar);
        AppMethodBeat.o(121464);
    }

    public final void cy(byte[] bArr) {
        AppMethodBeat.i(121465);
        fw(bArr.length);
        q(bArr, bArr.length);
        AppMethodBeat.o(121465);
    }

    public final void Uz(int i) {
        AppMethodBeat.i(121466);
        fw(UB(i));
        AppMethodBeat.o(121466);
    }

    public final void nT(long j) {
        AppMethodBeat.i(121467);
        av(nW(j));
        AppMethodBeat.o(121467);
    }

    public static int bs(int i, int i2) {
        AppMethodBeat.i(121468);
        int fv = fv(i) + ft(i2);
        AppMethodBeat.o(121468);
        return fv;
    }

    public static int c(int i, q qVar) {
        AppMethodBeat.i(121469);
        int fv = fv(i) + c(qVar);
        AppMethodBeat.o(121469);
        return fv;
    }

    public static int b(int i, d dVar) {
        AppMethodBeat.i(121470);
        int fv = fv(i) + c(dVar);
        AppMethodBeat.o(121470);
        return fv;
    }

    public static int ip(int i, int i2) {
        AppMethodBeat.i(121471);
        int fv = fv(i) + ft(i2);
        AppMethodBeat.o(121471);
        return fv;
    }

    public static int nU(long j) {
        AppMethodBeat.i(121472);
        int fv = fv(2) + aw(nW(j));
        AppMethodBeat.o(121472);
        return fv;
    }

    public static int ft(int i) {
        AppMethodBeat.i(121473);
        if (i >= 0) {
            int fx = fx(i);
            AppMethodBeat.o(121473);
            return fx;
        }
        AppMethodBeat.o(121473);
        return 10;
    }

    public static int bf(String str) {
        AppMethodBeat.i(121474);
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length + fx(bytes.length);
            AppMethodBeat.o(121474);
            return length;
        } catch (UnsupportedEncodingException e) {
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported.", e);
            AppMethodBeat.o(121474);
            throw runtimeException;
        }
    }

    public static int c(q qVar) {
        AppMethodBeat.i(121475);
        int vq = qVar.vq();
        vq += fx(vq);
        AppMethodBeat.o(121475);
        return vq;
    }

    public static int a(m mVar) {
        AppMethodBeat.i(121476);
        int vq = mVar.vq();
        vq += fx(vq);
        AppMethodBeat.o(121476);
        return vq;
    }

    public static int c(d dVar) {
        AppMethodBeat.i(121477);
        int fx = fx(dVar.size()) + dVar.size();
        AppMethodBeat.o(121477);
        return fx;
    }

    public static int cz(byte[] bArr) {
        AppMethodBeat.i(121478);
        int fx = fx(bArr.length) + bArr.length;
        AppMethodBeat.o(121478);
        return fx;
    }

    private void eid() {
        AppMethodBeat.i(121479);
        if (this.output == null) {
            a aVar = new a();
            AppMethodBeat.o(121479);
            throw aVar;
        }
        this.output.write(this.buffer, 0, this.position);
        this.position = 0;
        AppMethodBeat.o(121479);
    }

    public final void flush() {
        AppMethodBeat.i(121480);
        if (this.output != null) {
            eid();
        }
        AppMethodBeat.o(121480);
    }

    private void c(byte b) {
        AppMethodBeat.i(121481);
        if (this.position == this.limit) {
            eid();
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
        this.Bzy++;
        AppMethodBeat.o(121481);
    }

    public final void d(d dVar) {
        AppMethodBeat.i(121482);
        a(dVar, dVar.size());
        AppMethodBeat.o(121482);
    }

    private void q(byte[] bArr, int i) {
        AppMethodBeat.i(121483);
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
        AppMethodBeat.o(121483);
    }

    private void a(d dVar, int i) {
        AppMethodBeat.i(121484);
        if (this.limit - this.position >= i) {
            dVar.f(this.buffer, 0, this.position, i);
            this.position += i;
        } else {
            int i2 = this.limit - this.position;
            dVar.f(this.buffer, 0, this.position, i2);
            int i3 = i2 + 0;
            i -= i2;
            this.position = this.limit;
            this.Bzy = i2 + this.Bzy;
            eid();
            if (i <= this.limit) {
                dVar.f(this.buffer, i3, 0, i);
                this.position = i;
            } else {
                dVar.a(this.output, i3, i);
            }
        }
        this.Bzy += i;
        AppMethodBeat.o(121484);
    }

    public final void bu(int i, int i2) {
        AppMethodBeat.i(121485);
        fw(z.bv(i, i2));
        AppMethodBeat.o(121485);
    }

    public static int fv(int i) {
        AppMethodBeat.i(121486);
        int fx = fx(z.bv(i, 0));
        AppMethodBeat.o(121486);
        return fx;
    }

    public final void fw(int i) {
        AppMethodBeat.i(121487);
        while ((i & -128) != 0) {
            c((byte) ((i & d.MIC_SketchMark) | 128));
            i >>>= 7;
        }
        c((byte) i);
        AppMethodBeat.o(121487);
    }

    public static int fx(int i) {
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

    public final void av(long j) {
        AppMethodBeat.i(121488);
        while ((-128 & j) != 0) {
            c((byte) ((((int) j) & d.MIC_SketchMark) | 128));
            j >>>= 7;
        }
        c((byte) ((int) j));
        AppMethodBeat.o(121488);
    }

    public static int aw(long j) {
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

    public final void UA(int i) {
        AppMethodBeat.i(121489);
        c((byte) (i & 255));
        c((byte) ((i >> 8) & 255));
        c((byte) ((i >> 16) & 255));
        c((byte) ((i >> 24) & 255));
        AppMethodBeat.o(121489);
    }

    public final void nV(long j) {
        AppMethodBeat.i(121490);
        c((byte) (((int) j) & 255));
        c((byte) (((int) (j >> 8)) & 255));
        c((byte) (((int) (j >> 16)) & 255));
        c((byte) (((int) (j >> 24)) & 255));
        c((byte) (((int) (j >> 32)) & 255));
        c((byte) (((int) (j >> 40)) & 255));
        c((byte) (((int) (j >> 48)) & 255));
        c((byte) (((int) (j >> 56)) & 255));
        AppMethodBeat.o(121490);
    }

    public static int UB(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static long nW(long j) {
        return (j << 1) ^ (j >> 63);
    }
}
