package android.support.p069v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.content.p062a.C0378b.C0377a;
import android.support.p057v4.widget.C0522b;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.widget.n */
class C0723n {
    final TextView ago;
    private C0698ba agp;
    private C0698ba agq;
    private C0698ba agr;
    private C0698ba ags;
    final C0725p agt;
    Typeface agu;
    boolean agv;
    int mStyle = 0;

    /* renamed from: e */
    static C0723n m1629e(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new C6260o(textView);
        }
        return new C0723n(textView);
    }

    C0723n(TextView textView) {
        this.ago = textView;
        this.agt = new C0725p(this.ago);
    }

    /* Access modifiers changed, original: 0000 */
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo2098a(AttributeSet attributeSet, int i) {
        C0699bc a;
        Context context = this.ago.getContext();
        C0716i hE = C0716i.m1606hE();
        C0699bc a2 = C0699bc.m1555a(context, attributeSet, C0554a.AppCompatTextHelper, i, 0);
        int resourceId = a2.getResourceId(0, -1);
        if (a2.hasValue(3)) {
            this.agp = C0723n.m1627a(context, hE, a2.getResourceId(3, 0));
        }
        if (a2.hasValue(1)) {
            this.agq = C0723n.m1627a(context, hE, a2.getResourceId(1, 0));
        }
        if (a2.hasValue(4)) {
            this.agr = C0723n.m1627a(context, hE, a2.getResourceId(4, 0));
        }
        if (a2.hasValue(2)) {
            this.ags = C0723n.m1627a(context, hE, a2.getResourceId(2, 0));
        }
        a2.atG.recycle();
        boolean z = this.ago.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z2 = false;
        Object obj = null;
        ColorStateList colorStateList = null;
        ColorStateList colorStateList2 = null;
        ColorStateList colorStateList3 = null;
        if (resourceId != -1) {
            a = C0699bc.m1553a(context, resourceId, C0554a.TextAppearance);
            if (!z && a.hasValue(11)) {
                obj = 1;
                z2 = a.getBoolean(11, false);
            }
            m1628a(context, a);
            if (VERSION.SDK_INT < 23) {
                if (a.hasValue(3)) {
                    colorStateList = a.getColorStateList(3);
                }
                if (a.hasValue(4)) {
                    colorStateList2 = a.getColorStateList(4);
                }
                if (a.hasValue(5)) {
                    colorStateList3 = a.getColorStateList(5);
                }
            }
            a.atG.recycle();
        }
        a = C0699bc.m1555a(context, attributeSet, C0554a.TextAppearance, i, 0);
        if (!z && a.hasValue(11)) {
            obj = 1;
            z2 = a.getBoolean(11, false);
        }
        if (VERSION.SDK_INT < 23) {
            if (a.hasValue(3)) {
                colorStateList = a.getColorStateList(3);
            }
            if (a.hasValue(4)) {
                colorStateList2 = a.getColorStateList(4);
            }
            if (a.hasValue(5)) {
                colorStateList3 = a.getColorStateList(5);
            }
        }
        m1628a(context, a);
        a.atG.recycle();
        if (colorStateList != null) {
            this.ago.setTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.ago.setHintTextColor(colorStateList2);
        }
        if (colorStateList3 != null) {
            this.ago.setLinkTextColor(colorStateList3);
        }
        if (!(z || r0 == null)) {
            setAllCaps(z2);
        }
        if (this.agu != null) {
            this.ago.setTypeface(this.agu, this.mStyle);
        }
        C0725p c0725p = this.agt;
        float f = -1.0f;
        float f2 = -1.0f;
        float f3 = -1.0f;
        TypedArray obtainStyledAttributes = c0725p.mContext.obtainStyledAttributes(attributeSet, C0554a.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(2)) {
            c0725p.agC = obtainStyledAttributes.getInt(2, 0);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            f3 = obtainStyledAttributes.getDimension(3, -1.0f);
        }
        if (obtainStyledAttributes.hasValue(5)) {
            f = obtainStyledAttributes.getDimension(5, -1.0f);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            f2 = obtainStyledAttributes.getDimension(6, -1.0f);
        }
        if (obtainStyledAttributes.hasValue(4)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(4, 0);
            if (resourceId2 > 0) {
                TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId2);
                int length = obtainTypedArray.length();
                int[] iArr = new int[length];
                if (length > 0) {
                    for (resourceId2 = 0; resourceId2 < length; resourceId2++) {
                        iArr[resourceId2] = obtainTypedArray.getDimensionPixelSize(resourceId2, -1);
                    }
                    c0725p.agH = C0725p.m1643f(iArr);
                    c0725p.mo2109hK();
                }
                obtainTypedArray.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        if (!c0725p.mo2113hP()) {
            c0725p.agC = 0;
        } else if (c0725p.agC == 1) {
            if (!c0725p.agI) {
                DisplayMetrics displayMetrics = c0725p.mContext.getResources().getDisplayMetrics();
                if (f == -1.0f) {
                    f = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (f2 == -1.0f) {
                    f2 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (f3 == -1.0f) {
                    f3 = 1.0f;
                }
                c0725p.mo2108f(f, f2, f3);
            }
            c0725p.mo2110hL();
        }
        if (C0522b.f699OV && this.agt.agC != 0) {
            int[] iArr2 = this.agt.agH;
            if (iArr2.length <= 0) {
                return;
            }
            if (((float) this.ago.getAutoSizeStepGranularity()) != -1.0f) {
                this.ago.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.agt.agF), Math.round(this.agt.agG), Math.round(this.agt.agE), 0);
            } else {
                this.ago.setAutoSizeTextTypeUniformWithPresetSizes(iArr2, 0);
            }
        }
    }

    /* renamed from: a */
    private void m1628a(Context context, C0699bc c0699bc) {
        int i = 12;
        this.mStyle = c0699bc.getInt(2, this.mStyle);
        if (c0699bc.hasValue(10) || c0699bc.hasValue(12)) {
            this.agu = null;
            if (!c0699bc.hasValue(12)) {
                i = 10;
            }
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.ago);
                try {
                    this.agu = c0699bc.mo2028a(i, this.mStyle, new C0377a() {
                        /* renamed from: b */
                        public final void mo664b(Typeface typeface) {
                            C0723n c0723n = C0723n.this;
                            WeakReference weakReference = weakReference;
                            if (c0723n.agv) {
                                c0723n.agu = typeface;
                                TextView textView = (TextView) weakReference.get();
                                if (textView != null) {
                                    textView.setTypeface(typeface, c0723n.mStyle);
                                }
                            }
                        }
                    });
                    this.agv = this.agu == null;
                } catch (NotFoundException | UnsupportedOperationException e) {
                }
            }
            if (this.agu == null) {
                String string = c0699bc.getString(i);
                if (string != null) {
                    this.agu = Typeface.create(string, this.mStyle);
                }
            }
        } else if (c0699bc.hasValue(1)) {
            this.agv = false;
            switch (c0699bc.getInt(1, 1)) {
                case 1:
                    this.agu = Typeface.SANS_SERIF;
                    return;
                case 2:
                    this.agu = Typeface.SERIF;
                    return;
                case 3:
                    this.agu = Typeface.MONOSPACE;
                    return;
                default:
                    return;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: r */
    public final void mo2101r(Context context, int i) {
        C0699bc a = C0699bc.m1553a(context, i, C0554a.TextAppearance);
        if (a.hasValue(11)) {
            setAllCaps(a.getBoolean(11, false));
        }
        if (VERSION.SDK_INT < 23 && a.hasValue(3)) {
            ColorStateList colorStateList = a.getColorStateList(3);
            if (colorStateList != null) {
                this.ago.setTextColor(colorStateList);
            }
        }
        m1628a(context, a);
        a.atG.recycle();
        if (this.agu != null) {
            this.ago.setTypeface(this.agu, this.mStyle);
        }
    }

    /* Access modifiers changed, original: final */
    public final void setAllCaps(boolean z) {
        this.ago.setAllCaps(z);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: hI */
    public void mo2099hI() {
        if (this.agp != null || this.agq != null || this.agr != null || this.ags != null) {
            Drawable[] compoundDrawables = this.ago.getCompoundDrawables();
            mo2097a(compoundDrawables[0], this.agp);
            mo2097a(compoundDrawables[1], this.agq);
            mo2097a(compoundDrawables[2], this.agr);
            mo2097a(compoundDrawables[3], this.ags);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo2097a(Drawable drawable, C0698ba c0698ba) {
        if (drawable != null && c0698ba != null) {
            C0716i.m1598a(drawable, c0698ba, this.ago.getDrawableState());
        }
    }

    /* renamed from: a */
    protected static C0698ba m1627a(Context context, C0716i c0716i, int i) {
        ColorStateList o = c0716i.mo2085o(context, i);
        if (o == null) {
            return null;
        }
        C0698ba c0698ba = new C0698ba();
        c0698ba.atE = true;
        c0698ba.atC = o;
        return c0698ba;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hJ */
    public final void mo2100hJ() {
        if (!C0522b.f699OV) {
            this.agt.mo2111hM();
        }
    }

    /* Access modifiers changed, original: final */
    public final void setTextSize(int i, float f) {
        if (!C0522b.f699OV && !this.agt.mo2112hO()) {
            m1630e(i, f);
        }
    }

    /* renamed from: e */
    private void m1630e(int i, float f) {
        this.agt.mo2107e(i, f);
    }

    /* Access modifiers changed, original: final */
    public final void setAutoSizeTextTypeWithDefaults(int i) {
        this.agt.setAutoSizeTextTypeWithDefaults(i);
    }

    /* Access modifiers changed, original: final */
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        this.agt.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    /* Access modifiers changed, original: final */
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        this.agt.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }
}
