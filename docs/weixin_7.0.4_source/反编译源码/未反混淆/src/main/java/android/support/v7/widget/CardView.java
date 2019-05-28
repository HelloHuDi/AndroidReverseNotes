package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.j;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;

public class CardView extends FrameLayout {
    private static final int[] agN = new int[]{16842801};
    private static final u agO;
    private boolean agP;
    int agQ;
    int agR;
    final Rect agS;
    final Rect agT;
    private final t agU;
    private boolean qh;

    static {
        if (VERSION.SDK_INT >= 21) {
            agO = new r();
        } else if (VERSION.SDK_INT >= 17) {
            agO = new q();
        } else {
            agO = new s();
        }
        agO.hT();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.h);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int color;
        super(context, attributeSet, i);
        this.agS = new Rect();
        this.agT = new Rect();
        this.agU = new t() {
            private Drawable agV;

            public final void l(Drawable drawable) {
                this.agV = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            public final boolean getUseCompatPadding() {
                return CardView.this.getUseCompatPadding();
            }

            public final boolean getPreventCornerOverlap() {
                return CardView.this.getPreventCornerOverlap();
            }

            public final void e(int i, int i2, int i3, int i4) {
                CardView.this.agT.set(i, i2, i3, i4);
                CardView cardView = CardView.this;
                super.setPadding(cardView.agS.left + i, CardView.this.agS.top + i2, CardView.this.agS.right + i3, CardView.this.agS.bottom + i4);
            }

            public final void S(int i, int i2) {
                if (i > CardView.this.agQ) {
                    super.setMinimumWidth(i);
                }
                if (i2 > CardView.this.agR) {
                    super.setMinimumHeight(i2);
                }
            }

            public final Drawable hR() {
                return this.agV;
            }

            public final View hS() {
                return CardView.this;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.CardView, i, R.style.cv);
        if (obtainStyledAttributes.hasValue(2)) {
            colorStateList = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(agN);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(R.color.jo);
            } else {
                color = getResources().getColor(R.color.jn);
            }
            colorStateList = ColorStateList.valueOf(color);
        }
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.qh = obtainStyledAttributes.getBoolean(6, false);
        this.agP = obtainStyledAttributes.getBoolean(7, true);
        color = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.agS.left = obtainStyledAttributes.getDimensionPixelSize(9, color);
        this.agS.top = obtainStyledAttributes.getDimensionPixelSize(11, color);
        this.agS.right = obtainStyledAttributes.getDimensionPixelSize(10, color);
        this.agS.bottom = obtainStyledAttributes.getDimensionPixelSize(12, color);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.agQ = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.agR = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        agO.a(this.agU, context, colorStateList, dimension, dimension2, dimension3);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public boolean getUseCompatPadding() {
        return this.qh;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.qh != z) {
            this.qh = z;
            agO.g(this.agU);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (agO instanceof r) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case j.INVALID_ID /*-2147483648*/:
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) agO.b(this.agU)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case j.INVALID_ID /*-2147483648*/:
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) agO.c(this.agU)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    public void setMinimumWidth(int i) {
        this.agQ = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.agR = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        agO.a(this.agU, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        agO.a(this.agU, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return agO.i(this.agU);
    }

    public int getContentPaddingLeft() {
        return this.agS.left;
    }

    public int getContentPaddingRight() {
        return this.agS.right;
    }

    public int getContentPaddingTop() {
        return this.agS.top;
    }

    public int getContentPaddingBottom() {
        return this.agS.bottom;
    }

    public void setRadius(float f) {
        agO.a(this.agU, f);
    }

    public float getRadius() {
        return agO.d(this.agU);
    }

    public void setCardElevation(float f) {
        agO.c(this.agU, f);
    }

    public float getCardElevation() {
        return agO.e(this.agU);
    }

    public void setMaxCardElevation(float f) {
        agO.b(this.agU, f);
    }

    public float getMaxCardElevation() {
        return agO.a(this.agU);
    }

    public boolean getPreventCornerOverlap() {
        return this.agP;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.agP) {
            this.agP = z;
            agO.h(this.agU);
        }
    }
}
