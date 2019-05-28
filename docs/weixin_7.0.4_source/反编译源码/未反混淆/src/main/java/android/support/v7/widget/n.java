package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.b;
import android.support.v7.a.a.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class n {
    final TextView ago;
    private ba agp;
    private ba agq;
    private ba agr;
    private ba ags;
    final p agt;
    Typeface agu;
    boolean agv;
    int mStyle = 0;

    static n e(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new o(textView);
        }
        return new n(textView);
    }

    n(TextView textView) {
        this.ago = textView;
        this.agt = new p(this.ago);
    }

    /* Access modifiers changed, original: 0000 */
    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i) {
        bc a;
        Context context = this.ago.getContext();
        i hE = i.hE();
        bc a2 = bc.a(context, attributeSet, a.AppCompatTextHelper, i, 0);
        int resourceId = a2.getResourceId(0, -1);
        if (a2.hasValue(3)) {
            this.agp = a(context, hE, a2.getResourceId(3, 0));
        }
        if (a2.hasValue(1)) {
            this.agq = a(context, hE, a2.getResourceId(1, 0));
        }
        if (a2.hasValue(4)) {
            this.agr = a(context, hE, a2.getResourceId(4, 0));
        }
        if (a2.hasValue(2)) {
            this.ags = a(context, hE, a2.getResourceId(2, 0));
        }
        a2.atG.recycle();
        boolean z = this.ago.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z2 = false;
        Object obj = null;
        ColorStateList colorStateList = null;
        ColorStateList colorStateList2 = null;
        ColorStateList colorStateList3 = null;
        if (resourceId != -1) {
            a = bc.a(context, resourceId, a.TextAppearance);
            if (!z && a.hasValue(11)) {
                obj = 1;
                z2 = a.getBoolean(11, false);
            }
            a(context, a);
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
        a = bc.a(context, attributeSet, a.TextAppearance, i, 0);
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
        a(context, a);
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
        p pVar = this.agt;
        float f = -1.0f;
        float f2 = -1.0f;
        float f3 = -1.0f;
        TypedArray obtainStyledAttributes = pVar.mContext.obtainStyledAttributes(attributeSet, a.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(2)) {
            pVar.agC = obtainStyledAttributes.getInt(2, 0);
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
                    pVar.agH = p.f(iArr);
                    pVar.hK();
                }
                obtainTypedArray.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        if (!pVar.hP()) {
            pVar.agC = 0;
        } else if (pVar.agC == 1) {
            if (!pVar.agI) {
                DisplayMetrics displayMetrics = pVar.mContext.getResources().getDisplayMetrics();
                if (f == -1.0f) {
                    f = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (f2 == -1.0f) {
                    f2 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (f3 == -1.0f) {
                    f3 = 1.0f;
                }
                pVar.f(f, f2, f3);
            }
            pVar.hL();
        }
        if (b.OV && this.agt.agC != 0) {
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

    private void a(Context context, bc bcVar) {
        int i = 12;
        this.mStyle = bcVar.getInt(2, this.mStyle);
        if (bcVar.hasValue(10) || bcVar.hasValue(12)) {
            this.agu = null;
            if (!bcVar.hasValue(12)) {
                i = 10;
            }
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.ago);
                try {
                    this.agu = bcVar.a(i, this.mStyle, new android.support.v4.content.a.b.a() {
                        public final void b(Typeface typeface) {
                            n nVar = n.this;
                            WeakReference weakReference = weakReference;
                            if (nVar.agv) {
                                nVar.agu = typeface;
                                TextView textView = (TextView) weakReference.get();
                                if (textView != null) {
                                    textView.setTypeface(typeface, nVar.mStyle);
                                }
                            }
                        }
                    });
                    this.agv = this.agu == null;
                } catch (NotFoundException | UnsupportedOperationException e) {
                }
            }
            if (this.agu == null) {
                String string = bcVar.getString(i);
                if (string != null) {
                    this.agu = Typeface.create(string, this.mStyle);
                }
            }
        } else if (bcVar.hasValue(1)) {
            this.agv = false;
            switch (bcVar.getInt(1, 1)) {
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
    public final void r(Context context, int i) {
        bc a = bc.a(context, i, a.TextAppearance);
        if (a.hasValue(11)) {
            setAllCaps(a.getBoolean(11, false));
        }
        if (VERSION.SDK_INT < 23 && a.hasValue(3)) {
            ColorStateList colorStateList = a.getColorStateList(3);
            if (colorStateList != null) {
                this.ago.setTextColor(colorStateList);
            }
        }
        a(context, a);
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
    public void hI() {
        if (this.agp != null || this.agq != null || this.agr != null || this.ags != null) {
            Drawable[] compoundDrawables = this.ago.getCompoundDrawables();
            a(compoundDrawables[0], this.agp);
            a(compoundDrawables[1], this.agq);
            a(compoundDrawables[2], this.agr);
            a(compoundDrawables[3], this.ags);
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(Drawable drawable, ba baVar) {
        if (drawable != null && baVar != null) {
            i.a(drawable, baVar, this.ago.getDrawableState());
        }
    }

    protected static ba a(Context context, i iVar, int i) {
        ColorStateList o = iVar.o(context, i);
        if (o == null) {
            return null;
        }
        ba baVar = new ba();
        baVar.atE = true;
        baVar.atC = o;
        return baVar;
    }

    /* Access modifiers changed, original: final */
    public final void hJ() {
        if (!b.OV) {
            this.agt.hM();
        }
    }

    /* Access modifiers changed, original: final */
    public final void setTextSize(int i, float f) {
        if (!b.OV && !this.agt.hO()) {
            e(i, f);
        }
    }

    private void e(int i, float f) {
        this.agt.e(i, f);
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
