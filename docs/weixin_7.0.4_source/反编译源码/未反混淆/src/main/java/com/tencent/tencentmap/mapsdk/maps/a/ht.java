package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public class ht {
    protected static Paint a;
    private static final String b = Bitmap.class.getCanonicalName();

    static {
        AppMethodBeat.i(99585);
        Paint paint = new Paint();
        a = paint;
        paint.setAntiAlias(true);
        AppMethodBeat.o(99585);
    }

    public static Bitmap a(View view) {
        AppMethodBeat.i(99577);
        if (view != null) {
            try {
                Bitmap a;
                synchronized (view) {
                    view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                    view.setDrawingCacheEnabled(true);
                    view.buildDrawingCache();
                    a = a(view.getDrawingCache());
                    view.destroyDrawingCache();
                }
                AppMethodBeat.o(99577);
                return a;
            } catch (Throwable th) {
                new StringBuilder("BitmapUtil.convertToBitmap errorDetail:").append(Log.getStackTraceString(th));
            }
        }
        AppMethodBeat.o(99577);
        return null;
    }

    public static Bitmap a(Bitmap bitmap) {
        AppMethodBeat.i(99578);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(99578);
            return null;
        }
        Bitmap a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
        AppMethodBeat.o(99578);
        return a;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.i(99579);
        if (bitmap == null || bitmap.isRecycled() || i <= 0 || i2 <= 0) {
            AppMethodBeat.o(99579);
            return null;
        }
        Bitmap a = a(i, i2, Config.ARGB_8888);
        a.setDensity(bitmap.getDensity());
        if (a == null) {
            AppMethodBeat.o(99579);
            return null;
        }
        Canvas canvas = new Canvas(a);
        a.eraseColor(0);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, a);
        AppMethodBeat.o(99579);
        return a;
    }

    public static Bitmap a(Bitmap bitmap, Context context, int i, int i2) {
        AppMethodBeat.i(99580);
        if (bitmap == null || bitmap.isRecycled() || i <= 0 || i2 <= 0) {
            AppMethodBeat.o(99580);
            return null;
        }
        if (i > 2048) {
            i = 2048;
        }
        if (i2 > 2048) {
            i2 = 2048;
        }
        Bitmap a = a(i, i2, Config.ARGB_8888);
        if (a == null) {
            AppMethodBeat.o(99580);
            return null;
        }
        a.eraseColor(0);
        Canvas canvas = new Canvas(a);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, i, i2);
        bitmapDrawable.draw(canvas);
        AppMethodBeat.o(99580);
        return a;
    }

    public static Drawable b(Bitmap bitmap) {
        AppMethodBeat.i(99581);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        AppMethodBeat.o(99581);
        return bitmapDrawable;
    }

    private static Bitmap a(int i, int i2, Config config) {
        Bitmap createBitmap;
        AppMethodBeat.i(99582);
        try {
            createBitmap = Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError e) {
            try {
                createBitmap = Bitmap.createBitmap(i, i2, config);
            } catch (OutOfMemoryError e2) {
                AppMethodBeat.o(99582);
                return null;
            }
        }
        AppMethodBeat.o(99582);
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        AppMethodBeat.i(99583);
        if (bitmap == null) {
            AppMethodBeat.o(99583);
            return bitmap;
        } else if (f == 1.0f) {
            AppMethodBeat.o(99583);
            return bitmap;
        } else {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            AppMethodBeat.o(99583);
            return bitmap;
        }
    }

    public static byte[] a(Bitmap bitmap, CompressFormat compressFormat) {
        AppMethodBeat.i(99584);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(99584);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(99584);
        return toByteArray;
    }
}
