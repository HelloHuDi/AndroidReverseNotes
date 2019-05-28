package com.tencent.tencentmap.mapsdk.maps.p667a;

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

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ht */
public class C24388ht {
    /* renamed from: a */
    protected static Paint f4735a;
    /* renamed from: b */
    private static final String f4736b = Bitmap.class.getCanonicalName();

    static {
        AppMethodBeat.m2504i(99585);
        Paint paint = new Paint();
        f4735a = paint;
        paint.setAntiAlias(true);
        AppMethodBeat.m2505o(99585);
    }

    /* renamed from: a */
    public static Bitmap m37844a(View view) {
        AppMethodBeat.m2504i(99577);
        if (view != null) {
            try {
                Bitmap a;
                synchronized (view) {
                    view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                    view.setDrawingCacheEnabled(true);
                    view.buildDrawingCache();
                    a = C24388ht.m37840a(view.getDrawingCache());
                    view.destroyDrawingCache();
                }
                AppMethodBeat.m2505o(99577);
                return a;
            } catch (Throwable th) {
                new StringBuilder("BitmapUtil.convertToBitmap errorDetail:").append(Log.getStackTraceString(th));
            }
        }
        AppMethodBeat.m2505o(99577);
        return null;
    }

    /* renamed from: a */
    public static Bitmap m37840a(Bitmap bitmap) {
        AppMethodBeat.m2504i(99578);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(99578);
            return null;
        }
        Bitmap a = C24388ht.m37842a(bitmap, bitmap.getWidth(), bitmap.getHeight());
        AppMethodBeat.m2505o(99578);
        return a;
    }

    /* renamed from: a */
    public static Bitmap m37842a(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(99579);
        if (bitmap == null || bitmap.isRecycled() || i <= 0 || i2 <= 0) {
            AppMethodBeat.m2505o(99579);
            return null;
        }
        Bitmap a = C24388ht.m37839a(i, i2, Config.ARGB_8888);
        a.setDensity(bitmap.getDensity());
        if (a == null) {
            AppMethodBeat.m2505o(99579);
            return null;
        }
        Canvas canvas = new Canvas(a);
        a.eraseColor(0);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, f4735a);
        AppMethodBeat.m2505o(99579);
        return a;
    }

    /* renamed from: a */
    public static Bitmap m37843a(Bitmap bitmap, Context context, int i, int i2) {
        AppMethodBeat.m2504i(99580);
        if (bitmap == null || bitmap.isRecycled() || i <= 0 || i2 <= 0) {
            AppMethodBeat.m2505o(99580);
            return null;
        }
        if (i > 2048) {
            i = 2048;
        }
        if (i2 > 2048) {
            i2 = 2048;
        }
        Bitmap a = C24388ht.m37839a(i, i2, Config.ARGB_8888);
        if (a == null) {
            AppMethodBeat.m2505o(99580);
            return null;
        }
        a.eraseColor(0);
        Canvas canvas = new Canvas(a);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, i, i2);
        bitmapDrawable.draw(canvas);
        AppMethodBeat.m2505o(99580);
        return a;
    }

    /* renamed from: b */
    public static Drawable m37846b(Bitmap bitmap) {
        AppMethodBeat.m2504i(99581);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        AppMethodBeat.m2505o(99581);
        return bitmapDrawable;
    }

    /* renamed from: a */
    private static Bitmap m37839a(int i, int i2, Config config) {
        Bitmap createBitmap;
        AppMethodBeat.m2504i(99582);
        try {
            createBitmap = Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError e) {
            try {
                createBitmap = Bitmap.createBitmap(i, i2, config);
            } catch (OutOfMemoryError e2) {
                AppMethodBeat.m2505o(99582);
                return null;
            }
        }
        AppMethodBeat.m2505o(99582);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m37841a(Bitmap bitmap, float f) {
        AppMethodBeat.m2504i(99583);
        if (bitmap == null) {
            AppMethodBeat.m2505o(99583);
            return bitmap;
        } else if (f == 1.0f) {
            AppMethodBeat.m2505o(99583);
            return bitmap;
        } else {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            AppMethodBeat.m2505o(99583);
            return bitmap;
        }
    }

    /* renamed from: a */
    public static byte[] m37845a(Bitmap bitmap, CompressFormat compressFormat) {
        AppMethodBeat.m2504i(99584);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(99584);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(99584);
        return toByteArray;
    }
}
