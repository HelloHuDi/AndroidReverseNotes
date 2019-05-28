package com.tencent.p177mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(14)
/* renamed from: com.tencent.mm.plugin.appbrand.page.au */
public final class C33469au {
    /* renamed from: a */
    public static void m54678a(Canvas canvas, View view, float f, float f2) {
        AppMethodBeat.m2504i(91121);
        if (view.getVisibility() != 0) {
            AppMethodBeat.m2505o(91121);
        } else if (view instanceof TextureView) {
            Bitmap bitmap = ((TextureView) view).getBitmap(view.getWidth(), view.getHeight());
            if (!(bitmap == null || bitmap.isRecycled())) {
                canvas.drawBitmap(bitmap, f, f2, null);
            }
            AppMethodBeat.m2505o(91121);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                C33469au.m54678a(canvas, childAt, childAt.getX() + f, childAt.getY() + f2);
            }
            AppMethodBeat.m2505o(91121);
        } else {
            canvas.save();
            canvas.translate(f, f2);
            view.draw(canvas);
            canvas.restore();
            AppMethodBeat.m2505o(91121);
        }
    }

    /* renamed from: i */
    public static boolean m54679i(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(91122);
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            AppMethodBeat.m2505o(91122);
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
                z = C33469au.m54679i((ViewGroup) childAt);
            }
            if (z) {
                break;
            }
        }
        AppMethodBeat.m2505o(91122);
        return z;
    }
}
