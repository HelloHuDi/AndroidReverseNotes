package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0474r;
import android.support.p069v7.p071c.p072a.C0589b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.AppCompatMultiAutoCompleteTextView */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements C0474r {
    private static final int[] aaV = new int[]{16843126};
    private final C0713g afh;
    private final C0723n afi;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5698g3);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(C0697az.m1552ad(context), attributeSet, i);
        C0699bc a = C0699bc.m1555a(getContext(), attributeSet, aaV, i, 0);
        if (a.hasValue(0)) {
            setDropDownBackgroundDrawable(a.getDrawable(0));
        }
        a.atG.recycle();
        this.afh = new C0713g(this);
        this.afh.mo2068a(attributeSet, i);
        this.afi = C0723n.m1629e(this);
        this.afi.mo2098a(attributeSet, i);
        this.afi.mo2099hI();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0589b.m1275g(getContext(), i));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.afh != null) {
            this.afh.mo2069bD(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.afh != null) {
            this.afh.mo2073hz();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.afh != null) {
            this.afh.setSupportBackgroundTintList(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.afh != null ? this.afh.getSupportBackgroundTintList() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.afh != null) {
            this.afh.setSupportBackgroundTintMode(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.afh != null ? this.afh.getSupportBackgroundTintMode() : null;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.afh != null) {
            this.afh.mo2072hA();
        }
        if (this.afi != null) {
            this.afi.mo2099hI();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.afi != null) {
            this.afi.mo2101r(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0720j.m1620a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
