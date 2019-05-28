package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.content.b;
import android.support.v4.view.q;
import android.support.v4.view.s;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.be;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class BottomNavigationItemView extends FrameLayout implements a {
    private static final int[] kO = new int[]{16842912};
    private final int kP;
    private final int kQ;
    private final float kR;
    private final float kS;
    private boolean kT;
    private ImageView kU;
    private final TextView kV;
    private final TextView kW;
    private int kX;
    private j kY;
    private ColorStateList kZ;

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kX = -1;
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.yq);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.yj);
        this.kP = resources.getDimensionPixelSize(R.dimen.yo);
        this.kQ = dimensionPixelSize - dimensionPixelSize2;
        this.kR = (((float) dimensionPixelSize2) * 1.0f) / ((float) dimensionPixelSize);
        this.kS = (((float) dimensionPixelSize) * 1.0f) / ((float) dimensionPixelSize2);
        LayoutInflater.from(context).inflate(R.layout.s1, this, true);
        setBackgroundResource(R.drawable.l5);
        this.kU = (ImageView) findViewById(R.id.jb);
        this.kV = (TextView) findViewById(R.id.b9e);
        this.kW = (TextView) findViewById(R.id.b9f);
    }

    public final void a(j jVar) {
        this.kY = jVar;
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setIcon(jVar.getIcon());
        setTitle(jVar.getTitle());
        setId(jVar.getItemId());
        setContentDescription(jVar.getContentDescription());
        be.a(this, jVar.getTooltipText());
    }

    public void setItemPosition(int i) {
        this.kX = i;
    }

    public int getItemPosition() {
        return this.kX;
    }

    public void setShiftingMode(boolean z) {
        this.kT = z;
    }

    public j getItemData() {
        return this.kY;
    }

    public void setTitle(CharSequence charSequence) {
        this.kV.setText(charSequence);
        this.kW.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.kW.setPivotX((float) (this.kW.getWidth() / 2));
        this.kW.setPivotY((float) this.kW.getBaseline());
        this.kV.setPivotX((float) (this.kV.getWidth() / 2));
        this.kV.setPivotY((float) this.kV.getBaseline());
        LayoutParams layoutParams;
        if (this.kT) {
            if (z) {
                layoutParams = (LayoutParams) this.kU.getLayoutParams();
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.kP;
                this.kU.setLayoutParams(layoutParams);
                this.kW.setVisibility(0);
                this.kW.setScaleX(1.0f);
                this.kW.setScaleY(1.0f);
            } else {
                layoutParams = (LayoutParams) this.kU.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.topMargin = this.kP;
                this.kU.setLayoutParams(layoutParams);
                this.kW.setVisibility(4);
                this.kW.setScaleX(0.5f);
                this.kW.setScaleY(0.5f);
            }
            this.kV.setVisibility(4);
        } else if (z) {
            layoutParams = (LayoutParams) this.kU.getLayoutParams();
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.kP + this.kQ;
            this.kU.setLayoutParams(layoutParams);
            this.kW.setVisibility(0);
            this.kV.setVisibility(4);
            this.kW.setScaleX(1.0f);
            this.kW.setScaleY(1.0f);
            this.kV.setScaleX(this.kR);
            this.kV.setScaleY(this.kR);
        } else {
            layoutParams = (LayoutParams) this.kU.getLayoutParams();
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.kP;
            this.kU.setLayoutParams(layoutParams);
            this.kW.setVisibility(4);
            this.kV.setVisibility(0);
            this.kW.setScaleX(this.kS);
            this.kW.setScaleY(this.kS);
            this.kV.setScaleX(1.0f);
            this.kV.setScaleY(1.0f);
        }
        refreshDrawableState();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.kV.setEnabled(z);
        this.kW.setEnabled(z);
        this.kU.setEnabled(z);
        if (z) {
            s.a((View) this, q.U(getContext()));
        } else {
            s.a((View) this, null);
        }
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.kY != null && this.kY.isCheckable() && this.kY.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, kO);
        }
        return onCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = android.support.v4.a.a.a.f(drawable).mutate();
            android.support.v4.a.a.a.a(drawable, this.kZ);
        }
        this.kU.setImageDrawable(drawable);
    }

    public final boolean br() {
        return false;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.kZ = colorStateList;
        if (this.kY != null) {
            setIcon(this.kY.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.kV.setTextColor(colorStateList);
        this.kW.setTextColor(colorStateList);
    }

    public void setItemBackground(int i) {
        Drawable drawable;
        if (i == 0) {
            drawable = null;
        } else {
            drawable = b.g(getContext(), i);
        }
        s.a((View) this, drawable);
    }
}
