package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.design.widget.o */
final class C41488o {
    /* renamed from: tW */
    private static final int[] f16757tW = new int[]{C25738R.attr.f5680fl};

    /* renamed from: G */
    static void m72457G(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f16757tW);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        obtainStyledAttributes.recycle();
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
