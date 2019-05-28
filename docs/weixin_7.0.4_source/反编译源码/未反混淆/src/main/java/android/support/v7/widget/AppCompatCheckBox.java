package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.r;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.tencent.mm.R;

public class AppCompatCheckBox extends CheckBox implements r {
    private final h afo;

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.g6);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(az.ad(context), attributeSet, i);
        this.afo = new h(this);
        this.afo.a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.afo != null) {
            this.afo.hC();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(b.g(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.afo != null ? this.afo.bE(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.afo != null) {
            this.afo.setSupportButtonTintList(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.afo != null) {
            return this.afo.afq;
        }
        return null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.afo != null) {
            this.afo.setSupportButtonTintMode(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        if (this.afo != null) {
            return this.afo.afr;
        }
        return null;
    }
}
