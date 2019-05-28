package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.TextView;

final class o extends n {
    private ba agy;
    private ba agz;

    o(TextView textView) {
        super(textView);
    }

    /* Access modifiers changed, original: final */
    public final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        Context context = this.ago.getContext();
        i hE = i.hE();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(5)) {
            this.agy = n.a(context, hE, obtainStyledAttributes.getResourceId(5, 0));
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.agz = n.a(context, hE, obtainStyledAttributes.getResourceId(6, 0));
        }
        obtainStyledAttributes.recycle();
    }

    /* Access modifiers changed, original: final */
    public final void hI() {
        super.hI();
        if (this.agy != null || this.agz != null) {
            Drawable[] compoundDrawablesRelative = this.ago.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.agy);
            a(compoundDrawablesRelative[2], this.agz);
        }
    }
}
