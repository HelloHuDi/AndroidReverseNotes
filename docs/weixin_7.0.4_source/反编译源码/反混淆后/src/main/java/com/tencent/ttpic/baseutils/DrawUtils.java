package com.tencent.ttpic.baseutils;

import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DrawUtils {
    private static final String TAG = DrawUtils.class.getSimpleName();
    public static Paint sPaint = new Paint();

    static {
        AppMethodBeat.m2504i(49670);
        AppMethodBeat.m2505o(49670);
    }

    public static Paint createRGBPaint(int i) {
        AppMethodBeat.m2504i(49669);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) Color.red(i), 0.0f, 0.0f, 0.0f, 0.0f, (float) Color.green(i), 0.0f, 0.0f, 0.0f, 0.0f, (float) Color.blue(i), 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        AppMethodBeat.m2505o(49669);
        return paint;
    }
}
