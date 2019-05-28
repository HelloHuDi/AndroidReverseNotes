package com.tencent.p177mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.page.as */
public final class C2413as {
    /* renamed from: cq */
    public static Bitmap m4666cq(View view) {
        AppMethodBeat.m2504i(91120);
        if (view.getWidth() < 0 || view.getHeight() < 0) {
            AppMethodBeat.m2505o(91120);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        C2413as.m4665a(view, new Canvas(createBitmap));
        AppMethodBeat.m2505o(91120);
        return createBitmap;
    }

    /* renamed from: a */
    public static void m4665a(View view, Canvas canvas) {
        boolean z;
        AppMethodBeat.m2504i(91119);
        if (view.getVisibility() != 0) {
            z = true;
        } else if (view instanceof C19625ar) {
            z = ((C19625ar) view).mo22183g(canvas);
        } else {
            view.draw(canvas);
            z = false;
        }
        if (z) {
            AppMethodBeat.m2505o(91119);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                C2413as.m4665a(viewGroup.getChildAt(i), canvas);
            }
        }
        AppMethodBeat.m2505o(91119);
    }
}
