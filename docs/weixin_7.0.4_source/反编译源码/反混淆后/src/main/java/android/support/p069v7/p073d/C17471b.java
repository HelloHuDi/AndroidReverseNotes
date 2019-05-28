package android.support.p069v7.p073d;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.p057v4.p058a.C0284b;
import android.support.p057v4.p065f.C6197a;
import android.support.p057v4.widget.C8415j;
import android.util.SparseBooleanArray;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v7.d.b */
public final class C17471b {
    /* renamed from: XJ */
    static final C17472b f4015XJ = new C05931();
    /* renamed from: XE */
    public final List<C17473c> f4016XE;
    /* renamed from: XF */
    public final List<C37135c> f4017XF;
    /* renamed from: XG */
    public final Map<C37135c, C17473c> f4018XG = new C6197a();
    /* renamed from: XH */
    public final SparseBooleanArray f4019XH = new SparseBooleanArray();
    /* renamed from: XI */
    public final C17473c f4020XI = m27129fQ();

    /* renamed from: android.support.v7.d.b$1 */
    static class C05931 implements C17472b {
        C05931() {
        }

        /* renamed from: d */
        public final boolean mo1468d(float[] fArr) {
            int i;
            if (fArr[2] >= 0.95f) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                if (fArr[2] <= 0.05f) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    if (fArr[0] < 10.0f || fArr[0] > 37.0f || fArr[1] > 0.82f) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.d.b$b */
    public interface C17472b {
        /* renamed from: d */
        boolean mo1468d(float[] fArr);
    }

    /* renamed from: android.support.v7.d.b$c */
    public static final class C17473c {
        /* renamed from: XO */
        private final int f4021XO;
        /* renamed from: XP */
        private final int f4022XP;
        /* renamed from: XQ */
        private final int f4023XQ;
        /* renamed from: XR */
        public final int f4024XR;
        /* renamed from: XS */
        private boolean f4025XS;
        /* renamed from: XT */
        private int f4026XT;
        /* renamed from: XU */
        private int f4027XU;
        /* renamed from: XV */
        private float[] f4028XV;
        /* renamed from: Xw */
        public final int f4029Xw;

        public C17473c(int i, int i2) {
            this.f4021XO = Color.red(i);
            this.f4022XP = Color.green(i);
            this.f4023XQ = Color.blue(i);
            this.f4024XR = i;
            this.f4029Xw = i2;
        }

        /* renamed from: fR */
        public final float[] mo31818fR() {
            if (this.f4028XV == null) {
                this.f4028XV = new float[3];
            }
            C0284b.m471a(this.f4021XO, this.f4022XP, this.f4023XQ, this.f4028XV);
            return this.f4028XV;
        }

        /* renamed from: fS */
        public final int mo31819fS() {
            m27131fT();
            return this.f4027XU;
        }

        /* renamed from: fT */
        private void m27131fT() {
            if (!this.f4025XS) {
                int d = C0284b.m474d(-1, this.f4024XR, 4.5f);
                int d2 = C0284b.m474d(-1, this.f4024XR, 3.0f);
                if (d == -1 || d2 == -1) {
                    int d3 = C0284b.m474d(WebView.NIGHT_MODE_COLOR, this.f4024XR, 4.5f);
                    int d4 = C0284b.m474d(WebView.NIGHT_MODE_COLOR, this.f4024XR, 3.0f);
                    if (d3 == -1 || d4 == -1) {
                        if (d != -1) {
                            d = C0284b.m479u(-1, d);
                        } else {
                            d = C0284b.m479u(WebView.NIGHT_MODE_COLOR, d3);
                        }
                        this.f4027XU = d;
                        if (d2 != -1) {
                            d = C0284b.m479u(-1, d2);
                        } else {
                            d = C0284b.m479u(WebView.NIGHT_MODE_COLOR, d4);
                        }
                        this.f4026XT = d;
                        this.f4025XS = true;
                        return;
                    }
                    this.f4027XU = C0284b.m479u(WebView.NIGHT_MODE_COLOR, d3);
                    this.f4026XT = C0284b.m479u(WebView.NIGHT_MODE_COLOR, d4);
                    this.f4025XS = true;
                    return;
                }
                this.f4027XU = C0284b.m479u(-1, d);
                this.f4026XT = C0284b.m479u(-1, d2);
                this.f4025XS = true;
            }
        }

        public final String toString() {
            StringBuilder append = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.f4024XR)).append(']').append(" [HSL: ").append(Arrays.toString(mo31818fR())).append(']').append(" [Population: ").append(this.f4029Xw).append(']').append(" [Title Text: #");
            m27131fT();
            return append.append(Integer.toHexString(this.f4026XT)).append(']').append(" [Body Text: #").append(Integer.toHexString(mo31819fS())).append(']').toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C17473c c17473c = (C17473c) obj;
            if (this.f4029Xw == c17473c.f4029Xw && this.f4024XR == c17473c.f4024XR) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.f4024XR * 31) + this.f4029Xw;
        }
    }

    /* renamed from: android.support.v7.d.b$a */
    public static final class C17474a {
        /* renamed from: XE */
        public final List<C17473c> f4030XE;
        /* renamed from: XF */
        public final List<C37135c> f4031XF = new ArrayList();
        /* renamed from: XK */
        public int f4032XK = 16;
        /* renamed from: XL */
        public int f4033XL = 12544;
        /* renamed from: XM */
        public int f4034XM = -1;
        /* renamed from: XN */
        public Rect f4035XN;
        public final Bitmap mBitmap;
        public final List<C17472b> mFilters = new ArrayList();

        public C17474a(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            this.mFilters.add(C17471b.f4015XJ);
            this.mBitmap = bitmap;
            this.f4030XE = null;
            this.f4031XF.add(C37135c.f15826XW);
            this.f4031XF.add(C37135c.f15827XX);
            this.f4031XF.add(C37135c.f15828XY);
            this.f4031XF.add(C37135c.f15829XZ);
            this.f4031XF.add(C37135c.f15830Ya);
            this.f4031XF.add(C37135c.f15831Yb);
        }

        /* renamed from: e */
        public final int[] mo31822e(Bitmap bitmap) {
            int i = 0;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            if (this.f4035XN == null) {
                return iArr;
            }
            int width2 = this.f4035XN.width();
            int height2 = this.f4035XN.height();
            int[] iArr2 = new int[(width2 * height2)];
            while (i < height2) {
                System.arraycopy(iArr, ((this.f4035XN.top + i) * width) + this.f4035XN.left, iArr2, i * width2, width2);
                i++;
            }
            return iArr2;
        }
    }

    /* renamed from: d */
    public static C17474a m27128d(Bitmap bitmap) {
        return new C17474a(bitmap);
    }

    public C17471b(List<C17473c> list, List<C37135c> list2) {
        this.f4016XE = list;
        this.f4017XF = list2;
    }

    /* renamed from: fQ */
    private C17473c m27129fQ() {
        int i = C8415j.INVALID_ID;
        C17473c c17473c = null;
        int size = this.f4016XE.size();
        int i2 = 0;
        while (i2 < size) {
            C17473c c17473c2 = (C17473c) this.f4016XE.get(i2);
            if (c17473c2.f4029Xw > i) {
                i = c17473c2.f4029Xw;
            } else {
                c17473c2 = c17473c;
            }
            i2++;
            c17473c = c17473c2;
        }
        return c17473c;
    }
}
