package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.r;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import com.tencent.mm.R;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements r {
    private static final int[] aaV = new int[]{16843126};
    private final g afh;
    private final n afi;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.g3);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(az.ad(context), attributeSet, i);
        bc a = bc.a(getContext(), attributeSet, aaV, i, 0);
        if (a.hasValue(0)) {
            setDropDownBackgroundDrawable(a.getDrawable(0));
        }
        a.atG.recycle();
        this.afh = new g(this);
        this.afh.a(attributeSet, i);
        this.afi = n.e(this);
        this.afi.a(attributeSet, i);
        this.afi.hI();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(b.g(getContext(), i));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.afh != null) {
            this.afh.bD(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.afh != null) {
            this.afh.hz();
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
            this.afh.hA();
        }
        if (this.afi != null) {
            this.afi.hI();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.afi != null) {
            this.afi.r(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
