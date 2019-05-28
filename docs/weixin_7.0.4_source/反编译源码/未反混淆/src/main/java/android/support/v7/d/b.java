package android.support.v7.d;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v4.widget.j;
import android.util.SparseBooleanArray;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b {
    static final b XJ = new b() {
        public final boolean d(float[] fArr) {
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
    };
    public final List<c> XE;
    public final List<c> XF;
    public final Map<c, c> XG = new android.support.v4.f.a();
    public final SparseBooleanArray XH = new SparseBooleanArray();
    public final c XI = fQ();

    public interface b {
        boolean d(float[] fArr);
    }

    public static final class c {
        private final int XO;
        private final int XP;
        private final int XQ;
        public final int XR;
        private boolean XS;
        private int XT;
        private int XU;
        private float[] XV;
        public final int Xw;

        public c(int i, int i2) {
            this.XO = Color.red(i);
            this.XP = Color.green(i);
            this.XQ = Color.blue(i);
            this.XR = i;
            this.Xw = i2;
        }

        public final float[] fR() {
            if (this.XV == null) {
                this.XV = new float[3];
            }
            android.support.v4.a.b.a(this.XO, this.XP, this.XQ, this.XV);
            return this.XV;
        }

        public final int fS() {
            fT();
            return this.XU;
        }

        private void fT() {
            if (!this.XS) {
                int d = android.support.v4.a.b.d(-1, this.XR, 4.5f);
                int d2 = android.support.v4.a.b.d(-1, this.XR, 3.0f);
                if (d == -1 || d2 == -1) {
                    int d3 = android.support.v4.a.b.d(WebView.NIGHT_MODE_COLOR, this.XR, 4.5f);
                    int d4 = android.support.v4.a.b.d(WebView.NIGHT_MODE_COLOR, this.XR, 3.0f);
                    if (d3 == -1 || d4 == -1) {
                        if (d != -1) {
                            d = android.support.v4.a.b.u(-1, d);
                        } else {
                            d = android.support.v4.a.b.u(WebView.NIGHT_MODE_COLOR, d3);
                        }
                        this.XU = d;
                        if (d2 != -1) {
                            d = android.support.v4.a.b.u(-1, d2);
                        } else {
                            d = android.support.v4.a.b.u(WebView.NIGHT_MODE_COLOR, d4);
                        }
                        this.XT = d;
                        this.XS = true;
                        return;
                    }
                    this.XU = android.support.v4.a.b.u(WebView.NIGHT_MODE_COLOR, d3);
                    this.XT = android.support.v4.a.b.u(WebView.NIGHT_MODE_COLOR, d4);
                    this.XS = true;
                    return;
                }
                this.XU = android.support.v4.a.b.u(-1, d);
                this.XT = android.support.v4.a.b.u(-1, d2);
                this.XS = true;
            }
        }

        public final String toString() {
            StringBuilder append = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.XR)).append(']').append(" [HSL: ").append(Arrays.toString(fR())).append(']').append(" [Population: ").append(this.Xw).append(']').append(" [Title Text: #");
            fT();
            return append.append(Integer.toHexString(this.XT)).append(']').append(" [Body Text: #").append(Integer.toHexString(fS())).append(']').toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.Xw == cVar.Xw && this.XR == cVar.XR) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.XR * 31) + this.Xw;
        }
    }

    public static final class a {
        public final List<c> XE;
        public final List<c> XF = new ArrayList();
        public int XK = 16;
        public int XL = 12544;
        public int XM = -1;
        public Rect XN;
        public final Bitmap mBitmap;
        public final List<b> mFilters = new ArrayList();

        public a(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            this.mFilters.add(b.XJ);
            this.mBitmap = bitmap;
            this.XE = null;
            this.XF.add(c.XW);
            this.XF.add(c.XX);
            this.XF.add(c.XY);
            this.XF.add(c.XZ);
            this.XF.add(c.Ya);
            this.XF.add(c.Yb);
        }

        public final int[] e(Bitmap bitmap) {
            int i = 0;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            if (this.XN == null) {
                return iArr;
            }
            int width2 = this.XN.width();
            int height2 = this.XN.height();
            int[] iArr2 = new int[(width2 * height2)];
            while (i < height2) {
                System.arraycopy(iArr, ((this.XN.top + i) * width) + this.XN.left, iArr2, i * width2, width2);
                i++;
            }
            return iArr2;
        }
    }

    public static a d(Bitmap bitmap) {
        return new a(bitmap);
    }

    public b(List<c> list, List<c> list2) {
        this.XE = list;
        this.XF = list2;
    }

    private c fQ() {
        int i = j.INVALID_ID;
        c cVar = null;
        int size = this.XE.size();
        int i2 = 0;
        while (i2 < size) {
            c cVar2 = (c) this.XE.get(i2);
            if (cVar2.Xw > i) {
                i = cVar2.Xw;
            } else {
                cVar2 = cVar;
            }
            i2++;
            cVar = cVar2;
        }
        return cVar;
    }
}
