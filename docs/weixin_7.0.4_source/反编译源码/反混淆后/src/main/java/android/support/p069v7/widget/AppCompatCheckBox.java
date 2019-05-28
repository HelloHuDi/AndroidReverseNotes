package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p057v4.widget.C0548r;
import android.support.p069v7.p071c.p072a.C0589b;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.AppCompatCheckBox */
public class AppCompatCheckBox extends CheckBox implements C0548r {
    private final C0714h afo;

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5701g6);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(C0697az.m1552ad(context), attributeSet, i);
        this.afo = new C0714h(this);
        this.afo.mo2076a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.afo != null) {
            this.afo.mo2078hC();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(C0589b.m1275g(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.afo != null ? this.afo.mo2077bE(compoundPaddingLeft) : compoundPaddingLeft;
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
