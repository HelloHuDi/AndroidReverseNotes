package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a {
    public static int q(Activity activity) {
        int height;
        AppMethodBeat.i(93057);
        if (activity instanceof AppCompatActivity) {
            if (((AppCompatActivity) activity).getSupportActionBar() != null) {
                height = ((AppCompatActivity) activity).getSupportActionBar().getHeight();
                AppMethodBeat.o(93057);
                return height;
            }
        } else if (activity.getActionBar() != null) {
            height = activity.getActionBar().getHeight();
            AppMethodBeat.o(93057);
            return height;
        }
        height = bG(activity);
        AppMethodBeat.o(93057);
        return height;
    }

    public static int bG(Context context) {
        AppMethodBeat.i(93058);
        TypedValue typedValue = new TypedValue();
        int complexToDimensionPixelSize;
        if (context.getTheme().resolveAttribute(R.attr.dx, typedValue, true)) {
            complexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            AppMethodBeat.o(93058);
            return complexToDimensionPixelSize;
        } else if (context.getTheme().resolveAttribute(16843499, typedValue, true)) {
            complexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            AppMethodBeat.o(93058);
            return complexToDimensionPixelSize;
        } else {
            AppMethodBeat.o(93058);
            return 0;
        }
    }
}
