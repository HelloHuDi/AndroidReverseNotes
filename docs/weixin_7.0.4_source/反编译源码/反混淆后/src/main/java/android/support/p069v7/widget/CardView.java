package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p1438b.C31874a.C31873a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.CardView */
public class CardView extends FrameLayout {
    private static final int[] agN = new int[]{16842801};
    private static final C0726u agO;
    private boolean agP;
    int agQ;
    int agR;
    final Rect agS;
    final Rect agT;
    private final C8473t agU;
    /* renamed from: qh */
    private boolean f16846qh;

    /* renamed from: android.support.v7.widget.CardView$1 */
    class C06491 implements C8473t {
        private Drawable agV;

        C06491() {
        }

        /* renamed from: l */
        public final void mo1690l(Drawable drawable) {
            this.agV = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        public final boolean getUseCompatPadding() {
            return CardView.this.getUseCompatPadding();
        }

        public final boolean getPreventCornerOverlap() {
            return CardView.this.getPreventCornerOverlap();
        }

        /* renamed from: e */
        public final void mo1685e(int i, int i2, int i3, int i4) {
            CardView.this.agT.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            super.setPadding(cardView.agS.left + i, CardView.this.agS.top + i2, CardView.this.agS.right + i3, CardView.this.agS.bottom + i4);
        }

        /* renamed from: S */
        public final void mo1684S(int i, int i2) {
            if (i > CardView.this.agQ) {
                super.setMinimumWidth(i);
            }
            if (i2 > CardView.this.agR) {
                super.setMinimumHeight(i2);
            }
        }

        /* renamed from: hR */
        public final Drawable mo1688hR() {
            return this.agV;
        }

        /* renamed from: hS */
        public final View mo1689hS() {
            return CardView.this;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            agO = new C8472r();
        } else if (VERSION.SDK_INT >= 17) {
            agO = new C44971q();
        } else {
            agO = new C6261s();
        }
        agO.mo2129hT();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5467h);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int color;
        super(context, attributeSet, i);
        this.agS = new Rect();
        this.agT = new Rect();
        this.agU = new C06491();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C31873a.CardView, i, C25738R.style.f10731cv);
        if (obtainStyledAttributes.hasValue(2)) {
            colorStateList = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(agN);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(C25738R.color.f11860jo);
            } else {
                color = getResources().getColor(C25738R.color.f11859jn);
            }
            colorStateList = ColorStateList.valueOf(color);
        }
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.f16846qh = obtainStyledAttributes.getBoolean(6, false);
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
        agO.mo2119a(this.agU, context, colorStateList, dimension, dimension2, dimension3);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public boolean getUseCompatPadding() {
        return this.f16846qh;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f16846qh != z) {
            this.f16846qh = z;
            agO.mo2127g(this.agU);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (agO instanceof C8472r) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case C8415j.INVALID_ID /*-2147483648*/:
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) agO.mo2121b(this.agU)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case C8415j.INVALID_ID /*-2147483648*/:
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) agO.mo2123c(this.agU)), MeasureSpec.getSize(i2)), mode);
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
        agO.mo2120a(this.agU, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        agO.mo2120a(this.agU, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return agO.mo2130i(this.agU);
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
        agO.mo2118a(this.agU, f);
    }

    public float getRadius() {
        return agO.mo2125d(this.agU);
    }

    public void setCardElevation(float f) {
        agO.mo2124c(this.agU, f);
    }

    public float getCardElevation() {
        return agO.mo2126e(this.agU);
    }

    public void setMaxCardElevation(float f) {
        agO.mo2122b(this.agU, f);
    }

    public float getMaxCardElevation() {
        return agO.mo2117a(this.agU);
    }

    public boolean getPreventCornerOverlap() {
        return this.agP;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.agP) {
            this.agP = z;
            agO.mo2128h(this.agU);
        }
    }
}
