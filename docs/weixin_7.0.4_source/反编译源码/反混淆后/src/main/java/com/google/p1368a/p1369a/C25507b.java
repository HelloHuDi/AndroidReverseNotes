package com.google.p1368a.p1369a;

import com.tencent.view.C31128d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* renamed from: com.google.a.a.b */
public final class C25507b {
    private final byte[] buffer;
    final int limit;
    int position = 0;

    /* renamed from: com.google.a.a.b$a */
    public static class C25506a extends IOException {
        C25506a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    C25507b(byte[] bArr, int i) {
        this.buffer = bArr;
        this.limit = i + 0;
    }

    /* renamed from: l */
    public final void mo42765l(int i, long j) {
        m40267bu(i, 0);
        m40261av(j);
    }

    /* renamed from: m */
    public final void mo42766m(int i, long j) {
        m40267bu(i, 0);
        m40261av(j);
    }

    /* renamed from: bq */
    public final void mo42762bq(int i, int i2) {
        m40267bu(i, 0);
        if (i2 >= 0) {
            m40273fw(i2);
        } else {
            m40261av((long) i2);
        }
    }

    /* renamed from: e */
    public final void mo42764e(int i, String str) {
        m40267bu(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        m40273fw(bytes.length);
        m40277q(bytes, bytes.length);
    }

    /* renamed from: a */
    public final void mo42760a(int i, C25510e c25510e) {
        m40267bu(i, 2);
        m40273fw(c25510e.mo42768vp());
        c25510e.mo11878a(this);
    }

    /* renamed from: b */
    public final void mo42761b(int i, byte[] bArr) {
        m40267bu(i, 2);
        m40273fw(bArr.length);
        m40277q(bArr, bArr.length);
    }

    /* renamed from: br */
    public final void mo42763br(int i, int i2) {
        m40267bu(i, 0);
        m40273fw(i2);
    }

    /* renamed from: n */
    public static int m40275n(int i, long j) {
        return C25507b.m40272fv(i) + C25507b.m40262aw(j);
    }

    /* renamed from: o */
    public static int m40276o(int i, long j) {
        return C25507b.m40272fv(i) + C25507b.m40262aw(j);
    }

    /* renamed from: bs */
    public static int m40265bs(int i, int i2) {
        return C25507b.m40272fv(i) + C25507b.m40270ft(i2);
    }

    /* renamed from: f */
    public static int m40269f(int i, String str) {
        return C25507b.m40272fv(i) + C25507b.m40264bf(str);
    }

    /* renamed from: b */
    public static int m40263b(int i, C25510e c25510e) {
        int fv = C25507b.m40272fv(i);
        int vq = c25510e.mo42769vq();
        return fv + (vq + C25507b.m40274fx(vq));
    }

    /* renamed from: c */
    public static int m40268c(int i, byte[] bArr) {
        return C25507b.m40272fv(i) + (C25507b.m40274fx(bArr.length) + bArr.length);
    }

    /* renamed from: bt */
    public static int m40266bt(int i, int i2) {
        return C25507b.m40272fv(i) + C25507b.m40274fx(i2);
    }

    /* renamed from: ft */
    public static int m40270ft(int i) {
        if (i >= 0) {
            return C25507b.m40274fx(i);
        }
        return 10;
    }

    /* renamed from: bf */
    public static int m40264bf(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + C25507b.m40274fx(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    /* renamed from: fu */
    private void m40271fu(int i) {
        byte b = (byte) i;
        if (this.position == this.limit) {
            throw new C25506a(this.position, this.limit);
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    /* renamed from: q */
    private void m40277q(byte[] bArr, int i) {
        if (this.limit - this.position >= i) {
            System.arraycopy(bArr, 0, this.buffer, this.position, i);
            this.position += i;
            return;
        }
        throw new C25506a(this.position, this.limit);
    }

    /* renamed from: bu */
    private void m40267bu(int i, int i2) {
        m40273fw(C45015g.m82450bv(i, i2));
    }

    /* renamed from: fv */
    private static int m40272fv(int i) {
        return C25507b.m40274fx(C45015g.m82450bv(i, 0));
    }

    /* renamed from: fw */
    private void m40273fw(int i) {
        while ((i & -128) != 0) {
            m40271fu((i & C31128d.MIC_SketchMark) | 128);
            i >>>= 7;
        }
        m40271fu(i);
    }

    /* renamed from: fx */
    public static int m40274fx(int i) {
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
    private void m40261av(long j) {
        while ((-128 & j) != 0) {
            m40271fu((((int) j) & C31128d.MIC_SketchMark) | 128);
            j >>>= 7;
        }
        m40271fu((int) j);
    }

    /* renamed from: aw */
    private static int m40262aw(long j) {
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
