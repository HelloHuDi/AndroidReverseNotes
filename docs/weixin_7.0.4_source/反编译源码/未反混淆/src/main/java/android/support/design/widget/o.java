package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import com.tencent.mm.R;

final class o {
    private static final int[] tW = new int[]{R.attr.fl};

    static void G(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(tW);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        obtainStyledAttributes.recycle();
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
