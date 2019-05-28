package p690e.p691a.p692a.p695b.p697b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.view.C31128d;
import java.io.UnsupportedEncodingException;
import p690e.p691a.p692a.p695b.C6090a;

/* renamed from: e.a.a.b.b.a */
public final class C6091a {
    private final byte[] buffer;
    private final int limit;
    private int position = 0;

    public C6091a(byte[] bArr, int i) {
        AppMethodBeat.m2504i(51891);
        this.buffer = bArr;
        this.limit = i + 0;
        AppMethodBeat.m2505o(51891);
    }

    /* renamed from: f */
    public final void mo13466f(int i, double d) {
        AppMethodBeat.m2504i(51892);
        mo13464bu(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        m9573c((byte) (((int) doubleToLongBits) & 255));
        m9573c((byte) (((int) (doubleToLongBits >> 8)) & 255));
        m9573c((byte) (((int) (doubleToLongBits >> 16)) & 255));
        m9573c((byte) (((int) (doubleToLongBits >> 24)) & 255));
        m9573c((byte) (((int) (doubleToLongBits >> 32)) & 255));
        m9573c((byte) (((int) (doubleToLongBits >> 40)) & 255));
        m9573c((byte) (((int) (doubleToLongBits >> 48)) & 255));
        m9573c((byte) (((int) (doubleToLongBits >> 56)) & 255));
        AppMethodBeat.m2505o(51892);
    }

    /* renamed from: r */
    public final void mo13470r(int i, float f) {
        AppMethodBeat.m2504i(51893);
        mo13464bu(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        m9573c((byte) (floatToIntBits & 255));
        m9573c((byte) ((floatToIntBits >> 8) & 255));
        m9573c((byte) ((floatToIntBits >> 16) & 255));
        m9573c((byte) ((floatToIntBits >> 24) & 255));
        AppMethodBeat.m2505o(51893);
    }

    /* renamed from: m */
    public final void mo13469m(int i, long j) {
        AppMethodBeat.m2504i(51894);
        mo13464bu(i, 0);
        mo13462av(j);
        AppMethodBeat.m2505o(51894);
    }

    /* renamed from: bq */
    public final void mo13463bq(int i, int i2) {
        AppMethodBeat.m2504i(51895);
        mo13464bu(i, 0);
        if (i2 >= 0) {
            mo13467fw(i2);
            AppMethodBeat.m2505o(51895);
            return;
        }
        mo13462av((long) i2);
        AppMethodBeat.m2505o(51895);
    }

    /* renamed from: aN */
    public final void mo13461aN(int i, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(51896);
        mo13464bu(i, 0);
        if (z) {
            i2 = 1;
        }
        m9573c((byte) i2);
        AppMethodBeat.m2505o(51896);
    }

    /* renamed from: e */
    public final void mo13465e(int i, String str) {
        AppMethodBeat.m2504i(51897);
        if (str == null) {
            AppMethodBeat.m2505o(51897);
            return;
        }
        mo13464bu(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        mo13467fw(bytes.length);
        m9574cC(bytes);
        AppMethodBeat.m2505o(51897);
    }

    /* renamed from: a */
    public final void mo13460a(int i, C1332b c1332b) {
        AppMethodBeat.m2504i(51898);
        if (c1332b == null) {
            AppMethodBeat.m2505o(51898);
            return;
        }
        mo13464bu(i, 2);
        byte[] toByteArray = c1332b.toByteArray();
        mo13467fw(toByteArray.length);
        m9574cC(toByteArray);
        AppMethodBeat.m2505o(51898);
    }

    /* renamed from: iy */
    public final void mo13468iy(int i, int i2) {
        AppMethodBeat.m2504i(51899);
        mo13464bu(i, 2);
        mo13467fw(i2);
        AppMethodBeat.m2505o(51899);
    }

    /* renamed from: o */
    public static int m9578o(int i, long j) {
        AppMethodBeat.m2504i(51900);
        int fv = C6091a.m9576fv(i) + C6091a.m9570aw(j);
        AppMethodBeat.m2505o(51900);
        return fv;
    }

    /* renamed from: bs */
    public static int m9572bs(int i, int i2) {
        AppMethodBeat.m2504i(51901);
        int fv;
        if (i2 >= 0) {
            fv = C6091a.m9576fv(i) + C6091a.m9577fx(i2);
            AppMethodBeat.m2505o(51901);
            return fv;
        }
        fv = C6091a.m9576fv(i) + 10;
        AppMethodBeat.m2505o(51901);
        return fv;
    }

    /* renamed from: f */
    public static int m9575f(int i, String str) {
        AppMethodBeat.m2504i(51902);
        if (str == null) {
            AppMethodBeat.m2505o(51902);
            return 0;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length + (C6091a.m9576fv(i) + C6091a.m9577fx(bytes.length));
            AppMethodBeat.m2505o(51902);
            return length;
        } catch (UnsupportedEncodingException e) {
            IllegalStateException illegalStateException = new IllegalStateException("UTF-8 not supported.");
            AppMethodBeat.m2505o(51902);
            throw illegalStateException;
        }
    }

    /* renamed from: b */
    public static int m9571b(int i, C1332b c1332b) {
        AppMethodBeat.m2504i(51903);
        if (c1332b == null) {
            AppMethodBeat.m2505o(51903);
            return 0;
        }
        int fv = (C6091a.m9576fv(i) + C6091a.m9577fx(c1332b.f1226wR.length)) + c1332b.f1226wR.length;
        AppMethodBeat.m2505o(51903);
        return fv;
    }

    /* renamed from: c */
    private void m9573c(byte b) {
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    /* renamed from: cC */
    private void m9574cC(byte[] bArr) {
        AppMethodBeat.m2504i(51904);
        if (bArr == null) {
            AppMethodBeat.m2505o(51904);
            return;
        }
        m9579q(bArr, bArr.length);
        AppMethodBeat.m2505o(51904);
    }

    /* renamed from: q */
    private void m9579q(byte[] bArr, int i) {
        AppMethodBeat.m2504i(51905);
        if (bArr == null) {
            AppMethodBeat.m2505o(51905);
        } else if (this.limit - this.position >= i) {
            System.arraycopy(bArr, 0, this.buffer, this.position, i);
            this.position += i;
            AppMethodBeat.m2505o(51905);
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
            AppMethodBeat.m2505o(51905);
        }
    }

    /* renamed from: bu */
    public final void mo13464bu(int i, int i2) {
        AppMethodBeat.m2504i(51906);
        mo13467fw(C6090a.m9567bv(i, i2));
        AppMethodBeat.m2505o(51906);
    }

    /* renamed from: fv */
    public static int m9576fv(int i) {
        AppMethodBeat.m2504i(51907);
        int fx = C6091a.m9577fx(C6090a.m9567bv(i, 0));
        AppMethodBeat.m2505o(51907);
        return fx;
    }

    /* renamed from: fw */
    public final void mo13467fw(int i) {
        AppMethodBeat.m2504i(51908);
        while ((i & -128) != 0) {
            m9573c((byte) ((i & C31128d.MIC_SketchMark) | 128));
            i >>>= 7;
        }
        m9573c((byte) i);
        AppMethodBeat.m2505o(51908);
    }

    /* renamed from: fx */
    public static int m9577fx(int i) {
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
    public final void mo13462av(long j) {
        AppMethodBeat.m2504i(51909);
        while ((-128 & j) != 0) {
            m9573c((byte) ((((int) j) & C31128d.MIC_SketchMark) | 128));
            j >>>= 7;
        }
        m9573c((byte) ((int) j));
        AppMethodBeat.m2505o(51909);
    }

    /* renamed from: aw */
    public static int m9570aw(long j) {
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
