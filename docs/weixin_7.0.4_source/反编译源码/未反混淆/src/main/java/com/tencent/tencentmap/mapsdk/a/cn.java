package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ic;

public final class cn {
    public static cm a(String str) {
        AppMethodBeat.i(100948);
        bl blVar = new bl(2);
        blVar.a(str);
        cm cmVar = new cm(blVar);
        AppMethodBeat.o(100948);
        return cmVar;
    }

    public static cm a(Bitmap bitmap) {
        AppMethodBeat.i(100949);
        if (bitmap == null) {
            AppMethodBeat.o(100949);
            return null;
        }
        Bitmap a = ic.a(bitmap);
        bl blVar = new bl(7);
        blVar.a(a);
        cm cmVar = new cm(blVar);
        AppMethodBeat.o(100949);
        return cmVar;
    }

    public static cm a(View view) {
        AppMethodBeat.i(100950);
        if (view == null) {
            AppMethodBeat.o(100950);
            return null;
        }
        try {
            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            cm a = a(drawingCache);
            if (drawingCache != null) {
                drawingCache.recycle();
            }
            view.destroyDrawingCache();
            AppMethodBeat.o(100950);
            return a;
        } catch (Exception e) {
            AppMethodBeat.o(100950);
            return null;
        }
    }
}
