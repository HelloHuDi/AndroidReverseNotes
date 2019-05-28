package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag {
    public static Bitmap d(Bitmap bitmap, float f) {
        AppMethodBeat.i(112468);
        if (bitmap == null || bitmap.isRecycled()) {
            ai.e("WeUIBitmapUtil", "getRoundedCornerBitmap in bitmap is null", new Object[0]);
            AppMethodBeat.o(112468);
            return null;
        }
        Bitmap k = k(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        if (k == null) {
            AppMethodBeat.o(112468);
            return null;
        }
        Canvas canvas = new Canvas(k);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-4144960);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        ai.i("WeUIBitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", bitmap);
        bitmap.recycle();
        AppMethodBeat.o(112468);
        return k;
    }

    private static Bitmap k(int i, int i2, Config config) {
        AppMethodBeat.i(112469);
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(i, i2, config);
        } catch (Throwable th) {
        }
        AppMethodBeat.o(112469);
        return bitmap;
    }
}
