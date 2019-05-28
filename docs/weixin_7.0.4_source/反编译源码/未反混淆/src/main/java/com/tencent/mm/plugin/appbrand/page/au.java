package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(14)
public final class au {
    public static void a(Canvas canvas, View view, float f, float f2) {
        AppMethodBeat.i(91121);
        if (view.getVisibility() != 0) {
            AppMethodBeat.o(91121);
        } else if (view instanceof TextureView) {
            Bitmap bitmap = ((TextureView) view).getBitmap(view.getWidth(), view.getHeight());
            if (!(bitmap == null || bitmap.isRecycled())) {
                canvas.drawBitmap(bitmap, f, f2, null);
            }
            AppMethodBeat.o(91121);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                a(canvas, childAt, childAt.getX() + f, childAt.getY() + f2);
            }
            AppMethodBeat.o(91121);
        } else {
            canvas.save();
            canvas.translate(f, f2);
            view.draw(canvas);
            canvas.restore();
            AppMethodBeat.o(91121);
        }
    }

    public static boolean i(ViewGroup viewGroup) {
        AppMethodBeat.i(91122);
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            AppMethodBeat.o(91122);
            return false;
        }
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextureView) {
                z = true;
            }
            if (childAt instanceof ViewGroup) {
                z = i((ViewGroup) childAt);
            }
            if (z) {
                break;
            }
        }
        AppMethodBeat.o(91122);
        return z;
    }
}
