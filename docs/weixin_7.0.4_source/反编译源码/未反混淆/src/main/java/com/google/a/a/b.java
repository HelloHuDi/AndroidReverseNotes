package com.google.a.a;

import com.tencent.view.d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class b {
    private final byte[] buffer;
    final int limit;
    int position = 0;

    public static class a extends IOException {
        a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    b(byte[] bArr, int i) {
        this.buffer = bArr;
        this.limit = i + 0;
    }

    public final void l(int i, long j) {
        bu(i, 0);
        av(j);
    }

    public final void m(int i, long j) {
        bu(i, 0);
        av(j);
    }

    public final void bq(int i, int i2) {
        bu(i, 0);
        if (i2 >= 0) {
            fw(i2);
        } else {
            av((long) i2);
        }
    }

    public final void e(int i, String str) {
        bu(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        fw(bytes.length);
        q(bytes, bytes.length);
    }

    public final void a(int i, e eVar) {
        bu(i, 2);
        fw(eVar.vp());
        eVar.a(this);
    }

    public final void b(int i, byte[] bArr) {
        bu(i, 2);
        fw(bArr.length);
        q(bArr, bArr.length);
    }

    public final void br(int i, int i2) {
        bu(i, 0);
        fw(i2);
    }

    public static int n(int i, long j) {
        return fv(i) + aw(j);
    }

    public static int o(int i, long j) {
        return fv(i) + aw(j);
    }

    public static int bs(int i, int i2) {
        return fv(i) + ft(i2);
    }

    public static int f(int i, String str) {
        return fv(i) + bf(str);
    }

    public static int b(int i, e eVar) {
        int fv = fv(i);
        int vq = eVar.vq();
        return fv + (vq + fx(vq));
    }

    public static int c(int i, byte[] bArr) {
        return fv(i) + (fx(bArr.length) + bArr.length);
    }

    public static int bt(int i, int i2) {
        return fv(i) + fx(i2);
    }

    public static int ft(int i) {
        if (i >= 0) {
            return fx(i);
        }
        return 10;
    }

    public static int bf(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + fx(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    private void fu(int i) {
        byte b = (byte) i;
        if (this.position == this.limit) {
            throw new a(this.position, this.limit);
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    private void q(byte[] bArr, int i) {
        if (this.limit - this.position >= i) {
            System.arraycopy(bArr, 0, this.buffer, this.position, i);
            this.position += i;
            return;
        }
        throw new a(this.position, this.limit);
    }

    private void bu(int i, int i2) {
        fw(g.bv(i, i2));
    }

    private static int fv(int i) {
        return fx(g.bv(i, 0));
    }

    private void fw(int i) {
        while ((i & -128) != 0) {
            fu((i & d.MIC_SketchMark) | 128);
            i >>>= 7;
        }
        fu(i);
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

    private void av(long j) {
        while ((-128 & j) != 0) {
            fu((((int) j) & d.MIC_SketchMark) | 128);
            j >>>= 7;
        }
        fu((int) j);
    }

    private static int aw(long j) {
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
