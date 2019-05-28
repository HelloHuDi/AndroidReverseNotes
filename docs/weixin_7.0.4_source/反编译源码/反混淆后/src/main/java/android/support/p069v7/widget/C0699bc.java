package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.p057v4.content.p062a.C0378b;
import android.support.p057v4.content.p062a.C0378b.C0377a;
import android.support.p069v7.p071c.p072a.C0589b;
import android.util.AttributeSet;
import android.util.TypedValue;

/* renamed from: android.support.v7.widget.bc */
public final class C0699bc {
    private TypedValue afJ;
    public final TypedArray atG;
    private final Context mContext;

    /* renamed from: a */
    public static C0699bc m1554a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C0699bc(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: a */
    public static C0699bc m1555a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C0699bc(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* renamed from: a */
    public static C0699bc m1553a(Context context, int i, int[] iArr) {
        return new C0699bc(context, context.obtainStyledAttributes(i, iArr));
    }

    private C0699bc(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.atG = typedArray;
    }

    public final Drawable getDrawable(int i) {
        if (this.atG.hasValue(i)) {
            int resourceId = this.atG.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0589b.m1275g(this.mContext, resourceId);
            }
        }
        return this.atG.getDrawable(i);
    }

    /* renamed from: cW */
    public final Drawable mo2029cW(int i) {
        if (this.atG.hasValue(i)) {
            int resourceId = this.atG.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0716i.m1606hE().mo2082a(this.mContext, resourceId, true);
            }
        }
        return null;
    }

    /* renamed from: a */
    public final Typeface mo2028a(int i, int i2, C0377a c0377a) {
        int resourceId = this.atG.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.afJ == null) {
            this.afJ = new TypedValue();
        }
        return C0378b.m632a(this.mContext, resourceId, this.afJ, i2, c0377a);
    }

    public final CharSequence getText(int i) {
        return this.atG.getText(i);
    }

    public final String getString(int i) {
        return this.atG.getString(i);
    }

    public final boolean getBoolean(int i, boolean z) {
        return this.atG.getBoolean(i, z);
    }

    public final int getInt(int i, int i2) {
        return this.atG.getInt(i, i2);
    }

    public final float getFloat(int i, float f) {
        return this.atG.getFloat(i, f);
    }

    public final int getColor(int i, int i2) {
        return this.atG.getColor(i, i2);
    }

    public final ColorStateList getColorStateList(int i) {
        if (this.atG.hasValue(i)) {
            int resourceId = this.atG.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList h = C0589b.m1276h(this.mContext, resourceId);
                if (h != null) {
                    return h;
                }
            }
        }
        return this.atG.getColorStateList(i);
    }

    public final int getInteger(int i, int i2) {
        return this.atG.getInteger(i, i2);
    }

    public final int getDimensionPixelOffset(int i, int i2) {
        return this.atG.getDimensionPixelOffset(i, i2);
    }

    public final int getDimensionPixelSize(int i, int i2) {
        return this.atG.getDimensionPixelSize(i, i2);
    }

    public final int getLayoutDimension(int i, int i2) {
        return this.atG.getLayoutDimension(i, i2);
    }

    public final int getResourceId(int i, int i2) {
        return this.atG.getResourceId(i, i2);
    }

    public final boolean hasValue(int i) {
        return this.atG.hasValue(i);
    }
}
