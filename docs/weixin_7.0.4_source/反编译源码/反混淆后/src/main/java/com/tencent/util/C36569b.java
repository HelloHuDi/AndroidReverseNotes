package com.tencent.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.util.b */
public final class C36569b {
    private static final String[] AHV = new String[]{"orientation"};
    private static final float[] AHW = new float[32];
    /* renamed from: Bn */
    private static final float[] f15469Bn = new float[16];
    private static final String[] azD = new String[]{"_data"};

    /* renamed from: a */
    public static Bitmap m60592a(Bitmap bitmap, int i, int i2, Matrix matrix) {
        Bitmap createBitmap;
        Paint paint = null;
        AppMethodBeat.m2504i(86573);
        Canvas canvas = new Canvas();
        if (matrix.isIdentity()) {
            createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, (float) i, (float) i2);
            matrix.mapRect(rectF);
            try {
                createBitmap = Bitmap.createBitmap(Math.round(rectF.width()), Math.round(rectF.height()), bitmap.getConfig());
                canvas.translate(-rectF.left, -rectF.top);
                canvas.concat(matrix);
                paint = new Paint(2);
                if (!matrix.rectStaysRect()) {
                    paint.setAntiAlias(true);
                }
            } catch (OutOfMemoryError e) {
                AppMethodBeat.m2505o(86573);
                return null;
            }
        }
        createBitmap.setDensity(bitmap.getDensity());
        canvas.setBitmap(createBitmap);
        canvas.drawBitmap(bitmap, new Rect(0, 0, i + 0, i2 + 0), new RectF(0.0f, 0.0f, (float) i, (float) i2), paint);
        AppMethodBeat.m2505o(86573);
        return createBitmap;
    }

    /* renamed from: g */
    public static Bitmap m60593g(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap;
        Object obj = 1;
        AppMethodBeat.m2504i(86574);
        long currentTimeMillis = System.currentTimeMillis();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Object obj2 = null;
        try {
            createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            obj2 = 1;
        } catch (OutOfMemoryError e) {
            createBitmap = null;
        }
        if (obj2 == null) {
            try {
                createBitmap = Bitmap.createBitmap(i, i2, Config.RGB_565);
            } catch (OutOfMemoryError e2) {
            }
            if (obj != null || createBitmap == null) {
                AppMethodBeat.m2505o(86574);
                return null;
            }
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate((float) ((i - width) / 2), (float) ((i2 - height) / 2));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(2));
            C16371i.m25186k("BitmapUtils", "crop bitmap - " + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(86574);
            return createBitmap;
        }
        obj = obj2;
        if (obj != null) {
        }
        AppMethodBeat.m2505o(86574);
        return null;
    }

    public static boolean recycle(Bitmap bitmap) {
        AppMethodBeat.m2504i(86575);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(86575);
            return false;
        }
        bitmap.recycle();
        AppMethodBeat.m2505o(86575);
        return true;
    }
}
