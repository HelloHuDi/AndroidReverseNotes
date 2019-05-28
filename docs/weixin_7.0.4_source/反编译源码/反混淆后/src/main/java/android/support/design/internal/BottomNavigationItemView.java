package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.view.C0473q;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.view.menu.C0630p.C0629a;
import android.support.p069v7.view.menu.C6239j;
import android.support.p069v7.widget.C0701be;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.p177mm.C25738R;

public class BottomNavigationItemView extends FrameLayout implements C0629a {
    /* renamed from: kO */
    private static final int[] f16700kO = new int[]{16842912};
    /* renamed from: kP */
    private final int f16701kP;
    /* renamed from: kQ */
    private final int f16702kQ;
    /* renamed from: kR */
    private final float f16703kR;
    /* renamed from: kS */
    private final float f16704kS;
    /* renamed from: kT */
    private boolean f16705kT;
    /* renamed from: kU */
    private ImageView f16706kU;
    /* renamed from: kV */
    private final TextView f16707kV;
    /* renamed from: kW */
    private final TextView f16708kW;
    /* renamed from: kX */
    private int f16709kX;
    /* renamed from: kY */
    private C6239j f16710kY;
    /* renamed from: kZ */
    private ColorStateList f16711kZ;

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16709kX = -1;
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C25738R.dimen.f10347yq);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C25738R.dimen.f10340yj);
        this.f16701kP = resources.getDimensionPixelSize(C25738R.dimen.f10345yo);
        this.f16702kQ = dimensionPixelSize - dimensionPixelSize2;
        this.f16703kR = (((float) dimensionPixelSize2) * 1.0f) / ((float) dimensionPixelSize);
        this.f16704kS = (((float) dimensionPixelSize) * 1.0f) / ((float) dimensionPixelSize2);
        LayoutInflater.from(context).inflate(2130969271, this, true);
        setBackgroundResource(C25738R.drawable.f6649l5);
        this.f16706kU = (ImageView) findViewById(2131820915);
        this.f16707kV = (TextView) findViewById(2131823260);
        this.f16708kW = (TextView) findViewById(2131823261);
    }

    /* renamed from: a */
    public final void mo1609a(C6239j c6239j) {
        this.f16710kY = c6239j;
        setCheckable(c6239j.isCheckable());
        setChecked(c6239j.isChecked());
        setEnabled(c6239j.isEnabled());
        setIcon(c6239j.getIcon());
        setTitle(c6239j.getTitle());
        setId(c6239j.getItemId());
        setContentDescription(c6239j.getContentDescription());
        C0701be.m1558a(this, c6239j.getTooltipText());
    }

    public void setItemPosition(int i) {
        this.f16709kX = i;
    }

    public int getItemPosition() {
        return this.f16709kX;
    }

    public void setShiftingMode(boolean z) {
        this.f16705kT = z;
    }

    public C6239j getItemData() {
        return this.f16710kY;
    }

    public void setTitle(CharSequence charSequence) {
        this.f16707kV.setText(charSequence);
        this.f16708kW.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.f16708kW.setPivotX((float) (this.f16708kW.getWidth() / 2));
        this.f16708kW.setPivotY((float) this.f16708kW.getBaseline());
        this.f16707kV.setPivotX((float) (this.f16707kV.getWidth() / 2));
        this.f16707kV.setPivotY((float) this.f16707kV.getBaseline());
        LayoutParams layoutParams;
        if (this.f16705kT) {
            if (z) {
                layoutParams = (LayoutParams) this.f16706kU.getLayoutParams();
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.f16701kP;
                this.f16706kU.setLayoutParams(layoutParams);
                this.f16708kW.setVisibility(0);
                this.f16708kW.setScaleX(1.0f);
                this.f16708kW.setScaleY(1.0f);
            } else {
                layoutParams = (LayoutParams) this.f16706kU.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.topMargin = this.f16701kP;
                this.f16706kU.setLayoutParams(layoutParams);
                this.f16708kW.setVisibility(4);
                this.f16708kW.setScaleX(0.5f);
                this.f16708kW.setScaleY(0.5f);
            }
            this.f16707kV.setVisibility(4);
        } else if (z) {
            layoutParams = (LayoutParams) this.f16706kU.getLayoutParams();
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.f16701kP + this.f16702kQ;
            this.f16706kU.setLayoutParams(layoutParams);
            this.f16708kW.setVisibility(0);
            this.f16707kV.setVisibility(4);
            this.f16708kW.setScaleX(1.0f);
            this.f16708kW.setScaleY(1.0f);
            this.f16707kV.setScaleX(this.f16703kR);
            this.f16707kV.setScaleY(this.f16703kR);
        } else {
            layoutParams = (LayoutParams) this.f16706kU.getLayoutParams();
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.f16701kP;
            this.f16706kU.setLayoutParams(layoutParams);
            this.f16708kW.setVisibility(4);
            this.f16707kV.setVisibility(0);
            this.f16708kW.setScaleX(this.f16704kS);
            this.f16708kW.setScaleY(this.f16704kS);
            this.f16707kV.setScaleX(1.0f);
            this.f16707kV.setScaleY(1.0f);
        }
        refreshDrawableState();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f16707kV.setEnabled(z);
        this.f16708kW.setEnabled(z);
        this.f16706kU.setEnabled(z);
        if (z) {
            C0477s.m907a((View) this, C0473q.m835U(getContext()));
        } else {
            C0477s.m907a((View) this, null);
        }
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f16710kY != null && this.f16710kY.isCheckable() && this.f16710kY.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f16700kO);
        }
        return onCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = C0280a.m467f(drawable).mutate();
            C0280a.m457a(drawable, this.f16711kZ);
        }
        this.f16706kU.setImageDrawable(drawable);
    }

    /* renamed from: br */
    public final boolean mo1610br() {
        return false;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f16711kZ = colorStateList;
        if (this.f16710kY != null) {
            setIcon(this.f16710kY.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f16707kV.setTextColor(colorStateList);
        this.f16708kW.setTextColor(colorStateList);
    }

    public void setItemBackground(int i) {
        Drawable drawable;
        if (i == 0) {
            drawable = null;
        } else {
            drawable = C0380b.m649g(getContext(), i);
        }
        C0477s.m904a((View) this, drawable);
    }
}
