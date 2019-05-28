package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.e.c;
import android.support.v4.view.d;
import android.support.v4.view.s;
import android.support.v7.a.a.a;
import android.support.v7.widget.bc;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;
import com.google.android.gms.common.internal.GmsClientSupervisor;

final class f {
    private static final boolean nS = (VERSION.SDK_INT < 18);
    private static final Paint nT = null;
    private boolean hq;
    private float mScale;
    CharSequence mText;
    private final View mView;
    private boolean nU;
    float nV;
    private final Rect nW;
    private final Rect nX;
    private final RectF nY;
    int nZ = 16;
    Interpolator oA;
    private Interpolator oB;
    private float oC;
    private float oD;
    private float oE;
    private int oF;
    private float oG;
    private float oH;
    private float oI;
    private int oJ;
    int oa = 16;
    float ob = 15.0f;
    float oc = 15.0f;
    private ColorStateList od;
    ColorStateList oe;
    private float of;
    private float og;
    private float oh;
    private float oi;
    private float oj;
    private float ok;
    Typeface ol;
    Typeface om;
    private Typeface oo;
    private CharSequence oq;
    private boolean or;
    private Bitmap os;
    private Paint ot;
    private float ou;
    private float ov;
    private float ow;
    private int[] ox;
    private boolean oy;
    private final TextPaint oz;

    public f(View view) {
        this.mView = view;
        this.oz = new TextPaint(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
        this.nX = new Rect();
        this.nW = new Rect();
        this.nY = new RectF();
    }

    /* Access modifiers changed, original: final */
    public final void b(Interpolator interpolator) {
        this.oB = interpolator;
        bT();
    }

    /* Access modifiers changed, original: final */
    public final void b(ColorStateList colorStateList) {
        if (this.oe != colorStateList) {
            this.oe = colorStateList;
            bT();
        }
    }

    /* Access modifiers changed, original: final */
    public final void c(ColorStateList colorStateList) {
        if (this.od != colorStateList) {
            this.od = colorStateList;
            bT();
        }
    }

    /* Access modifiers changed, original: final */
    public final void c(int i, int i2, int i3, int i4) {
        if (!a(this.nW, i, i2, i3, i4)) {
            this.nW.set(i, i2, i3, i4);
            this.oy = true;
            bM();
        }
    }

    /* Access modifiers changed, original: final */
    public final void d(int i, int i2, int i3, int i4) {
        if (!a(this.nX, i, i2, i3, i4)) {
            this.nX.set(i, i2, i3, i4);
            this.oy = true;
            bM();
        }
    }

    private void bM() {
        boolean z = this.nX.width() > 0 && this.nX.height() > 0 && this.nW.width() > 0 && this.nW.height() > 0;
        this.nU = z;
    }

    /* Access modifiers changed, original: final */
    public final void P(int i) {
        if (this.nZ != i) {
            this.nZ = i;
            bT();
        }
    }

    /* Access modifiers changed, original: final */
    public final void Q(int i) {
        if (this.oa != i) {
            this.oa = i;
            bT();
        }
    }

    /* Access modifiers changed, original: final */
    public final void R(int i) {
        bc a = bc.a(this.mView.getContext(), i, a.TextAppearance);
        if (a.hasValue(3)) {
            this.oe = a.getColorStateList(3);
        }
        if (a.hasValue(0)) {
            this.oc = (float) a.getDimensionPixelSize(0, (int) this.oc);
        }
        this.oF = a.getInt(6, 0);
        this.oD = a.getFloat(7, 0.0f);
        this.oE = a.getFloat(8, 0.0f);
        this.oC = a.getFloat(9, 0.0f);
        a.atG.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.ol = T(i);
        }
        bT();
    }

    /* Access modifiers changed, original: final */
    public final void S(int i) {
        bc a = bc.a(this.mView.getContext(), i, a.TextAppearance);
        if (a.hasValue(3)) {
            this.od = a.getColorStateList(3);
        }
        if (a.hasValue(0)) {
            this.ob = (float) a.getDimensionPixelSize(0, (int) this.ob);
        }
        this.oJ = a.getInt(6, 0);
        this.oH = a.getFloat(7, 0.0f);
        this.oI = a.getFloat(8, 0.0f);
        this.oG = a.getFloat(9, 0.0f);
        a.atG.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.om = T(i);
        }
        bT();
    }

    private Typeface T(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(Typeface typeface) {
        this.om = typeface;
        this.ol = typeface;
        bT();
    }

    /* Access modifiers changed, original: final */
    public final Typeface bN() {
        return this.ol != null ? this.ol : Typeface.DEFAULT;
    }

    /* Access modifiers changed, original: final */
    public final void i(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.nV) {
            this.nV = f;
            bO();
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean setState(int[] iArr) {
        boolean z;
        this.ox = iArr;
        if ((this.oe == null || !this.oe.isStateful()) && (this.od == null || !this.od.isStateful())) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        bT();
        return true;
    }

    private void bO() {
        j(this.nV);
    }

    private void j(float f) {
        k(f);
        this.oj = a(this.oh, this.oi, f, this.oA);
        this.ok = a(this.of, this.og, f, this.oA);
        l(a(this.ob, this.oc, f, this.oB));
        if (this.oe != this.od) {
            this.oz.setColor(c(bP(), bQ(), f));
        } else {
            this.oz.setColor(bQ());
        }
        this.oz.setShadowLayer(a(this.oG, this.oC, f, null), a(this.oH, this.oD, f, null), a(this.oI, this.oE, f, null), c(this.oJ, this.oF, f));
        s.R(this.mView);
    }

    private int bP() {
        if (this.ox != null) {
            return this.od.getColorForState(this.ox, 0);
        }
        return this.od.getDefaultColor();
    }

    private int bQ() {
        if (this.ox != null) {
            return this.oe.getColorForState(this.ox, 0);
        }
        return this.oe.getDefaultColor();
    }

    private void bR() {
        int i;
        int i2 = 1;
        float f = 0.0f;
        float f2 = this.ow;
        m(this.oc);
        float measureText = this.oq != null ? this.oz.measureText(this.oq, 0, this.oq.length()) : 0.0f;
        int i3 = this.oa;
        if (this.hq) {
            i = 1;
        } else {
            i = 0;
        }
        i = d.getAbsoluteGravity(i3, i);
        switch (i & 112) {
            case 48:
                this.og = ((float) this.nX.top) - this.oz.ascent();
                break;
            case 80:
                this.og = (float) this.nX.bottom;
                break;
            default:
                this.og = (((this.oz.descent() - this.oz.ascent()) / 2.0f) - this.oz.descent()) + ((float) this.nX.centerY());
                break;
        }
        switch (i & 8388615) {
            case 1:
                this.oi = ((float) this.nX.centerX()) - (measureText / 2.0f);
                break;
            case 5:
                this.oi = ((float) this.nX.right) - measureText;
                break;
            default:
                this.oi = (float) this.nX.left;
                break;
        }
        m(this.ob);
        if (this.oq != null) {
            f = this.oz.measureText(this.oq, 0, this.oq.length());
        }
        int i4 = this.nZ;
        if (!this.hq) {
            i2 = 0;
        }
        i4 = d.getAbsoluteGravity(i4, i2);
        switch (i4 & 112) {
            case 48:
                this.of = ((float) this.nW.top) - this.oz.ascent();
                break;
            case 80:
                this.of = (float) this.nW.bottom;
                break;
            default:
                this.of = (((this.oz.descent() - this.oz.ascent()) / 2.0f) - this.oz.descent()) + ((float) this.nW.centerY());
                break;
        }
        switch (i4 & 8388615) {
            case 1:
                this.oh = ((float) this.nW.centerX()) - (f / 2.0f);
                break;
            case 5:
                this.oh = ((float) this.nW.right) - f;
                break;
            default:
                this.oh = (float) this.nW.left;
                break;
        }
        bU();
        l(f2);
    }

    private void k(float f) {
        this.nY.left = a((float) this.nW.left, (float) this.nX.left, f, this.oA);
        this.nY.top = a(this.of, this.og, f, this.oA);
        this.nY.right = a((float) this.nW.right, (float) this.nX.right, f, this.oA);
        this.nY.bottom = a((float) this.nW.bottom, (float) this.nX.bottom, f, this.oA);
    }

    public final void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.oq != null && this.nU) {
            float f;
            float f2 = this.oj;
            float f3 = this.ok;
            int i = (!this.or || this.os == null) ? 0 : 1;
            if (i != 0) {
                f = this.ou * this.mScale;
            } else {
                this.oz.ascent();
                f = 0.0f;
                this.oz.descent();
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.mScale != 1.0f) {
                canvas.scale(this.mScale, this.mScale, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.os, f2, f3, this.ot);
            } else {
                canvas.drawText(this.oq, 0, this.oq.length(), f2, f3, this.oz);
            }
        }
        canvas.restoreToCount(save);
    }

    private boolean a(CharSequence charSequence) {
        Object obj = 1;
        if (s.T(this.mView) != 1) {
            obj = null;
        }
        return (obj != null ? c.KK : c.KJ).a(charSequence, charSequence.length());
    }

    private void l(float f) {
        m(f);
        boolean z = nS && this.mScale != 1.0f;
        this.or = z;
        if (this.or) {
            bS();
        }
        s.R(this.mView);
    }

    static boolean a(Typeface typeface, Typeface typeface2) {
        return !(typeface == null || typeface.equals(typeface2)) || (typeface == null && typeface2 != null);
    }

    private void m(float f) {
        boolean z = true;
        if (this.mText != null) {
            float f2;
            boolean z2;
            float width = (float) this.nX.width();
            float width2 = (float) this.nW.width();
            if (n(f, this.oc)) {
                f2 = this.oc;
                this.mScale = 1.0f;
                if (a(this.oo, this.ol)) {
                    this.oo = this.ol;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                f2 = this.ob;
                if (a(this.oo, this.om)) {
                    this.oo = this.om;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (n(f, this.ob)) {
                    this.mScale = 1.0f;
                } else {
                    this.mScale = f / this.ob;
                }
                float f3 = this.oc / this.ob;
                width = width2 * f3 > width ? Math.min(width / f3, width2) : width2;
            }
            if (width > 0.0f) {
                if (this.ow != f2 || this.oy || r0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.ow = f2;
                this.oy = false;
            }
            if (this.oq == null || r0) {
                this.oz.setTextSize(this.ow);
                this.oz.setTypeface(this.oo);
                TextPaint textPaint = this.oz;
                if (this.mScale == 1.0f) {
                    z = false;
                }
                textPaint.setLinearText(z);
                CharSequence ellipsize = TextUtils.ellipsize(this.mText, this.oz, width, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.oq)) {
                    this.oq = ellipsize;
                    this.hq = a(this.oq);
                }
            }
        }
    }

    private void bS() {
        if (this.os == null && !this.nW.isEmpty() && !TextUtils.isEmpty(this.oq)) {
            j(0.0f);
            this.ou = this.oz.ascent();
            this.ov = this.oz.descent();
            int round = Math.round(this.oz.measureText(this.oq, 0, this.oq.length()));
            int round2 = Math.round(this.ov - this.ou);
            if (round > 0 && round2 > 0) {
                this.os = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.os).drawText(this.oq, 0, this.oq.length(), 0.0f, ((float) round2) - this.oz.descent(), this.oz);
                if (this.ot == null) {
                    this.ot = new Paint(3);
                }
            }
        }
    }

    public final void bT() {
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            bR();
            bO();
        }
    }

    /* Access modifiers changed, original: final */
    public final void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.oq = null;
            bU();
            bT();
        }
    }

    private void bU() {
        if (this.os != null) {
            this.os.recycle();
            this.os = null;
        }
    }

    private static boolean n(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static int c(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    private static float a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return a.b(f, f2, f3);
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
