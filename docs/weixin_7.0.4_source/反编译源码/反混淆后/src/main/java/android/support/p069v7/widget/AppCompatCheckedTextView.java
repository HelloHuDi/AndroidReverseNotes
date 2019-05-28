package android.support.p069v7.widget;

import android.content.Context;
import android.support.p069v7.p071c.p072a.C0589b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* renamed from: android.support.v7.widget.AppCompatCheckedTextView */
public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] aaV = new int[]{16843016};
    private final C0723n afi;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(C0697az.m1552ad(context), attributeSet, i);
        this.afi = C0723n.m1629e(this);
        this.afi.mo2098a(attributeSet, i);
        this.afi.mo2099hI();
        C0699bc a = C0699bc.m1555a(getContext(), attributeSet, aaV, i, 0);
        setCheckMarkDrawable(a.getDrawable(0));
        a.atG.recycle();
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(C0589b.m1275g(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.afi != null) {
            this.afi.mo2101r(context, i);
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.afi != null) {
            this.afi.mo2099hI();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0720j.m1620a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
