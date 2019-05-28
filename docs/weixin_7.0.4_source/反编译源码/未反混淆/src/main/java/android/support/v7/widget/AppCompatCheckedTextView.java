package android.support.v7.widget;

import android.content.Context;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] aaV = new int[]{16843016};
    private final n afi;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(az.ad(context), attributeSet, i);
        this.afi = n.e(this);
        this.afi.a(attributeSet, i);
        this.afi.hI();
        bc a = bc.a(getContext(), attributeSet, aaV, i, 0);
        setCheckMarkDrawable(a.getDrawable(0));
        a.atG.recycle();
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(b.g(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.afi != null) {
            this.afi.r(context, i);
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.afi != null) {
            this.afi.hI();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
