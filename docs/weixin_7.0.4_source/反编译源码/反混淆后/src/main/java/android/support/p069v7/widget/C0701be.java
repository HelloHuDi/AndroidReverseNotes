package android.support.p069v7.widget;

import android.os.Build.VERSION;
import android.view.View;

/* renamed from: android.support.v7.widget.be */
public final class C0701be {
    /* renamed from: a */
    public static void m1558a(View view, CharSequence charSequence) {
        if (VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            C0704bf.m1560a(view, charSequence);
        }
    }
}
