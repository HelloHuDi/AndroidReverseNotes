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
import android.support.p057v4.p064e.C37118c;
import android.support.p057v4.view.C0456d;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.widget.C0699bc;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;
import com.google.android.gms.common.internal.GmsClientSupervisor;

/* renamed from: android.support.design.widget.f */
final class C44944f {
    /* renamed from: nS */
    private static final boolean f17615nS = (VERSION.SDK_INT < 18);
    /* renamed from: nT */
    private static final Paint f17616nT = null;
    /* renamed from: hq */
    private boolean f17617hq;
    private float mScale;
    CharSequence mText;
    private final View mView;
    /* renamed from: nU */
    private boolean f17618nU;
    /* renamed from: nV */
    float f17619nV;
    /* renamed from: nW */
    private final Rect f17620nW;
    /* renamed from: nX */
    private final Rect f17621nX;
    /* renamed from: nY */
    private final RectF f17622nY;
    /* renamed from: nZ */
    int f17623nZ = 16;
    /* renamed from: oA */
    Interpolator f17624oA;
    /* renamed from: oB */
    private Interpolator f17625oB;
    /* renamed from: oC */
    private float f17626oC;
    /* renamed from: oD */
    private float f17627oD;
    /* renamed from: oE */
    private float f17628oE;
    /* renamed from: oF */
    private int f17629oF;
    /* renamed from: oG */
    private float f17630oG;
    /* renamed from: oH */
    private float f17631oH;
    /* renamed from: oI */
    private float f17632oI;
    /* renamed from: oJ */
    private int f17633oJ;
    /* renamed from: oa */
    int f17634oa = 16;
    /* renamed from: ob */
    float f17635ob = 15.0f;
    /* renamed from: oc */
    float f17636oc = 15.0f;
    /* renamed from: od */
    private ColorStateList f17637od;
    /* renamed from: oe */
    ColorStateList f17638oe;
    /* renamed from: of */
    private float f17639of;
    /* renamed from: og */
    private float f17640og;
    /* renamed from: oh */
    private float f17641oh;
    /* renamed from: oi */
    private float f17642oi;
    /* renamed from: oj */
    private float f17643oj;
    /* renamed from: ok */
    private float f17644ok;
    /* renamed from: ol */
    Typeface f17645ol;
    /* renamed from: om */
    Typeface f17646om;
    /* renamed from: oo */
    private Typeface f17647oo;
    /* renamed from: oq */
    private CharSequence f17648oq;
    /* renamed from: or */
    private boolean f17649or;
    /* renamed from: os */
    private Bitmap f17650os;
    /* renamed from: ot */
    private Paint f17651ot;
    /* renamed from: ou */
    private float f17652ou;
    /* renamed from: ov */
    private float f17653ov;
    /* renamed from: ow */
    private float f17654ow;
    /* renamed from: ox */
    private int[] f17655ox;
    /* renamed from: oy */
    private boolean f17656oy;
    /* renamed from: oz */
    private final TextPaint f17657oz;

    public C44944f(View view) {
        this.mView = view;
        this.f17657oz = new TextPaint(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
        this.f17621nX = new Rect();
        this.f17620nW = new Rect();
        this.f17622nY = new RectF();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo72151b(Interpolator interpolator) {
        this.f17625oB = interpolator;
        mo72153bT();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo72150b(ColorStateList colorStateList) {
        if (this.f17638oe != colorStateList) {
            this.f17638oe = colorStateList;
            mo72153bT();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo72155c(ColorStateList colorStateList) {
        if (this.f17637od != colorStateList) {
            this.f17637od = colorStateList;
            mo72153bT();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo72154c(int i, int i2, int i3, int i4) {
        if (!C44944f.m82181a(this.f17620nW, i, i2, i3, i4)) {
            this.f17620nW.set(i, i2, i3, i4);
            this.f17656oy = true;
            m82184bM();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo72156d(int i, int i2, int i3, int i4) {
        if (!C44944f.m82181a(this.f17621nX, i, i2, i3, i4)) {
            this.f17621nX.set(i, i2, i3, i4);
            this.f17656oy = true;
            m82184bM();
        }
    }

    /* renamed from: bM */
    private void m82184bM() {
        boolean z = this.f17621nX.width() > 0 && this.f17621nX.height() > 0 && this.f17620nW.width() > 0 && this.f17620nW.height() > 0;
        this.f17618nU = z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: P */
    public final void mo72145P(int i) {
        if (this.f17623nZ != i) {
            this.f17623nZ = i;
            mo72153bT();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Q */
    public final void mo72146Q(int i) {
        if (this.f17634oa != i) {
            this.f17634oa = i;
            mo72153bT();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: R */
    public final void mo72147R(int i) {
        C0699bc a = C0699bc.m1553a(this.mView.getContext(), i, C0554a.TextAppearance);
        if (a.hasValue(3)) {
            this.f17638oe = a.getColorStateList(3);
        }
        if (a.hasValue(0)) {
            this.f17636oc = (float) a.getDimensionPixelSize(0, (int) this.f17636oc);
        }
        this.f17629oF = a.getInt(6, 0);
        this.f17627oD = a.getFloat(7, 0.0f);
        this.f17628oE = a.getFloat(8, 0.0f);
        this.f17626oC = a.getFloat(9, 0.0f);
        a.atG.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f17645ol = m82179T(i);
        }
        mo72153bT();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: S */
    public final void mo72148S(int i) {
        C0699bc a = C0699bc.m1553a(this.mView.getContext(), i, C0554a.TextAppearance);
        if (a.hasValue(3)) {
            this.f17637od = a.getColorStateList(3);
        }
        if (a.hasValue(0)) {
            this.f17635ob = (float) a.getDimensionPixelSize(0, (int) this.f17635ob);
        }
        this.f17633oJ = a.getInt(6, 0);
        this.f17631oH = a.getFloat(7, 0.0f);
        this.f17632oI = a.getFloat(8, 0.0f);
        this.f17630oG = a.getFloat(9, 0.0f);
        a.atG.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f17646om = m82179T(i);
        }
        mo72153bT();
    }

    /* renamed from: T */
    private Typeface m82179T(int i) {
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
    /* renamed from: a */
    public final void mo72149a(Typeface typeface) {
        this.f17646om = typeface;
        this.f17645ol = typeface;
        mo72153bT();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bN */
    public final Typeface mo72152bN() {
        return this.f17645ol != null ? this.f17645ol : Typeface.DEFAULT;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: i */
    public final void mo72158i(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.f17619nV) {
            this.f17619nV = f;
            m82185bO();
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean setState(int[] iArr) {
        boolean z;
        this.f17655ox = iArr;
        if ((this.f17638oe == null || !this.f17638oe.isStateful()) && (this.f17637od == null || !this.f17637od.isStateful())) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        mo72153bT();
        return true;
    }

    /* renamed from: bO */
    private void m82185bO() {
        m82192j(this.f17619nV);
    }

    /* renamed from: j */
    private void m82192j(float f) {
        m82193k(f);
        this.f17643oj = C44944f.m82180a(this.f17641oh, this.f17642oi, f, this.f17624oA);
        this.f17644ok = C44944f.m82180a(this.f17639of, this.f17640og, f, this.f17624oA);
        m82194l(C44944f.m82180a(this.f17635ob, this.f17636oc, f, this.f17625oB));
        if (this.f17638oe != this.f17637od) {
            this.f17657oz.setColor(C44944f.m82191c(m82186bP(), m82187bQ(), f));
        } else {
            this.f17657oz.setColor(m82187bQ());
        }
        this.f17657oz.setShadowLayer(C44944f.m82180a(this.f17630oG, this.f17626oC, f, null), C44944f.m82180a(this.f17631oH, this.f17627oD, f, null), C44944f.m82180a(this.f17632oI, this.f17628oE, f, null), C44944f.m82191c(this.f17633oJ, this.f17629oF, f));
        C0477s.m891R(this.mView);
    }

    /* renamed from: bP */
    private int m82186bP() {
        if (this.f17655ox != null) {
            return this.f17637od.getColorForState(this.f17655ox, 0);
        }
        return this.f17637od.getDefaultColor();
    }

    /* renamed from: bQ */
    private int m82187bQ() {
        if (this.f17655ox != null) {
            return this.f17638oe.getColorForState(this.f17655ox, 0);
        }
        return this.f17638oe.getDefaultColor();
    }

    /* renamed from: bR */
    private void m82188bR() {
        int i;
        int i2 = 1;
        float f = 0.0f;
        float f2 = this.f17654ow;
        m82195m(this.f17636oc);
        float measureText = this.f17648oq != null ? this.f17657oz.measureText(this.f17648oq, 0, this.f17648oq.length()) : 0.0f;
        int i3 = this.f17634oa;
        if (this.f17617hq) {
            i = 1;
        } else {
            i = 0;
        }
        i = C0456d.getAbsoluteGravity(i3, i);
        switch (i & 112) {
            case 48:
                this.f17640og = ((float) this.f17621nX.top) - this.f17657oz.ascent();
                break;
            case 80:
                this.f17640og = (float) this.f17621nX.bottom;
                break;
            default:
                this.f17640og = (((this.f17657oz.descent() - this.f17657oz.ascent()) / 2.0f) - this.f17657oz.descent()) + ((float) this.f17621nX.centerY());
                break;
        }
        switch (i & 8388615) {
            case 1:
                this.f17642oi = ((float) this.f17621nX.centerX()) - (measureText / 2.0f);
                break;
            case 5:
                this.f17642oi = ((float) this.f17621nX.right) - measureText;
                break;
            default:
                this.f17642oi = (float) this.f17621nX.left;
                break;
        }
        m82195m(this.f17635ob);
        if (this.f17648oq != null) {
            f = this.f17657oz.measureText(this.f17648oq, 0, this.f17648oq.length());
        }
        int i4 = this.f17623nZ;
        if (!this.f17617hq) {
            i2 = 0;
        }
        i4 = C0456d.getAbsoluteGravity(i4, i2);
        switch (i4 & 112) {
            case 48:
                this.f17639of = ((float) this.f17620nW.top) - this.f17657oz.ascent();
                break;
            case 80:
                this.f17639of = (float) this.f17620nW.bottom;
                break;
            default:
                this.f17639of = (((this.f17657oz.descent() - this.f17657oz.ascent()) / 2.0f) - this.f17657oz.descent()) + ((float) this.f17620nW.centerY());
                break;
        }
        switch (i4 & 8388615) {
            case 1:
                this.f17641oh = ((float) this.f17620nW.centerX()) - (f / 2.0f);
                break;
            case 5:
                this.f17641oh = ((float) this.f17620nW.right) - f;
                break;
            default:
                this.f17641oh = (float) this.f17620nW.left;
                break;
        }
        m82190bU();
        m82194l(f2);
    }

    /* renamed from: k */
    private void m82193k(float f) {
        this.f17622nY.left = C44944f.m82180a((float) this.f17620nW.left, (float) this.f17621nX.left, f, this.f17624oA);
        this.f17622nY.top = C44944f.m82180a(this.f17639of, this.f17640og, f, this.f17624oA);
        this.f17622nY.right = C44944f.m82180a((float) this.f17620nW.right, (float) this.f17621nX.right, f, this.f17624oA);
        this.f17622nY.bottom = C44944f.m82180a((float) this.f17620nW.bottom, (float) this.f17621nX.bottom, f, this.f17624oA);
    }

    public final void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.f17648oq != null && this.f17618nU) {
            float f;
            float f2 = this.f17643oj;
            float f3 = this.f17644ok;
            int i = (!this.f17649or || this.f17650os == null) ? 0 : 1;
            if (i != 0) {
                f = this.f17652ou * this.mScale;
            } else {
                this.f17657oz.ascent();
                f = 0.0f;
                this.f17657oz.descent();
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.mScale != 1.0f) {
                canvas.scale(this.mScale, this.mScale, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.f17650os, f2, f3, this.f17651ot);
            } else {
                canvas.drawText(this.f17648oq, 0, this.f17648oq.length(), f2, f3, this.f17657oz);
            }
        }
        canvas.restoreToCount(save);
    }

    /* renamed from: a */
    private boolean m82183a(CharSequence charSequence) {
        Object obj = 1;
        if (C0477s.m893T(this.mView) != 1) {
            obj = null;
        }
        return (obj != null ? C37118c.f15771KK : C37118c.f15770KJ).mo707a(charSequence, charSequence.length());
    }

    /* renamed from: l */
    private void m82194l(float f) {
        m82195m(f);
        boolean z = f17615nS && this.mScale != 1.0f;
        this.f17649or = z;
        if (this.f17649or) {
            m82189bS();
        }
        C0477s.m891R(this.mView);
    }

    /* renamed from: a */
    static boolean m82182a(Typeface typeface, Typeface typeface2) {
        return !(typeface == null || typeface.equals(typeface2)) || (typeface == null && typeface2 != null);
    }

    /* renamed from: m */
    private void m82195m(float f) {
        boolean z = true;
        if (this.mText != null) {
            float f2;
            boolean z2;
            float width = (float) this.f17621nX.width();
            float width2 = (float) this.f17620nW.width();
            if (C44944f.m82196n(f, this.f17636oc)) {
                f2 = this.f17636oc;
                this.mScale = 1.0f;
                if (C44944f.m82182a(this.f17647oo, this.f17645ol)) {
                    this.f17647oo = this.f17645ol;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                f2 = this.f17635ob;
                if (C44944f.m82182a(this.f17647oo, this.f17646om)) {
                    this.f17647oo = this.f17646om;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (C44944f.m82196n(f, this.f17635ob)) {
                    this.mScale = 1.0f;
                } else {
                    this.mScale = f / this.f17635ob;
                }
                float f3 = this.f17636oc / this.f17635ob;
                width = width2 * f3 > width ? Math.min(width / f3, width2) : width2;
            }
            if (width > 0.0f) {
                if (this.f17654ow != f2 || this.f17656oy || r0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f17654ow = f2;
                this.f17656oy = false;
            }
            if (this.f17648oq == null || r0) {
                this.f17657oz.setTextSize(this.f17654ow);
                this.f17657oz.setTypeface(this.f17647oo);
                TextPaint textPaint = this.f17657oz;
                if (this.mScale == 1.0f) {
                    z = false;
                }
                textPaint.setLinearText(z);
                CharSequence ellipsize = TextUtils.ellipsize(this.mText, this.f17657oz, width, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.f17648oq)) {
                    this.f17648oq = ellipsize;
                    this.f17617hq = m82183a(this.f17648oq);
                }
            }
        }
    }

    /* renamed from: bS */
    private void m82189bS() {
        if (this.f17650os == null && !this.f17620nW.isEmpty() && !TextUtils.isEmpty(this.f17648oq)) {
            m82192j(0.0f);
            this.f17652ou = this.f17657oz.ascent();
            this.f17653ov = this.f17657oz.descent();
            int round = Math.round(this.f17657oz.measureText(this.f17648oq, 0, this.f17648oq.length()));
            int round2 = Math.round(this.f17653ov - this.f17652ou);
            if (round > 0 && round2 > 0) {
                this.f17650os = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.f17650os).drawText(this.f17648oq, 0, this.f17648oq.length(), 0.0f, ((float) round2) - this.f17657oz.descent(), this.f17657oz);
                if (this.f17651ot == null) {
                    this.f17651ot = new Paint(3);
                }
            }
        }
    }

    /* renamed from: bT */
    public final void mo72153bT() {
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            m82188bR();
            m82185bO();
        }
    }

    /* Access modifiers changed, original: final */
    public final void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.f17648oq = null;
            m82190bU();
            mo72153bT();
        }
    }

    /* renamed from: bU */
    private void m82190bU() {
        if (this.f17650os != null) {
            this.f17650os.recycle();
            this.f17650os = null;
        }
    }

    /* renamed from: n */
    private static boolean m82196n(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    /* renamed from: c */
    private static int m82191c(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    /* renamed from: a */
    private static float m82180a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return C31841a.m51586b(f, f2, f3);
    }

    /* renamed from: a */
    private static boolean m82181a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
