package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as {
    public static Bitmap cq(View view) {
        AppMethodBeat.i(91120);
        if (view.getWidth() < 0 || view.getHeight() < 0) {
            AppMethodBeat.o(91120);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        a(view, new Canvas(createBitmap));
        AppMethodBeat.o(91120);
        return createBitmap;
    }

    public static void a(View view, Canvas canvas) {
        boolean z;
        AppMethodBeat.i(91119);
        if (view.getVisibility() != 0) {
            z = true;
        } else if (view instanceof ar) {
            z = ((ar) view).g(canvas);
        } else {
            view.draw(canvas);
            z = false;
        }
        if (z) {
            AppMethodBeat.o(91119);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), canvas);
            }
        }
        AppMethodBeat.o(91119);
    }
}
