package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.o */
final class C6260o extends C0723n {
    private C0698ba agy;
    private C0698ba agz;

    C6260o(TextView textView) {
        super(textView);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo2098a(AttributeSet attributeSet, int i) {
        super.mo2098a(attributeSet, i);
        Context context = this.ago.getContext();
        C0716i hE = C0716i.m1606hE();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0554a.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(5)) {
            this.agy = C0723n.m1627a(context, hE, obtainStyledAttributes.getResourceId(5, 0));
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.agz = C0723n.m1627a(context, hE, obtainStyledAttributes.getResourceId(6, 0));
        }
        obtainStyledAttributes.recycle();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hI */
    public final void mo2099hI() {
        super.mo2099hI();
        if (this.agy != null || this.agz != null) {
            Drawable[] compoundDrawablesRelative = this.ago.getCompoundDrawablesRelative();
            mo2097a(compoundDrawablesRelative[0], this.agy);
            mo2097a(compoundDrawablesRelative[2], this.agz);
        }
    }
}
