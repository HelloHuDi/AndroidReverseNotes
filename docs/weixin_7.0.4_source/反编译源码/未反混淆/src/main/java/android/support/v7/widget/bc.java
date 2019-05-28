package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.b.a;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.util.TypedValue;

public final class bc {
    private TypedValue afJ;
    public final TypedArray atG;
    private final Context mContext;

    public static bc a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new bc(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static bc a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new bc(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static bc a(Context context, int i, int[] iArr) {
        return new bc(context, context.obtainStyledAttributes(i, iArr));
    }

    private bc(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.atG = typedArray;
    }

    public final Drawable getDrawable(int i) {
        if (this.atG.hasValue(i)) {
            int resourceId = this.atG.getResourceId(i, 0);
            if (resourceId != 0) {
                return b.g(this.mContext, resourceId);
            }
        }
        return this.atG.getDrawable(i);
    }

    public final Drawable cW(int i) {
        if (this.atG.hasValue(i)) {
            int resourceId = this.atG.getResourceId(i, 0);
            if (resourceId != 0) {
                return i.hE().a(this.mContext, resourceId, true);
            }
        }
        return null;
    }

    public final Typeface a(int i, int i2, a aVar) {
        int resourceId = this.atG.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.afJ == null) {
            this.afJ = new TypedValue();
        }
        return android.support.v4.content.a.b.a(this.mContext, resourceId, this.afJ, i2, aVar);
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
                ColorStateList h = b.h(this.mContext, resourceId);
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
