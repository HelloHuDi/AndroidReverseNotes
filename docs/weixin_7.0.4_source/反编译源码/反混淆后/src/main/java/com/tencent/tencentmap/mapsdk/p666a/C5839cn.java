package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;

/* renamed from: com.tencent.tencentmap.mapsdk.a.cn */
public final class C5839cn {
    /* renamed from: a */
    public static C41018cm m8917a(String str) {
        AppMethodBeat.m2504i(100948);
        C5838bl c5838bl = new C5838bl(2);
        c5838bl.mo12314a(str);
        C41018cm c41018cm = new C41018cm(c5838bl);
        AppMethodBeat.m2505o(100948);
        return c41018cm;
    }

    /* renamed from: a */
    public static C41018cm m8915a(Bitmap bitmap) {
        AppMethodBeat.m2504i(100949);
        if (bitmap == null) {
            AppMethodBeat.m2505o(100949);
            return null;
        }
        Bitmap a = C36520ic.m60469a(bitmap);
        C5838bl c5838bl = new C5838bl(7);
        c5838bl.mo12313a(a);
        C41018cm c41018cm = new C41018cm(c5838bl);
        AppMethodBeat.m2505o(100949);
        return c41018cm;
    }

    /* renamed from: a */
    public static C41018cm m8916a(View view) {
        AppMethodBeat.m2504i(100950);
        if (view == null) {
            AppMethodBeat.m2505o(100950);
            return null;
        }
        try {
            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            C41018cm a = C5839cn.m8915a(drawingCache);
            if (drawingCache != null) {
                drawingCache.recycle();
            }
            view.destroyDrawingCache();
            AppMethodBeat.m2505o(100950);
            return a;
        } catch (Exception e) {
            AppMethodBeat.m2505o(100950);
            return null;
        }
    }
}
