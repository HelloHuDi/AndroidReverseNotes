package com.tencent.p177mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import android.support.p069v7.app.AppCompatActivity;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.compatible.util.a */
public final class C1441a {
    /* renamed from: q */
    public static int m3066q(Activity activity) {
        int height;
        AppMethodBeat.m2504i(93057);
        if (activity instanceof AppCompatActivity) {
            if (((AppCompatActivity) activity).getSupportActionBar() != null) {
                height = ((AppCompatActivity) activity).getSupportActionBar().getHeight();
                AppMethodBeat.m2505o(93057);
                return height;
            }
        } else if (activity.getActionBar() != null) {
            height = activity.getActionBar().getHeight();
            AppMethodBeat.m2505o(93057);
            return height;
        }
        height = C1441a.m3065bG(activity);
        AppMethodBeat.m2505o(93057);
        return height;
    }

    /* renamed from: bG */
    public static int m3065bG(Context context) {
        AppMethodBeat.m2504i(93058);
        TypedValue typedValue = new TypedValue();
        int complexToDimensionPixelSize;
        if (context.getTheme().resolveAttribute(C25738R.attr.f5618dx, typedValue, true)) {
            complexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            AppMethodBeat.m2505o(93058);
            return complexToDimensionPixelSize;
        } else if (context.getTheme().resolveAttribute(16843499, typedValue, true)) {
            complexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            AppMethodBeat.m2505o(93058);
            return complexToDimensionPixelSize;
        } else {
            AppMethodBeat.m2505o(93058);
            return 0;
        }
    }
}
