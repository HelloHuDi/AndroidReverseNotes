package e.a.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.view.d;
import java.io.UnsupportedEncodingException;

public final class a {
    private final byte[] buffer;
    private final int limit;
    private int position = 0;

    public a(byte[] bArr, int i) {
        AppMethodBeat.i(51891);
        this.buffer = bArr;
        this.limit = i + 0;
        AppMethodBeat.o(51891);
    }

    public final void f(int i, double d) {
        AppMethodBeat.i(51892);
        bu(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        c((byte) (((int) doubleToLongBits) & 255));
        c((byte) (((int) (doubleToLongBits >> 8)) & 255));
        c((byte) (((int) (doubleToLongBits >> 16)) & 255));
        c((byte) (((int) (doubleToLongBits >> 24)) & 255));
        c((byte) (((int) (doubleToLongBits >> 32)) & 255));
        c((byte) (((int) (doubleToLongBits >> 40)) & 255));
        c((byte) (((int) (doubleToLongBits >> 48)) & 255));
        c((byte) (((int) (doubleToLongBits >> 56)) & 255));
        AppMethodBeat.o(51892);
    }

    public final void r(int i, float f) {
        AppMethodBeat.i(51893);
        bu(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        c((byte) (floatToIntBits & 255));
        c((byte) ((floatToIntBits >> 8) & 255));
        c((byte) ((floatToIntBits >> 16) & 255));
        c((byte) ((floatToIntBits >> 24) & 255));
        AppMethodBeat.o(51893);
    }

    public final void m(int i, long j) {
        AppMethodBeat.i(51894);
        bu(i, 0);
        av(j);
        AppMethodBeat.o(51894);
    }

    public final void bq(int i, int i2) {
        AppMethodBeat.i(51895);
        bu(i, 0);
        if (i2 >= 0) {
            fw(i2);
            AppMethodBeat.o(51895);
            return;
        }
        av((long) i2);
        AppMethodBeat.o(51895);
    }

    public final void aN(int i, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(51896);
        bu(i, 0);
        if (z) {
            i2 = 1;
        }
        c((byte) i2);
        AppMethodBeat.o(51896);
    }

    public final void e(int i, String str) {
        AppMethodBeat.i(51897);
        if (str == null) {
            AppMethodBeat.o(51897);
            return;
        }
        bu(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        fw(bytes.length);
        cC(bytes);
        AppMethodBeat.o(51897);
    }

    public final void a(int i, b bVar) {
        AppMethodBeat.i(51898);
        if (bVar == null) {
            AppMethodBeat.o(51898);
            return;
        }
        bu(i, 2);
        byte[] toByteArray = bVar.toByteArray();
        fw(toByteArray.length);
        cC(toByteArray);
        AppMethodBeat.o(51898);
    }

    public final void iy(int i, int i2) {
        AppMethodBeat.i(51899);
        bu(i, 2);
        fw(i2);
        AppMethodBeat.o(51899);
    }

    public static int o(int i, long j) {
        AppMethodBeat.i(51900);
        int fv = fv(i) + aw(j);
        AppMethodBeat.o(51900);
        return fv;
    }

    public static int bs(int i, int i2) {
        AppMethodBeat.i(51901);
        int fv;
        if (i2 >= 0) {
            fv = fv(i) + fx(i2);
            AppMethodBeat.o(51901);
            return fv;
        }
        fv = fv(i) + 10;
        AppMethodBeat.o(51901);
        return fv;
    }

    public static int f(int i, String str) {
        AppMethodBeat.i(51902);
        if (str == null) {
            AppMethodBeat.o(51902);
            return 0;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length + (fv(i) + fx(bytes.length));
            AppMethodBeat.o(51902);
            return length;
        } catch (UnsupportedEncodingException e) {
            IllegalStateException illegalStateException = new IllegalStateException("UTF-8 not supported.");
            AppMethodBeat.o(51902);
            throw illegalStateException;
        }
    }

    public static int b(int i, b bVar) {
        AppMethodBeat.i(51903);
        if (bVar == null) {
            AppMethodBeat.o(51903);
            return 0;
        }
        int fv = (fv(i) + fx(bVar.wR.length)) + bVar.wR.length;
        AppMethodBeat.o(51903);
        return fv;
    }

    private void c(byte b) {
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    private void cC(byte[] bArr) {
        AppMethodBeat.i(51904);
        if (bArr == null) {
            AppMethodBeat.o(51904);
            return;
        }
        q(bArr, bArr.length);
        AppMethodBeat.o(51904);
    }

    private void q(byte[] bArr, int i) {
        AppMethodBeat.i(51905);
        if (bArr == null) {
            AppMethodBeat.o(51905);
        } else if (this.limit - this.position >= i) {
            System.arraycopy(bArr, 0, this.buffer, this.position, i);
            this.position += i;
            AppMethodBeat.o(51905);
        } else {
            int i2 = this.limit - this.position;
            System.arraycopy(bArr, 0, this.buffer, this.position, i2);
            int i3 = i2 + 0;
            i2 = i - i2;
            this.position = this.limit;
            if (i2 <= this.limit) {
                System.arraycopy(bArr, i3, this.buffer, 0, i2);
                this.position = i2;
            }
            AppMethodBeat.o(51905);
        }
    }

    public final void bu(int i, int i2) {
        AppMethodBeat.i(51906);
        fw(e.a.a.b.a.bv(i, i2));
        AppMethodBeat.o(51906);
    }

    public static int fv(int i) {
        AppMethodBeat.i(51907);
        int fx = fx(e.a.a.b.a.bv(i, 0));
        AppMethodBeat.o(51907);
        return fx;
    }

    public final void fw(int i) {
        AppMethodBeat.i(51908);
        while ((i & -128) != 0) {
            c((byte) ((i & d.MIC_SketchMark) | 128));
            i >>>= 7;
        }
        c((byte) i);
        AppMethodBeat.o(51908);
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
        AppMethodBeat.i(51909);
        while ((-128 & j) != 0) {
            c((byte) ((((int) j) & d.MIC_SketchMark) | 128));
            j >>>= 7;
        }
        c((byte) ((int) j));
        AppMethodBeat.o(51909);
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
}
